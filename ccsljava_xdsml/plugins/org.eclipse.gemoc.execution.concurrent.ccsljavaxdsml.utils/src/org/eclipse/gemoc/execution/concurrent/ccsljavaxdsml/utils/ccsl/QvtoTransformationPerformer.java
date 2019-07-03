/*******************************************************************************
 * Copyright (c) 2017 INRIA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     INRIA - initial API and implementation
 *******************************************************************************/
package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.utils.ccsl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gemoc.commons.eclipse.messagingsystem.api.MessagingSystem;
import org.eclipse.gemoc.commons.eclipse.messagingsystem.api.MessagingSystemManager;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.utils.Activator;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.ImportStatement;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockConstraintSystem;
import fr.inria.aoste.timesquare.ccslkernel.parser.xtext.ExtendedCCSLStandaloneSetup;

public class QvtoTransformationPerformer {

	private XtextResourceSet aModelResourceSet=null;
	private XtextResourceSet outputResourceSet=null;

	protected static MessagingSystem messagingSystem = null;

	public static MessagingSystem getMessagingSystem() {
		if (messagingSystem == null) {
			MessagingSystemManager msm = new MessagingSystemManager();
			// use the baseMessageGroup of the engine in order to share consoles instead of duplicating them
			messagingSystem = msm.createBestPlatformMessagingSystem(
					org.eclipse.gemoc.executionframework.engine.Activator.PLUGIN_ID, 
					org.eclipse.gemoc.executionframework.engine.Activator.CONSOLE_NAME);
		}
		return messagingSystem;
	}

	
	
	/**
	 * just initialization stuff from xtext for an ecl resource
	 */
	private void initializeXtext(){
		ExtendedCCSLStandaloneSetup ess= new ExtendedCCSLStandaloneSetup();
		Injector injector = ess.createInjector();
		// instanciate a resource set
		aModelResourceSet = injector.getInstance(XtextResourceSet.class);
		outputResourceSet = injector.getInstance(XtextResourceSet.class);
		//set.setClasspathURIContext(getClasspathURIContext());
		aModelResourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		ExtendedCCSLStandaloneSetup.doSetup();
	}
	
	public void run(ResourceSet resourceSet, String transformationPath, String modelPath, String outputMoCPath, String outputFeedbackPath, String outputPriorityPath) 
	{		
		//initialize console
		getMessagingSystem();
		
	    URI transformationURI = URI.createURI(transformationPath, true);
	    URI modelURI = URI.createURI(modelPath, true);
		IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(modelURI);
		initializeXtext();
	    //model resource
		//Resource modelResource = aModelResourceSet.getResource(modelURI, true);
		Resource modelResource = resourceSet.getResource(modelURI, true);

	    //transformationURI is the URI of qvto file
		TransformationExecutor executor = new TransformationExecutor(transformationURI);
		//inResource have the vaule of inModel
		ModelExtent input = new BasicModelExtent(modelResource.getContents());
		ModelExtent outputMoC = new BasicModelExtent();
		ModelExtent outputFeedback = new BasicModelExtent();
		ModelExtent outputPriority = new BasicModelExtent();
		
		ExecutionContextImpl context = new ExecutionContextImpl();

		ExecutionDiagnostic diagnostic = executor.execute(context, input, outputMoC, outputFeedback, outputPriority);
		System.out.println(diagnostic);
		if(diagnostic.getSeverity() != ExecutionDiagnostic.OK){
			messagingSystem.error(diagnostic.getMessage(), Activator.PLUGIN_ID);
			throw new ExceptionInInitializerError("the QVTo file compiled from the ECL contains syntactic errors. Please double check your ECL:"+diagnostic.getMessage());
		}
		//output resource saving
	    
	    URI outputMoCUri = URI.createURI(outputMoCPath, true);
	    URI outputFeedbackUri = URI.createURI(outputFeedbackPath, true);
	    URI outputPriorityUri = URI.createURI(outputPriorityPath, true);
	    Resource outputMoCResource = null;
	    Resource outputFeedbackResource = null;
	    Resource outputPriorityResource = null;
	    try
	    {
	    	outputMoCResource = outputResourceSet.createResource(outputMoCUri);
	    	outputFeedbackResource = outputResourceSet.createResource(outputFeedbackUri);
	    	outputPriorityResource = outputResourceSet.createResource(outputPriorityUri);
		    outputMoCResource.getContents().addAll(outputMoC.getContents());
		    outputFeedbackResource.getContents().addAll(outputFeedback.getContents());
		    outputPriorityResource.getContents().addAll(outputPriority.getContents());
		    hackImportStatements(modelURI, outputMoC);		    
			outputMoCResource.save(null);
			outputFeedbackResource.save(null);
			outputPriorityResource.save(null);
	    }
	    catch (Exception e)
	    {
	    	e.printStackTrace();
	    };
	}

	private void hackImportStatements(URI modelURI, ModelExtent output) {
		if (output.getContents().size() > 0
	    	&& output.getContents().get(0) instanceof ClockConstraintSystem) {
	    	ClockConstraintSystem system = (ClockConstraintSystem)output.getContents().get(0);
	    	for(ImportStatement i : system.getImports()) {
	    		if (!i.getImportURI().equals(modelURI.toString())) {
	    			String pluginBasedURI = i.getImportURI().replace("platform:/resource", "platform:/plugin");
	    			i.setImportURI(pluginBasedURI);
	    		}
	    	}
	    }
	}
	
}
