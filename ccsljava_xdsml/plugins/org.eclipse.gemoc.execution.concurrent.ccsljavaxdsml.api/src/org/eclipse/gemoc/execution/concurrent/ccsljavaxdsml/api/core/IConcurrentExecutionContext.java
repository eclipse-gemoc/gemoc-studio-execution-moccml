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
package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core;

import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.extensions.languages.ConcurrentLanguageDefinitionExtension;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.ActionModel;
import org.eclipse.gemoc.xdsmlframework.api.core.IExecutionContext;
//import org.eclipse.gemoc.xdsmlframework.api.core.IExecutionPlatform;
//import org.eclipse.gemoc.xdsmlframework.api.core.IRunConfiguration;
//import org.eclipse.gemoc.xdsmlframework.api.extensions.languages.LanguageDefinitionExtension;

public interface IConcurrentExecutionContext extends IExecutionContext<IConcurrentRunConfiguration, IConcurrentExecutionPlatform, ConcurrentLanguageDefinitionExtension>
{
//	ConcurrentLanguageDefinitionExtension getConcurrentLanguageDefinitionExtension();
//	IConcurrentExecutionPlatform getConcurrentExecutionPlatform();
	ILogicalStepDecider getLogicalStepDecider();

	ActionModel getFeedbackModel();
	 
}
