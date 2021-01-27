/*******************************************************************************
 * Copyright (c) 2017 INRIA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     I3S Laboratory - initial API and implementation
 *******************************************************************************/
package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.moc;

import java.util.List;

import org.eclipse.gemoc.trace.commons.model.trace.Step;

/**
 * class used to drive the execution engine in an exhaustive simulation... Which may require different action than the classical simulation
 * TO BE SANITIZED
 * @author julien.deantoni@univ-cotedazur.fr
 *
 */
public interface ICCSLExplorer{

	
	public void initSolverForExploration();
	public void prepareSolverForNewStepForExploration();
	public void resetCurrentStepForExploration();
	public List<Step<?>> computeAndGetPossibleLogicalStepsForExploration();
	public void applyLogicalStepForExploration(Step<?> logicalStep);


}
