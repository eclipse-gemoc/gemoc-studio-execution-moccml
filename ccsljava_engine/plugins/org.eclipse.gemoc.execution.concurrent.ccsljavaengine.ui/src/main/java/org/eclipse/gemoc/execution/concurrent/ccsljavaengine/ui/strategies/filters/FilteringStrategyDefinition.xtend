package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.strategies.filters

import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.strategies.StrategyDefinition
import org.eclipse.gemoc.execution.concurrent.engine.strategies.Strategy

abstract class FilteringStrategyDefinition extends StrategyDefinition {
	new(String ID, String label, Class<? extends Strategy> clazz) {
		super(ID, label, StrategyDefinition.StrategyGroup.FILTERING_STRATEGY, clazz)
	}
}
