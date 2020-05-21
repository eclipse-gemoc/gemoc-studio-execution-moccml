package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core

import java.util.Set
import org.eclipse.gemoc.trace.commons.model.trace.ParallelStep
import org.eclipse.gemoc.trace.commons.model.trace.SmallStep
import org.eclipse.gemoc.trace.commons.model.trace.Step

abstract class AbstractCompilingConcurrentExecutionEngine <C extends AbstractConcurrentModelExecutionContext<R, ?, ?>, R extends IConcurrentRunConfiguration> extends AbstractConcurrentExecutionEngine<C, R> {
	
	abstract def Set<ParallelStep<?,?>> computeRawLogicalSteps()
	
	override protected computeInitialLogicalSteps() {
		val steps = computeRawLogicalSteps().map[ps|ps as ParallelStep<? extends Step<?>,?>]
		return steps.filter[s1|s1.subSteps.forall[ss1|
			steps.filter[s2|s2!==s1].forall[ss2|
				applyConcurrencyStrategies(ss1 as SmallStep<?>,ss2 as SmallStep<?>)
			]
		]].map[ps|ps as ParallelStep<?,?>].toSet()

	}
	
	
}