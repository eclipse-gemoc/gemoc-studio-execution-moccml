package org.eclipse.gemoc.example.moccmlsigpml.design.services;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent;
import org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place;

import sigpml.xdsml.api.impl.SigPMLRTDAccessor;

public class K3RuntimeDataHelper {
	
	public boolean getIsCurrentlyExecuting(Agent eObject) {
		return SigPMLRTDAccessor.getIsCurrentlyExecuting(eObject);
	}
	
	public int getCurrentSize(Place eObject) {
		return SigPMLRTDAccessor.getCurrentSize(eObject);
	}
	
	public int getCurrentExecCycle(Agent eObject) {
		return SigPMLRTDAccessor.getCurrentExecCycle(eObject);
	}

}
