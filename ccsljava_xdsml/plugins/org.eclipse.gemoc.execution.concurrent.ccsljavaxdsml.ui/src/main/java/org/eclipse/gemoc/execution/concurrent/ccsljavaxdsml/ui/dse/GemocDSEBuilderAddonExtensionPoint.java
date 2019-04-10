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

import java.util.ArrayList;

import org.eclipse.gemoc.xdsmlframework.api.extensions.ExtensionPoint;

public class GemocDSEBuilderAddonExtensionPoint extends ExtensionPoint<GemocDSEBuilderAddonExtension>
{

	public static final String GEMOC_DSE_BUILDER_ADDON_EXTENSION_POINT = "org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.ui.dse.builder_addon";
	public static final String GEMOC_DSE_BUILDER_ADDON_EXTENSION_POINT_ID = "id";
	public static final String GEMOC_DSE_BUILDER_ADDON_EXTENSION_POINT_NAME = "Name";
	public static final String GEMOC_DSE_BUILDER_ADDON_EXTENSION_POINT_SHORTDESCRIPTION = "ShortDescription";
	public static final String GEMOC_DSE_BUILDER_ADDON_EXTENSION_POINT_CLASS = "Class";
	public static final String GEMOC_DSE_BUILDER_ADDON_EXTENSION_POINT_DEFAULT = "Default";

	protected GemocDSEBuilderAddonExtensionPoint() 
	{
		super(GemocDSEBuilderAddonExtension.class);
	}

	private static GemocDSEBuilderAddonExtensionPoint _singleton;
	
	private static GemocDSEBuilderAddonExtensionPoint getExtensionPoint()
	{
		if (_singleton == null)
		{
			_singleton = new GemocDSEBuilderAddonExtensionPoint();
		}
		return _singleton;
	}
		
	static public ArrayList<GemocDSEBuilderAddonExtension> getSpecifications()
	{
		return (ArrayList<GemocDSEBuilderAddonExtension>) getExtensionPoint().internal_getSpecifications();
	}
	
	@Override
	protected String getExtensionPointName() 
	{
		return GEMOC_DSE_BUILDER_ADDON_EXTENSION_POINT;
	}
	

	
}
