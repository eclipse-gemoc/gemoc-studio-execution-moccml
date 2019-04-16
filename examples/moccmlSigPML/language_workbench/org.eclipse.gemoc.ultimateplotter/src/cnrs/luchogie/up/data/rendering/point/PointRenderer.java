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

import cnrs.luchogie.up.data.Point;
import cnrs.luchogie.up.data.rendering.DataElementRenderer;

public abstract class PointRenderer extends DataElementRenderer
{
	private int xShift = 0;
	private int yShift = 0;


    public int getXShift()
    {
        return xShift;
    }

    public int getYShift()
    {
        return yShift;
    }

    public void setXShift(int xShift)
    {
        this.xShift = xShift;
    }

    public void setYShift(int yShift)
    {
        this.yShift = yShift;
    }

	/**
	 * @see org.lucci.up.data.DataElementRenderer#getRenderableDataElementClass()
	 */
	public Class<?> getRenderableDataElementClass()
	{
		return Point.class;
	}

}
