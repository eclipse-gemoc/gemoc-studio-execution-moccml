package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.commons;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.IMoccmlExecutionPlatform;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dsa.executors.ICodeExecutor;
import org.eclipse.gemoc.executionframework.engine.commons.DefaultExecutionPlatform;
import org.eclipse.gemoc.xdsmlframework.api.core.IRunConfiguration;
import org.eclipse.gemoc.xdsmlframework.api.extensions.languages.LanguageDefinitionExtension;

public class CodeExecutorBasedExecutionPlatform extends DefaultExecutionPlatform {

	protected ICodeExecutor _codeExecutor;

	public CodeExecutorBasedExecutionPlatform(LanguageDefinitionExtension _languageDefinition,
			IRunConfiguration runConfiguration) throws CoreException {
		super(_languageDefinition, runConfiguration);
	}

	public ICodeExecutor getCodeExecutor() {
		return _codeExecutor;
	}

}