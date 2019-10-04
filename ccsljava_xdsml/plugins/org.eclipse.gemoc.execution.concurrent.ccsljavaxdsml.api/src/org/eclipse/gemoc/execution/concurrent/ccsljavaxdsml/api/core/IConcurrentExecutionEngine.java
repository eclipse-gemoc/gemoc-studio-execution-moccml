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
package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core;

import java.util.List;

import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.moc.ISolver;
import org.eclipse.gemoc.trace.commons.model.trace.Step;
import org.eclipse.gemoc.xdsmlframework.api.core.IExecutionEngine;

public interface IConcurrentExecutionEngine extends IExecutionEngine<IConcurrentExecutionContext> {

	IConcurrentExecutionContext getConcurrentExecutionContext();

	void recomputePossibleLogicalSteps();

	List<Step<?>> getPossibleLogicalSteps();

	Step<?> getSelectedLogicalStep();

	void addFutureAction(IFutureAction action);

	ILogicalStepDecider getLogicalStepDecider();

	void changeLogicalStepDecider(ILogicalStepDecider newDecider);

	ISolver getSolver();

	void setSolver(ISolver solver);

}
