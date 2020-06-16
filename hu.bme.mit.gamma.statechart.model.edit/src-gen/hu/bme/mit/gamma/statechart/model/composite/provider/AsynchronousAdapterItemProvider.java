/**
 */
package hu.bme.mit.gamma.statechart.model.composite.provider;


import hu.bme.mit.gamma.statechart.model.StatechartModelFactory;

import hu.bme.mit.gamma.statechart.model.composite.AsynchronousAdapter;
import hu.bme.mit.gamma.statechart.model.composite.CompositeFactory;
import hu.bme.mit.gamma.statechart.model.composite.CompositePackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link hu.bme.mit.gamma.statechart.model.composite.AsynchronousAdapter} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AsynchronousAdapterItemProvider extends AsynchronousComponentItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AsynchronousAdapterItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(CompositePackage.Literals.ASYNCHRONOUS_ADAPTER__CONTROL_SPECIFICATIONS);
			childrenFeatures.add(CompositePackage.Literals.ASYNCHRONOUS_ADAPTER__MESSAGE_QUEUES);
			childrenFeatures.add(CompositePackage.Literals.ASYNCHRONOUS_ADAPTER__CLOCKS);
			childrenFeatures.add(CompositePackage.Literals.ASYNCHRONOUS_ADAPTER__WRAPPED_COMPONENT);
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((AsynchronousAdapter)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_AsynchronousAdapter_type") :
			getString("_UI_AsynchronousAdapter_type") + " " + label;
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

		switch (notification.getFeatureID(AsynchronousAdapter.class)) {
			case CompositePackage.ASYNCHRONOUS_ADAPTER__CONTROL_SPECIFICATIONS:
			case CompositePackage.ASYNCHRONOUS_ADAPTER__MESSAGE_QUEUES:
			case CompositePackage.ASYNCHRONOUS_ADAPTER__CLOCKS:
			case CompositePackage.ASYNCHRONOUS_ADAPTER__WRAPPED_COMPONENT:
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
				(CompositePackage.Literals.ASYNCHRONOUS_ADAPTER__CONTROL_SPECIFICATIONS,
				 CompositeFactory.eINSTANCE.createControlSpecification()));

		newChildDescriptors.add
			(createChildParameter
				(CompositePackage.Literals.ASYNCHRONOUS_ADAPTER__MESSAGE_QUEUES,
				 CompositeFactory.eINSTANCE.createMessageQueue()));

		newChildDescriptors.add
			(createChildParameter
				(CompositePackage.Literals.ASYNCHRONOUS_ADAPTER__CLOCKS,
				 StatechartModelFactory.eINSTANCE.createClock()));

		newChildDescriptors.add
			(createChildParameter
				(CompositePackage.Literals.ASYNCHRONOUS_ADAPTER__WRAPPED_COMPONENT,
				 CompositeFactory.eINSTANCE.createSynchronousComponentInstance()));
	}

}
