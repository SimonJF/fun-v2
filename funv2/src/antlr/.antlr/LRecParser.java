// Generated from /Users/simon.fowler/git-repos/fun-v2/funv2/src/antlr/LRec.g4 by ANTLR 4.13.1

package antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LRecParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, INT=3, MUL=4, DIV=5, SUB=6, ADD=7, EQ=8, BACKSLASH=9, 
		DOT=10, LET=11, IN=12, REC=13, FUN=14, TRUE=15, FALSE=16, EQQ=17, AND=18, 
		OR=19, LT=20, GT=21, IF=22, THEN=23, ELSE=24, IDENT=25, WS=26;
	public static final int
		RULE_expr = 0, RULE_base_expr = 1, RULE_prim = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"expr", "base_expr", "prim"
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

	@Override
	public String getGrammarFileName() { return "LRec.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LRecParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LetRecContext extends ExprContext {
		public TerminalNode LET() { return getToken(LRecParser.LET, 0); }
		public TerminalNode REC() { return getToken(LRecParser.REC, 0); }
		public List<TerminalNode> IDENT() { return getTokens(LRecParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(LRecParser.IDENT, i);
		}
		public TerminalNode EQ() { return getToken(LRecParser.EQ, 0); }
		public Base_exprContext base_expr() {
			return getRuleContext(Base_exprContext.class,0);
		}
		public TerminalNode IN() { return getToken(LRecParser.IN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LetRecContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).enterLetRec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).exitLetRec(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LetFunContext extends ExprContext {
		public TerminalNode LET() { return getToken(LRecParser.LET, 0); }
		public TerminalNode FUN() { return getToken(LRecParser.FUN, 0); }
		public List<TerminalNode> IDENT() { return getTokens(LRecParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(LRecParser.IDENT, i);
		}
		public TerminalNode EQ() { return getToken(LRecParser.EQ, 0); }
		public Base_exprContext base_expr() {
			return getRuleContext(Base_exprContext.class,0);
		}
		public TerminalNode IN() { return getToken(LRecParser.IN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LetFunContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).enterLetFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).exitLetFun(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BaseExprContext extends ExprContext {
		public Base_exprContext base_expr() {
			return getRuleContext(Base_exprContext.class,0);
		}
		public BaseExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).enterBaseExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).exitBaseExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LetContext extends ExprContext {
		public TerminalNode LET() { return getToken(LRecParser.LET, 0); }
		public TerminalNode IDENT() { return getToken(LRecParser.IDENT, 0); }
		public TerminalNode EQ() { return getToken(LRecParser.EQ, 0); }
		public Base_exprContext base_expr() {
			return getRuleContext(Base_exprContext.class,0);
		}
		public TerminalNode IN() { return getToken(LRecParser.IN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LetContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).enterLet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).exitLet(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expr);
		try {
			setState(32);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new LetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(6);
				match(LET);
				setState(7);
				match(IDENT);
				setState(8);
				match(EQ);
				setState(9);
				base_expr(0);
				setState(10);
				match(IN);
				setState(11);
				expr();
				}
				break;
			case 2:
				_localctx = new LetFunContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(13);
				match(LET);
				setState(14);
				match(FUN);
				setState(15);
				match(IDENT);
				setState(16);
				match(IDENT);
				setState(17);
				match(EQ);
				setState(18);
				base_expr(0);
				setState(19);
				match(IN);
				setState(20);
				expr();
				}
				break;
			case 3:
				_localctx = new LetRecContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(22);
				match(LET);
				setState(23);
				match(REC);
				setState(24);
				match(IDENT);
				setState(25);
				match(IDENT);
				setState(26);
				match(EQ);
				setState(27);
				base_expr(0);
				setState(28);
				match(IN);
				setState(29);
				expr();
				}
				break;
			case 4:
				_localctx = new BaseExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(31);
				base_expr(0);
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
	public static class Base_exprContext extends ParserRuleContext {
		public Base_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_expr; }
	 
		public Base_exprContext() { }
		public void copyFrom(Base_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AppContext extends Base_exprContext {
		public List<PrimContext> prim() {
			return getRuleContexts(PrimContext.class);
		}
		public PrimContext prim(int i) {
			return getRuleContext(PrimContext.class,i);
		}
		public AppContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).enterApp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).exitApp(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DivContext extends Base_exprContext {
		public List<Base_exprContext> base_expr() {
			return getRuleContexts(Base_exprContext.class);
		}
		public Base_exprContext base_expr(int i) {
			return getRuleContext(Base_exprContext.class,i);
		}
		public TerminalNode DIV() { return getToken(LRecParser.DIV, 0); }
		public DivContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).enterDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).exitDiv(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddContext extends Base_exprContext {
		public List<Base_exprContext> base_expr() {
			return getRuleContexts(Base_exprContext.class);
		}
		public Base_exprContext base_expr(int i) {
			return getRuleContext(Base_exprContext.class,i);
		}
		public TerminalNode ADD() { return getToken(LRecParser.ADD, 0); }
		public AddContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).exitAdd(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SubContext extends Base_exprContext {
		public List<Base_exprContext> base_expr() {
			return getRuleContexts(Base_exprContext.class);
		}
		public Base_exprContext base_expr(int i) {
			return getRuleContext(Base_exprContext.class,i);
		}
		public TerminalNode SUB() { return getToken(LRecParser.SUB, 0); }
		public SubContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).enterSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).exitSub(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CondContext extends Base_exprContext {
		public TerminalNode IF() { return getToken(LRecParser.IF, 0); }
		public Base_exprContext base_expr() {
			return getRuleContext(Base_exprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(LRecParser.THEN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(LRecParser.ELSE, 0); }
		public CondContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).enterCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).exitCond(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrContext extends Base_exprContext {
		public List<Base_exprContext> base_expr() {
			return getRuleContexts(Base_exprContext.class);
		}
		public Base_exprContext base_expr(int i) {
			return getRuleContext(Base_exprContext.class,i);
		}
		public TerminalNode OR() { return getToken(LRecParser.OR, 0); }
		public OrContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).exitOr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulContext extends Base_exprContext {
		public List<Base_exprContext> base_expr() {
			return getRuleContexts(Base_exprContext.class);
		}
		public Base_exprContext base_expr(int i) {
			return getRuleContext(Base_exprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(LRecParser.MUL, 0); }
		public MulContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).enterMul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).exitMul(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndContext extends Base_exprContext {
		public List<Base_exprContext> base_expr() {
			return getRuleContexts(Base_exprContext.class);
		}
		public Base_exprContext base_expr(int i) {
			return getRuleContext(Base_exprContext.class,i);
		}
		public TerminalNode AND() { return getToken(LRecParser.AND, 0); }
		public AndContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).exitAnd(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LtContext extends Base_exprContext {
		public List<Base_exprContext> base_expr() {
			return getRuleContexts(Base_exprContext.class);
		}
		public Base_exprContext base_expr(int i) {
			return getRuleContext(Base_exprContext.class,i);
		}
		public TerminalNode LT() { return getToken(LRecParser.LT, 0); }
		public LtContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).enterLt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).exitLt(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqContext extends Base_exprContext {
		public List<Base_exprContext> base_expr() {
			return getRuleContexts(Base_exprContext.class);
		}
		public Base_exprContext base_expr(int i) {
			return getRuleContext(Base_exprContext.class,i);
		}
		public TerminalNode EQQ() { return getToken(LRecParser.EQQ, 0); }
		public EqContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).enterEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).exitEq(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FactContext extends Base_exprContext {
		public PrimContext prim() {
			return getRuleContext(PrimContext.class,0);
		}
		public FactContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).enterFact(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).exitFact(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GtContext extends Base_exprContext {
		public List<Base_exprContext> base_expr() {
			return getRuleContexts(Base_exprContext.class);
		}
		public Base_exprContext base_expr(int i) {
			return getRuleContext(Base_exprContext.class,i);
		}
		public TerminalNode GT() { return getToken(LRecParser.GT, 0); }
		public GtContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).enterGt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).exitGt(this);
		}
	}

	public final Base_exprContext base_expr() throws RecognitionException {
		return base_expr(0);
	}

	private Base_exprContext base_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Base_exprContext _localctx = new Base_exprContext(_ctx, _parentState);
		Base_exprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_base_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				_localctx = new CondContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(35);
				match(IF);
				setState(36);
				base_expr(0);
				setState(37);
				match(THEN);
				setState(38);
				expr();
				setState(39);
				match(ELSE);
				setState(40);
				expr();
				}
				break;
			case 2:
				{
				_localctx = new AppContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(42);
				prim();
				setState(43);
				prim();
				}
				break;
			case 3:
				{
				_localctx = new FactContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(45);
				prim();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(77);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(75);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new DivContext(new Base_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_base_expr);
						setState(48);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(49);
						match(DIV);
						setState(50);
						base_expr(13);
						}
						break;
					case 2:
						{
						_localctx = new MulContext(new Base_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_base_expr);
						setState(51);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(52);
						match(MUL);
						setState(53);
						base_expr(12);
						}
						break;
					case 3:
						{
						_localctx = new AddContext(new Base_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_base_expr);
						setState(54);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(55);
						match(ADD);
						setState(56);
						base_expr(11);
						}
						break;
					case 4:
						{
						_localctx = new SubContext(new Base_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_base_expr);
						setState(57);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(58);
						match(SUB);
						setState(59);
						base_expr(10);
						}
						break;
					case 5:
						{
						_localctx = new EqContext(new Base_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_base_expr);
						setState(60);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(61);
						match(EQQ);
						setState(62);
						base_expr(9);
						}
						break;
					case 6:
						{
						_localctx = new LtContext(new Base_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_base_expr);
						setState(63);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(64);
						match(LT);
						setState(65);
						base_expr(8);
						}
						break;
					case 7:
						{
						_localctx = new GtContext(new Base_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_base_expr);
						setState(66);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(67);
						match(GT);
						setState(68);
						base_expr(7);
						}
						break;
					case 8:
						{
						_localctx = new AndContext(new Base_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_base_expr);
						setState(69);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(70);
						match(AND);
						setState(71);
						base_expr(6);
						}
						break;
					case 9:
						{
						_localctx = new OrContext(new Base_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_base_expr);
						setState(72);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(73);
						match(OR);
						setState(74);
						base_expr(5);
						}
						break;
					}
					} 
				}
				setState(79);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
	public static class PrimContext extends ParserRuleContext {
		public PrimContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prim; }
	 
		public PrimContext() { }
		public void copyFrom(PrimContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RecContext extends PrimContext {
		public TerminalNode REC() { return getToken(LRecParser.REC, 0); }
		public List<TerminalNode> IDENT() { return getTokens(LRecParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(LRecParser.IDENT, i);
		}
		public TerminalNode DOT() { return getToken(LRecParser.DOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RecContext(PrimContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).enterRec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).exitRec(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarContext extends PrimContext {
		public TerminalNode IDENT() { return getToken(LRecParser.IDENT, 0); }
		public VarContext(PrimContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).exitVar(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParensContext extends PrimContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParensContext(PrimContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).enterParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).exitParens(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrueContext extends PrimContext {
		public TerminalNode TRUE() { return getToken(LRecParser.TRUE, 0); }
		public TrueContext(PrimContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).enterTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).exitTrue(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FalseContext extends PrimContext {
		public TerminalNode FALSE() { return getToken(LRecParser.FALSE, 0); }
		public FalseContext(PrimContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).enterFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).exitFalse(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LambdaContext extends PrimContext {
		public TerminalNode BACKSLASH() { return getToken(LRecParser.BACKSLASH, 0); }
		public TerminalNode IDENT() { return getToken(LRecParser.IDENT, 0); }
		public TerminalNode DOT() { return getToken(LRecParser.DOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LambdaContext(PrimContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).enterLambda(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).exitLambda(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntContext extends PrimContext {
		public TerminalNode INT() { return getToken(LRecParser.INT, 0); }
		public IntContext(PrimContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LRecListener ) ((LRecListener)listener).exitInt(this);
		}
	}

	public final PrimContext prim() throws RecognitionException {
		PrimContext _localctx = new PrimContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_prim);
		try {
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BACKSLASH:
				_localctx = new LambdaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				match(BACKSLASH);
				setState(81);
				match(IDENT);
				setState(82);
				match(DOT);
				setState(83);
				expr();
				}
				break;
			case REC:
				_localctx = new RecContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				match(REC);
				setState(85);
				match(IDENT);
				setState(86);
				match(T__0);
				setState(87);
				match(IDENT);
				setState(88);
				match(T__1);
				setState(89);
				match(DOT);
				setState(90);
				expr();
				}
				break;
			case IDENT:
				_localctx = new VarContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(91);
				match(IDENT);
				}
				break;
			case INT:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(92);
				match(INT);
				}
				break;
			case TRUE:
				_localctx = new TrueContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(93);
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new FalseContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(94);
				match(FALSE);
				}
				break;
			case T__0:
				_localctx = new ParensContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(95);
				match(T__0);
				setState(96);
				expr();
				setState(97);
				match(T__1);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return base_expr_sempred((Base_exprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean base_expr_sempred(Base_exprContext _localctx, int predIndex) {
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
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001af\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000!\b\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001/\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001L\b"+
		"\u0001\n\u0001\f\u0001O\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002d\b\u0002\u0001"+
		"\u0002\u0000\u0001\u0002\u0003\u0000\u0002\u0004\u0000\u0000v\u0000 \u0001"+
		"\u0000\u0000\u0000\u0002.\u0001\u0000\u0000\u0000\u0004c\u0001\u0000\u0000"+
		"\u0000\u0006\u0007\u0005\u000b\u0000\u0000\u0007\b\u0005\u0019\u0000\u0000"+
		"\b\t\u0005\b\u0000\u0000\t\n\u0003\u0002\u0001\u0000\n\u000b\u0005\f\u0000"+
		"\u0000\u000b\f\u0003\u0000\u0000\u0000\f!\u0001\u0000\u0000\u0000\r\u000e"+
		"\u0005\u000b\u0000\u0000\u000e\u000f\u0005\u000e\u0000\u0000\u000f\u0010"+
		"\u0005\u0019\u0000\u0000\u0010\u0011\u0005\u0019\u0000\u0000\u0011\u0012"+
		"\u0005\b\u0000\u0000\u0012\u0013\u0003\u0002\u0001\u0000\u0013\u0014\u0005"+
		"\f\u0000\u0000\u0014\u0015\u0003\u0000\u0000\u0000\u0015!\u0001\u0000"+
		"\u0000\u0000\u0016\u0017\u0005\u000b\u0000\u0000\u0017\u0018\u0005\r\u0000"+
		"\u0000\u0018\u0019\u0005\u0019\u0000\u0000\u0019\u001a\u0005\u0019\u0000"+
		"\u0000\u001a\u001b\u0005\b\u0000\u0000\u001b\u001c\u0003\u0002\u0001\u0000"+
		"\u001c\u001d\u0005\f\u0000\u0000\u001d\u001e\u0003\u0000\u0000\u0000\u001e"+
		"!\u0001\u0000\u0000\u0000\u001f!\u0003\u0002\u0001\u0000 \u0006\u0001"+
		"\u0000\u0000\u0000 \r\u0001\u0000\u0000\u0000 \u0016\u0001\u0000\u0000"+
		"\u0000 \u001f\u0001\u0000\u0000\u0000!\u0001\u0001\u0000\u0000\u0000\""+
		"#\u0006\u0001\uffff\uffff\u0000#$\u0005\u0016\u0000\u0000$%\u0003\u0002"+
		"\u0001\u0000%&\u0005\u0017\u0000\u0000&\'\u0003\u0000\u0000\u0000\'(\u0005"+
		"\u0018\u0000\u0000()\u0003\u0000\u0000\u0000)/\u0001\u0000\u0000\u0000"+
		"*+\u0003\u0004\u0002\u0000+,\u0003\u0004\u0002\u0000,/\u0001\u0000\u0000"+
		"\u0000-/\u0003\u0004\u0002\u0000.\"\u0001\u0000\u0000\u0000.*\u0001\u0000"+
		"\u0000\u0000.-\u0001\u0000\u0000\u0000/M\u0001\u0000\u0000\u000001\n\f"+
		"\u0000\u000012\u0005\u0005\u0000\u00002L\u0003\u0002\u0001\r34\n\u000b"+
		"\u0000\u000045\u0005\u0004\u0000\u00005L\u0003\u0002\u0001\f67\n\n\u0000"+
		"\u000078\u0005\u0007\u0000\u00008L\u0003\u0002\u0001\u000b9:\n\t\u0000"+
		"\u0000:;\u0005\u0006\u0000\u0000;L\u0003\u0002\u0001\n<=\n\b\u0000\u0000"+
		"=>\u0005\u0011\u0000\u0000>L\u0003\u0002\u0001\t?@\n\u0007\u0000\u0000"+
		"@A\u0005\u0014\u0000\u0000AL\u0003\u0002\u0001\bBC\n\u0006\u0000\u0000"+
		"CD\u0005\u0015\u0000\u0000DL\u0003\u0002\u0001\u0007EF\n\u0005\u0000\u0000"+
		"FG\u0005\u0012\u0000\u0000GL\u0003\u0002\u0001\u0006HI\n\u0004\u0000\u0000"+
		"IJ\u0005\u0013\u0000\u0000JL\u0003\u0002\u0001\u0005K0\u0001\u0000\u0000"+
		"\u0000K3\u0001\u0000\u0000\u0000K6\u0001\u0000\u0000\u0000K9\u0001\u0000"+
		"\u0000\u0000K<\u0001\u0000\u0000\u0000K?\u0001\u0000\u0000\u0000KB\u0001"+
		"\u0000\u0000\u0000KE\u0001\u0000\u0000\u0000KH\u0001\u0000\u0000\u0000"+
		"LO\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000"+
		"\u0000N\u0003\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000PQ\u0005"+
		"\t\u0000\u0000QR\u0005\u0019\u0000\u0000RS\u0005\n\u0000\u0000Sd\u0003"+
		"\u0000\u0000\u0000TU\u0005\r\u0000\u0000UV\u0005\u0019\u0000\u0000VW\u0005"+
		"\u0001\u0000\u0000WX\u0005\u0019\u0000\u0000XY\u0005\u0002\u0000\u0000"+
		"YZ\u0005\n\u0000\u0000Zd\u0003\u0000\u0000\u0000[d\u0005\u0019\u0000\u0000"+
		"\\d\u0005\u0003\u0000\u0000]d\u0005\u000f\u0000\u0000^d\u0005\u0010\u0000"+
		"\u0000_`\u0005\u0001\u0000\u0000`a\u0003\u0000\u0000\u0000ab\u0005\u0002"+
		"\u0000\u0000bd\u0001\u0000\u0000\u0000cP\u0001\u0000\u0000\u0000cT\u0001"+
		"\u0000\u0000\u0000c[\u0001\u0000\u0000\u0000c\\\u0001\u0000\u0000\u0000"+
		"c]\u0001\u0000\u0000\u0000c^\u0001\u0000\u0000\u0000c_\u0001\u0000\u0000"+
		"\u0000d\u0005\u0001\u0000\u0000\u0000\u0005 .KMc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}