package org.eclipse.gemoc.execution.moccml.lwb.example.deployer.wizards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.gemoc.execution.moccml.example.deployer.Activator;
import org.eclipse.gemoc.sequential.language.wb.sample.deployer.wizards.AbstractExampleWizard;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class TFSMExampleWizard extends AbstractExampleWizard {

	@Override
	protected AbstractUIPlugin getContainerPlugin() {
		return Activator.getDefault();
	}

	@Override
	protected Collection<ProjectDescriptor> getProjectDescriptors() {
		List<ProjectDescriptor> projects = new ArrayList<ProjectDescriptor>(1);
		// extract project in a compilation friendly way, give the compiler a chance to be more efficient and succeed without a "clean all"
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.eclipse.gemoc.example.moccml.tfsm.model.zip", 	"org.eclipse.gemoc.example.moccml.tfsm.model"));;
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.eclipse.gemoc.example.moccml.tfsm.model.edit.zip", 	"org.eclipse.gemoc.example.moccml.tfsm.model.edit"));;
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.eclipse.gemoc.example.moccml.tfsm.model.editor.zip", 	"org.eclipse.gemoc.example.moccml.tfsm.model.editor"));;
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.eclipse.gemoc.example.moccml.tfsm.k3dsa.zip", 	"org.eclipse.gemoc.example.moccml.tfsm.k3dsa"));;
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.eclipse.gemoc.example.moccml.tfsm.moc.dse.zip", 	"org.eclipse.gemoc.example.moccml.tfsm.moc.dse"));;
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.eclipse.gemoc.example.moccml.tfsm.moc.lib.zip", 	"org.eclipse.gemoc.example.moccml.tfsm.moc.lib"));;
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.eclipse.gemoc.example.moccml.tfsm.design.zip", 	"org.eclipse.gemoc.example.moccml.tfsm.design"));;
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.eclipse.gemoc.example.moccml.tfsm.zip", 	"org.eclipse.gemoc.example.moccml.tfsm"));
		
return projects;
	}

}
