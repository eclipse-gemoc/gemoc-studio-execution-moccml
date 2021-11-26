/* GENERATED FILE, do not modify manually                                                    *
 * If you need to modify it, copy it first */
package oncurrenttfsm.xdsml.api.impl;
import java.io.Serializable;
import java.lang.reflect.Method;
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
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.dsa.helper.IK3ModelStateHelper;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.utils.Copier;
import org.eclipse.gemoc.executionframework.engine.commons.K3DslHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class OncurrentTFSMModelStateHelper implements IK3ModelStateHelper{
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
				clazz = K3DslHelper.getTarget(org.eclipse.gemoc.example.moccml.tfsm.k3dsa.aspect.IntegerVariableAspect.class);
				if (clazz.isInstance(elem)) {
					ElementState elemState = theFactory.createElementState();
					elemState.setModelElement(elem);
					res.getOwnedElementstates().add(elemState);
					Object propertyValue = null;
					// Annotation CONTAINER
					propertyValue = OncurrentTFSMRTDAccessor.saveProperty_currentValue((org.eclipse.gemoc.example.moccml.tfsm.tfsm.IntegerVariable)elem);
					AttributeNameToValue n2v0 = new AttributeNameToValue("currentValue", propertyValue);
					elemState.getSavedRTDs().add(n2v0);
				}
				clazz = K3DslHelper.getTarget(org.eclipse.gemoc.example.moccml.tfsm.k3dsa.aspect.BooleanVariableAspect.class);
				if (clazz.isInstance(elem)) {
					ElementState elemState = theFactory.createElementState();
					elemState.setModelElement(elem);
					res.getOwnedElementstates().add(elemState);
					Object propertyValue = null;
					// Annotation CONTAINER
					propertyValue = OncurrentTFSMRTDAccessor.saveProperty_currentValue((org.eclipse.gemoc.example.moccml.tfsm.tfsm.BooleanVariable)elem);
					AttributeNameToValue n2v0 = new AttributeNameToValue("currentValue", propertyValue);
					elemState.getSavedRTDs().add(n2v0);
				}
				clazz = K3DslHelper.getTarget(org.eclipse.gemoc.example.moccml.tfsm.k3dsa.aspect.FSMClockAspect.class);
				if (clazz.isInstance(elem)) {
					ElementState elemState = theFactory.createElementState();
					elemState.setModelElement(elem);
					res.getOwnedElementstates().add(elemState);
					Object propertyValue = null;
					if (allRTDs) {  //property not in state space:numberOfTicks
					// Annotation CONTAINER
						propertyValue = OncurrentTFSMRTDAccessor.saveProperty_numberOfTicks((org.eclipse.gemoc.example.moccml.tfsm.tfsm.FSMClock)elem);
						AttributeNameToValue n2v0 = new AttributeNameToValue("numberOfTicks", propertyValue);
						elemState.getSavedRTDs().add(n2v0);
					}
				}
				clazz = K3DslHelper.getTarget(org.eclipse.gemoc.example.moccml.tfsm.k3dsa.aspect.TFSMAspect.class);
				if (clazz.isInstance(elem)) {
					ElementState elemState = theFactory.createElementState();
					elemState.setModelElement(elem);
					res.getOwnedElementstates().add(elemState);
					Object propertyValue = null;
					// Annotation REFERENCE
					propertyValue = OncurrentTFSMRTDAccessor.saveProperty_currentState((org.eclipse.gemoc.example.moccml.tfsm.tfsm.TFSM)elem);
					AttributeNameToValue n2v0 = new AttributeNameToValue("currentState", propertyValue);
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
				Method setter = null;
				setter = getRestorePropertySetter(elemState.getModelElement().getClass(), n2v);
				try {
					setter.invoke(null, elemState.getModelElement(), n2v.value);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
				
			}
		}
	}


	private Method getRestorePropertySetter(Class<?> targetClass, AttributeNameToValue n2v) {
		Method setter = null;
		try {
			for(Method m2 : OncurrentTFSMRTDAccessor.class.getMethods()) {
				if(m2.getName().equals("restoreProperty_"+n2v.name) && m2.getParameterTypes().length == 2) {
					if(m2.getParameterTypes()[0].isAssignableFrom(targetClass) &&
							(n2v.value == null || m2.getParameterTypes()[1].isAssignableFrom(n2v.value.getClass()))	) {
						setter = m2;
						break;
					}
				}
			}
			if (setter == null) {
				throw new RuntimeException("no method found for restoreProperty_"+n2v.name+"("+targetClass+", "+n2v.value.getClass().getName()+")");
			}
			return setter;
		} catch (SecurityException | IllegalArgumentException e) {
			throw new RuntimeException("no method found for set"+n2v.name+"("+targetClass+", "+n2v.value.getClass().getName()+")");
		}
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