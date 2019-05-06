/*******************************************************************************
 * Copyright (c) 2015, 2017  I3S Laboratory  and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     I3S Laboratory - initial API and implementation
 *******************************************************************************/
package cnrs.luchogie.up.data.event;

import java.util.EventListener;

import cnrs.luchogie.up.data.DataElement;
import cnrs.luchogie.up.data.rendering.DataElementRenderer;

/**
 * @author luc
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public interface DataElementListener extends EventListener
{
	void renderedAdded( DataElement dataElement, DataElementRenderer renderer );
	void renderedRemoved( DataElement dataElement, DataElementRenderer renderer );
}
