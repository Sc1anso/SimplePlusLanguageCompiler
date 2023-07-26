// Generated from C:/Users/valla/SimplePlus/src\SVM.g4 by ANTLR 4.9.1
package gen;

import java.util.HashMap;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SVMLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PUSH=1, POP=2, ADD=3, SUB=4, MULT=5, DIV=6, NEG=7, NOT=8, STOREW=9, LOADW=10, 
		BRANCH=11, BRANCHEQ=12, BRANCHNEQ=13, BRANCHLESS=14, BRANCHLESSEQ=15, 
		BRANCHMORE=16, BRANCHMOREQ=17, BRANCHAND=18, BRANCHOR=19, JS=20, LOADRA=21, 
		STORERA=22, LOADRV=23, STORERV=24, LOADFP=25, STOREFP=26, COPYFP=27, LOADHP=28, 
		STOREHP=29, RETURN=30, DELETE=31, PRINT=32, HALT=33, COL=34, LABEL=35, 
		NUMBER=36, WHITESP=37, ERR=38;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PUSH", "POP", "ADD", "SUB", "MULT", "DIV", "NEG", "NOT", "STOREW", "LOADW", 
			"BRANCH", "BRANCHEQ", "BRANCHNEQ", "BRANCHLESS", "BRANCHLESSEQ", "BRANCHMORE", 
			"BRANCHMOREQ", "BRANCHAND", "BRANCHOR", "JS", "LOADRA", "STORERA", "LOADRV", 
			"STORERV", "LOADFP", "STOREFP", "COPYFP", "LOADHP", "STOREHP", "RETURN", 
			"DELETE", "PRINT", "HALT", "COL", "LABEL", "NUMBER", "WHITESP", "ERR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'push'", "'pop'", "'add'", "'sub'", "'mult'", "'div'", "'neg'", 
			"'not'", "'sw'", "'lw'", "'b'", "'beq'", "'bneq'", "'bl'", "'bleq'", 
			"'bm'", "'bmeq'", "'band'", "'bor'", "'js'", "'lra'", "'sra'", "'lrv'", 
			"'srv'", "'lfp'", "'sfp'", "'cfp'", "'lhp'", "'shp'", "'ret'", "'del'", 
			"'print'", "'halt'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PUSH", "POP", "ADD", "SUB", "MULT", "DIV", "NEG", "NOT", "STOREW", 
			"LOADW", "BRANCH", "BRANCHEQ", "BRANCHNEQ", "BRANCHLESS", "BRANCHLESSEQ", 
			"BRANCHMORE", "BRANCHMOREQ", "BRANCHAND", "BRANCHOR", "JS", "LOADRA", 
			"STORERA", "LOADRV", "STORERV", "LOADFP", "STOREFP", "COPYFP", "LOADHP", 
			"STOREHP", "RETURN", "DELETE", "PRINT", "HALT", "COL", "LABEL", "NUMBER", 
			"WHITESP", "ERR"
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


	public int lexicalErrors=0;


	public SVMLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SVM.g4"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 37:
			ERR_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void ERR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 System.err.println("Invalid char: "+ getText()); lexicalErrors++;  
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2(\u00f7\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3"+
		"\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3"+
		"\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3"+
		"\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3"+
		"\"\3\"\3\"\3\"\3\"\3#\3#\3$\3$\7$\u00da\n$\f$\16$\u00dd\13$\3%\3%\5%\u00e1"+
		"\n%\3%\3%\7%\u00e5\n%\f%\16%\u00e8\13%\5%\u00ea\n%\3&\6&\u00ed\n&\r&\16"+
		"&\u00ee\3&\3&\3\'\3\'\3\'\3\'\3\'\2\2(\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(\3\2\5\4\2C\\"+
		"c|\5\2\62;C\\c|\5\2\13\f\17\17\"\"\2\u00fb\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M"+
		"\3\2\2\2\3O\3\2\2\2\5T\3\2\2\2\7X\3\2\2\2\t\\\3\2\2\2\13`\3\2\2\2\re\3"+
		"\2\2\2\17i\3\2\2\2\21m\3\2\2\2\23q\3\2\2\2\25t\3\2\2\2\27w\3\2\2\2\31"+
		"y\3\2\2\2\33}\3\2\2\2\35\u0082\3\2\2\2\37\u0085\3\2\2\2!\u008a\3\2\2\2"+
		"#\u008d\3\2\2\2%\u0092\3\2\2\2\'\u0097\3\2\2\2)\u009b\3\2\2\2+\u009e\3"+
		"\2\2\2-\u00a2\3\2\2\2/\u00a6\3\2\2\2\61\u00aa\3\2\2\2\63\u00ae\3\2\2\2"+
		"\65\u00b2\3\2\2\2\67\u00b6\3\2\2\29\u00ba\3\2\2\2;\u00be\3\2\2\2=\u00c2"+
		"\3\2\2\2?\u00c6\3\2\2\2A\u00ca\3\2\2\2C\u00d0\3\2\2\2E\u00d5\3\2\2\2G"+
		"\u00d7\3\2\2\2I\u00e9\3\2\2\2K\u00ec\3\2\2\2M\u00f2\3\2\2\2OP\7r\2\2P"+
		"Q\7w\2\2QR\7u\2\2RS\7j\2\2S\4\3\2\2\2TU\7r\2\2UV\7q\2\2VW\7r\2\2W\6\3"+
		"\2\2\2XY\7c\2\2YZ\7f\2\2Z[\7f\2\2[\b\3\2\2\2\\]\7u\2\2]^\7w\2\2^_\7d\2"+
		"\2_\n\3\2\2\2`a\7o\2\2ab\7w\2\2bc\7n\2\2cd\7v\2\2d\f\3\2\2\2ef\7f\2\2"+
		"fg\7k\2\2gh\7x\2\2h\16\3\2\2\2ij\7p\2\2jk\7g\2\2kl\7i\2\2l\20\3\2\2\2"+
		"mn\7p\2\2no\7q\2\2op\7v\2\2p\22\3\2\2\2qr\7u\2\2rs\7y\2\2s\24\3\2\2\2"+
		"tu\7n\2\2uv\7y\2\2v\26\3\2\2\2wx\7d\2\2x\30\3\2\2\2yz\7d\2\2z{\7g\2\2"+
		"{|\7s\2\2|\32\3\2\2\2}~\7d\2\2~\177\7p\2\2\177\u0080\7g\2\2\u0080\u0081"+
		"\7s\2\2\u0081\34\3\2\2\2\u0082\u0083\7d\2\2\u0083\u0084\7n\2\2\u0084\36"+
		"\3\2\2\2\u0085\u0086\7d\2\2\u0086\u0087\7n\2\2\u0087\u0088\7g\2\2\u0088"+
		"\u0089\7s\2\2\u0089 \3\2\2\2\u008a\u008b\7d\2\2\u008b\u008c\7o\2\2\u008c"+
		"\"\3\2\2\2\u008d\u008e\7d\2\2\u008e\u008f\7o\2\2\u008f\u0090\7g\2\2\u0090"+
		"\u0091\7s\2\2\u0091$\3\2\2\2\u0092\u0093\7d\2\2\u0093\u0094\7c\2\2\u0094"+
		"\u0095\7p\2\2\u0095\u0096\7f\2\2\u0096&\3\2\2\2\u0097\u0098\7d\2\2\u0098"+
		"\u0099\7q\2\2\u0099\u009a\7t\2\2\u009a(\3\2\2\2\u009b\u009c\7l\2\2\u009c"+
		"\u009d\7u\2\2\u009d*\3\2\2\2\u009e\u009f\7n\2\2\u009f\u00a0\7t\2\2\u00a0"+
		"\u00a1\7c\2\2\u00a1,\3\2\2\2\u00a2\u00a3\7u\2\2\u00a3\u00a4\7t\2\2\u00a4"+
		"\u00a5\7c\2\2\u00a5.\3\2\2\2\u00a6\u00a7\7n\2\2\u00a7\u00a8\7t\2\2\u00a8"+
		"\u00a9\7x\2\2\u00a9\60\3\2\2\2\u00aa\u00ab\7u\2\2\u00ab\u00ac\7t\2\2\u00ac"+
		"\u00ad\7x\2\2\u00ad\62\3\2\2\2\u00ae\u00af\7n\2\2\u00af\u00b0\7h\2\2\u00b0"+
		"\u00b1\7r\2\2\u00b1\64\3\2\2\2\u00b2\u00b3\7u\2\2\u00b3\u00b4\7h\2\2\u00b4"+
		"\u00b5\7r\2\2\u00b5\66\3\2\2\2\u00b6\u00b7\7e\2\2\u00b7\u00b8\7h\2\2\u00b8"+
		"\u00b9\7r\2\2\u00b98\3\2\2\2\u00ba\u00bb\7n\2\2\u00bb\u00bc\7j\2\2\u00bc"+
		"\u00bd\7r\2\2\u00bd:\3\2\2\2\u00be\u00bf\7u\2\2\u00bf\u00c0\7j\2\2\u00c0"+
		"\u00c1\7r\2\2\u00c1<\3\2\2\2\u00c2\u00c3\7t\2\2\u00c3\u00c4\7g\2\2\u00c4"+
		"\u00c5\7v\2\2\u00c5>\3\2\2\2\u00c6\u00c7\7f\2\2\u00c7\u00c8\7g\2\2\u00c8"+
		"\u00c9\7n\2\2\u00c9@\3\2\2\2\u00ca\u00cb\7r\2\2\u00cb\u00cc\7t\2\2\u00cc"+
		"\u00cd\7k\2\2\u00cd\u00ce\7p\2\2\u00ce\u00cf\7v\2\2\u00cfB\3\2\2\2\u00d0"+
		"\u00d1\7j\2\2\u00d1\u00d2\7c\2\2\u00d2\u00d3\7n\2\2\u00d3\u00d4\7v\2\2"+
		"\u00d4D\3\2\2\2\u00d5\u00d6\7<\2\2\u00d6F\3\2\2\2\u00d7\u00db\t\2\2\2"+
		"\u00d8\u00da\t\3\2\2\u00d9\u00d8\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9"+
		"\3\2\2\2\u00db\u00dc\3\2\2\2\u00dcH\3\2\2\2\u00dd\u00db\3\2\2\2\u00de"+
		"\u00ea\7\62\2\2\u00df\u00e1\7/\2\2\u00e0\u00df\3\2\2\2\u00e0\u00e1\3\2"+
		"\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e6\4\63;\2\u00e3\u00e5\4\62;\2\u00e4"+
		"\u00e3\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2"+
		"\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00de\3\2\2\2\u00e9"+
		"\u00e0\3\2\2\2\u00eaJ\3\2\2\2\u00eb\u00ed\t\4\2\2\u00ec\u00eb\3\2\2\2"+
		"\u00ed\u00ee\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0"+
		"\3\2\2\2\u00f0\u00f1\b&\2\2\u00f1L\3\2\2\2\u00f2\u00f3\13\2\2\2\u00f3"+
		"\u00f4\b\'\3\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\b\'\2\2\u00f6N\3\2\2\2"+
		"\b\2\u00db\u00e0\u00e6\u00e9\u00ee\4\2\3\2\3\'\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}