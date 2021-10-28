/**
 */
package org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import Java Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.ImportJavaStatement#getImportedNamespace <em>Imported Namespace</em>}</li>
 * </ul>
 *
 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.TestScenarioLangPackage#getImportJavaStatement()
 * @model
 * @generated
 */
public interface ImportJavaStatement extends EObject {
	/**
	 * Returns the value of the '<em><b>Imported Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported Namespace</em>' attribute.
	 * @see #setImportedNamespace(String)
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.TestScenarioLangPackage#getImportJavaStatement_ImportedNamespace()
	 * @model required="true"
	 * @generated
	 */
	String getImportedNamespace();

	/**
	 * Sets the value of the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.ImportJavaStatement#getImportedNamespace <em>Imported Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imported Namespace</em>' attribute.
	 * @see #getImportedNamespace()
	 * @generated
	 */
	void setImportedNamespace(String value);

} // ImportJavaStatement
