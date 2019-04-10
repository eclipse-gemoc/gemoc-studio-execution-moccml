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
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.dsa.executors;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dsa.executors.CodeExecutionException;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dsa.executors.ICodeExecutor;
import org.eclipse.gemoc.trace.commons.model.trace.MSEOccurrence;

/**
 * An aggregation of several CodeExecutors.
 * The actual invoke command will be dispatched to the first CodeExecutor that is able to handle it 
 * @author dvojtise
 * @author flatombe
 * 
 */
public class CodeExecutorDispatcher implements ICodeExecutor 
{

	protected List<ICodeExecutor> _executors = null;

	public CodeExecutorDispatcher() 
	{
		_executors = new ArrayList<ICodeExecutor>();
	}

	public CodeExecutorDispatcher(ICodeExecutor codeExecutor) 
	{
		this();
		addExecutor(codeExecutor);
	}

	public CodeExecutorDispatcher(List<ICodeExecutor> codeExecutors) 
	{
		this();
		for (ICodeExecutor codeExecutor : codeExecutors) 
		{
			addExecutor(codeExecutor);
		}
	}

	public void addExecutor(ICodeExecutor executor) 
	{
		_executors.add(executor);
	}

	@Override
	public Object execute(MSEOccurrence mseOccurrence) throws CodeExecutionException 
	{		
		int count = 0;
		for (ICodeExecutor executor : _executors) 
		{
			count++;
			try {
				return executor.execute(mseOccurrence);
			} catch (CodeExecutionException e) 
			{
				if (e.isCodeExecutionApplicable()){
					org.eclipse.gemoc.execution.concurrent.ccsljavaengine.Activator.getDefault().error( "Code executor("+count+"/"+_executors.size()+") "+executor.getExcutorID()+" wasn't able to process the request. "+e.getMessage(), e);
					//org.eclipse.gemoc.executionframework.engine.commons.Activator.getDefault().error("", e);
					throw new CodeExecutionException("An applicable code executor was found but failed due to "+e.getMessage(), mseOccurrence);
				}else{
					org.eclipse.gemoc.execution.concurrent.ccsljavaengine.Activator.getDefault().debug( "Code executor("+count+"/"+_executors.size()+") "+executor.getExcutorID()+" wasn't able to process the request. "+e.getMessage());
				}
			}
		}
		throw new CodeExecutionException("No code executor could perform the action call. (a commons mistake is : missing package export of the called class or aspect)", mseOccurrence);
	}

	@Override
	public Object execute(Object caller, String methodName,
			List<Object> parameters) throws CodeExecutionException {
		for (ICodeExecutor executor : _executors) 
		{
			try {
				return executor.execute(caller, methodName, parameters);
			} catch (CodeExecutionException e) 
			{
				//e.printStackTrace();
			}
		}
		throw new CodeExecutionException("No code executor could perform the action call. (a commons mistake is : missing package export of the called class or aspect)", null);
	}
	
	@Override
	public List<Method> findCompatibleMethodsWithAnnotation(Object caller,
			List<Object> parameters, Class<? extends Annotation> annotationClass) {
		ArrayList<Method> result = new ArrayList<Method>();
		for (ICodeExecutor executor : _executors) 
		{
			result.addAll(executor.findCompatibleMethodsWithAnnotation(caller, parameters, annotationClass));
		}
		return result;
	}
	
	@Override
	public String getExcutorID() {
		return this.getClass().getSimpleName();
	}

	
}