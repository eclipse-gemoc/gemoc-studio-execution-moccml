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
package cnrs.luchogie.up;

import java.util.Collection;

import cnrs.luchogie.up.data.Point;


/**
 * @author luc.hogie
 */
public interface InteractiveSwingPlotterListener extends SwingPlotterListener
{
	void pointsSelected(SwingPlotter sp, Collection<Point> points);
}
