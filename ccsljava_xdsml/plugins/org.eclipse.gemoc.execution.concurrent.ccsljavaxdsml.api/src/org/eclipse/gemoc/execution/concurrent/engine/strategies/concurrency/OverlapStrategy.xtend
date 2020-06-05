package org.eclipse.gemoc.execution.concurrent.engine.strategies.concurrency

import org.eclipse.gemoc.execution.concurrent.engine.strategies.ConcurrencyStrategy
import org.eclipse.gemoc.trace.commons.model.trace.SmallStep
import static extension org.eclipse.gemoc.execution.concurrent.engine.strategies.FootprintUtil.*

class OverlapStrategy implements ConcurrencyStrategy {

	override canBeConcurrent(SmallStep<?> step1, SmallStep<?> step2) {
		val step1FootPrint = step1.footprint.allEObjectsTouched
		val step2FootPrint = step2.footprint.allEObjectsTouched;
		
		step1FootPrint.exists[step2FootPrint.contains(it)] ||
		step1.footprint.instantiations.forall[step1.footprint.instantiations.contains(it)]
	}

}
