/**
 */
package hu.bme.mit.gamma.action.model.provider;

import hu.bme.mit.gamma.action.model.util.ActionModelAdapterFactory;

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
public class ActionModelItemProviderAdapterFactory extends ActionModelAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
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
	public ActionModelItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link hu.bme.mit.gamma.action.model.ProcedureDeclaration} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcedureDeclarationItemProvider procedureDeclarationItemProvider;

	/**
	 * This creates an adapter for a {@link hu.bme.mit.gamma.action.model.ProcedureDeclaration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createProcedureDeclarationAdapter() {
		if (procedureDeclarationItemProvider == null) {
			procedureDeclarationItemProvider = new ProcedureDeclarationItemProvider(this);
		}

		return procedureDeclarationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hu.bme.mit.gamma.action.model.EmptyStatement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EmptyStatementItemProvider emptyStatementItemProvider;

	/**
	 * This creates an adapter for a {@link hu.bme.mit.gamma.action.model.EmptyStatement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEmptyStatementAdapter() {
		if (emptyStatementItemProvider == null) {
			emptyStatementItemProvider = new EmptyStatementItemProvider(this);
		}

		return emptyStatementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hu.bme.mit.gamma.action.model.Block} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlockItemProvider blockItemProvider;

	/**
	 * This creates an adapter for a {@link hu.bme.mit.gamma.action.model.Block}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBlockAdapter() {
		if (blockItemProvider == null) {
			blockItemProvider = new BlockItemProvider(this);
		}

		return blockItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hu.bme.mit.gamma.action.model.Branch} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BranchItemProvider branchItemProvider;

	/**
	 * This creates an adapter for a {@link hu.bme.mit.gamma.action.model.Branch}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBranchAdapter() {
		if (branchItemProvider == null) {
			branchItemProvider = new BranchItemProvider(this);
		}

		return branchItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hu.bme.mit.gamma.action.model.VariableDeclarationStatement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableDeclarationStatementItemProvider variableDeclarationStatementItemProvider;

	/**
	 * This creates an adapter for a {@link hu.bme.mit.gamma.action.model.VariableDeclarationStatement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createVariableDeclarationStatementAdapter() {
		if (variableDeclarationStatementItemProvider == null) {
			variableDeclarationStatementItemProvider = new VariableDeclarationStatementItemProvider(this);
		}

		return variableDeclarationStatementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hu.bme.mit.gamma.action.model.ConstantDeclarationStatement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstantDeclarationStatementItemProvider constantDeclarationStatementItemProvider;

	/**
	 * This creates an adapter for a {@link hu.bme.mit.gamma.action.model.ConstantDeclarationStatement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConstantDeclarationStatementAdapter() {
		if (constantDeclarationStatementItemProvider == null) {
			constantDeclarationStatementItemProvider = new ConstantDeclarationStatementItemProvider(this);
		}

		return constantDeclarationStatementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hu.bme.mit.gamma.action.model.ExpressionStatement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionStatementItemProvider expressionStatementItemProvider;

	/**
	 * This creates an adapter for a {@link hu.bme.mit.gamma.action.model.ExpressionStatement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExpressionStatementAdapter() {
		if (expressionStatementItemProvider == null) {
			expressionStatementItemProvider = new ExpressionStatementItemProvider(this);
		}

		return expressionStatementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hu.bme.mit.gamma.action.model.BreakStatement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BreakStatementItemProvider breakStatementItemProvider;

	/**
	 * This creates an adapter for a {@link hu.bme.mit.gamma.action.model.BreakStatement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBreakStatementAdapter() {
		if (breakStatementItemProvider == null) {
			breakStatementItemProvider = new BreakStatementItemProvider(this);
		}

		return breakStatementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hu.bme.mit.gamma.action.model.ReturnStatement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReturnStatementItemProvider returnStatementItemProvider;

	/**
	 * This creates an adapter for a {@link hu.bme.mit.gamma.action.model.ReturnStatement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReturnStatementAdapter() {
		if (returnStatementItemProvider == null) {
			returnStatementItemProvider = new ReturnStatementItemProvider(this);
		}

		return returnStatementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hu.bme.mit.gamma.action.model.IfStatement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfStatementItemProvider ifStatementItemProvider;

	/**
	 * This creates an adapter for a {@link hu.bme.mit.gamma.action.model.IfStatement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIfStatementAdapter() {
		if (ifStatementItemProvider == null) {
			ifStatementItemProvider = new IfStatementItemProvider(this);
		}

		return ifStatementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hu.bme.mit.gamma.action.model.SwitchStatement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SwitchStatementItemProvider switchStatementItemProvider;

	/**
	 * This creates an adapter for a {@link hu.bme.mit.gamma.action.model.SwitchStatement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSwitchStatementAdapter() {
		if (switchStatementItemProvider == null) {
			switchStatementItemProvider = new SwitchStatementItemProvider(this);
		}

		return switchStatementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hu.bme.mit.gamma.action.model.ForStatement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForStatementItemProvider forStatementItemProvider;

	/**
	 * This creates an adapter for a {@link hu.bme.mit.gamma.action.model.ForStatement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createForStatementAdapter() {
		if (forStatementItemProvider == null) {
			forStatementItemProvider = new ForStatementItemProvider(this);
		}

		return forStatementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hu.bme.mit.gamma.action.model.ChoiceStatement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChoiceStatementItemProvider choiceStatementItemProvider;

	/**
	 * This creates an adapter for a {@link hu.bme.mit.gamma.action.model.ChoiceStatement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createChoiceStatementAdapter() {
		if (choiceStatementItemProvider == null) {
			choiceStatementItemProvider = new ChoiceStatementItemProvider(this);
		}

		return choiceStatementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hu.bme.mit.gamma.action.model.AssignmentStatement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssignmentStatementItemProvider assignmentStatementItemProvider;

	/**
	 * This creates an adapter for a {@link hu.bme.mit.gamma.action.model.AssignmentStatement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAssignmentStatementAdapter() {
		if (assignmentStatementItemProvider == null) {
			assignmentStatementItemProvider = new AssignmentStatementItemProvider(this);
		}

		return assignmentStatementItemProvider;
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
		if (procedureDeclarationItemProvider != null) procedureDeclarationItemProvider.dispose();
		if (emptyStatementItemProvider != null) emptyStatementItemProvider.dispose();
		if (blockItemProvider != null) blockItemProvider.dispose();
		if (branchItemProvider != null) branchItemProvider.dispose();
		if (variableDeclarationStatementItemProvider != null) variableDeclarationStatementItemProvider.dispose();
		if (constantDeclarationStatementItemProvider != null) constantDeclarationStatementItemProvider.dispose();
		if (expressionStatementItemProvider != null) expressionStatementItemProvider.dispose();
		if (breakStatementItemProvider != null) breakStatementItemProvider.dispose();
		if (returnStatementItemProvider != null) returnStatementItemProvider.dispose();
		if (ifStatementItemProvider != null) ifStatementItemProvider.dispose();
		if (switchStatementItemProvider != null) switchStatementItemProvider.dispose();
		if (forStatementItemProvider != null) forStatementItemProvider.dispose();
		if (choiceStatementItemProvider != null) choiceStatementItemProvider.dispose();
		if (assignmentStatementItemProvider != null) assignmentStatementItemProvider.dispose();
	}

}