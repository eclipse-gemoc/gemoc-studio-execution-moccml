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
package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.extensions.languages;

public class MoccmlLanguageDefinitionExtensionPoint
		extends AbstractConcurrentLanguageExtensionPoint<MoccmlLanguageDefinitionExtension> {

	public static final String GEMOC_CONCURRENT_LANGUAGE_EXTENSION_POINT = "org.eclipse.gemoc.gemoc_language_workbench.moccml.xdsml";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_SOLVER_ATT = "solver_class";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_CODEEXECUTOR_ATT = "codeExecutor_class";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_TO_CCSL_QVTO_FILE_PATH_ATT = "toCCSLQVTOFilePath";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_MSE_STATE_CONTROLLER_DEFINITION = "MSE_State_Controller_Definition";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_MSE_STATE_CONTROLLER_CLASS_DEFINITION = "MSE_State_Controller_Class";

	public MoccmlLanguageDefinitionExtensionPoint() {
		super(MoccmlLanguageDefinitionExtension.class);
	}

	@Override
	protected String getExtensionPointName() {
		return GEMOC_CONCURRENT_LANGUAGE_EXTENSION_POINT;
	}

}
