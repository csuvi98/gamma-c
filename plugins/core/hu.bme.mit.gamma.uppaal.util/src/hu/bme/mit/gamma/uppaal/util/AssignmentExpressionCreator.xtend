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
package hu.bme.mit.gamma.uppaal.util

import hu.bme.mit.gamma.util.GammaEcoreUtil
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import uppaal.core.NamedElement
import uppaal.declarations.DataVariableDeclaration
import uppaal.declarations.VariableContainer
import uppaal.declarations.VariableDeclaration
import uppaal.expressions.AssignmentExpression
import uppaal.expressions.AssignmentOperator
import uppaal.expressions.Expression
import uppaal.expressions.ExpressionsFactory
import uppaal.expressions.LogicalOperator
import uppaal.expressions.NegationExpression
import uppaal.templates.Edge
import uppaal.templates.Location
import uppaal.templates.TemplatesFactory

class AssignmentExpressionCreator {
	// NTA builder
	protected final extension NtaBuilder ntaBuilder
	// UPPAAL factories
	protected final extension ExpressionsFactory expFact = ExpressionsFactory.eINSTANCE
	protected final extension TemplatesFactory temFact = TemplatesFactory.eINSTANCE
	// Auxiliary objects
	protected final extension GammaEcoreUtil gammaEcoreUtil = GammaEcoreUtil.INSTANCE
	
	new(NtaBuilder ntaBuilder) {
		this.ntaBuilder = ntaBuilder
	}
	
	/**
	 * Puts an assignment expression onto the given container. The left side is the
	 * given variable, the right side is either true or false. E.g.: myVariable = true.
	 */
	def createAssignmentExpression(EObject container, EReference reference,
			DataVariableDeclaration variable, boolean isTrue) {
		return container.createAssignmentExpression(reference, variable, isTrue.toString)
	}
	
	/**
	 * Puts an assignment expression onto the given container. The left side is the
	 * given variable, the right side is an integer value. E.g.: myVariable = 0.
	 */
	def createAssignmentExpression(EObject container, EReference reference,
			VariableDeclaration variable, String value) {
		val assignmentExpression = variable.createAssignmentExpression(value)
		container.add(reference, assignmentExpression)
		return assignmentExpression
	}
	
	protected def createAssignmentExpression(VariableDeclaration variable, String value) {
		return createAssignmentExpression => [
			it.firstExpr = createIdentifierExpression => [
				it.identifier = variable.variable.head // Only one variable is expected
			]
			it.operator = AssignmentOperator.EQUAL
			it.secondExpr = createLiteralExpression => [
				it.text = value
			]
		]
	}
	
	/**
	 * Puts an assignment expression onto the given container. The left side is the first given variable,
	 * the right side is the second given variable". E.g.: myFirstVariable = mySecondVariable.
	 */
	def void createAssignmentExpression(EObject container, EReference reference,
			DataVariableDeclaration lhs, DataVariableDeclaration rhs) {
   		container.add(reference,
			createAssignmentExpression => [
				it.firstExpr = createIdentifierExpression => [
					it.identifier = lhs.variable.head // Only one variable is expected
				]
				it.operator = AssignmentOperator.EQUAL
				it.secondExpr = createIdentifierExpression => [
					it.identifier = rhs.variable.head // Only one variable is expected
				]
			]
		)
	}
	
	def AssignmentExpression createAssignmentExpression(EObject container,
			EReference reference, VariableContainer variable, Expression rhs) {
		val assignmentExpression = createAssignmentExpression => [
			it.firstExpr = createIdentifierExpression => [
				it.identifier = variable.variable.head // Only one variable is expected
			]
			it.operator = AssignmentOperator.EQUAL
			it.secondExpr = rhs
		]
		container.add(reference, assignmentExpression)
		return assignmentExpression
	}
	
	def AssignmentExpression createIfThenElseAssignment(EObject container, EReference reference,
			VariableContainer variable,	NamedElement _if, NamedElement _then, NamedElement _else) {
		return container.createIfThenElseAssignment(reference, variable, 
			createIdentifierExpression => [it.identifier = _if],
			createIdentifierExpression => [it.identifier = _then],
			createIdentifierExpression => [it.identifier = _else]
		)
	}
	
	def AssignmentExpression createIfThenElseAssignment(EObject container, EReference reference,
			VariableContainer variable,	NamedElement _if, String _then, NamedElement _else) {
		return container.createIfThenElseAssignment(reference, variable, 
			createIdentifierExpression => [it.identifier = _if],
			createLiteralExpression => [it.text = _then],
			createIdentifierExpression => [it.identifier = _else]
		)
	}
	
	def AssignmentExpression createIfThenElseAssignment(EObject container, EReference reference,
			VariableContainer variable, NamedElement _if, NamedElement _then, String _else) {
		return container.createIfThenElseAssignment(reference, variable, 
			createIdentifierExpression => [it.identifier = _if],
			createIdentifierExpression => [it.identifier = _then],
			createLiteralExpression => [it.text = _else]
		)
	}
	
	def AssignmentExpression createIfThenElseAssignment(EObject container, EReference reference,
			VariableContainer variable, Expression _if, Expression _then, Expression _else) {
		val assignmentExpression = createAssignmentExpression => [
			it.firstExpr = createIdentifierExpression => [
				it.identifier = variable.variable.head // Only one variable is expected
			]
			it.operator = AssignmentOperator.EQUAL
			it.secondExpr = createConditionExpression => [
				it.ifExpression = _if
				it.thenExpression = _then
				it.elseExpression = _else
			]
		]
		container.add(reference, assignmentExpression)
		return assignmentExpression
	}
	
	/**
	 * Puts an assignment expression onto the given container. The left side is the first given variable,
	 * the right side is the second given variable in disjunction with the third variable.
	 * E.g.: myFirstVariable = mySecondVariable (op) myThirdVariable.
	 */
	def void createAssignmentLogicalExpression(EObject container, EReference reference,
			DataVariableDeclaration lhs, DataVariableDeclaration rhsl, LogicalOperator operator, DataVariableDeclaration rhsr) {
   		container.add(reference,
   			createAssignmentExpression => [
				it.firstExpr = createIdentifierExpression => [
					it.identifier = lhs.variable.head // Only one variable is expected
				]
				it.operator = AssignmentOperator.EQUAL
				it.secondExpr = createLogicalExpression => [
					it.firstExpr = createIdentifierExpression => [
						it.identifier = rhsl.variable.head // Only one variable is expected
					]
					it.operator = operator
					it.secondExpr = createIdentifierExpression => [
						it.identifier = rhsr.variable.head // Only one variable is expected
					]
				]
			]
		)
	}
	
	/**
	 * Creates a loop edge onto the given location that sets the toRaise flag of the give signal to isTrue.
	 */
	def createLoopEdgeWithBoolAssignment(Location location, DataVariableDeclaration variable, boolean isTrue) {
		val loopEdge = location.createEdge(location)
		// variable = isTrue
		loopEdge.update += variable.createAssignmentExpression(isTrue.toString)
		return loopEdge
	}
	
	/**
	 * Creates a loop edge onto the given location that sets the toRaise flag of the give signal to true and puts a guard on it too,
	 * so the edge is only fireable if the variable-to-be-set is false.
	 */
	def createLoopEdgeWithGuardedBoolAssignment(Location location, DataVariableDeclaration variable) {
		val loopEdge = location.createLoopEdgeWithBoolAssignment(variable, true)
		val negationExpression = createNegationExpression as NegationExpression => [
			it.negatedExpression = createIdentifierExpression => [
				it.identifier = variable.variable.head
			]
		]
		// Only fireable if the bool variable is not already set
		loopEdge.addGuard(negationExpression, LogicalOperator.AND)
		return loopEdge
	}
	
	def extendLoopEdgeWithGuardedBoolAssignment(Edge loopEdge, DataVariableDeclaration variable) {
		loopEdge.update += variable.createAssignmentExpression(true.toString)
		val negationExpression = createNegationExpression as NegationExpression => [
			it.negatedExpression = createIdentifierExpression => [
				it.identifier = variable.variable.head
			]
		]
		// Only fireable if the bool variable is not already set
		loopEdge.addGuard(negationExpression, LogicalOperator.AND)
		return loopEdge
	}
	
}