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
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.concurrentmse;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.gemoc.execution.concurrent.ccsljavaengine.concurrentmse.Concurrent_msePackage
 * @generated
 */
public interface Concurrent_mseFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Concurrent_mseFactory eINSTANCE = org.eclipse.gemoc.execution.concurrent.ccsljavaengine.concurrentmse.impl.Concurrent_mseFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Feedback MSE</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feedback MSE</em>'.
	 * @generated
	 */
	FeedbackMSE createFeedbackMSE();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Concurrent_msePackage getConcurrent_msePackage();

} //Concurrent_mseFactory
