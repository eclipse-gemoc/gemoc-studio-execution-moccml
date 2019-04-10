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
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.timesquare.moc.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Event;
import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.FiredStateKind;
import fr.inria.aoste.trace.LogicalStep;
import fr.inria.aoste.trace.ModelElementReference;

public class LogicalStepHelper {

	/**
	 * 
	 * @param logicalStep
	 * @return the list of ModelElementReference of this LogicalStep that are
	 *         Ticked and have a reference
	 */
	public static List<Event> getTickedEvents(LogicalStep logicalStep) {
		List<Event> result = new ArrayList<Event>();
		for (EventOccurrence eventOccurrence : logicalStep.getEventOccurrences()) {
			if (eventOccurrence.getFState() == FiredStateKind.TICK 
					&& eventOccurrence.getReferedElement() != null) {
				if (eventOccurrence.getReferedElement() instanceof ModelElementReference) {
					ModelElementReference mer = (ModelElementReference) eventOccurrence.getReferedElement();
					// get associated clock : this is the last element of the elementRef
					EObject actualClock = mer.getElementRef().get(mer.getElementRef().size() - 1);
					if (actualClock instanceof Clock) {

						// then get the event associated to the clock
						result.add(((Clock) actualClock).getTickingEvent());
					}
					//if (mer.getElementRef().size() == 1 && mer.getElementRef().get(0) instanceof Event) {
					//	result.add((Event) mer.getElementRef().get(0));
					//}
				}
				 
			}
		}
		return result;
	}
	
//	/**
//	 * 
//	 * @param logicalStep
//	 * @return the list of ModelElementReference of this LogicalStep that are
//	 *         Ticked and have a reference
//	 */
//	public static LogicalStep convertToOldLogicalStep(Step step) {
//		LogicalStep logicalStep = fr.inria.aoste.trace.TraceFactory.eINSTANCE.createLogicalStep();
//		if (step instanceof ParallelStep<?> ){
//			ParallelStep<?> ps = (ParallelStep<?>)step;
//			ps.getSubSteps();
//		}
//		for (EventOccurrence eventOccurrence : step.getEventOccurrences()) {
//			if (eventOccurrence.getFState() == FiredStateKind.TICK 
//					&& eventOccurrence.getReferedElement() != null) {
//				if (eventOccurrence.getReferedElement() instanceof ModelElementReference) {
//					ModelElementReference mer = (ModelElementReference) eventOccurrence.getReferedElement();
//					// get associated clock : this is the last element of the elementRef
//					EObject actualClock = mer.getElementRef().get(mer.getElementRef().size() - 1);
//					if (actualClock instanceof Clock) {
//
//						// then get the event associated to the clock
//						result.add(((Clock) actualClock).getTickingEvent());
//					}
//					//if (mer.getElementRef().size() == 1 && mer.getElementRef().get(0) instanceof Event) {
//					//	result.add((Event) mer.getElementRef().get(0));
//					//}
//				}
//				 
//			}
//		}
//		return result;
//	}
	
	public static void removeNotTickedEvents(LogicalStep logicalStep) {
		List<EventOccurrence> eventOccurencesToKeep = new ArrayList<EventOccurrence>();
		for (EventOccurrence eventOccurrence : logicalStep.getEventOccurrences()) {
			if (eventOccurrence.getFState() == FiredStateKind.TICK 
					&& eventOccurrence.getReferedElement() != null) {
				if (eventOccurrence.getReferedElement() instanceof ModelElementReference) {
					ModelElementReference mer = (ModelElementReference) eventOccurrence.getReferedElement();
					// get associated clock : this is the last element of the elementRef
					EObject actualClock = mer.getElementRef().get(mer.getElementRef().size() - 1);
					if (actualClock instanceof Clock) {
						eventOccurencesToKeep.add(eventOccurrence);
					}
				}				 
			}
		}
		logicalStep.getEventOccurrences().clear();
		logicalStep.getEventOccurrences().addAll(eventOccurencesToKeep);
	}

}
