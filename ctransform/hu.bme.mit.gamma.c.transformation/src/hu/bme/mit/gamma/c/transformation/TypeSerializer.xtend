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
package hu.bme.mit.gamma.c.transformation

import hu.bme.mit.gamma.expression.model.BooleanTypeDefinition
import hu.bme.mit.gamma.expression.model.DecimalTypeDefinition
import hu.bme.mit.gamma.expression.model.EnumerationTypeDefinition
import hu.bme.mit.gamma.expression.model.IntegerTypeDefinition
import hu.bme.mit.gamma.expression.model.RationalTypeDefinition
import hu.bme.mit.gamma.expression.model.Type
import hu.bme.mit.gamma.expression.model.TypeReference

import static extension hu.bme.mit.gamma.expression.derivedfeatures.ExpressionModelDerivedFeatures.*

class TypeSerializer {
	
	def dispatch String serialize(Type type) {
		throw new IllegalArgumentException("Not supported expression: " + type)
	}
	
	def dispatch String serialize(TypeReference type) '''«IF type.reference.type.isPrimitive»«type.reference.type.serialize»«ELSE»enum «type.reference.name»«ENDIF»'''
	
	def dispatch String serialize(BooleanTypeDefinition type) '''bool'''
	
	def dispatch String serialize(IntegerTypeDefinition type) '''long'''
	
	def dispatch String serialize(DecimalTypeDefinition type) '''double'''
	
	def dispatch String serialize(RationalTypeDefinition type) '''double'''
	
	def dispatch String serialize(EnumerationTypeDefinition type) {
		throw new IllegalArgumentException("Anonymous enumeration types are not supported: " + type)
	}

}
