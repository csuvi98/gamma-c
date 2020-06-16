/**
 */
package hu.bme.mit.gamma.statechart.model.composite.provider;

import hu.bme.mit.gamma.statechart.model.composite.util.CompositeAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CompositeItemProviderAdapterFactory extends CompositeAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link hu.bme.mit.gamma.statechart.model.composite.PrioritizedElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrioritizedElementItemProvider prioritizedElementItemProvider;

	/**
	 * This creates an adapter for a {@link hu.bme.mit.gamma.statechart.model.composite.PrioritizedElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPrioritizedElementAdapter() {
		if (prioritizedElementItemProvider == null) {
			prioritizedElementItemProvider = new PrioritizedElementItemProvider(this);
		}

		return prioritizedElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hu.bme.mit.gamma.statechart.model.composite.PortBinding} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PortBindingItemProvider portBindingItemProvider;

	/**
	 * This creates an adapter for a {@link hu.bme.mit.gamma.statechart.model.composite.PortBinding}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPortBindingAdapter() {
		if (portBindingItemProvider == null) {
			portBindingItemProvider = new PortBindingItemProvider(this);
		}

		return portBindingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hu.bme.mit.gamma.statechart.model.composite.InstancePortReference} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstancePortReferenceItemProvider instancePortReferenceItemProvider;

	/**
	 * This creates an adapter for a {@link hu.bme.mit.gamma.statechart.model.composite.InstancePortReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInstancePortReferenceAdapter() {
		if (instancePortReferenceItemProvider == null) {
			instancePortReferenceItemProvider = new InstancePortReferenceItemProvider(this);
		}

		return instancePortReferenceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hu.bme.mit.gamma.statechart.model.composite.BroadcastChannel} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BroadcastChannelItemProvider broadcastChannelItemProvider;

	/**
	 * This creates an adapter for a {@link hu.bme.mit.gamma.statechart.model.composite.BroadcastChannel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBroadcastChannelAdapter() {
		if (broadcastChannelItemProvider == null) {
			broadcastChannelItemProvider = new BroadcastChannelItemProvider(this);
		}

		return broadcastChannelItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hu.bme.mit.gamma.statechart.model.composite.SimpleChannel} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleChannelItemProvider simpleChannelItemProvider;

	/**
	 * This creates an adapter for a {@link hu.bme.mit.gamma.statechart.model.composite.SimpleChannel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSimpleChannelAdapter() {
		if (simpleChannelItemProvider == null) {
			simpleChannelItemProvider = new SimpleChannelItemProvider(this);
		}

		return simpleChannelItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hu.bme.mit.gamma.statechart.model.composite.ControlSpecification} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ControlSpecificationItemProvider controlSpecificationItemProvider;

	/**
	 * This creates an adapter for a {@link hu.bme.mit.gamma.statechart.model.composite.ControlSpecification}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createControlSpecificationAdapter() {
		if (controlSpecificationItemProvider == null) {
			controlSpecificationItemProvider = new ControlSpecificationItemProvider(this);
		}

		return controlSpecificationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hu.bme.mit.gamma.statechart.model.composite.MessageQueue} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MessageQueueItemProvider messageQueueItemProvider;

	/**
	 * This creates an adapter for a {@link hu.bme.mit.gamma.statechart.model.composite.MessageQueue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMessageQueueAdapter() {
		if (messageQueueItemProvider == null) {
			messageQueueItemProvider = new MessageQueueItemProvider(this);
		}

		return messageQueueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hu.bme.mit.gamma.statechart.model.composite.SynchronousComponentInstance} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SynchronousComponentInstanceItemProvider synchronousComponentInstanceItemProvider;

	/**
	 * This creates an adapter for a {@link hu.bme.mit.gamma.statechart.model.composite.SynchronousComponentInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSynchronousComponentInstanceAdapter() {
		if (synchronousComponentInstanceItemProvider == null) {
			synchronousComponentInstanceItemProvider = new SynchronousComponentInstanceItemProvider(this);
		}

		return synchronousComponentInstanceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hu.bme.mit.gamma.statechart.model.composite.AsynchronousComponentInstance} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AsynchronousComponentInstanceItemProvider asynchronousComponentInstanceItemProvider;

	/**
	 * This creates an adapter for a {@link hu.bme.mit.gamma.statechart.model.composite.AsynchronousComponentInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAsynchronousComponentInstanceAdapter() {
		if (asynchronousComponentInstanceItemProvider == null) {
			asynchronousComponentInstanceItemProvider = new AsynchronousComponentInstanceItemProvider(this);
		}

		return asynchronousComponentInstanceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hu.bme.mit.gamma.statechart.model.composite.AsynchronousCompositeComponent} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AsynchronousCompositeComponentItemProvider asynchronousCompositeComponentItemProvider;

	/**
	 * This creates an adapter for a {@link hu.bme.mit.gamma.statechart.model.composite.AsynchronousCompositeComponent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAsynchronousCompositeComponentAdapter() {
		if (asynchronousCompositeComponentItemProvider == null) {
			asynchronousCompositeComponentItemProvider = new AsynchronousCompositeComponentItemProvider(this);
		}

		return asynchronousCompositeComponentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hu.bme.mit.gamma.statechart.model.composite.AsynchronousAdapter} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AsynchronousAdapterItemProvider asynchronousAdapterItemProvider;

	/**
	 * This creates an adapter for a {@link hu.bme.mit.gamma.statechart.model.composite.AsynchronousAdapter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAsynchronousAdapterAdapter() {
		if (asynchronousAdapterItemProvider == null) {
			asynchronousAdapterItemProvider = new AsynchronousAdapterItemProvider(this);
		}

		return asynchronousAdapterItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hu.bme.mit.gamma.statechart.model.composite.CascadeCompositeComponent} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CascadeCompositeComponentItemProvider cascadeCompositeComponentItemProvider;

	/**
	 * This creates an adapter for a {@link hu.bme.mit.gamma.statechart.model.composite.CascadeCompositeComponent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCascadeCompositeComponentAdapter() {
		if (cascadeCompositeComponentItemProvider == null) {
			cascadeCompositeComponentItemProvider = new CascadeCompositeComponentItemProvider(this);
		}

		return cascadeCompositeComponentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hu.bme.mit.gamma.statechart.model.composite.SynchronousCompositeComponent} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SynchronousCompositeComponentItemProvider synchronousCompositeComponentItemProvider;

	/**
	 * This creates an adapter for a {@link hu.bme.mit.gamma.statechart.model.composite.SynchronousCompositeComponent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSynchronousCompositeComponentAdapter() {
		if (synchronousCompositeComponentItemProvider == null) {
			synchronousCompositeComponentItemProvider = new SynchronousCompositeComponentItemProvider(this);
		}

		return synchronousCompositeComponentItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void dispose() {
		if (prioritizedElementItemProvider != null) prioritizedElementItemProvider.dispose();
		if (portBindingItemProvider != null) portBindingItemProvider.dispose();
		if (instancePortReferenceItemProvider != null) instancePortReferenceItemProvider.dispose();
		if (broadcastChannelItemProvider != null) broadcastChannelItemProvider.dispose();
		if (simpleChannelItemProvider != null) simpleChannelItemProvider.dispose();
		if (controlSpecificationItemProvider != null) controlSpecificationItemProvider.dispose();
		if (messageQueueItemProvider != null) messageQueueItemProvider.dispose();
		if (synchronousComponentInstanceItemProvider != null) synchronousComponentInstanceItemProvider.dispose();
		if (asynchronousComponentInstanceItemProvider != null) asynchronousComponentInstanceItemProvider.dispose();
		if (asynchronousCompositeComponentItemProvider != null) asynchronousCompositeComponentItemProvider.dispose();
		if (asynchronousAdapterItemProvider != null) asynchronousAdapterItemProvider.dispose();
		if (cascadeCompositeComponentItemProvider != null) cascadeCompositeComponentItemProvider.dispose();
		if (synchronousCompositeComponentItemProvider != null) synchronousCompositeComponentItemProvider.dispose();
	}

}
