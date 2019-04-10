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
//package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.ui.editor;
//
//import org.eclipse.core.resources.IProject;
//import org.eclipse.core.resources.IResource;
//import org.eclipse.emf.ecore.EObject;
//import org.eclipse.gemoc.commons.eclipse.core.resources.FileFinderVisitor;
//import org.eclipse.gemoc.commons.eclipse.ui.dialogs.SelectSpecificFileDialog;
//import org.eclipse.jface.dialogs.Dialog;
//
////import fr.inria.diverse.melange.ui.contentassist.IProposal;
//
//public class SelectEclProposal implements IProposal{
//	
//	class SelectEclIFileDialog extends SelectSpecificFileDialog {
//		public FileFinderVisitor instanciateFinder() {
//			return new FileFinderVisitor("ecl");
//		}
//	}
//
//	@Override
//	public String getDisplayText() {
//		return "-- Select an existing ECL file --";
//	}
//
//	@Override
//	public String getReplacementText() {
//		SelectEclIFileDialog dialog = new SelectEclIFileDialog();
//		if (dialog.open() == Dialog.OK) {
//			Object[] selections = dialog.getResult();
//			if(selections != null 
//				&& selections.length != 0
//				&& selections[0] instanceof IResource 
//			){
//				IResource eclFile = (IResource) selections[0];
//				String replacementText = "\"/"+eclFile.getProject().getName() +"/"+eclFile.getProjectRelativePath()+"\"";
//				return replacementText;
//			}
//		}
//		return "";
//	}
//
//	@Override
//	public void configureProject(IProject project) {
//		// TODO Auto-generated method stub
//	}
//
//	@Override
//	public void configureProposal(EObject context) {
//		// TODO Auto-generated method stub
//	}
//
//}
