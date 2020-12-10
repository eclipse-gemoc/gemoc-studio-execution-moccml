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
package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.moc;

import java.util.Set;

import org.chocosolver.solver.Model;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.AbstractConcurrentModelExecutionContext;
import org.eclipse.gemoc.trace.commons.model.trace.ParallelStep;
import org.eclipse.gemoc.trace.commons.model.trace.Step;
import org.eclipse.gemoc.xdsmlframework.api.core.IDisposable;

/**
 * A Solver is the visible interface of any constraint solver system that runs
 * on its corresponding input based on a Model of Execution, returns Steps upon
 * requests and provides an API to influence the constraint-solving.
 * 
 * @author flatombe
 * @author Julien Deantoni
 */
public interface ISolver extends IDisposable {
	/**
	 * Returns the currently possible LogicalSteps
	 * 
	 * @return a list of LogicalSteps
	 */
	public Model computeAndGetPossibleLogicalSteps();

	/**
	 * Returns the currently possible LogicalSteps
	 * 
	 * @return a list of LogicalSteps
	 */
	public Model updatePossibleLogicalSteps();

	/**
	 * among the currently possible LogicalStep (see {@link getPossibleLogicalSteps}
	 * ), asks the solver to choose one
	 * 
	 * @return the logical step proposed from possible LogicalSteps
	 */
	public ParallelStep<?,?> proposeLogicalStep();

	/**
	 * ask the solver to apply the given LogicalStep and thus compute next step
	 * 
	 * @param the LogicalStep to apply
	 */
	public void applyLogicalStep(ParallelStep<?,?> logicalStep);

	/**
	 * Actions that could be done to prepare the workspace before any model is
	 * loaded Ie. in the context the model is not loaded yet
	 * 
	 * @param concurrentexecutionContext
	 */
	public void prepareBeforeModelLoading(AbstractConcurrentModelExecutionContext concurrentexecutionContext);

	/**
	 * Initialize the solver.
	 * The Executioncontext is supposed to be complete : ie. the model is loaded
	 * 
	 * @param concurrentexecutionContext
	 */
	public void initialize(AbstractConcurrentModelExecutionContext concurrentexecutionContext);


}
