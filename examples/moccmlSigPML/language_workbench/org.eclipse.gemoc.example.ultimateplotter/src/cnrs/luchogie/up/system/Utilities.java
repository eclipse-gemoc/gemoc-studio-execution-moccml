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
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * @author luc
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class Utilities
{
	/**
	 * Double precision arithmetics works too bad on integer values.
	 * This convert 1.0000000001 to 1
	public static double round( double a )
	{
		a *= 1000000000;
		a = java.lang.Math.round(a);
		a /= 1000000000;
    	return a;
	}
     */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<?> colorList = new Vector(Arrays.asList(new Object[] {Color.red, Color.blue, Color.green, Color.yellow, Color.orange}));
}
