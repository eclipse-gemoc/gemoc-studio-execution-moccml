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
package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.ui.builder;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gemoc.commons.eclipse.core.resources.AbstractProjectNature;
import org.eclipse.gemoc.commons.eclipse.core.resources.IProjectUtils;
import org.eclipse.gemoc.commons.eclipse.jdt.JavaProject;
import org.eclipse.gemoc.commons.eclipse.pde.manifest.ManifestChanger;
import org.eclipse.gemoc.commons.eclipse.pde.ui.PluginConverter;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.ui.Activator;
import org.eclipse.gemoc.xdsmlframework.ide.ui.builder.GemocLanguageProjectNature;
import org.eclipse.gemoc.xdsmlframework.ide.ui.builder.pde.PluginXMLHelper;
import org.osgi.framework.BundleException;

public class MoccmlLanguageProjectNature extends AbstractProjectNature {

	/**
	 * ID of this project nature
	 */
	public static final String NATURE_ID = Activator.PLUGIN_ID+".MoccmlLanguageProjectNature";

	@Override
	public void configure() throws CoreException {
		requirementConfigure();
		addBuilder(MoccmlLanguageProjectBuilder.BUILDER_ID);
	}

	@Override
	public void deconfigure() throws CoreException {
		removeBuilder(MoccmlLanguageProjectBuilder.BUILDER_ID);
	}
	
	
	/**
	 * Action done during the configure() that cannot be undone during the deconfigure()
	 * this is the case of the addition of required natures, and changes in the files (plugin, manifest, ...)
	 * @throws CoreException
	 */
	public void requirementConfigure() throws CoreException {
		try {
			IProject project = getProject();
			IProjectUtils.addNature(project, GemocLanguageProjectNature.NATURE_ID);
			JavaProject.create(project);
			addPluginNature(project);
			JavaProject.addSourceFolder(project, Activator.EXTENSION_GENERATED_CLASS_FOLDER_NAME);
			addGemocResourcesToBuildProperties(project);
			updateManifestFile(project);
		} catch (IOException e) {
			Activator.error("Problem while adding Gemoc Language nature to project. " + e.getMessage(), e);
		}
	}
	
	private void addPluginNature(IProject project) throws CoreException {
		if(!project.hasNature("org.eclipse.pde.PluginNature")) 
		{
			try {
				// create first the plugin.xml file
				PluginXMLHelper.createEmptyTemplateFile(project.getFile(PluginXMLHelper.PLUGIN_FILENAME), false);					
				// convert to plugin and add necessary entries in the build.properties
				PluginConverter.convert(project);							
			} 
			catch (InvocationTargetException | InterruptedException e) 
			{
				Activator.error("cannot add org.eclipse.pde.PluginNature nature to project due to " + e.getMessage(), e);
			}								
		}
	}
	private void updateManifestFile(IProject project){
		// complement manifest
		ManifestChanger changer = new ManifestChanger(project);
		try {		
			changer.addPluginDependency("org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api");				
			changer.addPluginDependency("org.eclipse.gemoc.execution.concurrent.ccsljavaengine");
			changer.addPluginDependency("org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3");
			changer.addPluginDependency("org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.timesquare");
			changer.commit();	
		} catch (BundleException | IOException | CoreException e) {
			Activator.error("Failed to update manifest "+e.getMessage(), e);
		}
	}
	
	private void addGemocResourcesToBuildProperties(IProject project){
		
		try {
			Properties properties = new Properties();
			InputStream inputStream = project.getFile("build.properties").getContents();
			properties.load(inputStream);
			String binIncludes = properties.getProperty("bin.includes");
			if(binIncludes != null ){
//				if(!binIncludes.contains("project.xdsml")){
//					properties.put("bin.includes", binIncludes+", project.xdsml");
//				}
			}
			//create an empty InputStream
			PipedInputStream in = new PipedInputStream();
			//create an OutputStream with the InputStream from above as input
			PipedOutputStream out = new PipedOutputStream(in);

			//now work on the OutputStream e.g.
			properties.store(out, "");
			out.close();
			//now you have the OutputStream as InputStream

			//overwrite file contents
			project.getFile("build.properties").setContents(in, true, true, new NullProgressMonitor());
				
		} catch (CoreException e1) {
			Activator.error(e1.getMessage(), e1);
		} catch (IOException e) {
			Activator.error(e.getMessage(), e);
		}
		
	}
}
