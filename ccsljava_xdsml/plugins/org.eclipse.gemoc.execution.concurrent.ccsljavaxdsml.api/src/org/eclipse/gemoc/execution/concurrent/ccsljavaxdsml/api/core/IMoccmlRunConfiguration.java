package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core;

public interface IMoccmlRunConfiguration extends IConcurrentRunConfiguration {

	boolean getIsExhaustiveSimulation();
	String getExecutionModelPath();

}
