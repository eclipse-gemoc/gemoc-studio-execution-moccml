package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.dsa.executors.explorer;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.ElementState;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelState;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelStateFactory;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.ModelSpecificEvent;

public class ControlAndRTDState implements Serializable {
	
	private static final long serialVersionUID = 0;
	public K3ModelState modelState = K3ModelStateFactory.eINSTANCE.createK3ModelState();
	public byte[] moCCState = null;
	public Map<ModelSpecificEvent, Boolean> engineState = null;

	public ControlAndRTDState(K3ModelState modelS, byte[] moccS, Map<ModelSpecificEvent, Boolean> es) {
		super();
		modelState = modelS;
		moCCState = moccS;
		engineState = es;
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
		return state.engineState.equals(this.engineState);
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
		for(ModelSpecificEvent mse : this.engineState.keySet()) {
			sbRes.append(mse.getName()+ "=" +this.engineState.get(mse)+"\n");
		}
		return sbRes.toString();
	}
	
}
