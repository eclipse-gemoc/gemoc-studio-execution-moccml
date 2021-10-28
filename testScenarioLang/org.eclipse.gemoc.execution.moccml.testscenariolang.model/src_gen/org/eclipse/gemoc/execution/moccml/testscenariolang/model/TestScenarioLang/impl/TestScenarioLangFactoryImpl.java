/**
 */
package org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestScenarioLangFactoryImpl extends EFactoryImpl implements TestScenarioLangFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TestScenarioLangFactory init() {
		try {
			TestScenarioLangFactory theTestScenarioLangFactory = (TestScenarioLangFactory)EPackage.Registry.INSTANCE.getEFactory(TestScenarioLangPackage.eNS_URI);
			if (theTestScenarioLangFactory != null) {
				return theTestScenarioLangFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TestScenarioLangFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestScenarioLangFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TestScenarioLangPackage.MSE_STATEMENT: return createMseStatement();
			case TestScenarioLangPackage.OBJECT_VARIABLE: return createObjectVariable();
			case TestScenarioLangPackage.SCENARIO: return createScenario();
			case TestScenarioLangPackage.REWRITING_RULE_CALL_STATEMENT: return createRewritingRuleCallStatement();
			case TestScenarioLangPackage.STATEMENT: return createStatement();
			case TestScenarioLangPackage.IMPORT_JAVA_STATEMENT: return createImportJavaStatement();
			case TestScenarioLangPackage.CONSTANT: return createConstant();
			case TestScenarioLangPackage.INTEGER_LITERAL: return createIntegerLiteral();
			case TestScenarioLangPackage.VARIABLE_REF: return createVariableRef();
			case TestScenarioLangPackage.STRING_LITERAL: return createStringLiteral();
			case TestScenarioLangPackage.EOBJECT_REF: return createEObjectRef();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case TestScenarioLangPackage.LIVE_STATE_KIND:
				return createLiveStateKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case TestScenarioLangPackage.LIVE_STATE_KIND:
				return convertLiveStateKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MseStatement createMseStatement() {
		MseStatementImpl mseStatement = new MseStatementImpl();
		return mseStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectVariable createObjectVariable() {
		ObjectVariableImpl objectVariable = new ObjectVariableImpl();
		return objectVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Scenario createScenario() {
		ScenarioImpl scenario = new ScenarioImpl();
		return scenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RewritingRuleCallStatement createRewritingRuleCallStatement() {
		RewritingRuleCallStatementImpl rewritingRuleCallStatement = new RewritingRuleCallStatementImpl();
		return rewritingRuleCallStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Statement createStatement() {
		StatementImpl statement = new StatementImpl();
		return statement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImportJavaStatement createImportJavaStatement() {
		ImportJavaStatementImpl importJavaStatement = new ImportJavaStatementImpl();
		return importJavaStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Constant createConstant() {
		ConstantImpl constant = new ConstantImpl();
		return constant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntegerLiteral createIntegerLiteral() {
		IntegerLiteralImpl integerLiteral = new IntegerLiteralImpl();
		return integerLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableRef createVariableRef() {
		VariableRefImpl variableRef = new VariableRefImpl();
		return variableRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StringLiteral createStringLiteral() {
		StringLiteralImpl stringLiteral = new StringLiteralImpl();
		return stringLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObjectRef createEObjectRef() {
		EObjectRefImpl eObjectRef = new EObjectRefImpl();
		return eObjectRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiveStateKind createLiveStateKindFromString(EDataType eDataType, String initialValue) {
		LiveStateKind result = LiveStateKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLiveStateKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TestScenarioLangPackage getTestScenarioLangPackage() {
		return (TestScenarioLangPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TestScenarioLangPackage getPackage() {
		return TestScenarioLangPackage.eINSTANCE;
	}

} //TestScenarioLangFactoryImpl
