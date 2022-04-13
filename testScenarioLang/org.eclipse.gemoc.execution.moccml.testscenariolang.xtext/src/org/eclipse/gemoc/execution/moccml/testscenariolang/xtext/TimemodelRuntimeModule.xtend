package org.eclipse.gemoc.execution.moccml.testscenariolang.xtext

import org.eclipse.xtext.generator.IGenerator2
import org.eclipse.xtext.resource.generic.AbstractGenericResourceRuntimeModule

/**
 * This class is used to configure the runtime dependency injection (DI) container for the EMF State-Machine language.
 */
class TimemodelRuntimeModule extends AbstractGenericResourceRuntimeModule {

	override protected getFileExtensions() {
		'timemodel'
	}

	override protected getLanguageName() {
		"fr.inria.aoste.timesquare.ccslkernel.model"
	}
}