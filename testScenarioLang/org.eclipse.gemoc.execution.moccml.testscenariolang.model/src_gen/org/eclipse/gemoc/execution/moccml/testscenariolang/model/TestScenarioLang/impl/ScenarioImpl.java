/**
 */
package org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.ImportStatement;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.ImportJavaStatement;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.ObjectVariable;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.Scenario;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.Statement;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.TestScenarioLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.ScenarioImpl#getModelImports <em>Model Imports</em>}</li>
 *   <li>{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.ScenarioImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.ScenarioImpl#getStatementSequence <em>Statement Sequence</em>}</li>
 *   <li>{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.ScenarioImpl#getClassImports <em>Class Imports</em>}</li>
 *   <li>{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.ScenarioImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScenarioImpl extends EObjectImpl implements Scenario {
	/**
	 * The cached value of the '{@link #getModelImports() <em>Model Imports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelImports()
	 * @generated
	 * @ordered
	 */
	protected EList<ImportStatement> modelImports;

	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<ObjectVariable> variables;

	/**
	 * The cached value of the '{@link #getStatementSequence() <em>Statement Sequence</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatementSequence()
	 * @generated
	 * @ordered
	 */
	protected EList<Statement> statementSequence;

	/**
	 * The cached value of the '{@link #getClassImports() <em>Class Imports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassImports()
	 * @generated
	 * @ordered
	 */
	protected EList<ImportJavaStatement> classImports;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScenarioImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestScenarioLangPackage.Literals.SCENARIO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ImportStatement> getModelImports() {
		if (modelImports == null) {
			modelImports = new EObjectContainmentEList<ImportStatement>(ImportStatement.class, this, TestScenarioLangPackage.SCENARIO__MODEL_IMPORTS);
		}
		return modelImports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ObjectVariable> getVariables() {
		if (variables == null) {
			variables = new EObjectContainmentEList<ObjectVariable>(ObjectVariable.class, this, TestScenarioLangPackage.SCENARIO__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Statement> getStatementSequence() {
		if (statementSequence == null) {
			statementSequence = new EObjectContainmentEList<Statement>(Statement.class, this, TestScenarioLangPackage.SCENARIO__STATEMENT_SEQUENCE);
		}
		return statementSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ImportJavaStatement> getClassImports() {
		if (classImports == null) {
			classImports = new EObjectContainmentEList<ImportJavaStatement>(ImportJavaStatement.class, this, TestScenarioLangPackage.SCENARIO__CLASS_IMPORTS);
		}
		return classImports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestScenarioLangPackage.SCENARIO__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestScenarioLangPackage.SCENARIO__MODEL_IMPORTS:
				return ((InternalEList<?>)getModelImports()).basicRemove(otherEnd, msgs);
			case TestScenarioLangPackage.SCENARIO__VARIABLES:
				return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
			case TestScenarioLangPackage.SCENARIO__STATEMENT_SEQUENCE:
				return ((InternalEList<?>)getStatementSequence()).basicRemove(otherEnd, msgs);
			case TestScenarioLangPackage.SCENARIO__CLASS_IMPORTS:
				return ((InternalEList<?>)getClassImports()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestScenarioLangPackage.SCENARIO__MODEL_IMPORTS:
				return getModelImports();
			case TestScenarioLangPackage.SCENARIO__VARIABLES:
				return getVariables();
			case TestScenarioLangPackage.SCENARIO__STATEMENT_SEQUENCE:
				return getStatementSequence();
			case TestScenarioLangPackage.SCENARIO__CLASS_IMPORTS:
				return getClassImports();
			case TestScenarioLangPackage.SCENARIO__NAME:
				return getName();
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
			case TestScenarioLangPackage.SCENARIO__MODEL_IMPORTS:
				getModelImports().clear();
				getModelImports().addAll((Collection<? extends ImportStatement>)newValue);
				return;
			case TestScenarioLangPackage.SCENARIO__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends ObjectVariable>)newValue);
				return;
			case TestScenarioLangPackage.SCENARIO__STATEMENT_SEQUENCE:
				getStatementSequence().clear();
				getStatementSequence().addAll((Collection<? extends Statement>)newValue);
				return;
			case TestScenarioLangPackage.SCENARIO__CLASS_IMPORTS:
				getClassImports().clear();
				getClassImports().addAll((Collection<? extends ImportJavaStatement>)newValue);
				return;
			case TestScenarioLangPackage.SCENARIO__NAME:
				setName((String)newValue);
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
			case TestScenarioLangPackage.SCENARIO__MODEL_IMPORTS:
				getModelImports().clear();
				return;
			case TestScenarioLangPackage.SCENARIO__VARIABLES:
				getVariables().clear();
				return;
			case TestScenarioLangPackage.SCENARIO__STATEMENT_SEQUENCE:
				getStatementSequence().clear();
				return;
			case TestScenarioLangPackage.SCENARIO__CLASS_IMPORTS:
				getClassImports().clear();
				return;
			case TestScenarioLangPackage.SCENARIO__NAME:
				setName(NAME_EDEFAULT);
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
			case TestScenarioLangPackage.SCENARIO__MODEL_IMPORTS:
				return modelImports != null && !modelImports.isEmpty();
			case TestScenarioLangPackage.SCENARIO__VARIABLES:
				return variables != null && !variables.isEmpty();
			case TestScenarioLangPackage.SCENARIO__STATEMENT_SEQUENCE:
				return statementSequence != null && !statementSequence.isEmpty();
			case TestScenarioLangPackage.SCENARIO__CLASS_IMPORTS:
				return classImports != null && !classImports.isEmpty();
			case TestScenarioLangPackage.SCENARIO__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ScenarioImpl
