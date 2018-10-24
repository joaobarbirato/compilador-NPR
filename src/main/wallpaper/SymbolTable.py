class SymbolTable:
    def __init__(self):
        self.symbols = []

    def __str__(self):
        texto = ""
        for s in self.symbols:
            texto += str(s) + '\n'
        return texto

    def addSymbol(self, symbol):
        # ERRO: simbolo já foi adicionado a tabela de simbolos
        if self.exist(symbol.identificador):
            return False
        else:
            self.symbols.append(symbol)
            return True

    def getElementos(self, imagem):
        elementos = []
        for s in self.symbols:
            if s.tipo == 'Elementos' and s.imagem == imagem:
                elementos.append(s)
        return elementos


    # verifica se um identificador já foi declarado
    def exist(self, identificador):
        for symbol in self.symbols:
            if symbol.identificador == identificador:
                return True
        return False
