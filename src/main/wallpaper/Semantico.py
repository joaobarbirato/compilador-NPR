from wallpaperParser import wallpaperParser
from wallpaperVisitor import wallpaperVisitor
from Simbolo import Simbolo, TabelaSimbolo, ListaTabela


class Semantico(wallpaperVisitor):
    def __init__(self):
        self.imagens = ListaTabela()
        self.formas = ListaTabela()
        # tabela auxiliar para guardar a tabela atual de imagem
        # permite passar uma tabela pelas funções
        self.tabela_imagem = None
        # tabela auxiliar para guardar a tabela atual de forma
        # permite passar uma tabela pelas funções
        self.tabela_forma = None

    def visitPrograma(self, ctx: wallpaperParser.ProgramaContext):
        wallpaperVisitor.visitPrograma(self, ctx)

    def visitImagem(self, ctx: wallpaperParser.ImagemContext):
        if self.imagens.exist(ctx.IDENT()):
            print('O identificador ' + str(ctx.IDENT()) + ' já foi declarado.')
        else:
            self.imagens.addTabela(TabelaSimbolo(ctx.IDENT().getText()))

    def visitCorpo(self, ctx:wallpaperParser.CorpoContext):
        if not self.imagens.exist(ctx.IDENT()):
            print('O identificador ' + str(ctx.IDENT()) + ' não foi declarado.')
        else:
            self.tabela_imagem = self.imagens.getTabela(ctx.IDENT())
            self.visitPropriedade(ctx.propriedade())

    # TODO: Verificar para cada imagem que ela somente pode ter
    # TODO: 1 cor, 1 tamanho etc...
    def visitPropriedade(self, ctx: wallpaperParser.PropriedadeContext):
        if ctx.cor():
            self.tabela_imagem.addSimbolo(Simbolo('cor', '', ctx.cor().HEX().getText()))

        elif ctx.tamanho():
            tamanho = ctx.tamanho()
            self.tabela_imagem.addSimbolo(Simbolo('tamanho', '', (int(tamanho.NUM_INT(0).getText()), int(tamanho.NUM_INT(1).getText()))))

        elif ctx.nome_arquivo():
            self.tabela_imagem.addSimbolo(Simbolo('nome', '', ctx.nome_arquivo().IDENT().getText() + '.' + ctx.nome_arquivo().tipo_arquivo().getText()))

        elif ctx.conteudo():
            self.visitConteudo(ctx.conteudo())

    def visitConteudo(self, ctx: wallpaperParser.ConteudoContext):
        i = 0
        for ctxForma in ctx.forma():
            self.visitAtributos(ctx.atributos(i))
            self.tabela_forma.addSimbolo(Simbolo('formato', '', ctxForma.getText()))
            i += 1

    # TODO: Verificar para cada forma que ela somente pode ter
    # TODO: 1 cor, 1 tamanho, 1 chave etc...
    def visitAtributos(self, ctx: wallpaperParser.AtributosContext):
        if not ctx.chave().getText():
            print('Erro: O atributo chave é obrigatório para formas')
            return

        # Verifica se já foi declarado o identificador da forma (chave)
        if self.formas.exist(ctx.chave().IDENT()) or self.imagens.exist(ctx.chave().IDENT()):
            print('O identificador ' + ctx.chave().IDENT().getText() + ' já foi declarado.')
            return
        else:
            # adiciona uma entrada do tipo forma na tabela de simbolos da imagem
            self.tabela_imagem.addSimbolo(Simbolo('forma', ctx.chave().IDENT().getText(), ''))
            # atribui a tabela de forma para a tabela auxiliar
            self.tabela_forma = TabelaSimbolo(ctx.chave().IDENT().getText())
            self.formas.addTabela(self.tabela_forma)

        if not ctx.cor().HEX():
            print('Erro: O atributo cor é obrigatório para formas')
            return

        self.tabela_forma.addSimbolo(Simbolo('cor', '', ctx.cor().HEX().getText()))

        if not ctx.tamanho().NUM_INT():
            print('Erro: O atributo tamanho é obrigatório para formas')
            return

        tamanho = ctx.tamanho()
        self.tabela_forma.addSimbolo(Simbolo('tamanho', '', (int(tamanho.NUM_INT(0).getText()), int(tamanho.NUM_INT(1).getText()))))

