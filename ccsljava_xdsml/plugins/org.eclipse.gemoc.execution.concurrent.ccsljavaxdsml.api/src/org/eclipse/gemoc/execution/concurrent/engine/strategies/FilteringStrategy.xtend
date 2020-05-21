package org.eclipse.gemoc.execution.concurrent.engine.strategies

import java.util.Set
import org.eclipse.gemoc.trace.commons.model.generictrace.GenericParallelStep

interface FilteringStrategy extends Strategy {

	def Set<GenericParallelStep> filter(Set<GenericParallelStep> steps)

}
