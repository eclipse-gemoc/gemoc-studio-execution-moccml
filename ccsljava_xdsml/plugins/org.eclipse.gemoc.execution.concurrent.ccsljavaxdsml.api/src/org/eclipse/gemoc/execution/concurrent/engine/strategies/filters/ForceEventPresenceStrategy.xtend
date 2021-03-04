package org.eclipse.gemoc.execution.concurrent.engine.strategies.filters

import java.util.Comparator
import java.util.HashSet
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.EClass
import org.eclipse.gemoc.execution.concurrent.engine.strategies.EnumeratingFilteringStrategy
import org.eclipse.gemoc.trace.commons.model.trace.ParallelStep
import org.eclipse.gemoc.trace.commons.model.trace.Step
import org.eclipse.gemoc.trace.commons.model.trace.MSE
import org.eclipse.xtend.lib.annotations.Accessors

import org.eclipse.gemoc.trace.commons.model.generictrace.GenericSmallStep

/**
 * Remove steps that differ only in objects of a specific type -- specify that objects of that type are not considered to have identity (e.g., parts in the PLS example).
 * 
 * This is a filtering strategy to allow it to interact with concurrency computation to recognise that it is still meaningful to have two potentially concurrent applications 
 * of assemble (in the PLS case), for example. It's just not meaningful to have four ``different'' atomic assemble steps where there is only one machine. Hence, this is a filtering
 * strategy that needs to be applied after all possible concurrent executions have been computed.
 */
class ForceEventPresenceStrategy  implements EnumeratingFilteringStrategy {

	/**
	 * Objects of these types should not be considered to have independent identity. So, while we can require to match multiple, distinct objects in one rule match, two rule matches 
	 * should only be considered different if they differ in matches for objects that are not of one of these types.
	 */
	@Accessors
	var List<? extends EClass> toBePresentTypes

	new(List<? extends EClass> toBePresentTypes) {
		this.toBePresentTypes = toBePresentTypes
	}
	
	new() {
		this(emptyList)
	}

	override Set<ParallelStep<? extends Step<?>, ?>> filter(Set<ParallelStep<? extends Step<?>, ?>> steps, Comparator<Step<?>> stepComparator) {
		var Set<ParallelStep<? extends Step<?>, ?>> res = new HashSet<ParallelStep<? extends Step<?>, ?>>()
		for(ParallelStep<? extends Step<?>,?> ps : steps){
			for(Step<?> s : ps.subSteps){
				var MSE sMSE = (s as GenericSmallStep).mseoccurrence.mse;
				//TODO: here mse is of type feedback mse which is not expected
				if (sMSE.getCaller() !== null && (sMSE.getCaller().eClass.isToBePresentType)){
					res.add(ps)
				}
			}
		}
		return res
	}
	

	private def boolean isToBePresentType(EClass type) {
		toBePresentTypes.exists[nit|(nit.name == type.name) || nit.isSuperTypeOf(type)]
	}
}
