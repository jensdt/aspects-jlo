package aspectsjlo.model.advice.weaving.subobjectread;

import java.util.ArrayList;
import java.util.List;

import aspectsjava.model.advice.weaving.TargetedAdviceMethodProvider;
import chameleon.aspects.advice.Advice;
import chameleon.aspects.namingRegistry.NamingRegistry;
import chameleon.aspects.namingRegistry.NamingRegistryFactory;
import chameleon.aspects.pointcut.expression.MatchResult;
import chameleon.core.declaration.Declaration;
import chameleon.core.element.Element;
import chameleon.core.expression.Expression;
import chameleon.core.expression.NamedTarget;
import chameleon.core.expression.NamedTargetExpression;
import chameleon.core.lookup.LookupException;
import chameleon.core.reference.CrossReferenceWithTarget;

public class DefaultSubobjectRead extends TargetedAdviceMethodProvider<CrossReferenceWithTarget> {
	
	@Override
	protected String getName(Advice advice, MatchResult<CrossReferenceWithTarget> joinpoint) throws LookupException {
		NamingRegistry<Advice> adviceNamingRegistry = NamingRegistryFactory.instance().getNamingRegistryFor("advice");
		NamingRegistry<Declaration> methodNamingRegistry = NamingRegistryFactory.instance().getNamingRegistryFor("componentrelation");
		
		Declaration component = joinpoint.getJoinpoint().getElement();
		
		return "advice_" + adviceNamingRegistry.getName(advice) + "_" + methodNamingRegistry.getName(component);
	}

	
	@Override
	protected List<Expression> getParameters(Advice advice,	MatchResult<CrossReferenceWithTarget> joinpoint) throws LookupException {
		List<Expression> parameters = new ArrayList<Expression>();
		
		Element target = getTarget(joinpoint).clone();
		
		Expression reference = null;
		if (target instanceof Expression)
			reference = (Expression) target.clone();
		else if (target instanceof NamedTarget)
			reference = new NamedTargetExpression(((NamedTarget) target).name());

		
		parameters.add(reference);
		parameters.add(getSelf(joinpoint));
		
		return parameters;
	}

}
