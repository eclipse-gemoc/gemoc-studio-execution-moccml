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

public class CatmullRomSplineFigureRenderer extends BSplineFigureRenderer
{
  float b(int i, float t) {
    switch (i) {
    case -2:
      return ((-t+2)*t-1)*t/2;
    case -1:
      return (((3*t-5)*t)*t+2)/2;
    case 0:
      return ((-3*t+4)*t+1)*t/2;
    case 1:
      return ((t-1)*t*t)/2;
    }
    return 0; //we only get here if an invalid i is specified
  }
}
