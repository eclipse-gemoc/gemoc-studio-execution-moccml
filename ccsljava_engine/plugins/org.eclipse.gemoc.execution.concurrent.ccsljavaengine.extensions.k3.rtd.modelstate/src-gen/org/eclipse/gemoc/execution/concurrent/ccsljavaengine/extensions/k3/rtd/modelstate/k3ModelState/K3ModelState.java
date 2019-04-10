/**
 */
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>K3 Model State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelState#getOwnedElementstates <em>Owned Elementstates</em>}</li>
 * </ul>
 *
 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelStatePackage#getK3ModelState()
 * @model
 * @generated
 */
public interface K3ModelState extends EObject {
	/**
	 * Returns the value of the '<em><b>Owned Elementstates</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.ElementState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Elementstates</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Elementstates</em>' containment reference list.
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelStatePackage#getK3ModelState_OwnedElementstates()
	 * @model containment="true"
	 * @generated
	 */
	EList<ElementState> getOwnedElementstates();

} // K3ModelState
