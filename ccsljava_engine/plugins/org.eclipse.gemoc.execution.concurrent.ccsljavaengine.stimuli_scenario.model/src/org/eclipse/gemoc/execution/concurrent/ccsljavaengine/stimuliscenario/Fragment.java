/*******************************************************************************
 * Copyright (c) 2017 INRIA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     INRIA - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.stimuliscenario;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fragment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.stimuliscenario.Fragment#getStepList <em>Step List</em>}</li>
 * </ul>
 *
 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.stimuliscenario.ScenarioPackage#getFragment()
 * @model
 * @generated
 */
public interface Fragment extends EObject {
	/**
	 * Returns the value of the '<em><b>Step List</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.stimuliscenario.ExecutionStep}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step List</em>' containment reference list.
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.stimuliscenario.ScenarioPackage#getFragment_StepList()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExecutionStep> getStepList();

} // Fragment
