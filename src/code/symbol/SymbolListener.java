package code.symbol;
import code.ast.*;
import code.core.MiniPythonBaseListener;
import code.core.MiniPythonParser;
import code.symbol.*;

public class SymbolListener extends MiniPythonBaseListener{
    
    private Scope scope;

	@Override public void enterStart(MiniPythonParser.StartContext ctx) {
        
        this.scope = new Scope();
        NativeFunction.print.setScope(this.scope);
        NativeFunction.input.setScope(this.scope);
        this.scope.bind("print", NativeFunction.print);
        this.scope.bind("input", NativeFunction.input);

    }

	@Override 
    public void enterIdExpression(MiniPythonParser.IdExpressionContext ctx) {
        try{
            Variable v = (Variable) this.scope.resolve(ctx.ID().getText());
        } catch(Exception e){
            code.symbol.Class c = (code.symbol.Class) this.scope.resolve(ctx.ID().getText());
        }
    }

	@Override 
    public void exitIdExpression(MiniPythonParser.IdExpressionContext ctx) {}

	@Override 
    public void enterIdentifier(MiniPythonParser.IdentifierContext ctx) { }

	@Override 
    public void exitIdentifier(MiniPythonParser.IdentifierContext ctx) { }

	@Override 
    public void enterAssignment(MiniPythonParser.AssignmentContext ctx) {
        Variable v;
        try {
            v = (Variable) this.scope.resolve(ctx.identifier().getText());
            v.setValue(ctx.expression());
        } catch(NullPointerException e){
            v = new Variable(new Identifier(ctx.identifier().getText()));
            v.setScope(this.scope);;
            v.setValue(ctx.expression());
            this.scope.bind(ctx.identifier().getText(), v);
        }
    }

	@Override 
    public void exitAssignment(MiniPythonParser.AssignmentContext ctx) {
        System.out.println(this.scope);
    }

	@Override 
    public void enterMethod(MiniPythonParser.MethodContext ctx) {
        code.symbol.Method m = (code.symbol.Method)this.scope.resolve(ctx.identifier().get(1).getText());
        this.scope = m.getScope();
    }

	@Override 
    public void exitMethod(MiniPythonParser.MethodContext ctx) {
        if(this.scope.getParentScope() != null){
            this.scope = this.scope.getParentScope();
        }
    }

	@Override 
    public void enterFunction(MiniPythonParser.FunctionContext ctx) {
        code.symbol.Function v = (code.symbol.Function)this.scope.resolve(ctx.identifier().getText());
        this.scope = v.getScope();
        //TODO: Pass values to parameter variables
    }

	@Override 
    public void exitFunction(MiniPythonParser.FunctionContext ctx) {
        if(this.scope.getParentScope() != null){
            this.scope = this.scope.getParentScope();
        }
    }

	@Override 
    public void enterDef_function(MiniPythonParser.Def_functionContext ctx) {
        code.symbol.Function f = new code.symbol.Function();
        f.setScope(new Scope(scope));
        f.getScope().setParentScope(scope);
        for (MiniPythonParser.IdentifierContext identifier: ctx.fun_parameter().identifier()) {
            f.getScope().bind(identifier.getText(), new Variable(new Identifier(identifier.getText())));
        }
        this.scope.bind(ctx.identifier().getText(), f);
        this.scope = f.getScope();
    }

	@Override 
    public void exitDef_function(MiniPythonParser.Def_functionContext ctx) {
        if(this.scope.getParentScope() != null){
            this.scope = this.scope.getParentScope();
        }
    }

	@Override 
    public void enterDef_method(MiniPythonParser.Def_methodContext ctx) {
        code.symbol.Method m = new code.symbol.Method(new Identifier(ctx.identifier().getText()));
        m.setScope(new Scope(scope));
        if(ctx.fun_parameter() != null){
            for (MiniPythonParser.IdentifierContext identifier: ctx.fun_parameter().identifier()) {
                m.getScope().bind(identifier.getText(), new Variable(new Identifier(identifier.getText())));
            }
        }
        this.scope.bind(ctx.identifier().getText(), m);
    }

	@Override 
    public void exitDef_method(MiniPythonParser.Def_methodContext ctx) {
        System.out.println(this.scope);
    }

	@Override 
    public void enterDef_class(MiniPythonParser.Def_classContext ctx) {
        code.symbol.Class c = new code.symbol.Class();
        c.setScope(new Scope(scope));
        try{
            c.getScope().setParentScope(this.scope.resolve(ctx.identifier().get(1).getText()).getScope());
        } catch(Exception e){}

        for (MiniPythonParser.Def_methodContext method: ctx.def_method()) {
            c.getScope().bind(method.identifier().getText(), new code.symbol.Method(new Identifier(method.identifier().getText())));
        }
        this.scope.bind(ctx.identifier().get(0).getText(), c);
    }

	@Override 
    public void exitDef_class(MiniPythonParser.Def_classContext ctx) {}
}
