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
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.dse;

import java.util.function.Consumer;

import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.commons.MoccmlModelExecutionContext;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.AbstractConcurrentExecutionEngine;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dsa.executors.CodeExecutionException;
import org.eclipse.gemoc.trace.commons.model.trace.SmallStep;
import org.eclipse.gemoc.trace.commons.model.trace.Step;

public abstract class OperationExecution {

	private SmallStep<?> smallStep;
	private AbstractConcurrentExecutionEngine _engine;
	private Object _result;
	private Consumer<Step<?>> beforeStepCallback;
	private Runnable afterStepCallback;

	protected OperationExecution(SmallStep<?> smallStep, AbstractConcurrentExecutionEngine engine,
			Consumer<Step<?>> beforeStepCallback, Runnable afterStepCallback) {
		this.smallStep = smallStep;
		_engine = engine;
		this.beforeStepCallback = beforeStepCallback;
		this.afterStepCallback = afterStepCallback;
	}

	protected void beforeStepCallback(Step<?> s) {
		beforeStepCallback.accept(s);
	}

	protected void afterStepCallback() {
		afterStepCallback.run();
	}

	abstract public void run() throws CodeExecutionException;

	protected MoccmlModelExecutionContext getExecutionContext() {
		return (MoccmlModelExecutionContext) _engine.getExecutionContext();
	}

	protected AbstractConcurrentExecutionEngine getEngine() {
		return _engine;
	}

	protected SmallStep<?> getSmallStep() {
		return smallStep;
	}

	protected void setResult(Object result) {
		_result = result;
	}

	protected Object getResult() {
		return _result;
	}
}
