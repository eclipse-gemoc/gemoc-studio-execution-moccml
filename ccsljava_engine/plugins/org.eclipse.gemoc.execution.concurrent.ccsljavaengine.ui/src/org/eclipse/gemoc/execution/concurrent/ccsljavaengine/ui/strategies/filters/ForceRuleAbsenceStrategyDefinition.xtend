package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.strategies.filters

import java.util.Set
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.strategies.LaunchConfigurationContext
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.strategies.StrategyControlUpdateListener
import org.eclipse.gemoc.execution.concurrent.engine.strategies.Strategy
import org.eclipse.gemoc.execution.concurrent.engine.strategies.filters.NonIdentityElementsStrategy
import org.eclipse.swt.SWT
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.events.SelectionListener
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Control
import org.eclipse.swt.widgets.List
import org.eclipse.gemoc.execution.concurrent.engine.strategies.filters.ForceRuleAbsenceStrategy

class ForceRuleAbsenceStrategyDefinition extends FilteringStrategyDefinition {
	new() {
		super("org.eclipse.gemoc.xdsml.strategies.remove_unwanted", "Force Rule Absence",
			ForceRuleAbsenceStrategy)
	}

	override getUIControl(Composite parent, LaunchConfigurationContext lcc, StrategyControlUpdateListener scul) {
		val control = new List(parent, SWT.MULTI.bitwiseOr(SWT.V_SCROLL).bitwiseOr(SWT.BORDER))
		control.layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false)
		
		lcc.addSemanticsChangeListener([ evt |
			control.updateSemantics(evt.newValue as Set<String>)
		])

		control.updateSemantics(lcc.semantics)

		
		if (scul !== null) {
			control.addSelectionListener(new SelectionListener() {
				
				override widgetDefaultSelected(SelectionEvent e) { }
				
				override widgetSelected(SelectionEvent e) {
					scul.controlUpdated(ForceRuleAbsenceStrategyDefinition.this)
				}				
			})
		}

		control
	}

	override initaliseControl(Control uiElement, String configData) {
		val list = uiElement as List
		if (list.items.size > 0) {
			val namesToSelect = configData.split("@@")

			list.select(#[0..list.itemCount-1].flatten.filter[namesToSelect.contains(list.items.get(it))])
		}
	}

	override void initaliseControl(Control uiElement, Strategy strategy) {
		val list = uiElement as List
		list.setSelection(#[] as int[])
		
		if (strategy instanceof NonIdentityElementsStrategy) {
			list.selection = strategy.nonIdentityTypes.map[name]
		}
	}

	override encodeConfigInformation(Control uiElement) {
		val list = uiElement as List

		list.selectionIndices.map[i | list.items.get(i)].join("@@")
	}

	override initialise(Strategy strategy, String configData, LaunchConfigurationContext lcc) {
		if (strategy instanceof ForceRuleAbsenceStrategy) {
			lcc.addSemanticsChangeListener([ evt |
				strategy.updateSemantics(evt.newValue as Set<String>, configData)
			])
	
			strategy.updateSemantics(lcc.semantics, configData)
		}
	}

	def updateSemantics(List control, Set<String> semantics) {
		control.items = emptyList

		if (semantics !== null) {
			semantics.forEach [ r |
				control.add(r)
			]
		}
	}

	def updateSemantics(ForceRuleAbsenceStrategy feas, Set<String> semantics, String configData) {
		feas.toBeAbsentRule.clear

		if (semantics !== null) {
			val actionNames = configData.split("@@").toList
			feas.toBeAbsentRule= semantics.filter[r|actionNames.contains(r)].toList
		}
	}
}
