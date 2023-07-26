// Generated from C:/Users/valla/SimplePlus/src\SVM.g4 by ANTLR 4.9.1
package gen;

import java.util.HashMap;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SVMParser extends Parser {
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
	public static final int
		RULE_assembly = 0, RULE_instruction = 1;
	private static String[] makeRuleNames() {
		return new String[] {
			"assembly", "instruction"
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

	@Override
	public String getGrammarFileName() { return "SVM.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SVMParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class AssemblyContext extends ParserRuleContext {
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public AssemblyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assembly; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterAssembly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitAssembly(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitAssembly(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyContext assembly() throws RecognitionException {
		AssemblyContext _localctx = new AssemblyContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_assembly);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(7);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PUSH) | (1L << POP) | (1L << ADD) | (1L << SUB) | (1L << MULT) | (1L << DIV) | (1L << NEG) | (1L << STOREW) | (1L << LOADW) | (1L << BRANCH) | (1L << BRANCHEQ) | (1L << BRANCHNEQ) | (1L << BRANCHLESS) | (1L << BRANCHLESSEQ) | (1L << BRANCHMORE) | (1L << BRANCHMOREQ) | (1L << BRANCHAND) | (1L << BRANCHOR) | (1L << JS) | (1L << LOADRA) | (1L << STORERA) | (1L << LOADRV) | (1L << STORERV) | (1L << LOADFP) | (1L << STOREFP) | (1L << COPYFP) | (1L << LOADHP) | (1L << STOREHP) | (1L << RETURN) | (1L << DELETE) | (1L << PRINT) | (1L << HALT) | (1L << LABEL))) != 0)) {
				{
				{
				setState(4);
				instruction();
				}
				}
				setState(9);
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

	public static class InstructionContext extends ParserRuleContext {
		public Token n;
		public Token l;
		public TerminalNode PUSH() { return getToken(SVMParser.PUSH, 0); }
		public TerminalNode POP() { return getToken(SVMParser.POP, 0); }
		public TerminalNode ADD() { return getToken(SVMParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(SVMParser.SUB, 0); }
		public TerminalNode MULT() { return getToken(SVMParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(SVMParser.DIV, 0); }
		public TerminalNode NEG() { return getToken(SVMParser.NEG, 0); }
		public TerminalNode STOREW() { return getToken(SVMParser.STOREW, 0); }
		public TerminalNode LOADW() { return getToken(SVMParser.LOADW, 0); }
		public TerminalNode COL() { return getToken(SVMParser.COL, 0); }
		public TerminalNode BRANCH() { return getToken(SVMParser.BRANCH, 0); }
		public TerminalNode BRANCHEQ() { return getToken(SVMParser.BRANCHEQ, 0); }
		public TerminalNode BRANCHNEQ() { return getToken(SVMParser.BRANCHNEQ, 0); }
		public TerminalNode BRANCHLESS() { return getToken(SVMParser.BRANCHLESS, 0); }
		public TerminalNode BRANCHLESSEQ() { return getToken(SVMParser.BRANCHLESSEQ, 0); }
		public TerminalNode BRANCHMORE() { return getToken(SVMParser.BRANCHMORE, 0); }
		public TerminalNode BRANCHMOREQ() { return getToken(SVMParser.BRANCHMOREQ, 0); }
		public TerminalNode BRANCHAND() { return getToken(SVMParser.BRANCHAND, 0); }
		public TerminalNode BRANCHOR() { return getToken(SVMParser.BRANCHOR, 0); }
		public TerminalNode JS() { return getToken(SVMParser.JS, 0); }
		public TerminalNode LOADRA() { return getToken(SVMParser.LOADRA, 0); }
		public TerminalNode STORERA() { return getToken(SVMParser.STORERA, 0); }
		public TerminalNode LOADRV() { return getToken(SVMParser.LOADRV, 0); }
		public TerminalNode STORERV() { return getToken(SVMParser.STORERV, 0); }
		public TerminalNode LOADFP() { return getToken(SVMParser.LOADFP, 0); }
		public TerminalNode STOREFP() { return getToken(SVMParser.STOREFP, 0); }
		public TerminalNode COPYFP() { return getToken(SVMParser.COPYFP, 0); }
		public TerminalNode LOADHP() { return getToken(SVMParser.LOADHP, 0); }
		public TerminalNode STOREHP() { return getToken(SVMParser.STOREHP, 0); }
		public TerminalNode RETURN() { return getToken(SVMParser.RETURN, 0); }
		public TerminalNode DELETE() { return getToken(SVMParser.DELETE, 0); }
		public TerminalNode PRINT() { return getToken(SVMParser.PRINT, 0); }
		public TerminalNode HALT() { return getToken(SVMParser.HALT, 0); }
		public TerminalNode NUMBER() { return getToken(SVMParser.NUMBER, 0); }
		public TerminalNode LABEL() { return getToken(SVMParser.LABEL, 0); }
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(10);
				match(PUSH);
				setState(11);
				((InstructionContext)_localctx).n = match(NUMBER);
				}
				break;
			case 2:
				{
				setState(12);
				match(PUSH);
				setState(13);
				((InstructionContext)_localctx).l = match(LABEL);
				}
				break;
			case 3:
				{
				setState(14);
				match(POP);
				}
				break;
			case 4:
				{
				setState(15);
				match(ADD);
				}
				break;
			case 5:
				{
				setState(16);
				match(SUB);
				}
				break;
			case 6:
				{
				setState(17);
				match(MULT);
				}
				break;
			case 7:
				{
				setState(18);
				match(DIV);
				}
				break;
			case 8:
				{
				setState(19);
				match(NEG);
				}
				break;
			case 9:
				{
				setState(20);
				match(STOREW);
				}
				break;
			case 10:
				{
				setState(21);
				match(LOADW);
				}
				break;
			case 11:
				{
				setState(22);
				((InstructionContext)_localctx).l = match(LABEL);
				setState(23);
				match(COL);
				}
				break;
			case 12:
				{
				setState(24);
				match(BRANCH);
				setState(25);
				((InstructionContext)_localctx).l = match(LABEL);
				}
				break;
			case 13:
				{
				setState(26);
				match(BRANCHEQ);
				setState(27);
				((InstructionContext)_localctx).l = match(LABEL);
				}
				break;
			case 14:
				{
				setState(28);
				match(BRANCHNEQ);
				setState(29);
				((InstructionContext)_localctx).l = match(LABEL);
				}
				break;
			case 15:
				{
				setState(30);
				match(BRANCHLESS);
				setState(31);
				((InstructionContext)_localctx).l = match(LABEL);
				}
				break;
			case 16:
				{
				setState(32);
				match(BRANCHLESSEQ);
				setState(33);
				((InstructionContext)_localctx).l = match(LABEL);
				}
				break;
			case 17:
				{
				setState(34);
				match(BRANCHMORE);
				setState(35);
				((InstructionContext)_localctx).l = match(LABEL);
				}
				break;
			case 18:
				{
				setState(36);
				match(BRANCHMOREQ);
				setState(37);
				((InstructionContext)_localctx).l = match(LABEL);
				}
				break;
			case 19:
				{
				setState(38);
				match(BRANCHAND);
				setState(39);
				((InstructionContext)_localctx).l = match(LABEL);
				}
				break;
			case 20:
				{
				setState(40);
				match(BRANCHOR);
				setState(41);
				((InstructionContext)_localctx).l = match(LABEL);
				}
				break;
			case 21:
				{
				setState(42);
				match(JS);
				}
				break;
			case 22:
				{
				setState(43);
				match(LOADRA);
				}
				break;
			case 23:
				{
				setState(44);
				match(STORERA);
				}
				break;
			case 24:
				{
				setState(45);
				match(LOADRV);
				}
				break;
			case 25:
				{
				setState(46);
				match(STORERV);
				}
				break;
			case 26:
				{
				setState(47);
				match(LOADFP);
				}
				break;
			case 27:
				{
				setState(48);
				match(STOREFP);
				}
				break;
			case 28:
				{
				setState(49);
				match(COPYFP);
				}
				break;
			case 29:
				{
				setState(50);
				match(LOADHP);
				}
				break;
			case 30:
				{
				setState(51);
				match(STOREHP);
				}
				break;
			case 31:
				{
				setState(52);
				match(RETURN);
				}
				break;
			case 32:
				{
				setState(53);
				match(DELETE);
				}
				break;
			case 33:
				{
				setState(54);
				match(PRINT);
				}
				break;
			case 34:
				{
				setState(55);
				match(HALT);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(=\4\2\t\2\4\3\t\3"+
		"\3\2\7\2\b\n\2\f\2\16\2\13\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\5\3;\n\3\3\3\2\2\4\2\4\2\2\2\\\2\t\3\2\2\2\4:\3\2\2\2\6\b\5\4\3"+
		"\2\7\6\3\2\2\2\b\13\3\2\2\2\t\7\3\2\2\2\t\n\3\2\2\2\n\3\3\2\2\2\13\t\3"+
		"\2\2\2\f\r\7\3\2\2\r;\7&\2\2\16\17\7\3\2\2\17;\7%\2\2\20;\7\4\2\2\21;"+
		"\7\5\2\2\22;\7\6\2\2\23;\7\7\2\2\24;\7\b\2\2\25;\7\t\2\2\26;\7\13\2\2"+
		"\27;\7\f\2\2\30\31\7%\2\2\31;\7$\2\2\32\33\7\r\2\2\33;\7%\2\2\34\35\7"+
		"\16\2\2\35;\7%\2\2\36\37\7\17\2\2\37;\7%\2\2 !\7\20\2\2!;\7%\2\2\"#\7"+
		"\21\2\2#;\7%\2\2$%\7\22\2\2%;\7%\2\2&\'\7\23\2\2\';\7%\2\2()\7\24\2\2"+
		");\7%\2\2*+\7\25\2\2+;\7%\2\2,;\7\26\2\2-;\7\27\2\2.;\7\30\2\2/;\7\31"+
		"\2\2\60;\7\32\2\2\61;\7\33\2\2\62;\7\34\2\2\63;\7\35\2\2\64;\7\36\2\2"+
		"\65;\7\37\2\2\66;\7 \2\2\67;\7!\2\28;\7\"\2\29;\7#\2\2:\f\3\2\2\2:\16"+
		"\3\2\2\2:\20\3\2\2\2:\21\3\2\2\2:\22\3\2\2\2:\23\3\2\2\2:\24\3\2\2\2:"+
		"\25\3\2\2\2:\26\3\2\2\2:\27\3\2\2\2:\30\3\2\2\2:\32\3\2\2\2:\34\3\2\2"+
		"\2:\36\3\2\2\2: \3\2\2\2:\"\3\2\2\2:$\3\2\2\2:&\3\2\2\2:(\3\2\2\2:*\3"+
		"\2\2\2:,\3\2\2\2:-\3\2\2\2:.\3\2\2\2:/\3\2\2\2:\60\3\2\2\2:\61\3\2\2\2"+
		":\62\3\2\2\2:\63\3\2\2\2:\64\3\2\2\2:\65\3\2\2\2:\66\3\2\2\2:\67\3\2\2"+
		"\2:8\3\2\2\2:9\3\2\2\2;\5\3\2\2\2\4\t:";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}