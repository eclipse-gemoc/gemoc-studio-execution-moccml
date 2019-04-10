/*******************************************************************************
 * Copyright (c) 2017 INRIA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     INRIA - initial API and implementation
 *******************************************************************************/
package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.ui.dialogs;

import org.eclipse.gemoc.commons.eclipse.core.resources.FileFinderVisitor;
import org.eclipse.gemoc.commons.eclipse.ui.dialogs.SelectSpecificFileDialog;


public class SelectECLIFileDialog extends SelectSpecificFileDialog {

	@Override
	protected FileFinderVisitor instanciateFinder() {
		return new FileFinderVisitor("ecl");
	}

}
