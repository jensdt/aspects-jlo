// $ANTLR 3.3 Nov 30, 2010 12:45:30 C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g 2011-06-01 00:08:05

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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class AspectJLoParser extends ChameleonParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Identifier", "ENUM", "FloatingPointLiteral", "CharacterLiteral", "StringLiteral", "HexLiteral", "OctalLiteral", "DecimalLiteral", "ASSERT", "HexDigit", "IntegerTypeSuffix", "Exponent", "FloatTypeSuffix", "EscapeSequence", "UnicodeEscape", "OctalEscape", "Export", "Connector", "Connect", "Name", "Overrides", "Letter", "JavaIDDigit", "WS", "COMMENT", "LINE_COMMENT", "IdentifierWithWC", "'package'", "';'", "'import'", "'static'", "'.'", "'*'", "'public'", "'protected'", "'private'", "'abstract'", "'final'", "'strictfp'", "'class'", "'extends'", "'implements'", "'<'", "','", "'>'", "'&'", "'{'", "'}'", "'interface'", "'void'", "'['", "']'", "'throws'", "'='", "'native'", "'synchronized'", "'transient'", "'volatile'", "'boolean'", "'char'", "'byte'", "'short'", "'int'", "'long'", "'float'", "'double'", "'?'", "'super'", "'('", "')'", "'...'", "'this'", "'null'", "'true'", "'false'", "'@'", "'default'", "':'", "'if'", "'else'", "'for'", "'while'", "'do'", "'try'", "'finally'", "'switch'", "'return'", "'throw'", "'break'", "'continue'", "'catch'", "'case'", "'+='", "'-='", "'*='", "'/='", "'&='", "'|='", "'^='", "'%='", "'||'", "'&&'", "'|'", "'^'", "'=='", "'!='", "'instanceof'", "'+'", "'-'", "'/'", "'%'", "'++'", "'--'", "'~'", "'!'", "'new'", "'subobject'", "'alias'", "'proceed'", "'#'", "'outer'", "'rooot'", "'->'", "'aspect'", "'pointcut'", "'call'", "'subobjectRead'", "'callAnnotated'", "'emptyHandler'", "'fieldRead'", "'typeHandler'", "'cast'", "'arguments'", "'thisType'", "'targetType'", "'within'", "'before_'", "'after_'", "'around_'", "'returning'", "'throwing'"
    };
    public static final int EOF=-1;
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
    public static final int T__132=132;
    public static final int T__133=133;
    public static final int T__134=134;
    public static final int T__135=135;
    public static final int T__136=136;
    public static final int T__137=137;
    public static final int T__138=138;
    public static final int T__139=139;
    public static final int T__140=140;
    public static final int T__141=141;
    public static final int T__142=142;
    public static final int T__143=143;
    public static final int T__144=144;
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
    public static final int IdentifierWithWC=30;

    // delegates
    public AspectJLo_JavaP gJavaP;
    // delegators


        public AspectJLoParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public AspectJLoParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[549+1];
             
            gJavaP = new AspectJLo_JavaP(input, state, this);         
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
        gJavaP.setTreeAdaptor(this.adaptor);
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return AspectJLoParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g"; }


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
      
      


    public static class identifierRule_return extends ParserRuleReturnScope {
        public String element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "identifierRule"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:323:1: identifierRule returns [String element] : (id= Identifier | ex= Export | co= Connector | ctc= Connect | n= Name | o= Overrides );
    public final AspectJLoParser.identifierRule_return identifierRule() throws RecognitionException {
        AspectJLoParser.identifierRule_return retval = new AspectJLoParser.identifierRule_return();
        retval.start = input.LT(1);
        int identifierRule_StartIndex = input.index();
        Object root_0 = null;

        Token id=null;
        Token ex=null;
        Token co=null;
        Token ctc=null;
        Token n=null;
        Token o=null;

        Object id_tree=null;
        Object ex_tree=null;
        Object co_tree=null;
        Object ctc_tree=null;
        Object n_tree=null;
        Object o_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 409) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:324:5: (id= Identifier | ex= Export | co= Connector | ctc= Connect | n= Name | o= Overrides )
            int alt1=6;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                alt1=1;
                }
                break;
            case Export:
                {
                alt1=2;
                }
                break;
            case Connector:
                {
                alt1=3;
                }
                break;
            case Connect:
                {
                alt1=4;
                }
                break;
            case Name:
                {
                alt1=5;
                }
                break;
            case Overrides:
                {
                alt1=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:324:7: id= Identifier
                    {
                    root_0 = (Object)adaptor.nil();

                    id=(Token)match(input,Identifier,FOLLOW_Identifier_in_identifierRule72); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    id_tree = (Object)adaptor.create(id);
                    adaptor.addChild(root_0, id_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = (id!=null?id.getText():null);
                    }

                    }
                    break;
                case 2 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:325:9: ex= Export
                    {
                    root_0 = (Object)adaptor.nil();

                    ex=(Token)match(input,Export,FOLLOW_Export_in_identifierRule87); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ex_tree = (Object)adaptor.create(ex);
                    adaptor.addChild(root_0, ex_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = (ex!=null?ex.getText():null);
                    }

                    }
                    break;
                case 3 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:326:9: co= Connector
                    {
                    root_0 = (Object)adaptor.nil();

                    co=(Token)match(input,Connector,FOLLOW_Connector_in_identifierRule103); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    co_tree = (Object)adaptor.create(co);
                    adaptor.addChild(root_0, co_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = (co!=null?co.getText():null);
                    }

                    }
                    break;
                case 4 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:327:9: ctc= Connect
                    {
                    root_0 = (Object)adaptor.nil();

                    ctc=(Token)match(input,Connect,FOLLOW_Connect_in_identifierRule119); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ctc_tree = (Object)adaptor.create(ctc);
                    adaptor.addChild(root_0, ctc_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = (ctc!=null?ctc.getText():null);
                    }

                    }
                    break;
                case 5 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:328:9: n= Name
                    {
                    root_0 = (Object)adaptor.nil();

                    n=(Token)match(input,Name,FOLLOW_Name_in_identifierRule135); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    n_tree = (Object)adaptor.create(n);
                    adaptor.addChild(root_0, n_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = (n!=null?n.getText():null);
                    }

                    }
                    break;
                case 6 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:329:9: o= Overrides
                    {
                    root_0 = (Object)adaptor.nil();

                    o=(Token)match(input,Overrides,FOLLOW_Overrides_in_identifierRule151); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    o_tree = (Object)adaptor.create(o);
                    adaptor.addChild(root_0, o_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = (o!=null?o.getText():null);
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
            if ( state.backtracking>0 ) { memoize(input, 409, identifierRule_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "identifierRule"

    public static class memberDecl_return extends ParserRuleReturnScope {
        public TypeElement element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "memberDecl"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:333:1: memberDecl returns [TypeElement element] : (gen= genericMethodOrConstructorDecl | mem= memberDeclaration | vmd= voidMethodDeclaration | cs= constructorDeclaration | id= interfaceDeclaration | cd= classDeclaration | comp= subobjectDeclaration | exp= exportDeclaration | np= nameParameter | con= connector | cnct= connection );
    public final AspectJLoParser.memberDecl_return memberDecl() throws RecognitionException {
        AspectJLoParser.memberDecl_return retval = new AspectJLoParser.memberDecl_return();
        retval.start = input.LT(1);
        int memberDecl_StartIndex = input.index();
        Object root_0 = null;

        AspectJLo_JavaP.genericMethodOrConstructorDecl_return gen = null;

        AspectJLo_JavaP.memberDeclaration_return mem = null;

        AspectJLo_JavaP.voidMethodDeclaration_return vmd = null;

        AspectJLo_JavaP.constructorDeclaration_return cs = null;

        AspectJLo_JavaP.interfaceDeclaration_return id = null;

        AspectJLo_JavaP.classDeclaration_return cd = null;

        AspectJLoParser.subobjectDeclaration_return comp = null;

        AspectJLoParser.exportDeclaration_return exp = null;

        AspectJLoParser.nameParameter_return np = null;

        AspectJLoParser.connector_return con = null;

        AspectJLoParser.connection_return cnct = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 410) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:335:5: (gen= genericMethodOrConstructorDecl | mem= memberDeclaration | vmd= voidMethodDeclaration | cs= constructorDeclaration | id= interfaceDeclaration | cd= classDeclaration | comp= subobjectDeclaration | exp= exportDeclaration | np= nameParameter | con= connector | cnct= connection )
            int alt2=11;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:335:9: gen= genericMethodOrConstructorDecl
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_genericMethodOrConstructorDecl_in_memberDecl188);
                    gen=genericMethodOrConstructorDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, gen.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = gen.element;
                    }

                    }
                    break;
                case 2 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:336:9: mem= memberDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_memberDeclaration_in_memberDecl202);
                    mem=memberDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, mem.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = mem.element;
                    }

                    }
                    break;
                case 3 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:337:9: vmd= voidMethodDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_voidMethodDeclaration_in_memberDecl216);
                    vmd=voidMethodDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vmd.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = vmd.element;
                    }

                    }
                    break;
                case 4 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:338:9: cs= constructorDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_constructorDeclaration_in_memberDecl230);
                    cs=constructorDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cs.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = cs.element;
                    }

                    }
                    break;
                case 5 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:339:9: id= interfaceDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_interfaceDeclaration_in_memberDecl244);
                    id=interfaceDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, id.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element=id.element; gJavaP.addNonTopLevelObjectInheritance(id.element);
                    }

                    }
                    break;
                case 6 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:340:9: cd= classDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_classDeclaration_in_memberDecl258);
                    cd=classDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cd.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element=cd.element; gJavaP.addNonTopLevelObjectInheritance(cd.element);
                    }

                    }
                    break;
                case 7 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:341:9: comp= subobjectDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_subobjectDeclaration_in_memberDecl272);
                    comp=subobjectDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, comp.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element=comp.element;
                    }

                    }
                    break;
                case 8 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:342:9: exp= exportDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_exportDeclaration_in_memberDecl286);
                    exp=exportDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, exp.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element=exp.element;
                    }

                    }
                    break;
                case 9 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:343:9: np= nameParameter
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nameParameter_in_memberDecl300);
                    np=nameParameter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, np.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element=np.element;
                    }

                    }
                    break;
                case 10 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:344:9: con= connector
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_connector_in_memberDecl314);
                    con=connector();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, con.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = con.element;
                    }

                    }
                    break;
                case 11 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:345:9: cnct= connection
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_connection_in_memberDecl328);
                    cnct=connection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cnct.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = cnct.element;
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
              setLocation(retval.element, (CommonToken)retval.start, (CommonToken)retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 410, memberDecl_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "memberDecl"

    public static class connector_return extends ParserRuleReturnScope {
        public TypeElement element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "connector"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:348:1: connector returns [TypeElement element] : ctkw= Connector cp= subobjectParameter ';' ;
    public final AspectJLoParser.connector_return connector() throws RecognitionException {
        AspectJLoParser.connector_return retval = new AspectJLoParser.connector_return();
        retval.start = input.LT(1);
        int connector_StartIndex = input.index();
        Object root_0 = null;

        Token ctkw=null;
        Token char_literal1=null;
        AspectJLoParser.subobjectParameter_return cp = null;


        Object ctkw_tree=null;
        Object char_literal1_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 411) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:349:3: (ctkw= Connector cp= subobjectParameter ';' )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:349:5: ctkw= Connector cp= subobjectParameter ';'
            {
            root_0 = (Object)adaptor.nil();

            ctkw=(Token)match(input,Connector,FOLLOW_Connector_in_connector351); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ctkw_tree = (Object)adaptor.create(ctkw);
            adaptor.addChild(root_0, ctkw_tree);
            }
            pushFollow(FOLLOW_subobjectParameter_in_connector355);
            cp=subobjectParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, cp.getTree());
            if ( state.backtracking==0 ) {
              retval.element = cp.element; setKeyword(retval.element,ctkw);
            }
            char_literal1=(Token)match(input,32,FOLLOW_32_in_connector358); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal1_tree = (Object)adaptor.create(char_literal1);
            adaptor.addChild(root_0, char_literal1_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 411, connector_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "connector"

    public static class connection_return extends ParserRuleReturnScope {
        public TypeElement element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "connection"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:352:1: connection returns [TypeElement element] : ctkw= Connect name= identifierRule tokw= Identifier arg= subobjectArgument ';' ;
    public final AspectJLoParser.connection_return connection() throws RecognitionException {
        AspectJLoParser.connection_return retval = new AspectJLoParser.connection_return();
        retval.start = input.LT(1);
        int connection_StartIndex = input.index();
        Object root_0 = null;

        Token ctkw=null;
        Token tokw=null;
        Token char_literal2=null;
        AspectJLoParser.identifierRule_return name = null;

        AspectJLoParser.subobjectArgument_return arg = null;


        Object ctkw_tree=null;
        Object tokw_tree=null;
        Object char_literal2_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 412) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:353:3: (ctkw= Connect name= identifierRule tokw= Identifier arg= subobjectArgument ';' )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:353:5: ctkw= Connect name= identifierRule tokw= Identifier arg= subobjectArgument ';'
            {
            root_0 = (Object)adaptor.nil();

            ctkw=(Token)match(input,Connect,FOLLOW_Connect_in_connection378); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ctkw_tree = (Object)adaptor.create(ctkw);
            adaptor.addChild(root_0, ctkw_tree);
            }
            pushFollow(FOLLOW_identifierRule_in_connection382);
            name=identifierRule();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, name.getTree());
            tokw=(Token)match(input,Identifier,FOLLOW_Identifier_in_connection386); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tokw_tree = (Object)adaptor.create(tokw);
            adaptor.addChild(root_0, tokw_tree);
            }
            pushFollow(FOLLOW_subobjectArgument_in_connection390);
            arg=subobjectArgument();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, arg.getTree());
            char_literal2=(Token)match(input,32,FOLLOW_32_in_connection392); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal2_tree = (Object)adaptor.create(char_literal2);
            adaptor.addChild(root_0, char_literal2_tree);
            }
            if ( state.backtracking==0 ) {
              retval.element = new InstantiatedMemberSubobjectParameter(new SimpleNameSignature((name!=null?input.toString(name.start,name.stop):null)),arg.element);
               	   setKeyword(retval.element,ctkw);
              	   setName(retval.element,name.start);
               	   if((tokw!=null?tokw.getText():null).equals("to")) {setKeyword(arg.element,tokw);}
               	  
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
            if ( state.backtracking>0 ) { memoize(input, 412, connection_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "connection"

    public static class nameParameter_return extends ParserRuleReturnScope {
        public TypeElement element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nameParameter"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:361:1: nameParameter returns [TypeElement element] : Name identifierRule ( '=' memberName )? ';' ;
    public final AspectJLoParser.nameParameter_return nameParameter() throws RecognitionException {
        AspectJLoParser.nameParameter_return retval = new AspectJLoParser.nameParameter_return();
        retval.start = input.LT(1);
        int nameParameter_StartIndex = input.index();
        Object root_0 = null;

        Token Name3=null;
        Token char_literal5=null;
        Token char_literal7=null;
        AspectJLoParser.identifierRule_return identifierRule4 = null;

        AspectJLoParser.memberName_return memberName6 = null;


        Object Name3_tree=null;
        Object char_literal5_tree=null;
        Object char_literal7_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 413) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:362:6: ( Name identifierRule ( '=' memberName )? ';' )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:362:8: Name identifierRule ( '=' memberName )? ';'
            {
            root_0 = (Object)adaptor.nil();

            Name3=(Token)match(input,Name,FOLLOW_Name_in_nameParameter419); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Name3_tree = (Object)adaptor.create(Name3);
            adaptor.addChild(root_0, Name3_tree);
            }
            pushFollow(FOLLOW_identifierRule_in_nameParameter421);
            identifierRule4=identifierRule();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, identifierRule4.getTree());
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:362:28: ( '=' memberName )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==57) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:362:29: '=' memberName
                    {
                    char_literal5=(Token)match(input,57,FOLLOW_57_in_nameParameter424); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal5_tree = (Object)adaptor.create(char_literal5);
                    adaptor.addChild(root_0, char_literal5_tree);
                    }
                    pushFollow(FOLLOW_memberName_in_nameParameter426);
                    memberName6=memberName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, memberName6.getTree());

                    }
                    break;

            }

            char_literal7=(Token)match(input,32,FOLLOW_32_in_nameParameter430); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal7_tree = (Object)adaptor.create(char_literal7);
            adaptor.addChild(root_0, char_literal7_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 413, nameParameter_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "nameParameter"

    public static class memberName_return extends ParserRuleReturnScope {
        public Object element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "memberName"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:365:1: memberName returns [Object element] : identifierRule ;
    public final AspectJLoParser.memberName_return memberName() throws RecognitionException {
        AspectJLoParser.memberName_return retval = new AspectJLoParser.memberName_return();
        retval.start = input.LT(1);
        int memberName_StartIndex = input.index();
        Object root_0 = null;

        AspectJLoParser.identifierRule_return identifierRule8 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 414) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:366:3: ( identifierRule )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:366:5: identifierRule
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_identifierRule_in_memberName455);
            identifierRule8=identifierRule();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, identifierRule8.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 414, memberName_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "memberName"

    public static class exportDeclaration_return extends ParserRuleReturnScope {
        public Export element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exportDeclaration"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:369:1: exportDeclaration returns [Export element] : xp= Export m= map ( ',' mm= map )* ';' ;
    public final AspectJLoParser.exportDeclaration_return exportDeclaration() throws RecognitionException {
        AspectJLoParser.exportDeclaration_return retval = new AspectJLoParser.exportDeclaration_return();
        retval.start = input.LT(1);
        int exportDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token xp=null;
        Token char_literal9=null;
        Token char_literal10=null;
        AspectJLoParser.map_return m = null;

        AspectJLoParser.map_return mm = null;


        Object xp_tree=null;
        Object char_literal9_tree=null;
        Object char_literal10_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 415) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:370:6: (xp= Export m= map ( ',' mm= map )* ';' )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:370:8: xp= Export m= map ( ',' mm= map )* ';'
            {
            root_0 = (Object)adaptor.nil();

            xp=(Token)match(input,Export,FOLLOW_Export_in_exportDeclaration482); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            xp_tree = (Object)adaptor.create(xp);
            adaptor.addChild(root_0, xp_tree);
            }
            if ( state.backtracking==0 ) {
              retval.element = new Export(); setKeyword(retval.element,xp);
            }
            pushFollow(FOLLOW_map_in_exportDeclaration488);
            m=map();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, m.getTree());
            if ( state.backtracking==0 ) {
              retval.element.add(m.element);
            }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:370:121: ( ',' mm= map )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==47) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:370:122: ',' mm= map
            	    {
            	    char_literal9=(Token)match(input,47,FOLLOW_47_in_exportDeclaration493); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal9_tree = (Object)adaptor.create(char_literal9);
            	    adaptor.addChild(root_0, char_literal9_tree);
            	    }
            	    pushFollow(FOLLOW_map_in_exportDeclaration497);
            	    mm=map();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, mm.getTree());
            	    if ( state.backtracking==0 ) {
            	      retval.element.add(mm.element);
            	    }

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            char_literal10=(Token)match(input,32,FOLLOW_32_in_exportDeclaration503); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal10_tree = (Object)adaptor.create(char_literal10);
            adaptor.addChild(root_0, char_literal10_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 415, exportDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "exportDeclaration"

    public static class map_return extends ParserRuleReturnScope {
        public RenamingClause element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "map"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:373:1: map returns [RenamingClause element] : oldFQN= fqn (id= Identifier newSig= signature )? ;
    public final AspectJLoParser.map_return map() throws RecognitionException {
        AspectJLoParser.map_return retval = new AspectJLoParser.map_return();
        retval.start = input.LT(1);
        int map_StartIndex = input.index();
        Object root_0 = null;

        Token id=null;
        AspectJLoParser.fqn_return oldFQN = null;

        AspectJLoParser.signature_return newSig = null;


        Object id_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 416) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:374:2: (oldFQN= fqn (id= Identifier newSig= signature )? )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:374:5: oldFQN= fqn (id= Identifier newSig= signature )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_fqn_in_map530);
            oldFQN=fqn();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, oldFQN.getTree());
            if ( state.backtracking==0 ) {
              retval.element = new RenamingClause(null, oldFQN.element);
            }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:375:5: (id= Identifier newSig= signature )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==Identifier) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:375:6: id= Identifier newSig= signature
                    {
                    id=(Token)match(input,Identifier,FOLLOW_Identifier_in_map542); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    id_tree = (Object)adaptor.create(id);
                    adaptor.addChild(root_0, id_tree);
                    }
                    pushFollow(FOLLOW_signature_in_map546);
                    newSig=signature();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, newSig.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element.setNewSignature(newSig.element);
                      	    if((id!=null?id.getText():null).equals("as")) {setKeyword(retval.element, id);}
                      	   
                    }

                    }
                    break;

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
            if ( state.backtracking>0 ) { memoize(input, 416, map_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "map"

    public static class subobjectDeclaration_return extends ParserRuleReturnScope {
        public ComponentRelation element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subobjectDeclaration"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:381:1: subobjectDeclaration returns [ComponentRelation element] : cp= 'subobject' (tp= type )? name= identifierRule (body= classBody | ';' ) ;
    public final AspectJLoParser.subobjectDeclaration_return subobjectDeclaration() throws RecognitionException {
        AspectJLoParser.subobjectDeclaration_return retval = new AspectJLoParser.subobjectDeclaration_return();
        retval.start = input.LT(1);
        int subobjectDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token cp=null;
        Token char_literal11=null;
        AspectJLo_JavaP.type_return tp = null;

        AspectJLoParser.identifierRule_return name = null;

        AspectJLo_JavaP.classBody_return body = null;


        Object cp_tree=null;
        Object char_literal11_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 417) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:382:6: (cp= 'subobject' (tp= type )? name= identifierRule (body= classBody | ';' ) )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:382:8: cp= 'subobject' (tp= type )? name= identifierRule (body= classBody | ';' )
            {
            root_0 = (Object)adaptor.nil();

            cp=(Token)match(input,120,FOLLOW_120_in_subobjectDeclaration581); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            cp_tree = (Object)adaptor.create(cp);
            adaptor.addChild(root_0, cp_tree);
            }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:382:25: (tp= type )?
            int alt6=2;
            switch ( input.LA(1) ) {
                case Identifier:
                    {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1==Identifier||(LA6_1>=Export && LA6_1<=Overrides)||LA6_1==35||LA6_1==46||LA6_1==54) ) {
                        alt6=1;
                    }
                    }
                    break;
                case Export:
                    {
                    int LA6_2 = input.LA(2);

                    if ( (LA6_2==Identifier||(LA6_2>=Export && LA6_2<=Overrides)||LA6_2==35||LA6_2==46||LA6_2==54) ) {
                        alt6=1;
                    }
                    }
                    break;
                case Connector:
                    {
                    int LA6_3 = input.LA(2);

                    if ( (LA6_3==Identifier||(LA6_3>=Export && LA6_3<=Overrides)||LA6_3==35||LA6_3==46||LA6_3==54) ) {
                        alt6=1;
                    }
                    }
                    break;
                case Connect:
                    {
                    int LA6_4 = input.LA(2);

                    if ( (LA6_4==Identifier||(LA6_4>=Export && LA6_4<=Overrides)||LA6_4==35||LA6_4==46||LA6_4==54) ) {
                        alt6=1;
                    }
                    }
                    break;
                case Name:
                    {
                    int LA6_5 = input.LA(2);

                    if ( (LA6_5==Identifier||(LA6_5>=Export && LA6_5<=Overrides)||LA6_5==35||LA6_5==46||LA6_5==54) ) {
                        alt6=1;
                    }
                    }
                    break;
                case Overrides:
                    {
                    int LA6_6 = input.LA(2);

                    if ( (LA6_6==Identifier||(LA6_6>=Export && LA6_6<=Overrides)||LA6_6==35||LA6_6==46||LA6_6==54) ) {
                        alt6=1;
                    }
                    }
                    break;
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                    {
                    alt6=1;
                    }
                    break;
            }

            switch (alt6) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:0:0: tp= type
                    {
                    pushFollow(FOLLOW_type_in_subobjectDeclaration585);
                    tp=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tp.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_identifierRule_in_subobjectDeclaration590);
            name=identifierRule();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, name.getTree());
            if ( state.backtracking==0 ) {
              retval.element = new ComponentRelation(new SimpleNameSignature((name!=null?input.toString(name.start,name.stop):null)), (tp!=null?tp.element:null));
                  	         setKeyword(retval.element,cp);
                  	         setName(retval.element,name.start);
                  	        
            }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:387:14: (body= classBody | ';' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==50) ) {
                alt7=1;
            }
            else if ( (LA7_0==32) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:387:15: body= classBody
                    {
                    pushFollow(FOLLOW_classBody_in_subobjectDeclaration624);
                    body=classBody();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element.setBody((body!=null?body.element:null));
                    }

                    }
                    break;
                case 2 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:387:73: ';'
                    {
                    char_literal11=(Token)match(input,32,FOLLOW_32_in_subobjectDeclaration630); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal11_tree = (Object)adaptor.create(char_literal11);
                    adaptor.addChild(root_0, char_literal11_tree);
                    }

                    }
                    break;

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
            if ( state.backtracking>0 ) { memoize(input, 417, subobjectDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "subobjectDeclaration"

    public static class configurationBlock_return extends ParserRuleReturnScope {
        public ConfigurationBlock element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "configurationBlock"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:391:1: configurationBlock returns [ConfigurationBlock element] : al= 'alias' '{' (cl= configurationClause ( ',' cll= configurationClause )* )? '}' ;
    public final AspectJLoParser.configurationBlock_return configurationBlock() throws RecognitionException {
        AspectJLoParser.configurationBlock_return retval = new AspectJLoParser.configurationBlock_return();
        retval.start = input.LT(1);
        int configurationBlock_StartIndex = input.index();
        Object root_0 = null;

        Token al=null;
        Token char_literal12=null;
        Token char_literal13=null;
        Token char_literal14=null;
        AspectJLoParser.configurationClause_return cl = null;

        AspectJLoParser.configurationClause_return cll = null;


        Object al_tree=null;
        Object char_literal12_tree=null;
        Object char_literal13_tree=null;
        Object char_literal14_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 418) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:393:9: (al= 'alias' '{' (cl= configurationClause ( ',' cll= configurationClause )* )? '}' )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:393:11: al= 'alias' '{' (cl= configurationClause ( ',' cll= configurationClause )* )? '}'
            {
            root_0 = (Object)adaptor.nil();

            al=(Token)match(input,121,FOLLOW_121_in_configurationBlock679); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            al_tree = (Object)adaptor.create(al);
            adaptor.addChild(root_0, al_tree);
            }
            char_literal12=(Token)match(input,50,FOLLOW_50_in_configurationBlock681); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal12_tree = (Object)adaptor.create(char_literal12);
            adaptor.addChild(root_0, char_literal12_tree);
            }
            if ( state.backtracking==0 ) {
              retval.element = new ConfigurationBlock(); setKeyword(retval.element,al);
            }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:393:102: (cl= configurationClause ( ',' cll= configurationClause )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==Identifier||(LA9_0>=Export && LA9_0<=Overrides)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:393:103: cl= configurationClause ( ',' cll= configurationClause )*
                    {
                    pushFollow(FOLLOW_configurationClause_in_configurationBlock688);
                    cl=configurationClause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cl.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element.add(cl.element);
                    }
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:393:159: ( ',' cll= configurationClause )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==47) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:393:160: ',' cll= configurationClause
                    	    {
                    	    char_literal13=(Token)match(input,47,FOLLOW_47_in_configurationBlock692); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal13_tree = (Object)adaptor.create(char_literal13);
                    	    adaptor.addChild(root_0, char_literal13_tree);
                    	    }
                    	    pushFollow(FOLLOW_configurationClause_in_configurationBlock696);
                    	    cll=configurationClause();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, cll.getTree());
                    	    if ( state.backtracking==0 ) {
                    	      retval.element.add(cll.element);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal14=(Token)match(input,51,FOLLOW_51_in_configurationBlock703); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal14_tree = (Object)adaptor.create(char_literal14);
            adaptor.addChild(root_0, char_literal14_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 418, configurationBlock_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "configurationBlock"

    public static class configurationClause_return extends ParserRuleReturnScope {
        public ConfigurationClause element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "configurationClause"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:396:1: configurationClause returns [ConfigurationClause element] : (sig= signature ov= '>' f= fqn | sigg= signature al= '=' ff= fqn );
    public final AspectJLoParser.configurationClause_return configurationClause() throws RecognitionException {
        AspectJLoParser.configurationClause_return retval = new AspectJLoParser.configurationClause_return();
        retval.start = input.LT(1);
        int configurationClause_StartIndex = input.index();
        Object root_0 = null;

        Token ov=null;
        Token al=null;
        AspectJLoParser.signature_return sig = null;

        AspectJLoParser.fqn_return f = null;

        AspectJLoParser.signature_return sigg = null;

        AspectJLoParser.fqn_return ff = null;


        Object ov_tree=null;
        Object al_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 419) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:398:2: (sig= signature ov= '>' f= fqn | sigg= signature al= '=' ff= fqn )
            int alt10=2;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                int LA10_1 = input.LA(2);

                if ( (synpred23_AspectJLo()) ) {
                    alt10=1;
                }
                else if ( (true) ) {
                    alt10=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
                }
                break;
            case Export:
                {
                int LA10_2 = input.LA(2);

                if ( (synpred23_AspectJLo()) ) {
                    alt10=1;
                }
                else if ( (true) ) {
                    alt10=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 2, input);

                    throw nvae;
                }
                }
                break;
            case Connector:
                {
                int LA10_3 = input.LA(2);

                if ( (synpred23_AspectJLo()) ) {
                    alt10=1;
                }
                else if ( (true) ) {
                    alt10=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 3, input);

                    throw nvae;
                }
                }
                break;
            case Connect:
                {
                int LA10_4 = input.LA(2);

                if ( (synpred23_AspectJLo()) ) {
                    alt10=1;
                }
                else if ( (true) ) {
                    alt10=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 4, input);

                    throw nvae;
                }
                }
                break;
            case Name:
                {
                int LA10_5 = input.LA(2);

                if ( (synpred23_AspectJLo()) ) {
                    alt10=1;
                }
                else if ( (true) ) {
                    alt10=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 5, input);

                    throw nvae;
                }
                }
                break;
            case Overrides:
                {
                int LA10_6 = input.LA(2);

                if ( (synpred23_AspectJLo()) ) {
                    alt10=1;
                }
                else if ( (true) ) {
                    alt10=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 6, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:398:4: sig= signature ov= '>' f= fqn
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_signature_in_configurationClause739);
                    sig=signature();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, sig.getTree());
                    ov=(Token)match(input,48,FOLLOW_48_in_configurationClause743); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ov_tree = (Object)adaptor.create(ov);
                    adaptor.addChild(root_0, ov_tree);
                    }
                    pushFollow(FOLLOW_fqn_in_configurationClause747);
                    f=fqn();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, f.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = new OverridesClause(sig.element, f.element);
                      	      setKeyword(retval.element, ov);
                      	     
                    }

                    }
                    break;
                case 2 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:403:3: sigg= signature al= '=' ff= fqn
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_signature_in_configurationClause764);
                    sigg=signature();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, sigg.getTree());
                    al=(Token)match(input,57,FOLLOW_57_in_configurationClause768); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    al_tree = (Object)adaptor.create(al);
                    adaptor.addChild(root_0, al_tree);
                    }
                    pushFollow(FOLLOW_fqn_in_configurationClause772);
                    ff=fqn();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ff.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = new RenamingClause(sigg.element, ff.element);
                      	      setKeyword(retval.element, al);
                      	     
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
              setLocation(retval.element, (CommonToken)retval.start, (CommonToken)retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 419, configurationClause_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "configurationClause"

    public static class signature_return extends ParserRuleReturnScope {
        public Signature element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "signature"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:409:1: signature returns [Signature element] : (sig= identifierRule | sigg= identifierRule '(' (t= type ( ',' tt= type )* )? ')' );
    public final AspectJLoParser.signature_return signature() throws RecognitionException {
        AspectJLoParser.signature_return retval = new AspectJLoParser.signature_return();
        retval.start = input.LT(1);
        int signature_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal15=null;
        Token char_literal16=null;
        Token char_literal17=null;
        AspectJLoParser.identifierRule_return sig = null;

        AspectJLoParser.identifierRule_return sigg = null;

        AspectJLo_JavaP.type_return t = null;

        AspectJLo_JavaP.type_return tt = null;


        Object char_literal15_tree=null;
        Object char_literal16_tree=null;
        Object char_literal17_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 420) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:410:9: (sig= identifierRule | sigg= identifierRule '(' (t= type ( ',' tt= type )* )? ')' )
            int alt13=2;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==EOF||LA13_1==Identifier||LA13_1==32||(LA13_1>=47 && LA13_1<=48)||LA13_1==51||LA13_1==57) ) {
                    alt13=1;
                }
                else if ( (LA13_1==72) ) {
                    alt13=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
                }
                break;
            case Export:
                {
                int LA13_2 = input.LA(2);

                if ( (LA13_2==EOF||LA13_2==Identifier||LA13_2==32||(LA13_2>=47 && LA13_2<=48)||LA13_2==51||LA13_2==57) ) {
                    alt13=1;
                }
                else if ( (LA13_2==72) ) {
                    alt13=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 2, input);

                    throw nvae;
                }
                }
                break;
            case Connector:
                {
                int LA13_3 = input.LA(2);

                if ( (LA13_3==EOF||LA13_3==Identifier||LA13_3==32||(LA13_3>=47 && LA13_3<=48)||LA13_3==51||LA13_3==57) ) {
                    alt13=1;
                }
                else if ( (LA13_3==72) ) {
                    alt13=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 3, input);

                    throw nvae;
                }
                }
                break;
            case Connect:
                {
                int LA13_4 = input.LA(2);

                if ( (LA13_4==EOF||LA13_4==Identifier||LA13_4==32||(LA13_4>=47 && LA13_4<=48)||LA13_4==51||LA13_4==57) ) {
                    alt13=1;
                }
                else if ( (LA13_4==72) ) {
                    alt13=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 4, input);

                    throw nvae;
                }
                }
                break;
            case Name:
                {
                int LA13_5 = input.LA(2);

                if ( (LA13_5==EOF||LA13_5==Identifier||LA13_5==32||(LA13_5>=47 && LA13_5<=48)||LA13_5==51||LA13_5==57) ) {
                    alt13=1;
                }
                else if ( (LA13_5==72) ) {
                    alt13=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 5, input);

                    throw nvae;
                }
                }
                break;
            case Overrides:
                {
                int LA13_6 = input.LA(2);

                if ( (LA13_6==EOF||LA13_6==Identifier||LA13_6==32||(LA13_6>=47 && LA13_6<=48)||LA13_6==51||LA13_6==57) ) {
                    alt13=1;
                }
                else if ( (LA13_6==72) ) {
                    alt13=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 6, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:410:11: sig= identifierRule
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_identifierRule_in_signature806);
                    sig=identifierRule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, sig.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = new SimpleNameSignature((sig!=null?input.toString(sig.start,sig.stop):null));
                    }

                    }
                    break;
                case 2 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:411:11: sigg= identifierRule '(' (t= type ( ',' tt= type )* )? ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_identifierRule_in_signature822);
                    sigg=identifierRule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, sigg.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = new SimpleNameDeclarationWithParametersSignature((sigg!=null?input.toString(sigg.start,sigg.stop):null));
                    }
                    char_literal15=(Token)match(input,72,FOLLOW_72_in_signature843); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal15_tree = (Object)adaptor.create(char_literal15);
                    adaptor.addChild(root_0, char_literal15_tree);
                    }
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:412:21: (t= type ( ',' tt= type )* )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==Identifier||(LA12_0>=Export && LA12_0<=Overrides)||(LA12_0>=62 && LA12_0<=69)) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:412:22: t= type ( ',' tt= type )*
                            {
                            pushFollow(FOLLOW_type_in_signature848);
                            t=type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
                            if ( state.backtracking==0 ) {
                              ((SimpleNameDeclarationWithParametersSignature)retval.element).add(t.element);
                            }
                            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:413:18: ( ',' tt= type )*
                            loop11:
                            do {
                                int alt11=2;
                                int LA11_0 = input.LA(1);

                                if ( (LA11_0==47) ) {
                                    alt11=1;
                                }


                                switch (alt11) {
                            	case 1 :
                            	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:413:19: ',' tt= type
                            	    {
                            	    char_literal16=(Token)match(input,47,FOLLOW_47_in_signature871); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    char_literal16_tree = (Object)adaptor.create(char_literal16);
                            	    adaptor.addChild(root_0, char_literal16_tree);
                            	    }
                            	    pushFollow(FOLLOW_type_in_signature875);
                            	    tt=type();

                            	    state._fsp--;
                            	    if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, tt.getTree());
                            	    if ( state.backtracking==0 ) {
                            	      ((SimpleNameDeclarationWithParametersSignature)retval.element).add(tt.element);
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop11;
                                }
                            } while (true);


                            }
                            break;

                    }

                    char_literal17=(Token)match(input,73,FOLLOW_73_in_signature882); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal17_tree = (Object)adaptor.create(char_literal17);
                    adaptor.addChild(root_0, char_literal17_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 420, signature_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "signature"

    public static class fqn_return extends ParserRuleReturnScope {
        public QualifiedName element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fqn"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:416:1: fqn returns [QualifiedName element] : (sig= signature | id= identifierRule '.' ff= fqn );
    public final AspectJLoParser.fqn_return fqn() throws RecognitionException {
        AspectJLoParser.fqn_return retval = new AspectJLoParser.fqn_return();
        retval.start = input.LT(1);
        int fqn_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal18=null;
        AspectJLoParser.signature_return sig = null;

        AspectJLoParser.identifierRule_return id = null;

        AspectJLoParser.fqn_return ff = null;


        Object char_literal18_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 421) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:417:9: (sig= signature | id= identifierRule '.' ff= fqn )
            int alt14=2;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==EOF||LA14_1==Identifier||LA14_1==32||LA14_1==47||LA14_1==51||LA14_1==72) ) {
                    alt14=1;
                }
                else if ( (LA14_1==35) ) {
                    alt14=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;
                }
                }
                break;
            case Export:
                {
                int LA14_2 = input.LA(2);

                if ( (LA14_2==EOF||LA14_2==Identifier||LA14_2==32||LA14_2==47||LA14_2==51||LA14_2==72) ) {
                    alt14=1;
                }
                else if ( (LA14_2==35) ) {
                    alt14=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 2, input);

                    throw nvae;
                }
                }
                break;
            case Connector:
                {
                int LA14_3 = input.LA(2);

                if ( (LA14_3==EOF||LA14_3==Identifier||LA14_3==32||LA14_3==47||LA14_3==51||LA14_3==72) ) {
                    alt14=1;
                }
                else if ( (LA14_3==35) ) {
                    alt14=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 3, input);

                    throw nvae;
                }
                }
                break;
            case Connect:
                {
                int LA14_4 = input.LA(2);

                if ( (LA14_4==EOF||LA14_4==Identifier||LA14_4==32||LA14_4==47||LA14_4==51||LA14_4==72) ) {
                    alt14=1;
                }
                else if ( (LA14_4==35) ) {
                    alt14=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 4, input);

                    throw nvae;
                }
                }
                break;
            case Name:
                {
                int LA14_5 = input.LA(2);

                if ( (LA14_5==EOF||LA14_5==Identifier||LA14_5==32||LA14_5==47||LA14_5==51||LA14_5==72) ) {
                    alt14=1;
                }
                else if ( (LA14_5==35) ) {
                    alt14=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 5, input);

                    throw nvae;
                }
                }
                break;
            case Overrides:
                {
                int LA14_6 = input.LA(2);

                if ( (LA14_6==EOF||LA14_6==Identifier||LA14_6==32||LA14_6==47||LA14_6==51||LA14_6==72) ) {
                    alt14=1;
                }
                else if ( (LA14_6==35) ) {
                    alt14=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 6, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:417:11: sig= signature
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_signature_in_fqn922);
                    sig=signature();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, sig.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element=sig.element;
                    }

                    }
                    break;
                case 2 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:418:15: id= identifierRule '.' ff= fqn
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_identifierRule_in_fqn942);
                    id=identifierRule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, id.getTree());
                    char_literal18=(Token)match(input,35,FOLLOW_35_in_fqn944); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal18_tree = (Object)adaptor.create(char_literal18);
                    adaptor.addChild(root_0, char_literal18_tree);
                    }
                    pushFollow(FOLLOW_fqn_in_fqn948);
                    ff=fqn();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ff.getTree());
                    if ( state.backtracking==0 ) {

                                    Signature signature = new SimpleNameSignature((id!=null?input.toString(id.start,id.stop):null));
                                    if(ff.element instanceof CompositeQualifiedName) {
                                      ((CompositeQualifiedName)ff.element).prefix(signature); 
                                      retval.element = ff.element;
                                    } else {
                                      retval.element=new CompositeQualifiedName();
                                      ((CompositeQualifiedName)retval.element).append(signature);
                                      ((CompositeQualifiedName)retval.element).append((Signature)ff.element);
                                    }
                                    
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
            if ( state.backtracking>0 ) { memoize(input, 421, fqn_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "fqn"

    public static class expression_return extends ParserRuleReturnScope {
        public Expression element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:431:1: expression returns [Expression element] : (ex= conditionalExpression (op= assignmentOperator exx= expression )? | sb= 'subobject' '.' id= identifierRule args= arguments | prcd= 'proceed' args= arguments );
    public final AspectJLoParser.expression_return expression() throws RecognitionException {
        AspectJLoParser.expression_return retval = new AspectJLoParser.expression_return();
        retval.start = input.LT(1);
        int expression_StartIndex = input.index();
        Object root_0 = null;

        Token sb=null;
        Token prcd=null;
        Token char_literal19=null;
        AspectJLo_JavaP.conditionalExpression_return ex = null;

        AspectJLo_JavaP.assignmentOperator_return op = null;

        AspectJLoParser.expression_return exx = null;

        AspectJLoParser.identifierRule_return id = null;

        AspectJLo_JavaP.arguments_return args = null;


        Object sb_tree=null;
        Object prcd_tree=null;
        Object char_literal19_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 422) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:432:5: (ex= conditionalExpression (op= assignmentOperator exx= expression )? | sb= 'subobject' '.' id= identifierRule args= arguments | prcd= 'proceed' args= arguments )
            int alt16=3;
            switch ( input.LA(1) ) {
            case Identifier:
            case FloatingPointLiteral:
            case CharacterLiteral:
            case StringLiteral:
            case HexLiteral:
            case OctalLiteral:
            case DecimalLiteral:
            case Export:
            case Connector:
            case Connect:
            case Name:
            case Overrides:
            case 53:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 71:
            case 72:
            case 75:
            case 76:
            case 77:
            case 78:
            case 111:
            case 112:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 123:
            case 124:
            case 125:
                {
                alt16=1;
                }
                break;
            case 120:
                {
                alt16=2;
                }
                break;
            case 122:
                {
                alt16=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:432:9: ex= conditionalExpression (op= assignmentOperator exx= expression )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_conditionalExpression_in_expression987);
                    ex=conditionalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ex.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element=ex.element;
                    }
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:432:63: (op= assignmentOperator exx= expression )?
                    int alt15=2;
                    alt15 = dfa15.predict(input);
                    switch (alt15) {
                        case 1 :
                            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:432:64: op= assignmentOperator exx= expression
                            {
                            pushFollow(FOLLOW_assignmentOperator_in_expression994);
                            op=assignmentOperator();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, op.getTree());
                            pushFollow(FOLLOW_expression_in_expression998);
                            exx=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, exx.getTree());
                            if ( state.backtracking==0 ) {
                              String txt = (op!=null?input.toString(op.start,op.stop):null); 
                                       if(txt.equals("=")) {
                                         retval.element = new AssignmentExpression(ex.element,exx.element);
                                       } else {
                                         retval.element = new InfixOperatorInvocation((op!=null?input.toString(op.start,op.stop):null),ex.element);
                                         ((InfixOperatorInvocation)retval.element).addArgument(exx.element);
                                       }
                                       setLocation(retval.element,op.start,op.stop,"__NAME");
                                       setLocation(retval.element,retval.start,exx.stop);
                                      
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:444:11: sb= 'subobject' '.' id= identifierRule args= arguments
                    {
                    root_0 = (Object)adaptor.nil();

                    sb=(Token)match(input,120,FOLLOW_120_in_expression1034); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    sb_tree = (Object)adaptor.create(sb);
                    adaptor.addChild(root_0, sb_tree);
                    }
                    char_literal19=(Token)match(input,35,FOLLOW_35_in_expression1036); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal19_tree = (Object)adaptor.create(char_literal19);
                    adaptor.addChild(root_0, char_literal19_tree);
                    }
                    pushFollow(FOLLOW_identifierRule_in_expression1040);
                    id=identifierRule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, id.getTree());
                    pushFollow(FOLLOW_arguments_in_expression1044);
                    args=arguments();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, args.getTree());
                    if ( state.backtracking==0 ) {

                                retval.element = new SubobjectConstructorCall((id!=null?input.toString(id.start,id.stop):null), args.element);
                               setLocation(retval.element,sb,args.stop);
                               setKeyword(retval.element,sb);
                                 
                    }

                    }
                    break;
                case 3 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:449:11: prcd= 'proceed' args= arguments
                    {
                    root_0 = (Object)adaptor.nil();

                    prcd=(Token)match(input,122,FOLLOW_122_in_expression1060); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    prcd_tree = (Object)adaptor.create(prcd);
                    adaptor.addChild(root_0, prcd_tree);
                    }
                    pushFollow(FOLLOW_arguments_in_expression1064);
                    args=arguments();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, args.getTree());
                    if ( state.backtracking==0 ) {

                                ProceedCall result = new ProceedCall();
                                result.addAllArguments(args.element);
                                retval.element = result;
                                setKeyword(retval.element, prcd);
                                setLocation(retval.element,prcd,prcd);
                              
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
            if ( state.backtracking>0 ) { memoize(input, 422, expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class nonTargetPrimary_return extends ParserRuleReturnScope {
        public Expression element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nonTargetPrimary"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:476:1: nonTargetPrimary returns [Expression element] : (lit= literal | at= '#' id= identifierRule '(' ex= expression stop= ')' | okw= 'outer' supsuf= superSuffix | rkw= 'rooot' supsuf= superSuffix );
    public final AspectJLoParser.nonTargetPrimary_return nonTargetPrimary() throws RecognitionException {
        AspectJLoParser.nonTargetPrimary_return retval = new AspectJLoParser.nonTargetPrimary_return();
        retval.start = input.LT(1);
        int nonTargetPrimary_StartIndex = input.index();
        Object root_0 = null;

        Token at=null;
        Token stop=null;
        Token okw=null;
        Token rkw=null;
        Token char_literal20=null;
        AspectJLo_JavaP.literal_return lit = null;

        AspectJLoParser.identifierRule_return id = null;

        AspectJLoParser.expression_return ex = null;

        AspectJLo_JavaP.superSuffix_return supsuf = null;


        Object at_tree=null;
        Object stop_tree=null;
        Object okw_tree=null;
        Object rkw_tree=null;
        Object char_literal20_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 423) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:477:4: (lit= literal | at= '#' id= identifierRule '(' ex= expression stop= ')' | okw= 'outer' supsuf= superSuffix | rkw= 'rooot' supsuf= superSuffix )
            int alt17=4;
            switch ( input.LA(1) ) {
            case FloatingPointLiteral:
            case CharacterLiteral:
            case StringLiteral:
            case HexLiteral:
            case OctalLiteral:
            case DecimalLiteral:
            case 76:
            case 77:
            case 78:
                {
                alt17=1;
                }
                break;
            case 123:
                {
                alt17=2;
                }
                break;
            case 124:
                {
                alt17=3;
                }
                break;
            case 125:
                {
                alt17=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:478:4: lit= literal
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_literal_in_nonTargetPrimary1116);
                    lit=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, lit.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = lit.element;
                    }

                    }
                    break;
                case 2 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:479:6: at= '#' id= identifierRule '(' ex= expression stop= ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    at=(Token)match(input,123,FOLLOW_123_in_nonTargetPrimary1127); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    at_tree = (Object)adaptor.create(at);
                    adaptor.addChild(root_0, at_tree);
                    }
                    pushFollow(FOLLOW_identifierRule_in_nonTargetPrimary1131);
                    id=identifierRule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, id.getTree());
                    char_literal20=(Token)match(input,72,FOLLOW_72_in_nonTargetPrimary1133); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal20_tree = (Object)adaptor.create(char_literal20);
                    adaptor.addChild(root_0, char_literal20_tree);
                    }
                    pushFollow(FOLLOW_expression_in_nonTargetPrimary1137);
                    ex=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ex.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = ex.element;
                    }
                    stop=(Token)match(input,73,FOLLOW_73_in_nonTargetPrimary1143); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    stop_tree = (Object)adaptor.create(stop);
                    adaptor.addChild(root_0, stop_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new ComponentParameterCall(ex.element, (id!=null?input.toString(id.start,id.stop):null));
                                    setLocation(retval.element,at,stop);
                                    setKeyword(retval.element,at);
                                 
                    }

                    }
                    break;
                case 3 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:484:11: okw= 'outer' supsuf= superSuffix
                    {
                    root_0 = (Object)adaptor.nil();

                    okw=(Token)match(input,124,FOLLOW_124_in_nonTargetPrimary1170); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    okw_tree = (Object)adaptor.create(okw);
                    adaptor.addChild(root_0, okw_tree);
                    }
                    pushFollow(FOLLOW_superSuffix_in_nonTargetPrimary1174);
                    supsuf=superSuffix();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, supsuf.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = supsuf.element;
                                  InvocationTarget tar = new OuterTarget();
                                  ((TargetedExpression)retval.element).setTarget(tar);
                                  setLocation(retval.element,okw,okw); // put locations on the SuperTarget.
                                  setKeyword(tar,okw);
                                 
                    }

                    }
                    break;
                case 4 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:491:11: rkw= 'rooot' supsuf= superSuffix
                    {
                    root_0 = (Object)adaptor.nil();

                    rkw=(Token)match(input,125,FOLLOW_125_in_nonTargetPrimary1202); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    rkw_tree = (Object)adaptor.create(rkw);
                    adaptor.addChild(root_0, rkw_tree);
                    }
                    pushFollow(FOLLOW_superSuffix_in_nonTargetPrimary1206);
                    supsuf=superSuffix();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, supsuf.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = supsuf.element;
                                  InvocationTarget tar = new RootTarget();
                                  ((TargetedExpression)retval.element).setTarget(tar);
                                  setLocation(retval.element,rkw,rkw); // put locations on the SuperTarget.
                                  setKeyword(tar,rkw);
                                 
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
            if ( state.backtracking>0 ) { memoize(input, 423, nonTargetPrimary_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "nonTargetPrimary"

    public static class subobjectParameter_return extends ParserRuleReturnScope {
        public ComponentParameter element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subobjectParameter"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:501:1: subobjectParameter returns [ComponentParameter element] : (single= singleSubobjectParameter | multi= multiSubobjectParameter );
    public final AspectJLoParser.subobjectParameter_return subobjectParameter() throws RecognitionException {
        AspectJLoParser.subobjectParameter_return retval = new AspectJLoParser.subobjectParameter_return();
        retval.start = input.LT(1);
        int subobjectParameter_StartIndex = input.index();
        Object root_0 = null;

        AspectJLoParser.singleSubobjectParameter_return single = null;

        AspectJLoParser.multiSubobjectParameter_return multi = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 424) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:502:2: (single= singleSubobjectParameter | multi= multiSubobjectParameter )
            int alt18=2;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                int LA18_1 = input.LA(2);

                if ( (synpred34_AspectJLo()) ) {
                    alt18=1;
                }
                else if ( (true) ) {
                    alt18=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;
                }
                }
                break;
            case Export:
                {
                int LA18_2 = input.LA(2);

                if ( (synpred34_AspectJLo()) ) {
                    alt18=1;
                }
                else if ( (true) ) {
                    alt18=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 2, input);

                    throw nvae;
                }
                }
                break;
            case Connector:
                {
                int LA18_3 = input.LA(2);

                if ( (synpred34_AspectJLo()) ) {
                    alt18=1;
                }
                else if ( (true) ) {
                    alt18=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 3, input);

                    throw nvae;
                }
                }
                break;
            case Connect:
                {
                int LA18_4 = input.LA(2);

                if ( (synpred34_AspectJLo()) ) {
                    alt18=1;
                }
                else if ( (true) ) {
                    alt18=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 4, input);

                    throw nvae;
                }
                }
                break;
            case Name:
                {
                int LA18_5 = input.LA(2);

                if ( (synpred34_AspectJLo()) ) {
                    alt18=1;
                }
                else if ( (true) ) {
                    alt18=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 5, input);

                    throw nvae;
                }
                }
                break;
            case Overrides:
                {
                int LA18_6 = input.LA(2);

                if ( (synpred34_AspectJLo()) ) {
                    alt18=1;
                }
                else if ( (true) ) {
                    alt18=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 6, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:502:4: single= singleSubobjectParameter
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_singleSubobjectParameter_in_subobjectParameter1243);
                    single=singleSubobjectParameter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, single.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = single.element;
                    }

                    }
                    break;
                case 2 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:503:5: multi= multiSubobjectParameter
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_multiSubobjectParameter_in_subobjectParameter1253);
                    multi=multiSubobjectParameter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, multi.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = multi.element;
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
            if ( state.backtracking>0 ) { memoize(input, 424, subobjectParameter_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "subobjectParameter"

    public static class singleSubobjectParameter_return extends ParserRuleReturnScope {
        public ComponentParameter element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "singleSubobjectParameter"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:506:1: singleSubobjectParameter returns [ComponentParameter element] : id= identifierRule tcontainer= type arrow= '->' tcomp= type ;
    public final AspectJLoParser.singleSubobjectParameter_return singleSubobjectParameter() throws RecognitionException {
        AspectJLoParser.singleSubobjectParameter_return retval = new AspectJLoParser.singleSubobjectParameter_return();
        retval.start = input.LT(1);
        int singleSubobjectParameter_StartIndex = input.index();
        Object root_0 = null;

        Token arrow=null;
        AspectJLoParser.identifierRule_return id = null;

        AspectJLo_JavaP.type_return tcontainer = null;

        AspectJLo_JavaP.type_return tcomp = null;


        Object arrow_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 425) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:507:2: (id= identifierRule tcontainer= type arrow= '->' tcomp= type )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:507:4: id= identifierRule tcontainer= type arrow= '->' tcomp= type
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_identifierRule_in_singleSubobjectParameter1272);
            id=identifierRule();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, id.getTree());
            pushFollow(FOLLOW_type_in_singleSubobjectParameter1276);
            tcontainer=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, tcontainer.getTree());
            arrow=(Token)match(input,126,FOLLOW_126_in_singleSubobjectParameter1280); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            arrow_tree = (Object)adaptor.create(arrow);
            adaptor.addChild(root_0, arrow_tree);
            }
            pushFollow(FOLLOW_type_in_singleSubobjectParameter1284);
            tcomp=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, tcomp.getTree());
            if ( state.backtracking==0 ) {
              retval.element = new SingleFormalComponentParameter(new SimpleNameSignature((id!=null?input.toString(id.start,id.stop):null)),tcontainer.element,tcomp.element);
              	   setLocation(retval.element,id.start,tcomp.stop);
              	   setKeyword(tcontainer.element,arrow);
              	   setName(retval.element,id.start);
              	   
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
            if ( state.backtracking>0 ) { memoize(input, 425, singleSubobjectParameter_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "singleSubobjectParameter"

    public static class multiSubobjectParameter_return extends ParserRuleReturnScope {
        public ComponentParameter element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "multiSubobjectParameter"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:515:1: multiSubobjectParameter returns [ComponentParameter element] : id= identifierRule tcontainer= type arrow= '->' '[' tcomp= type fin= ']' ;
    public final AspectJLoParser.multiSubobjectParameter_return multiSubobjectParameter() throws RecognitionException {
        AspectJLoParser.multiSubobjectParameter_return retval = new AspectJLoParser.multiSubobjectParameter_return();
        retval.start = input.LT(1);
        int multiSubobjectParameter_StartIndex = input.index();
        Object root_0 = null;

        Token arrow=null;
        Token fin=null;
        Token char_literal21=null;
        AspectJLoParser.identifierRule_return id = null;

        AspectJLo_JavaP.type_return tcontainer = null;

        AspectJLo_JavaP.type_return tcomp = null;


        Object arrow_tree=null;
        Object fin_tree=null;
        Object char_literal21_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 426) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:516:2: (id= identifierRule tcontainer= type arrow= '->' '[' tcomp= type fin= ']' )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:516:5: id= identifierRule tcontainer= type arrow= '->' '[' tcomp= type fin= ']'
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_identifierRule_in_multiSubobjectParameter1308);
            id=identifierRule();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, id.getTree());
            pushFollow(FOLLOW_type_in_multiSubobjectParameter1312);
            tcontainer=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, tcontainer.getTree());
            arrow=(Token)match(input,126,FOLLOW_126_in_multiSubobjectParameter1316); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            arrow_tree = (Object)adaptor.create(arrow);
            adaptor.addChild(root_0, arrow_tree);
            }
            char_literal21=(Token)match(input,54,FOLLOW_54_in_multiSubobjectParameter1318); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal21_tree = (Object)adaptor.create(char_literal21);
            adaptor.addChild(root_0, char_literal21_tree);
            }
            pushFollow(FOLLOW_type_in_multiSubobjectParameter1322);
            tcomp=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, tcomp.getTree());
            fin=(Token)match(input,55,FOLLOW_55_in_multiSubobjectParameter1326); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            fin_tree = (Object)adaptor.create(fin);
            adaptor.addChild(root_0, fin_tree);
            }
            if ( state.backtracking==0 ) {
              retval.element = new MultiFormalComponentParameter(new SimpleNameSignature((id!=null?input.toString(id.start,id.stop):null)),tcontainer.element,tcomp.element);
              	   setLocation(retval.element,id.start,fin);
              	   setKeyword(tcontainer.element,arrow);
              	   setName(retval.element,id.start);
              	   
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
            if ( state.backtracking>0 ) { memoize(input, 426, multiSubobjectParameter_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "multiSubobjectParameter"

    public static class subobjectArgument_return extends ParserRuleReturnScope {
        public ActualComponentArgument element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subobjectArgument"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:524:1: subobjectArgument returns [ActualComponentArgument element] : (s= singleSubobjectArgument | ss= multiSubobjectArgument );
    public final AspectJLoParser.subobjectArgument_return subobjectArgument() throws RecognitionException {
        AspectJLoParser.subobjectArgument_return retval = new AspectJLoParser.subobjectArgument_return();
        retval.start = input.LT(1);
        int subobjectArgument_StartIndex = input.index();
        Object root_0 = null;

        AspectJLoParser.singleSubobjectArgument_return s = null;

        AspectJLoParser.multiSubobjectArgument_return ss = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 427) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:525:3: (s= singleSubobjectArgument | ss= multiSubobjectArgument )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==Identifier||(LA19_0>=Export && LA19_0<=Overrides)||LA19_0==79) ) {
                alt19=1;
            }
            else if ( (LA19_0==54) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:526:5: s= singleSubobjectArgument
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_singleSubobjectArgument_in_subobjectArgument1353);
                    s=singleSubobjectArgument();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, s.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element=s.element;
                    }

                    }
                    break;
                case 2 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:527:6: ss= multiSubobjectArgument
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_multiSubobjectArgument_in_subobjectArgument1365);
                    ss=multiSubobjectArgument();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ss.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element=ss.element;
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
            if ( state.backtracking>0 ) { memoize(input, 427, subobjectArgument_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "subobjectArgument"

    public static class singleSubobjectArgument_return extends ParserRuleReturnScope {
        public SingleActualComponentArgument element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "singleSubobjectArgument"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:530:1: singleSubobjectArgument returns [SingleActualComponentArgument element] : (id= identifierRule | '@' idd= identifierRule );
    public final AspectJLoParser.singleSubobjectArgument_return singleSubobjectArgument() throws RecognitionException {
        AspectJLoParser.singleSubobjectArgument_return retval = new AspectJLoParser.singleSubobjectArgument_return();
        retval.start = input.LT(1);
        int singleSubobjectArgument_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal22=null;
        AspectJLoParser.identifierRule_return id = null;

        AspectJLoParser.identifierRule_return idd = null;


        Object char_literal22_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 428) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:531:2: (id= identifierRule | '@' idd= identifierRule )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==Identifier||(LA20_0>=Export && LA20_0<=Overrides)) ) {
                alt20=1;
            }
            else if ( (LA20_0==79) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:532:3: id= identifierRule
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_identifierRule_in_singleSubobjectArgument1389);
                    id=identifierRule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, id.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = new ComponentNameActualArgument((id!=null?input.toString(id.start,id.stop):null));

                    }

                    }
                    break;
                case 2 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:534:11: '@' idd= identifierRule
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal22=(Token)match(input,79,FOLLOW_79_in_singleSubobjectArgument1403); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal22_tree = (Object)adaptor.create(char_literal22);
                    adaptor.addChild(root_0, char_literal22_tree);
                    }
                    pushFollow(FOLLOW_identifierRule_in_singleSubobjectArgument1407);
                    idd=identifierRule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, idd.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = new ParameterReferenceActualArgument((idd!=null?input.toString(idd.start,idd.stop):null));
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
            if ( state.backtracking>0 ) { memoize(input, 428, singleSubobjectArgument_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "singleSubobjectArgument"

    public static class multiSubobjectArgument_return extends ParserRuleReturnScope {
        public MultiActualComponentArgument element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "multiSubobjectArgument"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:537:1: multiSubobjectArgument returns [MultiActualComponentArgument element] : '[' (single= singleSubobjectArgument ( ',' singlee= singleSubobjectArgument )* )? ']' ;
    public final AspectJLoParser.multiSubobjectArgument_return multiSubobjectArgument() throws RecognitionException {
        AspectJLoParser.multiSubobjectArgument_return retval = new AspectJLoParser.multiSubobjectArgument_return();
        retval.start = input.LT(1);
        int multiSubobjectArgument_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal23=null;
        Token char_literal24=null;
        Token char_literal25=null;
        AspectJLoParser.singleSubobjectArgument_return single = null;

        AspectJLoParser.singleSubobjectArgument_return singlee = null;


        Object char_literal23_tree=null;
        Object char_literal24_tree=null;
        Object char_literal25_tree=null;

        retval.element = new MultiActualComponentArgument();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 429) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:539:2: ( '[' (single= singleSubobjectArgument ( ',' singlee= singleSubobjectArgument )* )? ']' )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:540:3: '[' (single= singleSubobjectArgument ( ',' singlee= singleSubobjectArgument )* )? ']'
            {
            root_0 = (Object)adaptor.nil();

            char_literal23=(Token)match(input,54,FOLLOW_54_in_multiSubobjectArgument1431); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal23_tree = (Object)adaptor.create(char_literal23);
            adaptor.addChild(root_0, char_literal23_tree);
            }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:540:7: (single= singleSubobjectArgument ( ',' singlee= singleSubobjectArgument )* )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==Identifier||(LA22_0>=Export && LA22_0<=Overrides)||LA22_0==79) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:540:8: single= singleSubobjectArgument ( ',' singlee= singleSubobjectArgument )*
                    {
                    pushFollow(FOLLOW_singleSubobjectArgument_in_multiSubobjectArgument1436);
                    single=singleSubobjectArgument();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, single.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element.add(single.element);
                    }
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:541:7: ( ',' singlee= singleSubobjectArgument )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==47) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:541:8: ',' singlee= singleSubobjectArgument
                    	    {
                    	    char_literal24=(Token)match(input,47,FOLLOW_47_in_multiSubobjectArgument1448); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal24_tree = (Object)adaptor.create(char_literal24);
                    	    adaptor.addChild(root_0, char_literal24_tree);
                    	    }
                    	    pushFollow(FOLLOW_singleSubobjectArgument_in_multiSubobjectArgument1452);
                    	    singlee=singleSubobjectArgument();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, singlee.getTree());
                    	    if ( state.backtracking==0 ) {
                    	      retval.element.add(singlee.element);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal25=(Token)match(input,55,FOLLOW_55_in_multiSubobjectArgument1464); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal25_tree = (Object)adaptor.create(char_literal25);
            adaptor.addChild(root_0, char_literal25_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 429, multiSubobjectArgument_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "multiSubobjectArgument"

    public static class compilationUnit_return extends ParserRuleReturnScope {
        public CompilationUnit element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compilationUnit"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:551:1: compilationUnit returns [CompilationUnit element] : ( annotations (np= packageDeclaration (imp= importDeclaration )* (typech= typeDeclaration )* | cd= classOrInterfaceDeclaration (typech= typeDeclaration )* ) | (np= packageDeclaration )? (imp= importDeclaration )* (typech= typeDeclaration | ad= aspect )* ) ;
    public final AspectJLoParser.compilationUnit_return compilationUnit() throws RecognitionException {
        AspectJLoParser.compilationUnit_return retval = new AspectJLoParser.compilationUnit_return();
        retval.start = input.LT(1);
        int compilationUnit_StartIndex = input.index();
        Object root_0 = null;

        AspectJLo_JavaP.packageDeclaration_return np = null;

        AspectJLo_JavaP.importDeclaration_return imp = null;

        AspectJLo_JavaP.typeDeclaration_return typech = null;

        AspectJLo_JavaP.classOrInterfaceDeclaration_return cd = null;

        AspectJLoParser.aspect_return ad = null;

        AspectJLo_JavaP.annotations_return annotations26 = null;



         
        NamespacePart npp = null;
        retval.element = getCompilationUnit();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 430) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:556:5: ( ( annotations (np= packageDeclaration (imp= importDeclaration )* (typech= typeDeclaration )* | cd= classOrInterfaceDeclaration (typech= typeDeclaration )* ) | (np= packageDeclaration )? (imp= importDeclaration )* (typech= typeDeclaration | ad= aspect )* ) )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:556:8: ( annotations (np= packageDeclaration (imp= importDeclaration )* (typech= typeDeclaration )* | cd= classOrInterfaceDeclaration (typech= typeDeclaration )* ) | (np= packageDeclaration )? (imp= importDeclaration )* (typech= typeDeclaration | ad= aspect )* )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:556:8: ( annotations (np= packageDeclaration (imp= importDeclaration )* (typech= typeDeclaration )* | cd= classOrInterfaceDeclaration (typech= typeDeclaration )* ) | (np= packageDeclaration )? (imp= importDeclaration )* (typech= typeDeclaration | ad= aspect )* )
            int alt30=2;
            alt30 = dfa30.predict(input);
            switch (alt30) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:556:10: annotations (np= packageDeclaration (imp= importDeclaration )* (typech= typeDeclaration )* | cd= classOrInterfaceDeclaration (typech= typeDeclaration )* )
                    {
                    pushFollow(FOLLOW_annotations_in_compilationUnit1498);
                    annotations26=annotations();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotations26.getTree());
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:557:9: (np= packageDeclaration (imp= importDeclaration )* (typech= typeDeclaration )* | cd= classOrInterfaceDeclaration (typech= typeDeclaration )* )
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==31) ) {
                        alt26=1;
                    }
                    else if ( (LA26_0==ENUM||LA26_0==34||(LA26_0>=37 && LA26_0<=43)||LA26_0==52||LA26_0==79) ) {
                        alt26=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:557:13: np= packageDeclaration (imp= importDeclaration )* (typech= typeDeclaration )*
                            {
                            pushFollow(FOLLOW_packageDeclaration_in_compilationUnit1514);
                            np=packageDeclaration();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, np.getTree());
                            if ( state.backtracking==0 ) {
                              npp=np.element;
                                               retval.element.add(npp);
                                               npp.addImport(new DemandImport(new NamespaceReference("java.lang")));
                                              
                            }
                            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:562:13: (imp= importDeclaration )*
                            loop23:
                            do {
                                int alt23=2;
                                int LA23_0 = input.LA(1);

                                if ( (LA23_0==33) ) {
                                    alt23=1;
                                }


                                switch (alt23) {
                            	case 1 :
                            	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:562:14: imp= importDeclaration
                            	    {
                            	    pushFollow(FOLLOW_importDeclaration_in_compilationUnit1550);
                            	    imp=importDeclaration();

                            	    state._fsp--;
                            	    if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, imp.getTree());
                            	    if ( state.backtracking==0 ) {
                            	      npp.addImport(imp.element);
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop23;
                                }
                            } while (true);

                            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:563:13: (typech= typeDeclaration )*
                            loop24:
                            do {
                                int alt24=2;
                                int LA24_0 = input.LA(1);

                                if ( (LA24_0==ENUM||LA24_0==32||LA24_0==34||(LA24_0>=37 && LA24_0<=43)||LA24_0==52||LA24_0==79) ) {
                                    alt24=1;
                                }


                                switch (alt24) {
                            	case 1 :
                            	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:563:14: typech= typeDeclaration
                            	    {
                            	    pushFollow(FOLLOW_typeDeclaration_in_compilationUnit1571);
                            	    typech=typeDeclaration();

                            	    state._fsp--;
                            	    if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typech.getTree());
                            	    if ( state.backtracking==0 ) {
                            	      processType(npp,typech.element);
                            	                      
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop24;
                                }
                            } while (true);


                            }
                            break;
                        case 2 :
                            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:567:13: cd= classOrInterfaceDeclaration (typech= typeDeclaration )*
                            {
                            pushFollow(FOLLOW_classOrInterfaceDeclaration_in_compilationUnit1620);
                            cd=classOrInterfaceDeclaration();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, cd.getTree());
                            if ( state.backtracking==0 ) {
                              npp = new NamespacePart(language().defaultNamespace());
                                              retval.element.add(npp);
                                              npp.addImport(new DemandImport(new NamespaceReference("java.lang")));
                                              processType(npp,cd.element);
                                             
                            }
                            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:573:13: (typech= typeDeclaration )*
                            loop25:
                            do {
                                int alt25=2;
                                int LA25_0 = input.LA(1);

                                if ( (LA25_0==ENUM||LA25_0==32||LA25_0==34||(LA25_0>=37 && LA25_0<=43)||LA25_0==52||LA25_0==79) ) {
                                    alt25=1;
                                }


                                switch (alt25) {
                            	case 1 :
                            	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:573:14: typech= typeDeclaration
                            	    {
                            	    pushFollow(FOLLOW_typeDeclaration_in_compilationUnit1655);
                            	    typech=typeDeclaration();

                            	    state._fsp--;
                            	    if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typech.getTree());
                            	    if ( state.backtracking==0 ) {
                            	      processType(npp,typech.element);
                            	                     
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop25;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:578:9: (np= packageDeclaration )? (imp= importDeclaration )* (typech= typeDeclaration | ad= aspect )*
                    {
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:578:9: (np= packageDeclaration )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==31) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:578:10: np= packageDeclaration
                            {
                            pushFollow(FOLLOW_packageDeclaration_in_compilationUnit1710);
                            np=packageDeclaration();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, np.getTree());
                            if ( state.backtracking==0 ) {

                                            npp=np.element;
                                          
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                               if(npp == null) {
                                 npp = new NamespacePart(language().defaultNamespace());
                               }
                               npp.addImport(new DemandImport(new NamespaceReference("java.lang")));
                               retval.element.add(npp);
                              
                    }
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:590:9: (imp= importDeclaration )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==33) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:590:10: imp= importDeclaration
                    	    {
                    	    pushFollow(FOLLOW_importDeclaration_in_compilationUnit1759);
                    	    imp=importDeclaration();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, imp.getTree());
                    	    if ( state.backtracking==0 ) {
                    	      npp.addImport(imp.element);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);

                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:593:9: (typech= typeDeclaration | ad= aspect )*
                    loop29:
                    do {
                        int alt29=3;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==ENUM||LA29_0==32||LA29_0==34||(LA29_0>=37 && LA29_0<=43)||LA29_0==52||LA29_0==79) ) {
                            alt29=1;
                        }
                        else if ( (LA29_0==127) ) {
                            alt29=2;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:593:10: typech= typeDeclaration
                    	    {
                    	    pushFollow(FOLLOW_typeDeclaration_in_compilationUnit1796);
                    	    typech=typeDeclaration();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typech.getTree());
                    	    if ( state.backtracking==0 ) {

                    	                 processType(npp,typech.element);
                    	                
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:598:11: ad= aspect
                    	    {
                    	    pushFollow(FOLLOW_aspect_in_compilationUnit1834);
                    	    ad=aspect();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ad.getTree());
                    	    if ( state.backtracking==0 ) {

                    	             		 npp.add(ad.element);       	
                    	             	  
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);


                    }
                    break;

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
            if ( state.backtracking>0 ) { memoize(input, 430, compilationUnit_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "compilationUnit"

    public static class aspect_return extends ParserRuleReturnScope {
        public Aspect element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "aspect"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:606:1: aspect returns [Aspect element] : asp= 'aspect' name= identifierRule '{' ( (adv= advice ) | (ptc= pointcut ) )* '}' ;
    public final AspectJLoParser.aspect_return aspect() throws RecognitionException {
        AspectJLoParser.aspect_return retval = new AspectJLoParser.aspect_return();
        retval.start = input.LT(1);
        int aspect_StartIndex = input.index();
        Object root_0 = null;

        Token asp=null;
        Token char_literal27=null;
        Token char_literal28=null;
        AspectJLoParser.identifierRule_return name = null;

        AspectJLoParser.advice_return adv = null;

        AspectJLoParser.pointcut_return ptc = null;


        Object asp_tree=null;
        Object char_literal27_tree=null;
        Object char_literal28_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 431) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:607:2: (asp= 'aspect' name= identifierRule '{' ( (adv= advice ) | (ptc= pointcut ) )* '}' )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:607:4: asp= 'aspect' name= identifierRule '{' ( (adv= advice ) | (ptc= pointcut ) )* '}'
            {
            root_0 = (Object)adaptor.nil();

            asp=(Token)match(input,127,FOLLOW_127_in_aspect1880); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            asp_tree = (Object)adaptor.create(asp);
            adaptor.addChild(root_0, asp_tree);
            }
            pushFollow(FOLLOW_identifierRule_in_aspect1884);
            name=identifierRule();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, name.getTree());
            if ( state.backtracking==0 ) {
              retval.element = new Aspect((name!=null?input.toString(name.start,name.stop):null));
            }
            char_literal27=(Token)match(input,50,FOLLOW_50_in_aspect1890); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal27_tree = (Object)adaptor.create(char_literal27);
            adaptor.addChild(root_0, char_literal27_tree);
            }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:609:2: ( (adv= advice ) | (ptc= pointcut ) )*
            loop31:
            do {
                int alt31=3;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==Identifier||(LA31_0>=Export && LA31_0<=Overrides)||LA31_0==53||(LA31_0>=62 && LA31_0<=69)||(LA31_0>=140 && LA31_0<=142)) ) {
                    alt31=1;
                }
                else if ( (LA31_0==128) ) {
                    alt31=2;
                }


                switch (alt31) {
            	case 1 :
            	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:609:3: (adv= advice )
            	    {
            	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:609:3: (adv= advice )
            	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:609:4: adv= advice
            	    {
            	    pushFollow(FOLLOW_advice_in_aspect1899);
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
            	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:609:56: (ptc= pointcut )
            	    {
            	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:609:56: (ptc= pointcut )
            	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:609:57: ptc= pointcut
            	    {
            	    pushFollow(FOLLOW_pointcut_in_aspect1906);
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
            	    break loop31;
                }
            } while (true);

            char_literal28=(Token)match(input,51,FOLLOW_51_in_aspect1914); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal28_tree = (Object)adaptor.create(char_literal28);
            adaptor.addChild(root_0, char_literal28_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 431, aspect_StartIndex); }
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
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:617:1: pointcut returns [Pointcut element] : pct= 'pointcut' decl= pointcutDecl pars= formalParameters ':' expr= pointcutExpression ';' ;
    public final AspectJLoParser.pointcut_return pointcut() throws RecognitionException {
        AspectJLoParser.pointcut_return retval = new AspectJLoParser.pointcut_return();
        retval.start = input.LT(1);
        int pointcut_StartIndex = input.index();
        Object root_0 = null;

        Token pct=null;
        Token char_literal29=null;
        Token char_literal30=null;
        AspectJLoParser.pointcutDecl_return decl = null;

        AspectJLo_JavaP.formalParameters_return pars = null;

        AspectJLoParser.pointcutExpression_return expr = null;


        Object pct_tree=null;
        Object char_literal29_tree=null;
        Object char_literal30_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 432) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:619:2: (pct= 'pointcut' decl= pointcutDecl pars= formalParameters ':' expr= pointcutExpression ';' )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:619:4: pct= 'pointcut' decl= pointcutDecl pars= formalParameters ':' expr= pointcutExpression ';'
            {
            root_0 = (Object)adaptor.nil();

            pct=(Token)match(input,128,FOLLOW_128_in_pointcut1941); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            pct_tree = (Object)adaptor.create(pct);
            adaptor.addChild(root_0, pct_tree);
            }
            pushFollow(FOLLOW_pointcutDecl_in_pointcut1945);
            decl=pointcutDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, decl.getTree());
            pushFollow(FOLLOW_formalParameters_in_pointcut1949);
            pars=formalParameters();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pars.getTree());
            char_literal29=(Token)match(input,81,FOLLOW_81_in_pointcut1951); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal29_tree = (Object)adaptor.create(char_literal29);
            adaptor.addChild(root_0, char_literal29_tree);
            }
            pushFollow(FOLLOW_pointcutExpression_in_pointcut1955);
            expr=pointcutExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr.getTree());
            char_literal30=(Token)match(input,32,FOLLOW_32_in_pointcut1957); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal30_tree = (Object)adaptor.create(char_literal30);
            adaptor.addChild(root_0, char_literal30_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 432, pointcut_StartIndex); }
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
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:630:1: pointcutDecl returns [String element] : name= identifierRule ;
    public final AspectJLoParser.pointcutDecl_return pointcutDecl() throws RecognitionException {
        AspectJLoParser.pointcutDecl_return retval = new AspectJLoParser.pointcutDecl_return();
        retval.start = input.LT(1);
        int pointcutDecl_StartIndex = input.index();
        Object root_0 = null;

        AspectJLoParser.identifierRule_return name = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 433) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:631:2: (name= identifierRule )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:631:4: name= identifierRule
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_identifierRule_in_pointcutDecl1980);
            name=identifierRule();

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
            if ( state.backtracking>0 ) { memoize(input, 433, pointcutDecl_StartIndex); }
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
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:634:1: pointcutExpression returns [PointcutExpression element] : (expr1= pointcutExpressionOr '&&' expr2= pointcutExpression | exprOr= pointcutExpressionOr );
    public final AspectJLoParser.pointcutExpression_return pointcutExpression() throws RecognitionException {
        AspectJLoParser.pointcutExpression_return retval = new AspectJLoParser.pointcutExpression_return();
        retval.start = input.LT(1);
        int pointcutExpression_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal31=null;
        AspectJLoParser.pointcutExpressionOr_return expr1 = null;

        AspectJLoParser.pointcutExpression_return expr2 = null;

        AspectJLoParser.pointcutExpressionOr_return exprOr = null;


        Object string_literal31_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 434) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:636:2: (expr1= pointcutExpressionOr '&&' expr2= pointcutExpression | exprOr= pointcutExpressionOr )
            int alt32=2;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:636:4: expr1= pointcutExpressionOr '&&' expr2= pointcutExpression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pointcutExpressionOr_in_pointcutExpression2005);
                    expr1=pointcutExpressionOr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr1.getTree());
                    string_literal31=(Token)match(input,105,FOLLOW_105_in_pointcutExpression2007); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal31_tree = (Object)adaptor.create(string_literal31);
                    adaptor.addChild(root_0, string_literal31_tree);
                    }
                    pushFollow(FOLLOW_pointcutExpression_in_pointcutExpression2011);
                    expr2=pointcutExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr2.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = new PointcutExpressionAnd(expr1.element, expr2.element);
                    }

                    }
                    break;
                case 2 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:637:4: exprOr= pointcutExpressionOr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pointcutExpressionOr_in_pointcutExpression2020);
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
            if ( state.backtracking>0 ) { memoize(input, 434, pointcutExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "pointcutExpression"

    public static class memberReference_return extends ParserRuleReturnScope {
        public MemberReference element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "memberReference"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:640:1: memberReference returns [MemberReference element] : (initName= identifierRule ( '.' appendName= identifierRule )* ) ;
    public final AspectJLoParser.memberReference_return memberReference() throws RecognitionException {
        AspectJLoParser.memberReference_return retval = new AspectJLoParser.memberReference_return();
        retval.start = input.LT(1);
        int memberReference_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal32=null;
        AspectJLoParser.identifierRule_return initName = null;

        AspectJLoParser.identifierRule_return appendName = null;


        Object char_literal32_tree=null;

        String fullName = "";
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 435) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:642:2: ( (initName= identifierRule ( '.' appendName= identifierRule )* ) )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:642:4: (initName= identifierRule ( '.' appendName= identifierRule )* )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:642:4: (initName= identifierRule ( '.' appendName= identifierRule )* )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:642:5: initName= identifierRule ( '.' appendName= identifierRule )*
            {
            pushFollow(FOLLOW_identifierRule_in_memberReference2044);
            initName=identifierRule();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, initName.getTree());
            if ( state.backtracking==0 ) {
              fullName = (initName!=null?input.toString(initName.start,initName.stop):null);
            }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:642:58: ( '.' appendName= identifierRule )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==35) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:642:59: '.' appendName= identifierRule
            	    {
            	    char_literal32=(Token)match(input,35,FOLLOW_35_in_memberReference2049); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal32_tree = (Object)adaptor.create(char_literal32);
            	    adaptor.addChild(root_0, char_literal32_tree);
            	    }
            	    pushFollow(FOLLOW_identifierRule_in_memberReference2053);
            	    appendName=identifierRule();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, appendName.getTree());
            	    if ( state.backtracking==0 ) {
            	      fullName += "." + (appendName!=null?input.toString(appendName.start,appendName.stop):null); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
              retval.element = new MemberReference(fullName);
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
            if ( state.backtracking>0 ) { memoize(input, 435, memberReference_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "memberReference"

    public static class pointcutExpressionOr_return extends ParserRuleReturnScope {
        public PointcutExpression element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pointcutExpressionOr"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:645:1: pointcutExpressionOr returns [PointcutExpression element] : (expr1= pointcutAtom '||' expr2= pointcutExpressionOr | expr= pointcutAtom );
    public final AspectJLoParser.pointcutExpressionOr_return pointcutExpressionOr() throws RecognitionException {
        AspectJLoParser.pointcutExpressionOr_return retval = new AspectJLoParser.pointcutExpressionOr_return();
        retval.start = input.LT(1);
        int pointcutExpressionOr_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal33=null;
        AspectJLoParser.pointcutAtom_return expr1 = null;

        AspectJLoParser.pointcutExpressionOr_return expr2 = null;

        AspectJLoParser.pointcutAtom_return expr = null;


        Object string_literal33_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 436) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:647:2: (expr1= pointcutAtom '||' expr2= pointcutExpressionOr | expr= pointcutAtom )
            int alt34=2;
            alt34 = dfa34.predict(input);
            switch (alt34) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:647:4: expr1= pointcutAtom '||' expr2= pointcutExpressionOr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pointcutAtom_in_pointcutExpressionOr2081);
                    expr1=pointcutAtom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr1.getTree());
                    string_literal33=(Token)match(input,104,FOLLOW_104_in_pointcutExpressionOr2083); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal33_tree = (Object)adaptor.create(string_literal33);
                    adaptor.addChild(root_0, string_literal33_tree);
                    }
                    pushFollow(FOLLOW_pointcutExpressionOr_in_pointcutExpressionOr2087);
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
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:648:4: expr= pointcutAtom
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pointcutAtom_in_pointcutExpressionOr2096);
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
            if ( state.backtracking>0 ) { memoize(input, 436, pointcutExpressionOr_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "pointcutExpressionOr"

    public static class methodReference_return extends ParserRuleReturnScope {
        public MethodReference element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "methodReference"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:651:1: methodReference returns [MethodReference element] : (t= typeOrVoid | twc= IdentifierWithWC ) name= methodRefFqn ;
    public final AspectJLoParser.methodReference_return methodReference() throws RecognitionException {
        AspectJLoParser.methodReference_return retval = new AspectJLoParser.methodReference_return();
        retval.start = input.LT(1);
        int methodReference_StartIndex = input.index();
        Object root_0 = null;

        Token twc=null;
        AspectJLoParser.typeOrVoid_return t = null;

        AspectJLoParser.methodRefFqn_return name = null;


        Object twc_tree=null;

        JavaTypeReference type = null; String typeWithWC = null;
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 437) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:654:2: ( (t= typeOrVoid | twc= IdentifierWithWC ) name= methodRefFqn )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:654:4: (t= typeOrVoid | twc= IdentifierWithWC ) name= methodRefFqn
            {
            root_0 = (Object)adaptor.nil();

            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:654:4: (t= typeOrVoid | twc= IdentifierWithWC )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==Identifier||(LA35_0>=Export && LA35_0<=Overrides)||LA35_0==53||(LA35_0>=62 && LA35_0<=69)) ) {
                alt35=1;
            }
            else if ( (LA35_0==IdentifierWithWC) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:654:5: t= typeOrVoid
                    {
                    pushFollow(FOLLOW_typeOrVoid_in_methodReference2125);
                    t=typeOrVoid();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
                    if ( state.backtracking==0 ) {
                      type = t.element; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:654:39: twc= IdentifierWithWC
                    {
                    twc=(Token)match(input,IdentifierWithWC,FOLLOW_IdentifierWithWC_in_methodReference2131); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    twc_tree = (Object)adaptor.create(twc);
                    adaptor.addChild(root_0, twc_tree);
                    }
                    if ( state.backtracking==0 ) {
                      typeWithWC = (twc!=null?twc.getText():null);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_methodRefFqn_in_methodReference2138);
            name=methodRefFqn();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, name.getTree());
            if ( state.backtracking==0 ) {
              retval.element = new MethodReference(name.element, type, typeWithWC);
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
            if ( state.backtracking>0 ) { memoize(input, 437, methodReference_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "methodReference"

    public static class methodRefFqn_return extends ParserRuleReturnScope {
        public QualifiedMethodHeader element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "methodRefFqn"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:657:1: methodRefFqn returns [QualifiedMethodHeader element] : (id= ( IdentifierWithWC | Identifier ) '.' )* mth= simpleMethodHeader ;
    public final AspectJLoParser.methodRefFqn_return methodRefFqn() throws RecognitionException {
        AspectJLoParser.methodRefFqn_return retval = new AspectJLoParser.methodRefFqn_return();
        retval.start = input.LT(1);
        int methodRefFqn_StartIndex = input.index();
        Object root_0 = null;

        Token id=null;
        Token char_literal34=null;
        AspectJLoParser.simpleMethodHeader_return mth = null;


        Object id_tree=null;
        Object char_literal34_tree=null;

        CompositeQualifiedName prefixes = new CompositeQualifiedName();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 438) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:660:2: ( (id= ( IdentifierWithWC | Identifier ) '.' )* mth= simpleMethodHeader )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:660:4: (id= ( IdentifierWithWC | Identifier ) '.' )* mth= simpleMethodHeader
            {
            root_0 = (Object)adaptor.nil();

            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:660:4: (id= ( IdentifierWithWC | Identifier ) '.' )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==Identifier||LA36_0==IdentifierWithWC) ) {
                    int LA36_1 = input.LA(2);

                    if ( (LA36_1==35) ) {
                        alt36=1;
                    }


                }


                switch (alt36) {
            	case 1 :
            	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:660:5: id= ( IdentifierWithWC | Identifier ) '.'
            	    {
            	    id=(Token)input.LT(1);
            	    if ( input.LA(1)==Identifier||input.LA(1)==IdentifierWithWC ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(id));
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    char_literal34=(Token)match(input,35,FOLLOW_35_in_methodRefFqn2172); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal34_tree = (Object)adaptor.create(char_literal34);
            	    adaptor.addChild(root_0, char_literal34_tree);
            	    }
            	    if ( state.backtracking==0 ) {
            	      prefixes.append(new SimpleNameSignature((id!=null?id.getText():null)));
            	    }

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            pushFollow(FOLLOW_simpleMethodHeader_in_methodRefFqn2180);
            mth=simpleMethodHeader();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mth.getTree());
            if ( state.backtracking==0 ) {
              retval.element = new QualifiedMethodHeader(mth.element); retval.element.setPrefixes(prefixes);
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
            if ( state.backtracking>0 ) { memoize(input, 438, methodRefFqn_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "methodRefFqn"

    public static class simpleMethodHeader_return extends ParserRuleReturnScope {
        public SimpleNameDeclarationWithParameterTypesHeader element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "simpleMethodHeader"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:663:1: simpleMethodHeader returns [SimpleNameDeclarationWithParameterTypesHeader element] : name= ( IdentifierWithWC | Identifier ) pars= formalParameterTypes ;
    public final AspectJLoParser.simpleMethodHeader_return simpleMethodHeader() throws RecognitionException {
        AspectJLoParser.simpleMethodHeader_return retval = new AspectJLoParser.simpleMethodHeader_return();
        retval.start = input.LT(1);
        int simpleMethodHeader_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        AspectJLoParser.formalParameterTypes_return pars = null;


        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 439) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:665:9: (name= ( IdentifierWithWC | Identifier ) pars= formalParameterTypes )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:665:11: name= ( IdentifierWithWC | Identifier ) pars= formalParameterTypes
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)input.LT(1);
            if ( input.LA(1)==Identifier||input.LA(1)==IdentifierWithWC ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(name));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            pushFollow(FOLLOW_formalParameterTypes_in_simpleMethodHeader2219);
            pars=formalParameterTypes();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pars.getTree());
            if ( state.backtracking==0 ) {
              retval.element = new SimpleNameDeclarationWithParameterTypesHeader((name!=null?name.getText():null)); retval.element.addAll(pars.element); 
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
            if ( state.backtracking>0 ) { memoize(input, 439, simpleMethodHeader_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "simpleMethodHeader"

    public static class formalParameterTypes_return extends ParserRuleReturnScope {
        public List<TypeReference> element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "formalParameterTypes"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:668:1: formalParameterTypes returns [List<TypeReference> element] : '(' (pars= formalParameterTypeDecls )? ')' ;
    public final AspectJLoParser.formalParameterTypes_return formalParameterTypes() throws RecognitionException {
        AspectJLoParser.formalParameterTypes_return retval = new AspectJLoParser.formalParameterTypes_return();
        retval.start = input.LT(1);
        int formalParameterTypes_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal35=null;
        Token char_literal36=null;
        AspectJLoParser.formalParameterTypeDecls_return pars = null;


        Object char_literal35_tree=null;
        Object char_literal36_tree=null;

        retval.element = new ArrayList<TypeReference>();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 440) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:670:5: ( '(' (pars= formalParameterTypeDecls )? ')' )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:670:9: '(' (pars= formalParameterTypeDecls )? ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal35=(Token)match(input,72,FOLLOW_72_in_formalParameterTypes2261); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal35_tree = (Object)adaptor.create(char_literal35);
            adaptor.addChild(root_0, char_literal35_tree);
            }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:670:13: (pars= formalParameterTypeDecls )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==Identifier||(LA37_0>=Export && LA37_0<=Overrides)||(LA37_0>=62 && LA37_0<=69)) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:670:14: pars= formalParameterTypeDecls
                    {
                    pushFollow(FOLLOW_formalParameterTypeDecls_in_formalParameterTypes2266);
                    pars=formalParameterTypeDecls();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pars.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element=pars.element;
                    }

                    }
                    break;

            }

            char_literal36=(Token)match(input,73,FOLLOW_73_in_formalParameterTypes2272); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal36_tree = (Object)adaptor.create(char_literal36);
            adaptor.addChild(root_0, char_literal36_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 440, formalParameterTypes_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "formalParameterTypes"

    public static class formalParameterTypeDecls_return extends ParserRuleReturnScope {
        public List<TypeReference> element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "formalParameterTypeDecls"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:673:1: formalParameterTypeDecls returns [List<TypeReference> element] : t= type ( ',' decls= formalParameterTypeDecls )? ;
    public final AspectJLoParser.formalParameterTypeDecls_return formalParameterTypeDecls() throws RecognitionException {
        AspectJLoParser.formalParameterTypeDecls_return retval = new AspectJLoParser.formalParameterTypeDecls_return();
        retval.start = input.LT(1);
        int formalParameterTypeDecls_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal37=null;
        AspectJLo_JavaP.type_return t = null;

        AspectJLoParser.formalParameterTypeDecls_return decls = null;


        Object char_literal37_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 441) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:674:5: (t= type ( ',' decls= formalParameterTypeDecls )? )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:674:9: t= type ( ',' decls= formalParameterTypeDecls )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_type_in_formalParameterTypeDecls2297);
            t=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:674:16: ( ',' decls= formalParameterTypeDecls )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==47) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:674:17: ',' decls= formalParameterTypeDecls
                    {
                    char_literal37=(Token)match(input,47,FOLLOW_47_in_formalParameterTypeDecls2300); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal37_tree = (Object)adaptor.create(char_literal37);
                    adaptor.addChild(root_0, char_literal37_tree);
                    }
                    pushFollow(FOLLOW_formalParameterTypeDecls_in_formalParameterTypeDecls2304);
                    decls=formalParameterTypeDecls();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, decls.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element=decls.element; 
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              if(retval.element == null) {
                       retval.element=new ArrayList<TypeReference>();}
                       retval.element.add(0, t.element);
                       
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
            if ( state.backtracking>0 ) { memoize(input, 441, formalParameterTypeDecls_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "formalParameterTypeDecls"

    public static class typeOrVoid_return extends ParserRuleReturnScope {
        public JavaTypeReference element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeOrVoid"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:681:1: typeOrVoid returns [JavaTypeReference element] : (t= type | v= voidType );
    public final AspectJLoParser.typeOrVoid_return typeOrVoid() throws RecognitionException {
        AspectJLoParser.typeOrVoid_return retval = new AspectJLoParser.typeOrVoid_return();
        retval.start = input.LT(1);
        int typeOrVoid_StartIndex = input.index();
        Object root_0 = null;

        AspectJLo_JavaP.type_return t = null;

        AspectJLo_JavaP.voidType_return v = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 442) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:682:2: (t= type | v= voidType )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==Identifier||(LA39_0>=Export && LA39_0<=Overrides)||(LA39_0>=62 && LA39_0<=69)) ) {
                alt39=1;
            }
            else if ( (LA39_0==53) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:682:4: t= type
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_type_in_typeOrVoid2339);
                    t=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element=t.element;
                    }

                    }
                    break;
                case 2 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:683:4: v= voidType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_voidType_in_typeOrVoid2348);
                    v=voidType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element=v.element;
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
            if ( state.backtracking>0 ) { memoize(input, 442, typeOrVoid_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "typeOrVoid"

    public static class pointcutAtom_return extends ParserRuleReturnScope {
        public PointcutExpression element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pointcutAtom"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:686:1: pointcutAtom returns [PointcutExpression element] : (cl= 'call' '(' metref= methodReference ')' | subobjRead= 'subobjectRead' '(' subobjreadType= type subobjreadRef= memberReference ')' | clA= 'callAnnotated' '(' annot= identifierRule ')' | emptyCatch= 'emptyHandler' | fieldRead= 'fieldRead' '(' fieldreadtype= type fieldref= fieldReference ')' | handler= 'typeHandler' '(' exceptionType= type ')' | cast= 'cast' '(' castType= type ')' | namedRef= namedPointcutReference | withinCl= within | getargs= 'arguments' t= typesOrParameters | thisType= 'thisType' '(' exp= expression ')' | targetType= 'targetType' '(' exp= expression ')' | ifCheck= 'if' '(' exp= expression ')' | '!' expr1= pointcutAtom | '(' expr2= pointcutExpression ')' );
    public final AspectJLoParser.pointcutAtom_return pointcutAtom() throws RecognitionException {
        AspectJLoParser.pointcutAtom_return retval = new AspectJLoParser.pointcutAtom_return();
        retval.start = input.LT(1);
        int pointcutAtom_StartIndex = input.index();
        Object root_0 = null;

        Token cl=null;
        Token subobjRead=null;
        Token clA=null;
        Token emptyCatch=null;
        Token fieldRead=null;
        Token handler=null;
        Token cast=null;
        Token getargs=null;
        Token thisType=null;
        Token targetType=null;
        Token ifCheck=null;
        Token char_literal38=null;
        Token char_literal39=null;
        Token char_literal40=null;
        Token char_literal41=null;
        Token char_literal42=null;
        Token char_literal43=null;
        Token char_literal44=null;
        Token char_literal45=null;
        Token char_literal46=null;
        Token char_literal47=null;
        Token char_literal48=null;
        Token char_literal49=null;
        Token char_literal50=null;
        Token char_literal51=null;
        Token char_literal52=null;
        Token char_literal53=null;
        Token char_literal54=null;
        Token char_literal55=null;
        Token char_literal56=null;
        Token char_literal57=null;
        Token char_literal58=null;
        AspectJLoParser.methodReference_return metref = null;

        AspectJLo_JavaP.type_return subobjreadType = null;

        AspectJLoParser.memberReference_return subobjreadRef = null;

        AspectJLoParser.identifierRule_return annot = null;

        AspectJLo_JavaP.type_return fieldreadtype = null;

        AspectJLoParser.fieldReference_return fieldref = null;

        AspectJLo_JavaP.type_return exceptionType = null;

        AspectJLo_JavaP.type_return castType = null;

        AspectJLoParser.namedPointcutReference_return namedRef = null;

        AspectJLoParser.within_return withinCl = null;

        AspectJLoParser.typesOrParameters_return t = null;

        AspectJLoParser.expression_return exp = null;

        AspectJLoParser.pointcutAtom_return expr1 = null;

        AspectJLoParser.pointcutExpression_return expr2 = null;


        Object cl_tree=null;
        Object subobjRead_tree=null;
        Object clA_tree=null;
        Object emptyCatch_tree=null;
        Object fieldRead_tree=null;
        Object handler_tree=null;
        Object cast_tree=null;
        Object getargs_tree=null;
        Object thisType_tree=null;
        Object targetType_tree=null;
        Object ifCheck_tree=null;
        Object char_literal38_tree=null;
        Object char_literal39_tree=null;
        Object char_literal40_tree=null;
        Object char_literal41_tree=null;
        Object char_literal42_tree=null;
        Object char_literal43_tree=null;
        Object char_literal44_tree=null;
        Object char_literal45_tree=null;
        Object char_literal46_tree=null;
        Object char_literal47_tree=null;
        Object char_literal48_tree=null;
        Object char_literal49_tree=null;
        Object char_literal50_tree=null;
        Object char_literal51_tree=null;
        Object char_literal52_tree=null;
        Object char_literal53_tree=null;
        Object char_literal54_tree=null;
        Object char_literal55_tree=null;
        Object char_literal56_tree=null;
        Object char_literal57_tree=null;
        Object char_literal58_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 443) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:688:2: (cl= 'call' '(' metref= methodReference ')' | subobjRead= 'subobjectRead' '(' subobjreadType= type subobjreadRef= memberReference ')' | clA= 'callAnnotated' '(' annot= identifierRule ')' | emptyCatch= 'emptyHandler' | fieldRead= 'fieldRead' '(' fieldreadtype= type fieldref= fieldReference ')' | handler= 'typeHandler' '(' exceptionType= type ')' | cast= 'cast' '(' castType= type ')' | namedRef= namedPointcutReference | withinCl= within | getargs= 'arguments' t= typesOrParameters | thisType= 'thisType' '(' exp= expression ')' | targetType= 'targetType' '(' exp= expression ')' | ifCheck= 'if' '(' exp= expression ')' | '!' expr1= pointcutAtom | '(' expr2= pointcutExpression ')' )
            int alt40=15;
            switch ( input.LA(1) ) {
            case 129:
                {
                alt40=1;
                }
                break;
            case 130:
                {
                alt40=2;
                }
                break;
            case 131:
                {
                alt40=3;
                }
                break;
            case 132:
                {
                alt40=4;
                }
                break;
            case 133:
                {
                alt40=5;
                }
                break;
            case 134:
                {
                alt40=6;
                }
                break;
            case 135:
                {
                alt40=7;
                }
                break;
            case Identifier:
            case Export:
            case Connector:
            case Connect:
            case Name:
            case Overrides:
                {
                alt40=8;
                }
                break;
            case 139:
                {
                alt40=9;
                }
                break;
            case 136:
                {
                alt40=10;
                }
                break;
            case 137:
                {
                alt40=11;
                }
                break;
            case 138:
                {
                alt40=12;
                }
                break;
            case 82:
                {
                alt40=13;
                }
                break;
            case 118:
                {
                alt40=14;
                }
                break;
            case 72:
                {
                alt40=15;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:688:4: cl= 'call' '(' metref= methodReference ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    cl=(Token)match(input,129,FOLLOW_129_in_pointcutAtom2372); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    cl_tree = (Object)adaptor.create(cl);
                    adaptor.addChild(root_0, cl_tree);
                    }
                    char_literal38=(Token)match(input,72,FOLLOW_72_in_pointcutAtom2374); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal38_tree = (Object)adaptor.create(char_literal38);
                    adaptor.addChild(root_0, char_literal38_tree);
                    }
                    pushFollow(FOLLOW_methodReference_in_pointcutAtom2378);
                    metref=methodReference();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, metref.getTree());
                    char_literal39=(Token)match(input,73,FOLLOW_73_in_pointcutAtom2380); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal39_tree = (Object)adaptor.create(char_literal39);
                    adaptor.addChild(root_0, char_literal39_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new SignatureMethodInvocationPointcutExpression(metref.element); setKeyword(retval.element, cl);
                    }

                    }
                    break;
                case 2 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:689:4: subobjRead= 'subobjectRead' '(' subobjreadType= type subobjreadRef= memberReference ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    subobjRead=(Token)match(input,130,FOLLOW_130_in_pointcutAtom2389); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    subobjRead_tree = (Object)adaptor.create(subobjRead);
                    adaptor.addChild(root_0, subobjRead_tree);
                    }
                    char_literal40=(Token)match(input,72,FOLLOW_72_in_pointcutAtom2391); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal40_tree = (Object)adaptor.create(char_literal40);
                    adaptor.addChild(root_0, char_literal40_tree);
                    }
                    pushFollow(FOLLOW_type_in_pointcutAtom2395);
                    subobjreadType=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, subobjreadType.getTree());
                    pushFollow(FOLLOW_memberReference_in_pointcutAtom2399);
                    subobjreadRef=memberReference();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, subobjreadRef.getTree());
                    char_literal41=(Token)match(input,73,FOLLOW_73_in_pointcutAtom2401); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal41_tree = (Object)adaptor.create(char_literal41);
                    adaptor.addChild(root_0, char_literal41_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new SubobjectRead(subobjreadType.element, subobjreadRef.element); setKeyword(retval.element, subobjRead); 
                    }

                    }
                    break;
                case 3 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:690:4: clA= 'callAnnotated' '(' annot= identifierRule ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    clA=(Token)match(input,131,FOLLOW_131_in_pointcutAtom2411); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    clA_tree = (Object)adaptor.create(clA);
                    adaptor.addChild(root_0, clA_tree);
                    }
                    char_literal42=(Token)match(input,72,FOLLOW_72_in_pointcutAtom2413); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal42_tree = (Object)adaptor.create(char_literal42);
                    adaptor.addChild(root_0, char_literal42_tree);
                    }
                    pushFollow(FOLLOW_identifierRule_in_pointcutAtom2417);
                    annot=identifierRule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annot.getTree());
                    char_literal43=(Token)match(input,73,FOLLOW_73_in_pointcutAtom2419); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal43_tree = (Object)adaptor.create(char_literal43);
                    adaptor.addChild(root_0, char_literal43_tree);
                    }
                    if ( state.backtracking==0 ) {
                      AnnotatedMethodInvocationExpression result = new AnnotatedMethodInvocationExpression(); result.setReference(new AnnotationReference((annot!=null?input.toString(annot.start,annot.stop):null))); retval.element = result; setKeyword(retval.element, clA);
                    }

                    }
                    break;
                case 4 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:691:4: emptyCatch= 'emptyHandler'
                    {
                    root_0 = (Object)adaptor.nil();

                    emptyCatch=(Token)match(input,132,FOLLOW_132_in_pointcutAtom2428); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    emptyCatch_tree = (Object)adaptor.create(emptyCatch);
                    adaptor.addChild(root_0, emptyCatch_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new EmptyCatchClausePointcutExpression(); setKeyword(retval.element, emptyCatch); 
                    }

                    }
                    break;
                case 5 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:692:4: fieldRead= 'fieldRead' '(' fieldreadtype= type fieldref= fieldReference ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    fieldRead=(Token)match(input,133,FOLLOW_133_in_pointcutAtom2437); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    fieldRead_tree = (Object)adaptor.create(fieldRead);
                    adaptor.addChild(root_0, fieldRead_tree);
                    }
                    char_literal44=(Token)match(input,72,FOLLOW_72_in_pointcutAtom2439); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal44_tree = (Object)adaptor.create(char_literal44);
                    adaptor.addChild(root_0, char_literal44_tree);
                    }
                    pushFollow(FOLLOW_type_in_pointcutAtom2443);
                    fieldreadtype=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, fieldreadtype.getTree());
                    pushFollow(FOLLOW_fieldReference_in_pointcutAtom2447);
                    fieldref=fieldReference();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, fieldref.getTree());
                    char_literal45=(Token)match(input,73,FOLLOW_73_in_pointcutAtom2449); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal45_tree = (Object)adaptor.create(char_literal45);
                    adaptor.addChild(root_0, char_literal45_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new FieldReadPointcutExpression(fieldreadtype.element, fieldref.element); setKeyword(retval.element, fieldRead); 
                    }

                    }
                    break;
                case 6 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:693:4: handler= 'typeHandler' '(' exceptionType= type ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    handler=(Token)match(input,134,FOLLOW_134_in_pointcutAtom2458); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    handler_tree = (Object)adaptor.create(handler);
                    adaptor.addChild(root_0, handler_tree);
                    }
                    char_literal46=(Token)match(input,72,FOLLOW_72_in_pointcutAtom2460); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal46_tree = (Object)adaptor.create(char_literal46);
                    adaptor.addChild(root_0, char_literal46_tree);
                    }
                    pushFollow(FOLLOW_type_in_pointcutAtom2464);
                    exceptionType=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, exceptionType.getTree());
                    char_literal47=(Token)match(input,73,FOLLOW_73_in_pointcutAtom2466); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal47_tree = (Object)adaptor.create(char_literal47);
                    adaptor.addChild(root_0, char_literal47_tree);
                    }
                    if ( state.backtracking==0 ) {
                      TypeCatchClausePointcutExpression catchHandler = new TypeCatchClausePointcutExpression(); catchHandler.setExceptionType(exceptionType.element); retval.element = catchHandler; setKeyword(retval.element, handler); 
                    }

                    }
                    break;
                case 7 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:694:4: cast= 'cast' '(' castType= type ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    cast=(Token)match(input,135,FOLLOW_135_in_pointcutAtom2475); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    cast_tree = (Object)adaptor.create(cast);
                    adaptor.addChild(root_0, cast_tree);
                    }
                    char_literal48=(Token)match(input,72,FOLLOW_72_in_pointcutAtom2477); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal48_tree = (Object)adaptor.create(char_literal48);
                    adaptor.addChild(root_0, char_literal48_tree);
                    }
                    pushFollow(FOLLOW_type_in_pointcutAtom2481);
                    castType=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, castType.getTree());
                    char_literal49=(Token)match(input,73,FOLLOW_73_in_pointcutAtom2483); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal49_tree = (Object)adaptor.create(char_literal49);
                    adaptor.addChild(root_0, char_literal49_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.element = new CastPointcutExpression(castType.element); setKeyword(retval.element, cast); 
                    }

                    }
                    break;
                case 8 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:695:4: namedRef= namedPointcutReference
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_namedPointcutReference_in_pointcutAtom2492);
                    namedRef=namedPointcutReference();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, namedRef.getTree());
                    if ( state.backtracking==0 ) {
                      NamedPointcutExpression named = new NamedPointcutExpression(); named.setPointcutReference(namedRef.element); retval.element = named;
                    }

                    }
                    break;
                case 9 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:696:4: withinCl= within
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_within_in_pointcutAtom2501);
                    withinCl=within();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, withinCl.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = withinCl.element;
                    }

                    }
                    break;
                case 10 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:698:4: getargs= 'arguments' t= typesOrParameters
                    {
                    root_0 = (Object)adaptor.nil();

                    getargs=(Token)match(input,136,FOLLOW_136_in_pointcutAtom2512); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    getargs_tree = (Object)adaptor.create(getargs);
                    adaptor.addChild(root_0, getargs_tree);
                    }
                    pushFollow(FOLLOW_typesOrParameters_in_pointcutAtom2516);
                    t=typesOrParameters();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
                    if ( state.backtracking==0 ) {
                      ArgsPointcutExpression expr = new ArgsPointcutExpression(); expr.addAll(t.element); retval.element = expr; setKeyword(retval.element, getargs); 
                    }

                    }
                    break;
                case 11 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:699:4: thisType= 'thisType' '(' exp= expression ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    thisType=(Token)match(input,137,FOLLOW_137_in_pointcutAtom2525); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    thisType_tree = (Object)adaptor.create(thisType);
                    adaptor.addChild(root_0, thisType_tree);
                    }
                    char_literal50=(Token)match(input,72,FOLLOW_72_in_pointcutAtom2527); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal50_tree = (Object)adaptor.create(char_literal50);
                    adaptor.addChild(root_0, char_literal50_tree);
                    }
                    pushFollow(FOLLOW_expression_in_pointcutAtom2531);
                    exp=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, exp.getTree());
                    char_literal51=(Token)match(input,73,FOLLOW_73_in_pointcutAtom2533); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal51_tree = (Object)adaptor.create(char_literal51);
                    adaptor.addChild(root_0, char_literal51_tree);
                    }
                    if ( state.backtracking==0 ) {
                      ThisTypePointcutExpression expr = new ThisTypePointcutExpression((NamedTargetExpression) exp.element); retval.element = expr; setKeyword(retval.element, thisType); 
                    }

                    }
                    break;
                case 12 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:700:4: targetType= 'targetType' '(' exp= expression ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    targetType=(Token)match(input,138,FOLLOW_138_in_pointcutAtom2542); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    targetType_tree = (Object)adaptor.create(targetType);
                    adaptor.addChild(root_0, targetType_tree);
                    }
                    char_literal52=(Token)match(input,72,FOLLOW_72_in_pointcutAtom2544); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal52_tree = (Object)adaptor.create(char_literal52);
                    adaptor.addChild(root_0, char_literal52_tree);
                    }
                    pushFollow(FOLLOW_expression_in_pointcutAtom2548);
                    exp=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, exp.getTree());
                    char_literal53=(Token)match(input,73,FOLLOW_73_in_pointcutAtom2550); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal53_tree = (Object)adaptor.create(char_literal53);
                    adaptor.addChild(root_0, char_literal53_tree);
                    }
                    if ( state.backtracking==0 ) {
                      TargetTypePointcutExpression expr = new TargetTypePointcutExpression((NamedTargetExpression) exp.element); retval.element = expr; setKeyword(retval.element, targetType); 
                    }

                    }
                    break;
                case 13 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:701:4: ifCheck= 'if' '(' exp= expression ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    ifCheck=(Token)match(input,82,FOLLOW_82_in_pointcutAtom2559); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ifCheck_tree = (Object)adaptor.create(ifCheck);
                    adaptor.addChild(root_0, ifCheck_tree);
                    }
                    char_literal54=(Token)match(input,72,FOLLOW_72_in_pointcutAtom2561); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal54_tree = (Object)adaptor.create(char_literal54);
                    adaptor.addChild(root_0, char_literal54_tree);
                    }
                    pushFollow(FOLLOW_expression_in_pointcutAtom2565);
                    exp=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, exp.getTree());
                    char_literal55=(Token)match(input,73,FOLLOW_73_in_pointcutAtom2567); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal55_tree = (Object)adaptor.create(char_literal55);
                    adaptor.addChild(root_0, char_literal55_tree);
                    }
                    if ( state.backtracking==0 ) {
                      IfPointcutExpression expr = new IfPointcutExpression(exp.element); retval.element = expr; setKeyword(retval.element, ifCheck);
                    }

                    }
                    break;
                case 14 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:702:4: '!' expr1= pointcutAtom
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal56=(Token)match(input,118,FOLLOW_118_in_pointcutAtom2574); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal56_tree = (Object)adaptor.create(char_literal56);
                    adaptor.addChild(root_0, char_literal56_tree);
                    }
                    pushFollow(FOLLOW_pointcutAtom_in_pointcutAtom2578);
                    expr1=pointcutAtom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr1.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = new PointcutExpressionNot(expr1.element);
                    }

                    }
                    break;
                case 15 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:703:4: '(' expr2= pointcutExpression ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal57=(Token)match(input,72,FOLLOW_72_in_pointcutAtom2585); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal57_tree = (Object)adaptor.create(char_literal57);
                    adaptor.addChild(root_0, char_literal57_tree);
                    }
                    pushFollow(FOLLOW_pointcutExpression_in_pointcutAtom2589);
                    expr2=pointcutExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr2.getTree());
                    char_literal58=(Token)match(input,73,FOLLOW_73_in_pointcutAtom2591); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal58_tree = (Object)adaptor.create(char_literal58);
                    adaptor.addChild(root_0, char_literal58_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 443, pointcutAtom_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "pointcutAtom"

    public static class typesOrParameters_return extends ParserRuleReturnScope {
        public List<NamedTargetExpression> element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typesOrParameters"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:706:1: typesOrParameters returns [List<NamedTargetExpression> element] : '(' (pars= typesOrParameterDecls )? ')' ;
    public final AspectJLoParser.typesOrParameters_return typesOrParameters() throws RecognitionException {
        AspectJLoParser.typesOrParameters_return retval = new AspectJLoParser.typesOrParameters_return();
        retval.start = input.LT(1);
        int typesOrParameters_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal59=null;
        Token char_literal60=null;
        AspectJLoParser.typesOrParameterDecls_return pars = null;


        Object char_literal59_tree=null;
        Object char_literal60_tree=null;

        retval.element = new ArrayList<NamedTargetExpression>();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 444) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:708:5: ( '(' (pars= typesOrParameterDecls )? ')' )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:708:9: '(' (pars= typesOrParameterDecls )? ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal59=(Token)match(input,72,FOLLOW_72_in_typesOrParameters2617); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal59_tree = (Object)adaptor.create(char_literal59);
            adaptor.addChild(root_0, char_literal59_tree);
            }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:708:13: (pars= typesOrParameterDecls )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==Identifier||(LA41_0>=FloatingPointLiteral && LA41_0<=DecimalLiteral)||(LA41_0>=Export && LA41_0<=Overrides)||LA41_0==53||(LA41_0>=62 && LA41_0<=69)||(LA41_0>=71 && LA41_0<=72)||(LA41_0>=75 && LA41_0<=78)||(LA41_0>=111 && LA41_0<=112)||(LA41_0>=115 && LA41_0<=120)||(LA41_0>=122 && LA41_0<=125)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:708:14: pars= typesOrParameterDecls
                    {
                    pushFollow(FOLLOW_typesOrParameterDecls_in_typesOrParameters2622);
                    pars=typesOrParameterDecls();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pars.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element=pars.element;
                    }

                    }
                    break;

            }

            char_literal60=(Token)match(input,73,FOLLOW_73_in_typesOrParameters2628); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal60_tree = (Object)adaptor.create(char_literal60);
            adaptor.addChild(root_0, char_literal60_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 444, typesOrParameters_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "typesOrParameters"

    public static class typesOrParameterDecls_return extends ParserRuleReturnScope {
        public List<NamedTargetExpression> element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typesOrParameterDecls"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:711:1: typesOrParameterDecls returns [List<NamedTargetExpression> element] : exp= expression ( ',' decls= typesOrParameterDecls )? ;
    public final AspectJLoParser.typesOrParameterDecls_return typesOrParameterDecls() throws RecognitionException {
        AspectJLoParser.typesOrParameterDecls_return retval = new AspectJLoParser.typesOrParameterDecls_return();
        retval.start = input.LT(1);
        int typesOrParameterDecls_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal61=null;
        AspectJLoParser.expression_return exp = null;

        AspectJLoParser.typesOrParameterDecls_return decls = null;


        Object char_literal61_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 445) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:712:5: (exp= expression ( ',' decls= typesOrParameterDecls )? )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:712:7: exp= expression ( ',' decls= typesOrParameterDecls )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_expression_in_typesOrParameterDecls2651);
            exp=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exp.getTree());
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:712:22: ( ',' decls= typesOrParameterDecls )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==47) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:712:23: ',' decls= typesOrParameterDecls
                    {
                    char_literal61=(Token)match(input,47,FOLLOW_47_in_typesOrParameterDecls2654); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal61_tree = (Object)adaptor.create(char_literal61);
                    adaptor.addChild(root_0, char_literal61_tree);
                    }
                    pushFollow(FOLLOW_typesOrParameterDecls_in_typesOrParameterDecls2658);
                    decls=typesOrParameterDecls();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, decls.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element=decls.element; 
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              if(retval.element == null) {
              	 	retval.element=new ArrayList<NamedTargetExpression>();
                       } 
                       retval.element.add(0, (NamedTargetExpression) exp.element);
                       
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
            if ( state.backtracking>0 ) { memoize(input, 445, typesOrParameterDecls_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "typesOrParameterDecls"

    public static class subtypeMarker_return extends ParserRuleReturnScope {
        public SubtypeMarker element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subtypeMarker"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:720:1: subtypeMarker returns [SubtypeMarker element] : '+' ;
    public final AspectJLoParser.subtypeMarker_return subtypeMarker() throws RecognitionException {
        AspectJLoParser.subtypeMarker_return retval = new AspectJLoParser.subtypeMarker_return();
        retval.start = input.LT(1);
        int subtypeMarker_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal62=null;

        Object char_literal62_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 446) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:721:2: ( '+' )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:721:4: '+'
            {
            root_0 = (Object)adaptor.nil();

            char_literal62=(Token)match(input,111,FOLLOW_111_in_subtypeMarker2688); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal62_tree = (Object)adaptor.create(char_literal62);
            adaptor.addChild(root_0, char_literal62_tree);
            }
            if ( state.backtracking==0 ) {
              retval.element = new SubtypeMarker();
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
            if ( state.backtracking>0 ) { memoize(input, 446, subtypeMarker_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "subtypeMarker"

    public static class withinType_return extends ParserRuleReturnScope {
        public WithinTypePointcutExpression element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "withinType"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:723:1: withinType returns [WithinTypePointcutExpression element] : withinToken= 'within' '(' withinTypeRef= type (marker= subtypeMarker )? ')' ;
    public final AspectJLoParser.withinType_return withinType() throws RecognitionException {
        AspectJLoParser.withinType_return retval = new AspectJLoParser.withinType_return();
        retval.start = input.LT(1);
        int withinType_StartIndex = input.index();
        Object root_0 = null;

        Token withinToken=null;
        Token char_literal63=null;
        Token char_literal64=null;
        AspectJLo_JavaP.type_return withinTypeRef = null;

        AspectJLoParser.subtypeMarker_return marker = null;


        Object withinToken_tree=null;
        Object char_literal63_tree=null;
        Object char_literal64_tree=null;

        WithinTypePointcutExpression within = new WithinTypePointcutExpression();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 447) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:725:2: (withinToken= 'within' '(' withinTypeRef= type (marker= subtypeMarker )? ')' )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:725:4: withinToken= 'within' '(' withinTypeRef= type (marker= subtypeMarker )? ')'
            {
            root_0 = (Object)adaptor.nil();

            withinToken=(Token)match(input,139,FOLLOW_139_in_withinType2710); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            withinToken_tree = (Object)adaptor.create(withinToken);
            adaptor.addChild(root_0, withinToken_tree);
            }
            char_literal63=(Token)match(input,72,FOLLOW_72_in_withinType2712); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal63_tree = (Object)adaptor.create(char_literal63);
            adaptor.addChild(root_0, char_literal63_tree);
            }
            pushFollow(FOLLOW_type_in_withinType2716);
            withinTypeRef=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, withinTypeRef.getTree());
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:725:48: (marker= subtypeMarker )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==111) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:725:49: marker= subtypeMarker
                    {
                    pushFollow(FOLLOW_subtypeMarker_in_withinType2721);
                    marker=subtypeMarker();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, marker.getTree());
                    if ( state.backtracking==0 ) {
                      within.setSubtypeMarker(marker.element);
                    }

                    }
                    break;

            }

            char_literal64=(Token)match(input,73,FOLLOW_73_in_withinType2727); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal64_tree = (Object)adaptor.create(char_literal64);
            adaptor.addChild(root_0, char_literal64_tree);
            }
            if ( state.backtracking==0 ) {
              retval.element = within; within.setTypeReference(withinTypeRef.element); setKeyword(retval.element, withinToken); 
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
            if ( state.backtracking>0 ) { memoize(input, 447, withinType_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "withinType"

    public static class withinMethod_return extends ParserRuleReturnScope {
        public WithinMethodPointcutExpression element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "withinMethod"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:727:1: withinMethod returns [WithinMethodPointcutExpression element] : withinToken= 'within' '(' metref= methodReference ')' ;
    public final AspectJLoParser.withinMethod_return withinMethod() throws RecognitionException {
        AspectJLoParser.withinMethod_return retval = new AspectJLoParser.withinMethod_return();
        retval.start = input.LT(1);
        int withinMethod_StartIndex = input.index();
        Object root_0 = null;

        Token withinToken=null;
        Token char_literal65=null;
        Token char_literal66=null;
        AspectJLoParser.methodReference_return metref = null;


        Object withinToken_tree=null;
        Object char_literal65_tree=null;
        Object char_literal66_tree=null;

        WithinMethodPointcutExpression within = new WithinMethodPointcutExpression();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 448) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:729:2: (withinToken= 'within' '(' metref= methodReference ')' )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:729:4: withinToken= 'within' '(' metref= methodReference ')'
            {
            root_0 = (Object)adaptor.nil();

            withinToken=(Token)match(input,139,FOLLOW_139_in_withinMethod2749); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            withinToken_tree = (Object)adaptor.create(withinToken);
            adaptor.addChild(root_0, withinToken_tree);
            }
            char_literal65=(Token)match(input,72,FOLLOW_72_in_withinMethod2751); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal65_tree = (Object)adaptor.create(char_literal65);
            adaptor.addChild(root_0, char_literal65_tree);
            }
            pushFollow(FOLLOW_methodReference_in_withinMethod2755);
            metref=methodReference();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, metref.getTree());
            char_literal66=(Token)match(input,73,FOLLOW_73_in_withinMethod2757); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal66_tree = (Object)adaptor.create(char_literal66);
            adaptor.addChild(root_0, char_literal66_tree);
            }
            if ( state.backtracking==0 ) {
              retval.element = within; within.setMethodReference(metref.element); setKeyword(retval.element, withinToken); 
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
            if ( state.backtracking>0 ) { memoize(input, 448, withinMethod_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "withinMethod"

    public static class within_return extends ParserRuleReturnScope {
        public WithinPointcutExpression element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "within"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:731:1: within returns [WithinPointcutExpression element] : (withinTypeCL= withinType | withinMethodCL= withinMethod );
    public final AspectJLoParser.within_return within() throws RecognitionException {
        AspectJLoParser.within_return retval = new AspectJLoParser.within_return();
        retval.start = input.LT(1);
        int within_StartIndex = input.index();
        Object root_0 = null;

        AspectJLoParser.withinType_return withinTypeCL = null;

        AspectJLoParser.withinMethod_return withinMethodCL = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 449) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:732:2: (withinTypeCL= withinType | withinMethodCL= withinMethod )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==139) ) {
                int LA44_1 = input.LA(2);

                if ( (synpred77_AspectJLo()) ) {
                    alt44=1;
                }
                else if ( (true) ) {
                    alt44=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:732:4: withinTypeCL= withinType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_withinType_in_within2774);
                    withinTypeCL=withinType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, withinTypeCL.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = withinTypeCL.element;
                    }

                    }
                    break;
                case 2 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:733:4: withinMethodCL= withinMethod
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_withinMethod_in_within2783);
                    withinMethodCL=withinMethod();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, withinMethodCL.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = withinMethodCL.element;
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
            if ( state.backtracking>0 ) { memoize(input, 449, within_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "within"

    public static class fieldReference_return extends ParserRuleReturnScope {
        public MemberReference element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fieldReference"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:736:1: fieldReference returns [MemberReference element] : (initName= identifierRule ( '.' appendName= identifierRule )* ) ;
    public final AspectJLoParser.fieldReference_return fieldReference() throws RecognitionException {
        AspectJLoParser.fieldReference_return retval = new AspectJLoParser.fieldReference_return();
        retval.start = input.LT(1);
        int fieldReference_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal67=null;
        AspectJLoParser.identifierRule_return initName = null;

        AspectJLoParser.identifierRule_return appendName = null;


        Object char_literal67_tree=null;

        String fullName = "";
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 450) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:738:2: ( (initName= identifierRule ( '.' appendName= identifierRule )* ) )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:738:4: (initName= identifierRule ( '.' appendName= identifierRule )* )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:738:4: (initName= identifierRule ( '.' appendName= identifierRule )* )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:738:5: initName= identifierRule ( '.' appendName= identifierRule )*
            {
            pushFollow(FOLLOW_identifierRule_in_fieldReference2807);
            initName=identifierRule();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, initName.getTree());
            if ( state.backtracking==0 ) {
              fullName = (initName!=null?input.toString(initName.start,initName.stop):null);
            }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:738:58: ( '.' appendName= identifierRule )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==35) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:738:59: '.' appendName= identifierRule
            	    {
            	    char_literal67=(Token)match(input,35,FOLLOW_35_in_fieldReference2812); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal67_tree = (Object)adaptor.create(char_literal67);
            	    adaptor.addChild(root_0, char_literal67_tree);
            	    }
            	    pushFollow(FOLLOW_identifierRule_in_fieldReference2816);
            	    appendName=identifierRule();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, appendName.getTree());
            	    if ( state.backtracking==0 ) {
            	      fullName += "." + (appendName!=null?input.toString(appendName.start,appendName.stop):null); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
              retval.element = new MemberReference(fullName);
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
            if ( state.backtracking>0 ) { memoize(input, 450, fieldReference_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "fieldReference"

    public static class namedPointcutReference_return extends ParserRuleReturnScope {
        public PointcutReference element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "namedPointcutReference"
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:741:1: namedPointcutReference returns [PointcutReference element] : decl= pointcutDecl '(' (params= argParams )? end= ')' ;
    public final AspectJLoParser.namedPointcutReference_return namedPointcutReference() throws RecognitionException {
        AspectJLoParser.namedPointcutReference_return retval = new AspectJLoParser.namedPointcutReference_return();
        retval.start = input.LT(1);
        int namedPointcutReference_StartIndex = input.index();
        Object root_0 = null;

        Token end=null;
        Token char_literal68=null;
        AspectJLoParser.pointcutDecl_return decl = null;

        AspectJLoParser.argParams_return params = null;


        Object end_tree=null;
        Object char_literal68_tree=null;

        List<NamedTargetExpression> arguments = new ArrayList<NamedTargetExpression>();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 451) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:743:2: (decl= pointcutDecl '(' (params= argParams )? end= ')' )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:743:4: decl= pointcutDecl '(' (params= argParams )? end= ')'
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_pointcutDecl_in_namedPointcutReference2845);
            decl=pointcutDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, decl.getTree());
            char_literal68=(Token)match(input,72,FOLLOW_72_in_namedPointcutReference2847); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal68_tree = (Object)adaptor.create(char_literal68);
            adaptor.addChild(root_0, char_literal68_tree);
            }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:743:26: (params= argParams )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==Identifier||(LA46_0>=Export && LA46_0<=Overrides)) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:743:27: params= argParams
                    {
                    pushFollow(FOLLOW_argParams_in_namedPointcutReference2852);
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

            end=(Token)match(input,73,FOLLOW_73_in_namedPointcutReference2860); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 451, namedPointcutReference_StartIndex); }
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
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:746:1: argParams returns [List<NamedTargetExpression> element] : name= identifierRule ( ',' otherparams= argParams )? ;
    public final AspectJLoParser.argParams_return argParams() throws RecognitionException {
        AspectJLoParser.argParams_return retval = new AspectJLoParser.argParams_return();
        retval.start = input.LT(1);
        int argParams_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal69=null;
        AspectJLoParser.identifierRule_return name = null;

        AspectJLoParser.argParams_return otherparams = null;


        Object char_literal69_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 452) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:747:2: (name= identifierRule ( ',' otherparams= argParams )? )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:747:4: name= identifierRule ( ',' otherparams= argParams )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_identifierRule_in_argParams2880);
            name=identifierRule();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, name.getTree());
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:747:24: ( ',' otherparams= argParams )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==47) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:747:25: ',' otherparams= argParams
                    {
                    char_literal69=(Token)match(input,47,FOLLOW_47_in_argParams2883); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal69_tree = (Object)adaptor.create(char_literal69);
                    adaptor.addChild(root_0, char_literal69_tree);
                    }
                    pushFollow(FOLLOW_argParams_in_argParams2887);
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
            if ( state.backtracking>0 ) { memoize(input, 452, argParams_StartIndex); }
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
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:755:1: advice returns [Advice element] : (t= type | 'void' )? advtype= adviceTypeModifier pars= formalParameters (advtypespec= adviceTypeModifierSpecifier )? ':' pointcutExpr= pointcutExpression bdy= adviceBody ;
    public final AspectJLoParser.advice_return advice() throws RecognitionException {
        AspectJLoParser.advice_return retval = new AspectJLoParser.advice_return();
        retval.start = input.LT(1);
        int advice_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal70=null;
        Token char_literal71=null;
        AspectJLo_JavaP.type_return t = null;

        AspectJLoParser.adviceTypeModifier_return advtype = null;

        AspectJLo_JavaP.formalParameters_return pars = null;

        AspectJLoParser.adviceTypeModifierSpecifier_return advtypespec = null;

        AspectJLoParser.pointcutExpression_return pointcutExpr = null;

        AspectJLoParser.adviceBody_return bdy = null;


        Object string_literal70_tree=null;
        Object char_literal71_tree=null;

        TypeReference tref = null; List<NamedTargetExpression> arguments = new ArrayList<NamedTargetExpression>(); Modifier adviceTypeSpecifier = null;
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 453) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:758:2: ( (t= type | 'void' )? advtype= adviceTypeModifier pars= formalParameters (advtypespec= adviceTypeModifierSpecifier )? ':' pointcutExpr= pointcutExpression bdy= adviceBody )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:758:4: (t= type | 'void' )? advtype= adviceTypeModifier pars= formalParameters (advtypespec= adviceTypeModifierSpecifier )? ':' pointcutExpr= pointcutExpression bdy= adviceBody
            {
            root_0 = (Object)adaptor.nil();

            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:758:4: (t= type | 'void' )?
            int alt48=3;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==Identifier||(LA48_0>=Export && LA48_0<=Overrides)||(LA48_0>=62 && LA48_0<=69)) ) {
                alt48=1;
            }
            else if ( (LA48_0==53) ) {
                alt48=2;
            }
            switch (alt48) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:758:5: t= type
                    {
                    pushFollow(FOLLOW_type_in_advice2921);
                    t=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
                    if ( state.backtracking==0 ) {
                      tref=t.element;
                    }

                    }
                    break;
                case 2 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:758:31: 'void'
                    {
                    string_literal70=(Token)match(input,53,FOLLOW_53_in_advice2926); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal70_tree = (Object)adaptor.create(string_literal70);
                    adaptor.addChild(root_0, string_literal70_tree);
                    }
                    if ( state.backtracking==0 ) {
                      tref = typeRef("void");
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_adviceTypeModifier_in_advice2934);
            advtype=adviceTypeModifier();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, advtype.getTree());
            pushFollow(FOLLOW_formalParameters_in_advice2938);
            pars=formalParameters();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pars.getTree());
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:758:115: (advtypespec= adviceTypeModifierSpecifier )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( ((LA49_0>=143 && LA49_0<=144)) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:758:116: advtypespec= adviceTypeModifierSpecifier
                    {
                    pushFollow(FOLLOW_adviceTypeModifierSpecifier_in_advice2943);
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

            char_literal71=(Token)match(input,81,FOLLOW_81_in_advice2949); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal71_tree = (Object)adaptor.create(char_literal71);
            adaptor.addChild(root_0, char_literal71_tree);
            }
            pushFollow(FOLLOW_pointcutExpression_in_advice2953);
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
            pushFollow(FOLLOW_adviceBody_in_advice2964);
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
            if ( state.backtracking>0 ) { memoize(input, 453, advice_StartIndex); }
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
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:773:1: adviceBody returns [Block element] : b= adviceBlock ;
    public final AspectJLoParser.adviceBody_return adviceBody() throws RecognitionException {
        AspectJLoParser.adviceBody_return retval = new AspectJLoParser.adviceBody_return();
        retval.start = input.LT(1);
        int adviceBody_StartIndex = input.index();
        Object root_0 = null;

        AspectJLoParser.adviceBlock_return b = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 454) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:774:5: (b= adviceBlock )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:774:9: b= adviceBlock
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_adviceBlock_in_adviceBody2990);
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
            if ( state.backtracking>0 ) { memoize(input, 454, adviceBody_StartIndex); }
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
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:777:1: adviceBlock returns [Block element] : '{' (stat= adviceBlockStatement )* '}' ;
    public final AspectJLoParser.adviceBlock_return adviceBlock() throws RecognitionException {
        AspectJLoParser.adviceBlock_return retval = new AspectJLoParser.adviceBlock_return();
        retval.start = input.LT(1);
        int adviceBlock_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal72=null;
        Token char_literal73=null;
        AspectJLoParser.adviceBlockStatement_return stat = null;


        Object char_literal72_tree=null;
        Object char_literal73_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 455) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:778:5: ( '{' (stat= adviceBlockStatement )* '}' )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:778:9: '{' (stat= adviceBlockStatement )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal72=(Token)match(input,50,FOLLOW_50_in_adviceBlock3019); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal72_tree = (Object)adaptor.create(char_literal72);
            adaptor.addChild(root_0, char_literal72_tree);
            }
            if ( state.backtracking==0 ) {
              retval.element = new Block();
            }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:778:45: (stat= adviceBlockStatement )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( ((LA50_0>=Identifier && LA50_0<=ASSERT)||(LA50_0>=Export && LA50_0<=Overrides)||LA50_0==32||LA50_0==34||(LA50_0>=37 && LA50_0<=43)||LA50_0==50||(LA50_0>=52 && LA50_0<=53)||LA50_0==59||(LA50_0>=62 && LA50_0<=69)||(LA50_0>=71 && LA50_0<=72)||(LA50_0>=75 && LA50_0<=79)||LA50_0==82||(LA50_0>=84 && LA50_0<=87)||(LA50_0>=89 && LA50_0<=93)||(LA50_0>=111 && LA50_0<=112)||(LA50_0>=115 && LA50_0<=120)||(LA50_0>=122 && LA50_0<=125)) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:778:46: stat= adviceBlockStatement
            	    {
            	    pushFollow(FOLLOW_adviceBlockStatement_in_adviceBlock3026);
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
            	    break loop50;
                }
            } while (true);

            char_literal73=(Token)match(input,51,FOLLOW_51_in_adviceBlock3032); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal73_tree = (Object)adaptor.create(char_literal73);
            adaptor.addChild(root_0, char_literal73_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 455, adviceBlock_StartIndex); }
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
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:781:1: adviceBlockStatement returns [Statement element] : (local= localVariableDeclarationStatement | cd= classOrInterfaceDeclaration | specialReturn= adviceReturnStatement | stat= statement );
    public final AspectJLoParser.adviceBlockStatement_return adviceBlockStatement() throws RecognitionException {
        AspectJLoParser.adviceBlockStatement_return retval = new AspectJLoParser.adviceBlockStatement_return();
        retval.start = input.LT(1);
        int adviceBlockStatement_StartIndex = input.index();
        Object root_0 = null;

        AspectJLo_JavaP.localVariableDeclarationStatement_return local = null;

        AspectJLo_JavaP.classOrInterfaceDeclaration_return cd = null;

        AspectJLoParser.adviceReturnStatement_return specialReturn = null;

        AspectJLo_JavaP.statement_return stat = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 456) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:783:5: (local= localVariableDeclarationStatement | cd= classOrInterfaceDeclaration | specialReturn= adviceReturnStatement | stat= statement )
            int alt51=4;
            alt51 = dfa51.predict(input);
            switch (alt51) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:783:9: local= localVariableDeclarationStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_localVariableDeclarationStatement_in_adviceBlockStatement3065);
                    local=localVariableDeclarationStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, local.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = local.element;
                    }

                    }
                    break;
                case 2 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:784:9: cd= classOrInterfaceDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_classOrInterfaceDeclaration_in_adviceBlockStatement3079);
                    cd=classOrInterfaceDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cd.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = new LocalClassStatement(cd.element);
                    }

                    }
                    break;
                case 3 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:785:7: specialReturn= adviceReturnStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_adviceReturnStatement_in_adviceBlockStatement3091);
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
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:786:9: stat= statement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_statement_in_adviceBlockStatement3105);
                    stat=statement();

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
            if ( state.backtracking>0 ) { memoize(input, 456, adviceBlockStatement_StartIndex); }
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
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:789:1: adviceReturnStatement returns [Statement element] : retkey= 'return' (retex= expression )? ';' ;
    public final AspectJLoParser.adviceReturnStatement_return adviceReturnStatement() throws RecognitionException {
        AspectJLoParser.adviceReturnStatement_return retval = new AspectJLoParser.adviceReturnStatement_return();
        retval.start = input.LT(1);
        int adviceReturnStatement_StartIndex = input.index();
        Object root_0 = null;

        Token retkey=null;
        Token char_literal74=null;
        AspectJLoParser.expression_return retex = null;


        Object retkey_tree=null;
        Object char_literal74_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 457) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:791:5: (retkey= 'return' (retex= expression )? ';' )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:791:7: retkey= 'return' (retex= expression )? ';'
            {
            root_0 = (Object)adaptor.nil();

            retkey=(Token)match(input,90,FOLLOW_90_in_adviceReturnStatement3138); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            retkey_tree = (Object)adaptor.create(retkey);
            adaptor.addChild(root_0, retkey_tree);
            }
            if ( state.backtracking==0 ) {
              retval.element = new AdviceReturnStatement();
                     setKeyword(retval.element,retkey);
            }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:794:8: (retex= expression )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==Identifier||(LA52_0>=FloatingPointLiteral && LA52_0<=DecimalLiteral)||(LA52_0>=Export && LA52_0<=Overrides)||LA52_0==53||(LA52_0>=62 && LA52_0<=69)||(LA52_0>=71 && LA52_0<=72)||(LA52_0>=75 && LA52_0<=78)||(LA52_0>=111 && LA52_0<=112)||(LA52_0>=115 && LA52_0<=120)||(LA52_0>=122 && LA52_0<=125)) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:794:9: retex= expression
                    {
                    pushFollow(FOLLOW_expression_in_adviceReturnStatement3160);
                    retex=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, retex.getTree());
                    if ( state.backtracking==0 ) {
                      ((ReturnStatement)retval.element).setExpression(retex.element);
                            
                    }

                    }
                    break;

            }

            char_literal74=(Token)match(input,32,FOLLOW_32_in_adviceReturnStatement3166); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal74_tree = (Object)adaptor.create(char_literal74);
            adaptor.addChild(root_0, char_literal74_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 457, adviceReturnStatement_StartIndex); }
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
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:799:1: adviceTypeModifier returns [Modifier element] : (bf= 'before_' | af= 'after_' | ar= 'around_' );
    public final AspectJLoParser.adviceTypeModifier_return adviceTypeModifier() throws RecognitionException {
        AspectJLoParser.adviceTypeModifier_return retval = new AspectJLoParser.adviceTypeModifier_return();
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 458) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:800:2: (bf= 'before_' | af= 'after_' | ar= 'around_' )
            int alt53=3;
            switch ( input.LA(1) ) {
            case 140:
                {
                alt53=1;
                }
                break;
            case 141:
                {
                alt53=2;
                }
                break;
            case 142:
                {
                alt53=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:800:4: bf= 'before_'
                    {
                    root_0 = (Object)adaptor.nil();

                    bf=(Token)match(input,140,FOLLOW_140_in_adviceTypeModifier3191); if (state.failed) return retval;
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
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:801:4: af= 'after_'
                    {
                    root_0 = (Object)adaptor.nil();

                    af=(Token)match(input,141,FOLLOW_141_in_adviceTypeModifier3200); if (state.failed) return retval;
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
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:802:4: ar= 'around_'
                    {
                    root_0 = (Object)adaptor.nil();

                    ar=(Token)match(input,142,FOLLOW_142_in_adviceTypeModifier3209); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 458, adviceTypeModifier_StartIndex); }
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
    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:805:1: adviceTypeModifierSpecifier returns [Modifier element] : (rt= 'returning' ( '(' (retparam= formalParameter )? ')' )? | tw= 'throwing' ( '(' (throwabletype= formalParameter )? ')' )? );
    public final AspectJLoParser.adviceTypeModifierSpecifier_return adviceTypeModifierSpecifier() throws RecognitionException {
        AspectJLoParser.adviceTypeModifierSpecifier_return retval = new AspectJLoParser.adviceTypeModifierSpecifier_return();
        retval.start = input.LT(1);
        int adviceTypeModifierSpecifier_StartIndex = input.index();
        Object root_0 = null;

        Token rt=null;
        Token tw=null;
        Token char_literal75=null;
        Token char_literal76=null;
        Token char_literal77=null;
        Token char_literal78=null;
        AspectJLo_JavaP.formalParameter_return retparam = null;

        AspectJLo_JavaP.formalParameter_return throwabletype = null;


        Object rt_tree=null;
        Object tw_tree=null;
        Object char_literal75_tree=null;
        Object char_literal76_tree=null;
        Object char_literal77_tree=null;
        Object char_literal78_tree=null;

        FormalParameter fp = null; FormalParameter exceptionParam = null;
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 459) ) { return retval; }
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:807:2: (rt= 'returning' ( '(' (retparam= formalParameter )? ')' )? | tw= 'throwing' ( '(' (throwabletype= formalParameter )? ')' )? )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==143) ) {
                alt58=1;
            }
            else if ( (LA58_0==144) ) {
                alt58=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:807:4: rt= 'returning' ( '(' (retparam= formalParameter )? ')' )?
                    {
                    root_0 = (Object)adaptor.nil();

                    rt=(Token)match(input,143,FOLLOW_143_in_adviceTypeModifierSpecifier3233); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    rt_tree = (Object)adaptor.create(rt);
                    adaptor.addChild(root_0, rt_tree);
                    }
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:807:19: ( '(' (retparam= formalParameter )? ')' )?
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==72) ) {
                        alt55=1;
                    }
                    switch (alt55) {
                        case 1 :
                            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:807:20: '(' (retparam= formalParameter )? ')'
                            {
                            char_literal75=(Token)match(input,72,FOLLOW_72_in_adviceTypeModifierSpecifier3236); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal75_tree = (Object)adaptor.create(char_literal75);
                            adaptor.addChild(root_0, char_literal75_tree);
                            }
                            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:807:24: (retparam= formalParameter )?
                            int alt54=2;
                            int LA54_0 = input.LA(1);

                            if ( (LA54_0==Identifier||(LA54_0>=Export && LA54_0<=Overrides)||LA54_0==41||(LA54_0>=62 && LA54_0<=69)||LA54_0==79) ) {
                                alt54=1;
                            }
                            switch (alt54) {
                                case 1 :
                                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:807:25: retparam= formalParameter
                                    {
                                    pushFollow(FOLLOW_formalParameter_in_adviceTypeModifierSpecifier3241);
                                    retparam=formalParameter();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) adaptor.addChild(root_0, retparam.getTree());
                                    if ( state.backtracking==0 ) {
                                      fp = retparam.element;
                                    }

                                    }
                                    break;

                            }

                            char_literal76=(Token)match(input,73,FOLLOW_73_in_adviceTypeModifierSpecifier3247); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal76_tree = (Object)adaptor.create(char_literal76);
                            adaptor.addChild(root_0, char_literal76_tree);
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
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:808:4: tw= 'throwing' ( '(' (throwabletype= formalParameter )? ')' )?
                    {
                    root_0 = (Object)adaptor.nil();

                    tw=(Token)match(input,144,FOLLOW_144_in_adviceTypeModifierSpecifier3258); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    tw_tree = (Object)adaptor.create(tw);
                    adaptor.addChild(root_0, tw_tree);
                    }
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:808:18: ( '(' (throwabletype= formalParameter )? ')' )?
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( (LA57_0==72) ) {
                        alt57=1;
                    }
                    switch (alt57) {
                        case 1 :
                            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:808:19: '(' (throwabletype= formalParameter )? ')'
                            {
                            char_literal77=(Token)match(input,72,FOLLOW_72_in_adviceTypeModifierSpecifier3261); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal77_tree = (Object)adaptor.create(char_literal77);
                            adaptor.addChild(root_0, char_literal77_tree);
                            }
                            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:808:23: (throwabletype= formalParameter )?
                            int alt56=2;
                            int LA56_0 = input.LA(1);

                            if ( (LA56_0==Identifier||(LA56_0>=Export && LA56_0<=Overrides)||LA56_0==41||(LA56_0>=62 && LA56_0<=69)||LA56_0==79) ) {
                                alt56=1;
                            }
                            switch (alt56) {
                                case 1 :
                                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:808:24: throwabletype= formalParameter
                                    {
                                    pushFollow(FOLLOW_formalParameter_in_adviceTypeModifierSpecifier3266);
                                    throwabletype=formalParameter();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) adaptor.addChild(root_0, throwabletype.getTree());
                                    if ( state.backtracking==0 ) {
                                      exceptionParam = throwabletype.element;
                                    }

                                    }
                                    break;

                            }

                            char_literal78=(Token)match(input,73,FOLLOW_73_in_adviceTypeModifierSpecifier3272); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal78_tree = (Object)adaptor.create(char_literal78);
                            adaptor.addChild(root_0, char_literal78_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 459, adviceTypeModifierSpecifier_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "adviceTypeModifierSpecifier"

    // $ANTLR start synpred7_AspectJLo
    public final void synpred7_AspectJLo_fragment() throws RecognitionException {   
        AspectJLo_JavaP.memberDeclaration_return mem = null;


        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:336:9: (mem= memberDeclaration )
        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:336:9: mem= memberDeclaration
        {
        pushFollow(FOLLOW_memberDeclaration_in_synpred7_AspectJLo202);
        mem=memberDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_AspectJLo

    // $ANTLR start synpred9_AspectJLo
    public final void synpred9_AspectJLo_fragment() throws RecognitionException {   
        AspectJLo_JavaP.constructorDeclaration_return cs = null;


        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:338:9: (cs= constructorDeclaration )
        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:338:9: cs= constructorDeclaration
        {
        pushFollow(FOLLOW_constructorDeclaration_in_synpred9_AspectJLo230);
        cs=constructorDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_AspectJLo

    // $ANTLR start synpred13_AspectJLo
    public final void synpred13_AspectJLo_fragment() throws RecognitionException {   
        AspectJLoParser.exportDeclaration_return exp = null;


        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:342:9: (exp= exportDeclaration )
        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:342:9: exp= exportDeclaration
        {
        pushFollow(FOLLOW_exportDeclaration_in_synpred13_AspectJLo286);
        exp=exportDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_AspectJLo

    // $ANTLR start synpred14_AspectJLo
    public final void synpred14_AspectJLo_fragment() throws RecognitionException {   
        AspectJLoParser.nameParameter_return np = null;


        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:343:9: (np= nameParameter )
        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:343:9: np= nameParameter
        {
        pushFollow(FOLLOW_nameParameter_in_synpred14_AspectJLo300);
        np=nameParameter();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_AspectJLo

    // $ANTLR start synpred15_AspectJLo
    public final void synpred15_AspectJLo_fragment() throws RecognitionException {   
        AspectJLoParser.connector_return con = null;


        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:344:9: (con= connector )
        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:344:9: con= connector
        {
        pushFollow(FOLLOW_connector_in_synpred15_AspectJLo314);
        con=connector();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_AspectJLo

    // $ANTLR start synpred23_AspectJLo
    public final void synpred23_AspectJLo_fragment() throws RecognitionException {   
        Token ov=null;
        AspectJLoParser.signature_return sig = null;

        AspectJLoParser.fqn_return f = null;


        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:398:4: (sig= signature ov= '>' f= fqn )
        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:398:4: sig= signature ov= '>' f= fqn
        {
        pushFollow(FOLLOW_signature_in_synpred23_AspectJLo739);
        sig=signature();

        state._fsp--;
        if (state.failed) return ;
        ov=(Token)match(input,48,FOLLOW_48_in_synpred23_AspectJLo743); if (state.failed) return ;
        pushFollow(FOLLOW_fqn_in_synpred23_AspectJLo747);
        f=fqn();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred23_AspectJLo

    // $ANTLR start synpred28_AspectJLo
    public final void synpred28_AspectJLo_fragment() throws RecognitionException {   
        AspectJLo_JavaP.assignmentOperator_return op = null;

        AspectJLoParser.expression_return exx = null;


        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:432:64: (op= assignmentOperator exx= expression )
        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:432:64: op= assignmentOperator exx= expression
        {
        pushFollow(FOLLOW_assignmentOperator_in_synpred28_AspectJLo994);
        op=assignmentOperator();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred28_AspectJLo998);
        exx=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred28_AspectJLo

    // $ANTLR start synpred34_AspectJLo
    public final void synpred34_AspectJLo_fragment() throws RecognitionException {   
        AspectJLoParser.singleSubobjectParameter_return single = null;


        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:502:4: (single= singleSubobjectParameter )
        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:502:4: single= singleSubobjectParameter
        {
        pushFollow(FOLLOW_singleSubobjectParameter_in_synpred34_AspectJLo1243);
        single=singleSubobjectParameter();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred34_AspectJLo

    // $ANTLR start synpred43_AspectJLo
    public final void synpred43_AspectJLo_fragment() throws RecognitionException {   
        AspectJLo_JavaP.packageDeclaration_return np = null;

        AspectJLo_JavaP.importDeclaration_return imp = null;

        AspectJLo_JavaP.typeDeclaration_return typech = null;

        AspectJLo_JavaP.classOrInterfaceDeclaration_return cd = null;


        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:556:10: ( annotations (np= packageDeclaration (imp= importDeclaration )* (typech= typeDeclaration )* | cd= classOrInterfaceDeclaration (typech= typeDeclaration )* ) )
        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:556:10: annotations (np= packageDeclaration (imp= importDeclaration )* (typech= typeDeclaration )* | cd= classOrInterfaceDeclaration (typech= typeDeclaration )* )
        {
        pushFollow(FOLLOW_annotations_in_synpred43_AspectJLo1498);
        annotations();

        state._fsp--;
        if (state.failed) return ;
        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:557:9: (np= packageDeclaration (imp= importDeclaration )* (typech= typeDeclaration )* | cd= classOrInterfaceDeclaration (typech= typeDeclaration )* )
        int alt68=2;
        int LA68_0 = input.LA(1);

        if ( (LA68_0==31) ) {
            alt68=1;
        }
        else if ( (LA68_0==ENUM||LA68_0==34||(LA68_0>=37 && LA68_0<=43)||LA68_0==52||LA68_0==79) ) {
            alt68=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 68, 0, input);

            throw nvae;
        }
        switch (alt68) {
            case 1 :
                // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:557:13: np= packageDeclaration (imp= importDeclaration )* (typech= typeDeclaration )*
                {
                pushFollow(FOLLOW_packageDeclaration_in_synpred43_AspectJLo1514);
                np=packageDeclaration();

                state._fsp--;
                if (state.failed) return ;
                // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:562:13: (imp= importDeclaration )*
                loop65:
                do {
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==33) ) {
                        alt65=1;
                    }


                    switch (alt65) {
                	case 1 :
                	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:562:14: imp= importDeclaration
                	    {
                	    pushFollow(FOLLOW_importDeclaration_in_synpred43_AspectJLo1550);
                	    imp=importDeclaration();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }
                	    break;

                	default :
                	    break loop65;
                    }
                } while (true);

                // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:563:13: (typech= typeDeclaration )*
                loop66:
                do {
                    int alt66=2;
                    int LA66_0 = input.LA(1);

                    if ( (LA66_0==ENUM||LA66_0==32||LA66_0==34||(LA66_0>=37 && LA66_0<=43)||LA66_0==52||LA66_0==79) ) {
                        alt66=1;
                    }


                    switch (alt66) {
                	case 1 :
                	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:563:14: typech= typeDeclaration
                	    {
                	    pushFollow(FOLLOW_typeDeclaration_in_synpred43_AspectJLo1571);
                	    typech=typeDeclaration();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }
                	    break;

                	default :
                	    break loop66;
                    }
                } while (true);


                }
                break;
            case 2 :
                // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:567:13: cd= classOrInterfaceDeclaration (typech= typeDeclaration )*
                {
                pushFollow(FOLLOW_classOrInterfaceDeclaration_in_synpred43_AspectJLo1620);
                cd=classOrInterfaceDeclaration();

                state._fsp--;
                if (state.failed) return ;
                // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:573:13: (typech= typeDeclaration )*
                loop67:
                do {
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==ENUM||LA67_0==32||LA67_0==34||(LA67_0>=37 && LA67_0<=43)||LA67_0==52||LA67_0==79) ) {
                        alt67=1;
                    }


                    switch (alt67) {
                	case 1 :
                	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:573:14: typech= typeDeclaration
                	    {
                	    pushFollow(FOLLOW_typeDeclaration_in_synpred43_AspectJLo1655);
                	    typech=typeDeclaration();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }
                	    break;

                	default :
                	    break loop67;
                    }
                } while (true);


                }
                break;

        }


        }
    }
    // $ANTLR end synpred43_AspectJLo

    // $ANTLR start synpred50_AspectJLo
    public final void synpred50_AspectJLo_fragment() throws RecognitionException {   
        AspectJLoParser.pointcutExpressionOr_return expr1 = null;

        AspectJLoParser.pointcutExpression_return expr2 = null;


        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:636:4: (expr1= pointcutExpressionOr '&&' expr2= pointcutExpression )
        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:636:4: expr1= pointcutExpressionOr '&&' expr2= pointcutExpression
        {
        pushFollow(FOLLOW_pointcutExpressionOr_in_synpred50_AspectJLo2005);
        expr1=pointcutExpressionOr();

        state._fsp--;
        if (state.failed) return ;
        match(input,105,FOLLOW_105_in_synpred50_AspectJLo2007); if (state.failed) return ;
        pushFollow(FOLLOW_pointcutExpression_in_synpred50_AspectJLo2011);
        expr2=pointcutExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred50_AspectJLo

    // $ANTLR start synpred52_AspectJLo
    public final void synpred52_AspectJLo_fragment() throws RecognitionException {   
        AspectJLoParser.pointcutAtom_return expr1 = null;

        AspectJLoParser.pointcutExpressionOr_return expr2 = null;


        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:647:4: (expr1= pointcutAtom '||' expr2= pointcutExpressionOr )
        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:647:4: expr1= pointcutAtom '||' expr2= pointcutExpressionOr
        {
        pushFollow(FOLLOW_pointcutAtom_in_synpred52_AspectJLo2081);
        expr1=pointcutAtom();

        state._fsp--;
        if (state.failed) return ;
        match(input,104,FOLLOW_104_in_synpred52_AspectJLo2083); if (state.failed) return ;
        pushFollow(FOLLOW_pointcutExpressionOr_in_synpred52_AspectJLo2087);
        expr2=pointcutExpressionOr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred52_AspectJLo

    // $ANTLR start synpred77_AspectJLo
    public final void synpred77_AspectJLo_fragment() throws RecognitionException {   
        AspectJLoParser.withinType_return withinTypeCL = null;


        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:732:4: (withinTypeCL= withinType )
        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:732:4: withinTypeCL= withinType
        {
        pushFollow(FOLLOW_withinType_in_synpred77_AspectJLo2774);
        withinTypeCL=withinType();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred77_AspectJLo

    // $ANTLR start synpred85_AspectJLo
    public final void synpred85_AspectJLo_fragment() throws RecognitionException {   
        AspectJLo_JavaP.localVariableDeclarationStatement_return local = null;


        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:783:9: (local= localVariableDeclarationStatement )
        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:783:9: local= localVariableDeclarationStatement
        {
        pushFollow(FOLLOW_localVariableDeclarationStatement_in_synpred85_AspectJLo3065);
        local=localVariableDeclarationStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred85_AspectJLo

    // $ANTLR start synpred86_AspectJLo
    public final void synpred86_AspectJLo_fragment() throws RecognitionException {   
        AspectJLo_JavaP.classOrInterfaceDeclaration_return cd = null;


        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:784:9: (cd= classOrInterfaceDeclaration )
        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:784:9: cd= classOrInterfaceDeclaration
        {
        pushFollow(FOLLOW_classOrInterfaceDeclaration_in_synpred86_AspectJLo3079);
        cd=classOrInterfaceDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred86_AspectJLo

    // $ANTLR start synpred87_AspectJLo
    public final void synpred87_AspectJLo_fragment() throws RecognitionException {   
        AspectJLoParser.adviceReturnStatement_return specialReturn = null;


        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:785:7: (specialReturn= adviceReturnStatement )
        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\AspectJLo.g:785:7: specialReturn= adviceReturnStatement
        {
        pushFollow(FOLLOW_adviceReturnStatement_in_synpred87_AspectJLo3091);
        specialReturn=adviceReturnStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred87_AspectJLo

    // Delegated rules
    public AspectJLo_JavaP.modifiers_return modifiers() throws RecognitionException { return gJavaP.modifiers(); }
    public AspectJLo_JavaP.forUpdate_return forUpdate() throws RecognitionException { return gJavaP.forUpdate(); }
    public AspectJLo_JavaP.variableDeclarator_return variableDeclarator() throws RecognitionException { return gJavaP.variableDeclarator(); }
    public AspectJLo_JavaP.argumentsSuffixRubbish_return argumentsSuffixRubbish() throws RecognitionException { return gJavaP.argumentsSuffixRubbish(); }
    public AspectJLo_JavaP.classOrInterfaceDeclaration_return classOrInterfaceDeclaration() throws RecognitionException { return gJavaP.classOrInterfaceDeclaration(); }
    public AspectJLo_JavaP.constructorDeclaration_return constructorDeclaration() throws RecognitionException { return gJavaP.constructorDeclaration(); }
    public AspectJLo_JavaP.relationalExpression_return relationalExpression() throws RecognitionException { return gJavaP.relationalExpression(); }
    public AspectJLo_JavaP.packageDeclaration_return packageDeclaration() throws RecognitionException { return gJavaP.packageDeclaration(); }
    public AspectJLo_JavaP.enumBody_return enumBody() throws RecognitionException { return gJavaP.enumBody(); }
    public AspectJLo_JavaP.fieldDeclaration_return fieldDeclaration() throws RecognitionException { return gJavaP.fieldDeclaration(); }
    public AspectJLo_JavaP.conditionalExpression_return conditionalExpression() throws RecognitionException { return gJavaP.conditionalExpression(); }
    public AspectJLo_JavaP.qualifiedNameList_return qualifiedNameList() throws RecognitionException { return gJavaP.qualifiedNameList(); }
    public AspectJLo_JavaP.localVariableDeclaration_return localVariableDeclaration() throws RecognitionException { return gJavaP.localVariableDeclaration(); }
    public AspectJLo_JavaP.constructorBody_return constructorBody() throws RecognitionException { return gJavaP.constructorBody(); }
    public AspectJLo_JavaP.defaultValue_return defaultValue() throws RecognitionException { return gJavaP.defaultValue(); }
    public AspectJLo_JavaP.variableDeclaratorId_return variableDeclaratorId() throws RecognitionException { return gJavaP.variableDeclaratorId(); }
    public AspectJLo_JavaP.primitiveType_return primitiveType() throws RecognitionException { return gJavaP.primitiveType(); }
    public AspectJLo_JavaP.methodDeclaration_return methodDeclaration() throws RecognitionException { return gJavaP.methodDeclaration(); }
    public AspectJLo_JavaP.formalParameters_return formalParameters() throws RecognitionException { return gJavaP.formalParameters(); }
    public AspectJLo_JavaP.voidInterfaceMethodDeclaratorRest_return voidInterfaceMethodDeclaratorRest() throws RecognitionException { return gJavaP.voidInterfaceMethodDeclaratorRest(); }
    public AspectJLo_JavaP.interfaceMethodDeclaratorRest_return interfaceMethodDeclaratorRest() throws RecognitionException { return gJavaP.interfaceMethodDeclaratorRest(); }
    public AspectJLo_JavaP.constantExpression_return constantExpression() throws RecognitionException { return gJavaP.constantExpression(); }
    public AspectJLo_JavaP.qualifiedName_return qualifiedName() throws RecognitionException { return gJavaP.qualifiedName(); }
    public AspectJLo_JavaP.castExpression_return castExpression() throws RecognitionException { return gJavaP.castExpression(); }
    public AspectJLo_JavaP.elementValue_return elementValue() throws RecognitionException { return gJavaP.elementValue(); }
    public AspectJLo_JavaP.localVariableDeclarationStatement_return localVariableDeclarationStatement() throws RecognitionException { return gJavaP.localVariableDeclarationStatement(); }
    public AspectJLo_JavaP.interfaceMethod_return interfaceMethod() throws RecognitionException { return gJavaP.interfaceMethod(); }
    public AspectJLo_JavaP.innerCreator_return innerCreator() throws RecognitionException { return gJavaP.innerCreator(); }
    public AspectJLo_JavaP.modifier_return modifier() throws RecognitionException { return gJavaP.modifier(); }
    public AspectJLo_JavaP.forInit_return forInit() throws RecognitionException { return gJavaP.forInit(); }
    public AspectJLo_JavaP.nonWildcardTypeArguments_return nonWildcardTypeArguments() throws RecognitionException { return gJavaP.nonWildcardTypeArguments(); }
    public AspectJLo_JavaP.explicitConstructorInvocation_return explicitConstructorInvocation() throws RecognitionException { return gJavaP.explicitConstructorInvocation(); }
    public AspectJLo_JavaP.unaryExpression_return unaryExpression() throws RecognitionException { return gJavaP.unaryExpression(); }
    public AspectJLo_JavaP.andExpression_return andExpression() throws RecognitionException { return gJavaP.andExpression(); }
    public AspectJLo_JavaP.typeList_return typeList() throws RecognitionException { return gJavaP.typeList(); }
    public AspectJLo_JavaP.methodDeclaratorRest_return methodDeclaratorRest() throws RecognitionException { return gJavaP.methodDeclaratorRest(); }
    public AspectJLo_JavaP.explicitGenericInvocation_return explicitGenericInvocation() throws RecognitionException { return gJavaP.explicitGenericInvocation(); }
    public AspectJLo_JavaP.nameAndParams_return nameAndParams() throws RecognitionException { return gJavaP.nameAndParams(); }
    public AspectJLo_JavaP.constructorDeclaratorRest_return constructorDeclaratorRest() throws RecognitionException { return gJavaP.constructorDeclaratorRest(); }
    public AspectJLo_JavaP.booleanLiteral_return booleanLiteral() throws RecognitionException { return gJavaP.booleanLiteral(); }
    public AspectJLo_JavaP.enumConstantName_return enumConstantName() throws RecognitionException { return gJavaP.enumConstantName(); }
    public AspectJLo_JavaP.superSuffix_return superSuffix() throws RecognitionException { return gJavaP.superSuffix(); }
    public AspectJLo_JavaP.shiftOp_return shiftOp() throws RecognitionException { return gJavaP.shiftOp(); }
    public AspectJLo_JavaP.constantDeclarator_return constantDeclarator() throws RecognitionException { return gJavaP.constantDeclarator(); }
    public AspectJLo_JavaP.classOrInterfaceModifier_return classOrInterfaceModifier() throws RecognitionException { return gJavaP.classOrInterfaceModifier(); }
    public AspectJLo_JavaP.variableInitializer_return variableInitializer() throws RecognitionException { return gJavaP.variableInitializer(); }
    public AspectJLo_JavaP.annotationConstantRest_return annotationConstantRest(TypeReference type) throws RecognitionException { return gJavaP.annotationConstantRest(type); }
    public AspectJLo_JavaP.elementValuePair_return elementValuePair() throws RecognitionException { return gJavaP.elementValuePair(); }
    public AspectJLo_JavaP.classCreatorRest_return classCreatorRest() throws RecognitionException { return gJavaP.classCreatorRest(); }
    public AspectJLo_JavaP.block_return block() throws RecognitionException { return gJavaP.block(); }
    public AspectJLo_JavaP.arguments_return arguments() throws RecognitionException { return gJavaP.arguments(); }
    public AspectJLo_JavaP.statementExpression_return statementExpression() throws RecognitionException { return gJavaP.statementExpression(); }
    public AspectJLo_JavaP.instanceOfExpression_return instanceOfExpression() throws RecognitionException { return gJavaP.instanceOfExpression(); }
    public AspectJLo_JavaP.annotations_return annotations() throws RecognitionException { return gJavaP.annotations(); }
    public AspectJLo_JavaP.normalInterfaceDeclaration_return normalInterfaceDeclaration() throws RecognitionException { return gJavaP.normalInterfaceDeclaration(); }
    public AspectJLo_JavaP.shiftExpression_return shiftExpression() throws RecognitionException { return gJavaP.shiftExpression(); }
    public AspectJLo_JavaP.typeArgument_return typeArgument() throws RecognitionException { return gJavaP.typeArgument(); }
    public AspectJLo_JavaP.voidMethodDeclaratorRest_return voidMethodDeclaratorRest() throws RecognitionException { return gJavaP.voidMethodDeclaratorRest(); }
    public AspectJLo_JavaP.forControl_return forControl() throws RecognitionException { return gJavaP.forControl(); }
    public AspectJLo_JavaP.enumConstant_return enumConstant() throws RecognitionException { return gJavaP.enumConstant(); }
    public AspectJLo_JavaP.interfaceMethodOrFieldDecl_return interfaceMethodOrFieldDecl() throws RecognitionException { return gJavaP.interfaceMethodOrFieldDecl(); }
    public AspectJLo_JavaP.creator_return creator() throws RecognitionException { return gJavaP.creator(); }
    public AspectJLo_JavaP.genericMethodOrConstructorDecl_return genericMethodOrConstructorDecl() throws RecognitionException { return gJavaP.genericMethodOrConstructorDecl(); }
    public AspectJLo_JavaP.variableModifiers_return variableModifiers() throws RecognitionException { return gJavaP.variableModifiers(); }
    public AspectJLo_JavaP.formalParameterDecls_return formalParameterDecls() throws RecognitionException { return gJavaP.formalParameterDecls(); }
    public AspectJLo_JavaP.interfaceMemberDecl_return interfaceMemberDecl() throws RecognitionException { return gJavaP.interfaceMemberDecl(); }
    public AspectJLo_JavaP.switchBlockStatementGroups_return switchBlockStatementGroups() throws RecognitionException { return gJavaP.switchBlockStatementGroups(); }
    public AspectJLo_JavaP.literal_return literal() throws RecognitionException { return gJavaP.literal(); }
    public AspectJLo_JavaP.typeDeclaration_return typeDeclaration() throws RecognitionException { return gJavaP.typeDeclaration(); }
    public AspectJLo_JavaP.equalityExpression_return equalityExpression() throws RecognitionException { return gJavaP.equalityExpression(); }
    public AspectJLo_JavaP.voidInterfaceMethodDeclaration_return voidInterfaceMethodDeclaration() throws RecognitionException { return gJavaP.voidInterfaceMethodDeclaration(); }
    public AspectJLo_JavaP.classOrInterfaceModifiers_return classOrInterfaceModifiers() throws RecognitionException { return gJavaP.classOrInterfaceModifiers(); }
    public AspectJLo_JavaP.enumBodyDeclarations_return enumBodyDeclarations() throws RecognitionException { return gJavaP.enumBodyDeclarations(); }
    public AspectJLo_JavaP.annotationTypeBody_return annotationTypeBody() throws RecognitionException { return gJavaP.annotationTypeBody(); }
    public AspectJLo_JavaP.enhancedForControl_return enhancedForControl() throws RecognitionException { return gJavaP.enhancedForControl(); }
    public AspectJLo_JavaP.catchClause_return catchClause() throws RecognitionException { return gJavaP.catchClause(); }
    public AspectJLo_JavaP.enumConstants_return enumConstants() throws RecognitionException { return gJavaP.enumConstants(); }
    public AspectJLo_JavaP.identifierSuffixRubbush_return identifierSuffixRubbush() throws RecognitionException { return gJavaP.identifierSuffixRubbush(); }
    public AspectJLo_JavaP.voidType_return voidType() throws RecognitionException { return gJavaP.voidType(); }
    public AspectJLo_JavaP.typeParameter_return typeParameter() throws RecognitionException { return gJavaP.typeParameter(); }
    public AspectJLo_JavaP.expressionList_return expressionList() throws RecognitionException { return gJavaP.expressionList(); }
    public AspectJLo_JavaP.blockStatement_return blockStatement() throws RecognitionException { return gJavaP.blockStatement(); }
    public AspectJLo_JavaP.unaryExpressionNotPlusMinus_return unaryExpressionNotPlusMinus() throws RecognitionException { return gJavaP.unaryExpressionNotPlusMinus(); }
    public AspectJLo_JavaP.annotationName_return annotationName() throws RecognitionException { return gJavaP.annotationName(); }
    public AspectJLo_JavaP.normalClassDeclaration_return normalClassDeclaration() throws RecognitionException { return gJavaP.normalClassDeclaration(); }
    public AspectJLo_JavaP.annotationTypeElementDeclaration_return annotationTypeElementDeclaration() throws RecognitionException { return gJavaP.annotationTypeElementDeclaration(); }
    public AspectJLo_JavaP.enumDeclaration_return enumDeclaration() throws RecognitionException { return gJavaP.enumDeclaration(); }
    public AspectJLo_JavaP.integerLiteral_return integerLiteral() throws RecognitionException { return gJavaP.integerLiteral(); }
    public AspectJLo_JavaP.classOrInterfaceType_return classOrInterfaceType() throws RecognitionException { return gJavaP.classOrInterfaceType(); }
    public AspectJLo_JavaP.switchLabel_return switchLabel() throws RecognitionException { return gJavaP.switchLabel(); }
    public AspectJLo_JavaP.arrayAccessSuffixRubbish_return arrayAccessSuffixRubbish() throws RecognitionException { return gJavaP.arrayAccessSuffixRubbish(); }
    public AspectJLo_JavaP.importDeclaration_return importDeclaration() throws RecognitionException { return gJavaP.importDeclaration(); }
    public AspectJLo_JavaP.elementValuePairs_return elementValuePairs() throws RecognitionException { return gJavaP.elementValuePairs(); }
    public AspectJLo_JavaP.assignmentOperator_return assignmentOperator() throws RecognitionException { return gJavaP.assignmentOperator(); }
    public AspectJLo_JavaP.variableDeclarators_return variableDeclarators() throws RecognitionException { return gJavaP.variableDeclarators(); }
    public AspectJLo_JavaP.classBody_return classBody() throws RecognitionException { return gJavaP.classBody(); }
    public AspectJLo_JavaP.interfaceBody_return interfaceBody() throws RecognitionException { return gJavaP.interfaceBody(); }
    public AspectJLo_JavaP.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException { return gJavaP.multiplicativeExpression(); }
    public AspectJLo_JavaP.genericMethodOrConstructorRest_return genericMethodOrConstructorRest() throws RecognitionException { return gJavaP.genericMethodOrConstructorRest(); }
    public AspectJLo_JavaP.moreidentifierRuleSuffixRubbish_return moreidentifierRuleSuffixRubbish() throws RecognitionException { return gJavaP.moreidentifierRuleSuffixRubbish(); }
    public AspectJLo_JavaP.arrayInitializer_return arrayInitializer() throws RecognitionException { return gJavaP.arrayInitializer(); }
    public AspectJLo_JavaP.methodBody_return methodBody() throws RecognitionException { return gJavaP.methodBody(); }
    public AspectJLo_JavaP.annotationMethodRest_return annotationMethodRest(TypeReference type) throws RecognitionException { return gJavaP.annotationMethodRest(type); }
    public AspectJLo_JavaP.memberDeclaration_return memberDeclaration() throws RecognitionException { return gJavaP.memberDeclaration(); }
    public AspectJLo_JavaP.typeArguments_return typeArguments() throws RecognitionException { return gJavaP.typeArguments(); }
    public AspectJLo_JavaP.primary_return primary() throws RecognitionException { return gJavaP.primary(); }
    public AspectJLo_JavaP.annotationTypeDeclaration_return annotationTypeDeclaration() throws RecognitionException { return gJavaP.annotationTypeDeclaration(); }
    public AspectJLo_JavaP.interfaceDeclaration_return interfaceDeclaration() throws RecognitionException { return gJavaP.interfaceDeclaration(); }
    public AspectJLo_JavaP.inclusiveOrExpression_return inclusiveOrExpression() throws RecognitionException { return gJavaP.inclusiveOrExpression(); }
    public AspectJLo_JavaP.createClassHereBecauseANTLRisAnnoying_return createClassHereBecauseANTLRisAnnoying() throws RecognitionException { return gJavaP.createClassHereBecauseANTLRisAnnoying(); }
    public AspectJLo_JavaP.statement_return statement() throws RecognitionException { return gJavaP.statement(); }
    public AspectJLo_JavaP.exclusiveOrExpression_return exclusiveOrExpression() throws RecognitionException { return gJavaP.exclusiveOrExpression(); }
    public AspectJLo_JavaP.voidMethodDeclaration_return voidMethodDeclaration() throws RecognitionException { return gJavaP.voidMethodDeclaration(); }
    public AspectJLo_JavaP.conditionalOrExpression_return conditionalOrExpression() throws RecognitionException { return gJavaP.conditionalOrExpression(); }
    public AspectJLo_JavaP.typeParameters_return typeParameters() throws RecognitionException { return gJavaP.typeParameters(); }
    public AspectJLo_JavaP.formalParameter_return formalParameter() throws RecognitionException { return gJavaP.formalParameter(); }
    public AspectJLo_JavaP.annotation_return annotation() throws RecognitionException { return gJavaP.annotation(); }
    public AspectJLo_JavaP.catches_return catches() throws RecognitionException { return gJavaP.catches(); }
    public AspectJLo_JavaP.annotationMethodOrConstantRest_return annotationMethodOrConstantRest(TypeReference type) throws RecognitionException { return gJavaP.annotationMethodOrConstantRest(type); }
    public AspectJLo_JavaP.additiveExpression_return additiveExpression() throws RecognitionException { return gJavaP.additiveExpression(); }
    public AspectJLo_JavaP.type_return type() throws RecognitionException { return gJavaP.type(); }
    public AspectJLo_JavaP.conditionalAndExpression_return conditionalAndExpression() throws RecognitionException { return gJavaP.conditionalAndExpression(); }
    public AspectJLo_JavaP.relationalOp_return relationalOp() throws RecognitionException { return gJavaP.relationalOp(); }
    public AspectJLo_JavaP.createdName_return createdName() throws RecognitionException { return gJavaP.createdName(); }
    public AspectJLo_JavaP.typeBound_return typeBound() throws RecognitionException { return gJavaP.typeBound(); }
    public AspectJLo_JavaP.classDeclaration_return classDeclaration() throws RecognitionException { return gJavaP.classDeclaration(); }
    public AspectJLo_JavaP.selector_return selector() throws RecognitionException { return gJavaP.selector(); }
    public AspectJLo_JavaP.interfaceGenericMethodDecl_return interfaceGenericMethodDecl() throws RecognitionException { return gJavaP.interfaceGenericMethodDecl(); }
    public AspectJLo_JavaP.interfaceBodyDeclaration_return interfaceBodyDeclaration() throws RecognitionException { return gJavaP.interfaceBodyDeclaration(); }
    public AspectJLo_JavaP.elementValueArrayInitializer_return elementValueArrayInitializer() throws RecognitionException { return gJavaP.elementValueArrayInitializer(); }
    public AspectJLo_JavaP.annotationTypeElementRest_return annotationTypeElementRest() throws RecognitionException { return gJavaP.annotationTypeElementRest(); }
    public AspectJLo_JavaP.parExpression_return parExpression() throws RecognitionException { return gJavaP.parExpression(); }
    public AspectJLo_JavaP.variableModifier_return variableModifier() throws RecognitionException { return gJavaP.variableModifier(); }
    public AspectJLo_JavaP.interfaceConstant_return interfaceConstant() throws RecognitionException { return gJavaP.interfaceConstant(); }
    public AspectJLo_JavaP.classBodyDeclaration_return classBodyDeclaration() throws RecognitionException { return gJavaP.classBodyDeclaration(); }
    public AspectJLo_JavaP.switchCase_return switchCase() throws RecognitionException { return gJavaP.switchCase(); }
    public AspectJLo_JavaP.typeName_return typeName() throws RecognitionException { return gJavaP.typeName(); }

    public final boolean synpred7_AspectJLo() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_AspectJLo_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred85_AspectJLo() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred85_AspectJLo_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_AspectJLo() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_AspectJLo_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred50_AspectJLo() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred50_AspectJLo_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_AspectJLo() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_AspectJLo_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_AspectJLo() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_AspectJLo_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred87_AspectJLo() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred87_AspectJLo_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_AspectJLo() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_AspectJLo_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred86_AspectJLo() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred86_AspectJLo_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_AspectJLo() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_AspectJLo_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_AspectJLo() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_AspectJLo_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred77_AspectJLo() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred77_AspectJLo_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_AspectJLo() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_AspectJLo_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred52_AspectJLo() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred52_AspectJLo_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_AspectJLo() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_AspectJLo_fragment(); // can never throw exception
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
    protected DFA15 dfa15 = new DFA15(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA34 dfa34 = new DFA34(this);
    protected DFA51 dfa51 = new DFA51(this);
    static final String DFA2_eotS =
        "\33\uffff";
    static final String DFA2_eofS =
        "\33\uffff";
    static final String DFA2_minS =
        "\1\4\1\uffff\6\0\23\uffff";
    static final String DFA2_maxS =
        "\1\170\1\uffff\6\0\23\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\7\uffff\1\3\1\5\1\uffff\1\6\1\uffff\1"+
        "\7\1\4\1\10\1\12\1\13\1\11";
    static final String DFA2_specialS =
        "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\23\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\2\1\23\16\uffff\1\3\1\4\1\5\1\6\1\7\22\uffff\1\23\2\uffff"+
            "\1\1\5\uffff\1\21\1\20\10\uffff\10\10\11\uffff\1\21\50\uffff"+
            "\1\25",
            "",
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
            return "333:1: memberDecl returns [TypeElement element] : (gen= genericMethodOrConstructorDecl | mem= memberDeclaration | vmd= voidMethodDeclaration | cs= constructorDeclaration | id= interfaceDeclaration | cd= classDeclaration | comp= subobjectDeclaration | exp= exportDeclaration | np= nameParameter | con= connector | cnct= connection );";
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
                        if ( (synpred7_AspectJLo()) ) {s = 8;}

                        else if ( (synpred9_AspectJLo()) ) {s = 22;}

                         
                        input.seek(index2_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA2_3 = input.LA(1);

                         
                        int index2_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_AspectJLo()) ) {s = 8;}

                        else if ( (synpred9_AspectJLo()) ) {s = 22;}

                        else if ( (synpred13_AspectJLo()) ) {s = 23;}

                         
                        input.seek(index2_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA2_4 = input.LA(1);

                         
                        int index2_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_AspectJLo()) ) {s = 8;}

                        else if ( (synpred9_AspectJLo()) ) {s = 22;}

                        else if ( (synpred15_AspectJLo()) ) {s = 24;}

                         
                        input.seek(index2_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA2_5 = input.LA(1);

                         
                        int index2_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_AspectJLo()) ) {s = 8;}

                        else if ( (synpred9_AspectJLo()) ) {s = 22;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index2_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA2_6 = input.LA(1);

                         
                        int index2_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_AspectJLo()) ) {s = 8;}

                        else if ( (synpred9_AspectJLo()) ) {s = 22;}

                        else if ( (synpred14_AspectJLo()) ) {s = 26;}

                         
                        input.seek(index2_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA2_7 = input.LA(1);

                         
                        int index2_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_AspectJLo()) ) {s = 8;}

                        else if ( (synpred9_AspectJLo()) ) {s = 22;}

                         
                        input.seek(index2_7);
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
    static final String DFA15_eotS =
        "\16\uffff";
    static final String DFA15_eofS =
        "\1\14\15\uffff";
    static final String DFA15_minS =
        "\1\40\13\0\2\uffff";
    static final String DFA15_maxS =
        "\1\147\13\0\2\uffff";
    static final String DFA15_acceptS =
        "\14\uffff\1\2\1\1";
    static final String DFA15_specialS =
        "\1\uffff\1\12\1\4\1\11\1\3\1\7\1\1\1\5\1\0\1\10\1\6\1\2\2\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\14\15\uffff\1\12\1\14\1\13\2\uffff\1\14\3\uffff\1\14\1\uffff"+
            "\1\1\17\uffff\1\14\7\uffff\1\14\16\uffff\1\2\1\3\1\4\1\5\1\6"+
            "\1\7\1\10\1\11",
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
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "432:63: (op= assignmentOperator exx= expression )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA15_8 = input.LA(1);

                         
                        int index15_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_AspectJLo()) ) {s = 13;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index15_8);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA15_6 = input.LA(1);

                         
                        int index15_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_AspectJLo()) ) {s = 13;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index15_6);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA15_11 = input.LA(1);

                         
                        int index15_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_AspectJLo()) ) {s = 13;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index15_11);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA15_4 = input.LA(1);

                         
                        int index15_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_AspectJLo()) ) {s = 13;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index15_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA15_2 = input.LA(1);

                         
                        int index15_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_AspectJLo()) ) {s = 13;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index15_2);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA15_7 = input.LA(1);

                         
                        int index15_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_AspectJLo()) ) {s = 13;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index15_7);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA15_10 = input.LA(1);

                         
                        int index15_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_AspectJLo()) ) {s = 13;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index15_10);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA15_5 = input.LA(1);

                         
                        int index15_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_AspectJLo()) ) {s = 13;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index15_5);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA15_9 = input.LA(1);

                         
                        int index15_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_AspectJLo()) ) {s = 13;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index15_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA15_3 = input.LA(1);

                         
                        int index15_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_AspectJLo()) ) {s = 13;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index15_3);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA15_1 = input.LA(1);

                         
                        int index15_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_AspectJLo()) ) {s = 13;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index15_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 15, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA30_eotS =
        "\22\uffff";
    static final String DFA30_eofS =
        "\1\2\21\uffff";
    static final String DFA30_minS =
        "\1\5\1\0\20\uffff";
    static final String DFA30_maxS =
        "\1\177\1\0\20\uffff";
    static final String DFA30_acceptS =
        "\2\uffff\1\2\16\uffff\1\1";
    static final String DFA30_specialS =
        "\1\uffff\1\0\20\uffff}>";
    static final String[] DFA30_transitionS = {
            "\1\2\31\uffff\4\2\2\uffff\7\2\10\uffff\1\2\32\uffff\1\1\57"+
            "\uffff\1\2",
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
            ""
    };

    static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
    static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
    static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
    static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
    static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
    static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
    static final short[][] DFA30_transition;

    static {
        int numStates = DFA30_transitionS.length;
        DFA30_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = DFA30_eot;
            this.eof = DFA30_eof;
            this.min = DFA30_min;
            this.max = DFA30_max;
            this.accept = DFA30_accept;
            this.special = DFA30_special;
            this.transition = DFA30_transition;
        }
        public String getDescription() {
            return "556:8: ( annotations (np= packageDeclaration (imp= importDeclaration )* (typech= typeDeclaration )* | cd= classOrInterfaceDeclaration (typech= typeDeclaration )* ) | (np= packageDeclaration )? (imp= importDeclaration )* (typech= typeDeclaration | ad= aspect )* )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA30_1 = input.LA(1);

                         
                        int index30_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_AspectJLo()) ) {s = 17;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index30_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 30, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA32_eotS =
        "\27\uffff";
    static final String DFA32_eofS =
        "\27\uffff";
    static final String DFA32_minS =
        "\1\4\24\0\2\uffff";
    static final String DFA32_maxS =
        "\1\u008b\24\0\2\uffff";
    static final String DFA32_acceptS =
        "\25\uffff\1\1\1\2";
    static final String DFA32_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\2\uffff}>";
    static final String[] DFA32_transitionS = {
            "\1\10\17\uffff\1\11\1\12\1\13\1\14\1\15\57\uffff\1\24\11\uffff"+
            "\1\22\43\uffff\1\23\12\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\17"+
            "\1\20\1\21\1\16",
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
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
    static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
    static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
    static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
    static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
    static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
    static final short[][] DFA32_transition;

    static {
        int numStates = DFA32_transitionS.length;
        DFA32_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = DFA32_eot;
            this.eof = DFA32_eof;
            this.min = DFA32_min;
            this.max = DFA32_max;
            this.accept = DFA32_accept;
            this.special = DFA32_special;
            this.transition = DFA32_transition;
        }
        public String getDescription() {
            return "634:1: pointcutExpression returns [PointcutExpression element] : (expr1= pointcutExpressionOr '&&' expr2= pointcutExpression | exprOr= pointcutExpressionOr );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA32_1 = input.LA(1);

                         
                        int index32_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index32_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA32_2 = input.LA(1);

                         
                        int index32_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index32_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA32_3 = input.LA(1);

                         
                        int index32_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index32_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA32_4 = input.LA(1);

                         
                        int index32_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index32_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA32_5 = input.LA(1);

                         
                        int index32_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index32_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA32_6 = input.LA(1);

                         
                        int index32_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index32_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA32_7 = input.LA(1);

                         
                        int index32_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index32_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA32_8 = input.LA(1);

                         
                        int index32_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index32_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA32_9 = input.LA(1);

                         
                        int index32_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index32_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA32_10 = input.LA(1);

                         
                        int index32_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index32_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA32_11 = input.LA(1);

                         
                        int index32_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index32_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA32_12 = input.LA(1);

                         
                        int index32_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index32_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA32_13 = input.LA(1);

                         
                        int index32_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index32_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA32_14 = input.LA(1);

                         
                        int index32_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index32_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA32_15 = input.LA(1);

                         
                        int index32_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index32_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA32_16 = input.LA(1);

                         
                        int index32_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index32_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA32_17 = input.LA(1);

                         
                        int index32_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index32_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA32_18 = input.LA(1);

                         
                        int index32_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index32_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA32_19 = input.LA(1);

                         
                        int index32_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index32_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA32_20 = input.LA(1);

                         
                        int index32_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index32_20);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 32, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA34_eotS =
        "\27\uffff";
    static final String DFA34_eofS =
        "\27\uffff";
    static final String DFA34_minS =
        "\1\4\24\0\2\uffff";
    static final String DFA34_maxS =
        "\1\u008b\24\0\2\uffff";
    static final String DFA34_acceptS =
        "\25\uffff\1\1\1\2";
    static final String DFA34_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\2\uffff}>";
    static final String[] DFA34_transitionS = {
            "\1\10\17\uffff\1\11\1\12\1\13\1\14\1\15\57\uffff\1\24\11\uffff"+
            "\1\22\43\uffff\1\23\12\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\17"+
            "\1\20\1\21\1\16",
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
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA34_eot = DFA.unpackEncodedString(DFA34_eotS);
    static final short[] DFA34_eof = DFA.unpackEncodedString(DFA34_eofS);
    static final char[] DFA34_min = DFA.unpackEncodedStringToUnsignedChars(DFA34_minS);
    static final char[] DFA34_max = DFA.unpackEncodedStringToUnsignedChars(DFA34_maxS);
    static final short[] DFA34_accept = DFA.unpackEncodedString(DFA34_acceptS);
    static final short[] DFA34_special = DFA.unpackEncodedString(DFA34_specialS);
    static final short[][] DFA34_transition;

    static {
        int numStates = DFA34_transitionS.length;
        DFA34_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA34_transition[i] = DFA.unpackEncodedString(DFA34_transitionS[i]);
        }
    }

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = DFA34_eot;
            this.eof = DFA34_eof;
            this.min = DFA34_min;
            this.max = DFA34_max;
            this.accept = DFA34_accept;
            this.special = DFA34_special;
            this.transition = DFA34_transition;
        }
        public String getDescription() {
            return "645:1: pointcutExpressionOr returns [PointcutExpression element] : (expr1= pointcutAtom '||' expr2= pointcutExpressionOr | expr= pointcutAtom );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA34_1 = input.LA(1);

                         
                        int index34_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index34_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA34_2 = input.LA(1);

                         
                        int index34_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index34_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA34_3 = input.LA(1);

                         
                        int index34_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index34_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA34_4 = input.LA(1);

                         
                        int index34_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index34_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA34_5 = input.LA(1);

                         
                        int index34_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index34_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA34_6 = input.LA(1);

                         
                        int index34_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index34_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA34_7 = input.LA(1);

                         
                        int index34_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index34_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA34_8 = input.LA(1);

                         
                        int index34_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index34_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA34_9 = input.LA(1);

                         
                        int index34_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index34_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA34_10 = input.LA(1);

                         
                        int index34_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index34_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA34_11 = input.LA(1);

                         
                        int index34_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index34_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA34_12 = input.LA(1);

                         
                        int index34_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index34_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA34_13 = input.LA(1);

                         
                        int index34_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index34_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA34_14 = input.LA(1);

                         
                        int index34_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index34_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA34_15 = input.LA(1);

                         
                        int index34_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index34_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA34_16 = input.LA(1);

                         
                        int index34_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index34_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA34_17 = input.LA(1);

                         
                        int index34_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index34_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA34_18 = input.LA(1);

                         
                        int index34_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index34_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA34_19 = input.LA(1);

                         
                        int index34_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index34_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA34_20 = input.LA(1);

                         
                        int index34_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_AspectJLo()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index34_20);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 34, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA51_eotS =
        "\103\uffff";
    static final String DFA51_eofS =
        "\103\uffff";
    static final String DFA51_minS =
        "\1\4\20\0\11\uffff\1\0\50\uffff";
    static final String DFA51_maxS =
        "\1\175\20\0\11\uffff\1\0\50\uffff";
    static final String DFA51_acceptS =
        "\21\uffff\1\2\11\uffff\1\4\45\uffff\1\1\1\3";
    static final String DFA51_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\1\17\11\uffff\1\20\50\uffff}>";
    static final String[] DFA51_transitionS = {
            "\1\3\1\21\7\33\7\uffff\1\4\1\5\1\6\1\7\1\10\7\uffff\1\33\1"+
            "\uffff\1\21\2\uffff\4\21\1\1\2\21\6\uffff\1\33\1\uffff\1\21"+
            "\1\33\5\uffff\1\33\2\uffff\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
            "\1\20\1\uffff\2\33\2\uffff\4\33\1\2\2\uffff\1\33\1\uffff\4\33"+
            "\1\uffff\1\33\1\32\3\33\21\uffff\2\33\2\uffff\6\33\1\uffff\4"+
            "\33",
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
            "",
            ""
    };

    static final short[] DFA51_eot = DFA.unpackEncodedString(DFA51_eotS);
    static final short[] DFA51_eof = DFA.unpackEncodedString(DFA51_eofS);
    static final char[] DFA51_min = DFA.unpackEncodedStringToUnsignedChars(DFA51_minS);
    static final char[] DFA51_max = DFA.unpackEncodedStringToUnsignedChars(DFA51_maxS);
    static final short[] DFA51_accept = DFA.unpackEncodedString(DFA51_acceptS);
    static final short[] DFA51_special = DFA.unpackEncodedString(DFA51_specialS);
    static final short[][] DFA51_transition;

    static {
        int numStates = DFA51_transitionS.length;
        DFA51_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA51_transition[i] = DFA.unpackEncodedString(DFA51_transitionS[i]);
        }
    }

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = DFA51_eot;
            this.eof = DFA51_eof;
            this.min = DFA51_min;
            this.max = DFA51_max;
            this.accept = DFA51_accept;
            this.special = DFA51_special;
            this.transition = DFA51_transition;
        }
        public String getDescription() {
            return "781:1: adviceBlockStatement returns [Statement element] : (local= localVariableDeclarationStatement | cd= classOrInterfaceDeclaration | specialReturn= adviceReturnStatement | stat= statement );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA51_1 = input.LA(1);

                         
                        int index51_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_AspectJLo()) ) {s = 65;}

                        else if ( (synpred86_AspectJLo()) ) {s = 17;}

                         
                        input.seek(index51_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA51_2 = input.LA(1);

                         
                        int index51_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_AspectJLo()) ) {s = 65;}

                        else if ( (synpred86_AspectJLo()) ) {s = 17;}

                         
                        input.seek(index51_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA51_3 = input.LA(1);

                         
                        int index51_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_AspectJLo()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index51_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA51_4 = input.LA(1);

                         
                        int index51_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_AspectJLo()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index51_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA51_5 = input.LA(1);

                         
                        int index51_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_AspectJLo()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index51_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA51_6 = input.LA(1);

                         
                        int index51_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_AspectJLo()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index51_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA51_7 = input.LA(1);

                         
                        int index51_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_AspectJLo()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index51_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA51_8 = input.LA(1);

                         
                        int index51_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_AspectJLo()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index51_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA51_9 = input.LA(1);

                         
                        int index51_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_AspectJLo()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index51_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA51_10 = input.LA(1);

                         
                        int index51_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_AspectJLo()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index51_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA51_11 = input.LA(1);

                         
                        int index51_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_AspectJLo()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index51_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA51_12 = input.LA(1);

                         
                        int index51_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_AspectJLo()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index51_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA51_13 = input.LA(1);

                         
                        int index51_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_AspectJLo()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index51_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA51_14 = input.LA(1);

                         
                        int index51_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_AspectJLo()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index51_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA51_15 = input.LA(1);

                         
                        int index51_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_AspectJLo()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index51_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA51_16 = input.LA(1);

                         
                        int index51_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_AspectJLo()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index51_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA51_26 = input.LA(1);

                         
                        int index51_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_AspectJLo()) ) {s = 66;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index51_26);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 51, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_Identifier_in_identifierRule72 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Export_in_identifierRule87 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Connector_in_identifierRule103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Connect_in_identifierRule119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Name_in_identifierRule135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Overrides_in_identifierRule151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_genericMethodOrConstructorDecl_in_memberDecl188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_memberDeclaration_in_memberDecl202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_voidMethodDeclaration_in_memberDecl216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constructorDeclaration_in_memberDecl230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceDeclaration_in_memberDecl244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classDeclaration_in_memberDecl258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subobjectDeclaration_in_memberDecl272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exportDeclaration_in_memberDecl286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nameParameter_in_memberDecl300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_connector_in_memberDecl314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_connection_in_memberDecl328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Connector_in_connector351 = new BitSet(new long[]{0x0000000001F00010L});
    public static final BitSet FOLLOW_subobjectParameter_in_connector355 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_connector358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Connect_in_connection378 = new BitSet(new long[]{0x0000000001F00010L});
    public static final BitSet FOLLOW_identifierRule_in_connection382 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_connection386 = new BitSet(new long[]{0x0040000001F00010L,0x0000000000008000L});
    public static final BitSet FOLLOW_subobjectArgument_in_connection390 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_connection392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Name_in_nameParameter419 = new BitSet(new long[]{0x0000000001F00010L});
    public static final BitSet FOLLOW_identifierRule_in_nameParameter421 = new BitSet(new long[]{0x0200000100000000L});
    public static final BitSet FOLLOW_57_in_nameParameter424 = new BitSet(new long[]{0x0000000001F00010L});
    public static final BitSet FOLLOW_memberName_in_nameParameter426 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_nameParameter430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierRule_in_memberName455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Export_in_exportDeclaration482 = new BitSet(new long[]{0x0000000001F00010L});
    public static final BitSet FOLLOW_map_in_exportDeclaration488 = new BitSet(new long[]{0x0000800100000000L});
    public static final BitSet FOLLOW_47_in_exportDeclaration493 = new BitSet(new long[]{0x0000000001F00010L});
    public static final BitSet FOLLOW_map_in_exportDeclaration497 = new BitSet(new long[]{0x0000800100000000L});
    public static final BitSet FOLLOW_32_in_exportDeclaration503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fqn_in_map530 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_Identifier_in_map542 = new BitSet(new long[]{0x0000000001F00010L});
    public static final BitSet FOLLOW_signature_in_map546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_subobjectDeclaration581 = new BitSet(new long[]{0xC000000001F00010L,0x000000000000003FL});
    public static final BitSet FOLLOW_type_in_subobjectDeclaration585 = new BitSet(new long[]{0x0000000001F00010L});
    public static final BitSet FOLLOW_identifierRule_in_subobjectDeclaration590 = new BitSet(new long[]{0x0004000100000000L});
    public static final BitSet FOLLOW_classBody_in_subobjectDeclaration624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_subobjectDeclaration630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_configurationBlock679 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_configurationBlock681 = new BitSet(new long[]{0x0008000001F00010L});
    public static final BitSet FOLLOW_configurationClause_in_configurationBlock688 = new BitSet(new long[]{0x0008800000000000L});
    public static final BitSet FOLLOW_47_in_configurationBlock692 = new BitSet(new long[]{0x0000000001F00010L});
    public static final BitSet FOLLOW_configurationClause_in_configurationBlock696 = new BitSet(new long[]{0x0008800000000000L});
    public static final BitSet FOLLOW_51_in_configurationBlock703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_signature_in_configurationClause739 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_configurationClause743 = new BitSet(new long[]{0x0000000001F00010L});
    public static final BitSet FOLLOW_fqn_in_configurationClause747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_signature_in_configurationClause764 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_configurationClause768 = new BitSet(new long[]{0x0000000001F00010L});
    public static final BitSet FOLLOW_fqn_in_configurationClause772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierRule_in_signature806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierRule_in_signature822 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_signature843 = new BitSet(new long[]{0xC000000001F00010L,0x000000000000023FL});
    public static final BitSet FOLLOW_type_in_signature848 = new BitSet(new long[]{0x0000800000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_47_in_signature871 = new BitSet(new long[]{0xC000000001F00010L,0x000000000000003FL});
    public static final BitSet FOLLOW_type_in_signature875 = new BitSet(new long[]{0x0000800000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_signature882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_signature_in_fqn922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierRule_in_fqn942 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_fqn944 = new BitSet(new long[]{0x0000000001F00010L});
    public static final BitSet FOLLOW_fqn_in_fqn948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalExpression_in_expression987 = new BitSet(new long[]{0x0201400000000002L,0x000000FF00000000L});
    public static final BitSet FOLLOW_assignmentOperator_in_expression994 = new BitSet(new long[]{0xC020000001F00FD0L,0x3DF98000000079BFL});
    public static final BitSet FOLLOW_expression_in_expression998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_expression1034 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_expression1036 = new BitSet(new long[]{0x0000000001F00010L});
    public static final BitSet FOLLOW_identifierRule_in_expression1040 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_arguments_in_expression1044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_expression1060 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_arguments_in_expression1064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_nonTargetPrimary1116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_nonTargetPrimary1127 = new BitSet(new long[]{0x0000000001F00010L});
    public static final BitSet FOLLOW_identifierRule_in_nonTargetPrimary1131 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_nonTargetPrimary1133 = new BitSet(new long[]{0xC020000001F00FD0L,0x3DF98000000079BFL});
    public static final BitSet FOLLOW_expression_in_nonTargetPrimary1137 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_nonTargetPrimary1143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_nonTargetPrimary1170 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_superSuffix_in_nonTargetPrimary1174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_nonTargetPrimary1202 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_superSuffix_in_nonTargetPrimary1206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_singleSubobjectParameter_in_subobjectParameter1243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multiSubobjectParameter_in_subobjectParameter1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierRule_in_singleSubobjectParameter1272 = new BitSet(new long[]{0xC000000001F00010L,0x000000000000003FL});
    public static final BitSet FOLLOW_type_in_singleSubobjectParameter1276 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_126_in_singleSubobjectParameter1280 = new BitSet(new long[]{0xC000000001F00010L,0x000000000000003FL});
    public static final BitSet FOLLOW_type_in_singleSubobjectParameter1284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierRule_in_multiSubobjectParameter1308 = new BitSet(new long[]{0xC000000001F00010L,0x000000000000003FL});
    public static final BitSet FOLLOW_type_in_multiSubobjectParameter1312 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_126_in_multiSubobjectParameter1316 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_multiSubobjectParameter1318 = new BitSet(new long[]{0xC000000001F00010L,0x000000000000003FL});
    public static final BitSet FOLLOW_type_in_multiSubobjectParameter1322 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_multiSubobjectParameter1326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_singleSubobjectArgument_in_subobjectArgument1353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multiSubobjectArgument_in_subobjectArgument1365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierRule_in_singleSubobjectArgument1389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_singleSubobjectArgument1403 = new BitSet(new long[]{0x0000000001F00010L});
    public static final BitSet FOLLOW_identifierRule_in_singleSubobjectArgument1407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_multiSubobjectArgument1431 = new BitSet(new long[]{0x0080000001F00010L,0x0000000000008000L});
    public static final BitSet FOLLOW_singleSubobjectArgument_in_multiSubobjectArgument1436 = new BitSet(new long[]{0x0080800000000000L});
    public static final BitSet FOLLOW_47_in_multiSubobjectArgument1448 = new BitSet(new long[]{0x0000000001F00010L,0x0000000000008000L});
    public static final BitSet FOLLOW_singleSubobjectArgument_in_multiSubobjectArgument1452 = new BitSet(new long[]{0x0080800000000000L});
    public static final BitSet FOLLOW_55_in_multiSubobjectArgument1464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotations_in_compilationUnit1498 = new BitSet(new long[]{0x00100FE480000020L,0x0000000000008000L});
    public static final BitSet FOLLOW_packageDeclaration_in_compilationUnit1514 = new BitSet(new long[]{0x00100FE780000022L,0x0000000000008000L});
    public static final BitSet FOLLOW_importDeclaration_in_compilationUnit1550 = new BitSet(new long[]{0x00100FE780000022L,0x0000000000008000L});
    public static final BitSet FOLLOW_typeDeclaration_in_compilationUnit1571 = new BitSet(new long[]{0x00100FE580000022L,0x0000000000008000L});
    public static final BitSet FOLLOW_classOrInterfaceDeclaration_in_compilationUnit1620 = new BitSet(new long[]{0x00100FE580000022L,0x0000000000008000L});
    public static final BitSet FOLLOW_typeDeclaration_in_compilationUnit1655 = new BitSet(new long[]{0x00100FE580000022L,0x0000000000008000L});
    public static final BitSet FOLLOW_packageDeclaration_in_compilationUnit1710 = new BitSet(new long[]{0x00100FE780000022L,0x8000000000008000L});
    public static final BitSet FOLLOW_importDeclaration_in_compilationUnit1759 = new BitSet(new long[]{0x00100FE780000022L,0x8000000000008000L});
    public static final BitSet FOLLOW_typeDeclaration_in_compilationUnit1796 = new BitSet(new long[]{0x00100FE580000022L,0x8000000000008000L});
    public static final BitSet FOLLOW_aspect_in_compilationUnit1834 = new BitSet(new long[]{0x00100FE580000022L,0x8000000000008000L});
    public static final BitSet FOLLOW_127_in_aspect1880 = new BitSet(new long[]{0x0000000001F00010L});
    public static final BitSet FOLLOW_identifierRule_in_aspect1884 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_aspect1890 = new BitSet(new long[]{0xC028000001F00010L,0x000000000000003FL,0x0000000000007001L});
    public static final BitSet FOLLOW_advice_in_aspect1899 = new BitSet(new long[]{0xC028000001F00010L,0x000000000000003FL,0x0000000000007001L});
    public static final BitSet FOLLOW_pointcut_in_aspect1906 = new BitSet(new long[]{0xC028000001F00010L,0x000000000000003FL,0x0000000000007001L});
    public static final BitSet FOLLOW_51_in_aspect1914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_128_in_pointcut1941 = new BitSet(new long[]{0x0000000001F00010L});
    public static final BitSet FOLLOW_pointcutDecl_in_pointcut1945 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_formalParameters_in_pointcut1949 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_pointcut1951 = new BitSet(new long[]{0x0000000001F00010L,0x0040000000040100L,0x0000000000000FFEL});
    public static final BitSet FOLLOW_pointcutExpression_in_pointcut1955 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_pointcut1957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierRule_in_pointcutDecl1980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutExpressionOr_in_pointcutExpression2005 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_105_in_pointcutExpression2007 = new BitSet(new long[]{0x0000000001F00010L,0x0040000000040100L,0x0000000000000FFEL});
    public static final BitSet FOLLOW_pointcutExpression_in_pointcutExpression2011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutExpressionOr_in_pointcutExpression2020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierRule_in_memberReference2044 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_memberReference2049 = new BitSet(new long[]{0x0000000001F00010L});
    public static final BitSet FOLLOW_identifierRule_in_memberReference2053 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_pointcutAtom_in_pointcutExpressionOr2081 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_104_in_pointcutExpressionOr2083 = new BitSet(new long[]{0x0000000001F00010L,0x0040000000040100L,0x0000000000000FFEL});
    public static final BitSet FOLLOW_pointcutExpressionOr_in_pointcutExpressionOr2087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutAtom_in_pointcutExpressionOr2096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeOrVoid_in_methodReference2125 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_IdentifierWithWC_in_methodReference2131 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_methodRefFqn_in_methodReference2138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_methodRefFqn2166 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_methodRefFqn2172 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_simpleMethodHeader_in_methodRefFqn2180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_simpleMethodHeader2211 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_formalParameterTypes_in_simpleMethodHeader2219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_formalParameterTypes2261 = new BitSet(new long[]{0xC000000001F00010L,0x000000000000023FL});
    public static final BitSet FOLLOW_formalParameterTypeDecls_in_formalParameterTypes2266 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_formalParameterTypes2272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_formalParameterTypeDecls2297 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_47_in_formalParameterTypeDecls2300 = new BitSet(new long[]{0xC000000001F00010L,0x000000000000003FL});
    public static final BitSet FOLLOW_formalParameterTypeDecls_in_formalParameterTypeDecls2304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeOrVoid2339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_voidType_in_typeOrVoid2348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_pointcutAtom2372 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_pointcutAtom2374 = new BitSet(new long[]{0xC020000041F00010L,0x000000000000003FL});
    public static final BitSet FOLLOW_methodReference_in_pointcutAtom2378 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_pointcutAtom2380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_pointcutAtom2389 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_pointcutAtom2391 = new BitSet(new long[]{0xC000000001F00010L,0x000000000000003FL});
    public static final BitSet FOLLOW_type_in_pointcutAtom2395 = new BitSet(new long[]{0x0000000001F00010L});
    public static final BitSet FOLLOW_memberReference_in_pointcutAtom2399 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_pointcutAtom2401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_131_in_pointcutAtom2411 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_pointcutAtom2413 = new BitSet(new long[]{0x0000000001F00010L});
    public static final BitSet FOLLOW_identifierRule_in_pointcutAtom2417 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_pointcutAtom2419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_132_in_pointcutAtom2428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_133_in_pointcutAtom2437 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_pointcutAtom2439 = new BitSet(new long[]{0xC000000001F00010L,0x000000000000003FL});
    public static final BitSet FOLLOW_type_in_pointcutAtom2443 = new BitSet(new long[]{0x0000000001F00010L});
    public static final BitSet FOLLOW_fieldReference_in_pointcutAtom2447 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_pointcutAtom2449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_134_in_pointcutAtom2458 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_pointcutAtom2460 = new BitSet(new long[]{0xC000000001F00010L,0x000000000000003FL});
    public static final BitSet FOLLOW_type_in_pointcutAtom2464 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_pointcutAtom2466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_135_in_pointcutAtom2475 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_pointcutAtom2477 = new BitSet(new long[]{0xC000000001F00010L,0x000000000000003FL});
    public static final BitSet FOLLOW_type_in_pointcutAtom2481 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_pointcutAtom2483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_namedPointcutReference_in_pointcutAtom2492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_within_in_pointcutAtom2501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_136_in_pointcutAtom2512 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_typesOrParameters_in_pointcutAtom2516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_137_in_pointcutAtom2525 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_pointcutAtom2527 = new BitSet(new long[]{0xC020000001F00FD0L,0x3DF98000000079BFL});
    public static final BitSet FOLLOW_expression_in_pointcutAtom2531 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_pointcutAtom2533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_138_in_pointcutAtom2542 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_pointcutAtom2544 = new BitSet(new long[]{0xC020000001F00FD0L,0x3DF98000000079BFL});
    public static final BitSet FOLLOW_expression_in_pointcutAtom2548 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_pointcutAtom2550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_pointcutAtom2559 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_pointcutAtom2561 = new BitSet(new long[]{0xC020000001F00FD0L,0x3DF98000000079BFL});
    public static final BitSet FOLLOW_expression_in_pointcutAtom2565 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_pointcutAtom2567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_pointcutAtom2574 = new BitSet(new long[]{0x0000000001F00010L,0x0040000000040100L,0x0000000000000FFEL});
    public static final BitSet FOLLOW_pointcutAtom_in_pointcutAtom2578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_pointcutAtom2585 = new BitSet(new long[]{0x0000000001F00010L,0x0040000000040100L,0x0000000000000FFEL});
    public static final BitSet FOLLOW_pointcutExpression_in_pointcutAtom2589 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_pointcutAtom2591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_typesOrParameters2617 = new BitSet(new long[]{0xC020000001F00FD0L,0x3DF9800000007BBFL});
    public static final BitSet FOLLOW_typesOrParameterDecls_in_typesOrParameters2622 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_typesOrParameters2628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_typesOrParameterDecls2651 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_47_in_typesOrParameterDecls2654 = new BitSet(new long[]{0xC020000001F00FD0L,0x3DF98000000079BFL});
    public static final BitSet FOLLOW_typesOrParameterDecls_in_typesOrParameterDecls2658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_subtypeMarker2688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_139_in_withinType2710 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_withinType2712 = new BitSet(new long[]{0xC000000001F00010L,0x000000000000003FL});
    public static final BitSet FOLLOW_type_in_withinType2716 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000200L});
    public static final BitSet FOLLOW_subtypeMarker_in_withinType2721 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_withinType2727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_139_in_withinMethod2749 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_withinMethod2751 = new BitSet(new long[]{0xC020000041F00010L,0x000000000000003FL});
    public static final BitSet FOLLOW_methodReference_in_withinMethod2755 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_withinMethod2757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_withinType_in_within2774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_withinMethod_in_within2783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierRule_in_fieldReference2807 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_fieldReference2812 = new BitSet(new long[]{0x0000000001F00010L});
    public static final BitSet FOLLOW_identifierRule_in_fieldReference2816 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_pointcutDecl_in_namedPointcutReference2845 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_namedPointcutReference2847 = new BitSet(new long[]{0x0000000001F00010L,0x0000000000000200L});
    public static final BitSet FOLLOW_argParams_in_namedPointcutReference2852 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_namedPointcutReference2860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierRule_in_argParams2880 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_47_in_argParams2883 = new BitSet(new long[]{0x0000000001F00010L});
    public static final BitSet FOLLOW_argParams_in_argParams2887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_advice2921 = new BitSet(new long[]{0xC020000001F00010L,0x000000000000003FL,0x0000000000007000L});
    public static final BitSet FOLLOW_53_in_advice2926 = new BitSet(new long[]{0xC020000001F00010L,0x000000000000003FL,0x0000000000007000L});
    public static final BitSet FOLLOW_adviceTypeModifier_in_advice2934 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_formalParameters_in_advice2938 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L,0x0000000000018000L});
    public static final BitSet FOLLOW_adviceTypeModifierSpecifier_in_advice2943 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_advice2949 = new BitSet(new long[]{0x0000000001F00010L,0x0040000000040100L,0x0000000000000FFEL});
    public static final BitSet FOLLOW_pointcutExpression_in_advice2953 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_adviceBody_in_advice2964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceBlock_in_adviceBody2990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_adviceBlock3019 = new BitSet(new long[]{0xC83C0FE581F01FF0L,0x3DF980003EF4F9BFL});
    public static final BitSet FOLLOW_adviceBlockStatement_in_adviceBlock3026 = new BitSet(new long[]{0xC83C0FE581F01FF0L,0x3DF980003EF4F9BFL});
    public static final BitSet FOLLOW_51_in_adviceBlock3032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localVariableDeclarationStatement_in_adviceBlockStatement3065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceDeclaration_in_adviceBlockStatement3079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceReturnStatement_in_adviceBlockStatement3091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_adviceBlockStatement3105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_adviceReturnStatement3138 = new BitSet(new long[]{0xC020000101F00FD0L,0x3DF98000000079BFL});
    public static final BitSet FOLLOW_expression_in_adviceReturnStatement3160 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_adviceReturnStatement3166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_140_in_adviceTypeModifier3191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_141_in_adviceTypeModifier3200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_142_in_adviceTypeModifier3209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_143_in_adviceTypeModifierSpecifier3233 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_adviceTypeModifierSpecifier3236 = new BitSet(new long[]{0xC000020001F00010L,0x000000000000823FL});
    public static final BitSet FOLLOW_formalParameter_in_adviceTypeModifierSpecifier3241 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_adviceTypeModifierSpecifier3247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_144_in_adviceTypeModifierSpecifier3258 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_adviceTypeModifierSpecifier3261 = new BitSet(new long[]{0xC000020001F00010L,0x000000000000823FL});
    public static final BitSet FOLLOW_formalParameter_in_adviceTypeModifierSpecifier3266 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_adviceTypeModifierSpecifier3272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_memberDeclaration_in_synpred7_AspectJLo202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constructorDeclaration_in_synpred9_AspectJLo230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exportDeclaration_in_synpred13_AspectJLo286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nameParameter_in_synpred14_AspectJLo300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_connector_in_synpred15_AspectJLo314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_signature_in_synpred23_AspectJLo739 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_synpred23_AspectJLo743 = new BitSet(new long[]{0x0000000001F00010L});
    public static final BitSet FOLLOW_fqn_in_synpred23_AspectJLo747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentOperator_in_synpred28_AspectJLo994 = new BitSet(new long[]{0xC020000001F00FD0L,0x3DF98000000079BFL});
    public static final BitSet FOLLOW_expression_in_synpred28_AspectJLo998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_singleSubobjectParameter_in_synpred34_AspectJLo1243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotations_in_synpred43_AspectJLo1498 = new BitSet(new long[]{0x00100FE480000020L,0x0000000000008000L});
    public static final BitSet FOLLOW_packageDeclaration_in_synpred43_AspectJLo1514 = new BitSet(new long[]{0x00100FE780000022L,0x0000000000008000L});
    public static final BitSet FOLLOW_importDeclaration_in_synpred43_AspectJLo1550 = new BitSet(new long[]{0x00100FE780000022L,0x0000000000008000L});
    public static final BitSet FOLLOW_typeDeclaration_in_synpred43_AspectJLo1571 = new BitSet(new long[]{0x00100FE580000022L,0x0000000000008000L});
    public static final BitSet FOLLOW_classOrInterfaceDeclaration_in_synpred43_AspectJLo1620 = new BitSet(new long[]{0x00100FE580000022L,0x0000000000008000L});
    public static final BitSet FOLLOW_typeDeclaration_in_synpred43_AspectJLo1655 = new BitSet(new long[]{0x00100FE580000022L,0x0000000000008000L});
    public static final BitSet FOLLOW_pointcutExpressionOr_in_synpred50_AspectJLo2005 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_105_in_synpred50_AspectJLo2007 = new BitSet(new long[]{0x0000000001F00010L,0x0040000000040100L,0x0000000000000FFEL});
    public static final BitSet FOLLOW_pointcutExpression_in_synpred50_AspectJLo2011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutAtom_in_synpred52_AspectJLo2081 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_104_in_synpred52_AspectJLo2083 = new BitSet(new long[]{0x0000000001F00010L,0x0040000000040100L,0x0000000000000FFEL});
    public static final BitSet FOLLOW_pointcutExpressionOr_in_synpred52_AspectJLo2087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_withinType_in_synpred77_AspectJLo2774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localVariableDeclarationStatement_in_synpred85_AspectJLo3065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceDeclaration_in_synpred86_AspectJLo3079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceReturnStatement_in_synpred87_AspectJLo3091 = new BitSet(new long[]{0x0000000000000002L});

}