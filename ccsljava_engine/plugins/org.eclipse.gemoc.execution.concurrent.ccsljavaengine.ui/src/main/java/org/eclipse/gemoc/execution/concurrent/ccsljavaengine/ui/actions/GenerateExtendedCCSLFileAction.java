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

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.utils.ccsl.QvtoTransformationPerformer;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

abstract public class GenerateExtendedCCSLFileAction implements IObjectActionDelegate {

	private IFile modelFile;
	private String qvtoUriString;
	protected String modelUriString;

	
	public GenerateExtendedCCSLFileAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}
	
	
	abstract protected String getMoCFileExtension();
	
	
	private String getFeedbackFileExtension() {
		return "feedback";
	}

	protected void doQvToTransfo() {
		int numberOfCharToRemove = modelFile.getFullPath().toString().length() - modelFile.getFileExtension().length() -1;
		String outputMoCPath = "platform:/resource" + modelFile.getFullPath().toString().substring(0, numberOfCharToRemove) + "_executionModel." + getMoCFileExtension();
		String outputFeedbackPath = "platform:/resource" + modelFile.getFullPath().toString().substring(0, numberOfCharToRemove) + "_executionModel." + getFeedbackFileExtension();
		QvtoTransformationPerformer performer = new QvtoTransformationPerformer();
		performer.run(new ResourceSetImpl(), qvtoUriString, modelUriString, outputMoCPath, outputFeedbackPath);
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		if (modelFile == null || !modelFile.exists())
			return;
		modelUriString = "platform:/resource" + modelFile.getFullPath().toString();
	    qvtoUriString = getTransformationURI();
	    if (qvtoUriString != null)
			doQvToTransfo();			
	}

	abstract protected String getTransformationURI();
		
	/**path
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
			modelFile=null;
			if (selection instanceof TreeSelection) {
				TreeSelection ts = (TreeSelection) selection;
				Iterator<?> it = ts.iterator();
				while(it.hasNext()){
					Object o = it.next();
					if (o instanceof IFile) {
	//					IFile f = (IFile)o;
	//					if (f.getFileExtension().compareTo("qvto")==0){
	//						qvtoFile = (IFile) o;
	//					}else{
							modelFile = (IFile) o;
	//					}
						
						
					}
				}
				
			}
		}

}