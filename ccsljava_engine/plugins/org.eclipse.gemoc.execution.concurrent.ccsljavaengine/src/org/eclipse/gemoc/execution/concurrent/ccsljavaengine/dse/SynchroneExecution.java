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

import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.engine.ConcurrentExecutionEngine;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dsa.executors.CodeExecutionException;
import org.eclipse.gemoc.executionframework.engine.Activator;
import org.eclipse.gemoc.trace.commons.model.trace.SmallStep;
import org.eclipse.gemoc.trace.commons.model.trace.Step;

public class SynchroneExecution extends OperationExecution {

	public SynchroneExecution(SmallStep<?> smallStep, ConcurrentExecutionEngine engine, Consumer<Step<?>> beforeStep,
			Runnable afterStep) {
		super(smallStep, engine, beforeStep, afterStep);
	}

	@Override
	public void run() throws CodeExecutionException {

		beforeStepCallback(getSmallStep());
		Object res = callExecutor();
		setResult(res);
		try {
			applyAnimationTime();
		} catch (InterruptedException e) {
			Activator.getDefault().error("Exception received " + e.getMessage(), e);
		}
		afterStepCallback();
	}

	/**
	 * Calls the {@link EventExecutor} for the given {@link EngineEventOccurence}.
	 * 
	 * @param mse the {@link EngineEventOccurence} to execute
	 * @return the {@link FeedbackData} if any, <code>null</code> other wise
	 * @throws CodeExecutionException
	 */
	private Object callExecutor() throws CodeExecutionException {
		Object res = null;

		res = getExecutionContext().getExecutionPlatform().getCodeExecutor().execute(getSmallStep().getMseoccurrence());

		return res;
	}

	private void applyAnimationTime() throws InterruptedException {
		int animationDelay = getEngine().getExecutionContext().getRunConfiguration().getAnimationDelay();
		if (animationDelay != 0) {
			Thread.sleep(animationDelay);
		}
	}

}
