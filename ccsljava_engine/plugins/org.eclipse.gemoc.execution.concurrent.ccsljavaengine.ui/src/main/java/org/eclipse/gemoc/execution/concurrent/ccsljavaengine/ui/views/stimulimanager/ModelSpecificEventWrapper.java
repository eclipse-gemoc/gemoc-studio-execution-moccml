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

import org.eclipse.gemoc.moccml.mapping.feedback.feedback.ModelSpecificEvent;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.Block;


/**
 *  
 * @author lguillem
 *	First implementation of the clock wrapper. We can access to 
 *	the clock and is state. In the future others features like
 *	statistics (nb of uses,etc ) will be added.
 */
public class ModelSpecificEventWrapper 
{
	private ModelSpecificEvent _mse;
	private ClockStatus _state;
	
	public ModelSpecificEventWrapper(ModelSpecificEvent mse) 
	{
		_mse = mse;
		_state = ClockStatus.NOTFORCED_NOTSET;
	}
	
	public void setState(ClockStatus state)
	{
		_state = state;
	}
	
	public ClockStatus getState()
	{
		return _state;
	}

	public String getClockQualifiedName() 
	{
		Block block = (Block)_mse.eContainer();
		String result = block.getName();
		result += "::";
		result += _mse.getName();
		return result;
	}
	
	public ModelSpecificEvent getMSE() 
	{
		return _mse;
	}
}
