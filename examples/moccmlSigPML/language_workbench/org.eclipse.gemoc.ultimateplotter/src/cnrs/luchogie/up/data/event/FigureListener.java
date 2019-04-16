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
package cnrs.luchogie.up.data.event;




import cnrs.luchogie.up.data.Figure;
import cnrs.luchogie.up.data.Point;


/**
 * @author Luc Hogie
 */

public interface FigureListener extends DataElementListener
{
	void pointInserted( Figure figure, Point point, int position );
	void pointRemoved( Figure figure, Point point, int position );
	void figureInserted( Figure figure, Figure subFigure, int position );
	void figureRemoved( Figure figure, Figure subFigure, int position );
}
