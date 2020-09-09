/**
 */
package hu.bme.mit.gamma.statechart.composite.provider;


import hu.bme.mit.gamma.expression.model.ExpressionModelFactory;

import hu.bme.mit.gamma.expression.model.provider.NamedElementItemProvider;

import hu.bme.mit.gamma.statechart.composite.CompositeModelPackage;
import hu.bme.mit.gamma.statechart.composite.MessageQueue;

import hu.bme.mit.gamma.statechart.interface_.InterfaceModelFactory;

import hu.bme.mit.gamma.statechart.statechart.StatechartModelFactory;

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
 * This is the item provider adapter for a {@link hu.bme.mit.gamma.statechart.composite.MessageQueue} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MessageQueueItemProvider extends NamedElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageQueueItemProvider(AdapterFactory adapterFactory) {
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

			addPriorityPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Priority feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPriorityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PrioritizedElement_priority_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PrioritizedElement_priority_feature", "_UI_PrioritizedElement_type"),
				 CompositeModelPackage.Literals.PRIORITIZED_ELEMENT__PRIORITY,
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
			childrenFeatures.add(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY);
			childrenFeatures.add(CompositeModelPackage.Literals.MESSAGE_QUEUE__EVENT_REFERENCE);
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
	 * This returns MessageQueue.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/MessageQueue"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((MessageQueue)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_MessageQueue_type") :
			getString("_UI_MessageQueue_type") + " " + label;
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

		switch (notification.getFeatureID(MessageQueue.class)) {
			case CompositeModelPackage.MESSAGE_QUEUE__PRIORITY:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case CompositeModelPackage.MESSAGE_QUEUE__CAPACITY:
			case CompositeModelPackage.MESSAGE_QUEUE__EVENT_REFERENCE:
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
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 InterfaceModelFactory.eINSTANCE.createEventParameterReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 StatechartModelFactory.eINSTANCE.createStateReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createLogicExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createOpaqueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createElseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createDefaultExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createIntegerLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createDecimalLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createRationalLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createTrueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createFalseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createArrayLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createIntegerRangeLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createRecordLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createEnumerationLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createIfThenElseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createNotExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createForallExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createExistsExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createImplyExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createXorExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createEqualityExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createInequalityExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createGreaterExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createGreaterEqualExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createLessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createLessEqualExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createAddExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createSubtractExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createMultiplyExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createDivideExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createDivExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createModExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createUnaryMinusExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createUnaryPlusExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createFunctionAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createArrayAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createRecordAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__CAPACITY,
				 ExpressionModelFactory.eINSTANCE.createSelectExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__EVENT_REFERENCE,
				 StatechartModelFactory.eINSTANCE.createAnyPortEventReference()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__EVENT_REFERENCE,
				 StatechartModelFactory.eINSTANCE.createPortEventReference()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__EVENT_REFERENCE,
				 StatechartModelFactory.eINSTANCE.createClockTickReference()));

		newChildDescriptors.add
			(createChildParameter
				(CompositeModelPackage.Literals.MESSAGE_QUEUE__EVENT_REFERENCE,
				 StatechartModelFactory.eINSTANCE.createTimeoutEventReference()));
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
