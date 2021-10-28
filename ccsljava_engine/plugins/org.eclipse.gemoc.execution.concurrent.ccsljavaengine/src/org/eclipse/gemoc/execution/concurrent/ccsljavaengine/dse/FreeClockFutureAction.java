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

import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dse.IMoccmlFutureAction;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dse.IMoccmlMSEStateController;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.ModelSpecificEvent;

public class FreeClockFutureAction implements IMoccmlFutureAction
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1600863389578532939L;
	private String _mseToBeForcedURI;
	private String _triggeringMSEURI;
	
	public FreeClockFutureAction(String mseToBeForcedURI, String triggeringMSEURI) 
	{
		_mseToBeForcedURI = mseToBeForcedURI;
		_triggeringMSEURI = triggeringMSEURI;
	}

	@Override
	public String getTriggeringMSEURI() 
	{
		return _triggeringMSEURI;
	}
	
	@Override
	public String getMseToBeForcedURI() 
	{
		return _mseToBeForcedURI;
	}

	@Override
	public void perform(IMoccmlMSEStateController controler) 
	{
		controler.freeInTheFuture(_mseToBeForcedURI);
	}

}
