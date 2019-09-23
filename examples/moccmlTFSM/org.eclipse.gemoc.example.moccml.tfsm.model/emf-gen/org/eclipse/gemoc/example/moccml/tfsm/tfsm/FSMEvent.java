/**
 */
package org.eclipse.gemoc.example.moccml.tfsm.tfsm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FSM Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gemoc.example.moccml.tfsm.tfsm.FSMEvent#getSollicitingTransitions <em>Solliciting Transitions</em>}</li>
 * </ul>
 *
 * @see org.eclipse.gemoc.example.moccml.tfsm.tfsm.TfsmPackage#getFSMEvent()
 * @model
 * @generated
 */
public interface FSMEvent extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Solliciting Transitions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gemoc.example.moccml.tfsm.tfsm.Transition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solliciting Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solliciting Transitions</em>' reference list.
	 * @see org.eclipse.gemoc.example.moccml.tfsm.tfsm.TfsmPackage#getFSMEvent_SollicitingTransitions()
	 * @model
	 * @generated
	 */
	EList<Transition> getSollicitingTransitions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void occurs();

} // FSMEvent
