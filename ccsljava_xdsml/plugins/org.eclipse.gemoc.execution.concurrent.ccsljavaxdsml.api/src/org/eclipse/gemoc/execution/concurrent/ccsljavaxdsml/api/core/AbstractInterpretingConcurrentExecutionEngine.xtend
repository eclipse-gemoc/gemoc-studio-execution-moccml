package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core

import java.util.ArrayList
import java.util.HashSet
import java.util.List
import java.util.Set
import org.eclipse.gemoc.trace.commons.model.generictrace.GenericParallelStep
import org.eclipse.gemoc.trace.commons.model.generictrace.GenericSmallStep
import org.eclipse.gemoc.trace.commons.model.generictrace.GenerictraceFactory
import org.eclipse.gemoc.trace.commons.model.trace.ParallelStep
import org.eclipse.gemoc.trace.commons.model.trace.SmallStep
import org.eclipse.gemoc.trace.commons.model.trace.Step

abstract class AbstractInterpretingConcurrentExecutionEngine<C extends AbstractConcurrentModelExecutionContext<R, ?, ?>, R extends IConcurrentRunConfiguration> extends AbstractConcurrentExecutionEngine<C, R> {

	/**
	 * Compute the atomic steps currently available.
	 */
	def abstract Set<? extends GenericSmallStep> computePossibleSmallSteps()

	/**
	 * Compare the two steps (previously generated by this engine) and return true if they could run concurrently.
	 * 
	 * Assumed to be computing a reflexive and symmetric relation.
	 */
	// TODO: Cache results as this will likely be invoked multiple times for the same combination of steps 
	def abstract boolean canInitiallyRunConcurrently(SmallStep<?> s1, SmallStep<?> s2)

	extension static val GenerictraceFactory traceFactory = GenerictraceFactory.eINSTANCE

	override protected computeInitialLogicalSteps() {

		var Set<ParallelStep<? extends Step<?>, ?>> possibleLogicalSteps = new HashSet<ParallelStep<? extends Step<?>, ?>>()

		val atomicSteps = computePossibleSmallSteps

		possibleLogicalSteps += atomicSteps.generateConcurrentSteps.map [ seq |
			if (seq.subSteps.length > 1) {
				seq
			}
		].filterNull

		possibleLogicalSteps += atomicSteps.map [ s |
			// Concurrent engine expects everything to be a parallel step
			createGenericParallelStep => [
				subSteps += s
			]
		].toSet

		possibleLogicalSteps
	}

	/**
	 * Generate all possible maximally concurrent steps
	 * 
	 * @param atomicSteps all current atomic steps
	 */
	private def Set<GenericParallelStep> generateConcurrentSteps(Set<? extends GenericSmallStep> atomicSteps) {
		var possibleSequences = new HashSet<GenericParallelStep>

		atomicSteps.toList.createAllStepSequences(possibleSequences, new HashSet<GenericSmallStep>)

		possibleSequences
	}

	/**
	 * Compute all maximally concurrent steps
	 */
	private def void createAllStepSequences(List<? extends GenericSmallStep> allSmallSteps,
		Set<GenericParallelStep> possibleSequences, Set<GenericSmallStep> currentStack) {
		val foundOne = new ArrayList(#[false])

		allSmallSteps.forEach [ s, idx |
			if (s.canRunConcurrentlyWith(currentStack)) {
				foundOne.set(0, true)

				var clonedStack = new HashSet<GenericSmallStep>(currentStack)
				clonedStack += s
				allSmallSteps.subList(idx + 1, allSmallSteps.length) // Only include elements to the right of the current element
				.createAllStepSequences(possibleSequences, clonedStack)
			}
		]

		if (!foundOne.get(0)) {
			possibleSequences.addNewParallelStep(currentStack)
		}
	}

	private def addNewParallelStep(Set<GenericParallelStep> possibleSequences, Set<GenericSmallStep> currentStack) {
		// Only add if not a sub-set of an already existing parallel step
		if (currentStack.isNotContainedAsSubstepInAnyOf(possibleSequences)) {
			possibleSequences += createGenericParallelStep => [
				subSteps += currentStack.map[createClonedSmallStep as GenericSmallStep]
			]
		}
	}

	private def isNotContainedAsSubstepInAnyOf(Set<GenericSmallStep> stepSet,
		Set<GenericParallelStep> possiblyContainingSteps) {
		possiblyContainingSteps.forall[parStep|stepSet.isNotContainedAsSubstepIn(parStep)]
	}

	private def isNotContainedAsSubstepIn(Set<GenericSmallStep> stepSet,
		GenericParallelStep potentiallyContainingStep) {
		!stepSet.forall [ step |
			potentiallyContainingStep.subSteps.filter(GenericSmallStep).exists [ subStep |
				subStep.isEqualSmallStepTo(step)
			]
		]
	}

	/**
	 * Check if a given small step can run in parallel with a given set of other small steps.
	 * 
	 * @returns true if the given step can run concurrently with all steps in otherSteps
	 */
	private def canRunConcurrentlyWith(SmallStep<?> step, Set<GenericSmallStep> otherSteps) {
		otherSteps.forall[step.canRunConcurrentlyWith(it)]
	}

	/**
	 * Check if two small steps can be executed in parallel. First checks if the two matches can run in parallel in principle, 
	 * using canInitiallyRunConcurrently. Then checks if all concurrency strategies agree that they should be run in parallel.
	 * 
	 * @returns true if the two small steps can run in parallel
	 */
	private def canRunConcurrentlyWith(SmallStep<?> step1, SmallStep<?> step2) {
		canInitiallyRunConcurrently(step1, step2) && applyConcurrencyStrategies(step1, step2)
	}
}
