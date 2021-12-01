/**
 */
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelStateFactory
 * @model kind="package"
 * @generated
 */
public interface K3ModelStatePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "k3ModelState";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/gemoc/k3/rtd/modelState";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "k3ModelState";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	K3ModelStatePackage eINSTANCE = org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3ModelStatePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3ModelStateImpl <em>K3 Model State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3ModelStateImpl
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3ModelStatePackageImpl#getK3ModelState()
	 * @generated
	 */
	int K3_MODEL_STATE = 0;

	/**
	 * The feature id for the '<em><b>Owned Elementstates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int K3_MODEL_STATE__OWNED_ELEMENTSTATES = 0;

	/**
	 * The number of structural features of the '<em>K3 Model State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int K3_MODEL_STATE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>K3 Model State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int K3_MODEL_STATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.ElementStateImpl <em>Element State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.ElementStateImpl
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3ModelStatePackageImpl#getElementState()
	 * @generated
	 */
	int ELEMENT_STATE = 1;

	/**
	 * The feature id for the '<em><b>Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_STATE__MODEL_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Saved RT Ds</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_STATE__SAVED_RT_DS = 1;

	/**
	 * The number of structural features of the '<em>Element State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_STATE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Element State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_STATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3AttributeRTDImpl <em>K3 Attribute RTD</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3AttributeRTDImpl
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3ModelStatePackageImpl#getK3AttributeRTD()
	 * @generated
	 */
	int K3_ATTRIBUTE_RTD = 2;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int K3_ATTRIBUTE_RTD__ATTRIBUTE_NAME = 0;

	/**
	 * The number of structural features of the '<em>K3 Attribute RTD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int K3_ATTRIBUTE_RTD_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>K3 Attribute RTD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int K3_ATTRIBUTE_RTD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3StringAttributeRTDImpl <em>K3 String Attribute RTD</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3StringAttributeRTDImpl
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3ModelStatePackageImpl#getK3StringAttributeRTD()
	 * @generated
	 */
	int K3_STRING_ATTRIBUTE_RTD = 3;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int K3_STRING_ATTRIBUTE_RTD__ATTRIBUTE_NAME = K3_ATTRIBUTE_RTD__ATTRIBUTE_NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int K3_STRING_ATTRIBUTE_RTD__VALUE = K3_ATTRIBUTE_RTD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>K3 String Attribute RTD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int K3_STRING_ATTRIBUTE_RTD_FEATURE_COUNT = K3_ATTRIBUTE_RTD_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>K3 String Attribute RTD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int K3_STRING_ATTRIBUTE_RTD_OPERATION_COUNT = K3_ATTRIBUTE_RTD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3RawAttributeRTDImpl <em>K3 Raw Attribute RTD</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3RawAttributeRTDImpl
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3ModelStatePackageImpl#getK3RawAttributeRTD()
	 * @generated
	 */
	int K3_RAW_ATTRIBUTE_RTD = 4;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int K3_RAW_ATTRIBUTE_RTD__ATTRIBUTE_NAME = K3_ATTRIBUTE_RTD__ATTRIBUTE_NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int K3_RAW_ATTRIBUTE_RTD__VALUE = K3_ATTRIBUTE_RTD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int K3_RAW_ATTRIBUTE_RTD__CLASS_NAME = K3_ATTRIBUTE_RTD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>K3 Raw Attribute RTD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int K3_RAW_ATTRIBUTE_RTD_FEATURE_COUNT = K3_ATTRIBUTE_RTD_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>K3 Raw Attribute RTD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int K3_RAW_ATTRIBUTE_RTD_OPERATION_COUNT = K3_ATTRIBUTE_RTD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3SingleEMFReferenceRTDImpl <em>K3 Single EMF Reference RTD</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3SingleEMFReferenceRTDImpl
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3ModelStatePackageImpl#getK3SingleEMFReferenceRTD()
	 * @generated
	 */
	int K3_SINGLE_EMF_REFERENCE_RTD = 5;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int K3_SINGLE_EMF_REFERENCE_RTD__ATTRIBUTE_NAME = K3_ATTRIBUTE_RTD__ATTRIBUTE_NAME;

	/**
	 * The feature id for the '<em><b>Reference Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int K3_SINGLE_EMF_REFERENCE_RTD__REFERENCE_VALUE = K3_ATTRIBUTE_RTD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>K3 Single EMF Reference RTD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int K3_SINGLE_EMF_REFERENCE_RTD_FEATURE_COUNT = K3_ATTRIBUTE_RTD_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>K3 Single EMF Reference RTD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int K3_SINGLE_EMF_REFERENCE_RTD_OPERATION_COUNT = K3_ATTRIBUTE_RTD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3ManyEMFReferenceRTDImpl <em>K3 Many EMF Reference RTD</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3ManyEMFReferenceRTDImpl
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3ModelStatePackageImpl#getK3ManyEMFReferenceRTD()
	 * @generated
	 */
	int K3_MANY_EMF_REFERENCE_RTD = 6;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int K3_MANY_EMF_REFERENCE_RTD__ATTRIBUTE_NAME = K3_ATTRIBUTE_RTD__ATTRIBUTE_NAME;

	/**
	 * The feature id for the '<em><b>Reference Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int K3_MANY_EMF_REFERENCE_RTD__REFERENCE_VALUES = K3_ATTRIBUTE_RTD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>K3 Many EMF Reference RTD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int K3_MANY_EMF_REFERENCE_RTD_FEATURE_COUNT = K3_ATTRIBUTE_RTD_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>K3 Many EMF Reference RTD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int K3_MANY_EMF_REFERENCE_RTD_OPERATION_COUNT = K3_ATTRIBUTE_RTD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '<em>Java Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3ModelStatePackageImpl#getJavaObject()
	 * @generated
	 */
	int JAVA_OBJECT = 7;


	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelState <em>K3 Model State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>K3 Model State</em>'.
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelState
	 * @generated
	 */
	EClass getK3ModelState();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelState#getOwnedElementstates <em>Owned Elementstates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Elementstates</em>'.
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelState#getOwnedElementstates()
	 * @see #getK3ModelState()
	 * @generated
	 */
	EReference getK3ModelState_OwnedElementstates();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.ElementState <em>Element State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element State</em>'.
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.ElementState
	 * @generated
	 */
	EClass getElementState();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.ElementState#getSavedRTDs <em>Saved RT Ds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Saved RT Ds</em>'.
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.ElementState#getSavedRTDs()
	 * @see #getElementState()
	 * @generated
	 */
	EReference getElementState_SavedRTDs();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3AttributeRTD <em>K3 Attribute RTD</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>K3 Attribute RTD</em>'.
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3AttributeRTD
	 * @generated
	 */
	EClass getK3AttributeRTD();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3AttributeRTD#getAttributeName <em>Attribute Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute Name</em>'.
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3AttributeRTD#getAttributeName()
	 * @see #getK3AttributeRTD()
	 * @generated
	 */
	EAttribute getK3AttributeRTD_AttributeName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3StringAttributeRTD <em>K3 String Attribute RTD</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>K3 String Attribute RTD</em>'.
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3StringAttributeRTD
	 * @generated
	 */
	EClass getK3StringAttributeRTD();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3StringAttributeRTD#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3StringAttributeRTD#getValue()
	 * @see #getK3StringAttributeRTD()
	 * @generated
	 */
	EAttribute getK3StringAttributeRTD_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3RawAttributeRTD <em>K3 Raw Attribute RTD</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>K3 Raw Attribute RTD</em>'.
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3RawAttributeRTD
	 * @generated
	 */
	EClass getK3RawAttributeRTD();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3RawAttributeRTD#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3RawAttributeRTD#getValue()
	 * @see #getK3RawAttributeRTD()
	 * @generated
	 */
	EAttribute getK3RawAttributeRTD_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3RawAttributeRTD#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3RawAttributeRTD#getClassName()
	 * @see #getK3RawAttributeRTD()
	 * @generated
	 */
	EAttribute getK3RawAttributeRTD_ClassName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3SingleEMFReferenceRTD <em>K3 Single EMF Reference RTD</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>K3 Single EMF Reference RTD</em>'.
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3SingleEMFReferenceRTD
	 * @generated
	 */
	EClass getK3SingleEMFReferenceRTD();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3SingleEMFReferenceRTD#getReferenceValue <em>Reference Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reference Value</em>'.
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3SingleEMFReferenceRTD#getReferenceValue()
	 * @see #getK3SingleEMFReferenceRTD()
	 * @generated
	 */
	EReference getK3SingleEMFReferenceRTD_ReferenceValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ManyEMFReferenceRTD <em>K3 Many EMF Reference RTD</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>K3 Many EMF Reference RTD</em>'.
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ManyEMFReferenceRTD
	 * @generated
	 */
	EClass getK3ManyEMFReferenceRTD();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ManyEMFReferenceRTD#getReferenceValues <em>Reference Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Reference Values</em>'.
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ManyEMFReferenceRTD#getReferenceValues()
	 * @see #getK3ManyEMFReferenceRTD()
	 * @generated
	 */
	EReference getK3ManyEMFReferenceRTD_ReferenceValues();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.ElementState#getModelElement <em>Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model Element</em>'.
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.ElementState#getModelElement()
	 * @see #getElementState()
	 * @generated
	 */
	EReference getElementState_ModelElement();

	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>Java Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Java Object</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getJavaObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	K3ModelStateFactory getK3ModelStateFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3ModelStateImpl <em>K3 Model State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3ModelStateImpl
		 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3ModelStatePackageImpl#getK3ModelState()
		 * @generated
		 */
		EClass K3_MODEL_STATE = eINSTANCE.getK3ModelState();

		/**
		 * The meta object literal for the '<em><b>Owned Elementstates</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference K3_MODEL_STATE__OWNED_ELEMENTSTATES = eINSTANCE.getK3ModelState_OwnedElementstates();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.ElementStateImpl <em>Element State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.ElementStateImpl
		 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3ModelStatePackageImpl#getElementState()
		 * @generated
		 */
		EClass ELEMENT_STATE = eINSTANCE.getElementState();

		/**
		 * The meta object literal for the '<em><b>Saved RT Ds</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_STATE__SAVED_RT_DS = eINSTANCE.getElementState_SavedRTDs();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3AttributeRTDImpl <em>K3 Attribute RTD</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3AttributeRTDImpl
		 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3ModelStatePackageImpl#getK3AttributeRTD()
		 * @generated
		 */
		EClass K3_ATTRIBUTE_RTD = eINSTANCE.getK3AttributeRTD();

		/**
		 * The meta object literal for the '<em><b>Attribute Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute K3_ATTRIBUTE_RTD__ATTRIBUTE_NAME = eINSTANCE.getK3AttributeRTD_AttributeName();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3StringAttributeRTDImpl <em>K3 String Attribute RTD</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3StringAttributeRTDImpl
		 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3ModelStatePackageImpl#getK3StringAttributeRTD()
		 * @generated
		 */
		EClass K3_STRING_ATTRIBUTE_RTD = eINSTANCE.getK3StringAttributeRTD();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute K3_STRING_ATTRIBUTE_RTD__VALUE = eINSTANCE.getK3StringAttributeRTD_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3RawAttributeRTDImpl <em>K3 Raw Attribute RTD</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3RawAttributeRTDImpl
		 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3ModelStatePackageImpl#getK3RawAttributeRTD()
		 * @generated
		 */
		EClass K3_RAW_ATTRIBUTE_RTD = eINSTANCE.getK3RawAttributeRTD();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute K3_RAW_ATTRIBUTE_RTD__VALUE = eINSTANCE.getK3RawAttributeRTD_Value();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute K3_RAW_ATTRIBUTE_RTD__CLASS_NAME = eINSTANCE.getK3RawAttributeRTD_ClassName();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3SingleEMFReferenceRTDImpl <em>K3 Single EMF Reference RTD</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3SingleEMFReferenceRTDImpl
		 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3ModelStatePackageImpl#getK3SingleEMFReferenceRTD()
		 * @generated
		 */
		EClass K3_SINGLE_EMF_REFERENCE_RTD = eINSTANCE.getK3SingleEMFReferenceRTD();

		/**
		 * The meta object literal for the '<em><b>Reference Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference K3_SINGLE_EMF_REFERENCE_RTD__REFERENCE_VALUE = eINSTANCE.getK3SingleEMFReferenceRTD_ReferenceValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3ManyEMFReferenceRTDImpl <em>K3 Many EMF Reference RTD</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3ManyEMFReferenceRTDImpl
		 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3ModelStatePackageImpl#getK3ManyEMFReferenceRTD()
		 * @generated
		 */
		EClass K3_MANY_EMF_REFERENCE_RTD = eINSTANCE.getK3ManyEMFReferenceRTD();

		/**
		 * The meta object literal for the '<em><b>Reference Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference K3_MANY_EMF_REFERENCE_RTD__REFERENCE_VALUES = eINSTANCE.getK3ManyEMFReferenceRTD_ReferenceValues();

		/**
		 * The meta object literal for the '<em><b>Model Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_STATE__MODEL_ELEMENT = eINSTANCE.getElementState_ModelElement();

		/**
		 * The meta object literal for the '<em>Java Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Object
		 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3ModelStatePackageImpl#getJavaObject()
		 * @generated
		 */
		EDataType JAVA_OBJECT = eINSTANCE.getJavaObject();

	}

} //K3ModelStatePackage
