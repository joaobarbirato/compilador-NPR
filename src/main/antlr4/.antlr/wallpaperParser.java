// Generated from /docs/home-hdd/jbarbirato-hdd/Documents/UFSCar/CC2/compilador-wallpaper/src/main/antlr4/wallpaper.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class wallpaperParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		HEX=32, NUM_INT=33, NUM_REAL=34, WS=35, ENDL=36, IDENT=37, CAMINHO=38;
	public static final int
		RULE_programa = 0, RULE_declaracao = 1, RULE_imagem = 2, RULE_corpo = 3, 
		RULE_propriedade = 4, RULE_filtro = 5, RULE_filtro_opcoes = 6, RULE_conteudo = 7, 
		RULE_valores = 8, RULE_caminho = 9, RULE_posicao_importado = 10, RULE_referencia = 11, 
		RULE_forma = 12, RULE_atributos = 13, RULE_chave = 14, RULE_cor = 15, 
		RULE_tamanho = 16, RULE_posicao = 17, RULE_nome_arquivo = 18, RULE_tipo_arquivo = 19;
	public static final String[] ruleNames = {
		"programa", "declaracao", "imagem", "corpo", "propriedade", "filtro", 
		"filtro_opcoes", "conteudo", "valores", "caminho", "posicao_importado", 
		"referencia", "forma", "atributos", "chave", "cor", "tamanho", "posicao", 
		"nome_arquivo", "tipo_arquivo"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'Img'", "';'", "'.'", "'filtro'", "'='", "','", "'desfoque'", "'suavizacao'", 
		"'contorno'", "'conteudo'", "'{'", "'}'", "'['", "']'", "'importado'", 
		"'caminho'", "'posicao'", "'('", "')'", "'copia'", "'->'", "'chave'", 
		"'retangulo'", "'triangulo'", "'circulo'", "'texto'", "'cor'", "'tamanho'", 
		"'nome'", "'jpg'", "'png'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "HEX", "NUM_INT", "NUM_REAL", 
		"WS", "ENDL", "IDENT", "CAMINHO"
	};
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
	public String getGrammarFileName() { return "wallpaper.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public wallpaperParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramaContext extends ParserRuleContext {
		public DeclaracaoContext declaracao() {
			return getRuleContext(DeclaracaoContext.class,0);
		}
		public List<CorpoContext> corpo() {
			return getRuleContexts(CorpoContext.class);
		}
		public CorpoContext corpo(int i) {
			return getRuleContext(CorpoContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			declaracao();
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(41);
				corpo();
				}
				}
				setState(46);
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

	public static class DeclaracaoContext extends ParserRuleContext {
		public List<ImagemContext> imagem() {
			return getRuleContexts(ImagemContext.class);
		}
		public ImagemContext imagem(int i) {
			return getRuleContext(ImagemContext.class,i);
		}
		public DeclaracaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao; }
	}

	public final DeclaracaoContext declaracao() throws RecognitionException {
		DeclaracaoContext _localctx = new DeclaracaoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaracao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(47);
				imagem();
				}
				}
				setState(50); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
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

	public static class ImagemContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(wallpaperParser.IDENT, 0); }
		public ImagemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imagem; }
	}

	public final ImagemContext imagem() throws RecognitionException {
		ImagemContext _localctx = new ImagemContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_imagem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(T__0);
			setState(53);
			match(IDENT);
			setState(54);
			match(T__1);
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

	public static class CorpoContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(wallpaperParser.IDENT, 0); }
		public PropriedadeContext propriedade() {
			return getRuleContext(PropriedadeContext.class,0);
		}
		public CorpoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_corpo; }
	}

	public final CorpoContext corpo() throws RecognitionException {
		CorpoContext _localctx = new CorpoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_corpo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(IDENT);
			setState(57);
			match(T__2);
			setState(58);
			propriedade();
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

	public static class PropriedadeContext extends ParserRuleContext {
		public CorContext cor() {
			return getRuleContext(CorContext.class,0);
		}
		public TamanhoContext tamanho() {
			return getRuleContext(TamanhoContext.class,0);
		}
		public Nome_arquivoContext nome_arquivo() {
			return getRuleContext(Nome_arquivoContext.class,0);
		}
		public ConteudoContext conteudo() {
			return getRuleContext(ConteudoContext.class,0);
		}
		public FiltroContext filtro() {
			return getRuleContext(FiltroContext.class,0);
		}
		public PropriedadeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propriedade; }
	}

	public final PropriedadeContext propriedade() throws RecognitionException {
		PropriedadeContext _localctx = new PropriedadeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_propriedade);
		try {
			setState(65);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				cor();
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				tamanho();
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 3);
				{
				setState(62);
				nome_arquivo();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 4);
				{
				setState(63);
				conteudo();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 5);
				{
				setState(64);
				filtro();
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

	public static class FiltroContext extends ParserRuleContext {
		public List<Filtro_opcoesContext> filtro_opcoes() {
			return getRuleContexts(Filtro_opcoesContext.class);
		}
		public Filtro_opcoesContext filtro_opcoes(int i) {
			return getRuleContext(Filtro_opcoesContext.class,i);
		}
		public FiltroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filtro; }
	}

	public final FiltroContext filtro() throws RecognitionException {
		FiltroContext _localctx = new FiltroContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_filtro);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(T__3);
			setState(68);
			match(T__4);
			setState(69);
			filtro_opcoes();
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(70);
				match(T__5);
				setState(71);
				filtro_opcoes();
				}
				}
				setState(76);
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

	public static class Filtro_opcoesContext extends ParserRuleContext {
		public Filtro_opcoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filtro_opcoes; }
	}

	public final Filtro_opcoesContext filtro_opcoes() throws RecognitionException {
		Filtro_opcoesContext _localctx = new Filtro_opcoesContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_filtro_opcoes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8))) != 0)) ) {
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

	public static class ConteudoContext extends ParserRuleContext {
		public List<ValoresContext> valores() {
			return getRuleContexts(ValoresContext.class);
		}
		public ValoresContext valores(int i) {
			return getRuleContext(ValoresContext.class,i);
		}
		public List<ReferenciaContext> referencia() {
			return getRuleContexts(ReferenciaContext.class);
		}
		public ReferenciaContext referencia(int i) {
			return getRuleContext(ReferenciaContext.class,i);
		}
		public ConteudoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conteudo; }
	}

	public final ConteudoContext conteudo() throws RecognitionException {
		ConteudoContext _localctx = new ConteudoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_conteudo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(T__9);
			setState(80);
			match(T__4);
			setState(81);
			match(T__10);
			setState(84); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(84);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__14:
				case T__22:
				case T__23:
				case T__24:
				case T__25:
					{
					setState(82);
					valores();
					}
					break;
				case T__19:
					{
					setState(83);
					referencia();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(86); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__19) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25))) != 0) );
			setState(88);
			match(T__11);
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

	public static class ValoresContext extends ParserRuleContext {
		public FormaContext forma() {
			return getRuleContext(FormaContext.class,0);
		}
		public AtributosContext atributos() {
			return getRuleContext(AtributosContext.class,0);
		}
		public ChaveContext chave() {
			return getRuleContext(ChaveContext.class,0);
		}
		public CaminhoContext caminho() {
			return getRuleContext(CaminhoContext.class,0);
		}
		public TamanhoContext tamanho() {
			return getRuleContext(TamanhoContext.class,0);
		}
		public Posicao_importadoContext posicao_importado() {
			return getRuleContext(Posicao_importadoContext.class,0);
		}
		public ValoresContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valores; }
	}

	public final ValoresContext valores() throws RecognitionException {
		ValoresContext _localctx = new ValoresContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_valores);
		int _la;
		try {
			setState(109);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__22:
			case T__23:
			case T__24:
			case T__25:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				forma();
				setState(91);
				match(T__4);
				setState(92);
				match(T__12);
				setState(93);
				atributos();
				setState(94);
				match(T__13);
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				match(T__14);
				setState(97);
				match(T__4);
				setState(98);
				match(T__12);
				setState(99);
				chave();
				setState(100);
				caminho();
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__27) {
					{
					setState(101);
					tamanho();
					}
				}

				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(104);
					posicao_importado();
					}
				}

				setState(107);
				match(T__13);
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

	public static class CaminhoContext extends ParserRuleContext {
		public TerminalNode CAMINHO() { return getToken(wallpaperParser.CAMINHO, 0); }
		public CaminhoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caminho; }
	}

	public final CaminhoContext caminho() throws RecognitionException {
		CaminhoContext _localctx = new CaminhoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_caminho);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(T__15);
			setState(112);
			match(T__4);
			setState(113);
			match(CAMINHO);
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

	public static class Posicao_importadoContext extends ParserRuleContext {
		public List<TerminalNode> NUM_INT() { return getTokens(wallpaperParser.NUM_INT); }
		public TerminalNode NUM_INT(int i) {
			return getToken(wallpaperParser.NUM_INT, i);
		}
		public Posicao_importadoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_posicao_importado; }
	}

	public final Posicao_importadoContext posicao_importado() throws RecognitionException {
		Posicao_importadoContext _localctx = new Posicao_importadoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_posicao_importado);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(T__16);
			setState(116);
			match(T__4);
			setState(117);
			match(T__17);
			setState(118);
			match(NUM_INT);
			setState(119);
			match(T__5);
			setState(120);
			match(NUM_INT);
			setState(121);
			match(T__18);
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

	public static class ReferenciaContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(wallpaperParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(wallpaperParser.IDENT, i);
		}
		public CorContext cor() {
			return getRuleContext(CorContext.class,0);
		}
		public PosicaoContext posicao() {
			return getRuleContext(PosicaoContext.class,0);
		}
		public ReferenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referencia; }
	}

	public final ReferenciaContext referencia() throws RecognitionException {
		ReferenciaContext _localctx = new ReferenciaContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_referencia);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(T__19);
			setState(124);
			match(T__20);
			setState(125);
			match(IDENT);
			setState(126);
			match(T__2);
			setState(127);
			match(IDENT);
			setState(128);
			match(T__12);
			setState(129);
			match(T__21);
			setState(130);
			match(T__4);
			setState(131);
			match(IDENT);
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__26) {
				{
				setState(132);
				cor();
				}
			}

			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(135);
				posicao();
				}
			}

			setState(138);
			match(T__13);
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

	public static class FormaContext extends ParserRuleContext {
		public FormaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forma; }
	}

	public final FormaContext forma() throws RecognitionException {
		FormaContext _localctx = new FormaContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_forma);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25))) != 0)) ) {
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

	public static class AtributosContext extends ParserRuleContext {
		public ChaveContext chave() {
			return getRuleContext(ChaveContext.class,0);
		}
		public CorContext cor() {
			return getRuleContext(CorContext.class,0);
		}
		public PosicaoContext posicao() {
			return getRuleContext(PosicaoContext.class,0);
		}
		public AtributosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atributos; }
	}

	public final AtributosContext atributos() throws RecognitionException {
		AtributosContext _localctx = new AtributosContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_atributos);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			chave();
			setState(143);
			cor();
			setState(144);
			posicao();
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

	public static class ChaveContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(wallpaperParser.IDENT, 0); }
		public ChaveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chave; }
	}

	public final ChaveContext chave() throws RecognitionException {
		ChaveContext _localctx = new ChaveContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_chave);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(T__21);
			setState(147);
			match(T__4);
			setState(148);
			match(IDENT);
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

	public static class CorContext extends ParserRuleContext {
		public TerminalNode HEX() { return getToken(wallpaperParser.HEX, 0); }
		public CorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cor; }
	}

	public final CorContext cor() throws RecognitionException {
		CorContext _localctx = new CorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_cor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(T__26);
			setState(151);
			match(T__4);
			setState(152);
			match(HEX);
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

	public static class TamanhoContext extends ParserRuleContext {
		public List<TerminalNode> NUM_INT() { return getTokens(wallpaperParser.NUM_INT); }
		public TerminalNode NUM_INT(int i) {
			return getToken(wallpaperParser.NUM_INT, i);
		}
		public TamanhoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tamanho; }
	}

	public final TamanhoContext tamanho() throws RecognitionException {
		TamanhoContext _localctx = new TamanhoContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_tamanho);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(T__27);
			setState(155);
			match(T__4);
			setState(156);
			match(T__17);
			setState(157);
			match(NUM_INT);
			setState(158);
			match(T__5);
			setState(159);
			match(NUM_INT);
			setState(160);
			match(T__18);
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

	public static class PosicaoContext extends ParserRuleContext {
		public List<TerminalNode> NUM_INT() { return getTokens(wallpaperParser.NUM_INT); }
		public TerminalNode NUM_INT(int i) {
			return getToken(wallpaperParser.NUM_INT, i);
		}
		public PosicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_posicao; }
	}

	public final PosicaoContext posicao() throws RecognitionException {
		PosicaoContext _localctx = new PosicaoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_posicao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(T__16);
			setState(163);
			match(T__4);
			setState(164);
			match(T__17);
			setState(165);
			match(NUM_INT);
			setState(166);
			match(T__5);
			setState(167);
			match(NUM_INT);
			setState(168);
			match(T__5);
			setState(169);
			match(NUM_INT);
			setState(170);
			match(T__5);
			setState(171);
			match(NUM_INT);
			setState(172);
			match(T__18);
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

	public static class Nome_arquivoContext extends ParserRuleContext {
		public TerminalNode CAMINHO() { return getToken(wallpaperParser.CAMINHO, 0); }
		public Nome_arquivoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nome_arquivo; }
	}

	public final Nome_arquivoContext nome_arquivo() throws RecognitionException {
		Nome_arquivoContext _localctx = new Nome_arquivoContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_nome_arquivo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(T__28);
			setState(175);
			match(T__4);
			setState(176);
			match(CAMINHO);
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

	public static class Tipo_arquivoContext extends ParserRuleContext {
		public Tipo_arquivoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_arquivo; }
	}

	public final Tipo_arquivoContext tipo_arquivo() throws RecognitionException {
		Tipo_arquivoContext _localctx = new Tipo_arquivoContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_tipo_arquivo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			_la = _input.LA(1);
			if ( !(_la==T__29 || _la==T__30) ) {
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u00b7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\7\2-\n\2\f\2\16\2\60\13\2\3\3\6"+
		"\3\63\n\3\r\3\16\3\64\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\5\6D\n\6\3\7\3\7\3\7\3\7\3\7\7\7K\n\7\f\7\16\7N\13\7\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\6\tW\n\t\r\t\16\tX\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\5\ni\n\n\3\n\5\nl\n\n\3\n\3\n\5\np\n\n\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\5\r\u0088\n\r\3\r\5\r\u008b\n\r\3\r\3\r\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\2\2\26\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(\2\5\3\2\t\13\3\2\31\34\3\2 !\2\u00b0\2"+
		"*\3\2\2\2\4\62\3\2\2\2\6\66\3\2\2\2\b:\3\2\2\2\nC\3\2\2\2\fE\3\2\2\2\16"+
		"O\3\2\2\2\20Q\3\2\2\2\22o\3\2\2\2\24q\3\2\2\2\26u\3\2\2\2\30}\3\2\2\2"+
		"\32\u008e\3\2\2\2\34\u0090\3\2\2\2\36\u0094\3\2\2\2 \u0098\3\2\2\2\"\u009c"+
		"\3\2\2\2$\u00a4\3\2\2\2&\u00b0\3\2\2\2(\u00b4\3\2\2\2*.\5\4\3\2+-\5\b"+
		"\5\2,+\3\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\3\3\2\2\2\60.\3\2\2\2"+
		"\61\63\5\6\4\2\62\61\3\2\2\2\63\64\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2"+
		"\65\5\3\2\2\2\66\67\7\3\2\2\678\7\'\2\289\7\4\2\29\7\3\2\2\2:;\7\'\2\2"+
		";<\7\5\2\2<=\5\n\6\2=\t\3\2\2\2>D\5 \21\2?D\5\"\22\2@D\5&\24\2AD\5\20"+
		"\t\2BD\5\f\7\2C>\3\2\2\2C?\3\2\2\2C@\3\2\2\2CA\3\2\2\2CB\3\2\2\2D\13\3"+
		"\2\2\2EF\7\6\2\2FG\7\7\2\2GL\5\16\b\2HI\7\b\2\2IK\5\16\b\2JH\3\2\2\2K"+
		"N\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\r\3\2\2\2NL\3\2\2\2OP\t\2\2\2P\17\3\2\2"+
		"\2QR\7\f\2\2RS\7\7\2\2SV\7\r\2\2TW\5\22\n\2UW\5\30\r\2VT\3\2\2\2VU\3\2"+
		"\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z[\7\16\2\2[\21\3\2\2\2\\"+
		"]\5\32\16\2]^\7\7\2\2^_\7\17\2\2_`\5\34\17\2`a\7\20\2\2ap\3\2\2\2bc\7"+
		"\21\2\2cd\7\7\2\2de\7\17\2\2ef\5\36\20\2fh\5\24\13\2gi\5\"\22\2hg\3\2"+
		"\2\2hi\3\2\2\2ik\3\2\2\2jl\5\26\f\2kj\3\2\2\2kl\3\2\2\2lm\3\2\2\2mn\7"+
		"\20\2\2np\3\2\2\2o\\\3\2\2\2ob\3\2\2\2p\23\3\2\2\2qr\7\22\2\2rs\7\7\2"+
		"\2st\7(\2\2t\25\3\2\2\2uv\7\23\2\2vw\7\7\2\2wx\7\24\2\2xy\7#\2\2yz\7\b"+
		"\2\2z{\7#\2\2{|\7\25\2\2|\27\3\2\2\2}~\7\26\2\2~\177\7\27\2\2\177\u0080"+
		"\7\'\2\2\u0080\u0081\7\5\2\2\u0081\u0082\7\'\2\2\u0082\u0083\7\17\2\2"+
		"\u0083\u0084\7\30\2\2\u0084\u0085\7\7\2\2\u0085\u0087\7\'\2\2\u0086\u0088"+
		"\5 \21\2\u0087\u0086\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008a\3\2\2\2\u0089"+
		"\u008b\5$\23\2\u008a\u0089\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\3\2"+
		"\2\2\u008c\u008d\7\20\2\2\u008d\31\3\2\2\2\u008e\u008f\t\3\2\2\u008f\33"+
		"\3\2\2\2\u0090\u0091\5\36\20\2\u0091\u0092\5 \21\2\u0092\u0093\5$\23\2"+
		"\u0093\35\3\2\2\2\u0094\u0095\7\30\2\2\u0095\u0096\7\7\2\2\u0096\u0097"+
		"\7\'\2\2\u0097\37\3\2\2\2\u0098\u0099\7\35\2\2\u0099\u009a\7\7\2\2\u009a"+
		"\u009b\7\"\2\2\u009b!\3\2\2\2\u009c\u009d\7\36\2\2\u009d\u009e\7\7\2\2"+
		"\u009e\u009f\7\24\2\2\u009f\u00a0\7#\2\2\u00a0\u00a1\7\b\2\2\u00a1\u00a2"+
		"\7#\2\2\u00a2\u00a3\7\25\2\2\u00a3#\3\2\2\2\u00a4\u00a5\7\23\2\2\u00a5"+
		"\u00a6\7\7\2\2\u00a6\u00a7\7\24\2\2\u00a7\u00a8\7#\2\2\u00a8\u00a9\7\b"+
		"\2\2\u00a9\u00aa\7#\2\2\u00aa\u00ab\7\b\2\2\u00ab\u00ac\7#\2\2\u00ac\u00ad"+
		"\7\b\2\2\u00ad\u00ae\7#\2\2\u00ae\u00af\7\25\2\2\u00af%\3\2\2\2\u00b0"+
		"\u00b1\7\37\2\2\u00b1\u00b2\7\7\2\2\u00b2\u00b3\7(\2\2\u00b3\'\3\2\2\2"+
		"\u00b4\u00b5\t\4\2\2\u00b5)\3\2\2\2\r.\64CLVXhko\u0087\u008a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}