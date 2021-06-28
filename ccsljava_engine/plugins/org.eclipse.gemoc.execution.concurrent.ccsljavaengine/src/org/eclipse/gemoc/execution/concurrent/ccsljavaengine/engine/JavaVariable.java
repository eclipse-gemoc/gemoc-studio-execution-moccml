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
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.engine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.CodeExecutionJdtClassLoader;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeHierarchy;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.core.CompilationUnit;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.jdt.internal.core.PackageFragment;
import org.eclipse.jdt.internal.core.PackageFragmentRoot;

@SuppressWarnings("restriction")
public class JavaVariable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3965023336242443147L;
	public String name;
	public String typename;
	transient private IType type;
	transient private Object o;
	transient private List<IMethod> lst;


	public JavaVariable() {
		super();
		init();
	}

	public String getTypeName() {
		if (type != null) {
			return type.getFullyQualifiedName();
		} else {
			return typename;
		}
	}

	/**
	 * This constructor is used when code execution behaviors are either built
	 * from the GUI or rebuilt from the persistent options. The IType element
	 * comes from the JDT Java model (through the GUI) and the typename field is
	 * initialized with an identifier that describes the hierarchy and path from
	 * the root of the Java model (ie. the workspace) to the actual IType. Most
	 * of the time this path starts at the Java model (in the JDT
	 * {@link JavaCore} class), then to the {@link JavaProject}, the
	 * {@link PackageFragmentRoot} instance, then the {@link PackageFragment},
	 * the {@link CompilationUnit} and finally the {@link IType}. This path is
	 * encoded in a String returned by the
	 * {@link #getStringFromJavaElement(IJavaElement)} function.
	 * 
	 * @param name
	 * @param type
	 */
	public JavaVariable(String name, IType type) {
		super();
		this.name = name;
		this.type = type;
		this.typename = getStringFromJavaElement(type);
	}

	/**
	 * This constructor is used when the {@link JavaVariable} object is built from
	 * the analysis of a Xtext code execution model loaded from a resource. In
	 * this scenario, the {@link IType} element is not accessible (especially
	 * because the type can be either a class in the worspace or a class in a
	 * plugin deployed in the running eclipse). Here the typeName argument is
	 * the fully qualified name of the type, such that a properly configured
	 * classloader can use it.
	 * 
	 * @param name
	 * @param typeName
	 */
	public JavaVariable(String name, String typeName) {
		super();
		this.name = name;
		this.typename = typeName;
		this.type = null;
		init();
	}

	public void init() {
		/*
		 * if typename is not in the form required by the JDT to designate an
		 * element the field type will stay null.
		 */
		if (type == null) {
			type = (IType) getJavaElementFromString(typename);
		}
	}

	protected String getStringFromJavaElement(IJavaElement javaElement) {
		if (javaElement != null) {
			String ret = ((javaElement).getHandleIdentifier());
			return ret;
		}
		return null;
	}

	protected IJavaElement getJavaElementFromString(String s) {
		try {
			return JavaCore.create(s);
		} catch (Throwable t) {
			return null;
		}
	}

	public Object getObject() {
		if (o == null) {
			try {
				init();
				String _className;
				/*
				 * If the type field is not null, the JavaVariable object was built
				 * using the GUI and the type comes from the JDT model of
				 * projects in the workspace. Then the JPT project can be
				 * determined and the ProjectClassLoader class can be used. On
				 * the other hand, when the JavaVariable object comes from a loaded
				 * Xtext .codeexecution resource/model, the type can be either
				 * from the workspace or from a plugin in the running Eclipse
				 * instance: in both cases, there is not a single IProject
				 * object that can be used, and we rely on the
				 * CodeExecutionJdtClassLoader class to load the class either
				 * from all the workspace java project or from a plugin, by
				 * giving to this class loader a parent which is the class
				 * loader of this plugin. In the manifest of this plugin the
				 * Buddy-Policy of the loader is set to global so that it is
				 * able to load a class from any plugin in the running Eclipse
				 * instance.
				 */
				if (type != null) {
					_className = type.getFullyQualifiedParameterizedName();
					ClassLoader newLoader = ProjectClassLoader.instance
							.getProjectClassLoader(type);
					Class<?> clazz = newLoader.loadClass(_className);
					o = clazz.newInstance();
				} else {
					_className = typename;
					ClassLoader newLoader = new CodeExecutionJdtClassLoader(getClass()
							.getClassLoader());
					Class<?> clazz = newLoader.loadClass(_className);
					o = clazz.newInstance();
				}
			} catch (Throwable e) {
				System.err.println("error " + e);
				e.printStackTrace();
			}
		}
		return o;
	}

	public List<IMethod> getIMethods() {
		if (type == null)
			return null;
		if (lst == null) {
			lst = new ArrayList<IMethod>();
			IType t = type;

			{
				try {

					for (IMethod m : t.getMethods()) {
						lst.add(m);
					}
					ITypeHierarchy th = t.newSupertypeHierarchy(new NullProgressMonitor());
					th.refresh(new NullProgressMonitor());
					for (IType t2 : th.getAllSuperclasses(t)) {
						for (IMethod m : t2.getMethods()) {
							if (m.isConstructor())
								continue;
							int flags = m.getFlags();
							if (!Flags.isPublic(flags))
								continue;
							if (Flags.isStatic(flags))
								continue;
							lst.add(m);
						}
					}
				} catch (Throwable e) {
					e.printStackTrace();
				}

			}
		}
		return lst;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj instanceof JavaVariable) {
			((JavaVariable) obj).init();
			this.init();
			if (this.type != null && ((JavaVariable) obj).type != null) {
				if (((JavaVariable) obj).type.equals(this.type)
						&& (((JavaVariable) obj).name).equals(this.name)) {
					return true;
				}
			} else {
				return ((JavaVariable) obj).typename.compareTo(this.typename) == 0
						&& (((JavaVariable) obj).name).equals(this.name);
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return (name != null ? name.hashCode() : 0) + ((type != null) ? type.hashCode() : 0);
	}

}
