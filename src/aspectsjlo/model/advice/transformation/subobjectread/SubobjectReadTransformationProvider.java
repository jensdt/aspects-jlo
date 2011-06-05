package aspectsjlo.model.advice.transformation.subobjectread;

import java.util.ArrayList;
import java.util.List;

import jnome.core.expression.invocation.JavaMethodInvocation;
import jnome.core.type.BasicJavaTypeReference;
import subobjectjava.model.component.ComponentRelation;
import subobjectjava.translate.JavaTranslator;
import aspectsjava.model.advice.transformation.CreateAdviceMethodTransformationProvider;
import aspectsjava.model.advice.transformation.runtime.AdviceMethodCoordinator;
import aspectsjava.model.advice.transformation.runtime.transformationprovider.RuntimeAnd;
import aspectsjava.model.advice.transformation.runtime.transformationprovider.RuntimeIfCheck;
import aspectsjava.model.advice.transformation.runtime.transformationprovider.RuntimeNot;
import aspectsjava.model.advice.transformation.runtime.transformationprovider.RuntimeOr;
import aspectsjava.model.advice.transformation.runtime.transformationprovider.RuntimeTypeCheck;
import aspectsjava.model.advice.transformation.runtime.transformationprovider.parameterexposure.TypeParameterExposure;
import chameleon.aspects.WeavingEncapsulator;
import chameleon.aspects.advice.Advice;
import chameleon.aspects.advice.runtimetransformation.Coordinator;
import chameleon.aspects.advice.runtimetransformation.transformationprovider.RuntimeExpressionProvider;
import chameleon.aspects.advice.runtimetransformation.transformationprovider.RuntimeParameterExposureProvider;
import chameleon.aspects.namingRegistry.NamingRegistry;
import chameleon.aspects.namingRegistry.NamingRegistryFactory;
import chameleon.aspects.pointcut.expression.MatchResult;
import chameleon.aspects.pointcut.expression.PointcutExpression;
import chameleon.aspects.pointcut.expression.dynamicexpression.IfPointcutExpression;
import chameleon.aspects.pointcut.expression.dynamicexpression.ParameterExposurePointcutExpression;
import chameleon.aspects.pointcut.expression.dynamicexpression.TargetTypePointcutExpression;
import chameleon.aspects.pointcut.expression.dynamicexpression.ThisTypePointcutExpression;
import chameleon.aspects.pointcut.expression.dynamicexpression.TypePointcutExpression;
import chameleon.aspects.pointcut.expression.generic.PointcutExpressionAnd;
import chameleon.aspects.pointcut.expression.generic.PointcutExpressionNot;
import chameleon.aspects.pointcut.expression.generic.PointcutExpressionOr;
import chameleon.aspects.pointcut.expression.generic.RuntimePointcutExpression;
import chameleon.core.declaration.Declaration;
import chameleon.core.element.Element;
import chameleon.core.expression.Expression;
import chameleon.core.expression.NamedTarget;
import chameleon.core.expression.NamedTargetExpression;
import chameleon.core.lookup.LookupException;
import chameleon.core.reference.CrossReferenceWithName;
import chameleon.core.reference.CrossReferenceWithTarget;
import chameleon.core.variable.FormalParameter;
import chameleon.oo.type.BasicTypeReference;
import chameleon.oo.type.DeclarationWithType;
import chameleon.oo.type.Type;
import chameleon.oo.type.TypeReference;
import chameleon.oo.type.generics.ActualTypeArgument;
import chameleon.support.member.simplename.method.NormalMethod;
import chameleon.support.member.simplename.method.RegularMethodInvocation;

public abstract class SubobjectReadTransformationProvider extends CreateAdviceMethodTransformationProvider {
	
	/**
	 *  {@inheritDoc}
	 */
	@Override
	protected TypeReference getAdiceMethodReturnType() {
		try {
			BasicJavaTypeReference originalTypeReference = (BasicJavaTypeReference) ((ComponentRelation) getJoinpoint().getJoinpoint().getElement()).componentTypeReference();
			BasicJavaTypeReference returnType = new BasicJavaTypeReference(originalTypeReference.getType().getFullyQualifiedName());
		
			for (ActualTypeArgument ta : originalTypeReference.typeArguments())
				returnType.addArgument((ActualTypeArgument) ta.clone());
		
		
			return returnType;
		} catch (LookupException e) {
			// Can only occur due to a bug so swallow the exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 *  {@inheritDoc}
	 */
	@Override
	protected List<FormalParameter> getAdviceMethodParameters() {
		List<FormalParameter> result = new ArrayList<FormalParameter>();
		
		result.add(new FormalParameter(expressionName, new BasicTypeReference(getTargetType().getFullyQualifiedName())));
		result.add(new FormalParameter(calleeName, new BasicTypeReference("java.lang.Object")));
		
		return result;
	}
	
	private Type getTargetType() {
		Element target = getJoinpoint().getJoinpoint().getTarget();
		
		try {
			if (target instanceof NamedTarget)
				if (((NamedTarget) target).getElement() instanceof DeclarationWithType)
					return ((DeclarationWithType) ((NamedTarget) target).getElement()).declarationType();
			else if (target instanceof Expression)
				return ((Expression) target).getType();
			
		} catch (LookupException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		throw new RuntimeException();
	}
	
	
	@Override
	public boolean supports(PointcutExpression<?> pointcutExpression) {
		if (pointcutExpression instanceof TypePointcutExpression)
			return true;
		
		if (pointcutExpression instanceof IfPointcutExpression)
			return true;
		
		if (pointcutExpression instanceof PointcutExpressionOr)
			return true;
		
		if (pointcutExpression instanceof PointcutExpressionAnd)
			return true;
		
		if (pointcutExpression instanceof PointcutExpressionNot)
			return true;
		
		return false;
	}

	@Override
	public void initialiseRuntimeTransformers(MatchResult<? extends Element> joinpoint) {
		
	}

	@Override
	public Coordinator<NormalMethod> getCoordinator(MatchResult<? extends Element> joinpoint, WeavingEncapsulator previous, WeavingEncapsulator next) {
		return new AdviceMethodCoordinator(this, getJoinpoint(), previous, next);
	}

	@Override
	public RuntimeExpressionProvider getRuntimeExpressionProvider(RuntimePointcutExpression pointcutExpression) {		
		if (pointcutExpression instanceof ThisTypePointcutExpression)
			return new RuntimeTypeCheck(new NamedTargetExpression(calleeName));
		
		if (pointcutExpression instanceof TargetTypePointcutExpression)
			return new RuntimeTypeCheck(new NamedTargetExpression(expressionName));
		
		if (pointcutExpression instanceof IfPointcutExpression)
			return new RuntimeIfCheck();
		
		if (pointcutExpression instanceof PointcutExpressionOr)
			return new RuntimeOr();
		
		if (pointcutExpression instanceof PointcutExpressionAnd)
			return new RuntimeAnd();
		
		if (pointcutExpression instanceof PointcutExpressionNot)
			return new RuntimeNot();
		
		return null;
	}

	@Override
	public RuntimeParameterExposureProvider getRuntimeParameterInjectionProvider(ParameterExposurePointcutExpression<?> expression) {
		if (expression instanceof ThisTypePointcutExpression)
			return new TypeParameterExposure(new NamedTargetExpression(calleeName));
		
		if (expression instanceof TargetTypePointcutExpression)
			return new TypeParameterExposure(new NamedTargetExpression(expressionName));
		
		return null;
	}

	@Override
	public RegularMethodInvocation getNextInvocation(WeavingEncapsulator nextWeavingEncapsulator) {
		if (nextWeavingEncapsulator == null)
			return createSubobjectRead();
		else
			return createNextAdviceInvocation(nextWeavingEncapsulator);
	}
	
	private RegularMethodInvocation createNextAdviceInvocation(WeavingEncapsulator nextWeavingEncapsulator) {
		RegularMethodInvocation getInstance = new RegularMethodInvocation("instance", new NamedTarget(nextWeavingEncapsulator.getAdvice().aspect().name()));
		RegularMethodInvocation adviceInvocation = new RegularMethodInvocation(getAdviceMethodName(nextWeavingEncapsulator.getAdvice()), getInstance);
		
		adviceInvocation.addArgument(new NamedTargetExpression(expressionName));
		adviceInvocation.addArgument(new NamedTargetExpression(calleeName));

		return adviceInvocation;
	}

	private RegularMethodInvocation createSubobjectRead() {
		// This is a workaround because JLo can not handle the static methods of the aspect class at the moment. This will do manual translation,
		// instead of automatic building of the generated aspect class.
		JavaTranslator JLoTranslator = new JavaTranslator();
		
		CrossReferenceWithTarget joinpointCall = (CrossReferenceWithTarget) getJoinpoint().getJoinpoint().clone();
		// Quite a lot of copy pasted code form JavaTranslator, but as said before, workaround
		String name = ((CrossReferenceWithName)joinpointCall).name();
		
		String getterName = JLoTranslator.getterName(name);
		NamedTarget target = (NamedTarget) joinpointCall.getTarget().clone();
		target.setName(expressionName);
		RegularMethodInvocation inv = new JavaMethodInvocation(getterName, target);
		
		return inv;
	}

	@Override
	public String getAdviceMethodName(Advice advice) {
		NamingRegistry<Advice> adviceNamingRegistry = NamingRegistryFactory.instance().getNamingRegistryFor("advice");
		NamingRegistry<Declaration> methodNamingRegistry = NamingRegistryFactory.instance().getNamingRegistryFor("componentrelation");
		
		Declaration component = null;
		try {
			component = getJoinpoint().getJoinpoint().getElement();
		} catch (LookupException e) {
			// Can only occur due to bugs
			e.printStackTrace();
		}
		
		return "advice_" + adviceNamingRegistry.getName(advice) + "_" + methodNamingRegistry.getName(component);
	}
	
	@Override
	public MatchResult<? extends CrossReferenceWithTarget> getJoinpoint() {
		return (MatchResult<? extends CrossReferenceWithTarget>) super.getJoinpoint();
	}
	
	public final String calleeName = "_$callee";
	public final String expressionName = "_$expr";
	public final String retvalName = "_$retval";
}