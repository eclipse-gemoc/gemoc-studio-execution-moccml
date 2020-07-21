package org.eclipse.gemoc.execution.concurrent.engine.strategies

import org.chocosolver.solver.Model
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.AbstractConcurrentExecutionEngine.StepFactory

interface SymbolicFilteringStrategy extends Strategy{

	def Model doSymbolicFilter(Model symbolicPossibleSteps) {
	}
}
