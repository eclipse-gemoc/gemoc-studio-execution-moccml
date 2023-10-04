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

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.stimuliscenario.EventState;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.stimuliscenario.ExecutionStep;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.stimuliscenario.Reference;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.Activator;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.views.stimulimanager.ClockStatus;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.views.stimulimanager.ModelSpecificEventContext;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.views.stimulimanager.ModelSpecificEventWrapper;

public class ScenarioRecorder extends ScenarioTool
{
	public ScenarioRecorder(ModelSpecificEventContext mseContext)
	{
		super(mseContext);
	}

	private void createResource() 
	{
		ResourceSet rs = _mseContext.getEngine().getExecutionContext().getResourceModel().getResourceSet(); 				
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss");
		String fileName = format.format(new Date()) + ".scenario";
		URI uri = URI.createURI("platform:/resource" 
				+ _mseContext.getEngine().getExecutionContext().getWorkspace().getExecutionPath().append(fileName).toString());
		_resource = rs.createResource(uri);
	}

	private void createScenario()
	{
		Runnable runnable = new Runnable() 
		{
			public void run() 
			{
				_scenario = _factory.createScenario();
				_resource.getContents().add(_scenario);
				save();
			}
		};
		safeModelModification(runnable, "create scenario");
	}

	public void startRecord()
	{
		if(_scenario == null)
		{	
			createResource();
			createScenario();
		}
		Runnable runnable = new Runnable() 
		{
			public void run() {
				List<Reference> refList = _scenario.getRefList();
				Reference ref = _factory.createReference();
				ref.setStartStep((int) _mseContext.getEngine().getEngineStatus().getNbLogicalStepRun());
				refList.add(ref);
				_fragment = _factory.createFragment();
				ref.setFragment(_fragment);
			}
		};
		safeModelModification(runnable, "start record scenario");	
	}

	public void record()
	{
		Runnable runnable = new Runnable() 
		{
			public void run() {

				List<ExecutionStep> stepList =  _fragment.getStepList();
				ExecutionStep newStep = _factory.createExecutionStep();
				List<EventState> newListEvent = newStep.getEventList();
				for(ModelSpecificEventWrapper cw: _mseContext.getMSEs())
				{
					ClockStatus state = cw.getState();
					boolean isForced = state.isForced();
					if(isForced)
					{
						EventState newState = _factory.createEventState();
						newState.setMse(cw.getMSE());
						newState.setState(state.getState());
						newListEvent.add(newState);
					} 

				}
				stepList.add(newStep);

				save();
			}
		};
		safeModelModification(runnable, "record scenario");			
	}		


	protected void save()
	{
		try 
		{
			_resource.save(null);
		} 
		catch (IOException e) {
			String message = "Cannot save scenario, see inner exception";
			Activator.getDefault().error(message, e);
		}
	}
}
