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
package org.eclipse.gemoc.execution.moccml.testscenariolang.xtext;

import org.eclipse.gemoc.execution.moccml.testscenariolang.model.TestScenarioLang.LiveStateKind;
import org.eclipse.xtext.common.services.Ecore2XtextTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.nodemodel.INode;

import fr.inria.aoste.trace.EnableStateKind;
import fr.inria.aoste.trace.FiredStateKind;

public class TestScenarioLangTerminalConverters extends
		Ecore2XtextTerminalConverters {

	private static final class FiredStateKindValueConverterImplementation
		extends AbstractNullSafeConverter<FiredStateKind> {

		@Override
		protected String internalToString(FiredStateKind value) {
			if (value == FiredStateKind.TICK) {
				return "ticks";
			}
			else if (value == FiredStateKind.NO_TICK) {
				return "doesnot tick";
			}
			return null;
		}

		@Override
		protected FiredStateKind internalToValue(String string, INode node)
				throws ValueConverterException {
			if (string.compareTo("ticks") == 0) {
				return FiredStateKind.TICK;
			}
			else if (string.compareTo("doesnot tick") == 0) {
				return FiredStateKind.NO_TICK;
			}
			else if (string.compareTo("doesnot_tick") == 0) {
				return FiredStateKind.NO_TICK;
			}
			return null;
		}
		
	}
	
	@ValueConverter (rule = "FiredStateKind")
	public IValueConverter<FiredStateKind> getFiredStateKindConverter() {
	    return new FiredStateKindValueConverterImplementation();
	} 
	
	private static final class EnableStateKindValueConverter extends AbstractNullSafeConverter<EnableStateKind> {
		@Override
		protected String internalToString(EnableStateKind value) {
			switch (value) {
			case TICK:
				return "must_tick";
			case NO_TICK:
				return "cannot_tick";
			case FREE:
				return "is_free";
			case INDETERMINED:
				return "is_undetermined";
			default:
				break;
			}
			return null;
		}
		
		@Override
		protected EnableStateKind internalToValue(String string, INode node)
				throws ValueConverterException {
			if (string.compareTo("must_tick") == 0) {
				return EnableStateKind.TICK;
			}
			else if (string.compareTo("cannot_tick") == 0) {
				return EnableStateKind.NO_TICK;
			}
			else if (string.compareTo("is_free") == 0) {
				return EnableStateKind.FREE;
			}
			else if (string.compareTo("is_undetermined") == 0) {
				return EnableStateKind.INDETERMINED;
			}
			return null;
		}
	}
	
	@ValueConverter (rule = "EnableStateKind")
	public IValueConverter<EnableStateKind> getEnableStateKindConverter() {
		return new EnableStateKindValueConverter();
	}
	
	private static final class LiveStateKindValueConverter extends AbstractNullSafeConverter<LiveStateKind> {

		@Override
		protected String internalToString(LiveStateKind value) {
			return value.name();
		}

		@Override
		protected LiveStateKind internalToValue(String string, INode node)
				throws ValueConverterException {
			return LiveStateKind.getByName(string);
		}
		
	}
	
	@ValueConverter (rule = "LiveStateKind")
	public IValueConverter<LiveStateKind> getLiveStateKindConverter() {
		return new LiveStateKindValueConverter();
	}
}
