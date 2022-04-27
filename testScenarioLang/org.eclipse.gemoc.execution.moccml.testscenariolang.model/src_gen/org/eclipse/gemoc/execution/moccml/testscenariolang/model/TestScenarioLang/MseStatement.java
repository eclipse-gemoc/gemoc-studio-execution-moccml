/**
 */
package org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;

import fr.inria.aoste.trace.EnableStateKind;
import fr.inria.aoste.trace.FiredStateKind;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mse Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.MseStatement#getClocks <em>Clocks</em>}</li>
 *   <li>{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.MseStatement#getFireState <em>Fire State</em>}</li>
 *   <li>{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.MseStatement#getEnableState <em>Enable State</em>}</li>
 *   <li>{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.MseStatement#getLiveState <em>Live State</em>}</li>
 * </ul>
 *
 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.TestScenarioLangPackage#getMseStatement()
 * @model
 * @generated
 */
public interface MseStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Clocks</b></em>' reference list.
	 * The list contents are of type {@link fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clocks</em>' reference list.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.TestScenarioLangPackage#getMseStatement_Clocks()
	 * @model required="true"
	 * @generated
	 */
	EList<Clock> getClocks();

	/**
	 * Returns the value of the '<em><b>Fire State</b></em>' attribute list.
	 * The list contents are of type {@link fr.inria.aoste.trace.FiredStateKind}.
	 * The literals are from the enumeration {@link fr.inria.aoste.trace.FiredStateKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fire State</em>' attribute list.
	 * @see fr.inria.aoste.trace.FiredStateKind
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.TestScenarioLangPackage#getMseStatement_FireState()
	 * @model
	 * @generated
	 */
	EList<FiredStateKind> getFireState();

	/**
	 * Returns the value of the '<em><b>Enable State</b></em>' attribute list.
	 * The list contents are of type {@link fr.inria.aoste.trace.EnableStateKind}.
	 * The literals are from the enumeration {@link fr.inria.aoste.trace.EnableStateKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enable State</em>' attribute list.
	 * @see fr.inria.aoste.trace.EnableStateKind
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.TestScenarioLangPackage#getMseStatement_EnableState()
	 * @model
	 * @generated
	 */
	EList<EnableStateKind> getEnableState();

	/**
	 * Returns the value of the '<em><b>Live State</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.LiveStateKind}.
	 * The literals are from the enumeration {@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.LiveStateKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Live State</em>' attribute list.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.LiveStateKind
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.TestScenarioLangPackage#getMseStatement_LiveState()
	 * @model
	 * @generated
	 */
	EList<LiveStateKind> getLiveState();

} // MseStatement
