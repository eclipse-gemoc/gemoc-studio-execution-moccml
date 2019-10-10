/*******************************************************************************
 * Copyright (c) 2017 INRIA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     INRIA - initial API and implementation
 *     I3S Laboratory - API update and bug fix
 *******************************************************************************/
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.dse;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.function.Consumer;

import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.engine.ConcurrentExecutionEngine;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.engine.MoccmlExecutionEngine;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dsa.executors.CodeExecutionException;
import org.eclipse.gemoc.executionframework.engine.Activator;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.ActionFinishedCondition;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.ActionResultCondition;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.ComparisonOperator;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.Condition;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.Force;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.ForceKind;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.When;
import org.eclipse.gemoc.trace.commons.model.trace.SmallStep;
import org.eclipse.gemoc.trace.commons.model.trace.Step;

public class ASynchroneExecution extends OperationExecution {

	private Collection<When> _whenStatements;
	private IMoccmlMSEStateController _clockController;
	private HashMap<Force, When> _forces;
	private Consumer<Step<?>> beforeStep;
	private Runnable afterStep;

	public ASynchroneExecution(SmallStep<?> smallStep, Collection<When> whenStatements,
			IMoccmlMSEStateController clockController, ConcurrentExecutionEngine engine, Consumer<Step<?>> beforeStep,
			Runnable afterStep) {
		super(smallStep, engine, beforeStep, afterStep);
		this.beforeStep = beforeStep;
		this.afterStep = afterStep;
		_whenStatements = whenStatements;
		_clockController = clockController;
	}

	public void run() {
		collectForces();
		// forbid
		// why forcing absence by default ?
		for (Force force : _forces.keySet()) {
			if (force.getKind().equals(ForceKind.PRESENCE)) {
				// should force presence ?
				_clockController.forceAbsenceTickInTheFuture(force.getEventToBeForced());
			}
		}

		// il y avait un problème de course dans le cas d'un feedback qui devait
		// etre immédiat. L'idée de François
		// c'etait on interdit tout en attendant de la réponse de l'exécution
		// asynchrone de la méthode.
		// dans certains exemples il n'est pas possible de "faire autre chose en
		// attendant" et donc on doit forcément attendre le retour de la
		// fonction associée pour éviter les deadlocks... Je propose avant de
		// mieux faire de ne rendre asynchrone que les futurs et pas les
		// feedbacks...

		boolean shouldBeLaunchInAThread = false;

		for (Entry<Force, When> entry : _forces.entrySet()) {
			Condition condition = entry.getValue().getCondition();
			if (condition instanceof ActionFinishedCondition) {
				shouldBeLaunchInAThread = true;
			}
		}

		if (shouldBeLaunchInAThread) {
			Runnable runnable = new Runnable() {

				@Override
				public void run() {
					internalRun();
				}
			};
			Thread t = new Thread(runnable);
			t.start();
		} else {
			try {
				executeMSESynchronously();
				// free
				for (Entry<Force, When> entry : _forces.entrySet()) {
					Condition condition = entry.getValue().getCondition();
					dealWithExecutionResult(entry, condition);
				}
			} catch (Exception e) {
				Activator.getDefault().error("Exception received " + e.getMessage(), e);
			}
		}

	}

	private void collectForces() {
		_forces = new HashMap<>();
		for (When statement : _whenStatements) {
			// if (statement.getCondition() instanceof ActionFinishedCondition)
			// {
			// }
			if (statement.getAction() instanceof Force) {
				Force a = (Force) statement.getAction();
				_forces.put(a, statement);
			}
		}
	}

	protected void internalRun() {
		try {
			executeMSESynchronously();
			// free
			for (Entry<Force, When> entry : _forces.entrySet()) {
				Condition condition = entry.getValue().getCondition();
				if (condition instanceof ActionFinishedCondition) {
					_clockController.freeInTheFuture(entry.getKey().getEventToBeForced());
				} else {
					dealWithExecutionResult(entry, condition);
				}
			}
		} catch (Exception e) {
			Activator.getDefault().error("Exception received " + e.getMessage(), e);
		}
	}

	private void dealWithExecutionResult(Entry<Force, When> entry, Condition condition) throws Exception {
		if (condition instanceof ActionResultCondition) {
			ActionResultCondition resultCondition = (ActionResultCondition) condition;
			boolean goOn = false;

			switch (resultCondition.getOperator().getValue()) {
			case ComparisonOperator.DIFFERENT_VALUE:
				goOn = getResult() != resultCondition.getComparisonValue();
				break;
			case ComparisonOperator.EQUALS_VALUE:
				goOn = getResult().equals(resultCondition.getComparisonValue());
				break;
			default:
				goOn = tryNumber(resultCondition.getOperator(), getResult(), resultCondition.getComparisonValue());
				break;
			}
			if (goOn) {
				if (entry.getKey().getOnTrigger() == null) {
					_clockController.freeInTheFuture(entry.getKey().getEventToBeForced());
				} else {
					FreeClockFutureAction action = new FreeClockFutureAction(entry.getKey().getEventToBeForced(),
							entry.getKey().getOnTrigger(), _clockController);
					((MoccmlExecutionEngine)getEngine()).addFutureAction(action);
				}
			}
		}
	}

	private boolean tryNumber(ComparisonOperator operator, Object result, Object comparisonValue) throws Exception {
		Double s1 = null;
		Double s2 = null;
		if (result instanceof Number && comparisonValue instanceof Number) {
			s1 = ((Number) result).doubleValue();
			s2 = ((Number) comparisonValue).doubleValue();
		}
		if (s1 == null || s2 == null) {
			throw new Exception("Cannot convert result or comparison value to double.");
		}
		boolean goOn = false;
		int comparisonResult = Double.compare(s1.doubleValue(), s2.doubleValue());
		switch (operator.getValue()) {
		case ComparisonOperator.INF_EQUALS_VALUE:
			goOn = comparisonResult <= 0;
			break;
		case ComparisonOperator.INF_VALUE:
			goOn = comparisonResult < 0;
			break;
		case ComparisonOperator.SUP_EQUALS_VALUE:
			goOn = comparisonResult >= 0;
			break;
		case ComparisonOperator.SUP_VALUE:
			goOn = comparisonResult > 0;
			break;
		}
		return goOn;
	}

	private void executeMSESynchronously() throws CodeExecutionException {
		SynchroneExecution execution = new SynchroneExecution(getSmallStep(), getEngine(), beforeStep, afterStep);
		execution.run();
		setResult(execution.getResult());
	}

}
