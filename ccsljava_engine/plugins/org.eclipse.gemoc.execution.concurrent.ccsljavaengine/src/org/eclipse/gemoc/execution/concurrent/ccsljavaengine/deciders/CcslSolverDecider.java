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
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.deciders;

import java.util.List;

import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.engine.MoccmlExecutionEngine;
import org.eclipse.gemoc.executionframework.engine.concurrency.AbstractConcurrentExecutionEngine;
import org.eclipse.gemoc.executionframework.engine.concurrency.deciders.ILogicalStepDecider;
import org.eclipse.gemoc.trace.commons.model.trace.ParallelStep;

/**
 * Decider that will delegate its choice to the solver
 *
 */
public class CcslSolverDecider implements ILogicalStepDecider {

	@Override
	public ParallelStep<?,?> decide(AbstractConcurrentExecutionEngine<?,?> engine, List<ParallelStep<?,?>> possibleLogicalSteps) {
		MoccmlExecutionEngine moccmlengine = (MoccmlExecutionEngine) engine;
		return moccmlengine.getSolver().proposeLogicalStep();
	}

	@Override
	public void dispose() {
		// nothing to do
	}

	@Override
	public void preempt() {
		// no
	}
}
