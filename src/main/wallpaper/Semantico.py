from wallpaperParser import wallpaperParser
from wallpaperVisitor import wallpaperVisitor
from SymbolTable import SymbolTable
from Symbol import Symbol


class Semantico(wallpaperVisitor):
    def __init__(self):
        self.tabela_simbolos = None

    def visitPrograma(self, ctx:wallpaperParser.ProgramaContext):
        self.tabela_simbolos = SymbolTable()
        wallpaperVisitor.visitPrograma(self, ctx)

    def visitDeclaracoes(self, ctx:wallpaperParser.DeclaracoesContext):
        identificador = None
        cor = None
        tamanho = None

        if (self.tabela_simbolos.exist(ctx.IDENT()[0].getText())):
            print('O identificador ' + str(ctx.IDENT()[0]) + ' já foi declarado.')
        else:
            identificador = ctx.IDENT()[0].getText()

        if (ctx.IDENT()[1].getText() != ctx.IDENT()[0].getText()):
            print('O identificador ' + str(ctx.IDENT()[1]) + ' não foi declarado anteriormente.')
        else:
            cor = ctx.cor().HEX().getText()

        if (ctx.IDENT()[2].getText() != ctx.IDENT()[0].getText()):
            print('O identificador ' + str(ctx.IDENT()[2]) + ' não foi declarado anteriormente.')
        else:
            tamanho = (int(ctx.tamanho().NUM_INT(0).getText()), int(ctx.tamanho().NUM_INT(1).getText()))

        s = Symbol("Imagem", cor, tamanho, identificador, None, None)
        self.tabela_simbolos.addSymbol(s)

    def visitElementos(self, ctx: wallpaperParser.ElementosContext):
        if not (self.tabela_simbolos.exist(ctx.IDENT().getText())):
            print('O identificador ' + str(ctx.IDENT()) + ' não foi declarado anteriormente.')

        for c in ctx.conteudo():
            forma, chave, cor, tamanho = self.visitConteudo(c)

            if (self.tabela_simbolos.exist(chave)):
                print("Erro o identificador " + chave + " já foi declarado")
            else:
                s = Symbol("Elemento", cor, tamanho, chave, forma, ctx.IDENT().getText())
                self.tabela_simbolos.addSymbol(s)

    def visitConteudo(self, ctx: wallpaperParser.ConteudoContext):
        forma = wallpaperVisitor.visitForma(self, ctx.forma())
        chave = self.visitChave(ctx.atributos().chave())
        cor = self.visitCor(ctx.atributos().cor())
        tamanho = self.visitTamanho(ctx.atributos().tamanho())

        return forma, chave, cor, tamanho

    # Visit a parse tree produced by wallpaperParser#retangulo.
    def visitRetangulo(self, ctx:wallpaperParser.RetanguloContext):
        return 'retangulo'


    # Visit a parse tree produced by wallpaperParser#triangulo.
    def visitTriangulo(self, ctx:wallpaperParser.TrianguloContext):
        return 'triangulo'


    # Visit a parse tree produced by wallpaperParser#circulo.
    def visitCirculo(self, ctx:wallpaperParser.CirculoContext):
        return 'circulo'


    # Visit a parse tree produced by wallpaperParser#texto.
    def visitTexto(self, ctx:wallpaperParser.TextoContext):
        return 'texto'

    def visitChave(self, ctx:wallpaperParser.ChaveContext):
        return ctx.IDENT().getText()

    # Visit a parse tree produced by wallpaperParser#cor.
    def visitCor(self, ctx:wallpaperParser.CorContext):
        return ctx.HEX().getText()


    # Visit a parse tree produced by wallpaperParser#tamanho.
    def visitTamanho(self, ctx:wallpaperParser.TamanhoContext):
        return (int(ctx.NUM_INT(0).getText()), int(ctx.NUM_INT(1).getText()))