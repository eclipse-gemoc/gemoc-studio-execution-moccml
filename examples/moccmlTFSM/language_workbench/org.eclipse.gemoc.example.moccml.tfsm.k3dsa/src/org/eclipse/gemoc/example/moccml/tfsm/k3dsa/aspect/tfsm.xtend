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
import static extension org.eclipse.gemoc.example.moccml.tfsm.k3dsa.aspect.VariableAspect.*
import groovy.lang.GroovyShell
import java.util.Map
import groovy.lang.Binding 

import static extension org.eclipse.gemoc.example.moccml.tfsm.k3dsa.aspect.FSMClockAspect.*
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.Variable
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.Value
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.IntegerVariable
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.IntegerValue
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.BooleanVariable
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.IntegerCalculationExpression
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.IntegerCalculationOperator
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.IntegerComparisonExpression
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.IntegerComparisonOperator
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.BooleanValue
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.BooleanUnaryExpression
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.BooleanBinaryExpression
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.BooleanBinaryOperator
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.Expression
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.BooleanUnaryOperator
import static extension org.eclipse.gemoc.example.moccml.tfsm.k3dsa.aspect.ExpressionAspect.*
import static extension org.eclipse.gemoc.example.moccml.tfsm.k3dsa.aspect.IntegerVariableAspect.*
import static extension org.eclipse.gemoc.example.moccml.tfsm.k3dsa.aspect.BooleanVariableAspect.*
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.OpaqueBooleanExpression
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.OpaqueIntegerExpression
//import fr.inria.diverse.k3.al.annotationprocessor.coordination.Time
//import fr.inria.diverse.k3.al.annotationprocessor.coordination.Input
//import fr.inria.diverse.k3.al.annotationprocessor.coordination.Output

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
		if(_self.action!== null && !_self.action.empty){		
			//GroovyRunner.executeScript(_self.action, _self);
			var Object res;
			try {	
				// add variables _self and _this for use in the expression
				val binding = new Binding
				binding.setVariable("_self", _self)
				binding.setVariable("_this", _self)		
				val ucl = EvaluateGuardAspect.classLoader
				val shell = new GroovyShell(ucl, binding)
		
//				res = shell.evaluate(_self.action) as Map<String, Object>
				for(Expression e : _self.action){
					e.execute()
				}
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
	
	//@Time 
	public Integer numberOfTicks = 0 //MUST be initialized for coordination

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
		_self.ownedVars.forEach[_var | _var.init()]
		println("[" + _self.getClass().getSimpleName() + ":" + _self.getName() + ".Init()]Initialized " + _self.name);
	}
}

@Aspect(className=EvaluateGuard)
class EvaluateGuardAspect extends GuardAspect {
	def boolean evaluate() {
		var Object res;
			res = _self.condition.evaluate()
		return res as Boolean;
	}
}











@Aspect(className=Expression)
class ExpressionAspect {
	def int execute() {
		return 0
	}
	
	def boolean evaluate() {
		return true
	}
	
}

@Aspect(className=Variable)
class VariableAspect {
	def void init() {
	}
	
	def String print() {
	}
}

@Aspect(className=IntegerVariable)
class IntegerVariableAspect extends VariableAspect {
	
//	@Input(cond="true")
//	@Output(cond="true")
	public Integer currentValue = 0
	
	@OverrideAspectMethod
	def void init() {
		_self.currentValue = _self.initialValue
	}
	
	@OverrideAspectMethod
	def String print() {
		var text = new StringBuffer();
		text.append(_self.getName());
		text.append(" = ");
		text.append(_self.currentValue);
		return text.toString();
	}
}

@Aspect(className=BooleanVariable)
class BooleanVariableAspect extends VariableAspect {

//	@Input(cond="true")
//	@Output(cond="true")
	public Boolean currentValue = false;
	
	@OverrideAspectMethod
	def void init() {
		_self.currentValue = _self.initialValue
	}
	
	@OverrideAspectMethod
	def String print() {
		var text = new StringBuffer();
		text.append(_self.getName());
		text.append(" = ");
		text.append(_self.currentValue);
		return text.toString();
	}

}



@Aspect(className=IntegerCalculationExpression)
class IntegerCalculationExpressionAspect extends ExpressionAspect {
	
	@OverrideAspectMethod
	def int execute() {
		if (_self.operator.value == IntegerCalculationOperator.ADD_VALUE) {
			return _self.operand1.currentValue + _self.operand2.currentValue
		} else if (_self.operator.value == IntegerCalculationOperator.SUBRACT_VALUE) {
			return _self.operand1.currentValue - _self.operand2.currentValue
		}
	return 0
	}
}

@Aspect(className=IntegerComparisonExpression)
class IntegerComparisonExpressionAspect extends ExpressionAspect {
	
	@OverrideAspectMethod
	def boolean evaluate() {
		if (_self.operator.value == IntegerComparisonOperator.EQUALS_VALUE) {
			return _self.operand1.currentValue == _self.operand2.currentValue
		} else if (_self.operator.value == IntegerComparisonOperator.GREATER_EQUALS_VALUE) {
			return _self.operand1.currentValue >= _self.operand2.currentValue
		} else if (_self.operator.value == IntegerComparisonOperator.GREATER_VALUE) {
			return _self.operand1.currentValue > _self.operand2.currentValue
		} else if (_self.operator.value == IntegerComparisonOperator.SMALLER_EQUALS_VALUE) {
			return _self.operand1.currentValue <= _self.operand2.currentValue
		} else if (_self.operator.value == IntegerComparisonOperator.SMALLER_VALUE) {
			return _self.operand1.currentValue < _self.operand2.currentValue
		}
		return true
	}
}

@Aspect(className=BooleanUnaryExpression)
class BooleanUnaryExpressionAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def boolean evaluate() {
		if (_self.operator.value == BooleanUnaryOperator.NOT_VALUE) {
			return !_self.operand.currentValue
		}
		return true
	}
}
 
@Aspect(className=BooleanBinaryExpression)
class BooleanBinaryExpressionAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def boolean evaluate() {
		if (_self.operator.value == BooleanBinaryOperator.AND_VALUE) {
			return _self.operand1.currentValue && _self.operand2.currentValue
		} else if (_self.operator.value == BooleanBinaryOperator.OR_VALUE) {
			return _self.operand1.currentValue || _self.operand2.currentValue
		}
	return true
	}
}

@Aspect(className=OpaqueBooleanExpression)
class OpaqueBooleanExpressionAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def boolean evaluate() {
		var Object res;
		try {	
			// add variables _self and _this for use in the expression
			val binding = new Binding
			binding.setVariable("_self", _self)
			binding.setVariable("_this", _self)	
			
			for(Variable v : (_self.eContainer.eContainer as TimedSystem).ownedVars){
				binding.setVariable(v.name, v)	
			}
				
			val ucl = EvaluateGuardAspect.classLoader
			val shell = new GroovyShell(ucl, binding)
	
			res = shell.evaluate(_self.value)
		} catch (org.codehaus.groovy.control.MultipleCompilationErrorsException cnfe) {
			println("Failed to call Groovy script" + cnfe.message)
			cnfe.printStackTrace
		}
	return res as Boolean
	}
}

@Aspect(className=OpaqueIntegerExpression)
class OpaqueIntegerExpressionAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def int execute() {
		var Object res;
		try {	
			// add variables _self and _this for use in the expression
			val binding = new Binding
			binding.setVariable("_self", _self)
			binding.setVariable("_this", _self)	
			
			for(Variable v : (_self.eContainer.eContainer as TimedSystem).ownedVars){
				binding.setVariable(v.name, v)	
			}
				
			val ucl = EvaluateGuardAspect.classLoader
			val shell = new GroovyShell(ucl, binding)
	
			res = shell.evaluate(_self.value)
		} catch (org.codehaus.groovy.control.MultipleCompilationErrorsException cnfe) {
			println("Failed to call Groovy script" + cnfe.message)
			cnfe.printStackTrace
		}
	return res as Integer
	}
}