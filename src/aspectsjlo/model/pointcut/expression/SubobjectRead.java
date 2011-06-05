package aspectsjlo.model.pointcut.expression;

import java.util.ArrayList;
import java.util.List;

import org.rejuse.association.SingleAssociation;

import subobjectjava.model.component.ComponentRelation;
import subobjectjava.model.expression.SubobjectConstructorCall;
import chameleon.aspects.pointcut.expression.MatchResult;
import chameleon.aspects.pointcut.expression.staticexpression.AbstractStaticPointcutExpression;
import chameleon.aspects.pointcut.expression.staticexpression.MemberReference;
import chameleon.core.declaration.Declaration;
import chameleon.core.element.Element;
import chameleon.core.expression.MethodInvocation;
import chameleon.core.lookup.LookupException;
import chameleon.core.reference.CrossReferenceWithName;
import chameleon.core.reference.CrossReferenceWithTarget;
import chameleon.oo.type.Type;
import chameleon.oo.type.TypeReference;
import chameleon.oo.type.inheritance.InheritanceRelation;
import chameleon.util.Util;

public class SubobjectRead<E extends SubobjectRead<E>> extends AbstractStaticPointcutExpression<E> {
	
	public SubobjectRead() {
		
	}
	
	public SubobjectRead(TypeReference typeref, MemberReference subobjref) {
		setTypeReference(typeref);
		setSubobjectReference(subobjref);
	}
	
	private SingleAssociation<SubobjectRead<E>, MemberReference> _subobjectReference = new SingleAssociation<SubobjectRead<E>, MemberReference>(this);
	private SingleAssociation<SubobjectRead<E>, TypeReference> _typeReference = new SingleAssociation<SubobjectRead<E>, TypeReference>(this);
	
	public TypeReference typeReference() {
		return _typeReference.getOtherEnd();
	}
	
	public MemberReference subobjectReference() {
		return _subobjectReference.getOtherEnd();
	}
	
	private void setTypeReference(TypeReference reference) {
		setAsParent(_typeReference, reference);
	}
	
	private void setSubobjectReference(MemberReference reference) {
		setAsParent(_subobjectReference, reference);
	}

	@Override
	public MatchResult matches(Element element) throws LookupException {
		CrossReferenceWithTarget joinpoint = (CrossReferenceWithTarget) element;
		Declaration referencedElement = joinpoint.getElement();

		boolean isSubobjectRead = false;
		if((! (joinpoint instanceof MethodInvocation)) && (! (joinpoint instanceof TypeReference)) && (joinpoint.nearestAncestor(InheritanceRelation.class) == null)
			&& joinpoint.nearestAncestor(SubobjectConstructorCall.class) == null) {
			try {
				Declaration decl = joinpoint.getElement();
				if(decl instanceof ComponentRelation) {
					if (!((ComponentRelation) referencedElement).componentTypeReference().getType().baseType().sameAs(typeReference().getType().baseType()))
						return MatchResult.noMatch();
					
					String fqn = ((Type) referencedElement.nearestAncestor(Type.class)).getFullyQualifiedName() + "." + joinpoint.getElement().signature().name();
					if (!fqn.equals(subobjectReference().reference()))
						return MatchResult.noMatch();
						
					return new MatchResult<CrossReferenceWithTarget>(this, joinpoint);
				}
			}
			catch(LookupException exc) {
			}
		}

		return MatchResult.noMatch();
	}

	@Override
	public boolean isSupported(Class<? extends Element> type) {
		if (CrossReferenceWithTarget.class.isAssignableFrom(type))
			return true;
		
		return false;
	}

	@Override
	public List<? extends Element> children() {
		List<Element> result = new ArrayList<Element>();
		
		Util.addNonNull(subobjectReference(), result);
		Util.addNonNull(typeReference(), result);
		
		return result;
	}

	@Override
	public E clone() {
		SubobjectRead<E> clone = new SubobjectRead<E>();
		
		clone.setSubobjectReference(Util.cloneOrNull(subobjectReference()));
		clone.setTypeReference(Util.cloneOrNull(typeReference()));
		
		return (E) clone;
	}

}
