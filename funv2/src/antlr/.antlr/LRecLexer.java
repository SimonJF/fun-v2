// Generated from /Users/simon.fowler/git-repos/fun-v2/funv2/src/antlr/Fun.g4 by ANTLR 4.13.1

package antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class LRecLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, INT=3, MUL=4, DIV=5, SUB=6, ADD=7, EQ=8, BACKSLASH=9, 
		DOT=10, LET=11, IN=12, REC=13, FUN=14, TRUE=15, FALSE=16, EQQ=17, AND=18, 
		OR=19, LT=20, GT=21, IF=22, THEN=23, ELSE=24, IDENT=25, WS=26;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "INT", "MUL", "DIV", "SUB", "ADD", "EQ", "BACKSLASH", 
			"DOT", "LET", "IN", "REC", "FUN", "TRUE", "FALSE", "EQQ", "AND", "OR", 
			"LT", "GT", "IF", "THEN", "ELSE", "IDENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", null, "'*'", "'/'", "'-'", "'+'", "'='", "'\\'", 
			"'.'", "'let'", "'in'", "'rec'", "'fun'", "'true'", "'false'", "'=='", 
			"'&&'", "'||'", "'<'", "'>'", "'if'", "'then'", "'else'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "INT", "MUL", "DIV", "SUB", "ADD", "EQ", "BACKSLASH", 
			"DOT", "LET", "IN", "REC", "FUN", "TRUE", "FALSE", "EQQ", "AND", "OR", 
			"LT", "GT", "IF", "THEN", "ELSE", "IDENT", "WS"
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


	public LRecLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Fun.g4"; }

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
		"\u0004\u0000\u001a\u008e\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0004\u0002;\b\u0002\u000b\u0002"+
		"\f\u0002<\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0005\u0018\u0083\b\u0018\n\u0018"+
		"\f\u0018\u0086\t\u0018\u0001\u0019\u0004\u0019\u0089\b\u0019\u000b\u0019"+
		"\f\u0019\u008a\u0001\u0019\u0001\u0019\u0000\u0000\u001a\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010"+
		"!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a"+
		"\u0001\u0000\u0004\u0001\u000009\u0001\u0000az\u0003\u000009AZaz\u0003"+
		"\u0000\t\n\r\r  \u0090\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000"+
		"\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000"+
		"\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000"+
		"\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000"+
		"\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000"+
		")\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001"+
		"\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000"+
		"\u0000\u00003\u0001\u0000\u0000\u0000\u00015\u0001\u0000\u0000\u0000\u0003"+
		"7\u0001\u0000\u0000\u0000\u0005:\u0001\u0000\u0000\u0000\u0007>\u0001"+
		"\u0000\u0000\u0000\t@\u0001\u0000\u0000\u0000\u000bB\u0001\u0000\u0000"+
		"\u0000\rD\u0001\u0000\u0000\u0000\u000fF\u0001\u0000\u0000\u0000\u0011"+
		"H\u0001\u0000\u0000\u0000\u0013J\u0001\u0000\u0000\u0000\u0015L\u0001"+
		"\u0000\u0000\u0000\u0017P\u0001\u0000\u0000\u0000\u0019S\u0001\u0000\u0000"+
		"\u0000\u001bW\u0001\u0000\u0000\u0000\u001d[\u0001\u0000\u0000\u0000\u001f"+
		"`\u0001\u0000\u0000\u0000!f\u0001\u0000\u0000\u0000#i\u0001\u0000\u0000"+
		"\u0000%l\u0001\u0000\u0000\u0000\'o\u0001\u0000\u0000\u0000)q\u0001\u0000"+
		"\u0000\u0000+s\u0001\u0000\u0000\u0000-v\u0001\u0000\u0000\u0000/{\u0001"+
		"\u0000\u0000\u00001\u0080\u0001\u0000\u0000\u00003\u0088\u0001\u0000\u0000"+
		"\u000056\u0005(\u0000\u00006\u0002\u0001\u0000\u0000\u000078\u0005)\u0000"+
		"\u00008\u0004\u0001\u0000\u0000\u00009;\u0007\u0000\u0000\u0000:9\u0001"+
		"\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000"+
		"<=\u0001\u0000\u0000\u0000=\u0006\u0001\u0000\u0000\u0000>?\u0005*\u0000"+
		"\u0000?\b\u0001\u0000\u0000\u0000@A\u0005/\u0000\u0000A\n\u0001\u0000"+
		"\u0000\u0000BC\u0005-\u0000\u0000C\f\u0001\u0000\u0000\u0000DE\u0005+"+
		"\u0000\u0000E\u000e\u0001\u0000\u0000\u0000FG\u0005=\u0000\u0000G\u0010"+
		"\u0001\u0000\u0000\u0000HI\u0005\\\u0000\u0000I\u0012\u0001\u0000\u0000"+
		"\u0000JK\u0005.\u0000\u0000K\u0014\u0001\u0000\u0000\u0000LM\u0005l\u0000"+
		"\u0000MN\u0005e\u0000\u0000NO\u0005t\u0000\u0000O\u0016\u0001\u0000\u0000"+
		"\u0000PQ\u0005i\u0000\u0000QR\u0005n\u0000\u0000R\u0018\u0001\u0000\u0000"+
		"\u0000ST\u0005r\u0000\u0000TU\u0005e\u0000\u0000UV\u0005c\u0000\u0000"+
		"V\u001a\u0001\u0000\u0000\u0000WX\u0005f\u0000\u0000XY\u0005u\u0000\u0000"+
		"YZ\u0005n\u0000\u0000Z\u001c\u0001\u0000\u0000\u0000[\\\u0005t\u0000\u0000"+
		"\\]\u0005r\u0000\u0000]^\u0005u\u0000\u0000^_\u0005e\u0000\u0000_\u001e"+
		"\u0001\u0000\u0000\u0000`a\u0005f\u0000\u0000ab\u0005a\u0000\u0000bc\u0005"+
		"l\u0000\u0000cd\u0005s\u0000\u0000de\u0005e\u0000\u0000e \u0001\u0000"+
		"\u0000\u0000fg\u0005=\u0000\u0000gh\u0005=\u0000\u0000h\"\u0001\u0000"+
		"\u0000\u0000ij\u0005&\u0000\u0000jk\u0005&\u0000\u0000k$\u0001\u0000\u0000"+
		"\u0000lm\u0005|\u0000\u0000mn\u0005|\u0000\u0000n&\u0001\u0000\u0000\u0000"+
		"op\u0005<\u0000\u0000p(\u0001\u0000\u0000\u0000qr\u0005>\u0000\u0000r"+
		"*\u0001\u0000\u0000\u0000st\u0005i\u0000\u0000tu\u0005f\u0000\u0000u,"+
		"\u0001\u0000\u0000\u0000vw\u0005t\u0000\u0000wx\u0005h\u0000\u0000xy\u0005"+
		"e\u0000\u0000yz\u0005n\u0000\u0000z.\u0001\u0000\u0000\u0000{|\u0005e"+
		"\u0000\u0000|}\u0005l\u0000\u0000}~\u0005s\u0000\u0000~\u007f\u0005e\u0000"+
		"\u0000\u007f0\u0001\u0000\u0000\u0000\u0080\u0084\u0007\u0001\u0000\u0000"+
		"\u0081\u0083\u0007\u0002\u0000\u0000\u0082\u0081\u0001\u0000\u0000\u0000"+
		"\u0083\u0086\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000"+
		"\u0084\u0085\u0001\u0000\u0000\u0000\u00852\u0001\u0000\u0000\u0000\u0086"+
		"\u0084\u0001\u0000\u0000\u0000\u0087\u0089\u0007\u0003\u0000\u0000\u0088"+
		"\u0087\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a"+
		"\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b"+
		"\u008c\u0001\u0000\u0000\u0000\u008c\u008d\u0006\u0019\u0000\u0000\u008d"+
		"4\u0001\u0000\u0000\u0000\u0004\u0000<\u0084\u008a\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}