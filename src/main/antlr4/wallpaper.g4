
/* Gramática Wallpaper
** Autores                              RA
** - Cassiano Maia                      726507
** - João Gabriel Melo Barbirato        726546
** - Julia Milain                       726552
** - Rebeca Lima Rocha                  486060
*/

grammar wallpaper;

fragment LETRA: [a-zA-Z];
fragment ALGARISMO: [0-9];

HEX : '0x' (ALGARISMO)+;

NUM_INT : (ALGARISMO)+;
NUM_REAL : (ALGARISMO)+ '.' (ALGARISMO)+;

WS : (' ') -> skip ;
ENDL : ([\n] | [\t] | [\r]) -> skip ;

IDENT : (LETRA | '_') ('_'| ALGARISMO | LETRA)* ;

programa : declaracoes corpo ;

declaracoes : 'Img' IDENT (IDENT)* ';' ;

corpo: (cmd)* ;

cmd: elementos |
	conteudo |
	forma |
	atributos |
salvarImagem;

elementos : IDENT '=' '{' (conteudo)* '}' ';' ;

conteudo : forma '=' '[' atributos ']' ';' ;

forma : retangulo | triangulo | circulo | texto ;

retangulo: 'retangulo';

triangulo: 'triangulo';

circulo: 'circulo';

texto: 'texto';

atributos : 'id' '=' IDENT (IDENT)* | 'cor' '=' HEX | 'tamanho' '=' '(' NUM_INT ',' NUM_INT ')';

salvarImagem : 'retornar' IDENT;