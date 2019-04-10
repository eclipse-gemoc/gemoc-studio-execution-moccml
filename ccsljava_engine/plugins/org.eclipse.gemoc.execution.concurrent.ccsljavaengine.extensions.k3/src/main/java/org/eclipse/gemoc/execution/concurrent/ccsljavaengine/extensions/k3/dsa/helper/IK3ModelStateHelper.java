package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.dsa.helper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelState;

public interface IK3ModelStateHelper {
	
	public K3ModelState getK3ModelState(EObject model);
	public void restoreModelState(K3ModelState state);

};


