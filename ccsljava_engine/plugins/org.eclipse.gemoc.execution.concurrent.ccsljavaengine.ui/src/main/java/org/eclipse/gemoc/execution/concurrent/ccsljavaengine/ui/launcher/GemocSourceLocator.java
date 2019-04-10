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
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.launcher;

import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gemoc.dsl.debug.ide.DSLSourceLocator;
import org.eclipse.gemoc.dsl.debug.ide.adapter.DSLStackFrameAdapter;
import org.eclipse.gemoc.trace.commons.model.helper.StepHelper;
import org.eclipse.gemoc.trace.commons.model.trace.MSE;
import org.eclipse.gemoc.trace.commons.model.trace.Step;

public class GemocSourceLocator extends DSLSourceLocator {

	@Override
	public Object getSourceElement(IStackFrame stackFrame) {
		final Object res;
		if (stackFrame instanceof DSLStackFrameAdapter) {
			final DSLStackFrameAdapter eStackFrame = (DSLStackFrameAdapter) stackFrame;
			final EObject instruction = eStackFrame.getCurrentInstruction();
			if (instruction instanceof Step) {
				res = getFirstTarget((Step) instruction);
			} else if (instruction != null) {
				res = instruction;
			} else {
				res = eStackFrame.getContext();
			}
		} else {
			res = null;
		}
		return res;
	}

	private EObject getFirstTarget(Step step) {
		EObject res = null;

		for (MSE event : StepHelper.collectAllMSEs(step)) 
		{
			res = event;
			break;
		}

		return res;
	}

}
