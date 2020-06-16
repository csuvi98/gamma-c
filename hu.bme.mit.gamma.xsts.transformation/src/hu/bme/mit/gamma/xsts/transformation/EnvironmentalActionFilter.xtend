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
package hu.bme.mit.gamma.xsts.transformation

import hu.bme.mit.gamma.expression.util.ExpressionUtil
import hu.bme.mit.gamma.statechart.model.composite.Component
import hu.bme.mit.gamma.statechart.model.interface_.Persistency
import hu.bme.mit.gamma.xsts.model.model.Action
import hu.bme.mit.gamma.xsts.model.model.AssignmentAction
import hu.bme.mit.gamma.xsts.model.model.AssumeAction
import hu.bme.mit.gamma.xsts.model.model.CompositeAction
import hu.bme.mit.gamma.xsts.model.model.XSTSModelFactory
import java.util.Set
import org.eclipse.emf.ecore.util.EcoreUtil

import static hu.bme.mit.gamma.xsts.transformation.util.Namings.*

import static extension hu.bme.mit.gamma.expression.model.derivedfeatures.ExpressionModelDerivedFeatures.*
import static extension hu.bme.mit.gamma.statechart.model.derivedfeatures.StatechartModelDerivedFeatures.*

class EnvironmentalActionFilter {
	// Names that need to be kept
	Set<String> necessaryNames
	// Auxiliary objects
	protected extension ExpressionUtil expressionUtil = ExpressionUtil.INSTANCE
	protected final extension XSTSModelFactory xstsModelFactory = XSTSModelFactory.eINSTANCE
	
	def void deleteEverythingExceptSystemEventsAndParameters(CompositeAction action, Component component) {
		necessaryNames = newHashSet
		// Input and output events and parameters
		for (port : component.allConnectedSimplePorts) {
			val statechart = port.containingStatechart
			val instance = statechart.referencingComponentInstance
			for (eventDeclaration : port.interfaceRealization.interface.allEventDeclarations) {
				val event = eventDeclaration.event
				necessaryNames += customizeInputName(event, port, instance)
				necessaryNames += customizeOutputName(event, port, instance)
				for (parameter : event.parameterDeclarations) {
					necessaryNames += customizeInName(parameter, port, instance)
					if (event.persistency == Persistency.PERSISTENT) {
						necessaryNames += customizeOutName(parameter, port, instance)
					}
				}
			}
		}
		// Clock variable settings are retained too - not necessary as the timeouts are in the merged action now
//		for (simpleInstance : component.allSimpleInstances) {
//			val statechart = simpleInstance.type as StatechartDefinition
//			for (timeoutDelcaration : statechart.timeoutDeclarations) {
//				necessaryNames += customizeName(timeoutDelcaration, simpleInstance)
//			}
//		}
		action.delete
	}
	
	def Action resetEverythingExceptPersistentParameters(CompositeAction action, Component component) {
		necessaryNames = newHashSet
		for (port : component.allConnectedSimplePorts) {
			val statechart = port.containingStatechart
			val instance = statechart.referencingComponentInstance
			for (eventDeclaration : port.interfaceRealization.interface.allEventDeclarations) {
				val event = eventDeclaration.event
				if (event.persistency == Persistency.PERSISTENT) {
					for (parameter : event.parameterDeclarations) {
						necessaryNames += customizeInName(parameter, port, instance)
						necessaryNames += customizeOutName(parameter, port, instance)
					}
				}
			}
		}
		return action.reset
	}
	
	private def Action reset(CompositeAction action) {
		val xStsAssignments = newHashSet
		for (xStsAssignment : EcoreUtil.getAllContents(action, true).filter(AssignmentAction).toIterable) {
			val declaration = xStsAssignment.lhs.declaration
			val name = declaration.name
			if (!necessaryNames.contains(name)) {
				// Resetting the variable if it is not led out to the system port
				val defaultExpression = declaration.type.defaultExpression
				xStsAssignment.rhs = defaultExpression
				xStsAssignments += xStsAssignment
			}
		}
		return createSequentialAction => [
			it.actions += xStsAssignments
		]
	}
	
	private def void delete(CompositeAction action) {
		val xStsSubactions = action.actions
		val copyXStsSubactions = newArrayList
		copyXStsSubactions += xStsSubactions
		for (xStsSubaction : copyXStsSubactions) {
			if (xStsSubaction instanceof AssignmentAction) {
				val name = xStsSubaction.lhs.declaration.name
				if (!necessaryNames.contains(name)) {
					// Deleting
					xStsSubactions -= xStsSubaction
				}
			}
			else if (xStsSubaction instanceof AssumeAction) {
				val variables = xStsSubaction.assumption.referredVariables
				if (!variables.exists[necessaryNames.contains(it.name)]) {
					// Deleting the assume action
					xStsSubactions -= xStsSubaction
				}
			}
			else if (xStsSubaction instanceof CompositeAction) {
				xStsSubaction.delete
			}
		}
	}
	
	
}