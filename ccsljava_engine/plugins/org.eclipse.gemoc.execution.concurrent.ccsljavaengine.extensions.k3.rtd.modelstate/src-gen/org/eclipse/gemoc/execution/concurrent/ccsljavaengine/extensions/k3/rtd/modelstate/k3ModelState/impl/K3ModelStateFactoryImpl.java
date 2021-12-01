/**
 */
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class K3ModelStateFactoryImpl extends EFactoryImpl implements K3ModelStateFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static K3ModelStateFactory init() {
		try {
			K3ModelStateFactory theK3ModelStateFactory = (K3ModelStateFactory)EPackage.Registry.INSTANCE.getEFactory(K3ModelStatePackage.eNS_URI);
			if (theK3ModelStateFactory != null) {
				return theK3ModelStateFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new K3ModelStateFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public K3ModelStateFactoryImpl() {
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
			case K3ModelStatePackage.K3_MODEL_STATE: return createK3ModelState();
			case K3ModelStatePackage.ELEMENT_STATE: return createElementState();
			case K3ModelStatePackage.K3_STRING_ATTRIBUTE_RTD: return createK3StringAttributeRTD();
			case K3ModelStatePackage.K3_RAW_ATTRIBUTE_RTD: return createK3RawAttributeRTD();
			case K3ModelStatePackage.K3_SINGLE_EMF_REFERENCE_RTD: return createK3SingleEMFReferenceRTD();
			case K3ModelStatePackage.K3_MANY_EMF_REFERENCE_RTD: return createK3ManyEMFReferenceRTD();
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
			case K3ModelStatePackage.JAVA_OBJECT:
				return createJavaObjectFromString(eDataType, initialValue);
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
			case K3ModelStatePackage.JAVA_OBJECT:
				return convertJavaObjectToString(eDataType, instanceValue);
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
	public K3ModelState createK3ModelState() {
		K3ModelStateImpl k3ModelState = new K3ModelStateImpl();
		return k3ModelState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ElementState createElementState() {
		ElementStateImpl elementState = new ElementStateImpl();
		return elementState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public K3StringAttributeRTD createK3StringAttributeRTD() {
		K3StringAttributeRTDImpl k3StringAttributeRTD = new K3StringAttributeRTDImpl();
		return k3StringAttributeRTD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public K3RawAttributeRTD createK3RawAttributeRTD() {
		K3RawAttributeRTDImpl k3RawAttributeRTD = new K3RawAttributeRTDImpl();
		return k3RawAttributeRTD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public K3SingleEMFReferenceRTD createK3SingleEMFReferenceRTD() {
		K3SingleEMFReferenceRTDImpl k3SingleEMFReferenceRTD = new K3SingleEMFReferenceRTDImpl();
		return k3SingleEMFReferenceRTD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public K3ManyEMFReferenceRTD createK3ManyEMFReferenceRTD() {
		K3ManyEMFReferenceRTDImpl k3ManyEMFReferenceRTD = new K3ManyEMFReferenceRTDImpl();
		return k3ManyEMFReferenceRTD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createJavaObjectFromString(EDataType eDataType, String initialValue) {
		return super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJavaObjectToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public K3ModelStatePackage getK3ModelStatePackage() {
		return (K3ModelStatePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static K3ModelStatePackage getPackage() {
		return K3ModelStatePackage.eINSTANCE;
	}

} //K3ModelStateFactoryImpl
