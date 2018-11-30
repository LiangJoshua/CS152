grammar FeatherweightJavaScript;


@header { package edu.sjsu.fwjs.parser; }

// Reserved words
IF        : 'if' ;
ELSE      : 'else' ;
WHILE	  : 'while' ;
FUNCTION  : 'function' ;
VAR	  : 'var' ;
PRINT 	  : 'print' ;

// Literals
INT       : [1-9][0-9]* | '0' ;
BOOL	  : ('true' | 'false');
NULL	  : 'null';

// Symbols
MUL       : '*' ;
DIV       : '/' ;
SEPARATOR : ';' ;
ADD	  : '+' ;
SUB	  : '-' ;
MOD	  : '%' ;
GT	  : '>' ;
LT 	  : '<' ;
GTE	  : '>=';
LTE	  : '<=';
EQ	  : '==';

ASGN	  : '=' ;
IDENTIFIER: ([a-zA-Z] | '_') ([a-zA-z0-9] | '_')* ;






// Whitespace and comments
NEWLINE   : '\r'? '\n' -> skip ;
LINE_COMMENT  : '//' ~[\n\r]* -> skip ;
WS            : [ \t]+ -> skip ; // ignore whitespace
BLOCK_COMMENT : '/*' .*? '*/' -> skip ;

// ***Paring rules ***

/** The start rule */
prog: stat+ ;

stat: expr SEPARATOR                                    # bareExpr
    | IF '(' expr ')' block ELSE block                  # ifThenElse
    | IF '(' expr ')' block                             # ifThen
    | WHILE '(' expr ')' block				# while
    | PRINT '(' expr ')' SEPARATOR			# print
    ;

expr: expr op=( '*' | '/' | '%' ) expr                  # MulDivMod
    | INT                                               # int
    | '(' expr ')'                                      # parens
    | expr op=( '+' | '-' ) expr                        # AddSub
    | expr op=( '>' | '<' | '>=' | '<=' | '==' ) expr   # comparison
    | FUNCTION '(' (expr)? (',' expr)* ')' block        # FuncDecl
    | IDENTIFIER '(' (expr)? (',' expr)* ')'            # FucApp
    | VAR IDENTIFIER ASGN expr                          # VarDecl
    | IDENTIFIER                                        # VarApp
    | IDENTIFIER ASGN expr                              # VarAsgn
    | INT                                               # int
    | BOOL                                              # bool
    | NULL                                              # null
    ;

block: '{' stat* '}'                                    # fullBlock
     | stat                                             # simpBlock
     ;

