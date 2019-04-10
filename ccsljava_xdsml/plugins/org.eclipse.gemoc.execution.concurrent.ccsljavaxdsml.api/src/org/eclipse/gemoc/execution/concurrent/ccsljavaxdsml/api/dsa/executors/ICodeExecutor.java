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
package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dsa.executors;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

import org.eclipse.gemoc.trace.commons.model.trace.MSEOccurrence;


/**
 * A CodeExecutor is an entity responsible for being able to invoke a method on
 * an object and parameters, based on the method's name. It must have knowledge
 * about how the code is compiled into Java Bytecode, and if any particular
 * strategy must be used to locate the correct method.
 * 
 */
public interface ICodeExecutor 
{
	
	Object execute(MSEOccurrence mseOccurrence) throws CodeExecutionException;
	Object execute(Object caller, String methodName, List<Object> parameters) throws CodeExecutionException;
	
	/** allows to find methods applicable to the caller with a given list of parameters and with an annotation regardless of the method name */
	List<Method> findCompatibleMethodsWithAnnotation(Object caller, List<Object> parameters, Class<? extends Annotation> annotationClass);
	
	String getExcutorID();

}
