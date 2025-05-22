grammar SimpleLang;

@header {
    import main.ast.baseNodes_DIR.*;
    import main.ast.declaration_DIR.*;
    import main.ast.expression_DIR.*;
    import main.ast.literal_DIR.*;
    import main.ast.statement_DIR.*;
}

// Entry point of the grammar, defines a program structure.
program
	returns[Program programRet]:
	{$programRet = new Program();} (
		tu = translationUnit {$programRet.setTranslationUnit($tu.translationUnitRet);}
	)? EOF;

// A translation unit consists of one or more external declarations.
translationUnit
	returns[TranslationUnit translationUnitRet]:
	{$translationUnitRet = new TranslationUnit();} (
		extDecl = externalDeclaration {$translationUnitRet.addExternalDeclaration($extDecl.externalDeclarationRet);
			}
	)+;

// An external declaration can be a function definition, a global declaration, or a stray semicolon.
externalDeclaration
	returns[ExternalDeclaration externalDeclarationRet]:
	funcDef = functionDefinition {
            $externalDeclarationRet = new ExternalDeclaration();
            $externalDeclarationRet.setFunctionDefinition($funcDef.functionDefinitionRet);
        }
	| decl = declaration {
            $externalDeclarationRet = new ExternalDeclaration();
            $externalDeclarationRet.setDeclaration($decl.declarationRet);
            $externalDeclarationRet.setLine($decl.declarationRet.getLine());
        }
	| {$externalDeclarationRet = new ExternalDeclaration();} Semi; // stray ;

// Defines a function, including optional declaration specifiers, a declarator, optional C89-style
// K&R declaration list, and a compound statement (body).
functionDefinition
	returns[FunctionDefinition functionDefinitionRet]:
	{$functionDefinitionRet = new FunctionDefinition();} (
		declSpecs = declarationSpecifiers {$functionDefinitionRet.setDecSpecifiers($declSpecs.declarationSpecifiersRet);
			}
	)? declaratorNode = declarator {$functionDefinitionRet.setDeclarator($declaratorNode.declaratorRet); $functionDefinitionRet.setLine($declaratorNode.declaratorRet.getLine());
		} (
		k_and_r_decls = declarationList {$functionDefinitionRet.setDecList($k_and_r_decls.decListRet);
			}
	)? body = compoundStatement {$functionDefinitionRet.setCompoundStatement($body.compoundStatementRet);
		};

// A list of declarations, typically used for K&R style function parameter declarations.
declarationList
	returns[DecList decListRet]:
	{$decListRet = new DecList();} (
		decl = declaration {$decListRet.addDeclaration($decl.declarationRet);}
	)+;

// Defines various forms of expressions, maintaining C operator precedence.
expression
	returns[Expression expressionRet]:
	identifierToken = Identifier {$expressionRet = new Identifier($identifierToken.text); $expressionRet.setLine($identifierToken.line);
		}
	| constantToken = Constant {$expressionRet = new Constant($constantToken.text); $expressionRet.setLine($constantToken.line);
		}
	| stringLiteralSequence = StringLiteral+ {$expressionRet = new Identifier($stringLiteralSequence.text); $expressionRet.notFirst();
		}
	| LeftParen parenExpression = expression {$expressionRet = $parenExpression.expressionRet; $parenExpression.expressionRet.notFirst();
		} RightParen
	// Compound literal: (type_name){initializer_list}
	| LeftParen compoundType = typeName RightParen LeftBrace compoundInitializer = initializerList {$expressionRet = new TIExpression($compoundType.typeNameRet, $compoundInitializer.initializerListRet);
		} Comma? RightBrace
	// Array indexing: expression[expression]
	| e1 = expression LeftBracket e2 = expression RightBracket {$expressionRet = new ArrayIndexing($e1.expressionRet, $e2.expressionRet);  $e1.expressionRet.notFirst(); $e2.expressionRet.notFirst();
		}
	// Function call: expression(argument_expression_list?)
	| fe = expression {$expressionRet = new FuncCall($fe.expressionRet); $expressionRet.notFirst();
		} LeftParen (
		fa = argumentExpressionList {$expressionRet.setArgExpression($fa.argExpressionRet); $fa.argExpressionRet.notFirstExpression();
			}
	)? RightParen
	// Postfix increment: expression++
	| ue = expression pp = PlusPlus {$expressionRet = new UnaryExpression($ue.expressionRet, $pp.text); $expressionRet.setLine($pp.line);  $ue.expressionRet.notFirst();
		}
	// Postfix decrement: expression--
	| ue2 = expression mm = MinusMinus {$expressionRet = new UnaryExpression($ue2.expressionRet, $mm.text); $expressionRet.setLine($mm.line);   $ue2.expressionRet.notFirst();
		}
	// Prefix expressions: ++expr, --expr, sizeof expr, &expr, *expr, +expr, -expr, ~expr, !expr, sizeof(type)
	| {PrefixExpression pe = new PrefixExpression();} (
		pp = PlusPlus {pe.addOp($pp.text);}
		| mm = MinusMinus {pe.addOp($mm.text);}
		| s = Sizeof {pe.addOp($s.text);}
	)* (
		// Operand of the prefix expression
		id = Identifier {pe.setIdentifier($id.text);}
		| c = Constant {pe.setConstant($c.text);}
		| StringLiteral+ // String literals as an operand, raw
		| LeftParen e = expression RightParen {pe.setExpression($e.expressionRet); $e.expressionRet.notFirst();
			}
		| LeftParen t = typeName RightParen LeftBrace i = initializerList {
            pe.setTIExpression(new TIExpression($t.typeNameRet, $i.initializerListRet));
            } Comma? RightBrace
		| u = unaryOperator c1 = castExpression {
            pe.setUnaryOp($u.unaryOpRet);
            pe.setCastExpression($c1.castExpressionRet);
            $c1.castExpressionRet.getExpression().notFirst();
            }
		| Sizeof LeftParen t1 = typeName {pe.setTypeName($t1.typeNameRet); } RightParen
	) {$expressionRet = pe;}
	// Cast expression: (type_name) cast_expression
	| LeftParen t = typeName RightParen ce = castExpression {$expressionRet = new ExpressionCast($t.typeNameRet, $ce.castExpressionRet);
		}
	// Multiplicative operators: *, /, %
	| e1 = expression op = (Star | Div | Mod) e2 = expression {$e1.expressionRet.notFirst(); $e2.expressionRet.notFirst();
		} {$expressionRet = new BinaryExpression($e1.expressionRet, $e2.expressionRet, $op.text); $expressionRet.setLine($op.line);
		}
	// Additive operators: +, -
	| e1 = expression op = (Plus | Minus) e2 = expression {$e1.expressionRet.notFirst(); $e2.expressionRet.notFirst();
		} {$expressionRet = new BinaryExpression($e1.expressionRet, $e2.expressionRet, $op.text); $expressionRet.setLine($op.line);
		}
	// Shift operators: <<, >>
	| e1 = expression op = (LeftShift | RightShift) e2 = expression {$e1.expressionRet.notFirst(); $e2.expressionRet.notFirst();
		} {$expressionRet = new BinaryExpression($e1.expressionRet, $e2.expressionRet, $op.text); $expressionRet.setLine($op.line);
		}
	// Relational operators: <, >, <=, >=
	| e1 = expression op = (
		Less
		| Greater
		| LessEqual
		| GreaterEqual
	) e2 = expression {$e1.expressionRet.notFirst(); $e2.expressionRet.notFirst();} {$expressionRet = new BinaryExpression($e1.expressionRet, $e2.expressionRet, $op.text); $expressionRet.setLine($op.line);
		}
	// Equality operators: ==, !=
	| e1 = expression op = (Equal | NotEqual) e2 = expression {$e1.expressionRet.notFirst(); $e2.expressionRet.notFirst();
		} {$expressionRet = new BinaryExpression($e1.expressionRet, $e2.expressionRet, $op.text); $expressionRet.setLine($op.line);
		}
	// Bitwise AND operator: &
	| e1 = expression op = And e2 = expression {$e1.expressionRet.notFirst(); $e2.expressionRet.notFirst();
		} {$expressionRet = new BinaryExpression($e1.expressionRet, $e2.expressionRet, $op.text); $expressionRet.setLine($op.line);
		}
	// Bitwise XOR operator: ^
	| e1 = expression op = Xor e2 = expression {$e1.expressionRet.notFirst(); $e2.expressionRet.notFirst();
		} {$expressionRet = new BinaryExpression($e1.expressionRet, $e2.expressionRet, $op.text); $expressionRet.setLine($op.line);
		}
	// Bitwise OR operator: |
	| e1 = expression op = Or e2 = expression {$e1.expressionRet.notFirst(); $e2.expressionRet.notFirst();
		} {$expressionRet = new BinaryExpression($e1.expressionRet, $e2.expressionRet, $op.text); $expressionRet.setLine($op.line);
		}
	// Logical AND operator: &&
	| e1 = expression op = AndAnd e2 = expression {$e1.expressionRet.notFirst(); $e2.expressionRet.notFirst();
		} {$expressionRet = new BinaryExpression($e1.expressionRet, $e2.expressionRet, $op.text); $expressionRet.setLine($op.line);
		}
	// Logical OR operator: ||
	| e1 = expression op = OrOr e2 = expression {$e1.expressionRet.notFirst(); $e2.expressionRet.notFirst();
		} {$expressionRet = new BinaryExpression($e1.expressionRet, $e2.expressionRet, $op.text); $expressionRet.setLine($op.line);
		}
	// Conditional operator: expr ? expr : expr
	| e1 = expression q = Question e2 = expression Colon e3 = expression {$e1.expressionRet.notFirst(); $e2.expressionRet.notFirst(); $e3.expressionRet.notFirst();
		} {$expressionRet = new CondExpression($e1.expressionRet, $e2.expressionRet, $e3.expressionRet); $expressionRet.setLine($q.line);
		}
	// Assignment operators: =, *=, /=, etc.
	| e1 = expression a = assignmentOperator e2 = expression {$e1.expressionRet.notFirst(); $e2.expressionRet.notFirst();
		} {$expressionRet = new BinaryExpression($e1.expressionRet, $e2.expressionRet, $a.assignmentOpRet); $expressionRet.setLine($a.assignmentOpRet.getLine());
		};

// List of expressions used as arguments in a function call.
argumentExpressionList
	returns[ArgExpression argExpressionRet]:
	firstExpr = expression {$argExpressionRet = new ArgExpression($firstExpr.expressionRet);} (
		Comma nextExpr = expression {$argExpressionRet.addExpression($nextExpr.expressionRet);}
	)*;

// Unary operators like &, *, +, -, ~, !
unaryOperator
	returns[UnaryOperator unaryOpRet]:
	t = And {$unaryOpRet = new UnaryOperator($t.text);}
	| t = Star {$unaryOpRet = new UnaryOperator($t.text);}
	| t = Plus {$unaryOpRet = new UnaryOperator($t.text);}
	| t = Minus {$unaryOpRet = new UnaryOperator($t.text);}
	| t = Tilde {$unaryOpRet = new UnaryOperator($t.text);}
	| t = Not {$unaryOpRet = new UnaryOperator($t.text);};

// Expression being cast, or part of a cast operation. This rule seems to handle explicit casts like
// (type)expr, or can be a simple expression or a number.
castExpression
	returns[CastExpression castExpressionRet]:
	{ $castExpressionRet = new CastExpression(); } LeftParen targetType = typeName { $castExpressionRet.setTypeName($targetType.typeNameRet); 
		} RightParen nestedCastExpr = castExpression { $castExpressionRet.setCastExpression($nestedCastExpr.castExpressionRet); 
		}
	| { $castExpressionRet = new CastExpression(); } simpleExpression = expression { $castExpressionRet.setExpression($simpleExpression.expressionRet); 
		}
	| { $castExpressionRet = new CastExpression(); } numericLiteral = DigitSequence { $castExpressionRet.setNum($numericLiteral.text); 
		};

// Various assignment operators.
assignmentOperator
	returns[AssignmentOp assignmentOpRet]:
	opToken = Assign { $assignmentOpRet = new AssignmentOp($opToken.text); $assignmentOpRet.setLine($opToken.line); 
		}
	| opToken = StarAssign { $assignmentOpRet = new AssignmentOp($opToken.text); $assignmentOpRet.setLine($opToken.line); 
		}
	| opToken = DivAssign { $assignmentOpRet = new AssignmentOp($opToken.text); $assignmentOpRet.setLine($opToken.line); 
		}
	| opToken = ModAssign { $assignmentOpRet = new AssignmentOp($opToken.text); $assignmentOpRet.setLine($opToken.line); 
		}
	| opToken = PlusAssign { $assignmentOpRet = new AssignmentOp($opToken.text); $assignmentOpRet.setLine($opToken.line); 
		}
	| opToken = MinusAssign { $assignmentOpRet = new AssignmentOp($opToken.text); $assignmentOpRet.setLine($opToken.line); 
		}
	| opToken = LeftShiftAssign { $assignmentOpRet = new AssignmentOp($opToken.text); $assignmentOpRet.setLine($opToken.line); 
		}
	| opToken = RightShiftAssign { $assignmentOpRet = new AssignmentOp($opToken.text); $assignmentOpRet.setLine($opToken.line); 
		}
	| opToken = AndAssign { $assignmentOpRet = new AssignmentOp($opToken.text); $assignmentOpRet.setLine($opToken.line); 
		}
	| opToken = XorAssign { $assignmentOpRet = new AssignmentOp($opToken.text); $assignmentOpRet.setLine($opToken.line); 
		}
	| opToken = OrAssign { $assignmentOpRet = new AssignmentOp($opToken.text); $assignmentOpRet.setLine($opToken.line); 
		};

// A declaration, consisting of declaration specifiers and an optional list of init-declarators.
declaration
	returns[Declaration declarationRet]:
	specs = declarationSpecifiers { $declarationRet = new Declaration($specs.declarationSpecifiersRet); 
		} (
		initList = initDeclaratorList { $declarationRet.setInitDecList($initList.initDeclaratorListRet); 
			}
	)? Semi;

// A sequence of declaration specifiers (e.g., type specifiers, typedef, const).
declarationSpecifiers
	returns[DeclarationSpecifiers declarationSpecifiersRet]:
	{ $declarationSpecifiersRet = new DeclarationSpecifiers(); } (
		specifierItem = declarationSpecifier { $declarationSpecifiersRet.addDeclarationSpecifier($specifierItem.declarationSpecifierRet); 
			}
	)+;

// Rule for a single declaration specifier: either typedef, a base type specifier, or const.
declarationSpecifier
	returns[DeclarationSpecifier declarationSpecifierRet]:
	{ $declarationSpecifierRet = new DeclarationSpecifier(); } typedefToken = Typedef { $declarationSpecifierRet.setType($typedefToken.text); 
		}
	| { $declarationSpecifierRet = new DeclarationSpecifier(); } typeSpecNode = typeSpecifier { $declarationSpecifierRet.setTypeSpecifier($typeSpecNode.typeSpecifierRet); 
		}
	| { $declarationSpecifierRet = new DeclarationSpecifier(); } constToken = Const { $declarationSpecifierRet.setType($constToken.text); 
		};

// Rule for a comma-separated list of one or more declarators, each potentially with an initializer.
initDeclaratorList
	returns[InitDeclaratorList initDeclaratorListRet]:
	firstInitDeclarator = initDeclarator { $initDeclaratorListRet = new InitDeclaratorList($firstInitDeclarator.initDeclaratorRet); 
		} (
		Comma nextInitDeclarator = initDeclarator { $initDeclaratorListRet.addInitDeclarator($nextInitDeclarator.initDeclaratorRet); 
			}
	)*;

// Rule for a declarator, optionally followed by an '=' and an initializer.
initDeclarator
	returns[InitDeclarator initDeclaratorRet]:
	declaratorNode = declarator { $initDeclaratorRet = new InitDeclarator($declaratorNode.declaratorRet); 
		} (
		Assign initializerNode = initializer { $initDeclaratorRet.setInitializer($initializerNode.initializerRet); 
			}
	)?;

// Rule for basic type specifiers (e.g., int, char, void) or a typedef name (Identifier).
typeSpecifier
	returns[TypeSpecifier typeSpecifierRet]:
	typeKeyword = Void { $typeSpecifierRet = new TypeSpecifier($typeKeyword.text); }
	| typeKeyword = Char { $typeSpecifierRet = new TypeSpecifier($typeKeyword.text); }
	| typeKeyword = Short { $typeSpecifierRet = new TypeSpecifier($typeKeyword.text); }
	| typeKeyword = Int { $typeSpecifierRet = new TypeSpecifier($typeKeyword.text); }
	| typeKeyword = Long { $typeSpecifierRet = new TypeSpecifier($typeKeyword.text); }
	| typeKeyword = Float { $typeSpecifierRet = new TypeSpecifier($typeKeyword.text); }
	| typeKeyword = Double { $typeSpecifierRet = new TypeSpecifier($typeKeyword.text); }
	| typeKeyword = Signed { $typeSpecifierRet = new TypeSpecifier($typeKeyword.text); }
	| typeKeyword = Unsigned { $typeSpecifierRet = new TypeSpecifier($typeKeyword.text); }
	| typeKeyword = Bool { $typeSpecifierRet = new TypeSpecifier($typeKeyword.text); }
	| typedefNameToken = Identifier // User-defined type name (from typedef)
	{ $typeSpecifierRet = new TypeSpecifier($typedefNameToken.text, true); $typeSpecifierRet.setLine($typedefNameToken.line); 
		};

// Rule for a list of type specifiers (e.g., 'int') and type qualifiers (e.g., 'const').
specifierQualifierList
	returns[SpecifierQualifierList specifierQualifierListRet]:
	{ $specifierQualifierListRet = new SpecifierQualifierList(); } (
		typeSpecNode = typeSpecifier { $specifierQualifierListRet.setTypeSpecifier($typeSpecNode.typeSpecifierRet); 
			}
		| Const // Type qualifier
	) (
		recursiveSpecQualList = specifierQualifierList { $specifierQualifierListRet.setSpecifierQualifierList($recursiveSpecQualList.specifierQualifierListRet); 
			}
	)?;

// Rule for a declarator, which names an entity; can include an optional pointer part and a direct declarator.
declarator
    returns[Declarator declaratorRet]
    :
    { $declaratorRet = new Declarator(); }
    (
        pointerNode = pointer { $declaratorRet.setPointer($pointerNode.pointerRet); }
    )?
    coreDeclarator = directDeclarator
    {
        $declaratorRet.setDirectDec($coreDeclarator.directDecRet);
        $declaratorRet.setLine($coreDeclarator.directDecRet.getLine());
    }
    ;
  
// Rule for the core part of a declarator: an identifier, a parenthesized declarator, an array, or a function.
//directDeclarator
//    returns[DirectDec directDecRet]
//    :
//    { $directDecRet = new DirectDec(); }
//    identifierToken = Identifier
//    { $directDecRet.setIdentifier($identifierToken.text); $directDecRet.setLine($identifierToken.line); }
//    |
//    { $directDecRet = new DirectDec(); }
//    leftParenToken = LeftParen nestedDeclarator = declarator RightParen
//    { $directDecRet.setDeclarator($nestedDeclarator.declaratorRet); $directDecRet.setLine($leftParenToken.line); }
//    |
//    { $directDecRet = new DirectDec(); } // Array declarator
//    arrayBaseDeclarator = directDeclarator
//    { $directDecRet.setDirectDec($arrayBaseDeclarator.directDecRet); }
//    LeftBracket (arraySizeExpr = expression { $directDecRet.setExpression($arraySizeExpr.expressionRet); })? RightBracket
//    |
//    { $directDecRet = new DirectDec(); } // Function declarator
//    funcBaseDeclarator = directDeclarator
//    { $directDecRet.setDirectDec($funcBaseDeclarator.directDecRet); }
//    funcLeftParen = LeftParen
//    (
//        paramList = parameterList { $directDecRet.setParameterList($paramList.parameterListRet); $directDecRet.setLine($funcLeftParen.line); }
//        | (identList = identifierList { $directDecRet.setIdentifierList($identList.identifierListRet); })? // K&R style
//    )
//    RightParen
//    ;
directDeclarator returns [DirectDec directDecRet]
    : {$directDecRet = new DirectDec();} id = Identifier {$directDecRet.setIdentifier($id.text); $directDecRet.setLine($id.line);}
    | {$directDecRet = new DirectDec();} l = LeftParen d = declarator {$directDecRet.setDeclarator($d.declaratorRet); $directDecRet.setLine($l.line);} RightParen
    |  d1 = directDeclarator {$directDecRet = new DirectDec();} {$directDecRet.setDirectDec($d1.directDecRet);}
        LeftBracket (e = expression {$directDecRet.setExpression($e.expressionRet);})? RightBracket
    |  d2 = directDeclarator {$directDecRet = new DirectDec();} {$directDecRet.setDirectDec($d2.directDecRet);}
        l = LeftParen  (p = parameterList {$directDecRet.setParameterList($p.parameterListRet); $directDecRet.setLine($l.line);}
        | (i = identifierList {$directDecRet.setIdentifierList($i.identifierListRet);} )?) RightParen ;


// Rule for a pointer declaration, like '*' or '* const'.
pointer
    returns[Pointer pointerRet]
    :
    { $pointerRet = new Pointer(); }
    (Star Const*)+ // One or more '*' optionally followed by 'const'
    ;

// Rule for a comma-separated list of parameter declarations.
parameterList
    returns[ParameterList parameterListRet]
    :
    firstParameter = parameterDeclaration
    { $parameterListRet = new ParameterList($firstParameter.parameterDecRet); }
    (
        Comma nextParameter = parameterDeclaration
        { $parameterListRet.addParameterDec($nextParameter.parameterDecRet); }
    )*
    ;


// Rule for a single parameter declaration within a function signature.
parameterDeclaration
    returns[ParameterDec parameterDecRet]
    :
    paramTypeSpecs = declarationSpecifiers
    { $parameterDecRet = new ParameterDec($paramTypeSpecs.declarationSpecifiersRet); }
    (
        paramDeclarator = declarator { $parameterDecRet.setDeclarator($paramDeclarator.declaratorRet); }
        | (paramAbstractDeclarator = abstractDeclarator { $parameterDecRet.setAbstractDec($paramAbstractDeclarator.abstractDecRet); })?
    )
    ;

// Rule for a comma-separated list of identifiers, used in K&R C function declarations.
identifierList
    returns[IdentifierList identifierListRet]
    :
    firstIdentifier = Identifier { $identifierListRet = new IdentifierList($firstIdentifier.text); }
    (
        Comma nextIdentifier = Identifier { $identifierListRet.addIdentifier($nextIdentifier.text); }
    )*
    ;

// Rule for a type name, typically used in casts or with sizeof operator.
typeName
    returns[TypeName typeNameRet]
    :
    specQuals = specifierQualifierList
    { $typeNameRet = new TypeName($specQuals.specifierQualifierListRet); }
    (
        absDeclarator = abstractDeclarator { $typeNameRet.setAbstractDec($absDeclarator.abstractDecRet); }
    )?
    ;
// Rule for an abstract declarator, used for type names where no identifier is present (e.g., in casts).
abstractDeclarator
    returns[AbstractDec abstractDecRet]
    :
    { $abstractDecRet = new AbstractDec(); }
    pointerNode = pointer { $abstractDecRet.setPointer($pointerNode.pointerRet); }
    |
    { $abstractDecRet = new AbstractDec(); }
    ( optionalPointerNode = pointer { $abstractDecRet.setPointer($optionalPointerNode.pointerRet); } )?
    directAbsDeclaratorNode = directAbstractDeclarator { $abstractDecRet.setDirectAbsDec($directAbsDeclaratorNode.directAbsDecRet); }
    ;

// Rule for the core part of an abstract declarator: array type, function type, or parenthesized abstract declarator.
//directAbstractDeclarator
//    returns[DirectAbsDec directAbsDecRet]
//    :
//    { $directAbsDecRet = new DirectAbsDec(); } // Abstract array declarator: [ expression? ]
//    LeftBracket (arraySizeExpr = expression { $directAbsDecRet.setExpression($arraySizeExpr.expressionRet); })? RightBracket
//    |
//    { $directAbsDecRet = new DirectAbsDec(); } // Parenthesized abstract declarator or abstract function type: ( abstract_declarator | parameter_list? )
//    LeftParen
//    (
//        nestedAbstractDeclarator = abstractDeclarator { $directAbsDecRet.setAbstractDec($nestedAbstractDeclarator.abstractDecRet); }
//        | (paramList = parameterList { $directAbsDecRet.setParameterList($paramList.parameterListRet); })?
//    )
//    RightParen
//    |
//    { $directAbsDecRet = new DirectAbsDec(); } // Recursive abstract array declarator: direct_abstract_declarator [ expression? ]
//    baseDirectAbstractDeclarator_Array = directAbstractDeclarator
//    { $directAbsDecRet.setDirectAbsDec($baseDirectAbstractDeclarator_Array.directAbsDecRet); }
//    LeftBracket (recursiveArraySizeExpr = expression { $directAbsDecRet.setExpression($recursiveArraySizeExpr.expressionRet); })? RightBracket
//    |
//    { $directAbsDecRet = new DirectAbsDec(); } // Recursive abstract function declarator: direct_abstract_declarator ( parameter_list? )
//    baseDirectAbstractDeclarator_Func = directAbstractDeclarator
//    { $directAbsDecRet.setDirectAbsDec($baseDirectAbstractDeclarator_Func.directAbsDecRet); }
//    LeftParen (recursiveParamList = parameterList { $directAbsDecRet.setParameterList($recursiveParamList.parameterListRet); })? RightParen
//    ;
//

directAbstractDeclarator returns [DirectAbsDec directAbsDecRet]
    : {$directAbsDecRet = new DirectAbsDec();} LeftBracket (e = expression {$directAbsDecRet.setExpression($e.expressionRet);})? RightBracket
    | {$directAbsDecRet = new DirectAbsDec();} LeftParen
     (a = abstractDeclarator {$directAbsDecRet.setAbstractDec($a.abstractDecRet);} |
     (p = parameterList {$directAbsDecRet.setParameterList($p.parameterListRet);})?) RightParen
    |  d = directAbstractDeclarator {$directAbsDecRet = new DirectAbsDec();} {$directAbsDecRet.setDirectAbsDec($d.directAbsDecRet);}
     LeftBracket (e = expression {$directAbsDecRet.setExpression($e.expressionRet);})? RightBracket
    |  d = directAbstractDeclarator {$directAbsDecRet = new DirectAbsDec();} {$directAbsDecRet.setDirectAbsDec($d.directAbsDecRet);}
     LeftParen (p = parameterList {$directAbsDecRet.setParameterList($p.parameterListRet);})? RightParen ;

// Rule for an initializer for a variable or member: either a single expression or a brace-enclosed list.
initializer
    returns[Initializer initializerRet]
    :
    { $initializerRet = new Initializer(); }
    initExpression = expression { $initializerRet.setExpression($initExpression.expressionRet); }
    |
    { $initializerRet = new Initializer(); }
    LeftBrace initItemsList = initializerList { $initializerRet.setInitializerList($initItemsList.initializerListRet); } Comma? RightBrace
    ;
 
// Rule for a comma-separated list of initializers, possibly with C99 designated initializers.
initializerList
    returns[InitializerList initializerListRet]
    :
    { $initializerListRet = new InitializerList(); }
    ( firstDesignation = designation { $initializerListRet.addDesignation($firstDesignation.designationRet); } )?
    firstInitializerItem = initializer { $initializerListRet.addInitializer($firstInitializerItem.initializerRet); }
    (
        Comma
        ( nextDesignation = designation { $initializerListRet.addDesignation($nextDesignation.designationRet); } )?
        nextInitializerItem = initializer { $initializerListRet.addInitializer($nextInitializerItem.initializerRet); }
    )*
    ;
  // Rule for a C99 designated initializer part (e.g., .member = or [index] =).
designation
    returns[Designation designationRet]
    :
    { $designationRet = new Designation(); }
    (
        designatorElement = designator { $designationRet.addDesignator($designatorElement.designatorRet); }
    )+
    Assign
    ;

// Rule for a single designator in a C99 designated initializer: either an array index or a struct/union member.
designator
    returns[Designator designatorRet]
    :
    { $designatorRet = new Designator(); }
    LeftBracket indexValueExpression = expression RightBracket
    { $designatorRet.setExpression($indexValueExpression.expressionRet); }
    |
    Dot memberNameIdentifier = Identifier
    { $designatorRet.setLine($memberNameIdentifier.line); } // Assuming Designator AST node can store line info for dot member
    ;

// Rule for a generic statement, dispatching to specific statement types.
statement
    returns[Statement statementRet]
    :
    compoundStmtNode = compoundStatement { $statementRet = $compoundStmtNode.compoundStatementRet; }
    | exprStmtNode = expressionStatement { $statementRet = $exprStmtNode.expressionStatementRet; }
    | selectionStmtNode = selectionStatement { $statementRet = $selectionStmtNode.selectionStatementRet; }
    | iterationStmtNode = iterationStatement { $statementRet = $iterationStmtNode.iterStatementRet; }
    | jumpStmtNode = jumpStatement { $statementRet = $jumpStmtNode.jumpStatementRet; }
    ;

// Rule for a compound statement (a block of code enclosed in braces {}).
compoundStatement
    returns[CompoundStatement compoundStatementRet]
    :
    { $compoundStatementRet = new CompoundStatement(); }
    LeftBrace
    (
        (
            itemInBlock = blockItem { $compoundStatementRet.addBlockItem($itemInBlock.blockItemRet); }
        )+
    )?
    RightBrace
    ;

// Rule for an item within a block: either a statement or a declaration.
blockItem
    returns[BlockItem blockItemRet]
    :
    { $blockItemRet = new BlockItem(); }
    statementNode = statement { $blockItemRet.setStatement($statementNode.statementRet); }
    |
    { $blockItemRet = new BlockItem(); }
    declarationNode = declaration { $blockItemRet.setDeclaration($declarationNode.declarationRet); }
    ;

// Rule for an expression statement, which is an optional expression followed by a semicolon.
expressionStatement
    returns[ExpressionStatement expressionStatementRet]
    :
    { $expressionStatementRet = new ExpressionStatement(); }
    (
        exprNode = expression { $expressionStatementRet.setExpression($exprNode.expressionRet); }
    )?
    Semi
    ;

// Rule for a selection statement, primarily an if-else construct.
selectionStatement
    returns[SelectionStatement selectionStatementRet]
    :
    ifToken = If LeftParen conditionExpr = expression RightParen thenStatementNode = statement
    {
        $selectionStatementRet = new SelectionStatement($conditionExpr.expressionRet, $thenStatementNode.statementRet);
        $selectionStatementRet.setLine($ifToken.line);
    }
    (
        elseToken = Else elseStatementNode = statement
        {
            $selectionStatementRet.setElseStatement($elseStatementNode.statementRet);
            $selectionStatementRet.setElseLine($elseToken.line);
        }
    )?
    ;

// Rule for iteration statements: while, do-while, and for loops.
iterationStatement
    returns[IterStatement iterStatementRet]
    :
    whileToken = While LeftParen loopConditionExpr = expression RightParen loopBodyStatement = statement
    {
        $iterStatementRet = new IterStatement();
        $iterStatementRet.setExpression($loopConditionExpr.expressionRet);
        $iterStatementRet.setStatement($loopBodyStatement.statementRet);
        $iterStatementRet.setLine($whileToken.line);
        $iterStatementRet.setType($whileToken.text);
    }
    |
    Do doLoopBodyStatement = statement doWhileToken = While LeftParen doLoopConditionExpr = expression RightParen Semi
    {
        $iterStatementRet = new IterStatement();
        $iterStatementRet.setExpression($doLoopConditionExpr.expressionRet);
        $iterStatementRet.setStatement($doLoopBodyStatement.statementRet);
        $iterStatementRet.setLine($doWhileToken.line);
        $iterStatementRet.setType($doWhileToken.text); // Type is 'while' for do-while
    }
    |
    forToken = For LeftParen forLoopConditions = forCondition RightParen forLoopBodyStatement = statement
    {
        $iterStatementRet = new IterStatement();
        $iterStatementRet.setForCondition($forLoopConditions.forConditionRet);
        $iterStatementRet.setStatement($forLoopBodyStatement.statementRet);
        $iterStatementRet.setLine($forToken.line);
        $iterStatementRet.setType($forToken.text);
    }
    ;

// Rule for the three components within a for-loop's parentheses: initialization, condition, and iteration.
forCondition
    returns[ForCondition forConditionRet]
    :
    { $forConditionRet = new ForCondition(); }
    ( // Initialization part
        initDeclarationNode = forDeclaration { $forConditionRet.setForDec($initDeclarationNode.forDecRet); }
        |
        ( initExpressionNode = expression { $forConditionRet.setExpression($initExpressionNode.expressionRet); } )?
    )
    Semi
    ( // Condition part
        conditionExpressionNode = forExpression { $forConditionRet.setForExpression1($conditionExpressionNode.forExpressionRet); }
    )?
    Semi
    ( // Iteration part
        iterationExpressionNode = forExpression { $forConditionRet.setForExpression1($iterationExpressionNode.forExpressionRet); } // AST uses ForExpression1 for iteration too
    )?
    ;
// Rule for the declaration part within a for-loop's initialization (e.g., for(int i=0; ...)).
forDeclaration
    returns[ForDec forDecRet]
    :
    declarationSpecs = declarationSpecifiers
    { $forDecRet = new ForDec($declarationSpecs.declarationSpecifiersRet); }
    (
        initDeclarators = initDeclaratorList
        { $forDecRet.setInitDecList($initDeclarators.initDeclaratorListRet); }
    )?
    ;

// Rule for an expression within a for-loop's condition or iteration part (can be a comma-separated list).
forExpression
    returns[ForExpression forExpressionRet]
    :
    initialExpression = expression
    { $forExpressionRet = new ForExpression($initialExpression.expressionRet); }
    (
        Comma additionalExpr = expression
        { $forExpressionRet.addExpression($additionalExpr.expressionRet); }
    )*
    ;

// Rule for jump statements: continue, break, or return (optionally with an expression).
jumpStatement
    returns[JumpStatement jumpStatementRet]
    :
    { $jumpStatementRet = new JumpStatement(); }
    (
        Continue
        | Break
        | Return
          (
            returnValueExpr = expression { $jumpStatementRet.setReturnExpression($returnValueExpr.expressionRet); }
          )?
    )
    Semi
    ;

// --- LEXER RULES ---

// Keywords
Break: 'break';
Char: 'char';
Const: 'const';
Continue: 'continue';
Do: 'do';
Double: 'double';
Else: 'else';
Float: 'float';
For: 'for';
If: 'if';
Int: 'int';
Long: 'long';
Return: 'return';
Short: 'short';
Signed: 'signed';
Sizeof: 'sizeof';
Switch: 'switch';
Typedef: 'typedef';
Unsigned: 'unsigned';
Void: 'void';
While: 'while';
Bool: 'bool';

// Punctuation and Operators
LeftParen: '(';
RightParen: ')';
LeftBracket: '[';
RightBracket: ']';
LeftBrace: '{';
RightBrace: '}';
Less: '<';
LessEqual: '<=';
Greater: '>';
GreaterEqual: '>=';
LeftShift: '<<';
RightShift: '>>';
Plus: '+';
PlusPlus: '++';
Minus: '-';
MinusMinus: '--';
Star: '*';
Div: '/';
Mod: '%';
And: '&';
Or: '|';
AndAnd: '&&';
OrOr: '||';
Xor: '^';
Not: '!';
Tilde: '~';
Question: '?';
Colon: ':';
Semi: ';';
Comma: ',';
Assign: '=';
StarAssign: '*=';
DivAssign: '/=';
ModAssign: '%=';
PlusAssign: '+=';
MinusAssign: '-=';
LeftShiftAssign: '<<=';
RightShiftAssign: '>>=';
AndAssign: '&=';
XorAssign: '^=';
OrAssign: '|=';
Equal: '==';
NotEqual: '!=';
Arrow: '->';
Dot: '.';

// Identifier
Identifier: IdentifierNondigit (IdentifierNondigit | Digit)*;

fragment IdentifierNondigit: Nondigit | UniversalCharacterName;

fragment Nondigit: [a-zA-Z_];

fragment Digit: [0-9];

fragment UniversalCharacterName:
	'\\u' HexQuad
	| '\\U' HexQuad HexQuad;

fragment HexQuad:
	HexadecimalDigit HexadecimalDigit HexadecimalDigit HexadecimalDigit;

// Constants (Numeric and Character)
Constant:
	IntegerConstant
	| FloatingConstant
	| CharacterConstant;

fragment IntegerConstant:
	DecimalConstant IntegerSuffix?
	| OctalConstant IntegerSuffix?
	| HexadecimalConstant IntegerSuffix?
	| BinaryConstant;

fragment BinaryConstant: '0' [bB] [0-1]+;

fragment DecimalConstant: NonzeroDigit Digit*;

fragment OctalConstant: '0' OctalDigit*;

fragment HexadecimalConstant:
	HexadecimalPrefix HexadecimalDigit+;

fragment HexadecimalPrefix: '0' [xX];

fragment NonzeroDigit: [1-9];

fragment OctalDigit: [0-7];

fragment HexadecimalDigit: [0-9a-fA-F];

fragment IntegerSuffix:
	UnsignedSuffix LongSuffix?
	| UnsignedSuffix LongLongSuffix
	| LongSuffix UnsignedSuffix?
	| LongLongSuffix UnsignedSuffix?;

fragment UnsignedSuffix: [uU];

fragment LongSuffix: [lL];

fragment LongLongSuffix: 'll' | 'LL';

fragment FloatingConstant:
	DecimalFloatingConstant
	| HexadecimalFloatingConstant;

fragment DecimalFloatingConstant:
	FractionalConstant ExponentPart? FloatingSuffix?
	| DigitSequence ExponentPart FloatingSuffix?;

fragment HexadecimalFloatingConstant:
	HexadecimalPrefix (
		HexadecimalFractionalConstant
		| HexadecimalDigitSequence
	) BinaryExponentPart FloatingSuffix?;

fragment FractionalConstant:
	DigitSequence? Dot DigitSequence
	| DigitSequence Dot;

fragment ExponentPart: [eE] Sign? DigitSequence;

fragment Sign: [+-];


// A sequence of one or more digits. This is a lexer rule. It's used by castExpression and also as a
// fragment in FloatingConstant.
DigitSequence: Digit+;

fragment HexadecimalFractionalConstant:
	HexadecimalDigitSequence? Dot HexadecimalDigitSequence
	| HexadecimalDigitSequence Dot;

fragment BinaryExponentPart: [pP] Sign? DigitSequence;

fragment HexadecimalDigitSequence: HexadecimalDigit+;

fragment FloatingSuffix: [flFL];

fragment CharacterConstant:
	'\'' CCharSequence '\''
	| 'L\'' CCharSequence '\'' // Wide character constant
	| 'u\'' CCharSequence '\'' // UTF-16 character constant
	| 'U\'' CCharSequence '\''; // UTF-32 character constant

fragment CCharSequence: CChar+;

fragment CChar: ~['\\\r\n] | EscapeSequence;

fragment EscapeSequence:
	SimpleEscapeSequence
	| OctalEscapeSequence
	| HexadecimalEscapeSequence
	| UniversalCharacterName;

fragment SimpleEscapeSequence: '\\' ['"?abfnrtv\\];

fragment OctalEscapeSequence:
	'\\' OctalDigit OctalDigit? OctalDigit?;

fragment HexadecimalEscapeSequence: '\\x' HexadecimalDigit+;

// String Literals
StringLiteral: EncodingPrefix? '"' SCharSequence? '"';

fragment EncodingPrefix: 'u8' | 'u' | 'U' | 'L';

fragment SCharSequence: SChar+;

fragment SChar: ~["\\\r\n] | EscapeSequence | '\\\n' | '\\\r\n';

// Preprocessor directives and comments (sent to hidden channel)
MultiLineMacro:
	'#' (~[\n]*? '\\' '\r'? '\n')+ ~ [\n]+ -> channel(HIDDEN);

Directive: '#' ~[\n]* -> channel(HIDDEN);

Whitespace: [ \t]+ -> channel(HIDDEN);

Newline: ('\r' '\n'? | '\n') -> channel(HIDDEN);

BlockComment: '/*' .*? '*/' -> channel(HIDDEN);

LineComment: '//' ~[\r\n]* -> channel(HIDDEN);