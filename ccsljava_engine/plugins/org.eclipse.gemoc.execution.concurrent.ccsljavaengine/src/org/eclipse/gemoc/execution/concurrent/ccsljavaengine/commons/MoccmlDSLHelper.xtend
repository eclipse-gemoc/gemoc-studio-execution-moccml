package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.commons

import java.util.Set
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.gemoc.executionframework.engine.commons.DslHelper

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
}
