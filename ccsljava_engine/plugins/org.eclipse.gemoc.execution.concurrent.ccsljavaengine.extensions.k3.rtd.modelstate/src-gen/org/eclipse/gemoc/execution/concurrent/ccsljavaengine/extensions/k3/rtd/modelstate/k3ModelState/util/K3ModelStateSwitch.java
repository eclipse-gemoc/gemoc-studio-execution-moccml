/**
 */
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelStatePackage
 * @generated
 */
public class K3ModelStateSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static K3ModelStatePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public K3ModelStateSwitch() {
		if (modelPackage == null) {
			modelPackage = K3ModelStatePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case K3ModelStatePackage.K3_MODEL_STATE: {
				K3ModelState k3ModelState = (K3ModelState)theEObject;
				T result = caseK3ModelState(k3ModelState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case K3ModelStatePackage.ELEMENT_STATE: {
				ElementState elementState = (ElementState)theEObject;
				T result = caseElementState(elementState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case K3ModelStatePackage.K3_ATTRIBUTE_RTD: {
				K3AttributeRTD k3AttributeRTD = (K3AttributeRTD)theEObject;
				T result = caseK3AttributeRTD(k3AttributeRTD);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case K3ModelStatePackage.K3_STRING_ATTRIBUTE_RTD: {
				K3StringAttributeRTD k3StringAttributeRTD = (K3StringAttributeRTD)theEObject;
				T result = caseK3StringAttributeRTD(k3StringAttributeRTD);
				if (result == null) result = caseK3AttributeRTD(k3StringAttributeRTD);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case K3ModelStatePackage.K3_RAW_ATTRIBUTE_RTD: {
				K3RawAttributeRTD k3RawAttributeRTD = (K3RawAttributeRTD)theEObject;
				T result = caseK3RawAttributeRTD(k3RawAttributeRTD);
				if (result == null) result = caseK3AttributeRTD(k3RawAttributeRTD);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case K3ModelStatePackage.K3_SINGLE_EMF_REFERENCE_RTD: {
				K3SingleEMFReferenceRTD k3SingleEMFReferenceRTD = (K3SingleEMFReferenceRTD)theEObject;
				T result = caseK3SingleEMFReferenceRTD(k3SingleEMFReferenceRTD);
				if (result == null) result = caseK3AttributeRTD(k3SingleEMFReferenceRTD);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case K3ModelStatePackage.K3_MANY_EMF_REFERENCE_RTD: {
				K3ManyEMFReferenceRTD k3ManyEMFReferenceRTD = (K3ManyEMFReferenceRTD)theEObject;
				T result = caseK3ManyEMFReferenceRTD(k3ManyEMFReferenceRTD);
				if (result == null) result = caseK3AttributeRTD(k3ManyEMFReferenceRTD);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>K3 Model State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>K3 Model State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseK3ModelState(K3ModelState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementState(ElementState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>K3 Attribute RTD</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>K3 Attribute RTD</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseK3AttributeRTD(K3AttributeRTD object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>K3 String Attribute RTD</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>K3 String Attribute RTD</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseK3StringAttributeRTD(K3StringAttributeRTD object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>K3 Raw Attribute RTD</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>K3 Raw Attribute RTD</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseK3RawAttributeRTD(K3RawAttributeRTD object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>K3 Single EMF Reference RTD</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>K3 Single EMF Reference RTD</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseK3SingleEMFReferenceRTD(K3SingleEMFReferenceRTD object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>K3 Many EMF Reference RTD</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>K3 Many EMF Reference RTD</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseK3ManyEMFReferenceRTD(K3ManyEMFReferenceRTD object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //K3ModelStateSwitch
