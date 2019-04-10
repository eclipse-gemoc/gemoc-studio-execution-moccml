/*******************************************************************************
 * Copyright (c) 2017 INRIA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     INRIA - initial API and implementation
 *     I3S Laboratory - API update and bug fix
 *******************************************************************************/
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.commons;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.IConcurrentRunConfiguration;
import org.eclipse.gemoc.executionframework.engine.core.RunConfiguration;
//import org.eclipse.gemoc.executionframework.engine.ui.commons.RunConfiguration;

public class ConcurrentRunConfiguration extends RunConfiguration implements IConcurrentRunConfiguration{


	public static final String LAUNCH_SELECTED_DECIDER = "GEMOC_LAUNCH_SELECTED_DECIDER";
	public static final String DECIDER_SOLVER = "Solver decider";
	public static final String DECIDER_ASKUSER_STEP_BY_STEP = "Step by step user decider";
	public static final String EXTRA_TIMEMODEL_PATH = "TIMEMODEL_PATH";
	public static final String EXHAUSTIVE_MODE = "Do Exhaustive Simulation";
	
	private String _modelInitializationMethod;
	private String _modelInitializationArguments;
	
	public ConcurrentRunConfiguration(ILaunchConfiguration launchConfiguration)
			throws CoreException {
		super(launchConfiguration);
		// TODO Auto-generated constructor stub
	}
	
	protected void extractInformation() throws CoreException {
		super.extractInformation();
		
		_deciderName = getAttribute(LAUNCH_SELECTED_DECIDER, "");
		_executionModelPath = getAttribute(EXTRA_TIMEMODEL_PATH, "");
		_isExhaustive = getAttribute(EXHAUSTIVE_MODE, false);
		_modelInitializationMethod = getAttribute(LAUNCH_INITIALIZATION_METHOD, "");
		_modelInitializationArguments = getAttribute(LAUNCH_INITIALIZATION_ARGUMENTS, "");
	}
	
	protected String _deciderName;
	protected String _executionModelPath;
	protected boolean _isExhaustive;
	
	@Override
	public String getDeciderName() {
		return _deciderName;
	}
	
	@Override
	public String getExecutionModelPath() {
		return _executionModelPath;
	}
	
	@Override
	public boolean getIsExhaustiveSimulation() {
		return _isExhaustive;
	}

	@Override
	public String getModelInitializationMethod() {
		return _modelInitializationMethod;
	}

	@Override
	public String getModelInitializationArguments() {
		return _modelInitializationArguments;
	}

}
