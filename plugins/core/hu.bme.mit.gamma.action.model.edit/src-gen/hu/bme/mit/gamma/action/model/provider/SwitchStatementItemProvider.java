/**
 */
package hu.bme.mit.gamma.action.model.provider;


import hu.bme.mit.gamma.action.model.ActionModelFactory;
import hu.bme.mit.gamma.action.model.ActionModelPackage;
import hu.bme.mit.gamma.action.model.SwitchStatement;

import hu.bme.mit.gamma.expression.model.ExpressionModelFactory;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link hu.bme.mit.gamma.action.model.SwitchStatement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SwitchStatementItemProvider extends StatementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchStatementItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION);
			childrenFeatures.add(ActionModelPackage.Literals.SWITCH_STATEMENT__CASES);
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
	 * This returns SwitchStatement.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SwitchStatement"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_SwitchStatement_type");
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

		switch (notification.getFeatureID(SwitchStatement.class)) {
			case ActionModelPackage.SWITCH_STATEMENT__CONTROL_EXPRESSION:
			case ActionModelPackage.SWITCH_STATEMENT__CASES:
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
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createLogicExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createOpaqueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createElseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createDefaultExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createIntegerLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createDecimalLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createRationalLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createTrueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createFalseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createArrayLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createIntegerRangeLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createRecordLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createEnumerationLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createIfThenElseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createNotExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createForallExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createExistsExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createImplyExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createXorExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createEqualityExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createInequalityExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createGreaterExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createGreaterEqualExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createLessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createLessEqualExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createAddExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createSubtractExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createMultiplyExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createDivideExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createDivExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createModExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createUnaryMinusExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createUnaryPlusExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createFunctionAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createArrayAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createRecordAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CONTROL_EXPRESSION,
				 ExpressionModelFactory.eINSTANCE.createSelectExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.SWITCH_STATEMENT__CASES,
				 ActionModelFactory.eINSTANCE.createBranch()));
	}

}
