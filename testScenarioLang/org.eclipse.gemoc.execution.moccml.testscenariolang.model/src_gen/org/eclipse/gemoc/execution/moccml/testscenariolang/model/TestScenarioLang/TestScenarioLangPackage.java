/**
 */
package org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.TestScenarioLangFactory
 * @model kind="package"
 * @generated
 */
public interface TestScenarioLangPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "TestScenarioLang";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://gemoc.org/moccml/testscenariolang";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "TestScenarioLang";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TestScenarioLangPackage eINSTANCE = org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.TestScenarioLangPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.StatementImpl <em>Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.StatementImpl
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.TestScenarioLangPackageImpl#getStatement()
	 * @generated
	 */
	int STATEMENT = 4;

	/**
	 * The number of structural features of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.MseStatementImpl <em>Mse Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.MseStatementImpl
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.TestScenarioLangPackageImpl#getMseStatement()
	 * @generated
	 */
	int MSE_STATEMENT = 0;

	/**
	 * The feature id for the '<em><b>Clocks</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSE_STATEMENT__CLOCKS = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fire State</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSE_STATEMENT__FIRE_STATE = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Enable State</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSE_STATEMENT__ENABLE_STATE = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Live State</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSE_STATEMENT__LIVE_STATE = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Mse Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.VariableImpl
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.TestScenarioLangPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.ObjectVariableImpl <em>Object Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.ObjectVariableImpl
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.TestScenarioLangPackageImpl#getObjectVariable()
	 * @generated
	 */
	int OBJECT_VARIABLE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VARIABLE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VARIABLE__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VARIABLE__INITIAL_VALUE = 2;

	/**
	 * The number of structural features of the '<em>Object Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VARIABLE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.ScenarioImpl <em>Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.ScenarioImpl
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.TestScenarioLangPackageImpl#getScenario()
	 * @generated
	 */
	int SCENARIO = 2;

	/**
	 * The feature id for the '<em><b>Model Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__MODEL_IMPORTS = 0;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__VARIABLES = 1;

	/**
	 * The feature id for the '<em><b>Statement Sequence</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__STATEMENT_SEQUENCE = 2;

	/**
	 * The feature id for the '<em><b>Class Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__CLASS_IMPORTS = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__NAME = 4;

	/**
	 * The number of structural features of the '<em>Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.RewritingRuleCallStatementImpl <em>Rewriting Rule Call Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.RewritingRuleCallStatementImpl
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.TestScenarioLangPackageImpl#getRewritingRuleCallStatement()
	 * @generated
	 */
	int REWRITING_RULE_CALL_STATEMENT = 3;

	/**
	 * The feature id for the '<em><b>Object Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REWRITING_RULE_CALL_STATEMENT__OBJECT_VARIABLE = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REWRITING_RULE_CALL_STATEMENT__METHOD = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REWRITING_RULE_CALL_STATEMENT__PARAMETERS = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Rewriting Rule Call Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REWRITING_RULE_CALL_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.ImportJavaStatementImpl <em>Import Java Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.ImportJavaStatementImpl
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.TestScenarioLangPackageImpl#getImportJavaStatement()
	 * @generated
	 */
	int IMPORT_JAVA_STATEMENT = 5;

	/**
	 * The feature id for the '<em><b>Imported Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_JAVA_STATEMENT__IMPORTED_NAMESPACE = 0;

	/**
	 * The number of structural features of the '<em>Import Java Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_JAVA_STATEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.ConstantImpl <em>Constant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.ConstantImpl
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.TestScenarioLangPackageImpl#getConstant()
	 * @generated
	 */
	int CONSTANT = 7;

	/**
	 * The number of structural features of the '<em>Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.IntegerLiteralImpl
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.TestScenarioLangPackageImpl#getIntegerLiteral()
	 * @generated
	 */
	int INTEGER_LITERAL = 8;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL__VALUE = CONSTANT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_FEATURE_COUNT = CONSTANT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.VariableRefImpl <em>Variable Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.VariableRefImpl
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.TestScenarioLangPackageImpl#getVariableRef()
	 * @generated
	 */
	int VARIABLE_REF = 9;

	/**
	 * The feature id for the '<em><b>Var</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REF__VAR = VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REF_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.StringLiteralImpl <em>String Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.StringLiteralImpl
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.TestScenarioLangPackageImpl#getStringLiteral()
	 * @generated
	 */
	int STRING_LITERAL = 10;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL__VALUE = CONSTANT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_FEATURE_COUNT = CONSTANT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.EObjectRefImpl <em>EObject Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.EObjectRefImpl
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.TestScenarioLangPackageImpl#getEObjectRef()
	 * @generated
	 */
	int EOBJECT_REF = 11;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_REF__OBJECT = VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EObject Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_REF_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.LiveStateKind <em>Live State Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.LiveStateKind
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.TestScenarioLangPackageImpl#getLiveStateKind()
	 * @generated
	 */
	int LIVE_STATE_KIND = 12;


	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.MseStatement <em>Mse Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mse Statement</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.MseStatement
	 * @generated
	 */
	EClass getMseStatement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.MseStatement#getClocks <em>Clocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Clocks</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.MseStatement#getClocks()
	 * @see #getMseStatement()
	 * @generated
	 */
	EReference getMseStatement_Clocks();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.MseStatement#getFireState <em>Fire State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Fire State</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.MseStatement#getFireState()
	 * @see #getMseStatement()
	 * @generated
	 */
	EAttribute getMseStatement_FireState();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.MseStatement#getEnableState <em>Enable State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Enable State</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.MseStatement#getEnableState()
	 * @see #getMseStatement()
	 * @generated
	 */
	EAttribute getMseStatement_EnableState();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.MseStatement#getLiveState <em>Live State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Live State</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.MseStatement#getLiveState()
	 * @see #getMseStatement()
	 * @generated
	 */
	EAttribute getMseStatement_LiveState();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.ObjectVariable <em>Object Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Variable</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.ObjectVariable
	 * @generated
	 */
	EClass getObjectVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.ObjectVariable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.ObjectVariable#getName()
	 * @see #getObjectVariable()
	 * @generated
	 */
	EAttribute getObjectVariable_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.ObjectVariable#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.ObjectVariable#getType()
	 * @see #getObjectVariable()
	 * @generated
	 */
	EReference getObjectVariable_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.ObjectVariable#getInitialValue <em>Initial Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Value</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.ObjectVariable#getInitialValue()
	 * @see #getObjectVariable()
	 * @generated
	 */
	EAttribute getObjectVariable_InitialValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.Scenario <em>Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scenario</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.Scenario
	 * @generated
	 */
	EClass getScenario();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.Scenario#getModelImports <em>Model Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Imports</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.Scenario#getModelImports()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_ModelImports();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.Scenario#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.Scenario#getVariables()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_Variables();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.Scenario#getStatementSequence <em>Statement Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statement Sequence</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.Scenario#getStatementSequence()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_StatementSequence();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.Scenario#getClassImports <em>Class Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Class Imports</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.Scenario#getClassImports()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_ClassImports();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.Scenario#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.Scenario#getName()
	 * @see #getScenario()
	 * @generated
	 */
	EAttribute getScenario_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.RewritingRuleCallStatement <em>Rewriting Rule Call Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rewriting Rule Call Statement</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.RewritingRuleCallStatement
	 * @generated
	 */
	EClass getRewritingRuleCallStatement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.RewritingRuleCallStatement#getObjectVariable <em>Object Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object Variable</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.RewritingRuleCallStatement#getObjectVariable()
	 * @see #getRewritingRuleCallStatement()
	 * @generated
	 */
	EReference getRewritingRuleCallStatement_ObjectVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.RewritingRuleCallStatement#getMethod <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Method</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.RewritingRuleCallStatement#getMethod()
	 * @see #getRewritingRuleCallStatement()
	 * @generated
	 */
	EReference getRewritingRuleCallStatement_Method();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.RewritingRuleCallStatement#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.RewritingRuleCallStatement#getParameters()
	 * @see #getRewritingRuleCallStatement()
	 * @generated
	 */
	EReference getRewritingRuleCallStatement_Parameters();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.Statement
	 * @generated
	 */
	EClass getStatement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.ImportJavaStatement <em>Import Java Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import Java Statement</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.ImportJavaStatement
	 * @generated
	 */
	EClass getImportJavaStatement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.ImportJavaStatement#getImportedNamespace <em>Imported Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Imported Namespace</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.ImportJavaStatement#getImportedNamespace()
	 * @see #getImportJavaStatement()
	 * @generated
	 */
	EAttribute getImportJavaStatement_ImportedNamespace();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.Constant <em>Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constant</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.Constant
	 * @generated
	 */
	EClass getConstant();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.IntegerLiteral <em>Integer Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Literal</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.IntegerLiteral
	 * @generated
	 */
	EClass getIntegerLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.IntegerLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.IntegerLiteral#getValue()
	 * @see #getIntegerLiteral()
	 * @generated
	 */
	EAttribute getIntegerLiteral_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.VariableRef <em>Variable Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Ref</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.VariableRef
	 * @generated
	 */
	EClass getVariableRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.VariableRef#getVar <em>Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Var</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.VariableRef#getVar()
	 * @see #getVariableRef()
	 * @generated
	 */
	EReference getVariableRef_Var();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.StringLiteral <em>String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.StringLiteral
	 * @generated
	 */
	EClass getStringLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.StringLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.StringLiteral#getValue()
	 * @see #getStringLiteral()
	 * @generated
	 */
	EAttribute getStringLiteral_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.EObjectRef <em>EObject Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EObject Ref</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.EObjectRef
	 * @generated
	 */
	EClass getEObjectRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.EObjectRef#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.EObjectRef#getObject()
	 * @see #getEObjectRef()
	 * @generated
	 */
	EReference getEObjectRef_Object();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.LiveStateKind <em>Live State Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Live State Kind</em>'.
	 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.LiveStateKind
	 * @generated
	 */
	EEnum getLiveStateKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TestScenarioLangFactory getTestScenarioLangFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.MseStatementImpl <em>Mse Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.MseStatementImpl
		 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.TestScenarioLangPackageImpl#getMseStatement()
		 * @generated
		 */
		EClass MSE_STATEMENT = eINSTANCE.getMseStatement();

		/**
		 * The meta object literal for the '<em><b>Clocks</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MSE_STATEMENT__CLOCKS = eINSTANCE.getMseStatement_Clocks();

		/**
		 * The meta object literal for the '<em><b>Fire State</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MSE_STATEMENT__FIRE_STATE = eINSTANCE.getMseStatement_FireState();

		/**
		 * The meta object literal for the '<em><b>Enable State</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MSE_STATEMENT__ENABLE_STATE = eINSTANCE.getMseStatement_EnableState();

		/**
		 * The meta object literal for the '<em><b>Live State</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MSE_STATEMENT__LIVE_STATE = eINSTANCE.getMseStatement_LiveState();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.ObjectVariableImpl <em>Object Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.ObjectVariableImpl
		 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.TestScenarioLangPackageImpl#getObjectVariable()
		 * @generated
		 */
		EClass OBJECT_VARIABLE = eINSTANCE.getObjectVariable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_VARIABLE__NAME = eINSTANCE.getObjectVariable_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_VARIABLE__TYPE = eINSTANCE.getObjectVariable_Type();

		/**
		 * The meta object literal for the '<em><b>Initial Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_VARIABLE__INITIAL_VALUE = eINSTANCE.getObjectVariable_InitialValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.ScenarioImpl <em>Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.ScenarioImpl
		 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.TestScenarioLangPackageImpl#getScenario()
		 * @generated
		 */
		EClass SCENARIO = eINSTANCE.getScenario();

		/**
		 * The meta object literal for the '<em><b>Model Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__MODEL_IMPORTS = eINSTANCE.getScenario_ModelImports();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__VARIABLES = eINSTANCE.getScenario_Variables();

		/**
		 * The meta object literal for the '<em><b>Statement Sequence</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__STATEMENT_SEQUENCE = eINSTANCE.getScenario_StatementSequence();

		/**
		 * The meta object literal for the '<em><b>Class Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__CLASS_IMPORTS = eINSTANCE.getScenario_ClassImports();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCENARIO__NAME = eINSTANCE.getScenario_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.RewritingRuleCallStatementImpl <em>Rewriting Rule Call Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.RewritingRuleCallStatementImpl
		 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.TestScenarioLangPackageImpl#getRewritingRuleCallStatement()
		 * @generated
		 */
		EClass REWRITING_RULE_CALL_STATEMENT = eINSTANCE.getRewritingRuleCallStatement();

		/**
		 * The meta object literal for the '<em><b>Object Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REWRITING_RULE_CALL_STATEMENT__OBJECT_VARIABLE = eINSTANCE.getRewritingRuleCallStatement_ObjectVariable();

		/**
		 * The meta object literal for the '<em><b>Method</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REWRITING_RULE_CALL_STATEMENT__METHOD = eINSTANCE.getRewritingRuleCallStatement_Method();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REWRITING_RULE_CALL_STATEMENT__PARAMETERS = eINSTANCE.getRewritingRuleCallStatement_Parameters();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.StatementImpl <em>Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.StatementImpl
		 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.TestScenarioLangPackageImpl#getStatement()
		 * @generated
		 */
		EClass STATEMENT = eINSTANCE.getStatement();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.ImportJavaStatementImpl <em>Import Java Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.ImportJavaStatementImpl
		 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.TestScenarioLangPackageImpl#getImportJavaStatement()
		 * @generated
		 */
		EClass IMPORT_JAVA_STATEMENT = eINSTANCE.getImportJavaStatement();

		/**
		 * The meta object literal for the '<em><b>Imported Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT_JAVA_STATEMENT__IMPORTED_NAMESPACE = eINSTANCE.getImportJavaStatement_ImportedNamespace();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.VariableImpl
		 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.TestScenarioLangPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.ConstantImpl <em>Constant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.ConstantImpl
		 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.TestScenarioLangPackageImpl#getConstant()
		 * @generated
		 */
		EClass CONSTANT = eINSTANCE.getConstant();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.IntegerLiteralImpl
		 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.TestScenarioLangPackageImpl#getIntegerLiteral()
		 * @generated
		 */
		EClass INTEGER_LITERAL = eINSTANCE.getIntegerLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_LITERAL__VALUE = eINSTANCE.getIntegerLiteral_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.VariableRefImpl <em>Variable Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.VariableRefImpl
		 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.TestScenarioLangPackageImpl#getVariableRef()
		 * @generated
		 */
		EClass VARIABLE_REF = eINSTANCE.getVariableRef();

		/**
		 * The meta object literal for the '<em><b>Var</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_REF__VAR = eINSTANCE.getVariableRef_Var();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.StringLiteralImpl <em>String Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.StringLiteralImpl
		 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.TestScenarioLangPackageImpl#getStringLiteral()
		 * @generated
		 */
		EClass STRING_LITERAL = eINSTANCE.getStringLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_LITERAL__VALUE = eINSTANCE.getStringLiteral_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.EObjectRefImpl <em>EObject Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.EObjectRefImpl
		 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.TestScenarioLangPackageImpl#getEObjectRef()
		 * @generated
		 */
		EClass EOBJECT_REF = eINSTANCE.getEObjectRef();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EOBJECT_REF__OBJECT = eINSTANCE.getEObjectRef_Object();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.LiveStateKind <em>Live State Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.LiveStateKind
		 * @see org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.impl.TestScenarioLangPackageImpl#getLiveStateKind()
		 * @generated
		 */
		EEnum LIVE_STATE_KIND = eINSTANCE.getLiveStateKind();

	}

} //TestScenarioLangPackage
