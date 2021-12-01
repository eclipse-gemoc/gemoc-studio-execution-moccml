/**
 */
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.ElementState;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3AttributeRTD;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ManyEMFReferenceRTD;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelState;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelStateFactory;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelStatePackage;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3RawAttributeRTD;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3SingleEMFReferenceRTD;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3StringAttributeRTD;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class K3ModelStatePackageImpl extends EPackageImpl implements K3ModelStatePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass k3ModelStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass k3AttributeRTDEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass k3StringAttributeRTDEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass k3RawAttributeRTDEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass k3SingleEMFReferenceRTDEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass k3ManyEMFReferenceRTDEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType javaObjectEDataType = null;

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
	 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelStatePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private K3ModelStatePackageImpl() {
		super(eNS_URI, K3ModelStateFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link K3ModelStatePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static K3ModelStatePackage init() {
		if (isInited) return (K3ModelStatePackage)EPackage.Registry.INSTANCE.getEPackage(K3ModelStatePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredK3ModelStatePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		K3ModelStatePackageImpl theK3ModelStatePackage = registeredK3ModelStatePackage instanceof K3ModelStatePackageImpl ? (K3ModelStatePackageImpl)registeredK3ModelStatePackage : new K3ModelStatePackageImpl();

		isInited = true;

		// Create package meta-data objects
		theK3ModelStatePackage.createPackageContents();

		// Initialize created meta-data
		theK3ModelStatePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theK3ModelStatePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(K3ModelStatePackage.eNS_URI, theK3ModelStatePackage);
		return theK3ModelStatePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getK3ModelState() {
		return k3ModelStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getK3ModelState_OwnedElementstates() {
		return (EReference)k3ModelStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getElementState() {
		return elementStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getElementState_SavedRTDs() {
		return (EReference)elementStateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getK3AttributeRTD() {
		return k3AttributeRTDEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getK3AttributeRTD_AttributeName() {
		return (EAttribute)k3AttributeRTDEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getK3StringAttributeRTD() {
		return k3StringAttributeRTDEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getK3StringAttributeRTD_Value() {
		return (EAttribute)k3StringAttributeRTDEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getK3RawAttributeRTD() {
		return k3RawAttributeRTDEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getK3RawAttributeRTD_Value() {
		return (EAttribute)k3RawAttributeRTDEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getK3RawAttributeRTD_ClassName() {
		return (EAttribute)k3RawAttributeRTDEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getK3SingleEMFReferenceRTD() {
		return k3SingleEMFReferenceRTDEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getK3SingleEMFReferenceRTD_ReferenceValue() {
		return (EReference)k3SingleEMFReferenceRTDEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getK3ManyEMFReferenceRTD() {
		return k3ManyEMFReferenceRTDEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getK3ManyEMFReferenceRTD_ReferenceValues() {
		return (EReference)k3ManyEMFReferenceRTDEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getElementState_ModelElement() {
		return (EReference)elementStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getJavaObject() {
		return javaObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public K3ModelStateFactory getK3ModelStateFactory() {
		return (K3ModelStateFactory)getEFactoryInstance();
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
		k3ModelStateEClass = createEClass(K3_MODEL_STATE);
		createEReference(k3ModelStateEClass, K3_MODEL_STATE__OWNED_ELEMENTSTATES);

		elementStateEClass = createEClass(ELEMENT_STATE);
		createEReference(elementStateEClass, ELEMENT_STATE__MODEL_ELEMENT);
		createEReference(elementStateEClass, ELEMENT_STATE__SAVED_RT_DS);

		k3AttributeRTDEClass = createEClass(K3_ATTRIBUTE_RTD);
		createEAttribute(k3AttributeRTDEClass, K3_ATTRIBUTE_RTD__ATTRIBUTE_NAME);

		k3StringAttributeRTDEClass = createEClass(K3_STRING_ATTRIBUTE_RTD);
		createEAttribute(k3StringAttributeRTDEClass, K3_STRING_ATTRIBUTE_RTD__VALUE);

		k3RawAttributeRTDEClass = createEClass(K3_RAW_ATTRIBUTE_RTD);
		createEAttribute(k3RawAttributeRTDEClass, K3_RAW_ATTRIBUTE_RTD__VALUE);
		createEAttribute(k3RawAttributeRTDEClass, K3_RAW_ATTRIBUTE_RTD__CLASS_NAME);

		k3SingleEMFReferenceRTDEClass = createEClass(K3_SINGLE_EMF_REFERENCE_RTD);
		createEReference(k3SingleEMFReferenceRTDEClass, K3_SINGLE_EMF_REFERENCE_RTD__REFERENCE_VALUE);

		k3ManyEMFReferenceRTDEClass = createEClass(K3_MANY_EMF_REFERENCE_RTD);
		createEReference(k3ManyEMFReferenceRTDEClass, K3_MANY_EMF_REFERENCE_RTD__REFERENCE_VALUES);

		// Create data types
		javaObjectEDataType = createEDataType(JAVA_OBJECT);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		k3StringAttributeRTDEClass.getESuperTypes().add(this.getK3AttributeRTD());
		k3RawAttributeRTDEClass.getESuperTypes().add(this.getK3AttributeRTD());
		k3SingleEMFReferenceRTDEClass.getESuperTypes().add(this.getK3AttributeRTD());
		k3ManyEMFReferenceRTDEClass.getESuperTypes().add(this.getK3AttributeRTD());

		// Initialize classes, features, and operations; add parameters
		initEClass(k3ModelStateEClass, K3ModelState.class, "K3ModelState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getK3ModelState_OwnedElementstates(), this.getElementState(), null, "ownedElementstates", null, 0, -1, K3ModelState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementStateEClass, ElementState.class, "ElementState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getElementState_ModelElement(), ecorePackage.getEObject(), null, "modelElement", null, 0, 1, ElementState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElementState_SavedRTDs(), this.getK3AttributeRTD(), null, "savedRTDs", null, 0, -1, ElementState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(k3AttributeRTDEClass, K3AttributeRTD.class, "K3AttributeRTD", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getK3AttributeRTD_AttributeName(), ecorePackage.getEString(), "attributeName", null, 1, 1, K3AttributeRTD.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(k3StringAttributeRTDEClass, K3StringAttributeRTD.class, "K3StringAttributeRTD", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getK3StringAttributeRTD_Value(), ecorePackage.getEString(), "value", null, 0, 1, K3StringAttributeRTD.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(k3RawAttributeRTDEClass, K3RawAttributeRTD.class, "K3RawAttributeRTD", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getK3RawAttributeRTD_Value(), ecorePackage.getEString(), "value", null, 0, 1, K3RawAttributeRTD.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getK3RawAttributeRTD_ClassName(), ecorePackage.getEString(), "className", null, 0, 1, K3RawAttributeRTD.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(k3SingleEMFReferenceRTDEClass, K3SingleEMFReferenceRTD.class, "K3SingleEMFReferenceRTD", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getK3SingleEMFReferenceRTD_ReferenceValue(), ecorePackage.getEObject(), null, "referenceValue", null, 0, 1, K3SingleEMFReferenceRTD.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(k3ManyEMFReferenceRTDEClass, K3ManyEMFReferenceRTD.class, "K3ManyEMFReferenceRTD", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getK3ManyEMFReferenceRTD_ReferenceValues(), ecorePackage.getEObject(), null, "referenceValues", null, 0, -1, K3ManyEMFReferenceRTD.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(javaObjectEDataType, Object.class, "JavaObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //K3ModelStatePackageImpl
