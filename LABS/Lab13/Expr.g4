grammar Expr;

// ***Lexing rules***

INT     : [0-9]+ ;
NEWLINE : '\r'? '\n' ;
WS      : [ \t]+ -> skip ; // ignore whitespace

MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;

ID : [a-zA-Z]+ ;

// ***Parsing rules ***

/** The start rule */
prog: stat+ ;

stat: expr NEWLINE              # printExpr
    | NEWLINE                   # blank
    ;

expr: expr op=( '*' | '/' ) expr   # MulDiv
    | expr op=( '+' | '-' ) expr   # AddSub
    | INT                       # int
    | '(' expr ')'              # parens
    | ID                        # id
    | ID '=' expr               # assign
    ;