/**
 */
package org.eclipse.gemoc.example.moccmlsigpml.model.sigpml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Place</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#getItsOutputPort <em>Its Output Port</em>}</li>
 *   <li>{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#getItsInputPort <em>Its Input Port</em>}</li>
 *   <li>{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#getSize <em>Size</em>}</li>
 *   <li>{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#getDelay <em>Delay</em>}</li>
 *   <li>{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#getCurrentSize <em>Current Size</em>}</li>
 *   <li>{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#isIsInitialized <em>Is Initialized</em>}</li>
 * </ul>
 *
 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.SigpmlPackage#getPlace()
 * @model annotation="Aspect"
 * @generated
 */
public interface Place extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Its Output Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Its Output Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Its Output Port</em>' reference.
	 * @see #setItsOutputPort(OutputPort)
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.SigpmlPackage#getPlace_ItsOutputPort()
	 * @model required="true"
	 * @generated
	 */
	OutputPort getItsOutputPort();

	/**
	 * Sets the value of the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#getItsOutputPort <em>Its Output Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Its Output Port</em>' reference.
	 * @see #getItsOutputPort()
	 * @generated
	 */
	void setItsOutputPort(OutputPort value);

	/**
	 * Returns the value of the '<em><b>Its Input Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Its Input Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Its Input Port</em>' reference.
	 * @see #setItsInputPort(InputPort)
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.SigpmlPackage#getPlace_ItsInputPort()
	 * @model required="true"
	 * @generated
	 */
	InputPort getItsInputPort();

	/**
	 * Sets the value of the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#getItsInputPort <em>Its Input Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Its Input Port</em>' reference.
	 * @see #getItsInputPort()
	 * @generated
	 */
	void setItsInputPort(InputPort value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(int)
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.SigpmlPackage#getPlace_Size()
	 * @model
	 * @generated
	 */
	int getSize();

	/**
	 * Sets the value of the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(int value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Application#getOwnedPlaces <em>Owned Places</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Application)
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.SigpmlPackage#getPlace_Owner()
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Application#getOwnedPlaces
	 * @model opposite="ownedPlaces" required="true" transient="false"
	 * @generated
	 */
	Application getOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Application value);

	/**
	 * Returns the value of the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delay</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delay</em>' attribute.
	 * @see #setDelay(int)
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.SigpmlPackage#getPlace_Delay()
	 * @model
	 * @generated
	 */
	int getDelay();

	/**
	 * Sets the value of the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#getDelay <em>Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delay</em>' attribute.
	 * @see #getDelay()
	 * @generated
	 */
	void setDelay(int value);

	/**
	 * Returns the value of the '<em><b>Current Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Size</em>' attribute.
	 * @see #setCurrentSize(int)
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.SigpmlPackage#getPlace_CurrentSize()
	 * @model annotation="Aspect"
	 * @generated
	 */
	int getCurrentSize();

	/**
	 * Sets the value of the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#getCurrentSize <em>Current Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Size</em>' attribute.
	 * @see #getCurrentSize()
	 * @generated
	 */
	void setCurrentSize(int value);

	/**
	 * Returns the value of the '<em><b>Is Initialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Initialized</em>' attribute.
	 * @see #setIsInitialized(boolean)
	 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.SigpmlPackage#getPlace_IsInitialized()
	 * @model
	 * @generated
	 */
	boolean isIsInitialized();

	/**
	 * Sets the value of the '{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place#isIsInitialized <em>Is Initialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Initialized</em>' attribute.
	 * @see #isIsInitialized()
	 * @generated
	 */
	void setIsInitialized(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void push();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void pop();

} // Place
