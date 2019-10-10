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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.deciders.ILogicalStepDecider;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.deciders.LogicalStepDeciderFactory;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.IConcurrentRunConfiguration;
import org.eclipse.gemoc.executionframework.engine.commons.AbstractModelExecutionContext;
import org.eclipse.gemoc.executionframework.engine.commons.EngineContextException;
import org.eclipse.gemoc.trace.commons.model.trace.MSEModel;
import org.eclipse.gemoc.xdsmlframework.api.core.ExecutionMode;
import org.eclipse.gemoc.xdsmlframework.api.core.IExecutionPlatform;
import org.eclipse.gemoc.xdsmlframework.api.extensions.languages.LanguageDefinitionExtension;

public abstract class ConcurrentModelExecutionContext<R extends IConcurrentRunConfiguration, P extends IExecutionPlatform, L extends LanguageDefinitionExtension>
		extends AbstractModelExecutionContext<R, P, L>  {

	public ConcurrentModelExecutionContext(R runConfiguration, ExecutionMode executionMode)
			throws EngineContextException {
		super(runConfiguration, executionMode);
		try {
			_logicalStepDecider = LogicalStepDeciderFactory.createDecider(runConfiguration.getDeciderName(),
					executionMode);

		} catch (CoreException e) {
			EngineContextException exception = new EngineContextException(
					"Cannot initialize the execution context, see inner exception.", e);
			throw exception;
		}

	}

	public void setUpMSEModel() {
		URI msemodelPlatformURI = URI.createPlatformResourceURI(
				getWorkspace().getMSEModelPath().removeFileExtension().addFileExtension("msemodel").toString(), true);
		try {
			Resource resource = this.getResourceModel().getResourceSet().getResource(msemodelPlatformURI, true);
			_mseModel = (MSEModel) resource.getContents().get(0);
		} catch (Exception e) {
			// file will be created later
		}
	}

	@Override
	public void dispose() {
		super.dispose();
		_logicalStepDecider.dispose();
	}

	protected ILogicalStepDecider _logicalStepDecider;

	protected MSEModel _mseModel;

	@Override
	public MSEModel getMSEModel() {
		if (_mseModel == null) {
			setUpMSEModel();
		}
		return _mseModel;
	}

	public ILogicalStepDecider getLogicalStepDecider() {
		return _logicalStepDecider;
	}

}
