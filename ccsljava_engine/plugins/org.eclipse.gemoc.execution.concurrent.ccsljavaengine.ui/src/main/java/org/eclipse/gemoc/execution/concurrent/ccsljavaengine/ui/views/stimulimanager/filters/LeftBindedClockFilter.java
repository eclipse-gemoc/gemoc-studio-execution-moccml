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

public class LeftBindedClockFilter extends Filter {

	@Override
	public Collection<ModelSpecificEventWrapper> applyFilter() {
		for(Relation relation: relations)
		{
			List<Binding> bindings = relation.getBindings();
			Binding leftBinding = bindings.get(0);
			// We copy the collection and scan the copy to be able to delete some of the element while we are in the for()
			// else there is a problem.
			List<ModelSpecificEventWrapper> copyWrapperList = new ArrayList<ModelSpecificEventWrapper>(wrapperList);
			for(ModelSpecificEventWrapper clockWrapper: copyWrapperList)
			{
				if(clockWrapper.getMSE().getName() == leftBinding.getBindable().getName()) 
				{
					wrapperList.remove(clockWrapper);
				}
			}
		}
		addFutureTickingClocks();
		return wrapperList;
	}
}
