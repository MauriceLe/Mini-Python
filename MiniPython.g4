grammar MiniPython;

start: (def_function | def_class | statement | COMMENT | NL)* EOF;

INT         : [0-9]+;
BOOL        : 'TRUE' | 'FALSE';
STRING      : ["].*?["] | ['].*?['];
COMMENT     : [#][a-zA-Z_0-9 ]*;

IF          : 'if';
ELIF        : 'elif';
ELSE        : 'else';
WHILE       : 'while';
RETURN      : 'return';
CLASS_      : 'class';
DEF         : 'def';
SELF        : 'self';
END         : '#end';

WS          : [ \t]+ -> skip;
NL          : [\r\n]+;
ID          : [a-zA-Z][a-zA-Z_0-9]*;

negation    : 'not';
logic       : 'or' | 'and';
multi_div   : '*' | '/';
plus_minus  : '+' | '-';
compare     : '>' | '<' | '=='| '!=' | '>=' | '<=';

expression  : expression multi_div expression
            | expression plus_minus expression
            | expression logic expression
            | expression compare expression
            | negation expression
            | ID | INT | BOOL | STRING;

block       : ':' NL statement*;
param       : '(' expression* (','expression)* ')';

if          : IF expression block (ELIF expression block)* (ELSE block)? END;
while       : WHILE expression ':' NL statement* END;
method      : ID '.' ID param NL;
function    : ID param NL;
object      : ID param NL;

assign      : ID '=' (expression | object | function | method) NL;
statement   : assign | if | while | function | method;

def_function: DEF ID '(' ID* (','ID)* ')' block RETURN expression? NL END;
def_class   : CLASS_ ID '(' ID? ')' ':' NL def_function END;