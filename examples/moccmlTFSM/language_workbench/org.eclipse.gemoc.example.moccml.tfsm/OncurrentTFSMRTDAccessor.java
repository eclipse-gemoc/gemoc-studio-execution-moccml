/* GENERATED FILE, do not modify manually                                                    *
 * If you need to modify it, copy it first */
package oncurrenttfsm.xdsml.api.impl;
import org.eclipse.emf.ecore.EObject;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.lang.reflect.Method;
import org.eclipse.gemoc.executionframework.engine.commons.K3DslHelper;


public class OncurrentTFSMRTDAccessor {
	public static java.lang.Integer getNumberOfTicks(org.eclipse.gemoc.example.moccml.tfsm.tfsm.FSMClock eObject) {
		return (java.lang.Integer)  getAspectProperty(eObject, "ConcurrentTFSM", "org.eclipse.gemoc.example.moccml.tfsm.k3dsa.aspect.FSMClockAspect", "numberOfTicks");
	}
	public static boolean setNumberOfTicks(org.eclipse.gemoc.example.moccml.tfsm.tfsm.FSMClock eObject, java.lang.Integer newValue) {
		return setAspectProperty(eObject, "ConcurrentTFSM", "org.eclipse.gemoc.example.moccml.tfsm.k3dsa.aspect.FSMClockAspect", "numberOfTicks", newValue);
	}
	public static org.eclipse.gemoc.example.moccml.tfsm.tfsm.State getCurrentState(org.eclipse.gemoc.example.moccml.tfsm.tfsm.TFSM eObject) {
		return (org.eclipse.gemoc.example.moccml.tfsm.tfsm.State)  getAspectProperty(eObject, "ConcurrentTFSM", "org.eclipse.gemoc.example.moccml.tfsm.k3dsa.aspect.TFSMAspect", "currentState");
	}
	public static boolean setCurrentState(org.eclipse.gemoc.example.moccml.tfsm.tfsm.TFSM eObject, org.eclipse.gemoc.example.moccml.tfsm.tfsm.State newValue) {
		return setAspectProperty(eObject, "ConcurrentTFSM", "org.eclipse.gemoc.example.moccml.tfsm.k3dsa.aspect.TFSMAspect", "currentState", newValue);
	}
	public static java.lang.Boolean getCurrentValue(org.eclipse.gemoc.example.moccml.tfsm.tfsm.BooleanVariable eObject) {
		return (java.lang.Boolean)  getAspectProperty(eObject, "ConcurrentTFSM", "org.eclipse.gemoc.example.moccml.tfsm.k3dsa.aspect.BooleanVariableAspect", "currentValue");
	}
	public static boolean setCurrentValue(org.eclipse.gemoc.example.moccml.tfsm.tfsm.BooleanVariable eObject, java.lang.Boolean newValue) {
		return setAspectProperty(eObject, "ConcurrentTFSM", "org.eclipse.gemoc.example.moccml.tfsm.k3dsa.aspect.BooleanVariableAspect", "currentValue", newValue);
	}
	public static java.lang.Integer getCurrentValue(org.eclipse.gemoc.example.moccml.tfsm.tfsm.IntegerVariable eObject) {
		return (java.lang.Integer)  getAspectProperty(eObject, "ConcurrentTFSM", "org.eclipse.gemoc.example.moccml.tfsm.k3dsa.aspect.IntegerVariableAspect", "currentValue");
	}
	public static boolean setCurrentValue(org.eclipse.gemoc.example.moccml.tfsm.tfsm.IntegerVariable eObject, java.lang.Integer newValue) {
		return setAspectProperty(eObject, "ConcurrentTFSM", "org.eclipse.gemoc.example.moccml.tfsm.k3dsa.aspect.IntegerVariableAspect", "currentValue", newValue);
	}

	public static Object getAspectProperty(EObject eObject, String languageName, String aspectName, String propertyName) {
		List<Class<?>> aspects = K3DslHelper.getAspectsOn(languageName, eObject.getClass());
		Class<?> aspect = null;
		for (Class<?> a : aspects) {
			try {
				if (Class.forName(aspectName).isAssignableFrom(a)) {
					aspect = a;
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		if (aspect == null) {
			return null;
		}
		Object res = null;
		 try {
			res = aspect.getDeclaredMethod(propertyName, ((fr.inria.diverse.k3.al.annotationprocessor.Aspect)aspect.getAnnotations()[0]).className()).invoke(eObject, eObject);
			if (res != null) {
				return res;
			}else {
				return null;
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	public static boolean setAspectProperty(EObject eObject, String languageName, String aspectName, String propertyName, Object newValue) {
		List<Class<?>> aspects = K3DslHelper.getAspectsOn(languageName, eObject.getClass());
		Class<?> aspect = null;
		for (Class<?> a : aspects) {
			try {
				if (Class.forName(aspectName).isAssignableFrom(a)) {
					aspect = a;
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return false;
			}
		}
		if (aspect == null) {
			return false;
		}
		final Class<?> targetClass = ((fr.inria.diverse.k3.al.annotationprocessor.Aspect)aspect.getAnnotations()[0]).className();
			 try {
				 
				 aspect.getMethod(propertyName, targetClass, newValue.getClass()).invoke(eObject, eObject, newValue);
				return true;
				} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					Method m = null;
					for(Class<?> c : newValue.getClass().getInterfaces()) {
						try {
							aspect.getMethod(propertyName, targetClass, c).invoke(eObject, eObject, newValue);
							return true;
						} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
						}
						if (m == null) {
							throw new RuntimeException("not method found for "+((fr.inria.diverse.k3.al.annotationprocessor.Aspect)aspect.getAnnotations()[0]).className()+"::set"+propertyName);
						}
					}
				}
			return false;
	}
};