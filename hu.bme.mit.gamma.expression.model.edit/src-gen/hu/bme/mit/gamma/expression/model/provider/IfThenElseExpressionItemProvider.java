/**
 */
package hu.bme.mit.gamma.expression.model.provider;


import hu.bme.mit.gamma.expression.model.ExpressionModelFactory;
import hu.bme.mit.gamma.expression.model.ExpressionModelPackage;
import hu.bme.mit.gamma.expression.model.IfThenElseExpression;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link hu.bme.mit.gamma.expression.model.IfThenElseExpression} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class IfThenElseExpressionItemProvider extends ExpressionItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfThenElseExpressionItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION);
			childrenFeatures.add(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN);
			childrenFeatures.add(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE);
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
	 * This returns IfThenElseExpression.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/IfThenElseExpression"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_IfThenElseExpression_type");
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

		switch (notification.getFeatureID(IfThenElseExpression.class)) {
			case ExpressionModelPackage.IF_THEN_ELSE_EXPRESSION__CONDITION:
			case ExpressionModelPackage.IF_THEN_ELSE_EXPRESSION__THEN:
			case ExpressionModelPackage.IF_THEN_ELSE_EXPRESSION__ELSE:
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
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createLogicExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createOpaqueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createElseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createDefaultExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createIntegerLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createDecimalLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createRationalLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createTrueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createFalseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createArrayLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createIntegerRangeLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createRecordLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createEnumerationLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createIfThenElseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createNotExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createForallExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createExistsExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createImplyExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createXorExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createEqualityExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createInequalityExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createGreaterExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createGreaterEqualExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createLessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createLessEqualExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createAddExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createSubtractExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createMultiplyExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createDivideExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createDivExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createModExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createUnaryMinusExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createUnaryPlusExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createFunctionAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createArrayAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createRecordAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION,
				 ExpressionModelFactory.eINSTANCE.createSelectExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createLogicExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createOpaqueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createElseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createDefaultExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createIntegerLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createDecimalLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createRationalLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createTrueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createFalseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createArrayLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createIntegerRangeLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createRecordLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createEnumerationLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createIfThenElseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createNotExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createForallExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createExistsExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createImplyExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createXorExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createEqualityExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createInequalityExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createGreaterExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createGreaterEqualExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createLessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createLessEqualExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createAddExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createSubtractExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createMultiplyExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createDivideExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createDivExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createModExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createUnaryMinusExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createUnaryPlusExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createFunctionAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createArrayAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createRecordAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN,
				 ExpressionModelFactory.eINSTANCE.createSelectExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createLogicExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createOpaqueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createElseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createDefaultExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createIntegerLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createDecimalLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createRationalLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createTrueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createFalseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createArrayLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createIntegerRangeLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createRecordLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createEnumerationLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createIfThenElseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createNotExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createForallExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createExistsExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createImplyExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createXorExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createEqualityExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createInequalityExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createGreaterExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createGreaterEqualExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createLessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createLessEqualExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createAddExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createSubtractExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createMultiplyExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createDivideExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createDivExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createModExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createUnaryMinusExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createUnaryPlusExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createFunctionAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createArrayAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
				 ExpressionModelFactory.eINSTANCE.createRecordAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE,
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
			childFeature == ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__CONDITION ||
			childFeature == ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__THEN ||
			childFeature == ExpressionModelPackage.Literals.IF_THEN_ELSE_EXPRESSION__ELSE;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
