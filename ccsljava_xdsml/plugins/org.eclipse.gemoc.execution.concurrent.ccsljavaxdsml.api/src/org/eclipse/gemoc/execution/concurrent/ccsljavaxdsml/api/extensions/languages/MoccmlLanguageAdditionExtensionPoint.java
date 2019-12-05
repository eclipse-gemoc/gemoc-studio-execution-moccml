/*******************************************************************************
 * Copyright (c) 2017, 2019 INRIA and others.
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

import java.util.Collection;

import org.eclipse.gemoc.xdsmlframework.api.extensions.ExtensionPoint;

public class MoccmlLanguageAdditionExtensionPoint extends ExtensionPoint<MoccmlLanguageAdditionExtension> {

	public static final String MOCCML_LANGUAGE_ADDITION_EXTENSION_POINT = "org.eclipse.gemoc.gemoc_language_workbench.moccml.xdsml.addition";
	public static final String MOCCML_LANGUAGE_ADDITION_EXTENSION_POINT_ADDITION_DEF = "MOCCML_XDSML_Addition";
	public static final String MOCCML_LANGUAGE_ADDITION_EXTENSION_POINT_NAME_ATT = "name";
	public static final String MOCCML_LANGUAGE_ADDITION_EXTENSION_POINT_REFERENCEDX_XDSML_ATT = "referencedXDSMLName";
	public static final String MOCCML_LANGUAGE_ADDITION_EXTENSION_POINT_XDSML_DEF_SOLVER_ATT = "solver_class";
	public static final String MOCCML_LANGUAGE_ADDITION_EXTENSION_POINT_XDSML_DEF_CODEEXECUTOR_ATT = "codeExecutor_class";
	public static final String MOCCML_LANGUAGE_ADDITION_EXTENSION_POINT_XDSML_DEF_TO_CCSL_QVTO_FILE_PATH_ATT = "toCCSLQVTOFilePath";
	public static final String MOCCML_LANGUAGE_ADDITION_EXTENSION_POINT_MSE_STATE_CONTROLLER_DEFINITION = "MSE_State_Controller_Definition";
	public static final String MOCCML_LANGUAGE_ADDITION_EXTENSION_POINT_MSE_STATE_CONTROLLER_CLASS_DEFINITION = "MSE_State_Controller_Class";

	public MoccmlLanguageAdditionExtensionPoint() {
		super(MoccmlLanguageAdditionExtension.class);
	}

	@Override
	protected String getExtensionPointName() {
		return MOCCML_LANGUAGE_ADDITION_EXTENSION_POINT;
	}

	private static MoccmlLanguageAdditionExtensionPoint _singleton;

	private static MoccmlLanguageAdditionExtensionPoint getExtensionPoint() {
		if (_singleton == null) {
			_singleton = new MoccmlLanguageAdditionExtensionPoint();
		}
		return _singleton;
	}

	static public Collection<MoccmlLanguageAdditionExtension> getSpecifications() {
		return getExtensionPoint().internal_getSpecifications();
	}

	/**
	 * find in the declared extension point the first MOCCML XDSMl Addition with the given name (usually the same as the referencedXDSML)
	 * @param additionName
	 * @return
	 */
	static public MoccmlLanguageAdditionExtension findMoccmlLanguageAddition(String additionName) {
		for (MoccmlLanguageAdditionExtension extension : getSpecifications()) {
			if (extension.getName().equals(additionName)) {
				return extension;
			}
		}
		return null;
	}
	
	
	/**
	 * find in the declared extension points the first MOCCML XDSMl Addition referencing the given XDSML language
	 * @param additionName
	 * @return
	 */
	static public MoccmlLanguageAdditionExtension findMoccmlLanguageAdditionForLanguage(String xdsmlName) {
		for (MoccmlLanguageAdditionExtension extension : getSpecifications()) {
			if (extension.getReferencedXDSMLName().equals(xdsmlName)) {
				return extension;
			}
		}
		return null;
	}

}
