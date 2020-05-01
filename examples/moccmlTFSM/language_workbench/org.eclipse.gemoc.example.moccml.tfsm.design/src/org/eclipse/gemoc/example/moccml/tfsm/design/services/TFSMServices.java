/*******************************************************************************
 * Copyright (c) 2015, 2016  I3S Laboratory  and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     I3S Laboratory - initial API and implementation
 *******************************************************************************/
package org.eclipse.gemoc.example.moccml.tfsm.design.services;

import org.eclipse.gemoc.example.moccml.tfsm.tfsm.BooleanExpression;
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.EvaluateGuard;
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.EventGuard;
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.FSMEvent;
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.IntegerComparisonExpression;
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.TemporalGuard;
import org.eclipse.gemoc.example.moccml.tfsm.tfsm.Transition;

/** TFSM services.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 * 
 */
public class TFSMServices {

	/**
	 * Gets the label for the given {@link Transition}.
	 * 
	 * @param transition
	 *            the {@link Transition}
	 * @return the label for the given {@link Transition}
	 */
	public String getLabel(Transition transition) {
		final StringBuilder res = new StringBuilder();

		if (transition.getOwnedGuard() instanceof EventGuard) {
			res.append("when ");
			res.append(((EventGuard) transition.getOwnedGuard())
					.getTriggeringEvent().getName());
		} else if (transition.getOwnedGuard() instanceof TemporalGuard) {
			res.append("after ");
			res.append(((TemporalGuard) transition.getOwnedGuard())
					.getAfterDuration());
			res.append(" on ");
			res.append(((TemporalGuard) transition.getOwnedGuard())
					.getOnClock().getName());
		} else if (transition.getOwnedGuard() instanceof EvaluateGuard) {
			res.append("if ");
			EvaluateGuard g = ((EvaluateGuard) transition.getOwnedGuard());
			BooleanExpression c = g.getCondition();
			if (c instanceof IntegerComparisonExpression) {
				IntegerComparisonExpression ice = (IntegerComparisonExpression) c;
			res.append("("+ice.getOperand1().getName() + " "+ice.getOperator()+" "+ice.getOperand2().getName()+")");
			}
		}
		if (transition.getGeneratedEvents().size() > 0 || transition.getAction().size() > 0) {
			res.append("\n / \n");
			if (transition.getAction().size() > 0) {
				res.append(transition.getAction());
				res.append("\n");
			}
			for (FSMEvent event : transition.getGeneratedEvents()) {
				res.append("  !");
				res.append(event.getName());
				res.append(";");
			}
		}
		

		return res.toString();
	}


}
