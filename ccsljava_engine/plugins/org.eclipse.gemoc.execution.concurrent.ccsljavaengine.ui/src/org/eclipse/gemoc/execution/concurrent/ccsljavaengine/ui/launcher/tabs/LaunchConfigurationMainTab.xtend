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
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.launcher.tabs

import fr.inria.diverse.k3.al.annotationprocessor.InitializeModel
import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import java.lang.reflect.Method
import java.util.ArrayList
import java.util.List
import java.util.Set
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IWorkspace
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.CoreException
import org.eclipse.debug.core.ILaunchConfiguration
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy
import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EPackage
import org.eclipse.gemoc.commons.eclipse.emf.EMFResource
import org.eclipse.gemoc.commons.eclipse.emf.URIHelper
import org.eclipse.gemoc.commons.eclipse.ui.dialogs.SelectAnyIFileDialog
import org.eclipse.gemoc.dsl.debug.ide.launch.AbstractDSLLaunchConfigurationDelegate
import org.eclipse.gemoc.dsl.debug.ide.sirius.ui.launch.AbstractDSLLaunchConfigurationDelegateSiriusUI
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.Activator
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.launcher.MoccmlLauncherMessages
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.ConcurrentRunConfiguration
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dsa.executors.ICodeExecutor
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.extensions.deciders.DeciderSpecificationExtension
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.extensions.deciders.DeciderSpecificationExtensionPoint
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.extensions.languages.MoccmlLanguageAdditionExtension
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.extensions.languages.MoccmlLanguageAdditionExtensionPoint
import org.eclipse.gemoc.executionframework.engine.commons.DslHelper
import org.eclipse.gemoc.executionframework.engine.core.RunConfiguration
import org.eclipse.gemoc.executionframework.engine.ui.launcher.tabs.AbstractLaunchConfigurationTab
import org.eclipse.gemoc.xdsmlframework.ui.utils.dialogs.SelectAIRDIFileDialog
import org.eclipse.jface.dialogs.Dialog
import org.eclipse.osgi.util.NLS
import org.eclipse.swt.SWT
import org.eclipse.swt.events.ModifyEvent
import org.eclipse.swt.events.ModifyListener
import org.eclipse.swt.events.SelectionAdapter
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.graphics.Font
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.Combo
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Group
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Text
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.commons.MoccmlDSLHelper
import org.eclipse.emf.ecore.EObject

class LaunchConfigurationMainTab extends AbstractLaunchConfigurationTab {
	protected Composite _parent
	protected Text _modelLocationText
	protected Text _modelInitializationMethodText
	protected Text _modelInitializationArgumentsText
	protected Text _siriusRepresentationLocationText
	protected Button _animateButton
	protected Text _delayText
	protected Combo _languageCombo
	protected Combo _deciderCombo
	// protected Button _animationFirstBreak; not needed since debug mode uses the logical step decider.
	protected Text modelofexecutionglml_LocationText
	public int GRID_DEFAULT_WIDTH = 200

	@Accessors(PUBLIC_GETTER)
	var Set<EPackage> metamodels
	@Accessors(PUBLIC_GETTER)
	var Set<String> semantics
	@Accessors(PUBLIC_GETTER)
	var EObject modelRoot
	

	override void createControl(Composite parent) {
		_parent = parent
		var Composite area = new Composite(parent, SWT.NULL)
		var GridLayout gl = new GridLayout(1, false)
		gl.marginHeight = 0
		area.setLayout(gl)
		area.layout()
		setControl(area)
		var Group modelArea = createGroup(area, "Model:")
		createModelLayout(modelArea, null)
		var Group languageArea = createGroup(area, "Language:")
		createLanguageLayout(languageArea, null)
		var Group debugArea = createGroup(area, "Animation:")
		createAnimationLayout(debugArea, null)
	}

	override void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(RunConfiguration.LAUNCH_DELAY, 1000)
		configuration.setAttribute(ConcurrentRunConfiguration.LAUNCH_SELECTED_DECIDER,
			ConcurrentRunConfiguration.DECIDER_ASKUSER_STEP_BY_STEP)
	}

	override void initializeFrom(ILaunchConfiguration configuration) {
		try {
			var ConcurrentRunConfiguration runConfiguration = new ConcurrentRunConfiguration(configuration)
			_modelLocationText.setText(URIHelper.removePlatformScheme(runConfiguration.getExecutedModelURI()))
			if (runConfiguration.getAnimatorURI() !== null)
				_siriusRepresentationLocationText.setText(
					URIHelper.removePlatformScheme(runConfiguration.getAnimatorURI()))
			else
				_siriusRepresentationLocationText.setText("")
			_delayText.setText(Integer.toString(runConfiguration.getAnimationDelay()))
			_languageCombo.setText(runConfiguration.getLanguageName())
			_deciderCombo.setText(runConfiguration.getDeciderName())
			// _animationFirstBreak.setSelection(runConfiguration.getBreakStart());
			_modelInitializationArgumentsText.setText(runConfiguration.getModelInitializationArguments())
			updateDSL()
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e)
		}

	}

	override void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(AbstractDSLLaunchConfigurationDelegate.RESOURCE_URI,
			this._modelLocationText.getText())
		configuration.setAttribute(AbstractDSLLaunchConfigurationDelegateSiriusUI.SIRIUS_RESOURCE_URI,
			this._siriusRepresentationLocationText.getText())
		configuration.setAttribute(RunConfiguration.LAUNCH_DELAY, Integer.parseInt(_delayText.getText()))
		configuration.setAttribute(RunConfiguration.LAUNCH_SELECTED_LANGUAGE, this._languageCombo.getText())
		configuration.setAttribute(ConcurrentRunConfiguration.LAUNCH_SELECTED_DECIDER, this._deciderCombo.getText())
		configuration.setAttribute(ConcurrentRunConfiguration.LAUNCH_INITIALIZATION_METHOD,
			_modelInitializationMethodText.getText())
		configuration.setAttribute(ConcurrentRunConfiguration.LAUNCH_INITIALIZATION_ARGUMENTS,
			_modelInitializationArgumentsText.getText()) // configuration.setAttribute(RunConfiguration.LAUNCH_BREAK_START, _animationFirstBreak.getSelection());
	}

	override String getName() {
		return "Main"
	}

	// -----------------------------------
	/** 
	 * Basic modify listener that can be reused if there is no more precise need
	 */
	ModifyListener fBasicModifyListener = [ModifyEvent arg0|updateLaunchConfigurationDialog()]

	// -----------------------------------
	/** 
	 * Create the Field where user enters model to execute
	 * @param parent
	 * @param font
	 * @return
	 */
	def Composite createModelLayout(Composite parent, Font font) {
		createTextLabelLayout(parent, "Model to execute")
		// Model location text
		_modelLocationText = new Text(parent, SWT.SINGLE.bitwiseOr(SWT.BORDER))
		_modelLocationText.setLayoutData(createStandardLayout())
		_modelLocationText.setFont(font)
		_modelLocationText.addModifyListener(fBasicModifyListener)
		var Button modelLocationButton = createPushButton(parent, "Browse", null)
		modelLocationButton.addSelectionListener(new SelectionAdapter() {
			override void widgetSelected(SelectionEvent evt) {
				// handleModelLocationButtonSelected();
				// TODO launch the appropriate selector
				var SelectAnyIFileDialog dialog = new SelectAnyIFileDialog()
				if (dialog.open() === Dialog.OK) {
					var String modelPath = ((dialog.getResult().get(0) as IResource)).getFullPath().toPortableString()
					_modelLocationText.setText(modelPath)
					updateLaunchConfigurationDialog()
				}
			}
		})
		createTextLabelLayout(parent, "Model initialization method")
		_modelInitializationMethodText = new Text(parent, SWT.SINGLE.bitwiseOr(SWT.BORDER))
		_modelInitializationMethodText.setLayoutData(createStandardLayout())
		_modelInitializationMethodText.setFont(font)
		_modelInitializationMethodText.setEditable(false)
		createTextLabelLayout(parent, "")
		createTextLabelLayout(parent, "Model initialization arguments")
		_modelInitializationArgumentsText = new Text(parent,
			SWT.MULTI.bitwiseOr(SWT.BORDER).bitwiseOr(SWT.WRAP).bitwiseOr(SWT.V_SCROLL))
		var GridData gridData = new GridData(GridData.FILL_BOTH)
		gridData.heightHint = 40
		_modelInitializationArgumentsText.setLayoutData(gridData)
		// _modelInitializationArgumentsText.setLayoutData(createStandardLayout());
		_modelInitializationArgumentsText.setFont(font)
		_modelInitializationArgumentsText.setEditable(true)
		_modelInitializationArgumentsText.addModifyListener([ModifyEvent e|updateLaunchConfigurationDialog()])
		createTextLabelLayout(parent, "")
		return parent
	}

	def private Composite createAnimationLayout(Composite parent, Font font) {
		createTextLabelLayout(parent, "Animator")
		_siriusRepresentationLocationText = new Text(parent, SWT.SINGLE.bitwiseOr(SWT.BORDER))
		_siriusRepresentationLocationText.setLayoutData(createStandardLayout())
		_siriusRepresentationLocationText.setFont(font)
		_siriusRepresentationLocationText.addModifyListener(fBasicModifyListener)
		var Button siriusRepresentationLocationButton = createPushButton(parent, "Browse", null)
		siriusRepresentationLocationButton.addSelectionListener(new SelectionAdapter() {
			override void widgetSelected(SelectionEvent evt) {
				// handleModelLocationButtonSelected();
				// TODO launch the appropriate selector
				var SelectAIRDIFileDialog dialog = new SelectAIRDIFileDialog()
				if (dialog.open() === Dialog.OK) {
					var String modelPath = ((dialog.getResult().get(0) as IResource)).getFullPath().toPortableString()
					_siriusRepresentationLocationText.setText(modelPath)
					updateLaunchConfigurationDialog()
				}
			}
		})
		createTextLabelLayout(parent, "Delay")
		_delayText = new Text(parent, SWT.SINGLE.bitwiseOr(SWT.BORDER))
		_delayText.setLayoutData(createStandardLayout())
		_delayText.addModifyListener([ModifyEvent e|updateLaunchConfigurationDialog()])
		createTextLabelLayout(parent, "(in milliseconds)")
		createTextLabelLayout(parent, "Decider")
		_deciderCombo = new Combo(parent, SWT.BORDER)
		_deciderCombo.setLayoutData(createStandardLayout())
		var ArrayList<String> deciders = new ArrayList()
		for (DeciderSpecificationExtension definition : DeciderSpecificationExtensionPoint.getSpecifications()) {
			deciders.add(definition.getName())
		}
		// String[] deciderChoice = {
		// RunConfiguration.DECIDER_SOLVER_PROPOSITION,
		// RunConfiguration.DECIDER_RANDOM,
		// RunConfiguration.DECIDER_ASKUSER,
		// RunConfiguration.DECIDER_ASKUSER_STEP_BY_STEP };
		var String[] a = newArrayOfSize(deciders.size())
		_deciderCombo.setItems(deciders.toArray(a))
		_deciderCombo.select(0)
		_deciderCombo.addModifyListener(fBasicModifyListener)
		new Label(parent, SWT.NONE).setText("")
		// _animationFirstBreak = new Button(parent, SWT.CHECK);
		// _animationFirstBreak.setText("Break at start");
		// _animationFirstBreak.addSelectionListener(new SelectionAdapter() {
		//
		// @Override
		// public void widgetSelected(SelectionEvent event) {
		// updateLaunchConfigurationDialog();
		// }
		// }
		//
		// );
		return parent
	}

	def private GridData createStandardLayout() {
		return new GridData(SWT.FILL, SWT.CENTER, true, false)
	}

	/** 
	 * Create the Field where user enters the language used to execute
	 * @param parent
	 * @param font
	 * @return
	 */
	def Composite createLanguageLayout(Composite parent, Font font) {
		// Language
		createTextLabelLayout(parent, "DSL languages")
		_languageCombo = new Combo(parent, SWT.NONE)
		_languageCombo.setLayoutData(createStandardLayout())
		var List<String> languagesNames = DslHelper.getAllLanguages()
		var String[] empty = #[]
		_languageCombo.setItems(languagesNames.toArray(empty))
		_languageCombo.addSelectionListener(new SelectionAdapter() {
			override void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog()
				updateDSL()
			}
		})
		createTextLabelLayout(parent, "")
		return parent
	}

	override protected void updateLaunchConfigurationDialog() {
		super.updateLaunchConfigurationDialog()
		// modelInitializationMethod must come from the xdsml, maybe later we would
		// allows an "expert mode" where we will allow to change it there
		var MoccmlLanguageAdditionExtension languageDefinitionExtPoint = MoccmlLanguageAdditionExtensionPoint.
			findMoccmlLanguageAdditionForLanguage(_languageCombo.getText())
		if (languageDefinitionExtPoint !== null) {
			_modelInitializationMethodText.setText(getModelInitializationMethodName(languageDefinitionExtPoint))
		} else {
			_modelInitializationMethodText.setText("")
		}
		_modelInitializationArgumentsText.setEnabled(!_modelInitializationMethodText.getText().isEmpty())
		
		modelRoot = MoccmlDSLHelper::getModelRoot(_modelLocationText.text)
	}

	def protected String getModelInitializationMethodName(MoccmlLanguageAdditionExtension languageDefinitionExtension) {
		var ICodeExecutor codeExecutor
		try {
			codeExecutor = languageDefinitionExtension.instanciateCodeExecutor()
			var URI uri = URI.createPlatformResourceURI(_modelLocationText.getText(), true)
			var Object caller = EMFResource.getFirstContent(uri)
			var ArrayList<Object> parameters = new ArrayList<Object>()
			// try with String[] agrs
			var String[] p = newArrayOfSize(1);
			parameters.add(p); // new String[1]
			var List<Method> methods = codeExecutor.findCompatibleMethodsWithAnnotation(caller, parameters,
				InitializeModel)
			// try with List<String>
			parameters.clear()
			parameters.add(new ArrayList<String>())
			methods.addAll(codeExecutor.findCompatibleMethodsWithAnnotation(caller, parameters, InitializeModel))
			// try with EList<String>
			parameters.clear()
			parameters.add(new BasicEList<String>())
			methods.addAll(codeExecutor.findCompatibleMethodsWithAnnotation(caller, parameters, InitializeModel))
			if (!methods.isEmpty()) {
				var Method selectedMethod = methods.get(0)
				return '''«selectedMethod.getDeclaringClass().getCanonicalName()».«selectedMethod.getName()»'''
			}
		} catch (CoreException e) {
			Activator.warn(e.getMessage(), e)
		}

		return ""
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.AbstractLaunchConfigurationTab#isValid(org.eclipse.debug
	 * .core.ILaunchConfiguration)
	 */
	override boolean isValid(ILaunchConfiguration config) {
		setErrorMessage(null)
		setMessage(null)
		var IWorkspace workspace = ResourcesPlugin.getWorkspace()
		var String modelName = _modelLocationText.getText().trim()
		if (modelName.length() > 0) {
			var IResource modelIResource = workspace.getRoot().findMember(modelName)
			if (modelIResource === null || !modelIResource.exists()) {
				setErrorMessage(NLS.bind(MoccmlLauncherMessages.ConcurrentMainTab_model_doesnt_exist, #[modelName]))
				return false
			}
			if (modelName.equals("/")) {
				setErrorMessage(MoccmlLauncherMessages.ConcurrentMainTab_Model_not_specified)
				return false
			}
			if (!(modelIResource instanceof IFile)) {
				setErrorMessage(NLS.bind(MoccmlLauncherMessages.ConcurrentMainTab_invalid_model_file, #[modelName]))
				return false
			}
		}
		if (modelName.length() === 0) {
			setErrorMessage(MoccmlLauncherMessages.ConcurrentMainTab_Model_not_specified)
			return false
		}
		var String languageName = _languageCombo.getText().trim()
		if (languageName.length() === 0) {
			setErrorMessage(MoccmlLauncherMessages.ConcurrentMainTab_Language_not_specified)
			return false
		}
		
		return true
	}

	def Set<String> getSemanticRules() {
		if (_languageCombo.text !== null && !_languageCombo.text.empty)
			return MoccmlDSLHelper::getSemanticRules(_languageCombo.text)
		else
			return #{}
	}

	def Set<EPackage> getAbstractSyntax() {
		if (_languageCombo.text !== null && !_languageCombo.text.empty)
			return MoccmlDSLHelper::getAbstractSyntax(_languageCombo.text)
		else
			return #{}
	}
	


	val pcs = new PropertyChangeSupport(this)
	val METAMODELS = "metamodels"
	val SEMANTICS = "semantics"

	def updateDSL() {

		val oldSemantics = semantics
		semantics = getSemanticRules()

		val oldmms = metamodels
		metamodels = getAbstractSyntax()

		pcs.firePropertyChange(
			SEMANTICS,
			if(oldSemantics !== null) oldSemantics else emptyList,
			if(semantics !== null) semantics else emptyList
		)
		if (oldmms !== metamodels) {
			pcs.firePropertyChange(METAMODELS, oldmms, metamodels)
		}
	}

	def addMetamodelListener(PropertyChangeListener pcl) {
		pcs.addPropertyChangeListener(METAMODELS, pcl)
	}

	def addSemanticsListener(PropertyChangeListener pcl) {
		pcs.addPropertyChangeListener(SEMANTICS, pcl)
	}
}
