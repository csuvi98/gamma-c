package hu.bme.mit.gamma.c.transformation

import hu.bme.mit.gamma.expression.model.Expression
import hu.bme.mit.gamma.expression.model.ReferenceExpression
import hu.bme.mit.gamma.xsts.model.Action
import hu.bme.mit.gamma.xsts.model.AssignmentAction
import hu.bme.mit.gamma.xsts.model.AssumeAction
import hu.bme.mit.gamma.xsts.model.CompositeAction
import hu.bme.mit.gamma.xsts.model.NonDeterministicAction
import hu.bme.mit.gamma.xsts.model.SequentialAction
import hu.bme.mit.gamma.xsts.model.XSTS

import static extension hu.bme.mit.gamma.xsts.derivedfeatures.XSTSDerivedFeatures.*

class CommonizedVariableActionSerializer extends TempActionSerializer {
	
	extension ExpressionSerializer expressionSerializer = new ExpressionSerializer
	
	new(String STRUCT_NAME) {
		super(STRUCT_NAME)
	}
	
	
	override serializeInitializingAction(XSTS xSts) '''
		«xSts.initializingAction.serialize»
	'''
	
	override CharSequence serializeChangeState(XSTS xSts) '''
		void changeState«STRUCT_NAME»(«STRUCT_NAME»* statechart) {
					«xSts.mergedAction.serialize»
		}
	'''
	
	// Action serialization
	
	def dispatch CharSequence serialize(Action action) {
		throw new IllegalArgumentException("Not supported action: " + action)
	}
	
	def dispatch CharSequence serialize(NonDeterministicAction action) '''
		«FOR xStsSubaction : action.actions.filter[!it.unnecessaryAction] SEPARATOR ' else ' »
			if («xStsSubaction.condition.serialize») {
				«xStsSubaction.serialize»
			}
		«ENDFOR»
	'''
	
	def dispatch CharSequence serialize(SequentialAction action) '''
		«FOR xStsSubaction : action.actions»«xStsSubaction.serialize»«ENDFOR»
	'''

	def dispatch CharSequence serialize(AssumeAction action) ''''''
	
//	def dispatch CharSequence serialize(AssumeAction action) '''
//		assert «action.assumption.serialize»;
//	'''
	
	def dispatch CharSequence serialize(AssignmentAction action) {
		if (action.unnecessaryAction) {
			return ''''''
		}
		return '''
			«action.lhs.serialize» = «action.rhs.serialize»;
		'''
	}
	
	// Getting conditions from a non deterministic action point of view
	
	protected def dispatch Expression getCondition(Action action) {
		return createTrueExpression
	}
	
	protected def dispatch Expression getCondition(SequentialAction action) {
		val xStsSubactions = action.actions
		val firstXStsSubaction = xStsSubactions.head
		if (firstXStsSubaction instanceof AssumeAction) {
			return firstXStsSubaction.condition
		}
		val xStsCompositeSubactions = xStsSubactions.filter(CompositeAction)
		if (xStsCompositeSubactions.empty) {
			return createTrueExpression
		}
		return createAndExpression => [
			for (xStsSubaction : action.actions) {
				it.operands += xStsSubaction.condition
			}
		]
	}
	
	// Should not be present, but there are NonDeterministicActions inside NonDeterministicAction
	protected def dispatch Expression getCondition(NonDeterministicAction action) {
		return createOrExpression => [
			for (xStsSubaction : action.actions) {
				it.operands += xStsSubaction.condition
			}
		]
	}
	
	protected def dispatch Expression getCondition(AssumeAction action) {
		return action.assumption.clone(true, true)
	}
	
	// Optimization: for deleting unnecessary branches
	
	private def dispatch boolean isUnnecessaryAction(Action action) {
		return false;
	}
	
	private def dispatch boolean isUnnecessaryAction(SequentialAction action) {
		return action.actions.forall[it.unnecessaryAction]
	}
	
	private def dispatch boolean isUnnecessaryAction(AssumeAction action) {
		return true
	}
	
	private def dispatch boolean isUnnecessaryAction(AssignmentAction action) {
		val lhs = action.lhs.declaration
		val rhs = action.rhs
		if (rhs instanceof ReferenceExpression) {
			if (lhs.originalVariable == rhs.declaration.originalVariable) {
				return true
			}
		}
		return false
	}
	
		
}