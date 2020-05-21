package org.eclipse.gemoc.execution.concurrent.engine.strategies

import java.util.Set
import org.eclipse.gemoc.trace.commons.model.trace.ParallelStep

interface FilteringStrategy extends Strategy {

	def Set<ParallelStep<?,?>> filter(Set<ParallelStep<?,?>> steps)

}
