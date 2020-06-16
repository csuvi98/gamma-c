package hu.bme.mit.gamma.statechart.model.derivedfeatures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import hu.bme.mit.gamma.expression.model.ArgumentedElement;
import hu.bme.mit.gamma.expression.model.ParameterDeclaration;
import hu.bme.mit.gamma.expression.model.derivedfeatures.ExpressionModelDerivedFeatures;
import hu.bme.mit.gamma.statechart.model.AnyPortEventReference;
import hu.bme.mit.gamma.statechart.model.ClockTickReference;
import hu.bme.mit.gamma.statechart.model.CompositeElement;
import hu.bme.mit.gamma.statechart.model.DeepHistoryState;
import hu.bme.mit.gamma.statechart.model.EntryState;
import hu.bme.mit.gamma.statechart.model.EventReference;
import hu.bme.mit.gamma.statechart.model.EventSource;
import hu.bme.mit.gamma.statechart.model.InitialState;
import hu.bme.mit.gamma.statechart.model.InterfaceRealization;
import hu.bme.mit.gamma.statechart.model.Package;
import hu.bme.mit.gamma.statechart.model.Port;
import hu.bme.mit.gamma.statechart.model.PortEventReference;
import hu.bme.mit.gamma.statechart.model.RaiseEventAction;
import hu.bme.mit.gamma.statechart.model.RealizationMode;
import hu.bme.mit.gamma.statechart.model.Region;
import hu.bme.mit.gamma.statechart.model.SetTimeoutAction;
import hu.bme.mit.gamma.statechart.model.ShallowHistoryState;
import hu.bme.mit.gamma.statechart.model.State;
import hu.bme.mit.gamma.statechart.model.StateAnnotation;
import hu.bme.mit.gamma.statechart.model.StateNode;
import hu.bme.mit.gamma.statechart.model.StatechartDefinition;
import hu.bme.mit.gamma.statechart.model.TimeSpecification;
import hu.bme.mit.gamma.statechart.model.TimeoutDeclaration;
import hu.bme.mit.gamma.statechart.model.TimeoutEventReference;
import hu.bme.mit.gamma.statechart.model.Transition;
import hu.bme.mit.gamma.statechart.model.composite.AbstractSynchronousCompositeComponent;
import hu.bme.mit.gamma.statechart.model.composite.AsynchronousAdapter;
import hu.bme.mit.gamma.statechart.model.composite.AsynchronousComponent;
import hu.bme.mit.gamma.statechart.model.composite.AsynchronousComponentInstance;
import hu.bme.mit.gamma.statechart.model.composite.AsynchronousCompositeComponent;
import hu.bme.mit.gamma.statechart.model.composite.CascadeCompositeComponent;
import hu.bme.mit.gamma.statechart.model.composite.Component;
import hu.bme.mit.gamma.statechart.model.composite.ComponentInstance;
import hu.bme.mit.gamma.statechart.model.composite.CompositeComponent;
import hu.bme.mit.gamma.statechart.model.composite.PortBinding;
import hu.bme.mit.gamma.statechart.model.composite.SynchronousComponent;
import hu.bme.mit.gamma.statechart.model.composite.SynchronousComponentInstance;
import hu.bme.mit.gamma.statechart.model.interface_.Event;
import hu.bme.mit.gamma.statechart.model.interface_.EventDeclaration;
import hu.bme.mit.gamma.statechart.model.interface_.EventDirection;
import hu.bme.mit.gamma.statechart.model.interface_.Interface;

public class StatechartModelDerivedFeatures extends ExpressionModelDerivedFeatures {
	
	public static List<ParameterDeclaration> getParameterDeclarations(ArgumentedElement element) {
		if (element instanceof RaiseEventAction) {
			RaiseEventAction raiseEventAction = (RaiseEventAction) element;
			Event event = raiseEventAction.getEvent();
			return event.getParameterDeclarations();
		}
		if (element instanceof ComponentInstance) {
			ComponentInstance instance = (ComponentInstance) element;
			return getDerivedType(instance).getParameterDeclarations();
		}
		throw new IllegalArgumentException("Not supported element: " + element);
	}

	public static boolean isBroadcast(InterfaceRealization interfaceRealization) {
		return interfaceRealization.getRealizationMode() == RealizationMode.PROVIDED &&
				interfaceRealization.getInterface().getEvents().stream().allMatch(it -> it.getDirection() == EventDirection.OUT);
	}
	
	public static boolean isBroadcast(Port port) {
		return isBroadcast(port.getInterfaceRealization());
	}
	
	public static EventDirection getOpposite(EventDirection eventDirection) {
		switch (eventDirection) {
			case IN:
				return EventDirection.OUT;
			case OUT:
				return EventDirection.IN;
			default:
				throw new IllegalArgumentException("Not known event direction: " + eventDirection);
		}
	}
	
	public static Set<Component> getAllComponents(Package parentPackage) {
		Set<Component> types = new HashSet<Component>();
		for (Package importedPackage : parentPackage.getImports()) {
			for (Component importedComponent : importedPackage.getComponents()) {
				types.add(importedComponent);
			}
		}
		for (Component siblingComponent : parentPackage.getComponents()) {
			types.add(siblingComponent);
		}
		return types;
	}
	
	public static Set<SynchronousComponent> getAllSynchronousComponents(Package parentPackage) {
		Set<SynchronousComponent> types = new HashSet<SynchronousComponent>();
		for (Component component : getAllComponents(parentPackage)) {
			if (component instanceof SynchronousComponent) {
				types.add((SynchronousComponent) component);
			}
		}
		return types;
	}
	
	public static Set<AsynchronousComponent> getAllAsynchronousComponents(Package parentPackage) {
		Set<AsynchronousComponent> types = new HashSet<AsynchronousComponent>();
		for (Component component : getAllComponents(parentPackage)) {
			if (component instanceof AsynchronousComponent) {
				types.add((AsynchronousComponent) component);
			}
		}
		return types;
	}
	
	public static Set<StatechartDefinition> getAllStatechartComponents(Package parentPackage) {
		Set<StatechartDefinition> types = new HashSet<StatechartDefinition>();
		for (Component component : getAllSynchronousComponents(parentPackage)) {
			if (component instanceof StatechartDefinition) {
				types.add((StatechartDefinition) component);
			}
		}
		return types;
	}
	
	public static boolean areInterfacesEqual(Component lhs, Component rhs) {
		EList<Port> lhsPorts = lhs.getPorts();
		EList<Port> rhsPorts = rhs.getPorts();
		if (lhsPorts.size() != rhsPorts.size()) {
			return false;
		}
		for (Port lhsPort : lhsPorts) {
			if (!rhsPorts.stream().anyMatch(it -> ecoreUtil.helperEquals(lhsPort, it))) {
				return false;
			}
		}
		return true;
	}
	
	public static List<SynchronousComponentInstance> getAllSimpleInstances(Collection<? extends ComponentInstance> instances) {
		List<SynchronousComponentInstance> simpleInstances = new ArrayList<SynchronousComponentInstance>();
		for (ComponentInstance instance : instances) {
			simpleInstances.addAll(getAllSimpleInstances(instance));
		}
		return simpleInstances;
	}
	
	public static List<SynchronousComponentInstance> getAllSimpleInstances(ComponentInstance instance) {
		if (instance instanceof SynchronousComponentInstance) {
			SynchronousComponentInstance synchronousInstance = (SynchronousComponentInstance) instance;
			if (synchronousInstance.getType() instanceof StatechartDefinition) {
				// Atomic component
				return Collections.singletonList(synchronousInstance);
			}
			else {
				// Composite component
				return getAllSimpleInstances(synchronousInstance.getType());
			}
		}
		if (instance instanceof AsynchronousComponentInstance) {
			AsynchronousComponentInstance asynchronousInstance = (AsynchronousComponentInstance) instance;
			return getAllSimpleInstances(asynchronousInstance.getType());
		}
		throw new IllegalArgumentException("Not known instance type: " + instance);
	}
	
	public static List<SynchronousComponentInstance> getAllSimpleInstances(Component component) {
		List<SynchronousComponentInstance> simpleInstances = new ArrayList<SynchronousComponentInstance>();
		if (component instanceof AsynchronousCompositeComponent) {
			AsynchronousCompositeComponent asynchronousCompositeComponent = (AsynchronousCompositeComponent) component;
			for (AsynchronousComponentInstance instance : asynchronousCompositeComponent.getComponents()) {
				simpleInstances.addAll(getAllSimpleInstances(instance));
			}
		}
		else if (component instanceof AsynchronousAdapter) {
			AsynchronousAdapter asynchronousAdapter = (AsynchronousAdapter) component;
			simpleInstances.addAll(getAllSimpleInstances(asynchronousAdapter.getWrappedComponent()));
		}
		else if (component instanceof AbstractSynchronousCompositeComponent) {
			AbstractSynchronousCompositeComponent synchronousCompositeComponent = (AbstractSynchronousCompositeComponent) component;
			for (SynchronousComponentInstance instance : synchronousCompositeComponent.getComponents()) {
				simpleInstances.addAll(getAllSimpleInstances(instance));
			}
		}
		return simpleInstances;
	}
	
	public static List<AsynchronousComponentInstance> getAllAsynchronousSimpleInstances(Component component) {
		List<ComponentInstance> allInstances = getAllInstances(component);
		List<AsynchronousComponentInstance> asynchronousInstances = new ArrayList<AsynchronousComponentInstance>();
		for (ComponentInstance allInstance : allInstances) {
			if (getDerivedType(allInstance) instanceof AsynchronousAdapter) {
				asynchronousInstances.add((AsynchronousComponentInstance) allInstance);
			}
		}
		return asynchronousInstances;
	}
	
	public static List<ComponentInstance> getAllInstances(Component component) {
		List<ComponentInstance> instances = new ArrayList<ComponentInstance>();
		if (component instanceof AsynchronousCompositeComponent) {
			AsynchronousCompositeComponent asynchronousCompositeComponent = (AsynchronousCompositeComponent) component;
			for (AsynchronousComponentInstance instance : asynchronousCompositeComponent.getComponents()) {
				instances.add(instance);
				AsynchronousComponent type = instance.getType();
				instances.addAll(getAllInstances(type));
			}
		}
		else if (component instanceof AsynchronousAdapter) {
			AsynchronousAdapter asynchronousAdapter = (AsynchronousAdapter) component;
			SynchronousComponentInstance wrappedComponent = asynchronousAdapter.getWrappedComponent();
			instances.add(wrappedComponent);
			instances.addAll(getAllInstances(wrappedComponent.getType()));
		}
		else if (component instanceof AbstractSynchronousCompositeComponent) {
			AbstractSynchronousCompositeComponent synchronousCompositeComponent = (AbstractSynchronousCompositeComponent) component;
			for (SynchronousComponentInstance instance : synchronousCompositeComponent.getComponents()) {
				instances.add(instance);
				SynchronousComponent type = instance.getType();
				instances.addAll(getAllInstances(type));
			}
		}
		return instances;
	}
	
	public static Collection<StatechartDefinition> getAllContainedStatecharts(SynchronousComponent component) {
		List<StatechartDefinition> statecharts = new ArrayList<StatechartDefinition>();
		for (SynchronousComponentInstance instance : getAllSimpleInstances(component)) {
			statecharts.add((StatechartDefinition) instance.getType());
		}
		return statecharts;
	}
	
	public static Collection<EventDeclaration> getAllEventDeclarations(Interface _interface) {
		Set<EventDeclaration> eventDeclarations = new HashSet<EventDeclaration>(_interface.getEvents());
		for (Interface parentInterface : _interface.getParents()) {
			eventDeclarations.addAll(getAllEventDeclarations(parentInterface));
		}
		return eventDeclarations;
	}
	
	public static Collection<Event> getAllEvents(Interface _interface) {
		return getAllEventDeclarations(_interface).stream().map(it -> it.getEvent()).collect(Collectors.toSet());
	}
	
	public static Collection<Event> getInputEvents(Port port) {
		List<Event> events = new ArrayList<Event>();
		InterfaceRealization interfaceRealization = port.getInterfaceRealization();
		Interface _interface = interfaceRealization.getInterface();
		final Collection<EventDeclaration> allEventDeclarations = getAllEventDeclarations(_interface);
		if (interfaceRealization.getRealizationMode() == RealizationMode.PROVIDED) {
			events.addAll(allEventDeclarations.stream()
					.filter(it -> it.getDirection() != EventDirection.OUT)
					.map(it -> it.getEvent())
					.collect(Collectors.toList()));
		}
		if (interfaceRealization.getRealizationMode() == RealizationMode.REQUIRED) {
			events.addAll(allEventDeclarations.stream()
					.filter(it -> it.getDirection() != EventDirection.IN)
					.map(it -> it.getEvent())
					.collect(Collectors.toList()));
		}
		return events;
	}
	
	public static Collection<Event> getOutputEvents(Port port) {
		List<Event> events = new ArrayList<Event>();
		InterfaceRealization interfaceRealization = port.getInterfaceRealization();
		Interface _interface = interfaceRealization.getInterface();
		final Collection<EventDeclaration> allEventDeclarations = getAllEventDeclarations(_interface);
		if (interfaceRealization.getRealizationMode() == RealizationMode.PROVIDED) {
			events.addAll(allEventDeclarations.stream()
					.filter(it -> it.getDirection() != EventDirection.IN)
					.map(it -> it.getEvent())
					.collect(Collectors.toList()));
		}
		if (interfaceRealization.getRealizationMode() == RealizationMode.REQUIRED) {
			events.addAll(allEventDeclarations.stream()
					.filter(it -> it.getDirection() != EventDirection.OUT)
					.map(it -> it.getEvent())
					.collect(Collectors.toList()));
		}
		return events;
	}
	
	public static Collection<Port> getAllPorts(AsynchronousAdapter wrapper) {
		Collection<Port> allPorts = new HashSet<Port>(wrapper.getPorts());
		allPorts.addAll(wrapper.getWrappedComponent().getType().getPorts());
		return allPorts;
	}
	
	public static Collection<Port> getAllPorts(Component component) {
		if (component instanceof AsynchronousAdapter) {
			return getAllPorts((AsynchronousAdapter)component);
		}		
		return component.getPorts();
	}
	
	public static Collection<PortBinding> getPortBindings(Port port) {
		EObject component = port.eContainer();
		List<PortBinding> portBindings = new ArrayList<PortBinding>();
		if (component instanceof CompositeComponent) {
			CompositeComponent compositeComponent = (CompositeComponent) component;
			for (PortBinding portBinding : compositeComponent.getPortBindings()) {
				if (portBinding.getCompositeSystemPort() == port) {
					portBindings.add(portBinding);
				}
			}
		}		
		return portBindings;
	}
	
	public static Collection<Port> getAllConnectedSimplePorts(Component component) {
		Set<Port> simplePorts = new HashSet<Port>();
		for (Port port : getAllPorts(component)) {
			simplePorts.addAll(getAllConnectedSimplePorts(port));
		}
		return simplePorts;
	}
	
	public static Collection<Port> getAllConnectedSimplePorts(Port port) {
		Set<Port> simplePorts = new HashSet<Port>();
		Component component = getContainingComponent(port);
		if (component instanceof StatechartDefinition) {
			simplePorts.add(port);
		}
		if (component instanceof CompositeComponent) {
			CompositeComponent composite = (CompositeComponent) component;
			for (PortBinding portBinding : composite.getPortBindings()) {
				// Makes sense only if the containment hierarchy is a tree structure
				simplePorts.addAll(getAllConnectedSimplePorts(portBinding.getInstancePortReference().getPort()));
			}
		}
		return simplePorts;
	}
	
	public static Port getConnectedTopComponentPort(Port port) {
		Package _package = getContainingPackage(port);
		TreeIterator<Object> contents = EcoreUtil.getAllContents(_package, true);
		while (contents.hasNext()) {
			Object next = contents.next();
			if (next instanceof PortBinding) {
				PortBinding portBinding = (PortBinding) next;
				if (portBinding.getInstancePortReference().getPort() == port) {
					Port systemPort = portBinding.getCompositeSystemPort();
					return getConnectedTopComponentPort(systemPort);
				}
			}
		}
		return port;
	}
	
	public static EventSource getEventSource(EventReference eventReference) {
		if (eventReference instanceof PortEventReference) {
			return ((PortEventReference) eventReference).getPort();
		}
		if (eventReference instanceof AnyPortEventReference) {
			return ((AnyPortEventReference) eventReference).getPort();
		}
		if (eventReference instanceof ClockTickReference) {
			return ((ClockTickReference) eventReference).getClock();
		}
		if (eventReference instanceof TimeoutEventReference) {
			return ((TimeoutEventReference) eventReference).getTimeout();
		}
		throw new IllegalArgumentException("Not known type: " + eventReference);
	}
	
	public static Component getDerivedType(ComponentInstance instance) {
		if (instance instanceof SynchronousComponentInstance) {
			return ((SynchronousComponentInstance) instance).getType();
		}
		if (instance instanceof AsynchronousComponentInstance) {
			return ((AsynchronousComponentInstance) instance).getType();
		}
		throw new IllegalArgumentException("Not known type: " + instance);
	}
	
	public static EList<? extends ComponentInstance> getDerivedComponents(CompositeComponent composite) {
		if (composite instanceof AbstractSynchronousCompositeComponent) {
			return ((AbstractSynchronousCompositeComponent) composite).getComponents();
		}
		if (composite instanceof AsynchronousCompositeComponent) {
			return ((AsynchronousCompositeComponent) composite).getComponents();
		}
		throw new IllegalArgumentException("Not known type: " + composite);
	}
	
    public static boolean isCascade(ComponentInstance instance) {
    	if (getDerivedType(instance) instanceof StatechartDefinition) {
    		// Statecharts are cascade if contained by cascade composite components
    		return instance.eContainer() instanceof CascadeCompositeComponent;
   		}
   		return getDerivedType(instance) instanceof CascadeCompositeComponent;
    }
	
	public static int getLevel(StateNode stateNode) {
		if (isTopRegion(getParentRegion(stateNode))) {
			return 1;
		}
		else {
			return getLevel(getParentState(stateNode)) + 1;
		}
	}
	
	public static List<Transition> getOutgoingTransitions(StateNode node) {
		StatechartDefinition statechart = getContainingStatechart(node);
		return statechart.getTransitions().stream().filter(it -> it.getSourceState() == node).collect(Collectors.toList());
	}
	
	public static List<Transition> getIncomingTransitions(StateNode node) {
		StatechartDefinition statechart = getContainingStatechart(node);
		return statechart.getTransitions().stream().filter(it -> it.getTargetState() == node).collect(Collectors.toList());
	}
	
	public static Collection<StateNode> getAllStateNodes(CompositeElement compositeElement) {
		Set<StateNode> stateNodes = new HashSet<StateNode>();
		for (Region region : compositeElement.getRegions()) {
			for (StateNode stateNode : region.getStateNodes()) {
				stateNodes.add(stateNode);
				if (stateNode instanceof State) {
					State state = (State) stateNode;
					stateNodes.addAll(getAllStateNodes(state));
				}
			}
		}
		return stateNodes;
	}
	
	public static Collection<State> getAllStates(CompositeElement compositeElement) {
		Set<State> states = new HashSet<State>();
		for (StateNode stateNode : getAllStateNodes(compositeElement)) {
			if (stateNode instanceof State) {
				State state = (State) stateNode;
				states.add(state);
			}
		}
		return states;
	}
	
	public static Collection<State> getStates(Region region) {
		List<State> states = new ArrayList<State>();
		for (StateNode stateNode : region.getStateNodes()) {
			if (stateNode instanceof State) {
				State state = (State) stateNode;
				states.add(state);
			}
		}
		return states;
	}
	
	public static Collection<StateNode> getAllStateNodes(Region region) {
		List<StateNode> states = new ArrayList<StateNode>();
		TreeIterator<Object> allContents = EcoreUtil.getAllContents(region, true);
		while (allContents.hasNext()) {
			Object next = allContents.next();
			if (next instanceof StateNode) {
				states.add((StateNode) next);
			}
		}
		return states;
	}
	
	public static Collection<Region> getAllRegions(CompositeElement compositeElement) {
		Set<Region> regions = new HashSet<Region>(compositeElement.getRegions());
		for (State state : getAllStates(compositeElement)) {
			regions.addAll(getAllRegions(state));
		}
		return regions;
	}
	
	public static Collection<Region> getAllRegions(Region region) {
		Set<Region> regions = new HashSet<Region>();
		regions.add(region);
		TreeIterator<Object> allContents = EcoreUtil.getAllContents(region, true);
		while (allContents.hasNext()) {
			Object next = allContents.next();
			if (next instanceof Region) {
				regions.add((Region) next);
			}
		}
		return regions;
	}
	
	public static State getParentState(StateAnnotation annotation) {
		return (State) annotation.eContainer();
	}
	
	public static Region getParentRegion(StateNode node) {
		return (Region) node.eContainer();
	}
	
	public static boolean isTopRegion(Region region) {
		return region.eContainer() instanceof StatechartDefinition;
	}
	
	public static boolean isSubregion(Region region) {
		return !isTopRegion(region);
	}
	
	public static State getParentState(Region region) {
		if (isTopRegion(region)) {
			throw new IllegalArgumentException("This region has no parent state: " + region);
		}
		return (State) region.eContainer();
	}
	
	public static State getParentState(StateNode node) {
		Region parentRegion = getParentRegion(node);
		return getParentState(parentRegion);
	}
	
	public static Region getParentRegion(Region region) {
		if (isTopRegion(region)) {
			return null;
		}
		return getParentRegion((State) region.eContainer());
	}
	
	public static List<Region> getParentRegions(Region region) {
		if (isTopRegion(region)) {
			return new ArrayList<Region>();
		}
		Region parentRegion = getParentRegion(region);
		List<Region> parentRegions = new ArrayList<Region>();
		parentRegions.add(parentRegion);
		parentRegions.addAll(getParentRegions(parentRegion));
		return parentRegions;
	}
	
	public static List<Region> getSubregions(Region region) {
		List<Region> subregions = new ArrayList<Region>();
		for (List<Region> stateSubregions : getStates(region).stream().map(it -> it.getRegions())
				.collect(Collectors.toList())) {
			for (Region subregion : stateSubregions) {
				subregions.add(subregion);
				subregions.addAll(getSubregions(subregion));
			}
		}
		return subregions;
	}
	
	public static List<hu.bme.mit.gamma.statechart.model.State> getCommonAncestors(StateNode lhs, StateNode rhs) {
		List<hu.bme.mit.gamma.statechart.model.State> ancestors = getAncestors(lhs);
		ancestors.retainAll(getAncestors(rhs));
		return ancestors;
	}
	
	public static List<hu.bme.mit.gamma.statechart.model.State> getAncestors(StateNode node) {
		if (node.eContainer().eContainer() instanceof hu.bme.mit.gamma.statechart.model.State) {
			hu.bme.mit.gamma.statechart.model.State parentState = (hu.bme.mit.gamma.statechart.model.State) node.eContainer().eContainer();
			List<hu.bme.mit.gamma.statechart.model.State> ancestors = getAncestors(parentState);
			ancestors.add(parentState);
			return ancestors;
		}
		return new ArrayList<hu.bme.mit.gamma.statechart.model.State>();
	}
	
	public static List<Region> getRegionAncestors(StateNode node) {
		if (node.eContainer().eContainer() instanceof hu.bme.mit.gamma.statechart.model.State) {
			hu.bme.mit.gamma.statechart.model.State parentState = (hu.bme.mit.gamma.statechart.model.State) node.eContainer().eContainer();
			List<Region> ancestors = getRegionAncestors(parentState);
			ancestors.add((Region) node.eContainer());
			return ancestors;
		}
		Region parentRegion = (Region) node.eContainer();
		List<Region> regionList = new ArrayList<Region>();
		regionList.add(parentRegion);
		return regionList;
	}
	
	public static List<Region> getCommonRegionAncestors(StateNode lhs, StateNode rhs) {
		List<Region> ancestors = getRegionAncestors(lhs);
		ancestors.retainAll(getRegionAncestors(rhs));
		return ancestors;
	}
	
	/**
	 * Returns whether the given region has deep history in one of its ancestor regions.
	 */
	private static boolean hasDeepHistoryAbove(Region region) {
		if (isTopRegion(region)) {
			return false;
		}
		Region parentRegion = getParentRegion(region);
		return parentRegion.getStateNodes().stream().anyMatch(it -> it instanceof DeepHistoryState) ||
			hasDeepHistoryAbove(parentRegion);
	}
	
	/**
	 * Returns whether the region has history or not.
	 */
	public static boolean hasHistory(Region region) {
		return hasDeepHistoryAbove(region) || 
			region.getStateNodes().stream().anyMatch(it -> it instanceof ShallowHistoryState) || 
			region.getStateNodes().stream().anyMatch(it -> it instanceof DeepHistoryState);
	}	
	
	public static String getFullContainmentHierarchy(State state) {
		if (state == null) {
			return "";
		}
		Region parentRegion = getParentRegion(state);
		State parentState = null;
		if (parentRegion.eContainer() instanceof State) {
			parentState = getParentState(parentRegion);
		}
		String parentRegionName = parentRegion.getName();
		if (parentState == null) {
			// Yakindu bug? First character is set to lowercase in the case of top regions
			parentRegionName = parentRegionName.substring(0, 1).toLowerCase() + parentRegionName.substring(1); // toFirstLowerCase
			return parentRegionName + "_" + state.getName();
		}
		return getFullContainmentHierarchy(parentState) + "_" + parentRegionName + "_" + state.getName();
	}
	
	public static String getFullRegionPathName(Region lowestRegion) {
		if (!(lowestRegion.eContainer() instanceof State)) {
			return lowestRegion.getName();
		}
		String fullParentRegionPathName = getFullRegionPathName(getParentRegion(lowestRegion));
		return fullParentRegionPathName + "." + lowestRegion.getName(); // Only regions are in path - states could be added too
	}
	
	public static StatechartDefinition getContainingStatechart(EObject object) {
		if (object.eContainer() instanceof StatechartDefinition) {
			return (StatechartDefinition) object.eContainer();
		}
		return getContainingStatechart(object.eContainer());
	}
	
	public static Component getContainingComponent(EObject object) {
		if (object.eContainer() == null) {
			throw new IllegalArgumentException("Not contained by a component: " + object);
		}
		if (object instanceof Component) {
			return (Component) object;
		}
		return getContainingComponent(object.eContainer());
	}
	
	public static Package getContainingPackage(EObject object) {
		if (object instanceof Package) {
			return (Package) object;
		}
//		if (object.eContainer() == null) {
//			throw new IllegalArgumentException("Not contained by a package: " + object);
//		}
		return getContainingPackage(object.eContainer());
	}
	
	public static Event getContainingEvent(ParameterDeclaration parameter) {
		return (Event) parameter.eContainer();
	}
	
	public static EventDeclaration getContainingEventDeclaration(Event event) {
		return (EventDeclaration) event.eContainer();
	}
	
	public static boolean isSameRegion(Transition transition) {
		return getParentRegion(transition.getSourceState()) == getParentRegion(transition.getTargetState());
	}
	
	public static boolean isToHigher(Transition transition) {
		return isToHigher(transition.getSourceState(), transition.getTargetState());
	}
	
	public static boolean isToHigher(StateNode source, StateNode target) {
		Region sourceParentRegion = getParentRegion(source);
		if (isTopRegion(sourceParentRegion)) {
			return false;
		}
		State sourceParentState = getParentState(source);
		if (getParentRegion(sourceParentState) == getParentRegion(target)) {
			return true;
		}
		return isToHigher(sourceParentState, target);
	}
	
	public static boolean isToLower(Transition transition) {
		return isToLower(transition.getSourceState(), transition.getTargetState());
	}
	
	public static boolean isToLower(StateNode source, StateNode target) {
		Region targetParentRegion = getParentRegion(target);
		if (isTopRegion(targetParentRegion)) {
			return false;
		}
		State targetParentState = getParentState(target);
		if (getParentRegion(source) == getParentRegion(targetParentState)) {
			return true;
		}
		return isToLower(source, targetParentState);
	}
	
	public static boolean isToHigherAndLower(Transition transition) {
		return isToHigherAndLower(transition.getSourceState(), transition.getTargetState());
	}
	
	public static boolean isToHigherAndLower(StateNode source, StateNode target) {
		List<Region> sourceAncestors = getRegionAncestors(source);
		List<Region> targetAncestors = getRegionAncestors(target);
		List<Region> commonAncestors = new ArrayList<Region>(sourceAncestors);
		commonAncestors.retainAll(targetAncestors);
		if (commonAncestors.isEmpty()) {
			// Top region orthogonal invalid transitions
			return false;
		}
		sourceAncestors.removeAll(commonAncestors);
		if (sourceAncestors.isEmpty()) {
			// To lower level
			return false;
		}
		targetAncestors.removeAll(commonAncestors);
		if (targetAncestors.isEmpty()) {
			// To higher level
			return false;
		}
		return true;
	}
	
	public static StateNode getSourceAncestor(Transition transition) {
		return getSourceAncestor(transition.getSourceState(), transition.getTargetState());
	}
	
	public static StateNode getSourceAncestor(StateNode source, StateNode target) {
		if (isToLower(source, target)) {
			return source;
		}
		Region sourceParentRegion = getParentRegion(source);
		if (isTopRegion(sourceParentRegion)) {
			throw new IllegalArgumentException("No source ancestor!");
		}
		State sourceParentState = getParentState(source);
		return getSourceAncestor(sourceParentState, target);
	}
	
	public static StateNode getTargetAncestor(Transition transition) {
		return getTargetAncestor(transition.getSourceState(), transition.getTargetState());
	}
	
	public static StateNode getTargetAncestor(StateNode source, StateNode target) {
		if (isToHigher(source, target)) {
			return source;
		}
		Region targetParentRegion = getParentRegion(target);
		if (isTopRegion(targetParentRegion)) {
			throw new IllegalArgumentException("No target ancestor!");
		}
		State targetParentState = getParentState(target);
		return getTargetAncestor(source, targetParentState);
	}
	
	public static boolean isComposite(StateNode node) {
		if (node instanceof State) {
			return isComposite((State) node);
		}
		return false;
	}
	
	public static boolean isComposite(State state) {
		return !state.getRegions().isEmpty();
	}
	
	public static EntryState getEntryState(Region region) {
		Collection<StateNode> entryStates = region.getStateNodes().stream()
				.filter(it -> it instanceof EntryState)
				.collect(Collectors.toList());
		Optional<StateNode> entryState = entryStates.stream().filter(it -> it instanceof InitialState).findFirst();
		if (entryState.isPresent()) {
			return (EntryState) entryState.get();
		}
		entryState = entryStates.stream().filter(it -> it instanceof DeepHistoryState).findFirst();
		if (entryState.isPresent()) {
			return (EntryState) entryState.get();
		}
		entryState = entryStates.stream().filter(it -> it instanceof ShallowHistoryState).findFirst();
		if (entryState.isPresent()) {
			return (EntryState) entryState.get();
		}
		throw new IllegalArgumentException("Not known initial states in the region. " + region.getName() + ": " + entryStates);
	}
	
	public static Set<State> getReachableStates(StateNode node) {
		Set<State> reachableStates = new HashSet<State>();
		for (Transition outgoingTransition : getOutgoingTransitions(node)) {
			StateNode target = outgoingTransition.getTargetState();
			if (target instanceof State) {
				reachableStates.add((State) target);
			}
			else {
				reachableStates.addAll(getReachableStates(target));
			}
		}
		return reachableStates;
	}
	
	public static TimeSpecification getTimeoutValue(TimeoutDeclaration timeout) {
		StatechartDefinition statechart = getContainingStatechart(timeout);
		TimeSpecification time = null;
		TreeIterator<Object> contents = EcoreUtil.getAllContents(statechart, true);
		while (contents.hasNext()) {
			Object it = contents.next();
			if (it instanceof SetTimeoutAction) {
				SetTimeoutAction action = (SetTimeoutAction) it;
				if (action.getTimeoutDeclaration() == timeout) {
					if (time == null) {
						time = action.getTime();
					}
					else {
						throw new IllegalStateException("This timeout is assigned a value more than once: " + timeout);
					}
				}
			}
		}
		return time;
	}
	
	public static Collection<ComponentInstance> getReferencingComponentInstances(Component component) {
		Package _package = getContainingPackage(component);
		Collection<ComponentInstance> componentInstances = new HashSet<ComponentInstance>();
		for (Component siblingComponent : _package.getComponents()) {
			if (siblingComponent instanceof CompositeComponent) {
				CompositeComponent compositeComponent = (CompositeComponent) siblingComponent;
				for (ComponentInstance componentInstance : getDerivedComponents(compositeComponent)) {
					if (getDerivedType(componentInstance) == component) {
						componentInstances.add(componentInstance);
					}
				}
			}
		}
		return componentInstances;
	}
	
	public static ComponentInstance getReferencingComponentInstance(Component component) {
		Collection<ComponentInstance> instances = getReferencingComponentInstances(component);
		assert instances.size() == 1;
		return instances.stream().findFirst().get();
	}
	
	public static List<SynchronousComponentInstance> getScheduledInstances(AbstractSynchronousCompositeComponent component) {
		if (component instanceof CascadeCompositeComponent) {
			CascadeCompositeComponent cascade = (CascadeCompositeComponent) component;
			if (!cascade.getExecutionList().isEmpty()) {
				return cascade.getExecutionList();
			}
		}
		return component.getComponents();
	}
	
}