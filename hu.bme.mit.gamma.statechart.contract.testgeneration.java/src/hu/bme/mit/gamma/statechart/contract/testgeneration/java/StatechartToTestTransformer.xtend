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
package hu.bme.mit.gamma.statechart.contract.testgeneration.java

import hu.bme.mit.gamma.expression.model.Expression
import hu.bme.mit.gamma.statechart.contract.tracegeneration.StatechartContractToTraceTransformer
import hu.bme.mit.gamma.statechart.model.State
import hu.bme.mit.gamma.statechart.model.StatechartDefinition
import hu.bme.mit.gamma.statechart.model.contract.AdaptiveContractAnnotation
import hu.bme.mit.gamma.statechart.model.contract.StateContractAnnotation
import hu.bme.mit.gamma.trace.testgeneration.java.TestGenerator
import hu.bme.mit.gamma.uppaal.composition.transformation.api.util.DefaultCompositionToUppaalTransformer
import hu.bme.mit.gamma.uppaal.composition.transformation.api.util.ElementCoverage
import hu.bme.mit.gamma.util.FileUtil
import hu.bme.mit.gamma.util.GammaEcoreUtil
import java.io.File
import java.util.List

import static extension hu.bme.mit.gamma.statechart.model.derivedfeatures.StatechartModelDerivedFeatures.*
import hu.bme.mit.gamma.uppaal.verification.UppaalVerifier

class StatechartToTestTransformer {
	
	val queryParameters = "-C -t1"
	
	protected final extension FileUtil fileUtil = FileUtil.INSTANCE
	protected final extension GammaEcoreUtil ecoreUtil = GammaEcoreUtil.INSTANCE
	
	def execute(StatechartDefinition statechart, File containingFile, File testFolder, String basePackageName) {
		execute(statechart, #[], containingFile, testFolder, basePackageName, null)
	}
	
	def execute(StatechartDefinition statechart, List<Expression> arguments, File containingFile,
			File testFolder, String basePackageName, String fileName) {
		val adaptiveContractAnnotation = statechart.annotation as AdaptiveContractAnnotation
		// Transforming the statechart to UPPAAL
		val uppaalTransformer = new DefaultCompositionToUppaalTransformer
		val uppaalResult = uppaalTransformer.transformComponent(statechart.containingPackage, arguments,
			containingFile, #[ElementCoverage.TRANSITION_COVERAGE])
		val uppaalTraceability = uppaalResult.key
		val uppaalFile = uppaalResult.value.key
		
		// Getting traces from the simple states
		val modelModifier = uppaalTransformer.testQueryGenerationHandler.modelModifier
		val transitionAnnotations = modelModifier.transitionAnnotations
		for (transition : transitionAnnotations.keySet
				.filter[it.targetState instanceof State]
				.filter[!(it.targetState as State).isComposite]) {
			var simpleState = transition.targetState as State
			// Back-annotating s the model transformer deleted the contract statecharts from the resource set
			simpleState = statechart.findState(simpleState) 
			// Getting traces to the simple states
			val tranistionId = transitionAnnotations.get(transition)
			val uppaalQuery = "E<> " + modelModifier.getTransitionIdVariableName + " == " + tranistionId + " && isStable"
			val verifier = new UppaalVerifier
			val simpleStateExecutionTrace = verifier.verifyQuery(uppaalTraceability, queryParameters,
				uppaalFile, uppaalQuery, true, false)
			
			simpleStateExecutionTrace => [
				it.import = adaptiveContractAnnotation.monitoredComponent.containingPackage
				it.component = adaptiveContractAnnotation.monitoredComponent
				// No arguments supported yet
				it.steps.forEach[it.instanceStates.clear] // Clearing instance state checks
			]
			
			// Transforming traces from the referenced statecharts
			val contractStates = newArrayList(simpleState)
			contractStates += simpleState.ancestors
			val contractStatecharts = newArrayList
			contractStatecharts += contractStates.map[it.annotation].filter(StateContractAnnotation)
				.map[it.contractStatecharts].flatten.toSet
			
			val finalTraces = newArrayList
			val contractToTraceTransformer = new StatechartContractToTraceTransformer
			for (contractStatechart : contractStatecharts) {
				val contractTraces = contractToTraceTransformer.execute(contractStatechart)
				for (contractTrace : contractTraces) {
					val finalTrace = simpleStateExecutionTrace.clone(true, true)
					finalTrace.steps += contractTrace.steps
					finalTraces += finalTrace
				}
				// Generating tests
				val className = '''�IF fileName === null��simpleState.name.toFirstUpper��tranistionId��contractStatechart.name.toFirstUpper��ELSE��fileName��ENDIF�'''
				val testGenerator = new TestGenerator(finalTraces, basePackageName, className)
				val testClass = testGenerator.execute
				val testClassFile = getFile(testFolder, testGenerator.packageName, className)
				testClassFile.saveString(testClass)
			}
		}
	}
	
	private def findState(StatechartDefinition statechart, State newState) {
		val brokenAnnotation = newState.annotation
		newState.annotation = null
		for (state : statechart.allStates.filter[!it.composite]) {
			val clonedState = state.clone(true, true) => [
				it.annotation = null
			]
			if (clonedState.helperEquals(newState)) {
				newState.annotation = brokenAnnotation
				return state
			}
		}
		throw new IllegalArgumentException("Not found same state: " + newState)
	}
	
}