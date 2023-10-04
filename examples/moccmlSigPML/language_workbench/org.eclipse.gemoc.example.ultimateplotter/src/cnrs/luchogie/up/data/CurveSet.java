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



import java.awt.Color;
import java.util.List;
import java.util.Vector;

import cnrs.luchogie.up.data.rendering.figure.ConnectedLineFigureRenderer;
import cnrs.luchogie.up.data.rendering.figure.FigureRenderer;

/*
 * Created on Dec 30, 2004
 */

/**
 * @author luc.hogie
 */
public class CurveSet extends Figure
{
	private List<ConnectedLineFigureRenderer> renderers = new Vector<ConnectedLineFigureRenderer>();
	
	public CurveSet()
	{
		{
			ConnectedLineFigureRenderer r = new ConnectedLineFigureRenderer();
			r.setColor(Color.blue);
			renderers.add(r);
		}
		{
			ConnectedLineFigureRenderer r = new ConnectedLineFigureRenderer();
			r.setColor(Color.red);
			renderers.add(r);
		}
		{
			ConnectedLineFigureRenderer r = new ConnectedLineFigureRenderer();
			r.setColor(Color.green);
			renderers.add(r);
		}
		{
			ConnectedLineFigureRenderer r = new ConnectedLineFigureRenderer();
			r.setColor(Color.black);
			renderers.add(r);
		}
	}
	
	
	public void addFigure(Figure figure)
	{
		super.addFigure(figure);
		figure.addRenderer((FigureRenderer) renderers.get(getFigureCount() - 1));
	}
	
	public void addPoint(Point p)
	{
		throw new IllegalStateException("only figures can be added");
	}
}
