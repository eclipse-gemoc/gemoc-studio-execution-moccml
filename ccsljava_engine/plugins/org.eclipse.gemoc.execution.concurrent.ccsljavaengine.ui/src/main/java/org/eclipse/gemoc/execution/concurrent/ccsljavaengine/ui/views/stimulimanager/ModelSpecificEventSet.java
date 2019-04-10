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
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.views.stimulimanager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.views.stimulimanager.filters.IEventFilterStrategy;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.ActionModel;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.ModelSpecificEvent;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Relation;

public class ModelSpecificEventSet 
{
	
	private Map<String, ModelSpecificEventWrapper> _mseMap = new HashMap<String, ModelSpecificEventWrapper>();

	private List<Relation> _relations = new ArrayList<Relation>();

	
	public ModelSpecificEventSet(ActionModel model) 
	{
//		for(Relation r : clockConstraintSystem.getSubBlock().get(0).getRelations())
//		{
//			if (r instanceof Relation)
//			{
//				_relations.add((Relation)r);
//			}
//		}
		if (model != null)
		{
			for (ModelSpecificEvent mse : model.getEvents())
			{
				add(mse);
			}
		}
	}

	/**
	 * Wrap a clock and add it to the wrapper amp. 
	 * @param mse the clock to be 'wrapped' 
	 */
	private void add(ModelSpecificEvent mse) 
	{
		ModelSpecificEventWrapper wrapper = new ModelSpecificEventWrapper(mse);
		_mseMap.put(mse.getName(), wrapper);
	}
	
	/**
	 * Return the wrappers for the corresponding strategy.
	 * @param filter the strategy to applied on the wrapper map
	 * @return The filtered wrappers for the current cache
	 */
	public Collection<ModelSpecificEventWrapper> getFilteredMSEs(IEventFilterStrategy filter) 
	{
		filter.setParamFilter(_relations, _mseMap);
		return filter.applyFilter();
	}
	
	public ModelSpecificEventWrapper getMSE(String clockName) 
	{
		return _mseMap.get(clockName);
	}

	public Collection<ModelSpecificEventWrapper> getMSEs() 
	{
		return _mseMap.values();
	}

	
}
