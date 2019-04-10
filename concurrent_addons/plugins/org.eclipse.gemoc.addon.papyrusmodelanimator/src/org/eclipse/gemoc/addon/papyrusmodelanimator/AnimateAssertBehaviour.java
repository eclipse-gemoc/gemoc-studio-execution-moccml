/*******************************************************************************
 * Copyright (c) 2017 I3S laboratory, INRIA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     I3S laboratory and INRIA Kairos - initial API and implementation
 *******************************************************************************/
package org.eclipse.gemoc.addon.papyrusmodelanimator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLFactory;

import fr.inria.aoste.timesquare.backend.manager.visible.Behavior;
import fr.inria.aoste.timesquare.backend.manager.visible.ClockBehavior;
import fr.inria.aoste.timesquare.backend.manager.visible.ClockEntity;
import fr.inria.aoste.timesquare.backend.manager.visible.TraceHelper;

public class AnimateAssertBehaviour implements ClockBehavior{

	
	private final class StartSetCommentOperation extends AbstractEMFOperation {
	
		public StartSetCommentOperation(GraphicalEditPart theEditPart) {
			super(theEditPart.getEditingDomain(), "SetComment");
		}
	
		@Override
		protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			// TODO: fix that... the comment is created but not in the model
			// displayed by papyrus...
			if (_comment == null)
				_comment = _elem.createOwnedComment();
			_comment.setBody("CCSL violation of "+ _assertName +":\n   number of violation: " + _assertCounter+"\n\nstep where violation occurs :\n"+_stepsOfViolation);
			try {
				List<?> views = DiagramEditPartsUtil.getEObjectViews(_comment);
				Iterator<?> it = views.iterator();
				if (it.hasNext()){
					_elemShape = (ShapeStyle) it.next();
					_originalColor = _elemShape.getFillColor();
				}

			} catch (Exception e) {

			}
			return Status.OK_STATUS;
		}
	}

	private static final class SetColorRun extends AbstractEMFOperation {
	
		private AnimateAssertBehaviour aab = null;
	
		public SetColorRun(AnimateAssertBehaviour aab) {
			super(aab.theEditPart.getEditingDomain(), "SetColor");
			this.aab = aab;
		}
	
		@Override
		protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			List<?> views = DiagramEditPartsUtil.getEObjectViews(aab._comment);
			Iterator<?> it = views.iterator();
			if (it.hasNext()){
				aab._elemShape = (ShapeStyle) it.next();
			}
			if (aab._elemShape != null) {
	
				{

					aab._elemShape.setFillColor(255);
					int newcolor = aab._elemShape.getFillColor();
					aab.tablecolor.put( Integer.valueOf(aab._helper.getCurrentStepNumber()), Integer.valueOf(newcolor));
				}
			}
				aab._comment.setBody("CCSL violation of "+ aab._assertName +":\n   number of violation: " + aab._assertCounter+"\n\nstep where violation occurs :\n"+aab._stepsOfViolation);
	
			return Status.OK_STATUS;
		}
	}

	private static final class SetColorRunWrongActivationState extends AbstractEMFOperation {
	
		private final AnimateAssertBehaviour aab;
	
		public SetColorRunWrongActivationState(AnimateAssertBehaviour aab) {
			super(aab.theEditPart.getEditingDomain(), "SetColor");
			this.aab = aab;
		}
	
		@Override
		protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			List<?> views = DiagramEditPartsUtil.getEObjectViews(aab._comment);
			Iterator<?> it = views.iterator();
			if (it.hasNext()){
				aab._elemShape = (ShapeStyle) it.next();
			}
			if (aab._helper.getClockState().isIsClockDead()) {
				aab._elemShape.setFillColor(12632256);
			} else {
				{
	
				aab._elemShape.setFillColor(aab._originalColor);
				int newcolor = aab._elemShape.getFillColor();		
				aab.tablecolor.put( Integer.valueOf(aab._helper.getCurrentStepNumber()), Integer.valueOf(newcolor));
	
				}
			}
			//aab._comment.setBody("CCSL assert violation:\n   number of violation: " + aab._assertCounter);
			return Status.OK_STATUS;
		}
	}

	private static final class SetColorAgain extends AbstractEMFOperation {
	
		private final AnimateAssertBehaviour aab;
		private final int color;
	
		public SetColorAgain(AnimateAssertBehaviour _aab, int _color) {
			super(_aab.theEditPart.getEditingDomain(), "SetColor");
			this.aab = _aab;
			Integer n= Integer.valueOf(aab._helper.getCurrentStepNumber());
			if ( aab.tablecolor.containsKey(n))
				this.color= aab.tablecolor.get(n).intValue();
			else				
				this.color = _color;
	
		}
	
		@Override
		protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			List<?> views = DiagramEditPartsUtil.getEObjectViews(aab._comment);
			Iterator<?> it = views.iterator();
			if (it.hasNext()){
				aab._elemShape = (ShapeStyle) it.next();
			}
			aab._elemShape.setFillColor(color);
	
			return Status.OK_STATUS;
		}
	}

	private static final class RunnableRun implements Runnable {
	
		private final AnimateAssertBehaviour aab;
	
		public RunnableRun(AnimateAssertBehaviour _aab) {
			super();
			this.aab = _aab;
		}
	
		public void run() {
			try {
				aab._diagramEditPart.activate();
				AbstractEMFOperation cmd = new SetColorRun(aab);
 				try {
					cmd.execute(new NullProgressMonitor(), null);
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
	
				aab._diagramEditPart.refresh();
			} catch (Throwable e) {
				System.err.println(e);
			}
		}
	
	}

	private static final class RunnnableWithWrongActivationState implements Runnable {
		private final AnimateAssertBehaviour aab;
	
		public RunnnableWithWrongActivationState(AnimateAssertBehaviour _aab) {
			super();
			this.aab = _aab;
		}
	
		public void run() {
			try {
				aab._diagramEditPart.activate();
				AbstractEMFOperation cmd = new SetColorRunWrongActivationState(aab);	
				try {
					cmd.execute(null, null);
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
	
				aab._diagramEditPart.refresh();
			} catch (Throwable e) {
				System.err.println(e);
			}
		}
	}
	
	/**
	 * This method is called in debug mode when a step has already been computed
	 * but is visited again
	 */
	private static final class AgainRunnable implements Runnable {
	
		private final AnimateAssertBehaviour aab;
	
		private int color;
		
	
		public AgainRunnable(AnimateAssertBehaviour aab, int color) {
			super();
			this.aab = aab;
			this.color = color;
		}

		public void run() {
			try {
				aab._diagramEditPart.activate();
				AbstractEMFOperation cmd = new SetColorAgain(aab, color);
				try {
					cmd.execute(null, null);
				} catch (ExecutionException e) {					
					e.printStackTrace();
				}	
				aab._diagramEditPart.refresh();
			} catch (Throwable e) {
				System.err.println(e);
			}
		}
	}

	
	
	private int _assertCounter = 0;
	private int _originalColor;
	private int _currentStep=0;
	private String _stepsOfViolation="\t";
	private GraphicalEditPart theEditPart = null;
	private ShapeStyle _elemShape = null;
	private DiagramEditPart _diagramEditPart = null;
	private Comment _comment = null;
	private String _assertName = "";
	private TraceHelper _helper = null;
	private NamedElement _elem = null;
	private HashMap<Integer, Integer> tablecolor=new HashMap<Integer, Integer>();
	final ClockEntity _ae;
	
	public AnimateAssertBehaviour(ClockEntity ae) {
		super();
		_ae = ae;
		_assertName = _ae.getName();
		
	}

	public String getDescription() {	
		return "Papyrus Animator";
	}


	public void setEditPart(DiagramEditPart _diagramEditPart) {
		this._diagramEditPart = _diagramEditPart;
	}

	public void start() {
		if (_diagramEditPart != null)
			if (_diagramEditPart.resolveSemanticElement() instanceof NamedElement) {
					theEditPart = _diagramEditPart;
					AbstractEMFOperation cmd = new StartSetCommentOperation(theEditPart);
					_elem = ((NamedElement) _diagramEditPart.resolveSemanticElement());					
					
					try {
						cmd.execute(null, null);
					} catch (ExecutionException e) {
						e.printStackTrace();
						_comment = UMLFactory.eINSTANCE.createComment();
					}
					if (_comment == null) {
						_comment = UMLFactory.eINSTANCE.createComment();
					}

			}

	}

	public void run(TraceHelper helper) {
		if (_diagramEditPart != null) {
			theEditPart=_diagramEditPart;
			_helper = helper;
			_assertCounter++;
			_currentStep = _helper.getCurrentStepNumber();
			_stepsOfViolation += _currentStep+"\n\t";
			Display.getDefault().syncExec(new RunnableRun(this));
			_helper = null;
		}
	}

	public void runWithWrongActivationState(TraceHelper helper) {
		if (_diagramEditPart != null) {
			theEditPart=_diagramEditPart;
			_helper = helper;
			Display.getDefault().syncExec(new RunnnableWithWrongActivationState(this));
			_helper = null;
		}
	}

	
	/**
	 * This method is called in debug mode when a step has already been computed
	 * but is visited again
	 */
	public void againRun(TraceHelper helper) {
		if (theEditPart != null && _diagramEditPart != null) {		
			_helper = helper;
			Display.getDefault().syncExec(new AgainRunnable(this,255));
			_helper = null;
		}
	}

	/**
	 * This method is called in debug mode when a step has already been computed
	 * but is visited again
	 */
	public void againRunWithWrongActivationState(TraceHelper helper) {
		if (theEditPart != null && _diagramEditPart != null) {
			_helper = helper;
			Display.getDefault().syncExec(new AgainRunnable(this,_originalColor));
			_helper = null;
		}

	}
	
	public boolean behaviorEquals(Behavior behavior) {
		if (behavior==this)
			return true;		
		return false;
	}
	
	public int getSizeofTableColor()
	{
		return tablecolor.size();
	}

	protected NamedElement getNamedElement() {
		return _elem;
	}
}
