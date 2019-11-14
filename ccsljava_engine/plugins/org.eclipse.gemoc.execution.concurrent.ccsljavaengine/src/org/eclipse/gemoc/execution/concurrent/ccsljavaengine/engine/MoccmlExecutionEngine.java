/*******************************************************************************
 * Copyright (c) 2017 INRIA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     INRIA - initial API and implementation
 *     I3S Laboratory - API update and bug fix
 *******************************************************************************/
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.engine;

import java.util.ArrayList;
import java.util.function.Consumer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.commons.MoccmlModelExecutionContext;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.concurrentmse.FeedbackMSE;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.dse.ASynchroneExecution;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.dse.DefaultMSEStateController;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.dse.OperationExecution;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.dse.SynchroneExecution;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.IMoccmlRunConfiguration;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dsa.executors.CodeExecutionException;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dse.IMoccmlFutureAction;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dse.IMoccmlMSEStateController;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.moc.ICCSLSolver;
import org.eclipse.gemoc.executionframework.engine.Activator;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.ActionModel;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.When;
import org.eclipse.gemoc.trace.commons.model.trace.MSE;
import org.eclipse.gemoc.trace.commons.model.trace.SmallStep;
import org.eclipse.gemoc.trace.commons.model.trace.Step;
import org.eclipse.gemoc.xdsmlframework.api.core.IExecutionEngine;

/**
 * Basic abstract implementation of the ExecutionEngine, independent from the
 * technologies used for the solver, the executor and the feedback protocol. It
 * can display the runtime execution information to its registered observers.
 * 
 * There are two phases of initializations for this entity:
 * <ul>
 * <li>the constructor sets the language-specific elements such as
 * DomainSpecificEvents, Solver, EventExecutor, FeedbackPolicy</li>
 * <li>the initialize method sets the model-specific elements such as Model and
 * ModelLoader.</li>
 * </ul>
 * From the Model, we can derive :
 * <ul>
 * <li>the Model of Execution (using the DomainSpecificEvents)</li>
 * <li>the Higher-order-transformation (TODO)) and the Solver Input (using the
 * Model of Execution and the Solver Input Builder provided by the Solver).</li>
 * </ul>
 * 
 * There are a few elements that could enter the ExecutionEngine, maybe after
 * being reified as their own data structures:
 * <ul>
 * <li>{@link #scheduledSteps} is the FIFO of LogicalSteps. We use a FIFO
 * because sometimes we may want to memorize steps in order to go back in the
 * past and replay given steps. When the engine seeks to reach the next step of
 * execution, it will first check if there is something in this FIFO. If there
 * is not, then a new step is requested from the solver.</li>
 * <li>{@link #schedulingTrace} is a map recording the order in which the steps
 * of the solver have been used.</li>
 * <li>{@link #scheduledEventsMap} records which step is linked to which list of
 * MSEs. It is to be noticed that not all the MSEs were executed. Indeed, some
 * may have been illegal at the time (with regards to the MoC) and thus
 * discarded during the execution of this step.</li>
 * <li>{@link #executionTrace} records the steps and the actual MSEs that were
 * actually executed.</li>
 * </ul>
 * 
 * @see IExecutionEngine
 * 
 * @author flatombe
 * @author didier.vojtisek@inria.fr
 * @author julien.deantoni@polytech.unice.fr
 * @param <T>
 * 
 */
public class MoccmlExecutionEngine extends
		AbstractSolverCodeExecutorConcurrentEngine<MoccmlModelExecutionContext, IMoccmlRunConfiguration, ICCSLSolver> {

	private ArrayList<IMoccmlFutureAction> _futureActions = new ArrayList<>();

	private Object _futureActionsLock = new Object();

	private IMoccmlMSEStateController _mseStateController;

	public MoccmlExecutionEngine(MoccmlModelExecutionContext concurrentexecutionContext, ICCSLSolver s)
			throws CoreException {
		super();
		setSolver(s);
		initialize(concurrentexecutionContext);
	}

	public void addFutureAction(IMoccmlFutureAction action) {
		synchronized (_futureActionsLock) {
			_futureActions.add(action);
		}
	}

	@Override
	public String engineKindName() {
		return "GEMOC Moccml Engine";
	}

	private void executeAssociatedActions(MSE mse) {
		synchronized (_futureActionsLock) {
			ArrayList<IMoccmlFutureAction> actionsToRemove = new ArrayList<IMoccmlFutureAction>();
			for (IMoccmlFutureAction action : _futureActions) {
				if (action.getTriggeringMSE() == mse) {
					actionsToRemove.add(action);
					action.perform();
				}
			}
			_futureActions.removeAll(actionsToRemove);
		}
	}

	@Override
	protected void executeSmallStep(SmallStep<?> smallStep) throws CodeExecutionException {
		executeAssociatedActions(smallStep.getMseoccurrence().getMse());
		MSE mse = smallStep.getMseoccurrence().getMse();
		if (mse.getAction() != null) {
			ArrayList<When> whenStatements = new ArrayList<When>();
			// we are in a concurrent engine, the MSE should be a FeedbackMSE
			if (mse instanceof FeedbackMSE) {
				ActionModel feedbackModel = ((MoccmlModelExecutionContext) _executionContext).getFeedbackModel();
				for (When w : feedbackModel.getWhenStatements()) {
					if (w.getSource() == ((FeedbackMSE) mse).getFeedbackModelSpecificEvent()) {
						whenStatements.add(w);
					}
				}
			}
			OperationExecution execution = null;
			Consumer<Step<?>> beforeStep = s -> {
				beforeExecutionStep(s);
			};
			Runnable afterStep = () -> {
				afterExecutionStep();
			};
			if (whenStatements.size() == 0) {
				execution = new SynchroneExecution(smallStep, this, beforeStep, afterStep);
			}
			// if there is a future, execute async.
			else {
				execution = new ASynchroneExecution(smallStep, whenStatements, _mseStateController, this, beforeStep,
						afterStep);
			}
			execution.run();
		}
	}

	public void recomputePossibleLogicalSteps() {
		getSolver().revertForceClockEffect();
		updatePossibleLogicalSteps();
		notifyProposedLogicalStepsChanged();
	}

	@Override
	protected void beforeUpdatePossibleLogicalSteps() {
		for (IMoccmlMSEStateController c : getExecutionContext().getExecutionPlatform().getMSEStateControllers()) {
			c.applyMSEFutureStates(getSolver());
		}
	}

	@Override
	protected void performSpecificInitialize(MoccmlModelExecutionContext executionContext) {

		MoccmlModelExecutionContext concurrentExecutionContext = getExecutionContext();
		getSolver().setExecutableModelResource(concurrentExecutionContext.getResourceModel());

		_mseStateController = new DefaultMSEStateController();
		concurrentExecutionContext.getExecutionPlatform().getMSEStateControllers().add(_mseStateController);

		executeInitializeModelMethod(executionContext);

		executionContext.setUpMSEModel();
		executionContext.setUpFeedbackModel();

	}

	@Override
	protected void doAfterLogicalStepExecution(Step<?> logicalStep) {
		getSolver().applyLogicalStep(logicalStep);
	}

}
