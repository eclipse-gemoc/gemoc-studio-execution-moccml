/*******************************************************************************
 * Copyright (c) 2017 INRIA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     INRIA - initial API and implementation
 *     I3S - API modification and bug fix
 *******************************************************************************/
package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.ui.builder;

public class BuilderTemplates {

	public static final String MODEL_LOADER_CLASS_TEMPLATE =
"/* GENERATED FILE, do not modify manually                                                    *\n" +
" * If you need to modify it, disable the generation in the BuildOptions of the project.xdsml */\n" +
"package ${package.name};\n"+
"import java.util.Map;\n"+
"import org.eclipse.emf.common.util.URI;\n"+	
"import org.eclipse.emf.ecore.resource.Resource;\n"+
"import org.eclipse.emf.ecore.resource.ResourceSet;\n"+
"import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;\n"+
"import org.eclipse.gemoc.gemoc_language_workbench.api.utils.ModelLoader;\n"+
"public class ${language.name.toupperfirst}ModelLoader implements ModelLoader {\n"+
"	@Override\n"+
"	public Resource loadModel(String modelFileUri) {\n"+
"		Resource result = null;\n"+
"		${loadModel.content}\n"+
"		return result;\n"+
"	}\n"+
"}";
	
	public static final String INITIALIZER_CLASS_TEMPLATE =
"/* GENERATED FILE, do not modify manually                                                    *\n" +
" * If you need to modify it, disable the generation in the BuildOptions of the project.xdsml */\n" +
"package ${package.name};\n"+
"import org.eclipse.gemoc.gemoc_language_workbench.api.utils.LanguageInitializer;\n"+
"public class ${language.name.toupperfirst}Initializer implements LanguageInitializer {\n"+
"	@Override\n"+
"	public void initialize() {\n"+
"	${initializer.content}\n"+
"	}\n"+
"}";
	
	
	public static final String CODEEXECUTOR_CLASS_TEMPLATE =
"/* GENERATED FILE, do not modify manually                                                    *\n" +
" * If you need to modify it, disable the generation in the BuildOptions of the project.xdsml */\n" +
"package ${package.name};\n"+
"import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.dsa.executors.CodeExecutorDispatcher;\n"+
"public class ${language.name.toupperfirst}CodeExecutor extends CodeExecutorDispatcher ${implements.content} {\n"+
"	public ${language.name.toupperfirst}CodeExecutor(){\n"+
"	    ${constructor.content}\n"+
"	}\n"+
"	public String getDSAProjectName(){\n"+
"		//TODO please implement\n"+
"		return \"\";\n"+
"	}\n"+
"   ${additional.operations}\n"+
"}";
	
	public static final String SOLVER_CLASS_TEMPLATE =
"/* GENERATED FILE, do not modify manually                                                    *\n" +
" * If you need to modify it, disable the generation in the BuildOptions of the project.xdsml */\n" +
"package ${package.name};\n"+
"import org.eclipse.gemoc.execution.engine.commons.solvers.ccsl.CcslSolver;\n"+
"public class ${language.name.toupperfirst}Solver extends CcslSolver {\n"+
"	public ${language.name.toupperfirst}Solver(){\n"+
"	    ${constructor.content}\n"+
"	}\n"+
"}";
	
	
	public static final String MELANGE_TEMPLATE =
"/* GENERATED FILE, do not modify manually                                                    *\n" +
" * If you need to modify it, disable the needMelangeSynchronization flag in the project.xdsml */\n" +
"package ${package.name}\n"+
"${import.section}\n"+
"${base.language.metamodel.section}\n"+
"${executable.language.metamodel.section}";
	
	
	
	public static final String RTD_ACCESSOR_CLASS_TEMPLATE =
"/* GENERATED FILE, do not modify manually                                                    *\n" +
" * If you need to modify it, copy it first */\n" +
"package ${package.name};\n"+
"import org.eclipse.emf.ecore.EObject;\n"+
"import java.lang.reflect.InvocationTargetException;\n" + 
"import java.util.List;\n"+
"import java.lang.reflect.Method;\n" +
"import org.eclipse.gemoc.executionframework.engine.commons.K3DslHelper;\n" + 
"${extraImports}\n"+
"\n"+
"public class ${language.name.toupperfirst}RTDAccessor {\n"+
"${allGettersAndSetters}\n"+
"	public static Object getAspectProperty(EObject eObject, String languageName, String aspectName, String propertyName) {\n" + 
"		List<Class<?>> aspects = K3DslHelper.getAspectsOn(languageName, eObject.getClass());\n" + 
"		Class<?> aspect = null;\n" + 
"		for (Class<?> a : aspects) {\n" + 
"			try {\n" + 
"				if (Class.forName(aspectName).isAssignableFrom(a)) {\n" + 
"					aspect = a;\n" + 
"				}\n" + 
"			} catch (ClassNotFoundException e) {\n" + 
"				e.printStackTrace();\n" + 
"			}\n" + 
"		}\n" + 
"		if (aspect == null) {\n" + 
"			return null;\n" + 
"		}\n" + 
"		Object res = null;\n" + 
"		 try {\n" + 
"			res = aspect.getDeclaredMethod(propertyName, ((fr.inria.diverse.k3.al.annotationprocessor.Aspect)aspect.getAnnotations()[0]).className()).invoke(eObject, eObject);\n" + 
"			if (res != null) {\n" + 
"				return res;\n" + 
"			}else {\n" + 
"				return null;\n" + 
"			}\n" + 
"		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException\n" + 
"					| NoSuchMethodException | SecurityException e) {\n" + 
"			e.printStackTrace();\n" + 
"		}\n" + 
"\n" + 
"		return null;\n" + 
"	}\n" + 
"	\n" + 
"	\n" + 
"	public static boolean setAspectProperty(EObject eObject, String languageName, String aspectName, String propertyName, Object newValue) {\n" + 
"		List<Class<?>> aspects = K3DslHelper.getAspectsOn(languageName, eObject.getClass());\n" + 
"		Class<?> aspect = null;\n" + 
"		for (Class<?> a : aspects) {\n" + 
"			try {\n" + 
"				if (Class.forName(aspectName).isAssignableFrom(a)) {\n" + 
"					aspect = a;\n" + 
"				}\n" + 
"			} catch (ClassNotFoundException e) {\n" + 
"				e.printStackTrace();\n" + 
"				return false;\n" + 
"			}\n" + 
"		}\n" + 
"		if (aspect == null) {\n" + 
"			return false;\n" + 
"		}\n" + 
"			 try {\n" + 
"				 aspect.getMethod(propertyName, ((fr.inria.diverse.k3.al.annotationprocessor.Aspect)aspect.getAnnotations()[0]).className(), newValue.getClass()).invoke(eObject, eObject, newValue);\n" + 
"				return true;\n" + 
"				} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {\n" + 
"					Method m = null;\n" + 
"					for(Class<?> c : ((fr.inria.diverse.k3.al.annotationprocessor.Aspect)aspect.getAnnotations()[0]).getClass().getInterfaces()) {\n" + 
"						\n" + 
"						try {\n" + 
"							aspect.getMethod(propertyName, c, newValue.getClass()).invoke(eObject, eObject, newValue);\n" + 
"							return true;\n" + 
"						} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {\n" + 
"						}\n" + 
"						if (m == null) {\n" + 
"							throw new RuntimeException(\"not method found for \"+((fr.inria.diverse.k3.al.annotationprocessor.Aspect)aspect.getAnnotations()[0]).className()+\"::set\"+propertyName);\n" + 
"						}\n" + 
"					}\n" + 
"				}\n" + 
"			return false;\n" + 
"	}\n"+
"};";
	
	public static final String MODEL_STATE_CLASS_TEMPLATE =
"/* GENERATED FILE, do not modify manually                                                    *\n" +
" * If you need to modify it, copy it first */\n" +
"package ${package.name};\n"+
"import java.io.Serializable;\n" + 
"import java.lang.reflect.Method;\n" +
"import java.lang.reflect.InvocationTargetException;\n" + 
"import org.eclipse.emf.common.util.TreeIterator;\n" + 
"import org.eclipse.emf.ecore.EObject;\n" + 
"import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.ElementState;\n" + 
"import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelState;\n" + 
"import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelStateFactory;\n"+
"import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.dsa.helper.IK3ModelStateHelper;"+
"import org.eclipse.gemoc.executionframework.engine.commons.K3DslHelper;\n"+
"${extraImports}\n"+
"\n"+
"public class ${language.name.toupperfirst}ModelStateHelper implements IK3ModelStateHelper{\n"+ 
"\tprivate static class AttributeNameToValue implements Serializable{\n" + 
"\n\t\tprivate static final long serialVersionUID = 0;"+
"\t\tString name;\n" + 
"\t\tObject value;\n" + 
"\t\tpublic AttributeNameToValue(String n, Object v) {\n" + 
"\t\t\tname = n;\n" + 
"\t\t\tvalue = v;\n" + 
"\t\t}\n" + 
"\n" + 
"\n" + 
"		@Override\n" + 
"		public boolean equals(Object obj) {\n" + 
"			if (! (obj instanceof AttributeNameToValue)) {\n" + 
"				return false;\n" + 
"			}\n" + 
"			AttributeNameToValue a2n = (AttributeNameToValue)obj;\n" + 
"			if (this.name.compareTo(a2n.name) != 0) {\n" + 
"				return false;\n" + 
"			}\n" + 
"			if (this.value == null) {\n" + 
"				return a2n.value == null;\n" + 
"			}\n" + 
"			if (!this.value.equals(a2n.value)) {\n" + 
"				return false;\n" + 
"			}\n" + 
"			return true;\n" + 
"		}" + 
""+
"\t}"+
"\n\t\tK3ModelStateFactory theFactory = K3ModelStateFactory.eINSTANCE; \n"+
"${saveAndRestoreMethod}\n"+
"\n" + 
"	public void restoreModelState(K3ModelState state) {\n" + 
"		for(ElementState elemState : state.getOwnedElementstates()) {\n" + 
"			for(Object o : elemState.getSavedRTDs()) {\n" + 
"				AttributeNameToValue n2v = (AttributeNameToValue)o;\n" + 
"				try {\n" + 
"					if (n2v.value != null) {\n" + 
"						Method m = ${language.name.toupperfirst}RTDAccessor.class.getMethod(\"set\"+n2v.name, EObject.class, n2v.value.getClass());\n" + 
"						m.invoke(null, elemState.getModelElement(), n2v.value);\n" + 
"					}\n" + 
"				} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {\n" + 
"					Method m = null;\n" + 
"					for(Class<?> c : n2v.value.getClass().getInterfaces()) {\n" + 
"						\n" + 
"						try {\n" + 
"							m = ${language.name.toupperfirst}RTDAccessor.class.getMethod(\"set\"+n2v.name, EObject.class, n2v.value.getClass().getInterfaces()[0]);\n" + 
"							m.invoke(null, elemState.getModelElement(), n2v.value);\n" + 
"						} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {\n" + 
"						}\n" + 
"						if (m == null) {\n" + 
"							throw new RuntimeException(\"not method found for \"+n2v.value.getClass().getName()+\"::set\"+n2v.name);\n" + 
"						}\n" + 
"					}\n" + 
"				}\n" + 
"			}\n" + 
"		}\n" + 
"	}\n" + 
"\n" + 
"};";
	
}
