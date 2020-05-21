package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.strategies.concurrency

import org.eclipse.gemoc.execution.concurrent.engine.strategies.concurrency.FullyOverlapStrategy

class FullyOverlapStrategyDefinition extends ConcurrencyStrategyDefinition {
	new() {
		super("uk.ac.kcl.inf.xdsml.strategies.full_overlap", "Fully Overlap Strategy", FullyOverlapStrategy)
	}
}
