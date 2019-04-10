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

import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.views.stimulimanager.filters.IEventFilterStrategy;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class ViewContentProvider implements IStructuredContentProvider 
{
	private IEventFilterStrategy filterStrategy;

	public void inputChanged(Viewer v, Object oldInput, Object newInput) {}

	public void dispose() {}

	public Object[] getElements(Object parent) 
	{
		if(parent instanceof ModelSpecificEventSet)
		{
			ModelSpecificEventSet cache = (ModelSpecificEventSet) parent;
			ArrayList<ModelSpecificEventWrapper> listeClockWrapper = 
					new ArrayList<ModelSpecificEventWrapper>(cache.getFilteredMSEs(filterStrategy));
			return listeClockWrapper.toArray();
		}
		return new Object[0];
	}

	public void setFilterStrategy(IEventFilterStrategy filterStrategy) 
	{
		this.filterStrategy = filterStrategy;
	}
}

