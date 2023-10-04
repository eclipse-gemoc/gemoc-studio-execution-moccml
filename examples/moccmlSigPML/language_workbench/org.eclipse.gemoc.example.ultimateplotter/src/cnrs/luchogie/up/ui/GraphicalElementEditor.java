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

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import cnrs.luchogie.up.system.SpaceElement;

public class GraphicalElementEditor extends Editor
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4943885170704469730L;
	private JCheckBox visibleCheckbox = new JCheckBox("element is visible");
	private JCheckBox specificColor = new JCheckBox("element has a specific color", true);
	private JColorChooser colorChooser = new JColorChooser();

	public GraphicalElementEditor()
	{
		colorChooser.setChooserPanels(new AbstractColorChooserPanel[] {colorChooser.getChooserPanels()[2]});
		colorChooser.setPreviewPanel(new JLabel());
		setLayout(new GridLayout(3, 1));
		add(visibleCheckbox);
		add(specificColor);
		add(colorChooser);


		visibleCheckbox.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent event)
			{
				((SpaceElement) getObject()).setVisible(visibleCheckbox.isSelected());
				updatePlotter();
			}
		});

		specificColor.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent event)
			{
				SpaceElement ge = (SpaceElement) getObject();
				
				if (specificColor.isSelected())
				{
					if (ge.getParent() == null)
					{
						ge.setColor(Color.black);
					}
					else
					{
						ge.setColor(ge.getParent().getColor());
					}

					colorChooser.setColor(ge.getColor());
					colorChooser.setVisible(true);
				}
				else
				{
					ge.setColor(null);
					colorChooser.setVisible(false);
				}

				updatePlotter();
			}
		});

		colorChooser.getSelectionModel().addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent event)
			{
				((SpaceElement) getObject()).setColor(colorChooser.getColor());
				updatePlotter();
			}
		});
	}
	
	public void setObject(Object object)
	{
		SpaceElement ge = (SpaceElement) object;
		super.setObject(object);
		visibleCheckbox.setSelected(ge.isVisible());
		colorChooser.setColor(ge.getColor());
	}
	
	public String toString()
	{
		return "Basic";
	}

}
