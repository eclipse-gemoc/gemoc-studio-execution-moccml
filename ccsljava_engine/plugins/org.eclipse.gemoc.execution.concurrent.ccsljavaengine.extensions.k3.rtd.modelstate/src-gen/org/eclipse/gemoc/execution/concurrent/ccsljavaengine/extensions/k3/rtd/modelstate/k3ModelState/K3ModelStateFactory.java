/**
 */
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelStatePackage
 * @generated
 */
public interface K3ModelStateFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	K3ModelStateFactory eINSTANCE = org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3ModelStateFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>K3 Model State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>K3 Model State</em>'.
	 * @generated
	 */
	K3ModelState createK3ModelState();

	/**
	 * Returns a new object of class '<em>Element State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Element State</em>'.
	 * @generated
	 */
	ElementState createElementState();

	/**
	 * Returns a new object of class '<em>K3 String Attribute RTD</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>K3 String Attribute RTD</em>'.
	 * @generated
	 */
	K3StringAttributeRTD createK3StringAttributeRTD();

	/**
	 * Returns a new object of class '<em>K3 Raw Attribute RTD</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>K3 Raw Attribute RTD</em>'.
	 * @generated
	 */
	K3RawAttributeRTD createK3RawAttributeRTD();

	/**
	 * Returns a new object of class '<em>K3 Single EMF Reference RTD</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>K3 Single EMF Reference RTD</em>'.
	 * @generated
	 */
	K3SingleEMFReferenceRTD createK3SingleEMFReferenceRTD();

	/**
	 * Returns a new object of class '<em>K3 Many EMF Reference RTD</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>K3 Many EMF Reference RTD</em>'.
	 * @generated
	 */
	K3ManyEMFReferenceRTD createK3ManyEMFReferenceRTD();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	K3ModelStatePackage getK3ModelStatePackage();

} //K3ModelStateFactory
