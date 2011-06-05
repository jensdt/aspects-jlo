package aspectsjlo.translate.weaver.elementweaver.subobjectread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.rejuse.property.PropertySet;

import aspectsjava.translate.weaver.weavingprovider.ElementReplaceProvider;
import aspectsjlo.model.advice.transformation.subobjectread.AfterReturningSubobjectRead;
import aspectsjlo.model.advice.transformation.subobjectread.AfterSubobjectRead;
import aspectsjlo.model.advice.transformation.subobjectread.AroundSubobjectRead;
import aspectsjlo.model.advice.transformation.subobjectread.BeforeSubobjectRead;
import aspectsjlo.model.advice.weaving.subobjectread.DefaultSubobjectRead;
import chameleon.aspects.advice.Advice;
import chameleon.aspects.advice.types.translation.AdviceTransformationProvider;
import chameleon.aspects.advice.types.weaving.AdviceWeaveResultProvider;
import chameleon.aspects.pointcut.expression.MatchResult;
import chameleon.aspects.weaver.AbstractElementWeaver;
import chameleon.aspects.weaver.weavingprovider.WeavingProvider;
import chameleon.core.expression.MethodInvocation;
import chameleon.core.reference.CrossReferenceWithTarget;

public class SubobjectReadWeaver extends AbstractElementWeaver<CrossReferenceWithTarget, MethodInvocation> {

	private AdviceWeaveResultProvider<CrossReferenceWithTarget, MethodInvocation> weavingAdviceType = new DefaultSubobjectRead();

	@Override
	public AdviceWeaveResultProvider<CrossReferenceWithTarget, MethodInvocation> getWeaveResultProvider() {
		return weavingAdviceType;
	}
	
	@Override
	public AdviceTransformationProvider getTransformationProvider(Advice advice, MatchResult<CrossReferenceWithTarget> joinpoint) {
		PropertySet around = getAround(advice);		
		PropertySet before = getBefore(advice);
		PropertySet after = getAfter(advice);
		PropertySet afterReturning = getAfterReturning(advice);
		
		if (around.containsAll(advice.properties().properties()))
			return new AroundSubobjectRead();
		
		if (before.containsAll(advice.properties().properties()))
			return new BeforeSubobjectRead();
		
		if (after.containsAll(advice.properties().properties()))
			return new AfterSubobjectRead();
					
		if (afterReturning.containsAll(advice.properties().properties()))
			return new AfterReturningSubobjectRead();
	
		throw new RuntimeException();

	}

	private ElementReplaceProvider<CrossReferenceWithTarget, MethodInvocation> strategy = new ElementReplaceProvider<CrossReferenceWithTarget, MethodInvocation>();
	
	@Override
	public WeavingProvider<CrossReferenceWithTarget, MethodInvocation> getWeavingProvider(Advice advice) {
		return strategy;
	}

	@Override
	public List<Class<CrossReferenceWithTarget>> supportedTypes() {
		return Collections.singletonList(CrossReferenceWithTarget.class);
	}

	@Override
	public List<PropertySet> supportedAdviceProperties(Advice advice) {
		List<PropertySet> supportedProperties = new ArrayList<PropertySet>();
		
		supportedProperties.add(getAround(advice));		
		supportedProperties.add(getBefore(advice));
		supportedProperties.add(getAfter(advice));
		supportedProperties.add(getAfterReturning(advice));
		
		return supportedProperties;	}

}
