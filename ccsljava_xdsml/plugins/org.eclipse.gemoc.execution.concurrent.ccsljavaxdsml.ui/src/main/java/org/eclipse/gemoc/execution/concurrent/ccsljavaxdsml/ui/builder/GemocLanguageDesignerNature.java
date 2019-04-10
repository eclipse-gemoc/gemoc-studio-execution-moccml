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
package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.ui.builder;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.gemoc.commons.eclipse.core.resources.AbstractProjectNature;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.ui.Activator;

public class GemocLanguageDesignerNature extends AbstractProjectNature {

	/**
	 * ID of this project nature
	 */
	public static final String NATURE_ID = Activator.PLUGIN_ID+".gemocLanguageDesignerNature";

	@Override
	public void configure() throws CoreException {
		addBuilder(GemocLanguageDesignerBuilder.BUILDER_ID);
	}

	@Override
	public void deconfigure() throws CoreException {
		removeBuilder(GemocLanguageDesignerBuilder.BUILDER_ID);
	}
	
}
