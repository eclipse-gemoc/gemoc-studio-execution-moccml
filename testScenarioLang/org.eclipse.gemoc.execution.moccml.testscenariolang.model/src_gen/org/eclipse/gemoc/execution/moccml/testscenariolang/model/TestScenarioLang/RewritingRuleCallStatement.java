/**
 */
package org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.common.types.JvmOperation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rewriting Rule Call Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.RewritingRuleCallStatement#getObjectVariable <em>Object Variable</em>}</li>
 *   <li>{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.RewritingRuleCallStatement#getMethod <em>Method</em>}</li>
 *   <li>{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.RewritingRuleCallStatement#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.TestScenarioLangPackage#getRewritingRuleCallStatement()
 * @model
 * @generated
 */
public interface RewritingRuleCallStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Object Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Variable</em>' reference.
	 * @see #setObjectVariable(ObjectVariable)
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.TestScenarioLangPackage#getRewritingRuleCallStatement_ObjectVariable()
	 * @model required="true"
	 * @generated
	 */
	ObjectVariable getObjectVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.RewritingRuleCallStatement#getObjectVariable <em>Object Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Variable</em>' reference.
	 * @see #getObjectVariable()
	 * @generated
	 */
	void setObjectVariable(ObjectVariable value);

	/**
	 * Returns the value of the '<em><b>Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method</em>' reference.
	 * @see #setMethod(JvmOperation)
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.TestScenarioLangPackage#getRewritingRuleCallStatement_Method()
	 * @model required="true"
	 * @generated
	 */
	JvmOperation getMethod();

	/**
	 * Sets the value of the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.RewritingRuleCallStatement#getMethod <em>Method</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method</em>' reference.
	 * @see #getMethod()
	 * @generated
	 */
	void setMethod(JvmOperation value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.Variable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.TestScenarioLangPackage#getRewritingRuleCallStatement_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Variable> getParameters();

} // RewritingRuleCallStatement
