/********************************************************************************
 * Copyright (c) 2018-2020 Contributors to the Gamma project
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * SPDX-License-Identifier: EPL-1.0
 ********************************************************************************/
package hu.bme.mit.gamma.c.transformation

import hu.bme.mit.gamma.expression.model.Expression
import hu.bme.mit.gamma.expression.model.VariableDeclaration
import hu.bme.mit.gamma.xsts.model.Action
import hu.bme.mit.gamma.xsts.model.AssignmentAction
import hu.bme.mit.gamma.xsts.model.AssumeAction
import hu.bme.mit.gamma.xsts.model.NonDeterministicAction
import hu.bme.mit.gamma.xsts.model.SequentialAction
import java.util.Map

import static com.google.common.base.Preconditions.checkArgument

import static extension hu.bme.mit.gamma.xsts.derivedfeatures.XSTSDerivedFeatures.*
import hu.bme.mit.gamma.xsts.model.XSTS
import hu.bme.mit.gamma.expression.model.ReferenceExpression
import hu.bme.mit.gamma.expression.model.TypeReference

class UnusedActionSerializer {
	
	extension ExpressionSerializer expressionSerializer = new ExpressionSerializer
	extension TypeSerializer typeSerializer = new TypeSerializer
	
	protected int decisionMethodCount = 0
	protected Map<Integer, CharSequence> decisionMethodMap = newHashMap
	protected final String DECISION_METHOD_NAME = "d"
	
	protected int conditionMethodCount = 0
	protected Map<Integer, CharSequence> conditionMethodMap = newHashMap
	protected final String CONDITION_METHOD_NAME = "c"
	
	protected int actionMethodCount = 0
	protected Map<Integer, CharSequence> actionMethodMap = newHashMap
	protected final String ACTION_METHOD_NAME = "a"
	
	protected XSTS xSts;
	protected boolean resetSerialization = false;
	
	def CharSequence serializeChangeState(XSTS xSts, String STRUCT_NAME) '''
		void changeState«STRUCT_NAME»(«STRUCT_NAME»* statechart) {
			«xSts.mergedAction.serialize»
		}
		
		«««serializeChangeStateAuxiliaryMethods»
		
		«««serializeConditionAuxiliaryMethods»
		
		«««serializeActionAuxiliaryMethods»
	'''
	
	def serializeInitializingAction(XSTS xSts) {
		resetSerialization = true;
		this.xSts = xSts;
		return '''
			«xSts.initializingAction.serialize»
		'''
	}
	def void changeResetSerialization(){
		resetSerialization = false;
	}
	
	def dispatch CharSequence serialize(Action action) {
		throw new IllegalArgumentException("Not supported action: " + action)
	}
	
	def dispatch CharSequence serialize(AssignmentAction action) '''
		«action.serializeTemporaryAssignment»
	'''
	
	def dispatch CharSequence serialize(NonDeterministicAction action) '''
		«action.serializeNonDeterministicAction»
	'''
	
	def dispatch CharSequence serialize(SequentialAction action) {
		val xStsSubactions = action.actions
		// Either all contained actions are nondeterministic actions...
		if (!xStsSubactions.exists[it instanceof AssumeAction]) {
			return '''
				«FOR xStsSubaction : xStsSubactions»
					«xStsSubaction.serialize»
				«ENDFOR»
			'''
		}
		// Or a single assume action and assignment actions
		val xStsSubactionsSublist = xStsSubactions.subList(1, xStsSubactions.size)
		checkArgument(xStsSubactionsSublist.forall[it instanceof AssignmentAction], "An action is not "
			+ "an assignment action, this code generator does not handle this case: " + xStsSubactionsSublist)
		val xStsAssignmentActions = xStsSubactionsSublist.filter(AssignmentAction)
		'''
«««		 	First assume action is not serialized
			«FOR xStsSubaction : xStsAssignmentActions»
				«xStsSubaction.serializeTemporaryAssignment»
			«ENDFOR»
			«IF resetSerialization == true»
				«changeResetSerialization()»
			«ENDIF»
		'''
	}
	
	private def CharSequence serializeChangeStateAuxiliaryMethods() '''
		«FOR i : 0 ..< decisionMethodCount SEPARATOR System.lineSeparator»
			private void «DECISION_METHOD_NAME»«i»() {
				«decisionMethodMap.get(i)»
			}
		«ENDFOR»
	'''
	
	private def CharSequence serializeConditionAuxiliaryMethods() '''
		«FOR i : 0 ..< conditionMethodCount SEPARATOR System.lineSeparator»
			private boolean «CONDITION_METHOD_NAME»«i»() {
				return «conditionMethodMap.get(i)»;
			}
		«ENDFOR»
	'''
	
	private def CharSequence serializeActionAuxiliaryMethods() '''
		«FOR i : 0 ..< actionMethodCount SEPARATOR System.lineSeparator»
			private void «ACTION_METHOD_NAME»«i»() {
				«actionMethodMap.get(i)»
			}
		«ENDFOR»
	'''
	
	/** Needed because of too long methods */
	def CharSequence serializeNonDeterministicAction(NonDeterministicAction action)'''
		«FOR xStsSubaction : action.actions.filter[!it.unnecessaryAction] SEPARATOR ' else ' »
			if («xStsSubaction.condition.serialize») {
				«xStsSubaction.serialize»
			}
		«ENDFOR»
	'''
	
	/** Needed because of too long methods */
	private def serializeExpression(Expression xStsExpression) {
		conditionMethodMap.put(conditionMethodCount, xStsExpression.serialize)
		return CONDITION_METHOD_NAME + conditionMethodCount++ + "()"
	}
	
	/** Needed because of too long methods */
	private def serializeAction(Action xStsSubaction) {
		actionMethodMap.put(actionMethodCount, xStsSubaction.serialize)
		return ACTION_METHOD_NAME + actionMethodCount++ + "();"
	}
	
	protected def CharSequence serializeTemporaryAssignment(AssignmentAction action) {
		val declaration = action.lhs.declaration
		checkArgument(declaration instanceof VariableDeclaration)
		val variable = (declaration as VariableDeclaration).originalVariable
		if(resetSerialization){
			
		}
		return '''
			statechart->«variable.name» = «action.rhs.serialize»;
		'''
		/*«IF resetSerialization == true»
				statechart->«variable.name» = «action.rhs.serialize»;
				«variable.name» = statechart->«variable.name»;
			«ELSE»
				statechart->«variable.name» = «action.rhs.serialize»;
			«ENDIF» */
	}
	
	protected def CharSequence serializeFinalizationAssignment(VariableDeclaration variable) '''
		this.«variable.name» = «variable.name»;
	'''
	
	protected def dispatch getCondition(Action action) {
		throw new IllegalArgumentException("Condition retrieval is supported only for
			NonDeterminsiticActions: " + action)
	}
	
	protected def dispatch getCondition(SequentialAction action) {
		val firstXStsSubaction = action.actions.head
		checkArgument(firstXStsSubaction instanceof AssumeAction)
		val firstXStAssumeAction = firstXStsSubaction as AssumeAction
		return firstXStAssumeAction.assumption
	}
	
	protected def getTemporaryName(String name) {
		return "__" + name + "__"
	}
	
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