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
package cnrs.luchogie.up.data.rendering.point;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.net.URL;

import cnrs.luchogie.up.data.DataElement;
import cnrs.luchogie.up.data.Point;
import cnrs.luchogie.up.system.Dimension;
import cnrs.luchogie.up.system.Space;


/**
 * @author Luc Hogie
 */
public class ImagePointRenderer extends PointRenderer
{
	private Image image;

	/**
	 * @see org.lucci.plt.data.DataRenderer#draw(DataObject, Space)
	 */
	public void drawImpl(DataElement object, Space space)
	{
		ImageObserver imageObserver = space.getImageObserver();

		if ( image != null && imageObserver != null )
		{
			Point point = (Point) object;
			Dimension xDimension = space.getXDimension();
			Dimension yDimension = space.getYDimension();

			int px = xDimension.convertToGraphicsCoordonateSystem(point.getX());
			int py = yDimension.convertToGraphicsCoordonateSystem(point.getY());
			int x = px - image.getWidth(imageObserver) / 2 + getXShift();
			int y = py - image.getHeight(imageObserver) / 2 + getYShift();
			space.getFigureGraphics().drawImage( image, x, y, imageObserver );
		}
	}

	public Image getImage()
	{
		return image;
	}

	public void setImage(Image image)
	{
		this.image = image;
	}

	public void setImage(URL url)
	{
		setImage(Toolkit.getDefaultToolkit().createImage(url));
	}
    
    public String getPublicName()
    {
        return "image";
    }

}
