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
package hu.bme.mit.gamma.lowlevel.xsts.transformation

import hu.bme.mit.gamma.expression.model.ExpressionModelFactory
import hu.bme.mit.gamma.statechart.lowlevel.model.Region
import hu.bme.mit.gamma.statechart.lowlevel.model.State
import hu.bme.mit.gamma.statechart.lowlevel.model.StateNode
import hu.bme.mit.gamma.xsts.model.model.Action
import hu.bme.mit.gamma.xsts.model.model.ParallelAction
import hu.bme.mit.gamma.xsts.model.model.XSTSModelFactory

import static extension hu.bme.mit.gamma.statechart.lowlevel.model.derivedfeatures.LowlevelStatechartModelDerivedFeatures.*

class RegionDeactivator {
	// Model factories
	protected final extension XSTSModelFactory factory = XSTSModelFactory.eINSTANCE
	protected final extension ExpressionModelFactory constraintFactory = ExpressionModelFactory.eINSTANCE
	// Trace needed for variable references
	protected final Trace trace
		
	new(Trace trace) {
		this.trace = trace
	}
	
	// Parent region handling
	
	protected def Action createRecursiveXStsParentStateDeactivatingAction(StateNode lowlevelStateNode,
			State lowlevelTopState, boolean inclusiveTopState) {
		val lowlevelParentState = lowlevelStateNode.parentState
		val lowlevelParentRegion = lowlevelStateNode.parentRegion
		if (lowlevelParentRegion.isTopRegion ||
				(inclusiveTopState && lowlevelStateNode == lowlevelTopState) ||
				(!inclusiveTopState && lowlevelParentState == lowlevelTopState)) {
			// Deactivating only if we have not reached the top
			return createEmptyAction
		}
		val lowlevelGrandparentRegion = lowlevelParentState.parentRegion
		val singleXStsRegionDeactivatingAction = lowlevelGrandparentRegion.createSingleXStsRegionDeactivatingAction
		return createSequentialAction => [
			// No orthogonality
			it.actions += singleXStsRegionDeactivatingAction
			// Recursion
			it.actions += lowlevelParentState.createRecursiveXStsParentStateDeactivatingAction(
				lowlevelTopState, inclusiveTopState)
		]
	}
	
	/**
	 * Based on the given low-level state an action is created defining that the xSTS parent region
	 * variables of all parent states (excluding the given state) are set to the xSTS enum literal
	 * associated to the given low-level initial state, if the parent region of the parent state has
	 * no history, and does nothing if the parent region has history. This is done recursively for
	 * all parent regions, up until the top level state (its parent region is deactivated but its
	 * grandparent region is not), e.g., parentRegion1 (region variable) := Init (state enum literal);
	 * parentRegion2 (region variable) := SubregionInit (state enum literal). 
	 */
	protected def Action createRecursiveXStsParentStateDeactivatingActionWithOrthogonality(StateNode lowlevelStateNode,
			State lowlevelTopState) {
		val lowlevelRegion = lowlevelStateNode.parentRegion
		if (lowlevelRegion.isTopRegion || lowlevelStateNode == lowlevelTopState) {
			// Deactivating only if we have not reached the top
			return createEmptyAction
		}
		val lowlevelParentState = lowlevelStateNode.parentState
		val lowlevelGrandparentRegion = lowlevelParentState.parentRegion
		val singleXStsRegionDeactivatingAction = lowlevelGrandparentRegion.createSingleXStsRegionDeactivatingAction
		return createSequentialAction => [
			if (lowlevelGrandparentRegion.hasOrthogonalRegion) {
				// Orthogonal region
				it.actions += lowlevelGrandparentRegion.createRecursiveXStsOrthogonalRegionDeactivatingAction as ParallelAction => [
					it.actions += singleXStsRegionDeactivatingAction
				]
			}
			else {
				// No orthogonality
				it.actions += singleXStsRegionDeactivatingAction
			}
			// Recursion
			it.actions += lowlevelParentState.createRecursiveXStsParentStateDeactivatingActionWithOrthogonality(lowlevelTopState)
		]
	}
	
	// Subregion handling
	
	protected def createRecursiveXStsOrthogonalRegionDeactivatingAction(Region lowlevelRegion) {
		if (!lowlevelRegion.hasOrthogonalRegion) {
			return createEmptyAction
		}
		return createParallelAction => [
			for (lowlevelOrthogonalRegion : lowlevelRegion.orthogonalRegions) {
				it.actions += lowlevelOrthogonalRegion.createRecursiveXStsRegionAndSubregionDeactivatingAction
			}
		]
	}
	
	/**
	 * Based on the given low-level state an assignment action is created defining that the xSTS parent
	 * region variables of all SUBSTATES (including the given state) AND states of possible ORTHOGONAL regions
	 * are set to the xSTS enum literal associated to the given low-level initial state, if the parent region
	 * has no history, and does nothing if the parent region has history. This is done recursively for all
	 * contained regions, e.g., subregion1 (region variable) := Init (state enum literal);
	 * subregion2 (region variable) := SubregionInit (state enum literal). 
	 */
	 protected def Action createRecursiveXStsStateAndSubstateDeactivatingAction(State lowlevelState) {
		val lowlevelParentRegion = lowlevelState.parentRegion
		return createSequentialAction => [
			it.actions += lowlevelParentRegion.createSingleXStsRegionDeactivatingAction
			if (lowlevelState.composite) {
				it.actions += createParallelAction => [
					for (lowlevelSubregion : lowlevelState.regions) {
						it.actions += lowlevelSubregion.createRecursiveXStsRegionAndSubregionDeactivatingAction
					} 
				]
			}
		]
	}
	 
	protected def Action createRecursiveXStsStateAndSubstateDeactivatingActionWithOrthogonality(State lowlevelState) {
		val lowlevelParentRegion = lowlevelState.parentRegion
		val recursiveXStsStateAndSubstateDeactivatingAction = lowlevelState.createRecursiveXStsStateAndSubstateDeactivatingAction
		if (!lowlevelParentRegion.hasOrthogonalRegion) {
			return recursiveXStsStateAndSubstateDeactivatingAction
		}
		// Orthogonality
		return lowlevelParentRegion.createRecursiveXStsOrthogonalRegionDeactivatingAction as ParallelAction => [
			it.actions += recursiveXStsStateAndSubstateDeactivatingAction
		]
	}
	
	/**
	 * Based on the given low-level region, an assignment action is created defining that the xSTS region variable
	 * is set to the xSTS enum literal associated to the given low-level initial state, if the region has no history,
	 * and does nothing if the parent region has history.This is done recursively for all contained regions, e.g.,
	 * main_region (region variable) := Init (state enum literal); subregion (region variable) := SubregionInit (state enum literal). 
	 */
	protected def Action createRecursiveXStsRegionAndSubregionDeactivatingAction(Region lowlevelRegion) {
		return createSequentialAction => [
			it.actions += lowlevelRegion.createSingleXStsRegionDeactivatingAction
			if (!lowlevelRegion.isLeaf) {
				it.actions += createParallelAction => [
					for (lowlevelSubstate : lowlevelRegion.stateNodes.filter(State)) {
						for (lowlevelSubregion : lowlevelSubstate.regions) {
							it.actions += lowlevelSubregion.createRecursiveXStsRegionAndSubregionDeactivatingAction
						} 
					}
				]
			}
		]
	}
	
	protected def createSingleXStsRegionDeactivatingAction(Region lowlevelRegion) {
		if (lowlevelRegion.hasHistory) {
			// If the parent region has history, no action
			return createEmptyAction
		}
		else {
			return createAssignmentAction => [
				it.lhs = createReferenceExpression => [
					it.declaration = trace.getXStsVariable(lowlevelRegion)
				]
				it.rhs = createEnumerationLiteralExpression => [
					it.reference = trace.getXStsInactiveEnumLiteral(lowlevelRegion)
				]
			]
		}
	}
	
}