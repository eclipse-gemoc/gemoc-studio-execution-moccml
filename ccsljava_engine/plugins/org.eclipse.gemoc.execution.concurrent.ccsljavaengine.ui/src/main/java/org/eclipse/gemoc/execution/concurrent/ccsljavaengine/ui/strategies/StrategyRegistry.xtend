package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.strategies

import java.util.HashMap
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.strategies.concurrency.OverlapStrategyDefinition
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.strategies.concurrency.SetOfActionsStrategyDefinition
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.strategies.filters.MaxNumberOfStepsStrategyDefinition
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.strategies.filters.NonIdentityElementsStrategyDefinition
import org.eclipse.gemoc.execution.concurrent.engine.strategies.Strategy

/**
 * Registry of strategy descriptions. Eventually to be filled from an extension point.
 * 
 */
class StrategyRegistry {

	public static val INSTANCE = new StrategyRegistry

	public static val STRATEGIES_CONFIG_KEY = "uk.ac.kcl.inf.xdsml.strategies"
	
	private new() {
		add(new OverlapStrategyDefinition)
		add(new SetOfActionsStrategyDefinition)
		add(new NonIdentityElementsStrategyDefinition)
		add(new MaxNumberOfStepsStrategyDefinition)
	}

	val registry = new HashMap<String, StrategyDefinition>()

	def add(StrategyDefinition strategy) {
		registry.put(strategy.getStrategyID, strategy)
	}

	def getStrategies() {
		registry.values
	}

	def get(String ID) {
		registry.get(ID)
	}
	
	def StrategyDefinition strategyDefinitionOf(Strategy strategy) {
		registry.filter[x, sd| sd.isStrategyInstance(strategy)].get(0)
	}
}
