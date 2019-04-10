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
package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.ui.wizards;

import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.ui.wizards.pages.CreateDSAWizardPage;
import org.eclipse.jface.wizard.Wizard;

public class CreateDSAWizard extends Wizard {

	protected CreateDSAWizardContextAction context;
	

	public CreateDSAWizard(CreateDSAWizardContextAction context) {
		super();
		this.setWindowTitle("Create DSA");
		//context = new CreateDSAWizardContextAction(updatedGemocLanguageProject);
		this.context = context;
		addPage(new CreateDSAWizardPage("Create DSA", context));
	}

	@Override
	public void addPages() {
		
		super.addPages();
	}

	@Override
	public boolean performFinish() {
		// do the selected actions now ...
		context.execute();
		return true;
	}
}
