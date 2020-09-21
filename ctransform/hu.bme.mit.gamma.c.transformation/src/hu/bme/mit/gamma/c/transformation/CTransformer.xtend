package hu.bme.mit.gamma.c.transformation

import hu.bme.mit.gamma.xsts.model.XSTS
import org.eclipse.emf.ecore.resource.Resource
import hu.bme.mit.gamma.expression.model.EnumerationTypeDefinition
import hu.bme.mit.gamma.expression.model.TypeReference
import java.util.List
import java.util.ArrayList

class CTransformer {
	// Transformation-related extensions
	
	final extension TypeDeclarationSerializer typeDeclarationSerializer = new TypeDeclarationSerializer
	final extension VariableDiagnoser variableDiagnoser = new VariableDiagnoser
	final extension TypeSerializer typeSerializer = new TypeSerializer
	final extension InitialValueRetriever initialValueRetriever = new InitialValueRetriever
	final extension ExpressionSerializer expressionSerializer = new ExpressionSerializer
	final extension ActionSerializer actionSerializer;
	final extension CStatechartWrapperGenerator cStatechartWrapperGenerator;
	protected Resource resource

	
	protected XSTS xSts;
	
	protected boolean bareMetalIndicator = false;
	
	protected String model;
	protected String header;
	protected String headerName;
	protected String STRUCT_NAME;
	protected String wrapper;
	protected String wrapperHeader;
	protected String wrapperHeaderName;
	protected String temporaryIOName = "";
	protected List<String> publicHeaders = new ArrayList<String>();
	protected List<String> publicHeaderFileNames = new ArrayList<String>();
	protected List<String> ioStrings = new ArrayList<String>();
	protected List<String> nonTimeoutDeclarations = new ArrayList<String>();
	
	protected int decisionMethodCount = 0;
	protected int choiceMethodCount = 0;
	protected int actionMethodCount = 0;

	new(Resource resource, XSTS xSts, boolean bareMetalIndicator) {
		this.resource = resource
		// Create EMF scope and EMF IncQuery engine based on the resource
		this.xSts = xSts
		STRUCT_NAME = xSts.name.toFirstUpper + "Statemachine"
		actionSerializer = new CommonizedVariableActionSerializer(STRUCT_NAME)
		this.bareMetalIndicator = bareMetalIndicator;
		this.cStatechartWrapperGenerator = new CStatechartWrapperGenerator(this.xSts, bareMetalIndicator);
		// Create VIATRA Batch transformation

	}
	def getStructName(){
		return STRUCT_NAME
	}

	def execute(String headerName) {
		this.headerName = headerName
		model = '''
			#include <stdbool.h>
			#include <stdio.h>
			#include <stdlib.h>
			#include "«headerName»"
			«createStatechartWrapperHeader»
			«createStatechartWrapper()»
			«createHeader()»
			
			«IF actionSerializer instanceof InlinedChoiceActionSerializer»
				«actionSerializer.serializeTemporaryVariables(xSts)»
			«ENDIF»
			
			void reset«STRUCT_NAME»(«STRUCT_NAME»* statechart) {
			«««				Reference variables, e.g., enums, have to be set, as null is not a valid value, including regions: they have to be set to __Inactive__ explicitly on every reset
			«FOR enumVariable : (xSts.retrieveEnumVariables.reject[xSts.retrieveComponentParameters.toList.contains(it)])»
					statechart->«enumVariable.name» = «enumVariable.initialValue.serialize»;
			«ENDFOR»
				
				
				
				«xSts.serializeInitializingAction»
			}			
			
			
			«xSts.serializeChangeState»
			
			«IF actionSerializer instanceof InlinedChoiceActionSerializer»
				«IF actionSerializer.getChangeStateFinishedIndicator»
					«setDecisionCount(actionSerializer.getDecisionMethodCount)»
					«setChoiceCount(actionSerializer.getConditionMethodCount)»
					«setActionCount(actionSerializer.getActionMethodCount)»
				«ENDIF»
			«ENDIF»
			

			
«««			«FOR variable : xSts.variableGroups
«««								.map[it.variables]
«««								.flatten SEPARATOR System.lineSeparator»
«««				void set«variable.name.toFirstUpper»«STRUCT_NAME»(«STRUCT_NAME»* statechart,«variable.type.serialize» «variable.name») {
«««					statechart->«variable.name» = «variable.name»;
«««				}
«««							
«««				«variable.type.serialize» get«variable.name.toFirstUpper»«STRUCT_NAME»(«STRUCT_NAME»* statechart) {
«««					return statechart->«variable.name»;
«««				}
«««			«ENDFOR»
			
			
			void clearOutEvents«STRUCT_NAME»(«STRUCT_NAME»* statechart){
					«FOR event : xSts.retrieveOutEvents»
						statechart->«event.name» = false;
					«ENDFOR»
					«««				Clearing transient event parameters
					«FOR transientOutParameter : xSts.retrieveOutEventParameters.filter[xSts.transientVariables.contains(it)]»
						statechart->«transientOutParameter.name» = «transientOutParameter.initialValue.serialize»;
					«ENDFOR»
			}
				
			void clearInEvents«STRUCT_NAME»(«STRUCT_NAME»* statechart){
				«FOR event : xSts.retrieveInEvents»
						statechart->«event.name» = false;
				«ENDFOR»
					«««				Clearing transient event parameters
				«FOR transientInParameter : xSts.retrieveOutEventParameters.filter[xSts.transientVariables.contains(it)]»
						statechart->«transientInParameter.name» = «transientInParameter.initialValue.serialize»;
				«ENDFOR»
			}
				
				
			void runCycle«STRUCT_NAME»(«STRUCT_NAME»* statechart){
				clearOutEvents«STRUCT_NAME»(statechart);
				changeState«STRUCT_NAME»(statechart);
				clearInEvents«STRUCT_NAME»(statechart);
			}
				
			«IF actionSerializer instanceof InlinedChoiceActionSerializer»
				«IF actionSerializer.getChangeStateFinishedIndicator»
					«nonTimeoutDeclarations.clear()»
					«createHeader()»
				«ENDIF»
			«ENDIF»
			
		'''
	}
	
	def void setDecisionCount(int decision){
		decisionMethodCount = decision;
	}
	def void setChoiceCount(int choice){
		choiceMethodCount = choice;
	}
	def void setActionCount(int action){
		actionMethodCount = action;
	}
	
	def void createStatechartWrapper(){
		wrapper = createWrapper(STRUCT_NAME, headerName, wrapperHeaderName)
	}
	
	def void createStatechartWrapperHeader(){
		wrapperHeader = createWrapperHeader(STRUCT_NAME, headerName)
	}
	
	def getWrapper(){
		return wrapper;
	}
	
	def getModel(){
		return model;
	}
	
	def getHeader(){
		return header;
	}
	
	def getWrapperHeader(){
		return wrapperHeader;
	}
	
	def void putStringInIOList(String string){
		ioStrings.add(string);
	}
	def void assignStringToTempIO(String string){
		temporaryIOName = string;
	}
	
	def void addNonTimeout(String string){
		nonTimeoutDeclarations.add(string)
	}
	
	def void createHeader(){
		header = '''
			«FOR typeDeclarations: xSts.publicTypeDeclarations»
				#include "«typeDeclarations.name».h"
			«ENDFOR»
			#include <stdbool.h>
			#ifndef «STRUCT_NAME.toUpperCase»_HEADER
			#define «STRUCT_NAME.toUpperCase»_HEADER
			
«««			«FOR typeDeclarations: xSts.publicTypeDeclarations»
«««				«typeDeclarations.serialize»
	«««		«ENDFOR»
			«publicTypeDeclarationsHeader()»
			
			typedef struct «STRUCT_NAME»{
				«FOR typeDeclaration : xSts.privateTypeDeclarations»
					«typeDeclaration.serialize»
				«ENDFOR»
							
				«FOR variableDeclaration : xSts.retrieveNotTimeoutVariables»
					«IF !(nonTimeoutDeclarations.contains(variableDeclaration.type.serialize+variableDeclaration.name))»
						«variableDeclaration.type.serialize» «variableDeclaration.name»;
						«addNonTimeout(variableDeclaration.type.serialize+variableDeclaration.name)»
					«ENDIF»
				«ENDFOR»
							
				«FOR variableDeclaration : xSts.retrieveTimeouts»
					«variableDeclaration.type.serialize» «variableDeclaration.name»;
				«ENDFOR»
							
			}«STRUCT_NAME»;
			
			«««void «STRUCT_NAME»InitEventParameters(«STRUCT_NAME»* statechart, «FOR parameter : xSts.retrieveComponentParameters SEPARATOR ', '»«parameter.type.serialize» «parameter.name»«ENDFOR»);
			
			void reset«STRUCT_NAME»(«STRUCT_NAME»* statechart);
			
			
			void changeState«STRUCT_NAME»(«STRUCT_NAME»* statechart);
			
			void clearOutEvents«STRUCT_NAME»(«STRUCT_NAME»* statechart);
			void clearInEvents«STRUCT_NAME»(«STRUCT_NAME»* statechart);
			
			void runCycle«STRUCT_NAME»(«STRUCT_NAME»* statechart);
			
			«IF actionSerializer instanceof InlinedChoiceActionSerializer»
				«IF actionSerializer.getChangeStateFinishedIndicator»
					«FOR i : 0 ..< actionMethodCount»
						void «actionSerializer.getActionMethodName»«i»(«STRUCT_NAME»* statechart);
					«ENDFOR»
					
					«FOR i : 0 ..< choiceMethodCount»
						bool «actionSerializer.getConditionMethodName»«i»(«STRUCT_NAME»* statechart);
					«ENDFOR»
					
					«FOR i : 0 ..< decisionMethodCount»
						void «actionSerializer.getDecisionMethodName»«i»(«STRUCT_NAME»* statechart);
					«ENDFOR»
				«ENDIF»
			«ENDIF»
			
			
			#endif /* «STRUCT_NAME.toUpperCase»_HEADER */
			
			
			/*
			void testOutput«STRUCT_NAME»(«STRUCT_NAME»* statechart){
				printf("\n");						
				«FOR variableDeclaration : xSts.retrieveNotTimeoutVariables»
						printf("«variableDeclaration.name»: %d\n", statechart->«variableDeclaration.name»);
				«ENDFOR»
				printf("\n");							
				«FOR variableDeclaration : xSts.retrieveTimeouts»
						printf("«variableDeclaration.name»: %d\n", statechart->«variableDeclaration.name»);
				«ENDFOR»
				printf("\n");
			}
			
			*/
		'''
	}
	
	
	private def void publicTypeDeclarationsHeader(){
		for(typeDeclaration: xSts.publicTypeDeclarations){
			publicHeaders.add('''
			#ifndef «typeDeclaration.name.toUpperCase»
			#define «typeDeclaration.name.toUpperCase»
			«typeDeclaration.serialize»
			#endif /* «typeDeclaration.name.toUpperCase» */
			''')
			publicHeaderFileNames.add(typeDeclaration.name)
		}
	}
	
	def getPublicHeaders(){
		return publicHeaders;
	}
	
	def getPublicHeaderFileNames(){
		return publicHeaderFileNames;
	}
	
	def setWrapperHeaderName(String wrapperHeaderName){
		this.wrapperHeaderName = wrapperHeaderName
	}
	
	private def getPrivateTypeDeclarations(XSTS xSts) {
		val privateTypeDeclarations = newArrayList
		privateTypeDeclarations += xSts.typeDeclarations
		privateTypeDeclarations -= xSts.publicTypeDeclarations
		return privateTypeDeclarations
	}


}