package org.eclipse.gemoc.example.moccml.tfsm.design.services;

import org.eclipse.gemoc.example.moccml.tfsm.tfsm.BooleanVariable;
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.FSMClock;
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.IntegerVariable;
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.State;
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.TFSM;
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.Variable;

import oncurrenttfsm.xdsml.api.impl.OncurrentTFSMRTDAccessor;


public class K3RuntimeDataHelper {
	
	public State getCurrentState(TFSM eObject) {
		return OncurrentTFSMRTDAccessor.getCurrentState(eObject);
	}
	
	public int getNumberOfTicks(FSMClock eObject) {
		return OncurrentTFSMRTDAccessor.getNumberOfTicks(eObject);
	}
	
	public Object getCurrentValue(Variable eObject) {
		if (eObject instanceof BooleanVariable) {
			return OncurrentTFSMRTDAccessor.getCurrentValue((BooleanVariable)eObject);
		}
		return OncurrentTFSMRTDAccessor.getCurrentValue((IntegerVariable)eObject);

	}
	
	
}
