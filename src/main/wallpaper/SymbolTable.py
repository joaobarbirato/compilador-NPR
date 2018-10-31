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

    def getSymbol(self, identificador):
        for s in self.symbols:
            if s.identificador == identificador:
                return s
        return None

    def updateSymbol(self, identificador, tipo, valor):
        for s in self.symbols:
            if s.identificador == identificador:
                if tipo == 'chave':
                    s.chave =valor
                if tipo == 'cor':
                    s.cor = valor
                elif tipo == 'tamanho':
                    s.tamanho = valor
                elif tipo == 'nome':
                    s.nome = valor

    # verifica se um identificador já foi declarado
    def exist(self, identificador):
        for symbol in self.symbols:
            if symbol.identificador == identificador:
                return True
        return False
