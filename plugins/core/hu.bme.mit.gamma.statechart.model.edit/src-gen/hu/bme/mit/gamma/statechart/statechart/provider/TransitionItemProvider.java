/**
 */
package hu.bme.mit.gamma.statechart.statechart.provider;


import hu.bme.mit.gamma.action.model.ActionModelFactory;

import hu.bme.mit.gamma.expression.model.ExpressionModelFactory;

import hu.bme.mit.gamma.statechart.composite.provider.PrioritizedElementItemProvider;
import hu.bme.mit.gamma.statechart.composite.provider.StatechartEditPlugin;

import hu.bme.mit.gamma.statechart.interface_.InterfaceModelFactory;

import hu.bme.mit.gamma.statechart.statechart.StatechartModelFactory;
import hu.bme.mit.gamma.statechart.statechart.StatechartModelPackage;
import hu.bme.mit.gamma.statechart.statechart.Transition;

import java.math.BigInteger;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link hu.bme.mit.gamma.statechart.statechart.Transition} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TransitionItemProvider extends PrioritizedElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransitionItemProvider(AdapterFactory adapterFactory) {
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

			addSourceStatePropertyDescriptor(object);
			addTargetStatePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Source State feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourceStatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Transition_sourceState_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Transition_sourceState_feature", "_UI_Transition_type"),
				 StatechartModelPackage.Literals.TRANSITION__SOURCE_STATE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Target State feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetStatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Transition_targetState_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Transition_targetState_feature", "_UI_Transition_type"),
				 StatechartModelPackage.Literals.TRANSITION__TARGET_STATE,
				 true,
				 false,
				 true,
				 null,
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
			childrenFeatures.add(StatechartModelPackage.Literals.TRANSITION__TRIGGER);
			childrenFeatures.add(StatechartModelPackage.Literals.TRANSITION__GUARD);
			childrenFeatures.add(StatechartModelPackage.Literals.TRANSITION__EFFECTS);
			childrenFeatures.add(StatechartModelPackage.Literals.TRANSITION__ANNOTATIONS);
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
	 * This returns Transition.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Transition"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		BigInteger labelValue = ((Transition)object).getPriority();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_Transition_type") :
			getString("_UI_Transition_type") + " " + label;
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

		switch (notification.getFeatureID(Transition.class)) {
			case StatechartModelPackage.TRANSITION__TRIGGER:
			case StatechartModelPackage.TRANSITION__GUARD:
			case StatechartModelPackage.TRANSITION__EFFECTS:
			case StatechartModelPackage.TRANSITION__ANNOTATIONS:
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
				(StatechartModelPackage.Literals.TRANSITION__TRIGGER,
				 StatechartModelFactory.eINSTANCE.createBinaryTrigger()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__TRIGGER,
				 StatechartModelFactory.eINSTANCE.createUnaryTrigger()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__TRIGGER,
				 StatechartModelFactory.eINSTANCE.createOpaqueTrigger()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__TRIGGER,
				 StatechartModelFactory.eINSTANCE.createOnCycleTrigger()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__TRIGGER,
				 InterfaceModelFactory.eINSTANCE.createAnyTrigger()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__TRIGGER,
				 InterfaceModelFactory.eINSTANCE.createEventTrigger()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 StatechartModelFactory.eINSTANCE.createStateReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 InterfaceModelFactory.eINSTANCE.createEventParameterReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createLogicExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createOpaqueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createElseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createDefaultExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createIntegerLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createDecimalLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createRationalLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createTrueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createFalseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createArrayLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createIntegerRangeLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createRecordLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createEnumerationLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createIfThenElseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createNotExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createForallExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createExistsExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createImplyExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createXorExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createEqualityExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createInequalityExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createGreaterExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createGreaterEqualExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createLessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createLessEqualExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createAddExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createSubtractExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createMultiplyExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createDivideExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createDivExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createModExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createUnaryMinusExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createUnaryPlusExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createFunctionAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createArrayAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createRecordAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__GUARD,
				 ExpressionModelFactory.eINSTANCE.createSelectExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__EFFECTS,
				 StatechartModelFactory.eINSTANCE.createRaiseEventAction()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__EFFECTS,
				 StatechartModelFactory.eINSTANCE.createSetTimeoutAction()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__EFFECTS,
				 StatechartModelFactory.eINSTANCE.createDeactivateTimeoutAction()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__EFFECTS,
				 ActionModelFactory.eINSTANCE.createEmptyStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__EFFECTS,
				 ActionModelFactory.eINSTANCE.createBlock()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__EFFECTS,
				 ActionModelFactory.eINSTANCE.createVariableDeclarationStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__EFFECTS,
				 ActionModelFactory.eINSTANCE.createConstantDeclarationStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__EFFECTS,
				 ActionModelFactory.eINSTANCE.createExpressionStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__EFFECTS,
				 ActionModelFactory.eINSTANCE.createBreakStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__EFFECTS,
				 ActionModelFactory.eINSTANCE.createReturnStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__EFFECTS,
				 ActionModelFactory.eINSTANCE.createIfStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__EFFECTS,
				 ActionModelFactory.eINSTANCE.createSwitchStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__EFFECTS,
				 ActionModelFactory.eINSTANCE.createForStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__EFFECTS,
				 ActionModelFactory.eINSTANCE.createChoiceStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__EFFECTS,
				 ActionModelFactory.eINSTANCE.createAssignmentStatement()));

		newChildDescriptors.add
			(createChildParameter
				(StatechartModelPackage.Literals.TRANSITION__ANNOTATIONS,
				 StatechartModelFactory.eINSTANCE.createTransitionIdAnnotation()));
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
