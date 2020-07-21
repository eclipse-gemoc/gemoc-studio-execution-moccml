package org.eclipse.gemoc.execution.concurrent.symbolic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.BoolVar;
import org.chocosolver.solver.variables.Variable;
import org.chocosolver.util.ESat;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.AbstractConcurrentExecutionEngine;
import org.eclipse.gemoc.trace.commons.model.generictrace.GenericParallelStep;
import org.eclipse.gemoc.trace.commons.model.generictrace.GenericStep;
import org.eclipse.gemoc.trace.commons.model.generictrace.GenerictraceFactory;
import org.eclipse.gemoc.trace.commons.model.trace.ParallelStep;
import org.eclipse.gemoc.trace.commons.model.trace.SmallStep;
import org.eclipse.gemoc.trace.commons.model.trace.Step;

public class ChocoHelper {

	/**
	 * help retrieving the exact logical step used for the logical step decider
	 */
	public static Set<ParallelStep<? extends Step<?>, ?>> lastChocoLogicalSteps = null;

	public static Set<ParallelStep<? extends Step<?>, ?>> computePossibleStepInExtension(Model symbolicPossibleSteps, AbstractConcurrentExecutionEngine.StepFactory stepFactory) {


		Solver solver = symbolicPossibleSteps.getSolver();
		int nbSmallSteps = 0;
		for (Variable v : symbolicPossibleSteps.getVars()) {
			if (v instanceof SmallStepVariable) {
				nbSmallSteps++;
			}
		}

		// 6. Launch the resolution process (note, solutions provided by choco are folded in the sense that they contained "undefined" values
		//     whose meaning is : whatever the value, the model is satisfied. So I created small helper to get the exhaustive set of solutions
		ArrayList<ChocoSolution> allFoldedValues = new ArrayList<ChocoSolution>();
		while (solver.solve()) {
			ChocoSolution aSoluce = new ChocoSolution();
			for (int vNum = 0; vNum < nbSmallSteps; vNum++) {// not all vars since internal variable doesn't mind for us
				Variable v = symbolicPossibleSteps.getVar(vNum);
				if (v instanceof BoolVar) {
					aSoluce.add(new ChocoSolutionValue(v.asBoolVar(), v.asBoolVar().getBooleanValue()));
				}
			}
			allFoldedValues.add(aSoluce);
		}
		// 6.1: unfold all solutions provided by the solver
		ArrayList<ChocoSolution> allUnfoldedSolutions = unfoldSolutions(allFoldedValues);
		for (ChocoSolution s : allUnfoldedSolutions) {
			System.out.print("solution: ");
			for (ChocoSolutionValue sv : s) {
				if (sv.var instanceof SmallStepVariable) {
					System.out.print(" " + sv.var.getName() + "(" + ((SmallStepVariable) sv.var).associatedSmallStep
							+ ") =" + sv.value);
				} else {
					System.out.print(" " + sv.var.getName() + "=" + sv.value);
				}
			}
			System.out.println("");
		}

		lastChocoLogicalSteps = null;
		Set<ParallelStep<? extends Step<?>, ?>> result = new HashSet<ParallelStep<? extends Step<?>, ?>>();

		for (ChocoSolution s : allUnfoldedSolutions) {
			GenericParallelStep parStep = GenerictraceFactory.eINSTANCE.createGenericParallelStep();
			for (ChocoSolutionValue sv : s) {
				if (sv.var instanceof SmallStepVariable) {
					if (sv.value == ESat.TRUE) {
						parStep.getSubSteps().add((GenericStep) stepFactory
								.createClonedInnerStep(((SmallStepVariable) sv.var).associatedSmallStep));

//						GenericSmallStep smallStep = GenerictraceFactory.eINSTANCE.createGenericSmallStep();
//						MSEOccurrence mseOccurrence = TraceFactory.eINSTANCE.createMSEOccurrence();
//						mseOccurrence.setMse(((GenericStep) ((SmallStepVariable)sv.var).associatedSmallStep).getMseoccurrence().getMse());
//						smallStep.setMseoccurrence(mseOccurrence);
//						parStep.getSubSteps().add(smallStep);
					}
				}
			}
			result.add(parStep);
		}
		lastChocoLogicalSteps = result;
		return result;

	}

	static ArrayList<ChocoSolution> unfoldSolutions(ArrayList<ChocoSolution> allFoldedSolutions) {
		ArrayList<ChocoSolution> allUnfoldedSolutions = new ArrayList<ChocoSolution>();

		for (ChocoSolution s : allFoldedSolutions) {
			if (s.containsUndefined()) {
				ArrayList<ChocoSolutionValue> allUndefined = s.getUndefinedVar();
				double bound = Math.pow(2, allUndefined.size());
				for (double i = 0; i < bound; i++) {
					ChocoSolution sPrime = s.deepCopy();
					for (int bitLocation = 0; bitLocation < allUndefined.size(); bitLocation++) {
						if (isBitSet((long) i, bitLocation)) {
							sPrime.get(s.indexOf(allUndefined.get(bitLocation))).value = ESat.TRUE;
						} else {
							sPrime.get(s.indexOf(allUndefined.get(bitLocation))).value = ESat.FALSE;
						}
					}
					allUnfoldedSolutions.add(sPrime);
				}
			} else {
				allUnfoldedSolutions.add(s);
			}
		}

		return allUnfoldedSolutions;
	}

	private static Boolean isBitSet(long b, int bit) {
		return (b & (1 << bit)) != 0;
	}

	public static Set<SmallStep<?>> getAtomicSteps(Model symbolicPossibleSteps) {
		Set<SmallStep<?>> result = new HashSet<>();

		for (Variable v : symbolicPossibleSteps.getVars()) {
			if (v instanceof SmallStepVariable) {
				result.add(((SmallStepVariable) v).associatedSmallStep);
			}
		}

		return result;
	}
	
	public static void addExclusionConstraint(Model symboligPossibleSteps, SmallStep<?> s1, SmallStep<?> s2) {
		SmallStepVariable vs1 = null;
		SmallStepVariable vs2 = null;
		
		for (Variable v : symboligPossibleSteps.getVars()) {
			if (v instanceof SmallStepVariable) {
				if (((SmallStepVariable) v).associatedSmallStep == s1) {
					vs1 = (SmallStepVariable) v;
				} else if (((SmallStepVariable) v).associatedSmallStep == s2) {
					vs2 = (SmallStepVariable) v;				
				}
				
				if ((vs1 != null) && (vs2 != null)) {
					break;
				}
			}
		}
		
		vs1.eq(1).imp(vs2.eq(0))
			.and(vs2.eq(1).imp(vs1.eq(0)))
			.extension()
			.post();
	}


}
