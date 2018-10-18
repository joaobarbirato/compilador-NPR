#-*- coding utf8 -*-
import PIL

class Posicao():
    def __init__(self,x=None,y=None):
        self.x = x
        self.y = y


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
    pass


class Programa():
    """
        Classe principal de comandos do programa
    """
    def __init__(self):
        pass

    def declare_wallpaper(self):
        pass

    def declare_cor(self):
        pass
