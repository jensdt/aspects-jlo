package aspectsjlo.model.advice.transformation.subobjectread;

import java.util.List;

import jnome.core.language.Java;
import chameleon.aspects.WeavingEncapsulator;
import chameleon.aspects.advice.AdviceReturnStatement;
import chameleon.aspects.advice.types.ProceedCall;
import chameleon.core.expression.Expression;
import chameleon.core.lookup.LookupException;
import chameleon.core.statement.Block;
import chameleon.oo.type.BasicTypeReference;
import chameleon.oo.type.Type;
import chameleon.support.expression.ClassCastExpression;
import chameleon.support.expression.NullLiteral;
import chameleon.support.member.simplename.method.RegularMethodInvocation;
import chameleon.support.statement.ReturnStatement;

public class AroundSubobjectRead extends SubobjectReadTransformationProvider {
	@Override
	protected Block getBody(WeavingEncapsulator next) {
		Block adviceBody = getAdvice().body().clone();
		
		// Replace each proceed call to the method call
		List<ProceedCall> proceedCalls = adviceBody.descendants(ProceedCall.class);
		
		for (ProceedCall pc : proceedCalls) {
			RegularMethodInvocation<?> getValueInvocation = getNextInvocation(next);
				
			Expression<?> reflectiveCallInvocation = null;
			// Note that if the return type is a primitive, we first have to cast the primitive to its boxed variant, then cast to the actual type
			try {
				Type type = getAdvice().actualReturnType().getType();
				Java java = (Java) getAdvice().language(Java.class);
				
				if (type.isTrue(java.property("primitive")))
					reflectiveCallInvocation = new ClassCastExpression(new BasicTypeReference<BasicTypeReference<?>>(java.box(type).getFullyQualifiedName()), getValueInvocation);
				else
					reflectiveCallInvocation = getValueInvocation;
				
				pc.parentLink().getOtherRelation().replace(pc.parentLink(), reflectiveCallInvocation.parentLink());
			} catch (LookupException e) {
				System.out.println("Error while getting advice type");
			}		
		}
		
		try {
			Type type = getAdvice().actualReturnType().getType();
			if (type.signature().name().equals("void"))
				// We need an explicit return because the return type of the advice method is never 'void'
				adviceBody.addStatement(new ReturnStatement(new NullLiteral()));
		} catch (LookupException e) {
			System.out.println("Error while getting advice type");
		}
		
		
		return adviceBody;
	}
}
