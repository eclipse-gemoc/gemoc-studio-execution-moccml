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

public abstract class InterpolatingFigureRenderer extends FigureRenderer
{
	private int stepCount = 20;

    public int getStepCount()
    {
        return stepCount;
    }

    public void setStepCount(int stepCount)
    {
		if ( stepCount < 0 )
			throw new IllegalArgumentException( "stepCount must be > 0" );

        this.stepCount = stepCount;
    }
}
