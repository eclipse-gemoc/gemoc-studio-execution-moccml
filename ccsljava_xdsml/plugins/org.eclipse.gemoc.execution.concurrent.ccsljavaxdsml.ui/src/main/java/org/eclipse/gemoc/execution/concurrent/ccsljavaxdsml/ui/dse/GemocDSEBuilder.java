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
package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.ui.dse;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.eclipse.acceleo.common.preference.AcceleoPreferences;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gemoc.commons.eclipse.core.resources.IFileUtils;
import org.eclipse.gemoc.commons.eclipse.core.resources.IProjectUtils;
import org.eclipse.gemoc.commons.eclipse.core.resources.Marker;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.ui.Activator;
import org.eclipse.gemoc.moccml.mapping.ecltoqvto.main.AcceleoLauncherForEclToQvto;

import com.google.common.base.Charsets;

public class GemocDSEBuilder extends IncrementalProjectBuilder {
	
	public static String QVTO_GEN_FOLDER = "qvto-gen";

	private ArrayList<IGemocDSEBuilderAddon> addons;
	
	public GemocDSEBuilder() {
		//remove acceleo notifications
		AcceleoPreferences.switchForceDeactivationNotifications(true);
		try {
			addons = instanciateBuilderAddons();
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e);
		}
	}
	
	
	final public ArrayList<IGemocDSEBuilderAddon> instanciateBuilderAddons() throws CoreException {
		ArrayList<IGemocDSEBuilderAddon> addons = new ArrayList<IGemocDSEBuilderAddon>();
		for (GemocDSEBuilderAddonExtension addonExtension : GemocDSEBuilderAddonExtensionPoint.getSpecifications()) {
			addons.add(addonExtension.instanciateComponent());
		}
		return addons;
	}
	

	class GemocDSEBuilderDeltaVisitor implements IResourceDeltaVisitor {
		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.core.resources.IResourceDeltaVisitor#visit(org.eclipse.core.resources.IResourceDelta)
		 */
		@Override
		public boolean visit(IResourceDelta delta) throws CoreException {
			IResource resource = delta.getResource();
			
			switch (delta.getKind()) {
			case IResourceDelta.ADDED:
				// handle added resource
				processResource(resource);
				break;
			case IResourceDelta.REMOVED:
				// handle removed resource
				break;
			case IResourceDelta.CHANGED:
				// handle changed resource
				processResource(resource);
				break;
			}
			//return true to continue visiting children.
			return true;
		}
	}

	class Moc2ASProjectResourceVisitor implements IResourceVisitor {
		@Override
		public boolean visit(IResource resource) {
			processResource(resource);
			//return true to continue visiting children.
			return true;
		}
	}


	public static final String BUILDER_ID = Activator.PLUGIN_ID+".dse_builder";

	public static final String MARKER_TYPE = Activator.PLUGIN_ID+".dse_problem";


	protected void addMarker(IResource resource, String message, int lineNumber, int severity) {
		try {
			Marker.addMarker(resource, MARKER_TYPE, message, lineNumber, severity);
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.internal.events.InternalBuilder#build(int,
	 *      java.util.Map, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor)
			throws CoreException {
		if (kind == FULL_BUILD) {
			fullBuild(monitor);
		} else {
			IResourceDelta delta = getDelta(getProject());
			if (delta == null) {
				fullBuild(monitor);
			} else {
				incrementalBuild(delta, monitor);
			}
		}
		return null;
	}

	@Override
	protected void clean(IProgressMonitor monitor) throws CoreException {
		// delete markers set and files created
		Marker.removeMarkers(getProject(), MARKER_TYPE);
	}

	protected void processResource(IResource resource){
		
		if (resource instanceof IFile && resource.getName().equals("moc2as.properties")) {
			checkProjectProperties((IFile) resource);
		}
		else if (resource instanceof IProject)  {
			checkProjectMinimalContent((IProject) resource);
		}
		else if(resource instanceof IFile && resource.getName().endsWith(".ecl")){
			updateQVTOFromECL(resource);
		}
		else if(resource instanceof IFile 
				&& resource.getName().endsWith(".qvto") 
				&& resource.getProjectRelativePath().segment(0).equalsIgnoreCase(QVTO_GEN_FOLDER)){
			checkQVTOContent((IFile)resource);
		}
			
		for(IGemocDSEBuilderAddon addon : addons){
			try{
				addon.processResourceAddon(resource);
			}
			catch (Throwable e){
				Activator.error("Error in addon "+e.getMessage(), e);
			}
		}
		
	}
	
	protected void checkProjectMinimalContent(IProject project) {
		deleteMarkers(project);
		IFile propertyFile = (IFile) project.getFile("moc2as.properties");
		if(!propertyFile.exists())
		{
			addMarker(project, "Missing moc2as.properties, cannot generate qvto", -1, IMarker.SEVERITY_ERROR);
			return;
		}
	}
	
	protected void checkQVTOContent(IFile qvtoFile) {
		deleteMarkers(qvtoFile);
		
		try {
			BufferedReader reader;
			reader = new BufferedReader(new InputStreamReader(qvtoFile.getContents(),
					  Charsets.UTF_8));
		
			int lineNumber =0;
		
			while (reader.ready()) {
				  String line = reader.readLine();
				  lineNumber++;
				  if(line.contains("uses 'invalid';")){
					  addMarker(qvtoFile, "Generated QVTO file is Invalid. Check your ECL file or try to clean/rebuild the project", lineNumber, IMarker.SEVERITY_ERROR);
						return;  
				  }
			}
		} catch (IOException e) {
		} catch (CoreException e1) {}
	}
	
	protected void checkProjectProperties(IFile propertyFile) {
		checkProjectMinimalContent(propertyFile.getProject());
		deleteMarkers(propertyFile);
		Properties properties = new Properties();
		try {
			properties.load(propertyFile.getContents());
		
			String rootElement = properties.getProperty("rootElement");
			if(rootElement==null || rootElement.isEmpty()){
				addMarker(propertyFile, "rootElement not defined in moc2as.properties, cannot generate qvto", -1, IMarker.SEVERITY_ERROR);
				return;
			}
		} catch (IOException e1) {
			Activator.error(e1.getMessage(), e1);
		} catch (CoreException e1) {
			Activator.error(e1.getMessage(), e1);
		}
	}
	
	void updateQVTOFromECL(IResource resource) {		
		if (resource instanceof IFile && (resource.getName().endsWith(".ecl") || resource.getName().endsWith(".moccmlmapping"))) {
			IProject project = resource.getProject();
			final IFile eclFile = (IFile) resource;
			deleteMarkers(eclFile);
			
			
			IFile propertyFile = (IFile) resource.getProject().getFile("moc2as.properties");
			if(!propertyFile.exists()){
				addMarker(eclFile, "Missing moc2as.properties, cannot generate qvto with DSE builder", -1, IMarker.SEVERITY_WARNING);
				return;
			}
			try {
				Properties properties = new Properties();
				properties.load(propertyFile.getContents());
				String rootElement = properties.getProperty("rootElement");
				if(rootElement==null || rootElement.isEmpty()){
					addMarker(eclFile, "rootElement not defined in moc2as.properties, cannot generate qvto with DSE builder", -1, IMarker.SEVERITY_WARNING);
					return;
				}
				String uristring = eclFile.getLocation().toOSString();
			    final URI uri = URI.createFileURI(uristring);
			    
			    String genFolder = QVTO_GEN_FOLDER;
			    final IFolder modelingFolder = IProjectUtils.createFolder(project, genFolder + "/modeling");			    	
			    final IFolder languageFolder = IProjectUtils.createFolder(project, genFolder + "/language");			    	

			    final String qvtoFileName = eclFile.getFullPath()
			    					.removeFileExtension()
			    					.addFileExtension("qvto")
			    					.lastSegment();
//			    uri.lastSegment().replace(".ecl",	"_toCCSL.qvto");
//			    final IFile modelingFile = modelingFolder.getFile(new )
			    
			    
//				final IFolder qvtoFolder = project.getFolder("qvto-gen");
//				if(!qvtoFolder.exists()) qvtoFolder.create(true, true, null);
			

//				String folderPath = qvtoFolder.getLocation().toOSString();
	//			final File folder = new File(folderPath);
	
			    
			    
			    
				final List<String> arguments = new ArrayList<String>();
				//LanguageDefinition ld = EObjectUtil.eContainerOfType(ecliFilePath, LanguageDefinition.class);
				//String qvtoFileName = uri.lastSegment().replace(".ecl",	"_toCCSL.qvto");
				arguments.add(qvtoFileName);
				// the qvto transformation need to have the first package removed
				String fixedRootElement = rootElement;
				if(rootElement.contains("::")){
					fixedRootElement = rootElement.substring(rootElement.indexOf("::")+2);
				}
				arguments.add(fixedRootElement); 
				// create QVTO file
				ISafeRunnable runnable = new ISafeRunnable() {
					@Override
					public void handleException(Throwable e) {
						Activator.error(e.getMessage(), e);
					}
	
					@Override
					public void run() throws Exception {
	
						//ResourceUtil.createFolder(qvtoFolder, true, true, null);
	
						try {
							System.out.println("launching ecl to qvto:\n\turi=" + uri + "\n\tfolder=" + languageFolder + "\n\targs="
									+ arguments);
							AcceleoLauncherForEclToQvto launcher = new AcceleoLauncherForEclToQvto(uri, new File(languageFolder.getLocation().toOSString()), arguments);
							launcher.doGenerate(new BasicMonitor());
							
							IFile qvtoFileForLanguage = languageFolder.getFile(qvtoFileName);
							qvtoFileForLanguage.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
							checkQVTOContent(qvtoFileForLanguage);

							IFile qvtoFileForModeling = modelingFolder.getFile(qvtoFileName);
															
							String qvtoLanguageContent = IFileUtils.getStringContent(qvtoFileForLanguage);
							String qvtoModelingContent = qvtoLanguageContent.replaceAll("platform:/resource", "platform:/plugin");
							IFileUtils.writeInFileIfDifferent(qvtoFileForModeling, qvtoModelingContent, new NullProgressMonitor());
								
							qvtoFileForModeling.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
							checkQVTOContent(qvtoFileForModeling);
						} catch (IOException e) {
							addMarker(eclFile, e.getMessage(), -1, IMarker.SEVERITY_ERROR);
							Activator.error(e.getMessage(), e);
						}
					}
				};
				SafeRunner.run(runnable);
			} catch (CoreException e1) {

				Activator.error(e1.getMessage(), e1);
			} catch (IOException e1) {

				addMarker(eclFile, e1.getMessage(), 0, IMarker.SEVERITY_ERROR);
				Activator.error(e1.getMessage(), e1);
			}
		}
	}
	
	
	private void deleteMarkers(IResource file) {
		try {
			Marker.removeMarkers(file, MARKER_TYPE);
		} catch (CoreException ce) {
		}
	}

	protected void fullBuild(final IProgressMonitor monitor)
			throws CoreException {
		try {
			getProject().accept(new Moc2ASProjectResourceVisitor());
		} catch (CoreException e) {
		}
	}

	protected void incrementalBuild(IResourceDelta delta,
			IProgressMonitor monitor) throws CoreException {
		// the visitor does the work.
		delta.accept(new GemocDSEBuilderDeltaVisitor());
	}
}
