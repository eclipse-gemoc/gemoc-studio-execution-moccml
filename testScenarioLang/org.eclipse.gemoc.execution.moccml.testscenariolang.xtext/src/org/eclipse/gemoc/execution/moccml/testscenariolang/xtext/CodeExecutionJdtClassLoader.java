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
package org.eclipse.gemoc.execution.moccml.testscenariolang.xtext;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

/**
 * A class loader which is able to load classes from the projects in the workspace.
 * This class loader is a subclass of {@link URLClassLoader}. Each time a class is looked for the
 * URLs of the class loader are updated to refer to the java projects located in the workspace. A cache of
 * already analyzed java projects is maintained to avoid repetitive and useless analysis.
 * @author nchleq
 *
 */
public class CodeExecutionJdtClassLoader extends URLClassLoader {
	
	
	public CodeExecutionJdtClassLoader(ClassLoader parent) {
		super(new URL[0], parent);
	}
	
	static IWorkspace workspace;
	static IWorkspaceRoot root;
	static {
		workspace = ResourcesPlugin.getWorkspace();
		root = workspace.getRoot();	
	}
	
	/**
	 * Store analyzed project names together with a hash of their IJavaProject object, so
	 * that we can both know if a project has been visited and if its information has changed since last visit.
	 */
	private HashMap<String, Integer> visitedProjects = new HashMap<String, Integer>();
	
	private void updateSearchPaths() {
		IProject[] projects = root.getProjects();
		for (IProject project : projects) {
			if (project.isOpen()) {
				try {
					boolean isJavaProject = false;
					IProjectDescription descr = project.getDescription();
					/* is it a Java project ? */
					for (String nature : descr.getNatureIds()) {
						if (nature.equals(org.eclipse.jdt.core.JavaCore.NATURE_ID)) {
							isJavaProject = true;
							break;
						}
					}
					if (isJavaProject) {
						IJavaProject javaProject = JavaCore.create(project);
						// Already visited ?
						int hash = javaProject.hashCode();
						Integer oldHash = visitedProjects.get(project.getName());
						if (oldHash == null || oldHash != hash) {
							for (URL url : getProjectClassPathURLs(javaProject)) {
								addURL(url);
							}
							visitedProjects.put(project.getName(), hash);
						}
					}
				} catch (CoreException e) {
					/* Silent failure: skip this project */
				}
			}
		}
	}
	
	private URL[] getProjectClassPathURLs(IJavaProject project) {
		Set<URL> pathElements = new HashSet<URL>();
		try {
			IClasspathEntry[] paths = project.getResolvedClasspath(true);
			Set<IPath> outputPaths = new HashSet<IPath>();
			if (paths != null) {
				for (int i = 0; i < paths.length; i++) {
					IClasspathEntry path = paths[i];
					if (path.getEntryKind() == IClasspathEntry.CPE_LIBRARY) {
						URL url = getRawLocationURL(path.getPath());
						pathElements.add(url);
					} else if (path.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
						IPath output = path.getOutputLocation();
						if (output != null) {
							outputPaths.add(output);
						}
					}
				}
			}
			// Also add the output path of the project itself
			outputPaths.add(project.getOutputLocation());
			// And convert all these paths to absolute URLs
			IPath workspaceLocation = root.getLocation();
			for (IPath path : outputPaths) {
				IPath outputPath = workspaceLocation.append(path);
				URL outputURL = outputPath.toFile().toURI().toURL();
				pathElements.add(outputURL);
			}
		} catch (Throwable e) {
		}
		return pathElements.toArray(new URL[pathElements.size()]);
	}
	
	private static URL getRawLocationURL(IPath simplePath)
			throws MalformedURLException {
		File file = getRawLocationFile(simplePath);
		return file.toURI().toURL();
	}
	
	private static File getRawLocationFile(IPath simplePath) {
		IResource resource = root.findMember(simplePath);
		File file = null;
		if (resource != null) {
			file = root.findMember(simplePath).getRawLocation().toFile();
		} else {
			file = simplePath.toFile();
		}
		return file;
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		updateSearchPaths();
		Class<?> clazz = super.findClass(name);
		return clazz;
	}	
	
}
