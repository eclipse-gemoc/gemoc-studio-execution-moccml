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
package cnrs.luchogie.up.system;

import java.awt.Color;

import toools.math.MathsUtilities;

/**
 * @author Luc Hogie
 * 
 *         GraduationStepProperties defines the value of the step, its color,
 *         its font and its angle at each step of a graduation. This is a
 *         default implementation and users may derive it.
 * 
 *         Why subclassing it? Because maybe you want to put some special text
 *         at determined steps, or particular color? You can set to graduation
 *         line where you want... And a lot more.
 */
public class GraduationStepProperties
{
	public String getTextAt(double step)
	{
		int intStep = (int) step;

		if (step == intStep)
		{
			return Integer.toString(intStep);
		}
		else
		{
			double r = MathsUtilities.round(step, 6);
			
			if (MathsUtilities.isInteger(r))
			{
//				return String.valueOf(TextUtilities.toHumanString((int) r));
				return String.valueOf((int)r);
			}
			else
			{
				return String.valueOf(r);
			}
			
		}
	}

	public Color getLineColorAt(double step)
	{
		return null;
	}

	public Color getTextColorAt(double step)
	{
		return null;
	}

	public int getLineLengthAt(double step)
	{
		return 3;
	}

	/**
	 * This feature is not yet supported.
	 * 
	 * @param textAngle
	 */
	public int getTextAngleAt(double step)
	{
		return 0;
	}
}
