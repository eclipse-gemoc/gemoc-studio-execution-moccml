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

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.commons.MoccmlModelExecutionContext;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.concurrentmse.FeedbackMSE;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.dse.ASynchroneExecution;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.dse.DefaultMSEStateController;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.dse.OperationExecution;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.dse.SynchroneExecution;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.AbstractConcurrentExecutionEngine;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.ILogicalStepDecider;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dsa.executors.CodeExecutionException;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dsa.executors.ICodeExecutor;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dse.IMoccmlFutureAction;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dse.IMoccmlMSEStateController;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.moc.ICCSLSolver;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.moc.ISolver;
import org.eclipse.gemoc.executionframework.engine.Activator;
import org.eclipse.gemoc.executionframework.engine.core.CommandExecution;
import org.eclipse.gemoc.executionframework.engine.core.EngineStoppedException;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.ActionModel;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.When;
import org.eclipse.gemoc.trace.commons.model.trace.MSE;
import org.eclipse.gemoc.trace.commons.model.trace.ParallelStep;
import org.eclipse.gemoc.trace.commons.model.trace.SmallStep;
import org.eclipse.gemoc.trace.commons.model.trace.Step;
import org.eclipse.gemoc.xdsmlframework.api.core.EngineStatus;
import org.eclipse.gemoc.xdsmlframework.api.core.IExecutionContext;
import org.eclipse.gemoc.xdsmlframework.api.core.IExecutionEngine;
import org.eclipse.gemoc.xdsmlframework.api.engine_addon.IEngineAddon;

import fr.inria.diverse.k3.al.annotationprocessor.InitializeModel;

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
public class MoccmlExecutionEngine extends AbstractConcurrentExecutionEngine {

	private IMoccmlMSEStateController _mseStateController;

	public MoccmlExecutionEngine(MoccmlModelExecutionContext concurrentexecutionContext, ICCSLSolver s)
			throws CoreException {
		super();
		_solver = s;
		initialize(concurrentexecutionContext);
	}

	private void switchDeciderIfNecessary() {
		if (getLogicalStepDecider() != null && getLogicalStepDecider() != _logicalStepDecider) {
			_logicalStepDecider = getLogicalStepDecider();
		}
	}

	private ILogicalStepDecider _logicalStepDecider;

	@Override
	public ILogicalStepDecider getLogicalStepDecider() {
		return _logicalStepDecider;
	}

	@Override
	public void changeLogicalStepDecider(ILogicalStepDecider newDecider) {
		_logicalStepDecider = newDecider;
	}

	protected void computePossibleLogicalSteps() {
		_possibleLogicalSteps = getSolver().computeAndGetPossibleLogicalSteps();
	}

	private void updatePossibleLogicalSteps() {
		for (IMoccmlMSEStateController c : getConcurrentExecutionContext().getExecutionPlatform()
				.getMSEStateControllers()) {
			c.applyMSEFutureStates(getSolver());
		}
		synchronized (this) {
			_possibleLogicalSteps = getSolver().updatePossibleLogicalSteps();
		}
	}

	@Override
	public void recomputePossibleLogicalSteps() {
		getSolver().revertForceClockEffect();
		updatePossibleLogicalSteps();
		notifyProposedLogicalStepsChanged();
	}

	protected List<Step<?>> _possibleLogicalSteps = new ArrayList<>();

	@Override
	public List<Step<?>> getPossibleLogicalSteps() {
		synchronized (this) {
			return new ArrayList<Step<?>>(_possibleLogicalSteps);
		}
	}

	@Override
	protected final void performStop() {
		setSelectedLogicalStep(null);
		if (getLogicalStepDecider() != null) {
			// unlock decider if this is a user decider
			getLogicalStepDecider().preempt();
		}

	}

	private void notifyLogicalStepSelected() {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) {
			try {
				addon.stepSelected(this, getSelectedLogicalStep());
			} catch (Exception e) {
				Activator.getDefault().error("Exception in Addon " + addon + ", " + e.getMessage(), e);
			}
		}
	}

	private void notifyAboutToSelectLogicalStep() {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) {
			try {
				addon.aboutToSelectStep(this, getPossibleLogicalSteps());
			} catch (Exception e) {
				Activator.getDefault().error("Exception in Addon " + addon + ", " + e.getMessage(), e);
			}
		}
	}

	private Step<?> _selectedLogicalStep;

	@Override
	public Step<?> getSelectedLogicalStep() {
		synchronized (this) {
			return _selectedLogicalStep;
		}
	}

	protected void setSelectedLogicalStep(Step<?> ls) {
		synchronized (this) {
			_selectedLogicalStep = ls;
		}
	}

	/**
	 * 
	 * @return the IConcurrenExecutionContext or null if no such context is
	 *         available
	 */
	public MoccmlModelExecutionContext getConcurrentExecutionContext() {

		IExecutionContext<?, ?, ?> context = getExecutionContext();
		if (context instanceof MoccmlModelExecutionContext) {
			return (MoccmlModelExecutionContext) context;
		} else
			return null;
	}

	protected ICCSLSolver _solver;

	public ICCSLSolver getSolver() {
		return _solver;
	}

	private void notifyProposedLogicalStepsChanged() {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) {
			try {
				addon.proposedStepsChanged(this, getPossibleLogicalSteps());
			} catch (Exception e) {
				Activator.getDefault().error("Exception in Addon " + addon + ", " + e.getMessage(), e);
			}
		}
	}

	@Override
	public String toString() {
		return this.getClass().getName() + "@[Executor=" + getCodeExecutor() + " ; Solver=" + getSolver()
				+ " ; ModelResource=" + _executionContext.getResourceModel() + "]";
	}

	private void performExecutionStep() throws InterruptedException, CodeExecutionException {
		switchDeciderIfNecessary();
		computePossibleLogicalSteps();
		updatePossibleLogicalSteps();
		// 2- select one solution from available logical step /
		// select interactive vs batch
		if (_possibleLogicalSteps.size() == 0) {
			Activator.getDefault().debug("No more LogicalStep to run");
			stop();
		} else {
			// Activator.getDefault().debug("\t\t ---------------- LogicalStep "
			// + count);
			Step<?> selectedLogicalStep = selectAndExecuteLogicalStep();
			// 3 - run the selected logical step
			// inform the solver that we will run this step
			if (selectedLogicalStep != null) {
				getSolver().applyLogicalStep(selectedLogicalStep);

// only for testing purpose
//				List<fr.inria.aoste.timesquare.instantrelation.CCSLRelationModel.OccurrenceRelation> res = getSolver().getLastOccurrenceRelations();
//				System.out.println("/********************DEBUG OCCURRENCE RELATIONS****************\n*  "
//						+res
//						+"\n**********************************************************/");

				engineStatus.incrementNbLogicalStepRun();
			} else {
				// no logical step was selected, this is most probably due to a
				// preempt on the LogicalStepDecider and a change of Decider,
				// notify Addons that we'll rerun this ExecutionStep
				// recomputePossibleLogicalSteps();
			}
		}
	}

	private Step<?> selectAndExecuteLogicalStep() throws InterruptedException, CodeExecutionException {
		setEngineStatus(EngineStatus.RunStatus.WaitingLogicalStepSelection);
		notifyAboutToSelectLogicalStep();
		Step<?> selectedLogicalStep = getLogicalStepDecider().decide(this, getPossibleLogicalSteps());
		if (selectedLogicalStep != null) {
			setSelectedLogicalStep(selectedLogicalStep);
			setEngineStatus(EngineStatus.RunStatus.Running);
			notifyLogicalStepSelected();
			// run all the event occurrences of this logical
			// step
			executeSelectedLogicalStep();
		}
		return selectedLogicalStep;
	}

	/**
	 * run all the event occurrences of this logical step
	 * 
	 * @param logicalStepToApply
	 * @throws CodeExecutionException
	 */
	@SuppressWarnings("unchecked")
	protected void executeSelectedLogicalStep() throws CodeExecutionException {
		// = step in debug mode, goes to next logical step
		// -> run all event occurrences of the logical step
		// step into / open internal thread and pause them
		// each concurrent event occurrence is presented as a separate
		// thread in the debugger
		// execution feedback is sent to the solver so it can take internal
		// event into account

		if (!_isStopped) { // execute while stopped may occur when we push the
							// stop button when paused in the debugger
			beforeExecutionStep(_selectedLogicalStep);
			for (final Step<?> step : ((ParallelStep<Step<?>, ?>) _selectedLogicalStep).getSubSteps()) {
				SmallStep<?> sstep = (SmallStep<?>) step;
				executeAssociatedActions(sstep.getMseoccurrence().getMse());
				executeSmallStep(sstep);
			}
			afterExecutionStep();
		}
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

	private void executeSmallStep(SmallStep<?> smallStep) throws CodeExecutionException {
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

	private ArrayList<IMoccmlFutureAction> _futureActions = new ArrayList<>();
	private Object _futureActionsLock = new Object();

	public void addFutureAction(IMoccmlFutureAction action) {
		synchronized (_futureActionsLock) {
			_futureActions.add(action);
		}
	}

	@Override
	protected void performStart() {
		engineStatus.setNbLogicalStepRun(0);
		try {
			while (!_isStopped) {
				performExecutionStep();
			}
		} catch (EngineStoppedException ese) {
			throw ese; // forward the stop exception
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	public void setSolver(ISolver solver) {
		_solver = (ICCSLSolver) solver;

	}

	private ICodeExecutor getCodeExecutor() {
		return getConcurrentExecutionContext().getExecutionPlatform().getCodeExecutor();
	}

	@Override
	protected final void finishDispose() {
		_solver.dispose();
	}

	@Override
	protected void performInitialize(IExecutionContext executionContext) {

		if (!(executionContext instanceof MoccmlModelExecutionContext))
			throw new IllegalArgumentException(
					"executionContext must be an IConcurrentExecutionContext when used in ConcurrentExecutionEngine");

		MoccmlModelExecutionContext concurrentExecutionContext = getConcurrentExecutionContext();
		_solver.setExecutableModelResource(concurrentExecutionContext.getResourceModel());
//		already done in the launch place ?!
//		ISolver solver;
//		// TODO very ugly
//		try {
//			solver = concurrentExecutionContext.getConcurrentLanguageDefinitionExtension().instanciateSolver();
//		} catch (CoreException e) {
//			throw new RuntimeException(e.getMessage());
//		}
//		solver.initialize(concurrentExecutionContext);
//		this.setSolver(solver);
		this.changeLogicalStepDecider(concurrentExecutionContext.getLogicalStepDecider());

		_mseStateController = new DefaultMSEStateController();
		concurrentExecutionContext.getExecutionPlatform().getMSEStateControllers().add(_mseStateController);

		executeInitializeModelMethod((MoccmlModelExecutionContext) executionContext);

		((MoccmlModelExecutionContext) executionContext).setUpMSEModel();
		((MoccmlModelExecutionContext) executionContext).setUpFeedbackModel();

		Activator.getDefault().debug("*** Engine initialization done. ***");
	}

	private void executeInitializeModelMethod(MoccmlModelExecutionContext executionContext) {

		String modelInitializationMethodQName = executionContext.getRunConfiguration().getModelInitializationMethod();
		if (!modelInitializationMethodQName.isEmpty()) {
			Object target = executionContext.getResourceModel().getContents().get(0);
			String modelInitializationMethodName = modelInitializationMethodQName
					.substring(modelInitializationMethodQName.lastIndexOf(".") + 1);
			Activator.getDefault()
					.debug("*** Calling Model initialization method " + modelInitializationMethodName + "(). ***");

			final ArrayList<Object> modelInitializationParameters = new ArrayList<>();
			ICodeExecutor codeExecutor = getConcurrentExecutionContext().getExecutionPlatform().getCodeExecutor();
			ArrayList<Object> parameters = new ArrayList<Object>();
			// try with String[] args
			parameters.add(new String[1]);
			List<Method> methods = codeExecutor.findCompatibleMethodsWithAnnotation(target, parameters,
					InitializeModel.class);
			if (!methods.isEmpty()) {
				modelInitializationParameters
						.add(executionContext.getRunConfiguration().getModelInitializationArguments().split("\\r?\\n"));
			} else {
				// try with List<String>
				parameters.clear();
				parameters.add(new ArrayList<String>());
				methods.addAll(
						codeExecutor.findCompatibleMethodsWithAnnotation(target, parameters, InitializeModel.class));
				if (!methods.isEmpty()) {
					ArrayList<String> modelInitializationArgs = new ArrayList<>();
					for (String s : executionContext.getRunConfiguration().getModelInitializationArguments()
							.split("\\r?\\n")) {
						modelInitializationArgs.add(s);
					}
					modelInitializationParameters.add(modelInitializationArgs);
				} else {
					// try with EList<String>
					parameters.clear();
					parameters.add(new BasicEList<String>());
					methods.addAll(codeExecutor.findCompatibleMethodsWithAnnotation(target, parameters,
							InitializeModel.class));
					if (!methods.isEmpty()) {
						BasicEList<String> modelInitializationArgs = new BasicEList<>();
						for (String s : executionContext.getRunConfiguration().getModelInitializationArguments()
								.split("\\r?\\n")) {
							modelInitializationArgs.add(s);
						}
						modelInitializationParameters.add(modelInitializationArgs);
					}
				}
			}
			final TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Factory.INSTANCE
					.getEditingDomain(getExecutionContext().getResourceModel().getResourceSet());
			if (editingDomain != null) {
				final RecordingCommand command = new RecordingCommand(editingDomain,
						"execute  " + modelInitializationMethodQName) {
					private List<Object> result = new ArrayList<Object>();

					@Override
					protected void doExecute() {
						try {
							result.add(codeExecutor.execute(target, modelInitializationMethodName,
									modelInitializationParameters));
							Activator.getDefault().debug("*** Model initialization done. ***");
						} catch (CodeExecutionException e) {
							Activator.getDefault().error("Exception while initializing model " + e.getMessage(), e);
						}
					}

					@Override
					public Collection<?> getResult() {
						return result;
					}
				};
				CommandExecution.execute(editingDomain, command);
			} else {
				try {
					codeExecutor.execute(target, modelInitializationMethodName, modelInitializationParameters);
					Activator.getDefault().debug("*** Model initialization done. ***");
				} catch (CodeExecutionException e) {
					Activator.getDefault().error("Exception while initializing model " + e.getMessage(), e);
				}
			}
		} else {
			Activator.getDefault().debug(
					"*** Model initialization done. (no modelInitialization method defined for the language) ***");
		}

	}


	@Override
	protected void beforeStart() {

	}

	@Override
	public String engineKindName() {
		return "GEMOC Moccml Engine";
	}

}
