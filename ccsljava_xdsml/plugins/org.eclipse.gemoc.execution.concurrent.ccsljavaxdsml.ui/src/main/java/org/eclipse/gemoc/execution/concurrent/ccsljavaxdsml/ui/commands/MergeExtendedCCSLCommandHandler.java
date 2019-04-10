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
package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.ui.commands;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gemoc.commons.eclipse.resource.merging.ActionContext;
import org.eclipse.gemoc.commons.eclipse.resource.merging.IBeforeSavingAction;
import org.eclipse.gemoc.commons.eclipse.resource.merging.ResourcesMergerScript;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockConstraintSystem;

public class MergeExtendedCCSLCommandHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		if (selection != null 
			&& selection instanceof IStructuredSelection) {
			IStructuredSelection structeredSelection = (IStructuredSelection) selection;
			for(Object o : structeredSelection.toList()) 
			{
				if (o instanceof IFile) 
				{
					IFile inputFile = (IFile)o;
					merge(inputFile);
				}
			}
		}
		return null;
	}

	private void merge(IFile inputFile) throws ExecutionException {
		IPath outputFilePath = inputFile.getProjectRelativePath().removeFileExtension().addFileExtension("xmi");
		IFile outputFile = inputFile.getProject().getFile(outputFilePath);
		try {
			ResourcesMergerScript
				.allResourcesFrom(inputFile)
				.mergeInto(outputFile)
				.beforeSavingPerform(removeImports())
				.go();
		} catch (IOException e) {
			e.printStackTrace();
			throw new ExecutionException("Impossible to perform resource merging", e);
		}
	}

	private IBeforeSavingAction removeImports() {
		return new IBeforeSavingAction() {
			@Override
			public void run(ActionContext context) {
				for(EObject o : context.getResource().getContents()) {
					if (o instanceof ClockConstraintSystem) {
						ClockConstraintSystem system = (ClockConstraintSystem)o;
						system.getImports().clear();
					}
				}
			}
		};
	}


}
