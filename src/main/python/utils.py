#!/usr/bin/python3.7
#-*- coding utf8 -*-

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


class Tamanho():
    """
        Classe de tamanho
        w: largura
        h: altura
    """
    def __init__(self, w=None, h=None):
        if w:
            self.__width = w
        if h:
            self.__height = h
    
    def get_width(self):
        return self.__width

    def get_height(self):
        return self.__height

    def set_w(self, w=0):
        if x >= 0:
            self.__x = x
            return True
        return False

    def set_h(self, h=0):
        if y >= 0:
            self.__y = y
            return True
        return False