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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dsa.executors.ICodeExecutor;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dse.IMoccmlMSEStateController;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.moc.ISolver;
import org.eclipse.gemoc.xdsmlframework.api.extensions.Extension;
import org.eclipse.gemoc.xdsmlframework.api.extensions.languages.LanguageDefinitionExtension;
import org.eclipse.gemoc.xdsmlframework.api.extensions.languages.LanguageDefinitionExtensionPoint;

public class MoccmlLanguageAdditionExtension extends Extension {

	public String getName() {
		return getAttribute(MoccmlLanguageAdditionExtensionPoint.MOCCML_LANGUAGE_ADDITION_EXTENSION_POINT_NAME_ATT);
	}

	public String getReferencedXDSMLName() {
		return getAttribute(MoccmlLanguageAdditionExtensionPoint.MOCCML_LANGUAGE_ADDITION_EXTENSION_POINT_REFERENCEDX_XDSML_ATT);
	}
	
	
	public LanguageDefinitionExtension getReferencedXDSMLExtension() {
		return LanguageDefinitionExtensionPoint.findDefinition(getReferencedXDSMLName());
	}
	
	final public ICodeExecutor instanciateCodeExecutor() throws CoreException {
		Object instance = instanciate(MoccmlLanguageAdditionExtensionPoint.MOCCML_LANGUAGE_ADDITION_EXTENSION_POINT_XDSML_DEF_CODEEXECUTOR_ATT);
		if (instance instanceof ICodeExecutor) {
			return (ICodeExecutor) instance;
		}
		throwInstanciationCoreException();
		return null;
	}

	final public ISolver instanciateSolver() throws CoreException {
		Object instance = instanciate(MoccmlLanguageAdditionExtensionPoint.MOCCML_LANGUAGE_ADDITION_EXTENSION_POINT_XDSML_DEF_SOLVER_ATT);
		if (instance instanceof ISolver) {
			return (ISolver) instance;
		}
		throwInstanciationCoreException();
		return null;
	}

	final public String getQVTOPath() {
		return _configurationElement
				.getAttribute(MoccmlLanguageAdditionExtensionPoint.MOCCML_LANGUAGE_ADDITION_EXTENSION_POINT_XDSML_DEF_TO_CCSL_QVTO_FILE_PATH_ATT);
	}

	final public Collection<IMoccmlMSEStateController> instanciateMSEStateControllers() throws CoreException {
		ArrayList<IMoccmlMSEStateController> controllers = new ArrayList<IMoccmlMSEStateController>();
		for (IConfigurationElement childConfElement : _configurationElement
				.getChildren(MoccmlLanguageAdditionExtensionPoint.MOCCML_LANGUAGE_ADDITION_EXTENSION_POINT_MSE_STATE_CONTROLLER_DEFINITION)) {
			childConfElement.getName();
			final Object c = childConfElement
					.createExecutableExtension(MoccmlLanguageAdditionExtensionPoint.MOCCML_LANGUAGE_ADDITION_EXTENSION_POINT_MSE_STATE_CONTROLLER_CLASS_DEFINITION);
			if (c instanceof IMoccmlMSEStateController) {
				controllers.add((IMoccmlMSEStateController) c);
			}
		}
		return controllers;
	}

}
