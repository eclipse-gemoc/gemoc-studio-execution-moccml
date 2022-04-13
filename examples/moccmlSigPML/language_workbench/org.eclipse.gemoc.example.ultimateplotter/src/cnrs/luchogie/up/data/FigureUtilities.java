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
package cnrs.luchogie.up.data;

/**
 * @author luc.hogie
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class FigureUtilities extends Figure
{
	public static Point getClosestPoint(final Point referencePoint, final Figure figure)
	{
		if (figure == null)
			throw new NullPointerException();
			
		Point closestPoint = null;
		double distance = Integer.MAX_VALUE;

		for (Point p : figure.retrieveAllPoints())
		{
			double d = p.getDistanceTo(referencePoint);
				
			if (d < distance)
			{
				distance = d;
				closestPoint = p;
			}
		}

		return closestPoint;
	}

}
