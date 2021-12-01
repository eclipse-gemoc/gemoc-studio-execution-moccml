/**
 */
package org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWStorageResource;
import org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place;
import org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.SigpmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>HW Storage Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.HWStorageResourceImpl#getAllocatedPlaces <em>Allocated Places</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HWStorageResourceImpl extends HWRessourceImpl implements HWStorageResource {
	/**
	 * The cached value of the '{@link #getAllocatedPlaces() <em>Allocated Places</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocatedPlaces()
	 * @generated
	 * @ordered
	 */
	protected EList<Place> allocatedPlaces;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HWStorageResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SigpmlPackage.Literals.HW_STORAGE_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Place> getAllocatedPlaces() {
		if (allocatedPlaces == null) {
			allocatedPlaces = new EObjectResolvingEList<Place>(Place.class, this, SigpmlPackage.HW_STORAGE_RESOURCE__ALLOCATED_PLACES);
		}
		return allocatedPlaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SigpmlPackage.HW_STORAGE_RESOURCE__ALLOCATED_PLACES:
				return getAllocatedPlaces();
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
			case SigpmlPackage.HW_STORAGE_RESOURCE__ALLOCATED_PLACES:
				getAllocatedPlaces().clear();
				getAllocatedPlaces().addAll((Collection<? extends Place>)newValue);
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
			case SigpmlPackage.HW_STORAGE_RESOURCE__ALLOCATED_PLACES:
				getAllocatedPlaces().clear();
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
			case SigpmlPackage.HW_STORAGE_RESOURCE__ALLOCATED_PLACES:
				return allocatedPlaces != null && !allocatedPlaces.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //HWStorageResourceImpl
