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
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.actions;

import org.eclipse.core.resources.IResource;
import org.eclipse.gemoc.commons.eclipse.ui.dialogs.SelectAnyIFileDialog;
import org.eclipse.jface.dialogs.Dialog;

public class ChooseQVTOAndGenerateExtendedCCSLFile extends GenerateExtendedCCSLFileAction
{

	/**
	 * Constructor for Action1.
	 */
	public ChooseQVTOAndGenerateExtendedCCSLFile() {
		super();
	}

	@Override
	protected String getTransformationURI() {
		SelectAnyIFileDialog dialog = new SelectAnyIFileDialog();
		dialog.setPattern("*.qvto");
		if (dialog.open() == Dialog.OK)
			return "platform:/resource" + ((IResource) dialog.getResult()[0]).getFullPath().toString();
		return null;
	}
	
	@Override
	protected String getMoCFileExtension() {
		return "extendedCCSL";
	}

}
