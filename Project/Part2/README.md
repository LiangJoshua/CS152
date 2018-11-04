Project part 2 -- Write a parser
-------------------------------
At this point, you have written an interpreter for our Featherweight JavaScript language.
In this assignment, you will write the lexer and parser for this language using ANTLR.
(We won't connect the two just yet -- that will be the next assignment).

PART A -- Write the lexer

Before you can write the parsing rules, you will need to specify the lexing rules.  In this step, you specify the valid words of the language.

In ANTLR, lexing rules start with a capital letter.

The reserved words in FWJS are:
*if \
*else \
*while \
*function \
*var \
*print

Additionally, you will need rules for literals: \
*BOOLs will be either 'true' or 'false'. \
*INTs are integers of any length.  There should be no unnecessary leading zeroes. \
*NULL is represented by the word 'null'.

You will also have various symbols in the language:
* '*', '/', '+', '-', '%' are the usual mathematical operations.
* '>', '<', '>=', '<=', '==' are the usual equality comparisons.
* ';' separates statements.

You will need identifiers.  The rules for variable names in FWJS: \
*The first character must be an alphabetic character or an underscore. \
*The remaining characters must be alphabetic characters, numeric characters, or underscores. 

Finally, you will need to consider whitespace and comments. \
Neither should be part of the resulting AST, so be sure to use 'skip'. \
*NEWLINEs are either '\r\n' or '\n' \
*BLOCK_COMMENTs are the usual C-style /* comments */.  They do not support nesting. \
*LINE_COMMENTs comment out everything until the end of the line.  They use the usual C++ style // where everything after a slash-slash is a comment. \
*Spaces and tabs are whitespace characters, and can be ignored. 


PART B -- Write the parser

Once you have your lexing rules complete, you may add your parsing rules. \
In ANTLR, parsing rules start with a lower case letter.

The rules are as follows:

A program is one or more statements.

A statement may be: \
*An expression followed by a semicolon. \
*An if statement, with the usual JavaScript syntax. \
*A while statement. \
*A print statement. \
*An empty statement (a semicolon by itself).

An expression can be:
*Binary operations, where \
...'*', '/', '%' are the highest precedence. \
...'+' and '-' middle precedence. \
...'<', '<=', '>', '>=', and '==' are the lowest precedence. \
*A function declaration (e.g. function(x){ x+1 }) \
*A function application (e.g. f(1,2)) \
*A variable declaration (var x=3) \
*a variable reference (x) \
*An assignment statement (x=4) \
*A constant (int, bool, or null) \
*An expression in parenthesis

The sampleParseTrees/ directory contains some parse trees for the programs found in fwjsScripts/.  All .tree files were generated with grun's -tree option.  Your parse trees should be similar, but might not be exactly identical.  (Note that grun supports a -gui option that might be helpful to examine).


PART C -- Submit your code

When you have completed this assignment, submit your grammar file.  No other code is needed.

When you submit, list the names of all your team members within Canvas.
