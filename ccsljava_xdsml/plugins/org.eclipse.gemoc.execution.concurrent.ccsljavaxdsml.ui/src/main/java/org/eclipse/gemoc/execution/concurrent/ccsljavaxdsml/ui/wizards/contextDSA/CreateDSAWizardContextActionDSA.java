/*******************************************************************************
 * Copyright (c) 2017 INRIA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     INRIA - initial API and implementation
 *******************************************************************************/
package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.ui.wizards.contextDSA;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.ui.dialogs.SelectDSAIProjectDialog;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;

public class CreateDSAWizardContextActionDSA extends CreateDSAWizardContextBase {

	public CreateDSAWizardContextActionDSA(IProject gemocLanguageIProject) {
		super(gemocLanguageIProject);
	}

	public void createNewDSAProject() {
	}
	
	public void selectExistingDSAProject(){
		// launch the appropriate wizard
		SelectDSAIProjectDialog dialog = new SelectDSAIProjectDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		int res = dialog.open();
		if(res == WizardDialog.OK){
			// update the project model
			addDSAProjectToConf(((IResource)dialog.getResult()[0]).getName());
		}
	}	
	
}
