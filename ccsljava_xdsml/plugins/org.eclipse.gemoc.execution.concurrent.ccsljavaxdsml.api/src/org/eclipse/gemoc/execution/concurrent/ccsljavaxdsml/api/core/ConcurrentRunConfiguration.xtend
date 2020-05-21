/** 
 * Copyright (c) 2017 INRIA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * INRIA - initial API and implementation
 * I3S Laboratory - API update and bug fix
 */
package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core

import java.util.List
import org.eclipse.core.runtime.CoreException
import org.eclipse.debug.core.ILaunchConfiguration
import org.eclipse.gemoc.execution.concurrent.engine.strategies.Strategy
import org.eclipse.gemoc.executionframework.engine.core.RunConfiguration
import org.eclipse.xtend.lib.annotations.Accessors

//import org.eclipse.gemoc.executionframework.engine.ui.commons.RunConfiguration;
class ConcurrentRunConfiguration extends RunConfiguration implements IConcurrentRunConfiguration {
	public static final String LAUNCH_SELECTED_DECIDER = "GEMOC_LAUNCH_SELECTED_DECIDER"
	public static final String DECIDER_SOLVER = "Solver decider"
	public static final String DECIDER_ASKUSER_STEP_BY_STEP = "Step by step user decider"
	String _modelInitializationMethod
	String _modelInitializationArguments

	new(ILaunchConfiguration launchConfiguration) throws CoreException {
		super(launchConfiguration)
	}

	override protected void extractInformation() throws CoreException {
		super.extractInformation()
		_deciderName = getAttribute(LAUNCH_SELECTED_DECIDER, "")
		_modelInitializationMethod = getAttribute(LAUNCH_INITIALIZATION_METHOD, "")
		_modelInitializationArguments = getAttribute(LAUNCH_INITIALIZATION_ARGUMENTS, "")
	}

	protected String _deciderName

	override String getDeciderName() {
		return _deciderName
	}

	override String getModelInitializationMethod() {
		return _modelInitializationMethod
	}

	override String getModelInitializationArguments() {
		return _modelInitializationArguments
	}

	@Accessors(PUBLIC_GETTER)
	var List<Strategy> strategies
	
	def getConfigDetailFor(Strategy definition) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}
