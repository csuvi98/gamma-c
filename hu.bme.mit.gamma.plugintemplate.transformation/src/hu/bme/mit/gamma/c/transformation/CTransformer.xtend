package hu.bme.mit.gamma.c.transformation

import hu.bme.mit.gamma.xsts.model.model.XSTS
import org.eclipse.emf.ecore.resource.Resource

class CTransformer {
	// Transformation-related extensions
	
	final extension TypeDeclarationSerializer typeDeclarationSerializer = new TypeDeclarationSerializer
	final extension VariableDiagnoser variableDiagnoser = new VariableDiagnoser
	final extension TypeSerializer typeSerializer = new TypeSerializer
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
			
			public «STRUCT_NAME»(«FOR parameter : xSts.retrieveComponentParameters SEPARATOR ', '»«parameter.type.serialize» «parameter.name»«ENDFOR») {
				«FOR parameter : xSts.retrieveComponentParameters»
					this.«parameter.name» = «parameter.name»;
				«ENDFOR»
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
