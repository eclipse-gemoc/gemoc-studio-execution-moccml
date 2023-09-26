package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core;

import org.eclipse.gemoc.executionframework.engine.concurrency.IConcurrentRunConfiguration;

public interface IMoccmlRunConfiguration extends IConcurrentRunConfiguration {

	boolean getIsExhaustiveSimulation();
	String getExecutionModelPath();
	String getMoccmlScenarioModelPath();

}
