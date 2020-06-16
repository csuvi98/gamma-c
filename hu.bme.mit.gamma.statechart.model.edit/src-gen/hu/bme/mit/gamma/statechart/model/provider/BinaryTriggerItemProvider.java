/**
 */
package hu.bme.mit.gamma.statechart.model.provider;


import hu.bme.mit.gamma.statechart.model.BinaryTrigger;
import hu.bme.mit.gamma.statechart.model.BinaryType;
import hu.bme.mit.gamma.statechart.model.StatechartModelFactory;
import hu.bme.mit.gamma.statechart.model.StatechartModelPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link hu.bme.mit.gamma.statechart.model.BinaryTrigger} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BinaryTriggerItemProvider extends ComplexTriggerItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryTriggerItemProvider(AdapterFactory adapterFactory) {
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

			addTypePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BinaryTrigger_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BinaryTrigger_type_feature", "_UI_BinaryTrigger_type"),
				 StatechartModelPackage.Literals.BINARY_TRIGGER__TYPE,
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
			childrenFeatures.add(StatechartModelPackage.Literals.BINARY_TRIGGER__LEFT_OPERAND);
			childrenFeatures.add(StatechartModelPackage.Literals.BINARY_TRIGGER__RIGHT_OPERAND);
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		BinaryType labelValue = ((BinaryTrigger)object).getType();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_BinaryTrigger_type") :
			getString("_UI_BinaryTrigger_type") + " " + label;
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

		switch (notification.getFeatureID(BinaryTrigger.class)) {
			case StatechartModelPackage.BINARY_TRIGGER__TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case StatechartModelPackage.BINARY_TRIGGER__LEFT_OPERAND:
			case StatechartModelPackage.BINARY_TRIGGER__RIGHT_OPERAND:
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
				(StatechartModelPackage.Literals.BINARY_TRIGGER__LEFT_OPERAND,
				 StatechartModelFactory.eINSTANCE.createAnyTrigger()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.BINARY_TRIGGER__LEFT_OPERAND,
				 StatechartModelFactory.eINSTANCE.createEventTrigger()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.BINARY_TRIGGER__LEFT_OPERAND,
				 StatechartModelFactory.eINSTANCE.createBinaryTrigger()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.BINARY_TRIGGER__LEFT_OPERAND,
				 StatechartModelFactory.eINSTANCE.createUnaryTrigger()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.BINARY_TRIGGER__LEFT_OPERAND,
				 StatechartModelFactory.eINSTANCE.createOpaqueTrigger()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.BINARY_TRIGGER__LEFT_OPERAND,
				 StatechartModelFactory.eINSTANCE.createOnCycleTrigger()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.BINARY_TRIGGER__RIGHT_OPERAND,
				 StatechartModelFactory.eINSTANCE.createAnyTrigger()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.BINARY_TRIGGER__RIGHT_OPERAND,
				 StatechartModelFactory.eINSTANCE.createEventTrigger()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.BINARY_TRIGGER__RIGHT_OPERAND,
				 StatechartModelFactory.eINSTANCE.createBinaryTrigger()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.BINARY_TRIGGER__RIGHT_OPERAND,
				 StatechartModelFactory.eINSTANCE.createUnaryTrigger()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.BINARY_TRIGGER__RIGHT_OPERAND,
				 StatechartModelFactory.eINSTANCE.createOpaqueTrigger()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.BINARY_TRIGGER__RIGHT_OPERAND,
				 StatechartModelFactory.eINSTANCE.createOnCycleTrigger()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == StatechartModelPackage.Literals.BINARY_TRIGGER__LEFT_OPERAND ||
			childFeature == StatechartModelPackage.Literals.BINARY_TRIGGER__RIGHT_OPERAND;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
