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
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.views.stimulimanager.scenario;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.Activator;

public class ScenarioException extends CoreException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3981364089352382257L;

	public ScenarioException(String message)
	{
		this(new Status(IStatus.ERROR, Activator.PLUGIN_ID, message));
	}
	
	public ScenarioException(IStatus status) 
	{
		super(status);
	}
	
}
