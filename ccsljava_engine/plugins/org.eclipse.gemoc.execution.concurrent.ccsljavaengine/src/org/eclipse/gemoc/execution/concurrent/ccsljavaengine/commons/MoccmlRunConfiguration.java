package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.commons;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.IMoccmlRunConfiguration;
import org.eclipse.gemoc.executionframework.engine.concurrency.ConcurrentRunConfiguration;

public class MoccmlRunConfiguration  extends ConcurrentRunConfiguration implements IMoccmlRunConfiguration{
	public static final String EXTRA_TIMEMODEL_PATH = "TIMEMODEL_PATH";
	public static final String MOCCML_SCENARIO_PATH = "MOCCML_SCENARIO_PATH";
	public static final String EXHAUSTIVE_MODE = "Do Exhaustive Simulation";
	protected boolean _isExhaustive;
	protected String _executionModelPath;
	protected String _moccmlscenarioModelPath;

	
	public MoccmlRunConfiguration(ILaunchConfiguration launchConfiguration) throws CoreException {
		super(launchConfiguration);
	}

	@Override
	public boolean getIsExhaustiveSimulation() {
		return _isExhaustive;
	}
	
	@Override
	protected void extractInformation() throws CoreException {
		super.extractInformation();
		_isExhaustive = getAttribute(EXHAUSTIVE_MODE, false);
		_executionModelPath = getAttribute(EXTRA_TIMEMODEL_PATH, "");
		_moccmlscenarioModelPath = getAttribute(MOCCML_SCENARIO_PATH, "");
	}
	
	@Override
	public String getExecutionModelPath() {
		return _executionModelPath;
	}

	@Override
	public String getMoccmlScenarioModelPath() {
		return _moccmlscenarioModelPath;
	}

}
