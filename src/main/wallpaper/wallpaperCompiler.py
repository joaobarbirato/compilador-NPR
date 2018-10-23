from __future__ import annotations

import sys
from antlr4 import *
from wallpaperLexer import wallpaperLexer
from wallpaperParser import wallpaperParser


def main(argv):
    input = FileStream(argv[1])
    lexer = wallpaperLexer(input)
    stream = CommonTokenStream(lexer)
    parser = wallpaperParser(stream)
    tree = parser.programa()


if __name__ == '__main__':
    main(sys.argv)
