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
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.dsa.executors.explorer;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.commons.MoccmlModelExecutionContext;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.dse.DefaultMSEStateController;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.engine.MoccmlExecutionEngine;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.dsa.helper.IK3ModelStateHelper;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dsa.executors.CodeExecutionException;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.moc.ICCSLExplorer;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.moc.ICCSLSolver;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.ModelSpecificEvent;
import org.eclipse.gemoc.trace.commons.model.generictrace.GenericParallelStep;
import org.eclipse.gemoc.trace.commons.model.generictrace.GenericStep;
import org.eclipse.gemoc.trace.commons.model.trace.SmallStep;
import org.eclipse.gemoc.trace.commons.model.trace.Step;

import grph.Grph;

/**
 * Experimental feature to explore the whole state space of a model. Seen for
 * now as an execution engine but may before a dedicated tool that delegate
 * actual execution to a gemoc engine.
 * 
 * @see MoccmlExecutionEngine
 * 
 * @author julien.deantoni@univ-cotedazur.fr
 * @param <T>
 * 
 */
public class ExhaustiveConcurrentExecutionEngine extends MoccmlExecutionEngine {

	public ExhaustiveConcurrentExecutionEngine(MoccmlModelExecutionContext concurrentexecutionContext, ICCSLSolver s)
			throws CoreException {
		super(concurrentexecutionContext, s);
	}

	public StateSpace stateSpace = new StateSpace();
	protected ArrayList<ControlAndRTDState> statesToExplore = new ArrayList<ControlAndRTDState>();

	/**
	 * actually performs all the execution steps...
	 * 
	 * @throws CodeExecutionException
	 */
	@Override
	protected void performExecutionStep() {
		String fullLanguageName = this._executionContext.getLanguageDefinitionExtension().getName();
		int lastDot = fullLanguageName.lastIndexOf(".");
		if (lastDot == -1)
			lastDot = 0;
		String languageName = fullLanguageName.substring(lastDot + 1);
		String languageToUpperFirst = languageName.substring(0, 1).toUpperCase() + languageName.substring(1);

		IK3ModelStateHelper modelStateHelper = null;
		try {
			modelStateHelper = (IK3ModelStateHelper) this._executionContext.getDslBundle().loadClass(
					languageToUpperFirst.toLowerCase() + ".xdsml.api.impl." + languageToUpperFirst + "ModelStateHelper")
					.newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		EObject model = this._executionContext.getResourceModel().getContents().get(0);
//		System.out.println(model);
		
		((ICCSLExplorer)this._solver).initSolverForExploration();
		
		ControlAndRTDState initialState = new ControlAndRTDState(modelStateHelper.getK3ModelState(model),
				this._solver.getState(), this.saveState());
		stateSpace.initialState = initialState;
		stateSpace.addVertex(initialState);
		statesToExplore.add(initialState);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println("starts exploring state space on "+now);

		int exploredStates = 0;
		while (!statesToExplore.isEmpty()) {
			System.out.println("###################  explored "+exploredStates+"  ##################### still " + statesToExplore.size()+ " steps to explore ###########");
			exploredStates++;
			_possibleLogicalSteps = null;
			ControlAndRTDState currentState = statesToExplore.remove(0);
			modelStateHelper.restoreModelState(currentState.modelState);
			this._solver.setState(currentState.moCCState); //Arrays.copyOf( ?
			this.restoreState(currentState.engineState);
			// set the possibleLogicalSteps for this state
			((ICCSLExplorer)this._solver).computeAndGetPossibleLogicalStepsForExploration();
			beforeUpdatePossibleLogicalSteps(); //filter according to DSA returned value
			_possibleLogicalSteps = ((ICCSLExplorer)this._solver).updatePossibleLogicalStepsForExploration();
			// 2- compute all states accessible from the currenState when using the
			// possibleLogicalStates
			int originalPossibleLogicalStepSize = _possibleLogicalSteps.size();
			for (int i = 0; i < _possibleLogicalSteps.size(); i++) {
				
//				System.out.println(i+") current model state = "+currentState);
				if (getPossibleLogicalSteps().size() != originalPossibleLogicalStepSize) {
					System.err.println("something went wrong during mocc state save/restore");
				}
				((ICCSLExplorer)this._solver).prepareSolverForNewStepForExploration();
				
				Step<?> aStep = getPossibleLogicalSteps().get(i);
				setSelectedLogicalStep(aStep);
				try {
					executeSelectedLogicalStep();
				} catch (Throwable t) {
					throw new RuntimeException(t);
				}
				((ICCSLExplorer)this._solver).applyLogicalStepForExploration(aStep);
				engineStatus.incrementNbLogicalStepRun();
				ControlAndRTDState newState = new ControlAndRTDState(modelStateHelper.getK3ModelState(model),
						this._solver.getState(), this.saveState());

				ControlAndRTDState theExistingState = null;
				for (ControlAndRTDState s : stateSpace.getVertices()) {
					if (newState.equals(s)) {
						theExistingState = s;
						break;
					}
				}
				if (theExistingState == null) {
					stateSpace.addVertex(newState);
					StringBuffer buf = new StringBuffer(prettyPrint((GenericParallelStep) aStep));
					stateSpace.addDirectedSimpleEdge(currentState, buf, newState);
					statesToExplore.add(newState);
				} else {
					assert (theExistingState != null);
//					System.out.println("there is a loop");
					StringBuffer buf = new StringBuffer(prettyPrint((GenericParallelStep) aStep));
					stateSpace.addDirectedSimpleEdge(currentState, buf, theExistingState);
				}
				modelStateHelper.restoreModelState(currentState.modelState);
				this._solver.setState(currentState.moCCState); //Arrays.copyOf( ?
				this.restoreState(currentState.engineState);
			}
			((ICCSLExplorer)this._solver).resetCurrentStepForExploration();
		}
//		stepExecutor.clearFiredClock();
//		stepExecutor = null;
		this._solver = null;
		
		stop();
		PrintStream ps = null;
		String modelPath = this._executionContext.getResourceModel().getURI().toPlatformString(true);
		IProject modelProject = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(modelPath.substring(1, modelPath.substring(1).indexOf('/') + 1));
		IFile dotFile = modelProject
				.getFile(modelPath.replace("/" + modelProject.getName() + "/", "") + "_statespace.dot");

		try {
			ps = new PrintStream(dotFile.getLocationURI().toString().substring(5));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Grph internalGrph = stateSpace.getGrph();
		now = LocalDateTime.now();  
		System.out.println("just finished exploring state space on "+now);
		System.out.println("################################################res: " + internalGrph.getVertices().size()
				+ " states and " + internalGrph.getEdges().size() + " transitions");
		ps.print(internalGrph.toDot());
		ps.close();
	}

	private String prettyPrint(GenericParallelStep aStep) {
		StringBuilder sbStep = new StringBuilder();
		for (GenericStep s : aStep.getSubSteps()) {
			sbStep.append(((SmallStep<?>) s).getMseoccurrence().getMse().getName() + " ");
		}
		return sbStep.toString();
	}

	@Override
	public String engineKindName() {
		return "GEMOC Moccml Exhaustive Concurrent Engine";
	}
	
	public Map<ModelSpecificEvent, Boolean> saveState(){ //one map is enough since view are not used in exhaustive simulation
		return new HashMap<ModelSpecificEvent, Boolean>(((DefaultMSEStateController)getExecutionContext().getExecutionPlatform().getMSEStateControllers().iterator().next())._mseNextStates);
	}
	
	public void restoreState(Map<ModelSpecificEvent, Boolean> controllerStates){
		((DefaultMSEStateController)getExecutionContext().getExecutionPlatform().getMSEStateControllers().iterator().next())._mseNextStates = new HashMap<ModelSpecificEvent, Boolean>(controllerStates);
	}

}
