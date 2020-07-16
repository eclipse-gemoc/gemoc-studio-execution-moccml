package org.eclipse.gemoc.execution.concurrent.engine.strategies.filters

import java.util.Set
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.AbstractConcurrentExecutionEngine.StepFactory
import org.eclipse.gemoc.execution.concurrent.engine.strategies.FilteringStrategy
import org.eclipse.gemoc.trace.commons.model.trace.ParallelStep
import org.eclipse.gemoc.trace.commons.model.trace.SmallStep
import org.eclipse.gemoc.trace.commons.model.trace.Step

/**
 * A generic implementation of filtering ensuring the filtering contract.
 */
abstract class AbstractFilteringStrategy implements FilteringStrategy {


	override final filter(Set<ParallelStep<? extends Step<?>, ?>> steps, StepFactory factory) {
		val filteringResult = steps.doFilter(factory)
		
		// Ensure we export the right set of steps
		filteringResult.map[s | 
			if (steps.contains(s)) {
				s
			} else {
				val equalStep = steps.findFirst[equalParallelStepTo (s, factory)]
				
				if (equalStep !== null) {
					equalStep
				} else {
					if (steps.exists[superStepOf(s, factory)]) {
						s
					} else {
						// TODO Should properly log this
						
						System.err.println("Ignoring step illegally constructed by filtering strategy " + this)
						System.err.println("Step was: " + s)
						
						null
					}
				}
			}
		].filterNull.toSet
	}

	private def equalParallelStepTo(ParallelStep<? extends Step<?>, ?> s1, ParallelStep<? extends Step<?>, ?> s2,
		StepFactory factory) {
		s1.superStepOf(s2, factory) &&
		s2.superStepOf(s1, factory)  
	}

	private def superStepOf(ParallelStep<? extends Step<?>, ?> _super, ParallelStep<? extends Step<?>, ?> _sub, extension StepFactory factory) {
		_super.subSteps.length >= _sub.subSteps.length &&
		_sub.subSteps.forall[ss1 | _super.subSteps.exists[(it as SmallStep<?>).isEqualSmallStepTo(ss1 as SmallStep<?>)]]
	}

	abstract protected def Set<ParallelStep<? extends Step<?>, ?>> doFilter(Set<ParallelStep<? extends Step<?>, ?>> steps, StepFactory factory)
}