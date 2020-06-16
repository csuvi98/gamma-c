/**
 */
package hu.bme.mit.gamma.expression.model.provider;


import hu.bme.mit.gamma.expression.model.ArrayTypeDefinition;
import hu.bme.mit.gamma.expression.model.ExpressionModelFactory;
import hu.bme.mit.gamma.expression.model.ExpressionModelPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link hu.bme.mit.gamma.expression.model.ArrayTypeDefinition} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ArrayTypeDefinitionItemProvider extends EnumerableTypeDefinitionItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayTypeDefinitionItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__ELEMENT_TYPE);
			childrenFeatures.add(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE);
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
	 * This returns ArrayTypeDefinition.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ArrayTypeDefinition"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_ArrayTypeDefinition_type");
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

		switch (notification.getFeatureID(ArrayTypeDefinition.class)) {
			case ExpressionModelPackage.ARRAY_TYPE_DEFINITION__ELEMENT_TYPE:
			case ExpressionModelPackage.ARRAY_TYPE_DEFINITION__SIZE:
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
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__ELEMENT_TYPE,
				 ExpressionModelFactory.eINSTANCE.createType()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__ELEMENT_TYPE,
				 ExpressionModelFactory.eINSTANCE.createTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__ELEMENT_TYPE,
				 ExpressionModelFactory.eINSTANCE.createTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__ELEMENT_TYPE,
				 ExpressionModelFactory.eINSTANCE.createNumericalTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__ELEMENT_TYPE,
				 ExpressionModelFactory.eINSTANCE.createCompositeTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__ELEMENT_TYPE,
				 ExpressionModelFactory.eINSTANCE.createVoidTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__ELEMENT_TYPE,
				 ExpressionModelFactory.eINSTANCE.createBooleanTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__ELEMENT_TYPE,
				 ExpressionModelFactory.eINSTANCE.createIntegerTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__ELEMENT_TYPE,
				 ExpressionModelFactory.eINSTANCE.createRationalTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__ELEMENT_TYPE,
				 ExpressionModelFactory.eINSTANCE.createDecimalTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__ELEMENT_TYPE,
				 ExpressionModelFactory.eINSTANCE.createSubrangeTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__ELEMENT_TYPE,
				 ExpressionModelFactory.eINSTANCE.createEnumerationTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__ELEMENT_TYPE,
				 ExpressionModelFactory.eINSTANCE.createArrayTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__ELEMENT_TYPE,
				 ExpressionModelFactory.eINSTANCE.createIntegerRangeTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__ELEMENT_TYPE,
				 ExpressionModelFactory.eINSTANCE.createFunctionTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__ELEMENT_TYPE,
				 ExpressionModelFactory.eINSTANCE.createRecordTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createLogicExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createOpaqueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createElseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createDefaultExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createIntegerLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createDecimalLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createRationalLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createTrueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createFalseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createArrayLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createIntegerRangeLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createRecordLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createEnumerationLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createIfThenElseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createNotExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createForallExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createExistsExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createImplyExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createXorExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createEqualityExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createInequalityExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createGreaterExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createGreaterEqualExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createLessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createLessEqualExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createAddExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createSubtractExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createMultiplyExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createDivideExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createDivExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createModExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createUnaryMinusExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createUnaryPlusExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createFunctionAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createArrayAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createRecordAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.ARRAY_TYPE_DEFINITION__SIZE,
				 ExpressionModelFactory.eINSTANCE.createSelectExpression()));
	}

}
