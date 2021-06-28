package org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.ui


import org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.TestScenarioLangRuntimeModule
import org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.TimemodelRuntimeModule
import org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.ui.TimemodelUiModule
import org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.ui.internal.TestScenarioLangActivator

class TestScenarioLangActivatorEx extends TestScenarioLangActivator {
	
	
	override getRuntimeModule(String grammar) {
		if (grammar.isTimemodelLanguage) {
			return new TimemodelRuntimeModule
		}
		super.getRuntimeModule(grammar)
	}

	override getUiModule(String grammar) {
		if (grammar.isTimemodelLanguage) {
			return new TimemodelUiModule(this) 
		}
		super.getUiModule(grammar)
	}

	private def isTimemodelLanguage(String grammar){
		"fr.inria.aoste.timesquare.ccslkernel.model".equals(grammar)
	}
	
}
