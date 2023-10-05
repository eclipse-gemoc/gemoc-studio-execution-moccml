package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.eventscheduling.trace;

import java.util.Optional;

import org.eclipse.gemoc.executionframework.engine.concurrency.AbstractConcurrentExecutionEngine;
import org.eclipse.gemoc.executionframework.reflectivetrace.gemoc_execution_trace.Choice;
import org.eclipse.gemoc.executionframework.reflectivetrace.gemoc_execution_trace.ContextState;
import org.eclipse.gemoc.executionframework.reflectivetrace.gemoc_execution_trace.ExecutionTraceModel;
import org.eclipse.gemoc.executionframework.reflectivetrace.gemoc_execution_trace.ModelState;

public interface EventSchedulingModelExecutionTracingAddonMetaApproachExtension {

	Optional<ModelState> storeModelStateIfChanged();

	void restoreModelState(ModelState state);
	
	void storeSolverState(ContextState contextState);

	void restoreSolverState(Choice choice);
	
	void initialize(AbstractConcurrentExecutionEngine<?, ?> engine, ExecutionTraceModel executionTraceModel,
			EventSchedulingModelExecutionTracingAddon addon);

}
