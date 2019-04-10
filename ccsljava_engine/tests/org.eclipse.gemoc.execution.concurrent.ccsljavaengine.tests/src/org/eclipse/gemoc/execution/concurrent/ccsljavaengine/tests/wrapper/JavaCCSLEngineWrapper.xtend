//package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.tests.wrapper
//
//import java.util.Set
//import org.eclipse.core.runtime.CoreException
//import org.eclipse.core.runtime.Status
//import org.eclipse.emf.common.util.URI
//import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.commons.ConcurrentModelExecutionContext
//import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.dse.ConcurrentExecutionEngine
//import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.IConcurrentExecutionContext
//import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.IConcurrentRunConfiguration
//import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.moc.ISolver
//import org.eclipse.gemoc.executionframework.test.lib.IEngineWrapper
//import org.eclipse.gemoc.executionframework.test.lib.IExecutableModel
//import org.eclipse.gemoc.executionframework.test.lib.ILanguageWrapper
//import org.eclipse.gemoc.xdsmlframework.api.core.ExecutionMode
//
//class JavaCCSLEngineWrapper implements IEngineWrapper {
//
//	var ConcurrentExecutionEngine engine
//
//	override run() {
//		engine.start();
//		engine.joinThread();
//		if (engine.error != null)
//			throw engine.error
//	}
//
//	override getRealEngine() {
//		return engine
//	}
//
//	override prepare(ILanguageWrapper wrapper, IExecutableModel model, Set<String> addons, URI uri) {
//		val IConcurrentRunConfiguration runConf = new TestJavaCCSLRunConfiguration(model, uri, wrapper, addons)
//		val IConcurrentExecutionContext exeContext = new ConcurrentModelExecutionContext(runConf, ExecutionMode::Run);
//		exeContext.initializeResourceModel();
//		var ISolver solver = null;
//		try {
//			solver = exeContext.getConcurrentLanguageDefinitionExtension().instanciateSolver();
//			solver.prepareBeforeModelLoading(exeContext);
//			solver.initialize(exeContext);
//		} catch (CoreException e) {
//			throw new CoreException(
//				new Status(Status.ERROR, "test", "Cannot instanciate solver from language definition", e));
//		}
//		engine = new ConcurrentExecutionEngine(exeContext, solver);
//		engine.initialize(exeContext)
//		engine.stopOnAddonError = true;
//
//	}
//
//}
