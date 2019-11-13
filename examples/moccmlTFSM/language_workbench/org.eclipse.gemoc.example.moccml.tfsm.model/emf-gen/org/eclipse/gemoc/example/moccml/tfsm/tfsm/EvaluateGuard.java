/**
 */
package org.eclipse.gemoc.example.moccml.tfsm.tfsm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Evaluate Guard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gemoc.example.moccml.tfsm.tfsm.EvaluateGuard#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see org.eclipse.gemoc.example.moccml.tfsm.tfsm.TfsmPackage#getEvaluateGuard()
 * @model
 * @generated
 */
public interface EvaluateGuard extends Guard {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' attribute.
	 * @see #setCondition(String)
	 * @see org.eclipse.gemoc.example.moccml.tfsm.tfsm.TfsmPackage#getEvaluateGuard_Condition()
	 * @model
	 * @generated
	 */
	String getCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.gemoc.example.moccml.tfsm.tfsm.EvaluateGuard#getCondition <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' attribute.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean evaluate();

} // EvaluateGuard
