package aspectsjlo.model.advice.transformation.subobjectread;

import chameleon.aspects.WeavingEncapsulator;
import chameleon.core.statement.Block;
import chameleon.support.member.simplename.method.RegularMethodInvocation;
import chameleon.support.statement.ReturnStatement;

public class BeforeSubobjectRead extends SubobjectReadTransformationProvider {
	public Block getBody(WeavingEncapsulator next) {
		Block adviceBody = new Block();

		/*
		 *	Add the advice-body itself 
		 */
		adviceBody.addBlock(getAdvice().body().clone());
		
		/*
		 *	Create the proceed call
		 */
		RegularMethodInvocation<?> getValueInvocation = getNextInvocation(next);
		
		/*
		 * 	Add the return statement
		 */
		adviceBody.addStatement(new ReturnStatement(getValueInvocation));
		
		return adviceBody;
	}
}
