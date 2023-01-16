grammar MiniPython;

start: statements EOF;

expression      : expression MULTIPLY expression        # MultiplyExpression
                | expression DIVISION expression        # DivisionExpression  
                | expression PLUS expression            # PlusExpression
                | expression MINUS expression           # MinusExpression
                | expression LESS expression            # LessExpression
                | expression LESS_THEN expression       # LessThenExpression
                | expression GREATER expression         # GreaterExpression
                | expression GREATER_THEN expression    # GreaterThenExpression
                | expression EQUAL expression           # EqualExpression
                | expression NOT_EQUAL expression       # NotEqualExpression
                | NOT expression                        # NotExpression
                | call                                  # CallExpression
                | ID                                    # IdExpression
                | INT                                   # IntExpression
                | BOOLEAN                               # BoolExpression
                | STRING                                # StringExpression
                ;

statement       : expression
                | assignment
                | while 
                | if
                | try
                | call
                | function
                | class
                | return
                | import_module
                ;

statements      : statement+?;

identifier      : ID;

assignment      : identifier ASSIGN expression;

condition       : expression COLON 
                | LBRACKET expression RBRACKET COLON
                ;

exp_parameter   : expression? (COMMA expression)*;

return          : RETURN expression;

while           : WHILE condition statements END;
if              : if_statement elif_statement* else_statement? END;
if_statement    : IF condition statements;
elif_statement  : ELIF condition statements;
else_statement  : ELSE COLON statements;

import_module   : IMPORT identifier;

exception       : ZERO_DIVIS_ERROR          # ZeroDivisionError
                | VALUE_ERROR               # ValueError
                | ASSIGN_ERROR              # AssignError
                ;
                
try             : try_statement exc_statement fin_statement? END;
try_statement   : TRY COLON statements*;
exc_statement   : EXCEPT exception COLON statements*;
fin_statement   : FINALLY COLON statements*;


call            : identifier LBRACKET exp_parameter RBRACKET
                | identifier DOT identifier LBRACKET exp_parameter RBRACKET
                ;

fun_parameter   : identifier? (COMMA identifier)*;

function        : DEF identifier LBRACKET fun_parameter RBRACKET COLON statements END;

class           : CLASS_ identifier (COLON | LBRACKET identifier RBRACKET COLON) function* END;


INT             : [0-9]+;
BOOLEAN         : 'True' | 'False';
STRING          : ["].*?["] | ['].*?['];

NOT             : 'not';
OR              : 'or';
AND             : 'and';

MULTIPLY        : '*';
DIVISION        : '/';
PLUS            : '+';
MINUS           : '-';

LESS            : '<';
GREATER         : '>';
LESS_THEN       : '<=';
GREATER_THEN    : '>=';
EQUAL           : '==';
NOT_EQUAL       : '!=';

IMPORT          : 'import';
IF              : 'if';
ELIF            : 'elif';
ELSE            : 'else';
WHILE           : 'while';
RETURN          : 'return';
CLASS_          : 'class';
DEF             : 'def';
SELF            : 'self';
TRY             : 'try';
EXCEPT          : 'except';
FINALLY         : 'finally';

ZERO_DIVIS_ERROR: 'ZeroDivisionError';
VALUE_ERROR     : 'ValueError';
ASSIGN_ERROR    : 'AssignError';

LBRACKET        : '(';
RBRACKET        : ')';
ASSIGN          : '=';
COLON           : ':';
DOT             : '.';
COMMA           : ',';

END             : '#end' ('\n' | '\r\n')?;

WS              : [ \t\r\n]+ -> skip;
ID              : [a-z_A-Z][a-zA-Z_0-9]*;