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

import org.eclipse.core.runtime.IPath;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.views.stimulimanager.ModelSpecificEventContext;

public class ScenarioManager 
{
	private ScenarioRecorder _recorder;
	
	private ScenarioPlayer _player;
	
	/**
	 * Link with the corresponding engine cache for recording and playing
	 * operations.
	 */
	private ModelSpecificEventContext _mseContext;

	public ScenarioManager(ModelSpecificEventContext mseContext)
	{
		_mseContext = mseContext;
	}
		
	private ScenarioManagerState _state = ScenarioManagerState.Idle;
	
	public ScenarioManagerState getState()
	{
		return _state;
	}
	
	/**
	 * The scenario recorder is called and prepare the record. 
	 * <p>Record mode is set.
	 */
	public void startRecord()
	{
		_state = ScenarioManagerState.Recording;
		_recorder = new ScenarioRecorder(_mseContext);
		/* The scenario recorder begin the preparation for recording future steps.		*/
		_recorder.startRecord();
	}
	
	public void record()
	{
		if (_recorder != null)
		{
			_recorder.record();
		}
	}
	
	/**
	 * The cache state is reset to idle mode.
	 */
	public void stopRecord()
	{
		_state = ScenarioManagerState.Idle;
	}
	
	public void startPlaying(IPath path)
	{
		_state = ScenarioManagerState.Playing;
		_player = new ScenarioPlayer(_mseContext);
		_player.load(path);
		play();
	}
	
	public void play()
	{
		if (_player != null)
		{
			try
			{
				if (!_player.play())
				{
					stopPlaying();
				}
			}
			catch (ScenarioException e)
			{
				stopPlaying();
			}
		}
	}
	
	/**
	 * The state is reset to idle mode and scenario player is reset. 
	 */
	public void stopPlaying()
	{
		if (_player != null)
		{
			_player.stop();
		}
		_state = ScenarioManagerState.Idle;
	}

	
	public ModelSpecificEventContext getCache()
	{
		return _mseContext;
	}
		
}
