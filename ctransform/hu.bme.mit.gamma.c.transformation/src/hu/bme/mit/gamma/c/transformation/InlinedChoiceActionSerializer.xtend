package hu.bme.mit.gamma.c.transformation

import hu.bme.mit.gamma.xsts.model.XSTS
import hu.bme.mit.gamma.expression.model.Declaration
import hu.bme.mit.gamma.expression.model.Expression
import hu.bme.mit.gamma.expression.model.VariableDeclaration
import hu.bme.mit.gamma.xsts.model.Action
import hu.bme.mit.gamma.xsts.model.AssignmentAction
import hu.bme.mit.gamma.xsts.model.AssumeAction
import hu.bme.mit.gamma.xsts.model.NonDeterministicAction
import hu.bme.mit.gamma.xsts.model.SequentialAction
import hu.bme.mit.gamma.xsts.model.XSTS
import java.util.Map
import java.util.Set

import static com.google.common.base.Preconditions.checkArgument
import static extension hu.bme.mit.gamma.xsts.derivedfeatures.XSTSDerivedFeatures.*


class InlinedChoiceActionSerializer extends TempActionSerializer{
	
	extension TypeSerializer typeSerializer = new TypeSerializer;
	extension ExpressionSerializer expressionSerializer = new ExpressionSerializer;
	protected int decisionMethodCount = 0
	protected Map<Integer, CharSequence> decisionMethodMap = newHashMap
	protected final String DECISION_METHOD_NAME
	
	protected int conditionMethodCount = 0
	protected Map<Integer, CharSequence> conditionMethodMap = newHashMap
	protected final String CONDITION_METHOD_NAME
	
	protected int actionMethodCount = 0
	protected Map<Integer, CharSequence> actionMethodMap = newHashMap
	protected final String ACTION_METHOD_NAME
	
	new(String STRUCT_NAME) {
		super(STRUCT_NAME)
		DECISION_METHOD_NAME = "d"+STRUCT_NAME+"_"
		CONDITION_METHOD_NAME = "c"+STRUCT_NAME+"_"
		ACTION_METHOD_NAME = "a"+STRUCT_NAME+"_"
	}
	
	override serializeInitializingAction(XSTS xSts) {
		return '''
			«xSts.initializingAction.serialize»
			«xSts.initializingAction.writtenVariables.map[it.originalVariable].toSet.serializeFinalizationAssignments»
		'''
	}
	
	
	
	override CharSequence serializeChangeState(XSTS xSts) {
		val variableDeclarations = xSts.variableDeclarations.map[it.originalVariable].filter(VariableDeclaration).toSet
		return '''
			// Declaring temporary variables to avoid code duplication
			«FOR variableDeclaration : variableDeclarations»
				«variableDeclaration.type.serialize» «variableDeclaration.temporaryName» = «variableDeclaration.initialValue.serialize»;
			«ENDFOR»
			
			void changeState«STRUCT_NAME»(«STRUCT_NAME»* statechart) {
				// Initializing the temporary variables
				«variableDeclarations.serializeInitializationAssignments»
				«xSts.mergedAction.serialize»
				// Finalizing the actions
				«variableDeclarations.serializeFinalizationAssignments»
			}
			
			«serializeChangeStateAuxiliaryMethods»
			
			«serializeConditionAuxiliaryMethods»
			
			«serializeActionAuxiliaryMethods»
		'''
	}
	
	def dispatch CharSequence serialize(Action action) {
		throw new IllegalArgumentException("Not supported action: " + action)
	}
	
	def dispatch CharSequence serialize(AssignmentAction action) '''
		«action.serializeTemporaryAssignment» ««« Setting temporary variables, at the end there is serializeFinalizationAssignments
	'''
	
	def dispatch CharSequence serialize(NonDeterministicAction action) '''
		«action.serializeNonDeterministicAction»
	'''
	
	def dispatch CharSequence serialize(SequentialAction action) {
		val xStsSubactions = action.actions
		// Either all contained actions are NOT assume actions...
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
		'''
	}
	
	private def CharSequence serializeChangeStateAuxiliaryMethods() '''
		«FOR i : 0 ..< decisionMethodCount SEPARATOR System.lineSeparator»
			void «DECISION_METHOD_NAME»«i»(«STRUCT_NAME»* statechart) {
				«decisionMethodMap.get(i)»
			}
		«ENDFOR»
	'''
	
	private def CharSequence serializeConditionAuxiliaryMethods() '''
		«FOR i : 0 ..< conditionMethodCount SEPARATOR System.lineSeparator»
			bool «CONDITION_METHOD_NAME»«i»(«STRUCT_NAME»* statechart) {
				return «conditionMethodMap.get(i)»;
			}
		«ENDFOR»
	'''
	
	private def CharSequence serializeActionAuxiliaryMethods() '''
		«FOR i : 0 ..< actionMethodCount SEPARATOR System.lineSeparator»
			void «ACTION_METHOD_NAME»«i»(«STRUCT_NAME»* statechart) {
				«actionMethodMap.get(i)»
			}
		«ENDFOR»
	'''
	
	/** Needed because of too long methods */
	private def CharSequence serializeNonDeterministicAction(NonDeterministicAction action) {
		val INITIAL_CHANGE_STATE_METHOD_VALUE = decisionMethodCount
		val MAX_ACTION = 2048
		val ACTION_SIZE = action.actions.size
		val stringBuilder = new StringBuilder(10 * MAX_ACTION)
		for (var i = 0; i < ACTION_SIZE; i++) {
			if (i % MAX_ACTION == 0) {
				if (i != 0) {
					stringBuilder.append(System.lineSeparator + '''else «DECISION_METHOD_NAME»«decisionMethodCount + 1»();''')
					decisionMethodMap.put(decisionMethodCount++, stringBuilder.toString)
				}
				stringBuilder.length = 0
				stringBuilder.append('if ')
			}
			else {
				stringBuilder.append(System.lineSeparator + 'else if ')
			}
			val xStsSubaction = action.actions.get(i)
			stringBuilder.append('''(«xStsSubaction.getCondition.serializeExpression») «xStsSubaction.serializeAction»''')
		}
		decisionMethodMap.put(decisionMethodCount++, stringBuilder.toString)
		'''«DECISION_METHOD_NAME»«INITIAL_CHANGE_STATE_METHOD_VALUE»(«STRUCT_NAME»* statechart);'''
	}
	
	/** Needed because of too long methods */
	private def serializeExpression(Expression xStsExpression) {
		conditionMethodMap.put(conditionMethodCount, xStsExpression.serialize)
		return CONDITION_METHOD_NAME + conditionMethodCount++ + "(statechart)"
	}
	
	/** Needed because of too long methods */
	private def serializeAction(Action xStsSubaction) {
		actionMethodMap.put(actionMethodCount, xStsSubaction.serialize)
		return ACTION_METHOD_NAME + actionMethodCount++ + "(statechart);"
	}
	
	private def CharSequence serializeTemporaryAssignment(AssignmentAction action) {
		val declaration = action.lhs.declaration
		checkArgument(declaration instanceof VariableDeclaration)
		val variable = (declaration as VariableDeclaration).originalVariable
		return '''
			«variable.temporaryName» = «action.rhs.serialize»;
		'''
	}
	
	// Temporary variable handling
	
	private def CharSequence serializeInitializationAssignments(Set<? extends Declaration> variableDeclarations) '''
		«FOR variableDeclaration : variableDeclarations»
			«variableDeclaration.temporaryName» = statechart->«variableDeclaration.name»;
		«ENDFOR»
	'''
	
	private def CharSequence serializeFinalizationAssignments(Set<? extends Declaration> variableDeclarations) '''
		«FOR variableDeclaration : variableDeclarations»
			statechart->«variableDeclaration.name» = «variableDeclaration.temporaryName»;
		«ENDFOR»
	'''
	
		
	private def getTemporaryName(Declaration declaration) {
		return "__" + declaration.name + "__"
	}
	
	// Get conditions
	
	private def dispatch getCondition(Action action) {
		throw new IllegalArgumentException("Condition retrieval is supported only for
			NonDeterminsiticActions: " + action)
	}
	
	private def dispatch getCondition(SequentialAction action) {
		val firstXStsSubaction = action.actions.head
		checkArgument(firstXStsSubaction instanceof AssumeAction)
		val firstXStAssumeAction = firstXStsSubaction as AssumeAction
		return firstXStAssumeAction.assumption
	}
	
}