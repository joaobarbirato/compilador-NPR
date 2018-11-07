from __future__ import annotations

import sys
from antlr4 import *
from wallpaperLexer import wallpaperLexer
from wallpaperParser import wallpaperParser
from Semantico import Semantico
from Wallpaper import Wallpaper

def main(argv):
    input = FileStream(argv[1])
    lexer = wallpaperLexer(input)
    stream = CommonTokenStream(lexer)
    parser = wallpaperParser(stream)
    tree = parser.programa()

    analisador_semantico = Semantico()
    analisador_semantico.visitPrograma(tree)

    # print('----- Imagens -----')
    # for tabela in analisador_semantico.imagens.tabelas:
    #     print(tabela.nome_tabela)
    #     for simbolo in tabela.simbolos:
    #         print(simbolo.tipo, simbolo.valor)
    #     print()

    # print('----- Formas -----')
    # for tabela in analisador_semantico.formas.tabelas:
    #     print()
    #     print(tabela.nome_tabela)
    #     for simbolo in tabela.simbolos:
    #         print(simbolo.tipo, simbolo.valor)
    #     print()

    imagens = analisador_semantico.imagens
    formas = analisador_semantico.formas
    w = Wallpaper(imagens, formas)
    w.run()

if __name__ == '__main__':
    main(sys.argv)
