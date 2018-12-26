
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
    : '-'? (ALGARISMO)+
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
    : '"' (LETRA | '_' | '-' | '.' | '/' | ALGARISMO)+ '"'
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
    : 'filtro' '=' filtro_opcoes
    ;

filtro_opcoes
    : 'desfoque' | 'relevo' | 'contorno'
    ;

conteudo
    : 'conteudo' '=' '{' (valores|referencia)+ '}'
    ;

valores
    : forma '=' '[' atributos ']'
    | 'importado' '=' '[' chave caminho tamanho? ']'
    ;

atributos
    : chave cor posicao
    ;

caminho
    :  'caminho' '=' CAMINHO
    ;

referencia
    : 'copia' '->' IDENT '.' IDENT '[' 'chave' '=' IDENT cor? posicao? ']'
    ;

forma
    : 'retangulo' | 'triangulo' | 'circulo'
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
    : 'posicao' '=' '(' NUM_INT ',' NUM_INT (',' NUM_INT ',' NUM_INT)+ ')'
    ;

nome_arquivo
    : 'nome' '=' CAMINHO
    ;