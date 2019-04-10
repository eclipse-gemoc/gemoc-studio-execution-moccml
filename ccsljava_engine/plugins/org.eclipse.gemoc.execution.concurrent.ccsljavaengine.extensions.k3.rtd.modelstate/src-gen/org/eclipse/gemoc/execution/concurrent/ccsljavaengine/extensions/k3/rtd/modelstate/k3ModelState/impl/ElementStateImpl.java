/**
 */
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.ElementState;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelStatePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.ElementStateImpl#getSavedRTDs <em>Saved RT Ds</em>}</li>
 *   <li>{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.ElementStateImpl#getModelElement <em>Model Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ElementStateImpl extends MinimalEObjectImpl.Container implements ElementState {
	/**
	 * The cached value of the '{@link #getSavedRTDs() <em>Saved RT Ds</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSavedRTDs()
	 * @generated
	 * @ordered
	 */
	protected EList<Object> savedRTDs;

	/**
	 * The cached value of the '{@link #getModelElement() <em>Model Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelElement()
	 * @generated
	 * @ordered
	 */
	protected EObject modelElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return K3ModelStatePackage.Literals.ELEMENT_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Object> getSavedRTDs() {
		if (savedRTDs == null) {
			savedRTDs = new EDataTypeUniqueEList<Object>(Object.class, this, K3ModelStatePackage.ELEMENT_STATE__SAVED_RT_DS);
		}
		return savedRTDs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getModelElement() {
		if (modelElement != null && modelElement.eIsProxy()) {
			InternalEObject oldModelElement = (InternalEObject)modelElement;
			modelElement = eResolveProxy(oldModelElement);
			if (modelElement != oldModelElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, K3ModelStatePackage.ELEMENT_STATE__MODEL_ELEMENT, oldModelElement, modelElement));
			}
		}
		return modelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetModelElement() {
		return modelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelElement(EObject newModelElement) {
		EObject oldModelElement = modelElement;
		modelElement = newModelElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, K3ModelStatePackage.ELEMENT_STATE__MODEL_ELEMENT, oldModelElement, modelElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case K3ModelStatePackage.ELEMENT_STATE__SAVED_RT_DS:
				return getSavedRTDs();
			case K3ModelStatePackage.ELEMENT_STATE__MODEL_ELEMENT:
				if (resolve) return getModelElement();
				return basicGetModelElement();
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
			case K3ModelStatePackage.ELEMENT_STATE__SAVED_RT_DS:
				getSavedRTDs().clear();
				getSavedRTDs().addAll((Collection<? extends Object>)newValue);
				return;
			case K3ModelStatePackage.ELEMENT_STATE__MODEL_ELEMENT:
				setModelElement((EObject)newValue);
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
			case K3ModelStatePackage.ELEMENT_STATE__SAVED_RT_DS:
				getSavedRTDs().clear();
				return;
			case K3ModelStatePackage.ELEMENT_STATE__MODEL_ELEMENT:
				setModelElement((EObject)null);
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
			case K3ModelStatePackage.ELEMENT_STATE__SAVED_RT_DS:
				return savedRTDs != null && !savedRTDs.isEmpty();
			case K3ModelStatePackage.ELEMENT_STATE__MODEL_ELEMENT:
				return modelElement != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (savedRTDs: ");
		result.append(savedRTDs);
		result.append(')');
		return result.toString();
	}

} //ElementStateImpl
