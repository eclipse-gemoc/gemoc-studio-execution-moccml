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
/**
 */
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.concurrentmse;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.ModelSpecificEvent;
import org.eclipse.gemoc.trace.commons.model.trace.MSE;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feedback MSE</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.concurrentmse.FeedbackMSE#getFeedbackModelSpecificEvent <em>Feedback Model Specific Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.concurrentmse.Concurrent_msePackage#getFeedbackMSE()
 * @model
 * @generated
 */
public interface FeedbackMSE extends MSE {
	/**
	 * Returns the value of the '<em><b>Feedback Model Specific Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feedback Model Specific Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feedback Model Specific Event</em>' reference.
	 * @see #setFeedbackModelSpecificEvent(ModelSpecificEvent)
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.concurrentmse.Concurrent_msePackage#getFeedbackMSE_FeedbackModelSpecificEvent()
	 * @model required="true"
	 * @generated
	 */
	ModelSpecificEvent getFeedbackModelSpecificEvent();

	/**
	 * Sets the value of the '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.concurrentmse.FeedbackMSE#getFeedbackModelSpecificEvent <em>Feedback Model Specific Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feedback Model Specific Event</em>' reference.
	 * @see #getFeedbackModelSpecificEvent()
	 * @generated
	 */
	void setFeedbackModelSpecificEvent(ModelSpecificEvent value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EObject getCaller();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EOperation getAction();

} // FeedbackMSE
