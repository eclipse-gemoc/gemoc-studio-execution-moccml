/*******************************************************************************
 * Copyright (c) 2017 INRIA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     INRIA - initial API and implementation
 *     I3S Laboratory - API update and bug fix
 *******************************************************************************/
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.launcher.tabs;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.gemoc.commons.eclipse.ui.dialogs.SelectAnyIFileDialog;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.commons.ConcurrentRunConfiguration;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.Activator;
import org.eclipse.gemoc.executionframework.engine.core.RunConfiguration;
import org.eclipse.gemoc.executionframework.engine.ui.launcher.tabs.AbstractLaunchConfigurationTab;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

public class LaunchConfigurationAdvancedTab extends AbstractLaunchConfigurationTab {

	protected Composite _parent;
	protected Text _timemodelLocationText;
	protected Button _isExhaustive;
	public int GRID_DEFAULT_WIDTH = 200;

	@Override
	public void createControl(Composite parent) {
		_parent = parent;
		Composite area = new Composite(parent, SWT.NULL);
		GridLayout gl = new GridLayout(1, false);
		gl.marginHeight = 0;
		area.setLayout(gl);
		area.layout();
		setControl(area);

		Group executionModelArea = createGroup(area, "execution model (.timemodel):");
		createModelLayout(executionModelArea , null);
	
		_isExhaustive =createCheckButton(area, "Do Exhaustive Simulation");
		
		_isExhaustive.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				setDirty(true);
				updateLaunchConfigurationDialog();
				getLaunchConfigurationDialog().updateButtons();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				setDirty(true);
				notifyAll();
			}
		});

	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(RunConfiguration.LAUNCH_DELAY, 1000);
		configuration.setAttribute(ConcurrentRunConfiguration.LAUNCH_SELECTED_DECIDER,
				ConcurrentRunConfiguration.DECIDER_ASKUSER_STEP_BY_STEP);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			ConcurrentRunConfiguration runConfiguration = new ConcurrentRunConfiguration(configuration);
			_timemodelLocationText.setText(runConfiguration.getExecutionModelPath());
			_isExhaustive.setSelection(runConfiguration.getIsExhaustiveSimulation());
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e);
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(ConcurrentRunConfiguration.EXTRA_TIMEMODEL_PATH, _timemodelLocationText.getText());
		configuration.setAttribute(ConcurrentRunConfiguration.EXHAUSTIVE_MODE, _isExhaustive.getSelection());
	}

	@Override
	public String getName() {
		return "Advanced";
	}

	// -----------------------------------

	/**
	 * Basic modify listener that can be reused if there is no more precise need
	 */
	private ModifyListener fBasicModifyListener = new ModifyListener() {
		@Override
		public void modifyText(ModifyEvent arg0) {
			updateLaunchConfigurationDialog();
		}
	};

	// -----------------------------------

	/***
	 * Create the Field where user enters model to execute
	 * 
	 * @param parent
	 * @param font
	 * @return
	 */
	public Composite createModelLayout(Composite parent, Font font) {
		createTextLabelLayout(parent, "Model to execute");
		// Model location text
		_timemodelLocationText = new Text(parent, SWT.SINGLE | SWT.BORDER);
		_timemodelLocationText.setLayoutData(createStandardLayout());
		_timemodelLocationText.setFont(font);
		_timemodelLocationText.addModifyListener(fBasicModifyListener);
		Button modelLocationButton = createPushButton(parent, "Browse", null);
		modelLocationButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				// handleModelLocationButtonSelected();
				// TODO launch the appropriate selector

				SelectAnyIFileDialog dialog = new SelectAnyIFileDialog();
				if (dialog.open() == Dialog.OK) {
					String modelPath = ((IResource) dialog.getResult()[0]).getFullPath().toPortableString();
					_timemodelLocationText.setText(modelPath);
					updateLaunchConfigurationDialog();
				}
			}
		});
		
		createTextLabelLayout(parent, "");
		return parent;
	}

	private GridData createStandardLayout() {
		return new GridData(SWT.FILL, SWT.CENTER, true, false);
	}

	
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#isValid(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	public boolean isValid(ILaunchConfiguration config) {
		setErrorMessage(null);
		setMessage(null);
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		String timemodelName = _timemodelLocationText.getText().trim();
		if (timemodelName.length() > 0) {
			
			IResource modelIResource = workspace.getRoot().findMember(timemodelName);
			if (modelIResource == null || !modelIResource.exists()) {
				setErrorMessage(NLS.bind("execution model does not exist", new String[] {timemodelName})); 
				return false;
			}
			if (!timemodelName.equals("/")) {
				setWarningMessage("warning, you specified a specific timemodel file in the advanced tab... you may better know what you are doing :)"); 
			}
			if (! (modelIResource instanceof IFile)) {
				setErrorMessage(NLS.bind("execution model invalid file", new String[] {timemodelName})); 
				return false;
			}
		}
		if (timemodelName.length() != 0) {
			setWarningMessage("warning, you specified a specific timemodel file in the advanced tab... you may better know what you are doing :)"); 
		}
		
		return true;
	}
}
