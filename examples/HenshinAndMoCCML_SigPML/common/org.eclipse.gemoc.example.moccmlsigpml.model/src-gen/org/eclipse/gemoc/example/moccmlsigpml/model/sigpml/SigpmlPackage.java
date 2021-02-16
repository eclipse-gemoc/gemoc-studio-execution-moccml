/**
 */
package org.eclipse.gemoc.example.moccmlsigpml.model.sigpml;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
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
 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.SigpmlFactory
 * @model kind="package"
 * @generated
 */
public interface SigpmlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sigpml";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.eclipse.gemoc.example.moccmlsigpml.model/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sigpml";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SigpmlPackage eINSTANCE = org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.NamedElementImpl
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.ApplicationImpl <em>Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.ApplicationImpl
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getApplication()
	 * @generated
	 */
	int APPLICATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Agents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__OWNED_AGENTS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Places</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__OWNED_PLACES = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.AgentImpl <em>Agent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.AgentImpl
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getAgent()
	 * @generated
	 */
	int AGENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__OWNED_PORTS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cycles</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__CYCLES = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__OWNER = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__CODE = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Allocated To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__ALLOCATED_TO = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__STATE = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Current Cycle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__CURRENT_CYCLE = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Agent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The operation id for the '<em>Execute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT___EXECUTE = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Stop</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT___STOP = NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Executing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT___IS_EXECUTING = NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Agent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.PortImpl
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__OWNER = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__RATE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Has Been Processed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__HAS_BEEN_PROCESSED = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.InputPortImpl <em>Input Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.InputPortImpl
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getInputPort()
	 * @generated
	 */
	int INPUT_PORT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT__NAME = PORT__NAME;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT__OWNER = PORT__OWNER;

	/**
	 * The feature id for the '<em><b>Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT__RATE = PORT__RATE;

	/**
	 * The feature id for the '<em><b>Has Been Processed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT__HAS_BEEN_PROCESSED = PORT__HAS_BEEN_PROCESSED;

	/**
	 * The number of structural features of the '<em>Input Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Read</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT___READ = PORT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Input Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT_OPERATION_COUNT = PORT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.OutputPortImpl <em>Output Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.OutputPortImpl
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getOutputPort()
	 * @generated
	 */
	int OUTPUT_PORT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT__NAME = PORT__NAME;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT__OWNER = PORT__OWNER;

	/**
	 * The feature id for the '<em><b>Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT__RATE = PORT__RATE;

	/**
	 * The feature id for the '<em><b>Has Been Processed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT__HAS_BEEN_PROCESSED = PORT__HAS_BEEN_PROCESSED;

	/**
	 * The number of structural features of the '<em>Output Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Write</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT___WRITE = PORT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Output Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT_OPERATION_COUNT = PORT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.PlaceImpl <em>Place</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.PlaceImpl
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getPlace()
	 * @generated
	 */
	int PLACE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Its Output Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__ITS_OUTPUT_PORT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Its Input Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__ITS_INPUT_PORT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__SIZE = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__OWNER = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__DELAY = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Current Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__CURRENT_SIZE = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Is Initialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__IS_INITIALIZED = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Place</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The operation id for the '<em>Push</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE___PUSH = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Pop</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE___POP = NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Place</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.HWRessourceImpl <em>HW Ressource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.HWRessourceImpl
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getHWRessource()
	 * @generated
	 */
	int HW_RESSOURCE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_RESSOURCE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_RESSOURCE__OWNER = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Connected To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_RESSOURCE__CONNECTED_TO = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>HW Ressource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_RESSOURCE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>HW Ressource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_RESSOURCE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.HWComputationalResourceImpl <em>HW Computational Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.HWComputationalResourceImpl
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getHWComputationalResource()
	 * @generated
	 */
	int HW_COMPUTATIONAL_RESOURCE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COMPUTATIONAL_RESOURCE__NAME = HW_RESSOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COMPUTATIONAL_RESOURCE__OWNER = HW_RESSOURCE__OWNER;

	/**
	 * The feature id for the '<em><b>Connected To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COMPUTATIONAL_RESOURCE__CONNECTED_TO = HW_RESSOURCE__CONNECTED_TO;

	/**
	 * The feature id for the '<em><b>Is Under Preemptive Management</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COMPUTATIONAL_RESOURCE__IS_UNDER_PREEMPTIVE_MANAGEMENT = HW_RESSOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Allocated Agents</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COMPUTATIONAL_RESOURCE__ALLOCATED_AGENTS = HW_RESSOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>HW Computational Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COMPUTATIONAL_RESOURCE_FEATURE_COUNT = HW_RESSOURCE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Inc Cycle</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COMPUTATIONAL_RESOURCE___INC_CYCLE = HW_RESSOURCE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>HW Computational Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COMPUTATIONAL_RESOURCE_OPERATION_COUNT = HW_RESSOURCE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.HWStorageResourceImpl <em>HW Storage Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.HWStorageResourceImpl
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getHWStorageResource()
	 * @generated
	 */
	int HW_STORAGE_RESOURCE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_STORAGE_RESOURCE__NAME = HW_RESSOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_STORAGE_RESOURCE__OWNER = HW_RESSOURCE__OWNER;

	/**
	 * The feature id for the '<em><b>Connected To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_STORAGE_RESOURCE__CONNECTED_TO = HW_RESSOURCE__CONNECTED_TO;

	/**
	 * The feature id for the '<em><b>Allocated Places</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_STORAGE_RESOURCE__ALLOCATED_PLACES = HW_RESSOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>HW Storage Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_STORAGE_RESOURCE_FEATURE_COUNT = HW_RESSOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>HW Storage Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_STORAGE_RESOURCE_OPERATION_COUNT = HW_RESSOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.HWCommunicationResourceImpl <em>HW Communication Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.HWCommunicationResourceImpl
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getHWCommunicationResource()
	 * @generated
	 */
	int HW_COMMUNICATION_RESOURCE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COMMUNICATION_RESOURCE__NAME = HW_RESSOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COMMUNICATION_RESOURCE__OWNER = HW_RESSOURCE__OWNER;

	/**
	 * The feature id for the '<em><b>Connected To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COMMUNICATION_RESOURCE__CONNECTED_TO = HW_RESSOURCE__CONNECTED_TO;

	/**
	 * The number of structural features of the '<em>HW Communication Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COMMUNICATION_RESOURCE_FEATURE_COUNT = HW_RESSOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>HW Communication Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COMMUNICATION_RESOURCE_OPERATION_COUNT = HW_RESSOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.HWPlatformImpl <em>HW Platform</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.HWPlatformImpl
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getHWPlatform()
	 * @generated
	 */
	int HW_PLATFORM = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_PLATFORM__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned HW Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_PLATFORM__OWNED_HW_RESOURCES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>HW Platform</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_PLATFORM_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>HW Platform</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_PLATFORM_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SystemImpl
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getSystem()
	 * @generated
	 */
	int SYSTEM = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Application</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__OWNED_APPLICATION = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned HW Platform</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__OWNED_HW_PLATFORM = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.AgentState <em>Agent State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.AgentState
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getAgentState()
	 * @generated
	 */
	int AGENT_STATE = 13;

	/**
	 * The meta object id for the '<em>Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getObject()
	 * @generated
	 */
	int OBJECT = 14;


	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Application <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Application
	 * @generated
	 */
	EClass getApplication();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Application#getOwnedAgents <em>Owned Agents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Agents</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Application#getOwnedAgents()
	 * @see #getApplication()
	 * @generated
	 */
	EReference getApplication_OwnedAgents();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Application#getOwnedPlaces <em>Owned Places</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Places</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Application#getOwnedPlaces()
	 * @see #getApplication()
	 * @generated
	 */
	EReference getApplication_OwnedPlaces();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent <em>Agent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Agent</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent
	 * @generated
	 */
	EClass getAgent();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent#getOwnedPorts <em>Owned Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Ports</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent#getOwnedPorts()
	 * @see #getAgent()
	 * @generated
	 */
	EReference getAgent_OwnedPorts();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent#getCycles <em>Cycles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cycles</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent#getCycles()
	 * @see #getAgent()
	 * @generated
	 */
	EAttribute getAgent_Cycles();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent#getOwner()
	 * @see #getAgent()
	 * @generated
	 */
	EReference getAgent_Owner();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent#getCode()
	 * @see #getAgent()
	 * @generated
	 */
	EAttribute getAgent_Code();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent#getAllocatedTo <em>Allocated To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Allocated To</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent#getAllocatedTo()
	 * @see #getAgent()
	 * @generated
	 */
	EReference getAgent_AllocatedTo();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent#getState()
	 * @see #getAgent()
	 * @generated
	 */
	EAttribute getAgent_State();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent#getCurrentCycle <em>Current Cycle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Cycle</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent#getCurrentCycle()
	 * @see #getAgent()
	 * @generated
	 */
	EAttribute getAgent_CurrentCycle();

	/**
	 * Returns the meta object for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent#execute() <em>Execute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Execute</em>' operation.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent#execute()
	 * @generated
	 */
	EOperation getAgent__Execute();

	/**
	 * Returns the meta object for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent#stop() <em>Stop</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Stop</em>' operation.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent#stop()
	 * @generated
	 */
	EOperation getAgent__Stop();

	/**
	 * Returns the meta object for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent#isExecuting() <em>Is Executing</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Executing</em>' operation.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent#isExecuting()
	 * @generated
	 */
	EOperation getAgent__IsExecuting();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Port#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Port#getOwner()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Owner();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Port#getRate <em>Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rate</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Port#getRate()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Rate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Port#isHasBeenProcessed <em>Has Been Processed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Been Processed</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Port#isHasBeenProcessed()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_HasBeenProcessed();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.InputPort <em>Input Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Port</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.InputPort
	 * @generated
	 */
	EClass getInputPort();

	/**
	 * Returns the meta object for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.InputPort#read() <em>Read</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Read</em>' operation.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.InputPort#read()
	 * @generated
	 */
	EOperation getInputPort__Read();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.OutputPort <em>Output Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Port</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.OutputPort
	 * @generated
	 */
	EClass getOutputPort();

	/**
	 * Returns the meta object for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.OutputPort#write() <em>Write</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Write</em>' operation.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.OutputPort#write()
	 * @generated
	 */
	EOperation getOutputPort__Write();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place <em>Place</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Place</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place
	 * @generated
	 */
	EClass getPlace();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#getItsOutputPort <em>Its Output Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Its Output Port</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#getItsOutputPort()
	 * @see #getPlace()
	 * @generated
	 */
	EReference getPlace_ItsOutputPort();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#getItsInputPort <em>Its Input Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Its Input Port</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#getItsInputPort()
	 * @see #getPlace()
	 * @generated
	 */
	EReference getPlace_ItsInputPort();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#getSize()
	 * @see #getPlace()
	 * @generated
	 */
	EAttribute getPlace_Size();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#getOwner()
	 * @see #getPlace()
	 * @generated
	 */
	EReference getPlace_Owner();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#getDelay <em>Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delay</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#getDelay()
	 * @see #getPlace()
	 * @generated
	 */
	EAttribute getPlace_Delay();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#getCurrentSize <em>Current Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Size</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#getCurrentSize()
	 * @see #getPlace()
	 * @generated
	 */
	EAttribute getPlace_CurrentSize();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#isIsInitialized <em>Is Initialized</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Initialized</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#isIsInitialized()
	 * @see #getPlace()
	 * @generated
	 */
	EAttribute getPlace_IsInitialized();

	/**
	 * Returns the meta object for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#push() <em>Push</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Push</em>' operation.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#push()
	 * @generated
	 */
	EOperation getPlace__Push();

	/**
	 * Returns the meta object for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#pop() <em>Pop</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Pop</em>' operation.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#pop()
	 * @generated
	 */
	EOperation getPlace__Pop();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWRessource <em>HW Ressource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HW Ressource</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWRessource
	 * @generated
	 */
	EClass getHWRessource();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWRessource#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWRessource#getOwner()
	 * @see #getHWRessource()
	 * @generated
	 */
	EReference getHWRessource_Owner();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWRessource#getConnectedTo <em>Connected To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Connected To</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWRessource#getConnectedTo()
	 * @see #getHWRessource()
	 * @generated
	 */
	EReference getHWRessource_ConnectedTo();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWComputationalResource <em>HW Computational Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HW Computational Resource</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWComputationalResource
	 * @generated
	 */
	EClass getHWComputationalResource();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWComputationalResource#isIsUnderPreemptiveManagement <em>Is Under Preemptive Management</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Under Preemptive Management</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWComputationalResource#isIsUnderPreemptiveManagement()
	 * @see #getHWComputationalResource()
	 * @generated
	 */
	EAttribute getHWComputationalResource_IsUnderPreemptiveManagement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWComputationalResource#getAllocatedAgents <em>Allocated Agents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Allocated Agents</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWComputationalResource#getAllocatedAgents()
	 * @see #getHWComputationalResource()
	 * @generated
	 */
	EReference getHWComputationalResource_AllocatedAgents();

	/**
	 * Returns the meta object for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWComputationalResource#incCycle() <em>Inc Cycle</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Inc Cycle</em>' operation.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWComputationalResource#incCycle()
	 * @generated
	 */
	EOperation getHWComputationalResource__IncCycle();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWStorageResource <em>HW Storage Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HW Storage Resource</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWStorageResource
	 * @generated
	 */
	EClass getHWStorageResource();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWStorageResource#getAllocatedPlaces <em>Allocated Places</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Allocated Places</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWStorageResource#getAllocatedPlaces()
	 * @see #getHWStorageResource()
	 * @generated
	 */
	EReference getHWStorageResource_AllocatedPlaces();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWCommunicationResource <em>HW Communication Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HW Communication Resource</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWCommunicationResource
	 * @generated
	 */
	EClass getHWCommunicationResource();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWPlatform <em>HW Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HW Platform</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWPlatform
	 * @generated
	 */
	EClass getHWPlatform();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWPlatform#getOwnedHWResources <em>Owned HW Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned HW Resources</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWPlatform#getOwnedHWResources()
	 * @see #getHWPlatform()
	 * @generated
	 */
	EReference getHWPlatform_OwnedHWResources();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.System
	 * @generated
	 */
	EClass getSystem();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.System#getOwnedApplication <em>Owned Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Application</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.System#getOwnedApplication()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_OwnedApplication();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.System#getOwnedHWPlatform <em>Owned HW Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned HW Platform</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.System#getOwnedHWPlatform()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_OwnedHWPlatform();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.AgentState <em>Agent State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Agent State</em>'.
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.AgentState
	 * @generated
	 */
	EEnum getAgentState();

	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Object</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SigpmlFactory getSigpmlFactory();

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
		 * The meta object literal for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.ApplicationImpl <em>Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.ApplicationImpl
		 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getApplication()
		 * @generated
		 */
		EClass APPLICATION = eINSTANCE.getApplication();

		/**
		 * The meta object literal for the '<em><b>Owned Agents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION__OWNED_AGENTS = eINSTANCE.getApplication_OwnedAgents();

		/**
		 * The meta object literal for the '<em><b>Owned Places</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION__OWNED_PLACES = eINSTANCE.getApplication_OwnedPlaces();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.AgentImpl <em>Agent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.AgentImpl
		 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getAgent()
		 * @generated
		 */
		EClass AGENT = eINSTANCE.getAgent();

		/**
		 * The meta object literal for the '<em><b>Owned Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGENT__OWNED_PORTS = eINSTANCE.getAgent_OwnedPorts();

		/**
		 * The meta object literal for the '<em><b>Cycles</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT__CYCLES = eINSTANCE.getAgent_Cycles();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGENT__OWNER = eINSTANCE.getAgent_Owner();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT__CODE = eINSTANCE.getAgent_Code();

		/**
		 * The meta object literal for the '<em><b>Allocated To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGENT__ALLOCATED_TO = eINSTANCE.getAgent_AllocatedTo();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT__STATE = eINSTANCE.getAgent_State();

		/**
		 * The meta object literal for the '<em><b>Current Cycle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT__CURRENT_CYCLE = eINSTANCE.getAgent_CurrentCycle();

		/**
		 * The meta object literal for the '<em><b>Execute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation AGENT___EXECUTE = eINSTANCE.getAgent__Execute();

		/**
		 * The meta object literal for the '<em><b>Stop</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation AGENT___STOP = eINSTANCE.getAgent__Stop();

		/**
		 * The meta object literal for the '<em><b>Is Executing</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation AGENT___IS_EXECUTING = eINSTANCE.getAgent__IsExecuting();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.PortImpl
		 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__OWNER = eINSTANCE.getPort_Owner();

		/**
		 * The meta object literal for the '<em><b>Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__RATE = eINSTANCE.getPort_Rate();

		/**
		 * The meta object literal for the '<em><b>Has Been Processed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__HAS_BEEN_PROCESSED = eINSTANCE.getPort_HasBeenProcessed();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.InputPortImpl <em>Input Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.InputPortImpl
		 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getInputPort()
		 * @generated
		 */
		EClass INPUT_PORT = eINSTANCE.getInputPort();

		/**
		 * The meta object literal for the '<em><b>Read</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INPUT_PORT___READ = eINSTANCE.getInputPort__Read();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.OutputPortImpl <em>Output Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.OutputPortImpl
		 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getOutputPort()
		 * @generated
		 */
		EClass OUTPUT_PORT = eINSTANCE.getOutputPort();

		/**
		 * The meta object literal for the '<em><b>Write</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OUTPUT_PORT___WRITE = eINSTANCE.getOutputPort__Write();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.PlaceImpl <em>Place</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.PlaceImpl
		 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getPlace()
		 * @generated
		 */
		EClass PLACE = eINSTANCE.getPlace();

		/**
		 * The meta object literal for the '<em><b>Its Output Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLACE__ITS_OUTPUT_PORT = eINSTANCE.getPlace_ItsOutputPort();

		/**
		 * The meta object literal for the '<em><b>Its Input Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLACE__ITS_INPUT_PORT = eINSTANCE.getPlace_ItsInputPort();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLACE__SIZE = eINSTANCE.getPlace_Size();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLACE__OWNER = eINSTANCE.getPlace_Owner();

		/**
		 * The meta object literal for the '<em><b>Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLACE__DELAY = eINSTANCE.getPlace_Delay();

		/**
		 * The meta object literal for the '<em><b>Current Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLACE__CURRENT_SIZE = eINSTANCE.getPlace_CurrentSize();

		/**
		 * The meta object literal for the '<em><b>Is Initialized</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLACE__IS_INITIALIZED = eINSTANCE.getPlace_IsInitialized();

		/**
		 * The meta object literal for the '<em><b>Push</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PLACE___PUSH = eINSTANCE.getPlace__Push();

		/**
		 * The meta object literal for the '<em><b>Pop</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PLACE___POP = eINSTANCE.getPlace__Pop();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.NamedElementImpl
		 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.HWRessourceImpl <em>HW Ressource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.HWRessourceImpl
		 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getHWRessource()
		 * @generated
		 */
		EClass HW_RESSOURCE = eINSTANCE.getHWRessource();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HW_RESSOURCE__OWNER = eINSTANCE.getHWRessource_Owner();

		/**
		 * The meta object literal for the '<em><b>Connected To</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HW_RESSOURCE__CONNECTED_TO = eINSTANCE.getHWRessource_ConnectedTo();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.HWComputationalResourceImpl <em>HW Computational Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.HWComputationalResourceImpl
		 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getHWComputationalResource()
		 * @generated
		 */
		EClass HW_COMPUTATIONAL_RESOURCE = eINSTANCE.getHWComputationalResource();

		/**
		 * The meta object literal for the '<em><b>Is Under Preemptive Management</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HW_COMPUTATIONAL_RESOURCE__IS_UNDER_PREEMPTIVE_MANAGEMENT = eINSTANCE.getHWComputationalResource_IsUnderPreemptiveManagement();

		/**
		 * The meta object literal for the '<em><b>Allocated Agents</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HW_COMPUTATIONAL_RESOURCE__ALLOCATED_AGENTS = eINSTANCE.getHWComputationalResource_AllocatedAgents();

		/**
		 * The meta object literal for the '<em><b>Inc Cycle</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation HW_COMPUTATIONAL_RESOURCE___INC_CYCLE = eINSTANCE.getHWComputationalResource__IncCycle();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.HWStorageResourceImpl <em>HW Storage Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.HWStorageResourceImpl
		 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getHWStorageResource()
		 * @generated
		 */
		EClass HW_STORAGE_RESOURCE = eINSTANCE.getHWStorageResource();

		/**
		 * The meta object literal for the '<em><b>Allocated Places</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HW_STORAGE_RESOURCE__ALLOCATED_PLACES = eINSTANCE.getHWStorageResource_AllocatedPlaces();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.HWCommunicationResourceImpl <em>HW Communication Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.HWCommunicationResourceImpl
		 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getHWCommunicationResource()
		 * @generated
		 */
		EClass HW_COMMUNICATION_RESOURCE = eINSTANCE.getHWCommunicationResource();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.HWPlatformImpl <em>HW Platform</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.HWPlatformImpl
		 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getHWPlatform()
		 * @generated
		 */
		EClass HW_PLATFORM = eINSTANCE.getHWPlatform();

		/**
		 * The meta object literal for the '<em><b>Owned HW Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HW_PLATFORM__OWNED_HW_RESOURCES = eINSTANCE.getHWPlatform_OwnedHWResources();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SystemImpl <em>System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SystemImpl
		 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getSystem()
		 * @generated
		 */
		EClass SYSTEM = eINSTANCE.getSystem();

		/**
		 * The meta object literal for the '<em><b>Owned Application</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__OWNED_APPLICATION = eINSTANCE.getSystem_OwnedApplication();

		/**
		 * The meta object literal for the '<em><b>Owned HW Platform</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__OWNED_HW_PLATFORM = eINSTANCE.getSystem_OwnedHWPlatform();

		/**
		 * The meta object literal for the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.AgentState <em>Agent State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.AgentState
		 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getAgentState()
		 * @generated
		 */
		EEnum AGENT_STATE = eINSTANCE.getAgentState();

		/**
		 * The meta object literal for the '<em>Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Object
		 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.SigpmlPackageImpl#getObject()
		 * @generated
		 */
		EDataType OBJECT = eINSTANCE.getObject();

	}

} //SigpmlPackage
