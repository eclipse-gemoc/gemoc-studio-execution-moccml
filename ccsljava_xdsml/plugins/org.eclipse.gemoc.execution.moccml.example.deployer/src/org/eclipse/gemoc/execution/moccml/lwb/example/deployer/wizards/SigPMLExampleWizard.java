package org.eclipse.gemoc.execution.moccml.lwb.example.deployer.wizards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.gemoc.execution.moccml.example.deployer.Activator;
import org.eclipse.gemoc.sequential.language.wb.sample.deployer.wizards.AbstractExampleWizard;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class SigPMLExampleWizard extends AbstractExampleWizard {

	@Override
	protected AbstractUIPlugin getContainerPlugin() {
		return Activator.getDefault();
	}

	@Override
	protected Collection<ProjectDescriptor> getProjectDescriptors() {
		List<ProjectDescriptor> projects = new ArrayList<ProjectDescriptor>(1);
		// extract project in a compilation friendly way, give the compiler a chance to be more efficient and succeed without a "clean all"
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.eclipse.gemoc.example.moccmlsigpml.model.zip", 	"org.eclipse.gemoc.example.moccmlsigpml.model"));;
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.eclipse.gemoc.example.moccmlsigpml.model.edit.zip", 	"org.eclipse.gemoc.example.moccmlsigpml.model.edit"));;
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.eclipse.gemoc.example.moccmlsigpml.model.editor.zip", 	"org.eclipse.gemoc.example.moccmlsigpml.model.editor"));;
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.eclipse.gemoc.example.moccmlsigpml.groovy.zip", 	"org.eclipse.gemoc.example.moccmlsigpml.groovy"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.eclipse.gemoc.example.moccmlsigpml.k3dsa.zip", 	"org.eclipse.gemoc.example.moccmlsigpml.k3dsa"));;
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.eclipse.gemoc.example.moccmlsigpml.lib.zip", 	"org.eclipse.gemoc.example.moccmlsigpml.lib"));;
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.eclipse.gemoc.example.moccmlsigpml.design.zip", 	"org.eclipse.gemoc.example.moccmlsigpml.design"));;
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.eclipse.gemoc.example.moccmlsigpml.zip", 	"org.eclipse.gemoc.example.moccmlsigpml"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.eclipse.gemoc.ultimateplotter.zip", 	"org.eclipse.gemoc.example.ultimateplotter"));
		
return projects;
	}

}
