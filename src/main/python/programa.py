#-*- coding utf8 -*-
import PIL

class Posicao():
    def __init__(self,x=None,y=None):
        self.__x = x
        self.__y = y
    
    def get_x(self):
        return self.__x

    def get_y(self):
        return self.__y

    def set_x(self, x=0):
        if x >= 0:
            self.__x = x
            return True

        return False

    def set_y(self, y=0):
        if y >= 0:
            self.__y = y
            return True

        return False


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
