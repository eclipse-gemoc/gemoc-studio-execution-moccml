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

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import cnrs.luchogie.up.system.Arrow;
import cnrs.luchogie.up.system.Axis;
import cnrs.luchogie.up.system.AxisLine;
import cnrs.luchogie.up.system.Dimension;
import cnrs.luchogie.up.system.Graduation;
import cnrs.luchogie.up.system.Legend;
import cnrs.luchogie.up.system.Space;



public class UpTreeCellRenderer extends DefaultTreeCellRenderer
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2646183603598793668L;
	static Map<Class<?>, ImageIcon> iconMap;
	
	public UpTreeCellRenderer()
	{
		if (iconMap == null)
		{
			iconMap = new HashMap<Class<?>, ImageIcon>();
			iconMap.put(Arrow.class, new ImageIcon(Object.class.getResource("/res/arrow.gif")));
			iconMap.put(Space.class, new ImageIcon(Object.class.getResource("/res/aim.gif")));
			iconMap.put(Dimension.class, new ImageIcon(Object.class.getResource("/res/redBall.gif")));
			iconMap.put(AxisLine.class, new ImageIcon(Object.class.getResource("/res/greenBall.gif")));
			iconMap.put(Axis.class, new ImageIcon(Object.class.getResource("/res/blueBall.gif")));
			iconMap.put(Graduation.class, new ImageIcon(Object.class.getResource("/res/blueDiamond.gif")));
			iconMap.put(Legend.class, new ImageIcon(Object.class.getResource("/res/spiral.gif")));
		}
	}
	
	
	public Component getTreeCellRendererComponent(
		JTree tree,
		Object node,
		boolean selected,
		boolean expanded,
		boolean leaf,
		int row,
		boolean hasFocus)
	{
		Object object = ((DefaultMutableTreeNode) node).getUserObject();
		Icon icon = iconMap.get(object.getClass());
		JLabel component = (JLabel) super.getTreeCellRendererComponent(tree, node, selected, expanded, leaf, row, hasFocus);
		component.setIcon(icon);
		return component;
	}

}
