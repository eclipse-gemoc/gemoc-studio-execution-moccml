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
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.concurrentmse.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.concurrentmse.Concurrent_msePackage;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.concurrentmse.FeedbackMSE;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.ModelSpecificEvent;
import org.eclipse.gemoc.trace.commons.model.trace.impl.MSEImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feedback MSE</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.concurrentmse.impl.FeedbackMSEImpl#getFeedbackModelSpecificEvent <em>Feedback Model Specific Event</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeedbackMSEImpl extends MSEImpl implements FeedbackMSE {
	/**
	 * The cached value of the '{@link #getFeedbackModelSpecificEvent() <em>Feedback Model Specific Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeedbackModelSpecificEvent()
	 * @generated
	 * @ordered
	 */
	protected ModelSpecificEvent feedbackModelSpecificEvent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeedbackMSEImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Concurrent_msePackage.Literals.FEEDBACK_MSE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSpecificEvent getFeedbackModelSpecificEvent() {
		if (feedbackModelSpecificEvent != null && feedbackModelSpecificEvent.eIsProxy()) {
			InternalEObject oldFeedbackModelSpecificEvent = (InternalEObject)feedbackModelSpecificEvent;
			feedbackModelSpecificEvent = (ModelSpecificEvent)eResolveProxy(oldFeedbackModelSpecificEvent);
			if (feedbackModelSpecificEvent != oldFeedbackModelSpecificEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Concurrent_msePackage.FEEDBACK_MSE__FEEDBACK_MODEL_SPECIFIC_EVENT, oldFeedbackModelSpecificEvent, feedbackModelSpecificEvent));
			}
		}
		return feedbackModelSpecificEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSpecificEvent basicGetFeedbackModelSpecificEvent() {
		return feedbackModelSpecificEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeedbackModelSpecificEvent(ModelSpecificEvent newFeedbackModelSpecificEvent) {
		ModelSpecificEvent oldFeedbackModelSpecificEvent = feedbackModelSpecificEvent;
		feedbackModelSpecificEvent = newFeedbackModelSpecificEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Concurrent_msePackage.FEEDBACK_MSE__FEEDBACK_MODEL_SPECIFIC_EVENT, oldFeedbackModelSpecificEvent, feedbackModelSpecificEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Concurrent_msePackage.FEEDBACK_MSE__FEEDBACK_MODEL_SPECIFIC_EVENT:
				if (resolve) return getFeedbackModelSpecificEvent();
				return basicGetFeedbackModelSpecificEvent();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Concurrent_msePackage.FEEDBACK_MSE__FEEDBACK_MODEL_SPECIFIC_EVENT:
				setFeedbackModelSpecificEvent((ModelSpecificEvent)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case Concurrent_msePackage.FEEDBACK_MSE__FEEDBACK_MODEL_SPECIFIC_EVENT:
				setFeedbackModelSpecificEvent((ModelSpecificEvent)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Concurrent_msePackage.FEEDBACK_MSE__FEEDBACK_MODEL_SPECIFIC_EVENT:
				return feedbackModelSpecificEvent != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public EObject getCaller() {
		return getFeedbackModelSpecificEvent().getCaller();
	}

	@Override
	public EOperation getAction() {
		return getFeedbackModelSpecificEvent().getAction();
	}

} //FeedbackMSEImpl
