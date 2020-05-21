


package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.strategies.filters

import java.util.List
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

class NonIdentityElementsStrategyDefinition extends FilteringStrategyDefinition {
	new() {
		super("uk.ac.kcl.inf.xdsml.strategies.non_identity_elements", "Non Identity Elements Strategy",
			NonIdentityElementsStrategy)
	}

	override getUIControl(Composite parent, LaunchConfigurationContext lcc, StrategyControlUpdateListener scul) {
		val control = new org.eclipse.swt.widgets.List(parent, SWT.MULTI.bitwiseOr(SWT.V_SCROLL).bitwiseOr(SWT.BORDER))
		control.layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false)

		lcc.addMetamodelChangeListener([ evt |
			control.updateMetamodels(evt.newValue as List<EPackage>)
		])

		control.updateMetamodels(lcc.metamodels)
		
		if (scul !== null) {
			control.addSelectionListener(new SelectionListener() {
				
				override widgetDefaultSelected(SelectionEvent e) { }
				
				override widgetSelected(SelectionEvent e) {
					scul.controlUpdated(NonIdentityElementsStrategyDefinition.this)
				}				
			})
		}

		control
	}

	override initaliseControl(Control uiElement, String configData) {
		val list = uiElement as org.eclipse.swt.widgets.List
		if (list.items.size > 0) {
			val namesToSelect = configData.split("@@")

			list.select(#[0..list.itemCount-1].flatten.filter[namesToSelect.contains(list.items.get(it))])
		}
	}

	override void initaliseControl(Control uiElement, Strategy strategy) {
		val list = uiElement as org.eclipse.swt.widgets.List
		list.setSelection(#[] as int[])
		
		if (strategy instanceof NonIdentityElementsStrategy) {
			list.selection = strategy.nonIdentityTypes.map[name]
		}
	}

	override encodeConfigInformation(Control uiElement) {
		val list = uiElement as org.eclipse.swt.widgets.List

		list.selectionIndices.map[i | list.items.get(i)].join("@@")
	}

	override initialise(Strategy strategy, String configData, LaunchConfigurationContext lcc) {
		val h = strategy as NonIdentityElementsStrategy

		lcc.addMetamodelChangeListener([ evt |
			h.updateMetamodels(evt.newValue as List<EPackage>, configData)
		])
		
		h.updateMetamodels(lcc.metamodels as List<EPackage>, configData)
	}

	def updateMetamodels(org.eclipse.swt.widgets.List control, List<EPackage> metamodels) {
		control.items = emptyList

		if (metamodels !== null) {
			metamodels.flatMap[mm|mm.eAllContents.filter(EClass).toIterable].forEach [ c |
				control.add(c.name)
			]
		}
	}

	def updateMetamodels(NonIdentityElementsStrategy nieh, List<EPackage> metamodels, String configData) {
		nieh.nonIdentityTypes.clear
		
		if (metamodels !== null) {
			val classNames = configData.split("@@").toList
			nieh.nonIdentityTypes = metamodels.flatMap[ep | ep.eAllContents.filter(EClass).filter[ec | classNames.contains(ec.name)].toIterable].toList
		}
	}
}
