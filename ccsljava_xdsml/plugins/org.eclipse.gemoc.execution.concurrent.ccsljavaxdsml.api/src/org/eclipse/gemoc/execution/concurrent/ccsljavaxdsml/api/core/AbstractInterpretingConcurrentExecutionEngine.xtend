package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core

import java.util.HashSet
import java.util.Set
import org.eclipse.gemoc.trace.commons.model.generictrace.GenericParallelStep
import org.eclipse.gemoc.trace.commons.model.generictrace.GenericSmallStep
import org.eclipse.gemoc.trace.commons.model.generictrace.GenerictraceFactory
import org.eclipse.gemoc.trace.commons.model.trace.Step

abstract class AbstractInterpretingConcurrentExecutionEngine<C extends AbstractConcurrentModelExecutionContext<R, ?, ?>, R extends IConcurrentRunConfiguration> extends AbstractConcurrentExecutionEngine<C, R> {

	def abstract Set<GenericSmallStep> computePossibleSmallSteps()

	def abstract boolean canInitiallyRunConcurrently(Step<?> s1, Step<?> s2)

	override protected computeInitialLogicalSteps() {
		extension val traceFactory = GenerictraceFactory.eINSTANCE

		var Set<GenericParallelStep> possibleLogicalSteps = new HashSet<GenericParallelStep>()

		val atomicMatches = computePossibleSmallSteps

		possibleLogicalSteps.addAll(
			atomicMatches.generateConcurrentSteps.map [ seq |
				if (seq.subSteps.length > 1) {
					seq
				}
			].filterNull
		)

		val Set<GenericParallelStep> aaa = atomicMatches.map [ m |
			// Concurrent engine expects everything to be a parallel step
			val GenericParallelStep pstep = createGenericParallelStep()
			pstep.subSteps.add(m)
			pstep
		].toSet

		possibleLogicalSteps.addAll(aaa)

		return possibleLogicalSteps
	}

	/**
	 * Generate all possible maximally concurrent steps
	 * 
	 * @param matchList all current atomic matches
	 */
	private def Set<GenericParallelStep> generateConcurrentSteps(Set<GenericSmallStep> matchList) {
		var possibleSequences = new HashSet<GenericParallelStep>;

		createAllStepSequences(matchList, possibleSequences, new HashSet<GenericSmallStep>);

		possibleSequences
	}

	/**
	 * Recursively explore all matches, check if they have conflicts and create max valid rule sequence
	 * 
	 * @param a list of all matches, a list of lists of all possible sequences, current stack
	 */
	private def void createAllStepSequences(Set<GenericSmallStep> allMatches,
		Set<GenericParallelStep> possibleSequences, Set<GenericSmallStep> currentStack) {
		var foundOne = false;
		for (GenericSmallStep m : allMatches) {
			if (!currentStack.contains(m)) {
				if (!hasConflicts(m, currentStack)) {
					foundOne = true;
					currentStack.add(m);
					var clonedStack = currentStack.clone() as Set<GenericSmallStep>;
					createAllStepSequences(allMatches, possibleSequences, clonedStack);
					currentStack.remove(m);
				}
			}
		}
		if (!foundOne) {
			val pstep = GenerictraceFactory.eINSTANCE.createGenericParallelStep
			pstep.subSteps.addAll(currentStack)
			possibleSequences.add(pstep);
		}
	}

	/**
	 * Check if a match has conflicts with a set of other matches
	 * 
	 * @param match and a list of matches
	 */
	private def hasConflicts(Step<?> match, Set<GenericSmallStep> matches) {
		matches.exists[m|match.cannotRunConcurrently(m)]
	}

	/**
	 * Check if two matches cannot be executed in parallel. First checks if the two matches 
	 * conflict based on the CPA analysis. Then checks if all concurrency strategies agree 
	 * that they should be run in parallel.
	 * 
	 * @param match1 and match2
	 * 
	 * @output true if the two matches should not run in parallel
	 */
	private def cannotRunConcurrently(Step<?> match1, Step<?> match2) {
		!canInitiallyRunConcurrently(match1, match2) || !applyConcurrencyStrategies(match1, match2)

	}

}
