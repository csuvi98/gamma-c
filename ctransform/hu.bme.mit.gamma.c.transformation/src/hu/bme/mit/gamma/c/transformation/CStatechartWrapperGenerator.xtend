package hu.bme.mit.gamma.c.transformation

import hu.bme.mit.gamma.xsts.model.XSTS

class CStatechartWrapperGenerator {
	//final StatechartDefinition gammaStatechart
	final XSTS xSts
	protected String STRUCT;
	protected boolean bareMetalIndicator;
	
	new(XSTS xSts, boolean bareMetalIndicator){
		this.xSts = xSts
		this.bareMetalIndicator = bareMetalIndicator;
	}
	
	def createWrapperHeader(String STRUCT_NAME, String header){
		STRUCT = STRUCT_NAME
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

			#include "«header»"
			#include "«wrapperHeader»"
			«IF bareMetalIndicator»
				#include "time.h"
				
				long clk = 0;
			«ELSE»
				#include <sys/time.h>
			«ENDIF»			
			
			void set«STRUCT_NAME»Statechart(«STRUCT_NAME»Wrapper wrappedStatechart, «STRUCT_NAME»* statechart){
				wrappedStatechart.«STRUCT_NAME.toFirstLower» = *statechart;
			}
			
			
			void executeStep«STRUCT_NAME»(«STRUCT_NAME»Wrapper* wrappedStatechart){
				«createTiming()»
			}
			
			void wrappedReset«STRUCT_NAME»(«STRUCT_NAME»Wrapper* wrappedStatechart){
				reset«STRUCT_NAME»(&(wrappedStatechart->«STRUCT_NAME.toFirstLower»));
				gettimeofday(&(wrappedStatechart->startTimeval), NULL);
			}
			
		'''
	}
	
	def createTiming(){
		if(bareMetalIndicator == false){
			return'''
				gettimeofday(&(wrappedStatechart->elapsedTimeval), NULL);
				long elapsedTime = (((wrappedStatechart->elapsedTimeval.tv_sec - wrappedStatechart->startTimeval.tv_sec) * 1000000 + wrappedStatechart->elapsedTimeval.tv_usec - wrappedStatechart->startTimeval.tv_usec)/1000);
				«FOR timeout : xSts.clockVariables»
					wrappedStatechart->«STRUCT.toFirstLower».«timeout.name» = wrappedStatechart->«STRUCT.toFirstLower».«timeout.name» + elapsedTime;
				«ENDFOR»
				runCycle«STRUCT»(&(wrappedStatechart->«STRUCT.toFirstLower»));
				gettimeofday(&(wrappedStatechart->startTimeval), NULL);
			'''
		}else{
			return'''
				if(clk == CLOCKS_PER_SEC*1000 - 1){
				«FOR timeout : xSts.clockVariables»
					wrappedStatechart->«STRUCT.toFirstLower».«timeout.name» = wrappedStatechart->«STRUCT.toFirstLower».«timeout.name» + 1;
					clk = 0;
				«ENDFOR»
				}else{
					clk++;
				}
				runCycle«STRUCT»(&(wrappedStatechart->«STRUCT.toFirstLower»));
			'''
		}
	}

}