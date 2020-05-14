package org.eclipse.gemoc.addon.metaprogramming;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gemoc.dsl.Dsl;
import org.eclipse.gemoc.dsl.Entry;
import org.eclipse.gemoc.xdsmlframework.api.extensions.metaprog.IRule;
import org.eclipse.gemoc.xdsmlframework.api.extensions.metaprog.Message;
import org.eclipse.gemoc.xdsmlframework.api.extensions.metaprog.Severity;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.ocl.cst.PackageDeclarationCS;
import org.eclipse.ocl.xtext.basecs.PathElementWithURICS;
import org.eclipse.ocl.xtext.completeoclcs.impl.PackageDeclarationCSImpl;
import org.eclipse.ocl.xtext.completeoclcs.impl.ClassifierContextDeclCSImpl;

public class MOCCMLRule implements IRule{

	@Override
	public Message execute(Dsl dsl) {
		ArrayList<String> entriesNames = new ArrayList<String>();
		
		for (Entry e : dsl.getEntries()) {
			entriesNames.add(e.getKey());
		}
		
		if(!entriesNames.contains("k3")) {
			return (new Message("Missing entry \"k3\"", Severity.ERROR));
		}
		
		if(!entriesNames.contains("ecl")) {
			return (new Message("Missing entry \"ecl\"", Severity.ERROR));
		}
		
		return (new Message("", Severity.DEFAULT));
	}

	@Override
	public Message execute(Entry entry) {
		if("ecl".matches(entry.getKey())) {
			URI uri = URI.createURI("platform:/resource/" + entry.getValue());
			
			if(!uri.isPlatformResource()) {
				return (new Message("File for \"ale\" entry not in the workspace", Severity.ERROR));
			}
			
			/*IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IFile file = root.getFile(new Path(entry.eResource().getURI().toPlatformString(true)));
			
			IProject proj = file.getProject();
			IJavaProject jProj = JavaCore.create(proj);
			
			if(jProj == null) {
				return (new Message("No project dsa in the workspace", Severity.ERROR));
			}*/
			
			
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
				/*TODO: continu le taf ->
				 * 	verifier l'import du fichier ecore,
				 *  verifier la presence d'un package (surement instanceOf package)
				 * 	verifier la presence de content (surement instanceOf content)
				 */
				
			}catch(RuntimeException e) {
				return (new Message("The file for the \"ecl\" does not exist", Severity.ERROR));
			}
		}
		
		return (new Message("", Severity.DEFAULT));
	}

}
