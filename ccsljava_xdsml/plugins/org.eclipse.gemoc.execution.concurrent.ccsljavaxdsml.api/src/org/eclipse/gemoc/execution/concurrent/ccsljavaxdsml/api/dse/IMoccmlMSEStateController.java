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
package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dse;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.moc.ISolver;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.ModelSpecificEvent;



public interface IMoccmlMSEStateController
{

	void applyMSEFutureStates(ISolver solver);
	void forcePresenceInTheFuture(ModelSpecificEvent mse);
	void forceAbsenceTickInTheFuture(ModelSpecificEvent mse);
	void freeInTheFuture(String _mseToBeForcedURI);
	void setFeedBackModelResource(Resource resFeedbackModel);
	Resource  getFeedBackModelResource();
	
}
