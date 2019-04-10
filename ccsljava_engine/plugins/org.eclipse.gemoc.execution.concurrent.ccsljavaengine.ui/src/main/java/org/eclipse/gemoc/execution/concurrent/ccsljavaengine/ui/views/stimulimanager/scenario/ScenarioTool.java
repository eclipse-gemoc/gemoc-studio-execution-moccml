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

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.stimuliscenario.Fragment;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.stimuliscenario.Scenario;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.stimuliscenario.ScenarioFactory;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.stimuliscenario.impl.ScenarioFactoryImpl;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.views.stimulimanager.ModelSpecificEventContext;
import org.eclipse.gemoc.executionframework.engine.core.CommandExecution;

public class ScenarioTool 
{

	protected ModelSpecificEventContext _mseContext;
	protected Scenario _scenario;
	protected Fragment _fragment;
	protected Resource _resource;
	protected ScenarioFactory _factory;
	
	protected ScenarioTool(ModelSpecificEventContext mseContext)
	{
		_mseContext = mseContext;
		_scenario = null;
		_fragment = null;
		_factory = ScenarioFactoryImpl.eINSTANCE;
	}
	
	protected void safeModelModification(final Runnable runnable, String label)
	{
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(_resource);
		RecordingCommand command = new RecordingCommand(editingDomain, label) {
			public void doExecute() {
				runnable.run();
			}
		};
		CommandExecution.execute(editingDomain, command);
	}
	
	public Scenario getScenario()
	{
		return _scenario;
	}
	
	public Fragment getFragment()
	{
		return _fragment;
	}
}
