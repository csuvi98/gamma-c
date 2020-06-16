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
package hu.bme.mit.gamma.codegenerator.java.util

import hu.bme.mit.gamma.expression.model.EnumerationTypeDefinition
import hu.bme.mit.gamma.expression.model.Type
import hu.bme.mit.gamma.expression.model.TypeDeclaration

class TypeDeclarationSerializer {
	
	def String serialize(TypeDeclaration type) {
		val declaredType = type.type
		return declaredType.serialize(type.name)
	}
	
	def dispatch String serialize(Type type, String name) {
		throw new IllegalArgumentException("Not supported type: " + type)
	}
	
	def dispatch String serialize(EnumerationTypeDefinition type, String name) '''
		enum �name� {�FOR literal : type.literals SEPARATOR ', '��literal.name��ENDFOR�}
	'''
}