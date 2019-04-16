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
package cnrs.luchogie.up.ui;

import javax.swing.JPanel;

public class Editor extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9065822656647934238L;
	private UI ui;
	private Object object;
		
	protected void updatePlotter()
	{
		ui.getPlotter().setUpdateNeeded(true);
		ui.getPlotter().repaint();
	}
	public UI getUpUI()
	{
		return ui;
	}

	public void setUpUI(UI ui)
	{
		this.ui = ui;
	}

	public Object getObject()
	{
		return object;
	}

	public void setObject(Object object)
	{
		this.object = object;
	}
}
