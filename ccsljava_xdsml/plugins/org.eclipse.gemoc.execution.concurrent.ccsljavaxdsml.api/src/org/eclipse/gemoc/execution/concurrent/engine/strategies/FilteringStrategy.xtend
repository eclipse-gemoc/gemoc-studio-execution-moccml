package org.eclipse.gemoc.execution.concurrent.engine.strategies

import java.util.Set
import org.eclipse.gemoc.trace.commons.model.trace.ParallelStep
import org.eclipse.gemoc.trace.commons.model.trace.Step
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.AbstractConcurrentExecutionEngine.StepFactory

interface FilteringStrategy extends Strategy {

	/**
	 * Produce a filtered version of the set of steps provided.
	 * 
	 * Steps in the result set must be EITHER already in the original set of steps OR newly created logical steps that constrain the concurrency defined by the original set of steps.
	 * Specifically, this means that the strategy must only create new ParallelStep instances if (1) steps does not already contain an equal logical step and (2) the substeps of the 
	 * new step are a subset of the substeps of a step in the original set of steps.  
	 */
	def Set<ParallelStep<? extends Step<?>, ?>> filter(Set<ParallelStep<? extends Step<?>, ?>> steps,
		StepFactory factory)
}
