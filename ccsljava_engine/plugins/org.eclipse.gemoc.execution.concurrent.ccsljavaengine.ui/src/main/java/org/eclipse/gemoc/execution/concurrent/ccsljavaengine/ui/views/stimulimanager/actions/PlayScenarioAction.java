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
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.views.stimulimanager.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.gemoc.commons.eclipse.ui.ViewHelper;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.Activator;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.views.stimulimanager.SelectScenarioFileDialog;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.views.stimulimanager.StimuliManagerView;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.views.stimulimanager.scenario.ScenarioException;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

public class PlayScenarioAction extends Action 
{

	public PlayScenarioAction() 
	{
		setText("Play");
		setToolTipText("Play scenario");
		ImageDescriptor id = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/play-4-16.png");
		setImageDescriptor(id);
	}
	
	@Override
	public void run() 
	{
		StimuliManagerView eventView = ViewHelper.retrieveView(StimuliManagerView.ID);
		if (eventView.getEngine() != null)
		{
			try {
				eventView.playScenario(selectScenario());
			} catch (ScenarioException e) {
				e.printStackTrace();
				eventView.informationMsg("Load Scenario", e.getMessage());
			}				
		}
		else
		{
			eventView.informationMsg("Load Scenario", "Please Select one engine");
		}
	}
	
	private IPath selectScenario()
	{
		SelectScenarioFileDialog selector = new SelectScenarioFileDialog();
		selector.open();
		Object[] selection = selector.getResult();
		IPath path = ((IFile)selection[0]).getLocation();
		return path;
	}
	
}
