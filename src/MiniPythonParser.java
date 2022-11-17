// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MiniPythonParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, INT=20, BOOL=21, STRING=22, COMMENT=23, IF=24, ELIF=25, 
		ELSE=26, WHILE=27, RETURN=28, CLASS_=29, DEF=30, SELF=31, END=32, WS=33, 
		NL=34, ID=35;
	public static final int
		RULE_negation = 0, RULE_logic = 1, RULE_multi_div = 2, RULE_plus_minus = 3, 
		RULE_compare = 4, RULE_expression = 5, RULE_block = 6, RULE_param = 7, 
		RULE_if = 8, RULE_while = 9, RULE_method = 10, RULE_function = 11, RULE_object = 12, 
		RULE_assign = 13, RULE_statement = 14, RULE_def_function = 15, RULE_def_class = 16, 
		RULE_start = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"negation", "logic", "multi_div", "plus_minus", "compare", "expression", 
			"block", "param", "if", "while", "method", "function", "object", "assign", 
			"statement", "def_function", "def_class", "start"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'not'", "'or'", "'and'", "'*'", "'/'", "'+'", "'-'", "'>'", "'<'", 
			"'=='", "'!='", "'>='", "'<='", "':'", "'('", "','", "')'", "'.'", "'='", 
			null, null, null, null, "'if'", "'elif'", "'else'", "'while'", "'return'", 
			"'class'", "'def'", "'self'", "'#end'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "INT", "BOOL", "STRING", 
			"COMMENT", "IF", "ELIF", "ELSE", "WHILE", "RETURN", "CLASS_", "DEF", 
			"SELF", "END", "WS", "NL", "ID"
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
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniPythonParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NegationContext extends ParserRuleContext {
		public NegationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterNegation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitNegation(this);
		}
	}

	public final NegationContext negation() throws RecognitionException {
		NegationContext _localctx = new NegationContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_negation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(T__0);
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
	public static class LogicContext extends ParserRuleContext {
		public LogicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterLogic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitLogic(this);
		}
	}

	public final LogicContext logic() throws RecognitionException {
		LogicContext _localctx = new LogicContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_logic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			_la = _input.LA(1);
			if ( !(_la==T__1 || _la==T__2) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class Multi_divContext extends ParserRuleContext {
		public Multi_divContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multi_div; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterMulti_div(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitMulti_div(this);
		}
	}

	public final Multi_divContext multi_div() throws RecognitionException {
		Multi_divContext _localctx = new Multi_divContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_multi_div);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_la = _input.LA(1);
			if ( !(_la==T__3 || _la==T__4) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class Plus_minusContext extends ParserRuleContext {
		public Plus_minusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plus_minus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterPlus_minus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitPlus_minus(this);
		}
	}

	public final Plus_minusContext plus_minus() throws RecognitionException {
		Plus_minusContext _localctx = new Plus_minusContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_plus_minus);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_la = _input.LA(1);
			if ( !(_la==T__5 || _la==T__6) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class CompareContext extends ParserRuleContext {
		public CompareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterCompare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitCompare(this);
		}
	}

	public final CompareContext compare() throws RecognitionException {
		CompareContext _localctx = new CompareContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_compare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 16128L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class ExpressionContext extends ParserRuleContext {
		public NegationContext negation() {
			return getRuleContext(NegationContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ID() { return getToken(MiniPythonParser.ID, 0); }
		public TerminalNode INT() { return getToken(MiniPythonParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(MiniPythonParser.BOOL, 0); }
		public TerminalNode STRING() { return getToken(MiniPythonParser.STRING, 0); }
		public Multi_divContext multi_div() {
			return getRuleContext(Multi_divContext.class,0);
		}
		public Plus_minusContext plus_minus() {
			return getRuleContext(Plus_minusContext.class,0);
		}
		public LogicContext logic() {
			return getRuleContext(LogicContext.class,0);
		}
		public CompareContext compare() {
			return getRuleContext(CompareContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitExpression(this);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(47);
				negation();
				setState(48);
				expression(5);
				}
				break;
			case ID:
				{
				setState(50);
				match(ID);
				}
				break;
			case INT:
				{
				setState(51);
				match(INT);
				}
				break;
			case BOOL:
				{
				setState(52);
				match(BOOL);
				}
				break;
			case STRING:
				{
				setState(53);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(74);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(72);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(56);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(57);
						multi_div();
						setState(58);
						expression(10);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(60);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(61);
						plus_minus();
						setState(62);
						expression(9);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(64);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(65);
						logic();
						setState(66);
						expression(8);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(68);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(69);
						compare();
						setState(70);
						expression(7);
						}
						break;
					}
					} 
				}
				setState(76);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode NL() { return getToken(MiniPythonParser.NL, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T__13);
			setState(78);
			match(NL);
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 34510733312L) != 0) {
				{
				{
				setState(79);
				statement();
				}
				}
				setState(84);
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
	public static class ParamContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(T__14);
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 34367078402L) != 0) {
				{
				{
				setState(86);
				expression(0);
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15) {
				{
				{
				setState(92);
				match(T__15);
				setState(93);
				expression(0);
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(99);
			match(T__16);
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
	public static class IfContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MiniPythonParser.IF, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode END() { return getToken(MiniPythonParser.END, 0); }
		public List<TerminalNode> ELIF() { return getTokens(MiniPythonParser.ELIF); }
		public TerminalNode ELIF(int i) {
			return getToken(MiniPythonParser.ELIF, i);
		}
		public TerminalNode ELSE() { return getToken(MiniPythonParser.ELSE, 0); }
		public IfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitIf(this);
		}
	}

	public final IfContext if_() throws RecognitionException {
		IfContext _localctx = new IfContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_if);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(IF);
			setState(102);
			expression(0);
			setState(103);
			block();
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELIF) {
				{
				{
				setState(104);
				match(ELIF);
				setState(105);
				expression(0);
				setState(106);
				block();
				}
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(113);
				match(ELSE);
				setState(114);
				block();
				}
			}

			setState(117);
			match(END);
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
	public static class WhileContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MiniPythonParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NL() { return getToken(MiniPythonParser.NL, 0); }
		public TerminalNode END() { return getToken(MiniPythonParser.END, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public WhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitWhile(this);
		}
	}

	public final WhileContext while_() throws RecognitionException {
		WhileContext _localctx = new WhileContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_while);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(WHILE);
			setState(120);
			expression(0);
			setState(121);
			match(T__13);
			setState(122);
			match(NL);
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 34510733312L) != 0) {
				{
				{
				setState(123);
				statement();
				}
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(129);
			match(END);
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
	public static class MethodContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(MiniPythonParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MiniPythonParser.ID, i);
		}
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public TerminalNode NL() { return getToken(MiniPythonParser.NL, 0); }
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitMethod(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_method);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(ID);
			setState(132);
			match(T__17);
			setState(133);
			match(ID);
			setState(134);
			param();
			setState(135);
			match(NL);
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
	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniPythonParser.ID, 0); }
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public TerminalNode NL() { return getToken(MiniPythonParser.NL, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(ID);
			setState(138);
			param();
			setState(139);
			match(NL);
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
	public static class ObjectContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniPythonParser.ID, 0); }
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public TerminalNode NL() { return getToken(MiniPythonParser.NL, 0); }
		public ObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitObject(this);
		}
	}

	public final ObjectContext object() throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_object);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(ID);
			setState(142);
			param();
			setState(143);
			match(NL);
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
	public static class AssignContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniPythonParser.ID, 0); }
		public TerminalNode NL() { return getToken(MiniPythonParser.NL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitAssign(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(ID);
			setState(146);
			match(T__18);
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(147);
				expression(0);
				}
				break;
			case 2:
				{
				setState(148);
				object();
				}
				break;
			case 3:
				{
				setState(149);
				function();
				}
				break;
			case 4:
				{
				setState(150);
				method();
				}
				break;
			}
			setState(153);
			match(NL);
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
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public IfContext if_() {
			return getRuleContext(IfContext.class,0);
		}
		public WhileContext while_() {
			return getRuleContext(WhileContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_statement);
		try {
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				assign();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				if_();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(157);
				while_();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(158);
				function();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(159);
				method();
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
	public static class Def_functionContext extends ParserRuleContext {
		public TerminalNode DEF() { return getToken(MiniPythonParser.DEF, 0); }
		public List<TerminalNode> ID() { return getTokens(MiniPythonParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MiniPythonParser.ID, i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(MiniPythonParser.RETURN, 0); }
		public TerminalNode NL() { return getToken(MiniPythonParser.NL, 0); }
		public TerminalNode END() { return getToken(MiniPythonParser.END, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Def_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterDef_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitDef_function(this);
		}
	}

	public final Def_functionContext def_function() throws RecognitionException {
		Def_functionContext _localctx = new Def_functionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_def_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(DEF);
			setState(163);
			match(ID);
			setState(164);
			match(T__14);
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(165);
				match(ID);
				}
				}
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15) {
				{
				{
				setState(171);
				match(T__15);
				setState(172);
				match(ID);
				}
				}
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(178);
			match(T__16);
			setState(179);
			block();
			setState(180);
			match(RETURN);
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 34367078402L) != 0) {
				{
				setState(181);
				expression(0);
				}
			}

			setState(184);
			match(NL);
			setState(185);
			match(END);
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
	public static class Def_classContext extends ParserRuleContext {
		public TerminalNode CLASS_() { return getToken(MiniPythonParser.CLASS_, 0); }
		public List<TerminalNode> ID() { return getTokens(MiniPythonParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MiniPythonParser.ID, i);
		}
		public TerminalNode NL() { return getToken(MiniPythonParser.NL, 0); }
		public Def_functionContext def_function() {
			return getRuleContext(Def_functionContext.class,0);
		}
		public TerminalNode END() { return getToken(MiniPythonParser.END, 0); }
		public Def_classContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def_class; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterDef_class(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitDef_class(this);
		}
	}

	public final Def_classContext def_class() throws RecognitionException {
		Def_classContext _localctx = new Def_classContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_def_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(CLASS_);
			setState(188);
			match(ID);
			setState(189);
			match(T__14);
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(190);
				match(ID);
				}
			}

			setState(193);
			match(T__16);
			setState(194);
			match(T__13);
			setState(195);
			match(NL);
			setState(196);
			def_function();
			setState(197);
			match(END);
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
	public static class StartContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MiniPythonParser.EOF, 0); }
		public List<Def_functionContext> def_function() {
			return getRuleContexts(Def_functionContext.class);
		}
		public Def_functionContext def_function(int i) {
			return getRuleContext(Def_functionContext.class,i);
		}
		public List<Def_classContext> def_class() {
			return getRuleContexts(Def_classContext.class);
		}
		public Def_classContext def_class(int i) {
			return getRuleContext(Def_classContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> COMMENT() { return getTokens(MiniPythonParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(MiniPythonParser.COMMENT, i);
		}
		public List<TerminalNode> NL() { return getTokens(MiniPythonParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(MiniPythonParser.NL, i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 53309603840L) != 0) {
				{
				setState(204);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DEF:
					{
					setState(199);
					def_function();
					}
					break;
				case CLASS_:
					{
					setState(200);
					def_class();
					}
					break;
				case IF:
				case WHILE:
				case ID:
					{
					setState(201);
					statement();
					}
					break;
				case COMMENT:
					{
					setState(202);
					match(COMMENT);
					}
					break;
				case NL:
					{
					setState(203);
					match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(209);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001#\u00d4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u00057\b\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005I\b\u0005"+
		"\n\u0005\f\u0005L\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006"+
		"Q\b\u0006\n\u0006\f\u0006T\t\u0006\u0001\u0007\u0001\u0007\u0005\u0007"+
		"X\b\u0007\n\u0007\f\u0007[\t\u0007\u0001\u0007\u0001\u0007\u0005\u0007"+
		"_\b\u0007\n\u0007\f\u0007b\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\bm\b\b\n\b\f\bp\t\b\u0001"+
		"\b\u0001\b\u0003\bt\b\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0005\t}\b\t\n\t\f\t\u0080\t\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0003\r\u0098\b\r\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00a1\b\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00a7\b\u000f\n"+
		"\u000f\f\u000f\u00aa\t\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00ae"+
		"\b\u000f\n\u000f\f\u000f\u00b1\t\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u00b7\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00c0\b\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011"+
		"\u00cd\b\u0011\n\u0011\f\u0011\u00d0\t\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0000\u0001\n\u0012\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"\u0000\u0004\u0001\u0000\u0002"+
		"\u0003\u0001\u0000\u0004\u0005\u0001\u0000\u0006\u0007\u0001\u0000\b\r"+
		"\u00df\u0000$\u0001\u0000\u0000\u0000\u0002&\u0001\u0000\u0000\u0000\u0004"+
		"(\u0001\u0000\u0000\u0000\u0006*\u0001\u0000\u0000\u0000\b,\u0001\u0000"+
		"\u0000\u0000\n6\u0001\u0000\u0000\u0000\fM\u0001\u0000\u0000\u0000\u000e"+
		"U\u0001\u0000\u0000\u0000\u0010e\u0001\u0000\u0000\u0000\u0012w\u0001"+
		"\u0000\u0000\u0000\u0014\u0083\u0001\u0000\u0000\u0000\u0016\u0089\u0001"+
		"\u0000\u0000\u0000\u0018\u008d\u0001\u0000\u0000\u0000\u001a\u0091\u0001"+
		"\u0000\u0000\u0000\u001c\u00a0\u0001\u0000\u0000\u0000\u001e\u00a2\u0001"+
		"\u0000\u0000\u0000 \u00bb\u0001\u0000\u0000\u0000\"\u00ce\u0001\u0000"+
		"\u0000\u0000$%\u0005\u0001\u0000\u0000%\u0001\u0001\u0000\u0000\u0000"+
		"&\'\u0007\u0000\u0000\u0000\'\u0003\u0001\u0000\u0000\u0000()\u0007\u0001"+
		"\u0000\u0000)\u0005\u0001\u0000\u0000\u0000*+\u0007\u0002\u0000\u0000"+
		"+\u0007\u0001\u0000\u0000\u0000,-\u0007\u0003\u0000\u0000-\t\u0001\u0000"+
		"\u0000\u0000./\u0006\u0005\uffff\uffff\u0000/0\u0003\u0000\u0000\u0000"+
		"01\u0003\n\u0005\u000517\u0001\u0000\u0000\u000027\u0005#\u0000\u0000"+
		"37\u0005\u0014\u0000\u000047\u0005\u0015\u0000\u000057\u0005\u0016\u0000"+
		"\u00006.\u0001\u0000\u0000\u000062\u0001\u0000\u0000\u000063\u0001\u0000"+
		"\u0000\u000064\u0001\u0000\u0000\u000065\u0001\u0000\u0000\u00007J\u0001"+
		"\u0000\u0000\u000089\n\t\u0000\u00009:\u0003\u0004\u0002\u0000:;\u0003"+
		"\n\u0005\n;I\u0001\u0000\u0000\u0000<=\n\b\u0000\u0000=>\u0003\u0006\u0003"+
		"\u0000>?\u0003\n\u0005\t?I\u0001\u0000\u0000\u0000@A\n\u0007\u0000\u0000"+
		"AB\u0003\u0002\u0001\u0000BC\u0003\n\u0005\bCI\u0001\u0000\u0000\u0000"+
		"DE\n\u0006\u0000\u0000EF\u0003\b\u0004\u0000FG\u0003\n\u0005\u0007GI\u0001"+
		"\u0000\u0000\u0000H8\u0001\u0000\u0000\u0000H<\u0001\u0000\u0000\u0000"+
		"H@\u0001\u0000\u0000\u0000HD\u0001\u0000\u0000\u0000IL\u0001\u0000\u0000"+
		"\u0000JH\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000K\u000b\u0001"+
		"\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000MN\u0005\u000e\u0000\u0000"+
		"NR\u0005\"\u0000\u0000OQ\u0003\u001c\u000e\u0000PO\u0001\u0000\u0000\u0000"+
		"QT\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000"+
		"\u0000S\r\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000UY\u0005\u000f"+
		"\u0000\u0000VX\u0003\n\u0005\u0000WV\u0001\u0000\u0000\u0000X[\u0001\u0000"+
		"\u0000\u0000YW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z`\u0001"+
		"\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000\\]\u0005\u0010\u0000\u0000"+
		"]_\u0003\n\u0005\u0000^\\\u0001\u0000\u0000\u0000_b\u0001\u0000\u0000"+
		"\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000ac\u0001\u0000"+
		"\u0000\u0000b`\u0001\u0000\u0000\u0000cd\u0005\u0011\u0000\u0000d\u000f"+
		"\u0001\u0000\u0000\u0000ef\u0005\u0018\u0000\u0000fg\u0003\n\u0005\u0000"+
		"gn\u0003\f\u0006\u0000hi\u0005\u0019\u0000\u0000ij\u0003\n\u0005\u0000"+
		"jk\u0003\f\u0006\u0000km\u0001\u0000\u0000\u0000lh\u0001\u0000\u0000\u0000"+
		"mp\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000"+
		"\u0000os\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000qr\u0005\u001a"+
		"\u0000\u0000rt\u0003\f\u0006\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000"+
		"\u0000\u0000tu\u0001\u0000\u0000\u0000uv\u0005 \u0000\u0000v\u0011\u0001"+
		"\u0000\u0000\u0000wx\u0005\u001b\u0000\u0000xy\u0003\n\u0005\u0000yz\u0005"+
		"\u000e\u0000\u0000z~\u0005\"\u0000\u0000{}\u0003\u001c\u000e\u0000|{\u0001"+
		"\u0000\u0000\u0000}\u0080\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000"+
		"\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0081\u0001\u0000\u0000\u0000"+
		"\u0080~\u0001\u0000\u0000\u0000\u0081\u0082\u0005 \u0000\u0000\u0082\u0013"+
		"\u0001\u0000\u0000\u0000\u0083\u0084\u0005#\u0000\u0000\u0084\u0085\u0005"+
		"\u0012\u0000\u0000\u0085\u0086\u0005#\u0000\u0000\u0086\u0087\u0003\u000e"+
		"\u0007\u0000\u0087\u0088\u0005\"\u0000\u0000\u0088\u0015\u0001\u0000\u0000"+
		"\u0000\u0089\u008a\u0005#\u0000\u0000\u008a\u008b\u0003\u000e\u0007\u0000"+
		"\u008b\u008c\u0005\"\u0000\u0000\u008c\u0017\u0001\u0000\u0000\u0000\u008d"+
		"\u008e\u0005#\u0000\u0000\u008e\u008f\u0003\u000e\u0007\u0000\u008f\u0090"+
		"\u0005\"\u0000\u0000\u0090\u0019\u0001\u0000\u0000\u0000\u0091\u0092\u0005"+
		"#\u0000\u0000\u0092\u0097\u0005\u0013\u0000\u0000\u0093\u0098\u0003\n"+
		"\u0005\u0000\u0094\u0098\u0003\u0018\f\u0000\u0095\u0098\u0003\u0016\u000b"+
		"\u0000\u0096\u0098\u0003\u0014\n\u0000\u0097\u0093\u0001\u0000\u0000\u0000"+
		"\u0097\u0094\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000"+
		"\u0097\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000"+
		"\u0099\u009a\u0005\"\u0000\u0000\u009a\u001b\u0001\u0000\u0000\u0000\u009b"+
		"\u00a1\u0003\u001a\r\u0000\u009c\u00a1\u0003\u0010\b\u0000\u009d\u00a1"+
		"\u0003\u0012\t\u0000\u009e\u00a1\u0003\u0016\u000b\u0000\u009f\u00a1\u0003"+
		"\u0014\n\u0000\u00a0\u009b\u0001\u0000\u0000\u0000\u00a0\u009c\u0001\u0000"+
		"\u0000\u0000\u00a0\u009d\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000"+
		"\u0000\u0000\u00a0\u009f\u0001\u0000\u0000\u0000\u00a1\u001d\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a3\u0005\u001e\u0000\u0000\u00a3\u00a4\u0005#\u0000"+
		"\u0000\u00a4\u00a8\u0005\u000f\u0000\u0000\u00a5\u00a7\u0005#\u0000\u0000"+
		"\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a7\u00aa\u0001\u0000\u0000\u0000"+
		"\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000"+
		"\u00a9\u00af\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000"+
		"\u00ab\u00ac\u0005\u0010\u0000\u0000\u00ac\u00ae\u0005#\u0000\u0000\u00ad"+
		"\u00ab\u0001\u0000\u0000\u0000\u00ae\u00b1\u0001\u0000\u0000\u0000\u00af"+
		"\u00ad\u0001\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0"+
		"\u00b2\u0001\u0000\u0000\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b2"+
		"\u00b3\u0005\u0011\u0000\u0000\u00b3\u00b4\u0003\f\u0006\u0000\u00b4\u00b6"+
		"\u0005\u001c\u0000\u0000\u00b5\u00b7\u0003\n\u0005\u0000\u00b6\u00b5\u0001"+
		"\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001"+
		"\u0000\u0000\u0000\u00b8\u00b9\u0005\"\u0000\u0000\u00b9\u00ba\u0005 "+
		"\u0000\u0000\u00ba\u001f\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005\u001d"+
		"\u0000\u0000\u00bc\u00bd\u0005#\u0000\u0000\u00bd\u00bf\u0005\u000f\u0000"+
		"\u0000\u00be\u00c0\u0005#\u0000\u0000\u00bf\u00be\u0001\u0000\u0000\u0000"+
		"\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000"+
		"\u00c1\u00c2\u0005\u0011\u0000\u0000\u00c2\u00c3\u0005\u000e\u0000\u0000"+
		"\u00c3\u00c4\u0005\"\u0000\u0000\u00c4\u00c5\u0003\u001e\u000f\u0000\u00c5"+
		"\u00c6\u0005 \u0000\u0000\u00c6!\u0001\u0000\u0000\u0000\u00c7\u00cd\u0003"+
		"\u001e\u000f\u0000\u00c8\u00cd\u0003 \u0010\u0000\u00c9\u00cd\u0003\u001c"+
		"\u000e\u0000\u00ca\u00cd\u0005\u0017\u0000\u0000\u00cb\u00cd\u0005\"\u0000"+
		"\u0000\u00cc\u00c7\u0001\u0000\u0000\u0000\u00cc\u00c8\u0001\u0000\u0000"+
		"\u0000\u00cc\u00c9\u0001\u0000\u0000\u0000\u00cc\u00ca\u0001\u0000\u0000"+
		"\u0000\u00cc\u00cb\u0001\u0000\u0000\u0000\u00cd\u00d0\u0001\u0000\u0000"+
		"\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000"+
		"\u0000\u00cf\u00d1\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000"+
		"\u0000\u00d1\u00d2\u0005\u0000\u0000\u0001\u00d2#\u0001\u0000\u0000\u0000"+
		"\u00116HJRY`ns~\u0097\u00a0\u00a8\u00af\u00b6\u00bf\u00cc\u00ce";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}