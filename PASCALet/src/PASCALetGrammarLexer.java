// Generated from D:/Programming/Java_relateed/CMPILER_FINAL/PASCALet\PASCALetGrammar.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PASCALetGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PROGRAM=1, BEGIN=2, END=3, WRITE=4, WRITELN=5, READLN=6, PROCEDURE=7, 
		FUNCTION=8, FOR=9, TO=10, DO=11, IF=12, THEN=13, ELSE=14, VAR=15, STRING=16, 
		CHAR=17, INTEGER=18, BOOLEAN=19, ARRAY=20, OF=21, CONST=22, TRUE=23, FALSE=24, 
		AND=25, OR=26, NOT=27, LBRACKET=28, RBRACKET=29, LPAREN=30, RPAREN=31, 
		STAR=32, SLASH=33, MOD=34, PLUS=35, MINUS=36, EQUALS=37, NOTEQUALS=38, 
		GREATERTHAN=39, LESSTHAN=40, LESSTHANOREQUALS=41, GREATERTHANOREQUALS=42, 
		ASSIGNMENT=43, SEMICOLUMN=44, COLON=45, COMMA=46, IDENTIFIER=47, NUM_INT=48, 
		STRING_LITERAL=49, PERIOD=50, PERIODPERIOD=51, COMMENT1=52, COMMENT2=53, 
		WHITESPACES=54;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PROGRAM", "BEGIN", "END", "WRITE", "WRITELN", "READLN", "PROCEDURE", 
			"FUNCTION", "FOR", "TO", "DO", "IF", "THEN", "ELSE", "VAR", "STRING", 
			"CHAR", "INTEGER", "BOOLEAN", "ARRAY", "OF", "CONST", "TRUE", "FALSE", 
			"AND", "OR", "NOT", "LBRACKET", "RBRACKET", "LPAREN", "RPAREN", "STAR", 
			"SLASH", "MOD", "PLUS", "MINUS", "EQUALS", "NOTEQUALS", "GREATERTHAN", 
			"LESSTHAN", "LESSTHANOREQUALS", "GREATERTHANOREQUALS", "ASSIGNMENT", 
			"SEMICOLUMN", "COLON", "COMMA", "IDENTIFIER", "NUM_INT", "STRING_LITERAL", 
			"PERIOD", "PERIODPERIOD", "COMMENT1", "COMMENT2", "WHITESPACES", "A", 
			"B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", 
			"P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "'['", "']'", "'('", "')'", "'*'", "'/'", "'%'", 
			"'+'", "'-'", "'='", "'<>'", "'>'", "'<'", "'<='", "'>='", "':='", "';'", 
			"':'", "','", null, null, null, "'.'", "'..'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PROGRAM", "BEGIN", "END", "WRITE", "WRITELN", "READLN", "PROCEDURE", 
			"FUNCTION", "FOR", "TO", "DO", "IF", "THEN", "ELSE", "VAR", "STRING", 
			"CHAR", "INTEGER", "BOOLEAN", "ARRAY", "OF", "CONST", "TRUE", "FALSE", 
			"AND", "OR", "NOT", "LBRACKET", "RBRACKET", "LPAREN", "RPAREN", "STAR", 
			"SLASH", "MOD", "PLUS", "MINUS", "EQUALS", "NOTEQUALS", "GREATERTHAN", 
			"LESSTHAN", "LESSTHANOREQUALS", "GREATERTHANOREQUALS", "ASSIGNMENT", 
			"SEMICOLUMN", "COLON", "COMMA", "IDENTIFIER", "NUM_INT", "STRING_LITERAL", 
			"PERIOD", "PERIODPERIOD", "COMMENT1", "COMMENT2", "WHITESPACES"
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


	public PASCALetGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PASCALetGrammar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\28\u01ce\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3"+
		" \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3\'\3(\3(\3)\3)\3*\3*"+
		"\3*\3+\3+\3+\3,\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\7\60\u0166\n\60\f\60"+
		"\16\60\u0169\13\60\3\61\6\61\u016c\n\61\r\61\16\61\u016d\3\62\3\62\7\62"+
		"\u0172\n\62\f\62\16\62\u0175\13\62\3\62\3\62\3\63\3\63\3\64\3\64\3\64"+
		"\3\65\3\65\3\65\3\65\7\65\u0182\n\65\f\65\16\65\u0185\13\65\3\65\3\65"+
		"\3\65\3\65\3\65\3\66\3\66\7\66\u018e\n\66\f\66\16\66\u0191\13\66\3\66"+
		"\3\66\3\66\3\66\3\67\3\67\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3"+
		"=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3"+
		"I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P\3Q\3Q\5\u0173\u0183\u018f"+
		"\2R\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67"+
		"m8o\2q\2s\2u\2w\2y\2{\2}\2\177\2\u0081\2\u0083\2\u0085\2\u0087\2\u0089"+
		"\2\u008b\2\u008d\2\u008f\2\u0091\2\u0093\2\u0095\2\u0097\2\u0099\2\u009b"+
		"\2\u009d\2\u009f\2\u00a1\2\3\2\37\5\2C\\aac|\6\2\62;C\\aac|\5\2\13\f\17"+
		"\17\"\"\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJ"+
		"jj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2"+
		"SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4"+
		"\2\\\\||\2\u01b8\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2"+
		"\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2"+
		"\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k"+
		"\3\2\2\2\2m\3\2\2\2\3\u00a3\3\2\2\2\5\u00ab\3\2\2\2\7\u00b1\3\2\2\2\t"+
		"\u00b5\3\2\2\2\13\u00bb\3\2\2\2\r\u00c3\3\2\2\2\17\u00ca\3\2\2\2\21\u00d4"+
		"\3\2\2\2\23\u00dd\3\2\2\2\25\u00e1\3\2\2\2\27\u00e4\3\2\2\2\31\u00e7\3"+
		"\2\2\2\33\u00ea\3\2\2\2\35\u00ef\3\2\2\2\37\u00f4\3\2\2\2!\u00f8\3\2\2"+
		"\2#\u00ff\3\2\2\2%\u0104\3\2\2\2\'\u010c\3\2\2\2)\u0114\3\2\2\2+\u011a"+
		"\3\2\2\2-\u011d\3\2\2\2/\u0123\3\2\2\2\61\u0128\3\2\2\2\63\u012e\3\2\2"+
		"\2\65\u0132\3\2\2\2\67\u0135\3\2\2\29\u0139\3\2\2\2;\u013b\3\2\2\2=\u013d"+
		"\3\2\2\2?\u013f\3\2\2\2A\u0141\3\2\2\2C\u0143\3\2\2\2E\u0145\3\2\2\2G"+
		"\u0147\3\2\2\2I\u0149\3\2\2\2K\u014b\3\2\2\2M\u014d\3\2\2\2O\u0150\3\2"+
		"\2\2Q\u0152\3\2\2\2S\u0154\3\2\2\2U\u0157\3\2\2\2W\u015a\3\2\2\2Y\u015d"+
		"\3\2\2\2[\u015f\3\2\2\2]\u0161\3\2\2\2_\u0163\3\2\2\2a\u016b\3\2\2\2c"+
		"\u016f\3\2\2\2e\u0178\3\2\2\2g\u017a\3\2\2\2i\u017d\3\2\2\2k\u018b\3\2"+
		"\2\2m\u0196\3\2\2\2o\u019a\3\2\2\2q\u019c\3\2\2\2s\u019e\3\2\2\2u\u01a0"+
		"\3\2\2\2w\u01a2\3\2\2\2y\u01a4\3\2\2\2{\u01a6\3\2\2\2}\u01a8\3\2\2\2\177"+
		"\u01aa\3\2\2\2\u0081\u01ac\3\2\2\2\u0083\u01ae\3\2\2\2\u0085\u01b0\3\2"+
		"\2\2\u0087\u01b2\3\2\2\2\u0089\u01b4\3\2\2\2\u008b\u01b6\3\2\2\2\u008d"+
		"\u01b8\3\2\2\2\u008f\u01ba\3\2\2\2\u0091\u01bc\3\2\2\2\u0093\u01be\3\2"+
		"\2\2\u0095\u01c0\3\2\2\2\u0097\u01c2\3\2\2\2\u0099\u01c4\3\2\2\2\u009b"+
		"\u01c6\3\2\2\2\u009d\u01c8\3\2\2\2\u009f\u01ca\3\2\2\2\u00a1\u01cc\3\2"+
		"\2\2\u00a3\u00a4\5\u008dG\2\u00a4\u00a5\5\u0091I\2\u00a5\u00a6\5\u008b"+
		"F\2\u00a6\u00a7\5{>\2\u00a7\u00a8\5\u0091I\2\u00a8\u00a9\5o8\2\u00a9\u00aa"+
		"\5\u0087D\2\u00aa\4\3\2\2\2\u00ab\u00ac\5q9\2\u00ac\u00ad\5w<\2\u00ad"+
		"\u00ae\5{>\2\u00ae\u00af\5\177@\2\u00af\u00b0\5\u0089E\2\u00b0\6\3\2\2"+
		"\2\u00b1\u00b2\5w<\2\u00b2\u00b3\5\u0089E\2\u00b3\u00b4\5u;\2\u00b4\b"+
		"\3\2\2\2\u00b5\u00b6\5\u009bN\2\u00b6\u00b7\5\u0091I\2\u00b7\u00b8\5\177"+
		"@\2\u00b8\u00b9\5\u0095K\2\u00b9\u00ba\5w<\2\u00ba\n\3\2\2\2\u00bb\u00bc"+
		"\5\u009bN\2\u00bc\u00bd\5\u0091I\2\u00bd\u00be\5\177@\2\u00be\u00bf\5"+
		"\u0095K\2\u00bf\u00c0\5w<\2\u00c0\u00c1\5\u0085C\2\u00c1\u00c2\5\u0089"+
		"E\2\u00c2\f\3\2\2\2\u00c3\u00c4\5\u0091I\2\u00c4\u00c5\5w<\2\u00c5\u00c6"+
		"\5o8\2\u00c6\u00c7\5u;\2\u00c7\u00c8\5\u0085C\2\u00c8\u00c9\5\u0089E\2"+
		"\u00c9\16\3\2\2\2\u00ca\u00cb\5\u008dG\2\u00cb\u00cc\5\u0091I\2\u00cc"+
		"\u00cd\5\u008bF\2\u00cd\u00ce\5s:\2\u00ce\u00cf\5w<\2\u00cf\u00d0\5u;"+
		"\2\u00d0\u00d1\5\u0097L\2\u00d1\u00d2\5\u0091I\2\u00d2\u00d3\5w<\2\u00d3"+
		"\20\3\2\2\2\u00d4\u00d5\5y=\2\u00d5\u00d6\5\u0097L\2\u00d6\u00d7\5\u0089"+
		"E\2\u00d7\u00d8\5s:\2\u00d8\u00d9\5\u0095K\2\u00d9\u00da\5\177@\2\u00da"+
		"\u00db\5\u008bF\2\u00db\u00dc\5\u0089E\2\u00dc\22\3\2\2\2\u00dd\u00de"+
		"\5y=\2\u00de\u00df\5\u008bF\2\u00df\u00e0\5\u0091I\2\u00e0\24\3\2\2\2"+
		"\u00e1\u00e2\5\u0095K\2\u00e2\u00e3\5\u008bF\2\u00e3\26\3\2\2\2\u00e4"+
		"\u00e5\5u;\2\u00e5\u00e6\5\u008bF\2\u00e6\30\3\2\2\2\u00e7\u00e8\5\177"+
		"@\2\u00e8\u00e9\5y=\2\u00e9\32\3\2\2\2\u00ea\u00eb\5\u0095K\2\u00eb\u00ec"+
		"\5}?\2\u00ec\u00ed\5w<\2\u00ed\u00ee\5\u0089E\2\u00ee\34\3\2\2\2\u00ef"+
		"\u00f0\5w<\2\u00f0\u00f1\5\u0085C\2\u00f1\u00f2\5\u0093J\2\u00f2\u00f3"+
		"\5w<\2\u00f3\36\3\2\2\2\u00f4\u00f5\5\u0099M\2\u00f5\u00f6\5o8\2\u00f6"+
		"\u00f7\5\u0091I\2\u00f7 \3\2\2\2\u00f8\u00f9\5\u0093J\2\u00f9\u00fa\5"+
		"\u0095K\2\u00fa\u00fb\5\u0091I\2\u00fb\u00fc\5\177@\2\u00fc\u00fd\5\u0089"+
		"E\2\u00fd\u00fe\5{>\2\u00fe\"\3\2\2\2\u00ff\u0100\5s:\2\u0100\u0101\5"+
		"}?\2\u0101\u0102\5o8\2\u0102\u0103\5\u0091I\2\u0103$\3\2\2\2\u0104\u0105"+
		"\5\177@\2\u0105\u0106\5\u0089E\2\u0106\u0107\5\u0095K\2\u0107\u0108\5"+
		"w<\2\u0108\u0109\5{>\2\u0109\u010a\5w<\2\u010a\u010b\5\u0091I\2\u010b"+
		"&\3\2\2\2\u010c\u010d\5q9\2\u010d\u010e\5\u008bF\2\u010e\u010f\5\u008b"+
		"F\2\u010f\u0110\5\u0085C\2\u0110\u0111\5w<\2\u0111\u0112\5o8\2\u0112\u0113"+
		"\5\u0089E\2\u0113(\3\2\2\2\u0114\u0115\5o8\2\u0115\u0116\5\u0091I\2\u0116"+
		"\u0117\5\u0091I\2\u0117\u0118\5o8\2\u0118\u0119\5\u009fP\2\u0119*\3\2"+
		"\2\2\u011a\u011b\5\u008bF\2\u011b\u011c\5y=\2\u011c,\3\2\2\2\u011d\u011e"+
		"\5s:\2\u011e\u011f\5\u008bF\2\u011f\u0120\5\u0089E\2\u0120\u0121\5\u0093"+
		"J\2\u0121\u0122\5\u0095K\2\u0122.\3\2\2\2\u0123\u0124\5\u0095K\2\u0124"+
		"\u0125\5\u0091I\2\u0125\u0126\5\u0097L\2\u0126\u0127\5w<\2\u0127\60\3"+
		"\2\2\2\u0128\u0129\5y=\2\u0129\u012a\5o8\2\u012a\u012b\5\u0085C\2\u012b"+
		"\u012c\5\u0093J\2\u012c\u012d\5w<\2\u012d\62\3\2\2\2\u012e\u012f\5o8\2"+
		"\u012f\u0130\5\u0089E\2\u0130\u0131\5u;\2\u0131\64\3\2\2\2\u0132\u0133"+
		"\5\u008bF\2\u0133\u0134\5\u0091I\2\u0134\66\3\2\2\2\u0135\u0136\5\u0089"+
		"E\2\u0136\u0137\5\u008bF\2\u0137\u0138\5\u0095K\2\u01388\3\2\2\2\u0139"+
		"\u013a\7]\2\2\u013a:\3\2\2\2\u013b\u013c\7_\2\2\u013c<\3\2\2\2\u013d\u013e"+
		"\7*\2\2\u013e>\3\2\2\2\u013f\u0140\7+\2\2\u0140@\3\2\2\2\u0141\u0142\7"+
		",\2\2\u0142B\3\2\2\2\u0143\u0144\7\61\2\2\u0144D\3\2\2\2\u0145\u0146\7"+
		"\'\2\2\u0146F\3\2\2\2\u0147\u0148\7-\2\2\u0148H\3\2\2\2\u0149\u014a\7"+
		"/\2\2\u014aJ\3\2\2\2\u014b\u014c\7?\2\2\u014cL\3\2\2\2\u014d\u014e\7>"+
		"\2\2\u014e\u014f\7@\2\2\u014fN\3\2\2\2\u0150\u0151\7@\2\2\u0151P\3\2\2"+
		"\2\u0152\u0153\7>\2\2\u0153R\3\2\2\2\u0154\u0155\7>\2\2\u0155\u0156\7"+
		"?\2\2\u0156T\3\2\2\2\u0157\u0158\7@\2\2\u0158\u0159\7?\2\2\u0159V\3\2"+
		"\2\2\u015a\u015b\7<\2\2\u015b\u015c\7?\2\2\u015cX\3\2\2\2\u015d\u015e"+
		"\7=\2\2\u015eZ\3\2\2\2\u015f\u0160\7<\2\2\u0160\\\3\2\2\2\u0161\u0162"+
		"\7.\2\2\u0162^\3\2\2\2\u0163\u0167\t\2\2\2\u0164\u0166\t\3\2\2\u0165\u0164"+
		"\3\2\2\2\u0166\u0169\3\2\2\2\u0167\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168"+
		"`\3\2\2\2\u0169\u0167\3\2\2\2\u016a\u016c\4\62;\2\u016b\u016a\3\2\2\2"+
		"\u016c\u016d\3\2\2\2\u016d\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016eb\3"+
		"\2\2\2\u016f\u0173\7)\2\2\u0170\u0172\13\2\2\2\u0171\u0170\3\2\2\2\u0172"+
		"\u0175\3\2\2\2\u0173\u0174\3\2\2\2\u0173\u0171\3\2\2\2\u0174\u0176\3\2"+
		"\2\2\u0175\u0173\3\2\2\2\u0176\u0177\7)\2\2\u0177d\3\2\2\2\u0178\u0179"+
		"\7\60\2\2\u0179f\3\2\2\2\u017a\u017b\7\60\2\2\u017b\u017c\7\60\2\2\u017c"+
		"h\3\2\2\2\u017d\u017e\7*\2\2\u017e\u017f\7,\2\2\u017f\u0183\3\2\2\2\u0180"+
		"\u0182\13\2\2\2\u0181\u0180\3\2\2\2\u0182\u0185\3\2\2\2\u0183\u0184\3"+
		"\2\2\2\u0183\u0181\3\2\2\2\u0184\u0186\3\2\2\2\u0185\u0183\3\2\2\2\u0186"+
		"\u0187\7,\2\2\u0187\u0188\7+\2\2\u0188\u0189\3\2\2\2\u0189\u018a\b\65"+
		"\2\2\u018aj\3\2\2\2\u018b\u018f\7}\2\2\u018c\u018e\13\2\2\2\u018d\u018c"+
		"\3\2\2\2\u018e\u0191\3\2\2\2\u018f\u0190\3\2\2\2\u018f\u018d\3\2\2\2\u0190"+
		"\u0192\3\2\2\2\u0191\u018f\3\2\2\2\u0192\u0193\7\177\2\2\u0193\u0194\3"+
		"\2\2\2\u0194\u0195\b\66\2\2\u0195l\3\2\2\2\u0196\u0197\t\4\2\2\u0197\u0198"+
		"\3\2\2\2\u0198\u0199\b\67\2\2\u0199n\3\2\2\2\u019a\u019b\t\5\2\2\u019b"+
		"p\3\2\2\2\u019c\u019d\t\6\2\2\u019dr\3\2\2\2\u019e\u019f\t\7\2\2\u019f"+
		"t\3\2\2\2\u01a0\u01a1\t\b\2\2\u01a1v\3\2\2\2\u01a2\u01a3\t\t\2\2\u01a3"+
		"x\3\2\2\2\u01a4\u01a5\t\n\2\2\u01a5z\3\2\2\2\u01a6\u01a7\t\13\2\2\u01a7"+
		"|\3\2\2\2\u01a8\u01a9\t\f\2\2\u01a9~\3\2\2\2\u01aa\u01ab\t\r\2\2\u01ab"+
		"\u0080\3\2\2\2\u01ac\u01ad\t\16\2\2\u01ad\u0082\3\2\2\2\u01ae\u01af\t"+
		"\17\2\2\u01af\u0084\3\2\2\2\u01b0\u01b1\t\20\2\2\u01b1\u0086\3\2\2\2\u01b2"+
		"\u01b3\t\21\2\2\u01b3\u0088\3\2\2\2\u01b4\u01b5\t\22\2\2\u01b5\u008a\3"+
		"\2\2\2\u01b6\u01b7\t\23\2\2\u01b7\u008c\3\2\2\2\u01b8\u01b9\t\24\2\2\u01b9"+
		"\u008e\3\2\2\2\u01ba\u01bb\t\25\2\2\u01bb\u0090\3\2\2\2\u01bc\u01bd\t"+
		"\26\2\2\u01bd\u0092\3\2\2\2\u01be\u01bf\t\27\2\2\u01bf\u0094\3\2\2\2\u01c0"+
		"\u01c1\t\30\2\2\u01c1\u0096\3\2\2\2\u01c2\u01c3\t\31\2\2\u01c3\u0098\3"+
		"\2\2\2\u01c4\u01c5\t\32\2\2\u01c5\u009a\3\2\2\2\u01c6\u01c7\t\33\2\2\u01c7"+
		"\u009c\3\2\2\2\u01c8\u01c9\t\34\2\2\u01c9\u009e\3\2\2\2\u01ca\u01cb\t"+
		"\35\2\2\u01cb\u00a0\3\2\2\2\u01cc\u01cd\t\36\2\2\u01cd\u00a2\3\2\2\2\b"+
		"\2\u0167\u016d\u0173\u0183\u018f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}