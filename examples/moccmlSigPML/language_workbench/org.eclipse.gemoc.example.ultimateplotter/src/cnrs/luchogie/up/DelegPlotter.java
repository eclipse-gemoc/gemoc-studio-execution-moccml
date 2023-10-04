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

/**
 * @author luc.hogie
 * Created on Jun 4, 2004
 */
public class DelegPlotter
{
	private Graphics2DPlotter graphics2DPlotter;

	public Graphics2DPlotter getGraphics2DPlotter()
	{
		return graphics2DPlotter;
	}

	public void setGraphics2DPlotter(Graphics2DPlotter plotter)
	{
		graphics2DPlotter = plotter;
	}

}
