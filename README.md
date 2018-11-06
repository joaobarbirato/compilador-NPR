# Compilador Wallpaper
Compilador de wallpapers e imagens diversas

# Instalando o projeto
A versão do Python deve ser +3.7 pelo fato da biblioteca do antlr4 fazer uso de type annotation.


1 - Criar um virtual environment: $ python3.7 -m venv venv

2 - Acessar o virtual enviroment: $ source venv/bin/activate

Obs: No terminal aparecerá (venv) no inicio da linha.

3 - Instalar as dependências do projeto: $ pip install -r requirements.txt 

4 - Testar o compilador: $ python src/main/wallpaper/wallpaperCompiler.py src/main/test/example.wpp