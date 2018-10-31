from PIL import Image, ImageDraw

class Wallpaper:
    def __init__(self, simbolos):
        self.simbolos = simbolos
        self.imagens = []
        self.formas = []
        print(self.simbolos)

    def run(self):

        def rgb(hex):
            return tuple(int(hex[i:i + 2], 16) for i in (0, 2, 4))

        for s in self.simbolos.symbols:
            tipo = s.tipo
            if tipo == "Imagem":
                imagem = Image.new('RGB', s.tamanho, rgb(s.cor[2:]))
                draw = ImageDraw.Draw(imagem)
                self.imagens.append(s)
            else:
                if (s.forma == 'retangulo'):
                    draw.rectangle((40, 40, 85, 85), fill=rgb(s.cor[2:]))
                elif (s.forma == 'circulo'):
                    draw.ellipse((90, 80, 500, 400), fill=rgb(s.cor[2:]))
                self.formas.append(s)


        imagem.save('imagem.png', 'PNG')

