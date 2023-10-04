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
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.views.stimulimanager;

import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.stimuliscenario.Future;



/**
 * Store the 4 possible states of a Clock:
 * <p> - A clock can be forced to tick or not tick in the future;
 * <br>- A clock not forced can either tick or not tick in the future;
 */
public enum ClockStatus {

	NOTFORCED_SET(false, Future.TICK),
	NOTFORCED_NOTSET(false, Future.NO_TICK),
	FORCED_SET(true, Future.TICK),
	FORCED_NOTSET(true, Future.NO_TICK);
	
	private Boolean isForced;
	private Future future;

	ClockStatus(Boolean isForced, Future future)
	{
		this.isForced = isForced;
		this.future = future;
	}

	public Boolean isForced()
	{
		return isForced;
	}

	public Future getState()
	{
		return future;
	}
	
}
