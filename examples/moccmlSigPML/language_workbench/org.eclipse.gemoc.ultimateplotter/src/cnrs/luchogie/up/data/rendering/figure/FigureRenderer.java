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

import cnrs.luchogie.up.data.rendering.DataElementRenderer;

/**
 * @author Luc Hogie
 */
public abstract class FigureRenderer extends DataElementRenderer
{
	private boolean shownPointReductionEnabled = false;

	public boolean isShownPointReductionEnabled()
	{
		return shownPointReductionEnabled;
	}

	public void setShownPointReductionEnabled(boolean b)
	{
		shownPointReductionEnabled = b;
	}

}
