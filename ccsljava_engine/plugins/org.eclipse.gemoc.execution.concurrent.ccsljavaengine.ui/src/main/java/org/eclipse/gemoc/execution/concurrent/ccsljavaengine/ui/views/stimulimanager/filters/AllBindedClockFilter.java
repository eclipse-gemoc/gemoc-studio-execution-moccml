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
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.views.stimulimanager.filters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.views.stimulimanager.ModelSpecificEventWrapper;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Binding;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Relation;

/**
 * @author: lguillem
 */
public class AllBindedClockFilter extends Filter {

	@Override
	public Collection<ModelSpecificEventWrapper> applyFilter() {
		for(Relation relation: relations)
		{
			List<Binding> bindings = relation.getBindings();
			String leftBindingClockName = bindings.get(0).getBindable().getName();
			String rightBindingClockName = bindings.get(1).getBindable().getName();
	
			List<ModelSpecificEventWrapper> copyWrapperList = new ArrayList<ModelSpecificEventWrapper>(wrapperList);
			
			for(ModelSpecificEventWrapper clockWrapper: copyWrapperList)
			{
				String nameClock = clockWrapper.getMSE().getName();
				if(  nameClock == leftBindingClockName || nameClock == rightBindingClockName )
				{
					wrapperList.remove(clockWrapper);
				}
			}
		}
		addFutureTickingClocks();
		return wrapperList;
	}
}
