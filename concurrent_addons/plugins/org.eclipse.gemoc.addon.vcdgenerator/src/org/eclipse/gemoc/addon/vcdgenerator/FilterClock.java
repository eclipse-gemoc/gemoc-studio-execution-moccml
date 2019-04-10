/*******************************************************************************
 * Copyright (c) 2017 I3S laboratory and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     I3S laboratory - initial API and implementation
 *******************************************************************************/
package org.eclipse.gemoc.addon.vcdgenerator;

import org.eclipse.emf.ecore.EObject;

import fr.inria.aoste.timesquare.backend.manager.utils.IFilter;
import fr.inria.aoste.timesquare.backend.manager.visible.ClockEntity;
import fr.inria.aoste.timesquare.trace.util.HelperFactory;
import fr.inria.aoste.timesquare.trace.util.adapter.AdapterRegistry;

public final class FilterClock implements IFilter<ClockEntity> {
	
	@Override
	public boolean accept(ClockEntity o) {
		EObject eo = HelperFactory.getLastReference(o.getModelElementReference());
		return AdapterRegistry.getAdapter(eo).isClock(eo);
	}
}