# -*- coding utf-8 -*-
from __future__ import annotations

import sys
from antlr4 import *
from wallpaperLexer import wallpaperLexer
from wallpaperParser import wallpaperParser
from Semantico import Semantico
from Wallpaper import Wallpaper


def main(argv):
    try:
        input = FileStream(argv[1])
    except IndexError:
        print("Argumentos inválidos.")
        return -1

    lexer = wallpaperLexer(input)
    stream = CommonTokenStream(lexer)
    parser = wallpaperParser(stream)
    tree = parser.programa()

    analisador_semantico = Semantico()
    existe_erros = analisador_semantico.visitPrograma(tree)
    if not existe_erros:
        print('----- Imagens -----')
        for tabela in analisador_semantico.imagens.tabelas:
            print(tabela.nome_tabela)
            for simbolo in tabela.simbolos:
                print(simbolo.tipo, simbolo.valor)
            print()

        print('----- Formas -----')
        for tabela in analisador_semantico.formas.tabelas:
            print()
            print(tabela.nome_tabela)
            for simbolo in tabela.simbolos:
                print(simbolo.tipo, simbolo.valor)
            print()

        imagens = analisador_semantico.imagens
        formas = analisador_semantico.formas
        w = Wallpaper(imagens, formas)
        w.run()

    else:
        analisador_semantico.erros.print()


if __name__ == '__main__':
    main(sys.argv)
