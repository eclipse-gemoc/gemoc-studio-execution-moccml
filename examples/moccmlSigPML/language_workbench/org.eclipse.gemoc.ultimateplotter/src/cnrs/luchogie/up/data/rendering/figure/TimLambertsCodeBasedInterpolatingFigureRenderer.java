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

import cnrs.luchogie.up.data.Figure;
import cnrs.luchogie.up.data.Point;
import cnrs.luchogie.up.system.Dimension;
import cnrs.luchogie.up.system.Space;


public abstract class TimLambertsCodeBasedInterpolatingFigureRenderer
	extends InterpolatingFigureRenderer
{
	protected Polygon pts;

	protected void init(Figure figure, Space space)
	{
		pts = new Polygon();

		for (int i = 0; i < figure.getPointCount(); ++i)
		{
			Point p = figure.getPointAt(i);
			Dimension xDimension = space.getXDimension();
			Dimension yDimension = space.getYDimension();

			int px = xDimension.convertToGraphicsCoordonateSystem(p.getX());
			int py = yDimension.convertToGraphicsCoordonateSystem(p.getY());
			pts.addPoint(px, py);
		}
	}

	public class Cubic
	{
		float a;/* a + b*u + c*u^2 +d*u^3 */
		float b;/* a + b*u + c*u^2 +d*u^3 */
		float c;/* a + b*u + c*u^2 +d*u^3 */
		float d;/* a + b*u + c*u^2 +d*u^3 */

		public Cubic(float a, float b, float c, float d)
		{
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}

		public float eval(float u)
		{
			return (((d * u) + c) * u + b) * u + a;
		}
	}
}