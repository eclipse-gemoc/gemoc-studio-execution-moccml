package org.eclipse.gemoc.addon.metaprogramming;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.gemoc.xdsmlframework.api.extensions.metaprog.IRule;
import org.eclipse.gemoc.xdsmlframework.api.extensions.metaprog.IRuleProvider;
import org.eclipse.gemoc.xdsmlframework.api.extensions.metaprog.EcoreRule;
import org.eclipse.gemoc.xdsmlframework.extensions.kermeta3.Kermeta3Rule;

public class MOCCMLRuleProvider implements IRuleProvider {
	
	private ArrayList<IRule> ruleSet;

	public MOCCMLRuleProvider() {
		ruleSet = new ArrayList<IRule>();
	}
	
	@Override
	public Collection<IRule> getValidationRules() {
		ruleSet.add(new EcoreRule());
		ruleSet.add(new MOCCMLRule());
		ruleSet.add(new Kermeta3Rule(false));
		return ruleSet;
	}

}
