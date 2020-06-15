package org.eclipse.gemoc.execution.moccmlxdsml.metaprog;

import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gemoc.dsl.Entry;
import org.eclipse.gemoc.xdsmlframework.api.extensions.metaprog.ILanguageComponentValidator;
import org.eclipse.gemoc.xdsmlframework.api.extensions.metaprog.Message;
import org.eclipse.gemoc.xdsmlframework.api.extensions.metaprog.Severity;
import org.eclipse.ocl.xtext.basecs.PathElementWithURICS;
import org.eclipse.ocl.xtext.completeoclcs.impl.PackageDeclarationCSImpl;
import org.eclipse.ocl.xtext.completeoclcs.impl.ClassifierContextDeclCSImpl;

public class MOCCMLRule implements ILanguageComponentValidator{

	@Override
	public Message validate(Entry entry) {
		if("ecl".matches(entry.getKey())) {
			URI uri = URI.createURI("platform:/resource/" + entry.getValue());
			
			if(!uri.isPlatformResource()) {
				return (new Message("File for \"ale\" entry not in the workspace", Severity.ERROR));
			}
			
			ResourceSet rs = new ResourceSetImpl();
			Resource res;
			String ecoreModel = "";
			Boolean hasPackage = false;
			Boolean hasContext = false;
			
			try {
				res = rs.getResource(uri, true);
				List<EObject> contents = res.getContents().get(0).eContents();
				
				if (contents.isEmpty()) {
					return (new Message("No content in the ecl file", Severity.WARNING));
				}
				 TreeIterator<EObject> tree = res.getAllContents();
				 while(tree.hasNext()) {
					 EObject node = tree.next();
					 if(node instanceof PathElementWithURICS) {
						 PathElementWithURICS node2 = (PathElementWithURICS) node;
						 ecoreModel = node2.toString().replaceAll("'", "");
					 }
					 if(node instanceof PackageDeclarationCSImpl) {
						 hasPackage = true;
					 }
					 if(node instanceof ClassifierContextDeclCSImpl) {
						 hasContext = true;
					 }
				 }
				 TreeIterator<EObject> treeDSL = entry.eContainer().eAllContents(); 
				 while(treeDSL.hasNext()) {
					 EObject node = treeDSL.next();
					 if(node instanceof Entry) {
						 Entry node2 = (Entry) node;
						 if("ecore".matches(node2.getKey())) {
							 if(!node2.getValue().matches(ecoreModel)) {
								 return (new Message("Ecore model for ecl file not matching Ecore model in the dsl file.", Severity.WARNING));
							 }
						 }
					 }
				 }
				 if(!hasPackage) {
					 return (new Message("No package in the ecl file.", Severity.WARNING));
				 }
				 if(!hasContext) {
					 return (new Message("No context in the ecl file.", Severity.WARNING));
				 }
				
			}catch(RuntimeException e) {
				return (new Message("The file for the \"ecl\" does not exist", Severity.ERROR));
			}
		}
		
		return (new Message("", Severity.DEFAULT));
	}

}
