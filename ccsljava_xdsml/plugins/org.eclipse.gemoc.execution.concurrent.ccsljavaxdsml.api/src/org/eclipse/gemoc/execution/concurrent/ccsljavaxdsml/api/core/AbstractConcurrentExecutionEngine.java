package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core;

import java.util.List;

import org.eclipse.gemoc.executionframework.engine.core.AbstractExecutionEngine;
import org.eclipse.gemoc.trace.commons.model.trace.Step;
import org.eclipse.gemoc.xdsmlframework.api.core.IExecutionContext;
import org.eclipse.gemoc.xdsmlframework.api.core.IRunConfiguration;

public abstract class AbstractConcurrentExecutionEngine
<C extends AbstractConcurrentModelExecutionContext<R,?,?>, R extends IConcurrentRunConfiguration> 
extends AbstractExecutionEngine<C,R>

{
	
	
	public abstract C getConcurrentExecutionContext();

	public abstract void recomputePossibleLogicalSteps();

	public abstract List<Step<?>> getPossibleLogicalSteps();

	public abstract Step<?> getSelectedLogicalStep();

	public abstract ILogicalStepDecider getLogicalStepDecider();

	public abstract void changeLogicalStepDecider(ILogicalStepDecider newDecider);

}
