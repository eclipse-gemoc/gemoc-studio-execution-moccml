/*******************************************************************************
 * Copyright (c) 2017 I3S laboratory, INRIA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     I3S laboratory and INRIA Kairos - initial API and implementation
 *******************************************************************************/
package org.eclipse.gemoc.addon.papyrusmodelanimator;

import org.eclipse.core.resources.IFile;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.core.sashwindows.di.service.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.uml.diagram.clazz.UmlClassDiagramForMultiEditor;
import org.eclipse.papyrus.uml.diagram.common.part.UmlGmfDiagramEditor;
import org.eclipse.papyrus.uml.diagram.composite.UmlCompositeDiagramForMultiEditor;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.uml2.uml.Element;


/**
 * The Class PapyrusModelBridge.
 */
public class PapyrusModelBridge {

	
	/** The papyrus editor. */
	protected PapyrusMultiDiagramEditor papyrusEditor;
	
	/** The file. */
	protected IFile file;
	
	/** The page. */
	protected IWorkbenchPage page;
	
	/** The diagram editor. */
	protected UmlClassDiagramForMultiEditor classDiagramEditor=null;
	protected UmlCompositeDiagramForMultiEditor compositeDiagramEditor=null;
	
	/** The clazzdiagramedit part. */
	protected DiagramEditPart clazzdiagrameditPart;
	protected IPageManager pageMngr;
	protected ServicesRegistry serviceRegistry;
	
	
	public PapyrusModelBridge(IFile theDiagram) throws Exception {
		file = theDiagram;
		openPapyrusDiagram();			
	}
	

	/**
	 * Gets the root semantic model.
	 * 
	 * @return the root semantic model
	 */
	public Element getRootSemanticModel(){
		return (Element) getRootSemanticModel();
	}


//	/**
//	 * Gets the diagram edit part.
//	 * 
//	 * @return the diagram edit part
//	 */
//	public DiagramEditPart getDiagramEditPart(){
//		if(clazzdiagrameditPart== null){
//			ISashWindowsContainer container = null;
//			try {
//				container = ServiceUtils.getInstance().getISashWindowsContainer(serviceRegistry);
//			} catch (ServiceException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			clazzdiagrameditPart = ((UmlGmfDiagramEditor)container.getActiveEditor()).getDiagramEditPart();
//					
//					//(DiagramEditPart)NotationHelper.papyrusEditor.getDiagramGraphicalViewer().getContents().getRoot().getChildren().get(0);
//			}
//
//		return clazzdiagrameditPart;
//	}
	
	/**
	 * Open the papyrus editor.
	 */
	public void openPapyrusDiagram(){
		try{
			page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			IEditorDescriptor desc = PlatformUI.getWorkbench().
		    getEditorRegistry().getDefaultEditor(file.getName());
			IEditorPart editorPart =page.openEditor(new FileEditorInput(file), desc.getId(),true,IWorkbenchPage.MATCH_ID);			
			
			serviceRegistry = (ServicesRegistry) editorPart
					.getAdapter(ServicesRegistry.class);
			try {
				pageMngr = ServiceUtils.getInstance().getIPageManager(serviceRegistry);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			
			papyrusEditor=((PapyrusMultiDiagramEditor)editorPart);
			//System.out.println(papyrusEditor.getEditingDomain().getResourceSet());
		}
		catch (Exception e) {
			System.err.println("error "+e);
		}		
	}

}
