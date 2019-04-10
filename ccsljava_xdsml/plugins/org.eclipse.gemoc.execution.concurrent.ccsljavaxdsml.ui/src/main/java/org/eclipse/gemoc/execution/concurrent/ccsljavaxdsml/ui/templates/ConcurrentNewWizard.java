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
package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.ui.templates;

import org.eclipse.gemoc.commons.eclipse.pde.wizards.pages.pde.ui.BaseProjectWizardFields;
import org.eclipse.gemoc.commons.eclipse.pde.wizards.pages.pde.ui.templates.ITemplateSection;

import fr.inria.diverse.melange.ui.templates.melange.SimpleMTNewWizard;

public class ConcurrentNewWizard extends SimpleMTNewWizard{

	@Override
	public void init(BaseProjectWizardFields data) {
		super.init(data);
		setWindowTitle("Simple concurrent GEMOC project");
	}
	
	@Override
	public ITemplateSection[] createTemplateSections() {
		return new ITemplateSection[] {new ConcurrentTemplate()};
	}
}
