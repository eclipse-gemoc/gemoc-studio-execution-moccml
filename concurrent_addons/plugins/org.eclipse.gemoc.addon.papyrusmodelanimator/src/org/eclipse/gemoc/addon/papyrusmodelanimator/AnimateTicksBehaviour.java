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
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.NamedElement;

import fr.inria.aoste.timesquare.backend.manager.visible.Behavior;
import fr.inria.aoste.timesquare.backend.manager.visible.ClockEntity;
import fr.inria.aoste.timesquare.backend.manager.visible.TraceHelper;
import fr.inria.aoste.timesquare.trace.util.adapter.AdapterRegistry;
import fr.inria.aoste.timesquare.trace.util.adapter.IModelAdapter.EventEnumerator;

public class AnimateTicksBehaviour {

	private static final class SetColorRun extends AbstractEMFOperation {
	
		private AnimateTicksBehaviour atb = null;
	
		public SetColorRun(AnimateTicksBehaviour atb) {
			super(atb.theEditPart.getEditingDomain(), "SetColor");
			this.atb = atb;
		}
	
		@Override
		protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
	
			if (atb._elemShape != null) {
					switch (atb.ek) {
					case START:
						atb._elemShape.setFillColor(255);
						break;
	
					case SEND:
						atb._elemShape.setFillColor(127000000);
						break;
	
					case PRODUCE:
						atb._elemShape.setFillColor(127000000);
						break;
	
					case FINISH:
						atb._elemShape.setFillColor(atb._originalColor);
						break;
	
					case CONSUME:
						atb._elemShape.setFillColor(067000);
						break;
	
					case RECEIVE:
						atb._elemShape.setFillColor(067000);
						break;
					case UNDEFINED:
						atb._elemShape.setFillColor(255);
	
					}
			}
			
			if(atb._comment != null) {
				atb._comment.setBody("CCSL simulation results:\n   number of activation: " + atb._clockCounter
					+ "\n   schedule: " + atb._schedule);
			}
			return Status.OK_STATUS;
		}
	}

	private static final class RestoreDefault extends AbstractEMFOperation implements Runnable {
		private AnimateTicksBehaviour atb = null;
	
		public RestoreDefault(AnimateTicksBehaviour atb) {
			super(atb.theEditPart.getEditingDomain(), "RestoreDefault");
			this.atb = atb;
		}
	
		@Override
		protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			if (atb._elemShape != null) {
				atb._elemShape.setFillColor(atb._originalColor);
			}	
			return Status.OK_STATUS;
		}

		@Override
		public void run() {
			try {
//				atb._diagramEditPart.activate();
				try {
					this.execute(null, null);
				} catch (ExecutionException e) {					
					e.printStackTrace();
				}	
//				atb._diagramEditPart.refresh();
			} catch (Throwable e) {
				System.err.println(e);
			}
		}
	}
	

	private static final class RunnableRun implements Runnable {
	
		private final AnimateTicksBehaviour atb;
	
		public RunnableRun(AnimateTicksBehaviour _atb) {
			super();
			this.atb = _atb;
		}
	
		public void run() {
			try {
				//atb._diagramEditPart.activate();
				AbstractEMFOperation cmd = new SetColorRun(atb);
	
			//	atb._clockCounter++;
				atb._schedule += '1';
	
				try {
					cmd.execute(new NullProgressMonitor(), null);
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
	
			//	atb._diagramEditPart.refresh();
			} catch (Throwable e) {
				System.err.println(e);
			}
		}
	
	}

	
	private int _clockCounter = 0;
	private int _originalColor;
	private GraphicalEditPart theEditPart = null;
	private ShapeStyle _elemShape = null;
	private DiagramEditPart _diagramEditPart = null;
	private Comment _comment = null;
	private String _schedule = "";
	private TraceHelper _helper = null;
	private NamedElement _elem = null;
	private List<GraphicalEditPart> gmfElems = null;
	private HashMap<Integer, Integer> tablecolor=new HashMap<Integer, Integer>();
	final ClockEntity _ce;
	private EventEnumerator ek = null;
	
	public ClockEntity getClock() {
		return _ce;
	}
	
	public AnimateTicksBehaviour(ClockEntity ce) {
		super();
		_ce = ce;		
		ek=AdapterRegistry.getAdapter(_ce.getClock()).getEventkind(_ce.getClock());
	}

	public String getDescription() {	
		return "Papyrus Animator";
	}


	public void setEditPart(DiagramEditPart _diagramEditPart, List<GraphicalEditPart> gmfElems) {
		this._diagramEditPart = _diagramEditPart;
		this.gmfElems = gmfElems;
	}

	public void start() {
		if (_diagramEditPart == null)
			return;
		if ((_ce.getReferencedElement().size() > 0)
				&& (_ce.getReferencedElement().get(0) instanceof org.eclipse.uml2.uml.NamedElement)) {
			for (GraphicalEditPart o : gmfElems)
				if (o.resolveSemanticElement() instanceof NamedElement) {
					String ceRefElemQN = ((NamedElement) _ce.getReferencedElement().get(0)).getQualifiedName();
					if (ceRefElemQN  != null && ceRefElemQN.compareTo(
							((NamedElement) o.resolveSemanticElement()).getQualifiedName()) == 0) {
						theEditPart = o;
						_elem = ((NamedElement) o.resolveSemanticElement());					
						try {
							_elemShape = ((org.eclipse.gmf.runtime.notation.ShapeStyle)  o.getNotationView());
							_originalColor = _elemShape.getFillColor();
						} catch (Exception e) {
							//chuuuut
						}
					}
				}
		}

	}

	public void run() {
		if (theEditPart != null && _diagramEditPart != null) {
			Display.getDefault().syncExec(new RunnableRun(this));
		}
	}

	void finish() {
		if (theEditPart != null && _diagramEditPart != null) {
			Display.getDefault().syncExec(new RestoreDefault(this));
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
