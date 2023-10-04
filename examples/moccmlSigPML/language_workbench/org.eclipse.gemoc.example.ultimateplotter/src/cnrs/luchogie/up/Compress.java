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
import java.util.Vector;

import javax.swing.JFrame;

import cnrs.luchogie.up.data.Figure;
import cnrs.luchogie.up.data.Point;
import cnrs.luchogie.up.data.math.Function;
import cnrs.luchogie.up.data.rendering.point.CirclePointRenderer;

public class Compress
{
    public static void main(String[] args)
    {
        new Compress();
    }
    
    public Compress()
    {
        Collection<Double> xList = new Vector<Double>();

        for (double x = 0; x < 10; x += 0.1d)
        {
            xList.add(x);
        }

        Function f = new Function()
        {

            @Override
            public Point evaluate(double d)
            {
                return new Point(d, Math.cos(d) * Math.sin(d) * Math.tan(d));
            }
            
        };
        f.setDefinitionValues(0, 10, 0.1);
        Figure figure = f.createFigure();
        figure.addRenderer(new CirclePointRenderer());

        SwingPlotter plotter = new SwingPlotter();
        plotter.getGraphics2DPlotter().setFigure(figure);

        
        JFrame frame = new JFrame("y = f(x)");
        frame.setContentPane(plotter);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
    
}
