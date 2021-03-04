package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.strategy_selector

import java.util.ArrayList
import java.util.HashMap
import java.util.List
import org.eclipse.debug.core.ILaunchConfiguration
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy
import org.eclipse.debug.internal.ui.SWTFactory
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.strategies.LaunchConfigurationContext
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.strategies.StrategyDefinition
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.strategies.StrategyDefinition.StrategyGroup
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.strategies.StrategyRegistry
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.AbstractConcurrentExecutionEngine
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.ConcurrentRunConfiguration
import org.eclipse.gemoc.execution.concurrent.engine.strategies.Strategy
import org.eclipse.swt.SWT
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.events.SelectionListener
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Control
import org.eclipse.swt.widgets.Group
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.launcher.tabs.LaunchConfigurationStrategiesTab
import org.eclipse.swt.layout.GridData

/**
 * Control for selecting and configuring strategies.
 */
class StrategySelectionControl extends Composite {

	val strategySelections = new HashMap<StrategyDefinition, Boolean>
	val components = new HashMap<StrategyDefinition, Pair<Button, Control>>
	val LaunchConfigurationContext configContext
	
	@Accessors(PUBLIC_SETTER)
	var StrategyConfigurationUpdateListener updateListener = null

	new(Composite parent, LaunchConfigurationContext configContext) {
		super(parent, SWT.FILL)

		this.configContext = configContext

		// FIXME: This seems wrong: the control will be used without a launch tab, too...
		updateListener = new LaunchConfigurationStrategiesTab(configContext)
		
		StrategyRegistry.INSTANCE.strategies.forEach [ sd |
			strategySelections.put(sd, false)
		]

		val gl = new GridLayout(1, false)

		gl.marginHeight = 0
		setLayout(gl)

		createLayout

		layout()
	}

	def initialiseFrom(ILaunchConfiguration configuration) {
		initialiseFrom(configuration.getAttribute(StrategyRegistry.STRATEGIES_CONFIG_KEY, #[]), 
			[control, extension sd | control.initaliseControl(configuration.getAttribute(sd.strategyID + ConcurrentRunConfiguration.STRATEGIES_CONFIG_DATA_KEY, ""))]
		)
	}

	def updateSelectionsFrom(AbstractConcurrentExecutionEngine<?,?> engine) {
		val List<Strategy> strategies = new ArrayList
		strategies.addAll(engine.concurrencyStrategies)
		strategies.addAll(engine.filteringStrategies) 
		val groupedStrategies = strategies.groupBy[StrategyRegistry::INSTANCE.strategyDefinitionOf(it)]
		initialiseFrom(groupedStrategies.keySet.map[strategyID], [control, extension sd | control.initaliseControl(groupedStrategies.get(sd)?.head)])		
	}

	def saveConfiguration(ILaunchConfigurationWorkingCopy configuration) {
		val selectedStrategies = strategySelections.filter[hd, selected|selected].keySet
		configuration.setAttribute(StrategyRegistry.STRATEGIES_CONFIG_KEY,
			selectedStrategies.map[it.getStrategyID].toList)
		selectedStrategies.forEach [ extension hd |
			val strategyComponent = components.get(hd).value
			if (strategyComponent !== null) {
				configuration.setAttribute(hd.getStrategyID + ConcurrentRunConfiguration.STRATEGIES_CONFIG_DATA_KEY,
					strategyComponent.encodeConfigInformation())
			}
		]
	}

	private def createLayout() {
		val groupmap = new HashMap<StrategyGroup, Group>()

		groupmap.put(StrategyGroup.CONCURRENCY_STRATEGY, createGroup(this, "Concurrency Strategies"))
		groupmap.put(StrategyGroup.FILTERING_STRATEGY, createGroup(this, "Filtering Strategies"))

		strategySelections.keySet.forEach [ sd |

			var parentGroup = groupmap.get(sd.group)

			val checkbox = createCheckButton(parentGroup, sd.humanReadableLabel)
			checkbox.selection = strategySelections.get(sd)

			val uiControl = sd.getUIControl(parentGroup, configContext, [
				val isSelected = strategySelections.get(sd)
				
				if (isSelected) {
					// No point updating the detailed strategy config otherwise...
					updateListener.onStrategyConfigurationHasChanged(sd, isSelected, components.get(sd).value)		
				}
			])
			components.put(sd, new Pair(checkbox, uiControl))

			checkbox.addSelectionListener(new SelectionListener() {

				override widgetSelected(SelectionEvent e) {
					strategySelections.put(sd, checkbox.selection)
					updateListener.onStrategyConfigurationHasChanged(sd, checkbox.selection, uiControl)
				}

				override widgetDefaultSelected(SelectionEvent e) {}
			})
		]

		// remove empty groups
		groupmap.values.forEach [ g |
			if (g.children.length === 0) {
				g.dispose()
				this.layout(true)
			}
		]
	}

	private def Group createGroup(Composite parent, String text) {
		val group = new Group(parent, SWT.NULL)
		group.setText(text)

		group.layoutData = new GridData(SWT.FILL, SWT.FILL, true, true)

		val locationLayout = new GridLayout(6, false)
		locationLayout.marginHeight = 10
		locationLayout.marginWidth = 10
		group.setLayout(locationLayout)

		group
	}

	private def Button createCheckButton(Composite parent, String label) {
		SWTFactory.createCheckButton(parent, label, null, false, 1)
	}	

	private def initialiseFrom(
		Iterable<String> selectedStrategiesIDs, 
		Procedure2<Control, StrategyDefinition> initialiseControl
	) {
		strategySelections.keySet.forEach[hd|strategySelections.put(hd, false)]

		selectedStrategiesIDs.forEach [ sid |
			strategySelections.put(StrategyRegistry.INSTANCE.get(sid), true)
		]

		strategySelections.forEach [ extension sd, selected |
			val strategyComponents = components.get(sd)
			val checkbox = strategyComponents.key
			if (checkbox !== null) {
				checkbox.selection = selected
			}

			val hComponent = strategyComponents.value
			if (hComponent !== null) {
				initialiseControl.apply(hComponent, sd)
			}
		]
	}
}
