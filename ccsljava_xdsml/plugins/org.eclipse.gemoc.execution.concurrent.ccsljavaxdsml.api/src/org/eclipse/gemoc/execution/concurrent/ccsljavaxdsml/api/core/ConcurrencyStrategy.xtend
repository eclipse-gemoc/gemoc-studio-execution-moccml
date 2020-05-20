package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core

import org.eclipse.gemoc.trace.commons.model.trace.Step

interface ConcurrencyStrategy {
	
	def boolean canBeConcurrent(Step step, Step step2)
	
}