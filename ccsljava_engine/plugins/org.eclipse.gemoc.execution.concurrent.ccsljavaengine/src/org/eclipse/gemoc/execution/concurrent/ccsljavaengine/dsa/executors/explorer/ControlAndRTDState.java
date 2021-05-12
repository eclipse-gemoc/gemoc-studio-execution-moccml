package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.dsa.executors.explorer;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.tuple.Pair;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.dse.FreeClockFutureAction;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.ElementState;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelState;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelStateFactory;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dse.IMoccmlFutureAction;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.ModelSpecificEvent;

public class ControlAndRTDState implements Serializable {
	
	private static final long serialVersionUID = 0;
	public K3ModelState modelState = K3ModelStateFactory.eINSTANCE.createK3ModelState();
	public byte[] moCCState = null;
	public Map<ModelSpecificEvent, Boolean> nextEventToForce = null;
	public ArrayList<IMoccmlFutureAction> futurActions = null;
	
	public ControlAndRTDState(K3ModelState modelS, byte[] moccS, Pair<Map<ModelSpecificEvent, Boolean>, ArrayList<IMoccmlFutureAction>> engineState) {
		super();
		modelState = modelS;
		moCCState = moccS;
		nextEventToForce = engineState.getLeft();
		futurActions = engineState.getRight();
	}
	
	@Override
	public boolean equals(Object state){
		return this.equals((ControlAndRTDState)state);
	}

	public boolean equals(ControlAndRTDState state){
//		System.out.println("################################################################################################\ncompare "+this+ "with "+state);
		if (! Arrays.equals(state.moCCState, this.moCCState)) {
			return false;
		}
		int i = 0;
		for(ElementState newStateElemState : state.modelState.getOwnedElementstates()) {
			boolean found = false;
			for (ElementState modelElementState : this.modelState.getOwnedElementstates()) {
				if(areEquals(modelElementState,newStateElemState)) {
					found = true;
					break;
				}
			}
			if (!found) {
				return false;
			}
		}		
		if(nextEventToForce != null) { 
			if(!areEquals(state.nextEventToForce,this.nextEventToForce)) {
				return false;
			}
		}
		return areEquals(state.futurActions, this.futurActions);
	}
	
	private boolean areEquals(ArrayList<IMoccmlFutureAction> futurActions1,	ArrayList<IMoccmlFutureAction> futurActions2) {
		if(futurActions1.size() != futurActions2.size()) {
			return false;
		}
		mainloop: for(IMoccmlFutureAction fa1 : futurActions1) {
			for(IMoccmlFutureAction fa2 : futurActions2) {
				if (fa1.getTriggeringMSE().getName().compareTo(fa2.getTriggeringMSE().getName()) == 0 
						&&
					fa1.getMseToBeForced().getName().compareTo(fa2.getMseToBeForced().getName()) == 0) {
					continue mainloop;
				}
			}
			return false;
		}
		return true;
	}

	private boolean areEquals(Map<ModelSpecificEvent, Boolean> engineState, Map<ModelSpecificEvent, Boolean> newEngineState) {
		if(engineState.size() != newEngineState.size()) {
			return false;
		}
		mainloop: for(Entry<ModelSpecificEvent, Boolean> e1 : engineState.entrySet()) {
			for(Entry<ModelSpecificEvent, Boolean>  e2 : newEngineState.entrySet()) {
				if (e1.getKey().getName().compareTo(e2.getKey().getName()) == 0 && e1.getValue() == e2.getValue()) {
					continue mainloop;
				}
			}
			return false;
		}
		return true;
	}
	
	private boolean areEquals(ElementState modelElementState, ElementState newStateElemState) {
        if (!modelElementState.getModelElement().equals(newStateElemState.getModelElement())) {
            return false;
        }
		for(Object newStateRTD :  newStateElemState.getSavedRTDs()) {
			boolean RTDfound = false;
			for(Object modelRTD :  modelElementState.getSavedRTDs()) {
				if (newStateRTD.equals(modelRTD)) {
					RTDfound = true;
					break;
				}
			}
			if (!RTDfound) {
				return false;
			}
		}
		return true;
	}

	static Integer index = 0;
	@Override
	public String toString() {
		StringBuilder sbRes = new StringBuilder();//(index++).toString());
		for(ElementState elemState : this.modelState.getOwnedElementstates()) {
			try {
				EList<EAttribute> eAllAttributes = elemState.getModelElement().eClass().getEAllAttributes();
				for (EAttribute attr : eAllAttributes) {
					if ("name".equals(attr.getName())) {
						final Object value = elemState.getModelElement().eGet(attr, false);
						if (value instanceof String) {
							sbRes.append(((String) value)+"\n");
							break;
						}
					}
				}
			} catch (IllegalArgumentException | SecurityException e1) {
				sbRes.append(elemState.getModelElement().getClass().getName()+index);
				index++;
			}
//			sbRes.append(elemState.getModelElement());
			for(Object rtd : elemState.getSavedRTDs()) {
				//the Object is an AttributeNameToValue...
				try {
					Field f = rtd.getClass().getDeclaredField("name");
					f.setAccessible(true);
					sbRes.append("\t"+f.get(rtd)+":");
					f = rtd.getClass().getDeclaredField("value");
					f.setAccessible(true);
					sbRes.append("\t"+f.get(rtd)+"\n");
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		if (nextEventToForce != null) {
			for(ModelSpecificEvent mse : this.nextEventToForce.keySet()) {
				sbRes.append(mse.getName()+ "=" +this.nextEventToForce.get(mse)+"\n");
			}
		}
		if (futurActions != null) {
			for(IMoccmlFutureAction fa: this.futurActions) {
				sbRes.append("free "+ fa.getMseToBeForced()+ " on " +fa.getTriggeringMSE().getName()+"\n");
			}
		}
		return sbRes.toString();
	}
	
}
