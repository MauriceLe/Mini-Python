grammar MiniPython;


start: statements EOF;


expression          : expression MULTIPLY expression        # MultiplyExpression
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

exception           : ZERO_DIVIS_ERROR                      # ZeroDivisionError
                    | NAME_ERROR                            # NameError
                    | IMPORT_ERROR                          # ImportError
                    ;

statement           : expression
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

statements          : statement+?;

identifier          : ID;

assignment          : identifier ASSIGN expression;

condition           : expression COLON 
                    | LBRACKET expression RBRACKET COLON
                    ;

return              : RETURN expression;

import_module       : IMPORT identifier
                    | FROM identifier IMPORT identifier
                    ;

while               : WHILE condition statements END;

if                  : if_statement elif_statement* else_statement? END;
if_statement        : IF condition statements;
elif_statement      : ELIF condition statements;
else_statement      : ELSE COLON statements;
                
try                 : try_statement exc_statement fin_statement? END;
try_statement       : TRY COLON statements;
exc_statement       : EXCEPT exception? COLON statements;
fin_statement       : FINALLY COLON statements;

expression_parameter: expression? (COMMA expression)*;

function_parameter  : identifier? (COMMA identifier)*;

call                : identifier LBRACKET expression_parameter RBRACKET
                    | identifier DOT identifier LBRACKET expression_parameter RBRACKET
                    ;

function            : DEF identifier LBRACKET function_parameter RBRACKET COLON statements END;

class               : CLASS_ identifier (COLON | LBRACKET identifier RBRACKET COLON) function* END;


INT                 : [0-9]+;
BOOLEAN             : 'True' | 'False';
STRING              : ["].*?["] | ['].*?['];

NOT                 : 'not';
OR                  : 'or';
AND                 : 'and';

MULTIPLY            : '*';
DIVISION            : '/';
PLUS                : '+';
MINUS               : '-';

LESS                : '<';
GREATER             : '>';
LESS_THEN           : '<=';
GREATER_THEN        : '>=';
EQUAL               : '==';
NOT_EQUAL           : '!=';

FROM                : 'from';
IMPORT              : 'import';

IF                  : 'if';
ELIF                : 'elif';
ELSE                : 'else';
WHILE               : 'while';
RETURN              : 'return';
CLASS_              : 'class';
DEF                 : 'def';
TRY                 : 'try';
EXCEPT              : 'except';
FINALLY             : 'finally';

ZERO_DIVIS_ERROR    : 'ZeroDivisionError';
NAME_ERROR          : 'NameError';
IMPORT_ERROR        : 'ImportError';

LBRACKET            : '(';
RBRACKET            : ')';
ASSIGN              : '=';
COLON               : ':';
DOT                 : '.';
COMMA               : ',';

END                 : '#end' ('\n' | '\r\n')?;
WS                  : [ \t\r\n]+ -> skip;
ID                  : [a-z_A-Z][a-zA-Z_0-9]*;