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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import fr.inria.aoste.timesquare.instantrelation.CCSLRelationModel.CCSLConstraintRef;
import fr.inria.aoste.timesquare.instantrelation.CCSLRelationModel.CCSLRelationModelFactory;
import fr.inria.aoste.timesquare.instantrelation.CCSLRelationModel.OccurrenceRelation;
import fr.inria.aoste.timesquare.instantrelation.exceptions.ResolveClockConstraintException;
import fr.inria.aoste.timesquare.instantrelation.extensionpoint.IRelationModelStructureGenerator;
import fr.inria.aoste.timesquare.instantrelation.extensionpoint.LookForExtensions;
import fr.inria.aoste.timesquare.instantrelation.generator.InstantRelationModelGenerator;
import fr.inria.aoste.timesquare.instantrelation.generator.metier.AbstractCreator;
import fr.inria.aoste.timesquare.instantrelation.generator.metier.CreatorCoincidence;
import fr.inria.aoste.timesquare.instantrelation.generator.metier.CreatorCoincidenceInfSup;
import fr.inria.aoste.timesquare.instantrelation.generator.metier.CreatorPacket;
import fr.inria.aoste.timesquare.instantrelation.generator.metier.CreatorPacketGlissant;
import fr.inria.aoste.timesquare.instantrelation.generator.metier.CreatorPacketSustain;
import fr.inria.aoste.timesquare.instantrelation.generator.metier.CreatorPrecedesBy;
import fr.inria.aoste.timesquare.instantrelation.generator.metier.CreatorPrecedesByOffset;
import fr.inria.aoste.timesquare.instantrelation.generator.metier.CreatorPrecedesInf;
import fr.inria.aoste.timesquare.instantrelation.generator.metier.CreatorPrecedesOffset;
import fr.inria.aoste.timesquare.instantrelation.generator.metier.CreatorPrecedesSup;
import fr.inria.aoste.timesquare.instantrelation.generator.metier.CreatorPrecedesTrigger;
import fr.inria.aoste.timesquare.instantrelation.generator.metier.CreatorPrecedesTriggerOneShot;
import fr.inria.aoste.timesquare.instantrelation.generator.metier.activation.ActivationCreator;
import fr.inria.aoste.timesquare.instantrelation.generator.metier.activation.LifeActivationCreator;
import fr.inria.aoste.timesquare.instantrelation.listener.RelationModelListener;
import fr.inria.aoste.timesquare.utils.pluginhelpers.PluginHelpers;
import fr.inria.aoste.trace.LogicalStep;
import fr.inria.aoste.trace.ModelElementReference;
import fr.inria.aoste.trace.Reference;
import fr.inria.aoste.trace.Trace;
import fr.inria.aoste.trace.relation.IDescription;
import fr.inria.aoste.trace.relation.IOutputTraceList;

/**
 * 
 * @author Julien Deantoni
 * This class is a lean version of InstantRelationModelGenerator from Timesquare, it includes methods to create, edit and
 *         save Instants Relations Model
 */
public class GemocInstantRelationModelGenerator extends InstantRelationModelGenerator{

//	private OccurrenceRelationModel ccslRelation;
//
//	private IPath local;
//
//	private String namefile;

//	private final RelationModelListener irml = new RelationModelListener();

	public ArrayList<OccurrenceRelation> getLastOccurrenceRelations() {
		ArrayList<OccurrenceRelation> res = new ArrayList<OccurrenceRelation>();
		
		for(EObject or : ((RelationModelListener)irml).lrelation){
                    res.add((OccurrenceRelation) or);
                }
// 		((RelationModelListener)irml).lrelation.forEach(e -> res.add((OccurrenceRelation) e));
		return res;
	}

	/**
	 * Create a new instance of InstantRelationModelGenerator and create the
	 * root element of the Instants Relations Model
	 * 
	 * 
	 */
	public GemocInstantRelationModelGenerator() {
		CCSLRelationModelFactory modelFactory = CCSLRelationModelFactory.eINSTANCE;
		ccslRelation = modelFactory.createOccurrenceRelationModel();
	}

	public void setIOutputTraceList(IOutputTraceList outputlist) {
		irml.setIOutputTraceList(outputlist);
	}

	/**
	 * Create a new instance of InstantRelationModelGenerator and create the
	 * root element of the Instants Relations Model
	 * 
	 * @param outputlist
	 *            Interface used by the launcher's extension point
	 */
	public GemocInstantRelationModelGenerator(IOutputTraceList outputlist) {
		this();
		setIOutputTraceList(outputlist);
	}

	/**
	 * Returns a list of ClockConstraint containing in the Instants Relations
	 * Model root element
	 * 
	 * @return
	 * 
	 * @return A list of ClockConstraint
	 */
	public EList<CCSLConstraintRef> getClockConstraintList() {
		return ccslRelation.getRefsToCCSLConstraints();
	}

	/**
	 * Returns the root element of the model containing the EObject passed as
	 * parameter
	 * 
	 * @param eObject
	 *     a model element
	 */
	public void getModelRoot(EObject eObject) {
		// TODO ..
		irml.clear();
		if(LookForExtensions.getDefault().getICCSLModel(eObject, this)){
			//strange crazy code !! Benoit Ferrero what the hell did you do ? :)
			IRelationModelStructureGenerator generator = LookForExtensions.getDefault().getRelationModelStructureGenerator(eObject, this);
			generator.createRelationModelStructure(eObject, this);	
		}
	}

	/**
	 * Search for clocks constraint in CCSL models and add them to the Instants
	 * Relations Model
	 * 
	 * @param stepTrace
	 *            a StepTrace of a trace model
	 */
	public void addClockConstraint(LogicalStep stepTrace) {

		if (stepTrace.getEventOccurrences().isEmpty())
			return;
		Reference ref = stepTrace.getEventOccurrences().get(0).getReferedElement();
		EObject eo1 = null;
		// EObject eo2 = null;
		if (ref instanceof ModelElementReference)
			eo1 = ((ModelElementReference) ref).getElementRef().get(0);//.eContainer();
		getModelRoot(eo1);
//		disp();
	}

	public void extract(EObject eo1) {
		LookForExtensions.getDefault().getICCSLModel(eo1, this);
//		disp();
	}

	public ArrayList<IDescription> getDescription() {
		ArrayList<IDescription> desc = new ArrayList<IDescription>(lab.size());
		for (AbstractCreator a : lab) {
			desc.add(a.getDescription());
		}
		return desc;
	}

	public void disp() {
		for (AbstractCreator clockConstraint : lab) {
			System.out.println(clockConstraint.getDescription().toString());
		}

	}

	/**
	 * Load trace models in memory and return a sorted list of StepTraces
	 * 
	 * @param paths
	 *            A list of trace model paths
	 * @return A list of StepTrace
	 */
	public ArrayList<LogicalStep> loadTrace(IPath path) {
		ArrayList<LogicalStep> steps = new ArrayList<LogicalStep>();

		Trace trace = null;

		URI uri = URI.createFileURI(path.toString());

		Resource resource = new ResourceSetImpl().getResource(uri, true);

		resource.getResourceSet().getResources();

		Object o = resource.getContents().get(0);

		if (o instanceof Trace) {
			trace = (Trace) o;
			EcoreUtil.resolveAll(trace);
			steps.addAll(trace.getLogicalSteps());
		} else
			return null;

		return steps;
	}

	public ModelElementReference searchClock(EObject eo) {
		return searchClock(new EObject[] { eo });
	}

	public ModelElementReference searchClock(EObject[] eObjects) {

		boucle1: for (ModelElementReference mer : listClock) {
			if (mer.getElementRef().size() == eObjects.length) // TODO ?
			{
				for (EObject eo : eObjects) {
					if (mer.getElementRef().indexOf(eo) == -1)
						continue boucle1;
				}
				return mer;
			}
		}
		return null;
	}

	public ModelElementReference searchConstraint(EObject eo) {
		return searchConstraint(new EObject[] { eo });
	}

	public ModelElementReference searchConstraint(EObject[] eObjects) {
		boucle1: for (ModelElementReference mer : listRelation) {
			if (mer.getElementRef().size() == eObjects.length) {
				for (EObject eo : eObjects) {
					if (mer.getElementRef().indexOf(eo) == -1)
						continue boucle1;
				}
				return mer;
			}
		}
		return null;
	}

	public List<ModelElementReference> getListClock() {
		return listClock;
	}

	public List<ModelElementReference> getListRelation() {
		return listRelation;
	}

	public void setListClock(List<ModelElementReference> listClock) {
		this.listClock = listClock;
	}

	public void setListRelation(List<ModelElementReference> listrelation) {
		this.listRelation = listrelation;
	}

	
	
	
	
	

	
	/**
	 * This method is called for resolve instants relation of any
	 * ClockConstraints in the Instants Relation Model
	 * 
	 * @param stepTrace
	 *            a StepTrace of a trace model
	 */
	public void resolve(LogicalStep stepTrace) {
		List<ResolveClockConstraintException> list = new ArrayList<ResolveClockConstraintException>();
		try { 
			irml.clear();
			for (AbstractCreator clockConstraint : lab) {
				try {
					clockConstraint.resolve(stepTrace);
				} catch (ResolveClockConstraintException e) {
					list.add(e);

				}
			}
			irml.postNewRelation();
			
//			WE SUPPORT EMPTY STEP SO WE SHOULD NOT RAISE ANY EXCEPTIONS HERE
//			MultipleException.assertEmpty(list);
		} catch (Exception e) {
			e.printStackTrace();
		//	throw new RuntimeException(e);

		}
	}

	
//	public List<OccurrenceRelation> getLastOccurrenceRelations(){
//		ArrayList<OccurrenceRelation> res = new ArrayList<OccurrenceRelation>();
//		
//		
//		return res;
//	}
	
	private void saveRelationModel() {
		if (ccslRelation == null)
			return;
		String nametrace = local.append(namefile + ".ccslrelationmodel").toString();
		// .toFile().getAbsolutePath();
		ResourceSet resourceSet = new ResourceSetImpl();
		XMIResourceFactoryImpl xmiresource = new XMIResourceFactoryImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION, xmiresource);
		URI fileURI = URI.createFileURI(nametrace);
		resource = resourceSet.createResource(fileURI);
		resource.getContents().add(ccslRelation);

		try {

			resource.save(PluginHelpers.getEcoreSaveOption());// Collections.EMPTY_MAP);
			// resource.unload(); //TODO gestion du unload
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void saveRelationModel(ResourceSet rs) {

		if (ccslRelation == null)
			return;
		String nametrace = local.append(namefile + ".ccslrelationmodel").toString();
		XMIResourceFactoryImpl xmiresource = new XMIResourceFactoryImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION, xmiresource);
		URI fileURI = URI.createPlatformResourceURI(nametrace, false);
		resource = rs.createResource(fileURI);
		resource.getContents().add(ccslRelation);

		try {
			resource.save(PluginHelpers.getEcoreSaveOption());// Collections.EMPTY_MAP);
			// resource.unload(); //TODO gestion du unload
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Save the model at the location specify by the parameters
	 * 
	 * @param folderin
	 *            a path of the folder containing the instants relation model
	 * @param namefilein
	 *            the file name of the instants relation model
	 */
	public void saveRelationModel(IPath folderin, String namefilein) {
		local = folderin;
		namefile = namefilein;
		saveRelationModel();

		// RelationModelListener.getInstance().
		irml.reInit(); // TODO Change

	}

	public void saveRelationModel(ResourceSet rs, IPath folderin, String namefilein) {
		local = folderin;
		namefile = namefilein;
		saveRelationModel(rs);

		// RelationModelListener.getInstance().
		irml.reInit(); // TO

	}

	public void unload() {
		// TODO
		try {
			if (resource != null)
				resource.unload(); // TODO
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void aNewClockConstraint(CCSLConstraintRef clockConstraint) {
		getClockConstraintList().add(clockConstraint);
		irml.aNewClockConstraint(clockConstraint);
	}

	public AbstractCreator add(AbstractCreator ab) {
		if (ab != null) {
			if (ab.addChecking()) {
				lab.add(ab);
				ab.setIrml(irml);
			} 
//			else {
//				try {
//					System.err.println("Ignore : " + ab.getClass().getSimpleName() + " :" + ab.getDescription() + " ");
//				} catch (Throwable e) {
//					System.err.println("Ignore : " + ab.getClass().getSimpleName());
//				}
//			}
		}
		return ab;
	}

	public AbstractCreator add(AbstractCreator ab, ActivationCreator activationCreator) {
		if (ab != null) {
			if (ab.addChecking()) {
				if (activationCreator != null)
					ab.setActivationCreator(activationCreator);
				lab.add(ab);
				ab.setIrml(irml);
			} 
//			else {
//				try {
//					System.err.println("Ignore : " + ab.getClass().getSimpleName() + " :" + ab.getDescription() + " ");
//				} catch (Throwable e) {
//					System.err.println("Ignore : " + ab.getClass().getSimpleName());
//				}
//			}
		}
		return ab;
	}

	public CCSLConstraintRef addAndCreateAlternates(ModelElementReference a, ModelElementReference b, int a1, int b1,
			boolean left, boolean rigth) {
		CCSLConstraintRef cref = CCSLRelationModelFactory.eINSTANCE.createCCSLConstraintRef();
		cref.getCcslElements().add(a);
		cref.getCcslElements().add(b);
		getClockConstraintList().add(cref);
		irml.aNewClockConstraint(cref);
		/**************************************/
		add(new CreatorPrecedesBy(cref, a, b, left, a1, b1));
		if (a1 == 1 && b1 == 1) {
			add(new CreatorPrecedesOffset(cref, b, a, rigth, 0, 1));
		} else {
			add(new CreatorPrecedesByOffset(cref, b, a, rigth, b1, 0, a1, a1));
		}
		add(new CreatorPacket(cref, a, a1));
		add(new CreatorPacket(cref, b, b1));
		return cref;
	}

	public CCSLConstraintRef addAndCreatePrecedes(ModelElementReference a, ModelElementReference b, int a1, int b1,
			boolean strict) {

		CCSLConstraintRef cref = CCSLRelationModelFactory.eINSTANCE.createCCSLConstraintRef();
		cref.getCcslElements().add(a);
		cref.getCcslElements().add(b);
		getClockConstraintList().add(cref);
		irml.aNewClockConstraint(cref);
		/**************************************/
		add(new CreatorPrecedesBy(cref, a, b, strict, a1, b1));
		add(new CreatorPacket(cref, a, a1));
		add(new CreatorPacket(cref, b, b1));
		return cref;
	}

	public CCSLConstraintRef addAndCreateSync(ModelElementReference a, ModelElementReference b, int a1, int b1,
			boolean left, boolean rigth) {
		CCSLConstraintRef cref = CCSLRelationModelFactory.eINSTANCE.createCCSLConstraintRef();
		cref.getCcslElements().add(a);
		cref.getCcslElements().add(b);
		getClockConstraintList().add(cref);
		irml.aNewClockConstraint(cref);
		/**************************************/
		if (a1 == 1 && b1 == 1) {
			add(new CreatorPrecedesOffset(cref, a, b, left, 0, 1));
			add(new CreatorPrecedesOffset(cref, b, a, rigth, 0, 1));
		} else {
			add(new CreatorPrecedesByOffset(cref, a, b, left, a1, 0, b1, b1));
			add(new CreatorPrecedesByOffset(cref, b, a, rigth, b1, 0, a1, a1));
		}
		add(new CreatorPacket(cref, a, a1));
		add(new CreatorPacket(cref, b, b1));
		return cref;
	}

	public CCSLConstraintRef addAndCreateEqual(ModelElementReference a, ModelElementReference b) {
		CCSLConstraintRef cref = CCSLRelationModelFactory.eINSTANCE.createCCSLConstraintRef();
		cref.getCcslElements().add(a);
		cref.getCcslElements().add(b);
		/**************************************/
		CreatorCoincidence clockRelationEqual = new CreatorCoincidence(cref, a, b);
		getClockConstraintList().add(cref);
		irml.aNewClockConstraint(cref);

		add(clockRelationEqual);
		return cref;
	}

	/**
	 * res = c1 . c2
	 * 
	 * @param res
	 *            (ModelElementReference)
	 * @param c1
	 *            (ModelElementReference)
	 * @param c2
	 *            (ModelElementReference)
	 * @return an element from the instantRelamtionModel named CCSLConstraintRef
	 */
	public CCSLConstraintRef addAndCreateConcatenation(ModelElementReference res, ModelElementReference c1,
			ModelElementReference c2) {
		CCSLConstraintRef cref = CCSLRelationModelFactory.eINSTANCE.createCCSLConstraintRef();
		cref.getCcslElements().add(res);
		cref.getCcslElements().add(c1);
		cref.getCcslElements().add(c2);
		/**************************************/
		CreatorCoincidence instantRelationEqual = new CreatorCoincidence(cref, res, c1);
		CreatorCoincidence instantRelationEqual2 = new CreatorCoincidence(cref, res, c2);
		getClockConstraintList().add(cref);
		irml.aNewClockConstraint(cref);

		// ActivationCreator activationCreator
		// =activationCreatorFactory.createNotDeadActivationCreator(c1,true);
		add(instantRelationEqual, new LifeActivationCreator(res));
		add(instantRelationEqual2, new LifeActivationCreator(res));

		return cref;
	}

	/**
	 * res = c1 upTo c2
	 * 
	 * @param res
	 *            (ModelElementReference)
	 * @param c1
	 *            (ModelElementReference)
	 * @param c2
	 *            (ModelElementReference)
	 * @return an element from the instantRelamtionModel named CCSLConstraintRef
	 */
	public CCSLConstraintRef addAndCreateUpTo(ModelElementReference res, ModelElementReference c1,
			ModelElementReference c2) {
		CCSLConstraintRef cref = CCSLRelationModelFactory.eINSTANCE.createCCSLConstraintRef();
		cref.getCcslElements().add(res);
		cref.getCcslElements().add(c1);
		cref.getCcslElements().add(c2);
		/**************************************/

		CreatorCoincidence instantRelationEqual = new CreatorCoincidence(cref, res, c1);
		CreatorPrecedesTrigger instantRelationPrecedes = new CreatorPrecedesTrigger(cref, res, c2, true, true);
		CreatorPrecedesTriggerOneShot instantRelationPrecedes2 = new CreatorPrecedesTriggerOneShot(cref, c2, c1, false,
				false);

		getClockConstraintList().add(cref);
		irml.aNewClockConstraint(cref);

		add(instantRelationEqual, new LifeActivationCreator(res));
		add(instantRelationPrecedes2, new LifeActivationCreator(res));
		add(instantRelationPrecedes, new LifeActivationCreator(res));
		return cref;
	}

	public CCSLConstraintRef addandCreateInf(ModelElementReference r, ModelElementReference lst[]) {
		CCSLConstraintRef cref = CCSLRelationModelFactory.eINSTANCE.createCCSLConstraintRef();
		cref.getCcslElements().add(r);
		for (ModelElementReference a : lst)
			cref.getCcslElements().add(a);
		irml.aNewClockConstraint(cref);
		getClockConstraintList().add(cref);
		/*********************************/

		for (ModelElementReference a : lst) {
			add(new CreatorCoincidenceInfSup(cref, r, a), new LifeActivationCreator(r));
			add(new CreatorPrecedesInf(cref, r, a), new LifeActivationCreator(r));
		}
		return cref;
	}

	public CCSLConstraintRef addandCreateSup(ModelElementReference r, ModelElementReference lst[]) {
		CCSLConstraintRef cref = CCSLRelationModelFactory.eINSTANCE.createCCSLConstraintRef();
		cref.getCcslElements().add(r);
		for (ModelElementReference a : lst) {
			cref.getCcslElements().add(a);
		}
		irml.aNewClockConstraint(cref);
		getClockConstraintList().add(cref);
		/*********************************/

		for (ModelElementReference a : lst) {
			add(new CreatorCoincidenceInfSup(cref, r, a), new LifeActivationCreator(r));
			add(new CreatorPrecedesSup(cref, a, r), new LifeActivationCreator(r));
		}
		return cref;
	}

	public CCSLConstraintRef addandCreateInterOrUnion(ModelElementReference r, ModelElementReference a,
			ModelElementReference b) {
		CCSLConstraintRef cref = CCSLRelationModelFactory.eINSTANCE.createCCSLConstraintRef();
		cref.getCcslElements().add(r);
		cref.getCcslElements().add(a);
		cref.getCcslElements().add(b);
		irml.aNewClockConstraint(cref);
		getClockConstraintList().add(cref);

		/**************************************/
		add(new CreatorCoincidence(cref, r, a), new LifeActivationCreator(r));
		add(new CreatorCoincidence(cref, r, b), new LifeActivationCreator(r));
		return cref;
	}

	public CCSLConstraintRef addandCreateDelayedFor(ModelElementReference r, ModelElementReference a,
			ModelElementReference b, int n) {
		CCSLConstraintRef cref = CCSLRelationModelFactory.eINSTANCE.createCCSLConstraintRef();
		cref.getCcslElements().add(r);
		cref.getCcslElements().add(a);
		cref.getCcslElements().add(b);
		irml.aNewClockConstraint(cref);
		getClockConstraintList().add(cref);
		/**************************************/

		add(new CreatorCoincidence(cref, r, b), new LifeActivationCreator(r));
		if (n != -1)
			add(new CreatorPacketGlissant(cref, b, n, a), new LifeActivationCreator(r));
		if (a != b) {
			add(new CreatorPrecedesTrigger(cref, a, b, true, true), new LifeActivationCreator(r));
			add(new CreatorPrecedesTrigger(cref, b, a, true, true), new LifeActivationCreator(r));
		}
		return cref;
	}

	public CCSLConstraintRef addandCreateSampledOn(ModelElementReference sup, ModelElementReference superc,
			ModelElementReference trigger, boolean strictly) {
		CCSLConstraintRef cref = CCSLRelationModelFactory.eINSTANCE.createCCSLConstraintRef();
		cref.getCcslElements().add(sup);
		cref.getCcslElements().add(superc);
		cref.getCcslElements().add(trigger);
		irml.aNewClockConstraint(cref);
		getClockConstraintList().add(cref);

		/**************************************/
		add(new CreatorCoincidence(cref, superc, sup), new LifeActivationCreator(sup));
		add(new CreatorPrecedesTrigger(cref, trigger, superc, strictly, true), new LifeActivationCreator(sup)); // false
		// TODO
		// ??
		add(new CreatorPrecedesTrigger(cref, superc, trigger, !strictly, true), new LifeActivationCreator(sup, false));
		return cref;
	}

	public CCSLConstraintRef addandCreateSustain(ModelElementReference res, ModelElementReference sustain,
			ModelElementReference upto) {
		CCSLConstraintRef cref = CCSLRelationModelFactory.eINSTANCE.createCCSLConstraintRef();
		cref.getCcslElements().add(res);
		cref.getCcslElements().add(sustain);
		cref.getCcslElements().add(upto);
		irml.aNewClockConstraint(cref);
		getClockConstraintList().add(cref);
		/**************************************/
		add(new CreatorCoincidence(cref, res, sustain), new LifeActivationCreator(res));
		add(new CreatorPrecedesTrigger(cref, res, upto, true, true), new LifeActivationCreator(res));
		add(new CreatorPacketSustain(cref, res, sustain, upto), new LifeActivationCreator(res));
		return cref;
	}

}
