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

import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.ui.wizards.pages.CreateMOCCWizardPage;
import org.eclipse.jface.wizard.Wizard;

public class CreateMOCCWizard extends Wizard {

	protected CreateMOCCWizardContextAction context;
	

	public CreateMOCCWizard(CreateMOCCWizardContextAction context) {
		super();
		this.setWindowTitle("Create MOCC");
		//context = new CreateDSAWizardContextAction(updatedGemocLanguageProject);
		this.context = context;
		addPage(new CreateMOCCWizardPage("Create MOCC", context));
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
