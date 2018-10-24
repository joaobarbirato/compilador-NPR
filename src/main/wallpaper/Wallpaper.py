from PIL import Image, ImageDraw

class Wallpaper:
    def __init__(self, simbolos):
        self.simbolos = simbolos

    def run(self):

        def rgb(hex):
            return tuple(int(hex[i:i + 2], 16) for i in (0, 2, 4))

        img = self.simbolos.symbols[0]
        rgb(img.cor[2:])

        elmt = self.simbolos.symbols[1]
        print(rgb(elmt.cor[2:]))
        print(img.tamanho)
        print(rgb(img.cor[2:]))
        imagem = Image.new('RGB', img.tamanho, rgb(img.cor[2:]))

        draw = ImageDraw.Draw(imagem)

        if(elmt.forma == 'retangulo'):
            draw.rectangle((25, 25, 75, 75), fill=rgb(elmt.cor[2:]))

        imagem.save('image.png', 'PNG')

