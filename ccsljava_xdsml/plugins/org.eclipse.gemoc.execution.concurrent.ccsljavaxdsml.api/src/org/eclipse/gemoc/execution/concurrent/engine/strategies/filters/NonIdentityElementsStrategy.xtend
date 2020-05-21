

package org.eclipse.gemoc.execution.concurrent.engine.strategies.filters

import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.EClass
import org.eclipse.gemoc.execution.concurrent.engine.strategies.FilteringStrategy
import org.eclipse.gemoc.trace.commons.model.trace.ParallelStep
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Remove steps that differ only in objects of a specific type -- specify that objects of that type are not considered to have identity (e.g., parts in the PLS example).
 * 
 * This is a filtering strategy to allow it to interact with concurrency computation to recognise that it is still meaningful to have two potentially concurrent applications 
 * of assemble (in the PLS case), for example. It's just not meaningful to have four ``different'' atomic assemble steps where there is only one machine. Hence, this is a filtering
 * strategy that needs to be applied after all possible concurrent executions have been computed.
 */
class NonIdentityElementsStrategy  implements FilteringStrategy {

	/**
	 * Objects of these types should not be considered to have independent identity. So, while we can require to match multiple, distinct objects in one rule match, two rule matches 
	 * should only be considered different if they differ in matches for objects that are not of one of these types.
	 */
	@Accessors
	var List<? extends EClass> nonIdentityTypes



	new(List<? extends EClass> nonIdentityTypes) {
		this.nonIdentityTypes = nonIdentityTypes
	}

	override filter(Set<ParallelStep<?,?>> steps) {
	
	}


}
