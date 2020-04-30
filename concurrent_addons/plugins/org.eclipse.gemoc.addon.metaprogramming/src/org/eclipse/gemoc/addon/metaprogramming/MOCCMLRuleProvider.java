package org.eclipse.gemoc.addon.metaprogramming;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.gemoc.xdsmlframework.api.extensions.metaprog.IRule;
import org.eclipse.gemoc.xdsmlframework.api.extensions.metaprog.IRuleProvider;
import org.eclipse.gemoc.xdsmlframework.api.extensions.metaprog.EcoreRule;

public class MOCCMLRuleProvider implements IRuleProvider {

	@Override
	public Collection<IRule> getValidationRules() {
		ArrayList<IRule> ruleSet = new ArrayList<IRule>();
		ruleSet.add(new EcoreRule());
		ruleSet.add(new MOCCMLRule());
		return ruleSet;
	}

}
