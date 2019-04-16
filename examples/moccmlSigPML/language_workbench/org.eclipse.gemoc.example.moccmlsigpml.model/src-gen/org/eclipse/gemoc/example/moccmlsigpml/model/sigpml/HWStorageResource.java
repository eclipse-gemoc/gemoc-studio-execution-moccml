/**
 */
package org.eclipse.gemoc.example.moccmlsigpml.model.sigpml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>HW Storage Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWStorageResource#getAllocatedPlaces <em>Allocated Places</em>}</li>
 * </ul>
 *
 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.SigpmlPackage#getHWStorageResource()
 * @model
 * @generated
 */
public interface HWStorageResource extends HWRessource {
	/**
	 * Returns the value of the '<em><b>Allocated Places</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allocated Places</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allocated Places</em>' reference list.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.SigpmlPackage#getHWStorageResource_AllocatedPlaces()
	 * @model
	 * @generated
	 */
	EList<Place> getAllocatedPlaces();

} // HWStorageResource
