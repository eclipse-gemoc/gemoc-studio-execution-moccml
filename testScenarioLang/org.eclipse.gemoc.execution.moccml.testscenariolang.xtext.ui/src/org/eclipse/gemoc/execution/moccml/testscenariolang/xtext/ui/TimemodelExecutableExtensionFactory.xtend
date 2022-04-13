package org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.ui


import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory

class TimemodelExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	override protected getBundle() {
		TestScenarioLangActivatorEx.instance.bundle
	}

	override protected getInjector() {
		TestScenarioLangActivatorEx.instance.getInjector("fr.inria.aoste.timesquare.ccslkernel.model")
	}

}