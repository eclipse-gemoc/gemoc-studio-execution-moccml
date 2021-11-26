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
"import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.utils.Copier;\n"+
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
"			return res;\n" + 
"		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException\n" + 
"					| NoSuchMethodException | SecurityException e) {\n" + 
"			e.printStackTrace();\n" + 
"		}\n" + 
"\n" + 
"		return null;\n" + 
"	}\n" + 
"	\n" + 
"	\n" + 
"public static boolean setAspectProperty(EObject eObject, String languageName, String aspectName, String propertyName, Object newValue) {\n"
+ "		List<Class<?>> aspects = K3DslHelper.getAspectsOn(languageName, eObject.getClass());\n"
+ "		Class<?> aspect = null;\n"
+ "		for (Class<?> a : aspects) {\n"
+ "			try {\n"
+ "				if (Class.forName(aspectName).isAssignableFrom(a)) {\n"
+ "					aspect = a;\n"
+ "				}\n"
+ "			} catch (ClassNotFoundException e) {\n"
+ "				e.printStackTrace();\n"
+ "				return false;\n"
+ "			}\n"
+ "		}\n"
+ "		if (aspect == null) {\n"
+ "			return false;\n"
+ "		}\n"
+ "		 Method m = getSetter(propertyName,newValue,aspect);\n"
+ "		 try {\n"
+ "			m.invoke(eObject, eObject, newValue);\n"
+ "			return true;\n"
+ "		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {\n"
+ "			e.printStackTrace();\n"
+ "		}			\n"
+ "		return false;\n"
+ "}\n"
+ "	\n"
+ "	private static Method getSetter(String propertyName, Object value, Class<?> aspect) {\n"
+ "		Method setter = null;\n"
+ "		try {\n"
+ "			if(value != null) {\n"
+ "				setter = aspect.getMethod(propertyName, ((fr.inria.diverse.k3.al.annotationprocessor.Aspect)aspect.getAnnotations()[0]).className(), value.getClass());\n"
+ "			}else {\n"
+ "				for (Method m : aspect.getMethods()) {\n"
+ "					if (m.getName().compareTo(propertyName) ==0 && m.getParameterCount() == 2) {\n"
+ "						setter= m;\n"
+ "						return setter;\n"
+ "					}\n"
+ "				}\n"
+ "				throw new NoSuchMethodException();\n"
+ "			}\n"
+ "			return setter;\n"
+ "		} catch (NoSuchMethodException | SecurityException | IllegalArgumentException e) {\n"
+ "			\n"
+ "				for(Class<?> c : ((fr.inria.diverse.k3.al.annotationprocessor.Aspect)aspect.getAnnotations()[0]).getClass().getInterfaces()) {\n"
+ "					try {\n"
+ "						if(value != null) {\n"
+ "							setter = aspect.getMethod(propertyName, c, value.getClass());\n"
+ "							return setter;\n"
+ "						}\n"
+ "					} catch (NoSuchMethodException | SecurityException | IllegalArgumentException e1) {\n"
+ "					}\n"
+ "					for (Method m : aspect.getMethods()) {\n"
+ "						if (m.getName().compareTo(propertyName) ==0 && m.getParameterCount() == 2) {\n"
+ "							setter= m;\n"
+ "							return setter;\n"
+ "						}\n"
+ "					}\n"
+ "					\n"
+ "				}\n"
+ "				if (setter == null) {\n"
+ "					throw new RuntimeException(\"no method found for \"+value.getClass().getName()+\"::set\"+propertyName);\n"
+ "				}\n"
+ "			}\n"
+ "		return setter;\n"
+ "	}};";

	
	public static final String MODEL_STATE_CLASS_TEMPLATE =
"/* GENERATED FILE, do not modify manually                                                    *\n" +
" * If you need to modify it, copy it first */\n" +
"package ${package.name};\n"+
"import java.io.Serializable;\n" + 
"import java.lang.reflect.Method;\n" +
"import java.util.Collection;\n" +
"import java.util.HashSet;\n" +
"import java.util.Map;" +
"import java.lang.reflect.InvocationTargetException;\n" + 
"import org.eclipse.emf.common.util.TreeIterator;\n" + 
"import org.eclipse.emf.ecore.EObject;\n" + 
"import org.eclipse.emf.ecore.EStructuralFeature.Setting;\n" + 
"import org.eclipse.emf.ecore.resource.Resource;\n" +
"import org.eclipse.emf.ecore.util.EcoreUtil;\n" +
"import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.ElementState;\n" + 
"import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelState;\n" + 
"import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelStateFactory;\n"+
"import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.dsa.helper.IK3ModelStateHelper;\n"+
"import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.utils.Copier;\n"+
"import org.eclipse.gemoc.executionframework.engine.commons.K3DslHelper;\n"+
"import java.util.ArrayList;\n"
+ "import java.util.Arrays;\n"
+ "import java.util.List;\n"+
"${extraImports}\n"+
"\n"+
"public class ${language.name.toupperfirst}ModelStateHelper implements IK3ModelStateHelper{\n"+ 
"\tprivate static class AttributeNameToValue implements Serializable{\n" + 
"\t\tprivate static final long serialVersionUID = 0;\n"+
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
"		}\n" + 
"	}\n"+
"	K3ModelStateFactory theFactory = K3ModelStateFactory.eINSTANCE; \n"+
"${saveAndRestoreMethod}\n"+
"\n" + 
"	public void restoreModelState(K3ModelState state) {\n"
+ "		for(ElementState elemState : state.getOwnedElementstates()) {\n"
+ "			for(Object o : elemState.getSavedRTDs()) {\n"
+ "				AttributeNameToValue n2v = (AttributeNameToValue)o;\n"
+ "				org.eclipse.gemoc.executionframework.engine.Activator.getDefault().debug(String.format(\"Restoring %s.%s := %s\",\n"
+ "						elemState.getModelElement(), n2v.name,n2v.value.toString()));\n"
+ "				Method setter = null;\n"
+ "				setter = getRestorePropertySetter(elemState.getModelElement().getClass(), n2v);\n"
+ "				try {\n"
+ "					setter.invoke(null, elemState.getModelElement(), n2v.value);\n"
+ "				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {\n"
+ "					e.printStackTrace();\n"
+ "				}\n"
+ "				\n"
+ "			}\n"
+ "		}\n"
+ "	}\n"
+ "\n"
+ "\n"

+ "	private Method getRestorePropertySetter(Class<?> targetClass, AttributeNameToValue n2v) {\n"
+ "		Method setter = null;\n"
+ "		try {\n"
+ "			for(Method m2 : ${language.name.toupperfirst}RTDAccessor.class.getMethods()) {\n"
+ "				if(m2.getName().equals(\"restoreProperty_\"+n2v.name) && m2.getParameterTypes().length == 2) {\n"
+ "					if(m2.getParameterTypes()[0].isAssignableFrom(targetClass) &&\n"
+ "							(n2v.value == null || m2.getParameterTypes()[1].isAssignableFrom(n2v.value.getClass()))	) {\n"
+ "						setter = m2;\n"
+ "						break;\n"
+ "					}\n"
+ "				}\n"
+ "			}\n"
+ "			if (setter == null) {\n"
+ "				throw new RuntimeException(\"no method found for restoreProperty_\"+n2v.name+\"(\"+targetClass+\", \"+n2v.value.getClass().getName()+\")\");\n"
+ "			}\n"
+ "			return setter;\n"
+ "		} catch (SecurityException | IllegalArgumentException e) {\n"
+ "			throw new RuntimeException(\"no method found for set\"+n2v.name+\"(\"+targetClass+\", \"+n2v.value.getClass().getName()+\")\");\n"
+ "		}\n"
+ "	}\n"
+ "	\n"
+ "	public static List<Class> getSuperClasses(Class c) {\n"
+ "		List<Class> r = new ArrayList<>();\n"
+ "		List<Class> q = new ArrayList<>();\n"
+ "		q.add(c);\n"
+ "		while (!q.isEmpty()) {\n"
+ "			c = q.remove(0);\n"
+ "			r.add(c);\n"
+ "			if (c.getSuperclass() != null) {\n"
+ "				q.add(c.getSuperclass());\n"
+ "			}\n"
+ "			for (Class i : c.getInterfaces()) {\n"
+ "				q.add(i);\n"
+ "			}\n"
+ "		}\n"
+ "		return r;\n"
+ "	}\n"
+ "};";
	
}
