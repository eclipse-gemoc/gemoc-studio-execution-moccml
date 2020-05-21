package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.strategies.concurrency

import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.strategies.StrategyDefinition
import org.eclipse.gemoc.execution.concurrent.engine.strategies.Strategy

abstract class ConcurrencyStrategyDefinition extends StrategyDefinition {
	new(String ID, String label, Class<? extends Strategy> clazz) {
		super(ID, label, StrategyDefinition.StrategyGroup.CONCURRENCY_STRATEGY, clazz)
	}
}
