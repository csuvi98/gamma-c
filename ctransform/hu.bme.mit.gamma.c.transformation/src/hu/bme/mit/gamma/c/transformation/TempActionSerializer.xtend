package hu.bme.mit.gamma.c.transformation

import hu.bme.mit.gamma.expression.model.ExpressionModelFactory
import hu.bme.mit.gamma.expression.util.ExpressionUtil
import hu.bme.mit.gamma.util.GammaEcoreUtil
import hu.bme.mit.gamma.xsts.model.XSTS

abstract class TempActionSerializer {
	
	protected final extension ExpressionUtil expressionUtil = ExpressionUtil.INSTANCE
	protected final extension GammaEcoreUtil ecoreUtil = GammaEcoreUtil.INSTANCE
	protected final extension ExpressionModelFactory expressionModelFactory = ExpressionModelFactory.eINSTANCE
	
	abstract def CharSequence serializeInitializingAction(XSTS xSts)
	abstract def CharSequence serializeChangeState(XSTS xSts, String STRUCT_NAME)
}