/**
 */
package hu.bme.mit.gamma.expression.model.provider;


import hu.bme.mit.gamma.expression.model.ExpressionModelFactory;
import hu.bme.mit.gamma.expression.model.ExpressionModelPackage;
import hu.bme.mit.gamma.expression.model.ExpressionPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link hu.bme.mit.gamma.expression.model.ExpressionPackage} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpressionPackageItemProvider extends NamedElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionPackageItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(ExpressionModelPackage.Literals.PARAMETRIC_ELEMENT__PARAMETER_DECLARATIONS);
			childrenFeatures.add(ExpressionModelPackage.Literals.EXPRESSION_PACKAGE__TYPE_DECLARATIONS);
			childrenFeatures.add(ExpressionModelPackage.Literals.EXPRESSION_PACKAGE__CONSTANT_DECLARATIONS);
			childrenFeatures.add(ExpressionModelPackage.Literals.EXPRESSION_PACKAGE__FUNCTION_DECLARATIONS);
			childrenFeatures.add(ExpressionModelPackage.Literals.EXPRESSION_PACKAGE__BASIC_CONSTRAINT_DEFINITIONS);
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
	 * This returns ExpressionPackage.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ExpressionPackage"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ExpressionPackage)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ExpressionPackage_type") :
			getString("_UI_ExpressionPackage_type") + " " + label;
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

		switch (notification.getFeatureID(ExpressionPackage.class)) {
			case ExpressionModelPackage.EXPRESSION_PACKAGE__PARAMETER_DECLARATIONS:
			case ExpressionModelPackage.EXPRESSION_PACKAGE__TYPE_DECLARATIONS:
			case ExpressionModelPackage.EXPRESSION_PACKAGE__CONSTANT_DECLARATIONS:
			case ExpressionModelPackage.EXPRESSION_PACKAGE__FUNCTION_DECLARATIONS:
			case ExpressionModelPackage.EXPRESSION_PACKAGE__BASIC_CONSTRAINT_DEFINITIONS:
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
				(ExpressionModelPackage.Literals.PARAMETRIC_ELEMENT__PARAMETER_DECLARATIONS,
				 ExpressionModelFactory.eINSTANCE.createParameterDeclaration()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.EXPRESSION_PACKAGE__TYPE_DECLARATIONS,
				 ExpressionModelFactory.eINSTANCE.createTypeDeclaration()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.EXPRESSION_PACKAGE__CONSTANT_DECLARATIONS,
				 ExpressionModelFactory.eINSTANCE.createConstantDeclaration()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.EXPRESSION_PACKAGE__FUNCTION_DECLARATIONS,
				 ExpressionModelFactory.eINSTANCE.createFunctionDeclaration()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.EXPRESSION_PACKAGE__FUNCTION_DECLARATIONS,
				 ExpressionModelFactory.eINSTANCE.createLambdaDeclaration()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionModelPackage.Literals.EXPRESSION_PACKAGE__BASIC_CONSTRAINT_DEFINITIONS,
				 ExpressionModelFactory.eINSTANCE.createBasicConstraintDefinition()));
	}

}
