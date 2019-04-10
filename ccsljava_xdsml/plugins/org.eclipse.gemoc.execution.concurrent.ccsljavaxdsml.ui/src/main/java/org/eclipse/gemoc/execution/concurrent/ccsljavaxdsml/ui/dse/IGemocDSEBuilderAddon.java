/*******************************************************************************
 * Copyright (c) 2017 INRIA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     INRIA - initial API and implementation
 *******************************************************************************/
package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.ui.dse;

import org.eclipse.core.resources.IResource;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.ui.Activator;

public interface IGemocDSEBuilderAddon {
	
	public static final String BUILDER_ID = Activator.PLUGIN_ID+".dse_builder";

	public static final String MARKER_TYPE = Activator.PLUGIN_ID+".dse_problem";

	public void processResourceAddon(IResource resource);
	
}
