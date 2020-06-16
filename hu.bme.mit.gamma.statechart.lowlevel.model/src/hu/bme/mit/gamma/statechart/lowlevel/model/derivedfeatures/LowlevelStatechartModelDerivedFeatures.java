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
package hu.bme.mit.gamma.statechart.lowlevel.model.derivedfeatures;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import hu.bme.mit.gamma.statechart.lowlevel.model.CompositeElement;
import hu.bme.mit.gamma.statechart.lowlevel.model.DeepHistoryState;
import hu.bme.mit.gamma.statechart.lowlevel.model.HistoryState;
import hu.bme.mit.gamma.statechart.lowlevel.model.InitialState;
import hu.bme.mit.gamma.statechart.lowlevel.model.Region;
import hu.bme.mit.gamma.statechart.lowlevel.model.ShallowHistoryState;
import hu.bme.mit.gamma.statechart.lowlevel.model.State;
import hu.bme.mit.gamma.statechart.lowlevel.model.StateNode;
import hu.bme.mit.gamma.statechart.lowlevel.model.StatechartDefinition;

public class LowlevelStatechartModelDerivedFeatures {
	
	public static StatechartDefinition getStatechart(EObject object) {
		if (object instanceof StatechartDefinition) {
			return (StatechartDefinition) object;
		}
		return getStatechart(object.eContainer());
	}
	
	public static boolean hasOrthogonalRegion(Region lowlevelRegion) {
		return !getOrthogonalRegions(lowlevelRegion).isEmpty();
	}

	public static List<Region> getOrthogonalRegions(Region lowlevelRegion) {
		return lowlevelRegion.getParentElement().getRegions().stream()
				.filter(it-> it != lowlevelRegion).collect(Collectors.toList());
	}
	
	public static boolean hasInitialState(Region lowlevelRegion) {
		return lowlevelRegion.getStateNodes().stream()
				.anyMatch(it -> it instanceof InitialState);
	}
	
	public static boolean hasShallowHistoryState(Region lowlevelRegion) {
		return lowlevelRegion.getStateNodes().stream()
				.anyMatch(it -> it instanceof ShallowHistoryState);
	}
	
	public static boolean hasDeepHistoryState(Region lowlevelRegion) {
		return lowlevelRegion.getStateNodes().stream()
				.anyMatch(it -> it instanceof DeepHistoryState);
	}
	
	public static boolean hasHistoryState(Region lowlevelRegion) {
		return lowlevelRegion.getStateNodes().stream()
				.anyMatch(it -> it instanceof HistoryState);
	}
	
	public static boolean hasHistory(Region lowlevelRegion) {
		return hasHistoryState(lowlevelRegion) || hasDeepHistoryAbove(lowlevelRegion);
	}
	
	public static boolean hasDeepHistoryAbove(Region lowlevelRegion) {
		if (isTopRegion(lowlevelRegion)) {
			return false;
		}
		Region parentRegion = getParentRegion(lowlevelRegion);
		return parentRegion.getStateNodes().stream()
				.anyMatch(it -> it instanceof DeepHistoryState) ||
				hasDeepHistoryAbove(parentRegion);
	}
	
	public static Region getParentRegion(Region lowlevelRegion) {
		CompositeElement parentElement = lowlevelRegion.getParentElement();
		if (!(parentElement instanceof State)) {
			throw new IllegalArgumentException("Incorrect region: " + lowlevelRegion);
		}
		return ((State) parentElement).getParentRegion();
	}
	
	public static List<Region> getParentRegionsRecursively(StateNode lowlevelState) {
		return getParentRegionsRecursively(lowlevelState, null);
	}
	
	public static List<Region> getParentRegionsRecursively(StateNode lowlevelState, State topLowlevelState) {
		List<Region> lowlevelParentRegions = new ArrayList<Region>();
		if (lowlevelState == topLowlevelState) {
			return lowlevelParentRegions;
		}
		Region lowlevelParentRegion = lowlevelState.getParentRegion();
		lowlevelParentRegions.add(lowlevelParentRegion);
		if (isTopRegion(lowlevelParentRegion)) {
			return lowlevelParentRegions;
		}
		State lowlevelParentState = getParentState(lowlevelState);
		lowlevelParentRegions.addAll(getParentRegionsRecursively(lowlevelParentState, topLowlevelState));
		return lowlevelParentRegions;
	}
	
	public static List<Region> getSubregionsRecursively(StateNode lowlevelStateNode) {
		List<Region> lowlevelSubregions = new ArrayList<Region>();
		if (lowlevelStateNode instanceof State) {
			State lowlevelState = (State) lowlevelStateNode;
			lowlevelSubregions.addAll(lowlevelState.getRegions());
			for (Region lowlevelSubregion : lowlevelState.getRegions()) {
				for (StateNode lowlevelSubstateNode : lowlevelSubregion.getStateNodes()) {
					if (lowlevelSubstateNode instanceof State) {
						lowlevelSubregions.addAll(getSubregionsRecursively(lowlevelSubstateNode));
					}
				}
			}
		}
		return lowlevelSubregions;
	}
	
	public static boolean isTopRegion(Region lowlevelRegion) {
		return lowlevelRegion.getParentElement() instanceof StatechartDefinition;
	}
	
	public static boolean isComposite(State state) {
		return !state.getRegions().isEmpty();
	}
	
	public static State getParentState(StateNode lowlevelState) {
		CompositeElement parentElement = lowlevelState.getParentRegion().getParentElement();
		if (!(parentElement instanceof State)) {
			throw new IllegalArgumentException("Incorrect state node: " + lowlevelState);
		}
		return (State) parentElement;
	}

	public static boolean isLeaf(Region lowlevelRegion) {
		return lowlevelRegion.getStateNodes().stream()
				.filter(it -> it instanceof State).allMatch(it -> ((State) it).getRegions().isEmpty());
	}
	
}
