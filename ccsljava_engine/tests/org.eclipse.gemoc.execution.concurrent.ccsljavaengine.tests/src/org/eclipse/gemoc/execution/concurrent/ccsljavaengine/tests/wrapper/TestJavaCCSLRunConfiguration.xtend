//package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.tests.wrapper
//
//import org.eclipse.gemoc.executionframework.test.lib.impl.TestRunConfiguration
//import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.IConcurrentRunConfiguration
//import org.eclipse.gemoc.executionframework.test.lib.IExecutableModel
//import org.eclipse.emf.common.util.URI
//import org.eclipse.gemoc.executionframework.test.lib.ILanguageWrapper
//import java.util.Set
//import org.eclipse.xtend.lib.annotations.Delegate
//
//class TestJavaCCSLRunConfiguration implements IConcurrentRunConfiguration {
//
//	@Delegate
//	val TestRunConfiguration testRunconfiguration
//
//	new(IExecutableModel model, URI modelURI, ILanguageWrapper language, Set<String> addonsToLoad) {
//		testRunconfiguration = new TestRunConfiguration(model, modelURI, language, addonsToLoad)
//	}
//
//	override getDeciderName() {
//		return "Random decider"
//	}
//
//	override getExecutionModelPath() {
//		return ""
//	}
//
//}
