/**
 */
package hu.bme.mit.gamma.statechart.interface_.provider;


import hu.bme.mit.gamma.action.model.ActionModelFactory;

import hu.bme.mit.gamma.expression.model.ExpressionModelFactory;
import hu.bme.mit.gamma.expression.model.ExpressionModelPackage;

import hu.bme.mit.gamma.expression.model.provider.ExpressionPackageItemProvider;

import hu.bme.mit.gamma.statechart.composite.CompositeModelFactory;

import hu.bme.mit.gamma.statechart.composite.provider.StatechartEditPlugin;

import hu.bme.mit.gamma.statechart.interface_.InterfaceModelFactory;
import hu.bme.mit.gamma.statechart.interface_.InterfaceModelPackage;

import hu.bme.mit.gamma.statechart.statechart.StatechartModelFactory;

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
 * This is the item provider adapter for a {@link hu.bme.mit.gamma.statechart.interface_.Package} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PackageItemProvider extends ExpressionPackageItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageItemProvider(AdapterFactory adapterFactory) {
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

			addImportsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Imports feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImportsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Package_imports_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Package_imports_feature", "_UI_Package_type"),
				 InterfaceModelPackage.Literals.PACKAGE__IMPORTS,
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
			childrenFeatures.add(InterfaceModelPackage.Literals.PACKAGE__COMPONENTS);
			childrenFeatures.add(InterfaceModelPackage.Literals.PACKAGE__INTERFACES);
			childrenFeatures.add(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS);
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
	 * This returns Package.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Package"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((hu.bme.mit.gamma.statechart.interface_.Package)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Package_type") :
			getString("_UI_Package_type") + " " + label;
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

		switch (notification.getFeatureID(hu.bme.mit.gamma.statechart.interface_.Package.class)) {
			case InterfaceModelPackage.PACKAGE__COMPONENTS:
			case InterfaceModelPackage.PACKAGE__INTERFACES:
			case InterfaceModelPackage.PACKAGE__TOP_COMPONENT_ARGUMENTS:
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
				(ExpressionModelPackage.Literals.EXPRESSION_PACKAGE__FUNCTION_DECLARATIONS,
				 ActionModelFactory.eINSTANCE.createProcedureDeclaration()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__COMPONENTS,
				 CompositeModelFactory.eINSTANCE.createAsynchronousCompositeComponent()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__COMPONENTS,
				 CompositeModelFactory.eINSTANCE.createAsynchronousAdapter()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__COMPONENTS,
				 CompositeModelFactory.eINSTANCE.createCascadeCompositeComponent()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__COMPONENTS,
				 CompositeModelFactory.eINSTANCE.createSynchronousCompositeComponent()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__COMPONENTS,
				 StatechartModelFactory.eINSTANCE.createStatechartDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__INTERFACES,
				 InterfaceModelFactory.eINSTANCE.createInterface()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 InterfaceModelFactory.eINSTANCE.createEventParameterReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 StatechartModelFactory.eINSTANCE.createStateReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createLogicExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createOpaqueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createElseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createDefaultExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createIntegerLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createDecimalLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createRationalLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createTrueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createFalseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createArrayLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createIntegerRangeLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createRecordLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createEnumerationLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createReferenceExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createIfThenElseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createNotExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createForallExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createExistsExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createImplyExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createXorExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createEqualityExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createInequalityExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createGreaterExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createGreaterEqualExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createLessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createLessEqualExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createAddExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createSubtractExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createMultiplyExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createDivideExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createDivExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createModExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createUnaryMinusExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createUnaryPlusExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createFunctionAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createArrayAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
				 ExpressionModelFactory.eINSTANCE.createRecordAccessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(InterfaceModelPackage.Literals.PACKAGE__TOP_COMPONENT_ARGUMENTS,
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
		return StatechartEditPlugin.INSTANCE;
	}

}
