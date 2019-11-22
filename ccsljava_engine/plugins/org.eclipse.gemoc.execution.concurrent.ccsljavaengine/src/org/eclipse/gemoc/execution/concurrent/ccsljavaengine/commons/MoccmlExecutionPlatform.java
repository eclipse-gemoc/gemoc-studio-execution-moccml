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
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.commons;

import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.IMoccmlExecutionPlatform;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dse.IMoccmlMSEStateController;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.extensions.languages.MoccmlLanguageAdditionExtension;
import org.eclipse.gemoc.xdsmlframework.api.core.IRunConfiguration;
import org.eclipse.gemoc.xdsmlframework.api.extensions.languages.LanguageDefinitionExtension;

public class MoccmlExecutionPlatform extends CodeExecutorBasedExecutionPlatform implements IMoccmlExecutionPlatform {

	private Collection<IMoccmlMSEStateController> _clockControllers;

	public MoccmlExecutionPlatform(MoccmlLanguageAdditionExtension _moccmlLanguageAddition,
			LanguageDefinitionExtension _languageDefinition, IRunConfiguration runConfiguration) throws CoreException {
		super(_languageDefinition, runConfiguration);
		_clockControllers = _moccmlLanguageAddition.instanciateMSEStateControllers();

	}

	@Override
	public Collection<IMoccmlMSEStateController> getMSEStateControllers() {
		return _clockControllers;
	}

	@Override
	public void dispose() {
		super.dispose();
		_clockControllers.clear();
	}

}
