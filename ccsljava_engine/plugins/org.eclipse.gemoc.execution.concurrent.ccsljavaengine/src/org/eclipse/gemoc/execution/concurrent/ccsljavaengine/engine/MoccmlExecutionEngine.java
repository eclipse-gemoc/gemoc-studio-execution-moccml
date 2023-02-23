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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
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
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.EObjectRef;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.IntegerLiteral;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.MseStatement;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.ObjectVariable;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.RewritingRuleCallStatement;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.Scenario;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.Statement;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.Variable;
import org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.ui.internal.TestScenarioLangActivator;
import org.eclipse.gemoc.executionframework.engine.Activator;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.ActionModel;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.ModelSpecificEvent;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.When;
import org.eclipse.gemoc.trace.commons.model.generictrace.GenericSmallStep;
import org.eclipse.gemoc.trace.commons.model.trace.MSE;
import org.eclipse.gemoc.trace.commons.model.trace.SmallStep;
import org.eclipse.gemoc.trace.commons.model.trace.Step;
import org.eclipse.gemoc.xdsmlframework.api.core.IExecutionEngine;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;

import com.google.inject.Injector;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;
import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.ModelElementReference;
import fr.inria.aoste.trace.TraceFactory;

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

	private Scenario moccmlScenario = null;

	private EList<Statement> scenarioStatementSequence;

	private int indexInScenarioStatementSequence;

	private HashSet<Clock> clockUsedInScenario;

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
				if (((ModelSpecificEvent) _mseStateController.getFeedBackModelResource()
						.getEObject(action.getTriggeringMSEURI())).getName().compareTo(mse.getName()) == 0) {
					actionsToRemove.add(action);
					action.perform(_mseStateController);
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
			Consumer<List<Object>> afterStep = (o) -> {
				afterExecutionStep(o);
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

	/**
	 * Override to add management of the moccmlscenario if one is given
	 */
	@Override
	protected void performExecutionStep() {
		switchDeciderIfNecessary();
		_possibleLogicalSteps = computePossibleLogicalSteps();
		if (_possibleLogicalSteps.size() == 0) {
			Activator.getDefault().debug("No more LogicalStep to run");
//			stop();
		} else {
			// scenario mangement
			if (moccmlScenario != null) {
				applyScenarioEffect();
			}
			try {
				Step<?> selectedLogicalStep = selectAndExecuteLogicalStep();

				// 3 - run the selected logical step
				// inform the solver that we will run this step
				if (selectedLogicalStep != null) {
					doAfterLogicalStepExecution(selectedLogicalStep);
					engineStatus.incrementNbLogicalStepRun();

				} else {
					// no logical step was selected, this is most probably due to a
					// preempt on the LogicalStepDecider and a change of Decider,
					// notify Addons that we'll rerun this ExecutionStep
					// recomputePossibleLogicalSteps();
				}
			} catch (Throwable t) {
				throw new RuntimeException(t);
			}

		}
	}

	private void applyScenarioEffect() {
		Statement currentScenarioStatement = scenarioStatementSequence.get(indexInScenarioStatementSequence);
		dealWithRwRCallStatement(currentScenarioStatement);
		if (currentScenarioStatement instanceof MseStatement) {
			HashSet<Clock> clockToForceAbsent = new HashSet<Clock>(clockUsedInScenario);
			EList<Clock> statementClocks = ((MseStatement) currentScenarioStatement).getClocks();
			for (Clock toRemove : statementClocks) {
				clockToForceAbsent.remove(toRemove);
			}
			for (Clock c : clockToForceAbsent) {
				EventOccurrence occ = getEventOccurrenceFromClock(c);
				_solver.forbidEventOccurrence(occ);
			}
			if (statementClocks.size() > 1) {
				Clock oneClock = statementClocks.get(0);
				EventOccurrence oneClockOcc = getEventOccurrenceFromClock(oneClock);
				for (int i = 1; i < statementClocks.size(); i++) {
					EventOccurrence anotherClockOcc = getEventOccurrenceFromClock(statementClocks.get(i));
					_solver.addClockCoincidence(oneClockOcc, anotherClockOcc);
				}
			}
			_possibleLogicalSteps = computePossibleLogicalSteps();
			if (!_solver.hasSolution()) {
				Activator.getDefault()
						.error("The scenario violates the semantics at step " + indexInScenarioStatementSequence
								+ ". One of these clock cannot be absent: " + clockToForceAbsent);
//						stop();
			}
			// try to force presence of currentStatement but if not possible it does not
			// mean it will not be possible in a future step so we have to revert
			for (Clock toForce : statementClocks) {
				EventOccurrence occ = getEventOccurrenceFromClock(toForce);
				_solver.forceEventOccurrence(occ);
			}
			if (!_solver.hasSolution()) {
				_solver.revertForceClockEffect();
				for (Clock c : clockToForceAbsent) {
					EventOccurrence occ = getEventOccurrenceFromClock(c);
					_solver.forbidEventOccurrence(occ);
				}

			}
			_possibleLogicalSteps = computePossibleLogicalSteps();
			notifyProposedLogicalStepsChanged();
		}
	}

	private EventOccurrence getEventOccurrenceFromClock(Clock c) {
		EventOccurrence occ = TraceFactory.eINSTANCE.createEventOccurrence();
		ModelElementReference mer = TraceFactory.eINSTANCE.createModelElementReference();
		mer.getElementRef().add(c.eContainer().eContainer());
		mer.getElementRef().add(c.eContainer());
		mer.getElementRef().add(c);
		occ.setReferedElement(mer);
		return occ;
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
		Resource resFeedbackModel = executionContext.setUpFeedbackModel();
		_mseStateController.setFeedBackModelResource(resFeedbackModel);

		if (executionContext.hasARegisteredScenario) {
//			URI scenarioModelPlatformURI = URI.createPlatformResourceURI(
//						concurrentExecutionContext.getMoccmlscenarioModelPath(), true);
//			ResourceSet resourceSet = new ResourceSetImpl();
//			Resource resource = resourceSet.getResource(scenarioModelPlatformURI, true);
//			moccmlScenario = (Scenario) resource.getContents().get(0);
			moccmlScenario = loadTestScenarioLangification(concurrentExecutionContext.getMoccmlscenarioModelPath());
			scenarioStatementSequence = moccmlScenario.getStatementSequence();
			indexInScenarioStatementSequence = 0;
			clockUsedInScenario = new HashSet<Clock>();

			for (Statement s : moccmlScenario.getStatementSequence().stream().filter(s -> s instanceof MseStatement)
					.collect(Collectors.toList())) {
				clockUsedInScenario.addAll(((MseStatement) s).getClocks());
			}
		}
	}

	private Scenario loadTestScenarioLangification(String filename) {
		if (filename == null || filename.isEmpty()) {
			return null;
		}
		String language = TestScenarioLangActivator.ORG_ECLIPSE_GEMOC_EXECUTION_MOCCML_TESTSCENARIOLANG_XTEXT_TESTSCENARIOLANG;
		Injector injector = TestScenarioLangActivator.getInstance().getInjector(language);
		XtextResourceSetProvider provider = injector.getInstance(XtextResourceSetProvider.class);

		XtextResourceSet resourceSet = (XtextResourceSet) provider.get(findContainingProject(filename));
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

		URI uri = URI.createPlatformResourceURI(filename, true);
		XtextResource resource = (XtextResource) resourceSet.getResource(uri, true);
		List<Diagnostic> errors = resource.getErrors();
		if (!errors.isEmpty()) {
			System.err.println("the moccml scenrio file contains errors: " + errors);
			return null;
		}
		return (Scenario) resource.getContents().get(0);
	}

	private IProject findContainingProject(String filename) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IPath path = root.getLocation();
		path = path.append(new Path(filename));
		IFile file = (IFile) root.findMember(filename);
		return (file != null ? file.getProject() : null);
	}

	@Override
	protected void doAfterLogicalStepExecution(Step<?> logicalStep) {

		getSolver().applyLogicalStep(logicalStep);
		List<String> assertions = getSolver().getAssertionViolations();
		if (assertions.size() > 0) {
			System.err.println("###############################################\n  WARNING ! Assertion violation");
			Activator.getDefault()
					.error("###############################################\n  WARNING ! Assertion violation");
		}
		for (String ass : assertions) {
			System.err.println("#    " + ass);
			Activator.getDefault().error("#    " + ass);
		}
		if (assertions.size() > 0) {
			System.err.println("###############################################");
			Activator.getDefault().error("###############################################");
		}
		if (moccmlScenario != null) {
			manageScenario(logicalStep);
		}
	}

	private void manageScenario(Step<?> logicalStep) {
		Statement currentScenarioStatement = scenarioStatementSequence.get(indexInScenarioStatementSequence);
		if (currentScenarioStatement instanceof MseStatement) {
			ArrayList<Clock> clocksThatTicked = new ArrayList<Clock>();
			retrieveAllClocksFromStep(logicalStep, clocksThatTicked);
			if (((MseStatement) currentScenarioStatement).getClocks().stream().allMatch(
					c -> clocksThatTicked.stream().anyMatch(c2 -> c2.getName().compareTo(c.getName()) == 0))) {
				indexInScenarioStatementSequence++;
				currentScenarioStatement = scenarioStatementSequence.get(indexInScenarioStatementSequence);
				dealWithRwRCallStatement(currentScenarioStatement);
			}
		}
	}

	private void dealWithRwRCallStatement(Statement currentScenarioStatement) {
		while (!(currentScenarioStatement instanceof MseStatement)) {
			RewritingRuleCallStatement rwrcallStatement = (RewritingRuleCallStatement) currentScenarioStatement;
			ObjectVariable ov = rwrcallStatement.getObjectVariable();
			JavaVariable javaVar = new JavaVariable(ov.getName(), ov.getType().getType().getQualifiedName());
			Object obj = javaVar.getObject();
			JvmOperation jvmOp = rwrcallStatement.getMethod();
			EList<Variable> params = rwrcallStatement.getParameters();
			Object[] realParams = new Object[params.size()];
			Class<?>[] realParamTypes = new Class<?>[params.size()];
			for (int i = 0; i < params.size(); i++) {
				Variable v = params.get(i);
				if (v instanceof EObjectRef) {
					realParams[i] = ((EObjectRef) v).getObject();
					realParamTypes[i] = (EObject.class);// (EObjectRef)v).getObject().getClass();
				}
				if (v instanceof IntegerLiteral) {
					realParams[i] = new Integer(((IntegerLiteral) v).getValue());
					realParamTypes[i] = Integer.class;
				}
			}
			Method m;
			try {
				m = obj.getClass().getDeclaredMethod(jvmOp.getSimpleName(), realParamTypes);
				// it is possible to get the result here !
				Object res = m.invoke(obj, realParams);
				System.out.println(res);
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			indexInScenarioStatementSequence++;
			currentScenarioStatement = scenarioStatementSequence.get(indexInScenarioStatementSequence);
		}
	}

	private void retrieveAllClocksFromStep(Step<?> logicalStep, ArrayList<Clock> clocksThatTicked) {
		TreeIterator<EObject> it = logicalStep.eAllContents();
		while (it.hasNext()) {
			EObject eo = it.next();
			if (eo instanceof GenericSmallStep) {
				MSE mse = ((GenericSmallStep) eo).getMseoccurrence().getMse();
				if (mse instanceof FeedbackMSE) {
					EObject se = ((FeedbackMSE) mse).getFeedbackModelSpecificEvent().getSolverEvent();
					if (se instanceof Clock) {
						clocksThatTicked.add((Clock) se);
					}
				}

			}
		}
	}

	public Pair<Map<String, Boolean>, ArrayList<IMoccmlFutureAction>> saveState() { // one map is enough since view are
																					// not used in exhaustive simulation
		return Pair.of(
				new HashMap<String, Boolean>(((DefaultMSEStateController) getExecutionContext().getExecutionPlatform()
						.getMSEStateControllers().iterator().next())._mseNextStates),
				new ArrayList<>(this._futureActions));
	}

	public void restoreState(Pair<Map<String, Boolean>, ArrayList<IMoccmlFutureAction>> controllerStates) {
//		((DefaultMSEStateController)getExecutionContext().getExecutionPlatform().getMSEStateControllers().iterator().next())._mseNextStates = new HashMap<String, Boolean>(controllerStates.getLeft());
		((DefaultMSEStateController) _mseStateController)._mseNextStates = new HashMap<String, Boolean>(
				controllerStates.getLeft());
		this._futureActions = new ArrayList<IMoccmlFutureAction>(controllerStates.getRight());
	}

}
