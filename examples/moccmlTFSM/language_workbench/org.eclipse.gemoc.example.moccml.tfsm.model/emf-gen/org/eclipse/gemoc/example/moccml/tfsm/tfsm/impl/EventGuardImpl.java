/**
 */
package org.eclipse.gemoc.example.moccml.tfsm.tfsm.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.gemoc.example.moccml.tfsm.tfsm.EventGuard;
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.FSMEvent;
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.TfsmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Guard</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gemoc.example.moccml.tfsm.tfsm.impl.EventGuardImpl#getTriggeringEvent <em>Triggering Event</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EventGuardImpl extends GuardImpl implements EventGuard {
	/**
	 * The cached value of the '{@link #getTriggeringEvent() <em>Triggering Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriggeringEvent()
	 * @generated
	 * @ordered
	 */
	protected FSMEvent triggeringEvent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventGuardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TfsmPackage.Literals.EVENT_GUARD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSMEvent getTriggeringEvent() {
		if (triggeringEvent != null && triggeringEvent.eIsProxy()) {
			InternalEObject oldTriggeringEvent = (InternalEObject)triggeringEvent;
			triggeringEvent = (FSMEvent)eResolveProxy(oldTriggeringEvent);
			if (triggeringEvent != oldTriggeringEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TfsmPackage.EVENT_GUARD__TRIGGERING_EVENT, oldTriggeringEvent, triggeringEvent));
			}
		}
		return triggeringEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSMEvent basicGetTriggeringEvent() {
		return triggeringEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTriggeringEvent(FSMEvent newTriggeringEvent) {
		FSMEvent oldTriggeringEvent = triggeringEvent;
		triggeringEvent = newTriggeringEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TfsmPackage.EVENT_GUARD__TRIGGERING_EVENT, oldTriggeringEvent, triggeringEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TfsmPackage.EVENT_GUARD__TRIGGERING_EVENT:
				if (resolve) return getTriggeringEvent();
				return basicGetTriggeringEvent();
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
			case TfsmPackage.EVENT_GUARD__TRIGGERING_EVENT:
				setTriggeringEvent((FSMEvent)newValue);
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
			case TfsmPackage.EVENT_GUARD__TRIGGERING_EVENT:
				setTriggeringEvent((FSMEvent)null);
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
			case TfsmPackage.EVENT_GUARD__TRIGGERING_EVENT:
				return triggeringEvent != null;
		}
		return super.eIsSet(featureID);
	}

} //EventGuardImpl
