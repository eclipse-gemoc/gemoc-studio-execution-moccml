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
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.deciders;

import java.util.List;
import java.util.concurrent.Semaphore;

import org.eclipse.gemoc.commons.eclipse.ui.ViewHelper;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.SharedIcons;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.views.step.LogicalStepsView;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.AbstractConcurrentExecutionEngine;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.ILogicalStepDecider;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.moc.DeciderException;
import org.eclipse.gemoc.trace.commons.model.trace.Step;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener2;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;

public abstract class AbstractUserDecider implements ILogicalStepDecider 
{

	public AbstractUserDecider() 
	{
		super();
	}
	
	private Step _selectedLogicalStep;

	private Semaphore _semaphore = null;

	@Override
	public Step decide(final AbstractConcurrentExecutionEngine engine, final List<Step<?>> possibleLogicalSteps) throws DeciderException
			 {
		_preemptionHappened = false;
		_semaphore = new Semaphore(0);
		if(!isStepByStep() 
			&& engine.getPossibleLogicalSteps().size() == 1) 
			return possibleLogicalSteps.get(0);

		decisionView = ViewHelper.<LogicalStepsView>retrieveView(LogicalStepsView.ID);
		decisionView.refresh();
		
		// add action into view menu
		IMenuListener2 menuListener = new IMenuListener2() 
		{
		
			private Action _action = null;
						
			public void menuAboutToShow(IMenuManager manager) 
			{
				if (_action == null
					&& decisionView.getSelectedLogicalStep() != null
					&& engine.getPossibleLogicalSteps().contains(decisionView.getSelectedLogicalStep())) 
				{
					_action = createAction();
				}
				if (decisionView.getSelectedLogicalStep() != null
					&& _action != null)
					manager.add(_action);
			}

			public void menuAboutToHide(IMenuManager manager) 
			{
				if (_action != null)
					manager.remove(_action.getId());
			}
		};
		decisionView.addMenuListener(menuListener);
		
		// add action on double click
		IDoubleClickListener doubleClickListener = new IDoubleClickListener() 
		{
			public void doubleClick(DoubleClickEvent event) 
			{
				if (decisionView.getSelectedLogicalStep() != null
					&& engine.getPossibleLogicalSteps().contains(decisionView.getSelectedLogicalStep())) 
				{
					Action selectLogicalStepAction = new Action() 
					{
						public void run() 
						{
							_selectedLogicalStep = decisionView.getSelectedLogicalStep();
							_semaphore.release();
						}
					};
					selectLogicalStepAction.run();
				}
			}
		};
		decisionView.addDoubleClickListener(doubleClickListener);
		
		
		// wait for user selection if it applies to this engine
		try {
			_semaphore.acquire();
		} catch (InterruptedException e) {
			throw new DeciderException(e);
		}
		_semaphore = null;
		// clean menu listener
		decisionView.removeMenuListener(menuListener);
		decisionView.removeDoubleClickListener(doubleClickListener);
		if (_preemptionHappened)
			return null;
		return _selectedLogicalStep;
	}

	private LogicalStepsView decisionView;

	@Override
	public void dispose() {
		if (_semaphore != null)
			_semaphore.release();
		decisionView.refresh();
	}

	private boolean _preemptionHappened = false;
	@Override
	public void preempt() 
	{
		_preemptionHappened = true;
		if (_semaphore != null)
			_semaphore.release();
	}
	
	private Action createAction() {
		
		Action selectLogicalStepAction = new Action() 
		{
			public void run() 
			{
				_selectedLogicalStep = decisionView.getSelectedLogicalStep();
				_semaphore.release();
			}
		};
		selectLogicalStepAction.setId("org.eclipse.gemoc.executionframework.engine.io.commands.SelectLogicalStep");
		selectLogicalStepAction.setText("Select LogicalStep");
		selectLogicalStepAction.setToolTipText("Use selected LogicalStep");
		selectLogicalStepAction.setImageDescriptor(SharedIcons.LOGICALSTEP_ICON);
		return selectLogicalStepAction;
	}

	public abstract boolean isStepByStep();

	public void decideFromTimeLine(Step logicalStep)
	{
		_selectedLogicalStep = logicalStep;
		if (_semaphore != null)
			_semaphore.release();
	}
	
}
