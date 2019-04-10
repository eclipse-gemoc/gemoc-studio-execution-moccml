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
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.LogicalStepDeciderFactory;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.IConcurrentExecutionContext;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.IConcurrentExecutionPlatform;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.IConcurrentRunConfiguration;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.ILogicalStepDecider;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.extensions.languages.ConcurrentLanguageDefinitionExtension;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.extensions.languages.ConcurrentLanguageDefinitionExtensionPoint;
import org.eclipse.gemoc.executionframework.engine.commons.EngineContextException;
import org.eclipse.gemoc.executionframework.engine.commons.AbstractModelExecutionContext;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.ActionModel;
import org.eclipse.gemoc.trace.commons.model.trace.MSEModel;
import org.eclipse.gemoc.xdsmlframework.api.core.ExecutionMode;


public class ConcurrentModelExecutionContext extends AbstractModelExecutionContext<IConcurrentRunConfiguration,IConcurrentExecutionPlatform,ConcurrentLanguageDefinitionExtension> implements IConcurrentExecutionContext{

	public String alternativeExecutionModelPath = null;
	public ConcurrentModelExecutionContext(IConcurrentRunConfiguration runConfiguration, ExecutionMode executionMode)
			throws EngineContextException
	{
		super(runConfiguration, executionMode);
		try
		{
			_logicalStepDecider = LogicalStepDeciderFactory.createDecider(runConfiguration.getDeciderName(),
					executionMode);
			
		} catch (CoreException e)
		{
			EngineContextException exception = new EngineContextException(
					"Cannot initialize the execution context, see inner exception.", e);
			throw exception;
		}
		
	}

	
	@Override
	protected IConcurrentExecutionPlatform createExecutionPlatform() throws CoreException{
			return new DefaultConcurrentExecutionPlatform((ConcurrentLanguageDefinitionExtension)_languageDefinition, _runConfiguration);
	}
	
	@Override
	protected ConcurrentLanguageDefinitionExtension getLanguageDefinition(String languageName) throws EngineContextException
	{
		ConcurrentLanguageDefinitionExtension languageDefinition = ConcurrentLanguageDefinitionExtensionPoint
				.findDefinition(_runConfiguration.getLanguageName());
		if (languageDefinition == null)
		{
			String message = "Cannot find concurrent xdsml definition for the language " + _runConfiguration.getLanguageName()
					+ ", please verify that is is correctly deployed.";
			EngineContextException exception = new EngineContextException(message);
			throw exception;
		}
		return languageDefinition;
	}

	public void setUpMSEModel()
	{
		URI msemodelPlatformURI = URI.createPlatformResourceURI(getWorkspace().getMSEModelPath().removeFileExtension().addFileExtension("msemodel").toString(),
				true);
		try
		{
			Resource resource = this.getResourceModel().getResourceSet().getResource(msemodelPlatformURI, true);
			_mseModel = (MSEModel) resource.getContents().get(0);
		} catch (Exception e)
		{
			// file will be created later
		}
	}
	public void setUpFeedbackModel()
	{
		URI feedbackPlatformURI = URI.createPlatformResourceURI(getWorkspace().getMSEModelPath().removeFileExtension().addFileExtension("feedback").toString(),
				true);
		try
		{
			Resource resource = this.getResourceModel().getResourceSet().getResource(feedbackPlatformURI, true);
			_feedbackModel = (ActionModel) resource.getContents().get(0);
		} catch (Exception e)
		{
			// file will be created later
		}
	}
	
	@Override
	public void dispose()
	{
		super.dispose();
		_logicalStepDecider.dispose();
	}

	
	protected ActionModel _feedbackModel;
//
//	@Override
//	public ActionModel getFeedbackModel()
//	{
//		if(_feedbackModel == null){
//			setUpFeedbackModel();
//		}
//		return _feedbackModel;
//	}
//	
//
	protected ILogicalStepDecider _logicalStepDecider;
//
//	@Override
//	public ILogicalStepDecider getLogicalStepDecider() {
//		return _logicalStepDecider;
//	}
//
//	@Override
//	public IConcurrentExecutionPlatform getConcurrentExecutionPlatform() {
//		if(getExecutionPlatform() instanceof IConcurrentExecutionPlatform) return (IConcurrentExecutionPlatform) getExecutionPlatform();
//		else return null;
//	}
//
//	@Override
//	public ConcurrentLanguageDefinitionExtension getConcurrentLanguageDefinitionExtension() {
//		if(getLanguageDefinitionExtension() instanceof ConcurrentLanguageDefinitionExtension) return (ConcurrentLanguageDefinitionExtension) getLanguageDefinitionExtension();
//		return null;
//	}


	protected MSEModel _mseModel;
	
	@Override
	public MSEModel getMSEModel() {
		if(_mseModel == null){
			setUpMSEModel();
		}
		return _mseModel;
	}


	@Override
	public ILogicalStepDecider getLogicalStepDecider() {
		return _logicalStepDecider;
	}


	@Override
	public ActionModel getFeedbackModel() {
		return _feedbackModel;
	}




	




}
