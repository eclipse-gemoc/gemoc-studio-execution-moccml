package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.eventscheduling.trace;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.tuple.Pair;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.engine.MoccmlExecutionEngine;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.dsa.helper.IK3ModelStateHelper;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelState;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dse.IMoccmlFutureAction;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.moc.ICCSLSolver;
import org.eclipse.gemoc.executionframework.engine.Activator;
import org.eclipse.gemoc.executionframework.reflectivetrace.gemoc_execution_trace.Choice;
import org.eclipse.gemoc.executionframework.reflectivetrace.gemoc_execution_trace.ContextState;
import org.eclipse.gemoc.executionframework.reflectivetrace.gemoc_execution_trace.ExecutionTraceModel;
import org.eclipse.gemoc.executionframework.reflectivetrace.gemoc_execution_trace.Gemoc_execution_traceFactory;
import org.eclipse.gemoc.executionframework.reflectivetrace.gemoc_execution_trace.ModelState;
import org.eclipse.gemoc.executionframework.reflectivetrace.gemoc_execution_trace.SolverState;
import org.eclipse.gemoc.trace.gemoc.concurrent.AbstractEventSchedulingModelExecutionTracingAddon;

public class MoccmlEventSchedulingModelExecutionTracingAddon extends AbstractEventSchedulingModelExecutionTracingAddon {

	private IK3ModelStateHelper modelStateHelper;

	private IK3ModelStateHelper obtainModelStateHelper() {
		if (modelStateHelper == null) {

			String fullLanguageName = this._executionEngine.getExecutionContext().getLanguageDefinitionExtension()
					.getName();
			int lastDot = fullLanguageName.lastIndexOf(".");
			if (lastDot == -1)
				lastDot = 0;
			String languageName = fullLanguageName.substring(lastDot + 1);
			String languageToUpperFirst = languageName.substring(0, 1).toUpperCase() + languageName.substring(1);
			try {
				modelStateHelper = (IK3ModelStateHelper) this._executionEngine
						.getExecutionContext().getDslBundle().loadClass(languageToUpperFirst.toLowerCase()
								+ ".xdsml.api.impl." + languageToUpperFirst + "ModelStateHelper")
						.getConstructor().newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		}
		return modelStateHelper;
	}

	
	private MoccmlExecutionEngine castEngine() {
		return ((MoccmlExecutionEngine) this._executionEngine);
	}
	
	@Override
	protected void storeSolverState(ContextState contextState) {
		MoccmlExecutionEngine engine_cast =castEngine();
		Pair<Map<String, Boolean>, ArrayList<IMoccmlFutureAction>> engineState = engine_cast.saveState();

		ICCSLSolver solver_cast = engine_cast.getSolver();

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream objOut;
		byte[] serializableEngineState = null;
		try {
			objOut = new ObjectOutputStream(out);
			objOut.writeObject(Pair.of(engineState, solver_cast.getState()));
			serializableEngineState = out.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}

		SolverState solverState = Gemoc_execution_traceFactory.eINSTANCE.createSolverState();
		solverState.setSerializableModel(serializableEngineState);
		contextState.setSolverState(solverState);

	}

	@Override
	protected void restoreSolverState(Choice choice) {
		ICCSLSolver solver = castEngine().getSolver();
		Activator.getDefault()
				.debug("restoring solver state: " + choice.getContextState().getSolverState().getSerializableModel());

		byte[] moccmlEngineState = choice.getContextState().getSolverState().getSerializableModel();
		ByteArrayInputStream out = new ByteArrayInputStream(moccmlEngineState);
		ObjectInputStream objOut;
		Object thePair = null;
		try {
			objOut = new ObjectInputStream(out);
			thePair = objOut.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		castEngine()
				.restoreState((Pair<Map<String, Boolean>, ArrayList<IMoccmlFutureAction>>) ((Pair) thePair).getLeft());
		solver.setState((byte[]) ((Pair) thePair).getRight());
	}

	@Override
	protected void restoreModelState(ModelState state) {
		obtainModelStateHelper().restoreModelState((K3ModelState) state.getModel());
	}

	@Override
	protected void storeModelStateIfChanged() {
		Resource traceResource = this._executionTraceModel.eResource();
		if (traceResource.getContents().size() > 0) {

			ExecutionTraceModel traceModel = (ExecutionTraceModel) traceResource.getContents().get(0);

//			if (stateChanged || currentState == null) {
			Activator.getDefault().debug(String.format("[trace-%10s] new model state %3d detected",
					this.getCurrentEngineShortName(), traceModel.getReachedStates().size()));
			// new way to save RTDs

			EObject model = this._executionEngine.getExecutionContext().getResourceModel().getContents().get(0);
			K3ModelState result = obtainModelStateHelper().getK3ModelState(model);

			// No one needs to observe the clone
			result.eAdapters().clear();
			ModelState modelState = null;
			modelState = Gemoc_execution_traceFactory.eINSTANCE.createModelState();
			traceModel.getReachedStates().add(modelState);
			modelState.setModel(result);
			traceResource.getContents().add(result);
//				stateChanged = false;
			this.currentState = modelState;
		}
//		}
	}

}
