package hu.bme.mit.gamma.c.transformation

import hu.bme.mit.gamma.expression.model.BooleanTypeDefinition
import hu.bme.mit.gamma.expression.model.ExpressionModelFactory
import hu.bme.mit.gamma.expression.model.DecimalTypeDefinition
import hu.bme.mit.gamma.expression.model.EnumerationTypeDefinition
import hu.bme.mit.gamma.expression.model.Expression
import hu.bme.mit.gamma.expression.model.IntegerTypeDefinition
import hu.bme.mit.gamma.expression.model.RationalTypeDefinition
import hu.bme.mit.gamma.expression.model.Type
import hu.bme.mit.gamma.expression.model.TypeReference
import hu.bme.mit.gamma.expression.model.VariableDeclaration
import java.math.BigDecimal
import java.math.BigInteger
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil.Copier

class InitialValueRetriever {
	// Auxiliary objects
	protected final extension ExpressionModelFactory constraintModelFactory = ExpressionModelFactory.eINSTANCE
	
	def getInitialValue(VariableDeclaration variableDeclaration) {
		val initialValue = variableDeclaration.expression
		if (initialValue !== null) {
			return initialValue.clone
		}
		val type = variableDeclaration.type
		return type.initialValueOfType
	} 
	
	def dispatch Expression getInitialValueOfType(Type type) {
		throw new IllegalArgumentException("Not supported expression: " + type)
	}
	
	def dispatch Expression getInitialValueOfType(TypeReference type) {
		return type.reference.type.initialValueOfType
	}
	
	def dispatch Expression getInitialValueOfType(BooleanTypeDefinition type) {
		return createFalseExpression
	}
	
	def dispatch Expression getInitialValueOfType(IntegerTypeDefinition type) {
		return createIntegerLiteralExpression => [
			it.value = BigInteger.ZERO
		]
	}
	
	def dispatch Expression getInitialValueOfType(DecimalTypeDefinition type) {
		return createDecimalLiteralExpression => [
			it.value = BigDecimal.ZERO
		]
	}
	
	def dispatch Expression getInitialValueOfType(RationalTypeDefinition type) {
		return createRationalLiteralExpression => [
			it.numerator = BigInteger.ZERO
			it.denominator = BigInteger.ONE
		]
	}
	
	def dispatch Expression getInitialValueOfType(EnumerationTypeDefinition type) {
		return createEnumerationLiteralExpression => [
			it.reference = type.literals.head 
		]
	}
	
	private def <T extends EObject> T clone(T element) {
		// A new copier should be used every time, otherwise anomalies happen (references are changed without asking)
		val copier = new Copier(true, true)
		val clone = copier.copy(element) as T
		copier.copyReferences()
		return clone
	}
}