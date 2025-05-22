// Generated from C:/Users/mosta/github-classroom/PLC-UT/phase-2-ce-mostafa-kermaninia/src/main/grammar/SimpleLang.g4 by ANTLR 4.13.2
package main.grammar;

    import main.ast.baseNodes_DIR.*;
    import main.ast.declaration_DIR.*;
    import main.ast.expression_DIR.*;
    import main.ast.literal_DIR.*;
    import main.ast.statement_DIR.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class SimpleLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Break=1, Char=2, Const=3, Continue=4, Do=5, Double=6, Else=7, Float=8, 
		For=9, If=10, Int=11, Long=12, Return=13, Short=14, Signed=15, Sizeof=16, 
		Switch=17, Typedef=18, Unsigned=19, Void=20, While=21, Bool=22, LeftParen=23, 
		RightParen=24, LeftBracket=25, RightBracket=26, LeftBrace=27, RightBrace=28, 
		Less=29, LessEqual=30, Greater=31, GreaterEqual=32, LeftShift=33, RightShift=34, 
		Plus=35, PlusPlus=36, Minus=37, MinusMinus=38, Star=39, Div=40, Mod=41, 
		And=42, Or=43, AndAnd=44, OrOr=45, Xor=46, Not=47, Tilde=48, Question=49, 
		Colon=50, Semi=51, Comma=52, Assign=53, StarAssign=54, DivAssign=55, ModAssign=56, 
		PlusAssign=57, MinusAssign=58, LeftShiftAssign=59, RightShiftAssign=60, 
		AndAssign=61, XorAssign=62, OrAssign=63, Equal=64, NotEqual=65, Arrow=66, 
		Dot=67, Identifier=68, Constant=69, DigitSequence=70, StringLiteral=71, 
		MultiLineMacro=72, Directive=73, Whitespace=74, Newline=75, BlockComment=76, 
		LineComment=77;
	public static final int
		RULE_program = 0, RULE_translationUnit = 1, RULE_externalDeclaration = 2, 
		RULE_functionDefinition = 3, RULE_declarationList = 4, RULE_expression = 5, 
		RULE_argumentExpressionList = 6, RULE_unaryOperator = 7, RULE_castExpression = 8, 
		RULE_assignmentOperator = 9, RULE_declaration = 10, RULE_declarationSpecifiers = 11, 
		RULE_declarationSpecifier = 12, RULE_initDeclaratorList = 13, RULE_initDeclarator = 14, 
		RULE_typeSpecifier = 15, RULE_specifierQualifierList = 16, RULE_declarator = 17, 
		RULE_directDeclarator = 18, RULE_pointer = 19, RULE_parameterList = 20, 
		RULE_parameterDeclaration = 21, RULE_identifierList = 22, RULE_typeName = 23, 
		RULE_abstractDeclarator = 24, RULE_directAbstractDeclarator = 25, RULE_initializer = 26, 
		RULE_initializerList = 27, RULE_designation = 28, RULE_designator = 29, 
		RULE_statement = 30, RULE_compoundStatement = 31, RULE_blockItem = 32, 
		RULE_expressionStatement = 33, RULE_selectionStatement = 34, RULE_iterationStatement = 35, 
		RULE_forCondition = 36, RULE_forDeclaration = 37, RULE_forExpression = 38, 
		RULE_jumpStatement = 39;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "translationUnit", "externalDeclaration", "functionDefinition", 
			"declarationList", "expression", "argumentExpressionList", "unaryOperator", 
			"castExpression", "assignmentOperator", "declaration", "declarationSpecifiers", 
			"declarationSpecifier", "initDeclaratorList", "initDeclarator", "typeSpecifier", 
			"specifierQualifierList", "declarator", "directDeclarator", "pointer", 
			"parameterList", "parameterDeclaration", "identifierList", "typeName", 
			"abstractDeclarator", "directAbstractDeclarator", "initializer", "initializerList", 
			"designation", "designator", "statement", "compoundStatement", "blockItem", 
			"expressionStatement", "selectionStatement", "iterationStatement", "forCondition", 
			"forDeclaration", "forExpression", "jumpStatement"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'break'", "'char'", "'const'", "'continue'", "'do'", "'double'", 
			"'else'", "'float'", "'for'", "'if'", "'int'", "'long'", "'return'", 
			"'short'", "'signed'", "'sizeof'", "'switch'", "'typedef'", "'unsigned'", 
			"'void'", "'while'", "'bool'", "'('", "')'", "'['", "']'", "'{'", "'}'", 
			"'<'", "'<='", "'>'", "'>='", "'<<'", "'>>'", "'+'", "'++'", "'-'", "'--'", 
			"'*'", "'/'", "'%'", "'&'", "'|'", "'&&'", "'||'", "'^'", "'!'", "'~'", 
			"'?'", "':'", "';'", "','", "'='", "'*='", "'/='", "'%='", "'+='", "'-='", 
			"'<<='", "'>>='", "'&='", "'^='", "'|='", "'=='", "'!='", "'->'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Break", "Char", "Const", "Continue", "Do", "Double", "Else", "Float", 
			"For", "If", "Int", "Long", "Return", "Short", "Signed", "Sizeof", "Switch", 
			"Typedef", "Unsigned", "Void", "While", "Bool", "LeftParen", "RightParen", 
			"LeftBracket", "RightBracket", "LeftBrace", "RightBrace", "Less", "LessEqual", 
			"Greater", "GreaterEqual", "LeftShift", "RightShift", "Plus", "PlusPlus", 
			"Minus", "MinusMinus", "Star", "Div", "Mod", "And", "Or", "AndAnd", "OrOr", 
			"Xor", "Not", "Tilde", "Question", "Colon", "Semi", "Comma", "Assign", 
			"StarAssign", "DivAssign", "ModAssign", "PlusAssign", "MinusAssign", 
			"LeftShiftAssign", "RightShiftAssign", "AndAssign", "XorAssign", "OrAssign", 
			"Equal", "NotEqual", "Arrow", "Dot", "Identifier", "Constant", "DigitSequence", 
			"StringLiteral", "MultiLineMacro", "Directive", "Whitespace", "Newline", 
			"BlockComment", "LineComment"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SimpleLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpleLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Program programRet;
		public TranslationUnitContext tu;
		public TerminalNode EOF() { return getToken(SimpleLangParser.EOF, 0); }
		public TranslationUnitContext translationUnit() {
			return getRuleContext(TranslationUnitContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ProgramContext)_localctx).programRet =  new Program();
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2252349583972684L) != 0) || _la==Identifier) {
				{
				setState(81);
				((ProgramContext)_localctx).tu = translationUnit();
				_localctx.programRet.setTranslationUnit(((ProgramContext)_localctx).tu.translationUnitRet);
				}
			}

			setState(86);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TranslationUnitContext extends ParserRuleContext {
		public TranslationUnit translationUnitRet;
		public ExternalDeclarationContext extDecl;
		public List<ExternalDeclarationContext> externalDeclaration() {
			return getRuleContexts(ExternalDeclarationContext.class);
		}
		public ExternalDeclarationContext externalDeclaration(int i) {
			return getRuleContext(ExternalDeclarationContext.class,i);
		}
		public TranslationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_translationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterTranslationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitTranslationUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitTranslationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TranslationUnitContext translationUnit() throws RecognitionException {
		TranslationUnitContext _localctx = new TranslationUnitContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_translationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((TranslationUnitContext)_localctx).translationUnitRet =  new TranslationUnit();
			setState(92); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(89);
				((TranslationUnitContext)_localctx).extDecl = externalDeclaration();
				_localctx.translationUnitRet.addExternalDeclaration(((TranslationUnitContext)_localctx).extDecl.externalDeclarationRet);
							
				}
				}
				setState(94); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2252349583972684L) != 0) || _la==Identifier );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExternalDeclarationContext extends ParserRuleContext {
		public ExternalDeclaration externalDeclarationRet;
		public FunctionDefinitionContext funcDef;
		public DeclarationContext decl;
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode Semi() { return getToken(SimpleLangParser.Semi, 0); }
		public ExternalDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_externalDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterExternalDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitExternalDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitExternalDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExternalDeclarationContext externalDeclaration() throws RecognitionException {
		ExternalDeclarationContext _localctx = new ExternalDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_externalDeclaration);
		try {
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				((ExternalDeclarationContext)_localctx).funcDef = functionDefinition();

				            ((ExternalDeclarationContext)_localctx).externalDeclarationRet =  new ExternalDeclaration();
				            _localctx.externalDeclarationRet.setFunctionDefinition(((ExternalDeclarationContext)_localctx).funcDef.functionDefinitionRet);
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				((ExternalDeclarationContext)_localctx).decl = declaration();

				            ((ExternalDeclarationContext)_localctx).externalDeclarationRet =  new ExternalDeclaration();
				            _localctx.externalDeclarationRet.setDeclaration(((ExternalDeclarationContext)_localctx).decl.declarationRet);
				            _localctx.externalDeclarationRet.setLine(((ExternalDeclarationContext)_localctx).decl.declarationRet.getLine());
				        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				((ExternalDeclarationContext)_localctx).externalDeclarationRet =  new ExternalDeclaration();
				setState(103);
				match(Semi);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDefinitionContext extends ParserRuleContext {
		public FunctionDefinition functionDefinitionRet;
		public DeclarationSpecifiersContext declSpecs;
		public DeclaratorContext declaratorNode;
		public DeclarationListContext k_and_r_decls;
		public CompoundStatementContext body;
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public DeclarationListContext declarationList() {
			return getRuleContext(DeclarationListContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((FunctionDefinitionContext)_localctx).functionDefinitionRet =  new FunctionDefinition();
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(107);
				((FunctionDefinitionContext)_localctx).declSpecs = declarationSpecifiers();
				_localctx.functionDefinitionRet.setDecSpecifiers(((FunctionDefinitionContext)_localctx).declSpecs.declarationSpecifiersRet);
							
				}
				break;
			}
			setState(112);
			((FunctionDefinitionContext)_localctx).declaratorNode = declarator();
			_localctx.functionDefinitionRet.setDeclarator(((FunctionDefinitionContext)_localctx).declaratorNode.declaratorRet); _localctx.functionDefinitionRet.setLine(((FunctionDefinitionContext)_localctx).declaratorNode.declaratorRet.getLine());
					
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6084940L) != 0) || _la==Identifier) {
				{
				setState(114);
				((FunctionDefinitionContext)_localctx).k_and_r_decls = declarationList();
				_localctx.functionDefinitionRet.setDecList(((FunctionDefinitionContext)_localctx).k_and_r_decls.decListRet);
							
				}
			}

			setState(119);
			((FunctionDefinitionContext)_localctx).body = compoundStatement();
			_localctx.functionDefinitionRet.setCompoundStatement(((FunctionDefinitionContext)_localctx).body.compoundStatementRet);
					
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationListContext extends ParserRuleContext {
		public DecList decListRet;
		public DeclarationContext decl;
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public DeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDeclarationList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDeclarationList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationListContext declarationList() throws RecognitionException {
		DeclarationListContext _localctx = new DeclarationListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declarationList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((DeclarationListContext)_localctx).decListRet =  new DecList();
			setState(126); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(123);
				((DeclarationListContext)_localctx).decl = declaration();
				_localctx.decListRet.addDeclaration(((DeclarationListContext)_localctx).decl.declarationRet);
				}
				}
				setState(128); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 6084940L) != 0) || _la==Identifier );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Expression expressionRet;
		public ExpressionContext e1;
		public ExpressionContext fe;
		public ExpressionContext ue;
		public ExpressionContext ue2;
		public Token identifierToken;
		public Token constantToken;
		public Token stringLiteralSequence;
		public ExpressionContext parenExpression;
		public TypeNameContext compoundType;
		public InitializerListContext compoundInitializer;
		public Token pp;
		public Token mm;
		public Token s;
		public Token id;
		public Token c;
		public ExpressionContext e;
		public TypeNameContext t;
		public InitializerListContext i;
		public UnaryOperatorContext u;
		public CastExpressionContext c1;
		public TypeNameContext t1;
		public CastExpressionContext ce;
		public Token op;
		public ExpressionContext e2;
		public Token q;
		public ExpressionContext e3;
		public AssignmentOperatorContext a;
		public ArgumentExpressionListContext fa;
		public TerminalNode Identifier() { return getToken(SimpleLangParser.Identifier, 0); }
		public TerminalNode Constant() { return getToken(SimpleLangParser.Constant, 0); }
		public List<TerminalNode> StringLiteral() { return getTokens(SimpleLangParser.StringLiteral); }
		public TerminalNode StringLiteral(int i) {
			return getToken(SimpleLangParser.StringLiteral, i);
		}
		public TerminalNode LeftParen() { return getToken(SimpleLangParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(SimpleLangParser.RightParen, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LeftBrace() { return getToken(SimpleLangParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(SimpleLangParser.RightBrace, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public InitializerListContext initializerList() {
			return getRuleContext(InitializerListContext.class,0);
		}
		public TerminalNode Comma() { return getToken(SimpleLangParser.Comma, 0); }
		public List<TerminalNode> Sizeof() { return getTokens(SimpleLangParser.Sizeof); }
		public TerminalNode Sizeof(int i) {
			return getToken(SimpleLangParser.Sizeof, i);
		}
		public UnaryOperatorContext unaryOperator() {
			return getRuleContext(UnaryOperatorContext.class,0);
		}
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public List<TerminalNode> PlusPlus() { return getTokens(SimpleLangParser.PlusPlus); }
		public TerminalNode PlusPlus(int i) {
			return getToken(SimpleLangParser.PlusPlus, i);
		}
		public List<TerminalNode> MinusMinus() { return getTokens(SimpleLangParser.MinusMinus); }
		public TerminalNode MinusMinus(int i) {
			return getToken(SimpleLangParser.MinusMinus, i);
		}
		public TerminalNode Star() { return getToken(SimpleLangParser.Star, 0); }
		public TerminalNode Div() { return getToken(SimpleLangParser.Div, 0); }
		public TerminalNode Mod() { return getToken(SimpleLangParser.Mod, 0); }
		public TerminalNode Plus() { return getToken(SimpleLangParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(SimpleLangParser.Minus, 0); }
		public TerminalNode LeftShift() { return getToken(SimpleLangParser.LeftShift, 0); }
		public TerminalNode RightShift() { return getToken(SimpleLangParser.RightShift, 0); }
		public TerminalNode Less() { return getToken(SimpleLangParser.Less, 0); }
		public TerminalNode Greater() { return getToken(SimpleLangParser.Greater, 0); }
		public TerminalNode LessEqual() { return getToken(SimpleLangParser.LessEqual, 0); }
		public TerminalNode GreaterEqual() { return getToken(SimpleLangParser.GreaterEqual, 0); }
		public TerminalNode Equal() { return getToken(SimpleLangParser.Equal, 0); }
		public TerminalNode NotEqual() { return getToken(SimpleLangParser.NotEqual, 0); }
		public TerminalNode And() { return getToken(SimpleLangParser.And, 0); }
		public TerminalNode Xor() { return getToken(SimpleLangParser.Xor, 0); }
		public TerminalNode Or() { return getToken(SimpleLangParser.Or, 0); }
		public TerminalNode AndAnd() { return getToken(SimpleLangParser.AndAnd, 0); }
		public TerminalNode OrOr() { return getToken(SimpleLangParser.OrOr, 0); }
		public TerminalNode Colon() { return getToken(SimpleLangParser.Colon, 0); }
		public TerminalNode Question() { return getToken(SimpleLangParser.Question, 0); }
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(SimpleLangParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(SimpleLangParser.RightBracket, 0); }
		public ArgumentExpressionListContext argumentExpressionList() {
			return getRuleContext(ArgumentExpressionListContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(131);
				((ExpressionContext)_localctx).identifierToken = match(Identifier);
				((ExpressionContext)_localctx).expressionRet =  new Identifier((((ExpressionContext)_localctx).identifierToken!=null?((ExpressionContext)_localctx).identifierToken.getText():null)); _localctx.expressionRet.setLine((((ExpressionContext)_localctx).identifierToken!=null?((ExpressionContext)_localctx).identifierToken.getLine():0));
						
				}
				break;
			case 2:
				{
				setState(133);
				((ExpressionContext)_localctx).constantToken = match(Constant);
				((ExpressionContext)_localctx).expressionRet =  new Constant((((ExpressionContext)_localctx).constantToken!=null?((ExpressionContext)_localctx).constantToken.getText():null)); _localctx.expressionRet.setLine((((ExpressionContext)_localctx).constantToken!=null?((ExpressionContext)_localctx).constantToken.getLine():0));
						
				}
				break;
			case 3:
				{
				setState(136); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(135);
						((ExpressionContext)_localctx).stringLiteralSequence = match(StringLiteral);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(138); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				((ExpressionContext)_localctx).expressionRet =  new Identifier((((ExpressionContext)_localctx).stringLiteralSequence!=null?((ExpressionContext)_localctx).stringLiteralSequence.getText():null)); _localctx.expressionRet.notFirst();
						
				}
				break;
			case 4:
				{
				setState(141);
				match(LeftParen);
				setState(142);
				((ExpressionContext)_localctx).parenExpression = expression(0);
				((ExpressionContext)_localctx).expressionRet =  ((ExpressionContext)_localctx).parenExpression.expressionRet; ((ExpressionContext)_localctx).parenExpression.expressionRet.notFirst();
						
				setState(144);
				match(RightParen);
				}
				break;
			case 5:
				{
				setState(146);
				match(LeftParen);
				setState(147);
				((ExpressionContext)_localctx).compoundType = typeName();
				setState(148);
				match(RightParen);
				setState(149);
				match(LeftBrace);
				setState(150);
				((ExpressionContext)_localctx).compoundInitializer = initializerList();
				((ExpressionContext)_localctx).expressionRet =  new TIExpression(((ExpressionContext)_localctx).compoundType.typeNameRet, ((ExpressionContext)_localctx).compoundInitializer.initializerListRet);
						
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(152);
					match(Comma);
					}
				}

				setState(155);
				match(RightBrace);
				}
				break;
			case 6:
				{
				PrefixExpression pe = new PrefixExpression();
				setState(166);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						setState(164);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case PlusPlus:
							{
							setState(158);
							((ExpressionContext)_localctx).pp = match(PlusPlus);
							pe.addOp((((ExpressionContext)_localctx).pp!=null?((ExpressionContext)_localctx).pp.getText():null));
							}
							break;
						case MinusMinus:
							{
							setState(160);
							((ExpressionContext)_localctx).mm = match(MinusMinus);
							pe.addOp((((ExpressionContext)_localctx).mm!=null?((ExpressionContext)_localctx).mm.getText():null));
							}
							break;
						case Sizeof:
							{
							setState(162);
							((ExpressionContext)_localctx).s = match(Sizeof);
							pe.addOp((((ExpressionContext)_localctx).s!=null?((ExpressionContext)_localctx).s.getText():null));
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						} 
					}
					setState(168);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				}
				setState(204);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(169);
					((ExpressionContext)_localctx).id = match(Identifier);
					pe.setIdentifier((((ExpressionContext)_localctx).id!=null?((ExpressionContext)_localctx).id.getText():null));
					}
					break;
				case 2:
					{
					setState(171);
					((ExpressionContext)_localctx).c = match(Constant);
					pe.setConstant((((ExpressionContext)_localctx).c!=null?((ExpressionContext)_localctx).c.getText():null));
					}
					break;
				case 3:
					{
					setState(174); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(173);
							match(StringLiteral);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(176); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				case 4:
					{
					setState(178);
					match(LeftParen);
					setState(179);
					((ExpressionContext)_localctx).e = expression(0);
					setState(180);
					match(RightParen);
					pe.setExpression(((ExpressionContext)_localctx).e.expressionRet); ((ExpressionContext)_localctx).e.expressionRet.notFirst();
								
					}
					break;
				case 5:
					{
					setState(183);
					match(LeftParen);
					setState(184);
					((ExpressionContext)_localctx).t = typeName();
					setState(185);
					match(RightParen);
					setState(186);
					match(LeftBrace);
					setState(187);
					((ExpressionContext)_localctx).i = initializerList();

					            pe.setTIExpression(new TIExpression(((ExpressionContext)_localctx).t.typeNameRet, ((ExpressionContext)_localctx).i.initializerListRet));
					            
					setState(190);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Comma) {
						{
						setState(189);
						match(Comma);
						}
					}

					setState(192);
					match(RightBrace);
					}
					break;
				case 6:
					{
					setState(194);
					((ExpressionContext)_localctx).u = unaryOperator();
					setState(195);
					((ExpressionContext)_localctx).c1 = castExpression();

					            pe.setUnaryOp(((ExpressionContext)_localctx).u.unaryOpRet);
					            pe.setCastExpression(((ExpressionContext)_localctx).c1.castExpressionRet);
					            ((ExpressionContext)_localctx).c1.castExpressionRet.getExpression().notFirst();
					            
					}
					break;
				case 7:
					{
					setState(198);
					match(Sizeof);
					setState(199);
					match(LeftParen);
					setState(200);
					((ExpressionContext)_localctx).t1 = typeName();
					pe.setTypeName(((ExpressionContext)_localctx).t1.typeNameRet); 
					setState(202);
					match(RightParen);
					}
					break;
				}
				((ExpressionContext)_localctx).expressionRet =  pe;
				}
				break;
			case 7:
				{
				setState(207);
				match(LeftParen);
				setState(208);
				((ExpressionContext)_localctx).t = typeName();
				setState(209);
				match(RightParen);
				setState(210);
				((ExpressionContext)_localctx).ce = castExpression();
				((ExpressionContext)_localctx).expressionRet =  new ExpressionCast(((ExpressionContext)_localctx).t.typeNameRet, ((ExpressionContext)_localctx).ce.castExpressionRet);
						
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(312);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(310);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(215);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(216);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3848290697216L) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(217);
						((ExpressionContext)_localctx).e2 = expression(13);
						((ExpressionContext)_localctx).e1.expressionRet.notFirst(); ((ExpressionContext)_localctx).e2.expressionRet.notFirst();
						          		
						((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).e1.expressionRet, ((ExpressionContext)_localctx).e2.expressionRet, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)); _localctx.expressionRet.setLine((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getLine():0));
						          		
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(221);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(222);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Plus || _la==Minus) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(223);
						((ExpressionContext)_localctx).e2 = expression(12);
						((ExpressionContext)_localctx).e1.expressionRet.notFirst(); ((ExpressionContext)_localctx).e2.expressionRet.notFirst();
						          		
						((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).e1.expressionRet, ((ExpressionContext)_localctx).e2.expressionRet, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)); _localctx.expressionRet.setLine((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getLine():0));
						          		
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(227);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(228);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==LeftShift || _la==RightShift) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(229);
						((ExpressionContext)_localctx).e2 = expression(11);
						((ExpressionContext)_localctx).e1.expressionRet.notFirst(); ((ExpressionContext)_localctx).e2.expressionRet.notFirst();
						          		
						((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).e1.expressionRet, ((ExpressionContext)_localctx).e2.expressionRet, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)); _localctx.expressionRet.setLine((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getLine():0));
						          		
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(233);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(234);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8053063680L) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(235);
						((ExpressionContext)_localctx).e2 = expression(10);
						((ExpressionContext)_localctx).e1.expressionRet.notFirst(); ((ExpressionContext)_localctx).e2.expressionRet.notFirst();
						((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).e1.expressionRet, ((ExpressionContext)_localctx).e2.expressionRet, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)); _localctx.expressionRet.setLine((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getLine():0));
						          		
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(239);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(240);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Equal || _la==NotEqual) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(241);
						((ExpressionContext)_localctx).e2 = expression(9);
						((ExpressionContext)_localctx).e1.expressionRet.notFirst(); ((ExpressionContext)_localctx).e2.expressionRet.notFirst();
						          		
						((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).e1.expressionRet, ((ExpressionContext)_localctx).e2.expressionRet, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)); _localctx.expressionRet.setLine((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getLine():0));
						          		
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(245);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(246);
						((ExpressionContext)_localctx).op = match(And);
						setState(247);
						((ExpressionContext)_localctx).e2 = expression(8);
						((ExpressionContext)_localctx).e1.expressionRet.notFirst(); ((ExpressionContext)_localctx).e2.expressionRet.notFirst();
						          		
						((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).e1.expressionRet, ((ExpressionContext)_localctx).e2.expressionRet, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)); _localctx.expressionRet.setLine((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getLine():0));
						          		
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(251);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(252);
						((ExpressionContext)_localctx).op = match(Xor);
						setState(253);
						((ExpressionContext)_localctx).e2 = expression(7);
						((ExpressionContext)_localctx).e1.expressionRet.notFirst(); ((ExpressionContext)_localctx).e2.expressionRet.notFirst();
						          		
						((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).e1.expressionRet, ((ExpressionContext)_localctx).e2.expressionRet, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)); _localctx.expressionRet.setLine((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getLine():0));
						          		
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(257);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(258);
						((ExpressionContext)_localctx).op = match(Or);
						setState(259);
						((ExpressionContext)_localctx).e2 = expression(6);
						((ExpressionContext)_localctx).e1.expressionRet.notFirst(); ((ExpressionContext)_localctx).e2.expressionRet.notFirst();
						          		
						((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).e1.expressionRet, ((ExpressionContext)_localctx).e2.expressionRet, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)); _localctx.expressionRet.setLine((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getLine():0));
						          		
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(263);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(264);
						((ExpressionContext)_localctx).op = match(AndAnd);
						setState(265);
						((ExpressionContext)_localctx).e2 = expression(5);
						((ExpressionContext)_localctx).e1.expressionRet.notFirst(); ((ExpressionContext)_localctx).e2.expressionRet.notFirst();
						          		
						((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).e1.expressionRet, ((ExpressionContext)_localctx).e2.expressionRet, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)); _localctx.expressionRet.setLine((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getLine():0));
						          		
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(269);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(270);
						((ExpressionContext)_localctx).op = match(OrOr);
						setState(271);
						((ExpressionContext)_localctx).e2 = expression(4);
						((ExpressionContext)_localctx).e1.expressionRet.notFirst(); ((ExpressionContext)_localctx).e2.expressionRet.notFirst();
						          		
						((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).e1.expressionRet, ((ExpressionContext)_localctx).e2.expressionRet, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)); _localctx.expressionRet.setLine((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getLine():0));
						          		
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(275);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(276);
						((ExpressionContext)_localctx).q = match(Question);
						setState(277);
						((ExpressionContext)_localctx).e2 = expression(0);
						setState(278);
						match(Colon);
						setState(279);
						((ExpressionContext)_localctx).e3 = expression(3);
						((ExpressionContext)_localctx).e1.expressionRet.notFirst(); ((ExpressionContext)_localctx).e2.expressionRet.notFirst(); ((ExpressionContext)_localctx).e3.expressionRet.notFirst();
						          		
						((ExpressionContext)_localctx).expressionRet =  new CondExpression(((ExpressionContext)_localctx).e1.expressionRet, ((ExpressionContext)_localctx).e2.expressionRet, ((ExpressionContext)_localctx).e3.expressionRet); _localctx.expressionRet.setLine((((ExpressionContext)_localctx).q!=null?((ExpressionContext)_localctx).q.getLine():0));
						          		
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(283);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(284);
						((ExpressionContext)_localctx).a = assignmentOperator();
						setState(285);
						((ExpressionContext)_localctx).e2 = expression(2);
						((ExpressionContext)_localctx).e1.expressionRet.notFirst(); ((ExpressionContext)_localctx).e2.expressionRet.notFirst();
						          		
						((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).e1.expressionRet, ((ExpressionContext)_localctx).e2.expressionRet, ((ExpressionContext)_localctx).a.assignmentOpRet); _localctx.expressionRet.setLine(((ExpressionContext)_localctx).a.assignmentOpRet.getLine());
						          		
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(289);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(290);
						match(LeftBracket);
						setState(291);
						((ExpressionContext)_localctx).e2 = expression(0);
						setState(292);
						match(RightBracket);
						((ExpressionContext)_localctx).expressionRet =  new ArrayIndexing(((ExpressionContext)_localctx).e1.expressionRet, ((ExpressionContext)_localctx).e2.expressionRet);  ((ExpressionContext)_localctx).e1.expressionRet.notFirst(); ((ExpressionContext)_localctx).e2.expressionRet.notFirst();
						          		
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.fe = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(295);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						((ExpressionContext)_localctx).expressionRet =  new FuncCall(((ExpressionContext)_localctx).fe.expressionRet); _localctx.expressionRet.notFirst();
						          		
						setState(297);
						match(LeftParen);
						setState(301);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
							{
							setState(298);
							((ExpressionContext)_localctx).fa = argumentExpressionList();
							_localctx.expressionRet.setArgExpression(((ExpressionContext)_localctx).fa.argExpressionRet); ((ExpressionContext)_localctx).fa.argExpressionRet.notFirstExpression();
							          			
							}
						}

						setState(303);
						match(RightParen);
						}
						break;
					case 15:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.ue = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(304);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(305);
						((ExpressionContext)_localctx).pp = match(PlusPlus);
						((ExpressionContext)_localctx).expressionRet =  new UnaryExpression(((ExpressionContext)_localctx).ue.expressionRet, (((ExpressionContext)_localctx).pp!=null?((ExpressionContext)_localctx).pp.getText():null)); _localctx.expressionRet.setLine((((ExpressionContext)_localctx).pp!=null?((ExpressionContext)_localctx).pp.getLine():0));  ((ExpressionContext)_localctx).ue.expressionRet.notFirst();
						          		
						}
						break;
					case 16:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.ue2 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(307);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(308);
						((ExpressionContext)_localctx).mm = match(MinusMinus);
						((ExpressionContext)_localctx).expressionRet =  new UnaryExpression(((ExpressionContext)_localctx).ue2.expressionRet, (((ExpressionContext)_localctx).mm!=null?((ExpressionContext)_localctx).mm.getText():null)); _localctx.expressionRet.setLine((((ExpressionContext)_localctx).mm!=null?((ExpressionContext)_localctx).mm.getLine():0));   ((ExpressionContext)_localctx).ue2.expressionRet.notFirst();
						          		
						}
						break;
					}
					} 
				}
				setState(314);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentExpressionListContext extends ParserRuleContext {
		public ArgExpression argExpressionRet;
		public ExpressionContext firstExpr;
		public ExpressionContext nextExpr;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLangParser.Comma, i);
		}
		public ArgumentExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentExpressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterArgumentExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitArgumentExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitArgumentExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentExpressionListContext argumentExpressionList() throws RecognitionException {
		ArgumentExpressionListContext _localctx = new ArgumentExpressionListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_argumentExpressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			((ArgumentExpressionListContext)_localctx).firstExpr = expression(0);
			((ArgumentExpressionListContext)_localctx).argExpressionRet =  new ArgExpression(((ArgumentExpressionListContext)_localctx).firstExpr.expressionRet);
			setState(323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(317);
				match(Comma);
				setState(318);
				((ArgumentExpressionListContext)_localctx).nextExpr = expression(0);
				_localctx.argExpressionRet.addExpression(((ArgumentExpressionListContext)_localctx).nextExpr.expressionRet);
				}
				}
				setState(325);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryOperatorContext extends ParserRuleContext {
		public UnaryOperator unaryOpRet;
		public Token t;
		public TerminalNode And() { return getToken(SimpleLangParser.And, 0); }
		public TerminalNode Star() { return getToken(SimpleLangParser.Star, 0); }
		public TerminalNode Plus() { return getToken(SimpleLangParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(SimpleLangParser.Minus, 0); }
		public TerminalNode Tilde() { return getToken(SimpleLangParser.Tilde, 0); }
		public TerminalNode Not() { return getToken(SimpleLangParser.Not, 0); }
		public UnaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterUnaryOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitUnaryOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitUnaryOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOperatorContext unaryOperator() throws RecognitionException {
		UnaryOperatorContext _localctx = new UnaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_unaryOperator);
		try {
			setState(338);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case And:
				enterOuterAlt(_localctx, 1);
				{
				setState(326);
				((UnaryOperatorContext)_localctx).t = match(And);
				((UnaryOperatorContext)_localctx).unaryOpRet =  new UnaryOperator((((UnaryOperatorContext)_localctx).t!=null?((UnaryOperatorContext)_localctx).t.getText():null));
				}
				break;
			case Star:
				enterOuterAlt(_localctx, 2);
				{
				setState(328);
				((UnaryOperatorContext)_localctx).t = match(Star);
				((UnaryOperatorContext)_localctx).unaryOpRet =  new UnaryOperator((((UnaryOperatorContext)_localctx).t!=null?((UnaryOperatorContext)_localctx).t.getText():null));
				}
				break;
			case Plus:
				enterOuterAlt(_localctx, 3);
				{
				setState(330);
				((UnaryOperatorContext)_localctx).t = match(Plus);
				((UnaryOperatorContext)_localctx).unaryOpRet =  new UnaryOperator((((UnaryOperatorContext)_localctx).t!=null?((UnaryOperatorContext)_localctx).t.getText():null));
				}
				break;
			case Minus:
				enterOuterAlt(_localctx, 4);
				{
				setState(332);
				((UnaryOperatorContext)_localctx).t = match(Minus);
				((UnaryOperatorContext)_localctx).unaryOpRet =  new UnaryOperator((((UnaryOperatorContext)_localctx).t!=null?((UnaryOperatorContext)_localctx).t.getText():null));
				}
				break;
			case Tilde:
				enterOuterAlt(_localctx, 5);
				{
				setState(334);
				((UnaryOperatorContext)_localctx).t = match(Tilde);
				((UnaryOperatorContext)_localctx).unaryOpRet =  new UnaryOperator((((UnaryOperatorContext)_localctx).t!=null?((UnaryOperatorContext)_localctx).t.getText():null));
				}
				break;
			case Not:
				enterOuterAlt(_localctx, 6);
				{
				setState(336);
				((UnaryOperatorContext)_localctx).t = match(Not);
				((UnaryOperatorContext)_localctx).unaryOpRet =  new UnaryOperator((((UnaryOperatorContext)_localctx).t!=null?((UnaryOperatorContext)_localctx).t.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CastExpressionContext extends ParserRuleContext {
		public CastExpression castExpressionRet;
		public TypeNameContext targetType;
		public CastExpressionContext nestedCastExpr;
		public ExpressionContext simpleExpression;
		public Token numericLiteral;
		public TerminalNode LeftParen() { return getToken(SimpleLangParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(SimpleLangParser.RightParen, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DigitSequence() { return getToken(SimpleLangParser.DigitSequence, 0); }
		public CastExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterCastExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitCastExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitCastExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastExpressionContext castExpression() throws RecognitionException {
		CastExpressionContext _localctx = new CastExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_castExpression);
		try {
			setState(355);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				 ((CastExpressionContext)_localctx).castExpressionRet =  new CastExpression(); 
				setState(341);
				match(LeftParen);
				setState(342);
				((CastExpressionContext)_localctx).targetType = typeName();
				 _localctx.castExpressionRet.setTypeName(((CastExpressionContext)_localctx).targetType.typeNameRet); 
						
				setState(344);
				match(RightParen);
				setState(345);
				((CastExpressionContext)_localctx).nestedCastExpr = castExpression();
				 _localctx.castExpressionRet.setCastExpression(((CastExpressionContext)_localctx).nestedCastExpr.castExpressionRet); 
						
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				 ((CastExpressionContext)_localctx).castExpressionRet =  new CastExpression(); 
				setState(349);
				((CastExpressionContext)_localctx).simpleExpression = expression(0);
				 _localctx.castExpressionRet.setExpression(((CastExpressionContext)_localctx).simpleExpression.expressionRet); 
						
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				 ((CastExpressionContext)_localctx).castExpressionRet =  new CastExpression(); 
				setState(353);
				((CastExpressionContext)_localctx).numericLiteral = match(DigitSequence);
				 _localctx.castExpressionRet.setNum((((CastExpressionContext)_localctx).numericLiteral!=null?((CastExpressionContext)_localctx).numericLiteral.getText():null)); 
						
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentOperatorContext extends ParserRuleContext {
		public AssignmentOp assignmentOpRet;
		public Token opToken;
		public TerminalNode Assign() { return getToken(SimpleLangParser.Assign, 0); }
		public TerminalNode StarAssign() { return getToken(SimpleLangParser.StarAssign, 0); }
		public TerminalNode DivAssign() { return getToken(SimpleLangParser.DivAssign, 0); }
		public TerminalNode ModAssign() { return getToken(SimpleLangParser.ModAssign, 0); }
		public TerminalNode PlusAssign() { return getToken(SimpleLangParser.PlusAssign, 0); }
		public TerminalNode MinusAssign() { return getToken(SimpleLangParser.MinusAssign, 0); }
		public TerminalNode LeftShiftAssign() { return getToken(SimpleLangParser.LeftShiftAssign, 0); }
		public TerminalNode RightShiftAssign() { return getToken(SimpleLangParser.RightShiftAssign, 0); }
		public TerminalNode AndAssign() { return getToken(SimpleLangParser.AndAssign, 0); }
		public TerminalNode XorAssign() { return getToken(SimpleLangParser.XorAssign, 0); }
		public TerminalNode OrAssign() { return getToken(SimpleLangParser.OrAssign, 0); }
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterAssignmentOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitAssignmentOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitAssignmentOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignmentOperator);
		try {
			setState(379);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Assign:
				enterOuterAlt(_localctx, 1);
				{
				setState(357);
				((AssignmentOperatorContext)_localctx).opToken = match(Assign);
				 ((AssignmentOperatorContext)_localctx).assignmentOpRet =  new AssignmentOp((((AssignmentOperatorContext)_localctx).opToken!=null?((AssignmentOperatorContext)_localctx).opToken.getText():null)); _localctx.assignmentOpRet.setLine((((AssignmentOperatorContext)_localctx).opToken!=null?((AssignmentOperatorContext)_localctx).opToken.getLine():0)); 
						
				}
				break;
			case StarAssign:
				enterOuterAlt(_localctx, 2);
				{
				setState(359);
				((AssignmentOperatorContext)_localctx).opToken = match(StarAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOpRet =  new AssignmentOp((((AssignmentOperatorContext)_localctx).opToken!=null?((AssignmentOperatorContext)_localctx).opToken.getText():null)); _localctx.assignmentOpRet.setLine((((AssignmentOperatorContext)_localctx).opToken!=null?((AssignmentOperatorContext)_localctx).opToken.getLine():0)); 
						
				}
				break;
			case DivAssign:
				enterOuterAlt(_localctx, 3);
				{
				setState(361);
				((AssignmentOperatorContext)_localctx).opToken = match(DivAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOpRet =  new AssignmentOp((((AssignmentOperatorContext)_localctx).opToken!=null?((AssignmentOperatorContext)_localctx).opToken.getText():null)); _localctx.assignmentOpRet.setLine((((AssignmentOperatorContext)_localctx).opToken!=null?((AssignmentOperatorContext)_localctx).opToken.getLine():0)); 
						
				}
				break;
			case ModAssign:
				enterOuterAlt(_localctx, 4);
				{
				setState(363);
				((AssignmentOperatorContext)_localctx).opToken = match(ModAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOpRet =  new AssignmentOp((((AssignmentOperatorContext)_localctx).opToken!=null?((AssignmentOperatorContext)_localctx).opToken.getText():null)); _localctx.assignmentOpRet.setLine((((AssignmentOperatorContext)_localctx).opToken!=null?((AssignmentOperatorContext)_localctx).opToken.getLine():0)); 
						
				}
				break;
			case PlusAssign:
				enterOuterAlt(_localctx, 5);
				{
				setState(365);
				((AssignmentOperatorContext)_localctx).opToken = match(PlusAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOpRet =  new AssignmentOp((((AssignmentOperatorContext)_localctx).opToken!=null?((AssignmentOperatorContext)_localctx).opToken.getText():null)); _localctx.assignmentOpRet.setLine((((AssignmentOperatorContext)_localctx).opToken!=null?((AssignmentOperatorContext)_localctx).opToken.getLine():0)); 
						
				}
				break;
			case MinusAssign:
				enterOuterAlt(_localctx, 6);
				{
				setState(367);
				((AssignmentOperatorContext)_localctx).opToken = match(MinusAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOpRet =  new AssignmentOp((((AssignmentOperatorContext)_localctx).opToken!=null?((AssignmentOperatorContext)_localctx).opToken.getText():null)); _localctx.assignmentOpRet.setLine((((AssignmentOperatorContext)_localctx).opToken!=null?((AssignmentOperatorContext)_localctx).opToken.getLine():0)); 
						
				}
				break;
			case LeftShiftAssign:
				enterOuterAlt(_localctx, 7);
				{
				setState(369);
				((AssignmentOperatorContext)_localctx).opToken = match(LeftShiftAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOpRet =  new AssignmentOp((((AssignmentOperatorContext)_localctx).opToken!=null?((AssignmentOperatorContext)_localctx).opToken.getText():null)); _localctx.assignmentOpRet.setLine((((AssignmentOperatorContext)_localctx).opToken!=null?((AssignmentOperatorContext)_localctx).opToken.getLine():0)); 
						
				}
				break;
			case RightShiftAssign:
				enterOuterAlt(_localctx, 8);
				{
				setState(371);
				((AssignmentOperatorContext)_localctx).opToken = match(RightShiftAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOpRet =  new AssignmentOp((((AssignmentOperatorContext)_localctx).opToken!=null?((AssignmentOperatorContext)_localctx).opToken.getText():null)); _localctx.assignmentOpRet.setLine((((AssignmentOperatorContext)_localctx).opToken!=null?((AssignmentOperatorContext)_localctx).opToken.getLine():0)); 
						
				}
				break;
			case AndAssign:
				enterOuterAlt(_localctx, 9);
				{
				setState(373);
				((AssignmentOperatorContext)_localctx).opToken = match(AndAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOpRet =  new AssignmentOp((((AssignmentOperatorContext)_localctx).opToken!=null?((AssignmentOperatorContext)_localctx).opToken.getText():null)); _localctx.assignmentOpRet.setLine((((AssignmentOperatorContext)_localctx).opToken!=null?((AssignmentOperatorContext)_localctx).opToken.getLine():0)); 
						
				}
				break;
			case XorAssign:
				enterOuterAlt(_localctx, 10);
				{
				setState(375);
				((AssignmentOperatorContext)_localctx).opToken = match(XorAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOpRet =  new AssignmentOp((((AssignmentOperatorContext)_localctx).opToken!=null?((AssignmentOperatorContext)_localctx).opToken.getText():null)); _localctx.assignmentOpRet.setLine((((AssignmentOperatorContext)_localctx).opToken!=null?((AssignmentOperatorContext)_localctx).opToken.getLine():0)); 
						
				}
				break;
			case OrAssign:
				enterOuterAlt(_localctx, 11);
				{
				setState(377);
				((AssignmentOperatorContext)_localctx).opToken = match(OrAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOpRet =  new AssignmentOp((((AssignmentOperatorContext)_localctx).opToken!=null?((AssignmentOperatorContext)_localctx).opToken.getText():null)); _localctx.assignmentOpRet.setLine((((AssignmentOperatorContext)_localctx).opToken!=null?((AssignmentOperatorContext)_localctx).opToken.getLine():0)); 
						
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public Declaration declarationRet;
		public DeclarationSpecifiersContext specs;
		public InitDeclaratorListContext initList;
		public TerminalNode Semi() { return getToken(SimpleLangParser.Semi, 0); }
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public InitDeclaratorListContext initDeclaratorList() {
			return getRuleContext(InitDeclaratorListContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			((DeclarationContext)_localctx).specs = declarationSpecifiers();
			 ((DeclarationContext)_localctx).declarationRet =  new Declaration(((DeclarationContext)_localctx).specs.declarationSpecifiersRet); 
					
			setState(386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & 35184372154369L) != 0)) {
				{
				setState(383);
				((DeclarationContext)_localctx).initList = initDeclaratorList();
				 _localctx.declarationRet.setInitDecList(((DeclarationContext)_localctx).initList.initDeclaratorListRet); 
							
				}
			}

			setState(388);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationSpecifiersContext extends ParserRuleContext {
		public DeclarationSpecifiers declarationSpecifiersRet;
		public DeclarationSpecifierContext specifierItem;
		public List<DeclarationSpecifierContext> declarationSpecifier() {
			return getRuleContexts(DeclarationSpecifierContext.class);
		}
		public DeclarationSpecifierContext declarationSpecifier(int i) {
			return getRuleContext(DeclarationSpecifierContext.class,i);
		}
		public DeclarationSpecifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationSpecifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDeclarationSpecifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDeclarationSpecifiers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDeclarationSpecifiers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationSpecifiersContext declarationSpecifiers() throws RecognitionException {
		DeclarationSpecifiersContext _localctx = new DeclarationSpecifiersContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_declarationSpecifiers);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			 ((DeclarationSpecifiersContext)_localctx).declarationSpecifiersRet =  new DeclarationSpecifiers(); 
			setState(394); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(391);
					((DeclarationSpecifiersContext)_localctx).specifierItem = declarationSpecifier();
					 _localctx.declarationSpecifiersRet.addDeclarationSpecifier(((DeclarationSpecifiersContext)_localctx).specifierItem.declarationSpecifierRet); 
								
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(396); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationSpecifierContext extends ParserRuleContext {
		public DeclarationSpecifier declarationSpecifierRet;
		public Token typedefToken;
		public TypeSpecifierContext typeSpecNode;
		public Token constToken;
		public TerminalNode Typedef() { return getToken(SimpleLangParser.Typedef, 0); }
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public TerminalNode Const() { return getToken(SimpleLangParser.Const, 0); }
		public DeclarationSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDeclarationSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDeclarationSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDeclarationSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationSpecifierContext declarationSpecifier() throws RecognitionException {
		DeclarationSpecifierContext _localctx = new DeclarationSpecifierContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_declarationSpecifier);
		try {
			setState(408);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Typedef:
				enterOuterAlt(_localctx, 1);
				{
				 ((DeclarationSpecifierContext)_localctx).declarationSpecifierRet =  new DeclarationSpecifier(); 
				setState(399);
				((DeclarationSpecifierContext)_localctx).typedefToken = match(Typedef);
				 _localctx.declarationSpecifierRet.setType((((DeclarationSpecifierContext)_localctx).typedefToken!=null?((DeclarationSpecifierContext)_localctx).typedefToken.getText():null)); 
						
				}
				break;
			case Char:
			case Double:
			case Float:
			case Int:
			case Long:
			case Short:
			case Signed:
			case Unsigned:
			case Void:
			case Bool:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				 ((DeclarationSpecifierContext)_localctx).declarationSpecifierRet =  new DeclarationSpecifier(); 
				setState(402);
				((DeclarationSpecifierContext)_localctx).typeSpecNode = typeSpecifier();
				 _localctx.declarationSpecifierRet.setTypeSpecifier(((DeclarationSpecifierContext)_localctx).typeSpecNode.typeSpecifierRet); 
						
				}
				break;
			case Const:
				enterOuterAlt(_localctx, 3);
				{
				 ((DeclarationSpecifierContext)_localctx).declarationSpecifierRet =  new DeclarationSpecifier(); 
				setState(406);
				((DeclarationSpecifierContext)_localctx).constToken = match(Const);
				 _localctx.declarationSpecifierRet.setType((((DeclarationSpecifierContext)_localctx).constToken!=null?((DeclarationSpecifierContext)_localctx).constToken.getText():null)); 
						
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitDeclaratorListContext extends ParserRuleContext {
		public InitDeclaratorList initDeclaratorListRet;
		public InitDeclaratorContext firstInitDeclarator;
		public InitDeclaratorContext nextInitDeclarator;
		public List<InitDeclaratorContext> initDeclarator() {
			return getRuleContexts(InitDeclaratorContext.class);
		}
		public InitDeclaratorContext initDeclarator(int i) {
			return getRuleContext(InitDeclaratorContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLangParser.Comma, i);
		}
		public InitDeclaratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDeclaratorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterInitDeclaratorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitInitDeclaratorList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitInitDeclaratorList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitDeclaratorListContext initDeclaratorList() throws RecognitionException {
		InitDeclaratorListContext _localctx = new InitDeclaratorListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_initDeclaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410);
			((InitDeclaratorListContext)_localctx).firstInitDeclarator = initDeclarator();
			 ((InitDeclaratorListContext)_localctx).initDeclaratorListRet =  new InitDeclaratorList(((InitDeclaratorListContext)_localctx).firstInitDeclarator.initDeclaratorRet); 
					
			setState(418);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(412);
				match(Comma);
				setState(413);
				((InitDeclaratorListContext)_localctx).nextInitDeclarator = initDeclarator();
				 _localctx.initDeclaratorListRet.addInitDeclarator(((InitDeclaratorListContext)_localctx).nextInitDeclarator.initDeclaratorRet); 
							
				}
				}
				setState(420);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitDeclaratorContext extends ParserRuleContext {
		public InitDeclarator initDeclaratorRet;
		public DeclaratorContext declaratorNode;
		public InitializerContext initializerNode;
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode Assign() { return getToken(SimpleLangParser.Assign, 0); }
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public InitDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterInitDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitInitDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitInitDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitDeclaratorContext initDeclarator() throws RecognitionException {
		InitDeclaratorContext _localctx = new InitDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_initDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			((InitDeclaratorContext)_localctx).declaratorNode = declarator();
			 ((InitDeclaratorContext)_localctx).initDeclaratorRet =  new InitDeclarator(((InitDeclaratorContext)_localctx).declaratorNode.declaratorRet); 
					
			setState(427);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(423);
				match(Assign);
				setState(424);
				((InitDeclaratorContext)_localctx).initializerNode = initializer();
				 _localctx.initDeclaratorRet.setInitializer(((InitDeclaratorContext)_localctx).initializerNode.initializerRet); 
							
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeSpecifierContext extends ParserRuleContext {
		public TypeSpecifier typeSpecifierRet;
		public Token typeKeyword;
		public Token typedefNameToken;
		public TerminalNode Void() { return getToken(SimpleLangParser.Void, 0); }
		public TerminalNode Char() { return getToken(SimpleLangParser.Char, 0); }
		public TerminalNode Short() { return getToken(SimpleLangParser.Short, 0); }
		public TerminalNode Int() { return getToken(SimpleLangParser.Int, 0); }
		public TerminalNode Long() { return getToken(SimpleLangParser.Long, 0); }
		public TerminalNode Float() { return getToken(SimpleLangParser.Float, 0); }
		public TerminalNode Double() { return getToken(SimpleLangParser.Double, 0); }
		public TerminalNode Signed() { return getToken(SimpleLangParser.Signed, 0); }
		public TerminalNode Unsigned() { return getToken(SimpleLangParser.Unsigned, 0); }
		public TerminalNode Bool() { return getToken(SimpleLangParser.Bool, 0); }
		public TerminalNode Identifier() { return getToken(SimpleLangParser.Identifier, 0); }
		public TypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitTypeSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitTypeSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeSpecifierContext typeSpecifier() throws RecognitionException {
		TypeSpecifierContext _localctx = new TypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_typeSpecifier);
		try {
			setState(451);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Void:
				enterOuterAlt(_localctx, 1);
				{
				setState(429);
				((TypeSpecifierContext)_localctx).typeKeyword = match(Void);
				 ((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier((((TypeSpecifierContext)_localctx).typeKeyword!=null?((TypeSpecifierContext)_localctx).typeKeyword.getText():null)); 
				}
				break;
			case Char:
				enterOuterAlt(_localctx, 2);
				{
				setState(431);
				((TypeSpecifierContext)_localctx).typeKeyword = match(Char);
				 ((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier((((TypeSpecifierContext)_localctx).typeKeyword!=null?((TypeSpecifierContext)_localctx).typeKeyword.getText():null)); 
				}
				break;
			case Short:
				enterOuterAlt(_localctx, 3);
				{
				setState(433);
				((TypeSpecifierContext)_localctx).typeKeyword = match(Short);
				 ((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier((((TypeSpecifierContext)_localctx).typeKeyword!=null?((TypeSpecifierContext)_localctx).typeKeyword.getText():null)); 
				}
				break;
			case Int:
				enterOuterAlt(_localctx, 4);
				{
				setState(435);
				((TypeSpecifierContext)_localctx).typeKeyword = match(Int);
				 ((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier((((TypeSpecifierContext)_localctx).typeKeyword!=null?((TypeSpecifierContext)_localctx).typeKeyword.getText():null)); 
				}
				break;
			case Long:
				enterOuterAlt(_localctx, 5);
				{
				setState(437);
				((TypeSpecifierContext)_localctx).typeKeyword = match(Long);
				 ((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier((((TypeSpecifierContext)_localctx).typeKeyword!=null?((TypeSpecifierContext)_localctx).typeKeyword.getText():null)); 
				}
				break;
			case Float:
				enterOuterAlt(_localctx, 6);
				{
				setState(439);
				((TypeSpecifierContext)_localctx).typeKeyword = match(Float);
				 ((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier((((TypeSpecifierContext)_localctx).typeKeyword!=null?((TypeSpecifierContext)_localctx).typeKeyword.getText():null)); 
				}
				break;
			case Double:
				enterOuterAlt(_localctx, 7);
				{
				setState(441);
				((TypeSpecifierContext)_localctx).typeKeyword = match(Double);
				 ((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier((((TypeSpecifierContext)_localctx).typeKeyword!=null?((TypeSpecifierContext)_localctx).typeKeyword.getText():null)); 
				}
				break;
			case Signed:
				enterOuterAlt(_localctx, 8);
				{
				setState(443);
				((TypeSpecifierContext)_localctx).typeKeyword = match(Signed);
				 ((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier((((TypeSpecifierContext)_localctx).typeKeyword!=null?((TypeSpecifierContext)_localctx).typeKeyword.getText():null)); 
				}
				break;
			case Unsigned:
				enterOuterAlt(_localctx, 9);
				{
				setState(445);
				((TypeSpecifierContext)_localctx).typeKeyword = match(Unsigned);
				 ((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier((((TypeSpecifierContext)_localctx).typeKeyword!=null?((TypeSpecifierContext)_localctx).typeKeyword.getText():null)); 
				}
				break;
			case Bool:
				enterOuterAlt(_localctx, 10);
				{
				setState(447);
				((TypeSpecifierContext)_localctx).typeKeyword = match(Bool);
				 ((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier((((TypeSpecifierContext)_localctx).typeKeyword!=null?((TypeSpecifierContext)_localctx).typeKeyword.getText():null)); 
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 11);
				{
				setState(449);
				((TypeSpecifierContext)_localctx).typedefNameToken = match(Identifier);
				 ((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier((((TypeSpecifierContext)_localctx).typedefNameToken!=null?((TypeSpecifierContext)_localctx).typedefNameToken.getText():null), true); _localctx.typeSpecifierRet.setLine((((TypeSpecifierContext)_localctx).typedefNameToken!=null?((TypeSpecifierContext)_localctx).typedefNameToken.getLine():0)); 
						
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SpecifierQualifierListContext extends ParserRuleContext {
		public SpecifierQualifierList specifierQualifierListRet;
		public TypeSpecifierContext typeSpecNode;
		public SpecifierQualifierListContext recursiveSpecQualList;
		public TerminalNode Const() { return getToken(SimpleLangParser.Const, 0); }
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public SpecifierQualifierListContext specifierQualifierList() {
			return getRuleContext(SpecifierQualifierListContext.class,0);
		}
		public SpecifierQualifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specifierQualifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterSpecifierQualifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitSpecifierQualifierList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitSpecifierQualifierList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecifierQualifierListContext specifierQualifierList() throws RecognitionException {
		SpecifierQualifierListContext _localctx = new SpecifierQualifierListContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_specifierQualifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((SpecifierQualifierListContext)_localctx).specifierQualifierListRet =  new SpecifierQualifierList(); 
			setState(458);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Char:
			case Double:
			case Float:
			case Int:
			case Long:
			case Short:
			case Signed:
			case Unsigned:
			case Void:
			case Bool:
			case Identifier:
				{
				setState(454);
				((SpecifierQualifierListContext)_localctx).typeSpecNode = typeSpecifier();
				 _localctx.specifierQualifierListRet.setTypeSpecifier(((SpecifierQualifierListContext)_localctx).typeSpecNode.typeSpecifierRet); 
							
				}
				break;
			case Const:
				{
				setState(457);
				match(Const);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(463);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5822796L) != 0) || _la==Identifier) {
				{
				setState(460);
				((SpecifierQualifierListContext)_localctx).recursiveSpecQualList = specifierQualifierList();
				 _localctx.specifierQualifierListRet.setSpecifierQualifierList(((SpecifierQualifierListContext)_localctx).recursiveSpecQualList.specifierQualifierListRet); 
							
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaratorContext extends ParserRuleContext {
		public Declarator declaratorRet;
		public PointerContext pointerNode;
		public DirectDeclaratorContext coreDeclarator;
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public DeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((DeclaratorContext)_localctx).declaratorRet =  new Declarator(); 
			setState(469);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Star) {
				{
				setState(466);
				((DeclaratorContext)_localctx).pointerNode = pointer();
				 _localctx.declaratorRet.setPointer(((DeclaratorContext)_localctx).pointerNode.pointerRet); 
				}
			}

			setState(471);
			((DeclaratorContext)_localctx).coreDeclarator = directDeclarator(0);

			        _localctx.declaratorRet.setDirectDec(((DeclaratorContext)_localctx).coreDeclarator.directDecRet);
			        _localctx.declaratorRet.setLine(((DeclaratorContext)_localctx).coreDeclarator.directDecRet.getLine());
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DirectDeclaratorContext extends ParserRuleContext {
		public DirectDec directDecRet;
		public DirectDeclaratorContext d1;
		public DirectDeclaratorContext d2;
		public Token id;
		public Token l;
		public DeclaratorContext d;
		public ExpressionContext e;
		public ParameterListContext p;
		public IdentifierListContext i;
		public TerminalNode Identifier() { return getToken(SimpleLangParser.Identifier, 0); }
		public TerminalNode RightParen() { return getToken(SimpleLangParser.RightParen, 0); }
		public TerminalNode LeftParen() { return getToken(SimpleLangParser.LeftParen, 0); }
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(SimpleLangParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(SimpleLangParser.RightBracket, 0); }
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public DirectDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDirectDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDirectDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDirectDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectDeclaratorContext directDeclarator() throws RecognitionException {
		return directDeclarator(0);
	}

	private DirectDeclaratorContext directDeclarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DirectDeclaratorContext _localctx = new DirectDeclaratorContext(_ctx, _parentState);
		DirectDeclaratorContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_directDeclarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(484);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				((DirectDeclaratorContext)_localctx).directDecRet =  new DirectDec();
				setState(476);
				((DirectDeclaratorContext)_localctx).id = match(Identifier);
				_localctx.directDecRet.setIdentifier((((DirectDeclaratorContext)_localctx).id!=null?((DirectDeclaratorContext)_localctx).id.getText():null)); _localctx.directDecRet.setLine((((DirectDeclaratorContext)_localctx).id!=null?((DirectDeclaratorContext)_localctx).id.getLine():0));
				}
				break;
			case LeftParen:
				{
				((DirectDeclaratorContext)_localctx).directDecRet =  new DirectDec();
				setState(479);
				((DirectDeclaratorContext)_localctx).l = match(LeftParen);
				setState(480);
				((DirectDeclaratorContext)_localctx).d = declarator();
				_localctx.directDecRet.setDeclarator(((DirectDeclaratorContext)_localctx).d.declaratorRet); _localctx.directDecRet.setLine((((DirectDeclaratorContext)_localctx).l!=null?((DirectDeclaratorContext)_localctx).l.getLine():0));
				setState(482);
				match(RightParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(513);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(511);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
					case 1:
						{
						_localctx = new DirectDeclaratorContext(_parentctx, _parentState);
						_localctx.d1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_directDeclarator);
						setState(486);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						((DirectDeclaratorContext)_localctx).directDecRet =  new DirectDec();
						_localctx.directDecRet.setDirectDec(((DirectDeclaratorContext)_localctx).d1.directDecRet);
						setState(489);
						match(LeftBracket);
						setState(493);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
							{
							setState(490);
							((DirectDeclaratorContext)_localctx).e = expression(0);
							_localctx.directDecRet.setExpression(((DirectDeclaratorContext)_localctx).e.expressionRet);
							}
						}

						setState(495);
						match(RightBracket);
						}
						break;
					case 2:
						{
						_localctx = new DirectDeclaratorContext(_parentctx, _parentState);
						_localctx.d2 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_directDeclarator);
						setState(496);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						((DirectDeclaratorContext)_localctx).directDecRet =  new DirectDec();
						_localctx.directDecRet.setDirectDec(((DirectDeclaratorContext)_localctx).d2.directDecRet);
						setState(499);
						((DirectDeclaratorContext)_localctx).l = match(LeftParen);
						setState(508);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
						case 1:
							{
							setState(500);
							((DirectDeclaratorContext)_localctx).p = parameterList();
							_localctx.directDecRet.setParameterList(((DirectDeclaratorContext)_localctx).p.parameterListRet); _localctx.directDecRet.setLine((((DirectDeclaratorContext)_localctx).l!=null?((DirectDeclaratorContext)_localctx).l.getLine():0));
							}
							break;
						case 2:
							{
							setState(506);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la==Identifier) {
								{
								setState(503);
								((DirectDeclaratorContext)_localctx).i = identifierList();
								_localctx.directDecRet.setIdentifierList(((DirectDeclaratorContext)_localctx).i.identifierListRet);
								}
							}

							}
							break;
						}
						setState(510);
						match(RightParen);
						}
						break;
					}
					} 
				}
				setState(515);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PointerContext extends ParserRuleContext {
		public Pointer pointerRet;
		public List<TerminalNode> Star() { return getTokens(SimpleLangParser.Star); }
		public TerminalNode Star(int i) {
			return getToken(SimpleLangParser.Star, i);
		}
		public List<TerminalNode> Const() { return getTokens(SimpleLangParser.Const); }
		public TerminalNode Const(int i) {
			return getToken(SimpleLangParser.Const, i);
		}
		public PointerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterPointer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitPointer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitPointer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointerContext pointer() throws RecognitionException {
		PointerContext _localctx = new PointerContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_pointer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((PointerContext)_localctx).pointerRet =  new Pointer(); 
			setState(524); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(517);
				match(Star);
				setState(521);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Const) {
					{
					{
					setState(518);
					match(Const);
					}
					}
					setState(523);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(526); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Star );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterListContext extends ParserRuleContext {
		public ParameterList parameterListRet;
		public ParameterDeclarationContext firstParameter;
		public ParameterDeclarationContext nextParameter;
		public List<ParameterDeclarationContext> parameterDeclaration() {
			return getRuleContexts(ParameterDeclarationContext.class);
		}
		public ParameterDeclarationContext parameterDeclaration(int i) {
			return getRuleContext(ParameterDeclarationContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLangParser.Comma, i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(528);
			((ParameterListContext)_localctx).firstParameter = parameterDeclaration();
			 ((ParameterListContext)_localctx).parameterListRet =  new ParameterList(((ParameterListContext)_localctx).firstParameter.parameterDecRet); 
			setState(536);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(530);
				match(Comma);
				setState(531);
				((ParameterListContext)_localctx).nextParameter = parameterDeclaration();
				 _localctx.parameterListRet.addParameterDec(((ParameterListContext)_localctx).nextParameter.parameterDecRet); 
				}
				}
				setState(538);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterDeclarationContext extends ParserRuleContext {
		public ParameterDec parameterDecRet;
		public DeclarationSpecifiersContext paramTypeSpecs;
		public DeclaratorContext paramDeclarator;
		public AbstractDeclaratorContext paramAbstractDeclarator;
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public ParameterDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterParameterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitParameterDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitParameterDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterDeclarationContext parameterDeclaration() throws RecognitionException {
		ParameterDeclarationContext _localctx = new ParameterDeclarationContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_parameterDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(539);
			((ParameterDeclarationContext)_localctx).paramTypeSpecs = declarationSpecifiers();
			 ((ParameterDeclarationContext)_localctx).parameterDecRet =  new ParameterDec(((ParameterDeclarationContext)_localctx).paramTypeSpecs.declarationSpecifiersRet); 
			setState(549);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				{
				setState(541);
				((ParameterDeclarationContext)_localctx).paramDeclarator = declarator();
				 _localctx.parameterDecRet.setDeclarator(((ParameterDeclarationContext)_localctx).paramDeclarator.declaratorRet); 
				}
				break;
			case 2:
				{
				setState(547);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 549797756928L) != 0)) {
					{
					setState(544);
					((ParameterDeclarationContext)_localctx).paramAbstractDeclarator = abstractDeclarator();
					 _localctx.parameterDecRet.setAbstractDec(((ParameterDeclarationContext)_localctx).paramAbstractDeclarator.abstractDecRet); 
					}
				}

				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierListContext extends ParserRuleContext {
		public IdentifierList identifierListRet;
		public Token firstIdentifier;
		public Token nextIdentifier;
		public List<TerminalNode> Identifier() { return getTokens(SimpleLangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(SimpleLangParser.Identifier, i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLangParser.Comma, i);
		}
		public IdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterIdentifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitIdentifierList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitIdentifierList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierListContext identifierList() throws RecognitionException {
		IdentifierListContext _localctx = new IdentifierListContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_identifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(551);
			((IdentifierListContext)_localctx).firstIdentifier = match(Identifier);
			 ((IdentifierListContext)_localctx).identifierListRet =  new IdentifierList((((IdentifierListContext)_localctx).firstIdentifier!=null?((IdentifierListContext)_localctx).firstIdentifier.getText():null)); 
			setState(558);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(553);
				match(Comma);
				setState(554);
				((IdentifierListContext)_localctx).nextIdentifier = match(Identifier);
				 _localctx.identifierListRet.addIdentifier((((IdentifierListContext)_localctx).nextIdentifier!=null?((IdentifierListContext)_localctx).nextIdentifier.getText():null)); 
				}
				}
				setState(560);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeNameContext extends ParserRuleContext {
		public TypeName typeNameRet;
		public SpecifierQualifierListContext specQuals;
		public AbstractDeclaratorContext absDeclarator;
		public SpecifierQualifierListContext specifierQualifierList() {
			return getRuleContext(SpecifierQualifierListContext.class,0);
		}
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_typeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(561);
			((TypeNameContext)_localctx).specQuals = specifierQualifierList();
			 ((TypeNameContext)_localctx).typeNameRet =  new TypeName(((TypeNameContext)_localctx).specQuals.specifierQualifierListRet); 
			setState(566);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 549797756928L) != 0)) {
				{
				setState(563);
				((TypeNameContext)_localctx).absDeclarator = abstractDeclarator();
				 _localctx.typeNameRet.setAbstractDec(((TypeNameContext)_localctx).absDeclarator.abstractDecRet); 
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AbstractDeclaratorContext extends ParserRuleContext {
		public AbstractDec abstractDecRet;
		public PointerContext pointerNode;
		public PointerContext optionalPointerNode;
		public DirectAbstractDeclaratorContext directAbsDeclaratorNode;
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public DirectAbstractDeclaratorContext directAbstractDeclarator() {
			return getRuleContext(DirectAbstractDeclaratorContext.class,0);
		}
		public AbstractDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstractDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterAbstractDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitAbstractDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitAbstractDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbstractDeclaratorContext abstractDeclarator() throws RecognitionException {
		AbstractDeclaratorContext _localctx = new AbstractDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_abstractDeclarator);
		int _la;
		try {
			setState(581);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				 ((AbstractDeclaratorContext)_localctx).abstractDecRet =  new AbstractDec(); 
				setState(569);
				((AbstractDeclaratorContext)_localctx).pointerNode = pointer();
				 _localctx.abstractDecRet.setPointer(((AbstractDeclaratorContext)_localctx).pointerNode.pointerRet); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				 ((AbstractDeclaratorContext)_localctx).abstractDecRet =  new AbstractDec(); 
				setState(576);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Star) {
					{
					setState(573);
					((AbstractDeclaratorContext)_localctx).optionalPointerNode = pointer();
					 _localctx.abstractDecRet.setPointer(((AbstractDeclaratorContext)_localctx).optionalPointerNode.pointerRet); 
					}
				}

				setState(578);
				((AbstractDeclaratorContext)_localctx).directAbsDeclaratorNode = directAbstractDeclarator(0);
				 _localctx.abstractDecRet.setDirectAbsDec(((AbstractDeclaratorContext)_localctx).directAbsDeclaratorNode.directAbsDecRet); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DirectAbstractDeclaratorContext extends ParserRuleContext {
		public DirectAbsDec directAbsDecRet;
		public DirectAbstractDeclaratorContext d;
		public ExpressionContext e;
		public AbstractDeclaratorContext a;
		public ParameterListContext p;
		public TerminalNode LeftBracket() { return getToken(SimpleLangParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(SimpleLangParser.RightBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(SimpleLangParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(SimpleLangParser.RightParen, 0); }
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public DirectAbstractDeclaratorContext directAbstractDeclarator() {
			return getRuleContext(DirectAbstractDeclaratorContext.class,0);
		}
		public DirectAbstractDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directAbstractDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDirectAbstractDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDirectAbstractDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDirectAbstractDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectAbstractDeclaratorContext directAbstractDeclarator() throws RecognitionException {
		return directAbstractDeclarator(0);
	}

	private DirectAbstractDeclaratorContext directAbstractDeclarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DirectAbstractDeclaratorContext _localctx = new DirectAbstractDeclaratorContext(_ctx, _parentState);
		DirectAbstractDeclaratorContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_directAbstractDeclarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(605);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBracket:
				{
				((DirectAbstractDeclaratorContext)_localctx).directAbsDecRet =  new DirectAbsDec();
				setState(585);
				match(LeftBracket);
				setState(589);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
					{
					setState(586);
					((DirectAbstractDeclaratorContext)_localctx).e = expression(0);
					_localctx.directAbsDecRet.setExpression(((DirectAbstractDeclaratorContext)_localctx).e.expressionRet);
					}
				}

				setState(591);
				match(RightBracket);
				}
				break;
			case LeftParen:
				{
				((DirectAbstractDeclaratorContext)_localctx).directAbsDecRet =  new DirectAbsDec();
				setState(593);
				match(LeftParen);
				setState(602);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LeftParen:
				case LeftBracket:
				case Star:
					{
					setState(594);
					((DirectAbstractDeclaratorContext)_localctx).a = abstractDeclarator();
					_localctx.directAbsDecRet.setAbstractDec(((DirectAbstractDeclaratorContext)_localctx).a.abstractDecRet);
					}
					break;
				case Char:
				case Const:
				case Double:
				case Float:
				case Int:
				case Long:
				case Short:
				case Signed:
				case Typedef:
				case Unsigned:
				case Void:
				case Bool:
				case RightParen:
				case Identifier:
					{
					setState(600);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6084940L) != 0) || _la==Identifier) {
						{
						setState(597);
						((DirectAbstractDeclaratorContext)_localctx).p = parameterList();
						_localctx.directAbsDecRet.setParameterList(((DirectAbstractDeclaratorContext)_localctx).p.parameterListRet);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(604);
				match(RightParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(629);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(627);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
					case 1:
						{
						_localctx = new DirectAbstractDeclaratorContext(_parentctx, _parentState);
						_localctx.d = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_directAbstractDeclarator);
						setState(607);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						((DirectAbstractDeclaratorContext)_localctx).directAbsDecRet =  new DirectAbsDec();
						_localctx.directAbsDecRet.setDirectAbsDec(((DirectAbstractDeclaratorContext)_localctx).d.directAbsDecRet);
						setState(610);
						match(LeftBracket);
						setState(614);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
							{
							setState(611);
							((DirectAbstractDeclaratorContext)_localctx).e = expression(0);
							_localctx.directAbsDecRet.setExpression(((DirectAbstractDeclaratorContext)_localctx).e.expressionRet);
							}
						}

						setState(616);
						match(RightBracket);
						}
						break;
					case 2:
						{
						_localctx = new DirectAbstractDeclaratorContext(_parentctx, _parentState);
						_localctx.d = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_directAbstractDeclarator);
						setState(617);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						((DirectAbstractDeclaratorContext)_localctx).directAbsDecRet =  new DirectAbsDec();
						_localctx.directAbsDecRet.setDirectAbsDec(((DirectAbstractDeclaratorContext)_localctx).d.directAbsDecRet);
						setState(620);
						match(LeftParen);
						setState(624);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6084940L) != 0) || _la==Identifier) {
							{
							setState(621);
							((DirectAbstractDeclaratorContext)_localctx).p = parameterList();
							_localctx.directAbsDecRet.setParameterList(((DirectAbstractDeclaratorContext)_localctx).p.parameterListRet);
							}
						}

						setState(626);
						match(RightParen);
						}
						break;
					}
					} 
				}
				setState(631);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitializerContext extends ParserRuleContext {
		public Initializer initializerRet;
		public ExpressionContext initExpression;
		public InitializerListContext initItemsList;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LeftBrace() { return getToken(SimpleLangParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(SimpleLangParser.RightBrace, 0); }
		public InitializerListContext initializerList() {
			return getRuleContext(InitializerListContext.class,0);
		}
		public TerminalNode Comma() { return getToken(SimpleLangParser.Comma, 0); }
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_initializer);
		int _la;
		try {
			setState(645);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Sizeof:
			case LeftParen:
			case Plus:
			case PlusPlus:
			case Minus:
			case MinusMinus:
			case Star:
			case And:
			case Not:
			case Tilde:
			case Identifier:
			case Constant:
			case StringLiteral:
				enterOuterAlt(_localctx, 1);
				{
				 ((InitializerContext)_localctx).initializerRet =  new Initializer(); 
				setState(633);
				((InitializerContext)_localctx).initExpression = expression(0);
				 _localctx.initializerRet.setExpression(((InitializerContext)_localctx).initExpression.expressionRet); 
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 2);
				{
				 ((InitializerContext)_localctx).initializerRet =  new Initializer(); 
				setState(637);
				match(LeftBrace);
				setState(638);
				((InitializerContext)_localctx).initItemsList = initializerList();
				 _localctx.initializerRet.setInitializerList(((InitializerContext)_localctx).initItemsList.initializerListRet); 
				setState(641);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(640);
					match(Comma);
					}
				}

				setState(643);
				match(RightBrace);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitializerListContext extends ParserRuleContext {
		public InitializerList initializerListRet;
		public DesignationContext firstDesignation;
		public InitializerContext firstInitializerItem;
		public DesignationContext nextDesignation;
		public InitializerContext nextInitializerItem;
		public List<InitializerContext> initializer() {
			return getRuleContexts(InitializerContext.class);
		}
		public InitializerContext initializer(int i) {
			return getRuleContext(InitializerContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLangParser.Comma, i);
		}
		public List<DesignationContext> designation() {
			return getRuleContexts(DesignationContext.class);
		}
		public DesignationContext designation(int i) {
			return getRuleContext(DesignationContext.class,i);
		}
		public InitializerListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializerList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterInitializerList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitInitializerList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitInitializerList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerListContext initializerList() throws RecognitionException {
		InitializerListContext _localctx = new InitializerListContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_initializerList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			 ((InitializerListContext)_localctx).initializerListRet =  new InitializerList(); 
			setState(651);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LeftBracket || _la==Dot) {
				{
				setState(648);
				((InitializerListContext)_localctx).firstDesignation = designation();
				 _localctx.initializerListRet.addDesignation(((InitializerListContext)_localctx).firstDesignation.designationRet); 
				}
			}

			setState(653);
			((InitializerListContext)_localctx).firstInitializerItem = initializer();
			 _localctx.initializerListRet.addInitializer(((InitializerListContext)_localctx).firstInitializerItem.initializerRet); 
			setState(666);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(655);
					match(Comma);
					setState(659);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LeftBracket || _la==Dot) {
						{
						setState(656);
						((InitializerListContext)_localctx).nextDesignation = designation();
						 _localctx.initializerListRet.addDesignation(((InitializerListContext)_localctx).nextDesignation.designationRet); 
						}
					}

					setState(661);
					((InitializerListContext)_localctx).nextInitializerItem = initializer();
					 _localctx.initializerListRet.addInitializer(((InitializerListContext)_localctx).nextInitializerItem.initializerRet); 
					}
					} 
				}
				setState(668);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DesignationContext extends ParserRuleContext {
		public Designation designationRet;
		public DesignatorContext designatorElement;
		public TerminalNode Assign() { return getToken(SimpleLangParser.Assign, 0); }
		public List<DesignatorContext> designator() {
			return getRuleContexts(DesignatorContext.class);
		}
		public DesignatorContext designator(int i) {
			return getRuleContext(DesignatorContext.class,i);
		}
		public DesignationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDesignation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDesignation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDesignation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DesignationContext designation() throws RecognitionException {
		DesignationContext _localctx = new DesignationContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_designation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((DesignationContext)_localctx).designationRet =  new Designation(); 
			setState(673); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(670);
				((DesignationContext)_localctx).designatorElement = designator();
				 _localctx.designationRet.addDesignator(((DesignationContext)_localctx).designatorElement.designatorRet); 
				}
				}
				setState(675); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LeftBracket || _la==Dot );
			setState(677);
			match(Assign);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DesignatorContext extends ParserRuleContext {
		public Designator designatorRet;
		public ExpressionContext indexValueExpression;
		public Token memberNameIdentifier;
		public TerminalNode LeftBracket() { return getToken(SimpleLangParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(SimpleLangParser.RightBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Dot() { return getToken(SimpleLangParser.Dot, 0); }
		public TerminalNode Identifier() { return getToken(SimpleLangParser.Identifier, 0); }
		public DesignatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDesignator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDesignator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDesignator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DesignatorContext designator() throws RecognitionException {
		DesignatorContext _localctx = new DesignatorContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_designator);
		try {
			setState(688);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBracket:
				enterOuterAlt(_localctx, 1);
				{
				 ((DesignatorContext)_localctx).designatorRet =  new Designator(); 
				setState(680);
				match(LeftBracket);
				setState(681);
				((DesignatorContext)_localctx).indexValueExpression = expression(0);
				setState(682);
				match(RightBracket);
				 _localctx.designatorRet.setExpression(((DesignatorContext)_localctx).indexValueExpression.expressionRet); 
				}
				break;
			case Dot:
				enterOuterAlt(_localctx, 2);
				{
				setState(685);
				match(Dot);
				setState(686);
				((DesignatorContext)_localctx).memberNameIdentifier = match(Identifier);
				 _localctx.designatorRet.setLine((((DesignatorContext)_localctx).memberNameIdentifier!=null?((DesignatorContext)_localctx).memberNameIdentifier.getLine():0)); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public Statement statementRet;
		public CompoundStatementContext compoundStmtNode;
		public ExpressionStatementContext exprStmtNode;
		public SelectionStatementContext selectionStmtNode;
		public IterationStatementContext iterationStmtNode;
		public JumpStatementContext jumpStmtNode;
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public SelectionStatementContext selectionStatement() {
			return getRuleContext(SelectionStatementContext.class,0);
		}
		public IterationStatementContext iterationStatement() {
			return getRuleContext(IterationStatementContext.class,0);
		}
		public JumpStatementContext jumpStatement() {
			return getRuleContext(JumpStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_statement);
		try {
			setState(705);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBrace:
				enterOuterAlt(_localctx, 1);
				{
				setState(690);
				((StatementContext)_localctx).compoundStmtNode = compoundStatement();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).compoundStmtNode.compoundStatementRet; 
				}
				break;
			case Sizeof:
			case LeftParen:
			case Plus:
			case PlusPlus:
			case Minus:
			case MinusMinus:
			case Star:
			case And:
			case Not:
			case Tilde:
			case Semi:
			case Identifier:
			case Constant:
			case StringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(693);
				((StatementContext)_localctx).exprStmtNode = expressionStatement();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).exprStmtNode.expressionStatementRet; 
				}
				break;
			case If:
				enterOuterAlt(_localctx, 3);
				{
				setState(696);
				((StatementContext)_localctx).selectionStmtNode = selectionStatement();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).selectionStmtNode.selectionStatementRet; 
				}
				break;
			case Do:
			case For:
			case While:
				enterOuterAlt(_localctx, 4);
				{
				setState(699);
				((StatementContext)_localctx).iterationStmtNode = iterationStatement();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).iterationStmtNode.iterStatementRet; 
				}
				break;
			case Break:
			case Continue:
			case Return:
				enterOuterAlt(_localctx, 5);
				{
				setState(702);
				((StatementContext)_localctx).jumpStmtNode = jumpStatement();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).jumpStmtNode.jumpStatementRet; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompoundStatementContext extends ParserRuleContext {
		public CompoundStatement compoundStatementRet;
		public BlockItemContext itemInBlock;
		public TerminalNode LeftBrace() { return getToken(SimpleLangParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(SimpleLangParser.RightBrace, 0); }
		public List<BlockItemContext> blockItem() {
			return getRuleContexts(BlockItemContext.class);
		}
		public BlockItemContext blockItem(int i) {
			return getRuleContext(BlockItemContext.class,i);
		}
		public CompoundStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterCompoundStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitCompoundStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitCompoundStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoundStatementContext compoundStatement() throws RecognitionException {
		CompoundStatementContext _localctx = new CompoundStatementContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_compoundStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((CompoundStatementContext)_localctx).compoundStatementRet =  new CompoundStatement(); 
			setState(708);
			match(LeftBrace);
			setState(716);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2679475628015486L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 11L) != 0)) {
				{
				setState(712); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(709);
					((CompoundStatementContext)_localctx).itemInBlock = blockItem();
					 _localctx.compoundStatementRet.addBlockItem(((CompoundStatementContext)_localctx).itemInBlock.blockItemRet); 
					}
					}
					setState(714); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2679475628015486L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 11L) != 0) );
				}
			}

			setState(718);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockItemContext extends ParserRuleContext {
		public BlockItem blockItemRet;
		public StatementContext statementNode;
		public DeclarationContext declarationNode;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public BlockItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterBlockItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitBlockItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitBlockItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockItemContext blockItem() throws RecognitionException {
		BlockItemContext _localctx = new BlockItemContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_blockItem);
		try {
			setState(728);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				 ((BlockItemContext)_localctx).blockItemRet =  new BlockItem(); 
				setState(721);
				((BlockItemContext)_localctx).statementNode = statement();
				 _localctx.blockItemRet.setStatement(((BlockItemContext)_localctx).statementNode.statementRet); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				 ((BlockItemContext)_localctx).blockItemRet =  new BlockItem(); 
				setState(725);
				((BlockItemContext)_localctx).declarationNode = declaration();
				 _localctx.blockItemRet.setDeclaration(((BlockItemContext)_localctx).declarationNode.declarationRet); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionStatement expressionStatementRet;
		public ExpressionContext exprNode;
		public TerminalNode Semi() { return getToken(SimpleLangParser.Semi, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitExpressionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_expressionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ExpressionStatementContext)_localctx).expressionStatementRet =  new ExpressionStatement(); 
			setState(734);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
				{
				setState(731);
				((ExpressionStatementContext)_localctx).exprNode = expression(0);
				 _localctx.expressionStatementRet.setExpression(((ExpressionStatementContext)_localctx).exprNode.expressionRet); 
				}
			}

			setState(736);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelectionStatementContext extends ParserRuleContext {
		public SelectionStatement selectionStatementRet;
		public Token ifToken;
		public ExpressionContext conditionExpr;
		public StatementContext thenStatementNode;
		public Token elseToken;
		public StatementContext elseStatementNode;
		public TerminalNode LeftParen() { return getToken(SimpleLangParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(SimpleLangParser.RightParen, 0); }
		public TerminalNode If() { return getToken(SimpleLangParser.If, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(SimpleLangParser.Else, 0); }
		public SelectionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterSelectionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitSelectionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitSelectionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionStatementContext selectionStatement() throws RecognitionException {
		SelectionStatementContext _localctx = new SelectionStatementContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_selectionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(738);
			((SelectionStatementContext)_localctx).ifToken = match(If);
			setState(739);
			match(LeftParen);
			setState(740);
			((SelectionStatementContext)_localctx).conditionExpr = expression(0);
			setState(741);
			match(RightParen);
			setState(742);
			((SelectionStatementContext)_localctx).thenStatementNode = statement();

			        ((SelectionStatementContext)_localctx).selectionStatementRet =  new SelectionStatement(((SelectionStatementContext)_localctx).conditionExpr.expressionRet, ((SelectionStatementContext)_localctx).thenStatementNode.statementRet);
			        _localctx.selectionStatementRet.setLine((((SelectionStatementContext)_localctx).ifToken!=null?((SelectionStatementContext)_localctx).ifToken.getLine():0));
			    
			setState(748);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				{
				setState(744);
				((SelectionStatementContext)_localctx).elseToken = match(Else);
				setState(745);
				((SelectionStatementContext)_localctx).elseStatementNode = statement();

				            _localctx.selectionStatementRet.setElseStatement(((SelectionStatementContext)_localctx).elseStatementNode.statementRet);
				            _localctx.selectionStatementRet.setElseLine((((SelectionStatementContext)_localctx).elseToken!=null?((SelectionStatementContext)_localctx).elseToken.getLine():0));
				        
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IterationStatementContext extends ParserRuleContext {
		public IterStatement iterStatementRet;
		public Token whileToken;
		public ExpressionContext loopConditionExpr;
		public StatementContext loopBodyStatement;
		public StatementContext doLoopBodyStatement;
		public Token doWhileToken;
		public ExpressionContext doLoopConditionExpr;
		public Token forToken;
		public ForConditionContext forLoopConditions;
		public StatementContext forLoopBodyStatement;
		public TerminalNode LeftParen() { return getToken(SimpleLangParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(SimpleLangParser.RightParen, 0); }
		public TerminalNode While() { return getToken(SimpleLangParser.While, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode Do() { return getToken(SimpleLangParser.Do, 0); }
		public TerminalNode Semi() { return getToken(SimpleLangParser.Semi, 0); }
		public TerminalNode For() { return getToken(SimpleLangParser.For, 0); }
		public ForConditionContext forCondition() {
			return getRuleContext(ForConditionContext.class,0);
		}
		public IterationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterIterationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitIterationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitIterationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterationStatementContext iterationStatement() throws RecognitionException {
		IterationStatementContext _localctx = new IterationStatementContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_iterationStatement);
		try {
			setState(773);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case While:
				enterOuterAlt(_localctx, 1);
				{
				setState(750);
				((IterationStatementContext)_localctx).whileToken = match(While);
				setState(751);
				match(LeftParen);
				setState(752);
				((IterationStatementContext)_localctx).loopConditionExpr = expression(0);
				setState(753);
				match(RightParen);
				setState(754);
				((IterationStatementContext)_localctx).loopBodyStatement = statement();

				        ((IterationStatementContext)_localctx).iterStatementRet =  new IterStatement();
				        _localctx.iterStatementRet.setExpression(((IterationStatementContext)_localctx).loopConditionExpr.expressionRet);
				        _localctx.iterStatementRet.setStatement(((IterationStatementContext)_localctx).loopBodyStatement.statementRet);
				        _localctx.iterStatementRet.setLine((((IterationStatementContext)_localctx).whileToken!=null?((IterationStatementContext)_localctx).whileToken.getLine():0));
				        _localctx.iterStatementRet.setType((((IterationStatementContext)_localctx).whileToken!=null?((IterationStatementContext)_localctx).whileToken.getText():null));
				    
				}
				break;
			case Do:
				enterOuterAlt(_localctx, 2);
				{
				setState(757);
				match(Do);
				setState(758);
				((IterationStatementContext)_localctx).doLoopBodyStatement = statement();
				setState(759);
				((IterationStatementContext)_localctx).doWhileToken = match(While);
				setState(760);
				match(LeftParen);
				setState(761);
				((IterationStatementContext)_localctx).doLoopConditionExpr = expression(0);
				setState(762);
				match(RightParen);
				setState(763);
				match(Semi);

				        ((IterationStatementContext)_localctx).iterStatementRet =  new IterStatement();
				        _localctx.iterStatementRet.setExpression(((IterationStatementContext)_localctx).doLoopConditionExpr.expressionRet);
				        _localctx.iterStatementRet.setStatement(((IterationStatementContext)_localctx).doLoopBodyStatement.statementRet);
				        _localctx.iterStatementRet.setLine((((IterationStatementContext)_localctx).doWhileToken!=null?((IterationStatementContext)_localctx).doWhileToken.getLine():0));
				        _localctx.iterStatementRet.setType((((IterationStatementContext)_localctx).doWhileToken!=null?((IterationStatementContext)_localctx).doWhileToken.getText():null)); // Type is 'while' for do-while
				    
				}
				break;
			case For:
				enterOuterAlt(_localctx, 3);
				{
				setState(766);
				((IterationStatementContext)_localctx).forToken = match(For);
				setState(767);
				match(LeftParen);
				setState(768);
				((IterationStatementContext)_localctx).forLoopConditions = forCondition();
				setState(769);
				match(RightParen);
				setState(770);
				((IterationStatementContext)_localctx).forLoopBodyStatement = statement();

				        ((IterationStatementContext)_localctx).iterStatementRet =  new IterStatement();
				        _localctx.iterStatementRet.setForCondition(((IterationStatementContext)_localctx).forLoopConditions.forConditionRet);
				        _localctx.iterStatementRet.setStatement(((IterationStatementContext)_localctx).forLoopBodyStatement.statementRet);
				        _localctx.iterStatementRet.setLine((((IterationStatementContext)_localctx).forToken!=null?((IterationStatementContext)_localctx).forToken.getLine():0));
				        _localctx.iterStatementRet.setType((((IterationStatementContext)_localctx).forToken!=null?((IterationStatementContext)_localctx).forToken.getText():null));
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForConditionContext extends ParserRuleContext {
		public ForCondition forConditionRet;
		public ForDeclarationContext initDeclarationNode;
		public ExpressionContext initExpressionNode;
		public ForExpressionContext conditionExpressionNode;
		public ForExpressionContext iterationExpressionNode;
		public List<TerminalNode> Semi() { return getTokens(SimpleLangParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(SimpleLangParser.Semi, i);
		}
		public ForDeclarationContext forDeclaration() {
			return getRuleContext(ForDeclarationContext.class,0);
		}
		public List<ForExpressionContext> forExpression() {
			return getRuleContexts(ForExpressionContext.class);
		}
		public ForExpressionContext forExpression(int i) {
			return getRuleContext(ForExpressionContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterForCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitForCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitForCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForConditionContext forCondition() throws RecognitionException {
		ForConditionContext _localctx = new ForConditionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_forCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ForConditionContext)_localctx).forConditionRet =  new ForCondition(); 
			setState(784);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				{
				setState(776);
				((ForConditionContext)_localctx).initDeclarationNode = forDeclaration();
				 _localctx.forConditionRet.setForDec(((ForConditionContext)_localctx).initDeclarationNode.forDecRet); 
				}
				break;
			case 2:
				{
				setState(782);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
					{
					setState(779);
					((ForConditionContext)_localctx).initExpressionNode = expression(0);
					 _localctx.forConditionRet.setExpression(((ForConditionContext)_localctx).initExpressionNode.expressionRet); 
					}
				}

				}
				break;
			}
			setState(786);
			match(Semi);
			setState(790);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
				{
				setState(787);
				((ForConditionContext)_localctx).conditionExpressionNode = forExpression();
				 _localctx.forConditionRet.setForExpression1(((ForConditionContext)_localctx).conditionExpressionNode.forExpressionRet); 
				}
			}

			setState(792);
			match(Semi);
			setState(796);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
				{
				setState(793);
				((ForConditionContext)_localctx).iterationExpressionNode = forExpression();
				 _localctx.forConditionRet.setForExpression1(((ForConditionContext)_localctx).iterationExpressionNode.forExpressionRet); 
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForDeclarationContext extends ParserRuleContext {
		public ForDec forDecRet;
		public DeclarationSpecifiersContext declarationSpecs;
		public InitDeclaratorListContext initDeclarators;
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public InitDeclaratorListContext initDeclaratorList() {
			return getRuleContext(InitDeclaratorListContext.class,0);
		}
		public ForDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterForDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitForDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitForDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForDeclarationContext forDeclaration() throws RecognitionException {
		ForDeclarationContext _localctx = new ForDeclarationContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_forDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(798);
			((ForDeclarationContext)_localctx).declarationSpecs = declarationSpecifiers();
			 ((ForDeclarationContext)_localctx).forDecRet =  new ForDec(((ForDeclarationContext)_localctx).declarationSpecs.declarationSpecifiersRet); 
			setState(803);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & 35184372154369L) != 0)) {
				{
				setState(800);
				((ForDeclarationContext)_localctx).initDeclarators = initDeclaratorList();
				 _localctx.forDecRet.setInitDecList(((ForDeclarationContext)_localctx).initDeclarators.initDeclaratorListRet); 
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForExpressionContext extends ParserRuleContext {
		public ForExpression forExpressionRet;
		public ExpressionContext initialExpression;
		public ExpressionContext additionalExpr;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLangParser.Comma, i);
		}
		public ForExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterForExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitForExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitForExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForExpressionContext forExpression() throws RecognitionException {
		ForExpressionContext _localctx = new ForExpressionContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_forExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(805);
			((ForExpressionContext)_localctx).initialExpression = expression(0);
			 ((ForExpressionContext)_localctx).forExpressionRet =  new ForExpression(((ForExpressionContext)_localctx).initialExpression.expressionRet); 
			setState(813);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(807);
				match(Comma);
				setState(808);
				((ForExpressionContext)_localctx).additionalExpr = expression(0);
				 _localctx.forExpressionRet.addExpression(((ForExpressionContext)_localctx).additionalExpr.expressionRet); 
				}
				}
				setState(815);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JumpStatementContext extends ParserRuleContext {
		public JumpStatement jumpStatementRet;
		public ExpressionContext returnValueExpr;
		public TerminalNode Semi() { return getToken(SimpleLangParser.Semi, 0); }
		public TerminalNode Continue() { return getToken(SimpleLangParser.Continue, 0); }
		public TerminalNode Break() { return getToken(SimpleLangParser.Break, 0); }
		public TerminalNode Return() { return getToken(SimpleLangParser.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public JumpStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterJumpStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitJumpStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitJumpStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JumpStatementContext jumpStatement() throws RecognitionException {
		JumpStatementContext _localctx = new JumpStatementContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_jumpStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((JumpStatementContext)_localctx).jumpStatementRet =  new JumpStatement(); 
			setState(825);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Continue:
				{
				setState(817);
				match(Continue);
				}
				break;
			case Break:
				{
				setState(818);
				match(Break);
				}
				break;
			case Return:
				{
				setState(819);
				match(Return);
				setState(823);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
					{
					setState(820);
					((JumpStatementContext)_localctx).returnValueExpr = expression(0);
					 _localctx.jumpStatementRet.setReturnExpression(((JumpStatementContext)_localctx).returnValueExpr.expressionRet); 
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(827);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 18:
			return directDeclarator_sempred((DirectDeclaratorContext)_localctx, predIndex);
		case 25:
			return directAbstractDeclarator_sempred((DirectAbstractDeclaratorContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 5);
		case 8:
			return precpred(_ctx, 4);
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		case 11:
			return precpred(_ctx, 1);
		case 12:
			return precpred(_ctx, 18);
		case 13:
			return precpred(_ctx, 17);
		case 14:
			return precpred(_ctx, 16);
		case 15:
			return precpred(_ctx, 15);
		}
		return true;
	}
	private boolean directDeclarator_sempred(DirectDeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 16:
			return precpred(_ctx, 2);
		case 17:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean directAbstractDeclarator_sempred(DirectAbstractDeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 18:
			return precpred(_ctx, 2);
		case 19:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001M\u033e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000U\b\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0004"+
		"\u0001]\b\u0001\u000b\u0001\f\u0001^\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"i\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"o\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003v\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004\u007f\b\u0004\u000b\u0004"+
		"\f\u0004\u0080\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0004\u0005\u0089\b\u0005\u000b\u0005\f\u0005\u008a\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005\u009a\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005"+
		"\u0005\u00a5\b\u0005\n\u0005\f\u0005\u00a8\t\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0004\u0005\u00af\b\u0005\u000b\u0005"+
		"\f\u0005\u00b0\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u00bf\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u00cd\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005\u00d6\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u012e\b\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0005\u0005\u0137\b\u0005\n\u0005\f\u0005\u013a\t\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005"+
		"\u0006\u0142\b\u0006\n\u0006\f\u0006\u0145\t\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0153\b\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0164\b\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0003\t\u017c\b\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0003\n\u0183\b\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0004\u000b\u018b\b\u000b\u000b\u000b\f\u000b\u018c"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0003\f\u0199\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0005\r\u01a1\b\r\n\r\f\r\u01a4\t\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u01ac\b\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u01c4\b\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u01cb\b\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u01d0\b\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u01d6\b\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0003\u0012\u01e5\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u01ee\b\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u01fb\b\u0012"+
		"\u0003\u0012\u01fd\b\u0012\u0001\u0012\u0005\u0012\u0200\b\u0012\n\u0012"+
		"\f\u0012\u0203\t\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013"+
		"\u0208\b\u0013\n\u0013\f\u0013\u020b\t\u0013\u0004\u0013\u020d\b\u0013"+
		"\u000b\u0013\f\u0013\u020e\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0005\u0014\u0217\b\u0014\n\u0014\f\u0014\u021a"+
		"\t\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0224\b\u0015\u0003\u0015\u0226"+
		"\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005"+
		"\u0016\u022d\b\u0016\n\u0016\f\u0016\u0230\t\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0237\b\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0003\u0018\u0241\b\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0003\u0018\u0246\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0003\u0019\u024e\b\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0003\u0019\u0259\b\u0019\u0003\u0019\u025b\b\u0019\u0001"+
		"\u0019\u0003\u0019\u025e\b\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0267\b\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0003\u0019\u0271\b\u0019\u0001\u0019\u0005\u0019\u0274"+
		"\b\u0019\n\u0019\f\u0019\u0277\t\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0003\u001a\u0282\b\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u0286\b"+
		"\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u028c"+
		"\b\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0003\u001b\u0294\b\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0005"+
		"\u001b\u0299\b\u001b\n\u001b\f\u001b\u029c\t\u001b\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0004\u001c\u02a2\b\u001c\u000b\u001c\f\u001c"+
		"\u02a3\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003"+
		"\u001d\u02b1\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u02c2"+
		"\b\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0004"+
		"\u001f\u02c9\b\u001f\u000b\u001f\f\u001f\u02ca\u0003\u001f\u02cd\b\u001f"+
		"\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0003 \u02d9\b \u0001!\u0001!\u0001!\u0001!\u0003!\u02df\b!\u0001"+
		"!\u0001!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0003\"\u02ed\b\"\u0001#\u0001#\u0001#\u0001#\u0001"+
		"#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001"+
		"#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0003#\u0306"+
		"\b#\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0003$\u030f\b$\u0003"+
		"$\u0311\b$\u0001$\u0001$\u0001$\u0001$\u0003$\u0317\b$\u0001$\u0001$\u0001"+
		"$\u0001$\u0003$\u031d\b$\u0001%\u0001%\u0001%\u0001%\u0001%\u0003%\u0324"+
		"\b%\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0005&\u032c\b&\n&\f&\u032f"+
		"\t&\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0003\'\u0338"+
		"\b\'\u0003\'\u033a\b\'\u0001\'\u0001\'\u0001\'\u0000\u0003\n$2(\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.02468:<>@BDFHJLN\u0000\u0005\u0001\u0000\')\u0002\u0000"+
		"##%%\u0001\u0000!\"\u0001\u0000\u001d \u0001\u0000@A\u0397\u0000P\u0001"+
		"\u0000\u0000\u0000\u0002X\u0001\u0000\u0000\u0000\u0004h\u0001\u0000\u0000"+
		"\u0000\u0006j\u0001\u0000\u0000\u0000\bz\u0001\u0000\u0000\u0000\n\u00d5"+
		"\u0001\u0000\u0000\u0000\f\u013b\u0001\u0000\u0000\u0000\u000e\u0152\u0001"+
		"\u0000\u0000\u0000\u0010\u0163\u0001\u0000\u0000\u0000\u0012\u017b\u0001"+
		"\u0000\u0000\u0000\u0014\u017d\u0001\u0000\u0000\u0000\u0016\u0186\u0001"+
		"\u0000\u0000\u0000\u0018\u0198\u0001\u0000\u0000\u0000\u001a\u019a\u0001"+
		"\u0000\u0000\u0000\u001c\u01a5\u0001\u0000\u0000\u0000\u001e\u01c3\u0001"+
		"\u0000\u0000\u0000 \u01c5\u0001\u0000\u0000\u0000\"\u01d1\u0001\u0000"+
		"\u0000\u0000$\u01e4\u0001\u0000\u0000\u0000&\u0204\u0001\u0000\u0000\u0000"+
		"(\u0210\u0001\u0000\u0000\u0000*\u021b\u0001\u0000\u0000\u0000,\u0227"+
		"\u0001\u0000\u0000\u0000.\u0231\u0001\u0000\u0000\u00000\u0245\u0001\u0000"+
		"\u0000\u00002\u025d\u0001\u0000\u0000\u00004\u0285\u0001\u0000\u0000\u0000"+
		"6\u0287\u0001\u0000\u0000\u00008\u029d\u0001\u0000\u0000\u0000:\u02b0"+
		"\u0001\u0000\u0000\u0000<\u02c1\u0001\u0000\u0000\u0000>\u02c3\u0001\u0000"+
		"\u0000\u0000@\u02d8\u0001\u0000\u0000\u0000B\u02da\u0001\u0000\u0000\u0000"+
		"D\u02e2\u0001\u0000\u0000\u0000F\u0305\u0001\u0000\u0000\u0000H\u0307"+
		"\u0001\u0000\u0000\u0000J\u031e\u0001\u0000\u0000\u0000L\u0325\u0001\u0000"+
		"\u0000\u0000N\u0330\u0001\u0000\u0000\u0000PT\u0006\u0000\uffff\uffff"+
		"\u0000QR\u0003\u0002\u0001\u0000RS\u0006\u0000\uffff\uffff\u0000SU\u0001"+
		"\u0000\u0000\u0000TQ\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000"+
		"UV\u0001\u0000\u0000\u0000VW\u0005\u0000\u0000\u0001W\u0001\u0001\u0000"+
		"\u0000\u0000X\\\u0006\u0001\uffff\uffff\u0000YZ\u0003\u0004\u0002\u0000"+
		"Z[\u0006\u0001\uffff\uffff\u0000[]\u0001\u0000\u0000\u0000\\Y\u0001\u0000"+
		"\u0000\u0000]^\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001"+
		"\u0000\u0000\u0000_\u0003\u0001\u0000\u0000\u0000`a\u0003\u0006\u0003"+
		"\u0000ab\u0006\u0002\uffff\uffff\u0000bi\u0001\u0000\u0000\u0000cd\u0003"+
		"\u0014\n\u0000de\u0006\u0002\uffff\uffff\u0000ei\u0001\u0000\u0000\u0000"+
		"fg\u0006\u0002\uffff\uffff\u0000gi\u00053\u0000\u0000h`\u0001\u0000\u0000"+
		"\u0000hc\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000i\u0005\u0001"+
		"\u0000\u0000\u0000jn\u0006\u0003\uffff\uffff\u0000kl\u0003\u0016\u000b"+
		"\u0000lm\u0006\u0003\uffff\uffff\u0000mo\u0001\u0000\u0000\u0000nk\u0001"+
		"\u0000\u0000\u0000no\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000"+
		"pq\u0003\"\u0011\u0000qu\u0006\u0003\uffff\uffff\u0000rs\u0003\b\u0004"+
		"\u0000st\u0006\u0003\uffff\uffff\u0000tv\u0001\u0000\u0000\u0000ur\u0001"+
		"\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000"+
		"wx\u0003>\u001f\u0000xy\u0006\u0003\uffff\uffff\u0000y\u0007\u0001\u0000"+
		"\u0000\u0000z~\u0006\u0004\uffff\uffff\u0000{|\u0003\u0014\n\u0000|}\u0006"+
		"\u0004\uffff\uffff\u0000}\u007f\u0001\u0000\u0000\u0000~{\u0001\u0000"+
		"\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000"+
		"\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\t\u0001\u0000\u0000\u0000"+
		"\u0082\u0083\u0006\u0005\uffff\uffff\u0000\u0083\u0084\u0005D\u0000\u0000"+
		"\u0084\u00d6\u0006\u0005\uffff\uffff\u0000\u0085\u0086\u0005E\u0000\u0000"+
		"\u0086\u00d6\u0006\u0005\uffff\uffff\u0000\u0087\u0089\u0005G\u0000\u0000"+
		"\u0088\u0087\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000"+
		"\u008a\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000"+
		"\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u00d6\u0006\u0005\uffff\uffff"+
		"\u0000\u008d\u008e\u0005\u0017\u0000\u0000\u008e\u008f\u0003\n\u0005\u0000"+
		"\u008f\u0090\u0006\u0005\uffff\uffff\u0000\u0090\u0091\u0005\u0018\u0000"+
		"\u0000\u0091\u00d6\u0001\u0000\u0000\u0000\u0092\u0093\u0005\u0017\u0000"+
		"\u0000\u0093\u0094\u0003.\u0017\u0000\u0094\u0095\u0005\u0018\u0000\u0000"+
		"\u0095\u0096\u0005\u001b\u0000\u0000\u0096\u0097\u00036\u001b\u0000\u0097"+
		"\u0099\u0006\u0005\uffff\uffff\u0000\u0098\u009a\u00054\u0000\u0000\u0099"+
		"\u0098\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a"+
		"\u009b\u0001\u0000\u0000\u0000\u009b\u009c\u0005\u001c\u0000\u0000\u009c"+
		"\u00d6\u0001\u0000\u0000\u0000\u009d\u00a6\u0006\u0005\uffff\uffff\u0000"+
		"\u009e\u009f\u0005$\u0000\u0000\u009f\u00a5\u0006\u0005\uffff\uffff\u0000"+
		"\u00a0\u00a1\u0005&\u0000\u0000\u00a1\u00a5\u0006\u0005\uffff\uffff\u0000"+
		"\u00a2\u00a3\u0005\u0010\u0000\u0000\u00a3\u00a5\u0006\u0005\uffff\uffff"+
		"\u0000\u00a4\u009e\u0001\u0000\u0000\u0000\u00a4\u00a0\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a5\u00a8\u0001\u0000\u0000"+
		"\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000"+
		"\u0000\u00a7\u00cc\u0001\u0000\u0000\u0000\u00a8\u00a6\u0001\u0000\u0000"+
		"\u0000\u00a9\u00aa\u0005D\u0000\u0000\u00aa\u00cd\u0006\u0005\uffff\uffff"+
		"\u0000\u00ab\u00ac\u0005E\u0000\u0000\u00ac\u00cd\u0006\u0005\uffff\uffff"+
		"\u0000\u00ad\u00af\u0005G\u0000\u0000\u00ae\u00ad\u0001\u0000\u0000\u0000"+
		"\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000"+
		"\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u00cd\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b3\u0005\u0017\u0000\u0000\u00b3\u00b4\u0003\n\u0005\u0000\u00b4"+
		"\u00b5\u0005\u0018\u0000\u0000\u00b5\u00b6\u0006\u0005\uffff\uffff\u0000"+
		"\u00b6\u00cd\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005\u0017\u0000\u0000"+
		"\u00b8\u00b9\u0003.\u0017\u0000\u00b9\u00ba\u0005\u0018\u0000\u0000\u00ba"+
		"\u00bb\u0005\u001b\u0000\u0000\u00bb\u00bc\u00036\u001b\u0000\u00bc\u00be"+
		"\u0006\u0005\uffff\uffff\u0000\u00bd\u00bf\u00054\u0000\u0000\u00be\u00bd"+
		"\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf\u00c0"+
		"\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005\u001c\u0000\u0000\u00c1\u00cd"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c3\u0003\u000e\u0007\u0000\u00c3\u00c4"+
		"\u0003\u0010\b\u0000\u00c4\u00c5\u0006\u0005\uffff\uffff\u0000\u00c5\u00cd"+
		"\u0001\u0000\u0000\u0000\u00c6\u00c7\u0005\u0010\u0000\u0000\u00c7\u00c8"+
		"\u0005\u0017\u0000\u0000\u00c8\u00c9\u0003.\u0017\u0000\u00c9\u00ca\u0006"+
		"\u0005\uffff\uffff\u0000\u00ca\u00cb\u0005\u0018\u0000\u0000\u00cb\u00cd"+
		"\u0001\u0000\u0000\u0000\u00cc\u00a9\u0001\u0000\u0000\u0000\u00cc\u00ab"+
		"\u0001\u0000\u0000\u0000\u00cc\u00ae\u0001\u0000\u0000\u0000\u00cc\u00b2"+
		"\u0001\u0000\u0000\u0000\u00cc\u00b7\u0001\u0000\u0000\u0000\u00cc\u00c2"+
		"\u0001\u0000\u0000\u0000\u00cc\u00c6\u0001\u0000\u0000\u0000\u00cd\u00ce"+
		"\u0001\u0000\u0000\u0000\u00ce\u00d6\u0006\u0005\uffff\uffff\u0000\u00cf"+
		"\u00d0\u0005\u0017\u0000\u0000\u00d0\u00d1\u0003.\u0017\u0000\u00d1\u00d2"+
		"\u0005\u0018\u0000\u0000\u00d2\u00d3\u0003\u0010\b\u0000\u00d3\u00d4\u0006"+
		"\u0005\uffff\uffff\u0000\u00d4\u00d6\u0001\u0000\u0000\u0000\u00d5\u0082"+
		"\u0001\u0000\u0000\u0000\u00d5\u0085\u0001\u0000\u0000\u0000\u00d5\u0088"+
		"\u0001\u0000\u0000\u0000\u00d5\u008d\u0001\u0000\u0000\u0000\u00d5\u0092"+
		"\u0001\u0000\u0000\u0000\u00d5\u009d\u0001\u0000\u0000\u0000\u00d5\u00cf"+
		"\u0001\u0000\u0000\u0000\u00d6\u0138\u0001\u0000\u0000\u0000\u00d7\u00d8"+
		"\n\f\u0000\u0000\u00d8\u00d9\u0007\u0000\u0000\u0000\u00d9\u00da\u0003"+
		"\n\u0005\r\u00da\u00db\u0006\u0005\uffff\uffff\u0000\u00db\u00dc\u0006"+
		"\u0005\uffff\uffff\u0000\u00dc\u0137\u0001\u0000\u0000\u0000\u00dd\u00de"+
		"\n\u000b\u0000\u0000\u00de\u00df\u0007\u0001\u0000\u0000\u00df\u00e0\u0003"+
		"\n\u0005\f\u00e0\u00e1\u0006\u0005\uffff\uffff\u0000\u00e1\u00e2\u0006"+
		"\u0005\uffff\uffff\u0000\u00e2\u0137\u0001\u0000\u0000\u0000\u00e3\u00e4"+
		"\n\n\u0000\u0000\u00e4\u00e5\u0007\u0002\u0000\u0000\u00e5\u00e6\u0003"+
		"\n\u0005\u000b\u00e6\u00e7\u0006\u0005\uffff\uffff\u0000\u00e7\u00e8\u0006"+
		"\u0005\uffff\uffff\u0000\u00e8\u0137\u0001\u0000\u0000\u0000\u00e9\u00ea"+
		"\n\t\u0000\u0000\u00ea\u00eb\u0007\u0003\u0000\u0000\u00eb\u00ec\u0003"+
		"\n\u0005\n\u00ec\u00ed\u0006\u0005\uffff\uffff\u0000\u00ed\u00ee\u0006"+
		"\u0005\uffff\uffff\u0000\u00ee\u0137\u0001\u0000\u0000\u0000\u00ef\u00f0"+
		"\n\b\u0000\u0000\u00f0\u00f1\u0007\u0004\u0000\u0000\u00f1\u00f2\u0003"+
		"\n\u0005\t\u00f2\u00f3\u0006\u0005\uffff\uffff\u0000\u00f3\u00f4\u0006"+
		"\u0005\uffff\uffff\u0000\u00f4\u0137\u0001\u0000\u0000\u0000\u00f5\u00f6"+
		"\n\u0007\u0000\u0000\u00f6\u00f7\u0005*\u0000\u0000\u00f7\u00f8\u0003"+
		"\n\u0005\b\u00f8\u00f9\u0006\u0005\uffff\uffff\u0000\u00f9\u00fa\u0006"+
		"\u0005\uffff\uffff\u0000\u00fa\u0137\u0001\u0000\u0000\u0000\u00fb\u00fc"+
		"\n\u0006\u0000\u0000\u00fc\u00fd\u0005.\u0000\u0000\u00fd\u00fe\u0003"+
		"\n\u0005\u0007\u00fe\u00ff\u0006\u0005\uffff\uffff\u0000\u00ff\u0100\u0006"+
		"\u0005\uffff\uffff\u0000\u0100\u0137\u0001\u0000\u0000\u0000\u0101\u0102"+
		"\n\u0005\u0000\u0000\u0102\u0103\u0005+\u0000\u0000\u0103\u0104\u0003"+
		"\n\u0005\u0006\u0104\u0105\u0006\u0005\uffff\uffff\u0000\u0105\u0106\u0006"+
		"\u0005\uffff\uffff\u0000\u0106\u0137\u0001\u0000\u0000\u0000\u0107\u0108"+
		"\n\u0004\u0000\u0000\u0108\u0109\u0005,\u0000\u0000\u0109\u010a\u0003"+
		"\n\u0005\u0005\u010a\u010b\u0006\u0005\uffff\uffff\u0000\u010b\u010c\u0006"+
		"\u0005\uffff\uffff\u0000\u010c\u0137\u0001\u0000\u0000\u0000\u010d\u010e"+
		"\n\u0003\u0000\u0000\u010e\u010f\u0005-\u0000\u0000\u010f\u0110\u0003"+
		"\n\u0005\u0004\u0110\u0111\u0006\u0005\uffff\uffff\u0000\u0111\u0112\u0006"+
		"\u0005\uffff\uffff\u0000\u0112\u0137\u0001\u0000\u0000\u0000\u0113\u0114"+
		"\n\u0002\u0000\u0000\u0114\u0115\u00051\u0000\u0000\u0115\u0116\u0003"+
		"\n\u0005\u0000\u0116\u0117\u00052\u0000\u0000\u0117\u0118\u0003\n\u0005"+
		"\u0003\u0118\u0119\u0006\u0005\uffff\uffff\u0000\u0119\u011a\u0006\u0005"+
		"\uffff\uffff\u0000\u011a\u0137\u0001\u0000\u0000\u0000\u011b\u011c\n\u0001"+
		"\u0000\u0000\u011c\u011d\u0003\u0012\t\u0000\u011d\u011e\u0003\n\u0005"+
		"\u0002\u011e\u011f\u0006\u0005\uffff\uffff\u0000\u011f\u0120\u0006\u0005"+
		"\uffff\uffff\u0000\u0120\u0137\u0001\u0000\u0000\u0000\u0121\u0122\n\u0012"+
		"\u0000\u0000\u0122\u0123\u0005\u0019\u0000\u0000\u0123\u0124\u0003\n\u0005"+
		"\u0000\u0124\u0125\u0005\u001a\u0000\u0000\u0125\u0126\u0006\u0005\uffff"+
		"\uffff\u0000\u0126\u0137\u0001\u0000\u0000\u0000\u0127\u0128\n\u0011\u0000"+
		"\u0000\u0128\u0129\u0006\u0005\uffff\uffff\u0000\u0129\u012d\u0005\u0017"+
		"\u0000\u0000\u012a\u012b\u0003\f\u0006\u0000\u012b\u012c\u0006\u0005\uffff"+
		"\uffff\u0000\u012c\u012e\u0001\u0000\u0000\u0000\u012d\u012a\u0001\u0000"+
		"\u0000\u0000\u012d\u012e\u0001\u0000\u0000\u0000\u012e\u012f\u0001\u0000"+
		"\u0000\u0000\u012f\u0137\u0005\u0018\u0000\u0000\u0130\u0131\n\u0010\u0000"+
		"\u0000\u0131\u0132\u0005$\u0000\u0000\u0132\u0137\u0006\u0005\uffff\uffff"+
		"\u0000\u0133\u0134\n\u000f\u0000\u0000\u0134\u0135\u0005&\u0000\u0000"+
		"\u0135\u0137\u0006\u0005\uffff\uffff\u0000\u0136\u00d7\u0001\u0000\u0000"+
		"\u0000\u0136\u00dd\u0001\u0000\u0000\u0000\u0136\u00e3\u0001\u0000\u0000"+
		"\u0000\u0136\u00e9\u0001\u0000\u0000\u0000\u0136\u00ef\u0001\u0000\u0000"+
		"\u0000\u0136\u00f5\u0001\u0000\u0000\u0000\u0136\u00fb\u0001\u0000\u0000"+
		"\u0000\u0136\u0101\u0001\u0000\u0000\u0000\u0136\u0107\u0001\u0000\u0000"+
		"\u0000\u0136\u010d\u0001\u0000\u0000\u0000\u0136\u0113\u0001\u0000\u0000"+
		"\u0000\u0136\u011b\u0001\u0000\u0000\u0000\u0136\u0121\u0001\u0000\u0000"+
		"\u0000\u0136\u0127\u0001\u0000\u0000\u0000\u0136\u0130\u0001\u0000\u0000"+
		"\u0000\u0136\u0133\u0001\u0000\u0000\u0000\u0137\u013a\u0001\u0000\u0000"+
		"\u0000\u0138\u0136\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000"+
		"\u0000\u0139\u000b\u0001\u0000\u0000\u0000\u013a\u0138\u0001\u0000\u0000"+
		"\u0000\u013b\u013c\u0003\n\u0005\u0000\u013c\u0143\u0006\u0006\uffff\uffff"+
		"\u0000\u013d\u013e\u00054\u0000\u0000\u013e\u013f\u0003\n\u0005\u0000"+
		"\u013f\u0140\u0006\u0006\uffff\uffff\u0000\u0140\u0142\u0001\u0000\u0000"+
		"\u0000\u0141\u013d\u0001\u0000\u0000\u0000\u0142\u0145\u0001\u0000\u0000"+
		"\u0000\u0143\u0141\u0001\u0000\u0000\u0000\u0143\u0144\u0001\u0000\u0000"+
		"\u0000\u0144\r\u0001\u0000\u0000\u0000\u0145\u0143\u0001\u0000\u0000\u0000"+
		"\u0146\u0147\u0005*\u0000\u0000\u0147\u0153\u0006\u0007\uffff\uffff\u0000"+
		"\u0148\u0149\u0005\'\u0000\u0000\u0149\u0153\u0006\u0007\uffff\uffff\u0000"+
		"\u014a\u014b\u0005#\u0000\u0000\u014b\u0153\u0006\u0007\uffff\uffff\u0000"+
		"\u014c\u014d\u0005%\u0000\u0000\u014d\u0153\u0006\u0007\uffff\uffff\u0000"+
		"\u014e\u014f\u00050\u0000\u0000\u014f\u0153\u0006\u0007\uffff\uffff\u0000"+
		"\u0150\u0151\u0005/\u0000\u0000\u0151\u0153\u0006\u0007\uffff\uffff\u0000"+
		"\u0152\u0146\u0001\u0000\u0000\u0000\u0152\u0148\u0001\u0000\u0000\u0000"+
		"\u0152\u014a\u0001\u0000\u0000\u0000\u0152\u014c\u0001\u0000\u0000\u0000"+
		"\u0152\u014e\u0001\u0000\u0000\u0000\u0152\u0150\u0001\u0000\u0000\u0000"+
		"\u0153\u000f\u0001\u0000\u0000\u0000\u0154\u0155\u0006\b\uffff\uffff\u0000"+
		"\u0155\u0156\u0005\u0017\u0000\u0000\u0156\u0157\u0003.\u0017\u0000\u0157"+
		"\u0158\u0006\b\uffff\uffff\u0000\u0158\u0159\u0005\u0018\u0000\u0000\u0159"+
		"\u015a\u0003\u0010\b\u0000\u015a\u015b\u0006\b\uffff\uffff\u0000\u015b"+
		"\u0164\u0001\u0000\u0000\u0000\u015c\u015d\u0006\b\uffff\uffff\u0000\u015d"+
		"\u015e\u0003\n\u0005\u0000\u015e\u015f\u0006\b\uffff\uffff\u0000\u015f"+
		"\u0164\u0001\u0000\u0000\u0000\u0160\u0161\u0006\b\uffff\uffff\u0000\u0161"+
		"\u0162\u0005F\u0000\u0000\u0162\u0164\u0006\b\uffff\uffff\u0000\u0163"+
		"\u0154\u0001\u0000\u0000\u0000\u0163\u015c\u0001\u0000\u0000\u0000\u0163"+
		"\u0160\u0001\u0000\u0000\u0000\u0164\u0011\u0001\u0000\u0000\u0000\u0165"+
		"\u0166\u00055\u0000\u0000\u0166\u017c\u0006\t\uffff\uffff\u0000\u0167"+
		"\u0168\u00056\u0000\u0000\u0168\u017c\u0006\t\uffff\uffff\u0000\u0169"+
		"\u016a\u00057\u0000\u0000\u016a\u017c\u0006\t\uffff\uffff\u0000\u016b"+
		"\u016c\u00058\u0000\u0000\u016c\u017c\u0006\t\uffff\uffff\u0000\u016d"+
		"\u016e\u00059\u0000\u0000\u016e\u017c\u0006\t\uffff\uffff\u0000\u016f"+
		"\u0170\u0005:\u0000\u0000\u0170\u017c\u0006\t\uffff\uffff\u0000\u0171"+
		"\u0172\u0005;\u0000\u0000\u0172\u017c\u0006\t\uffff\uffff\u0000\u0173"+
		"\u0174\u0005<\u0000\u0000\u0174\u017c\u0006\t\uffff\uffff\u0000\u0175"+
		"\u0176\u0005=\u0000\u0000\u0176\u017c\u0006\t\uffff\uffff\u0000\u0177"+
		"\u0178\u0005>\u0000\u0000\u0178\u017c\u0006\t\uffff\uffff\u0000\u0179"+
		"\u017a\u0005?\u0000\u0000\u017a\u017c\u0006\t\uffff\uffff\u0000\u017b"+
		"\u0165\u0001\u0000\u0000\u0000\u017b\u0167\u0001\u0000\u0000\u0000\u017b"+
		"\u0169\u0001\u0000\u0000\u0000\u017b\u016b\u0001\u0000\u0000\u0000\u017b"+
		"\u016d\u0001\u0000\u0000\u0000\u017b\u016f\u0001\u0000\u0000\u0000\u017b"+
		"\u0171\u0001\u0000\u0000\u0000\u017b\u0173\u0001\u0000\u0000\u0000\u017b"+
		"\u0175\u0001\u0000\u0000\u0000\u017b\u0177\u0001\u0000\u0000\u0000\u017b"+
		"\u0179\u0001\u0000\u0000\u0000\u017c\u0013\u0001\u0000\u0000\u0000\u017d"+
		"\u017e\u0003\u0016\u000b\u0000\u017e\u0182\u0006\n\uffff\uffff\u0000\u017f"+
		"\u0180\u0003\u001a\r\u0000\u0180\u0181\u0006\n\uffff\uffff\u0000\u0181"+
		"\u0183\u0001\u0000\u0000\u0000\u0182\u017f\u0001\u0000\u0000\u0000\u0182"+
		"\u0183\u0001\u0000\u0000\u0000\u0183\u0184\u0001\u0000\u0000\u0000\u0184"+
		"\u0185\u00053\u0000\u0000\u0185\u0015\u0001\u0000\u0000\u0000\u0186\u018a"+
		"\u0006\u000b\uffff\uffff\u0000\u0187\u0188\u0003\u0018\f\u0000\u0188\u0189"+
		"\u0006\u000b\uffff\uffff\u0000\u0189\u018b\u0001\u0000\u0000\u0000\u018a"+
		"\u0187\u0001\u0000\u0000\u0000\u018b\u018c\u0001\u0000\u0000\u0000\u018c"+
		"\u018a\u0001\u0000\u0000\u0000\u018c\u018d\u0001\u0000\u0000\u0000\u018d"+
		"\u0017\u0001\u0000\u0000\u0000\u018e\u018f\u0006\f\uffff\uffff\u0000\u018f"+
		"\u0190\u0005\u0012\u0000\u0000\u0190\u0199\u0006\f\uffff\uffff\u0000\u0191"+
		"\u0192\u0006\f\uffff\uffff\u0000\u0192\u0193\u0003\u001e\u000f\u0000\u0193"+
		"\u0194\u0006\f\uffff\uffff\u0000\u0194\u0199\u0001\u0000\u0000\u0000\u0195"+
		"\u0196\u0006\f\uffff\uffff\u0000\u0196\u0197\u0005\u0003\u0000\u0000\u0197"+
		"\u0199\u0006\f\uffff\uffff\u0000\u0198\u018e\u0001\u0000\u0000\u0000\u0198"+
		"\u0191\u0001\u0000\u0000\u0000\u0198\u0195\u0001\u0000\u0000\u0000\u0199"+
		"\u0019\u0001\u0000\u0000\u0000\u019a\u019b\u0003\u001c\u000e\u0000\u019b"+
		"\u01a2\u0006\r\uffff\uffff\u0000\u019c\u019d\u00054\u0000\u0000\u019d"+
		"\u019e\u0003\u001c\u000e\u0000\u019e\u019f\u0006\r\uffff\uffff\u0000\u019f"+
		"\u01a1\u0001\u0000\u0000\u0000\u01a0\u019c\u0001\u0000\u0000\u0000\u01a1"+
		"\u01a4\u0001\u0000\u0000\u0000\u01a2\u01a0\u0001\u0000\u0000\u0000\u01a2"+
		"\u01a3\u0001\u0000\u0000\u0000\u01a3\u001b\u0001\u0000\u0000\u0000\u01a4"+
		"\u01a2\u0001\u0000\u0000\u0000\u01a5\u01a6\u0003\"\u0011\u0000\u01a6\u01ab"+
		"\u0006\u000e\uffff\uffff\u0000\u01a7\u01a8\u00055\u0000\u0000\u01a8\u01a9"+
		"\u00034\u001a\u0000\u01a9\u01aa\u0006\u000e\uffff\uffff\u0000\u01aa\u01ac"+
		"\u0001\u0000\u0000\u0000\u01ab\u01a7\u0001\u0000\u0000\u0000\u01ab\u01ac"+
		"\u0001\u0000\u0000\u0000\u01ac\u001d\u0001\u0000\u0000\u0000\u01ad\u01ae"+
		"\u0005\u0014\u0000\u0000\u01ae\u01c4\u0006\u000f\uffff\uffff\u0000\u01af"+
		"\u01b0\u0005\u0002\u0000\u0000\u01b0\u01c4\u0006\u000f\uffff\uffff\u0000"+
		"\u01b1\u01b2\u0005\u000e\u0000\u0000\u01b2\u01c4\u0006\u000f\uffff\uffff"+
		"\u0000\u01b3\u01b4\u0005\u000b\u0000\u0000\u01b4\u01c4\u0006\u000f\uffff"+
		"\uffff\u0000\u01b5\u01b6\u0005\f\u0000\u0000\u01b6\u01c4\u0006\u000f\uffff"+
		"\uffff\u0000\u01b7\u01b8\u0005\b\u0000\u0000\u01b8\u01c4\u0006\u000f\uffff"+
		"\uffff\u0000\u01b9\u01ba\u0005\u0006\u0000\u0000\u01ba\u01c4\u0006\u000f"+
		"\uffff\uffff\u0000\u01bb\u01bc\u0005\u000f\u0000\u0000\u01bc\u01c4\u0006"+
		"\u000f\uffff\uffff\u0000\u01bd\u01be\u0005\u0013\u0000\u0000\u01be\u01c4"+
		"\u0006\u000f\uffff\uffff\u0000\u01bf\u01c0\u0005\u0016\u0000\u0000\u01c0"+
		"\u01c4\u0006\u000f\uffff\uffff\u0000\u01c1\u01c2\u0005D\u0000\u0000\u01c2"+
		"\u01c4\u0006\u000f\uffff\uffff\u0000\u01c3\u01ad\u0001\u0000\u0000\u0000"+
		"\u01c3\u01af\u0001\u0000\u0000\u0000\u01c3\u01b1\u0001\u0000\u0000\u0000"+
		"\u01c3\u01b3\u0001\u0000\u0000\u0000\u01c3\u01b5\u0001\u0000\u0000\u0000"+
		"\u01c3\u01b7\u0001\u0000\u0000\u0000\u01c3\u01b9\u0001\u0000\u0000\u0000"+
		"\u01c3\u01bb\u0001\u0000\u0000\u0000\u01c3\u01bd\u0001\u0000\u0000\u0000"+
		"\u01c3\u01bf\u0001\u0000\u0000\u0000\u01c3\u01c1\u0001\u0000\u0000\u0000"+
		"\u01c4\u001f\u0001\u0000\u0000\u0000\u01c5\u01ca\u0006\u0010\uffff\uffff"+
		"\u0000\u01c6\u01c7\u0003\u001e\u000f\u0000\u01c7\u01c8\u0006\u0010\uffff"+
		"\uffff\u0000\u01c8\u01cb\u0001\u0000\u0000\u0000\u01c9\u01cb\u0005\u0003"+
		"\u0000\u0000\u01ca\u01c6\u0001\u0000\u0000\u0000\u01ca\u01c9\u0001\u0000"+
		"\u0000\u0000\u01cb\u01cf\u0001\u0000\u0000\u0000\u01cc\u01cd\u0003 \u0010"+
		"\u0000\u01cd\u01ce\u0006\u0010\uffff\uffff\u0000\u01ce\u01d0\u0001\u0000"+
		"\u0000\u0000\u01cf\u01cc\u0001\u0000\u0000\u0000\u01cf\u01d0\u0001\u0000"+
		"\u0000\u0000\u01d0!\u0001\u0000\u0000\u0000\u01d1\u01d5\u0006\u0011\uffff"+
		"\uffff\u0000\u01d2\u01d3\u0003&\u0013\u0000\u01d3\u01d4\u0006\u0011\uffff"+
		"\uffff\u0000\u01d4\u01d6\u0001\u0000\u0000\u0000\u01d5\u01d2\u0001\u0000"+
		"\u0000\u0000\u01d5\u01d6\u0001\u0000\u0000\u0000\u01d6\u01d7\u0001\u0000"+
		"\u0000\u0000\u01d7\u01d8\u0003$\u0012\u0000\u01d8\u01d9\u0006\u0011\uffff"+
		"\uffff\u0000\u01d9#\u0001\u0000\u0000\u0000\u01da\u01db\u0006\u0012\uffff"+
		"\uffff\u0000\u01db\u01dc\u0006\u0012\uffff\uffff\u0000\u01dc\u01dd\u0005"+
		"D\u0000\u0000\u01dd\u01e5\u0006\u0012\uffff\uffff\u0000\u01de\u01df\u0006"+
		"\u0012\uffff\uffff\u0000\u01df\u01e0\u0005\u0017\u0000\u0000\u01e0\u01e1"+
		"\u0003\"\u0011\u0000\u01e1\u01e2\u0006\u0012\uffff\uffff\u0000\u01e2\u01e3"+
		"\u0005\u0018\u0000\u0000\u01e3\u01e5\u0001\u0000\u0000\u0000\u01e4\u01da"+
		"\u0001\u0000\u0000\u0000\u01e4\u01de\u0001\u0000\u0000\u0000\u01e5\u0201"+
		"\u0001\u0000\u0000\u0000\u01e6\u01e7\n\u0002\u0000\u0000\u01e7\u01e8\u0006"+
		"\u0012\uffff\uffff\u0000\u01e8\u01e9\u0006\u0012\uffff\uffff\u0000\u01e9"+
		"\u01ed\u0005\u0019\u0000\u0000\u01ea\u01eb\u0003\n\u0005\u0000\u01eb\u01ec"+
		"\u0006\u0012\uffff\uffff\u0000\u01ec\u01ee\u0001\u0000\u0000\u0000\u01ed"+
		"\u01ea\u0001\u0000\u0000\u0000\u01ed\u01ee\u0001\u0000\u0000\u0000\u01ee"+
		"\u01ef\u0001\u0000\u0000\u0000\u01ef\u0200\u0005\u001a\u0000\u0000\u01f0"+
		"\u01f1\n\u0001\u0000\u0000\u01f1\u01f2\u0006\u0012\uffff\uffff\u0000\u01f2"+
		"\u01f3\u0006\u0012\uffff\uffff\u0000\u01f3\u01fc\u0005\u0017\u0000\u0000"+
		"\u01f4\u01f5\u0003(\u0014\u0000\u01f5\u01f6\u0006\u0012\uffff\uffff\u0000"+
		"\u01f6\u01fd\u0001\u0000\u0000\u0000\u01f7\u01f8\u0003,\u0016\u0000\u01f8"+
		"\u01f9\u0006\u0012\uffff\uffff\u0000\u01f9\u01fb\u0001\u0000\u0000\u0000"+
		"\u01fa\u01f7\u0001\u0000\u0000\u0000\u01fa\u01fb\u0001\u0000\u0000\u0000"+
		"\u01fb\u01fd\u0001\u0000\u0000\u0000\u01fc\u01f4\u0001\u0000\u0000\u0000"+
		"\u01fc\u01fa\u0001\u0000\u0000\u0000\u01fd\u01fe\u0001\u0000\u0000\u0000"+
		"\u01fe\u0200\u0005\u0018\u0000\u0000\u01ff\u01e6\u0001\u0000\u0000\u0000"+
		"\u01ff\u01f0\u0001\u0000\u0000\u0000\u0200\u0203\u0001\u0000\u0000\u0000"+
		"\u0201\u01ff\u0001\u0000\u0000\u0000\u0201\u0202\u0001\u0000\u0000\u0000"+
		"\u0202%\u0001\u0000\u0000\u0000\u0203\u0201\u0001\u0000\u0000\u0000\u0204"+
		"\u020c\u0006\u0013\uffff\uffff\u0000\u0205\u0209\u0005\'\u0000\u0000\u0206"+
		"\u0208\u0005\u0003\u0000\u0000\u0207\u0206\u0001\u0000\u0000\u0000\u0208"+
		"\u020b\u0001\u0000\u0000\u0000\u0209\u0207\u0001\u0000\u0000\u0000\u0209"+
		"\u020a\u0001\u0000\u0000\u0000\u020a\u020d\u0001\u0000\u0000\u0000\u020b"+
		"\u0209\u0001\u0000\u0000\u0000\u020c\u0205\u0001\u0000\u0000\u0000\u020d"+
		"\u020e\u0001\u0000\u0000\u0000\u020e\u020c\u0001\u0000\u0000\u0000\u020e"+
		"\u020f\u0001\u0000\u0000\u0000\u020f\'\u0001\u0000\u0000\u0000\u0210\u0211"+
		"\u0003*\u0015\u0000\u0211\u0218\u0006\u0014\uffff\uffff\u0000\u0212\u0213"+
		"\u00054\u0000\u0000\u0213\u0214\u0003*\u0015\u0000\u0214\u0215\u0006\u0014"+
		"\uffff\uffff\u0000\u0215\u0217\u0001\u0000\u0000\u0000\u0216\u0212\u0001"+
		"\u0000\u0000\u0000\u0217\u021a\u0001\u0000\u0000\u0000\u0218\u0216\u0001"+
		"\u0000\u0000\u0000\u0218\u0219\u0001\u0000\u0000\u0000\u0219)\u0001\u0000"+
		"\u0000\u0000\u021a\u0218\u0001\u0000\u0000\u0000\u021b\u021c\u0003\u0016"+
		"\u000b\u0000\u021c\u0225\u0006\u0015\uffff\uffff\u0000\u021d\u021e\u0003"+
		"\"\u0011\u0000\u021e\u021f\u0006\u0015\uffff\uffff\u0000\u021f\u0226\u0001"+
		"\u0000\u0000\u0000\u0220\u0221\u00030\u0018\u0000\u0221\u0222\u0006\u0015"+
		"\uffff\uffff\u0000\u0222\u0224\u0001\u0000\u0000\u0000\u0223\u0220\u0001"+
		"\u0000\u0000\u0000\u0223\u0224\u0001\u0000\u0000\u0000\u0224\u0226\u0001"+
		"\u0000\u0000\u0000\u0225\u021d\u0001\u0000\u0000\u0000\u0225\u0223\u0001"+
		"\u0000\u0000\u0000\u0226+\u0001\u0000\u0000\u0000\u0227\u0228\u0005D\u0000"+
		"\u0000\u0228\u022e\u0006\u0016\uffff\uffff\u0000\u0229\u022a\u00054\u0000"+
		"\u0000\u022a\u022b\u0005D\u0000\u0000\u022b\u022d\u0006\u0016\uffff\uffff"+
		"\u0000\u022c\u0229\u0001\u0000\u0000\u0000\u022d\u0230\u0001\u0000\u0000"+
		"\u0000\u022e\u022c\u0001\u0000\u0000\u0000\u022e\u022f\u0001\u0000\u0000"+
		"\u0000\u022f-\u0001\u0000\u0000\u0000\u0230\u022e\u0001\u0000\u0000\u0000"+
		"\u0231\u0232\u0003 \u0010\u0000\u0232\u0236\u0006\u0017\uffff\uffff\u0000"+
		"\u0233\u0234\u00030\u0018\u0000\u0234\u0235\u0006\u0017\uffff\uffff\u0000"+
		"\u0235\u0237\u0001\u0000\u0000\u0000\u0236\u0233\u0001\u0000\u0000\u0000"+
		"\u0236\u0237\u0001\u0000\u0000\u0000\u0237/\u0001\u0000\u0000\u0000\u0238"+
		"\u0239\u0006\u0018\uffff\uffff\u0000\u0239\u023a\u0003&\u0013\u0000\u023a"+
		"\u023b\u0006\u0018\uffff\uffff\u0000\u023b\u0246\u0001\u0000\u0000\u0000"+
		"\u023c\u0240\u0006\u0018\uffff\uffff\u0000\u023d\u023e\u0003&\u0013\u0000"+
		"\u023e\u023f\u0006\u0018\uffff\uffff\u0000\u023f\u0241\u0001\u0000\u0000"+
		"\u0000\u0240\u023d\u0001\u0000\u0000\u0000\u0240\u0241\u0001\u0000\u0000"+
		"\u0000\u0241\u0242\u0001\u0000\u0000\u0000\u0242\u0243\u00032\u0019\u0000"+
		"\u0243\u0244\u0006\u0018\uffff\uffff\u0000\u0244\u0246\u0001\u0000\u0000"+
		"\u0000\u0245\u0238\u0001\u0000\u0000\u0000\u0245\u023c\u0001\u0000\u0000"+
		"\u0000\u02461\u0001\u0000\u0000\u0000\u0247\u0248\u0006\u0019\uffff\uffff"+
		"\u0000\u0248\u0249\u0006\u0019\uffff\uffff\u0000\u0249\u024d\u0005\u0019"+
		"\u0000\u0000\u024a\u024b\u0003\n\u0005\u0000\u024b\u024c\u0006\u0019\uffff"+
		"\uffff\u0000\u024c\u024e\u0001\u0000\u0000\u0000\u024d\u024a\u0001\u0000"+
		"\u0000\u0000\u024d\u024e\u0001\u0000\u0000\u0000\u024e\u024f\u0001\u0000"+
		"\u0000\u0000\u024f\u025e\u0005\u001a\u0000\u0000\u0250\u0251\u0006\u0019"+
		"\uffff\uffff\u0000\u0251\u025a\u0005\u0017\u0000\u0000\u0252\u0253\u0003"+
		"0\u0018\u0000\u0253\u0254\u0006\u0019\uffff\uffff\u0000\u0254\u025b\u0001"+
		"\u0000\u0000\u0000\u0255\u0256\u0003(\u0014\u0000\u0256\u0257\u0006\u0019"+
		"\uffff\uffff\u0000\u0257\u0259\u0001\u0000\u0000\u0000\u0258\u0255\u0001"+
		"\u0000\u0000\u0000\u0258\u0259\u0001\u0000\u0000\u0000\u0259\u025b\u0001"+
		"\u0000\u0000\u0000\u025a\u0252\u0001\u0000\u0000\u0000\u025a\u0258\u0001"+
		"\u0000\u0000\u0000\u025b\u025c\u0001\u0000\u0000\u0000\u025c\u025e\u0005"+
		"\u0018\u0000\u0000\u025d\u0247\u0001\u0000\u0000\u0000\u025d\u0250\u0001"+
		"\u0000\u0000\u0000\u025e\u0275\u0001\u0000\u0000\u0000\u025f\u0260\n\u0002"+
		"\u0000\u0000\u0260\u0261\u0006\u0019\uffff\uffff\u0000\u0261\u0262\u0006"+
		"\u0019\uffff\uffff\u0000\u0262\u0266\u0005\u0019\u0000\u0000\u0263\u0264"+
		"\u0003\n\u0005\u0000\u0264\u0265\u0006\u0019\uffff\uffff\u0000\u0265\u0267"+
		"\u0001\u0000\u0000\u0000\u0266\u0263\u0001\u0000\u0000\u0000\u0266\u0267"+
		"\u0001\u0000\u0000\u0000\u0267\u0268\u0001\u0000\u0000\u0000\u0268\u0274"+
		"\u0005\u001a\u0000\u0000\u0269\u026a\n\u0001\u0000\u0000\u026a\u026b\u0006"+
		"\u0019\uffff\uffff\u0000\u026b\u026c\u0006\u0019\uffff\uffff\u0000\u026c"+
		"\u0270\u0005\u0017\u0000\u0000\u026d\u026e\u0003(\u0014\u0000\u026e\u026f"+
		"\u0006\u0019\uffff\uffff\u0000\u026f\u0271\u0001\u0000\u0000\u0000\u0270"+
		"\u026d\u0001\u0000\u0000\u0000\u0270\u0271\u0001\u0000\u0000\u0000\u0271"+
		"\u0272\u0001\u0000\u0000\u0000\u0272\u0274\u0005\u0018\u0000\u0000\u0273"+
		"\u025f\u0001\u0000\u0000\u0000\u0273\u0269\u0001\u0000\u0000\u0000\u0274"+
		"\u0277\u0001\u0000\u0000\u0000\u0275\u0273\u0001\u0000\u0000\u0000\u0275"+
		"\u0276\u0001\u0000\u0000\u0000\u02763\u0001\u0000\u0000\u0000\u0277\u0275"+
		"\u0001\u0000\u0000\u0000\u0278\u0279\u0006\u001a\uffff\uffff\u0000\u0279"+
		"\u027a\u0003\n\u0005\u0000\u027a\u027b\u0006\u001a\uffff\uffff\u0000\u027b"+
		"\u0286\u0001\u0000\u0000\u0000\u027c\u027d\u0006\u001a\uffff\uffff\u0000"+
		"\u027d\u027e\u0005\u001b\u0000\u0000\u027e\u027f\u00036\u001b\u0000\u027f"+
		"\u0281\u0006\u001a\uffff\uffff\u0000\u0280\u0282\u00054\u0000\u0000\u0281"+
		"\u0280\u0001\u0000\u0000\u0000\u0281\u0282\u0001\u0000\u0000\u0000\u0282"+
		"\u0283\u0001\u0000\u0000\u0000\u0283\u0284\u0005\u001c\u0000\u0000\u0284"+
		"\u0286\u0001\u0000\u0000\u0000\u0285\u0278\u0001\u0000\u0000\u0000\u0285"+
		"\u027c\u0001\u0000\u0000\u0000\u02865\u0001\u0000\u0000\u0000\u0287\u028b"+
		"\u0006\u001b\uffff\uffff\u0000\u0288\u0289\u00038\u001c\u0000\u0289\u028a"+
		"\u0006\u001b\uffff\uffff\u0000\u028a\u028c\u0001\u0000\u0000\u0000\u028b"+
		"\u0288\u0001\u0000\u0000\u0000\u028b\u028c\u0001\u0000\u0000\u0000\u028c"+
		"\u028d\u0001\u0000\u0000\u0000\u028d\u028e\u00034\u001a\u0000\u028e\u029a"+
		"\u0006\u001b\uffff\uffff\u0000\u028f\u0293\u00054\u0000\u0000\u0290\u0291"+
		"\u00038\u001c\u0000\u0291\u0292\u0006\u001b\uffff\uffff\u0000\u0292\u0294"+
		"\u0001\u0000\u0000\u0000\u0293\u0290\u0001\u0000\u0000\u0000\u0293\u0294"+
		"\u0001\u0000\u0000\u0000\u0294\u0295\u0001\u0000\u0000\u0000\u0295\u0296"+
		"\u00034\u001a\u0000\u0296\u0297\u0006\u001b\uffff\uffff\u0000\u0297\u0299"+
		"\u0001\u0000\u0000\u0000\u0298\u028f\u0001\u0000\u0000\u0000\u0299\u029c"+
		"\u0001\u0000\u0000\u0000\u029a\u0298\u0001\u0000\u0000\u0000\u029a\u029b"+
		"\u0001\u0000\u0000\u0000\u029b7\u0001\u0000\u0000\u0000\u029c\u029a\u0001"+
		"\u0000\u0000\u0000\u029d\u02a1\u0006\u001c\uffff\uffff\u0000\u029e\u029f"+
		"\u0003:\u001d\u0000\u029f\u02a0\u0006\u001c\uffff\uffff\u0000\u02a0\u02a2"+
		"\u0001\u0000\u0000\u0000\u02a1\u029e\u0001\u0000\u0000\u0000\u02a2\u02a3"+
		"\u0001\u0000\u0000\u0000\u02a3\u02a1\u0001\u0000\u0000\u0000\u02a3\u02a4"+
		"\u0001\u0000\u0000\u0000\u02a4\u02a5\u0001\u0000\u0000\u0000\u02a5\u02a6"+
		"\u00055\u0000\u0000\u02a69\u0001\u0000\u0000\u0000\u02a7\u02a8\u0006\u001d"+
		"\uffff\uffff\u0000\u02a8\u02a9\u0005\u0019\u0000\u0000\u02a9\u02aa\u0003"+
		"\n\u0005\u0000\u02aa\u02ab\u0005\u001a\u0000\u0000\u02ab\u02ac\u0006\u001d"+
		"\uffff\uffff\u0000\u02ac\u02b1\u0001\u0000\u0000\u0000\u02ad\u02ae\u0005"+
		"C\u0000\u0000\u02ae\u02af\u0005D\u0000\u0000\u02af\u02b1\u0006\u001d\uffff"+
		"\uffff\u0000\u02b0\u02a7\u0001\u0000\u0000\u0000\u02b0\u02ad\u0001\u0000"+
		"\u0000\u0000\u02b1;\u0001\u0000\u0000\u0000\u02b2\u02b3\u0003>\u001f\u0000"+
		"\u02b3\u02b4\u0006\u001e\uffff\uffff\u0000\u02b4\u02c2\u0001\u0000\u0000"+
		"\u0000\u02b5\u02b6\u0003B!\u0000\u02b6\u02b7\u0006\u001e\uffff\uffff\u0000"+
		"\u02b7\u02c2\u0001\u0000\u0000\u0000\u02b8\u02b9\u0003D\"\u0000\u02b9"+
		"\u02ba\u0006\u001e\uffff\uffff\u0000\u02ba\u02c2\u0001\u0000\u0000\u0000"+
		"\u02bb\u02bc\u0003F#\u0000\u02bc\u02bd\u0006\u001e\uffff\uffff\u0000\u02bd"+
		"\u02c2\u0001\u0000\u0000\u0000\u02be\u02bf\u0003N\'\u0000\u02bf\u02c0"+
		"\u0006\u001e\uffff\uffff\u0000\u02c0\u02c2\u0001\u0000\u0000\u0000\u02c1"+
		"\u02b2\u0001\u0000\u0000\u0000\u02c1\u02b5\u0001\u0000\u0000\u0000\u02c1"+
		"\u02b8\u0001\u0000\u0000\u0000\u02c1\u02bb\u0001\u0000\u0000\u0000\u02c1"+
		"\u02be\u0001\u0000\u0000\u0000\u02c2=\u0001\u0000\u0000\u0000\u02c3\u02c4"+
		"\u0006\u001f\uffff\uffff\u0000\u02c4\u02cc\u0005\u001b\u0000\u0000\u02c5"+
		"\u02c6\u0003@ \u0000\u02c6\u02c7\u0006\u001f\uffff\uffff\u0000\u02c7\u02c9"+
		"\u0001\u0000\u0000\u0000\u02c8\u02c5\u0001\u0000\u0000\u0000\u02c9\u02ca"+
		"\u0001\u0000\u0000\u0000\u02ca\u02c8\u0001\u0000\u0000\u0000\u02ca\u02cb"+
		"\u0001\u0000\u0000\u0000\u02cb\u02cd\u0001\u0000\u0000\u0000\u02cc\u02c8"+
		"\u0001\u0000\u0000\u0000\u02cc\u02cd\u0001\u0000\u0000\u0000\u02cd\u02ce"+
		"\u0001\u0000\u0000\u0000\u02ce\u02cf\u0005\u001c\u0000\u0000\u02cf?\u0001"+
		"\u0000\u0000\u0000\u02d0\u02d1\u0006 \uffff\uffff\u0000\u02d1\u02d2\u0003"+
		"<\u001e\u0000\u02d2\u02d3\u0006 \uffff\uffff\u0000\u02d3\u02d9\u0001\u0000"+
		"\u0000\u0000\u02d4\u02d5\u0006 \uffff\uffff\u0000\u02d5\u02d6\u0003\u0014"+
		"\n\u0000\u02d6\u02d7\u0006 \uffff\uffff\u0000\u02d7\u02d9\u0001\u0000"+
		"\u0000\u0000\u02d8\u02d0\u0001\u0000\u0000\u0000\u02d8\u02d4\u0001\u0000"+
		"\u0000\u0000\u02d9A\u0001\u0000\u0000\u0000\u02da\u02de\u0006!\uffff\uffff"+
		"\u0000\u02db\u02dc\u0003\n\u0005\u0000\u02dc\u02dd\u0006!\uffff\uffff"+
		"\u0000\u02dd\u02df\u0001\u0000\u0000\u0000\u02de\u02db\u0001\u0000\u0000"+
		"\u0000\u02de\u02df\u0001\u0000\u0000\u0000\u02df\u02e0\u0001\u0000\u0000"+
		"\u0000\u02e0\u02e1\u00053\u0000\u0000\u02e1C\u0001\u0000\u0000\u0000\u02e2"+
		"\u02e3\u0005\n\u0000\u0000\u02e3\u02e4\u0005\u0017\u0000\u0000\u02e4\u02e5"+
		"\u0003\n\u0005\u0000\u02e5\u02e6\u0005\u0018\u0000\u0000\u02e6\u02e7\u0003"+
		"<\u001e\u0000\u02e7\u02ec\u0006\"\uffff\uffff\u0000\u02e8\u02e9\u0005"+
		"\u0007\u0000\u0000\u02e9\u02ea\u0003<\u001e\u0000\u02ea\u02eb\u0006\""+
		"\uffff\uffff\u0000\u02eb\u02ed\u0001\u0000\u0000\u0000\u02ec\u02e8\u0001"+
		"\u0000\u0000\u0000\u02ec\u02ed\u0001\u0000\u0000\u0000\u02edE\u0001\u0000"+
		"\u0000\u0000\u02ee\u02ef\u0005\u0015\u0000\u0000\u02ef\u02f0\u0005\u0017"+
		"\u0000\u0000\u02f0\u02f1\u0003\n\u0005\u0000\u02f1\u02f2\u0005\u0018\u0000"+
		"\u0000\u02f2\u02f3\u0003<\u001e\u0000\u02f3\u02f4\u0006#\uffff\uffff\u0000"+
		"\u02f4\u0306\u0001\u0000\u0000\u0000\u02f5\u02f6\u0005\u0005\u0000\u0000"+
		"\u02f6\u02f7\u0003<\u001e\u0000\u02f7\u02f8\u0005\u0015\u0000\u0000\u02f8"+
		"\u02f9\u0005\u0017\u0000\u0000\u02f9\u02fa\u0003\n\u0005\u0000\u02fa\u02fb"+
		"\u0005\u0018\u0000\u0000\u02fb\u02fc\u00053\u0000\u0000\u02fc\u02fd\u0006"+
		"#\uffff\uffff\u0000\u02fd\u0306\u0001\u0000\u0000\u0000\u02fe\u02ff\u0005"+
		"\t\u0000\u0000\u02ff\u0300\u0005\u0017\u0000\u0000\u0300\u0301\u0003H"+
		"$\u0000\u0301\u0302\u0005\u0018\u0000\u0000\u0302\u0303\u0003<\u001e\u0000"+
		"\u0303\u0304\u0006#\uffff\uffff\u0000\u0304\u0306\u0001\u0000\u0000\u0000"+
		"\u0305\u02ee\u0001\u0000\u0000\u0000\u0305\u02f5\u0001\u0000\u0000\u0000"+
		"\u0305\u02fe\u0001\u0000\u0000\u0000\u0306G\u0001\u0000\u0000\u0000\u0307"+
		"\u0310\u0006$\uffff\uffff\u0000\u0308\u0309\u0003J%\u0000\u0309\u030a"+
		"\u0006$\uffff\uffff\u0000\u030a\u0311\u0001\u0000\u0000\u0000\u030b\u030c"+
		"\u0003\n\u0005\u0000\u030c\u030d\u0006$\uffff\uffff\u0000\u030d\u030f"+
		"\u0001\u0000\u0000\u0000\u030e\u030b\u0001\u0000\u0000\u0000\u030e\u030f"+
		"\u0001\u0000\u0000\u0000\u030f\u0311\u0001\u0000\u0000\u0000\u0310\u0308"+
		"\u0001\u0000\u0000\u0000\u0310\u030e\u0001\u0000\u0000\u0000\u0311\u0312"+
		"\u0001\u0000\u0000\u0000\u0312\u0316\u00053\u0000\u0000\u0313\u0314\u0003"+
		"L&\u0000\u0314\u0315\u0006$\uffff\uffff\u0000\u0315\u0317\u0001\u0000"+
		"\u0000\u0000\u0316\u0313\u0001\u0000\u0000\u0000\u0316\u0317\u0001\u0000"+
		"\u0000\u0000\u0317\u0318\u0001\u0000\u0000\u0000\u0318\u031c\u00053\u0000"+
		"\u0000\u0319\u031a\u0003L&\u0000\u031a\u031b\u0006$\uffff\uffff\u0000"+
		"\u031b\u031d\u0001\u0000\u0000\u0000\u031c\u0319\u0001\u0000\u0000\u0000"+
		"\u031c\u031d\u0001\u0000\u0000\u0000\u031dI\u0001\u0000\u0000\u0000\u031e"+
		"\u031f\u0003\u0016\u000b\u0000\u031f\u0323\u0006%\uffff\uffff\u0000\u0320"+
		"\u0321\u0003\u001a\r\u0000\u0321\u0322\u0006%\uffff\uffff\u0000\u0322"+
		"\u0324\u0001\u0000\u0000\u0000\u0323\u0320\u0001\u0000\u0000\u0000\u0323"+
		"\u0324\u0001\u0000\u0000\u0000\u0324K\u0001\u0000\u0000\u0000\u0325\u0326"+
		"\u0003\n\u0005\u0000\u0326\u032d\u0006&\uffff\uffff\u0000\u0327\u0328"+
		"\u00054\u0000\u0000\u0328\u0329\u0003\n\u0005\u0000\u0329\u032a\u0006"+
		"&\uffff\uffff\u0000\u032a\u032c\u0001\u0000\u0000\u0000\u032b\u0327\u0001"+
		"\u0000\u0000\u0000\u032c\u032f\u0001\u0000\u0000\u0000\u032d\u032b\u0001"+
		"\u0000\u0000\u0000\u032d\u032e\u0001\u0000\u0000\u0000\u032eM\u0001\u0000"+
		"\u0000\u0000\u032f\u032d\u0001\u0000\u0000\u0000\u0330\u0339\u0006\'\uffff"+
		"\uffff\u0000\u0331\u033a\u0005\u0004\u0000\u0000\u0332\u033a\u0005\u0001"+
		"\u0000\u0000\u0333\u0337\u0005\r\u0000\u0000\u0334\u0335\u0003\n\u0005"+
		"\u0000\u0335\u0336\u0006\'\uffff\uffff\u0000\u0336\u0338\u0001\u0000\u0000"+
		"\u0000\u0337\u0334\u0001\u0000\u0000\u0000\u0337\u0338\u0001\u0000\u0000"+
		"\u0000\u0338\u033a\u0001\u0000\u0000\u0000\u0339\u0331\u0001\u0000\u0000"+
		"\u0000\u0339\u0332\u0001\u0000\u0000\u0000\u0339\u0333\u0001\u0000\u0000"+
		"\u0000\u033a\u033b\u0001\u0000\u0000\u0000\u033b\u033c\u00053\u0000\u0000"+
		"\u033cO\u0001\u0000\u0000\u0000KT^hnu\u0080\u008a\u0099\u00a4\u00a6\u00b0"+
		"\u00be\u00cc\u00d5\u012d\u0136\u0138\u0143\u0152\u0163\u017b\u0182\u018c"+
		"\u0198\u01a2\u01ab\u01c3\u01ca\u01cf\u01d5\u01e4\u01ed\u01fa\u01fc\u01ff"+
		"\u0201\u0209\u020e\u0218\u0223\u0225\u022e\u0236\u0240\u0245\u024d\u0258"+
		"\u025a\u025d\u0266\u0270\u0273\u0275\u0281\u0285\u028b\u0293\u029a\u02a3"+
		"\u02b0\u02c1\u02ca\u02cc\u02d8\u02de\u02ec\u0305\u030e\u0310\u0316\u031c"+
		"\u0323\u032d\u0337\u0339";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}