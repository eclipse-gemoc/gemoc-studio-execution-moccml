/*******************************************************************************
 *  Copyright (c) 2000, 2017 INRIA and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  IBM - Initial API and implementation
 *  BEA - Daniel R Somerfield - Bug 88939
 *  Remy Chi Jian Suen - Bug 221973
 *******************************************************************************/
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.launcher;

import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.Activator;
import org.eclipse.osgi.util.NLS;

public class MoccmlLauncherMessages extends NLS {
	private static final String BUNDLE_NAME = Activator.PLUGIN_ID+".launcher.LauncherMessages";//$NON-NLS-1$

	

	public static String ConcurrentMainTab_Model_not_specified;
	public static String ConcurrentMainTab_invalid_model_file;
	public static String ConcurrentMainTab_model_doesnt_exist;
	

	public static String ConcurrentMainTab_Language_not_specified;
	public static String ConcurrentMainTab_incompatible_model_extension_for_language;
	public static String ConcurrentMainTab_missing_language;
	public static String ConcurrentMainTab_Invalid_Language_missing_xdsml;
	public static String ConcurrentMainTab_Invalid_Language_missing_xdsml_with_error;



	static {
		// load message values from bundle file
		NLS.initializeMessages(BUNDLE_NAME, MoccmlLauncherMessages.class);
	}


}
