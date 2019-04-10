/*******************************************************************************
 * Copyright (c) 2017 I3S laboratory, INRIA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     I3S laboratory and INRIA Kairos - initial API and implementation
 *******************************************************************************/
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.dsa.executors.explorer;

import grph.Grph;
import grph.oo.ObjectGrph;

public class StateSpace extends ObjectGrph<ControlAndRTDState, StringBuffer> {
	
	public Grph getGrph(){
		return this.backingGrph;
	}
	
	public ControlAndRTDState initialState = null;

	public int v2i(ControlAndRTDState v) {
		return super.v2i(v);
	}
	
}
