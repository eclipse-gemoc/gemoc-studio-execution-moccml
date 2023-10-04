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
import cnrs.luchogie.up.system.Space;


public class BSplineFigureRenderer
	extends TimLambertsCodeBasedInterpolatingFigureRenderer
{
	public void drawImpl(DataElement object, Space space)
	{
		init( (Figure) object, space);		
		Polygon pol = new Polygon();
		java.awt.Point q = p(2, 0);
		pol.addPoint(q.x, q.y);

		for (int i = 2; i < pts.npoints - 1; i++)
		{
			float STEPS = getStepCount();

			for (int j = 1; j <= STEPS; j++)
			{
				q = p(i, j / (float)STEPS);
				pol.addPoint(q.x, q.y);
			}
		}

		space.getFigureGraphics().drawPolyline(pol.xpoints, pol.ypoints, pol.npoints);
	}

	float b(int i, float t)
	{
		switch (i)
		{
			case -2:
				return (((-t + 3) * t - 3) * t + 1) / 6;
			case -1:
				return (((3 * t - 6) * t) * t + 4) / 6;
			case 0:
				return (((-3 * t + 3) * t + 3) * t + 1) / 6;
			case 1:
				return (t * t * t) / 6;
		}

		return 0; //we only get here if an invalid i is specified
	}

	java.awt.Point p(int i, float t)
	{
		float px = 0;
		float py = 0;

		for (int j = -2; j <= 1; j++)
		{
			px += b(j, t) * pts.xpoints[ i + j ];
			py += b(j, t) * pts.ypoints[ i + j ];
		}

		return new java.awt.Point((int)Math.round(px), (int)Math.round(py));
	}
    
    public String getPublicName()
    {
        return "B-splines";
    }

}