/**
 */
package org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.VariableRef#getVar <em>Var</em>}</li>
 * </ul>
 *
 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.TestScenarioLangPackage#getVariableRef()
 * @model
 * @generated
 */
public interface VariableRef extends Variable {
	/**
	 * Returns the value of the '<em><b>Var</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var</em>' reference.
	 * @see #setVar(ObjectVariable)
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.TestScenarioLangPackage#getVariableRef_Var()
	 * @model required="true"
	 * @generated
	 */
	ObjectVariable getVar();

	/**
	 * Sets the value of the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.VariableRef#getVar <em>Var</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var</em>' reference.
	 * @see #getVar()
	 * @generated
	 */
	void setVar(ObjectVariable value);

} // VariableRef
