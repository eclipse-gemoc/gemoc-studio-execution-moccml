package org.eclipse.gemoc.execution.concurrent.engine.strategies.concurrency

import java.util.List
import org.eclipse.gemoc.execution.concurrent.engine.strategies.ConcurrencyStrategy
import org.eclipse.gemoc.trace.commons.model.trace.SmallStep
import org.eclipse.xtend.lib.annotations.Accessors

class SetOfRulesStrategy  implements ConcurrencyStrategy {

	@Accessors
	var List<String> rules

	new(List<String> rules) {
		this.rules = rules;
	}
	
	override canBeConcurrent(SmallStep<?> step1, SmallStep<?> step2) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	
}
