/**
 */
package hu.bme.mit.gamma.expression.model.provider;


import hu.bme.mit.gamma.expression.model.ExpressionModelFactory;
import hu.bme.mit.gamma.expression.model.ExpressionModelPackage;
import hu.bme.mit.gamma.expression.model.FieldAssignment;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link hu.bme.mit.gamma.expression.model.FieldAssignment} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FieldAssignmentItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FieldAssignmentItemProvider(AdapterFactory adapterFactory) {
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

			addReferencePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Reference feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReferencePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FieldAssignment_reference_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FieldAssignment_reference_feature", "_UI_FieldAssignment_type"),
				 ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__REFERENCE,
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
			childrenFeatures.add(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE);
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
	 * This returns FieldAssignment.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/FieldAssignment"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((FieldAssignment)object).getReference();
		return label == null || label.length() == 0 ?
			getString("_UI_FieldAssignment_type") :
			getString("_UI_FieldAssignment_type") + " " + label;
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

		switch (notification.getFeatureID(FieldAssignment.class)) {
			case ExpressionModelPackage.FIELD_ASSIGNMENT__REFERENCE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ExpressionModelPackage.FIELD_ASSIGNMENT__VALUE:
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
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createLogicExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createOpaqueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createElseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createDefaultExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createIntegerLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createDecimalLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createRationalLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createTrueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createFalseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createArrayLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createIntegerRangeLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createRecordLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createEnumerationLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createIfThenElseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createNotExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createForallExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createExistsExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createImplyExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createXorExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createEqualityExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createInequalityExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createGreaterExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createGreaterEqualExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createLessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createLessEqualExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createAddExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createSubtractExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createMultiplyExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createDivideExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createDivExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createModExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createUnaryMinusExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createUnaryPlusExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createFunctionAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createArrayAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createRecordAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FIELD_ASSIGNMENT__VALUE,
				 ExpressionModelFactory.eINSTANCE.createSelectExpression()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ExpressionEditPlugin.INSTANCE;
	}

}
