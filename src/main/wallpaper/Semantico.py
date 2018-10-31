from wallpaperParser import wallpaperParser
from wallpaperVisitor import wallpaperVisitor
from SymbolTable import SymbolTable
from Symbol import Symbol


class Semantico(wallpaperVisitor):
    def __init__(self):
        self.tabela_simbolos = None
        self.imagem = None

    def visitPrograma(self, ctx:wallpaperParser.ProgramaContext):
        self.tabela_simbolos = SymbolTable()
        wallpaperVisitor.visitPrograma(self, ctx)

    def visitImagem(self, ctx:wallpaperParser.ImagemContext):
        if self.tabela_simbolos.exist(ctx.IDENT().getText()):
            print('O identificador ' + str(ctx.IDENT()) + ' já foi declarado.')
        else:
            identificador = ctx.IDENT().getText()
            self.tabela_simbolos.addSymbol(Symbol('Imagem', None, None, identificador, None, None, None))

    def visitCorpo(self, ctx:wallpaperParser.CorpoContext):
        imagem = self.tabela_simbolos.getSymbol(ctx.IDENT().getText())
        if not imagem:
            print('O identificador ' + str(ctx.IDENT()) + ' não foi foi declarado.')
        else:
            self.imagem = imagem
            tipo, valor = self.visitPropriedade(ctx.propriedade())
            if tipo and valor:
                self.tabela_simbolos.updateSymbol(imagem.identificador, tipo, valor)

    def visitPropriedade(self, ctx: wallpaperParser.PropriedadeContext):
        # verificar qual a propriedade
        if ctx.cor():
            return 'cor', ctx.cor().HEX().getText()

        elif ctx.tamanho():
            tamanho = ctx.tamanho()
            return 'tamanho', (int(tamanho.NUM_INT(0).getText()), int(tamanho.NUM_INT(1).getText()))

        elif ctx.nome():
            if not self.tabela_simbolos.exist(ctx.nome().IDENT().getText()):
                return 'nome', ctx.nome().IDENT().getText() + '.' + ctx.nome().tipo_arquivo().getText()
            else:
                print('O nome ' + str(ctx.IDENT()) + ' já existe.')
                return None, None

        elif ctx.conteudo():
            self.visitConteudo(ctx.conteudo())
            return None, None


    def visitConteudo(self, ctx: wallpaperParser.ConteudoContext): #visitCorpo
        i = 0
        for forma in ctx.forma():
            self.visitForma(forma)
            self.visitAtributos(ctx.atributos(i))
            i += 1

    def visitForma(self, ctx:wallpaperParser.FormaContext): #visitImagem
        forma = ctx.getText()
        self.tabela_simbolos.addSymbol(Symbol('Forma', None, None, None, forma, self.imagem.identificador, None))

    def visitAtributos(self, ctx: wallpaperParser.AtributosContext): #visitPropriedade
        if ctx.chave():
            return 'chave', ctx.chave().getText()

        elif ctx.cor():
            return 'cor', ctx.cor().HEX().getText()

        elif ctx.tamanho():
            tamanho = ctx.tamanho()
            return 'tamanho', (int(tamanho.NUM_INT(0).getText()), int(tamanho.NUM_INT(1).getText()))

