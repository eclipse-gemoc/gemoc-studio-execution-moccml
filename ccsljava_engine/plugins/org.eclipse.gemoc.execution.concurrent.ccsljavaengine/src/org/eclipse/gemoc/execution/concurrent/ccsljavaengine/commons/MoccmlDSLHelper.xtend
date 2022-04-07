package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.commons

import java.util.Set
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.gemoc.executionframework.engine.commons.DslHelper
import org.eclipse.ocl.xtext.completeoclcs.DefPropertyCS
import org.eclipse.gemoc.moccml.mapping.moccml_mapping.EventType
import org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS
import org.eclipse.emf.ecore.EObject

class MoccmlDSLHelper {

	private static def String getFQN(EPackage p) {
		if (p.ESuperPackage !== null) {
			return getFQN(p.ESuperPackage) + "." + p.name
		} else {
			return p.name
		}
	}

	private static def String getFQN(EOperation op) {
		return getFQN(op.EContainingClass.EPackage) + "." + op.EContainingClass.name + "." + op.name
	}

	static def Set<String> getSemanticRules(String dslName) {
		return getAbstractSyntax(dslName).flatMap[it.eAllContents().filter(EOperation).toList].map[getFQN(it)].toSet
	}

	static def Set<EPackage> getAbstractSyntax(String dslName) {
		val dsl = DslHelper.load(dslName)
		val uri = URI::createURI(dsl.getEntry("ecore").value.replace("resource", "plugin"))
		val resource = new ResourceSetImpl().getResource(uri, true)
		return resource.contents.filter(EPackage).toSet
	}
	
	static def Set<String> getDSE(String dslName) {
		return getMoCCMLDSE(dslName).filter[def | def.ownedType == EventType].map[eventDef | (eventDef.parent as ClassifierContextDeclCS).referredClass.name+"."+eventDef.name].toSet
	}

	static def Set<DefPropertyCS> getMoCCMLDSE(String dslName) {
		val dsl = DslHelper.load(dslName)
		val uri = URI::createURI(dsl.getEntry("ecl").value.replace("resource", "plugin"))
		val resource = new ResourceSetImpl().getResource(uri, true)
		return resource.contents.filter(DefPropertyCS).toSet
	}
	
	static def EObject getModelRoot(String modelLocation) {
		val uri = URI::createURI("platform:/resource"+modelLocation)
		try{
			val resource = new ResourceSetImpl().getResource(uri, true)
			return resource.contents.get(0)
		}catch(Exception e){
			return null
		}
	}
}
