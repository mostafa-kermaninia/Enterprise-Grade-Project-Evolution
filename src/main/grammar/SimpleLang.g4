grammar SimpleLang;

@header{
    import main.ast.nodes_DIR.*;
    import main.ast.declaration_DIR.*;
    import main.ast.expression_DIR.*;
    import main.ast.literal_DIR.*;
    import main.ast.statement_DIR.*;
}

program returns [Program programRet]:
    { $programRet = new Program(); }
    (tu=translationUnit { $programRet.setTranslationUnit(tu.translationUnitRet); })?
    EOF
;

translationUnit returns [TranslationUnit translationUnitRet]:
    { $translationUnitRet = new TranslationUnit(); }
    (ed=externalDeclaration { $translationUnitRet.addExternalDeclaration(ed.externalDeclarationRet); })+
;

externalDeclaration returns [ExternalDeclaration externalDeclarationRet]:
  fd=functionDefinition { $externalDeclarationRet = fd.functionDefinitionRet; }
  | d=declaration        { $externalDeclarationRet = d.declarationRet; }
  | Semi
;

functionDefinition returns [FunctionDefinition functionDefinitionRet]:
    { $functionDefinitionRet = new FunctionDefinition(); }
    ( ds=declarationSpecifiers  { $functionDefinitionRet.setDeclarationSpecifiers(ds.textRet); } )?
    d=declarator                { $functionDefinitionRet.setDeclarator(d.declaratorRet); }
    ( dl=declarationList        { $functionDefinitionRet.setDeclarationList(dl.declarationListRet); } )?
    cs=compoundStatement        { $functionDefinitionRet.setCompoundStatement(cs.compoundStatementRet); }
;

declarationList returns [DeclarationList declarationListRet]:
    { $declarationListRet = new DeclarationList(); }
    ( d=declaration { $declarationListRet.addDeclaration(d.declarationRet); } )+
;
//
//expression
//  : Identifier | Constant | StringLiteral+
//  | LeftParen expression RightParen
//  | LeftParen typeName RightParen LeftBrace initializerList Comma? RightBrace
//  | expression LeftBracket expression RightBracket                                // Array indexing
//  | expression LeftParen argumentExpressionList? RightParen                       // Function call
//  | expression PlusPlus                                                           // Postfix increment
//  | expression MinusMinus                                                         // Postfix decrement
//  | (PlusPlus  | MinusMinus | Sizeof)* (                                          // Prefix operators (zero or more)
//         Identifier
//       | Constant
//       | StringLiteral+
//       | LeftParen expression RightParen
//       | LeftParen typeName RightParen LeftBrace initializerList Comma? RightBrace
//       | unaryOperator castExpression
//       | Sizeof LeftParen typeName RightParen
//    )
//  | LeftParen typeName RightParen castExpression                                  // Cast expression
//  | expression (Star | Div | Mod) expression                                      // Multiplicative
//  | expression (Plus | Minus) expression                                          // Additive
//  | expression (LeftShift | RightShift) expression                                // Shift
//  | expression (Less | Greater | LessEqual | GreaterEqual) expression             // Relational
//  | expression (Equal | NotEqual) expression                                      // Equality
//  | expression And expression                                                     // Bitwise AND
//  | expression Xor expression                                                     // Bitwise XOR
//  | expression Or expression                                                      // Bitwise OR
//  | expression AndAnd expression                                                  // Logical AND
//  | expression OrOr expression                                                    // Logical OR
//  | expression Question expression Colon expression                               // Conditional operator
//  | expression assignmentOperator expression                                      // Assignment
//  | expression (Comma expression)+ ;                                              // Comma operator
expression returns [Expression expressionRet]:
    id=Identifier                       { $expressionRet = new IdentifierExpr(id.getText()); }
  | c=Constant                          { $expressionRet = new ConstantExpr(c.getText()); }
  | sl+=StringLiteral+                  { $expressionRet = new StringLiteralExpr(sl.getText()); }

  | LeftParen e1=expression RightParen  { $expressionRet = e1.expressionRet; }

  | LeftParen t1=typeName RightParen LeftBrace il1=initializerList Comma? RightBrace
        {
            $expressionRet = new CompoundLiteralExpr();
            $expressionRet.setTypeName(t1.typeNameRet);
            $expressionRet.setInitializerList(il1.initializerListRet);
        }

  | e2=expression LeftBracket e3=expression RightBracket
        {
            $expressionRet = new ArrayIndexExpr();
            $expressionRet.setArray(e2.expressionRet);
            $expressionRet.setIndex(e3.expressionRet);
        }

  | e4=expression LeftParen al=argumentExpressionList? RightParen
        {
            $expressionRet = new FunctionCallExpr();
            $expressionRet.setFunctionExpr(e4.expressionRet);
            if (al != null) $expressionRet.setArguments(al.argumentExpressionListRet);
        }

  | e5=expression PlusPlus
        { $expressionRet = new PostfixIncExpr(e5.expressionRet); }

  | e6=expression MinusMinus
        { $expressionRet = new PostfixDecExpr(e6.expressionRet); }

  | ops+=(PlusPlus|MinusMinus|Sizeof)*
        (
          id2=Identifier                { $expressionRet = new IdentifierExpr(id2.getText()); }
        | c2=Constant                   { $expressionRet = new ConstantExpr(c2.getText()); }
        | sl2+=StringLiteral+           { $expressionRet = new StringLiteralExpr(sl2.getText()); }
        | LeftParen e7=expression RightParen
              { $expressionRet = e7.expressionRet; }
        | LeftParen t2=typeName RightParen LeftBrace il2=initializerList Comma? RightBrace
              {
                  $expressionRet = new CompoundLiteralExpr();
                  $expressionRet.setTypeName(t2.typeNameRet);
                  $expressionRet.setInitializerList(il2.initializerListRet);
              }
        | uop=unaryOperator ce=castExpression
              {
                  $expressionRet = new UnaryOpExpr();
                  $expressionRet.setOperator(uop.unaryOperatorRet);
                  $expressionRet.setOperand(ce.castExpressionRet);
              }
        | Sizeof LeftParen t3=typeName RightParen
              {
                  $expressionRet = new SizeofTypeExpr(t3.typeNameRet);
              }
        )
        {
            for (TerminalNode op : $ops) {
                if (op.getText().equals("++"))
                    $expressionRet = new PrefixIncExpr($expressionRet);
                else if (op.getText().equals("--"))
                    $expressionRet = new PrefixDecExpr($expressionRet);
                else
                    $expressionRet = new SizeofExpr($expressionRet);
            }
        }

  | LeftParen t4=typeName RightParen ce2=castExpression
        {
            $expressionRet = new CastExpression();
            $expressionRet.setTypeName(t4.typeNameRet);
            $expressionRet.setCastExpression(ce2.castExpressionRet);
        }

  | e8=expression op1=(Star|Div|Mod) e9=expression
        {
            $expressionRet = new BinaryOpExpr();
            $expressionRet.setLeft(e8.expressionRet);
            $expressionRet.setOperator(op1.getText());
            $expressionRet.setRight(e9.expressionRet);
        }

  | e10=expression op2=(Plus|Minus) e11=expression
        {
            $expressionRet = new BinaryOpExpr();
            $expressionRet.setLeft(e10.expressionRet);
            $expressionRet.setOperator(op2.getText());
            $expressionRet.setRight(e11.expressionRet);
        }

  | e12=expression op3=(LeftShift|RightShift) e13=expression
        {
            $expressionRet = new BinaryOpExpr();
            $expressionRet.setLeft(e12.expressionRet);
            $expressionRet.setOperator(op3.getText());
            $expressionRet.setRight(e13.expressionRet);
        }

  | e14=expression op4=(Less|Greater|LessEqual|GreaterEqual) e15=expression
        {
            $expressionRet = new BinaryOpExpr();
            $expressionRet.setLeft(e14.expressionRet);
            $expressionRet.setOperator(op4.getText());
            $expressionRet.setRight(e15.expressionRet);
        }

  | e16=expression op5=(Equal|NotEqual) e17=expression
        {
            $expressionRet = new BinaryOpExpr();
            $expressionRet.setLeft(e16.expressionRet);
            $expressionRet.setOperator(op5.getText());
            $expressionRet.setRight(e17.expressionRet);
        }

  | e18=expression And e19=expression
        {
            $expressionRet = new BinaryOpExpr();
            $expressionRet.setLeft(e18.expressionRet);
            $expressionRet.setOperator("&");
            $expressionRet.setRight(e19.expressionRet);
        }

  | e20=expression Xor e21=expression
        {
            $expressionRet = new BinaryOpExpr();
            $expressionRet.setLeft(e20.expressionRet);
            $expressionRet.setOperator("^");
            $expressionRet.setRight(e21.expressionRet);
        }

  | e22=expression Or e23=expression
        {
            $expressionRet = new BinaryOpExpr();
            $expressionRet.setLeft(e22.expressionRet);
            $expressionRet.setOperator("|");
            $expressionRet.setRight(e23.expressionRet);
        }

  | e24=expression AndAnd e25=expression
        {
            $expressionRet = new BinaryOpExpr();
            $expressionRet.setLeft(e24.expressionRet);
            $expressionRet.setOperator("&&");
            $expressionRet.setRight(e25.expressionRet);
        }

  | e26=expression OrOr e27=expression
        {
            $expressionRet = new BinaryOpExpr();
            $expressionRet.setLeft(e26.expressionRet);
            $expressionRet.setOperator("||");
            $expressionRet.setRight(e27.expressionRet);
        }

  | e28=expression Question e29=expression Colon e30=expression
        {
            $expressionRet = new ConditionalExpr();
            $expressionRet.setCondition(e28.expressionRet);
            $expressionRet.setThenExpr(e29.expressionRet);
            $expressionRet.setElseExpr(e30.expressionRet);
        }

  | e31=expression ao=assignmentOperator e32=expression
        {
            $expressionRet = new AssignmentExpr();
            $expressionRet.setLeft(e31.expressionRet);
            $expressionRet.setOperator(ao.assignmentOperatorRet);
            $expressionRet.setRight(e32.expressionRet);
        }

  | e33=expression (Comma e34=expression)+
        {
            $expressionRet = new CommaExpr();
            $expressionRet.addExpression(e33.expressionRet);
            for (ExpressionContext ctx : $e34) $expressionRet.addExpression(ctx.expressionRet);
        }
;


argumentExpressionList returns [ArgumentExpressionList argumentExpressionListRet]:
    { $argumentExpressionListRet = new ArgumentExpressionList(); }
    e=expression { $argumentExpressionListRet.addExpression(e.exprRet); }
    ( Comma e2=expression { $argumentExpressionListRet.addExpression(e2.exprRet); })*
;

unaryOperator returns [UnaryOperator unaryOperatorRet]:
    op=(And | Star | Plus | Minus | Tilde | Not)
    { $unaryOperatorRet = UnaryOperator.valueOf(op.getText()); }
;

castExpression returns [CastExpression castExpressionRet]:
    { $castExpressionRet = new CastExpression(); }
    LeftParen t=typeName    { $castExpressionRet.setTypeName(t.typeNameRet); }
    RightParen ce=castExpression { $castExpressionRet.setCastExpression(ce.castExpressionRet); }
  | e=expression           { $castExpressionRet = e.expressionRet; }
  | ds=DigitSequence       { $castExpressionRet = new IntVal(Integer.parseInt(ds.getText())); }
;


//assignmentOperator
//  : Assign | StarAssign | DivAssign | ModAssign | PlusAssign | MinusAssign | LeftShiftAssign | RightShiftAssign | AndAssign | XorAssign | OrAssign ;
assignmentOperator returns [AssignmentOperator assignmentOperatorRet]:
    { $assignmentOperatorRet = new AssignmentOperator(); }
    op=Assign           { $assignmentOperatorRet.setAssignmentOperator(op.getText()); }
  | op=StarAssign      { $assignmentOperatorRet.setAssignmentOperator(op.getText()); }
  | op=DivAssign       { $assignmentOperatorRet.setAssignmentOperator(op.getText()); }
  | op=ModAssign       { $assignmentOperatorRet.setAssignmentOperator(op.getText()); }
  | op=PlusAssign      { $assignmentOperatorRet.setAssignmentOperator(op.getText()); }
  | op=MinusAssign     { $assignmentOperatorRet.setAssignmentOperator(op.getText()); }
  | op=LeftShiftAssign { $assignmentOperatorRet.setAssignmentOperator(op.getText()); }
  | op=RightShiftAssign{ $assignmentOperatorRet.setAssignmentOperator(op.getText()); }
  | op=AndAssign       { $assignmentOperatorRet.setAssignmentOperator(op.getText()); }
  | op=XorAssign       { $assignmentOperatorRet.setAssignmentOperator(op.getText()); }
  | op=OrAssign        { $assignmentOperatorRet.setAssignmentOperator(op.getText()); }
;

//declaration
//    : declarationSpecifiers initDeclaratorList? Semi ;
declaration returns [Declaration declarationRet]:
    { $declarationRet = new Declaration(); }
    ds=declarationSpecifiers
        { $declarationRet.setDeclarationSpecifiers(ds.declarationSpecifiersRet); }
    ( il=initDeclaratorList { $declarationRet.setInitDeclaratorList(il.initDeclaratorListRet); })?
    Semi
;

//declarationSpecifiers
//    : declarationSpecifier+ ;
declarationSpecifiers returns [DeclarationSpecifiers declarationSpecifiersRet]:
    { $declarationSpecifiersRet = new DeclarationSpecifiers(); }
    ( ds=declarationSpecifier { $declarationSpecifiersRet.addDeclarationSpecifier(ds.declarationSpecifierRet); })+
;


//declarationSpecifier
//    : Typedef | typeSpecifier | Const ;
declarationSpecifier returns [DeclarationSpecifier declarationSpecifierRet]:
    ts=typeSpecifier
        { $declarationSpecifierRet = ts.typeSpecifierRet; }
  | Typedef
        { $declarationSpecifierRet = new TypedefSpecifier(); }
  | Const
        { $declarationSpecifierRet = new ConstSpecifier(); }
;

//initDeclaratorList
//    : initDeclarator (Comma initDeclarator)* ;
initDeclaratorList returns [InitDeclaratorList initDeclaratorListRet]:
    { $initDeclaratorListRet = new InitDeclaratorList(); }
    i=initDeclarator { $initDeclaratorListRet.addInitDeclarator(i.initDeclaratorRet); }
    ( Comma i2=initDeclarator { $initDeclaratorListRet.addInitDeclarator(i2.initDeclaratorRet); })*
;

//initDeclarator
//    : declarator (Assign initializer)? ;
initDeclarator returns [InitDeclarator initDeclaratorRet]:
    { $initDeclaratorRet = new InitDeclarator(); }
    d=declarator
        { $initDeclaratorRet.setDeclarator(d.declaratorRet); }
    ( Assign i=initializer
        { $initDeclaratorRet.setInitializer(i.initializerRet); }
    )?
;

//typeSpecifier
//    : Void | Char | Short | Int | Long | Float | Double | Signed | Unsigned | Bool | Identifier ;
typeSpecifier returns [TypeSpecifier typeSpecifierRet]:
    { $typeSpecifierRet = new TypeSpecifier(); }
    v=Void           { $typeSpecifierRet.setVoid(v.getText()); }
  | c=Char           { $typeSpecifierRet.setChar(c.getText()); }
  | s=Short          { $typeSpecifierRet.setShort(s.getText()); }
  | i=Int            { $typeSpecifierRet.setInt(i.getText()); }
  | l=Long           { $typeSpecifierRet.setLong(l.getText()); }
  | f=Float          { $typeSpecifierRet.setFloat(f.getText()); }
  | d=Double         { $typeSpecifierRet.setDouble(d.getText()); }
  | si=Signed        { $typeSpecifierRet.setSigned(si.getText()); }
  | u=Unsigned       { $typeSpecifierRet.setUnsigned(u.getText()); }
  | b=Bool           { $typeSpecifierRet.setBool(b.getText()); }
  | id=Identifier    { $typeSpecifierRet.setIdentifier(id.getText()); }
;

//specifierQualifierList
//    : (typeSpecifier | Const) specifierQualifierList? ;
specifierQualifierList returns [SpecifierQualifierList specifierQualifierListRet]:
    { $specifierQualifierListRet = new SpecifierQualifierList(); }
    ( ts=typeSpecifier { $specifierQualifierListRet.setTypeSpecifier(ts.typeSpecifierRet); }
    | c=Const         { $specifierQualifierListRet.setConst(c.getText()); })
    ( sq=specifierQualifierList { $specifierQualifierListRet.setSpecifierQualifierList(sq.specifierQualifierListRet); } )?
;

//declarator
//    : pointer? directDeclarator ;
declarator returns [Declarator declaratorRet]:
    { $declaratorRet = new Declarator(); }
    ( p=pointer               { $declaratorRet.setPointer(p.pointerRet); } )?
    d=directDeclarator        { $declaratorRet.setDirectDeclarator(d.directDeclaratorRet); }
;

//directDeclarator
//    : Identifier
//    | LeftParen declarator RightParen
//    | directDeclarator LeftBracket expression? RightBracket
//    | directDeclarator LeftParen  (parameterList | identifierList?) RightParen ;
directDeclarator returns [DirectDeclarator directDeclaratorRet]:
    { $directDeclaratorRet = new DirectDeclarator(); }
    id=Identifier { $directDeclaratorRet.setIdentifier(id.getText()); }
    | LeftParen d=declarator { $directDeclaratorRet.setDeclarator(d.declaratorRet); } RightParen
    | dd=directDeclarator { $directDeclaratorRet.setDirectDeclarator(dd.directDeclaratorRet); } LeftBracket
    ( e=expression { $directDeclaratorRet.setExpression(e.expressionRet); } )? RightBracket
    | dd2=directDeclarator { $directDeclaratorRet.setDirectDeclarator(dd2.directDeclaratorRet); }
    LeftParen ( pl=parameterList { $directDeclaratorRet.setParameterList(pl.parameterListRet); }
              | ( il=identifierList { $directDeclaratorRet.setIdentifierList(il.identifierListRet); })? )
    RightParen
;

//pointer
//    : ((Star) (Const+)?)+ ;
pointer returns [Pointer pointerRet]:
    { $pointerRet = new Pointer(); }
    (
    s=Star { $pointerRet.addStar(); }
    ( c=Const { $pointerRet.addConst(c.getText()); } )*
    )+
;

//parameterList
//    : parameterDeclaration (Comma parameterDeclaration)* ;
parameterList returns [ParameterList parameterListRet]:
    { $parameterListRet = new ParameterList(); }
    pd=parameterDeclaration { $parameterListRet.addParameterDeclaration(pd.parameterDeclarationRet); }
    ( Comma pd2=parameterDeclaration { $parameterListRet.addParameterDeclaration(pd2.parameterDeclarationRet); })*
;

//parameterDeclaration
//    : declarationSpecifiers (declarator | abstractDeclarator?) ;
parameterDeclaration returns [ParameterDeclaration parameterDeclarationRet]:
    { $parameterDeclarationRet = new ParameterDeclaration(); }
    ds=declarationSpecifiers { $parameterDeclarationRet.setDeclarationSpecifiers(ds.declarationSpecifiersRet); }
        ( d=declarator { $parameterDeclarationRet.setDeclarator(d.declaratorRet); }
        | ( ad=abstractDeclarator { $parameterDeclarationRet.setAbstractDeclarator(ad.abstractDeclaratorRet); })?)
;

//identifierList
//    : Identifier (Comma Identifier)* ;
identifierList returns [IdentifierList identifierListRet]:
    { $identifierListRet = new IdentifierList(); }
    id=Identifier { $identifierListRet.addIdentifier(id.getText()); }
    ( Comma id2=Identifier { $identifierListRet.addIdentifier(id2.getText()); })*
;

//typeName
//    : specifierQualifierList abstractDeclarator? ;
typeName returns [TypeName typeNameRet]:
    { $typeNameRet = new TypeName(); }
    sq=specifierQualifierList { $typeNameRet.setSpecifierQualifierList(sq.specifierQualifierListRet); }
    ( ad=abstractDeclarator { $typeNameRet.setAbstractDeclarator(ad.abstractDeclaratorRet); } )?
;

//abstractDeclarator
//    : pointer | pointer? directAbstractDeclarator ;
abstractDeclarator returns [AbstractDeclarator abstractDeclaratorRet]:
    { $abstractDeclaratorRet = new AbstractDeclarator(); }
    p=pointer { $abstractDeclaratorRet.setPointer(p.pointerRet); }
  | ( p2=pointer { $abstractDeclaratorRet.setPointer(p2.pointerRet); } )?
    da=directAbstractDeclarator { $abstractDeclaratorRet.setDirectAbstractDeclarator(da.directAbstractDeclaratorRet); }
;

//directAbstractDeclarator
//    : LeftBracket expression? RightBracket
//    | LeftParen  (abstractDeclarator | parameterList?) RightParen
//    | directAbstractDeclarator LeftBracket expression? RightBracket
//    | directAbstractDeclarator LeftParen parameterList? RightParen ;
directAbstractDeclarator returns [DirectAbstractDeclarator directAbstractDeclaratorRet]:
    { $directAbstractDeclaratorRet = new DirectAbstractDeclarator(); }
    LeftBracket ( e=expression { $directAbstractDeclaratorRet.setExpression(e.expressionRet); } )? RightBracket
  | { $directAbstractDeclaratorRet = new DirectAbstractDeclarator(); }
    LeftParen ( ad=abstractDeclarator { $directAbstractDeclaratorRet.setAbstractDeclarator(ad.abstractDeclaratorRet); }
                | ( pl=parameterList     { $directAbstractDeclaratorRet.setParameterList(pl.parameterListRet); } )? ) RightParen
  | dd=directAbstractDeclarator { $directAbstractDeclaratorRet = new DirectAbstractDeclarator();
  $directAbstractDeclaratorRet.setDirectAbstractDeclarator(dd.directAbstractDeclaratorRet); }
  LeftBracket ( ex=expression { $directAbstractDeclaratorRet.setExpression(ex.expressionRet); } )? RightBracket
  | dd2=directAbstractDeclarator { $directAbstractDeclaratorRet = new DirectAbstractDeclarator();
  $directAbstractDeclaratorRet.setDirectAbstractDeclarator(dd2.directAbstractDeclaratorRet); }
  LeftParen ( pl2=parameterList { $directAbstractDeclaratorRet.setParameterList(pl2.parameterListRet); } )? RightParen
;

//initializer
//    : expression | LeftBrace initializerList Comma? RightBrace ;
initializer returns [Initializer initializerRet]:
    { $initializerRet = new Initializer(); }
    e=expression { $initializerRet.setExpression(e.expressionRet); }
  | { $initializerRet = new Initializer(); }
    LeftBrace il=initializerList { $initializerRet.setInitializerList(il.initializerListRet); } ( Comma )? RightBrace
;

//initializerList
//    : designation? initializer (Comma designation? initializer)* ;
initializerList returns [InitializerList initializerListRet]:
    { $initializerListRet = new InitializerList(); }
    ( d1=designation  { $initializerListRet.addDesignation(d1.designationRet); } )?
    i1=initializer     { $initializerListRet.addInitializer(i1.initializerRet); }
    ( Comma ( d2=designation { $initializerListRet.addDesignation(d2.designationRet); } )?
      i2=initializer  { $initializerListRet.addInitializer(i2.initializerRet); } )*
;

//designation
//    : designator+ Assign ;
designation returns [Designation designationRet]:
    { $designationRet = new Designation(); }
    ( d=designator { $designationRet.addDesignator(d.designatorRet); } )+ Assign
;

//designator
//    : LeftBracket expression RightBracket | Dot Identifier ;
designator returns [Designator designatorRet]:
    { $designatorRet = new Designator(); }
    LeftBracket e=expression { $designatorRet.setExpression(e.expressionRet); } RightBracket
  | Dot id=Identifier { $designatorRet.setIdentifier(id.getText()); }
;

//statement
//    : compoundStatement | expressionStatement | selectionStatement | iterationStatement | jumpStatement ;
statement returns [Statement statementRet]:
    { $statementRet = new Statement(); }
    cs=compoundStatement
        { $statementRet.setCompoundStatement(cs.compoundStatementRet); }
  | es=expressionStatement
        { $statementRet.setExpressionStatement(es.expressionStatementRet); }
  | ss=selectionStatement
        { $statementRet.setSelectionStatement(ss.selectionStatementRet); }
  | is=iterationStatement
        { $statementRet.setIterationStatement(is.iterationStatementRet); }
  | js=jumpStatement
        { $statementRet.setJumpStatement(js.jumpStatementRet); }
;


//compoundStatement
//    : LeftBrace (blockItem+)? RightBrace ;
compoundStatement returns [CompoundStatement compoundStatementRet]:
    { $compoundStatementRet = new CompoundStatement(); }
    LeftBrace
        ( bi=blockItem { $compoundStatementRet.addBlockItem(bi.blockItemRet); } )*
    RightBrace
;

//blockItem
//    : statement | declaration ;
blockItem returns [BlockItem blockItemRet]:
    { $blockItemRet = new BlockItem(); }
    st=statement     { $blockItemRet.setStatement(st.statementRet); }
  | de=declaration   { $blockItemRet.setDeclaration(de.declarationRet); }
;

//expressionStatement
//    : expression? Semi ;
expressionStatement returns [ExpressionStatement expressionStatementRet]:
    { $expressionStatementRet = new ExpressionStatement(); }
    ( e=expression { $expressionStatementRet.setExpression(e.expressionRet); } )?
    Semi
;

//selectionStatement
//    : If LeftParen expression RightParen statement (Else statement)? ;
selectionStatement returns [SelectionStatement selectionStatementRet]:
    { $selectionStatementRet = new SelectionStatement(); }
    If
    LeftParen  e=expression  { $selectionStatementRet.setExpression(e.expressionRet); }  RightParen
    st=statement             { $selectionStatementRet.setStatement(st.statementRet); }
    ( Else st2=statement     { $selectionStatementRet.setElseStatement(st2.statementRet); } )?
;

//iterationStatement
//    : While LeftParen expression RightParen statement
//    | Do statement While LeftParen expression RightParen Semi
//    | For LeftParen forCondition RightParen statement ;
iterationStatement returns [IterationStatement iterationStatementRet]:
    { $iterationStatementRet = new IterationStatement(); }
    While LeftParen e=expression   { $iterationStatementRet.setExpression(e.expressionRet); }
    RightParen st=statement        { $iterationStatementRet.setStatement(st.statementRet); }
  | { $iterationStatementRet = new IterationStatement(); }
    Do st2=statement               { $iterationStatementRet.setStatement(st2.statementRet); }
    While LeftParen e2=expression  { $iterationStatementRet.setExpression(e2.expressionRet); }
    RightParen Semi
  | { $iterationStatementRet = new IterationStatement(); }
    For LeftParen fc=forCondition  { $iterationStatementRet.setForCondition(fc.forConditionRet); }
    RightParen st3=statement       { $iterationStatementRet.setStatement(st3.statementRet); }
;

//forCondition
//    : (forDeclaration | expression?) Semi forExpression? Semi forExpression? ;
forCondition returns [ForCondition forConditionRet]:
    { $forConditionRet = new ForCondition(); }

    (
        fd=forDeclaration           { $forConditionRet.setForDeclaration(fd.forDeclarationRet); }
      | ( e0=expression             { $forConditionRet.setInitExpression(e0.expressionRet); } )?
    )
    Semi
    ( fe1=forExpression             { $forConditionRet.setFirstExpression(fe1.forExpressionRet); } )?
    Semi
    ( fe2=forExpression             { $forConditionRet.setSecondExpression(fe2.forExpressionRet); } )?
;

//forDeclaration
//    : declarationSpecifiers initDeclaratorList? ;
forDeclaration returns [ForDeclaration forDeclarationRet]:
    { $forDeclarationRet = new ForDeclaration(); }
    ds=declarationSpecifiers  { $forDeclarationRet.setDeclarationSpecifiers(ds.declarationSpecifiersRet); }
    ( il=initDeclaratorList   { $forDeclarationRet.setInitDeclaratorList(il.initDeclaratorListRet); } )?
;

//forExpression
//    : expression (Comma expression)* ;
forExpression returns [ForExpression forExpressionRet]:
    { $forExpressionRet = new ForExpression(); }
    e=expression
        { $forExpressionRet.addExpression(e.expressionRet); }
    ( Comma e2=expression
        { $forExpressionRet.addExpression(e2.expressionRet); }
    )*
;

//jumpStatement
//    : ( Continue | Break | Return expression? ) Semi ;
jumpStatement returns [JumpStatement jumpStatementRet]:

    c=Continue
        { $jumpStatementRet = new ContinueJumpStatement(); }
    Semi

  | b=Break
        { $jumpStatementRet = new BreakJumpStatement(); }
    Semi

  | r=Return
        { $jumpStatementRet = new ReturnJumpStatement(); }
        ( e=expression { ((ReturnJumpStatement)$jumpStatementRet).setExpression(e.expressionRet); } )?
    Semi
;

Break                 : 'break'                 ;
Char                  : 'char'                  ;
Const                 : 'const'                 ;
Continue              : 'continue'              ;
Do                    : 'do'                    ;
Double                : 'double'                ;
Else                  : 'else'                  ;
Float                 : 'float'                 ;
For                   : 'for'                   ;
If                    : 'if'                    ;
Int                   : 'int'                   ;
Long                  : 'long'                  ;
Return                : 'return'                ;
Short                 : 'short'                 ;
Signed                : 'signed'                ;
Sizeof                : 'sizeof'                ;
Switch                : 'switch'                ;
Typedef               : 'typedef'               ;
Unsigned              : 'unsigned'              ;
Void                  : 'void'                  ;
While                 : 'while'                 ;
Bool                  : 'bool'                  ;
LeftParen             : '('                     ;
RightParen            : ')'                     ;
LeftBracket           : '['                     ;
RightBracket          : ']'                     ;
LeftBrace             : '{'                     ;
RightBrace            : '}'                     ;
Less                  : '<'                     ;
LessEqual             : '<='                    ;
Greater               : '>'                     ;
GreaterEqual          : '>='                    ;
LeftShift             : '<<'                    ;
RightShift            : '>>'                    ;
Plus                  : '+'                     ;
PlusPlus              : '++'                    ;
Minus                 : '-'                     ;
MinusMinus            : '--'                    ;
Star                  : '*'                     ;
Div                   : '/'                     ;
Mod                   : '%'                     ;
And                   : '&'                     ;
Or                    : '|'                     ;
AndAnd                : '&&'                    ;
OrOr                  : '||'                    ;
Xor                   : '^'                     ;
Not                   : '!'                     ;
Tilde                 : '~'                     ;
Question              : '?'                     ;
Colon                 : ':'                     ;
Semi                  : ';'                     ;
Comma                 : ','                     ;
Assign                : '='                     ;
StarAssign            : '*='                    ;
DivAssign             : '/='                    ;
ModAssign             : '%='                    ;
PlusAssign            : '+='                    ;
MinusAssign           : '-='                    ;
LeftShiftAssign       : '<<='                   ;
RightShiftAssign      : '>>='                   ;
AndAssign             : '&='                    ;
XorAssign             : '^='                    ;
OrAssign              : '|='                    ;
Equal                 : '=='                    ;
NotEqual              : '!='                    ;
Arrow                 : '->'                    ;
Dot                   : '.'                     ;

Identifier
    : IdentifierNondigit (IdentifierNondigit | Digit)* ;

fragment IdentifierNondigit
    : Nondigit | UniversalCharacterName ;

fragment Nondigit
    : [a-zA-Z_] ;

fragment Digit
    : [0-9] ;

fragment UniversalCharacterName
    : '\\u' HexQuad | '\\U' HexQuad HexQuad ;

fragment HexQuad
    : HexadecimalDigit HexadecimalDigit HexadecimalDigit HexadecimalDigit ;

Constant
    : IntegerConstant | FloatingConstant | CharacterConstant ;

fragment IntegerConstant
    : DecimalConstant IntegerSuffix?
    | OctalConstant IntegerSuffix?
    | HexadecimalConstant IntegerSuffix?
    | BinaryConstant ;

fragment BinaryConstant
    : '0' [bB] [0-1]+ ;

fragment DecimalConstant
    : NonzeroDigit Digit* ;

fragment OctalConstant
    : '0' OctalDigit* ;

fragment HexadecimalConstant
    : HexadecimalPrefix HexadecimalDigit+ ;

fragment HexadecimalPrefix
    : '0' [xX] ;

fragment NonzeroDigit
    : [1-9] ;

fragment OctalDigit
    : [0-7] ;

fragment HexadecimalDigit
    : [0-9a-fA-F] ;

fragment IntegerSuffix
    : UnsignedSuffix LongSuffix? | UnsignedSuffix LongLongSuffix | LongSuffix UnsignedSuffix? | LongLongSuffix UnsignedSuffix? ;

fragment UnsignedSuffix
    : [uU] ;

fragment LongSuffix
    : [lL] ;

fragment LongLongSuffix
    : 'll' | 'LL' ;

fragment FloatingConstant
    : DecimalFloatingConstant | HexadecimalFloatingConstant ;

fragment DecimalFloatingConstant
    : FractionalConstant ExponentPart? FloatingSuffix? | DigitSequence ExponentPart FloatingSuffix? ;

fragment HexadecimalFloatingConstant
    : HexadecimalPrefix (HexadecimalFractionalConstant | HexadecimalDigitSequence) BinaryExponentPart FloatingSuffix? ;

fragment FractionalConstant
    : DigitSequence? Dot DigitSequence | DigitSequence Dot ;

fragment ExponentPart
    : [eE] Sign? DigitSequence ;

fragment Sign
    : [+-] ;

DigitSequence
    : Digit+ ;

fragment HexadecimalFractionalConstant
    : HexadecimalDigitSequence? Dot HexadecimalDigitSequence | HexadecimalDigitSequence Dot ;

fragment BinaryExponentPart
    : [pP] Sign? DigitSequence ;

fragment HexadecimalDigitSequence
    : HexadecimalDigit+ ;

fragment FloatingSuffix
    : [flFL] ;

fragment CharacterConstant
    : '\'' CCharSequence '\'' | 'L\'' CCharSequence '\''| 'u\'' CCharSequence '\'' | 'U\'' CCharSequence '\''
    ;

fragment CCharSequence
    : CChar+ ;

fragment CChar
    : ~['\\\r\n] | EscapeSequence ;

fragment EscapeSequence
    : SimpleEscapeSequence | OctalEscapeSequence | HexadecimalEscapeSequence | UniversalCharacterName ;

fragment SimpleEscapeSequence
    : '\\' ['"?abfnrtv\\] ;

fragment OctalEscapeSequence
    : '\\' OctalDigit OctalDigit? OctalDigit? ;

fragment HexadecimalEscapeSequence
    : '\\x' HexadecimalDigit+ ;

StringLiteral
    : EncodingPrefix? '"' SCharSequence? '"' ;

fragment EncodingPrefix
    : 'u8' | 'u' | 'U' | 'L' ;

fragment SCharSequence
    : SChar+ ;

fragment SChar
    : ~["\\\r\n] | EscapeSequence | '\\\n' | '\\\r\n' ;

MultiLineMacro
    : '#' (~[\n]*? '\\' '\r'? '\n')+ ~ [\n]+ -> channel(HIDDEN) ;

Directive
    : '#' ~[\n]* -> channel(HIDDEN) ;

Whitespace
    : [ \t]+ -> channel(HIDDEN) ;

Newline
    : ('\r' '\n'? | '\n') -> channel(HIDDEN) ;

BlockComment
    : '/*' .*? '*/' -> channel(HIDDEN) ;

LineComment
    : '//' ~[\r\n]* -> channel(HIDDEN) ;