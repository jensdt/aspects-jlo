grammar AspectJLo;
options {
  backtrack=true; 
  memoize=true;
  output=AST;
  superClass = ChameleonParser;
}

import JavaP,JLoL;
@header {
package aspectsjlo.input;

import aspectsjava.model.advice.*;
import aspectsjava.model.pointcut.expression.within.*;
import aspectsjava.model.pointcut.expression.methodinvocation.annotated.AnnotatedMethodInvocationExpression;
import aspectsjava.model.pointcut.expression.methodinvocation.annotated.AnnotationReference;
import aspectsjava.model.pointcut.expression.methodinvocation.signature.MethodReference;
import aspectsjava.model.pointcut.expression.methodinvocation.signature.QualifiedMethodHeader;
import aspectsjava.model.pointcut.expression.methodinvocation.signature.SignatureMethodInvocationPointcutExpression;
import aspectsjava.model.pointcut.expression.methodinvocation.signature.SimpleNameDeclarationWithParameterTypesHeader;


	import chameleon.aspects.*;
	import chameleon.aspects.advice.*;
	import chameleon.aspects.advice.AdviceReturnStatement;
	import chameleon.aspects.advice.types.*;
	import chameleon.aspects.pointcut.*;
	import chameleon.aspects.pointcut.expression.*;

import chameleon.aspects.pointcut.expression.generic.*;
	import chameleon.aspects.pointcut.expression.namedpointcut.*;
	import chameleon.aspects.pointcut.expression.dynamicexpression.*;
import chameleon.aspects.pointcut.expression.staticexpression.*;
	import chameleon.aspects.pointcut.expression.staticexpression.within.*;
	import chameleon.aspects.pointcut.expression.staticexpression.catchclause.*;
	import chameleon.aspects.pointcut.expression.staticexpression.fieldAccess.*;
	import chameleon.aspects.pointcut.expression.staticexpression.cast.*;

import aspectsjlo.model.pointcut.expression.*;

import chameleon.exception.ModelException;
import chameleon.exception.ChameleonProgrammerException;

import chameleon.core.lookup.LookupStrategyFactory;

import chameleon.core.compilationunit.CompilationUnit;

import chameleon.core.declaration.SimpleNameDeclarationWithParametersSignature;
import chameleon.core.declaration.SimpleNameDeclarationWithParametersHeader;
import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.declaration.Signature;
import chameleon.core.declaration.QualifiedName;
import chameleon.core.declaration.CompositeQualifiedName;
import chameleon.core.declaration.TargetDeclaration;

import chameleon.core.element.Element;

import chameleon.core.expression.Expression;
import chameleon.core.expression.MethodInvocation;
import chameleon.core.expression.Literal;
import chameleon.core.expression.Assignable;
import chameleon.core.expression.NamedTarget;
import chameleon.core.expression.NamedTargetExpression;
import chameleon.core.expression.InvocationTarget;
import chameleon.core.expression.TargetedExpression;
import chameleon.core.expression.VariableReference;

import chameleon.core.language.Language;

import chameleon.core.member.Member;

import chameleon.core.method.Method;
import chameleon.core.method.Implementation;
import chameleon.core.method.RegularImplementation;

import chameleon.core.method.exception.ExceptionClause;
import chameleon.core.method.exception.TypeExceptionDeclaration;

import chameleon.core.modifier.Modifier;

import chameleon.core.namespace.Namespace;
import chameleon.core.namespace.RootNamespace;
import chameleon.core.namespace.NamespaceOrTypeReference;
import chameleon.core.namespace.NamespaceReference;

import chameleon.core.namespacepart.NamespacePart;
import chameleon.core.namespacepart.Import;
import chameleon.core.namespacepart.TypeImport;
import chameleon.core.namespacepart.DemandImport;

import chameleon.core.reference.CrossReference;

import chameleon.core.statement.Block;
import chameleon.core.statement.Statement;

import chameleon.oo.type.ClassBody;
import chameleon.oo.type.RegularType;
import chameleon.oo.type.Type;
import chameleon.oo.type.TypeReference;
import chameleon.oo.type.TypeElement;
import chameleon.oo.type.TypeWithBody;
import chameleon.oo.type.ParameterBlock;

import chameleon.oo.type.generics.TypeParameter;
import chameleon.oo.type.generics.FormalTypeParameter;
import chameleon.oo.type.generics.ActualTypeArgument;
import chameleon.oo.type.generics.BasicTypeArgument;
import chameleon.oo.type.generics.TypeConstraint;
import chameleon.oo.type.generics.ExtendsConstraint;
import chameleon.oo.type.generics.ExtendsWildcard;
import chameleon.oo.type.generics.SuperWildcard;
import chameleon.oo.type.inheritance.SubtypeRelation;

import chameleon.core.variable.Variable;
import chameleon.core.variable.FormalParameter;
import chameleon.core.variable.VariableDeclaration;
import chameleon.core.variable.VariableDeclarator;

import chameleon.input.InputProcessor;
import chameleon.input.Position2D;

import chameleon.support.expression.RegularLiteral;
import chameleon.support.expression.NullLiteral;
import chameleon.support.expression.AssignmentExpression;
import chameleon.support.expression.ConditionalExpression;
import chameleon.support.expression.ConditionalAndExpression;
import chameleon.support.expression.ConditionalOrExpression;
import chameleon.support.expression.InstanceofExpression;
import chameleon.support.expression.ThisLiteral;
import chameleon.support.expression.FilledArrayIndex;
import chameleon.support.expression.EmptyArrayIndex;
import chameleon.support.expression.ArrayIndex;
import chameleon.support.expression.ClassCastExpression;
import chameleon.support.expression.SuperTarget;

import chameleon.support.member.simplename.method.NormalMethod;
import chameleon.support.member.simplename.variable.MemberVariableDeclarator;
import chameleon.support.member.simplename.operator.infix.InfixOperatorInvocation;
import chameleon.support.member.simplename.operator.prefix.PrefixOperatorInvocation;
import chameleon.support.member.simplename.operator.postfix.PostfixOperatorInvocation;
import chameleon.support.member.simplename.method.RegularMethodInvocation;

import chameleon.support.modifier.Abstract;
import chameleon.support.modifier.Final;
import chameleon.support.modifier.Private;
import chameleon.support.modifier.Protected;
import chameleon.support.modifier.Public;
import chameleon.support.modifier.Static;
import chameleon.support.modifier.Native;
import chameleon.support.modifier.Enum;
import chameleon.support.modifier.Interface;

import chameleon.support.statement.StatementExpression;
import chameleon.support.statement.LocalClassStatement;
import chameleon.support.statement.AssertStatement;
import chameleon.support.statement.IfThenElseStatement;
import chameleon.support.statement.ForStatement;
import chameleon.support.statement.ForControl;
import chameleon.support.statement.ForInit;
import chameleon.support.statement.SimpleForControl;
import chameleon.support.statement.EnhancedForControl;
import chameleon.support.statement.StatementExprList;
import chameleon.support.statement.TryStatement;
import chameleon.support.statement.CatchClause;
import chameleon.support.statement.FinallyClause;
import chameleon.support.statement.DoStatement;
import chameleon.support.statement.WhileStatement;
import chameleon.support.statement.SwitchStatement;
import chameleon.support.statement.SwitchCase;
import chameleon.support.statement.SwitchLabel;
import chameleon.support.statement.CaseLabel;
import chameleon.support.statement.DefaultLabel;
import chameleon.support.statement.EnumLabel;
import chameleon.support.statement.ReturnStatement;
import chameleon.support.statement.ThrowStatement;
import chameleon.support.statement.BreakStatement;
import chameleon.support.statement.ContinueStatement;
import chameleon.support.statement.SynchronizedStatement;
import chameleon.support.statement.EmptyStatement;
import chameleon.support.statement.LabeledStatement;

import chameleon.support.type.EmptyTypeElement;
import chameleon.support.type.StaticInitializer;

import chameleon.support.variable.LocalVariableDeclarator;

import chameleon.support.input.ChameleonParser;

import chameleon.util.Util;

import jnome.core.expression.ArrayInitializer;
import jnome.core.expression.ClassLiteral;
import jnome.core.expression.ArrayAccessExpression;
import jnome.core.expression.ArrayCreationExpression;
import jnome.core.expression.invocation.ConstructorInvocation;
import jnome.core.expression.invocation.JavaMethodInvocation;
import jnome.core.expression.invocation.ThisConstructorDelegation;
import jnome.core.expression.invocation.SuperConstructorDelegation;

import jnome.core.imports.SingleStaticImport;

import jnome.core.language.Java;

import jnome.core.modifier.StrictFP;
import jnome.core.modifier.Transient;
import jnome.core.modifier.Volatile;
import jnome.core.modifier.Synchronized;
import jnome.core.modifier.JavaConstructor;
import jnome.core.modifier.Implements;
import jnome.core.modifier.AnnotationModifier;
import jnome.core.modifier.AnnotationType;

import jnome.core.type.JavaTypeReference;
import jnome.core.type.ArrayTypeReference;
import jnome.core.type.BasicJavaTypeReference;
import jnome.core.type.JavaIntersectionTypeReference;
import jnome.core.type.PureWildcard;

import jnome.core.enumeration.EnumConstant;

import jnome.core.variable.JavaVariableDeclaration;
import jnome.core.variable.MultiFormalParameter;

import jnome.input.JavaFactory;

import subobjectjava.model.component.ComponentRelation;
import subobjectjava.model.component.ConfigurationBlock;
import subobjectjava.model.component.ConfigurationClause;
import subobjectjava.model.component.RenamingClause;
import subobjectjava.model.component.OverridesClause;
import subobjectjava.model.expression.SubobjectConstructorCall;
import subobjectjava.model.expression.ComponentParameterCall;
import subobjectjava.model.expression.OuterTarget;
import subobjectjava.model.expression.RootTarget;
import subobjectjava.model.component.ComponentParameter;
import subobjectjava.model.component.FormalComponentParameter;
import subobjectjava.model.component.SingleFormalComponentParameter;
import subobjectjava.model.component.MultiFormalComponentParameter;
import subobjectjava.model.component.ActualComponentArgument;
import subobjectjava.model.component.SingleActualComponentArgument;
import subobjectjava.model.component.MultiActualComponentArgument;
import subobjectjava.model.component.ComponentParameterTypeReference;
import subobjectjava.model.component.ComponentNameActualArgument;
import subobjectjava.model.component.ParameterReferenceActualArgument;
import subobjectjava.model.component.Export;
import subobjectjava.model.component.InstantiatedMemberSubobjectParameter;

import java.util.List;
import java.util.ArrayList;
}
@members{
public void processType(NamespacePart np, Type type){
    if(np == null) {throw new IllegalArgumentException("namespace part given to processType is null.");}
    if(type == null) {return;}  //throw new IllegalArgumentException("type given to processType is null.");}
    np.add(type);
    // inherit from java.lang.Object if there is no explicit extends relation
    String fqn = type.getFullyQualifiedName();
    if(fqn != null) {
      if(type.nonMemberInheritanceRelations().isEmpty() && (! fqn.equals("java.lang.Object"))){
        type.addInheritanceRelation(new SubtypeRelation(createTypeReference(new NamespaceOrTypeReference("java.lang"),"Object")));
      }
    }

  }
  
  @Override
  public void setLanguage(Language language) {
    gJavaP.setLanguage(language);
  }
  
  @Override
  public Language language() {
    return gJavaP.language();
  }
  
  public CompilationUnit getCompilationUnit() {
    return gJavaP.getCompilationUnit();
  }
	   
  public void setCompilationUnit(CompilationUnit compilationUnit) {
    gJavaP.setCompilationUnit(compilationUnit);
  }
  
  public Namespace getDefaultNamespace() {
    return gJavaP.getDefaultNamespace();
  }
  
    public void setFactory(JavaFactory factory) {
    gJavaP.setFactory(factory);
  }
  
  public JavaFactory factory() {
    return gJavaP.factory();
  }

  public JavaTypeReference typeRef(String qn) {
    return gJavaP.typeRef(qn);
  }

  public JavaTypeReference createTypeReference(CrossReference<?, ? extends TargetDeclaration> target, String name) {
    return gJavaP.createTypeReference(target,name);
  }
  
  public JavaTypeReference createTypeReference(CrossReference<?, ? extends TargetDeclaration> target, SimpleNameSignature signature) {
    return gJavaP.createTypeReference(target,signature);
  }

  public JavaTypeReference createTypeReference(NamedTarget target) {
    return gJavaP.createTypeReference(target);
  }

  public InvocationTarget cloneTarget(InvocationTarget target) {
    return gJavaP.cloneTarget(target);
  }
  
  public RegularMethodInvocation invocation(String name, InvocationTarget target) {
    return gJavaP.invocation(name,target);
  }
  
  
}

identifierRule returns [String element]
    : id=Identifier {retval.element = $id.text;} 
      | ex=Export  {retval.element = $ex.text;} 
      | co=Connector  {retval.element = $co.text;} 
      | ctc=Connect  {retval.element = $ctc.text;} 
      | n=Name  {retval.element = $n.text;} 
      | o=Overrides  {retval.element = $o.text;} 
    ;   


memberDecl returns [TypeElement element]
@after{setLocation(retval.element, (CommonToken)retval.start, (CommonToken)retval.stop);}
    :   gen=genericMethodOrConstructorDecl {retval.element = gen.element;}
    |   mem=memberDeclaration {retval.element = mem.element;}
    |   vmd=voidMethodDeclaration {retval.element = vmd.element;}
    |   cs=constructorDeclaration {retval.element = cs.element;}
    |   id=interfaceDeclaration {retval.element=id.element; gJavaP.addNonTopLevelObjectInheritance(id.element);}
    |   cd=classDeclaration {retval.element=cd.element; gJavaP.addNonTopLevelObjectInheritance(cd.element);}
    |   comp=subobjectDeclaration {retval.element=comp.element;}
    |   exp=exportDeclaration {retval.element=exp.element;}
    |   np=nameParameter {retval.element=np.element;}
    |   con=connector {retval.element = con.element;}
    |   cnct=connection {retval.element = cnct.element;}
    ;

connector returns [TypeElement element]
 	: ctkw=Connector cp=subobjectParameter {retval.element = cp.element; setKeyword(retval.element,ctkw);}';'	
 	;

connection returns [TypeElement element]
 	: ctkw=Connect name=identifierRule tokw=Identifier arg=subobjectArgument ';'
 	  {retval.element = new InstantiatedMemberSubobjectParameter(new SimpleNameSignature($name.text),arg.element);
 	   setKeyword(retval.element,ctkw);
	   setName(retval.element,name.start);
 	   if($tokw.text.equals("to")) {setKeyword(arg.element,tokw);}
 	  }	
 	;

nameParameter returns [TypeElement element]
    	:	Name identifierRule ('=' memberName)? ';'
    	;
    	
memberName returns [Object element]
 	: identifierRule
 	;    	

exportDeclaration returns [Export element]
    	: xp=Export {retval.element = new Export(); setKeyword(retval.element,xp);} m=map {retval.element.add(m.element);} (',' mm=map {retval.element.add(mm.element);})*	';'
    	;
    	
map returns [RenamingClause element]
	:  oldFQN=fqn {retval.element = new RenamingClause(null, oldFQN.element);} 
	   (id=Identifier newSig=signature 
	   {retval.element.setNewSignature(newSig.element);
	    if($id.text.equals("as")) {setKeyword(retval.element, id);}
	   })?
	;    	

subobjectDeclaration returns [ComponentRelation element]
    	:	cp='subobject' tp=type? name=identifierRule 
    	        {retval.element = new ComponentRelation(new SimpleNameSignature($name.text), $tp.element);
    	         setKeyword(retval.element,cp);
    	         setName(retval.element,name.start);
    	        }
    	        (body=classBody {retval.element.setBody($body.element);} | ';')  // cfg=configurationBlock? 
//    	      if(cfg != null) {retval.element.setConfigurationBlock($cfg.element);}
    	       
    	;
configurationBlock returns [ConfigurationBlock element] 
@after{setLocation(retval.element, (CommonToken)retval.start, (CommonToken)retval.stop);}
        : al='alias' '{' {retval.element = new ConfigurationBlock(); setKeyword(retval.element,al);} (cl=configurationClause{retval.element.add(cl.element);} (',' cll=configurationClause{retval.element.add(cll.element);})*)? '}'
        ;
        
configurationClause returns [ConfigurationClause element]
@after{setLocation(retval.element, (CommonToken)retval.start, (CommonToken)retval.stop);}
	: sig=signature ov='>' f=fqn
	     {retval.element = new OverridesClause(sig.element, f.element);
	      setKeyword(retval.element, ov);
	     }
	|
	 sigg=signature al='=' ff=fqn 
	     {retval.element = new RenamingClause(sigg.element, ff.element);
	      setKeyword(retval.element, al);
	     }
	;
	
signature returns [Signature element]
        : sig=identifierRule {retval.element = new SimpleNameSignature($sig.text);}
        | sigg=identifierRule {retval.element = new SimpleNameDeclarationWithParametersSignature($sigg.text);} 
                '(' (t=type {((SimpleNameDeclarationWithParametersSignature)retval.element).add(t.element);} 
                 (',' tt=type {((SimpleNameDeclarationWithParametersSignature)retval.element).add(tt.element);})*)?')'
        ;
        
fqn returns [QualifiedName element] 
        :	sig=signature {retval.element=sig.element;}
        |     id=identifierRule '.' ff=fqn {
              Signature signature = new SimpleNameSignature($id.text);
              if(ff.element instanceof CompositeQualifiedName) {
                ((CompositeQualifiedName)ff.element).prefix(signature); 
                retval.element = ff.element;
              } else {
                retval.element=new CompositeQualifiedName();
                ((CompositeQualifiedName)retval.element).append(signature);
                ((CompositeQualifiedName)retval.element).append((Signature)ff.element);
              }
              }
        ;
        
expression returns [Expression element]
    :   ex=conditionalExpression {retval.element=ex.element;} (op=assignmentOperator exx=expression 
        {String txt = $op.text; 
         if(txt.equals("=")) {
           retval.element = new AssignmentExpression(ex.element,exx.element);
         } else {
           retval.element = new InfixOperatorInvocation($op.text,ex.element);
           ((InfixOperatorInvocation)retval.element).addArgument(exx.element);
         }
         setLocation(retval.element,op.start,op.stop,"__NAME");
         setLocation(retval.element,retval.start,exx.stop);
        }
        )?
        | sb='subobject' '.' id=identifierRule args=arguments {
          retval.element = new SubobjectConstructorCall($id.text, args.element);
         setLocation(retval.element,sb,args.stop);
         setKeyword(retval.element,sb);
           }
        | prcd='proceed' args=arguments {
          ProceedCall result = new ProceedCall();
          result.addAllArguments(args.element);
          retval.element = result;
          setKeyword(retval.element, prcd);
          setLocation(retval.element,prcd,prcd);
        }   
    ;
    
//conditionalOrExpression returns [Expression element]
//    :   ex=componentParameterCall {retval.element = ex.element;} ( '||' exx=componentParameterCall 
//        {retval.element = new ConditionalOrExpression(retval.element, exx.element);
//         setLocation(retval.element,retval.start,exx.stop);
//        })*
//    ;

//componentParameterCall returns [Expression element]
// 	: ex=conditionalAndExpression {retval.element = ex.element;} (at='#' id=Identifier 
//            {retval.element = new ComponentParameterCall(ex.element, $id.text);
//              setLocation(retval.element,ex.start,id);
//              setKeyword(retval.element,at);
//             })?
//  	;

// NEEDS_TARGET


nonTargetPrimary returns [Expression element]
  	:
  	lit=literal {retval.element = lit.element;}
  	| at='#' id=identifierRule '(' ex=expression {retval.element = ex.element;} stop=')'
           {retval.element = new ComponentParameterCall(ex.element, $id.text);
              setLocation(retval.element,at,stop);
              setKeyword(retval.element,at);
           }
        | okw='outer' supsuf=superSuffix 
           {retval.element = supsuf.element;
            InvocationTarget tar = new OuterTarget();
            ((TargetedExpression)retval.element).setTarget(tar);
            setLocation(retval.element,okw,okw); // put locations on the SuperTarget.
            setKeyword(tar,okw);
           }
        | rkw='rooot' supsuf=superSuffix 
           {retval.element = supsuf.element;
            InvocationTarget tar = new RootTarget();
            ((TargetedExpression)retval.element).setTarget(tar);
            setLocation(retval.element,rkw,rkw); // put locations on the SuperTarget.
            setKeyword(tar,rkw);
           }
  	;

   
subobjectParameter returns [ComponentParameter element]
	: single=singleSubobjectParameter {retval.element = single.element;}
	 | multi=multiSubobjectParameter {retval.element = multi.element;}
	;

singleSubobjectParameter returns [ComponentParameter element]
	: id=identifierRule tcontainer=type arrow='->' tcomp=type 
	  {retval.element = new SingleFormalComponentParameter(new SimpleNameSignature($id.text),tcontainer.element,tcomp.element);
	   setLocation(retval.element,id.start,tcomp.stop);
	   setKeyword(tcontainer.element,arrow);
	   setName(retval.element,id.start);
	   }
	;

multiSubobjectParameter returns [ComponentParameter element]
	:  id=identifierRule tcontainer=type arrow='->' '[' tcomp=type fin=']'
	  {retval.element = new MultiFormalComponentParameter(new SimpleNameSignature($id.text),tcontainer.element,tcomp.element);
	   setLocation(retval.element,id.start,fin);
	   setKeyword(tcontainer.element,arrow);
	   setName(retval.element,id.start);
	   }
	;

subobjectArgument returns [ActualComponentArgument element]
 	:
 	  s=singleSubobjectArgument {retval.element=s.element;} 
 	 | ss=multiSubobjectArgument {retval.element=ss.element;}
 	;
 	
singleSubobjectArgument returns [SingleActualComponentArgument element]
	:
	 id=identifierRule {retval.element = new ComponentNameActualArgument($id.text);
}
        | '@' idd=identifierRule {retval.element = new ParameterReferenceActualArgument($idd.text);}
	;
	
multiSubobjectArgument returns [MultiActualComponentArgument element]
@init{retval.element = new MultiActualComponentArgument();}
	:
	 '[' (single=singleSubobjectArgument {retval.element.add(single.element);} 
	     (',' singlee=singleSubobjectArgument {retval.element.add(singlee.element);} )* )?
	 ']' 
	;	

// Aspect support starts here


// starting point for parsing a java file
/* The annotations are separated out to make parsing faster, but must be associated with
   a packageDeclaration or a typeDeclaration (and not an empty one). */
compilationUnit returns [CompilationUnit element] 
@init{ 
NamespacePart npp = null;
retval.element = getCompilationUnit();
}
    :  ( annotations
        (   np=packageDeclaration
                {npp=np.element;
                 retval.element.add(npp);
                 npp.addImport(new DemandImport(new NamespaceReference("java.lang")));
                } 
            (imp=importDeclaration{npp.addImport(imp.element);})* 
            (typech=typeDeclaration
                {processType(npp,typech.element);
                }
            )*
        |   cd=classOrInterfaceDeclaration
               {npp = new NamespacePart(language().defaultNamespace());
                retval.element.add(npp);
                npp.addImport(new DemandImport(new NamespaceReference("java.lang")));
                processType(npp,cd.element);
               } 
            (typech=typeDeclaration
               {processType(npp,typech.element);
               }
            )*
        )
    |   (np=packageDeclaration
            {
              npp=np.element;
            }
         )?
        {
         if(npp == null) {
           npp = new NamespacePart(language().defaultNamespace());
         }
         npp.addImport(new DemandImport(new NamespaceReference("java.lang")));
         retval.element.add(npp);
        }
        (imp=importDeclaration
          {npp.addImport(imp.element);}
        )* 
        (typech=typeDeclaration
          {
           processType(npp,typech.element);
          }
          |
          ad=aspect
      	   {
       		 npp.add(ad.element);       	
       	  }
        )* )
    ;


aspect returns [Aspect element]
	: asp='aspect' name=identifierRule {retval.element = new Aspect($name.text);} 
	'{' 	// This is: (advice|pointcut)*
	((adv=advice{retval.element.addAdvice(adv.element);})|(ptc=pointcut{retval.element.addPointcut(ptc.element);}))* 
	'}' 
	
	{
		//setKeyword(retval.element, asp);
	}
	;

pointcut returns [Pointcut element]
@after{setLocation(retval.element, decl.start, decl.stop);}
	: pct='pointcut' decl=pointcutDecl pars=formalParameters ':' expr=pointcutExpression ';'
	
	{
		SimpleNameDeclarationWithParametersHeader header = new SimpleNameDeclarationWithParametersHeader(decl.element);
		header.addFormalParameters(pars.element);
		setLocation(header, decl.start, pars.stop);
		retval.element = new Pointcut(header, expr.element);
		setKeyword(retval.element, pct);
	}
	;
	
pointcutDecl returns [String element]
	: name=identifierRule  {retval.element = $name.text;}
	;
	
pointcutExpression returns [PointcutExpression element]
@after{setLocation(retval.element, retval.start, retval.stop);}
	: expr1=pointcutExpressionOr '&&' expr2=pointcutExpression {retval.element = new PointcutExpressionAnd(expr1.element, expr2.element);}
	| exprOr=pointcutExpressionOr {retval.element = exprOr.element;}
	;

memberReference returns [MemberReference element]
@init{String fullName = "";}
	: (initName=identifierRule {fullName = $initName.text;} ('.' appendName=identifierRule {fullName += "." + $appendName.text; })*) {retval.element = new MemberReference(fullName);}
	;

pointcutExpressionOr returns [PointcutExpression element]
@after{setLocation(retval.element, retval.start, retval.stop);}
	: expr1=pointcutAtom '||' expr2=pointcutExpressionOr {retval.element = new PointcutExpressionOr(expr1.element, expr2.element);}
	| expr=pointcutAtom {retval.element = expr.element;}
	;
	
methodReference returns [MethodReference element]
@init{JavaTypeReference type = null; String typeWithWC = null;}
@after{setLocation(retval.element, retval.start, retval.stop);}
	: (t=typeOrVoid {type = t.element; }|twc=IdentifierWithWC {typeWithWC = $twc.text;}) name=methodRefFqn {retval.element = new MethodReference(name.element, type, typeWithWC);}
	;

methodRefFqn returns [QualifiedMethodHeader element]
@init{CompositeQualifiedName prefixes = new CompositeQualifiedName();}
@after{setLocation(retval.element, retval.start, retval.stop);}
	: (id=(IdentifierWithWC|Identifier) '.' {prefixes.append(new SimpleNameSignature($id.text));})* mth=simpleMethodHeader {retval.element = new QualifiedMethodHeader(mth.element); retval.element.setPrefixes(prefixes);}
	;
	
simpleMethodHeader returns [SimpleNameDeclarationWithParameterTypesHeader element]
@after{setLocation(retval.element, retval.start, retval.stop);}
        :	name=(IdentifierWithWC|Identifier) pars=formalParameterTypes {retval.element = new SimpleNameDeclarationWithParameterTypesHeader($name.text); retval.element.addAll(pars.element); } 
        ;
        
formalParameterTypes returns [List<TypeReference> element]
@init{retval.element = new ArrayList<TypeReference>();}
    :   '(' (pars=formalParameterTypeDecls {retval.element=pars.element;})? ')'
    ;

formalParameterTypeDecls returns [List<TypeReference> element]
    :   t=type (',' decls=formalParameterTypeDecls {retval.element=decls.element; })?
        {if(retval.element == null) {
         retval.element=new ArrayList<TypeReference>();}
         retval.element.add(0, t.element);
         }
    ;
	
typeOrVoid returns [JavaTypeReference element]
	: t=type {retval.element=t.element;}
	| v=voidType {retval.element=v.element;}
	;
	
pointcutAtom returns [PointcutExpression element]
@after{setLocation(retval.element, retval.start, retval.stop);}
	: cl='call' '(' metref=methodReference ')' {retval.element = new SignatureMethodInvocationPointcutExpression(metref.element); setKeyword(retval.element, cl);}
	| subobjRead='subobjectRead' '(' subobjreadType=type subobjreadRef=memberReference ')' {retval.element = new SubobjectRead(subobjreadType.element, subobjreadRef.element); setKeyword(retval.element, subobjRead); } 
	| clA='callAnnotated' '(' annot=identifierRule ')' {AnnotatedMethodInvocationExpression result = new AnnotatedMethodInvocationExpression(); result.setReference(new AnnotationReference($annot.text)); retval.element = result; setKeyword(retval.element, clA);}
	| emptyCatch='emptyHandler' {retval.element = new EmptyCatchClausePointcutExpression(); setKeyword(retval.element, emptyCatch); }
	| fieldRead='fieldRead' '(' fieldreadtype=type fieldref=fieldReference ')' {retval.element = new FieldReadPointcutExpression(fieldreadtype.element, fieldref.element); setKeyword(retval.element, fieldRead); }
	| handler='typeHandler' '(' exceptionType=type ')' {TypeCatchClausePointcutExpression catchHandler = new TypeCatchClausePointcutExpression(); catchHandler.setExceptionType(exceptionType.element); retval.element = catchHandler; setKeyword(retval.element, handler); }
	| cast='cast' '(' castType=type ')' { retval.element = new CastPointcutExpression(castType.element); setKeyword(retval.element, cast); }
	| namedRef=namedPointcutReference {NamedPointcutExpression named = new NamedPointcutExpression(); named.setPointcutReference(namedRef.element); retval.element = named;}
	| withinCl=within {retval.element = withinCl.element;}
	// Runtime checks
	| getargs='arguments' t=typesOrParameters {ArgsPointcutExpression expr = new ArgsPointcutExpression(); expr.addAll(t.element); retval.element = expr; setKeyword(retval.element, getargs); }
	| thisType='thisType' '(' exp=expression ')' {ThisTypePointcutExpression expr = new ThisTypePointcutExpression((NamedTargetExpression) exp.element); retval.element = expr; setKeyword(retval.element, thisType); }
	| targetType='targetType' '(' exp=expression ')' {TargetTypePointcutExpression expr = new TargetTypePointcutExpression((NamedTargetExpression) exp.element); retval.element = expr; setKeyword(retval.element, targetType); }
	| ifCheck='if' '(' exp=expression ')' {IfPointcutExpression expr = new IfPointcutExpression(exp.element); retval.element = expr; setKeyword(retval.element, ifCheck);}
	| '!' expr1=pointcutAtom {retval.element = new PointcutExpressionNot(expr1.element);}
	| '(' expr2=pointcutExpression ')' {retval.element = expr2.element;}
	;

typesOrParameters returns [List<NamedTargetExpression> element]
@init{retval.element = new ArrayList<NamedTargetExpression>();}
    :   '(' (pars=typesOrParameterDecls {retval.element=pars.element;})? ')'
    ;

typesOrParameterDecls returns [List<NamedTargetExpression> element]
    :	exp=expression (',' decls=typesOrParameterDecls {retval.element=decls.element; })? 
    	{if(retval.element == null) {
	 	retval.element=new ArrayList<NamedTargetExpression>();
         } 
         retval.element.add(0, (NamedTargetExpression) exp.element);
         }
    ;

subtypeMarker returns [SubtypeMarker element]
	: '+' {retval.element = new SubtypeMarker();};
	
withinType returns [WithinTypePointcutExpression element]
@init{WithinTypePointcutExpression within = new WithinTypePointcutExpression();}
	: withinToken='within' '(' withinTypeRef=type (marker=subtypeMarker {within.setSubtypeMarker(marker.element);})? ')' {retval.element = within; within.setTypeReference(withinTypeRef.element); setKeyword(retval.element, withinToken); };
	
withinMethod returns [WithinMethodPointcutExpression element]
@init{WithinMethodPointcutExpression within = new WithinMethodPointcutExpression();}
	: withinToken='within' '(' metref=methodReference ')' {retval.element = within; within.setMethodReference(metref.element); setKeyword(retval.element, withinToken); };

within returns [WithinPointcutExpression element]
	: withinTypeCL=withinType {retval.element = withinTypeCL.element;}
	| withinMethodCL=withinMethod {retval.element = withinMethodCL.element;}
	;

fieldReference returns [MemberReference element]
@init{String fullName = "";}
	: (initName=identifierRule {fullName = $initName.text;} ('.' appendName=identifierRule {fullName += "." + $appendName.text; })*) {retval.element = new MemberReference(fullName);}
	;
	
namedPointcutReference returns [PointcutReference element]
@init{List<NamedTargetExpression> arguments = new ArrayList<NamedTargetExpression>();}
	: decl=pointcutDecl '(' (params=argParams {arguments = params.element;})? end=')' {PointcutReference ref = new PointcutReference(decl.element); ref.addAllArguments(arguments); retval.element = ref;}
	;
	
argParams returns [List<NamedTargetExpression> element]
	: name=identifierRule (',' otherparams=argParams {retval.element=otherparams.element; })?
	 {if(retval.element == null) {
         	retval.element=new ArrayList<NamedTargetExpression>();
	  }
	  retval.element.add(0, new NamedTargetExpression($name.text));
         }
	;

advice returns [Advice element]
@init{TypeReference tref = null; List<NamedTargetExpression> arguments = new ArrayList<NamedTargetExpression>(); Modifier adviceTypeSpecifier = null;}
@after{setLocation(retval.element, retval.start, retval.stop);}
	: (t=type {tref=t.element;}| 'void' {tref = typeRef("void");})? advtype=adviceTypeModifier pars=formalParameters (advtypespec=adviceTypeModifierSpecifier {adviceTypeSpecifier = advtypespec.element; })? ':' pointcutExpr=pointcutExpression
	
	{
		retval.element=new JavaAdvice(tref);
		retval.element.setPointcutExpression(pointcutExpr.element);
		retval.element.addModifier(advtype.element);
		retval.element.addModifier(adviceTypeSpecifier);
		retval.element.addFormalParameters(pars.element);
	} 
	bdy=adviceBody
	{
		retval.element.setBody(bdy.element);
	}
	;
	
adviceBody returns [Block element]
    :   b=adviceBlock {retval.element = b.element;}
    ;
    
adviceBlock returns [Block element]
    :   '{' {retval.element = new Block();} (stat=adviceBlockStatement {if(stat != null) {retval.element.addStatement(stat.element);}})* '}'
    ;
    
adviceBlockStatement returns [Statement element]
@after{assert(retval.element != null);}
    :   local=localVariableDeclarationStatement {retval.element = local.element;}
    |   cd=classOrInterfaceDeclaration {retval.element = new LocalClassStatement(cd.element);}
    |	specialReturn=adviceReturnStatement {retval.element = specialReturn.element;}
    |   stat=statement {retval.element = stat.element;}
    ;
    
adviceReturnStatement returns [Statement element]
@after{setLocation(retval.element, (CommonToken)retval.start, (CommonToken)retval.stop);}
    : retkey='return' 
      {retval.element = new AdviceReturnStatement();
       setKeyword(retval.element,retkey);} 
       (retex=expression {((ReturnStatement)retval.element).setExpression(retex.element);
      })? ';'
    ;
    

adviceTypeModifier returns [Modifier element]
	: bf='before_' { retval.element = new Before(); setKeyword(retval.element, bf); }
	| af='after_' {retval.element = new After(); setKeyword(retval.element, af); }
	| ar='around_' {retval.element = new Around(); setKeyword(retval.element, ar); }
	;
	
adviceTypeModifierSpecifier returns [Modifier element]
@init{FormalParameter fp = null; FormalParameter exceptionParam = null;}
	: rt='returning' ('(' (retparam=formalParameter {fp = retparam.element;})? ')')? { Returning result = new Returning(); result.setReturnParameter(fp); retval.element = result; setKeyword(retval.element, rt); }
	| tw='throwing' ('(' (throwabletype=formalParameter {exceptionParam = throwabletype.element;})? ')')? { Throwing result = new Throwing(); result.setExceptionParameter(exceptionParam); retval.element = result; setKeyword(retval.element, tw); }
	;