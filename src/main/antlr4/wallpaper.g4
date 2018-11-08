
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
    : cor | tamanho | nome_arquivo | conteudo
    ;

conteudo
    : 'conteudo' '=' '{' (valores|referencia)+ '}'
    ;


valores
    : forma '=' '[' atributos_forma ']'
    | texto '=' '[' atributos_texto ']'
    ;

referencia
 : 'ref' '->' IDENT '.' IDENT '[' 'chave' '=' IDENT cor? posicao? ']';

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
    : 'texto'
    ;

atributos_texto
    : chave posicao_inicial corpo_texto //alinhamento
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
    : 'nome' '=' '"' IDENT '.' tipo_arquivo '"'
    ;

tipo_arquivo
    : 'jpg' | 'png'
    ;