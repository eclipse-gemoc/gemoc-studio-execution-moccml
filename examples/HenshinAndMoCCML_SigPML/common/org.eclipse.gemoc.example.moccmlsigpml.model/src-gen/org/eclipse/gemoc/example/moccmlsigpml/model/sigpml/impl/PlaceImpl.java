/**
 */
package org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Application;
import org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.InputPort;
import org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.OutputPort;
import org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place;
import org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.SigpmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Place</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.PlaceImpl#getItsOutputPort <em>Its Output Port</em>}</li>
 *   <li>{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.PlaceImpl#getItsInputPort <em>Its Input Port</em>}</li>
 *   <li>{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.PlaceImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.PlaceImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.PlaceImpl#getDelay <em>Delay</em>}</li>
 *   <li>{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.PlaceImpl#getCurrentSize <em>Current Size</em>}</li>
 *   <li>{@link org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.impl.PlaceImpl#isIsInitialized <em>Is Initialized</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PlaceImpl extends NamedElementImpl implements Place {
	/**
	 * The cached value of the '{@link #getItsOutputPort() <em>Its Output Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItsOutputPort()
	 * @generated
	 * @ordered
	 */
	protected OutputPort itsOutputPort;

	/**
	 * The cached value of the '{@link #getItsInputPort() <em>Its Input Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItsInputPort()
	 * @generated
	 * @ordered
	 */
	protected InputPort itsInputPort;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final int SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected int size = SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDelay() <em>Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelay()
	 * @generated
	 * @ordered
	 */
	protected static final int DELAY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDelay() <em>Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelay()
	 * @generated
	 * @ordered
	 */
	protected int delay = DELAY_EDEFAULT;

	/**
	 * The default value of the '{@link #getCurrentSize() <em>Current Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentSize()
	 * @generated
	 * @ordered
	 */
	protected static final int CURRENT_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCurrentSize() <em>Current Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentSize()
	 * @generated
	 * @ordered
	 */
	protected int currentSize = CURRENT_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsInitialized() <em>Is Initialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInitialized()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_INITIALIZED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsInitialized() <em>Is Initialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInitialized()
	 * @generated
	 * @ordered
	 */
	protected boolean isInitialized = IS_INITIALIZED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SigpmlPackage.Literals.PLACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OutputPort getItsOutputPort() {
		if (itsOutputPort != null && itsOutputPort.eIsProxy()) {
			InternalEObject oldItsOutputPort = (InternalEObject)itsOutputPort;
			itsOutputPort = (OutputPort)eResolveProxy(oldItsOutputPort);
			if (itsOutputPort != oldItsOutputPort) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SigpmlPackage.PLACE__ITS_OUTPUT_PORT, oldItsOutputPort, itsOutputPort));
			}
		}
		return itsOutputPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputPort basicGetItsOutputPort() {
		return itsOutputPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setItsOutputPort(OutputPort newItsOutputPort) {
		OutputPort oldItsOutputPort = itsOutputPort;
		itsOutputPort = newItsOutputPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SigpmlPackage.PLACE__ITS_OUTPUT_PORT, oldItsOutputPort, itsOutputPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InputPort getItsInputPort() {
		if (itsInputPort != null && itsInputPort.eIsProxy()) {
			InternalEObject oldItsInputPort = (InternalEObject)itsInputPort;
			itsInputPort = (InputPort)eResolveProxy(oldItsInputPort);
			if (itsInputPort != oldItsInputPort) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SigpmlPackage.PLACE__ITS_INPUT_PORT, oldItsInputPort, itsInputPort));
			}
		}
		return itsInputPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPort basicGetItsInputPort() {
		return itsInputPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setItsInputPort(InputPort newItsInputPort) {
		InputPort oldItsInputPort = itsInputPort;
		itsInputPort = newItsInputPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SigpmlPackage.PLACE__ITS_INPUT_PORT, oldItsInputPort, itsInputPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSize(int newSize) {
		int oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SigpmlPackage.PLACE__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Application getOwner() {
		if (eContainerFeatureID() != SigpmlPackage.PLACE__OWNER) return null;
		return (Application)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(Application newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, SigpmlPackage.PLACE__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwner(Application newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != SigpmlPackage.PLACE__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, SigpmlPackage.APPLICATION__OWNED_PLACES, Application.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SigpmlPackage.PLACE__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getDelay() {
		return delay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDelay(int newDelay) {
		int oldDelay = delay;
		delay = newDelay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SigpmlPackage.PLACE__DELAY, oldDelay, delay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getCurrentSize() {
		return currentSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCurrentSize(int newCurrentSize) {
		int oldCurrentSize = currentSize;
		currentSize = newCurrentSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SigpmlPackage.PLACE__CURRENT_SIZE, oldCurrentSize, currentSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsInitialized() {
		return isInitialized;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsInitialized(boolean newIsInitialized) {
		boolean oldIsInitialized = isInitialized;
		isInitialized = newIsInitialized;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SigpmlPackage.PLACE__IS_INITIALIZED, oldIsInitialized, isInitialized));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void push() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void pop() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SigpmlPackage.PLACE__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((Application)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SigpmlPackage.PLACE__OWNER:
				return basicSetOwner(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SigpmlPackage.PLACE__OWNER:
				return eInternalContainer().eInverseRemove(this, SigpmlPackage.APPLICATION__OWNED_PLACES, Application.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SigpmlPackage.PLACE__ITS_OUTPUT_PORT:
				if (resolve) return getItsOutputPort();
				return basicGetItsOutputPort();
			case SigpmlPackage.PLACE__ITS_INPUT_PORT:
				if (resolve) return getItsInputPort();
				return basicGetItsInputPort();
			case SigpmlPackage.PLACE__SIZE:
				return getSize();
			case SigpmlPackage.PLACE__OWNER:
				return getOwner();
			case SigpmlPackage.PLACE__DELAY:
				return getDelay();
			case SigpmlPackage.PLACE__CURRENT_SIZE:
				return getCurrentSize();
			case SigpmlPackage.PLACE__IS_INITIALIZED:
				return isIsInitialized();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SigpmlPackage.PLACE__ITS_OUTPUT_PORT:
				setItsOutputPort((OutputPort)newValue);
				return;
			case SigpmlPackage.PLACE__ITS_INPUT_PORT:
				setItsInputPort((InputPort)newValue);
				return;
			case SigpmlPackage.PLACE__SIZE:
				setSize((Integer)newValue);
				return;
			case SigpmlPackage.PLACE__OWNER:
				setOwner((Application)newValue);
				return;
			case SigpmlPackage.PLACE__DELAY:
				setDelay((Integer)newValue);
				return;
			case SigpmlPackage.PLACE__CURRENT_SIZE:
				setCurrentSize((Integer)newValue);
				return;
			case SigpmlPackage.PLACE__IS_INITIALIZED:
				setIsInitialized((Boolean)newValue);
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
			case SigpmlPackage.PLACE__ITS_OUTPUT_PORT:
				setItsOutputPort((OutputPort)null);
				return;
			case SigpmlPackage.PLACE__ITS_INPUT_PORT:
				setItsInputPort((InputPort)null);
				return;
			case SigpmlPackage.PLACE__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case SigpmlPackage.PLACE__OWNER:
				setOwner((Application)null);
				return;
			case SigpmlPackage.PLACE__DELAY:
				setDelay(DELAY_EDEFAULT);
				return;
			case SigpmlPackage.PLACE__CURRENT_SIZE:
				setCurrentSize(CURRENT_SIZE_EDEFAULT);
				return;
			case SigpmlPackage.PLACE__IS_INITIALIZED:
				setIsInitialized(IS_INITIALIZED_EDEFAULT);
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
			case SigpmlPackage.PLACE__ITS_OUTPUT_PORT:
				return itsOutputPort != null;
			case SigpmlPackage.PLACE__ITS_INPUT_PORT:
				return itsInputPort != null;
			case SigpmlPackage.PLACE__SIZE:
				return size != SIZE_EDEFAULT;
			case SigpmlPackage.PLACE__OWNER:
				return getOwner() != null;
			case SigpmlPackage.PLACE__DELAY:
				return delay != DELAY_EDEFAULT;
			case SigpmlPackage.PLACE__CURRENT_SIZE:
				return currentSize != CURRENT_SIZE_EDEFAULT;
			case SigpmlPackage.PLACE__IS_INITIALIZED:
				return isInitialized != IS_INITIALIZED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SigpmlPackage.PLACE___PUSH:
				push();
				return null;
			case SigpmlPackage.PLACE___POP:
				pop();
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (size: ");
		result.append(size);
		result.append(", delay: ");
		result.append(delay);
		result.append(", currentSize: ");
		result.append(currentSize);
		result.append(", isInitialized: ");
		result.append(isInitialized);
		result.append(')');
		return result.toString();
	}

} //PlaceImpl
