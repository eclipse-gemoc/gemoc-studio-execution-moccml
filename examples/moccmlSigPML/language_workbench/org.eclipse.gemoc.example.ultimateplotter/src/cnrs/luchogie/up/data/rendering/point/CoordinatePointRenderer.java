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
package cnrs.luchogie.up.data.rendering.point;

import cnrs.luchogie.up.data.DataElement;
import cnrs.luchogie.up.data.Point;
import cnrs.luchogie.up.system.Space;

/**
 * @author Administrateur
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class CoordinatePointRenderer extends TextPointRenderer
{
	/**
	 * @see org.lucci.plt.data.DataRenderer#draw(DataObject, Space)
	 */
	public void drawImpl(DataElement object, Space space)
	{
		Point point = (Point) object;
		setText( "(" + point.getX() + ", " + point.getY() + ")" );
		setXShift(0);
		setYShift(10);
		super.drawImpl(object, space);
	}
}
