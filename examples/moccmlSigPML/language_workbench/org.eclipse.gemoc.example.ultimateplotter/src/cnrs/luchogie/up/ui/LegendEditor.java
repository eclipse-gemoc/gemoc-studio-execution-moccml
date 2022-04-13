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

import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import cnrs.luchogie.up.system.Legend;


public class LegendEditor extends Editor
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4385425608732025772L;
	private JTextField textField = new JTextField(20);
	@SuppressWarnings("rawtypes")
	private JList fontList = new JList();

	@SuppressWarnings({ "unchecked", "deprecation" })
	public LegendEditor()
	{
		setLayout(new GridLayout(1, 1));
		add(new JLabel("Text:"));
		add(textField);

		textField.getDocument().addDocumentListener(new DocumentListener()
		{
			public void changedUpdate(DocumentEvent arg0)
			{
				((Legend) getObject()).setText(textField.getText());
				updatePlotter();			
			}

			public void insertUpdate(DocumentEvent arg0)
			{
				((Legend) getObject()).setText(textField.getText());
				updatePlotter();			
			}

			public void removeUpdate(DocumentEvent arg0)
			{
				((Legend) getObject()).setText(textField.getText());
				updatePlotter();			
			}
		});
		
		fontList.setListData(Toolkit.getDefaultToolkit().getFontList());
	}
	
	public void setObject(Object object)
	{
		Legend arrow = (Legend) object;
		super.setObject(object);
		textField.setText(arrow.getText());
	}
	
	public String toString()
	{
		return "Legend";
	}
}
