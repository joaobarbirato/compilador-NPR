
/* Gramática Wallpaper
** Autores                              RA
** - Cassiano Maia                      726507
** - João Gabriel Melo Barbirato        726546
** - Julia Milain                       726552
** - Rebeca Lima Rocha                  486060
*/

grammar wallpaper;

fragment
LETRA
    : 'a'..'z'|'A'..'Z'
    ;

fragment
ALGARISMO
    : '0'..'9'
    ;

HEX
    : '0x' (LETRA|ALGARISMO)*
    ;

NUM_INT
    : (ALGARISMO)+
    ;

NUM_REAL
    : (ALGARISMO)+ '.' (ALGARISMO)+
    ;

WS : (' ') -> skip ;

ENDL
    : ([\n] | [\t] | [\r]) -> skip
    ;

IDENT
    : (LETRA | '_') ('_'| ALGARISMO | LETRA)*
    ;

CAMINHO
    : '"' (LETRA | '_' | '-' | '.' | ALGARISMO)+ '"'
    ;

programa
    : declaracao corpo*
    ;

declaracao
    : imagem+
    ;

imagem
    : 'Img' IDENT ';'
    ;

corpo
    : IDENT '.' propriedade
    ;

propriedade
    : cor | tamanho | nome_arquivo | conteudo | filtro
    ;

filtro
    : 'filtro' '=' filtro_opcoes (',' filtro_opcoes)*
    ;

filtro_opcoes
    : 'desfoque' | 'suavizacao' | 'contorno'
    ;

conteudo
    : 'conteudo' '=' '{' (valores|referencia)+ '}'
    ;


caminho
    :  'caminho' '=' CAMINHO
    ;
    
valores
    : forma '=' '[' atributos_forma ']'
    | 'importado' '=' '[' caminho tamanho? posicao_importado? ']'
    | texto '=' '[' atributos_texto ']'
    ;

posicao_importado
    :   'posicao' '=' '(' NUM_INT ',' NUM_INT ')'
    ;

referencia
    : 'ref' '->' IDENT '.' IDENT '[' 'chave' '=' IDENT cor? posicao? ']'
    ;

forma
    : 'retangulo' | 'triangulo' | 'circulo' | 'texto'
    ;

atributos_forma
    : chave cor posicao
    ;

chave
    : 'chave' '=' IDENT
    ;

cor
    : 'cor' '=' HEX
    ;

tamanho
    : 'tamanho' '=' '(' NUM_INT ',' NUM_INT ')'
    ;

posicao
    : 'posicao' '=' '(' NUM_INT ',' NUM_INT ',' NUM_INT ',' NUM_INT ')'
    ;

//Regras referentes a texto na img
texto
    : 'texto' ;

atributos_texto
    : chave posicao_inicial corpo_texto
    ;

posicao_inicial
    : 'posicao_inicial' '=' '(' NUM_INT ',' NUM_INT ')'
    ;

corpo_texto
    : 'corpo_texto' '=' IDENT
    ;

alinhamento
    : 'direita' | 'centro' | 'direita'
    ;

nome_arquivo
    : 'nome' '=' CAMINHO
    ;

tipo_arquivo
    : 'jpg' | 'png'
    ;