// Generated from F:/university/TA/plc/S04/miniProject-NameAnalysis/src/main/grammar/SimpleLang.g4 by ANTLR 4.13.2
package main.grammar;

    import main.ast.nodes.*;
    import main.ast.nodes.declaration.*;
    import main.ast.nodes.Stmt.*;
    import main.ast.nodes.expr.*;
    import main.ast.nodes.expr.operator.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class SimpleLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, MAIN=7, INT=8, IF=9, ELSE=10, 
		RETURN=11, LBRACE=12, RBRACE=13, SEMI=14, ASSIGN=15, PLUS=16, LPAR=17, 
		RPAR=18, ID=19, INT_VAL=20, WHITE_SPACE=21, LINE_COMMENT=22, BLOCK_COMMENT=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "MAIN", "INT", "IF", 
			"ELSE", "RETURN", "LBRACE", "RBRACE", "SEMI", "ASSIGN", "PLUS", "LPAR", 
			"RPAR", "ID", "INT_VAL", "WHITE_SPACE", "LINE_COMMENT", "BLOCK_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'FuncDec'", "'++'", "'--'", "'*'", "'/'", "'-'", "'main'", "'int'", 
			"'if'", "'else'", "'return'", "'{'", "'}'", "';'", "'='", "'+'", "'('", 
			"')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "MAIN", "INT", "IF", "ELSE", 
			"RETURN", "LBRACE", "RBRACE", "SEMI", "ASSIGN", "PLUS", "LPAR", "RPAR", 
			"ID", "INT_VAL", "WHITE_SPACE", "LINE_COMMENT", "BLOCK_COMMENT"
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


	public SimpleLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SimpleLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0017\u0095\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0005\u0012l\b\u0012\n\u0012"+
		"\f\u0012o\t\u0012\u0001\u0013\u0004\u0013r\b\u0013\u000b\u0013\f\u0013"+
		"s\u0001\u0014\u0004\u0014w\b\u0014\u000b\u0014\f\u0014x\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u0081"+
		"\b\u0015\n\u0015\f\u0015\u0084\t\u0015\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u008c\b\u0016\n\u0016"+
		"\f\u0016\u008f\t\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u008d\u0000\u0017\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015"+
		"\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012"+
		"%\u0013\'\u0014)\u0015+\u0016-\u0017\u0001\u0000\u0005\u0003\u0000AZ_"+
		"_az\u0004\u000009AZ__az\u0001\u000009\u0003\u0000\t\n\r\r  \u0002\u0000"+
		"\n\n\r\r\u0099\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%"+
		"\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000"+
		"\u0000\u0001/\u0001\u0000\u0000\u0000\u00037\u0001\u0000\u0000\u0000\u0005"+
		":\u0001\u0000\u0000\u0000\u0007=\u0001\u0000\u0000\u0000\t?\u0001\u0000"+
		"\u0000\u0000\u000bA\u0001\u0000\u0000\u0000\rC\u0001\u0000\u0000\u0000"+
		"\u000fH\u0001\u0000\u0000\u0000\u0011L\u0001\u0000\u0000\u0000\u0013O"+
		"\u0001\u0000\u0000\u0000\u0015T\u0001\u0000\u0000\u0000\u0017[\u0001\u0000"+
		"\u0000\u0000\u0019]\u0001\u0000\u0000\u0000\u001b_\u0001\u0000\u0000\u0000"+
		"\u001da\u0001\u0000\u0000\u0000\u001fc\u0001\u0000\u0000\u0000!e\u0001"+
		"\u0000\u0000\u0000#g\u0001\u0000\u0000\u0000%i\u0001\u0000\u0000\u0000"+
		"\'q\u0001\u0000\u0000\u0000)v\u0001\u0000\u0000\u0000+|\u0001\u0000\u0000"+
		"\u0000-\u0087\u0001\u0000\u0000\u0000/0\u0005F\u0000\u000001\u0005u\u0000"+
		"\u000012\u0005n\u0000\u000023\u0005c\u0000\u000034\u0005D\u0000\u0000"+
		"45\u0005e\u0000\u000056\u0005c\u0000\u00006\u0002\u0001\u0000\u0000\u0000"+
		"78\u0005+\u0000\u000089\u0005+\u0000\u00009\u0004\u0001\u0000\u0000\u0000"+
		":;\u0005-\u0000\u0000;<\u0005-\u0000\u0000<\u0006\u0001\u0000\u0000\u0000"+
		"=>\u0005*\u0000\u0000>\b\u0001\u0000\u0000\u0000?@\u0005/\u0000\u0000"+
		"@\n\u0001\u0000\u0000\u0000AB\u0005-\u0000\u0000B\f\u0001\u0000\u0000"+
		"\u0000CD\u0005m\u0000\u0000DE\u0005a\u0000\u0000EF\u0005i\u0000\u0000"+
		"FG\u0005n\u0000\u0000G\u000e\u0001\u0000\u0000\u0000HI\u0005i\u0000\u0000"+
		"IJ\u0005n\u0000\u0000JK\u0005t\u0000\u0000K\u0010\u0001\u0000\u0000\u0000"+
		"LM\u0005i\u0000\u0000MN\u0005f\u0000\u0000N\u0012\u0001\u0000\u0000\u0000"+
		"OP\u0005e\u0000\u0000PQ\u0005l\u0000\u0000QR\u0005s\u0000\u0000RS\u0005"+
		"e\u0000\u0000S\u0014\u0001\u0000\u0000\u0000TU\u0005r\u0000\u0000UV\u0005"+
		"e\u0000\u0000VW\u0005t\u0000\u0000WX\u0005u\u0000\u0000XY\u0005r\u0000"+
		"\u0000YZ\u0005n\u0000\u0000Z\u0016\u0001\u0000\u0000\u0000[\\\u0005{\u0000"+
		"\u0000\\\u0018\u0001\u0000\u0000\u0000]^\u0005}\u0000\u0000^\u001a\u0001"+
		"\u0000\u0000\u0000_`\u0005;\u0000\u0000`\u001c\u0001\u0000\u0000\u0000"+
		"ab\u0005=\u0000\u0000b\u001e\u0001\u0000\u0000\u0000cd\u0005+\u0000\u0000"+
		"d \u0001\u0000\u0000\u0000ef\u0005(\u0000\u0000f\"\u0001\u0000\u0000\u0000"+
		"gh\u0005)\u0000\u0000h$\u0001\u0000\u0000\u0000im\u0007\u0000\u0000\u0000"+
		"jl\u0007\u0001\u0000\u0000kj\u0001\u0000\u0000\u0000lo\u0001\u0000\u0000"+
		"\u0000mk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000n&\u0001\u0000"+
		"\u0000\u0000om\u0001\u0000\u0000\u0000pr\u0007\u0002\u0000\u0000qp\u0001"+
		"\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000"+
		"st\u0001\u0000\u0000\u0000t(\u0001\u0000\u0000\u0000uw\u0007\u0003\u0000"+
		"\u0000vu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xv\u0001\u0000"+
		"\u0000\u0000xy\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z{\u0006"+
		"\u0014\u0000\u0000{*\u0001\u0000\u0000\u0000|}\u0005/\u0000\u0000}~\u0005"+
		"/\u0000\u0000~\u0082\u0001\u0000\u0000\u0000\u007f\u0081\b\u0004\u0000"+
		"\u0000\u0080\u007f\u0001\u0000\u0000\u0000\u0081\u0084\u0001\u0000\u0000"+
		"\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000"+
		"\u0000\u0083\u0085\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000"+
		"\u0000\u0085\u0086\u0006\u0015\u0000\u0000\u0086,\u0001\u0000\u0000\u0000"+
		"\u0087\u0088\u0005/\u0000\u0000\u0088\u0089\u0005*\u0000\u0000\u0089\u008d"+
		"\u0001\u0000\u0000\u0000\u008a\u008c\t\u0000\u0000\u0000\u008b\u008a\u0001"+
		"\u0000\u0000\u0000\u008c\u008f\u0001\u0000\u0000\u0000\u008d\u008e\u0001"+
		"\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008e\u0090\u0001"+
		"\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u0090\u0091\u0005"+
		"*\u0000\u0000\u0091\u0092\u0005/\u0000\u0000\u0092\u0093\u0001\u0000\u0000"+
		"\u0000\u0093\u0094\u0006\u0016\u0000\u0000\u0094.\u0001\u0000\u0000\u0000"+
		"\u0006\u0000msx\u0082\u008d\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}