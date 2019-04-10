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
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.dsa.api;

import java.io.InputStream;

public interface IK3DSAExecutorClassLoader {

	public Class<?> getClassForName(String className)  throws ClassNotFoundException ;
	public InputStream getResourceAsStream(String resourceName);
}
