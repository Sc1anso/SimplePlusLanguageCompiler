// Generated from C:/Users/valla/SimplePlus/src\SimplePlus.g4 by ANTLR 4.9.1
package gen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimplePlusLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, BOOL=30, ID=31, NUMBER=32, 
		WS=33, LINECOMMENTS=34, BLOCKCOMMENTS=35;
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
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "BOOL", "CHAR", "ID", "DIGIT", "NUMBER", 
			"WS", "LINECOMMENTS", "BLOCKCOMMENTS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "';'", "'('", "','", "')'", "'='", "'int'", "'bool'", 
			"'void'", "'var'", "'delete'", "'print'", "'return'", "'if'", "'else'", 
			"'-'", "'!'", "'*'", "'/'", "'+'", "'<'", "'<='", "'>'", "'>='", "'=='", 
			"'!='", "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "BOOL", "ID", "NUMBER", "WS", "LINECOMMENTS", 
			"BLOCKCOMMENTS"
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


	public SimplePlusLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SimplePlus.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2%\u00e7\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3"+
		"\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3"+
		"\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\5\37\u00b3\n\37\3 \3 \3!\3!\3!\7!\u00ba\n!\f!\16!\u00bd"+
		"\13!\3\"\3\"\3#\6#\u00c2\n#\r#\16#\u00c3\3$\3$\3$\3$\3%\3%\3%\3%\7%\u00ce"+
		"\n%\f%\16%\u00d1\13%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3&\7&\u00de\n&\f&\16"+
		"&\u00e1\13&\3&\3&\3&\3&\3&\2\2\'\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?\2A!C\2E\"G#I$K%\3\2\b\4\2C\\c|\5\2"+
		"\13\f\17\17\"\"\4\2\f\f\17\17\4\2,,\61\61\3\2,,\3\2\61\61\2\u00ed\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2A\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\3"+
		"M\3\2\2\2\5O\3\2\2\2\7Q\3\2\2\2\tS\3\2\2\2\13U\3\2\2\2\rW\3\2\2\2\17Y"+
		"\3\2\2\2\21[\3\2\2\2\23_\3\2\2\2\25d\3\2\2\2\27i\3\2\2\2\31m\3\2\2\2\33"+
		"t\3\2\2\2\35z\3\2\2\2\37\u0081\3\2\2\2!\u0084\3\2\2\2#\u0089\3\2\2\2%"+
		"\u008b\3\2\2\2\'\u008d\3\2\2\2)\u008f\3\2\2\2+\u0091\3\2\2\2-\u0093\3"+
		"\2\2\2/\u0095\3\2\2\2\61\u0098\3\2\2\2\63\u009a\3\2\2\2\65\u009d\3\2\2"+
		"\2\67\u00a0\3\2\2\29\u00a3\3\2\2\2;\u00a6\3\2\2\2=\u00b2\3\2\2\2?\u00b4"+
		"\3\2\2\2A\u00b6\3\2\2\2C\u00be\3\2\2\2E\u00c1\3\2\2\2G\u00c5\3\2\2\2I"+
		"\u00c9\3\2\2\2K\u00d4\3\2\2\2MN\7}\2\2N\4\3\2\2\2OP\7\177\2\2P\6\3\2\2"+
		"\2QR\7=\2\2R\b\3\2\2\2ST\7*\2\2T\n\3\2\2\2UV\7.\2\2V\f\3\2\2\2WX\7+\2"+
		"\2X\16\3\2\2\2YZ\7?\2\2Z\20\3\2\2\2[\\\7k\2\2\\]\7p\2\2]^\7v\2\2^\22\3"+
		"\2\2\2_`\7d\2\2`a\7q\2\2ab\7q\2\2bc\7n\2\2c\24\3\2\2\2de\7x\2\2ef\7q\2"+
		"\2fg\7k\2\2gh\7f\2\2h\26\3\2\2\2ij\7x\2\2jk\7c\2\2kl\7t\2\2l\30\3\2\2"+
		"\2mn\7f\2\2no\7g\2\2op\7n\2\2pq\7g\2\2qr\7v\2\2rs\7g\2\2s\32\3\2\2\2t"+
		"u\7r\2\2uv\7t\2\2vw\7k\2\2wx\7p\2\2xy\7v\2\2y\34\3\2\2\2z{\7t\2\2{|\7"+
		"g\2\2|}\7v\2\2}~\7w\2\2~\177\7t\2\2\177\u0080\7p\2\2\u0080\36\3\2\2\2"+
		"\u0081\u0082\7k\2\2\u0082\u0083\7h\2\2\u0083 \3\2\2\2\u0084\u0085\7g\2"+
		"\2\u0085\u0086\7n\2\2\u0086\u0087\7u\2\2\u0087\u0088\7g\2\2\u0088\"\3"+
		"\2\2\2\u0089\u008a\7/\2\2\u008a$\3\2\2\2\u008b\u008c\7#\2\2\u008c&\3\2"+
		"\2\2\u008d\u008e\7,\2\2\u008e(\3\2\2\2\u008f\u0090\7\61\2\2\u0090*\3\2"+
		"\2\2\u0091\u0092\7-\2\2\u0092,\3\2\2\2\u0093\u0094\7>\2\2\u0094.\3\2\2"+
		"\2\u0095\u0096\7>\2\2\u0096\u0097\7?\2\2\u0097\60\3\2\2\2\u0098\u0099"+
		"\7@\2\2\u0099\62\3\2\2\2\u009a\u009b\7@\2\2\u009b\u009c\7?\2\2\u009c\64"+
		"\3\2\2\2\u009d\u009e\7?\2\2\u009e\u009f\7?\2\2\u009f\66\3\2\2\2\u00a0"+
		"\u00a1\7#\2\2\u00a1\u00a2\7?\2\2\u00a28\3\2\2\2\u00a3\u00a4\7(\2\2\u00a4"+
		"\u00a5\7(\2\2\u00a5:\3\2\2\2\u00a6\u00a7\7~\2\2\u00a7\u00a8\7~\2\2\u00a8"+
		"<\3\2\2\2\u00a9\u00aa\7v\2\2\u00aa\u00ab\7t\2\2\u00ab\u00ac\7w\2\2\u00ac"+
		"\u00b3\7g\2\2\u00ad\u00ae\7h\2\2\u00ae\u00af\7c\2\2\u00af\u00b0\7n\2\2"+
		"\u00b0\u00b1\7u\2\2\u00b1\u00b3\7g\2\2\u00b2\u00a9\3\2\2\2\u00b2\u00ad"+
		"\3\2\2\2\u00b3>\3\2\2\2\u00b4\u00b5\t\2\2\2\u00b5@\3\2\2\2\u00b6\u00bb"+
		"\5? \2\u00b7\u00ba\5? \2\u00b8\u00ba\5C\"\2\u00b9\u00b7\3\2\2\2\u00b9"+
		"\u00b8\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2"+
		"\2\2\u00bcB\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00bf\4\62;\2\u00bfD\3\2"+
		"\2\2\u00c0\u00c2\5C\"\2\u00c1\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3"+
		"\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4F\3\2\2\2\u00c5\u00c6\t\3\2\2"+
		"\u00c6\u00c7\3\2\2\2\u00c7\u00c8\b$\2\2\u00c8H\3\2\2\2\u00c9\u00ca\7\61"+
		"\2\2\u00ca\u00cb\7\61\2\2\u00cb\u00cf\3\2\2\2\u00cc\u00ce\n\4\2\2\u00cd"+
		"\u00cc\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2"+
		"\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d3\b%\2\2\u00d3"+
		"J\3\2\2\2\u00d4\u00d5\7\61\2\2\u00d5\u00d6\7,\2\2\u00d6\u00df\3\2\2\2"+
		"\u00d7\u00de\n\5\2\2\u00d8\u00d9\7\61\2\2\u00d9\u00de\n\6\2\2\u00da\u00db"+
		"\7,\2\2\u00db\u00de\n\7\2\2\u00dc\u00de\5K&\2\u00dd\u00d7\3\2\2\2\u00dd"+
		"\u00d8\3\2\2\2\u00dd\u00da\3\2\2\2\u00dd\u00dc\3\2\2\2\u00de\u00e1\3\2"+
		"\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e2\3\2\2\2\u00e1"+
		"\u00df\3\2\2\2\u00e2\u00e3\7,\2\2\u00e3\u00e4\7\61\2\2\u00e4\u00e5\3\2"+
		"\2\2\u00e5\u00e6\b&\2\2\u00e6L\3\2\2\2\n\2\u00b2\u00b9\u00bb\u00c3\u00cf"+
		"\u00dd\u00df\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}