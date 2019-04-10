/*******************************************************************************
 * Copyright (c) 2017 Inria and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.ui.templates;

import org.eclipse.osgi.util.NLS;

public class WizardTemplateMessages extends NLS {
//	private static final String BUNDLE_NAME = "/org.eclipse.gemoc.execution.sequential.javaxdsml.ide.ui.templates.resources"; //$NON-NLS-1$

	static {
		// load message values from bundle file
		//NLS.initializeMessages(BUNDLE_NAME, WizardTemplateMessages.class);
	}
		
	public static String FirstCharUpperError;


	
	// ConcurrentLanguage constants
	public static String ConcurrentLanguageTemplate_packageName = "Package name";
	public static String ConcurrentLanguageTemplate_packageNameToolTip = "Enter the name of the concurrent project package name";
	public static String ConcurrentLanguageTemplate_melangeFileName = "Melange file name";
	public static String ConcurrentLanguageTemplate_melangeFileNameTooltip = "should not be used";
	public static String ConcurrentLanguageTemplate_melangeDefaultFileName = "myConcurrentLanguage";
	public static String ConcurrentLanguageTemplate_melangeMetamodelName = "";
	public static String ConcurrentLanguageTemplate_melangeMetamodelNameToolTip = "";
	public static String ConcurrentLanguageTemplate_ecoreFileLocation ="ecore location";
	public static String ConcurrentLanguageTemplate_ecoreFileLocationTooltip= "choose your ecore location";
	public static String ConcurrentLanguageTemplate_dsaProjectName = "DSA project";
	public static String ConcurrentLanguageTemplate_dsaProjectNameTooltip = "choose your DSA project";
	public static String ConcurrentLanguageTemplate_title = "title ?";
	public static String ConcurrentLanguageTemplate_desc = "description ?";
	public static String ConcurrentLanguageTemplate_wtitle = "wtitle ?";



	public static String ConcurrentLanguageTemplate_eclFileLocation = "moccml mapping file";
	public static String ConcurrentLanguageTemplate_eclFileLocationTooltip = "choose the ECL used to specify the concurrency";

	

}