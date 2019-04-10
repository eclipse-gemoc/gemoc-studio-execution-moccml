///*******************************************************************************
// * Copyright (c) 2017 Inria.
// * All rights reserved. This program and the accompanying materials
// * are made available under the terms of the Eclipse Public License v1.0
// * which accompanies this distribution, and is available at
// * http://www.eclipse.org/legal/epl-v10.html
// *
// * Contributors:
// *     Inria - initial API and implementation
// *******************************************************************************/
//package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.tests
//
//import com.google.inject.Inject
//import org.eclipse.core.resources.IProject
//import org.eclipse.xtext.junit4.AbstractXtextTests
//import org.eclipse.xtext.junit4.InjectWith
//import org.eclipse.xtext.junit4.XtextRunner
//import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil
//import org.junit.After
//import org.junit.Before
//import org.junit.FixMethodOrder
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.junit.runners.MethodSorters
//import org.eclipse.gemoc.xdsmlframework.test.lib.MelangeUiInjectorProvider
//import org.eclipse.gemoc.xdsmlframework.test.lib.WorkspaceTestHelper
//
//@RunWith(XtextRunner)
//@InjectWith(MelangeUiInjectorProvider)
//@FixMethodOrder(MethodSorters::NAME_ASCENDING)
//public class TFsmTest extends AbstractXtextTests
//{
//	@Inject WorkspaceTestHelper helper
//	IProject melangeProject
//	static final String BASE_FOLDER_NAME = "tests-inputs-gen/TFSM"
//	static final String BASE_PROJECT_NAME = "org.eclipse.gemoc.sample.tfsm.concurrent"
//	static final String PROJECT_NAME = BASE_PROJECT_NAME
//	static final String MELANGE_FILE = PROJECT_NAME+"/src/org/eclipse/gemoc.sample/tfsm/concurrent/Main.melange"
//	
//	@Before
//	override setUp() {
//		helper.setTargetPlatform
//		if (!helper.projectExists(PROJECT_NAME)) {
//			super.setUp
//			helper.init
//			IResourcesSetupUtil::cleanWorkspace
//			
//			// try to respect build order in order to ease compilation, this will speed up the test
//			helper.deployProject(PROJECT_NAME+".model",BASE_FOLDER_NAME+"/"+PROJECT_NAME+".model.zip")
//			helper.deployProject(PROJECT_NAME+".k3dsa",BASE_FOLDER_NAME+"/"+PROJECT_NAME+".k3dsa.zip")
//			helper.deployProject(PROJECT_NAME+".moc.dse",BASE_FOLDER_NAME+"/"+PROJECT_NAME+".moc.dse.zip")
//			helper.deployProject(PROJECT_NAME+".moc.lib",BASE_FOLDER_NAME+"/"+PROJECT_NAME+".moc.lib.zip")
//			melangeProject = helper.deployProject(PROJECT_NAME,BASE_FOLDER_NAME+"/"+PROJECT_NAME+".zip")
//			helper.deployProject(PROJECT_NAME+".xtfsm.design",BASE_FOLDER_NAME+"/"+PROJECT_NAME+".xtfsm.design.zip")
//			helper.deployProject(PROJECT_NAME+".xtfsm.edit",BASE_FOLDER_NAME+"/"+PROJECT_NAME+".xtfsm.edit.zip")
//			helper.deployProject(PROJECT_NAME+".xtfsm.editor",BASE_FOLDER_NAME+"/"+PROJECT_NAME+".xtfsm.editor.zip")
//			
//			
//			
//			IResourcesSetupUtil::reallyWaitForAutoBuild
//			helper.cleanAll(MELANGE_FILE)
//			IResourcesSetupUtil::reallyWaitForAutoBuild
//			helper.openEditor(MELANGE_FILE)
//		} else {
//			melangeProject = helper.getProject(PROJECT_NAME)
//		}
//	}
//
//	@After
//	override tearDown() {
//		// Nope
//	}
//	
//	/** calls melange's generate actions one by one */
//	@Test
//	def void test01GenerateAllMelange_NoErrorsInWorkspace() {
//		
//		helper.assertProjectExists(PROJECT_NAME)
//		
//		helper.generateLanguages(MELANGE_FILE)
//		IResourcesSetupUtil::reallyWaitForAutoBuild
//		helper.generateInterfaces(MELANGE_FILE)
//		IResourcesSetupUtil::reallyWaitForAutoBuild
//		helper.generateAdapters(MELANGE_FILE)
//		IResourcesSetupUtil::reallyWaitForAutoBuild
//		IResourcesSetupUtil::cleanBuild // required to be able to compile the ECL with a fresh version of the ecore
//		IResourcesSetupUtil::reallyWaitForAutoBuild
//		
//		helper.assertNoMarkers
//		
//		helper.assertProjectExists(PROJECT_NAME+".xtfsm")
//	}	
//
//	/** calls Melange generate all action */
//	@Test
//	def void test02GenerateAllMelange_NoErrorsInWorkspace() {
//		
//		helper.assertProjectExists(PROJECT_NAME)
//		
//		helper.cleanAll(MELANGE_FILE)
//		IResourcesSetupUtil::reallyWaitForAutoBuild
//	
//		helper.openEditor(MELANGE_FILE)
//		IResourcesSetupUtil::reallyWaitForAutoBuild
//		helper.generateAll(MELANGE_FILE)
//		IResourcesSetupUtil::reallyWaitForAutoBuild
//	
//		IResourcesSetupUtil::cleanBuild // required to be able to compile the ECL with a fresh version of the ecore
//		IResourcesSetupUtil::reallyWaitForAutoBuild
//	
//		helper.assertNoMarkers
//		
//		helper.assertProjectExists(PROJECT_NAME+".xtfsm")
//	}
//	
//}
