/**
 */
package org.eclipse.gemoc.example.moccmlsigpml.model.sigpml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Port#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Port#getRate <em>Rate</em>}</li>
 * </ul>
 *
 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.SigpmlPackage#getPort()
 * @model abstract="true"
 * @generated
 */
public interface Port extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent#getOwnedPorts <em>Owned Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Agent)
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.SigpmlPackage#getPort_Owner()
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent#getOwnedPorts
	 * @model opposite="ownedPorts" required="true" transient="false"
	 * @generated
	 */
	Agent getOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Port#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Agent value);

	/**
	 * Returns the value of the '<em><b>Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rate</em>' attribute.
	 * @see #setRate(int)
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.SigpmlPackage#getPort_Rate()
	 * @model required="true"
	 * @generated
	 */
	int getRate();

	/**
	 * Sets the value of the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Port#getRate <em>Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rate</em>' attribute.
	 * @see #getRate()
	 * @generated
	 */
	void setRate(int value);

} // Port
