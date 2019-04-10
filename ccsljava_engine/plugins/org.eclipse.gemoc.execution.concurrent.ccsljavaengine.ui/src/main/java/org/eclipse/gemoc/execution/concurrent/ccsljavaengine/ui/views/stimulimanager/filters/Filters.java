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

/**
 * Store a "mapping" of all declared filters with a name
 */
public enum Filters
{
	ALL("All Events", new NoFilter()),
	NO_LEFT_BIND("No Left binded Clocks", new LeftBindedClockFilter()),
	NO_BIND("Free Clocks", new AllBindedClockFilter());

	private Filter f;
	private String name;

	Filters(String name, Filter f)
	{
		this.name = name;
		this.f = f;
	}

	public Filter getFilter()
	{
		return f;
	}

	public String getName()
	{
		return name;
	}
}