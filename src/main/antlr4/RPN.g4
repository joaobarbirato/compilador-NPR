
/* Gramática de RPN (Reverse Polish Notation - RPN)
** Autores                          RA
** - Cassiano Maia                      726507
** - João Gabriel Melo Barbirato        726546
** - Julia Milain                       726552
*/

grammar RPN;

fragment LETRA: [a-zA-Z];
fragment ALGARISMO: [0-9];

// Ignore quebra de linha e espaço em branco
WS:   (' ') -> skip;
ENDL:  ([\n] | [\t] | [\r]) -> skip;

// números
NUM_INT: (ALGARISMO)+;
NUM_REAL: (ALGARISMO)+ '.' (ALGARISMO)+;

// Identificador de variaveis
IDENT: (LETRA|'_') ('_'|ALGARISMO|LETRA)*;

programa : declaracoes corpo;

declaracoes : 'var' var1=variavel (',' outrasVar=variavel)* ';';

corpo : (expressao)*;

expressao : expressao expressao operador_binario | expressao operador_unario | fator ;

operador_binario : 'op' '(' ('+' | '-' | '/' | '*' | '^') ');';
operador_unario : 'apply' '(' funcao ');'
                | 'not;'
                ;

funcao : 'exp' | 'sqrt' | 'sin' | 'cos' | 'tan';
fator : 'push' '(' numero ');';
numero : NUM_INT | NUM_REAL;
variavel : IDENT;
