/**
 */
package hu.bme.mit.gamma.expression.model.provider;


import hu.bme.mit.gamma.expression.model.ExpressionModelFactory;
import hu.bme.mit.gamma.expression.model.ExpressionModelPackage;
import hu.bme.mit.gamma.expression.model.SubrangeTypeDefinition;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link hu.bme.mit.gamma.expression.model.SubrangeTypeDefinition} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SubrangeTypeDefinitionItemProvider extends NumericalTypeDefinitionItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubrangeTypeDefinitionItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
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
			childrenFeatures.add(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND);
			childrenFeatures.add(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND);
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
	 * This returns SubrangeTypeDefinition.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SubrangeTypeDefinition"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_SubrangeTypeDefinition_type");
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

		switch (notification.getFeatureID(SubrangeTypeDefinition.class)) {
			case ExpressionModelPackage.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND:
			case ExpressionModelPackage.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND:
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
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createLogicExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createOpaqueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createElseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createDefaultExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createIntegerLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createDecimalLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createRationalLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createTrueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createFalseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createArrayLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createIntegerRangeLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createRecordLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createEnumerationLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createIfThenElseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createNotExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createForallExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createExistsExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createImplyExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createXorExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createEqualityExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createInequalityExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createGreaterExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createGreaterEqualExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createLessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createLessEqualExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createAddExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createSubtractExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createMultiplyExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createDivideExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createDivExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createModExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createUnaryMinusExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createUnaryPlusExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createFunctionAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createArrayAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createRecordAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createSelectExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createLogicExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createOpaqueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createElseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createDefaultExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createIntegerLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createDecimalLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createRationalLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createTrueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createFalseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createArrayLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createIntegerRangeLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createRecordLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createEnumerationLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createIfThenElseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createNotExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createForallExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createExistsExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createImplyExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createXorExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createEqualityExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createInequalityExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createGreaterExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createGreaterEqualExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createLessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createLessEqualExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createAddExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createSubtractExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createMultiplyExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createDivideExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createDivExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createModExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createUnaryMinusExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createUnaryPlusExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createFunctionAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createArrayAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createRecordAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND,
				 ExpressionModelFactory.eINSTANCE.createSelectExpression()));
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
			childFeature == ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__LOWER_BOUND ||
			childFeature == ExpressionModelPackage.Literals.SUBRANGE_TYPE_DEFINITION__UPPER_BOUND;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
