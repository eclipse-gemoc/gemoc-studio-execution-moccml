/**
 */
package org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.ObjectVariable;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.RewritingRuleCallStatement;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.TestScenarioLangPackage;

import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.Variable;
import org.eclipse.xtext.common.types.JvmOperation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rewriting Rule Call Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.RewritingRuleCallStatementImpl#getObjectVariable <em>Object Variable</em>}</li>
 *   <li>{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.RewritingRuleCallStatementImpl#getMethod <em>Method</em>}</li>
 *   <li>{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.RewritingRuleCallStatementImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RewritingRuleCallStatementImpl extends StatementImpl implements RewritingRuleCallStatement {
	/**
	 * The cached value of the '{@link #getObjectVariable() <em>Object Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectVariable()
	 * @generated
	 * @ordered
	 */
	protected ObjectVariable objectVariable;

	/**
	 * The cached value of the '{@link #getMethod() <em>Method</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethod()
	 * @generated
	 * @ordered
	 */
	protected JvmOperation method;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> parameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RewritingRuleCallStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestScenarioLangPackage.Literals.REWRITING_RULE_CALL_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectVariable getObjectVariable() {
		if (objectVariable != null && objectVariable.eIsProxy()) {
			InternalEObject oldObjectVariable = (InternalEObject)objectVariable;
			objectVariable = (ObjectVariable)eResolveProxy(oldObjectVariable);
			if (objectVariable != oldObjectVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestScenarioLangPackage.REWRITING_RULE_CALL_STATEMENT__OBJECT_VARIABLE, oldObjectVariable, objectVariable));
			}
		}
		return objectVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectVariable basicGetObjectVariable() {
		return objectVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setObjectVariable(ObjectVariable newObjectVariable) {
		ObjectVariable oldObjectVariable = objectVariable;
		objectVariable = newObjectVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestScenarioLangPackage.REWRITING_RULE_CALL_STATEMENT__OBJECT_VARIABLE, oldObjectVariable, objectVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JvmOperation getMethod() {
		if (method != null && method.eIsProxy()) {
			InternalEObject oldMethod = (InternalEObject)method;
			method = (JvmOperation)eResolveProxy(oldMethod);
			if (method != oldMethod) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestScenarioLangPackage.REWRITING_RULE_CALL_STATEMENT__METHOD, oldMethod, method));
			}
		}
		return method;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmOperation basicGetMethod() {
		return method;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMethod(JvmOperation newMethod) {
		JvmOperation oldMethod = method;
		method = newMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestScenarioLangPackage.REWRITING_RULE_CALL_STATEMENT__METHOD, oldMethod, method));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Variable> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Variable>(Variable.class, this, TestScenarioLangPackage.REWRITING_RULE_CALL_STATEMENT__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestScenarioLangPackage.REWRITING_RULE_CALL_STATEMENT__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
			case TestScenarioLangPackage.REWRITING_RULE_CALL_STATEMENT__OBJECT_VARIABLE:
				if (resolve) return getObjectVariable();
				return basicGetObjectVariable();
			case TestScenarioLangPackage.REWRITING_RULE_CALL_STATEMENT__METHOD:
				if (resolve) return getMethod();
				return basicGetMethod();
			case TestScenarioLangPackage.REWRITING_RULE_CALL_STATEMENT__PARAMETERS:
				return getParameters();
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
			case TestScenarioLangPackage.REWRITING_RULE_CALL_STATEMENT__OBJECT_VARIABLE:
				setObjectVariable((ObjectVariable)newValue);
				return;
			case TestScenarioLangPackage.REWRITING_RULE_CALL_STATEMENT__METHOD:
				setMethod((JvmOperation)newValue);
				return;
			case TestScenarioLangPackage.REWRITING_RULE_CALL_STATEMENT__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Variable>)newValue);
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
			case TestScenarioLangPackage.REWRITING_RULE_CALL_STATEMENT__OBJECT_VARIABLE:
				setObjectVariable((ObjectVariable)null);
				return;
			case TestScenarioLangPackage.REWRITING_RULE_CALL_STATEMENT__METHOD:
				setMethod((JvmOperation)null);
				return;
			case TestScenarioLangPackage.REWRITING_RULE_CALL_STATEMENT__PARAMETERS:
				getParameters().clear();
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
			case TestScenarioLangPackage.REWRITING_RULE_CALL_STATEMENT__OBJECT_VARIABLE:
				return objectVariable != null;
			case TestScenarioLangPackage.REWRITING_RULE_CALL_STATEMENT__METHOD:
				return method != null;
			case TestScenarioLangPackage.REWRITING_RULE_CALL_STATEMENT__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RewritingRuleCallStatementImpl
