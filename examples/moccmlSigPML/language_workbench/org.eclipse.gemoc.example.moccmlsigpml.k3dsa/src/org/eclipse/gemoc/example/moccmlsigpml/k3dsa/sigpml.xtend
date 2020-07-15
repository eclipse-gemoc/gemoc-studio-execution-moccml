package org.eclipse.gemoc.example.moccmlsigpml.k3dsa

import cnrs.luchogie.up.InteractiveSwingPlotter
import cnrs.luchogie.up.SwingPlotter
import cnrs.luchogie.up.data.Figure
import com.google.common.collect.LinkedListMultimap
import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.InitializeModel
import java.util.Map
import javax.swing.JFrame
import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.common.util.EList
import org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Agent
import org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.HWComputationalResource
import org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.InputPort
import org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.NamedElement
import org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.OutputPort
import org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Place
import org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.Port
import org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.System

import static extension org.eclipse.gemoc.example.moccmlsigpml.k3dsa.HWComputationalResourceAspect.*
import static extension org.eclipse.gemoc.example.moccmlsigpml.k3dsa.InputPortAspect.*
import static extension org.eclipse.gemoc.example.moccmlsigpml.k3dsa.OutputPortAspect.*
import static extension org.eclipse.gemoc.example.moccmlsigpml.k3dsa.PlaceAspect.*
import static extension org.eclipse.gemoc.example.moccmlsigpml.k3dsa.SystemAspect.*
import groovy.lang.Binding
import groovy.lang.GroovyShell
import cnrs.luchogie.up.data.rendering.figure.ConnectedLineFigureRenderer
//import fr.inria.diverse.k3.al.annotationprocessor.coordination.Exposed
//import fr.inria.diverse.k3.al.annotationprocessor.coordination.Input
//import fr.inria.diverse.k3.al.annotationprocessor.coordination.Output
import fr.inria.diverse.k3.al.annotationprocessor.Step

@Aspect(className = HWComputationalResource)
class HWComputationalResourceAspect {
	public Integer executionCycle = 0

	def void incCycle() {
		
		_self.executionCycle = _self.executionCycle + 1
		if (SystemAspect.DEBUG) println("execution cycle in CPU " + _self.name + " = " + _self.executionCycle)
	}
}

@Aspect(className = Agent) 
class AgentAspect extends NamedElementAspect {
	public SwingPlotter plotter = new InteractiveSwingPlotter
	public JFrame frame = new JFrame
	public Figure figure = new Figure
	public Boolean hasBeenStopped = false
	public Integer currentExecCycle = 0;
	public Boolean isCurrentlyExecuting = false;

	def void isExecuting() {
		if (SystemAspect.DEBUG) println(_self.name+'\n      isExecuting ('+_self.currentExecCycle+')')
		if(_self.currentExecCycle <= _self.cycles && (!_self.hasBeenStopped) ){
			_self.currentExecCycle = _self.currentExecCycle + 1
		}
	}

	def void stop() {
		if (SystemAspect.DEBUG) println(_self.name+'\n      stop('+_self.currentExecCycle+')')
		_self.currentExecCycle = 0
		_self.hasBeenStopped = true
	}

	def void execute() {
		_self.hasBeenStopped = false
		if (SystemAspect.DEBUG) println(_self.name + "\n      execute (" + _self.currentExecCycle + ")")
		if (SystemAspect.DEBUG) println("@ : " + _self.currentExecCycle + " sharedMemory:" + _self.system.sharedMemory)

		val outputPortNames = newArrayList
		_self.frame.setContentPane(_self.plotter)
		_self.frame.setSize(700, 400)
		_self.frame.alwaysOnTop = true;
		_self.frame.title = _self.name
		_self.plotter.getGraphics2DPlotter().setFigure(_self.figure);
		_self.figure.addRenderer(new ConnectedLineFigureRenderer());
		if (_self.frame.isVisible()){
			_self.frame.repaint(500);
		}else{
			_self.frame.repaint(5000);
		}

		val binding = new Binding
		binding.setVariable("plotter", _self.plotter)
		binding.setVariable("frame", _self.frame)

		val localTime = _self.allocatedTo.executionCycle
		binding.setVariable("localTime", localTime)
		binding.setVariable("figure", _self.figure)

		for(Port p : _self.ownedPorts) { 
			if (p instanceof InputPort) {
				val params = newArrayList

				for (i : 0 ..<  p.rate) {
					if (SystemAspect.DEBUG) println("start for rate params sharedMemory: " + _self.system.sharedMemory)

					val tmp = _self.system.sharedMemory.get(p.name).get(0)
					params.add(tmp)
					_self.system.sharedMemory.remove(p.name, tmp)

					if (SystemAspect.DEBUG) println("end for rate params sharedMemory: " + _self.system.sharedMemory)
				}

				if (SystemAspect.DEBUG) println("   in params: " + p.name +" = "+params)
				binding.setVariable(p.name, params)
			}
			else {
				if (SystemAspect.DEBUG) println("   out params: " + p.name )
				outputPortNames.add(p.name)
			}
		}	

		/* reset sizeToRead */
		for (Port p : _self.ownedPorts) {
			if (p instanceof InputPort) {
				p.sizeToread = 0
			}
		}

		
		try{
			//val ucl = _self.class.classLoader
			//val b = Platform.getBundle("org.eclipse.gemoc.example.moccmlsigpml.k3dsa")
			//val ucl = b.adapt(BundleWiring).getClassLoader()			
			val ucl = AgentAspect.classLoader
			//val ucl = _self.class.classLoader	
			val shell = new GroovyShell(ucl,binding)
	
			val res = shell.evaluate(_self.code) as Map<String, Object>
	
				
			for (String portName : outputPortNames) {
				_self.system.sharedMemory.put(portName, res.get(portName))
			}
			if (SystemAspect.DEBUG) println("sharedMemory: " + _self.system.sharedMemory)
		} catch (Exception cnfe){
			println("Failed to call Groovy script "+cnfe.message)
			for (String portName : outputPortNames) {
				_self.system.sharedMemory.put(portName, 0.0)
			}
			cnfe.printStackTrace
		}
	}
}

@Aspect(className = InputPort)
class InputPortAspect extends NamedElementAspect {
	public Integer sizeToread = 0

	def int read() {
		_self.sizeToread = _self.sizeToread + 1
		return _self.sizeToread
	}
	
	def void logSizeToReadWhenZero()
	{
		if (SystemAspect.DEBUG) println("*** sizeToRead is equal to 0 ***")
	}

	def void logSizeToReadWhenNotZero()
	{
		if (SystemAspect.DEBUG) println("sizeToRead = " + _self.sizeToread)
	}

}

@Aspect(className = OutputPort)
class OutputPortAspect extends NamedElementAspect {
	public Integer sizeWritten = 0

	def void write() {
//		_self.sizeWritten = _self.sizeWritten + 1
	}
}

@Aspect(className = Place)
class PlaceAspect extends NamedElementAspect {
	
//	@Exposed
//	@Input(cond="true")
//	@Output(cond="true")
	public EList<Object> fifo = new BasicEList()
	public Integer currentSize = 0
	public Boolean isInitialized = false

	@Step
	def void initialize() {
		if (SystemAspect.DEBUG) println("place " + _self.name + "is initializing")
		_self.fifo.clear
		for(i:0 ..< _self.delay) {
			var Object initialObject = 0
			_self.fifo.add(initialObject)
		}

		_self.currentSize = _self.fifo.size
	}

	@Step
	def void push() {
		//write move here to avoid k3 call order dependence
		_self.itsOutputPort.sizeWritten = _self.itsOutputPort.sizeWritten + 1 
		
		if (!_self.isInitialized) {
			_self.initialize()
			_self.isInitialized = true
		}

		_self.itsOutputPort.sizeWritten = _self.itsOutputPort.sizeWritten - 1 

		if (SystemAspect.DEBUG) println(_self.name + "push")
		if (SystemAspect.DEBUG) println("sharedMemory: " + _self.system.sharedMemory)

		var fifo_view = _self.fifo
		val objTowrite = _self.system.sharedMemory.get(_self.itsOutputPort.name).get(0)

		_self.system.sharedMemory.remove(_self.itsOutputPort.name, objTowrite)
		fifo_view.add(objTowrite)
		_self.currentSize = _self.fifo.size
		_self.fifo = fifo_view

		if (SystemAspect.DEBUG) println(fifo_view)
		if (SystemAspect.DEBUG) println("sharedMemory: " + _self.system.sharedMemory)
	}

	def void pop() {
		if(! _self.isInitialized) {
			_self.initialize()
			_self.isInitialized = true
		}

		if (SystemAspect.DEBUG) println(_self.name + "pop")
		if (SystemAspect.DEBUG) println("sharedMemory: " + _self.system.sharedMemory)
		if (SystemAspect.DEBUG) println(_self.fifo)

		val readedObject = _self.fifo.get(0)
		_self.fifo.remove(0)
		_self.currentSize = _self.fifo.size
		_self.system.sharedMemory.put(_self.itsInputPort.name, readedObject)

		if (SystemAspect.DEBUG) println("sharedMemory: " + _self.system.sharedMemory)
	}
}

@Aspect(className=System)
class SystemAspect {
	public LinkedListMultimap<String,Object> sharedMemory
	public static Boolean DEBUG = false;
	@InitializeModel
	def void initializeModel(EList<String> args){
		for(Place place : _self.ownedApplication.ownedPlaces){
			place.initialize
		}
	}
}

@Aspect(className=NamedElement)
abstract class NamedElementAspect {
	def System getSystem() {
		var contents = _self.eResource.contents
		val system = contents.findFirst[x | x instanceof System] as System
		
		if (system !== null && system.sharedMemory === null)
			system.sharedMemory = LinkedListMultimap.create
			
		return system
	}
}
