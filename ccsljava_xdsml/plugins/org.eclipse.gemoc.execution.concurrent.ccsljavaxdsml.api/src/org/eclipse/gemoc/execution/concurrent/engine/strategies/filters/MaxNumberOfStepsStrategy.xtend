package org.eclipse.gemoc.execution.concurrent.engine.strategies.filters

import java.util.ArrayList
import org.chocosolver.solver.Model
import org.chocosolver.solver.expression.discrete.arithmetic.ArExpression
import org.eclipse.gemoc.execution.concurrent.engine.strategies.SymbolicFilteringStrategy
import org.eclipse.gemoc.execution.concurrent.symbolic.SmallStepVariable
import org.eclipse.xtend.lib.annotations.Accessors

class MaxNumberOfStepsStrategy implements SymbolicFilteringStrategy {
	
	@Accessors
	var int maxNumberOfSteps

	new(int maxNumberOfSteps) {
		this.maxNumberOfSteps = maxNumberOfSteps
	}

	new() {
		this(2)
	}
	
	override filterSymbolically(Model symbolicPossibleSteps) {
		var allVars = new ArrayList()
		for(v : symbolicPossibleSteps.vars){
			if (v instanceof SmallStepVariable){
				allVars.add(v)
			}
		}
		//x.add(y.add(z)).lt(2).post();
		var ArExpression expr = allVars.get(0);
		for(var i = 1; i < allVars.size; i++){
			expr = expr.add(allVars.get(i));
		}
		expr.le(maxNumberOfSteps).post()		
	}
}
