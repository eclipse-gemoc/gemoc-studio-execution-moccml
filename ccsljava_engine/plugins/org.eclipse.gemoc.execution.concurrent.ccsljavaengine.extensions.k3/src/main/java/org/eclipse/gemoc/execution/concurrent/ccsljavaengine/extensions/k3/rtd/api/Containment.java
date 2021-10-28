/**
 * Copyright (c) 2017 Inria and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Inria - initial API and implementation
 */
package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Just for marking properties with containment indications.
 * Cannot use @Composition as we don't want any processor to be invoked.
 * This is up to the implementation to enforce (or not) the uniqueness in the model
 * Language  implementers should consider that the absence of this tag is equivalent to setting it to its default value (ie. CONTAINER )
 * as this is the default behavior for primitive type
 */
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@SuppressWarnings("all")
public @interface Containment {
  /**
   * Containment strategies
   */
  public enum ContainmentStrategy {
    /**
     * CONTAINER: the property is a container;
     * 	<ul>
     * 		<li>on collections, the elements in the collection are considered as the content
     * 		<li>on maps, the elements in the keys and the elements in the values are considered as the content
     * 		<li>in other cases, the element itself is considered as the content
     *  </ul>
     */
    CONTAINER,
    
    /**
     * REFERENCE: the property is a reference;
     * 		<ul>
     * 			<li>on collections, the elements in the collection ares considered as the references
     * 			<li>on maps, the elements in the keys and the elements in the values are considered as the references
     * 			<li> in other cases, the element itself is considered as the reference
     * 		</ul>
     */
    REFERENCE,
    
    /**
     * MAP_KEYCONTAINMENT_VALUEREFERENCE: special case for Map: the elements in the keys are considered as contained, the elements in the values are considered as references;
     */
    MAP_KEYCONTAINMENT_VALUEREFERENCE,
    
    /**
     * MAP_KEYREFERENCE_VALUECONTAINMENT: special case for Map: the elements in the keys are considered as references, the elements in the values are considered as contained;
     */
    MAP_KEYREFERENCE_VALUECONTAINMENT;
  }
  public Containment.ContainmentStrategy value() default Containment.ContainmentStrategy.CONTAINER;
}
