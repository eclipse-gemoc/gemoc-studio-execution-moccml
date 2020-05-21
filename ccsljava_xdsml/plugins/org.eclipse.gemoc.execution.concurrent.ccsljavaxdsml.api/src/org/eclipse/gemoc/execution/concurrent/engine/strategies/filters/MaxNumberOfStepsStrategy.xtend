package org.eclipse.gemoc.execution.concurrent.engine.strategies.filters

import java.util.Set
import org.eclipse.gemoc.execution.concurrent.engine.strategies.FilteringStrategy
import org.eclipse.gemoc.trace.commons.model.generictrace.GenericParallelStep
import org.eclipse.xtend.lib.annotations.Accessors

class MaxNumberOfStepsStrategy implements FilteringStrategy {

	@Accessors
	var int maxNumberOfSteps

	new(int maxNumberOfSteps) {
		this.maxNumberOfSteps = maxNumberOfSteps
	}


	override Set<GenericParallelStep> filter(Set<GenericParallelStep> steps) {

	}

	
}
