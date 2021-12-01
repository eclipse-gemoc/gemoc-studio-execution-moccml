/**
 */
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelStatePackage;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3SingleEMFReferenceRTD;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>K3 Single EMF Reference RTD</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3SingleEMFReferenceRTDImpl#getReferenceValue <em>Reference Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class K3SingleEMFReferenceRTDImpl extends K3AttributeRTDImpl implements K3SingleEMFReferenceRTD {
	/**
	 * The cached value of the '{@link #getReferenceValue() <em>Reference Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceValue()
	 * @generated
	 * @ordered
	 */
	protected EObject referenceValue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected K3SingleEMFReferenceRTDImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return K3ModelStatePackage.Literals.K3_SINGLE_EMF_REFERENCE_RTD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getReferenceValue() {
		return referenceValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReferenceValue(EObject newReferenceValue, NotificationChain msgs) {
		EObject oldReferenceValue = referenceValue;
		referenceValue = newReferenceValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, K3ModelStatePackage.K3_SINGLE_EMF_REFERENCE_RTD__REFERENCE_VALUE, oldReferenceValue, newReferenceValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferenceValue(EObject newReferenceValue) {
		if (newReferenceValue != referenceValue) {
			NotificationChain msgs = null;
			if (referenceValue != null)
				msgs = ((InternalEObject)referenceValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - K3ModelStatePackage.K3_SINGLE_EMF_REFERENCE_RTD__REFERENCE_VALUE, null, msgs);
			if (newReferenceValue != null)
				msgs = ((InternalEObject)newReferenceValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - K3ModelStatePackage.K3_SINGLE_EMF_REFERENCE_RTD__REFERENCE_VALUE, null, msgs);
			msgs = basicSetReferenceValue(newReferenceValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, K3ModelStatePackage.K3_SINGLE_EMF_REFERENCE_RTD__REFERENCE_VALUE, newReferenceValue, newReferenceValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case K3ModelStatePackage.K3_SINGLE_EMF_REFERENCE_RTD__REFERENCE_VALUE:
				return basicSetReferenceValue(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case K3ModelStatePackage.K3_SINGLE_EMF_REFERENCE_RTD__REFERENCE_VALUE:
				return getReferenceValue();
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
			case K3ModelStatePackage.K3_SINGLE_EMF_REFERENCE_RTD__REFERENCE_VALUE:
				setReferenceValue((EObject)newValue);
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
			case K3ModelStatePackage.K3_SINGLE_EMF_REFERENCE_RTD__REFERENCE_VALUE:
				setReferenceValue((EObject)null);
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
			case K3ModelStatePackage.K3_SINGLE_EMF_REFERENCE_RTD__REFERENCE_VALUE:
				return referenceValue != null;
		}
		return super.eIsSet(featureID);
	}

} //K3SingleEMFReferenceRTDImpl
