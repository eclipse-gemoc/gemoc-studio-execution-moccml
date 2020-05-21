package org.eclipse.gemoc.execution.concurrent.engine.strategies.concurrency

import org.eclipse.gemoc.execution.concurrent.engine.strategies.ConcurrencyStrategy
import org.eclipse.gemoc.trace.commons.model.trace.SmallStep

class OverlapStrategy implements ConcurrencyStrategy {

	override canBeConcurrent(SmallStep<?> step1, SmallStep<?> step2) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

}
