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

import javax.swing.JFrame;

import cnrs.luchogie.up.data.Figure;
import cnrs.luchogie.up.data.Point;
import cnrs.luchogie.up.data.rendering.figure.ConnectedLineFigureRenderer;

public class SimpleDemo
{
	public static void main(String[] args)
	{
		SwingPlotter plotter = new InteractiveSwingPlotter();

		Figure f = new Figure();
		f.addPoint(new Point(1,  1));
		f.addPoint(new Point(1,  2));
		f.addPoint(new Point(3, 4));
		f.addRenderer(new ConnectedLineFigureRenderer());
		
		plotter.getGraphics2DPlotter().setFigure(f);
		
		JFrame frame = new JFrame();
		frame.setContentPane(plotter);
		frame.setSize(400,  400);
		frame.setVisible(true);
	}

}
