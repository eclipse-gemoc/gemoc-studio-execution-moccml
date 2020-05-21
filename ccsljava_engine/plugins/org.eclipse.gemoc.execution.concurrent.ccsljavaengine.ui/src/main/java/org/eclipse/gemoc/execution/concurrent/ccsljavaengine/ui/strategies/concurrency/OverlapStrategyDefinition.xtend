package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.strategies.concurrency

import org.eclipse.gemoc.execution.concurrent.engine.strategies.concurrency.OverlapStrategy

class OverlapStrategyDefinition extends ConcurrencyStrategyDefinition {
	new() {
		super("uk.ac.kcl.inf.xdsml.strategies.overlap", "Overlap Strategy", OverlapStrategy)
	}
}
