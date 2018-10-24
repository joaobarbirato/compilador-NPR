class Symbol:
    def __init__(self, tipo, cor, tamanho, identificador, forma, imagem):
        self.tipo = tipo
        self.cor = cor
        self.tamanho = tamanho
        self.identificador = identificador
        # são None para o tipo Imagem
        self.forma = forma
        self.imagem = imagem

    def __str__(self):
        # print('('+self.tipo + ' ' + self.cor + ' ' + self.tamanho + ' ' + self.identificador + ')')
        return '(' + self.tipo + ' ' + self.cor + ' ' + str(self.tamanho) + ' ' + self.identificador + ' ' + str(self.forma) + ' ' + str(self.imagem) + ')'

# Symbol('Imagem', '0x000000', '(800, 600)', 'img', None, None)
# Symbol('Elemento', '0x800080', '(15,30)', 'id', 'retangulo', 'img')



