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
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.commons;

import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.IConcurrentExecutionPlatform;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dsa.executors.ICodeExecutor;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dse.IMSEStateController;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.extensions.languages.ConcurrentLanguageDefinitionExtension;
import org.eclipse.gemoc.executionframework.engine.commons.DefaultExecutionPlatform;
import org.eclipse.gemoc.xdsmlframework.api.core.IRunConfiguration;

public class DefaultConcurrentExecutionPlatform extends DefaultExecutionPlatform implements IConcurrentExecutionPlatform  {
	
	private ICodeExecutor _codeExecutor;
	//private Collection<IEngineAddon> _addons;
	private Collection<IMSEStateController> _clockControllers;
	
	public DefaultConcurrentExecutionPlatform(ConcurrentLanguageDefinitionExtension _languageDefinition, IRunConfiguration runConfiguration) throws CoreException 
	{
		super(_languageDefinition, runConfiguration);	
		_codeExecutor = _languageDefinition.instanciateCodeExecutor();
		_clockControllers = _languageDefinition.instanciateMSEStateControllers();
		
	}


	@Override
	public ICodeExecutor getCodeExecutor() 
	{
		return _codeExecutor;
	}

//	@Override
//	public Iterable<IEngineAddon> getEngineAddons() 
//	{
//		synchronized(_addonLock)
//		{
//			return Collections.unmodifiableCollection(new ArrayList<IEngineAddon>(_addons));
//		}
//	}

	@Override
	public Collection<IMSEStateController> getMSEStateControllers() 
	{
		return _clockControllers;
	}

	@Override
	public void dispose() 
	{
		super.dispose();
		_clockControllers.clear();
	}

	@Override
	public IConcurrentExecutionPlatform asConcurrentExecutionPlatform() {
		if( this instanceof IConcurrentExecutionPlatform) return this;
		else return null;
	}

//	private Object _addonLock = new Object();
//	
//	@Override
//	public void addEngineAddon(IEngineAddon addon) 
//	{
//		synchronized (_addonLock) 
//		{
//			_addons.add(addon);
//		}
//	}
//
//	@Override
//	public void removeEngineAddon(IEngineAddon addon) 
//	{
//		synchronized (_addonLock) 
//		{
//			_addons.remove(addon);
//		}
//	}
	
}
