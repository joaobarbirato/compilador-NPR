from PIL import Image, ImageDraw, ImageFilter

_DICT_FILTROS = {
    'contorno': ImageFilter.CONTOUR,
    'suavizacao': ImageFilter.SMOOTH,
    'desfoque': ImageFilter.BLUR
}

CUR_DIR = 'src/main/test/'


def rgb(hex):
    return tuple(int(hex[i:i + 2], 16) for i in (0, 2, 4))


class Forma:
    def __init__(self):
        self.chave = None
        self.cor = None
        self.posicao = None
        self.formato = None

    def desenharForma(self, draw):
        if self.formato == 'retangulo':
            draw.rectangle(self.posicao, fill=rgb(self.cor[2:]))
        elif self.formato == 'circulo':
            draw.ellipse(self.posicao, fill=rgb(self.cor[2:]))
        elif self.formato == 'triangulo':
            draw.polygon(self.posicao, fill=(self.cor[2:]))

class Texto:
    def __init__(self):
        self.chave = None
        self.posicao_inicial = None
        self.corpo_texto = None

    def desenharTexto(self, draw):
        print(self.posicao_inicial)
        print(self.corpo_texto)
        draw.text(self.posicao_inicial, self.corpo_texto)

class Imagem:
    def __init__(self):
        self.cor = None
        self.tamanho = None
        self.nome_arquivo = None
        self.formas = []
        self.textos = []
        self.png_importados = []
        self.filtros = []

    def desenharImagem(self):
        pillowImagem = Image.new('RGBA', self.tamanho, rgb(self.cor[2:]))
        draw = ImageDraw.Draw(pillowImagem)
        for forma in self.formas:
            forma.desenharForma(draw)

        for texto in self.textos:
            texto.desenharTexto(draw)

        for (caminho, tamanho, posicao) in self.png_importados:
            pngImagem = Image.open(CUR_DIR + caminho)
            if tamanho is not None:
                pngImagem = pngImagem.resize(tamanho)

            pillowImagem.paste(pngImagem, box=posicao, mask=pngImagem)

        for filtro in self.filtros:
            pillowImagem.filter(_DICT_FILTROS[filtro])

        pillowImagem.save(self.nome_arquivo, 'PNG')


class Wallpaper:
    def __init__(self, imagens, formas, textos):
        self.imagens = imagens
        self.formas = formas
        self.textos = textos

    def run(self):
        for tabela_imagem in self.imagens.tabelas:
            imagem = Imagem()
            for simbolo in tabela_imagem.simbolos:
                if simbolo.tipo == 'cor':
                    imagem.cor = simbolo.valor
                elif simbolo.tipo == 'tamanho':
                    imagem.tamanho = simbolo.valor
                elif simbolo.tipo == 'nome':
                    imagem.nome_arquivo = simbolo.valor
                elif simbolo.tipo == 'chave':  # nao existe mais o forma na imagem
                    for tabela_forma in self.formas.tabelas:
                        if simbolo.valor == tabela_forma.nome_tabela:  # formas que PERTENCEM à imagem
                            forma = Forma()
                            forma.chave = tabela_forma.nome_tabela  # setando a chave direto
                            for s in tabela_forma.simbolos:
                                if s.tipo == 'cor':
                                    forma.cor = str(s.valor)
                                elif s.tipo == 'posicao':
                                    forma.posicao = s.valor
                                elif s.tipo == 'formato':
                                    forma.formato = s.valor
                            imagem.formas.append(forma)

                elif simbolo.tipo == 'importado':
                    imagem.png_importados.append(simbolo.valor)

                elif simbolo.tipo == 'filtro':
                    imagem.filtros.append(simbolo.valor)

                elif simbolo.tipo == 'texto':
                    imagem.textos.append(simbolo.valor)

            imagem.desenharImagem()
