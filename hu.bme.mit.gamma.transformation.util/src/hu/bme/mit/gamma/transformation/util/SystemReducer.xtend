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
package hu.bme.mit.gamma.transformation.util

import hu.bme.mit.gamma.statechart.model.CompositeElement
import hu.bme.mit.gamma.statechart.model.Package
import hu.bme.mit.gamma.statechart.model.Region
import hu.bme.mit.gamma.statechart.model.StatechartDefinition
import hu.bme.mit.gamma.statechart.model.Transition
import hu.bme.mit.gamma.statechart.model.composite.BroadcastChannel
import hu.bme.mit.gamma.statechart.model.composite.SimpleChannel
import hu.bme.mit.gamma.statechart.model.composite.SynchronousComponentInstance
import hu.bme.mit.gamma.statechart.model.composite.SynchronousCompositeComponent
import hu.bme.mit.gamma.transformation.util.queries.Regions
import hu.bme.mit.gamma.transformation.util.queries.RemovableTransitions
import hu.bme.mit.gamma.transformation.util.queries.SimpleInstances
import hu.bme.mit.gamma.transformation.util.queries.TopRegions
import java.util.logging.Level
import java.util.logging.Logger
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.query.runtime.emf.EMFScope

import static extension hu.bme.mit.gamma.statechart.model.derivedfeatures.StatechartModelDerivedFeatures.*

class SystemReducer {
	
	final ViatraQueryEngine engine
	
	final extension Logger logger = Logger.getLogger("GammaLogger")

	new(ResourceSet resourceSet) {
		this.engine = ViatraQueryEngine.on(new EMFScope(resourceSet))
	}
	
	def execute() {
		val transitionMatcher = RemovableTransitions.Matcher.on(engine)
		val topRegionsMatcher = TopRegions.Matcher.on(engine)
		val simpleInstancesMatcher = SimpleInstances.Matcher.on(engine)
		val statecharts = newHashSet
		statecharts += topRegionsMatcher.allValuesOfstatechart
		// Transition optimizing
		while (transitionMatcher.hasMatch) {
			for (transition : transitionMatcher.allValuesOftransition.reject[it.eContainer === null]) {
				transition.removeTransition
			}
		}
		// Region optimizing
		val regionMatcher = Regions.Matcher.on(engine)
		for (region : regionMatcher.allValuesOfregion) {
			region.removeUnnecessaryRegion
		}
		for (transition : statecharts) {
			
		}
		// Statechart optimizing
		for (statechart : statecharts) {
			if (statechart.regions.empty || !simpleInstancesMatcher.hasMatch(null, statechart)) {
				statechart.regions.clear
				statechart.variableDeclarations.clear
				statechart.timeoutDeclarations.clear
				statechart.transitions.clear
				log(Level.INFO, "Removing statechart content: " + statechart.name)
			}
			// Removing transitions who went out of a state from a removed region
			for (transition : statechart.transitions.toSet /*To avoid concurrent modification*/ ) {
				val source = transition.sourceState
				val target = transition.targetState
				try {
					source.containingStatechart
					target.containingStatechart
				} catch (NullPointerException exception) {
					EcoreUtil.delete(transition)
				}
			}
		}
		// Instance optimizing
		for (instance : simpleInstancesMatcher.allValuesOfinstance) {
			instance.removeUnnecessaryStatechartInstance
		}
	}
	
	private def void removeTransition(Transition transition) {
		val statechart = transition.eContainer as StatechartDefinition
		val target = transition.targetState
		if (target.incomingTransitions.size == 1) {
			for (outgoingTransition : target.outgoingTransitions
					.reject[it === transition] /* Addressing loop edges */) {
				outgoingTransition.removeTransition
			}
			val region = target.parentRegion
			log(Level.INFO, "Removing state node " + target.name)
			region.stateNodes -= target
		}
		log(Level.INFO, "Removing transition " + transition.sourceState.name + " -> " + transition.targetState.name)
		statechart.transitions -= transition
	}
	
	private def void removeUnnecessaryRegion(Region region) {
		val states = region.states
		if (states.forall[!it.composite && it.outgoingTransitions.empty &&
				it.entryActions.empty && it.exitActions.empty || it.incomingTransitions.empty]) {
			// First, removing all related transitions (as otherwise nullptr exceptions are generated in incomingTransitions)
			val statechart = region.containingStatechart
			statechart.transitions -= (states.map[it.incomingTransitions].flatten + 
				states.map[it.outgoingTransitions].flatten).toList
			// Removing region
			val compositeElement = region.eContainer as CompositeElement
			compositeElement.regions -= region
			log(Level.INFO, "Removing region " + region.name + " of " + statechart.name)
		}
	}
	
	private def void removeUnnecessaryStatechartInstance(SynchronousComponentInstance instance) {
		val statechart = instance.type as StatechartDefinition
		if (statechart.regions.empty) {
			val container = instance.eContainer
			// It can be either an asynchronous adapter or a synchronous composite
			if (container instanceof SynchronousCompositeComponent) {
				container.components -= instance
				val _package = statechart.eContainer as Package
				_package.components -= statechart
				log(Level.INFO, "Removing statechart instance " + instance.name)
				// Port binding remover
				val unnecessaryPortBindings = container.portBindings
					.filter[it.instancePortReference.instance === instance].toList
				container.portBindings -= unnecessaryPortBindings
				// Channel remover
				val channels = container.channels
				val unnecessaryChannels = (channels.filter[it.providedPort.instance === instance] + 
					channels.filter(SimpleChannel).filter[it.requiredPort.instance === instance] +
					channels.filter(BroadcastChannel).filter[it.requiredPorts.exists[it.instance === instance]]).toList
				container.channels -= unnecessaryChannels
			}
		}
	}
	
}
