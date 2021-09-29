/* GENERATED FILE, do not modify manually                                                    *
 * If you need to modify it, copy it first */
package sigpml.xdsml.api.impl;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.ElementState;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelState;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelStateFactory;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.dsa.helper.IK3ModelStateHelper;import org.eclipse.gemoc.executionframework.engine.commons.K3DslHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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
		}	}
		K3ModelStateFactory theFactory = K3ModelStateFactory.eINSTANCE; 

	public K3ModelState getK3StateSpaceModelState(EObject model) {
		return getK3ModelState(model, false);
	}
	

	public K3ModelState getK3ModelState(EObject model) {
		return getK3ModelState(model, true);
	}
		
	public K3ModelState getK3ModelState(EObject model, boolean allRTDs) {
		K3ModelState res = theFactory.createK3ModelState();

		Class<?> clazz =null;
		clazz = K3DslHelper.getTarget(org.eclipse.gemoc.example.moccmlsigpml.k3dsa.PlaceAspect.class);
		if (clazz.isInstance(model)) {
			ElementState elemState = theFactory.createElementState();
			elemState.setModelElement(model);
			res.getOwnedElementstates().add(elemState);
				AttributeNameToValue n2v0 = new AttributeNameToValue("fifo", SigPMLRTDAccessor.getfifo(model));
				elemState.getSavedRTDs().add(n2v0);
				AttributeNameToValue n2v1 = new AttributeNameToValue("currentSize", SigPMLRTDAccessor.getcurrentSize(model));
				elemState.getSavedRTDs().add(n2v1);
				AttributeNameToValue n2v2 = new AttributeNameToValue("isInitialized", SigPMLRTDAccessor.getisInitialized(model));
				elemState.getSavedRTDs().add(n2v2);
		}
		clazz = K3DslHelper.getTarget(org.eclipse.gemoc.example.moccmlsigpml.k3dsa.SystemAspect.class);
		if (clazz.isInstance(model)) {
			ElementState elemState = theFactory.createElementState();
			elemState.setModelElement(model);
			res.getOwnedElementstates().add(elemState);
				AttributeNameToValue n2v0 = new AttributeNameToValue("sharedMemory", SigPMLRTDAccessor.getsharedMemory(model));
				elemState.getSavedRTDs().add(n2v0);
		}
		clazz = K3DslHelper.getTarget(org.eclipse.gemoc.example.moccmlsigpml.k3dsa.OutputPortAspect.class);
		if (clazz.isInstance(model)) {
			ElementState elemState = theFactory.createElementState();
			elemState.setModelElement(model);
			res.getOwnedElementstates().add(elemState);
				AttributeNameToValue n2v0 = new AttributeNameToValue("sizeWritten", SigPMLRTDAccessor.getsizeWritten(model));
				elemState.getSavedRTDs().add(n2v0);
		}
		clazz = K3DslHelper.getTarget(org.eclipse.gemoc.example.moccmlsigpml.k3dsa.AgentAspect.class);
		if (clazz.isInstance(model)) {
			ElementState elemState = theFactory.createElementState();
			elemState.setModelElement(model);
			res.getOwnedElementstates().add(elemState);
				AttributeNameToValue n2v0 = new AttributeNameToValue("plotter", SigPMLRTDAccessor.getplotter(model));
				elemState.getSavedRTDs().add(n2v0);
				AttributeNameToValue n2v1 = new AttributeNameToValue("frame", SigPMLRTDAccessor.getframe(model));
				elemState.getSavedRTDs().add(n2v1);
				AttributeNameToValue n2v2 = new AttributeNameToValue("figure", SigPMLRTDAccessor.getfigure(model));
				elemState.getSavedRTDs().add(n2v2);
				AttributeNameToValue n2v3 = new AttributeNameToValue("hasBeenStopped", SigPMLRTDAccessor.gethasBeenStopped(model));
				elemState.getSavedRTDs().add(n2v3);
				AttributeNameToValue n2v4 = new AttributeNameToValue("currentExecCycle", SigPMLRTDAccessor.getcurrentExecCycle(model));
				elemState.getSavedRTDs().add(n2v4);
				AttributeNameToValue n2v5 = new AttributeNameToValue("isCurrentlyExecuting", SigPMLRTDAccessor.getisCurrentlyExecuting(model));
				elemState.getSavedRTDs().add(n2v5);
		}
		clazz = K3DslHelper.getTarget(org.eclipse.gemoc.example.moccmlsigpml.k3dsa.InputPortAspect.class);
		if (clazz.isInstance(model)) {
			ElementState elemState = theFactory.createElementState();
			elemState.setModelElement(model);
			res.getOwnedElementstates().add(elemState);
				AttributeNameToValue n2v0 = new AttributeNameToValue("sizeToread", SigPMLRTDAccessor.getsizeToread(model));
				elemState.getSavedRTDs().add(n2v0);
		}
		clazz = K3DslHelper.getTarget(org.eclipse.gemoc.example.moccmlsigpml.k3dsa.HWComputationalResourceAspect.class);
		if (clazz.isInstance(model)) {
			ElementState elemState = theFactory.createElementState();
			elemState.setModelElement(model);
			res.getOwnedElementstates().add(elemState);
				AttributeNameToValue n2v0 = new AttributeNameToValue("executionCycle", SigPMLRTDAccessor.getexecutionCycle(model));
				elemState.getSavedRTDs().add(n2v0);
		}
		TreeIterator<EObject> allContentIt = model.eAllContents();
		while (allContentIt.hasNext()) {
			EObject elem = allContentIt.next();

			clazz =null;
			clazz = K3DslHelper.getTarget(org.eclipse.gemoc.example.moccmlsigpml.k3dsa.PlaceAspect.class);
			if (clazz.isInstance(elem)) {
				ElementState elemState = theFactory.createElementState();
				elemState.setModelElement(elem);
				res.getOwnedElementstates().add(elemState);
				AttributeNameToValue n2v0 = new AttributeNameToValue("fifo", SigPMLRTDAccessor.getfifo(elem));
				elemState.getSavedRTDs().add(n2v0);
				AttributeNameToValue n2v1 = new AttributeNameToValue("currentSize", SigPMLRTDAccessor.getcurrentSize(elem));
				elemState.getSavedRTDs().add(n2v1);
				AttributeNameToValue n2v2 = new AttributeNameToValue("isInitialized", SigPMLRTDAccessor.getisInitialized(elem));
				elemState.getSavedRTDs().add(n2v2);
			}
			clazz = K3DslHelper.getTarget(org.eclipse.gemoc.example.moccmlsigpml.k3dsa.SystemAspect.class);
			if (clazz.isInstance(elem)) {
				ElementState elemState = theFactory.createElementState();
				elemState.setModelElement(elem);
				res.getOwnedElementstates().add(elemState);
				AttributeNameToValue n2v0 = new AttributeNameToValue("sharedMemory", SigPMLRTDAccessor.getsharedMemory(elem));
				elemState.getSavedRTDs().add(n2v0);
			}
			clazz = K3DslHelper.getTarget(org.eclipse.gemoc.example.moccmlsigpml.k3dsa.OutputPortAspect.class);
			if (clazz.isInstance(elem)) {
				ElementState elemState = theFactory.createElementState();
				elemState.setModelElement(elem);
				res.getOwnedElementstates().add(elemState);
				AttributeNameToValue n2v0 = new AttributeNameToValue("sizeWritten", SigPMLRTDAccessor.getsizeWritten(elem));
				elemState.getSavedRTDs().add(n2v0);
			}
			clazz = K3DslHelper.getTarget(org.eclipse.gemoc.example.moccmlsigpml.k3dsa.AgentAspect.class);
			if (clazz.isInstance(elem)) {
				ElementState elemState = theFactory.createElementState();
				elemState.setModelElement(elem);
				res.getOwnedElementstates().add(elemState);
				AttributeNameToValue n2v0 = new AttributeNameToValue("plotter", SigPMLRTDAccessor.getplotter(elem));
				elemState.getSavedRTDs().add(n2v0);
				AttributeNameToValue n2v1 = new AttributeNameToValue("frame", SigPMLRTDAccessor.getframe(elem));
				elemState.getSavedRTDs().add(n2v1);
				AttributeNameToValue n2v2 = new AttributeNameToValue("figure", SigPMLRTDAccessor.getfigure(elem));
				elemState.getSavedRTDs().add(n2v2);
				AttributeNameToValue n2v3 = new AttributeNameToValue("hasBeenStopped", SigPMLRTDAccessor.gethasBeenStopped(elem));
				elemState.getSavedRTDs().add(n2v3);
				AttributeNameToValue n2v4 = new AttributeNameToValue("currentExecCycle", SigPMLRTDAccessor.getcurrentExecCycle(elem));
				elemState.getSavedRTDs().add(n2v4);
				AttributeNameToValue n2v5 = new AttributeNameToValue("isCurrentlyExecuting", SigPMLRTDAccessor.getisCurrentlyExecuting(elem));
				elemState.getSavedRTDs().add(n2v5);
			}
			clazz = K3DslHelper.getTarget(org.eclipse.gemoc.example.moccmlsigpml.k3dsa.InputPortAspect.class);
			if (clazz.isInstance(elem)) {
				ElementState elemState = theFactory.createElementState();
				elemState.setModelElement(elem);
				res.getOwnedElementstates().add(elemState);
				AttributeNameToValue n2v0 = new AttributeNameToValue("sizeToread", SigPMLRTDAccessor.getsizeToread(elem));
				elemState.getSavedRTDs().add(n2v0);
			}
			clazz = K3DslHelper.getTarget(org.eclipse.gemoc.example.moccmlsigpml.k3dsa.HWComputationalResourceAspect.class);
			if (clazz.isInstance(elem)) {
				ElementState elemState = theFactory.createElementState();
				elemState.setModelElement(elem);
				res.getOwnedElementstates().add(elemState);
				AttributeNameToValue n2v0 = new AttributeNameToValue("executionCycle", SigPMLRTDAccessor.getexecutionCycle(elem));
				elemState.getSavedRTDs().add(n2v0);
			}
		}
		return res;
		}

		public void restoreModelState(K3ModelState state) {
		for(ElementState elemState : state.getOwnedElementstates()) {
			for(Object o : elemState.getSavedRTDs()) {
				AttributeNameToValue n2v = (AttributeNameToValue)o;
						Method setter = null;
						setter = getSetter(n2v);
						try {
							setter.invoke(null, elemState.getModelElement(), n2v.value);
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
							e.printStackTrace();
						}
				
			}
		}
	}


	private Method getSetter(AttributeNameToValue n2v) {
		Method setter = null;
		try {
			if(n2v.value != null) {
				setter = SigPMLRTDAccessor.class.getMethod("set"+n2v.name, EObject.class, n2v.value.getClass());
			}else {
				for (Method m : SigPMLRTDAccessor.class.getMethods()) {
					if (m.getName().compareTo("set"+n2v.name) ==0 && m.getParameterCount() == 2) {
						setter= m;
						break;
					}
				}
			}
			return setter;
		} catch (NoSuchMethodException | SecurityException | IllegalArgumentException e) {
			if(n2v.value != null) {
					List<Class> allTypes = getSuperClasses(n2v.value.getClass());
					allTypes.addAll(Arrays.asList(n2v.value.getClass().getInterfaces()));
					for(Class<?> c : allTypes) {
						try {
							setter = SigPMLRTDAccessor.class.getMethod("set"+n2v.name, EObject.class, c);
							return setter;
						} catch (NoSuchMethodException | SecurityException | IllegalArgumentException e1) {
						}
					}
					if (setter == null) {
						throw new RuntimeException("no method found for "+n2v.value.getClass().getName()+"::set"+n2v.name);
					}
				}
			}
			return setter;
	}
	
	public static List<Class> getSuperClasses(Class c) {
		List<Class> r = new ArrayList<>();
		List<Class> q = new ArrayList<>();
		q.add(c);
		while (!q.isEmpty()) {
			c = q.remove(0);
			r.add(c);
			if (c.getSuperclass() != null) {
				q.add(c.getSuperclass());
			}
			for (Class i : c.getInterfaces()) {
				q.add(i);
			}
		}
		return r;
	}
};