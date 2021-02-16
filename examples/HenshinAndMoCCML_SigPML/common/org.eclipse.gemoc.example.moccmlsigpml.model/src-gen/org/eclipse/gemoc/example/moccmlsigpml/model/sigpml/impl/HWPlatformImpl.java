/**
 */
package org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWPlatform;
import org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWRessource;
import org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.SigpmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>HW Platform</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.HWPlatformImpl#getOwnedHWResources <em>Owned HW Resources</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HWPlatformImpl extends NamedElementImpl implements HWPlatform {
	/**
	 * The cached value of the '{@link #getOwnedHWResources() <em>Owned HW Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedHWResources()
	 * @generated
	 * @ordered
	 */
	protected EList<HWRessource> ownedHWResources;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HWPlatformImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SigpmlPackage.Literals.HW_PLATFORM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<HWRessource> getOwnedHWResources() {
		if (ownedHWResources == null) {
			ownedHWResources = new EObjectContainmentWithInverseEList<HWRessource>(HWRessource.class, this, SigpmlPackage.HW_PLATFORM__OWNED_HW_RESOURCES, SigpmlPackage.HW_RESSOURCE__OWNER);
		}
		return ownedHWResources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SigpmlPackage.HW_PLATFORM__OWNED_HW_RESOURCES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedHWResources()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SigpmlPackage.HW_PLATFORM__OWNED_HW_RESOURCES:
				return ((InternalEList<?>)getOwnedHWResources()).basicRemove(otherEnd, msgs);
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
			case SigpmlPackage.HW_PLATFORM__OWNED_HW_RESOURCES:
				return getOwnedHWResources();
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
			case SigpmlPackage.HW_PLATFORM__OWNED_HW_RESOURCES:
				getOwnedHWResources().clear();
				getOwnedHWResources().addAll((Collection<? extends HWRessource>)newValue);
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
			case SigpmlPackage.HW_PLATFORM__OWNED_HW_RESOURCES:
				getOwnedHWResources().clear();
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
			case SigpmlPackage.HW_PLATFORM__OWNED_HW_RESOURCES:
				return ownedHWResources != null && !ownedHWResources.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //HWPlatformImpl
