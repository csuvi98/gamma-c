/********************************************************************************
 * Copyright (c) 2018-2020 Contributors to the Gamma project
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * SPDX-License-Identifier: EPL-1.0
 ********************************************************************************/
package hu.bme.mit.gamma.statechart.phase.transformation

import hu.bme.mit.gamma.expression.model.NamedElement
import hu.bme.mit.gamma.statechart.composite.ComponentInstance

class Namings {
	
	static def getName(NamedElement element, ComponentInstance instance) {
		return element.getName + "Of" + instance.name
	}
	
}