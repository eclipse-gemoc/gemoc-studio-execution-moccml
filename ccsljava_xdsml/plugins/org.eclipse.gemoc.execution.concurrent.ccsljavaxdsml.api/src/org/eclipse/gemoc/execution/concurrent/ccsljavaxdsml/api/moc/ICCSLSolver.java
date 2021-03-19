package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.moc;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import fr.inria.aoste.timesquare.instantrelation.CCSLRelationModel.OccurrenceRelation;
import fr.inria.aoste.trace.AssertionState;
import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.ModelElementReference;

public interface ICCSLSolver extends ISolver {

	/**
	 * Forces the underlying MoC structure to forbid the given EventOccurrence from
	 * ticking in the next step.
	 */
	public void forbidEventOccurrence(EventOccurrence eventOccurrence);

	/**
	 * Forces the underlying MoC structure to force the given EventOccurrence to
	 * tick in the next step.
	 */
	public void forceEventOccurrence(EventOccurrence eventOccurrence);

	public ArrayList<ModelElementReference> getAllDiscreteClocks();

	/**
	 * Gets the state of the solver at a given execution step.
	 * 
	 * @return
	 */
	public byte[] getState();

	/**
	 * Compute the occurrence relations according to the logical step and the
	 * specification
	 * 
	 * @param the current #LogicalStep
	 **/
	List<OccurrenceRelation> getLastOccurrenceRelations();

	/**
	 * This method is needed to replace the eResource representing the executable
	 * metamodel referenced by the MSE model by the one which is actually loaded by
	 * executionEngine (and the animation if so)
	 * 
	 * @param the #Resource of the executable domain model
	 **/
	void setExecutableModelResource(Resource execModelResource);

	/**
	 * Sets the state of the solver as it was at a given step.
	 * 
	 * @param serializableModel
	 */
	public void setState(byte[] serializableModel);
	
	public void revertForceClockEffect();

	/**
	 * ask the solver to provide possible assertion violations
	 * must be called after a {@link #applyLogicalStep(Step<?> logicalStep)}
	 * @return a list of constraints where the assertion boolean is set to 'true' and which has been violated during the last step
	 */
	public List<ModelElementReference> getAssertionViolations();


}
