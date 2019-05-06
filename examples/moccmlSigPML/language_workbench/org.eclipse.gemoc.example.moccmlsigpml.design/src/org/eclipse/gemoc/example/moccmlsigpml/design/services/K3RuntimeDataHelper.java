package org.eclipse.gemoc.example.moccmlsigpml.design.services;

import org.eclipse.emf.ecore.EObject;

import sigpml.xdsml.api.impl.SigPMLRTDAccessor;

public class K3RuntimeDataHelper {
	
	public boolean getIsCurrentlyExecuting(EObject eObject) {
		return SigPMLRTDAccessor.getisCurrentlyExecuting(eObject);
	}
	
	public int getCurrentSize(EObject eObject) {
		return SigPMLRTDAccessor.getcurrentSize(eObject);
	}
	
	public int getCurrentExecCycle(EObject eObject) {
		return SigPMLRTDAccessor.getcurrentExecCycle(eObject);
	}

}
