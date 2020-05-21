package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core

import java.util.ArrayList
import java.util.Collection
import java.util.HashSet
import java.util.List
import java.util.Set
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dsa.executors.CodeExecutionException
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.moc.DeciderException
import org.eclipse.gemoc.execution.concurrent.engine.strategies.ConcurrencyStrategy
import org.eclipse.gemoc.execution.concurrent.engine.strategies.FilteringStrategy
import org.eclipse.gemoc.executionframework.engine.Activator
import org.eclipse.gemoc.executionframework.engine.core.AbstractExecutionEngine
import org.eclipse.gemoc.executionframework.engine.core.EngineStoppedException
import org.eclipse.gemoc.trace.commons.model.generictrace.GenericParallelStep
import org.eclipse.gemoc.trace.commons.model.trace.SmallStep
import org.eclipse.gemoc.trace.commons.model.trace.Step
import org.eclipse.gemoc.xdsmlframework.api.core.EngineStatus
import org.eclipse.gemoc.xdsmlframework.api.engine_addon.IEngineAddon
import org.eclipse.xtend.lib.annotations.Accessors

//TODO manage runconfiguration with strategies?
abstract class AbstractConcurrentExecutionEngine<C extends AbstractConcurrentModelExecutionContext<R, ?, ?>, R extends IConcurrentRunConfiguration> extends AbstractExecutionEngine<C, R> {

	def protected abstract void doAfterLogicalStepExecution(GenericParallelStep logicalStep)

	def protected abstract void executeSmallStep(SmallStep<?> smallStep) throws CodeExecutionException

	def protected abstract void performSpecificInitialize(C executionContext)

	def protected abstract Set<GenericParallelStep> computeInitialLogicalSteps()

	ILogicalStepDecider _logicalStepDecider
	protected Set<GenericParallelStep> _possibleLogicalSteps = new HashSet()
	GenericParallelStep _selectedLogicalStep

	@Accessors
	val List<ConcurrencyStrategy> concurrencyStrategies = new ArrayList<ConcurrencyStrategy>()
	@Accessors
	val List<FilteringStrategy> filteringStrategies = new ArrayList<FilteringStrategy>()

	def private Set<GenericParallelStep> computePossibleLogicalSteps() {
		val steps = computeInitialLogicalSteps()
		return filterByStrategies(steps)
	}

	/** 
	 * Return a list of steps filtered by all filtering strategies
	 */
	private def Set<GenericParallelStep> filterByStrategies(Set<GenericParallelStep> possibleSteps) {
		return filteringStrategies.fold(possibleSteps, [steps, fh|fh.filter(steps)])
	}

	/**
	 * Check that concurrency strategies allow two steps to run concurrently.
	 * Method to be used by subclasses in order to implement 'computeInitialLogicalSteps'.
	 * @param step1 The first step.
	 * @param step2 The second step.
	 * @return true if the concurrency strategies allow both steps to run concurrently.  
	 */
	protected final def boolean applyConcurrencyStrategies(SmallStep<?> step1, SmallStep<?> step2) {
		return concurrencyStrategies.forall[ch|ch.canBeConcurrent(step1, step2)]
	}

	override protected void beforeStart() {
	}

	def final void changeLogicalStepDecider(ILogicalStepDecider newDecider) {
		_logicalStepDecider = newDecider
	}

	def final ILogicalStepDecider getLogicalStepDecider() {
		return _logicalStepDecider
	}

	def final GenericParallelStep getSelectedLogicalStep() {
		synchronized (this) {
			return _selectedLogicalStep
		}
	}

	def final protected void setSelectedLogicalStep(GenericParallelStep ls) {
		synchronized (this) {
			_selectedLogicalStep = ls
		}
	}

	def final protected void switchDeciderIfNecessary() {
		if (getLogicalStepDecider() !== null && getLogicalStepDecider() !== _logicalStepDecider) {
			_logicalStepDecider = getLogicalStepDecider()
		}
	}

	override final protected void performStart() {
		engineStatus.setNbLogicalStepRun(0)
		try {
			while (!_isStopped) {
				performExecutionStep()
			}
		} catch (EngineStoppedException ese) {
			throw ese // forward the stop exception
		} catch (Throwable e) {
			throw new RuntimeException(e)
		}

	}

	override protected final void performStop() {
		setSelectedLogicalStep(null)
		if (getLogicalStepDecider() !== null) {
			// unlock decider if this is a user decider
			getLogicalStepDecider().preempt()
		}
	}

	/** 
	 * run all the event occurrences of this logical step
	 * @param logicalStepToApply
	 * @throws CodeExecutionException
	 */
	@SuppressWarnings("unchecked") def final protected void executeSelectedLogicalStep() throws CodeExecutionException {
		if (!_isStopped) {
			// execute while stopped may occur when we push the
			// stop button when paused in the debugger
			beforeExecutionStep(_selectedLogicalStep)
			for (Step<?> step : ((_selectedLogicalStep as GenericParallelStep)).getSubSteps()) {
				var SmallStep<?> sstep = (step as SmallStep<?>)
				executeSmallStep(sstep)
			}
			afterExecutionStep()
		}
	}

	def final List<GenericParallelStep> getPossibleLogicalSteps() {
		synchronized (this) {
			return new ArrayList<GenericParallelStep>(_possibleLogicalSteps)
		}
	}

	def final protected GenericParallelStep selectAndExecuteLogicalStep() throws CodeExecutionException, DeciderException {
		setEngineStatus(EngineStatus.RunStatus::WaitingLogicalStepSelection)
		notifyAboutToSelectLogicalStep()
		var GenericParallelStep selectedLogicalStep = getLogicalStepDecider().decide(this, getPossibleLogicalSteps())
		if (selectedLogicalStep !== null) {
			setSelectedLogicalStep(selectedLogicalStep)
			setEngineStatus(EngineStatus.RunStatus::Running)
			notifyLogicalStepSelected()
			// run all the event occurrences of this logical
			// step
			executeSelectedLogicalStep()
		}
		return selectedLogicalStep
	}

	def protected void performExecutionStep() {
		switchDeciderIfNecessary()
		_possibleLogicalSteps = computePossibleLogicalSteps()
		if (_possibleLogicalSteps.size() === 0) {
			Activator::getDefault().debug("No more LogicalStep to run")
			stop()
		} else {
			try {
				var GenericParallelStep selectedLogicalStep = selectAndExecuteLogicalStep()
				// 3 - run the selected logical step
				// inform the solver that we will run this step
				if (selectedLogicalStep !== null) {
					doAfterLogicalStepExecution(selectedLogicalStep)
					engineStatus.incrementNbLogicalStepRun()
				} else { // no logical step was selected, this is most probably due to a
					// preempt on the LogicalStepDecider and a change of Decider,
					// notify Addons that we'll rerun this ExecutionStep
					// recomputePossibleLogicalSteps();
				}
			} catch (Throwable t) {
				throw new RuntimeException(t)
			}

		}
	}

	def void addFilteringStrategy(FilteringStrategy strategy) {
		this.filteringStrategies.add(strategy)
	}

	def void addConcurrencyStrategy(ConcurrencyStrategy strategy) {
		this.concurrencyStrategies.add(strategy)
	}

	override protected final void performInitialize(C executionContext) {
		this.changeLogicalStepDecider(executionContext.getLogicalStepDecider())

//		val config = executionContext.getRunConfiguration() as ConcurrentRunConfiguration
//
//		config.getStrategies.forEach [ extension h |
//			val h = hd.instantiate
//			h.initialise(config.getConfigDetailFor(hd), lcc)
//
//			if (hd.group === StrategyGroup.FILTERING_STRATEGY) {
//				filteringStrategies.add(h as FilteringStrategy)
//			} else {
//				concurrencyStrategies.add(h as ConcurrencyStrategy)
//			}
//		]
		performSpecificInitialize(executionContext)

		Activator::getDefault().debug("*** Engine initialization done. ***")
	}

	def protected final void notifyAboutToSelectLogicalStep() {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) {
			try {
				addon.aboutToSelectStep(this, possibleLogicalSteps.map[s|s as Step<?>])
			} catch (Exception e) {
				Activator::getDefault().error('''Exception in Addon «addon», «e.getMessage()»'''.toString, e)
			}

		}
	}

	def protected final void notifyLogicalStepSelected() {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) {
			try {
				addon.stepSelected(this, getSelectedLogicalStep())
			} catch (Exception e) {
				Activator::getDefault().error('''Exception in Addon «addon», «e.getMessage()»'''.toString, e)
			}

		}
	}

	def protected final void notifyProposedLogicalStepsChanged() {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) {
			try {
				addon.proposedStepsChanged(this, possibleLogicalSteps.map[s|s as Step<?>])
			} catch (Exception e) {
				Activator::getDefault().error('''Exception in Addon «addon», «e.getMessage()»'''.toString, e)
			}

		}
	}
}
