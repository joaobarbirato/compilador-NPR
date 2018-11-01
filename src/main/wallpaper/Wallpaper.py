from PIL import Image, ImageDraw


def rgb(hex):
    return tuple(int(hex[i:i + 2], 16) for i in (0, 2, 4))


class Forma:
    def __init__(self):
        self.chave = None
        self.cor = None
        self.tamanho = None
        self.formato = None

    def draw(self, draw):
        if self.formato == 'retangulo':
            draw.rectangle((40, 40, 85, 85), fill=rgb(self.cor[2:]))
        elif self.formato == 'circulo':
            draw.ellipse((90, 80, 500, 400), fill=rgb(self.cor[2:]))


class Imagem:
    def __init__(self):
        self.cor = None
        self.tamanho = None
        self.nome_arquivo = None
        self.formas = []

    def draw(self):
        pillowImagem = Image.new('RGB', self.tamanho, rgb(self.cor[2:]))
        draw = ImageDraw.Draw(pillowImagem)
        for forma in self.formas:
            forma.draw(draw)

        pillowImagem.save(self.nome_arquivo, 'PNG')


class Wallpaper:
    def __init__(self, imagens, formas):
        self.imagens = imagens
        self.formas = formas

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
                elif simbolo.tipo == 'forma':
                    for tabela_forma in self.formas.tabelas:
                        forma = Forma()
                        for s in tabela_forma.simbolos:
                            if s.tipo == 'chave':
                                forma.chave = s.valor
                            elif s.tipo == 'cor':
                                forma.cor = s.valor
                            elif s.tipo == 'tamanho':
                                forma.tamanho = s.valor
                            elif s.tipo == 'formato':
                                forma.formato = s.valor
                        imagem.formas.append(forma)
            imagem.draw()