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
import cnrs.luchogie.up.system.Dimension;
import cnrs.luchogie.up.system.Space;

public class XDimensionOriginAxisConnectedPointRenderer extends PointRenderer
{

    public void drawImpl(DataElement object, Space space)
    {
        Point point = (Point) object;
        Dimension xDimension = space.getXDimension();
        Dimension yDimension = space.getYDimension();

        int x = xDimension.convertToGraphicsCoordonateSystem(point.getX());
        int y = yDimension.convertToGraphicsCoordonateSystem(point.getY());
        space.getFigureGraphics().drawLine(x, y, x, (int) space.getOriginPoint().getY());
    }

    public String getPublicName()
    {
        return "connected to Xaxis";
    }

}