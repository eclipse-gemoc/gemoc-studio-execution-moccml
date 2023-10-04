/*******************************************************************************
 * Copyright (c) 2017, 2019 INRIA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     INRIA - initial API and implementation
 *     I3S Laboratory - API update and bug fix
 *******************************************************************************/
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.launcher;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.commons.MoccmlModelExecutionContext;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.commons.MoccmlRunConfiguration;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.dsa.executors.explorer.ExhaustiveConcurrentExecutionEngine;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.engine.MoccmlExecutionEngine;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.Activator;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.views.stimulimanager.StimuliManagerView;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.IMoccmlRunConfiguration;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.moc.ICCSLSolver;
import org.eclipse.gemoc.executionframework.engine.commons.EngineContextException;
import org.eclipse.gemoc.executionframework.engine.concurrency.AbstractConcurrentExecutionEngine;
import org.eclipse.gemoc.executionframework.engine.ui.concurrency.launcher.AbstractConcurrentLauncher;
import org.eclipse.gemoc.xdsmlframework.api.core.ExecutionMode;

public class MoccmlLauncher extends AbstractConcurrentLauncher<IMoccmlRunConfiguration, MoccmlModelExecutionContext> {

	@Override
	protected AbstractConcurrentExecutionEngine<MoccmlModelExecutionContext, IMoccmlRunConfiguration> createEngine(
			IMoccmlRunConfiguration runConfiguration, ExecutionMode executionMode)
			throws EngineContextException, CoreException {

		MoccmlExecutionEngine _executionEngine = null;

		MoccmlModelExecutionContext concurrentexecutionContext = new MoccmlModelExecutionContext(runConfiguration,
				executionMode);
		concurrentexecutionContext.initializeResourceModel();
		ICCSLSolver _solver = null;
		try {
			_solver = (ICCSLSolver) concurrentexecutionContext.getMoccmlLanguageAdditionExtension().instanciateSolver();
			_solver.prepareBeforeModelLoading(concurrentexecutionContext);
			_solver.initialize(concurrentexecutionContext);
		} catch (CoreException e) {
			throw new CoreException(new Status(Status.ERROR, Activator.PLUGIN_ID,
					"Cannot instanciate solver from language definition", e));
		}

		if (runConfiguration.getIsExhaustiveSimulation()) {
			_executionEngine = new ExhaustiveConcurrentExecutionEngine(concurrentexecutionContext, _solver);
		} else {
			_executionEngine = new MoccmlExecutionEngine(concurrentexecutionContext, _solver);
		}

		return _executionEngine;

	}
	
	@Override
	protected IMoccmlRunConfiguration createRunConfiguration(ILaunchConfiguration launchConfiguration)
			throws CoreException {
		return new MoccmlRunConfiguration(launchConfiguration);
	}

	@Override
	protected Set<String> getAdditionalViewsIDs() {
		Set<String> result = new HashSet<String>();
		result.add(StimuliManagerView.ID);
		return result;
	}

}
