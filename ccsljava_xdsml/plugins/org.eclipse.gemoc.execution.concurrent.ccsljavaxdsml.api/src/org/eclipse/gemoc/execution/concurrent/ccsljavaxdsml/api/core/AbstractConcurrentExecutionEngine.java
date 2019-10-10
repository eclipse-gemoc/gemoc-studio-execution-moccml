package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core;

import java.util.List;

import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.moc.ISolver;
import org.eclipse.gemoc.executionframework.engine.core.AbstractExecutionEngine;
import org.eclipse.gemoc.trace.commons.model.trace.Step;

public abstract class AbstractConcurrentExecutionEngine extends AbstractExecutionEngine {
	public abstract AbstractConcurrentModelExecutionContext getConcurrentExecutionContext();

	public abstract void recomputePossibleLogicalSteps();

	public abstract List<Step<?>> getPossibleLogicalSteps();

	public abstract Step<?> getSelectedLogicalStep();

	public abstract ILogicalStepDecider getLogicalStepDecider();

	public abstract void changeLogicalStepDecider(ILogicalStepDecider newDecider);

	public abstract ISolver getSolver();

	public abstract void setSolver(ISolver solver);

}
