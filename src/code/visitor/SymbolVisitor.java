package code.visitor;

import java.util.function.Supplier;
import code.ast.*;
import code.ast.Assignment;
import code.ast.Class;
import code.symbol.Scope;
import code.symbol.Symbol;
import code.symbol.Variable;

public class SymbolVisitor extends AstVisitorBase<Object>{

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

    public Object visit(AstTree node){
        nest(()->{
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

    public Object visit(Callable node){return null;};

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

        scope.bind(node.getIdentifier().getText(), nest(()->{
            String base = node.getClass().getName();
            if(base != null){
                code.symbol.Class parent = (code.symbol.Class) scope.resolve(base);

                if(parent == null){

                }
                scope.setParentScope(parent.getScope());
            }

            for(code.ast.Function function : node.getFunctions()){
                function.accept(this);
            }

            node.setScope(scope);
            code.symbol.Class newClass = new code.symbol.Class(node);
            newClass.setScope(scope);
            return newClass;
        }));
        
        return scope.resolve(node.getIdentifier().getText());
    };

    public Object visit(code.ast.Function node){
        if(scope.resolve(node.getIdentifier().getText()) != null){
            System.out.println("Function '" + node.getIdentifier().getText() + "' is already defined or imported");
        }

        scope.bind(node.getIdentifier().getText(), nest(()-> {
            for(Identifier parameter : node.getParameter()){
                scope.bind(parameter.getText(),null);
            }

            node.getBody().accept(this);
            node.setScope(scope);
            
            code.symbol.Function function = new code.symbol.Function(node);
            function.setScope(scope);
            return function;
        }));

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

    public Object visit(ImportModule node){return null;};
    
}
