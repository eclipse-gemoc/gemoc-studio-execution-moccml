package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.commons;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.deciders.LogicalStepDeciderFactory;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.IMoccmlRunConfiguration;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.extensions.languages.MoccmlLanguageDefinitionExtension;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.extensions.languages.MoccmlLanguageDefinitionExtensionPoint;
import org.eclipse.gemoc.executionframework.engine.commons.EngineContextException;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.ActionModel;
import org.eclipse.gemoc.xdsmlframework.api.core.ExecutionMode;

public class MoccmlModelExecutionContext extends
		BaseConcurrentModelExecutionContext<IMoccmlRunConfiguration, MoccmlExecutionPlatform, MoccmlLanguageDefinitionExtension> {

	public MoccmlModelExecutionContext(IMoccmlRunConfiguration runConfiguration, ExecutionMode executionMode)
			throws EngineContextException {
		super(runConfiguration, executionMode);
	}

	protected ActionModel _feedbackModel;
	public String alternativeExecutionModelPath = null;

	public ActionModel getFeedbackModel() {
		return _feedbackModel;
	}

	public void setUpFeedbackModel() {
		URI feedbackPlatformURI = URI.createPlatformResourceURI(
				getWorkspace().getMSEModelPath().removeFileExtension().addFileExtension("feedback").toString(), true);
		try {
			Resource resource = this.getResourceModel().getResourceSet().getResource(feedbackPlatformURI, true);
			_feedbackModel = (ActionModel) resource.getContents().get(0);
		} catch (Exception e) {
			// file will be created later
		}
	}

	@Override
	protected MoccmlLanguageDefinitionExtension getLanguageDefinition(String languageName)
			throws EngineContextException {
		MoccmlLanguageDefinitionExtension languageDefinition = new MoccmlLanguageDefinitionExtensionPoint()
				.findDefinition(languageName);
		if (languageDefinition == null) {
			String message = "Cannot find concurrent xdsml definition for the language "
					+ _runConfiguration.getLanguageName() + ", please verify that is is correctly deployed.";
			throw new EngineContextException(message);
		}
		return languageDefinition;
	}

	@Override
	protected MoccmlExecutionPlatform createExecutionPlatform() throws CoreException {
		MoccmlLanguageDefinitionExtension moccmlLangDef;
		try {
			moccmlLangDef = getLanguageDefinition(this._runConfiguration.getLanguageName());
			MoccmlExecutionPlatform platform = new MoccmlExecutionPlatform(moccmlLangDef, _runConfiguration);
			platform.setCodeExecutor(moccmlLangDef.instanciateCodeExecutor());
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
