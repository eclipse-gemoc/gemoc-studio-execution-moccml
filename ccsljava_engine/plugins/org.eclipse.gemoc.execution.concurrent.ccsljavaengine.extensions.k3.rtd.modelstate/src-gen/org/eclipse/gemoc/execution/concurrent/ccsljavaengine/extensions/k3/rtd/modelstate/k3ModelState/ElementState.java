/**
 */
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.ElementState#getSavedRTDs <em>Saved RT Ds</em>}</li>
 *   <li>{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.ElementState#getModelElement <em>Model Element</em>}</li>
 * </ul>
 *
 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelStatePackage#getElementState()
 * @model
 * @generated
 */
public interface ElementState extends EObject {
	/**
	 * Returns the value of the '<em><b>Saved RT Ds</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Object}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Saved RT Ds</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Saved RT Ds</em>' attribute list.
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelStatePackage#getElementState_SavedRTDs()
	 * @model dataType="org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.JavaObject"
	 * @generated
	 */
	EList<Object> getSavedRTDs();

	/**
	 * Returns the value of the '<em><b>Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Element</em>' reference.
	 * @see #setModelElement(EObject)
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelStatePackage#getElementState_ModelElement()
	 * @model
	 * @generated
	 */
	EObject getModelElement();

	/**
	 * Sets the value of the '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.ElementState#getModelElement <em>Model Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Element</em>' reference.
	 * @see #getModelElement()
	 * @generated
	 */
	void setModelElement(EObject value);

} // ElementState
