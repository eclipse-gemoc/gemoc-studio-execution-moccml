/** 
 * Copyright (c) 2017 INRIA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * INRIA - initial API and implementation
 * I3S Laboratory - API update and bug fix
 */
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.launcher

import java.beans.PropertyChangeListener
import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup
import org.eclipse.debug.ui.CommonTab
import org.eclipse.debug.ui.ILaunchConfigurationDialog
import org.eclipse.debug.ui.ILaunchConfigurationTab
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.launcher.tabs.LaunchConfigurationAdvancedTab
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.launcher.tabs.LaunchConfigurationBackendsTab
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.launcher.tabs.LaunchConfigurationMainTab
import org.eclipse.gemoc.executionframework.engine.ui.concurrency.launcher.LaunchConfigurationStrategiesTab
import org.eclipse.gemoc.executionframework.engine.ui.concurrency.strategies.LaunchConfigurationContext

class MoccmlLauncherTabGroup extends AbstractLaunchConfigurationTabGroup {
	new() {
	}

	override void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		val mainTab = new LaunchConfigurationMainTab()
		var ILaunchConfigurationTab[] tabs = #[
			mainTab,
			new LaunchConfigurationBackendsTab(),
			new CommonTab(), 
			new LaunchConfigurationAdvancedTab(),
			new LaunchConfigurationStrategiesTab(new LaunchConfigurationContext {
				
				override getMetamodels() {
					val mms = mainTab.abstractSyntax
					if (mms !== null) mms.unmodifiableView else null
				}
				
				override addMetamodelChangeListener(PropertyChangeListener pcl) {
					mainTab.addMetamodelListener(pcl)
				}
				
				override getSemantics() {
					return mainTab.semantics
				}
				
				override addSemanticsChangeListener(PropertyChangeListener pcl) {
					mainTab.addSemanticsListener(pcl)
				}
				
				override getModelRoot() {
					return mainTab.modelRoot
				}
				
				override getEngine() {
					return null
				}
				
			})
			]
		setTabs(tabs)
	}
}
