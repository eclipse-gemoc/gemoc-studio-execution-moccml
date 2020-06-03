package org.eclipse.gemoc.execution.concurrent.engine.strategies

import java.util.Set
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.AbstractConcurrentExecutionEngine
import org.eclipse.gemoc.trace.commons.model.trace.ParallelStep
import org.eclipse.gemoc.trace.commons.model.trace.Step

interface FilteringStrategy extends Strategy {

	def Set<ParallelStep<? extends Step<?>, ?>> filter(Set<ParallelStep<? extends Step<?>, ?>> steps,
		AbstractConcurrentExecutionEngine<?, ?> engine)

}
