/**
 */
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ManyEMFReferenceRTD;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelStatePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>K3 Many EMF Reference RTD</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3ManyEMFReferenceRTDImpl#getReferenceValues <em>Reference Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class K3ManyEMFReferenceRTDImpl extends K3AttributeRTDImpl implements K3ManyEMFReferenceRTD {
	/**
	 * The cached value of the '{@link #getReferenceValues() <em>Reference Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceValues()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> referenceValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected K3ManyEMFReferenceRTDImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return K3ModelStatePackage.Literals.K3_MANY_EMF_REFERENCE_RTD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EObject> getReferenceValues() {
		if (referenceValues == null) {
			referenceValues = new EObjectContainmentEList<EObject>(EObject.class, this, K3ModelStatePackage.K3_MANY_EMF_REFERENCE_RTD__REFERENCE_VALUES);
		}
		return referenceValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case K3ModelStatePackage.K3_MANY_EMF_REFERENCE_RTD__REFERENCE_VALUES:
				return ((InternalEList<?>)getReferenceValues()).basicRemove(otherEnd, msgs);
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
			case K3ModelStatePackage.K3_MANY_EMF_REFERENCE_RTD__REFERENCE_VALUES:
				return getReferenceValues();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case K3ModelStatePackage.K3_MANY_EMF_REFERENCE_RTD__REFERENCE_VALUES:
				getReferenceValues().clear();
				getReferenceValues().addAll((Collection<? extends EObject>)newValue);
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
			case K3ModelStatePackage.K3_MANY_EMF_REFERENCE_RTD__REFERENCE_VALUES:
				getReferenceValues().clear();
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
			case K3ModelStatePackage.K3_MANY_EMF_REFERENCE_RTD__REFERENCE_VALUES:
				return referenceValues != null && !referenceValues.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //K3ManyEMFReferenceRTDImpl
