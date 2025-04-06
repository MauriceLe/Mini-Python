# Mini-Python Compiler

Mini-Python ist ein einfacher Python-ähnlicher Compiler, der in Java und Antlr geschrieben wurde. Er ermöglicht das Parsen und Ausführen von Python-artigem Code und bietet eine grundlegende Implementierung eines Mini-Python-Interpreters. Der Compiler nutzt ein Visitor-Pattern für die Verarbeitung des Abstract Syntax Trees (AST) und wurde entwickelt, um grundlegende Python-ähnliche Funktionen wie Variablen, Funktionen, Klassen, Import, Schleifen und Bedingungen zu unterstützen.

## Funktionen

Mini-Python unterstützt folgende Features:
- **Variablen**: Zuweisung von Werten an Variablen.
- **Funktionen**: Definition und Aufruf von Funktionen.
- **Klassen**: Erstellen von Klassen mit Methoden.
- **Importe**: Importieren von Modulen oder Funktionen.
- **Bedingungen**: Unterstützung für `if`, `elif` und `else`.
- **Fehlerbehandlung**: `try`, `except` und `finally` für Fehlerbehandlung.
- **Schleifen**: Unterstützung für `while`-Schleifen.
- **Arithmetische Operationen**: Addition, Subtraktion, Multiplikation, Division und Vergleichsoperationen.

## Grammatik

Die Grammatik von Mini-Python basiert auf einer angepassten Version von Python, die in Antlr definiert wurde. Die Grammatik umfasst grundlegende Ausdrücke, Anweisungen und Fehlerbehandlung. Hier ein Ausschnitt der Grammatikdefinition:

```antlr
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

assignment          : identifier ASSIGN expression;

return              : RETURN expression;

import_module       : IMPORT identifier
                    | FROM identifier IMPORT identifier
                    ;

while               : WHILE condition statements END;

if                  : if_statement elif_statement* else_statement? END;

try                 : try_statement exc_statement fin_statement? END;

function            : DEF identifier LBRACKET function_parameter RBRACKET COLON statements END;

class               : CLASS_ identifier (COLON | LBRACKET identifier RBRACKET COLON) function* END;
```

## Testbeispiel

Um die Funktionalität von Mini-Python zu testen, können Python-artige Dateien im .mipy-Format verwendet werden. Hier ein Beispiel für eine Testdatei `main.mipy`

```python
try:
    a = 10/0
except ZeroDivisionError:
    print('ZeroDivisionError')
#end

try:
    function(10)
except NameError:
    print('NameError')
#end

try:
    import not_found
except ImportError:
    print('ImportError')
#end

try:
    import not_found
    function(10)
    a = 10/0
except:
    print('Error')
finally:
    print('Finally')
#end

import lib
dog = Dog()
dog.wuff()
print(function(1,2,3))
```

In diesem Beispiel wird die Fehlerbehandlung mit `try`, `except`, und `finally` getestet, und es werden auch Module importiert und Funktionen aufgerufen.

## Installation

1. Klone das Repository:

     ```bash
      git clone https://github.com/MauriceLe/Mini-Python.git
      cd src
     ```
   
2. Abhängigkeiten installieren:

    Stelle sicher, dass Java und Antlr auf deinem System installiert sind. Du kannst Antlr von der offiziellen Webseite herunterladen.

3. Komplilieren:

    ```bash
      antlr4 MiniPython.g4
      javac MiniPython*.java
     ```

4. Ausführen:

    Führe den Mini-Python-Compiler mit einer .mipy-Datei aus

  ```bash
    java MiniPythonCompiler main.mipy
   ```

  
