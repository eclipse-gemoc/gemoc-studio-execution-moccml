/*
 * generated by Xtext
 */
package org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.ui.internal.TestScenarioLangActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class TestScenarioLangExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return TestScenarioLangActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return TestScenarioLangActivator.getInstance().getInjector(TestScenarioLangActivator.ORG_ECLIPSE_GEMOC_EXECUTION_MOCCML_TESTSCENARIOLANG_XTEXT_TESTSCENARIOLANG);
	}
	
}