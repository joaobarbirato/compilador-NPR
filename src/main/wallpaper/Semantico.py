from wallpaperParser import wallpaperParser
from wallpaperVisitor import wallpaperVisitor
from Simbolo import Simbolo, TabelaSimbolo, ListaTabela


class Semantico(wallpaperVisitor):
    def __init__(self):
        self.imagens = ListaTabela()
        self.formas = ListaTabela()
        self.texto = ListaTabela()
        # tabela auxiliar para guardar a tabela atual de imagem
        # permite passar uma tabela pelas funções
        self.tabela_imagem = None
        # tabela auxiliar para guardar a tabela atual de forma
        # permite passar uma tabela pelas funções
        self.tabela_forma = None
        # tabela auxiliar para guardar a tabela atual de texto
        # permite passar uma tabela pelas funções
        self.tabela_texto = None
        self.conteudoImagem = []
        self.caminhos_importado = None
        self.filtros = []

    def visitPrograma(self, ctx: wallpaperParser.ProgramaContext):
        wallpaperVisitor.visitPrograma(self, ctx)

    def visitImagem(self, ctx: wallpaperParser.ImagemContext):
        if self.imagens.exist(ctx.IDENT()):
            print('Erro: O identificador ' + str(ctx.IDENT()) + ' já foi declarado.')
        else:
            self.imagens.addTabela(TabelaSimbolo(ctx.IDENT().getText()))

    def visitCorpo(self, ctx: wallpaperParser.CorpoContext):
        if not self.imagens.exist(ctx.IDENT()):
            print('Erro: O identificador ' + str(ctx.IDENT()) + ' não foi declarado.')
        else:
            self.tabela_imagem = self.imagens.getTabela(ctx.IDENT())
            self.visitPropriedade(ctx.propriedade())

    def visitPropriedade(self, ctx: wallpaperParser.PropriedadeContext):
        if ctx.cor():
            if not self.tabela_imagem.getSimbolo('cor'):
                self.tabela_imagem.addSimbolo(Simbolo('cor', ctx.cor().HEX().getText()))
            else:
                print('Erro: A cor já foi adicionada à imagem.')
                return

        elif ctx.tamanho():
            tam = ctx.tamanho()
            if tam:
                if not self.tabela_imagem.getSimbolo('tamanho'):
                    self.tabela_imagem.addSimbolo(
                        Simbolo('tamanho', (int(tam.NUM_INT(0).getText()), int(tam.NUM_INT(1).getText()))))
                else:
                    print('Erro: O tamanho já foi adicionado à imagem.')
                    return
            else:
                print('Erro: tamanho nao definido')

        elif ctx.nome_arquivo():
            if not self.tabela_imagem.getSimbolo('nome'):
                self.tabela_imagem.addSimbolo(Simbolo('nome',ctx.nome_arquivo().CAMINHO().getText().replace('"','')))
            else:
                print('Erro: Imagem já possui um nome de arquivo.')
                return

        elif ctx.conteudo():
            for conteudo in self.conteudoImagem:
                if conteudo == self.tabela_imagem.nome_tabela:
                    print('Imagem já possui um conteúdo.')
                    return

            self.conteudoImagem.append(self.tabela_imagem.nome_tabela)
            self.visitConteudo(ctx.conteudo())

        elif ctx.filtro():
            self.visitFiltro(ctx.filtro())
            for filtro in self.filtros:
                self.tabela_imagem.addSimbolo(Simbolo("filtro", filtro))

    def visitFiltro(self, ctx: wallpaperParser.FiltroContext):
        for ctx_f_o in ctx.filtro_opcoes():
            self.visitFiltro_opcoes(ctx_f_o)

    def visitFiltro_opcoes(self, ctx: wallpaperParser.Filtro_opcoesContext):
        texto_filtro = ctx.getText()
        if texto_filtro not in self.filtros:
            self.filtros.append(texto_filtro)

    def visitConteudo(self, ctx: wallpaperParser.ConteudoContext):
        for referencia in ctx.referencia():
            self.visitReferencia(referencia)

        for valor in ctx.valores():
            self.visitValores(valor)

    def visitReferencia(self, ctx: wallpaperParser.ReferenciaContext):
        # verificar primeiro IDENT tabela de imagens
        # verificar segundo IDENT tabela de formas
        # verificar terceiro IDENT que é o chave da nova forma

        copy_forma = self.formas.getTabela(ctx.IDENT(1))
        self.tabela_forma = TabelaSimbolo(ctx.IDENT(2).getText())                          #--------
        self.tabela_imagem.addSimbolo(Simbolo('chave', ctx.IDENT(2).getText()))         #----------

        if ctx.cor():
            self.tabela_forma.addSimbolo(Simbolo('cor', ctx.cor().HEX()))
        else:
            self.tabela_forma.addSimbolo(Simbolo('cor', copy_forma.getSimbolo('cor').valor))

        if ctx.posicao():
            posicao = ctx.posicao()
            self.tabela_forma.addSimbolo(
                Simbolo('posicao', (int(posicao.NUM_INT(0).getText()), int(posicao.NUM_INT(1).getText()),
                                    int(posicao.NUM_INT(2).getText()), int(posicao.NUM_INT(3).getText()))))
        else:
            self.tabela_forma.addSimbolo(Simbolo('posicao', copy_forma.getSimbolo('posicao').valor))

        self.tabela_forma.addSimbolo(Simbolo('formato', copy_forma.getSimbolo('formato').valor))

        self.formas.addTabela(self.tabela_forma)
        self.tabela_forma = None

    def visitValores(self, ctx: wallpaperParser.ValoresContext):
        if ctx.forma():
            self.visitAtributos(ctx.atributos())
            self.tabela_forma.addSimbolo(Simbolo('formato', ctx.forma().getText()))
        elif ctx.caminho():
            self.visitCaminho(ctx.caminho())
            __tamanho = (int(ctx.tamanho().NUM_INT(0).getText()), int(ctx.tamanho().NUM_INT(1).getText())) \
                if ctx.tamanho() else None
            __posicao = (int(ctx.posicao_importado().NUM_INT(0).getText()), int(ctx.posicao_importado().NUM_INT(1).getText())) \
                if ctx.posicao_importado() else None

            self.tabela_imagem.addSimbolo(Simbolo('importado', (self.caminhos_importado, __tamanho, __posicao)))

    def visitCaminho(self, ctx:wallpaperParser.CaminhoContext):
        caminhos = ctx.CAMINHO()
        if caminhos:
            self.caminhos_importado = caminhos.getText().replace('"','')

    def visitAtributos(self, ctx: wallpaperParser.AtributosContext):

        if not ctx.chave().getText():
            print('Erro: O atributo chave é obrigatório para formas')
            return  # exit()

        # Verifica se já foi declarado o identificador da forma (chave)
        if self.formas.exist(ctx.chave().IDENT()) or self.imagens.exist(ctx.chave().IDENT()) or self.texto.exist(ctx.chave().IDENT()):
            print('Erro: O identificador ' + ctx.chave().IDENT().getText() + ' já foi declarado.')
            return
        else:
            # adiciona uma entrada do tipo chave na tabela de simbolos da imagem
            self.tabela_imagem.addSimbolo(Simbolo('chave', ctx.chave().IDENT().getText()))

            # atribui a tabela de forma para a tabela auxiliar
            self.tabela_forma = TabelaSimbolo(ctx.chave().IDENT().getText())       #=========
            self.formas.addTabela(self.tabela_forma)

        if not ctx.cor().HEX():
            print('Erro: O atributo cor é obrigatório para formas')
            return

        self.tabela_forma.addSimbolo(Simbolo('cor', ctx.cor().HEX().getText()))

        if not ctx.posicao().NUM_INT():
            print('Erro: O atributo posição é obrigatório para formas')
            return

        posicao = ctx.posicao()
        self.tabela_forma.addSimbolo(
            Simbolo('posicao', (int(posicao.NUM_INT(0).getText()), int(posicao.NUM_INT(1).getText()),
                                int(posicao.NUM_INT(2).getText()), int(posicao.NUM_INT(3).getText()))))


    def visitAtributos_texto(self, ctx: wallpaperParser.Atributos_textoContext):
        if not ctx.chave().IDENT():
            print('Erro: O atributo corpo_ é obrigatório para textos')
            return  # exit()

        if self.formas.exist(ctx.chave().IDENT()) or self.imagens.exist(ctx.chave().IDENT()) or self.texto.exist(ctx.chave().IDENT()):
            print('Erro: O identificador ' + ctx.chave().IDENT().getText() + ' já foi declarado.')
            return
        else:
            # adiciona uma entrada do tipo chave na tabela de simbolos da imagem
            #self.tabela_texto.addSimbolo(Simbolo('chave', ctx.chave().IDENT().getText()))

            # atribui a tabela de texto para a tabela auxiliar
            self.tabela_texto = TabelaSimbolo(ctx.chave().IDENT().getText())
            self.texto.addTabela(self.tabela_texto)

        if not ctx.posicao_inicial().NUM_INT:
            print('Erro: O atributo posição_inicial é obrigatório para texto')
            return

        posicao_inicial = ctx.posicao_inicial()
        self.tabela_texto.addSimbolo(
            Simbolo('posicao_inicial', (int(posicao_inicial.NUM_INT(0).getText()), int(posicao_inicial.NUM_INT(1).getText()))))

        if not ctx.corpo_texto().IDENT():
            print('Erro: O atributo corpo_texto é obrigatório para texto')
            return

        corpo_texto = ctx.corpo_texto()
        self.tabela_texto.addSimbolo(Simbolo('corpo_texto', corpo_texto.IDENT().getText()))
