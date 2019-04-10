/*******************************************************************************
 * Copyright (c) 2017 INRIA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     INRIA - initial API and implementation
 *     I3S Laboratory - API update and bug fix
 *******************************************************************************/
/**
 */
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.concurrentmse.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.concurrentmse.Concurrent_mseFactory;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.concurrentmse.Concurrent_msePackage;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.concurrentmse.FeedbackMSE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Concurrent_mseFactoryImpl extends EFactoryImpl implements Concurrent_mseFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Concurrent_mseFactory init() {
		try {
			Concurrent_mseFactory theConcurrent_mseFactory = (Concurrent_mseFactory)EPackage.Registry.INSTANCE.getEFactory(Concurrent_msePackage.eNS_URI);
			if (theConcurrent_mseFactory != null) {
				return theConcurrent_mseFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Concurrent_mseFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Concurrent_mseFactoryImpl() {
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
			case Concurrent_msePackage.FEEDBACK_MSE: return createFeedbackMSE();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeedbackMSE createFeedbackMSE() {
		FeedbackMSEImpl feedbackMSE = new FeedbackMSEImpl();
		return feedbackMSE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Concurrent_msePackage getConcurrent_msePackage() {
		return (Concurrent_msePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Concurrent_msePackage getPackage() {
		return Concurrent_msePackage.eINSTANCE;
	}

} //Concurrent_mseFactoryImpl
