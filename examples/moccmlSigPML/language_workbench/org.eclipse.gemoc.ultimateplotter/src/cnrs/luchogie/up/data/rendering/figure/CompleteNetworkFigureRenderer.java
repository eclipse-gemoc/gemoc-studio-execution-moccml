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




import cnrs.luchogie.up.data.DataElement;
import cnrs.luchogie.up.data.Figure;
import cnrs.luchogie.up.data.Point;
import cnrs.luchogie.up.system.Dimension;
import cnrs.luchogie.up.system.Space;

/**
 * @author Luc Hogie
 * 
 * This renderer draws a line between each point of the figure. This draws
 * a complete network.
 */


public class CompleteNetworkFigureRenderer extends FigureRenderer
{
	/**
	 * @see org.lucci.plt.data.DataRenderer#draw(DataObject, Space)
	 */
	public void drawImpl(DataElement object, Space space)
	{
		Figure pointList = (Figure) object;
		int pointCount = pointList.getPointCount();

		for (int i = 0; i < pointCount; ++i)
		{
			Point point = pointList.getPointAt(i);
			Dimension xDimension = space.getXDimension();
			Dimension yDimension = space.getYDimension();

			int px = xDimension.convertToGraphicsCoordonateSystem(point.getX());
			int py = yDimension.convertToGraphicsCoordonateSystem(point.getY());

			for (int j = 0; j < pointCount; ++j)
			{
				if ( i != j )
				{
					Point otherPoint = pointList.getPointAt(j);
					int opx = xDimension.convertToGraphicsCoordonateSystem(otherPoint.getX());
					int opy = yDimension.convertToGraphicsCoordonateSystem(otherPoint.getY());
					space.getFigureGraphics().drawLine( opx, opy, px, py );
				}
			}
		}
	}
    
    public String getPublicName()
    {
        return "complete network";
    }

}
