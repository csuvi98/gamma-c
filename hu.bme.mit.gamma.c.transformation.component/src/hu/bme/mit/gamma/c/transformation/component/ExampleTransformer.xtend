package hu.bme.mit.gamma.c.transformation.component

import hu.bme.mit.gamma.plugintemplate.transformation.patterns.ChoiceStates
import hu.bme.mit.gamma.plugintemplate.transformation.patterns.DeepHistoryStates
import hu.bme.mit.gamma.plugintemplate.transformation.patterns.ForkStates
import hu.bme.mit.gamma.plugintemplate.transformation.patterns.InitialStates
import hu.bme.mit.gamma.plugintemplate.transformation.patterns.JoinStates
import hu.bme.mit.gamma.plugintemplate.transformation.patterns.MergeStates
import hu.bme.mit.gamma.plugintemplate.transformation.patterns.Packages
import hu.bme.mit.gamma.plugintemplate.transformation.patterns.Regions
import hu.bme.mit.gamma.plugintemplate.transformation.patterns.ShallowHistoryStates
import hu.bme.mit.gamma.plugintemplate.transformation.patterns.Statecharts
import hu.bme.mit.gamma.plugintemplate.transformation.patterns.States
import hu.bme.mit.gamma.plugintemplate.transformation.patterns.Transitions
import hu.bme.mit.gamma.statechart.model.CompositeElement
import hu.bme.mit.gamma.statechart.model.Package
import hu.bme.mit.gamma.statechart.model.Region
import hu.bme.mit.gamma.statechart.model.State
import hu.bme.mit.gamma.statechart.model.StatechartDefinition
import hu.bme.mit.gamma.statechart.model.StatechartModelFactory
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.query.runtime.emf.EMFScope
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRule
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformation
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformationStatements

import static com.google.common.base.Preconditions.checkState

class ExampleTransformer {
	// Transformation-related extensions
	protected final extension BatchTransformation transformation
	protected final extension BatchTransformationStatements statements
	// Transformation rule-related extensions
	protected final extension BatchTransformationRuleFactory = new BatchTransformationRuleFactory
	protected final extension StatechartModelFactory = StatechartModelFactory.eINSTANCE

	protected ViatraQueryEngine engine
	protected Resource resource


	new(Resource resource) {
		this.resource = resource
		// Create EMF scope and EMF IncQuery engine based on the resource
		val scope = new EMFScope(resource)
		this.engine = ViatraQueryEngine.on(scope);
		// Create VIATRA Batch transformation
		transformation = BatchTransformation.forEngine(engine).build
		// Initialize batch transformation statements
		statements = transformation.transformationStatements
	}

	def execute() {
	}

	
}
