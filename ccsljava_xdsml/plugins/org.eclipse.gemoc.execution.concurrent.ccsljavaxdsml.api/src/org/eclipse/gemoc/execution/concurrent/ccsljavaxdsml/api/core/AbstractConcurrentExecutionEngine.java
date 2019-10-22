package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dsa.executors.CodeExecutionException;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.moc.DeciderException;
import org.eclipse.gemoc.executionframework.engine.Activator;
import org.eclipse.gemoc.executionframework.engine.core.AbstractExecutionEngine;
import org.eclipse.gemoc.executionframework.engine.core.EngineStoppedException;
import org.eclipse.gemoc.trace.commons.model.trace.ParallelStep;
import org.eclipse.gemoc.trace.commons.model.trace.SmallStep;
import org.eclipse.gemoc.trace.commons.model.trace.Step;
import org.eclipse.gemoc.xdsmlframework.api.core.EngineStatus;
import org.eclipse.gemoc.xdsmlframework.api.engine_addon.IEngineAddon;

public abstract class AbstractConcurrentExecutionEngine<C extends AbstractConcurrentModelExecutionContext<R, ?, ?, ?>, R extends IConcurrentRunConfiguration>
		extends AbstractExecutionEngine<C, R> {

	protected abstract List<Step<?>> computePossibleLogicalSteps();

	protected abstract void doAfterLogicalStepExecution(Step<?> logicalStep);

	protected abstract void executeSmallStep(SmallStep<?> smallStep) throws CodeExecutionException;

	private ILogicalStepDecider _logicalStepDecider;
	protected List<Step<?>> _possibleLogicalSteps = new ArrayList<>();
	private Step<?> _selectedLogicalStep;

	@Override
	protected void beforeStart() {

	}

	public final void changeLogicalStepDecider(ILogicalStepDecider newDecider) {
		_logicalStepDecider = newDecider;
	}

	public final ILogicalStepDecider getLogicalStepDecider() {
		return _logicalStepDecider;
	}

	public final Step<?> getSelectedLogicalStep() {
		synchronized (this) {
			return _selectedLogicalStep;
		}
	}

	final protected void setSelectedLogicalStep(Step<?> ls) {
		synchronized (this) {
			_selectedLogicalStep = ls;
		}
	}

	final protected void switchDeciderIfNecessary() {
		if (getLogicalStepDecider() != null && getLogicalStepDecider() != _logicalStepDecider) {
			_logicalStepDecider = getLogicalStepDecider();
		}
	}

	@Override
	final protected void performStart() {
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

	/**
	 * run all the event occurrences of this logical step
	 * 
	 * @param logicalStepToApply
	 * @throws CodeExecutionException
	 */
	@SuppressWarnings("unchecked")
	final protected void executeSelectedLogicalStep() throws CodeExecutionException {
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

	final public List<Step<?>> getPossibleLogicalSteps() {
		synchronized (this) {
			return new ArrayList<Step<?>>(_possibleLogicalSteps);
		}
	}

	final protected Step<?> selectAndExecuteLogicalStep() throws CodeExecutionException, DeciderException {
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

	protected void performExecutionStep() {
		switchDeciderIfNecessary();
		_possibleLogicalSteps = computePossibleLogicalSteps();
		if (_possibleLogicalSteps.size() == 0) {
			Activator.getDefault().debug("No more LogicalStep to run");
			stop();
		} else {
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

	protected final void notifyAboutToSelectLogicalStep() {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) {
			try {
				addon.aboutToSelectStep(this, getPossibleLogicalSteps());
			} catch (Exception e) {
				Activator.getDefault().error("Exception in Addon " + addon + ", " + e.getMessage(), e);
			}
		}
	}

	protected final void notifyLogicalStepSelected() {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) {
			try {
				addon.stepSelected(this, getSelectedLogicalStep());
			} catch (Exception e) {
				Activator.getDefault().error("Exception in Addon " + addon + ", " + e.getMessage(), e);
			}
		}
	}

	protected final void notifyProposedLogicalStepsChanged() {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) {
			try {
				addon.proposedStepsChanged(this, getPossibleLogicalSteps());
			} catch (Exception e) {
				Activator.getDefault().error("Exception in Addon " + addon + ", " + e.getMessage(), e);
			}
		}
	}

}
