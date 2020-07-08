/**
 */
package hu.bme.mit.gamma.expression.model.provider;


import hu.bme.mit.gamma.expression.model.ExpressionModelFactory;
import hu.bme.mit.gamma.expression.model.ExpressionModelPackage;
import hu.bme.mit.gamma.expression.model.FunctionTypeDefinition;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link hu.bme.mit.gamma.expression.model.FunctionTypeDefinition} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FunctionTypeDefinitionItemProvider extends CompositeTypeDefinitionItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionTypeDefinitionItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__PARAMETER_TYPES);
			childrenFeatures.add(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__RETURN_TYPE);
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
	 * This returns FunctionTypeDefinition.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/FunctionTypeDefinition"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_FunctionTypeDefinition_type");
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

		switch (notification.getFeatureID(FunctionTypeDefinition.class)) {
			case ExpressionModelPackage.FUNCTION_TYPE_DEFINITION__PARAMETER_TYPES:
			case ExpressionModelPackage.FUNCTION_TYPE_DEFINITION__RETURN_TYPE:
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
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__PARAMETER_TYPES,
				 ExpressionModelFactory.eINSTANCE.createType()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__PARAMETER_TYPES,
				 ExpressionModelFactory.eINSTANCE.createTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__PARAMETER_TYPES,
				 ExpressionModelFactory.eINSTANCE.createTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__PARAMETER_TYPES,
				 ExpressionModelFactory.eINSTANCE.createNumericalTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__PARAMETER_TYPES,
				 ExpressionModelFactory.eINSTANCE.createCompositeTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__PARAMETER_TYPES,
				 ExpressionModelFactory.eINSTANCE.createVoidTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__PARAMETER_TYPES,
				 ExpressionModelFactory.eINSTANCE.createBooleanTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__PARAMETER_TYPES,
				 ExpressionModelFactory.eINSTANCE.createIntegerTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__PARAMETER_TYPES,
				 ExpressionModelFactory.eINSTANCE.createRationalTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__PARAMETER_TYPES,
				 ExpressionModelFactory.eINSTANCE.createDecimalTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__PARAMETER_TYPES,
				 ExpressionModelFactory.eINSTANCE.createSubrangeTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__PARAMETER_TYPES,
				 ExpressionModelFactory.eINSTANCE.createEnumerationTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__PARAMETER_TYPES,
				 ExpressionModelFactory.eINSTANCE.createArrayTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__PARAMETER_TYPES,
				 ExpressionModelFactory.eINSTANCE.createIntegerRangeTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__PARAMETER_TYPES,
				 ExpressionModelFactory.eINSTANCE.createFunctionTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__PARAMETER_TYPES,
				 ExpressionModelFactory.eINSTANCE.createRecordTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__RETURN_TYPE,
				 ExpressionModelFactory.eINSTANCE.createType()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__RETURN_TYPE,
				 ExpressionModelFactory.eINSTANCE.createTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__RETURN_TYPE,
				 ExpressionModelFactory.eINSTANCE.createTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__RETURN_TYPE,
				 ExpressionModelFactory.eINSTANCE.createNumericalTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__RETURN_TYPE,
				 ExpressionModelFactory.eINSTANCE.createCompositeTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__RETURN_TYPE,
				 ExpressionModelFactory.eINSTANCE.createVoidTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__RETURN_TYPE,
				 ExpressionModelFactory.eINSTANCE.createBooleanTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__RETURN_TYPE,
				 ExpressionModelFactory.eINSTANCE.createIntegerTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__RETURN_TYPE,
				 ExpressionModelFactory.eINSTANCE.createRationalTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__RETURN_TYPE,
				 ExpressionModelFactory.eINSTANCE.createDecimalTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__RETURN_TYPE,
				 ExpressionModelFactory.eINSTANCE.createSubrangeTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__RETURN_TYPE,
				 ExpressionModelFactory.eINSTANCE.createEnumerationTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__RETURN_TYPE,
				 ExpressionModelFactory.eINSTANCE.createArrayTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__RETURN_TYPE,
				 ExpressionModelFactory.eINSTANCE.createIntegerRangeTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__RETURN_TYPE,
				 ExpressionModelFactory.eINSTANCE.createFunctionTypeDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__RETURN_TYPE,
				 ExpressionModelFactory.eINSTANCE.createRecordTypeDefinition()));
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
			childFeature == ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__PARAMETER_TYPES ||
			childFeature == ExpressionModelPackage.Literals.FUNCTION_TYPE_DEFINITION__RETURN_TYPE;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
