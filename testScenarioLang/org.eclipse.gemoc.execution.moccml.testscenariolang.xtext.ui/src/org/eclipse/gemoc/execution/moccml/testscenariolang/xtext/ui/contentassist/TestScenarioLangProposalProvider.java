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
/*
 * generated by Xtext
 */
package org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.ui.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.services.TestScenarioLangGrammarAccess;
import org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.services.TestScenarioLangGrammarAccess.EnableStateKindElements;
import org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.services.TestScenarioLangGrammarAccess.FiredStateKindElements;
import org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.services.TestScenarioLangGrammarAccess.LiveStateKindElements;
import org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.ui.contentassist.AbstractTestScenarioLangProposalProvider;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

import com.google.inject.Inject;

/**
 * see
 * http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on
 * how to customize content assistant
 */
public class TestScenarioLangProposalProvider extends AbstractTestScenarioLangProposalProvider {

	@Inject
	private IGrammarAccess grammarAccess;

	public void complete_FiredStateKind(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		TestScenarioLangGrammarAccess ga = (TestScenarioLangGrammarAccess) grammarAccess;
		FiredStateKindElements elts = ga.getFiredStateKindAccess();
		acceptor.accept(createCompletionProposal(elts.getDoesnot_tickKeyword_1().getValue(),
				context));
		acceptor.accept(createCompletionProposal(elts.getTicksKeyword_0().getValue(), context));
	}

	public void complete_EnableStateKind(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		TestScenarioLangGrammarAccess ga = (TestScenarioLangGrammarAccess) grammarAccess;
		EnableStateKindElements elts = ga.getEnableStateKindAccess();
		for (EObject elt : elts.getAlternatives().eContents()) {
			if (elt instanceof Keyword) {
				String proposal = ((Keyword) elt).getValue();
				acceptor.accept(createCompletionProposal(proposal, context));
			}
		}
	}

	public void complete_LiveStateKind(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		TestScenarioLangGrammarAccess ga = (TestScenarioLangGrammarAccess) grammarAccess;
		LiveStateKindElements elts = ga.getLiveStateKindAccess();
		acceptor.accept(createCompletionProposal(elts.getIsAliveKeyword_0().getValue(), context));
		acceptor.accept(createCompletionProposal(elts.getIsDeadKeyword_1().getValue(), context));

	}

}