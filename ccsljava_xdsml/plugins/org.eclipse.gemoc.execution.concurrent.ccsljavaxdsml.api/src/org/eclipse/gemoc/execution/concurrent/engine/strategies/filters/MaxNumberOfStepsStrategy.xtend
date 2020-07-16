package org.eclipse.gemoc.execution.concurrent.engine.strategies.filters

import java.util.ArrayList
import java.util.HashSet
import java.util.List
import java.util.Set
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.AbstractConcurrentExecutionEngine.StepFactory
import org.eclipse.gemoc.trace.commons.model.generictrace.GenerictraceFactory
import org.eclipse.gemoc.trace.commons.model.trace.ParallelStep
import org.eclipse.gemoc.trace.commons.model.trace.SmallStep
import org.eclipse.gemoc.trace.commons.model.trace.Step
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * A strategy that only allows concurrent steps with a maximum number of substeps.
 */
class MaxNumberOfStepsStrategy extends AbstractFilteringStrategy {

	@Accessors
	var int maxNumberOfSteps

	new(int maxNumberOfSteps) {
		this.maxNumberOfSteps = maxNumberOfSteps
	}

	new() {
		this(2)
	}

	override Set<ParallelStep<? extends Step<?>, ?>> doFilter(Set<ParallelStep<? extends Step<?>, ?>> steps, extension StepFactory factory) {
		steps.flatMap [ s |
			if (s.subSteps.length > maxNumberOfSteps) {
				var newSteps = new ArrayList<List<Step<?>>>

				generateSteps(s.subSteps as List<Step<?>>, newSteps, new ArrayList<Step<?>>)

				newSteps.map [ stepList |
					(GenerictraceFactory.eINSTANCE.createGenericParallelStep => [
						subSteps += stepList.map[(it as SmallStep<?>).createClonedSmallStep]
					]) as ParallelStep<? extends Step<?>, ?>
				]
			} else {
				#[s as ParallelStep<? extends Step<?>, ?>]
			}
		].removeDuplicates(factory)
	}

	/**
	 * Recursively produce all step sets of the given size from the given list of steps and add to newSteps
	 */
	private def void generateSteps(List<Step<?>> steps, List<List<Step<?>>> newSteps, List<Step<?>> currentList) {
		if (currentList.size == maxNumberOfSteps) {
			newSteps.add(new ArrayList(currentList))
			return
		}

		steps.forEach [ s, idx |
			currentList += s

			generateSteps(steps.subList(idx + 1, steps.size), newSteps, currentList)

			currentList.remove(currentList.size - 1)
		]
	}

	/**
	 * Remove all duplicate steps from the list.
	 * 
	 * FIXME: Not the most efficient implementation yet, and I suspect it will break if there 
	 * are multiple matches for the action name that can be run in parallel
	 */
	def Set<ParallelStep<? extends Step<?>, ?>> removeDuplicates(Iterable<ParallelStep<? extends Step<?>, ?>> steps,
		extension StepFactory factory) {
		steps.fold(new HashSet<ParallelStep<? extends Step<?>, ?>>, [ set, s |
			val sortedSSubsteps = s.subSteps.sortBy[mseoccurrence.mse.name]

			if (!set.exists [ s2 |
				val sortedS2SubSteps = s2.subSteps.sortBy[mseoccurrence.mse.name]

				if (sortedSSubsteps.size == sortedS2SubSteps.size) {
					val result = new ArrayList(#[true])

					sortedSSubsteps.forEach [ step, idx |
						result.set(
							0,
							result.get(0) &&
								(step as SmallStep<?>).isEqualSmallStepTo(sortedS2SubSteps.get(idx) as SmallStep<?>)
						)
					]

					result.get(0)
				} else {
					false
				}
			]) {
				set.add(s)
			}

			set
		]).toSet
	}
}
