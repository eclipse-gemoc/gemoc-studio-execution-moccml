package org.eclipse.gemoc.example.moccml.tfsm.k3dsa.aspect

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.EvaluateGuard
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.EventGuard
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.FSMClock
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.FSMEvent
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.Guard
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.NamedElement
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.State
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.TFSM
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.TemporalGuard
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.TimedSystem
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.Transition
import org.eclipse.gemoc.example.moccml.tfsm.k3dsa.GroovyRunner


import static extension org.eclipse.gemoc.example.moccml.tfsm.k3dsa.aspect.TFSMAspect.*
import groovy.lang.GroovyShell
import java.util.Map
import groovy.lang.Binding 

import static extension org.eclipse.gemoc.example.moccml.tfsm.k3dsa.aspect.FSMClockAspect.*


/*import static extension org.eclipse.gemoc.example.moccml.tfsm.k3dsa.aspect.StateAspect.*
import static extension org.eclipse.gemoc.example.moccml.tfsm.k3dsa.aspect.TransitionAspect.*
import static extension org.eclipse.gemoc.example.moccml.tfsm.k3dsa.aspect.NamedElementAspect.*
import static extension org.eclipse.gemoc.example.moccml.tfsm.k3dsa.aspect.GuardAspect.*
import static extension org.eclipse.gemoc.example.moccml.tfsm.k3dsa.aspect.TemporalGuardAspect.*
import static extension org.eclipse.gemoc.example.moccml.tfsm.k3dsa.aspect.EventGuardAspect.*
import static extension org.eclipse.gemoc.example.moccml.tfsm.k3dsa.aspect.FSMEventAspect.*
import static extension org.eclipse.gemoc.example.moccml.tfsm.k3dsa.aspect.TimedSystemAspect.*
import static extension org.eclipse.gemoc.example.moccml.tfsm.k3dsa.aspect.EvaluateGuardAspect.*
*/

@Aspect(className=TFSM)
class TFSMAspect extends NamedElementAspect {
	
	public State currentState;

	def public String initialize() {
		if (_self.currentState === null) {

			_self.currentState = _self.initialState;
		}
		println("[" + _self.getClass().getSimpleName() + ":" + _self.getName() + ".Init()]Initialized " + _self.name);
	}
	
	def public void changeCurrentState(State newState)
	{
		_self.currentState = newState
	}
		
}

@Aspect(className=State)
class StateAspect extends NamedElementAspect {
	def public String onEnter() {
		_self.owningFSM.currentState = _self;
		println("[" + _self.getClass().getSimpleName() + ":" + _self.getName() + ".onEnter()]Entering " + _self.name);
		
	}

	def public String onLeave() {
		println("[" + _self.getClass().getSimpleName() + ":" + _self.getName() + ".onLeave()]Leaving " + _self.name);
	}
}

@Aspect(className=Transition)
class TransitionAspect extends NamedElementAspect {
	def public String fire() {
		if(_self.action!= null && !_self.action.empty){		
			//GroovyRunner.executeScript(_self.action, _self);
			var Object res;
			try {	
				// add variables _self and _this for use in the expression
				val binding = new Binding
				binding.setVariable("_self", _self)
				binding.setVariable("_this", _self)		
				val ucl = EvaluateGuardAspect.classLoader
				val shell = new GroovyShell(ucl, binding)
		
				res = shell.evaluate(_self.action) as Map<String, Object>
		
			} catch (org.codehaus.groovy.control.MultipleCompilationErrorsException cnfe) {
				println("Failed to call Groovy script" + cnfe.message)
				cnfe.printStackTrace
			}	
		}
		_self.source.owningFSM.currentState = null
		println("[" + _self.getClass().getSimpleName() + ":" + _self.getName() + ".fire()]Fired " + _self.name + " -> " +
			_self.action)
	}
}

@Aspect(className=NamedElement)
class NamedElementAspect {
}

@Aspect(className=Guard)
abstract class GuardAspect extends NamedElementAspect {
}

@Aspect(className=TemporalGuard)
class TemporalGuardAspect extends GuardAspect {
}

@Aspect(className=EventGuard)
class EventGuardAspect extends GuardAspect {
}

@Aspect(className=FSMEvent)
class FSMEventAspect extends NamedElementAspect {
	def public String occurs() {
		println("[" + _self.getClass().getSimpleName() + ":" + _self.getName() + ".occurs()]Occured " )
	}
}

@Aspect(className=FSMClock)
class FSMClockAspect extends NamedElementAspect {
	
	public int numberOfTicks

	// Clock tick
	def public String ticks() {
		_self.numberOfTicks = _self.numberOfTicks + 1
		
		println("[" + _self.getClass().getSimpleName() + ":" + _self.getName() + ".ticks()]New number of ticks : " +
			_self.numberOfTicks.toString())
	}
}

@Aspect(className=TimedSystem)
class TimedSystemAspect extends NamedElementAspect {
	def public String initialize() {
		_self.tfsms.forEach[tfsm | tfsm.currentState = null]
		_self.globalClocks.forEach[globalClock | globalClock.numberOfTicks = 0]
		
		println("[" + _self.getClass().getSimpleName() + ":" + _self.getName() + ".Init()]Initialized " + _self.name);
	}
}

@Aspect(className=EvaluateGuard)
class EvaluateGuardAspect extends GuardAspect {
	def public boolean evaluate() {
		var Object res;
		try {	
			// add variables _self and _this for use in the expression
			val binding = new Binding
			binding.setVariable("_self", _self)
			binding.setVariable("_this", _self)		
			val ucl = EvaluateGuardAspect.classLoader
			val shell = new GroovyShell(ucl, binding)
	
			res = shell.evaluate(_self.condition)
	
		} catch (org.codehaus.groovy.control.MultipleCompilationErrorsException cnfe) {
			println("Failed to call Groovy script" + cnfe.message)
			cnfe.printStackTrace
		}

		return res as Boolean;
	}
}
