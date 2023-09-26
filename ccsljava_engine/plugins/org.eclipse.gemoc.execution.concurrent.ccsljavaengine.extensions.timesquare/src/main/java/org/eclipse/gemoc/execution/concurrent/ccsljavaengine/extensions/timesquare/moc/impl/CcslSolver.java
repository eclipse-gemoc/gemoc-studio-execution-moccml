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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.exception.ContradictionException;
import org.chocosolver.solver.expression.discrete.relational.ReExpression;
import org.chocosolver.solver.variables.BoolVar;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.commons.MoccmlModelExecutionContext;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.concurrentmse.FeedbackMSE;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.timesquare.Activator;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.utils.ccsl.QvtoTransformationPerformer;
import org.eclipse.gemoc.executionframework.engine.concurrency.AbstractConcurrentModelExecutionContext;
import org.eclipse.gemoc.executionframework.engine.concurrency.ChocoHelper;
import org.eclipse.gemoc.executionframework.engine.concurrency.SmallStepVariable;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.ActionModel;
import org.eclipse.gemoc.moccml.mapping.feedback.feedback.ModelSpecificEvent;
import org.eclipse.gemoc.trace.commons.model.generictrace.GenericParallelStep;
import org.eclipse.gemoc.trace.commons.model.generictrace.GenericSmallStep;
import org.eclipse.gemoc.trace.commons.model.generictrace.GenerictraceFactory;
import org.eclipse.gemoc.trace.commons.model.trace.MSE;
import org.eclipse.gemoc.trace.commons.model.trace.MSEModel;
import org.eclipse.gemoc.trace.commons.model.trace.MSEOccurrence;
import org.eclipse.gemoc.trace.commons.model.trace.ParallelStep;
import org.eclipse.gemoc.trace.commons.model.trace.SmallStep;
import org.eclipse.gemoc.trace.commons.model.trace.Step;
import org.eclipse.gemoc.trace.commons.model.trace.TraceFactory;
import org.eclipse.gemoc.xdsmlframework.api.core.IExecutionContext;
import org.eclipse.gemoc.xdsmlframework.api.core.IExecutionWorkspace;
import org.osgi.framework.Bundle;

import fr.inria.aoste.timesquare.ccslkernel.explorer.CCSLConstraintState;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Event;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.NamedElement;
import fr.inria.aoste.timesquare.ccslkernel.modelunfolding.exception.UnfoldingException;
import fr.inria.aoste.timesquare.ccslkernel.runtime.exceptions.NoBooleanSolution;
import fr.inria.aoste.timesquare.ccslkernel.runtime.exceptions.SimulationException;
import fr.inria.aoste.timesquare.ccslkernel.solver.StepExecutor;
import fr.inria.aoste.timesquare.ccslkernel.solver.exception.SolverException;
import fr.inria.aoste.timesquare.ccslkernel.solver.launch.CCSLKernelSolverWrapper;
import fr.inria.aoste.timesquare.instantrelation.CCSLRelationModel.OccurrenceRelation;
import fr.inria.aoste.timesquare.instantrelation.listener.RelationModelListener;
import fr.inria.aoste.timesquare.simulationpolicy.maxcardpolicy.MaxCardSimulationPolicy;
import fr.inria.aoste.timesquare.trace.util.QualifiedNameBuilder;
import fr.inria.aoste.timesquare.trace.util.adapter.AdapterRegistry;
import fr.inria.aoste.trace.AssertionState;
import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.LogicalStep;
import fr.inria.aoste.trace.ModelElementReference;
import fr.inria.aoste.trace.Reference;
import fr.inria.aoste.trace.relation.IDescription;

/**
 * Implementation of the ISolver dedicated to CCSL.
 * 
 */
public class CcslSolver implements org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.moc.ICCSLSolver, org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.moc.ICCSLExplorer {

	protected CCSLKernelSolverWrapper solverWrapper = null;
	protected URI solverInputURI = null;
	protected List<ParallelStep<? extends Step<?>,?>> _lastLogicalSteps = new ArrayList<ParallelStep<? extends Step<?>,?>>();
	protected ActionModel _feedbackModel;
	protected MSEModel _MSEModel;
	protected List<fr.inria.aoste.trace.LogicalStep> _intermediateResult;
	
	
	protected String _alternativeExecutionModelPath =null;
	ArrayList<ModelElementReference> assertionList = null;;
	
	public CcslSolver() 
	{
	}

	public CcslSolver(String specificTilmeModel){
		_alternativeExecutionModelPath = specificTilmeModel;
	}

	public CCSLKernelSolverWrapper getSolverWrapper() {
		return solverWrapper;
	}
	
	@Override
	public ArrayList<ModelElementReference> getAllDiscreteClocks(){
		return solverWrapper.getClockList();
	}
	
	@Override
	public void forbidEventOccurrence(EventOccurrence eventOccurrence) {
		this.solverWrapper.forceClockAbsence(this
				.getModelElementReferenceFromEventOccurrence(eventOccurrence));
	}

	@Override
	public void forceEventOccurrence(EventOccurrence eventOccurrence) {
		this.solverWrapper.forceClockPresence(this
				.getModelElementReferenceFromEventOccurrence(eventOccurrence));

	}

	/**
	 * Returns the ModelElementReference referred by this eventOccurrence (as
	 * originally sent by the CCSL Solver).
	 * 
	 * @param eventOccurrence
	 * @return
	 */
	private ModelElementReference getModelElementReferenceFromEventOccurrence(
			EventOccurrence eventOccurrence) {
		Reference reference = eventOccurrence.getReferedElement();
		if (reference instanceof ModelElementReference) {
			ModelElementReference mer = (ModelElementReference) reference;
			return mer;
			//			ModelElementReference merToForce = this.mappingEventToOriginalMer
//					.get(mer.getElementRef().get(0));
//			return merToForce;
		} else {
			throw new RuntimeException(
					"Refered Element of eventOccurrence should be a ModelElementReference");
		}
	}

	private ParallelStep<? extends Step<?>,?> createLogicalStep(fr.inria.aoste.trace.LogicalStep res) 
	{
		GenericParallelStep parStep = GenerictraceFactory.eINSTANCE.createGenericParallelStep();
		for (Event e : LogicalStepHelper.getTickedEvents(res))
		{
			MSEOccurrence mseOccurrence = TraceFactory.eINSTANCE.createMSEOccurrence();
			for (MSE mse : _MSEModel.getOwnedMSEs())
			{
				if (mse.getName().replace("MSE_", "").equals(e.getName().replace("evt_", "")))
				{
					mseOccurrence.setMse(mse);
					break;
				}
			}
			
			GenericSmallStep smallStep = GenerictraceFactory.eINSTANCE.createGenericSmallStep();
			smallStep.setMseoccurrence(mseOccurrence);
			parStep.getSubSteps().add(smallStep);
		}
		return parStep;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + "@[modelOfExecutionURI="
				+ this.solverInputURI + "]";
	}

	private void createSolver(IExecutionContext<?,?,?> context) 
	{
		//in the advanced tab of the launch config we can force a timemodel... risky but useful
		if(_alternativeExecutionModelPath == null || _alternativeExecutionModelPath.length() == 0){
			this.solverInputURI = URI.createPlatformResourceURI(context.getWorkspace().getMoCPath().toString(), true);
		}else{
			this.solverInputURI = URI.createPlatformResourceURI(_alternativeExecutionModelPath, true);
		}
		URI feedbackURI = URI.createPlatformResourceURI(getFeedbackPathFromMSEModelPath(context.getWorkspace().getMSEModelPath()).toString(), true);
		URI priorityURI = URI.createPlatformResourceURI(getPriorityPathFromMSEModelPath(context.getWorkspace().getMSEModelPath()).toString(), true);
		try 
		{
			//ResourceSet resourceSet = context.getResourceModel().getResourceSet();		
			ResourceSet resourceSet = new ResourceSetImpl();

			Resource ccslResource = resourceSet.getResource(this.solverInputURI, true);
			EcoreUtil.resolveAll(resourceSet);
			traceResources(resourceSet);
			traceUnresolvedProxies(resourceSet, solverInputURI);			
			
			ResourceSet prioResourceSet = new ResourceSetImpl();
			Resource prioResource = prioResourceSet .getResource(priorityURI, true);
			EcoreUtil.resolveAll(prioResourceSet);
			
			this.solverWrapper = new CCSLKernelSolverWrapper();
			this.solverWrapper.getSolver().loadModel(ccslResource);
			this.solverWrapper.getSolver().loadPriorityModel(prioResource);
			this.solverWrapper.getSolver().initSimulation();
			this.solverWrapper.getSolver().setPolicy(new MaxCardSimulationPolicy());

			Resource feedbackResource = resourceSet.getResource(feedbackURI, true);
			_feedbackModel = (ActionModel)feedbackResource.getContents().get(0);
			_MSEModel = context.getMSEModel();
			
		} catch (IOException e) {
			String errorMessage = "IOException while instantiating the CcslSolver";
			Activator.getDefault().error(errorMessage);
			Activator.getDefault().error(errorMessage, e);
		} catch (UnfoldingException e) {
			String errorMessage = "UnfoldingException while instantiating the CcslSolver";
			Activator.getDefault().error(errorMessage);
			Activator.getDefault().error(errorMessage, e);
		} catch (SolverException e) {
			String errorMessage = "SolverException while instantiating the CcslSolver";
			Activator.getDefault().error(errorMessage);
			Activator.getDefault().error(errorMessage, e);
		} catch (SimulationException e) {
			String errorMessage = "SimulationException while instantiating the CcslSolver";
			Activator.getDefault().error(errorMessage);
			Activator.getDefault().error(errorMessage, e);
		}

		
		initRelationModel();		
	}

	private void traceUnresolvedProxies(ResourceSet resourceSet,
			URI solverInputURI) {
		Map<EObject, Collection<Setting>>  unresolvedProxies = EcoreUtil.UnresolvedProxyCrossReferencer.find(resourceSet);
		if(unresolvedProxies.size() != 0){
			Activator.getDefault().warn("There are unresolved proxies in "+solverInputURI+ ", the first is "+unresolvedProxies.entrySet().toArray()[0]);
			Activator.getDefault().warn("Please verify that you don't have the modeling nature for your project so that the aird indexed all the resources, (it must not contain resolve warning).");
		}
	}

	private void traceResources(ResourceSet resourceSet) {
		Activator.getDefault().info("Input resources:");
		for(Resource r : resourceSet.getResources()) 
		{
			Activator.getDefault().info(r.getURI().toString());
		}
	}

	public boolean hasSolution(){
		return solverWrapper.hasSolution();
	}
	
	@Override
	public Model computeAndGetPossibleLogicalSteps() {
		
		try {
			_intermediateResult = solverWrapper.computeAndGetPossibleLogicalSteps();			
			_lastLogicalSteps.clear();
			for (fr.inria.aoste.trace.LogicalStep lsFromTimesquare : _intermediateResult)
			{
				ParallelStep<? extends Step<?>,?> lsFromTrace = createLogicalStep(lsFromTimesquare);
				_lastLogicalSteps.add(lsFromTrace);
			}
			Model symbolicPossibleSteps = fromLogicalStepsToModel();
			
			return symbolicPossibleSteps;
		} catch (NoBooleanSolution e) {
			Activator.getDefault().error(e.getMessage(), e);
		} catch (SolverException e) {
			Activator.getDefault().error(e.getMessage(), e);
		} catch (SimulationException e) {
			Activator.getDefault().error(e.getMessage(), e);
		} 
		return null;
	}

	private Model fromLogicalStepsToModel() {
		System.out.println(("inital computation choice -->"+_lastLogicalSteps.size()));
		Set<SmallStep> smallSteps = collectUnicSmallSteps(_lastLogicalSteps);
		Model symbolicPossibleSteps = new Model("modelFrom_lastLogicalSteps");
		List<SmallStepVariable> stepVars = createAllStepVars(smallSteps, symbolicPossibleSteps);
		List<SmallStepVariable> trueStepVars = new ArrayList();
		List<SmallStepVariable> falseStepVars = new ArrayList();
		List<ReExpression> allParVars = new ArrayList();
		
		for(ParallelStep<? extends Step<?>, ?> ps : _lastLogicalSteps) {
			
			trueStepVars.clear();
			falseStepVars.clear();
			for(Step<?> sm : ps.getSubSteps()) {
				trueStepVars.add(getAssociatedVar(stepVars, sm));
			}
			ReExpression aParVar = trueStepVars.get(0);
			for(int i=1; i < trueStepVars.size(); i++) {
				aParVar = aParVar.and(trueStepVars.get(i));
			}

			falseStepVars = new ArrayList<>(stepVars);
			falseStepVars.removeAll(trueStepVars);
			for(SmallStepVariable  ssv:falseStepVars) {
				aParVar = aParVar.and(ssv.not());
			}
			allParVars.add(aParVar);
			
		}
		if (allParVars.size() > 1) {
			ReExpression theRootParVar = allParVars.get(0);
			for(int i=1; i < allParVars.size(); i++) {
				theRootParVar = theRootParVar.xor(allParVars.get(i));
			}
			theRootParVar.post();
		}
		return symbolicPossibleSteps;
	}

	
	private Set<SmallStep> collectUnicSmallSteps(List<ParallelStep<? extends Step<?>, ?>> logicalSteps) {
		Set<SmallStep> result = new HashSet<>();
		Set<MSE> temp = new HashSet<>();
		for(ParallelStep<? extends Step<?>, ?> ps : logicalSteps) {
			for(Step<?> s : ps.getSubSteps()) {
				if (temp.add(s.getMseoccurrence().getMse())) {
					if (!(s instanceof SmallStep)) {
						throw new RuntimeException("org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.CCSLSolver: strange step found: should never happen");
					}
					result.add((SmallStep)s);
					}	
			}
		}
		return result;
	}
	
	private List<SmallStepVariable> createAllStepVars(Set<SmallStep> smallSteps, Model model) {
		List<SmallStepVariable> result = new ArrayList<>();
		for(SmallStep s : smallSteps) {
			result.add(new SmallStepVariable(s.getMseoccurrence().getMse().getName(), model, s));
		}
		return result;
	}
	
	private SmallStepVariable getAssociatedVar(List<SmallStepVariable> allStepVars, Step aStep) {
		for(SmallStepVariable s : allStepVars) {
			if (s.associatedSmallStep.getMseoccurrence().getMse().equals(aStep.getMseoccurrence().getMse())) {
				return s;
			}
		}
		return null;
	}
	
	@Override
	public Model updatePossibleLogicalSteps() {
		
		try {
			List<fr.inria.aoste.trace.LogicalStep> intermediateResult = solverWrapper.updatePossibleLogicalSteps();			
			_lastLogicalSteps.clear();
			for (fr.inria.aoste.trace.LogicalStep lsFromTimesquare : intermediateResult)
			{
				ParallelStep<? extends Step<?>,?> lsFromTrace = createLogicalStep(lsFromTimesquare);
				_lastLogicalSteps.add(lsFromTrace);
			}
			return fromLogicalStepsToModel();
		} catch (NoBooleanSolution e) {
			Activator.getDefault().error(e.getMessage(), e);
		} catch (SolverException e) {
			Activator.getDefault().error(e.getMessage(), e);
		} catch (SimulationException e) {
			Activator.getDefault().error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public ParallelStep<?,?> proposeLogicalStep() {
		int index = solverWrapper.proposeLogicalStepByIndex();
		ParallelStep<? extends Step<?>,?> result = null;
		if (_lastLogicalSteps.size() > index)
		{
			result = _lastLogicalSteps.get(index);			
		}
		return result;
	}
	@Override
	public void applyLogicalStep(ParallelStep<?, ?> logicalStep) {
		//_lastLogicalSteps = new ArrayList<>(ChocoHelper.lastChocoLogicalSteps);
		try {
			int index = getIndexOf(logicalStep);
			stepExecutor = solverWrapper.getSolver().getCurrentStepExecutor(); //saved until assertions have been retrieved
//			int index = _lastLogicalSteps.indexOf(logicalStep);

			solverWrapper.applyLogicalStepByIndex(index);
			resolveOccurrenceRelations(_intermediateResult.get(index));
		} catch (SolverException e) {
			Activator.getDefault().error(e.getMessage(), e);
		} catch (SimulationException e) {
			Activator.getDefault().error(e.getMessage(), e);
		}
	}

	private int getIndexOf(ParallelStep<?, ?> logicalStep) {
		parLoop: for(ParallelStep ps : _lastLogicalSteps) {
			subLoop: for(Step s : logicalStep.getSubSteps()) {
				if (!stepExists(s, ps)) {
					continue parLoop;
				}
			}
			return _lastLogicalSteps.indexOf(ps);
		}
		return 0;
	}

	private boolean stepExists(Step s, ParallelStep<? extends Step<?>, ?> ps) {
		for(Step ss: ps.getSubSteps()) {
			if (s.getMseoccurrence().getMse().equals(ss.getMseoccurrence().getMse())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public byte[] getState() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream objOut;
		try {
			objOut = new ObjectOutputStream(out);
	        objOut.writeObject(solverWrapper.getSolver().getCurrentState());
			return out.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void setState(byte[] serializableModel) {
		ByteArrayInputStream out = new ByteArrayInputStream(serializableModel);
        ObjectInputStream objOut;
		try {
			objOut = new ObjectInputStream(out);
	        Object o = objOut.readObject();
	        solverWrapper.getSolver().setCurrentState((CCSLConstraintState) o);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		solverWrapper.getSolver().clearStepData();
	}
	
	@Override
	public void revertForceClockEffect() {
		try {
			solverWrapper.revertForceClockEffect();
		} catch (SimulationException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void initialize(AbstractConcurrentModelExecutionContext context) 
	{
		if (context instanceof MoccmlModelExecutionContext){
			_alternativeExecutionModelPath = ((MoccmlModelExecutionContext)context).getRunConfiguration().getExecutionModelPath();
		}
		createSolver(context);
	}
	
	@Override
	public void prepareBeforeModelLoading(AbstractConcurrentModelExecutionContext context) 
	{
		generateMoC((MoccmlModelExecutionContext)context);
	}
	private void generateMoC(MoccmlModelExecutionContext context) 
	{
		IExecutionWorkspace workspace = context.getWorkspace();
		boolean mustGenerate = false;
		IFile mocFile = ResourcesPlugin.getWorkspace().getRoot().getFile(workspace.getMoCPath());		
		if (!mocFile.exists()
			|| 	ResourcesPlugin.getWorkspace().getRoot().getFile(workspace.getModelPath()).getLocalTimeStamp() > 
				ResourcesPlugin.getWorkspace().getRoot().getFile(workspace.getMoCPath()).getLocalTimeStamp()) 
		{
			mustGenerate = true;
		}
		IFile feedbackFile = ResourcesPlugin.getWorkspace().getRoot().getFile(getFeedbackPathFromMSEModelPath(workspace.getMSEModelPath()));
		if (!feedbackFile.exists()
				|| 	ResourcesPlugin.getWorkspace().getRoot().getFile(workspace.getModelPath()).getLocalTimeStamp() > 
					ResourcesPlugin.getWorkspace().getRoot().getFile(getFeedbackPathFromMSEModelPath(workspace.getMSEModelPath())).getLocalTimeStamp()) 
		{
			mustGenerate = true;
		}
		String transformationPath = context.getMoccmlLanguageAdditionExtension().getQVTOPath();
		if(transformationPath != null && transformationPath.length()!=0){
			final int bundleNameEnd=transformationPath.indexOf('/', 1);
		    final String bundleName=transformationPath.substring(1,bundleNameEnd);
		    Bundle bundle=Platform.getBundle(bundleName);
		    if (bundle != null) {
			    final URL bundleFileURL=bundle.getEntry(transformationPath.substring(bundleNameEnd));
				try {
					URL fileURL = FileLocator.toFileURL(bundleFileURL);
				    File transformationFile =new File(fileURL.getFile());
				    if (	feedbackFile.exists() &&
				    		transformationFile.lastModified() > 
							ResourcesPlugin.getWorkspace().getRoot().getFile(getFeedbackPathFromMSEModelPath(workspace.getMSEModelPath())).getLocalTimeStamp()) 
					{
						mustGenerate = true;
					}
				} catch (IOException e) {
					Activator.getDefault().error("QVTo file "+transformationPath+" not found, please verify your language specification", e);
				}
		      
		    }
		} else {
			Activator.getDefault().error("QVTo file  not correctly specified in plugin.xml, please verify your language specification");
			mustGenerate = false;
		}
		
		
		if (mustGenerate)
		{
//			Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
//			Map<String, Object> m = reg.getExtensionToFactoryMap();
//			m.put("timemodel", new XMIResourceFactoryImpl());
//
//			ResourceSet ccslResourceSet = new ResourceSetImpl();
//			this.solverInputURI = URI.createPlatformResourceURI(context.getWorkspace().getMoCPath().toString(), true);
//			Resource ccslResource = ccslResourceSet.getResource(this.solverInputURI, true);
//			
//			EcoreUtil.resolveAll(ccslResourceSet);
//			traceResources(ccslResourceSet);
//			traceUnresolvedProxies(ccslResourceSet, solverInputURI);			

			QvtoTransformationPerformer performer = new QvtoTransformationPerformer();
			performer.run(
						new ResourceSetImpl(),
						"platform:/plugin" + transformationPath, 
						context.getRunConfiguration().getExecutedModelURI().toString(), 
						"platform:/resource" + workspace.getMoCPath().toString(),
						"platform:/resource" + getFeedbackPathFromMSEModelPath(workspace.getMSEModelPath()).toString(),	
						"platform:/resource" + getPriorityPathFromMSEModelPath(workspace.getMSEModelPath()).toString());	
			// TODO must now generate the MSEModel based on this feedbackmodel, that'll wrap the ModelSpecificEvent from Timesquare to MSE for our internal trace
			generateMSEModel(context);
			// TODO must reload the model resourceSet since some element may have changed
		}		
	}

	/**
	 * generates a MSEModel that wraps the FeedbackModel used by Timesquare
	 */
	private void generateMSEModel(final AbstractConcurrentModelExecutionContext context){
		final URI feedbackURI = URI.createPlatformResourceURI(getFeedbackPathFromMSEModelPath(context.getWorkspace().getMSEModelPath()).toString(), true);
		final URI mseModelURI = URI.createPlatformResourceURI(context.getWorkspace().getMSEModelPath().toString(), true);
		
//		ResourceSet rs = context.getResourceModel().getResourceSet();
//		TransactionalEditingDomain edomain = org.eclipse.emf.transaction.TransactionalEditingDomain.Factory.INSTANCE.getEditingDomain(rs);
//		
//		edomain.getCommandStack().execute(new RecordingCommand(edomain) {
//			public void doExecute() {
		ResourceSet rs = new ResourceSetImpl();
				Resource feedBackRes = rs.getResource(feedbackURI, true);
				Resource mseRes = rs.createResource(mseModelURI);
				mseRes.getContents().clear();
				MSEModel mseModel = TraceFactory.eINSTANCE.createMSEModel();		
				mseRes.getContents().add(mseModel);
				ActionModel feedbackModel = (ActionModel)feedBackRes.getContents().get(0);
				if(feedbackModel!= null){
					for(ModelSpecificEvent feedbackModelSpecificEvent : feedbackModel.getEvents()){
						FeedbackMSE feedbackMSE = org.eclipse.gemoc.execution.concurrent.ccsljavaengine.concurrentmse.Concurrent_mseFactory.eINSTANCE.createFeedbackMSE();
						feedbackMSE.setFeedbackModelSpecificEvent(feedbackModelSpecificEvent);
						feedbackMSE.setName(feedbackModelSpecificEvent.getName());
						mseModel.getOwnedMSEs().add(feedbackMSE);
					}
				}
				try {
					mseRes.save(null);
				} catch (IOException e) {
					Activator.getDefault().error("Problem creating MSEModel from feedback model", e);
				}
//			}
//		});
		
		
		
		
	}
	
	@Override
	public void dispose() {
		this.solverWrapper=null;
	}
	
	public IPath getFeedbackPathFromMSEModelPath(IPath mseModelPath) 
	{
		IPath msePath= mseModelPath.removeFileExtension().addFileExtension("feedback");
		return msePath;
	}
	
	public IPath getPriorityPathFromMSEModelPath(IPath mseModelPath) 
	{
		IPath msePath= mseModelPath.removeFileExtension().addFileExtension("prioritymodel");
		return msePath;
	}

	
	protected GemocInstantRelationModelGenerator relationModelGenerator = null;
	protected List<ModelElementReference> listofclock;
	protected List<ModelElementReference> listofconstraint;
	protected List<EObject> listReferencedObject = new ArrayList<EObject>();
	protected List<Resource> listressource = new ArrayList<Resource>();
	protected  ArrayList<OccurrenceRelation> lastOccurrenceRelations = new ArrayList<OccurrenceRelation>(); // Relation
	public List<ModelElementReference> listofassert;
	public List<IDescription> listofrelation;

	
	private List<IDescription> getRelationDescription() {
		List<IDescription> lst = new ArrayList<IDescription>();
		try {
			EObject eo = solverWrapper.getResourceSet().getResources().get(0).getContents().get(0);
			relationModelGenerator = new GemocInstantRelationModelGenerator();
			if (relationModelGenerator == null)
				return lst; // relation ;
			relationModelGenerator.setListClock(listofclock);
			relationModelGenerator.setListRelation(listofconstraint);
			relationModelGenerator.extract(eo);
			lst = relationModelGenerator.getDescription();
		} catch (Throwable e) {
			System.err.println(e);
		}
		return lst;
	}
	
	public void initRelationModel() {
		relationModelGenerator = null;
		CCSLKernelSolverWrapper isolver = solverWrapper;
		if (isolver == null) {
			throw new RuntimeException("in CCSLSolver::resolveOccurrenceRelations, the solver has not been instantiated yet");
		}
		listofclock = Collections.unmodifiableList(isolver.getClockList());
		listofassert = Collections.unmodifiableList(isolver.getAssertList());
		listofconstraint = Collections.unmodifiableList(isolver.getConstraint());
		listofrelation = Collections.unmodifiableList(getRelationDescription());
		/***** Collect all reference Object *****/
		listReferencedObject = new ArrayList<EObject>();
		for (ModelElementReference r : listofclock) {
			AdapterRegistry.getAdapter(r).fillWithReferencedElements(r, listReferencedObject);
		}
		listReferencedObject = Collections.unmodifiableList(listReferencedObject);
		/****** Collect Resource of all reference Object ***/
		listressource = new ArrayList<Resource>();
		for (EObject el : listReferencedObject) {
			Resource rs = el.eResource();
			if (rs != null)
				if (!listressource.contains(rs)) {
					listressource.add(rs);
				}
		}
		listressource = Collections.unmodifiableList(listressource);

	}

	public List<OccurrenceRelation> resolveOccurrenceRelations(LogicalStep step) {
		try {
			if (((RelationModelListener) relationModelGenerator.irml).lrelation.size() == 0){
				relationModelGenerator.addClockConstraint(step);
//				System.out.println("initialization of the occurrence relation model: done");
			}
				relationModelGenerator.resolve(step);
				lastOccurrenceRelations.addAll(relationModelGenerator.getLastOccurrenceRelations());
		} catch (Throwable e) {

//			System.err.println("****************\nErreur Relation Model\n*****************\n");
			throw e;
		}
		
		return null;
	}

	@Override
	public List<OccurrenceRelation> getLastOccurrenceRelations() {
		return lastOccurrenceRelations;
	}

	@Override
	public void setExecutableModelResource(Resource execModelResource) {
		Class<? extends EObject> clazz = execModelResource.getContents().get(0).getClass();
		//EcoreUtil.resolveAll(_MSEModel.eResource());
		
		
		 for(Resource r: _MSEModel.eResource().getResourceSet().getResources()) {
				if(r.getContents().get(0).getClass() == clazz){
					_MSEModel.eResource().getResourceSet().getResources().remove(r);
					doChangeExecModel(execModelResource);
					return;
				}
		 }
		 doChangeExecModel(execModelResource);
		 return;
	}

	private void doChangeExecModel(Resource execModelResource) {
		final Resource r = execModelResource;
		TransactionalEditingDomain editingDomain = org.eclipse.emf.transaction.TransactionalEditingDomain.Factory.INSTANCE.getEditingDomain(_MSEModel.eResource().getResourceSet());
		final CommandStack commandStack = editingDomain.getCommandStack();
		commandStack.execute(new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				//Save DiagramDialog at proper position
				_MSEModel.eResource().getResourceSet().getResources().add(r);
			}
		});
	}
	
	
	
	@Override
	public List<String> getAssertionViolations() {
		ArrayList<String> res = new ArrayList<>();
		if (assertionList == null) { //lazy initialization
			assertionList = solverWrapper.getAssertList();
		}
		for(ModelElementReference assertion : assertionList) {
			 List<String> nameList = new ArrayList<String>();
			 for(EObject eo : assertion.getElementRef()) {
				 nameList.add(((NamedElement)eo).getName());
			 }
			String qn = String.join("::", nameList);
			if (stepExecutor.isAssertionViolated(qn)) {
				res.add(qn);
			}
		}
		stepExecutor = null; //not needed anymore, flushed
		return res;
	}

	public void addClockCoincidence(EventOccurrence occ1, EventOccurrence occ2) {
		solverWrapper.addClockCoincidence((ModelElementReference)occ1.getReferedElement(), (ModelElementReference)occ2.getReferedElement());
	}	
	
	
	
	//formal Analysis stuff, implementing org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.moc.ICCSLExplorer
	
	
	StepExecutor stepExecutor = null;
	
	@Override
	public void initSolverForExploration() {
		stepExecutor = new StepExecutor(this.getSolverWrapper().getSolver());
		this.getSolverWrapper().getSolver().setCurrentStepExecutor(stepExecutor); //convenience to force clocks
		stepExecutor.inSimulationMode = false;
		stepExecutor.clearStepData();
		stepExecutor.stepPreHook();
		try {
			stepExecutor.computePossibleClockStates();
		} catch (SimulationException e) {
			e.printStackTrace();
		}
	}

		@Override
		public void prepareSolverForNewStepForExploration() {
			stepExecutor.clearFiredClock();
			try {
				stepExecutor.computePossibleClockStates(); // hack to change
														   // constraint state
														   // from semantics!!

			} catch (SimulationException e) {
				e.printStackTrace();
			} 
		}
		
		@Override
		public void resetCurrentStepForExploration() {
			stepExecutor.clearStepData();
			stepExecutor.freeAll();
		}

		@Override
		public List<Step<?>> computeAndGetPossibleLogicalStepsForExploration() {
			
			try {
				_intermediateResult = stepExecutor.computeAndGetPossibleLogicalSteps();
						//solverWrapper.computeAndGetPossibleLogicalSteps();			
				_lastLogicalSteps.clear();
				for (fr.inria.aoste.trace.LogicalStep lsFromTimesquare : _intermediateResult)
				{
					ParallelStep<? extends Step<?>, ?> lsFromTrace = createLogicalStep(lsFromTimesquare);
					_lastLogicalSteps.add(lsFromTrace);
				}
				return new ArrayList<Step<?>>(_lastLogicalSteps);
			} catch (NoBooleanSolution e) {
				Activator.getDefault().error(e.getMessage(), e);
			} catch (SolverException e) {
				Activator.getDefault().error(e.getMessage(), e);
			} catch (SimulationException e) {
				Activator.getDefault().error(e.getMessage(), e);
			}
			return new ArrayList<Step<?>>();
		}
		
		
		@Override
		public Set<ParallelStep<? extends Step<?>, ?>> updatePossibleLogicalStepsForExploration() {
			
			try {
				_intermediateResult = stepExecutor.getAllSolutions();
						//solverWrapper.computeAndGetPossibleLogicalSteps();			
				_lastLogicalSteps.clear();
				for (fr.inria.aoste.trace.LogicalStep lsFromTimesquare : _intermediateResult)
				{
					ParallelStep<? extends Step<?>, ?> lsFromTrace = createLogicalStep(lsFromTimesquare);
					_lastLogicalSteps.add(lsFromTrace);
				}
				return new HashSet<ParallelStep<? extends Step<?>, ?>>(_lastLogicalSteps);
			} catch (NoBooleanSolution e) {
				Activator.getDefault().error(e.getMessage(), e);
			}
			return new HashSet<ParallelStep<? extends Step<?>, ?>>();
		}
		
		
		@Override
		public void applyLogicalStepForExploration(Step<?> logicalStep) {
			try {
				int index = _lastLogicalSteps.indexOf(logicalStep);
				stepExecutor.applyLogicalStepByIndex(index);
				//solverWrapper.applyLogicalStepByIndex(index);
				resolveOccurrenceRelations(_intermediateResult.get(index));
			} catch (SolverException e) {
				Activator.getDefault().error(e.getMessage(), e);
			} catch (SimulationException e) {
				Activator.getDefault().error(e.getMessage(), e);
			}
		}



	
}
