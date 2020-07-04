package hu.bme.mit.gamma.c.transformation

import hu.bme.mit.gamma.statechart.model.StatechartDefinition
import hu.bme.mit.gamma.xsts.model.model.XSTS

class CStatechartWrapperGenerator {
	//final StatechartDefinition gammaStatechart
	final XSTS xSts
	
	new(XSTS xSts/* , StatechartDefinition gammaStatechart*/){
		this.xSts = xSts
		//this.gammaStatechart = gammaStatechart
	}
	
	def createWrapper(String STRUCT_NAME, String header){
		return  '''
			#include <sys/time.h>
			#include "«header»"
			
			typedef struct Wrapped«STRUCT_NAME»{
				«STRUCT_NAME» «STRUCT_NAME.toFirstLower»;
				struct timeval startTimeval, elapsedTimeval;
			}Wrapped«STRUCT_NAME»;
			
			void set«STRUCT_NAME»Statechart(Wrapped«STRUCT_NAME» wrappedStatechart, «STRUCT_NAME»* statechart){
				wrappedStatechart.«STRUCT_NAME.toFirstLower» = statechart;
			}
			
			
			void executeStep«STRUCT_NAME»(Wrapped«STRUCT_NAME»* wrappedStatechart){
				gettimeofday(&(wrappedStatechart->elapsedTimeval), NULL);
				long elapsedTime = (((wrappedStatechart->elapsedTimeval.tv_sec - wrappedStatechart->startTimeval.tv_sec) * 1000000 + wrappedStatechart->elapsedTimeval.tv_usec - wrappedStatechart->startTimeval.tv_usec)/1000);
				«FOR timeout : xSts.clockVariables»
					set«timeout.name.toFirstUpper»(&(wrappedStatechart->«STRUCT_NAME.toFirstLower»), get«timeout.name.toFirstUpper»(&(wrappedStatechart->«STRUCT_NAME.toFirstLower»)) + elapsedTime);
				«ENDFOR»
				runCycle«STRUCT_NAME»(&(wrappedStatechart->«STRUCT_NAME.toFirstLower»));
				gettimeofday(&(wrappedStatechart->startTimeval), NULL);
			}
			
			void wrappedReset«STRUCT_NAME»(Wrapped«STRUCT_NAME»* wrappedStatechart){
				reset«STRUCT_NAME»(&(wrappedStatechart->«STRUCT_NAME.toFirstLower»));
				gettimeofday(&(wrappedStatechart->startTimeval), NULL);
			}
			
		'''
	}

}