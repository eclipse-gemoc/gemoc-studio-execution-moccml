/* GENERATED FILE, do not modify manually                                                    *
 * If you need to modify it, copy it first */
package sigpml.xdsml.api.impl;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.ElementState;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelState;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelStateFactory;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.dsa.helper.IK3ModelStateHelper;import org.eclipse.gemoc.executionframework.engine.commons.K3DslHelper;


public class SigPMLModelStateHelper implements IK3ModelStateHelper{
	private static class AttributeNameToValue implements Serializable{

		private static final long serialVersionUID = 0;		String name;
		Object value;
		public AttributeNameToValue(String n, Object v) {
			name = n;
			value = v;
		}


		@Override
		public boolean equals(Object obj) {
			if (! (obj instanceof AttributeNameToValue)) {
				return false;
			}
			AttributeNameToValue a2n = (AttributeNameToValue)obj;
			if (this.name.compareTo(a2n.name) != 0) {
				return false;
			}
			if (this.value == null) {
				return a2n.value == null;
			}
			if (!this.value.equals(a2n.value)) {
				return false;
			}
			return true;
		}

	}
	K3ModelStateFactory theFactory = K3ModelStateFactory.eINSTANCE; 
	public K3ModelState getK3ModelState(EObject model) {
		K3ModelState res = theFactory.createK3ModelState();

				// consider indirectly referenced models (ugly and probably not efficient)
		ArrayList<EObject> allElements = new ArrayList<EObject>();
		model.eAllContents().forEachRemaining(x -> allElements.add(x));
		Map<EObject, Collection<Setting>> f = EcoreUtil.CrossReferencer.find(allElements);
		HashSet<Resource> consideredResources = new HashSet<Resource>();
		consideredResources.add(model.eResource());
		f.keySet().forEach(eo -> consideredResources.add(eo.eResource()));
		
		for(Resource resource : consideredResources) {
			TreeIterator<EObject> allContentIt = resource.getAllContents();
			while (allContentIt.hasNext()) {
				EObject elem = allContentIt.next();

				Class<?> clazz =null;
				clazz = K3DslHelper.getTarget(org.eclipse.gemoc.example.moccmlsigpml.k3dsa.PlaceAspect.class);
				if (clazz.isInstance(elem)) {
					ElementState elemState = theFactory.createElementState();
					elemState.setModelElement(elem);
					res.getOwnedElementstates().add(elemState);
					AttributeNameToValue n2v0 = new AttributeNameToValue("fifo", SigPMLRTDAccessor.getFifo((org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place)elem));
					elemState.getSavedRTDs().add(n2v0);
					AttributeNameToValue n2v1 = new AttributeNameToValue("currentSize", SigPMLRTDAccessor.getCurrentSize((org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place)elem));
					elemState.getSavedRTDs().add(n2v1);
					AttributeNameToValue n2v2 = new AttributeNameToValue("isInitialized", SigPMLRTDAccessor.getIsInitialized((org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place)elem));
					elemState.getSavedRTDs().add(n2v2);
				}
				clazz = K3DslHelper.getTarget(org.eclipse.gemoc.example.moccmlsigpml.k3dsa.SystemAspect.class);
				if (clazz.isInstance(elem)) {
					ElementState elemState = theFactory.createElementState();
					elemState.setModelElement(elem);
					res.getOwnedElementstates().add(elemState);
					AttributeNameToValue n2v0 = new AttributeNameToValue("sharedMemory", SigPMLRTDAccessor.getSharedMemory((org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.System)elem));
					elemState.getSavedRTDs().add(n2v0);
				}
				clazz = K3DslHelper.getTarget(org.eclipse.gemoc.example.moccmlsigpml.k3dsa.OutputPortAspect.class);
				if (clazz.isInstance(elem)) {
					ElementState elemState = theFactory.createElementState();
					elemState.setModelElement(elem);
					res.getOwnedElementstates().add(elemState);
					AttributeNameToValue n2v0 = new AttributeNameToValue("sizeWritten", SigPMLRTDAccessor.getSizeWritten((org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.OutputPort)elem));
					elemState.getSavedRTDs().add(n2v0);
				}
				clazz = K3DslHelper.getTarget(org.eclipse.gemoc.example.moccmlsigpml.k3dsa.AgentAspect.class);
				if (clazz.isInstance(elem)) {
					ElementState elemState = theFactory.createElementState();
					elemState.setModelElement(elem);
					res.getOwnedElementstates().add(elemState);
					AttributeNameToValue n2v0 = new AttributeNameToValue("plotter", SigPMLRTDAccessor.getPlotter((org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent)elem));
					elemState.getSavedRTDs().add(n2v0);
					AttributeNameToValue n2v1 = new AttributeNameToValue("frame", SigPMLRTDAccessor.getFrame((org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent)elem));
					elemState.getSavedRTDs().add(n2v1);
					AttributeNameToValue n2v2 = new AttributeNameToValue("figure", SigPMLRTDAccessor.getFigure((org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent)elem));
					elemState.getSavedRTDs().add(n2v2);
					AttributeNameToValue n2v3 = new AttributeNameToValue("hasBeenStopped", SigPMLRTDAccessor.getHasBeenStopped((org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent)elem));
					elemState.getSavedRTDs().add(n2v3);
					AttributeNameToValue n2v4 = new AttributeNameToValue("currentExecCycle", SigPMLRTDAccessor.getCurrentExecCycle((org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent)elem));
					elemState.getSavedRTDs().add(n2v4);
					AttributeNameToValue n2v5 = new AttributeNameToValue("isCurrentlyExecuting", SigPMLRTDAccessor.getIsCurrentlyExecuting((org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent)elem));
					elemState.getSavedRTDs().add(n2v5);
				}
				clazz = K3DslHelper.getTarget(org.eclipse.gemoc.example.moccmlsigpml.k3dsa.InputPortAspect.class);
				if (clazz.isInstance(elem)) {
					ElementState elemState = theFactory.createElementState();
					elemState.setModelElement(elem);
					res.getOwnedElementstates().add(elemState);
					AttributeNameToValue n2v0 = new AttributeNameToValue("sizeToread", SigPMLRTDAccessor.getSizeToread((org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.InputPort)elem));
					elemState.getSavedRTDs().add(n2v0);
				}
				clazz = K3DslHelper.getTarget(org.eclipse.gemoc.example.moccmlsigpml.k3dsa.HWComputationalResourceAspect.class);
				if (clazz.isInstance(elem)) {
					ElementState elemState = theFactory.createElementState();
					elemState.setModelElement(elem);
					res.getOwnedElementstates().add(elemState);
					AttributeNameToValue n2v0 = new AttributeNameToValue("executionCycle", SigPMLRTDAccessor.getExecutionCycle((org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWComputationalResource)elem));
					elemState.getSavedRTDs().add(n2v0);
				}
			}
		}
		return res;
	}


	public void restoreModelState(K3ModelState state) {
		for(ElementState elemState : state.getOwnedElementstates()) {
			for(Object o : elemState.getSavedRTDs()) {
				AttributeNameToValue n2v = (AttributeNameToValue)o;
				String n2vOpName = n2v.name.substring(0,1).toUpperCase() + n2v.name.substring(1);
				try {
					if (n2v.value != null) {
						Method m = SigPMLRTDAccessor.class.getMethod("set"+n2vOpName, elemState.getModelElement().getClass().getInterfaces()[0], n2v.value.getClass());
						m.invoke(null, elemState.getModelElement(), n2v.value);
					}
				} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					Method m = null;
					for(Class<?> c : n2v.value.getClass().getInterfaces()) {
						
						try {
							m = SigPMLRTDAccessor.class.getMethod("set"+n2vOpName, elemState.getModelElement().getClass().getInterfaces()[0], c);
							m.invoke(null, elemState.getModelElement(), n2v.value);
						} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
						}
						if (m == null) {
							throw new RuntimeException("not method found for "+n2v.value.getClass().getName()+"::set"+n2vOpName);
						}
					}
				}
			}
		}
	}

};