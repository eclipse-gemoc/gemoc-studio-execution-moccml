package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.engine;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.commons.CodeExecutorBasedExecutionPlatform;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.commons.MoccmlModelExecutionContext;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.AbstractConcurrentExecutionEngine;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.AbstractConcurrentModelExecutionContext;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.IConcurrentRunConfiguration;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dsa.executors.CodeExecutionException;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dsa.executors.ICodeExecutor;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.moc.ISolver;
import org.eclipse.gemoc.executionframework.engine.Activator;
import org.eclipse.gemoc.executionframework.engine.core.CommandExecution;
import org.eclipse.gemoc.trace.commons.model.trace.ParallelStep;

import fr.inria.diverse.k3.al.annotationprocessor.InitializeModel;

public abstract class AbstractSolverCodeExecutorConcurrentEngine<C extends AbstractConcurrentModelExecutionContext<R, ? extends CodeExecutorBasedExecutionPlatform, ?>, R extends IConcurrentRunConfiguration, S extends ISolver>
		extends AbstractConcurrentExecutionEngine<C, R> {

	protected S _solver;

	protected void setSolver(S solver) {
		_solver = solver;

	}

	public S getSolver() {
		return _solver;
	}

	protected ICodeExecutor getCodeExecutor() {
		return getExecutionContext().getExecutionPlatform().getCodeExecutor();
	}

	protected final Set<ParallelStep<?,?>> computeWithoutUpdatePossibleLogicalSteps() {
		return getSolver().computeAndGetPossibleLogicalSteps();
	}

	protected Set<ParallelStep<?,?>> updatePossibleLogicalSteps() {
		beforeUpdatePossibleLogicalSteps();
		return getSolver().updatePossibleLogicalSteps();
	}

	protected abstract void beforeUpdatePossibleLogicalSteps();

	@Override
	protected Set<ParallelStep<?,?>> computeInitialLogicalSteps() {
		computeWithoutUpdatePossibleLogicalSteps();
		synchronized (this) {
			return updatePossibleLogicalSteps();
		}
	}
	

	@Override
	protected final void finishDispose() {
		getSolver().dispose();
	}

	@Override
	public String toString() {
		return this.getClass().getName() + "@[Executor=" + getCodeExecutor() + " ; Solver=" + getSolver()
				+ " ; ModelResource=" + _executionContext.getResourceModel() + "]";
	}

	protected void executeInitializeModelMethod(MoccmlModelExecutionContext executionContext) {

		String modelInitializationMethodQName = executionContext.getRunConfiguration().getModelInitializationMethod();
		if (!modelInitializationMethodQName.isEmpty()) {
			Object target = executionContext.getResourceModel().getContents().get(0);
			String modelInitializationMethodName = modelInitializationMethodQName
					.substring(modelInitializationMethodQName.lastIndexOf(".") + 1);
			Activator.getDefault()
					.debug("*** Calling Model initialization method " + modelInitializationMethodName + "(). ***");

			final ArrayList<Object> modelInitializationParameters = new ArrayList<>();
			ICodeExecutor codeExecutor = getExecutionContext().getExecutionPlatform().getCodeExecutor();
			ArrayList<Object> parameters = new ArrayList<Object>();
			// try with String[] args
			parameters.add(new String[1]);
			List<Method> methods = codeExecutor.findCompatibleMethodsWithAnnotation(target, parameters,
					InitializeModel.class);
			if (!methods.isEmpty()) {
				modelInitializationParameters
						.add(executionContext.getRunConfiguration().getModelInitializationArguments().split("\\r?\\n"));
			} else {
				// try with List<String>
				parameters.clear();
				parameters.add(new ArrayList<String>());
				methods.addAll(
						codeExecutor.findCompatibleMethodsWithAnnotation(target, parameters, InitializeModel.class));
				if (!methods.isEmpty()) {
					ArrayList<String> modelInitializationArgs = new ArrayList<>();
					for (String s : executionContext.getRunConfiguration().getModelInitializationArguments()
							.split("\\r?\\n")) {
						modelInitializationArgs.add(s);
					}
					modelInitializationParameters.add(modelInitializationArgs);
				} else {
					// try with EList<String>
					parameters.clear();
					parameters.add(new BasicEList<String>());
					methods.addAll(codeExecutor.findCompatibleMethodsWithAnnotation(target, parameters,
							InitializeModel.class));
					if (!methods.isEmpty()) {
						BasicEList<String> modelInitializationArgs = new BasicEList<>();
						for (String s : executionContext.getRunConfiguration().getModelInitializationArguments()
								.split("\\r?\\n")) {
							modelInitializationArgs.add(s);
						}
						modelInitializationParameters.add(modelInitializationArgs);
					}
				}
			}
			ResourceSet rs = getExecutionContext().getResourceModel().getResourceSet();
			final TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Factory.INSTANCE
					.getEditingDomain(rs);
			if (editingDomain != null) {
				final RecordingCommand command = new RecordingCommand(editingDomain,
						"execute  " + modelInitializationMethodQName) {
					private List<Object> result = new ArrayList<Object>();

					@Override
					protected void doExecute() {
						try {
							result.add(codeExecutor.execute(target, modelInitializationMethodName,
									modelInitializationParameters));
							Activator.getDefault().debug("*** Model initialization done. ***");
						} catch (CodeExecutionException e) {
							Activator.getDefault().error("Exception while initializing model " + e.getMessage(), e);
						}
					}

					@Override
					public Collection<?> getResult() {
						return result;
					}
				};
				CommandExecution.execute(editingDomain, command);
			} else {
				try {
					codeExecutor.execute(target, modelInitializationMethodName, modelInitializationParameters);
					Activator.getDefault().debug("*** Model initialization done. ***");
				} catch (CodeExecutionException e) {
					Activator.getDefault().error("Exception while initializing model " + e.getMessage(), e);
				}
			}
		} else {
			Activator.getDefault().debug(
					"*** Model initialization done. (no modelInitialization method defined for the language) ***");
		}

	}

}
