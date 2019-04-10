///*******************************************************************************
// * Copyright (c) 2017 INRIA and others.
// * All rights reserved. This program and the accompanying materials
// * are made available under the terms of the Eclipse Public License v1.0
// * which accompanies this distribution, and is available at
// * http://www.eclipse.org/legal/epl-v10.html
// *
// * Contributors:
// *     INRIA - initial API and implementation
// *******************************************************************************/
//package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.ui.commands;
//
//import org.eclipse.core.commands.ExecutionEvent;
//import org.eclipse.core.commands.ExecutionException;
//import org.eclipse.core.commands.IHandler;
//import org.eclipse.core.resources.IProject;
//import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.ui.wizards.CreateMOCCWizardContextAction;
//import org.eclipse.gemoc.xdsmlframework.ide.ui.commands.AbstractDslSelectHandler;
//
//
//public class CreateMOCCProjectHandler extends AbstractDslSelectHandler implements IHandler {
//
//	@Override
//	public Object executeForSelectedLanguage(ExecutionEvent event, IProject updatedGemocLanguageProject,
//			String language) throws ExecutionException {
//
//		CreateMOCCWizardContextAction action = new CreateMOCCWizardContextAction(
//				updatedGemocLanguageProject,
//				language);
//		action.actionToExecute = CreateMOCCWizardContextAction.CreateMOCCAction.CREATE_NEW_MOCC_PROJECT;
//		action.execute();
//		return null;
//	}
//
//	@Override
//	public String getSelectionMessage() {
//		return "Select Language that is used to initialize the MOC creation wizard";
//	}
//
//}
