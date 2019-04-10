/**
 */
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.ElementState;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelState;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelStatePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>K3 Model State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3ModelStateImpl#getOwnedElementstates <em>Owned Elementstates</em>}</li>
 * </ul>
 *
 * @generated
 */
public class K3ModelStateImpl extends MinimalEObjectImpl.Container implements K3ModelState {
	/**
	 * The cached value of the '{@link #getOwnedElementstates() <em>Owned Elementstates</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedElementstates()
	 * @generated
	 * @ordered
	 */
	protected EList<ElementState> ownedElementstates;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected K3ModelStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return K3ModelStatePackage.Literals.K3_MODEL_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ElementState> getOwnedElementstates() {
		if (ownedElementstates == null) {
			ownedElementstates = new EObjectContainmentEList<ElementState>(ElementState.class, this, K3ModelStatePackage.K3_MODEL_STATE__OWNED_ELEMENTSTATES);
		}
		return ownedElementstates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case K3ModelStatePackage.K3_MODEL_STATE__OWNED_ELEMENTSTATES:
				return ((InternalEList<?>)getOwnedElementstates()).basicRemove(otherEnd, msgs);
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
			case K3ModelStatePackage.K3_MODEL_STATE__OWNED_ELEMENTSTATES:
				return getOwnedElementstates();
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
			case K3ModelStatePackage.K3_MODEL_STATE__OWNED_ELEMENTSTATES:
				getOwnedElementstates().clear();
				getOwnedElementstates().addAll((Collection<? extends ElementState>)newValue);
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
			case K3ModelStatePackage.K3_MODEL_STATE__OWNED_ELEMENTSTATES:
				getOwnedElementstates().clear();
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
			case K3ModelStatePackage.K3_MODEL_STATE__OWNED_ELEMENTSTATES:
				return ownedElementstates != null && !ownedElementstates.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //K3ModelStateImpl
