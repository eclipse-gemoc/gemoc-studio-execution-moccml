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
package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.ui.wizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gemoc.commons.eclipse.core.resources.IProjectUtils;
import org.eclipse.gemoc.commons.eclipse.pde.wizards.pages.pde.TemplateListSelectionPage;
import org.eclipse.gemoc.commons.eclipse.pde.wizards.pages.pde.WizardElement;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.ui.Activator;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.ui.builder.MoccmlLanguageProjectNature;
import org.eclipse.pde.internal.ui.elements.ElementList;
import org.eclipse.swt.widgets.Composite;

import fr.inria.diverse.melange.ui.wizards.NewMelangeProjectWizard;
import fr.inria.diverse.melange.ui.wizards.pages.NewMelangeProjectWizardPage;

@SuppressWarnings("restriction")
public class CreateNewGemocConcurrentLanguageProject extends NewMelangeProjectWizard {

	public CreateNewGemocConcurrentLanguageProject() {
		super();
	}

	@Override
	public void addPages() {
		super.addPages();
		
		NewMelangeProjectWizardPage firstPage = (NewMelangeProjectWizardPage) getPage("wizardPage"); 
		firstPage.setTitle("Project");
		firstPage.setDescription("Create a new Gemoc Concurrent Language Project");
		firstPage.updateNameProject("org.mycompany.my_concurrent_language");
	}

	@Override
	public void configureProject(IProject project, IProgressMonitor monitor) {
		super.configureProject(project, monitor);
		try {
			IProjectUtils.addNature(project, MoccmlLanguageProjectNature.NATURE_ID);
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e);
		}
	}
	
	/**
	 * Look for extension point="fr.inria.diverse.commons.eclipse.pde.projectContent"
	 * and filter wizards
	 */
	@Override
	public ElementList getAvailableCodegenWizards() {
		ElementList superRes = super.getAvailableCodegenWizards();
		ElementList newRes = new ElementList("CodegenWizards"); //$NON-NLS-1$
		
		for (Object element : superRes.getChildren()) {
			if(element instanceof WizardElement){
				WizardElement wizardElem = (WizardElement) element;
				if(wizardElem.getID().equals("fr.inria.diverse.melange.ui.templates.projectContent.Concurrent")){
					newRes.add(wizardElem);
				}
			}
		}
		
		return newRes;
	}
	
	@Override
	public void createPageControls(Composite pageContainer) {
		super.createPageControls(pageContainer);
		TemplateListSelectionPage templatesPage = getTemplateListSelectionPage(context);
		templatesPage.setUseTemplate(true);
		templatesPage.selectTemplate("fr.inria.diverse.melange.ui.templates.projectContent.Concurrent");
	}
}






