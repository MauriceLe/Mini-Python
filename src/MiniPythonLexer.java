// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MiniPythonLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "INT", "BOOL", "STRING", "COMMENT", "IF", "ELIF", "ELSE", 
			"WHILE", "RETURN", "CLASS_", "DEF", "SELF", "END", "WS", "NL", "ID"
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


	public MiniPythonLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MiniPython.g4"; }

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
		"\u0004\u0000#\u00e0\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0004\u0013x\b\u0013\u000b"+
		"\u0013\f\u0013y\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0085"+
		"\b\u0014\u0001\u0015\u0001\u0015\u0005\u0015\u0089\b\u0015\n\u0015\f\u0015"+
		"\u008c\t\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u0091\b"+
		"\u0015\n\u0015\f\u0015\u0094\t\u0015\u0001\u0015\u0003\u0015\u0097\b\u0015"+
		"\u0001\u0016\u0001\u0016\u0005\u0016\u009b\b\u0016\n\u0016\f\u0016\u009e"+
		"\t\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0004 \u00cf"+
		"\b \u000b \f \u00d0\u0001 \u0001 \u0001!\u0004!\u00d6\b!\u000b!\f!\u00d7"+
		"\u0001\"\u0001\"\u0005\"\u00dc\b\"\n\"\f\"\u00df\t\"\u0002\u008a\u0092"+
		"\u0000#\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b"+
		"\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016"+
		"-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f? A!C\""+
		"E#\u0001\u0000\t\u0001\u000009\u0001\u0000\"\"\u0001\u0000\'\'\u0001\u0000"+
		"##\u0005\u0000  09AZ__az\u0002\u0000\t\t  \u0002\u0000\n\n\r\r\u0002\u0000"+
		"AZaz\u0004\u000009AZ__az\u00e8\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000"+
		"\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000"+
		"\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-"+
		"\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000"+
		"\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000"+
		"\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;"+
		"\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000"+
		"\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000\u0000"+
		"\u0000E\u0001\u0000\u0000\u0000\u0001G\u0001\u0000\u0000\u0000\u0003K"+
		"\u0001\u0000\u0000\u0000\u0005N\u0001\u0000\u0000\u0000\u0007R\u0001\u0000"+
		"\u0000\u0000\tT\u0001\u0000\u0000\u0000\u000bV\u0001\u0000\u0000\u0000"+
		"\rX\u0001\u0000\u0000\u0000\u000fZ\u0001\u0000\u0000\u0000\u0011\\\u0001"+
		"\u0000\u0000\u0000\u0013^\u0001\u0000\u0000\u0000\u0015a\u0001\u0000\u0000"+
		"\u0000\u0017d\u0001\u0000\u0000\u0000\u0019g\u0001\u0000\u0000\u0000\u001b"+
		"j\u0001\u0000\u0000\u0000\u001dl\u0001\u0000\u0000\u0000\u001fn\u0001"+
		"\u0000\u0000\u0000!p\u0001\u0000\u0000\u0000#r\u0001\u0000\u0000\u0000"+
		"%t\u0001\u0000\u0000\u0000\'w\u0001\u0000\u0000\u0000)\u0084\u0001\u0000"+
		"\u0000\u0000+\u0096\u0001\u0000\u0000\u0000-\u0098\u0001\u0000\u0000\u0000"+
		"/\u009f\u0001\u0000\u0000\u00001\u00a2\u0001\u0000\u0000\u00003\u00a7"+
		"\u0001\u0000\u0000\u00005\u00ac\u0001\u0000\u0000\u00007\u00b2\u0001\u0000"+
		"\u0000\u00009\u00b9\u0001\u0000\u0000\u0000;\u00bf\u0001\u0000\u0000\u0000"+
		"=\u00c3\u0001\u0000\u0000\u0000?\u00c8\u0001\u0000\u0000\u0000A\u00ce"+
		"\u0001\u0000\u0000\u0000C\u00d5\u0001\u0000\u0000\u0000E\u00d9\u0001\u0000"+
		"\u0000\u0000GH\u0005n\u0000\u0000HI\u0005o\u0000\u0000IJ\u0005t\u0000"+
		"\u0000J\u0002\u0001\u0000\u0000\u0000KL\u0005o\u0000\u0000LM\u0005r\u0000"+
		"\u0000M\u0004\u0001\u0000\u0000\u0000NO\u0005a\u0000\u0000OP\u0005n\u0000"+
		"\u0000PQ\u0005d\u0000\u0000Q\u0006\u0001\u0000\u0000\u0000RS\u0005*\u0000"+
		"\u0000S\b\u0001\u0000\u0000\u0000TU\u0005/\u0000\u0000U\n\u0001\u0000"+
		"\u0000\u0000VW\u0005+\u0000\u0000W\f\u0001\u0000\u0000\u0000XY\u0005-"+
		"\u0000\u0000Y\u000e\u0001\u0000\u0000\u0000Z[\u0005>\u0000\u0000[\u0010"+
		"\u0001\u0000\u0000\u0000\\]\u0005<\u0000\u0000]\u0012\u0001\u0000\u0000"+
		"\u0000^_\u0005=\u0000\u0000_`\u0005=\u0000\u0000`\u0014\u0001\u0000\u0000"+
		"\u0000ab\u0005!\u0000\u0000bc\u0005=\u0000\u0000c\u0016\u0001\u0000\u0000"+
		"\u0000de\u0005>\u0000\u0000ef\u0005=\u0000\u0000f\u0018\u0001\u0000\u0000"+
		"\u0000gh\u0005<\u0000\u0000hi\u0005=\u0000\u0000i\u001a\u0001\u0000\u0000"+
		"\u0000jk\u0005:\u0000\u0000k\u001c\u0001\u0000\u0000\u0000lm\u0005(\u0000"+
		"\u0000m\u001e\u0001\u0000\u0000\u0000no\u0005,\u0000\u0000o \u0001\u0000"+
		"\u0000\u0000pq\u0005)\u0000\u0000q\"\u0001\u0000\u0000\u0000rs\u0005."+
		"\u0000\u0000s$\u0001\u0000\u0000\u0000tu\u0005=\u0000\u0000u&\u0001\u0000"+
		"\u0000\u0000vx\u0007\u0000\u0000\u0000wv\u0001\u0000\u0000\u0000xy\u0001"+
		"\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000"+
		"z(\u0001\u0000\u0000\u0000{|\u0005T\u0000\u0000|}\u0005R\u0000\u0000}"+
		"~\u0005U\u0000\u0000~\u0085\u0005E\u0000\u0000\u007f\u0080\u0005F\u0000"+
		"\u0000\u0080\u0081\u0005A\u0000\u0000\u0081\u0082\u0005L\u0000\u0000\u0082"+
		"\u0083\u0005S\u0000\u0000\u0083\u0085\u0005E\u0000\u0000\u0084{\u0001"+
		"\u0000\u0000\u0000\u0084\u007f\u0001\u0000\u0000\u0000\u0085*\u0001\u0000"+
		"\u0000\u0000\u0086\u008a\u0007\u0001\u0000\u0000\u0087\u0089\t\u0000\u0000"+
		"\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0089\u008c\u0001\u0000\u0000"+
		"\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000"+
		"\u0000\u008b\u008d\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000"+
		"\u0000\u008d\u0097\u0007\u0001\u0000\u0000\u008e\u0092\u0007\u0002\u0000"+
		"\u0000\u008f\u0091\t\u0000\u0000\u0000\u0090\u008f\u0001\u0000\u0000\u0000"+
		"\u0091\u0094\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000\u0000\u0000"+
		"\u0092\u0090\u0001\u0000\u0000\u0000\u0093\u0095\u0001\u0000\u0000\u0000"+
		"\u0094\u0092\u0001\u0000\u0000\u0000\u0095\u0097\u0007\u0002\u0000\u0000"+
		"\u0096\u0086\u0001\u0000\u0000\u0000\u0096\u008e\u0001\u0000\u0000\u0000"+
		"\u0097,\u0001\u0000\u0000\u0000\u0098\u009c\u0007\u0003\u0000\u0000\u0099"+
		"\u009b\u0007\u0004\u0000\u0000\u009a\u0099\u0001\u0000\u0000\u0000\u009b"+
		"\u009e\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009c"+
		"\u009d\u0001\u0000\u0000\u0000\u009d.\u0001\u0000\u0000\u0000\u009e\u009c"+
		"\u0001\u0000\u0000\u0000\u009f\u00a0\u0005i\u0000\u0000\u00a0\u00a1\u0005"+
		"f\u0000\u0000\u00a10\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005e\u0000"+
		"\u0000\u00a3\u00a4\u0005l\u0000\u0000\u00a4\u00a5\u0005i\u0000\u0000\u00a5"+
		"\u00a6\u0005f\u0000\u0000\u00a62\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005"+
		"e\u0000\u0000\u00a8\u00a9\u0005l\u0000\u0000\u00a9\u00aa\u0005s\u0000"+
		"\u0000\u00aa\u00ab\u0005e\u0000\u0000\u00ab4\u0001\u0000\u0000\u0000\u00ac"+
		"\u00ad\u0005w\u0000\u0000\u00ad\u00ae\u0005h\u0000\u0000\u00ae\u00af\u0005"+
		"i\u0000\u0000\u00af\u00b0\u0005l\u0000\u0000\u00b0\u00b1\u0005e\u0000"+
		"\u0000\u00b16\u0001\u0000\u0000\u0000\u00b2\u00b3\u0005r\u0000\u0000\u00b3"+
		"\u00b4\u0005e\u0000\u0000\u00b4\u00b5\u0005t\u0000\u0000\u00b5\u00b6\u0005"+
		"u\u0000\u0000\u00b6\u00b7\u0005r\u0000\u0000\u00b7\u00b8\u0005n\u0000"+
		"\u0000\u00b88\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005c\u0000\u0000\u00ba"+
		"\u00bb\u0005l\u0000\u0000\u00bb\u00bc\u0005a\u0000\u0000\u00bc\u00bd\u0005"+
		"s\u0000\u0000\u00bd\u00be\u0005s\u0000\u0000\u00be:\u0001\u0000\u0000"+
		"\u0000\u00bf\u00c0\u0005d\u0000\u0000\u00c0\u00c1\u0005e\u0000\u0000\u00c1"+
		"\u00c2\u0005f\u0000\u0000\u00c2<\u0001\u0000\u0000\u0000\u00c3\u00c4\u0005"+
		"s\u0000\u0000\u00c4\u00c5\u0005e\u0000\u0000\u00c5\u00c6\u0005l\u0000"+
		"\u0000\u00c6\u00c7\u0005f\u0000\u0000\u00c7>\u0001\u0000\u0000\u0000\u00c8"+
		"\u00c9\u0005#\u0000\u0000\u00c9\u00ca\u0005e\u0000\u0000\u00ca\u00cb\u0005"+
		"n\u0000\u0000\u00cb\u00cc\u0005d\u0000\u0000\u00cc@\u0001\u0000\u0000"+
		"\u0000\u00cd\u00cf\u0007\u0005\u0000\u0000\u00ce\u00cd\u0001\u0000\u0000"+
		"\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000"+
		"\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000"+
		"\u0000\u00d2\u00d3\u0006 \u0000\u0000\u00d3B\u0001\u0000\u0000\u0000\u00d4"+
		"\u00d6\u0007\u0006\u0000\u0000\u00d5\u00d4\u0001\u0000\u0000\u0000\u00d6"+
		"\u00d7\u0001\u0000\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000\u00d7"+
		"\u00d8\u0001\u0000\u0000\u0000\u00d8D\u0001\u0000\u0000\u0000\u00d9\u00dd"+
		"\u0007\u0007\u0000\u0000\u00da\u00dc\u0007\b\u0000\u0000\u00db\u00da\u0001"+
		"\u0000\u0000\u0000\u00dc\u00df\u0001\u0000\u0000\u0000\u00dd\u00db\u0001"+
		"\u0000\u0000\u0000\u00dd\u00de\u0001\u0000\u0000\u0000\u00deF\u0001\u0000"+
		"\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\n\u0000y\u0084\u008a"+
		"\u0092\u0096\u009c\u00d0\u00d7\u00dd\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}