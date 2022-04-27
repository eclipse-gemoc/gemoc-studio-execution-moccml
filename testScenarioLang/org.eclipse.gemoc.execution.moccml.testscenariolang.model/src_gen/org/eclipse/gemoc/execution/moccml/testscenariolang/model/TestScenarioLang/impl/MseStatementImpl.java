/**
 */
package org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;

import fr.inria.aoste.trace.EnableStateKind;
import fr.inria.aoste.trace.FiredStateKind;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.LiveStateKind;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.MseStatement;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.TestScenarioLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mse Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.MseStatementImpl#getClocks <em>Clocks</em>}</li>
 *   <li>{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.MseStatementImpl#getFireState <em>Fire State</em>}</li>
 *   <li>{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.MseStatementImpl#getEnableState <em>Enable State</em>}</li>
 *   <li>{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.MseStatementImpl#getLiveState <em>Live State</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MseStatementImpl extends StatementImpl implements MseStatement {
	/**
	 * The cached value of the '{@link #getClocks() <em>Clocks</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClocks()
	 * @generated
	 * @ordered
	 */
	protected EList<Clock> clocks;

	/**
	 * The cached value of the '{@link #getFireState() <em>Fire State</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFireState()
	 * @generated
	 * @ordered
	 */
	protected EList<FiredStateKind> fireState;

	/**
	 * The cached value of the '{@link #getEnableState() <em>Enable State</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnableState()
	 * @generated
	 * @ordered
	 */
	protected EList<EnableStateKind> enableState;

	/**
	 * The cached value of the '{@link #getLiveState() <em>Live State</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiveState()
	 * @generated
	 * @ordered
	 */
	protected EList<LiveStateKind> liveState;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MseStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestScenarioLangPackage.Literals.MSE_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Clock> getClocks() {
		if (clocks == null) {
			clocks = new EObjectResolvingEList<Clock>(Clock.class, this, TestScenarioLangPackage.MSE_STATEMENT__CLOCKS);
		}
		return clocks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<FiredStateKind> getFireState() {
		if (fireState == null) {
			fireState = new EDataTypeUniqueEList<FiredStateKind>(FiredStateKind.class, this, TestScenarioLangPackage.MSE_STATEMENT__FIRE_STATE);
		}
		return fireState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EnableStateKind> getEnableState() {
		if (enableState == null) {
			enableState = new EDataTypeUniqueEList<EnableStateKind>(EnableStateKind.class, this, TestScenarioLangPackage.MSE_STATEMENT__ENABLE_STATE);
		}
		return enableState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<LiveStateKind> getLiveState() {
		if (liveState == null) {
			liveState = new EDataTypeUniqueEList<LiveStateKind>(LiveStateKind.class, this, TestScenarioLangPackage.MSE_STATEMENT__LIVE_STATE);
		}
		return liveState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestScenarioLangPackage.MSE_STATEMENT__CLOCKS:
				return getClocks();
			case TestScenarioLangPackage.MSE_STATEMENT__FIRE_STATE:
				return getFireState();
			case TestScenarioLangPackage.MSE_STATEMENT__ENABLE_STATE:
				return getEnableState();
			case TestScenarioLangPackage.MSE_STATEMENT__LIVE_STATE:
				return getLiveState();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestScenarioLangPackage.MSE_STATEMENT__CLOCKS:
				getClocks().clear();
				getClocks().addAll((Collection<? extends Clock>)newValue);
				return;
			case TestScenarioLangPackage.MSE_STATEMENT__FIRE_STATE:
				getFireState().clear();
				getFireState().addAll((Collection<? extends FiredStateKind>)newValue);
				return;
			case TestScenarioLangPackage.MSE_STATEMENT__ENABLE_STATE:
				getEnableState().clear();
				getEnableState().addAll((Collection<? extends EnableStateKind>)newValue);
				return;
			case TestScenarioLangPackage.MSE_STATEMENT__LIVE_STATE:
				getLiveState().clear();
				getLiveState().addAll((Collection<? extends LiveStateKind>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestScenarioLangPackage.MSE_STATEMENT__CLOCKS:
				getClocks().clear();
				return;
			case TestScenarioLangPackage.MSE_STATEMENT__FIRE_STATE:
				getFireState().clear();
				return;
			case TestScenarioLangPackage.MSE_STATEMENT__ENABLE_STATE:
				getEnableState().clear();
				return;
			case TestScenarioLangPackage.MSE_STATEMENT__LIVE_STATE:
				getLiveState().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestScenarioLangPackage.MSE_STATEMENT__CLOCKS:
				return clocks != null && !clocks.isEmpty();
			case TestScenarioLangPackage.MSE_STATEMENT__FIRE_STATE:
				return fireState != null && !fireState.isEmpty();
			case TestScenarioLangPackage.MSE_STATEMENT__ENABLE_STATE:
				return enableState != null && !enableState.isEmpty();
			case TestScenarioLangPackage.MSE_STATEMENT__LIVE_STATE:
				return liveState != null && !liveState.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (fireState: ");
		result.append(fireState);
		result.append(", enableState: ");
		result.append(enableState);
		result.append(", liveState: ");
		result.append(liveState);
		result.append(')');
		return result.toString();
	}

} //MseStatementImpl
