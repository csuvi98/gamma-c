package hu.bme.mit.gamma.c.transformation

import hu.bme.mit.gamma.xsts.model.XSTS

class CStatechartWrapperGenerator {
	//final StatechartDefinition gammaStatechart
	final XSTS xSts
	
	new(XSTS xSts/* , StatechartDefinition gammaStatechart*/){
		this.xSts = xSts
		//this.gammaStatechart = gammaStatechart
	}
	
	def createWrapperHeader(String STRUCT_NAME, String header){
		return'''
			#include <sys/time.h>
			#ifndef «STRUCT_NAME.toUpperCase»WRAPPER_HEADER
			#define «STRUCT_NAME.toUpperCase»WRAPPER_HEADER
			
			typedef struct «STRUCT_NAME»Wrapper{
				«STRUCT_NAME» «STRUCT_NAME.toFirstLower»;
				struct timeval startTimeval, elapsedTimeval;
			}«STRUCT_NAME»Wrapper;
			
			void set«STRUCT_NAME»Statechart(«STRUCT_NAME»Wrapper wrappedStatechart, «STRUCT_NAME»* statechart);
			
			void executeStep«STRUCT_NAME»(«STRUCT_NAME»Wrapper* wrappedStatechart);
			
			void wrappedReset«STRUCT_NAME»(«STRUCT_NAME»Wrapper* wrappedStatechart);
			
			#endif /* «STRUCT_NAME.toUpperCase»WRAPPER_HEADER */
		'''
	}
	
	def createWrapper(String STRUCT_NAME, String header, String wrapperHeader){
		return  '''
			#include <sys/time.h>
			#include "«header»"
			#include "«wrapperHeader»"
			
			
			void set«STRUCT_NAME»Statechart(«STRUCT_NAME»Wrapper wrappedStatechart, «STRUCT_NAME»* statechart){
				wrappedStatechart.«STRUCT_NAME.toFirstLower» = *statechart;
			}
			
			
			void executeStep«STRUCT_NAME»(«STRUCT_NAME»Wrapper* wrappedStatechart){
				gettimeofday(&(wrappedStatechart->elapsedTimeval), NULL);
				long elapsedTime = (((wrappedStatechart->elapsedTimeval.tv_sec - wrappedStatechart->startTimeval.tv_sec) * 1000000 + wrappedStatechart->elapsedTimeval.tv_usec - wrappedStatechart->startTimeval.tv_usec)/1000);
				«FOR timeout : xSts.clockVariables»
					wrappedStatechart->«STRUCT_NAME.toFirstLower».«timeout.name» = wrappedStatechart->«STRUCT_NAME.toFirstLower».«timeout.name» + elapsedTime;
«««					set«timeout.name.toFirstUpper»«STRUCT_NAME»(&(wrappedStatechart->«STRUCT_NAME.toFirstLower»), get«timeout.name.toFirstUpper»«STRUCT_NAME»(&(wrappedStatechart->«STRUCT_NAME.toFirstLower»)) + elapsedTime);
				«ENDFOR»
				runCycle«STRUCT_NAME»(&(wrappedStatechart->«STRUCT_NAME.toFirstLower»));
				gettimeofday(&(wrappedStatechart->startTimeval), NULL);
			}
			
			void wrappedReset«STRUCT_NAME»(«STRUCT_NAME»Wrapper* wrappedStatechart){
				reset«STRUCT_NAME»(&(wrappedStatechart->«STRUCT_NAME.toFirstLower»));
				gettimeofday(&(wrappedStatechart->startTimeval), NULL);
			}
			
		'''
	}

}