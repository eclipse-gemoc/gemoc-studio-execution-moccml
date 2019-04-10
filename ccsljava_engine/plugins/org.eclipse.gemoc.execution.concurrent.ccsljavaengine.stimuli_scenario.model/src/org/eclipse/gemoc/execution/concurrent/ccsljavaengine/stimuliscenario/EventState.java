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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.ModelSpecificEvent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.stimuliscenario.EventState#getState <em>State</em>}</li>
 *   <li>{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.stimuliscenario.EventState#getMse <em>Mse</em>}</li>
 * </ul>
 *
 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.stimuliscenario.ScenarioPackage#getEventState()
 * @model
 * @generated
 */
public interface EventState extends EObject {
	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.stimuliscenario.Future}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.stimuliscenario.Future
	 * @see #setState(Future)
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.stimuliscenario.ScenarioPackage#getEventState_State()
	 * @model
	 * @generated
	 */
	Future getState();

	/**
	 * Sets the value of the '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.stimuliscenario.EventState#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.stimuliscenario.Future
	 * @see #getState()
	 * @generated
	 */
	void setState(Future value);

	/**
	 * Returns the value of the '<em><b>Mse</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mse</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mse</em>' reference.
	 * @see #setMse(ModelSpecificEvent)
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.stimuliscenario.ScenarioPackage#getEventState_Mse()
	 * @model required="true"
	 * @generated
	 */
	ModelSpecificEvent getMse();

	/**
	 * Sets the value of the '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.stimuliscenario.EventState#getMse <em>Mse</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mse</em>' reference.
	 * @see #getMse()
	 * @generated
	 */
	void setMse(ModelSpecificEvent value);

} // EventState
