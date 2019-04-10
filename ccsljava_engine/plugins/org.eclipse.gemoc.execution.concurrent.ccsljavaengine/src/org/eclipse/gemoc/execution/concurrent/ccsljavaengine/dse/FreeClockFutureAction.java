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
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.dse;

import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.IFutureAction;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dse.IMSEStateController;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.ModelSpecificEvent;

public class FreeClockFutureAction implements IFutureAction
{

	private ModelSpecificEvent _mseToBeForced;
	private ModelSpecificEvent _triggeringMSE;
	private IMSEStateController _clockController;
	
	public FreeClockFutureAction(ModelSpecificEvent mseToBeForced, ModelSpecificEvent triggeringMSE, IMSEStateController clockController) 
	{
		_mseToBeForced = mseToBeForced;
		_triggeringMSE = triggeringMSE;
		_clockController = clockController;
	}

	@Override
	public ModelSpecificEvent getTriggeringMSE() 
	{
		return _triggeringMSE;
	}

	@Override
	public void perform() 
	{
		_clockController.freeInTheFuture(_mseToBeForced);
	}

}
