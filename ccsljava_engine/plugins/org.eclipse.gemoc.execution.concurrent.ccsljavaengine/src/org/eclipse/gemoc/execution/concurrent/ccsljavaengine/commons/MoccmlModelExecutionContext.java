/*******************************************************************************
 * Copyright (c) 2017, 2019 INRIA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     INRIA - initial API and implementation
 *******************************************************************************/
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.commons;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.deciders.LogicalStepDeciderFactory;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.IMoccmlRunConfiguration;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.extensions.languages.MoccmlLanguageAdditionExtension;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.extensions.languages.MoccmlLanguageAdditionExtensionPoint;
import org.eclipse.gemoc.executionframework.engine.commons.EngineContextException;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.ActionModel;
import org.eclipse.gemoc.xdsmlframework.api.core.ExecutionMode;
import org.eclipse.gemoc.xdsmlframework.api.extensions.languages.LanguageDefinitionExtension;
import org.eclipse.gemoc.xdsmlframework.api.extensions.languages.LanguageDefinitionExtensionPoint;

public class MoccmlModelExecutionContext extends
		BaseConcurrentModelExecutionContext<IMoccmlRunConfiguration, MoccmlExecutionPlatform, LanguageDefinitionExtension> {

	

	protected ActionModel _feedbackModel;
	protected String moccmlscenarioModelPath = null;
	public boolean hasARegisteredScenario = false;
	
	protected MoccmlLanguageAdditionExtension _moccmlLanguageAdditionExtension;

	public MoccmlModelExecutionContext(IMoccmlRunConfiguration runConfiguration, ExecutionMode executionMode)
			throws EngineContextException {
		super(runConfiguration, executionMode);
		_moccmlLanguageAdditionExtension = this.getMoccmlLanguageAddition(runConfiguration.getLanguageName());
		moccmlscenarioModelPath = runConfiguration.getMoccmlScenarioModelPath();
		if (moccmlscenarioModelPath.length() > 1) {
			hasARegisteredScenario = true;
		}

	}
	
	public ActionModel getFeedbackModel() {
		return _feedbackModel;
	}
	
	public String getMoccmlscenarioModelPath() {
		return moccmlscenarioModelPath;
	}

	public void setMoccmlscenarioModelPath(String moccmlscenarioModelPath) {
		this.moccmlscenarioModelPath = moccmlscenarioModelPath;
	}


	public Resource setUpFeedbackModel() {
		URI feedbackPlatformURI = URI.createPlatformResourceURI(
				getWorkspace().getMSEModelPath().removeFileExtension().addFileExtension("feedback").toString(), true);
		try {
			Resource resource = this.getResourceModel().getResourceSet().getResource(feedbackPlatformURI, true);
			_feedbackModel = (ActionModel) resource.getContents().get(0);
			return resource;
		} catch (Exception e) {
			// file will be created later
		}
		return null;
	}

	@Override
	protected LanguageDefinitionExtension getLanguageDefinitionExtension(String languageName)
			throws EngineContextException {
		LanguageDefinitionExtension languageDefinition = LanguageDefinitionExtensionPoint.findDefinition(languageName);
		if (languageDefinition == null) {
			String message = "Cannot find xdsml definition for the language "
					+ _runConfiguration.getLanguageName() + ", please verify that is is correctly deployed.";
			throw new EngineContextException(message);
		}
		return languageDefinition;
	}
	
	public MoccmlLanguageAdditionExtension getMoccmlLanguageAddition(String languageName)
			throws EngineContextException {
		MoccmlLanguageAdditionExtension languageAddition = MoccmlLanguageAdditionExtensionPoint.findMoccmlLanguageAdditionForLanguage(languageName);
		if (languageAddition == null) {
			String message = "Cannot find moccml addition for the language "
					+ _runConfiguration.getLanguageName() + ", please verify that is is correctly deployed.";
			throw new EngineContextException(message);
		}
		return languageAddition;
	}

	public MoccmlLanguageAdditionExtension getMoccmlLanguageAdditionExtension() {
		return _moccmlLanguageAdditionExtension;
	}

	@Override
	protected MoccmlExecutionPlatform createExecutionPlatform() throws CoreException {
		try {
			LanguageDefinitionExtension moccmlLangDef = getLanguageDefinitionExtension(this._runConfiguration.getLanguageName());
			MoccmlLanguageAdditionExtension languageAddition = getMoccmlLanguageAddition(this._runConfiguration.getLanguageName());
			MoccmlExecutionPlatform platform = new MoccmlExecutionPlatform(languageAddition, moccmlLangDef, _runConfiguration);
			platform.setCodeExecutor(languageAddition.instanciateCodeExecutor());
			return platform;
		} catch (EngineContextException e) {
			// TODO avoid runtime exception
			throw new RuntimeException(e);
		}
	}

	@Override
	protected String getDefaultRunDeciderName() {
		return LogicalStepDeciderFactory.DECIDER_SOLVER;
	}

}
