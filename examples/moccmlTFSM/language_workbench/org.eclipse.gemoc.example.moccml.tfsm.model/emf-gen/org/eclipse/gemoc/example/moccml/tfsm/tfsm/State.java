/**
 */
package org.eclipse.gemoc.example.moccml.tfsm.tfsm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gemoc.example.moccml.tfsm.tfsm.State#getOwningFSM <em>Owning FSM</em>}</li>
 *   <li>{@link org.eclipse.gemoc.example.moccml.tfsm.tfsm.State#getOutgoingTransitions <em>Outgoing Transitions</em>}</li>
 *   <li>{@link org.eclipse.gemoc.example.moccml.tfsm.tfsm.State#getIncomingTransitions <em>Incoming Transitions</em>}</li>
 * </ul>
 *
 * @see org.eclipse.gemoc.example.moccml.tfsm.tfsm.TfsmPackage#getState()
 * @model
 * @generated
 */
public interface State extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owning FSM</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gemoc.example.moccml.tfsm.tfsm.TFSM#getOwnedStates <em>Owned States</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning FSM</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning FSM</em>' container reference.
	 * @see #setOwningFSM(TFSM)
	 * @see org.eclipse.gemoc.example.moccml.tfsm.tfsm.TfsmPackage#getState_OwningFSM()
	 * @see org.eclipse.gemoc.example.moccml.tfsm.tfsm.TFSM#getOwnedStates
	 * @model opposite="ownedStates" required="true" transient="false"
	 * @generated
	 */
	TFSM getOwningFSM();

	/**
	 * Sets the value of the '{@link org.eclipse.gemoc.example.moccml.tfsm.tfsm.State#getOwningFSM <em>Owning FSM</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning FSM</em>' container reference.
	 * @see #getOwningFSM()
	 * @generated
	 */
	void setOwningFSM(TFSM value);

	/**
	 * Returns the value of the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gemoc.example.moccml.tfsm.tfsm.Transition}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gemoc.example.moccml.tfsm.tfsm.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Transitions</em>' reference list.
	 * @see org.eclipse.gemoc.example.moccml.tfsm.tfsm.TfsmPackage#getState_OutgoingTransitions()
	 * @see org.eclipse.gemoc.example.moccml.tfsm.tfsm.Transition#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<Transition> getOutgoingTransitions();

	/**
	 * Returns the value of the '<em><b>Incoming Transitions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gemoc.example.moccml.tfsm.tfsm.Transition}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gemoc.example.moccml.tfsm.tfsm.Transition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Transitions</em>' reference list.
	 * @see org.eclipse.gemoc.example.moccml.tfsm.tfsm.TfsmPackage#getState_IncomingTransitions()
	 * @see org.eclipse.gemoc.example.moccml.tfsm.tfsm.Transition#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<Transition> getIncomingTransitions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void onEnter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void onLeave();

} // State
