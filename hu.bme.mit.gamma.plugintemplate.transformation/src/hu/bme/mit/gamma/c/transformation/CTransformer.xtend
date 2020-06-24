package hu.bme.mit.gamma.c.transformation

import hu.bme.mit.gamma.xsts.model.model.XSTS
import org.eclipse.emf.ecore.resource.Resource
import hu.bme.mit.gamma.expression.model.EnumerationTypeDefinition
import hu.bme.mit.gamma.expression.model.TypeReference

class CTransformer {
	// Transformation-related extensions
	
	final extension TypeDeclarationSerializer typeDeclarationSerializer = new TypeDeclarationSerializer
	final extension VariableDiagnoser variableDiagnoser = new VariableDiagnoser
	final extension TypeSerializer typeSerializer = new TypeSerializer
	final extension InitialValueRetriever initialValueRetriever = new InitialValueRetriever
	final extension ExpressionSerializer expressionSerializer = new ExpressionSerializer
	final extension ActionSerializer actionSerializer = new ActionSerializer
	protected Resource resource

	protected Trace trace
	
	protected XSTS xSts;
	
	protected String model;
	protected String STRUCT_NAME;

	new(Resource resource, XSTS xSts) {
		this.resource = resource
		// Create EMF scope and EMF IncQuery engine based on the resource
		this.xSts = xSts
		STRUCT_NAME = xSts.name.toFirstUpper + "Statemachine"
		
		this.trace = null
		// Create VIATRA Batch transformation
	}

	def execute() {
		
		model = '''
			#include <stdbool.h>
			#include <stdio.h>
			#include <stdlib.h>
			
			typedef struct «STRUCT_NAME»{
				«FOR typeDeclaration : xSts.privateTypeDeclarations»
					«typeDeclaration.serialize»
				«ENDFOR»
				
				«FOR variableDeclaration : xSts.retrieveNotTimeoutVariables»
					 «variableDeclaration.type.serialize» «variableDeclaration.name»;
				«ENDFOR»
				
				«FOR variableDeclaration : xSts.retrieveTimeouts»
					 «variableDeclaration.type.serialize» «variableDeclaration.name»;
				«ENDFOR»
				
				
			}«STRUCT_NAME»;
			
			/*public «STRUCT_NAME»(«FOR parameter : xSts.retrieveComponentParameters SEPARATOR ', '»«parameter.type.serialize» «parameter.name»«ENDFOR») {
				«FOR parameter : xSts.retrieveComponentParameters»
					this.«parameter.name» = «parameter.name»;
				«ENDFOR»
			}*/
			
			void reset(«STRUCT_NAME»* statechart) {
			«««				Reference variables, e.g., enums, have to be set, as null is not a valid value, including regions: they have to be set to __Inactive__ explicitly on every reset
				«FOR enumVariable : (xSts.retrieveEnumVariables.reject[xSts.retrieveComponentParameters.toList.contains(it)])»
						statechart->«enumVariable.name» = «enumVariable.initialValue.serialize»;
				«ENDFOR»
				
				/*clearOutEvents();
				clearInEvents();*/
				
				«««FOR variableDeclaration : xSts.retrieveNotTimeoutVariables»
					«««IF variableDeclaration.type instanceof TypeReference»
					«««int «variableDeclaration.name»;
					«««ELSE»
					«««variableDeclaration.type.serialize» «variableDeclaration.name»;
					«««ENDIF»
				«««ENDFOR»
								
				«««FOR variableDeclaration : xSts.retrieveTimeouts»
					«««variableDeclaration.type.serialize» «variableDeclaration.name»;
				«««ENDFOR»
				
				«xSts.serializeInitializingAction»
			}
			
				void clearOutEvents(«STRUCT_NAME»* statechart){
					«FOR event : xSts.retrieveOutEvents»
						statechart->«event.name» = false;
					«ENDFOR»
					«««				Clearing transient event parameters
					«FOR transientOutParameter : xSts.retrieveOutEventParameters.filter[xSts.transientVariables.contains(it)]»
						«transientOutParameter.name» = «transientOutParameter.initialValue.serialize»;
					«ENDFOR»
				}
				
				void clearInEvents(«STRUCT_NAME»* statechart){
					«FOR event : xSts.retrieveInEvents»
						statechart->«event.name» = false;
					«ENDFOR»
					«««				Clearing transient event parameters
					«FOR transientOutParameter : xSts.retrieveOutEventParameters.filter[xSts.transientVariables.contains(it)]»
						«transientOutParameter.name» = «transientOutParameter.initialValue.serialize»;
					«ENDFOR»
				}
				«xSts.serializeChangeState(STRUCT_NAME)»
				
				void runCycle(«STRUCT_NAME»* statechart){
					clearOutEvents(statechart);
					changeState(statechart);
					clearInEvents(statechart);
				}
			
			
		'''
	}
	
	def getModel(){
		return model;
	}
	
	
	private def getPrivateTypeDeclarations(XSTS xSts) {
		val privateTypeDeclarations = newArrayList
		privateTypeDeclarations += xSts.typeDeclarations
		privateTypeDeclarations -= xSts.publicTypeDeclarations
		return privateTypeDeclarations
	}


}
