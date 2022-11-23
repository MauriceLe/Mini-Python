grammar MiniPython;

start: statement+? EOF;

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
                | function                              # FunctionExpression
                | method                                # MethodExpression
                | ID                                    # IdExpression
                | INT                                   # IntExpression
                | BOOLEAN                               # BoolExpression
                | STRING                                # StringExpression
                ;

statement       : expression
                | assignment
                | while 
                | if
                | function
                | method
                | def_function
                | def_class
                ;

assignment      : ID ASSIGN expression;

condition       : expression COLON 
                | LBRACKET expression RBRACKET COLON
                ;

exp_parameter   : expression (COMMA expression)*;

fun_parameter   : ID (COMMA ID)*;

return          : RETURN expression;

while           : WHILE condition statement* END;
if              : if_statement elif_statement* else_statement? END;
if_statement    : IF condition statement*;
elif_statement  : ELIF condition statement*;
else_statement  : ELSE statement*;

method          : ID '.' ID LBRACKET fun_parameter RBRACKET;
function        : ID LBRACKET exp_parameter RBRACKET;

def_function    : DEF ID LBRACKET fun_parameter RBRACKET COLON statement* return END;
def_method      : DEF ID LBRACKET SELF (COMMA fun_parameter)? RBRACKET COLON statement* return END;
def_class       : CLASS_ ID (COLON | LBRACKET ID RBRACKET COLON) def_method* END;


INT             : [0-9]+;
BOOLEAN         : 'TRUE' | 'FALSE';
STRING          : ["].*?["] | ['].*?['];
COMMENT         : [#][a-zA-Z_0-9 ]*;

WS              : [ \r\n\t]+ -> skip;
ID              : [a-zA-Z][a-zA-Z_0-9]*;

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

IF              : 'if';
ELIF            : 'elif';
ELSE            : 'else';
WHILE           : 'while';
RETURN          : 'return';
CLASS_          : 'class';
DEF             : 'def';
SELF            : 'self';
END             : '#end';

LBRACKET        : '(';
RBRACKET        : ')';
ASSIGN          : '=';
COLON           : ':';
DOT             : '.';
COMMA           : ',';