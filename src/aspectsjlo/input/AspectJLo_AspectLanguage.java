// $ANTLR 3.3 Nov 30, 2010 12:45:30 AspectLanguage.g 2011-05-21 18:06:11

package aspectsjlo.input;

	import aspectsjava.model.advice.*;

	import chameleon.aspects.*;
	import chameleon.aspects.advice.*;
	import chameleon.aspects.advice.AdviceReturnStatement;
	import chameleon.aspects.advice.types.*;
	import chameleon.aspects.pointcut.*;
	import chameleon.aspects.pointcut.expression.*;
	
import chameleon.aspects.pointcut.expression.generic.*;
	import chameleon.aspects.pointcut.expression.namedpointcut.*;
	import chameleon.aspects.pointcut.expression.dynamicexpression.*;
	import chameleon.aspects.pointcut.expression.staticexpression.within.*;
	import chameleon.aspects.pointcut.expression.staticexpression.catchclause.*;
	import chameleon.aspects.pointcut.expression.staticexpression.fieldAccess.*;
	import chameleon.aspects.pointcut.expression.staticexpression.cast.*;


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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class AspectJLo_AspectLanguage extends ChameleonParser {
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__59=59;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__73=73;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__90=90;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__99=99;
    public static final int T__100=100;
    public static final int T__101=101;
    public static final int T__102=102;
    public static final int T__103=103;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int T__109=109;
    public static final int T__110=110;
    public static final int T__111=111;
    public static final int T__112=112;
    public static final int T__113=113;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__118=118;
    public static final int T__119=119;
    public static final int T__120=120;
    public static final int T__121=121;
    public static final int T__122=122;
    public static final int T__123=123;
    public static final int T__124=124;
    public static final int T__125=125;
    public static final int T__126=126;
    public static final int T__127=127;
    public static final int T__128=128;
    public static final int T__129=129;
    public static final int T__130=130;
    public static final int T__131=131;
    public static final int Identifier=4;
    public static final int ENUM=5;
    public static final int FloatingPointLiteral=6;
    public static final int CharacterLiteral=7;
    public static final int StringLiteral=8;
    public static final int HexLiteral=9;
    public static final int OctalLiteral=10;
    public static final int DecimalLiteral=11;
    public static final int ASSERT=12;
    public static final int HexDigit=13;
    public static final int IntegerTypeSuffix=14;
    public static final int Exponent=15;
    public static final int FloatTypeSuffix=16;
    public static final int EscapeSequence=17;
    public static final int UnicodeEscape=18;
    public static final int OctalEscape=19;
    public static final int Export=20;
    public static final int Connector=21;
    public static final int Connect=22;
    public static final int Name=23;
    public static final int Overrides=24;
    public static final int Letter=25;
    public static final int JavaIDDigit=26;
    public static final int WS=27;
    public static final int COMMENT=28;
    public static final int LINE_COMMENT=29;

    // delegates
    // delegators
    public AspectJLoParser gAspectJLo;
    public AspectJLoParser gParent;


        public AspectJLo_AspectLanguage(TokenStream input, AspectJLoParser gAspectJLo) {
            this(input, new RecognizerSharedState(), gAspectJLo);
        }
        public AspectJLo_AspectLanguage(TokenStream input, RecognizerSharedState state, AspectJLoParser gAspectJLo) {
            super(input, state);
            this.gAspectJLo = gAspectJLo;
             
            gParent = gAspectJLo;
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return AspectJLoParser.tokenNames; }
    public String getGrammarFileName() { return "AspectLanguage.g"; }


    	@Override
    	public Object compilationUnit() throws RecognitionException {
    		throw new RuntimeException();
    	}
    	public JavaTypeReference typeRef(String qn) {
    	    return ((Java)language()).createTypeReference(qn);
    	  }


    public static class aspect_return extends ParserRuleReturnScope {
        public Aspect element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "aspect"
    // AspectLanguage.g:18:1: aspect returns [Aspect element] : asp= 'aspect' name= identifierRule '{' ( (adv= advice ) | (ptc= pointcut ) )* '}' ;
    public final AspectJLo_AspectLanguage.aspect_return aspect() throws RecognitionException {
        AspectJLo_AspectLanguage.aspect_return retval = new AspectJLo_AspectLanguage.aspect_return();
        retval.start = input.LT(1);
        int aspect_StartIndex = input.index();
        Object root_0 = null;

        Token asp=null;
        Token char_literal1=null;
        Token char_literal2=null;
        AspectJLoParser.identifierRule_return name = null;

        AspectJLo_AspectLanguage.advice_return adv = null;

        AspectJLo_AspectLanguage.pointcut_return ptc = null;


        Object asp_tree=null;
        Object char_literal1_tree=null;
        Object char_literal2_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 409) ) { return retval; }
            // AspectLanguage.g:19:2: (asp= 'aspect' name= identifierRule '{' ( (adv= advice ) | (ptc= pointcut ) )* '}' )
            // AspectLanguage.g:19:4: asp= 'aspect' name= identifierRule '{' ( (adv= advice ) | (ptc= pointcut ) )* '}'
            {
            root_0 = (Object)adaptor.nil();

            asp=(Token)match(input,119,FOLLOW_119_in_aspect58); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            asp_tree = (Object)adaptor.create(asp);
            adaptor.addChild(root_0, asp_tree);
            }
            pushFollow(FOLLOW_identifierRule_in_aspect62);
            name=gAspectJLo.identifierRule();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, name.getTree());
            if ( state.backtracking==0 ) {
              retval.element = new Aspect((name!=null?input.toString(name.start,name.stop):null));
            }
            char_literal1=(Token)match(input,49,FOLLOW_49_in_aspect68); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal1_tree = (Object)adaptor.create(char_literal1);
            adaptor.addChild(root_0, char_literal1_tree);
            }
            // AspectLanguage.g:21:2: ( (adv= advice ) | (ptc= pointcut ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Identifier||(LA1_0>=Export && LA1_0<=Overrides)||LA1_0==52||(LA1_0>=61 && LA1_0<=68)||(LA1_0>=121 && LA1_0<=123)) ) {
                    alt1=1;
                }
                else if ( (LA1_0==120) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // AspectLanguage.g:21:3: (adv= advice )
            	    {
            	    // AspectLanguage.g:21:3: (adv= advice )
            	    // AspectLanguage.g:21:4: adv= advice
            	    {
            	    pushFollow(FOLLOW_advice_in_aspect77);
            	    adv=advice();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, adv.getTree());
            	    if ( state.backtracking==0 ) {
            	      retval.element.addAdvice(adv.element);
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // AspectLanguage.g:21:56: (ptc= pointcut )
            	    {
            	    // AspectLanguage.g:21:56: (ptc= pointcut )
            	    // AspectLanguage.g:21:57: ptc= pointcut
            	    {
            	    pushFollow(FOLLOW_pointcut_in_aspect84);
            	    ptc=pointcut();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ptc.getTree());
            	    if ( state.backtracking==0 ) {
            	      retval.element.addPointcut(ptc.element);
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            char_literal2=(Token)match(input,50,FOLLOW_50_in_aspect92); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal2_tree = (Object)adaptor.create(char_literal2);
            adaptor.addChild(root_0, char_literal2_tree);
            }
            if ( state.backtracking==0 ) {

              		//setKeyword(retval.element, asp);
              	
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 409, aspect_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "aspect"

    public static class pointcut_return extends ParserRuleReturnScope {
        public Pointcut element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pointcut"
    // AspectLanguage.g:29:1: pointcut returns [Pointcut element] : pct= 'pointcut' decl= pointcutDecl pars= formalParameters ':' expr= pointcutExpression ';' ;
    public final AspectJLo_AspectLanguage.pointcut_return pointcut() throws RecognitionException {
        AspectJLo_AspectLanguage.pointcut_return retval = new AspectJLo_AspectLanguage.pointcut_return();
        retval.start = input.LT(1);
        int pointcut_StartIndex = input.index();
        Object root_0 = null;

        Token pct=null;
        Token char_literal3=null;
        Token char_literal4=null;
        AspectJLo_AspectLanguage.pointcutDecl_return decl = null;

        AspectJLo_JavaP.formalParameters_return pars = null;

        AspectJLo_AspectLanguage.pointcutExpression_return expr = null;


        Object pct_tree=null;
        Object char_literal3_tree=null;
        Object char_literal4_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 410) ) { return retval; }
            // AspectLanguage.g:31:2: (pct= 'pointcut' decl= pointcutDecl pars= formalParameters ':' expr= pointcutExpression ';' )
            // AspectLanguage.g:31:4: pct= 'pointcut' decl= pointcutDecl pars= formalParameters ':' expr= pointcutExpression ';'
            {
            root_0 = (Object)adaptor.nil();

            pct=(Token)match(input,120,FOLLOW_120_in_pointcut119); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            pct_tree = (Object)adaptor.create(pct);
            adaptor.addChild(root_0, pct_tree);
            }
            pushFollow(FOLLOW_pointcutDecl_in_pointcut123);
            decl=pointcutDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, decl.getTree());
            pushFollow(FOLLOW_formalParameters_in_pointcut127);
            pars=gAspectJLo.formalParameters();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pars.getTree());
            char_literal3=(Token)match(input,80,FOLLOW_80_in_pointcut129); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal3_tree = (Object)adaptor.create(char_literal3);
            adaptor.addChild(root_0, char_literal3_tree);
            }
            pushFollow(FOLLOW_pointcutExpression_in_pointcut133);
            expr=pointcutExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr.getTree());
            char_literal4=(Token)match(input,31,FOLLOW_31_in_pointcut135); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal4_tree = (Object)adaptor.create(char_literal4);
            adaptor.addChild(root_0, char_literal4_tree);
            }
            if ( state.backtracking==0 ) {

              		SimpleNameDeclarationWithParametersHeader header = new SimpleNameDeclarationWithParametersHeader(decl.element);
              		header.addFormalParameters(pars.element);
              		setLocation(header, decl.start, pars.stop);
              		retval.element = new Pointcut(header, expr.element);
              		setKeyword(retval.element, pct);
              	
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              setLocation(retval.element, decl.start, decl.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 410, pointcut_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "pointcut"

    public static class pointcutDecl_return extends ParserRuleReturnScope {
        public String element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pointcutDecl"
    // AspectLanguage.g:42:1: pointcutDecl returns [String element] : name= identifierRule ;
    public final AspectJLo_AspectLanguage.pointcutDecl_return pointcutDecl() throws RecognitionException {
        AspectJLo_AspectLanguage.pointcutDecl_return retval = new AspectJLo_AspectLanguage.pointcutDecl_return();
        retval.start = input.LT(1);
        int pointcutDecl_StartIndex = input.index();
        Object root_0 = null;

        AspectJLoParser.identifierRule_return name = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 411) ) { return retval; }
            // AspectLanguage.g:43:2: (name= identifierRule )
            // AspectLanguage.g:43:4: name= identifierRule
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_identifierRule_in_pointcutDecl158);
            name=gAspectJLo.identifierRule();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, name.getTree());
            if ( state.backtracking==0 ) {
              retval.element = (name!=null?input.toString(name.start,name.stop):null);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 411, pointcutDecl_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "pointcutDecl"

    public static class pointcutExpression_return extends ParserRuleReturnScope {
        public PointcutExpression element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pointcutExpression"
    // AspectLanguage.g:46:1: pointcutExpression returns [PointcutExpression element] : (ifCheck= 'if' '(' exp= expression ')' | expr1= pointcutExpressionOr '&&' expr2= pointcutExpression | exprOr= pointcutExpressionOr );
    public final AspectJLo_AspectLanguage.pointcutExpression_return pointcutExpression() throws RecognitionException {
        AspectJLo_AspectLanguage.pointcutExpression_return retval = new AspectJLo_AspectLanguage.pointcutExpression_return();
        retval.start = input.LT(1);
        int pointcutExpression_StartIndex = input.index();
        Object root_0 = null;

        Token ifCheck=null;
        Token char_literal5=null;
        Token char_literal6=null;
        Token string_literal7=null;
        AspectJLoParser.expression_return exp = null;

        AspectJLo_AspectLanguage.pointcutExpressionOr_return expr1 = null;

        AspectJLo_AspectLanguage.pointcutExpression_return expr2 = null;

        AspectJLo_AspectLanguage.pointcutExpressionOr_return exprOr = null;


        Object ifCheck_tree=null;
        Object char_literal5_tree=null;
        Object char_literal6_tree=null;
        Object string_literal7_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 412) ) { return retval; }
            // AspectLanguage.g:48:2: (ifCheck= 'if' '(' exp= expression ')' | expr1= pointcutExpressionOr '&&' expr2= pointcutExpression | exprOr= pointcutExpressionOr )
            int alt2=3;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // AspectLanguage.g:48:4: ifCheck= 'if' '(' exp= expression ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    ifCheck=(Token)match(input,81,FOLLOW_81_in_pointcutExpression183); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ifCheck_tree = (Object)adaptor.create(ifCheck);
                    adaptor.addChild(root_0, ifCheck_tree);
                    }
                    char_literal5=(Token)match(input,71,FOLLOW_71_in_pointcutExpression185); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal5_tree = (Object)adaptor.create(char_literal5);
                    adaptor.addChild(root_0, char_literal5_tree);
                    }
                    pushFollow(FOLLOW_expression_in_pointcutExpression189);
                    exp=gAspectJLo.expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, exp.getTree());
                    char_literal6=(Token)match(input,72,FOLLOW_72_in_pointcutExpression191); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal6_tree = (Object)adaptor.create(char_literal6);
                    adaptor.addChild(root_0, char_literal6_tree);
                    }
                    if ( state.backtracking==0 ) {
                      IfPointcutExpression expr = new IfPointcutExpression(exp.element); retval.element = expr; setKeyword(retval.element, ifCheck);
                    }

                    }
                    break;
                case 2 :
                    // AspectLanguage.g:49:4: expr1= pointcutExpressionOr '&&' expr2= pointcutExpression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pointcutExpressionOr_in_pointcutExpression200);
                    expr1=pointcutExpressionOr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr1.getTree());
                    string_literal7=(Token)match(input,104,FOLLOW_104_in_pointcutExpression202); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal7_tree = (Object)adaptor.create(string_literal7);
                    adaptor.addChild(root_0, string_literal7_tree);
                    }
                    pushFollow(FOLLOW_pointcutExpression_in_pointcutExpression206);
                    expr2=pointcutExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr2.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = new PointcutExpressionAnd(expr1.element, expr2.element);
                    }

                    }
                    break;
                case 3 :
                    // AspectLanguage.g:50:4: exprOr= pointcutExpressionOr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pointcutExpressionOr_in_pointcutExpression215);
                    exprOr=pointcutExpressionOr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, exprOr.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = exprOr.element;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              setLocation(retval.element, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 412, pointcutExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "pointcutExpression"

    public static class pointcutExpressionOr_return extends ParserRuleReturnScope {
        public PointcutExpression element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pointcutExpressionOr"
    // AspectLanguage.g:53:1: pointcutExpressionOr returns [PointcutExpression element] : (expr1= pointcutAtom '||' expr2= pointcutExpressionOr | expr= pointcutAtom );
    public final AspectJLo_AspectLanguage.pointcutExpressionOr_return pointcutExpressionOr() throws RecognitionException {
        AspectJLo_AspectLanguage.pointcutExpressionOr_return retval = new AspectJLo_AspectLanguage.pointcutExpressionOr_return();
        retval.start = input.LT(1);
        int pointcutExpressionOr_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal8=null;
        AspectJLo_AspectLanguage.pointcutAtom_return expr1 = null;

        AspectJLo_AspectLanguage.pointcutExpressionOr_return expr2 = null;

        AspectJLo_AspectLanguage.pointcutAtom_return expr = null;


        Object string_literal8_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 413) ) { return retval; }
            // AspectLanguage.g:55:2: (expr1= pointcutAtom '||' expr2= pointcutExpressionOr | expr= pointcutAtom )
            int alt3=2;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // AspectLanguage.g:55:4: expr1= pointcutAtom '||' expr2= pointcutExpressionOr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pointcutAtom_in_pointcutExpressionOr238);
                    expr1=pointcutAtom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr1.getTree());
                    string_literal8=(Token)match(input,103,FOLLOW_103_in_pointcutExpressionOr240); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal8_tree = (Object)adaptor.create(string_literal8);
                    adaptor.addChild(root_0, string_literal8_tree);
                    }
                    pushFollow(FOLLOW_pointcutExpressionOr_in_pointcutExpressionOr244);
                    expr2=pointcutExpressionOr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr2.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = new PointcutExpressionOr(expr1.element, expr2.element);
                    }

                    }
                    break;
                case 2 :
                    // AspectLanguage.g:56:4: expr= pointcutAtom
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pointcutAtom_in_pointcutExpressionOr253);
                    expr=pointcutAtom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = expr.element;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              setLocation(retval.element, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 413, pointcutExpressionOr_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "pointcutExpressionOr"

    public static class pointcutAtom_return extends ParserRuleReturnScope {
        public PointcutExpression element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pointcutAtom"
    // AspectLanguage.g:59:1: pointcutAtom returns [PointcutExpression element] : (namedRef= namedPointcutReference | '!' expr1= pointcutAtom | '(' expr2= pointcutExpression ')' );
    public final AspectJLo_AspectLanguage.pointcutAtom_return pointcutAtom() throws RecognitionException {
        AspectJLo_AspectLanguage.pointcutAtom_return retval = new AspectJLo_AspectLanguage.pointcutAtom_return();
        retval.start = input.LT(1);
        int pointcutAtom_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal9=null;
        Token char_literal10=null;
        Token char_literal11=null;
        AspectJLo_AspectLanguage.namedPointcutReference_return namedRef = null;

        AspectJLo_AspectLanguage.pointcutAtom_return expr1 = null;

        AspectJLo_AspectLanguage.pointcutExpression_return expr2 = null;


        Object char_literal9_tree=null;
        Object char_literal10_tree=null;
        Object char_literal11_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 414) ) { return retval; }
            // AspectLanguage.g:61:2: (namedRef= namedPointcutReference | '!' expr1= pointcutAtom | '(' expr2= pointcutExpression ')' )
            int alt4=3;
            switch ( input.LA(1) ) {
            case Identifier:
            case Export:
            case Connector:
            case Connect:
            case Name:
            case Overrides:
                {
                alt4=1;
                }
                break;
            case 117:
                {
                alt4=2;
                }
                break;
            case 71:
                {
                alt4=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // AspectLanguage.g:61:4: namedRef= namedPointcutReference
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_namedPointcutReference_in_pointcutAtom277);
                    namedRef=namedPointcutReference();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, namedRef.getTree());
                    if ( state.backtracking==0 ) {
                      NamedPointcutExpression named = new NamedPointcutExpression(); named.setPointcutReference(namedRef.element); retval.element = named;
                    }

                    }
                    break;
                case 2 :
                    // AspectLanguage.g:62:4: '!' expr1= pointcutAtom
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal9=(Token)match(input,117,FOLLOW_117_in_pointcutAtom284); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal9_tree = (Object)adaptor.create(char_literal9);
                    adaptor.addChild(root_0, char_literal9_tree);
                    }
                    pushFollow(FOLLOW_pointcutAtom_in_pointcutAtom288);
                    expr1=pointcutAtom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr1.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = new PointcutExpressionNot(expr1.element);
                    }

                    }
                    break;
                case 3 :
                    // AspectLanguage.g:63:4: '(' expr2= pointcutExpression ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal10=(Token)match(input,71,FOLLOW_71_in_pointcutAtom295); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal10_tree = (Object)adaptor.create(char_literal10);
                    adaptor.addChild(root_0, char_literal10_tree);
                    }
                    pushFollow(FOLLOW_pointcutExpression_in_pointcutAtom299);
                    expr2=pointcutExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr2.getTree());
                    char_literal11=(Token)match(input,72,FOLLOW_72_in_pointcutAtom301); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal11_tree = (Object)adaptor.create(char_literal11);
                    adaptor.addChild(root_0, char_literal11_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = expr2.element;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              setLocation(retval.element, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 414, pointcutAtom_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "pointcutAtom"

    public static class namedPointcutReference_return extends ParserRuleReturnScope {
        public PointcutReference element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "namedPointcutReference"
    // AspectLanguage.g:66:1: namedPointcutReference returns [PointcutReference element] : decl= pointcutDecl '(' (params= argParams )? end= ')' ;
    public final AspectJLo_AspectLanguage.namedPointcutReference_return namedPointcutReference() throws RecognitionException {
        AspectJLo_AspectLanguage.namedPointcutReference_return retval = new AspectJLo_AspectLanguage.namedPointcutReference_return();
        retval.start = input.LT(1);
        int namedPointcutReference_StartIndex = input.index();
        Object root_0 = null;

        Token end=null;
        Token char_literal12=null;
        AspectJLo_AspectLanguage.pointcutDecl_return decl = null;

        AspectJLo_AspectLanguage.argParams_return params = null;


        Object end_tree=null;
        Object char_literal12_tree=null;

        List<NamedTargetExpression> arguments = new ArrayList<NamedTargetExpression>();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 415) ) { return retval; }
            // AspectLanguage.g:68:2: (decl= pointcutDecl '(' (params= argParams )? end= ')' )
            // AspectLanguage.g:68:4: decl= pointcutDecl '(' (params= argParams )? end= ')'
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_pointcutDecl_in_namedPointcutReference325);
            decl=pointcutDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, decl.getTree());
            char_literal12=(Token)match(input,71,FOLLOW_71_in_namedPointcutReference327); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal12_tree = (Object)adaptor.create(char_literal12);
            adaptor.addChild(root_0, char_literal12_tree);
            }
            // AspectLanguage.g:68:26: (params= argParams )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==Identifier||(LA5_0>=Export && LA5_0<=Overrides)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // AspectLanguage.g:68:27: params= argParams
                    {
                    pushFollow(FOLLOW_argParams_in_namedPointcutReference332);
                    params=argParams();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, params.getTree());
                    if ( state.backtracking==0 ) {
                      arguments = params.element;
                    }

                    }
                    break;

            }

            end=(Token)match(input,72,FOLLOW_72_in_namedPointcutReference340); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            end_tree = (Object)adaptor.create(end);
            adaptor.addChild(root_0, end_tree);
            }
            if ( state.backtracking==0 ) {
              PointcutReference ref = new PointcutReference(decl.element); ref.addAllArguments(arguments); retval.element = ref;
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 415, namedPointcutReference_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "namedPointcutReference"

    public static class argParams_return extends ParserRuleReturnScope {
        public List<NamedTargetExpression> element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "argParams"
    // AspectLanguage.g:71:1: argParams returns [List<NamedTargetExpression> element] : name= identifierRule ( ',' otherparams= argParams )? ;
    public final AspectJLo_AspectLanguage.argParams_return argParams() throws RecognitionException {
        AspectJLo_AspectLanguage.argParams_return retval = new AspectJLo_AspectLanguage.argParams_return();
        retval.start = input.LT(1);
        int argParams_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal13=null;
        AspectJLoParser.identifierRule_return name = null;

        AspectJLo_AspectLanguage.argParams_return otherparams = null;


        Object char_literal13_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 416) ) { return retval; }
            // AspectLanguage.g:72:2: (name= identifierRule ( ',' otherparams= argParams )? )
            // AspectLanguage.g:72:4: name= identifierRule ( ',' otherparams= argParams )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_identifierRule_in_argParams360);
            name=gAspectJLo.identifierRule();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, name.getTree());
            // AspectLanguage.g:72:24: ( ',' otherparams= argParams )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==46) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // AspectLanguage.g:72:25: ',' otherparams= argParams
                    {
                    char_literal13=(Token)match(input,46,FOLLOW_46_in_argParams363); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal13_tree = (Object)adaptor.create(char_literal13);
                    adaptor.addChild(root_0, char_literal13_tree);
                    }
                    pushFollow(FOLLOW_argParams_in_argParams367);
                    otherparams=argParams();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, otherparams.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element=otherparams.element; 
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              if(retval.element == null) {
                       	retval.element=new ArrayList<NamedTargetExpression>();
              	  }
              	  retval.element.add(0, new NamedTargetExpression((name!=null?input.toString(name.start,name.stop):null)));
                       
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 416, argParams_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "argParams"

    public static class advice_return extends ParserRuleReturnScope {
        public Advice element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "advice"
    // AspectLanguage.g:80:1: advice returns [Advice element] : (t= type | 'void' )? advtype= adviceTypeModifier pars= formalParameters (advtypespec= adviceTypeModifierSpecifier )? ':' pointcutExpr= pointcutExpression bdy= adviceBody ;
    public final AspectJLo_AspectLanguage.advice_return advice() throws RecognitionException {
        AspectJLo_AspectLanguage.advice_return retval = new AspectJLo_AspectLanguage.advice_return();
        retval.start = input.LT(1);
        int advice_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal14=null;
        Token char_literal15=null;
        AspectJLo_JavaP.type_return t = null;

        AspectJLo_AspectLanguage.adviceTypeModifier_return advtype = null;

        AspectJLo_JavaP.formalParameters_return pars = null;

        AspectJLo_AspectLanguage.adviceTypeModifierSpecifier_return advtypespec = null;

        AspectJLo_AspectLanguage.pointcutExpression_return pointcutExpr = null;

        AspectJLo_AspectLanguage.adviceBody_return bdy = null;


        Object string_literal14_tree=null;
        Object char_literal15_tree=null;

        TypeReference tref = null; List<NamedTargetExpression> arguments = new ArrayList<NamedTargetExpression>(); Modifier adviceTypeSpecifier = null;
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 417) ) { return retval; }
            // AspectLanguage.g:83:2: ( (t= type | 'void' )? advtype= adviceTypeModifier pars= formalParameters (advtypespec= adviceTypeModifierSpecifier )? ':' pointcutExpr= pointcutExpression bdy= adviceBody )
            // AspectLanguage.g:83:4: (t= type | 'void' )? advtype= adviceTypeModifier pars= formalParameters (advtypespec= adviceTypeModifierSpecifier )? ':' pointcutExpr= pointcutExpression bdy= adviceBody
            {
            root_0 = (Object)adaptor.nil();

            // AspectLanguage.g:83:4: (t= type | 'void' )?
            int alt7=3;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==Identifier||(LA7_0>=Export && LA7_0<=Overrides)||(LA7_0>=61 && LA7_0<=68)) ) {
                alt7=1;
            }
            else if ( (LA7_0==52) ) {
                alt7=2;
            }
            switch (alt7) {
                case 1 :
                    // AspectLanguage.g:83:5: t= type
                    {
                    pushFollow(FOLLOW_type_in_advice401);
                    t=gAspectJLo.type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
                    if ( state.backtracking==0 ) {
                      tref=t.element;
                    }

                    }
                    break;
                case 2 :
                    // AspectLanguage.g:83:31: 'void'
                    {
                    string_literal14=(Token)match(input,52,FOLLOW_52_in_advice406); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal14_tree = (Object)adaptor.create(string_literal14);
                    adaptor.addChild(root_0, string_literal14_tree);
                    }
                    if ( state.backtracking==0 ) {
                      tref = typeRef("void");
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_adviceTypeModifier_in_advice414);
            advtype=adviceTypeModifier();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, advtype.getTree());
            pushFollow(FOLLOW_formalParameters_in_advice418);
            pars=gAspectJLo.formalParameters();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pars.getTree());
            // AspectLanguage.g:83:115: (advtypespec= adviceTypeModifierSpecifier )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=124 && LA8_0<=125)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // AspectLanguage.g:83:116: advtypespec= adviceTypeModifierSpecifier
                    {
                    pushFollow(FOLLOW_adviceTypeModifierSpecifier_in_advice423);
                    advtypespec=adviceTypeModifierSpecifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, advtypespec.getTree());
                    if ( state.backtracking==0 ) {
                      adviceTypeSpecifier = advtypespec.element; 
                    }

                    }
                    break;

            }

            char_literal15=(Token)match(input,80,FOLLOW_80_in_advice429); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal15_tree = (Object)adaptor.create(char_literal15);
            adaptor.addChild(root_0, char_literal15_tree);
            }
            pushFollow(FOLLOW_pointcutExpression_in_advice433);
            pointcutExpr=pointcutExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutExpr.getTree());
            if ( state.backtracking==0 ) {

              		retval.element=new JavaAdvice(tref);
              		retval.element.setPointcutExpression(pointcutExpr.element);
              		retval.element.addModifier(advtype.element);
              		retval.element.addModifier(adviceTypeSpecifier);
              		retval.element.addFormalParameters(pars.element);
              	
            }
            pushFollow(FOLLOW_adviceBody_in_advice444);
            bdy=adviceBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, bdy.getTree());
            if ( state.backtracking==0 ) {

              		retval.element.setBody(bdy.element);
              	
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              setLocation(retval.element, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 417, advice_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "advice"

    public static class adviceBody_return extends ParserRuleReturnScope {
        public Block element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "adviceBody"
    // AspectLanguage.g:98:1: adviceBody returns [Block element] : b= adviceBlock ;
    public final AspectJLo_AspectLanguage.adviceBody_return adviceBody() throws RecognitionException {
        AspectJLo_AspectLanguage.adviceBody_return retval = new AspectJLo_AspectLanguage.adviceBody_return();
        retval.start = input.LT(1);
        int adviceBody_StartIndex = input.index();
        Object root_0 = null;

        AspectJLo_AspectLanguage.adviceBlock_return b = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 418) ) { return retval; }
            // AspectLanguage.g:99:5: (b= adviceBlock )
            // AspectLanguage.g:99:9: b= adviceBlock
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_adviceBlock_in_adviceBody470);
            b=adviceBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, b.getTree());
            if ( state.backtracking==0 ) {
              retval.element = b.element;
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 418, adviceBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "adviceBody"

    public static class adviceBlock_return extends ParserRuleReturnScope {
        public Block element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "adviceBlock"
    // AspectLanguage.g:102:1: adviceBlock returns [Block element] : '{' (stat= adviceBlockStatement )* '}' ;
    public final AspectJLo_AspectLanguage.adviceBlock_return adviceBlock() throws RecognitionException {
        AspectJLo_AspectLanguage.adviceBlock_return retval = new AspectJLo_AspectLanguage.adviceBlock_return();
        retval.start = input.LT(1);
        int adviceBlock_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal16=null;
        Token char_literal17=null;
        AspectJLo_AspectLanguage.adviceBlockStatement_return stat = null;


        Object char_literal16_tree=null;
        Object char_literal17_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 419) ) { return retval; }
            // AspectLanguage.g:103:5: ( '{' (stat= adviceBlockStatement )* '}' )
            // AspectLanguage.g:103:9: '{' (stat= adviceBlockStatement )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal16=(Token)match(input,49,FOLLOW_49_in_adviceBlock499); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal16_tree = (Object)adaptor.create(char_literal16);
            adaptor.addChild(root_0, char_literal16_tree);
            }
            if ( state.backtracking==0 ) {
              retval.element = new Block();
            }
            // AspectLanguage.g:103:45: (stat= adviceBlockStatement )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=Identifier && LA9_0<=ASSERT)||(LA9_0>=Export && LA9_0<=Overrides)||LA9_0==31||LA9_0==33||(LA9_0>=36 && LA9_0<=42)||LA9_0==49||(LA9_0>=51 && LA9_0<=52)||LA9_0==58||(LA9_0>=61 && LA9_0<=68)||(LA9_0>=70 && LA9_0<=71)||(LA9_0>=74 && LA9_0<=78)||LA9_0==81||(LA9_0>=83 && LA9_0<=86)||(LA9_0>=88 && LA9_0<=92)||(LA9_0>=110 && LA9_0<=111)||(LA9_0>=114 && LA9_0<=118)||LA9_0==126||(LA9_0>=128 && LA9_0<=130)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // AspectLanguage.g:103:46: stat= adviceBlockStatement
            	    {
            	    pushFollow(FOLLOW_adviceBlockStatement_in_adviceBlock506);
            	    stat=adviceBlockStatement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, stat.getTree());
            	    if ( state.backtracking==0 ) {
            	      if(stat != null) {retval.element.addStatement(stat.element);}
            	    }

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            char_literal17=(Token)match(input,50,FOLLOW_50_in_adviceBlock512); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal17_tree = (Object)adaptor.create(char_literal17);
            adaptor.addChild(root_0, char_literal17_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 419, adviceBlock_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "adviceBlock"

    public static class adviceBlockStatement_return extends ParserRuleReturnScope {
        public Statement element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "adviceBlockStatement"
    // AspectLanguage.g:106:1: adviceBlockStatement returns [Statement element] : (local= localVariableDeclarationStatement | cd= classOrInterfaceDeclaration | specialReturn= adviceReturnStatement | stat= statement );
    public final AspectJLo_AspectLanguage.adviceBlockStatement_return adviceBlockStatement() throws RecognitionException {
        AspectJLo_AspectLanguage.adviceBlockStatement_return retval = new AspectJLo_AspectLanguage.adviceBlockStatement_return();
        retval.start = input.LT(1);
        int adviceBlockStatement_StartIndex = input.index();
        Object root_0 = null;

        AspectJLo_JavaP.localVariableDeclarationStatement_return local = null;

        AspectJLo_JavaP.classOrInterfaceDeclaration_return cd = null;

        AspectJLo_AspectLanguage.adviceReturnStatement_return specialReturn = null;

        AspectJLo_JavaP.statement_return stat = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 420) ) { return retval; }
            // AspectLanguage.g:108:5: (local= localVariableDeclarationStatement | cd= classOrInterfaceDeclaration | specialReturn= adviceReturnStatement | stat= statement )
            int alt10=4;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // AspectLanguage.g:108:9: local= localVariableDeclarationStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_localVariableDeclarationStatement_in_adviceBlockStatement545);
                    local=gAspectJLo.localVariableDeclarationStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, local.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = local.element;
                    }

                    }
                    break;
                case 2 :
                    // AspectLanguage.g:109:9: cd= classOrInterfaceDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_classOrInterfaceDeclaration_in_adviceBlockStatement559);
                    cd=gAspectJLo.classOrInterfaceDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cd.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = new LocalClassStatement(cd.element);
                    }

                    }
                    break;
                case 3 :
                    // AspectLanguage.g:110:7: specialReturn= adviceReturnStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_adviceReturnStatement_in_adviceBlockStatement571);
                    specialReturn=adviceReturnStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, specialReturn.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = specialReturn.element;
                    }

                    }
                    break;
                case 4 :
                    // AspectLanguage.g:111:9: stat= statement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_statement_in_adviceBlockStatement585);
                    stat=gAspectJLo.statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, stat.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = stat.element;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              assert(retval.element != null);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 420, adviceBlockStatement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "adviceBlockStatement"

    public static class adviceReturnStatement_return extends ParserRuleReturnScope {
        public Statement element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "adviceReturnStatement"
    // AspectLanguage.g:114:1: adviceReturnStatement returns [Statement element] : retkey= 'return' (retex= expression )? ';' ;
    public final AspectJLo_AspectLanguage.adviceReturnStatement_return adviceReturnStatement() throws RecognitionException {
        AspectJLo_AspectLanguage.adviceReturnStatement_return retval = new AspectJLo_AspectLanguage.adviceReturnStatement_return();
        retval.start = input.LT(1);
        int adviceReturnStatement_StartIndex = input.index();
        Object root_0 = null;

        Token retkey=null;
        Token char_literal18=null;
        AspectJLoParser.expression_return retex = null;


        Object retkey_tree=null;
        Object char_literal18_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 421) ) { return retval; }
            // AspectLanguage.g:116:5: (retkey= 'return' (retex= expression )? ';' )
            // AspectLanguage.g:116:7: retkey= 'return' (retex= expression )? ';'
            {
            root_0 = (Object)adaptor.nil();

            retkey=(Token)match(input,89,FOLLOW_89_in_adviceReturnStatement618); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            retkey_tree = (Object)adaptor.create(retkey);
            adaptor.addChild(root_0, retkey_tree);
            }
            if ( state.backtracking==0 ) {
              retval.element = new AdviceReturnStatement();
                     setKeyword(retval.element,retkey);
            }
            // AspectLanguage.g:119:8: (retex= expression )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==Identifier||(LA11_0>=FloatingPointLiteral && LA11_0<=DecimalLiteral)||(LA11_0>=Export && LA11_0<=Overrides)||LA11_0==52||(LA11_0>=61 && LA11_0<=68)||(LA11_0>=70 && LA11_0<=71)||(LA11_0>=74 && LA11_0<=77)||(LA11_0>=110 && LA11_0<=111)||(LA11_0>=114 && LA11_0<=118)||LA11_0==126||(LA11_0>=128 && LA11_0<=130)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // AspectLanguage.g:119:9: retex= expression
                    {
                    pushFollow(FOLLOW_expression_in_adviceReturnStatement640);
                    retex=gAspectJLo.expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, retex.getTree());
                    if ( state.backtracking==0 ) {
                      ((ReturnStatement)retval.element).setExpression(retex.element);
                            
                    }

                    }
                    break;

            }

            char_literal18=(Token)match(input,31,FOLLOW_31_in_adviceReturnStatement646); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal18_tree = (Object)adaptor.create(char_literal18);
            adaptor.addChild(root_0, char_literal18_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              setLocation(retval.element, (CommonToken)retval.start, (CommonToken)retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 421, adviceReturnStatement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "adviceReturnStatement"

    public static class adviceTypeModifier_return extends ParserRuleReturnScope {
        public Modifier element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "adviceTypeModifier"
    // AspectLanguage.g:124:1: adviceTypeModifier returns [Modifier element] : (bf= 'before_' | af= 'after_' | ar= 'around_' );
    public final AspectJLo_AspectLanguage.adviceTypeModifier_return adviceTypeModifier() throws RecognitionException {
        AspectJLo_AspectLanguage.adviceTypeModifier_return retval = new AspectJLo_AspectLanguage.adviceTypeModifier_return();
        retval.start = input.LT(1);
        int adviceTypeModifier_StartIndex = input.index();
        Object root_0 = null;

        Token bf=null;
        Token af=null;
        Token ar=null;

        Object bf_tree=null;
        Object af_tree=null;
        Object ar_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 422) ) { return retval; }
            // AspectLanguage.g:125:2: (bf= 'before_' | af= 'after_' | ar= 'around_' )
            int alt12=3;
            switch ( input.LA(1) ) {
            case 121:
                {
                alt12=1;
                }
                break;
            case 122:
                {
                alt12=2;
                }
                break;
            case 123:
                {
                alt12=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // AspectLanguage.g:125:4: bf= 'before_'
                    {
                    root_0 = (Object)adaptor.nil();

                    bf=(Token)match(input,121,FOLLOW_121_in_adviceTypeModifier671); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    bf_tree = (Object)adaptor.create(bf);
                    adaptor.addChild(root_0, bf_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.element = new Before(); setKeyword(retval.element, bf); 
                    }

                    }
                    break;
                case 2 :
                    // AspectLanguage.g:126:4: af= 'after_'
                    {
                    root_0 = (Object)adaptor.nil();

                    af=(Token)match(input,122,FOLLOW_122_in_adviceTypeModifier680); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    af_tree = (Object)adaptor.create(af);
                    adaptor.addChild(root_0, af_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new After(); setKeyword(retval.element, af); 
                    }

                    }
                    break;
                case 3 :
                    // AspectLanguage.g:127:4: ar= 'around_'
                    {
                    root_0 = (Object)adaptor.nil();

                    ar=(Token)match(input,123,FOLLOW_123_in_adviceTypeModifier689); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ar_tree = (Object)adaptor.create(ar);
                    adaptor.addChild(root_0, ar_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new Around(); setKeyword(retval.element, ar); 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 422, adviceTypeModifier_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "adviceTypeModifier"

    public static class adviceTypeModifierSpecifier_return extends ParserRuleReturnScope {
        public Modifier element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "adviceTypeModifierSpecifier"
    // AspectLanguage.g:130:1: adviceTypeModifierSpecifier returns [Modifier element] : (rt= 'returning' ( '(' (retparam= formalParameter )? ')' )? | tw= 'throwing' ( '(' (throwabletype= formalParameter )? ')' )? );
    public final AspectJLo_AspectLanguage.adviceTypeModifierSpecifier_return adviceTypeModifierSpecifier() throws RecognitionException {
        AspectJLo_AspectLanguage.adviceTypeModifierSpecifier_return retval = new AspectJLo_AspectLanguage.adviceTypeModifierSpecifier_return();
        retval.start = input.LT(1);
        int adviceTypeModifierSpecifier_StartIndex = input.index();
        Object root_0 = null;

        Token rt=null;
        Token tw=null;
        Token char_literal19=null;
        Token char_literal20=null;
        Token char_literal21=null;
        Token char_literal22=null;
        AspectJLo_JavaP.formalParameter_return retparam = null;

        AspectJLo_JavaP.formalParameter_return throwabletype = null;


        Object rt_tree=null;
        Object tw_tree=null;
        Object char_literal19_tree=null;
        Object char_literal20_tree=null;
        Object char_literal21_tree=null;
        Object char_literal22_tree=null;

        FormalParameter fp = null; FormalParameter exceptionParam = null;
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 423) ) { return retval; }
            // AspectLanguage.g:132:2: (rt= 'returning' ( '(' (retparam= formalParameter )? ')' )? | tw= 'throwing' ( '(' (throwabletype= formalParameter )? ')' )? )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==124) ) {
                alt17=1;
            }
            else if ( (LA17_0==125) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // AspectLanguage.g:132:4: rt= 'returning' ( '(' (retparam= formalParameter )? ')' )?
                    {
                    root_0 = (Object)adaptor.nil();

                    rt=(Token)match(input,124,FOLLOW_124_in_adviceTypeModifierSpecifier713); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    rt_tree = (Object)adaptor.create(rt);
                    adaptor.addChild(root_0, rt_tree);
                    }
                    // AspectLanguage.g:132:19: ( '(' (retparam= formalParameter )? ')' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==71) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // AspectLanguage.g:132:20: '(' (retparam= formalParameter )? ')'
                            {
                            char_literal19=(Token)match(input,71,FOLLOW_71_in_adviceTypeModifierSpecifier716); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal19_tree = (Object)adaptor.create(char_literal19);
                            adaptor.addChild(root_0, char_literal19_tree);
                            }
                            // AspectLanguage.g:132:24: (retparam= formalParameter )?
                            int alt13=2;
                            int LA13_0 = input.LA(1);

                            if ( (LA13_0==Identifier||(LA13_0>=Export && LA13_0<=Overrides)||LA13_0==40||(LA13_0>=61 && LA13_0<=68)||LA13_0==78) ) {
                                alt13=1;
                            }
                            switch (alt13) {
                                case 1 :
                                    // AspectLanguage.g:132:25: retparam= formalParameter
                                    {
                                    pushFollow(FOLLOW_formalParameter_in_adviceTypeModifierSpecifier721);
                                    retparam=gAspectJLo.formalParameter();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) adaptor.addChild(root_0, retparam.getTree());
                                    if ( state.backtracking==0 ) {
                                      fp = retparam.element;
                                    }

                                    }
                                    break;

                            }

                            char_literal20=(Token)match(input,72,FOLLOW_72_in_adviceTypeModifierSpecifier727); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal20_tree = (Object)adaptor.create(char_literal20);
                            adaptor.addChild(root_0, char_literal20_tree);
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                       Returning result = new Returning(); result.setReturnParameter(fp); retval.element = result; setKeyword(retval.element, rt); 
                    }

                    }
                    break;
                case 2 :
                    // AspectLanguage.g:133:4: tw= 'throwing' ( '(' (throwabletype= formalParameter )? ')' )?
                    {
                    root_0 = (Object)adaptor.nil();

                    tw=(Token)match(input,125,FOLLOW_125_in_adviceTypeModifierSpecifier738); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    tw_tree = (Object)adaptor.create(tw);
                    adaptor.addChild(root_0, tw_tree);
                    }
                    // AspectLanguage.g:133:18: ( '(' (throwabletype= formalParameter )? ')' )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==71) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // AspectLanguage.g:133:19: '(' (throwabletype= formalParameter )? ')'
                            {
                            char_literal21=(Token)match(input,71,FOLLOW_71_in_adviceTypeModifierSpecifier741); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal21_tree = (Object)adaptor.create(char_literal21);
                            adaptor.addChild(root_0, char_literal21_tree);
                            }
                            // AspectLanguage.g:133:23: (throwabletype= formalParameter )?
                            int alt15=2;
                            int LA15_0 = input.LA(1);

                            if ( (LA15_0==Identifier||(LA15_0>=Export && LA15_0<=Overrides)||LA15_0==40||(LA15_0>=61 && LA15_0<=68)||LA15_0==78) ) {
                                alt15=1;
                            }
                            switch (alt15) {
                                case 1 :
                                    // AspectLanguage.g:133:24: throwabletype= formalParameter
                                    {
                                    pushFollow(FOLLOW_formalParameter_in_adviceTypeModifierSpecifier746);
                                    throwabletype=gAspectJLo.formalParameter();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) adaptor.addChild(root_0, throwabletype.getTree());
                                    if ( state.backtracking==0 ) {
                                      exceptionParam = throwabletype.element;
                                    }

                                    }
                                    break;

                            }

                            char_literal22=(Token)match(input,72,FOLLOW_72_in_adviceTypeModifierSpecifier752); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal22_tree = (Object)adaptor.create(char_literal22);
                            adaptor.addChild(root_0, char_literal22_tree);
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                       Throwing result = new Throwing(); result.setExceptionParameter(exceptionParam); retval.element = result; setKeyword(retval.element, tw); 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 423, adviceTypeModifierSpecifier_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "adviceTypeModifierSpecifier"

    // $ANTLR start synpred4_AspectLanguage
    public final void synpred4_AspectLanguage_fragment() throws RecognitionException {   
        AspectJLo_AspectLanguage.pointcutExpressionOr_return expr1 = null;

        AspectJLo_AspectLanguage.pointcutExpression_return expr2 = null;


        // AspectLanguage.g:49:4: (expr1= pointcutExpressionOr '&&' expr2= pointcutExpression )
        // AspectLanguage.g:49:4: expr1= pointcutExpressionOr '&&' expr2= pointcutExpression
        {
        pushFollow(FOLLOW_pointcutExpressionOr_in_synpred4_AspectLanguage200);
        expr1=pointcutExpressionOr();

        state._fsp--;
        if (state.failed) return ;
        match(input,104,FOLLOW_104_in_synpred4_AspectLanguage202); if (state.failed) return ;
        pushFollow(FOLLOW_pointcutExpression_in_synpred4_AspectLanguage206);
        expr2=pointcutExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_AspectLanguage

    // $ANTLR start synpred5_AspectLanguage
    public final void synpred5_AspectLanguage_fragment() throws RecognitionException {   
        AspectJLo_AspectLanguage.pointcutAtom_return expr1 = null;

        AspectJLo_AspectLanguage.pointcutExpressionOr_return expr2 = null;


        // AspectLanguage.g:55:4: (expr1= pointcutAtom '||' expr2= pointcutExpressionOr )
        // AspectLanguage.g:55:4: expr1= pointcutAtom '||' expr2= pointcutExpressionOr
        {
        pushFollow(FOLLOW_pointcutAtom_in_synpred5_AspectLanguage238);
        expr1=pointcutAtom();

        state._fsp--;
        if (state.failed) return ;
        match(input,103,FOLLOW_103_in_synpred5_AspectLanguage240); if (state.failed) return ;
        pushFollow(FOLLOW_pointcutExpressionOr_in_synpred5_AspectLanguage244);
        expr2=pointcutExpressionOr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_AspectLanguage

    // $ANTLR start synpred14_AspectLanguage
    public final void synpred14_AspectLanguage_fragment() throws RecognitionException {   
        AspectJLo_JavaP.localVariableDeclarationStatement_return local = null;


        // AspectLanguage.g:108:9: (local= localVariableDeclarationStatement )
        // AspectLanguage.g:108:9: local= localVariableDeclarationStatement
        {
        pushFollow(FOLLOW_localVariableDeclarationStatement_in_synpred14_AspectLanguage545);
        local=gAspectJLo.localVariableDeclarationStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_AspectLanguage

    // $ANTLR start synpred15_AspectLanguage
    public final void synpred15_AspectLanguage_fragment() throws RecognitionException {   
        AspectJLo_JavaP.classOrInterfaceDeclaration_return cd = null;


        // AspectLanguage.g:109:9: (cd= classOrInterfaceDeclaration )
        // AspectLanguage.g:109:9: cd= classOrInterfaceDeclaration
        {
        pushFollow(FOLLOW_classOrInterfaceDeclaration_in_synpred15_AspectLanguage559);
        cd=gAspectJLo.classOrInterfaceDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_AspectLanguage

    // $ANTLR start synpred16_AspectLanguage
    public final void synpred16_AspectLanguage_fragment() throws RecognitionException {   
        AspectJLo_AspectLanguage.adviceReturnStatement_return specialReturn = null;


        // AspectLanguage.g:110:7: (specialReturn= adviceReturnStatement )
        // AspectLanguage.g:110:7: specialReturn= adviceReturnStatement
        {
        pushFollow(FOLLOW_adviceReturnStatement_in_synpred16_AspectLanguage571);
        specialReturn=adviceReturnStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_AspectLanguage

    // Delegated rules

    public final boolean synpred16_AspectLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_AspectLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_AspectLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_AspectLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_AspectLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_AspectLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_AspectLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_AspectLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_AspectLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_AspectLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA3 dfa3 = new DFA3(this);
    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA2_eotS =
        "\14\uffff";
    static final String DFA2_eofS =
        "\14\uffff";
    static final String DFA2_minS =
        "\1\4\1\uffff\10\0\2\uffff";
    static final String DFA2_maxS =
        "\1\165\1\uffff\10\0\2\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\10\uffff\1\2\1\3";
    static final String DFA2_specialS =
        "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\2\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\2\17\uffff\1\3\1\4\1\5\1\6\1\7\56\uffff\1\11\11\uffff\1"+
            "\1\43\uffff\1\10",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "46:1: pointcutExpression returns [PointcutExpression element] : (ifCheck= 'if' '(' exp= expression ')' | expr1= pointcutExpressionOr '&&' expr2= pointcutExpression | exprOr= pointcutExpressionOr );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA2_2 = input.LA(1);

                         
                        int index2_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_AspectLanguage()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index2_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA2_3 = input.LA(1);

                         
                        int index2_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_AspectLanguage()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index2_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA2_4 = input.LA(1);

                         
                        int index2_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_AspectLanguage()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index2_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA2_5 = input.LA(1);

                         
                        int index2_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_AspectLanguage()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index2_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA2_6 = input.LA(1);

                         
                        int index2_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_AspectLanguage()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index2_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA2_7 = input.LA(1);

                         
                        int index2_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_AspectLanguage()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index2_7);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA2_8 = input.LA(1);

                         
                        int index2_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_AspectLanguage()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index2_8);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA2_9 = input.LA(1);

                         
                        int index2_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_AspectLanguage()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index2_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 2, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA3_eotS =
        "\13\uffff";
    static final String DFA3_eofS =
        "\13\uffff";
    static final String DFA3_minS =
        "\1\4\10\0\2\uffff";
    static final String DFA3_maxS =
        "\1\165\10\0\2\uffff";
    static final String DFA3_acceptS =
        "\11\uffff\1\1\1\2";
    static final String DFA3_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\2\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\1\17\uffff\1\2\1\3\1\4\1\5\1\6\56\uffff\1\10\55\uffff\1"+
            "\7",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "53:1: pointcutExpressionOr returns [PointcutExpression element] : (expr1= pointcutAtom '||' expr2= pointcutExpressionOr | expr= pointcutAtom );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA3_1 = input.LA(1);

                         
                        int index3_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_AspectLanguage()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index3_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA3_2 = input.LA(1);

                         
                        int index3_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_AspectLanguage()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index3_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA3_3 = input.LA(1);

                         
                        int index3_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_AspectLanguage()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index3_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA3_4 = input.LA(1);

                         
                        int index3_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_AspectLanguage()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index3_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA3_5 = input.LA(1);

                         
                        int index3_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_AspectLanguage()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index3_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA3_6 = input.LA(1);

                         
                        int index3_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_AspectLanguage()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index3_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA3_7 = input.LA(1);

                         
                        int index3_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_AspectLanguage()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index3_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA3_8 = input.LA(1);

                         
                        int index3_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_AspectLanguage()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index3_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 3, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA10_eotS =
        "\102\uffff";
    static final String DFA10_eofS =
        "\102\uffff";
    static final String DFA10_minS =
        "\1\4\20\0\11\uffff\1\0\47\uffff";
    static final String DFA10_maxS =
        "\1\u0082\20\0\11\uffff\1\0\47\uffff";
    static final String DFA10_acceptS =
        "\21\uffff\1\2\11\uffff\1\4\44\uffff\1\1\1\3";
    static final String DFA10_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\1\17\11\uffff\1\20\47\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\3\1\21\7\33\7\uffff\1\4\1\5\1\6\1\7\1\10\6\uffff\1\33\1"+
            "\uffff\1\21\2\uffff\4\21\1\1\2\21\6\uffff\1\33\1\uffff\1\21"+
            "\1\33\5\uffff\1\33\2\uffff\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
            "\1\20\1\uffff\2\33\2\uffff\4\33\1\2\2\uffff\1\33\1\uffff\4\33"+
            "\1\uffff\1\33\1\32\3\33\21\uffff\2\33\2\uffff\5\33\7\uffff\1"+
            "\33\1\uffff\3\33",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "106:1: adviceBlockStatement returns [Statement element] : (local= localVariableDeclarationStatement | cd= classOrInterfaceDeclaration | specialReturn= adviceReturnStatement | stat= statement );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA10_1 = input.LA(1);

                         
                        int index10_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_AspectLanguage()) ) {s = 64;}

                        else if ( (synpred15_AspectLanguage()) ) {s = 17;}

                         
                        input.seek(index10_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA10_2 = input.LA(1);

                         
                        int index10_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_AspectLanguage()) ) {s = 64;}

                        else if ( (synpred15_AspectLanguage()) ) {s = 17;}

                         
                        input.seek(index10_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA10_3 = input.LA(1);

                         
                        int index10_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_AspectLanguage()) ) {s = 64;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index10_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA10_4 = input.LA(1);

                         
                        int index10_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_AspectLanguage()) ) {s = 64;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index10_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA10_5 = input.LA(1);

                         
                        int index10_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_AspectLanguage()) ) {s = 64;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index10_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA10_6 = input.LA(1);

                         
                        int index10_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_AspectLanguage()) ) {s = 64;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index10_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA10_7 = input.LA(1);

                         
                        int index10_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_AspectLanguage()) ) {s = 64;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index10_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA10_8 = input.LA(1);

                         
                        int index10_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_AspectLanguage()) ) {s = 64;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index10_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA10_9 = input.LA(1);

                         
                        int index10_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_AspectLanguage()) ) {s = 64;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index10_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA10_10 = input.LA(1);

                         
                        int index10_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_AspectLanguage()) ) {s = 64;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index10_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA10_11 = input.LA(1);

                         
                        int index10_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_AspectLanguage()) ) {s = 64;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index10_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA10_12 = input.LA(1);

                         
                        int index10_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_AspectLanguage()) ) {s = 64;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index10_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA10_13 = input.LA(1);

                         
                        int index10_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_AspectLanguage()) ) {s = 64;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index10_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA10_14 = input.LA(1);

                         
                        int index10_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_AspectLanguage()) ) {s = 64;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index10_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA10_15 = input.LA(1);

                         
                        int index10_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_AspectLanguage()) ) {s = 64;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index10_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA10_16 = input.LA(1);

                         
                        int index10_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_AspectLanguage()) ) {s = 64;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index10_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA10_26 = input.LA(1);

                         
                        int index10_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_AspectLanguage()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index10_26);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 10, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_119_in_aspect58 = new BitSet(new long[]{0x0000000001F00010L});
    public static final BitSet FOLLOW_identifierRule_in_aspect62 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_aspect68 = new BitSet(new long[]{0xE014000001F00010L,0x0F0000000000001FL});
    public static final BitSet FOLLOW_advice_in_aspect77 = new BitSet(new long[]{0xE014000001F00010L,0x0F0000000000001FL});
    public static final BitSet FOLLOW_pointcut_in_aspect84 = new BitSet(new long[]{0xE014000001F00010L,0x0F0000000000001FL});
    public static final BitSet FOLLOW_50_in_aspect92 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_pointcut119 = new BitSet(new long[]{0x0000000001F00010L});
    public static final BitSet FOLLOW_pointcutDecl_in_pointcut123 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_formalParameters_in_pointcut127 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_pointcut129 = new BitSet(new long[]{0x0000000001F00010L,0x0020000000020080L});
    public static final BitSet FOLLOW_pointcutExpression_in_pointcut133 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_pointcut135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierRule_in_pointcutDecl158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_pointcutExpression183 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_pointcutExpression185 = new BitSet(new long[]{0xE010000001F00FD0L,0x407CC00000003CDFL,0x0000000000000007L});
    public static final BitSet FOLLOW_expression_in_pointcutExpression189 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_pointcutExpression191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutExpressionOr_in_pointcutExpression200 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_104_in_pointcutExpression202 = new BitSet(new long[]{0x0000000001F00010L,0x0020000000020080L});
    public static final BitSet FOLLOW_pointcutExpression_in_pointcutExpression206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutExpressionOr_in_pointcutExpression215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutAtom_in_pointcutExpressionOr238 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_pointcutExpressionOr240 = new BitSet(new long[]{0x0000000001F00010L,0x0020000000000080L});
    public static final BitSet FOLLOW_pointcutExpressionOr_in_pointcutExpressionOr244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutAtom_in_pointcutExpressionOr253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_namedPointcutReference_in_pointcutAtom277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_pointcutAtom284 = new BitSet(new long[]{0x0000000001F00010L,0x0020000000000080L});
    public static final BitSet FOLLOW_pointcutAtom_in_pointcutAtom288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_pointcutAtom295 = new BitSet(new long[]{0x0000000001F00010L,0x0020000000020080L});
    public static final BitSet FOLLOW_pointcutExpression_in_pointcutAtom299 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_pointcutAtom301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutDecl_in_namedPointcutReference325 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_namedPointcutReference327 = new BitSet(new long[]{0x0000000001F00010L,0x0000000000000100L});
    public static final BitSet FOLLOW_argParams_in_namedPointcutReference332 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_namedPointcutReference340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierRule_in_argParams360 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_46_in_argParams363 = new BitSet(new long[]{0x0000000001F00010L});
    public static final BitSet FOLLOW_argParams_in_argParams367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_advice401 = new BitSet(new long[]{0xE010000001F00010L,0x0E0000000000001FL});
    public static final BitSet FOLLOW_52_in_advice406 = new BitSet(new long[]{0xE010000001F00010L,0x0E0000000000001FL});
    public static final BitSet FOLLOW_adviceTypeModifier_in_advice414 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_formalParameters_in_advice418 = new BitSet(new long[]{0x0000000000000000L,0x3000000000010000L});
    public static final BitSet FOLLOW_adviceTypeModifierSpecifier_in_advice423 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_advice429 = new BitSet(new long[]{0x0000000001F00010L,0x0020000000020080L});
    public static final BitSet FOLLOW_pointcutExpression_in_advice433 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_adviceBody_in_advice444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceBlock_in_adviceBody470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_adviceBlock499 = new BitSet(new long[]{0xE41E07F281F01FF0L,0x407CC0001F7A7CDFL,0x0000000000000007L});
    public static final BitSet FOLLOW_adviceBlockStatement_in_adviceBlock506 = new BitSet(new long[]{0xE41E07F281F01FF0L,0x407CC0001F7A7CDFL,0x0000000000000007L});
    public static final BitSet FOLLOW_50_in_adviceBlock512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localVariableDeclarationStatement_in_adviceBlockStatement545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceDeclaration_in_adviceBlockStatement559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceReturnStatement_in_adviceBlockStatement571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_adviceBlockStatement585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_adviceReturnStatement618 = new BitSet(new long[]{0xE010000081F00FD0L,0x407CC00000003CDFL,0x0000000000000007L});
    public static final BitSet FOLLOW_expression_in_adviceReturnStatement640 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_adviceReturnStatement646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_adviceTypeModifier671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_adviceTypeModifier680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_adviceTypeModifier689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_adviceTypeModifierSpecifier713 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_adviceTypeModifierSpecifier716 = new BitSet(new long[]{0xE000010001F00010L,0x000000000000411FL});
    public static final BitSet FOLLOW_formalParameter_in_adviceTypeModifierSpecifier721 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_adviceTypeModifierSpecifier727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_adviceTypeModifierSpecifier738 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_adviceTypeModifierSpecifier741 = new BitSet(new long[]{0xE000010001F00010L,0x000000000000411FL});
    public static final BitSet FOLLOW_formalParameter_in_adviceTypeModifierSpecifier746 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_adviceTypeModifierSpecifier752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutExpressionOr_in_synpred4_AspectLanguage200 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_104_in_synpred4_AspectLanguage202 = new BitSet(new long[]{0x0000000001F00010L,0x0020000000020080L});
    public static final BitSet FOLLOW_pointcutExpression_in_synpred4_AspectLanguage206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutAtom_in_synpred5_AspectLanguage238 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_synpred5_AspectLanguage240 = new BitSet(new long[]{0x0000000001F00010L,0x0020000000000080L});
    public static final BitSet FOLLOW_pointcutExpressionOr_in_synpred5_AspectLanguage244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localVariableDeclarationStatement_in_synpred14_AspectLanguage545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceDeclaration_in_synpred15_AspectLanguage559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceReturnStatement_in_synpred16_AspectLanguage571 = new BitSet(new long[]{0x0000000000000002L});

}