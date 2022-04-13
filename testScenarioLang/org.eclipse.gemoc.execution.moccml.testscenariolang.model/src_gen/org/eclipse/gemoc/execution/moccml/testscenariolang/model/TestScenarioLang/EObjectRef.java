/**
 */
package org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EObject Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.EObjectRef#getObject <em>Object</em>}</li>
 * </ul>
 *
 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.TestScenarioLangPackage#getEObjectRef()
 * @model
 * @generated
 */
public interface EObjectRef extends Variable {
	/**
	 * Returns the value of the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' reference.
	 * @see #setObject(EObject)
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.TestScenarioLangPackage#getEObjectRef_Object()
	 * @model required="true"
	 * @generated
	 */
	EObject getObject();

	/**
	 * Sets the value of the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.EObjectRef#getObject <em>Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(EObject value);

} // EObjectRef
