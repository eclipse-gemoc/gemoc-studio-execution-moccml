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
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.timesquare;

import org.eclipse.gemoc.commons.eclipse.logging.backends.DefaultLoggingBackend;
import org.eclipse.gemoc.commons.eclipse.messagingsystem.api.MessagingSystem;
import org.eclipse.gemoc.commons.eclipse.messagingsystem.api.MessagingSystemManager;
import org.eclipse.gemoc.commons.eclipse.pde.GemocPlugin;
import org.osgi.framework.BundleContext;


public class Activator extends GemocPlugin {

	private static BundleContext context;

	public static BundleContext getContext() {
		return context;
	}
	
	public static final String PLUGIN_ID = "org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.timesquare"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext bundleContext) throws Exception {
		super.start(bundleContext);
		context = bundleContext;
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	private DefaultLoggingBackend _loggingBackend;
	
	@Override
	public DefaultLoggingBackend resolveLoggingBackend() 
	{
		if (_loggingBackend == null)
		{
			_loggingBackend = new DefaultLoggingBackend(this);
			MessagingSystemManager msm = new MessagingSystemManager();
			// use the baseMessageGroup of the engine in order to share consoles instead of duplicating them
			MessagingSystem ms = msm.createBestPlatformMessagingSystem(
					org.eclipse.gemoc.executionframework.engine.Activator.PLUGIN_ID, 
					org.eclipse.gemoc.executionframework.engine.Activator.CONSOLE_NAME);
			_loggingBackend.setMessagingSystem(ms);
		}
		return _loggingBackend;
	}

	@Override
	public String getId() 
	{
		return PLUGIN_ID;
	}

}
