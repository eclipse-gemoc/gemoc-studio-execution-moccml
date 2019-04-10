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
	 * The feature id for the '<em><b>Saved RT Ds</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_STATE__SAVED_RT_DS = 0;

	/**
	 * The feature id for the '<em><b>Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_STATE__MODEL_ELEMENT = 1;

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
	 * The meta object id for the '<em>Java Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl.K3ModelStatePackageImpl#getJavaObject()
	 * @generated
	 */
	int JAVA_OBJECT = 2;


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
	 * Returns the meta object for the attribute list '{@link org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.ElementState#getSavedRTDs <em>Saved RT Ds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Saved RT Ds</em>'.
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.ElementState#getSavedRTDs()
	 * @see #getElementState()
	 * @generated
	 */
	EAttribute getElementState_SavedRTDs();

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
		 * The meta object literal for the '<em><b>Saved RT Ds</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_STATE__SAVED_RT_DS = eINSTANCE.getElementState_SavedRTDs();

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
