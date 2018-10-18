#!/usr/bin/python3.7
#-*- coding utf8 -*-

import PIL
from .utils import Tamanho, Posicao

class Elemento():
    """
        Classe abstrata de elementos do programa
    """
    pass


class Imagem(elemento):
    """
        Classe de imagens
    """
    pass


class Cor(elemento):
    """
        Classe de cores
    """
    def __init__(self, cor=(0,0,0)):
        if isinstance(cor, tuple) and len(tuple) == 3:
            (self.__r, self.__g, self.__b) = tuple
            self.__cor = tuple
            self.__tipo_cor = "rgb"
        else:
            self.__cor = tuple
            self.__tipo_cor = "hex"

    def get_cor(self):
        return self.__cor

    def set_cor(self, cor=(0,0,0)):
        if isinstance(cor, tuple) and len(tuple) == 3:
            (self.__r, self.__g, self.__b) = tuple
            self.__cor = tuple
            self.__tipo_cor = "rgb"
            return True
        else:
            self.__cor = tuple
            self.__tipo_cor = "hex"
            return True

        return False


class Programa():
    """
        Classe principal de comandos do programa
    """
    def __init__(self):
        pass

    def declare_elemento(self, elemento):
        pass
