package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core

import java.util.Set
import org.eclipse.gemoc.trace.commons.model.generictrace.GenericParallelStep

abstract class AbstractCompilingConcurrentExecutionEngine <C extends AbstractConcurrentModelExecutionContext<R, ?, ?>, R extends IConcurrentRunConfiguration> extends AbstractConcurrentExecutionEngine<C, R> {
	
	abstract def Set<GenericParallelStep> computeRawLogicalSteps()
	
	override protected computeInitialLogicalSteps() {
		val steps = computeRawLogicalSteps()
		return steps.filter[s1|s1.subSteps.forall[ss1|
			steps.filter[s2|s2!==s1].forall[ss2|
				applyConcurrencyStrategies(ss1,ss2)
			]
		]].toSet()

	}
	
	
}