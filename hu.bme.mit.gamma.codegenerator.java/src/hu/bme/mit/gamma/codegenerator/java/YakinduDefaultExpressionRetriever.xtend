package hu.bme.mit.gamma.codegenerator.java

import org.yakindu.base.types.Type

class YakinduDefaultExpressionRetriever {
	
	def getDefaultExpression(Type yakinduType) {
		val typeName = yakinduType.name
		switch (typeName) {
			case "boolean": 
				return "false"
			case "integer": 
				return "0"
			case "string": 
				return ""
			case "real": 
				return "0"
			default:
				throw new IllegalArgumentException("Not supported type: " + typeName)
		}
	}
	
}