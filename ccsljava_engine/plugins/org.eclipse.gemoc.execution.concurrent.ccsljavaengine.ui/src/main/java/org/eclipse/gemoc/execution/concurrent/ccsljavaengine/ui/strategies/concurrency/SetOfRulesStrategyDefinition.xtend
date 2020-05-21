package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.strategies.concurrency

import java.util.List
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.strategies.LaunchConfigurationContext
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.strategies.StrategyControlUpdateListener
import org.eclipse.gemoc.execution.concurrent.engine.strategies.Strategy
import org.eclipse.gemoc.execution.concurrent.engine.strategies.concurrency.SetOfRulesStrategy
import org.eclipse.swt.SWT
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.events.SelectionListener
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Control

class SetOfRulesStrategyDefinition extends ConcurrencyStrategyDefinition {
	
	val SetOfRulesStrategyDefinition thisSetOfRulesStrategyDefinition
	
	new() {
		super("uk.ac.kcl.inf.xdsml.strategies.set_of_rules", "Set Of Rules Strategy", SetOfRulesStrategy)
		thisSetOfRulesStrategyDefinition = this
	}

	override getUIControl(Composite parent, LaunchConfigurationContext lcc, StrategyControlUpdateListener scul) {
		val control = new org.eclipse.swt.widgets.List(parent, SWT.MULTI.bitwiseOr(SWT.V_SCROLL).bitwiseOr(SWT.BORDER))
		control.layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false)

		lcc.addSemanticsChangeListener([ evt |
			control.updateSemantics(evt.newValue as List<String>)
		])

		control.updateSemantics(lcc.semantics)

		if (scul !== null) {
			control.addSelectionListener(new SelectionListener() {

				override widgetDefaultSelected(SelectionEvent e) {}

				override widgetSelected(SelectionEvent e) {
					scul.controlUpdated(thisSetOfRulesStrategyDefinition)
				}
			})
		}

		control
	}

	override encodeConfigInformation(Control uiElement) {
		val list = uiElement as org.eclipse.swt.widgets.List

		list.selectionIndices.map[i|list.items.get(i)].join("@@")
	}

	override initaliseControl(Control uiElement, String configData) {
		val list = uiElement as org.eclipse.swt.widgets.List
		if (list.items.size > 0) {
			val namesToSelect = configData.split("@@")

			list.select(#[0 .. list.itemCount - 1].flatten.filter[namesToSelect.contains(list.items.get(it))])
		}
	}

	override void initaliseControl(Control uiElement, Strategy strategy) {
		val list = uiElement as org.eclipse.swt.widgets.List
		list.setSelection(#[] as int[])

		if (strategy instanceof SetOfRulesStrategy) {
			list.selection = strategy.rules.clone
		}
	}

	override initialise(Strategy strategy, String configData, LaunchConfigurationContext lcc) {
		val h = strategy as SetOfRulesStrategy

		lcc.addSemanticsChangeListener([ evt |
			h.updateSemantics(evt.newValue as List<String>, configData)
		])

		h.updateSemantics(lcc.semantics, configData)
	}

	def updateSemantics(org.eclipse.swt.widgets.List control, List<String> semantics) {
		control.items = emptyList

		if (semantics !== null) {
			semantics.forEach [ r |
				control.add(r)
			]
		}
	}

	def updateSemantics(SetOfRulesStrategy sorh, List<String> semantics, String configData) {
		sorh.rules.clear

		if (semantics !== null) {
			val ruleNames = configData.split("@@").toList
			sorh.rules = semantics.filter[r|ruleNames.contains(r)].toList
		}
	}
}
