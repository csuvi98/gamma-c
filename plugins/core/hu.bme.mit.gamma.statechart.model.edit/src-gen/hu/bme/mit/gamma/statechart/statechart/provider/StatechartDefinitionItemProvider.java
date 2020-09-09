/**
 */
package hu.bme.mit.gamma.statechart.statechart.provider;


import hu.bme.mit.gamma.expression.model.ExpressionModelFactory;

import hu.bme.mit.gamma.statechart.composite.provider.StatechartEditPlugin;
import hu.bme.mit.gamma.statechart.composite.provider.SynchronousComponentItemProvider;

import hu.bme.mit.gamma.statechart.contract.ContractModelFactory;

import hu.bme.mit.gamma.statechart.phase.PhaseModelFactory;

import hu.bme.mit.gamma.statechart.statechart.StatechartDefinition;
import hu.bme.mit.gamma.statechart.statechart.StatechartModelFactory;
import hu.bme.mit.gamma.statechart.statechart.StatechartModelPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link hu.bme.mit.gamma.statechart.statechart.StatechartDefinition} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class StatechartDefinitionItemProvider extends SynchronousComponentItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatechartDefinitionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addSchedulingOrderPropertyDescriptor(object);
			addOrthogonalRegionSchedulingOrderPropertyDescriptor(object);
			addTransitionPriorityPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Scheduling Order feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSchedulingOrderPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StatechartDefinition_schedulingOrder_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StatechartDefinition_schedulingOrder_feature", "_UI_StatechartDefinition_type"),
				 StatechartModelPackage.Literals.STATECHART_DEFINITION__SCHEDULING_ORDER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Orthogonal Region Scheduling Order feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOrthogonalRegionSchedulingOrderPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StatechartDefinition_orthogonalRegionSchedulingOrder_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StatechartDefinition_orthogonalRegionSchedulingOrder_feature", "_UI_StatechartDefinition_type"),
				 StatechartModelPackage.Literals.STATECHART_DEFINITION__ORTHOGONAL_REGION_SCHEDULING_ORDER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Transition Priority feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTransitionPriorityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StatechartDefinition_transitionPriority_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StatechartDefinition_transitionPriority_feature", "_UI_StatechartDefinition_type"),
				 StatechartModelPackage.Literals.STATECHART_DEFINITION__TRANSITION_PRIORITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(StatechartModelPackage.Literals.COMPOSITE_ELEMENT__REGIONS);
			childrenFeatures.add(StatechartModelPackage.Literals.STATECHART_DEFINITION__VARIABLE_DECLARATIONS);
			childrenFeatures.add(StatechartModelPackage.Literals.STATECHART_DEFINITION__TIMEOUT_DECLARATIONS);
			childrenFeatures.add(StatechartModelPackage.Literals.STATECHART_DEFINITION__TRANSITIONS);
			childrenFeatures.add(StatechartModelPackage.Literals.STATECHART_DEFINITION__ANNOTATION);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns StatechartDefinition.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/StatechartDefinition"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((StatechartDefinition)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_StatechartDefinition_type") :
			getString("_UI_StatechartDefinition_type") + " " + label;
	}


	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(StatechartDefinition.class)) {
			case StatechartModelPackage.STATECHART_DEFINITION__SCHEDULING_ORDER:
			case StatechartModelPackage.STATECHART_DEFINITION__ORTHOGONAL_REGION_SCHEDULING_ORDER:
			case StatechartModelPackage.STATECHART_DEFINITION__TRANSITION_PRIORITY:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case StatechartModelPackage.STATECHART_DEFINITION__REGIONS:
			case StatechartModelPackage.STATECHART_DEFINITION__VARIABLE_DECLARATIONS:
			case StatechartModelPackage.STATECHART_DEFINITION__TIMEOUT_DECLARATIONS:
			case StatechartModelPackage.STATECHART_DEFINITION__TRANSITIONS:
			case StatechartModelPackage.STATECHART_DEFINITION__ANNOTATION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.COMPOSITE_ELEMENT__REGIONS,
				 StatechartModelFactory.eINSTANCE.createRegion()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATECHART_DEFINITION__VARIABLE_DECLARATIONS,
				 ExpressionModelFactory.eINSTANCE.createVariableDeclaration()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATECHART_DEFINITION__TIMEOUT_DECLARATIONS,
				 StatechartModelFactory.eINSTANCE.createTimeoutDeclaration()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATECHART_DEFINITION__TRANSITIONS,
				 StatechartModelFactory.eINSTANCE.createTransition()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATECHART_DEFINITION__ANNOTATION,
				 ContractModelFactory.eINSTANCE.createAdaptiveContractAnnotation()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATECHART_DEFINITION__ANNOTATION,
				 PhaseModelFactory.eINSTANCE.createMissionPhaseAnnotation()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return StatechartEditPlugin.INSTANCE;
	}

}
