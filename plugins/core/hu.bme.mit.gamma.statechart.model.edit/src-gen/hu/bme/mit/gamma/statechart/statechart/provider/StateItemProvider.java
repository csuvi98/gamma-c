/**
 */
package hu.bme.mit.gamma.statechart.statechart.provider;


import hu.bme.mit.gamma.action.model.ActionModelFactory;

import hu.bme.mit.gamma.expression.model.ExpressionModelFactory;

import hu.bme.mit.gamma.statechart.contract.ContractModelFactory;

import hu.bme.mit.gamma.statechart.interface_.InterfaceModelFactory;

import hu.bme.mit.gamma.statechart.phase.PhaseModelFactory;

import hu.bme.mit.gamma.statechart.statechart.State;
import hu.bme.mit.gamma.statechart.statechart.StatechartModelFactory;
import hu.bme.mit.gamma.statechart.statechart.StatechartModelPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link hu.bme.mit.gamma.statechart.statechart.State} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class StateItemProvider extends StateNodeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(StatechartModelPackage.Literals.COMPOSITE_ELEMENT__REGIONS);
			childrenFeatures.add(StatechartModelPackage.Literals.STATE__INVARIANTS);
			childrenFeatures.add(StatechartModelPackage.Literals.STATE__ENTRY_ACTIONS);
			childrenFeatures.add(StatechartModelPackage.Literals.STATE__EXIT_ACTIONS);
			childrenFeatures.add(StatechartModelPackage.Literals.STATE__ANNOTATION);
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
	 * This returns State.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/State"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((State)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_State_type") :
			getString("_UI_State_type") + " " + label;
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

		switch (notification.getFeatureID(State.class)) {
			case StatechartModelPackage.STATE__REGIONS:
			case StatechartModelPackage.STATE__INVARIANTS:
			case StatechartModelPackage.STATE__ENTRY_ACTIONS:
			case StatechartModelPackage.STATE__EXIT_ACTIONS:
			case StatechartModelPackage.STATE__ANNOTATION:
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
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 StatechartModelFactory.eINSTANCE.createStateReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 InterfaceModelFactory.eINSTANCE.createEventParameterReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createLogicExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createOpaqueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createElseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createDefaultExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createIntegerLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createDecimalLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createRationalLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createTrueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createFalseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createArrayLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createIntegerRangeLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createRecordLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createEnumerationLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createIfThenElseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createNotExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createForallExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createExistsExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createImplyExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createXorExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createEqualityExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createInequalityExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createGreaterExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createGreaterEqualExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createLessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createLessEqualExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createAddExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createSubtractExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createMultiplyExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createDivideExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createDivExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createModExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createUnaryMinusExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createUnaryPlusExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createFunctionAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createArrayAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createRecordAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__INVARIANTS,
				 ExpressionModelFactory.eINSTANCE.createSelectExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__ENTRY_ACTIONS,
				 StatechartModelFactory.eINSTANCE.createRaiseEventAction()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__ENTRY_ACTIONS,
				 StatechartModelFactory.eINSTANCE.createSetTimeoutAction()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__ENTRY_ACTIONS,
				 StatechartModelFactory.eINSTANCE.createDeactivateTimeoutAction()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__ENTRY_ACTIONS,
				 ActionModelFactory.eINSTANCE.createEmptyStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__ENTRY_ACTIONS,
				 ActionModelFactory.eINSTANCE.createBlock()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__ENTRY_ACTIONS,
				 ActionModelFactory.eINSTANCE.createVariableDeclarationStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__ENTRY_ACTIONS,
				 ActionModelFactory.eINSTANCE.createConstantDeclarationStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__ENTRY_ACTIONS,
				 ActionModelFactory.eINSTANCE.createExpressionStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__ENTRY_ACTIONS,
				 ActionModelFactory.eINSTANCE.createBreakStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__ENTRY_ACTIONS,
				 ActionModelFactory.eINSTANCE.createReturnStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__ENTRY_ACTIONS,
				 ActionModelFactory.eINSTANCE.createIfStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__ENTRY_ACTIONS,
				 ActionModelFactory.eINSTANCE.createSwitchStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__ENTRY_ACTIONS,
				 ActionModelFactory.eINSTANCE.createForStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__ENTRY_ACTIONS,
				 ActionModelFactory.eINSTANCE.createChoiceStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__ENTRY_ACTIONS,
				 ActionModelFactory.eINSTANCE.createAssignmentStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__EXIT_ACTIONS,
				 StatechartModelFactory.eINSTANCE.createRaiseEventAction()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__EXIT_ACTIONS,
				 StatechartModelFactory.eINSTANCE.createSetTimeoutAction()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__EXIT_ACTIONS,
				 StatechartModelFactory.eINSTANCE.createDeactivateTimeoutAction()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__EXIT_ACTIONS,
				 ActionModelFactory.eINSTANCE.createEmptyStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__EXIT_ACTIONS,
				 ActionModelFactory.eINSTANCE.createBlock()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__EXIT_ACTIONS,
				 ActionModelFactory.eINSTANCE.createVariableDeclarationStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__EXIT_ACTIONS,
				 ActionModelFactory.eINSTANCE.createConstantDeclarationStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__EXIT_ACTIONS,
				 ActionModelFactory.eINSTANCE.createExpressionStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__EXIT_ACTIONS,
				 ActionModelFactory.eINSTANCE.createBreakStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__EXIT_ACTIONS,
				 ActionModelFactory.eINSTANCE.createReturnStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__EXIT_ACTIONS,
				 ActionModelFactory.eINSTANCE.createIfStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__EXIT_ACTIONS,
				 ActionModelFactory.eINSTANCE.createSwitchStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__EXIT_ACTIONS,
				 ActionModelFactory.eINSTANCE.createForStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__EXIT_ACTIONS,
				 ActionModelFactory.eINSTANCE.createChoiceStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__EXIT_ACTIONS,
				 ActionModelFactory.eINSTANCE.createAssignmentStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__ANNOTATION,
				 ContractModelFactory.eINSTANCE.createStateContractAnnotation()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.STATE__ANNOTATION,
				 PhaseModelFactory.eINSTANCE.createMissionPhaseStateAnnotation()));
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
			childFeature == StatechartModelPackage.Literals.STATE__ENTRY_ACTIONS ||
			childFeature == StatechartModelPackage.Literals.STATE__EXIT_ACTIONS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
