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
    print(analisador_semantico.tabela_simbolos)

    # w = Wallpaper(analisador_semantico.tabela_simbolos)
    # w.run()

if __name__ == '__main__':
    main(sys.argv)
