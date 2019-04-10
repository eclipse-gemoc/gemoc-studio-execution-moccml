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

import org.eclipse.gemoc.commons.eclipse.ui.ViewHelper;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.Activator;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.views.stimulimanager.StimuliManagerView;
import org.eclipse.gemoc.xdsmlframework.api.core.EngineStatus.RunStatus;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

public class RecordScenarioAction extends Action {

	public RecordScenarioAction()
	{
		setText("Record");
		setToolTipText("Record scenario");
		ImageDescriptor id = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/media-record.png");
		setImageDescriptor(id);
	}
	
	@Override
	public void run() {
		StimuliManagerView eventView = ViewHelper.retrieveView(StimuliManagerView.ID);
		if(eventView.getEngine()!=null &&
		   !eventView.getEngine().getRunningStatus().equals(RunStatus.Stopped))
		{
			eventView.startRecordScenario();
		}
		else
		{
			eventView.informationMsg("Record Scenario", "Operation not possible, please select an engine");
		}			
	}	
	
}
