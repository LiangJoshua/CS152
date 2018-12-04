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
IDENTIFIER: [a-zA-Z_][a-zA-Z_0-9]*;






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
    | '(' expr ')'                                      # Parens
    | expr '(' arglist? ')'                             # Call
    | expr op=( '+' | '-' ) expr                        # AddSub
    | expr op=( '>' | '<' | '>=' | '<=' | '==' ) expr   # Comparison
    | FUNCTION IDENTIFIER '(' idlist? ')' block        	# FuncDecl
    | FUNCTION '(' idlist? ')' block			# SecondFuncDecl
    | VAR IDENTIFIER ASGN expr                          # VarDecl
    | IDENTIFIER                                        # VarApp
    | IDENTIFIER ASGN expr                              # VarAsgn
    | INT                                               # Int
    | BOOL                                              # Bool
    | NULL                                              # Null
    ;

block: '{' stat* '}'                                    # fullBlock
     | stat                                             # simpBlock
     ;

arglist: expr (',' expr)*;

idlist: IDENTIFIER (',' IDENTIFIER)*;