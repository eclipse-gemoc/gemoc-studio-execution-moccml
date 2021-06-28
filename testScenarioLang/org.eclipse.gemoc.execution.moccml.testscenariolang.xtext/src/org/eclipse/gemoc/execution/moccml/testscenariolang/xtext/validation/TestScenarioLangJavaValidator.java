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
package org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.validation;

import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.RewritingRuleCallStatement;
import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.TestScenarioLangPackage;
import org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.validation.AbstractTestScenarioLangJavaValidator;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.validation.Check;
 

public class TestScenarioLangJavaValidator extends AbstractTestScenarioLangJavaValidator {
	
	private static String BOOLEAN_METHOD_REQUIRED = "Method should return a boolean or java.lang.Boolean if clock(s) are intended to be forced"; 
	
	@Check
	public void checkBooleanMethodWithForcedClock(RewritingRuleCallStatement behavior) {
		return;
		
//		if (behavior.getClockToForce().isEmpty()) {
//			return;
//		}
//		if (behavior.getMethod() != null) {
//			JvmTypeReference tRef = behavior.getMethod().getReturnType();
//			JvmType returnType = tRef.getType();
//			if ( returnType instanceof JvmPrimitiveType ) {
//				if (returnType.getSimpleName().compareTo("boolean") != 0) {
//					warning(BOOLEAN_METHOD_REQUIRED,
//							behavior, CodeExecutionPackage.Literals.CODE_EXECUTION_MODEL_BEHAVIOR__METHOD, 0);
//				}
//			}
//			else if ( returnType.getIdentifier().compareTo("java.lang.Boolean") != 0) {
//					warning(BOOLEAN_METHOD_REQUIRED,
//							behavior, CodeExecutionPackage.Literals.CODE_EXECUTION_MODEL_BEHAVIOR__METHOD, 0);
//			}
//		}
	}

}
