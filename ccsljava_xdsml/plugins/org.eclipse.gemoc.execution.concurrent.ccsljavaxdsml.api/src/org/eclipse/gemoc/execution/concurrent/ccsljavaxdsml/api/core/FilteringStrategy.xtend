package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core

import java.util.Set
import org.eclipse.gemoc.trace.commons.model.generictrace.GenericParallelStep

interface FilteringStrategy {
	
	def Set<GenericParallelStep> filter(Set<GenericParallelStep> steps)
	
}
