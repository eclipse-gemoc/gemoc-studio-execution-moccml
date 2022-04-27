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


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;


/**
 * The user may want to get an image object or the data of an
 * image file (PNG, JPEG, SVG...) for, for instance, return it to a 
 * HTTP-client that will have to draw the image on the web page
 * it will show.
 * 
 * @author Luc Hogie
 */
public class AWTImagePlotter extends DelegPlotter
{
	/**
	 * Creates and image with the given dimension.
	 * @param width
	 * @param height
	 * @return Image
	 */
	public Image getAWTImage( int width, int height )
	{
		BufferedImage image = new BufferedImage( width, height, BufferedImage.TYPE_INT_RGB );
		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.setClip(0, 0, width, height);
		getGraphics2DPlotter().paint(graphics);
		graphics.dispose();
		return image;
	}

}
