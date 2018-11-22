// Generated from FeatherweightJavaScript.g4 by ANTLR 4.4
 package edu.sjsu.fwjs.parser; 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FeatherweightJavaScriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__4=1, T__3=2, T__2=3, T__1=4, T__0=5, IF=6, ELSE=7, WHILE=8, FUNCTION=9, 
		VAR=10, PRINT=11, INT=12, BOOL=13, NULL=14, MUL=15, DIV=16, ADD=17, SUB=18, 
		MOD=19, SEPARATOR=20, ASSIGN=21, EQUAL=22, GREATER=23, LESS=24, GREATEREQUAL=25, 
		LESSEQUAL=26, IDENTIFIER=27, NEWLINE=28, BLOCK_COMMENT=29, LINE_COMMENT=30, 
		WS=31;
	public static final String[] tokenNames = {
		"<INVALID>", "'{'", "'}'", "'('", "')'", "','", "'if'", "'else'", "'while'", 
		"'function'", "'var'", "'print'", "INT", "BOOL", "'null'", "'*'", "'/'", 
		"'+'", "'-'", "'%'", "';'", "'='", "'=='", "'>'", "'<'", "'>='", "'<='", 
		"IDENTIFIER", "NEWLINE", "BLOCK_COMMENT", "LINE_COMMENT", "WS"
	};
	public static final int
		RULE_prog = 0, RULE_stat = 1, RULE_expr = 2, RULE_parameters = 3, RULE_arguments = 4, 
		RULE_block = 5;
	public static final String[] ruleNames = {
		"prog", "stat", "expr", "parameters", "arguments", "block"
	};

	@Override
	public String getGrammarFileName() { return "FeatherweightJavaScript.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FeatherweightJavaScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(12); stat();
				}
				}
				setState(15); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << IF) | (1L << WHILE) | (1L << FUNCTION) | (1L << VAR) | (1L << PRINT) | (1L << INT) | (1L << BOOL) | (1L << NULL) | (1L << SEPARATOR) | (1L << IDENTIFIER))) != 0) );
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

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BareexprContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEPARATOR() { return getToken(FeatherweightJavaScriptParser.SEPARATOR, 0); }
		public BareexprContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitBareexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintContext extends StatContext {
		public TerminalNode PRINT() { return getToken(FeatherweightJavaScriptParser.PRINT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEPARATOR() { return getToken(FeatherweightJavaScriptParser.SEPARATOR, 0); }
		public PrintContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfthenelseContext extends StatContext {
		public TerminalNode ELSE() { return getToken(FeatherweightJavaScriptParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(FeatherweightJavaScriptParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public IfthenelseContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitIfthenelse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfthenContext extends StatContext {
		public TerminalNode IF() { return getToken(FeatherweightJavaScriptParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IfthenContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitIfthen(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(FeatherweightJavaScriptParser.WHILE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SeperatorContext extends StatContext {
		public TerminalNode SEPARATOR() { return getToken(FeatherweightJavaScriptParser.SEPARATOR, 0); }
		public SeperatorContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitSeperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(48);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new BareexprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(17); expr(0);
				setState(18); match(SEPARATOR);
				}
				break;
			case 2:
				_localctx = new IfthenelseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(20); match(IF);
				setState(21); match(T__2);
				setState(22); expr(0);
				setState(23); match(T__1);
				setState(24); block();
				setState(25); match(ELSE);
				setState(26); block();
				}
				break;
			case 3:
				_localctx = new IfthenContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(28); match(IF);
				setState(29); match(T__2);
				setState(30); expr(0);
				setState(31); match(T__1);
				setState(32); block();
				}
				break;
			case 4:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(34); match(WHILE);
				setState(35); match(T__2);
				setState(36); expr(0);
				setState(37); match(T__1);
				setState(38); block();
				}
				break;
			case 5:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(40); match(PRINT);
				setState(41); match(T__2);
				setState(42); expr(0);
				setState(43); match(T__1);
				setState(45);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(44); match(SEPARATOR);
					}
					break;
				}
				}
				break;
			case 6:
				_localctx = new SeperatorContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(47); match(SEPARATOR);
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
	public static class VarassignContext extends ExprContext {
		public TerminalNode ASSIGN() { return getToken(FeatherweightJavaScriptParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(FeatherweightJavaScriptParser.IDENTIFIER, 0); }
		public VarassignContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitVarassign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParensContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullvalContext extends ExprContext {
		public TerminalNode NULL() { return getToken(FeatherweightJavaScriptParser.NULL, 0); }
		public NullvalContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitNullval(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MuldivmodContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MuldivmodContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitMuldivmod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualitiesContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EqualitiesContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitEqualities(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctioncallContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public FunctioncallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitFunctioncall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctiondeclarationContext extends ExprContext {
		public TerminalNode FUNCTION() { return getToken(FeatherweightJavaScriptParser.FUNCTION, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public FunctiondeclarationContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitFunctiondeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddsubContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddsubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitAddsub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolvalContext extends ExprContext {
		public TerminalNode BOOL() { return getToken(FeatherweightJavaScriptParser.BOOL, 0); }
		public BoolvalContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitBoolval(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarreferenceContext extends ExprContext {
		public TerminalNode IDENTIFIER() { return getToken(FeatherweightJavaScriptParser.IDENTIFIER, 0); }
		public VarreferenceContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitVarreference(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VardecelarationContext extends ExprContext {
		public TerminalNode ASSIGN() { return getToken(FeatherweightJavaScriptParser.ASSIGN, 0); }
		public TerminalNode VAR() { return getToken(FeatherweightJavaScriptParser.VAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(FeatherweightJavaScriptParser.IDENTIFIER, 0); }
		public VardecelarationContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitVardecelaration(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntContext extends ExprContext {
		public TerminalNode INT() { return getToken(FeatherweightJavaScriptParser.INT, 0); }
		public IntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new VardecelarationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(51); match(VAR);
				setState(52); match(IDENTIFIER);
				setState(53); match(ASSIGN);
				setState(54); expr(7);
				}
				break;
			case 2:
				{
				_localctx = new VarassignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(55); match(IDENTIFIER);
				setState(56); match(ASSIGN);
				setState(57); expr(5);
				}
				break;
			case 3:
				{
				_localctx = new FunctiondeclarationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(58); match(FUNCTION);
				setState(59); parameters();
				setState(60); match(T__4);
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << IF) | (1L << WHILE) | (1L << FUNCTION) | (1L << VAR) | (1L << PRINT) | (1L << INT) | (1L << BOOL) | (1L << NULL) | (1L << SEPARATOR) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(61); stat();
					}
					}
					setState(66);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(67); match(T__3);
				}
				break;
			case 4:
				{
				_localctx = new VarreferenceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(69); match(IDENTIFIER);
				}
				break;
			case 5:
				{
				_localctx = new BoolvalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(70); match(BOOL);
				}
				break;
			case 6:
				{
				_localctx = new NullvalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(71); match(NULL);
				}
				break;
			case 7:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(72); match(INT);
				}
				break;
			case 8:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(73); match(T__2);
				setState(74); expr(0);
				setState(75); match(T__1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(92);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(90);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new MuldivmodContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(79);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(80);
						((MuldivmodContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							((MuldivmodContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(81); expr(13);
						}
						break;
					case 2:
						{
						_localctx = new AddsubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(82);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(83);
						((AddsubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddsubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(84); expr(12);
						}
						break;
					case 3:
						{
						_localctx = new EqualitiesContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(85);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(86);
						((EqualitiesContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << GREATER) | (1L << LESS) | (1L << GREATEREQUAL) | (1L << LESSEQUAL))) != 0)) ) {
							((EqualitiesContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(87); expr(11);
						}
						break;
					case 4:
						{
						_localctx = new FunctioncallContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(88);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(89); arguments();
						}
						break;
					}
					} 
				}
				setState(94);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class ParametersContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER(int i) {
			return getToken(FeatherweightJavaScriptParser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(FeatherweightJavaScriptParser.IDENTIFIER); }
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95); match(T__2);
			setState(104);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(96); match(IDENTIFIER);
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(97); match(T__0);
					setState(98); match(IDENTIFIER);
					}
					}
					setState(103);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(106); match(T__1);
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

	public static class ArgumentsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108); match(T__2);
			setState(117);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << FUNCTION) | (1L << VAR) | (1L << INT) | (1L << BOOL) | (1L << NULL) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(109); expr(0);
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(110); match(T__0);
					setState(111); expr(0);
					}
					}
					setState(116);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(119); match(T__1);
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

	public static class BlockContext extends ParserRuleContext {
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	 
		public BlockContext() { }
		public void copyFrom(BlockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SimpblockContext extends BlockContext {
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public SimpblockContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitSimpblock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FullblockContext extends BlockContext {
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public FullblockContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitFullblock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		int _la;
		try {
			setState(130);
			switch (_input.LA(1)) {
			case T__4:
				_localctx = new FullblockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(121); match(T__4);
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << IF) | (1L << WHILE) | (1L << FUNCTION) | (1L << VAR) | (1L << PRINT) | (1L << INT) | (1L << BOOL) | (1L << NULL) | (1L << SEPARATOR) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(122); stat();
					}
					}
					setState(127);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(128); match(T__3);
				}
				break;
			case T__2:
			case IF:
			case WHILE:
			case FUNCTION:
			case VAR:
			case PRINT:
			case INT:
			case BOOL:
			case NULL:
			case SEPARATOR:
			case IDENTIFIER:
				_localctx = new SimpblockContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(129); stat();
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
		case 2: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 12);
		case 1: return precpred(_ctx, 11);
		case 2: return precpred(_ctx, 10);
		case 3: return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3!\u0087\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\6\2\20\n\2\r\2\16\2\21\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\60\n\3\3\3\5\3\63\n\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4A\n\4\f\4\16\4D\13\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4P\n\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\7\4]\n\4\f\4\16\4`\13\4\3\5\3\5\3\5\3\5\7\5f\n\5"+
		"\f\5\16\5i\13\5\5\5k\n\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6s\n\6\f\6\16\6v\13"+
		"\6\5\6x\n\6\3\6\3\6\3\7\3\7\7\7~\n\7\f\7\16\7\u0081\13\7\3\7\3\7\5\7\u0085"+
		"\n\7\3\7\2\3\6\b\2\4\6\b\n\f\2\5\4\2\21\22\25\25\3\2\23\24\3\2\30\34\u0099"+
		"\2\17\3\2\2\2\4\62\3\2\2\2\6O\3\2\2\2\ba\3\2\2\2\nn\3\2\2\2\f\u0084\3"+
		"\2\2\2\16\20\5\4\3\2\17\16\3\2\2\2\20\21\3\2\2\2\21\17\3\2\2\2\21\22\3"+
		"\2\2\2\22\3\3\2\2\2\23\24\5\6\4\2\24\25\7\26\2\2\25\63\3\2\2\2\26\27\7"+
		"\b\2\2\27\30\7\5\2\2\30\31\5\6\4\2\31\32\7\6\2\2\32\33\5\f\7\2\33\34\7"+
		"\t\2\2\34\35\5\f\7\2\35\63\3\2\2\2\36\37\7\b\2\2\37 \7\5\2\2 !\5\6\4\2"+
		"!\"\7\6\2\2\"#\5\f\7\2#\63\3\2\2\2$%\7\n\2\2%&\7\5\2\2&\'\5\6\4\2\'(\7"+
		"\6\2\2()\5\f\7\2)\63\3\2\2\2*+\7\r\2\2+,\7\5\2\2,-\5\6\4\2-/\7\6\2\2."+
		"\60\7\26\2\2/.\3\2\2\2/\60\3\2\2\2\60\63\3\2\2\2\61\63\7\26\2\2\62\23"+
		"\3\2\2\2\62\26\3\2\2\2\62\36\3\2\2\2\62$\3\2\2\2\62*\3\2\2\2\62\61\3\2"+
		"\2\2\63\5\3\2\2\2\64\65\b\4\1\2\65\66\7\f\2\2\66\67\7\35\2\2\678\7\27"+
		"\2\28P\5\6\4\t9:\7\35\2\2:;\7\27\2\2;P\5\6\4\7<=\7\13\2\2=>\5\b\5\2>B"+
		"\7\3\2\2?A\5\4\3\2@?\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2CE\3\2\2\2D"+
		"B\3\2\2\2EF\7\4\2\2FP\3\2\2\2GP\7\35\2\2HP\7\17\2\2IP\7\20\2\2JP\7\16"+
		"\2\2KL\7\5\2\2LM\5\6\4\2MN\7\6\2\2NP\3\2\2\2O\64\3\2\2\2O9\3\2\2\2O<\3"+
		"\2\2\2OG\3\2\2\2OH\3\2\2\2OI\3\2\2\2OJ\3\2\2\2OK\3\2\2\2P^\3\2\2\2QR\f"+
		"\16\2\2RS\t\2\2\2S]\5\6\4\17TU\f\r\2\2UV\t\3\2\2V]\5\6\4\16WX\f\f\2\2"+
		"XY\t\4\2\2Y]\5\6\4\rZ[\f\n\2\2[]\5\n\6\2\\Q\3\2\2\2\\T\3\2\2\2\\W\3\2"+
		"\2\2\\Z\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\7\3\2\2\2`^\3\2\2\2aj"+
		"\7\5\2\2bg\7\35\2\2cd\7\7\2\2df\7\35\2\2ec\3\2\2\2fi\3\2\2\2ge\3\2\2\2"+
		"gh\3\2\2\2hk\3\2\2\2ig\3\2\2\2jb\3\2\2\2jk\3\2\2\2kl\3\2\2\2lm\7\6\2\2"+
		"m\t\3\2\2\2nw\7\5\2\2ot\5\6\4\2pq\7\7\2\2qs\5\6\4\2rp\3\2\2\2sv\3\2\2"+
		"\2tr\3\2\2\2tu\3\2\2\2ux\3\2\2\2vt\3\2\2\2wo\3\2\2\2wx\3\2\2\2xy\3\2\2"+
		"\2yz\7\6\2\2z\13\3\2\2\2{\177\7\3\2\2|~\5\4\3\2}|\3\2\2\2~\u0081\3\2\2"+
		"\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0082\3\2\2\2\u0081\177\3\2\2"+
		"\2\u0082\u0085\7\4\2\2\u0083\u0085\5\4\3\2\u0084{\3\2\2\2\u0084\u0083"+
		"\3\2\2\2\u0085\r\3\2\2\2\17\21/\62BO\\^gjtw\177\u0084";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}