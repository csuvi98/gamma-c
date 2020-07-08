/**
 */
package hu.bme.mit.gamma.action.model.provider;


import hu.bme.mit.gamma.action.model.ActionModelFactory;
import hu.bme.mit.gamma.action.model.ActionModelPackage;
import hu.bme.mit.gamma.action.model.ForStatement;

import hu.bme.mit.gamma.expression.model.ExpressionModelFactory;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link hu.bme.mit.gamma.action.model.ForStatement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ForStatementItemProvider extends StatementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForStatementItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(ActionModelPackage.Literals.FOR_STATEMENT__PARAMETER);
			childrenFeatures.add(ActionModelPackage.Literals.FOR_STATEMENT__RANGE);
			childrenFeatures.add(ActionModelPackage.Literals.FOR_STATEMENT__BODY);
			childrenFeatures.add(ActionModelPackage.Literals.FOR_STATEMENT__THEN);
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
	 * This returns ForStatement.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ForStatement"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_ForStatement_type");
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

		switch (notification.getFeatureID(ForStatement.class)) {
			case ActionModelPackage.FOR_STATEMENT__PARAMETER:
			case ActionModelPackage.FOR_STATEMENT__RANGE:
			case ActionModelPackage.FOR_STATEMENT__BODY:
			case ActionModelPackage.FOR_STATEMENT__THEN:
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
				(ActionModelPackage.Literals.FOR_STATEMENT__PARAMETER,
				 ExpressionModelFactory.eINSTANCE.createParameterDeclaration()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createLogicExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createOpaqueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createElseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createDefaultExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createIntegerLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createDecimalLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createRationalLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createTrueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createFalseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createArrayLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createIntegerRangeLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createRecordLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createEnumerationLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createIfThenElseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createNotExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createForallExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createExistsExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createImplyExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createXorExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createEqualityExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createInequalityExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createGreaterExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createGreaterEqualExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createLessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createLessEqualExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createAddExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createSubtractExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createMultiplyExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createDivideExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createDivExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createModExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createUnaryMinusExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createUnaryPlusExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createFunctionAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createArrayAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createRecordAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__RANGE,
				 ExpressionModelFactory.eINSTANCE.createSelectExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__BODY,
				 ActionModelFactory.eINSTANCE.createEmptyStatement()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__BODY,
				 ActionModelFactory.eINSTANCE.createBlock()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__BODY,
				 ActionModelFactory.eINSTANCE.createVariableDeclarationStatement()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__BODY,
				 ActionModelFactory.eINSTANCE.createConstantDeclarationStatement()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__BODY,
				 ActionModelFactory.eINSTANCE.createExpressionStatement()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__BODY,
				 ActionModelFactory.eINSTANCE.createBreakStatement()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__BODY,
				 ActionModelFactory.eINSTANCE.createReturnStatement()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__BODY,
				 ActionModelFactory.eINSTANCE.createIfStatement()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__BODY,
				 ActionModelFactory.eINSTANCE.createSwitchStatement()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__BODY,
				 ActionModelFactory.eINSTANCE.createForStatement()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__BODY,
				 ActionModelFactory.eINSTANCE.createChoiceStatement()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__BODY,
				 ActionModelFactory.eINSTANCE.createAssignmentStatement()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__THEN,
				 ActionModelFactory.eINSTANCE.createEmptyStatement()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__THEN,
				 ActionModelFactory.eINSTANCE.createBlock()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__THEN,
				 ActionModelFactory.eINSTANCE.createVariableDeclarationStatement()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__THEN,
				 ActionModelFactory.eINSTANCE.createConstantDeclarationStatement()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__THEN,
				 ActionModelFactory.eINSTANCE.createExpressionStatement()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__THEN,
				 ActionModelFactory.eINSTANCE.createBreakStatement()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__THEN,
				 ActionModelFactory.eINSTANCE.createReturnStatement()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__THEN,
				 ActionModelFactory.eINSTANCE.createIfStatement()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__THEN,
				 ActionModelFactory.eINSTANCE.createSwitchStatement()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__THEN,
				 ActionModelFactory.eINSTANCE.createForStatement()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__THEN,
				 ActionModelFactory.eINSTANCE.createChoiceStatement()));

		newChildDescriptors.add
			(createChildParameter
				(ActionModelPackage.Literals.FOR_STATEMENT__THEN,
				 ActionModelFactory.eINSTANCE.createAssignmentStatement()));
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
			childFeature == ActionModelPackage.Literals.FOR_STATEMENT__BODY ||
			childFeature == ActionModelPackage.Literals.FOR_STATEMENT__THEN;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
