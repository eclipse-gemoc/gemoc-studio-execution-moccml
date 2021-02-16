/**
 */
package org.eclipse.gemoc.example.moccmlsigpml.model.sigpml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Application#getOwnedAgents <em>Owned Agents</em>}</li>
 *   <li>{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Application#getOwnedPlaces <em>Owned Places</em>}</li>
 * </ul>
 *
 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.SigpmlPackage#getApplication()
 * @model
 * @generated
 */
public interface Application extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owned Agents</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Agents</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Agents</em>' containment reference list.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.SigpmlPackage#getApplication_OwnedAgents()
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Agent> getOwnedAgents();

	/**
	 * Returns the value of the '<em><b>Owned Places</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Places</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Places</em>' containment reference list.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.SigpmlPackage#getApplication_OwnedPlaces()
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Place> getOwnedPlaces();

} // Application
