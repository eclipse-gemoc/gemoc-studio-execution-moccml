package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.engine;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.commons.CodeExecutorBasedExecutionPlatform;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.commons.MoccmlModelExecutionContext;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.AbstractConcurrentExecutionEngine;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.AbstractConcurrentModelExecutionContext;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.IConcurrentRunConfiguration;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.ILogicalStepDecider;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dsa.executors.CodeExecutionException;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dsa.executors.ICodeExecutor;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.moc.ISolver;
import org.eclipse.gemoc.executionframework.engine.Activator;
import org.eclipse.gemoc.executionframework.engine.core.CommandExecution;
import org.eclipse.gemoc.executionframework.engine.core.EngineStoppedException;
import org.eclipse.gemoc.trace.commons.model.trace.ParallelStep;
import org.eclipse.gemoc.trace.commons.model.trace.SmallStep;
import org.eclipse.gemoc.trace.commons.model.trace.Step;
import org.eclipse.gemoc.xdsmlframework.api.core.EngineStatus;
import org.eclipse.gemoc.xdsmlframework.api.engine_addon.IEngineAddon;

import fr.inria.diverse.k3.al.annotationprocessor.InitializeModel;

public abstract class AbstractSolverCodeExecutorConcurrentEngine<C extends AbstractConcurrentModelExecutionContext<R, ? extends CodeExecutorBasedExecutionPlatform, ?>, R extends IConcurrentRunConfiguration, S extends ISolver>
		extends AbstractConcurrentExecutionEngine<C, R> {

	private ILogicalStepDecider _logicalStepDecider;

	protected List<Step<?>> _possibleLogicalSteps = new ArrayList<>();

	private Step<?> _selectedLogicalStep;

	protected S _solver;

	protected abstract void updatePossibleLogicalSteps();

	protected abstract void executeSmallStep(SmallStep<?> smallStep) throws CodeExecutionException;

	protected void setSolver(S solver) {
		_solver = solver;

	}

	public S getSolver() {
		return _solver;
	}

	protected ICodeExecutor getCodeExecutor() {
		return getConcurrentExecutionContext().getExecutionPlatform().getCodeExecutor();
	}

	@Override
	protected void beforeStart() {

	}

	@Override
	public void changeLogicalStepDecider(ILogicalStepDecider newDecider) {
		_logicalStepDecider = newDecider;
	}

	protected void computePossibleLogicalSteps() {
		_possibleLogicalSteps = getSolver().computeAndGetPossibleLogicalSteps();
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
				executeSmallStep(sstep);
			}
			afterExecutionStep();
		}
	}

	@Override
	protected final void finishDispose() {
		getSolver().dispose();
	}

	@Override
	public ILogicalStepDecider getLogicalStepDecider() {
		return _logicalStepDecider;
	}

	@Override
	public List<Step<?>> getPossibleLogicalSteps() {
		synchronized (this) {
			return new ArrayList<Step<?>>(_possibleLogicalSteps);
		}
	}

	@Override
	public Step<?> getSelectedLogicalStep() {
		synchronized (this) {
			return _selectedLogicalStep;
		}
	}

	protected void notifyAboutToSelectLogicalStep() {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) {
			try {
				addon.aboutToSelectStep(this, getPossibleLogicalSteps());
			} catch (Exception e) {
				Activator.getDefault().error("Exception in Addon " + addon + ", " + e.getMessage(), e);
			}
		}
	}

	protected void notifyLogicalStepSelected() {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) {
			try {
				addon.stepSelected(this, getSelectedLogicalStep());
			} catch (Exception e) {
				Activator.getDefault().error("Exception in Addon " + addon + ", " + e.getMessage(), e);
			}
		}
	}

	protected void notifyProposedLogicalStepsChanged() {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) {
			try {
				addon.proposedStepsChanged(this, getPossibleLogicalSteps());
			} catch (Exception e) {
				Activator.getDefault().error("Exception in Addon " + addon + ", " + e.getMessage(), e);
			}
		}
	}

	protected void performExecutionStep() throws InterruptedException, CodeExecutionException {
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

	@Override
	protected final void performStop() {
		setSelectedLogicalStep(null);
		if (getLogicalStepDecider() != null) {
			// unlock decider if this is a user decider
			getLogicalStepDecider().preempt();
		}

	}

	protected Step<?> selectAndExecuteLogicalStep() throws InterruptedException, CodeExecutionException {
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

	protected void setSelectedLogicalStep(Step<?> ls) {
		synchronized (this) {
			_selectedLogicalStep = ls;
		}
	}

	protected void switchDeciderIfNecessary() {
		if (getLogicalStepDecider() != null && getLogicalStepDecider() != _logicalStepDecider) {
			_logicalStepDecider = getLogicalStepDecider();
		}
	}

	@Override
	public String toString() {
		return this.getClass().getName() + "@[Executor=" + getCodeExecutor() + " ; Solver=" + getSolver()
				+ " ; ModelResource=" + _executionContext.getResourceModel() + "]";
	}

	protected void executeInitializeModelMethod(MoccmlModelExecutionContext executionContext) {

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

}
