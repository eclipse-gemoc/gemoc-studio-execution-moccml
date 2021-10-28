/**
 */
package org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.TimeModelPackage;

import fr.inria.aoste.trace.TracePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.Constant;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.EObjectRef;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.ImportJavaStatement;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.IntegerLiteral;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.LiveStateKind;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.MseStatement;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.ObjectVariable;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.RewritingRuleCallStatement;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.Scenario;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.Statement;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.StringLiteral;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.TestScenarioLangFactory;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.TestScenarioLangPackage;

import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.Variable;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.VariableRef;
import org.eclipse.xtext.common.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestScenarioLangPackageImpl extends EPackageImpl implements TestScenarioLangPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mseStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scenarioEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rewritingRuleCallStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass importJavaStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eObjectRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum liveStateKindEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.TestScenarioLangPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TestScenarioLangPackageImpl() {
		super(eNS_URI, TestScenarioLangFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link TestScenarioLangPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TestScenarioLangPackage init() {
		if (isInited) return (TestScenarioLangPackage)EPackage.Registry.INSTANCE.getEPackage(TestScenarioLangPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredTestScenarioLangPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		TestScenarioLangPackageImpl theTestScenarioLangPackage = registeredTestScenarioLangPackage instanceof TestScenarioLangPackageImpl ? (TestScenarioLangPackageImpl)registeredTestScenarioLangPackage : new TestScenarioLangPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		TimeModelPackage.eINSTANCE.eClass();
		TracePackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theTestScenarioLangPackage.createPackageContents();

		// Initialize created meta-data
		theTestScenarioLangPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTestScenarioLangPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TestScenarioLangPackage.eNS_URI, theTestScenarioLangPackage);
		return theTestScenarioLangPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMseStatement() {
		return mseStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMseStatement_Clocks() {
		return (EReference)mseStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMseStatement_FireState() {
		return (EAttribute)mseStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMseStatement_EnableState() {
		return (EAttribute)mseStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMseStatement_LiveState() {
		return (EAttribute)mseStatementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getObjectVariable() {
		return objectVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getObjectVariable_Name() {
		return (EAttribute)objectVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getObjectVariable_Type() {
		return (EReference)objectVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getObjectVariable_InitialValue() {
		return (EAttribute)objectVariableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getScenario() {
		return scenarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScenario_ModelImports() {
		return (EReference)scenarioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScenario_Variables() {
		return (EReference)scenarioEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScenario_StatementSequence() {
		return (EReference)scenarioEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScenario_ClassImports() {
		return (EReference)scenarioEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getScenario_Name() {
		return (EAttribute)scenarioEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRewritingRuleCallStatement() {
		return rewritingRuleCallStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRewritingRuleCallStatement_ObjectVariable() {
		return (EReference)rewritingRuleCallStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRewritingRuleCallStatement_Method() {
		return (EReference)rewritingRuleCallStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRewritingRuleCallStatement_Parameters() {
		return (EReference)rewritingRuleCallStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStatement() {
		return statementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImportJavaStatement() {
		return importJavaStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImportJavaStatement_ImportedNamespace() {
		return (EAttribute)importJavaStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVariable() {
		return variableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConstant() {
		return constantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIntegerLiteral() {
		return integerLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntegerLiteral_Value() {
		return (EAttribute)integerLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVariableRef() {
		return variableRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableRef_Var() {
		return (EReference)variableRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStringLiteral() {
		return stringLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStringLiteral_Value() {
		return (EAttribute)stringLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEObjectRef() {
		return eObjectRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEObjectRef_Object() {
		return (EReference)eObjectRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getLiveStateKind() {
		return liveStateKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TestScenarioLangFactory getTestScenarioLangFactory() {
		return (TestScenarioLangFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		mseStatementEClass = createEClass(MSE_STATEMENT);
		createEReference(mseStatementEClass, MSE_STATEMENT__CLOCKS);
		createEAttribute(mseStatementEClass, MSE_STATEMENT__FIRE_STATE);
		createEAttribute(mseStatementEClass, MSE_STATEMENT__ENABLE_STATE);
		createEAttribute(mseStatementEClass, MSE_STATEMENT__LIVE_STATE);

		objectVariableEClass = createEClass(OBJECT_VARIABLE);
		createEAttribute(objectVariableEClass, OBJECT_VARIABLE__NAME);
		createEReference(objectVariableEClass, OBJECT_VARIABLE__TYPE);
		createEAttribute(objectVariableEClass, OBJECT_VARIABLE__INITIAL_VALUE);

		scenarioEClass = createEClass(SCENARIO);
		createEReference(scenarioEClass, SCENARIO__MODEL_IMPORTS);
		createEReference(scenarioEClass, SCENARIO__VARIABLES);
		createEReference(scenarioEClass, SCENARIO__STATEMENT_SEQUENCE);
		createEReference(scenarioEClass, SCENARIO__CLASS_IMPORTS);
		createEAttribute(scenarioEClass, SCENARIO__NAME);

		rewritingRuleCallStatementEClass = createEClass(REWRITING_RULE_CALL_STATEMENT);
		createEReference(rewritingRuleCallStatementEClass, REWRITING_RULE_CALL_STATEMENT__OBJECT_VARIABLE);
		createEReference(rewritingRuleCallStatementEClass, REWRITING_RULE_CALL_STATEMENT__METHOD);
		createEReference(rewritingRuleCallStatementEClass, REWRITING_RULE_CALL_STATEMENT__PARAMETERS);

		statementEClass = createEClass(STATEMENT);

		importJavaStatementEClass = createEClass(IMPORT_JAVA_STATEMENT);
		createEAttribute(importJavaStatementEClass, IMPORT_JAVA_STATEMENT__IMPORTED_NAMESPACE);

		variableEClass = createEClass(VARIABLE);

		constantEClass = createEClass(CONSTANT);

		integerLiteralEClass = createEClass(INTEGER_LITERAL);
		createEAttribute(integerLiteralEClass, INTEGER_LITERAL__VALUE);

		variableRefEClass = createEClass(VARIABLE_REF);
		createEReference(variableRefEClass, VARIABLE_REF__VAR);

		stringLiteralEClass = createEClass(STRING_LITERAL);
		createEAttribute(stringLiteralEClass, STRING_LITERAL__VALUE);

		eObjectRefEClass = createEClass(EOBJECT_REF);
		createEReference(eObjectRefEClass, EOBJECT_REF__OBJECT);

		// Create enums
		liveStateKindEEnum = createEEnum(LIVE_STATE_KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		TimeModelPackage theTimeModelPackage = (TimeModelPackage)EPackage.Registry.INSTANCE.getEPackage(TimeModelPackage.eNS_URI);
		TracePackage theTracePackage = (TracePackage)EPackage.Registry.INSTANCE.getEPackage(TracePackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		mseStatementEClass.getESuperTypes().add(this.getStatement());
		rewritingRuleCallStatementEClass.getESuperTypes().add(this.getStatement());
		constantEClass.getESuperTypes().add(this.getVariable());
		integerLiteralEClass.getESuperTypes().add(this.getConstant());
		variableRefEClass.getESuperTypes().add(this.getVariable());
		stringLiteralEClass.getESuperTypes().add(this.getConstant());
		eObjectRefEClass.getESuperTypes().add(this.getVariable());

		// Initialize classes and features; add operations and parameters
		initEClass(mseStatementEClass, MseStatement.class, "MseStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMseStatement_Clocks(), theTimeModelPackage.getClock(), null, "clocks", null, 1, -1, MseStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMseStatement_FireState(), theTracePackage.getFiredStateKind(), "fireState", null, 0, -1, MseStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMseStatement_EnableState(), theTracePackage.getEnableStateKind(), "enableState", null, 0, -1, MseStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMseStatement_LiveState(), this.getLiveStateKind(), "liveState", null, 0, -1, MseStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectVariableEClass, ObjectVariable.class, "ObjectVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getObjectVariable_Name(), ecorePackage.getEString(), "name", null, 1, 1, ObjectVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getObjectVariable_Type(), theTypesPackage.getJvmTypeReference(), null, "type", null, 1, 1, ObjectVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getObjectVariable_InitialValue(), ecorePackage.getEInt(), "initialValue", null, 0, 1, ObjectVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scenarioEClass, Scenario.class, "Scenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScenario_ModelImports(), theTimeModelPackage.getImportStatement(), null, "modelImports", null, 0, -1, Scenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScenario_Variables(), this.getObjectVariable(), null, "variables", null, 0, -1, Scenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScenario_StatementSequence(), this.getStatement(), null, "statementSequence", null, 0, -1, Scenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScenario_ClassImports(), this.getImportJavaStatement(), null, "classImports", null, 0, -1, Scenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScenario_Name(), ecorePackage.getEString(), "name", null, 0, 1, Scenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rewritingRuleCallStatementEClass, RewritingRuleCallStatement.class, "RewritingRuleCallStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRewritingRuleCallStatement_ObjectVariable(), this.getObjectVariable(), null, "objectVariable", null, 1, 1, RewritingRuleCallStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRewritingRuleCallStatement_Method(), theTypesPackage.getJvmOperation(), null, "method", null, 1, 1, RewritingRuleCallStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRewritingRuleCallStatement_Parameters(), this.getVariable(), null, "parameters", null, 0, -1, RewritingRuleCallStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statementEClass, Statement.class, "Statement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(importJavaStatementEClass, ImportJavaStatement.class, "ImportJavaStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImportJavaStatement_ImportedNamespace(), ecorePackage.getEString(), "importedNamespace", null, 1, 1, ImportJavaStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableEClass, Variable.class, "Variable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(constantEClass, Constant.class, "Constant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(integerLiteralEClass, IntegerLiteral.class, "IntegerLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegerLiteral_Value(), ecorePackage.getEInt(), "value", null, 0, 1, IntegerLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableRefEClass, VariableRef.class, "VariableRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableRef_Var(), this.getObjectVariable(), null, "var", null, 1, 1, VariableRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringLiteralEClass, StringLiteral.class, "StringLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringLiteral_Value(), ecorePackage.getEString(), "value", null, 0, 1, StringLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eObjectRefEClass, EObjectRef.class, "EObjectRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEObjectRef_Object(), ecorePackage.getEObject(), null, "object", null, 1, 1, EObjectRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(liveStateKindEEnum, LiveStateKind.class, "LiveStateKind");
		addEEnumLiteral(liveStateKindEEnum, LiveStateKind.IS_ALIVE);
		addEEnumLiteral(liveStateKindEEnum, LiveStateKind.IS_DEAD);

		// Create resource
		createResource(eNS_URI);
	}

} //TestScenarioLangPackageImpl
