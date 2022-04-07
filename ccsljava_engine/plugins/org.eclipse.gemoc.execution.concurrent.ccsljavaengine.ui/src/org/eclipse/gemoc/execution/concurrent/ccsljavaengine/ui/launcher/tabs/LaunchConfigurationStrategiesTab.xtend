package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.launcher.tabs

import java.util.Collections
import org.eclipse.debug.core.ILaunchConfiguration
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.strategies.LaunchConfigurationContext
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.strategies.StrategyDefinition
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.strategies.StrategyRegistry
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.strategy_selector.StrategyConfigurationUpdateListener
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.strategy_selector.StrategySelectionControl
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.ConcurrentRunConfiguration
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Control

/**
 * Tab for choosing the step strategies.
 */
class LaunchConfigurationStrategiesTab extends LaunchConfigurationTab implements StrategyConfigurationUpdateListener {
	val LaunchConfigurationContext configContext
	var StrategySelectionControl strategyControl
	
	/**
	 * Get all possible strategies and add them to the tab so the user can switch them on/off
	 */
	new(LaunchConfigurationContext configContext) {
		this.configContext = configContext
	}

	override createControl(Composite parent) {
		strategyControl = new StrategySelectionControl(parent, configContext)
		setControl(strategyControl)		
	}

	override setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(StrategyRegistry.STRATEGIES_CONFIG_KEY, Collections.EMPTY_LIST)
		StrategyRegistry.INSTANCE.strategies.forEach [ hd |
			configuration.removeAttribute(hd.strategyID + ConcurrentRunConfiguration.STRATEGIES_CONFIG_DATA_KEY)
		]
	}

	override initializeFrom(ILaunchConfiguration configuration) {
		strategyControl.initialiseFrom(configuration)
	}

	override performApply(ILaunchConfigurationWorkingCopy configuration) {
		strategyControl.saveConfiguration(configuration)
	}

	override isValid(ILaunchConfiguration config) {
		errorMessage = null
		true
	}

	override getName() { "Steps Strategies" }
	
	override onStrategyConfigurationHasChanged(StrategyDefinition sd, boolean isSelected, Control uiControl) {
		updateLaunchConfigurationDialog()
	}
}