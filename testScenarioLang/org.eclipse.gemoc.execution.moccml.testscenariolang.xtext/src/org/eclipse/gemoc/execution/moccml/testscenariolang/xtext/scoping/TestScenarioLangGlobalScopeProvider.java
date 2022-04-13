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
package org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.scoping;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.reflect.ReflectionTypeScopeProvider;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider;
import org.eclipse.xtext.common.types.xtext.ClasspathBasedTypeScopeProvider;
import org.eclipse.xtext.common.types.xtext.TypesAwareDefaultGlobalScopeProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.TimeModelPackage;

/**
 * A global scope provider that is both able to process the importURI attributes to establish cross links
 * with other EMF models, and to handle references to JVM types.
 * This class is a subclass of {@link ImportUriGlobalScopeProvider} in order to get the importURI behavior
 * and delegates references to JVM types to an instance of AbstractTypeScopeProvider obtained through Guice.
 * @see TypesAwareDefaultGlobalScopeProvider where part of is getScope() function is duplicated here.
 * @see ClasspathBasedTypeScopeProvider
 * @see org.eclipse.xtext.common.types.xtext.ui.JdtBasedSimpleTypeScopeProvider
 * @author nchleq
 *
 */
@SuppressWarnings("restriction")
public class TestScenarioLangGlobalScopeProvider extends ImportUriGlobalScopeProvider {
	
	/*
	 * AbstractTypeScopeProvider is bound to org.eclipse.xtext.common.types.xtext.ClasspathBasedTypeScopeProvider
	 * in the "Standalone" setup and to org.eclipse.xtext.common.types.xtext.ui.JdtBasedSimpleTypeScopeProvider
	 * int the IU setup. In both cases, the class AbstractTypeScopeProvider which is the usual global
	 * scope provider when using the JVM types uses an AbstractTypeScopeProvider instance (through Guice) to 
	 * handle all references to JVM types : we do the same here.
	 */
	@Inject
	private AbstractTypeScopeProvider typeScopeProvider;
	
	@Inject
	private ReflectionTypeScopeProvider reflectionTypeScopeProvider;

	@Override
	public IScope getScope(Resource resource, EReference reference,
			Predicate<IEObjectDescription> filter) {
		if (EcoreUtil2.isAssignableFrom(TypesPackage.Literals.JVM_TYPE, reference.getEReferenceType())) {
			IScope typeScope = typeScopeProvider.getScope(resource, reference, filter);
			return typeScope;
		}
//		else if(EcoreUtil2.isAssignableFrom(TimeModelPackage.Literals.CLOCK, reference.getEReferenceType())) {
//			IScope typeScope = reflectionTypeScopeProvider.getScope(resource, reference, filter);
//			return typeScope;
//		}
		else {
			return super.getScope(resource, reference, filter);
		}
	}

}
