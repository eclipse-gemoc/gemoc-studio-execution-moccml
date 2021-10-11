/* GENERATED FILE, do not modify manually                                                    *
 * If you need to modify it, copy it first */
package sigpml.xdsml.api.impl;
import org.eclipse.emf.ecore.EObject;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.lang.reflect.Method;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.utils.Copier;
import org.eclipse.gemoc.executionframework.engine.commons.K3DslHelper;


public class SigPMLRTDAccessor {
  public static org.eclipse.emf.common.util.EList getfifo(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place eObject) {
     org.eclipse.emf.common.util.EList theProperty = (org.eclipse.emf.common.util.EList)getAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.PlaceAspect", "fifo");
		return theProperty;
}
  public static org.eclipse.emf.common.util.EList saveProperty_fifo(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place eObject) {
		org.eclipse.emf.common.util.EList propertyValue = (org.eclipse.emf.common.util.EList)getAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.PlaceAspect", "fifo");
		propertyValue = propertyValue == null ? null : (org.eclipse.emf.common.util.EList)Copier.clone(propertyValue);
		return propertyValue;
}
	public static boolean setfifo(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place eObject, org.eclipse.emf.common.util.EList newValue) {
		return setAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.PlaceAspect", "fifo", newValue);
	}
	public static boolean restoreProperty_fifo(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place eObject, org.eclipse.emf.common.util.EList newValue) {
		org.eclipse.emf.common.util.EList propertyValue = newValue;
		propertyValue = propertyValue == null ? null : (org.eclipse.emf.common.util.EList)Copier.clone(propertyValue);
		return setAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.PlaceAspect", "fifo", propertyValue);
	}
  public static java.lang.Integer getcurrentSize(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place eObject) {
     java.lang.Integer theProperty = (java.lang.Integer)getAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.PlaceAspect", "currentSize");
		return theProperty;
}
  public static java.lang.Integer saveProperty_currentSize(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place eObject) {
		java.lang.Integer propertyValue = (java.lang.Integer)getAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.PlaceAspect", "currentSize");
		propertyValue = propertyValue == null ? null : (java.lang.Integer)Copier.clone(propertyValue);
		return propertyValue;
}
	public static boolean setcurrentSize(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place eObject, java.lang.Integer newValue) {
		return setAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.PlaceAspect", "currentSize", newValue);
	}
	public static boolean restoreProperty_currentSize(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place eObject, java.lang.Integer newValue) {
		java.lang.Integer propertyValue = newValue;
		propertyValue = propertyValue == null ? null : (java.lang.Integer)Copier.clone(propertyValue);
		return setAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.PlaceAspect", "currentSize", propertyValue);
	}
  public static java.lang.Boolean getisInitialized(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place eObject) {
     java.lang.Boolean theProperty = (java.lang.Boolean)getAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.PlaceAspect", "isInitialized");
		return theProperty;
}
  public static java.lang.Boolean saveProperty_isInitialized(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place eObject) {
		java.lang.Boolean propertyValue = (java.lang.Boolean)getAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.PlaceAspect", "isInitialized");
		propertyValue = propertyValue == null ? null : (java.lang.Boolean)Copier.clone(propertyValue);
		return propertyValue;
}
	public static boolean setisInitialized(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place eObject, java.lang.Boolean newValue) {
		return setAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.PlaceAspect", "isInitialized", newValue);
	}
	public static boolean restoreProperty_isInitialized(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place eObject, java.lang.Boolean newValue) {
		java.lang.Boolean propertyValue = newValue;
		propertyValue = propertyValue == null ? null : (java.lang.Boolean)Copier.clone(propertyValue);
		return setAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.PlaceAspect", "isInitialized", propertyValue);
	}
  public static com.google.common.collect.LinkedListMultimap getsharedMemory(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.System eObject) {
     com.google.common.collect.LinkedListMultimap theProperty = (com.google.common.collect.LinkedListMultimap)getAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.SystemAspect", "sharedMemory");
		return theProperty;
}
  public static com.google.common.collect.LinkedListMultimap saveProperty_sharedMemory(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.System eObject) {
		com.google.common.collect.LinkedListMultimap propertyValue = (com.google.common.collect.LinkedListMultimap)getAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.SystemAspect", "sharedMemory");
		propertyValue = propertyValue == null ? null : (com.google.common.collect.LinkedListMultimap)Copier.clone(propertyValue);
		return propertyValue;
}
	public static boolean setsharedMemory(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.System eObject, com.google.common.collect.LinkedListMultimap newValue) {
		return setAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.SystemAspect", "sharedMemory", newValue);
	}
	public static boolean restoreProperty_sharedMemory(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.System eObject, com.google.common.collect.LinkedListMultimap newValue) {
		com.google.common.collect.LinkedListMultimap propertyValue = newValue;
		propertyValue = propertyValue == null ? null : (com.google.common.collect.LinkedListMultimap)Copier.clone(propertyValue);
		return setAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.SystemAspect", "sharedMemory", propertyValue);
	}
  public static java.lang.Integer getsizeWritten(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.OutputPort eObject) {
     java.lang.Integer theProperty = (java.lang.Integer)getAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.OutputPortAspect", "sizeWritten");
		return theProperty;
}
  public static java.lang.Integer saveProperty_sizeWritten(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.OutputPort eObject) {
		java.lang.Integer propertyValue = (java.lang.Integer)getAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.OutputPortAspect", "sizeWritten");
		propertyValue = propertyValue == null ? null : (java.lang.Integer)Copier.clone(propertyValue);
		return propertyValue;
}
	public static boolean setsizeWritten(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.OutputPort eObject, java.lang.Integer newValue) {
		return setAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.OutputPortAspect", "sizeWritten", newValue);
	}
	public static boolean restoreProperty_sizeWritten(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.OutputPort eObject, java.lang.Integer newValue) {
		java.lang.Integer propertyValue = newValue;
		propertyValue = propertyValue == null ? null : (java.lang.Integer)Copier.clone(propertyValue);
		return setAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.OutputPortAspect", "sizeWritten", propertyValue);
	}
  public static cnrs.luchogie.up.SwingPlotter getplotter(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent eObject) {
     cnrs.luchogie.up.SwingPlotter theProperty = (cnrs.luchogie.up.SwingPlotter)getAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.AgentAspect", "plotter");
		return theProperty;
}
  public static cnrs.luchogie.up.SwingPlotter saveProperty_plotter(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent eObject) {
		cnrs.luchogie.up.SwingPlotter propertyValue = (cnrs.luchogie.up.SwingPlotter)getAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.AgentAspect", "plotter");
		// Reference property
		return propertyValue;
}
	public static boolean setplotter(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent eObject, cnrs.luchogie.up.SwingPlotter newValue) {
		return setAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.AgentAspect", "plotter", newValue);
	}
	public static boolean restoreProperty_plotter(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent eObject, cnrs.luchogie.up.SwingPlotter newValue) {
		cnrs.luchogie.up.SwingPlotter propertyValue = newValue;
		// Reference property
		return setAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.AgentAspect", "plotter", propertyValue);
	}
  public static javax.swing.JFrame getframe(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent eObject) {
     javax.swing.JFrame theProperty = (javax.swing.JFrame)getAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.AgentAspect", "frame");
		return theProperty;
}
  public static javax.swing.JFrame saveProperty_frame(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent eObject) {
		javax.swing.JFrame propertyValue = (javax.swing.JFrame)getAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.AgentAspect", "frame");
		// Reference property
		return propertyValue;
}
	public static boolean setframe(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent eObject, javax.swing.JFrame newValue) {
		return setAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.AgentAspect", "frame", newValue);
	}
	public static boolean restoreProperty_frame(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent eObject, javax.swing.JFrame newValue) {
		javax.swing.JFrame propertyValue = newValue;
		// Reference property
		return setAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.AgentAspect", "frame", propertyValue);
	}
  public static cnrs.luchogie.up.data.Figure getfigure(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent eObject) {
     cnrs.luchogie.up.data.Figure theProperty = (cnrs.luchogie.up.data.Figure)getAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.AgentAspect", "figure");
		return theProperty;
}
  public static cnrs.luchogie.up.data.Figure saveProperty_figure(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent eObject) {
		cnrs.luchogie.up.data.Figure propertyValue = (cnrs.luchogie.up.data.Figure)getAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.AgentAspect", "figure");
		// Reference property
		return propertyValue;
}
	public static boolean setfigure(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent eObject, cnrs.luchogie.up.data.Figure newValue) {
		return setAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.AgentAspect", "figure", newValue);
	}
	public static boolean restoreProperty_figure(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent eObject, cnrs.luchogie.up.data.Figure newValue) {
		cnrs.luchogie.up.data.Figure propertyValue = newValue;
		// Reference property
		return setAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.AgentAspect", "figure", propertyValue);
	}
  public static java.lang.Boolean gethasBeenStopped(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent eObject) {
     java.lang.Boolean theProperty = (java.lang.Boolean)getAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.AgentAspect", "hasBeenStopped");
		return theProperty;
}
  public static java.lang.Boolean saveProperty_hasBeenStopped(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent eObject) {
		java.lang.Boolean propertyValue = (java.lang.Boolean)getAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.AgentAspect", "hasBeenStopped");
		propertyValue = propertyValue == null ? null : (java.lang.Boolean)Copier.clone(propertyValue);
		return propertyValue;
}
	public static boolean sethasBeenStopped(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent eObject, java.lang.Boolean newValue) {
		return setAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.AgentAspect", "hasBeenStopped", newValue);
	}
	public static boolean restoreProperty_hasBeenStopped(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent eObject, java.lang.Boolean newValue) {
		java.lang.Boolean propertyValue = newValue;
		propertyValue = propertyValue == null ? null : (java.lang.Boolean)Copier.clone(propertyValue);
		return setAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.AgentAspect", "hasBeenStopped", propertyValue);
	}
  public static java.lang.Integer getcurrentExecCycle(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent eObject) {
     java.lang.Integer theProperty = (java.lang.Integer)getAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.AgentAspect", "currentExecCycle");
		return theProperty;
}
  public static java.lang.Integer saveProperty_currentExecCycle(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent eObject) {
		java.lang.Integer propertyValue = (java.lang.Integer)getAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.AgentAspect", "currentExecCycle");
		propertyValue = propertyValue == null ? null : (java.lang.Integer)Copier.clone(propertyValue);
		return propertyValue;
}
	public static boolean setcurrentExecCycle(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent eObject, java.lang.Integer newValue) {
		return setAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.AgentAspect", "currentExecCycle", newValue);
	}
	public static boolean restoreProperty_currentExecCycle(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent eObject, java.lang.Integer newValue) {
		java.lang.Integer propertyValue = newValue;
		propertyValue = propertyValue == null ? null : (java.lang.Integer)Copier.clone(propertyValue);
		return setAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.AgentAspect", "currentExecCycle", propertyValue);
	}
  public static java.lang.Boolean getisCurrentlyExecuting(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent eObject) {
     java.lang.Boolean theProperty = (java.lang.Boolean)getAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.AgentAspect", "isCurrentlyExecuting");
		return theProperty;
}
  public static java.lang.Boolean saveProperty_isCurrentlyExecuting(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent eObject) {
		java.lang.Boolean propertyValue = (java.lang.Boolean)getAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.AgentAspect", "isCurrentlyExecuting");
		propertyValue = propertyValue == null ? null : (java.lang.Boolean)Copier.clone(propertyValue);
		return propertyValue;
}
	public static boolean setisCurrentlyExecuting(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent eObject, java.lang.Boolean newValue) {
		return setAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.AgentAspect", "isCurrentlyExecuting", newValue);
	}
	public static boolean restoreProperty_isCurrentlyExecuting(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent eObject, java.lang.Boolean newValue) {
		java.lang.Boolean propertyValue = newValue;
		propertyValue = propertyValue == null ? null : (java.lang.Boolean)Copier.clone(propertyValue);
		return setAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.AgentAspect", "isCurrentlyExecuting", propertyValue);
	}
  public static java.lang.Integer getsizeToread(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.InputPort eObject) {
     java.lang.Integer theProperty = (java.lang.Integer)getAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.InputPortAspect", "sizeToread");
		return theProperty;
}
  public static java.lang.Integer saveProperty_sizeToread(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.InputPort eObject) {
		java.lang.Integer propertyValue = (java.lang.Integer)getAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.InputPortAspect", "sizeToread");
		propertyValue = propertyValue == null ? null : (java.lang.Integer)Copier.clone(propertyValue);
		return propertyValue;
}
	public static boolean setsizeToread(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.InputPort eObject, java.lang.Integer newValue) {
		return setAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.InputPortAspect", "sizeToread", newValue);
	}
	public static boolean restoreProperty_sizeToread(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.InputPort eObject, java.lang.Integer newValue) {
		java.lang.Integer propertyValue = newValue;
		propertyValue = propertyValue == null ? null : (java.lang.Integer)Copier.clone(propertyValue);
		return setAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.InputPortAspect", "sizeToread", propertyValue);
	}
  public static java.lang.Integer getexecutionCycle(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWComputationalResource eObject) {
     java.lang.Integer theProperty = (java.lang.Integer)getAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.HWComputationalResourceAspect", "executionCycle");
		return theProperty;
}
  public static java.lang.Integer saveProperty_executionCycle(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWComputationalResource eObject) {
		java.lang.Integer propertyValue = (java.lang.Integer)getAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.HWComputationalResourceAspect", "executionCycle");
		propertyValue = propertyValue == null ? null : (java.lang.Integer)Copier.clone(propertyValue);
		return propertyValue;
}
	public static boolean setexecutionCycle(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWComputationalResource eObject, java.lang.Integer newValue) {
		return setAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.HWComputationalResourceAspect", "executionCycle", newValue);
	}
	public static boolean restoreProperty_executionCycle(org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWComputationalResource eObject, java.lang.Integer newValue) {
		java.lang.Integer propertyValue = newValue;
		propertyValue = propertyValue == null ? null : (java.lang.Integer)Copier.clone(propertyValue);
		return setAspectProperty(eObject, "xSigPML", "org.eclipse.gemoc.example.moccmlsigpml.k3dsa.HWComputationalResourceAspect", "executionCycle", propertyValue);
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
			return res;
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
		 Method m = getSetter(propertyName,newValue,aspect);
		 try {
			m.invoke(eObject, eObject, newValue);
			return true;
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}			
		return false;
}
	
	private static Method getSetter(String propertyName, Object value, Class<?> aspect) {
		Method setter = null;
		try {
			if(value != null) {
				setter = aspect.getMethod(propertyName, ((fr.inria.diverse.k3.al.annotationprocessor.Aspect)aspect.getAnnotations()[0]).className(), value.getClass());
			}else {
				for (Method m : aspect.getMethods()) {
					if (m.getName().compareTo(propertyName) ==0 && m.getParameterCount() == 2) {
						setter= m;
						return setter;
					}
				}
				throw new NoSuchMethodException();
			}
			return setter;
		} catch (NoSuchMethodException | SecurityException | IllegalArgumentException e) {
			
				for(Class<?> c : ((fr.inria.diverse.k3.al.annotationprocessor.Aspect)aspect.getAnnotations()[0]).getClass().getInterfaces()) {
					try {
						if(value != null) {
							setter = aspect.getMethod(propertyName, c, value.getClass());
							return setter;
						}
					} catch (NoSuchMethodException | SecurityException | IllegalArgumentException e1) {
					}
					for (Method m : aspect.getMethods()) {
						if (m.getName().compareTo(propertyName) ==0 && m.getParameterCount() == 2) {
							setter= m;
							return setter;
						}
					}
					
				}
				if (setter == null) {
					throw new RuntimeException("no method found for "+value.getClass().getName()+"::set"+propertyName);
				}
			}
		return setter;
	}};