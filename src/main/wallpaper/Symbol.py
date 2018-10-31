class Symbol:
    def __init__(self, tipo, cor, tamanho, identificador, forma, imagem, nome):
        self.tipo = tipo
        self.cor = cor
        self.tamanho = tamanho
        self.identificador = identificador
        # são None para o tipo Imagem
        self.forma = forma
        self.imagem = imagem
        # é None para o tipo Forma
        self.nome = nome

    def __str__(self):
        if self.cor:
        if self.tamanho:
        if self.identificador:
        if self.forma:
        if self.imagem:
        if self.nome:
        return self.identificador + ' cor: ' + self.cor + ' tamanho: ' + str(self.nome)

# Symbol('Imagem', '0x000000', '(800, 600)', 'img', None, None,'img.png')
# Symbol('Forma', '0x800080', '(15,30)', 'id', 'retangulo', 'img', None)



