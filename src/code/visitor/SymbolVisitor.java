package code.visitor;

import java.util.function.Supplier;
import code.ast.*;
import code.ast.Class;
import code.ast.types.*;
import code.symbol.NativeFunction;
import code.symbol.Scope;
import code.symbol.Symbol;
import code.symbol.Variable;

public class SymbolVisitor implements AstVisitor<Object>{

    protected Scope scope;

    private Symbol nest(Supplier<Symbol> action){
        Scope parent = scope;
        scope = new Scope();

        if(parent != null){
            scope.getParentScope();
        }
        
        Symbol symbol = action.get();

        return symbol;
    }

    public Object visit(Assignment node){
        Identifier identifier = node.getIdentifier();

        if(scope.resolve(identifier.getText()) == null){
            Variable var = new Variable(identifier);
            var.setValue(node.getExpression().accept(this));
            scope.bind(identifier.getText(), var);
        }else {
            node.getExpression().accept(this);
        }

        return null;
    };

    public Object visit(Arithmetic node){
        node.getLeft().accept(this);
        node.getRight().accept(this);
        return null;
    };

    public Object visit(AstTree node) {

        nest(()->{
            scope.bind("print", NativeFunction.print);
            scope.bind("input", NativeFunction.input);
            node.getBlock().accept(this);
            return null;
        });

        return null;
    };

    public Object visit(Compare node){
        node.getLeft().accept(this);
        node.getRight().accept(this);
        return null;
    };

    public Object visit(Statement node){
        return null;
    };

    public Object visit(Expression node){
        return null;
    };

    public Object visit(Negation node){
        node.getExpression().accept(this);
        return null;
    };

    public Object visit(Callable node){
        return null;
    };

    public Object visit(If node){
        node.getCondition().accept(this);
        node.getIfBlock().accept(this);
        
        if(node.getElseBlock() != null){
            node.getElseBlock().accept(this);
        }

        return null;
    };

    public Object visit(Identifier node){
        Symbol symbol = null;

        symbol = scope.resolve(node.getText());

        if(symbol == null){
            System.out.println("Identifier '" + node.getText() + "' is not defined");
        }

        return symbol;
    };

    public Object visit(Return node){
        node.getExpression().accept(this);
        return null;
    };

    public Object visit(Class node){
        if(scope.resolve(node.getIdentifier().getText()) != null){
            System.out.println("Class '" + node.getIdentifier().getText() + "' is already defined or imported");
        }

        Symbol newClass = nest(()->{
            /*if(node.getSuperclass() != null){
                code.symbol.Class parent = (code.symbol.Class) scope.resolve(node.getSuperclass().getText());
                if(parent == null){
                    System.out.println("Class '" + node.getSuperclass().getText() + "' doesn't exist");
                }
                scope.setParentScope(parent.getScope());
            }*/
            for(code.ast.Function function : node.getFunctions()){
                function.accept(this);
            }
            node.setScope(scope);
            code.symbol.Class clazz = new code.symbol.Class(node);
            clazz.setScope(scope);
            return clazz;
        });

        scope.bind(node.getIdentifier().getText(),newClass);
        
        return scope.resolve(node.getIdentifier().getText());
    };

    public Object visit(Function node){
        if(scope.resolve(node.getIdentifier().getText()) != null){
            System.out.println("Function '" + node.getIdentifier().getText() + "' is already defined or imported");
        }

        Symbol function = nest(()->{
            for(Identifier parameter : node.getParameter()){
                scope.bind(parameter.getText(), new Variable(parameter));
            }
            node.setScope(scope);
            node.getBody().accept(this);
            code.symbol.Function func = new code.symbol.Function(node);
            func.setScope(scope);
            return func;
        });

        scope.bind(node.getIdentifier().getText(), function);

        return null;
    };

    public Object visit(Block node){
        nest(() -> {
            for( Statement stmt : node.getStatements()){
                stmt.accept(this);
            }
            node.setScope(scope);

            return null;
        });

        return null;
    };

    public Object visit(While node){
        node.getCondition().accept(this);
        node.getBody().accept(this);
        return null;
    };

    public Object visit(ImportModule node){
        return null;
    }

    @Override
    public Object visit(Int node) {
        return null;
    }

    @Override
    public Object visit(Text node) {
        return null;
    }

    @Override
    public Object visit(Bool node) {
        return null;
    }

    @Override
    public Object visit(Try node) {
        node.getTryBlock().accept(this);
        node.getExceptBlock().accept(this);
        if(node.getFinallyBlock() != null){
            node.getFinallyBlock().accept(this);
        }
        return null;
    };
    
}
