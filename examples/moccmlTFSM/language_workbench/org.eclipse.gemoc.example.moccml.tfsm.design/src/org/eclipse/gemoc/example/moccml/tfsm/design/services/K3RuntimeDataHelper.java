package org.eclipse.gemoc.example.moccml.tfsm.design.services;

import oncurrenttfsm.xdsml.api.impl.OncurrentTFSMRTDAccessor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.State;


public class K3RuntimeDataHelper {
	
	public State getCurrentState(EObject eObject) {
		System.out.println("getCurrentState(): "+eObject);
		System.out.println(OncurrentTFSMRTDAccessor.getcurrentState(eObject));
		return OncurrentTFSMRTDAccessor.getcurrentState(eObject);
	}
	
	public int getNumberOfTicks(EObject eObject) {
		return OncurrentTFSMRTDAccessor.getnumberOfTicks(eObject);
	}
	
}
