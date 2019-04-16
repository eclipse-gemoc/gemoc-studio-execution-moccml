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
package cnrs.luchogie.up.data.rendering.figure;


import java.awt.Polygon;

import cnrs.luchogie.up.data.DataElement;
import cnrs.luchogie.up.data.Figure;
import cnrs.luchogie.up.data.Point;
import cnrs.luchogie.up.system.Space;
/**
 * @author Luc Hogie
 */
public class PolygonFigureRenderer extends FigureRenderer
{
	private boolean filled = true;

	/**
	 * @see org.lucci.plt.data.DataRenderer#draw(DataObject, Space)
	 */
	public void drawImpl(DataElement object, Space space)
	{
		Figure pointList = (Figure) object;
		int pointCount = pointList.getPointCount();
		Polygon polygon = new Polygon();
	
		for (int i = 0; i < pointCount; ++i)
		{
			Point point = pointList.getPointAt(i);
			int px = space.getXDimension().convertToGraphicsCoordonateSystem(point.getX());
			int py = space.getYDimension().convertToGraphicsCoordonateSystem(point.getY());
			polygon.addPoint(px, py);
		}
		
		if ( filled )
		{
			space.getFigureGraphics().fillPolygon(polygon);
		}
		else
		{
			space.getFigureGraphics().drawPolygon(polygon);
		}
	}

	/**
	 * Returns the filled.
	 * @return boolean
	 */
	public boolean isFilled()
	{
		return filled;
	}

	/**
	 * Sets the filled.
	 * @param filled The filled to set
	 */
	public void setFilled(boolean filled)
	{
		this.filled = filled;
	}
    
    public String getPublicName()
    {
        return "polygone";
    }

}
