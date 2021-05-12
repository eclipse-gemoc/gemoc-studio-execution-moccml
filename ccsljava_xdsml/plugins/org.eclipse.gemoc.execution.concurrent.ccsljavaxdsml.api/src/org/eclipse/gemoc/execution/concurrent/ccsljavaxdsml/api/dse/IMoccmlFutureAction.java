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
package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dse;

import org.eclipse.gemoc.moccml.mapping.feedback.feedback.ModelSpecificEvent;

public interface IMoccmlFutureAction {

	ModelSpecificEvent getTriggeringMSE();

	void perform();

	ModelSpecificEvent getMseToBeForced();

}
