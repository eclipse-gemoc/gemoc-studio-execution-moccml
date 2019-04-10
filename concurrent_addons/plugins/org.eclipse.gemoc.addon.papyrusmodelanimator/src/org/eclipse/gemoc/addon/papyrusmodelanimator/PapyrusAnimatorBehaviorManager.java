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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.concurrentmse.FeedbackMSE;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.IConcurrentExecutionEngine;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.moc.ISolver;
import org.eclipse.gemoc.trace.commons.model.helper.StepHelper;
import org.eclipse.gemoc.trace.commons.model.trace.MSEOccurrence;
import org.eclipse.gemoc.trace.commons.model.trace.Step;
import org.eclipse.gemoc.xdsmlframework.api.core.IExecutionEngine;
import org.eclipse.gemoc.xdsmlframework.api.engine_addon.DefaultEngineAddon;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ConcreteEntity;
import fr.inria.aoste.timesquare.launcher.core.inter.CCSLInfo;
import fr.inria.aoste.trace.ModelElementReference;

public class PapyrusAnimatorBehaviorManager extends DefaultEngineAddon {

	private String _di2FilePath = null;
	private IFile _di2IFile = null;
	private DiagramEditPart _diagramEditPart = null;
	final private List<AnimateTicksBehaviour> behaviorList = new ArrayList<AnimateTicksBehaviour>();
	final private List<AnimateAssertBehaviour> assertBehaviorList = new ArrayList<AnimateAssertBehaviour>();
	private CCSLInfo ccslhelper = null;	
	private HashMap<String, Boolean> cachevalidation=new HashMap<String, Boolean>();
	private ISolver _solver;

	public boolean validDiFile(String file) {
		file = file.replace(".di", ".uml");
		try {
			if( cachevalidation.containsKey(file))
					return cachevalidation.get(file).booleanValue();
			ResourceSet rs = new ResourceSetImpl();
			URI uri = URI.createPlatformResourceURI(file, true);
			Resource r = rs.createResource(uri);
			r.load(Collections.EMPTY_MAP);
			try {
				EcoreUtil.resolveAll(rs);
			} catch (Exception e) {

			}
			for (Resource resource : rs.getResources()) {
				URI _uri = resource.getURI();
				if (ccslhelper.getMappingURIReferencedObject().keySet().contains(_uri))
				{
					cachevalidation.put(file, true);
					return true;
				}
			}
			cachevalidation.put(file, false);
			return false;
		} catch (Exception e) {
			cachevalidation.put(file, false);
			return false;
		}
	}

	public boolean validDiFile(IFile file) {
		if (file != null) {
			return validDiFile(file.getFullPath().toString());
		}
		return true;
	}

	@Override
	public void stepExecuted(IExecutionEngine engine, Step logicalStepExecuted){
		for(MSEOccurrence occ : StepHelper.collectAllMSEOccurrences(logicalStepExecuted)){
			if(occ.getMse() instanceof FeedbackMSE){
				Clock c = (Clock) ((FeedbackMSE)occ.getMse()).getFeedbackModelSpecificEvent().getSolverEvent();
				
				for ( AnimateTicksBehaviour b : behaviorList){
					ConcreteEntity ce = ((GemocClockEntity)b.getClock())._ce;
					if (ce.getName().compareTo(c.getName()) == 0){ //TODO: Fix this ugly comparison
						b.run();
						break;
					}
				}
			}
		}
	}
	
	@Override
	public void engineAboutToStop(IExecutionEngine engine) {
	//public void end(ConfigurationHelper helper) {
		try {
			Display.getDefault().syncExec(new RunnableEnd());						
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}


	@Override
	public void engineStopped(IExecutionEngine engine) {
	//public void clear() {
		behaviorList.clear();
		_di2FilePath = null;
		_di2IFile = null;
	}


	

	private List<GraphicalEditPart> editPartGetAllChildren(AbstractEditPart dep, List<GraphicalEditPart> res) {
		@SuppressWarnings("unchecked")
		List<GraphicalEditPart> tmp = dep.getChildren();
		res.addAll(tmp);
		for (GraphicalEditPart ep : tmp) {
			editPartGetAllChildren(ep, res);
		}
		return res;
	}

	@Override
	public void engineStarted(IExecutionEngine executionEngine) {
	//public void beforeExecution(ConfigurationHelper helper, IPath folderin, String namefilein, ISolverForBackend solver) {
		try {
			Display.getDefault().syncExec(new RunnableStart());						
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}	
	
	private class RunnableEnd implements Runnable {

		@Override
		public void run() {
			for (AnimateTicksBehaviour behavior : behaviorList) {
				behavior.finish();
			}
		}
		
	}
	private final class RunnableStart implements Runnable {
		public void run() {			
			if (_di2IFile == null) {
				IWorkspaceRoot iWorkspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
				_di2IFile = (IFile) iWorkspaceRoot.findMember(_di2FilePath);
				if (_di2IFile == null) {
					return;
				}
			}
			PapyrusModelBridge thePapyrusBridge = null;
			try {
				thePapyrusBridge = new PapyrusModelBridge(_di2IFile);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			_diagramEditPart = ((DiagramEditor) thePapyrusBridge.papyrusEditor.getActiveEditor()).getDiagramEditPart();
			_diagramEditPart.setFocus(true);	
			
			while( !(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()instanceof IMultiDiagramEditor)){	
			}
			IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			
			ISashWindowsContainer container = editorPart.getAdapter(ISashWindowsContainer.class);
			List<IEditorPart> parts = container.getVisibleIEditorParts();

// get graphical elements from all visible editors
			List<GraphicalEditPart> gmfElems = new ArrayList<GraphicalEditPart>();
			for(IEditorPart part: parts) {				
				if (part instanceof GraphicalEditor) {
					if (part instanceof DiagramEditor) {
						DiagramEditPart editPart = ((DiagramEditor) part).getDiagramEditPart();
						//create problems later
						//List<GraphicalEditPart> allConnections = editPart.getConnections();
						//gmfElems.addAll(allConnections);
						editPartGetAllChildren(editPart, gmfElems);
					}
				}
			}
// used to get only from the single one selected
//			List<GraphicalEditPart> gmfElems=editPartGetAllChildren(_diagramEditPart);				
			for (AnimateTicksBehaviour behavior : behaviorList) {
				behavior.setEditPart(_diagramEditPart,gmfElems);	 	
				behavior.start();
			}
			for (AnimateAssertBehaviour assertBehavior : assertBehaviorList) {
				assertBehavior.setEditPart(_diagramEditPart);	 	
				assertBehavior.start();
			}
		}
	}

	

	@Override
	public void engineAboutToStart(IExecutionEngine engine) {
		if(engine instanceof IConcurrentExecutionEngine){
			_solver = ((IConcurrentExecutionEngine)engine).getSolver();	
		}

		for(ModelElementReference mer : _solver.getAllDiscreteClocks()) {
			if (mer.getElementRef().size() != 0){
				EObject c = mer.getElementRef().get(mer.getElementRef().size() -1);
				if (! (c instanceof Clock)) {
					continue;
				}
				EObject eo = ((Clock) c).getTickingEvent().getReferencedObjectRefs().get(0);
				Resource modelResource = eo.eResource();
				URI modelUri = modelResource.getURI();
				if (modelUri.fileExtension().compareTo("uml") != 0) {
					System.err.println("you tried to activate the papyrus model animator on a non uml file: "+modelUri);
					return;
				}
				
				String modelPath = modelUri.toPlatformString(false);//.replace("platform:/resource/", "");
				String potentialDiPath = modelPath.replace(".uml", ".di");
				IResource diResource = org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot().findMember(potentialDiPath);
				if (diResource == null) {
					System.err.println("we tried to look for a di file named like the linked uml model "
							+ "but it does not exist. We could do a better search but... this is an open source project, why not helping us :)");
					return;
				}
				_di2FilePath = potentialDiPath;
				_di2IFile = (IFile) diResource;
				break;
			}
		}
		
		
		//create the appropriated actions
		
		try {
		loop1: for(ModelElementReference mer : _solver.getAllDiscreteClocks()){
				GemocClockEntity ced = new GemocClockEntity(mer);
				//TODO: fix this ugly comparison !!!
				if (mer.getElementRef().size() != 3)
					continue loop1;
				for (AnimateTicksBehaviour b : behaviorList) {
					if (b._ce == ced)
						continue loop1;
				}
				AnimateTicksBehaviour atb = new AnimateTicksBehaviour(ced);
				behaviorList.add(atb);
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}		
		
	}

	/**
	 * for test only
	 * @return 
	 */
	protected int[] test_SizeofGetTableColor() {
		int ti[]= new int[behaviorList.size()];
		for( int i=0;i<behaviorList.size();i++)
		{
			ti[i]=behaviorList.get(i).getSizeofTableColor();
		}
		return ti;
	}
	
	
	

	
}
