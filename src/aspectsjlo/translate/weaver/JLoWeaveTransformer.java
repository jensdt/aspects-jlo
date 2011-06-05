package aspectsjlo.translate.weaver;

import java.util.List;

import aspectsjava.translate.weaver.elementweaver.cast.CastWeaver;
import aspectsjava.translate.weaver.elementweaver.catchclause.CatchClauseWeaver;
import aspectsjava.translate.weaver.elementweaver.fieldaccess.FieldReadWeaver;
import aspectsjava.translate.weaver.elementweaver.methodinvocation.MethodInvocationWeaver;
import aspectsjlo.translate.weaver.elementweaver.subobjectread.SubobjectReadWeaver;
import chameleon.aspects.weaver.WeaveTransformer;
import chameleon.aspects.weaver.Weaver;
import chameleon.core.expression.MethodInvocation;
import chameleon.core.expression.NamedTargetExpression;
import chameleon.core.reference.CrossReferenceWithTarget;
import chameleon.core.statement.Block;
import chameleon.core.statement.Statement;
import chameleon.support.expression.ClassCastExpression;

public class JLoWeaveTransformer extends WeaveTransformer {

	@Override
	protected Weaver initialiseWeavers() {
		// Initiate the weavers
		Weaver<MethodInvocation, MethodInvocation> methodInvocationWeaver = new MethodInvocationWeaver();
		Weaver<Block, List<Statement>> catchClauseWeaver = new CatchClauseWeaver();
		Weaver<NamedTargetExpression, MethodInvocation> fieldWeaver = new FieldReadWeaver();
		Weaver<ClassCastExpression, MethodInvocation> castWeaver = new CastWeaver();
		Weaver<CrossReferenceWithTarget, MethodInvocation> subobjectreadWeaver = new SubobjectReadWeaver();
		
		methodInvocationWeaver.setNext(catchClauseWeaver);
		catchClauseWeaver.setNext(fieldWeaver);
		fieldWeaver.setNext(castWeaver);
		castWeaver.setNext(subobjectreadWeaver);
		
		return methodInvocationWeaver;
	}

}
