parser grammar AspectLanguage;
options {
  backtrack=true; 
  memoize=true;
  output=AST;
  superClass = ChameleonParser;
}
@members{
	@Override
	public Object compilationUnit() throws RecognitionException {
		throw new RuntimeException();
	}
	public JavaTypeReference typeRef(String qn) {
	    return ((Java)language()).createTypeReference(qn);
	  }
}

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
	: ifCheck='if' '(' exp=expression ')' {IfPointcutExpression expr = new IfPointcutExpression(exp.element); retval.element = expr; setKeyword(retval.element, ifCheck);}
	| expr1=pointcutExpressionOr '&&' expr2=pointcutExpression {retval.element = new PointcutExpressionAnd(expr1.element, expr2.element);}
	| exprOr=pointcutExpressionOr {retval.element = exprOr.element;}
	;

pointcutExpressionOr returns [PointcutExpression element]
@after{setLocation(retval.element, retval.start, retval.stop);}
	: expr1=pointcutAtom '||' expr2=pointcutExpressionOr {retval.element = new PointcutExpressionOr(expr1.element, expr2.element);}
	| expr=pointcutAtom {retval.element = expr.element;}
	;
	
pointcutAtom returns [PointcutExpression element]
@after{setLocation(retval.element, retval.start, retval.stop);}
	: namedRef=namedPointcutReference {NamedPointcutExpression named = new NamedPointcutExpression(); named.setPointcutReference(namedRef.element); retval.element = named;}
	| '!' expr1=pointcutAtom {retval.element = new PointcutExpressionNot(expr1.element);}
	| '(' expr2=pointcutExpression ')' {retval.element = expr2.element;}
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