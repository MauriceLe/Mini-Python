package code.visitor;

import code.ast.*;
import code.ast.types.*;
import code.core.MiniPythonLexer;
import code.core.MiniPythonParser;
import code.environment.*;
import code.environment.Class;
import java.util.List;
import java.util.stream.Collectors;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class InterpreterVisitor implements AstVisitor<Object>{

    private Environment env;

    @Override
    public Object visit(AstTree node) {
        env = new Environment();
        env.define("print", NativeFun.print);
        env.define("input", NativeFun.input);
        node.getBlock().accept(this);
        return env.getObjects();
    }

    @Override
    public Object visit(Arithmetic node) {

        List<Object> values = node.getOperands().stream().
        map(x -> x.accept(this)).collect(Collectors.toList());

        if (values.stream().allMatch(x -> x instanceof Integer)) {
            switch(node.getOperator()) {
                case "__mul__": 
                    return values.stream().reduce((x,y) -> (int)x * (int)y).orElse(1);
                case "__div__": 
                    return values.stream().reduce((x,y) -> (int)x / (int)y).orElse(1);
                case "__add__": 
                    return values.stream().reduce((x,y) -> (int)x + (int)y).orElse(0);
                case "__sub__": 
                    return values.stream().reduce((x,y) -> (int)x - (int)y).orElse(0);
            }
        }

        if (values.stream().anyMatch(x -> x instanceof String) 
            && node.getOperator() == "__add__") {
            return values.stream().reduce((x,y) -> x + y.toString()).orElse("");
        }
    
        return null;
    }

    @Override
    public Object visit(Compare node) {

        List<Object> values = node.getOperands().stream().
        map(x -> x.accept(this)).collect(Collectors.toList());

        if (values.stream().allMatch(x -> x instanceof Integer)) {
            switch (node.getOperator()) {
                case "__eq__":
                    return values.stream().reduce((x,y) -> (int)x == (int)y).orElse(true);
                case "__ne__":
                    return values.stream().reduce((x,y) -> (int)x != (int)y).orElse(true);
                case "__ge__":
                    return values.stream().reduce((x,y) -> (int)x > (int)y).orElse(true);
                case "__gt__":
                    return values.stream().reduce((x,y) -> (int)x >= (int)y).orElse(true);
                case "__le__":
                    return values.stream().reduce((x,y) -> (int)x < (int)y).orElse(true);
                case "__lt__":
                    return values.stream().reduce((x,y) -> (int)x <= (int)y).orElse(true);
            }
        }

        if (values.stream().allMatch(x -> x instanceof String)) {
            switch (node.getOperator()) {
                case "__eq__":
                    return values.stream().reduce((x,y) -> ((String)x).compareTo((String)y) == 0).orElse(true);
                case "__ne__":
                    return values.stream().reduce((x,y) -> ((String)x).compareTo((String)y) != 0).orElse(true);
                case "__ge__":
                    return values.stream().reduce((x,y) -> ((String)x).compareTo((String)y) > 0).orElse(true);
                case "__gt__":
                    return values.stream().reduce((x,y) -> ((String)x).compareTo((String)y) >= 0).orElse(true);
                case "__le__":
                    return values.stream().reduce((x,y) -> ((String)x).compareTo((String)y) < 0).orElse(true);
                case "__lt__":
                    return values.stream().reduce((x,y) -> ((String)x).compareTo((String)y) <= 0).orElse(true);
            }
        }

        if (values.stream().allMatch(x -> x instanceof Boolean)) {
            switch (node.getOperator()) {
                case "__eq__":
                    return values.stream().reduce((x,y) -> (boolean)x == (boolean)y).orElse(true);
                case "__ne__":
                    return values.stream().reduce((x,y) -> (boolean)x != (boolean)y).orElse(true);
                default: break;
            }
        }

        return null;
    }

    @Override
    public Object visit(Negation node) {
        Object value = node.getExpression().accept(this);

        if (value instanceof Boolean) {
            return !(boolean) value;
        }

        return null;
    }

    @Override
    public Object visit(Block node) {
        this.env = new Environment(env);

        for (Statement statement: node.getStatements()) {
            statement.accept(this);
        }

        return null;
    }

    @Override
    public Object visit(If node) {
        if((boolean)node.getCondition().accept(this)){
            node.getIfBlock().accept(this);
        } else {
            if(node.getElseBlock() == null){return null;}
            visit(node.getElseBlock());
        }
        return null;
    }

    @Override
    public Object visit(Method node) {

        Instance id = (Instance)this.env.get(node.getInstance().getText());
        Fun fun = (Fun)(id.get(node.getIdentifier().getText()));

        List<Object> args = node.getParameters().stream().
        map(x -> x.accept(this)).collect(Collectors.toList());

        Environment prev = this.env;

        this.env = new Environment(this.env);

        for (int i=0; i < args.size(); i++) {
            this.env.define(((DefMethod) fun.getNode()).getParameters().get(i).getText(), args.get(i));
        }

        for(Statement stmt: ((DefMethod)fun.getNode()).getBody().getStatements()){
            try{
                Return ret = (Return) stmt;
                return ret.accept(this);
            } catch(Exception e){
                stmt.accept(this);
            }
        }

        this.env = prev;

        return null;
    }

    @Override
    public Object visit(Callable node) {

        Fun fun = (Fun) this.env.get(node.getIdentifier().getText());

        List<Object> args = node.getParameters().stream().
        map(x -> x.accept(this)).collect(Collectors.toList());

        if(fun instanceof NativeFun){
            return ((NativeFun)fun).call(args);
        }

        if(fun instanceof Class){
            return ((Class)fun).call(args);
        }

        Environment prev = this.env;

        this.env = new Environment(this.env);

        for (int i=0; i < args.size(); i++) {
            this.env.define(((Function) fun.getNode()).getParameter().get(i).getText(), args.get(i));
        }

        for(Statement stmt: ((Function)fun.getNode()).getBody().getStatements()){
            try{
                Return ret = (Return)stmt;
                return ret.accept(this);
            } catch(Exception e){
                stmt.accept(this);
            }
        }

        this.env = prev;

        return null;
    }

    @Override
    public Object visit(Identifier node) {
        return env.get(node.getText());
    }
	
	@Override
    public Object visit(Assignment node) {
        this.env.define(node.getIdentifier().getText(), node.getExpression().accept(this));
        return null;
    }

    @Override
    public Object visit(Class node) {
        Environment prev = this.env;
        this.env = new Environment(this.env);

        for(DefMethod method: node.getMethods()){
            method.accept(this);
        }

        Class clazz = new Class(this.env, node);
        this.env = prev;
        this.env.define(node.getIdentifier().getText(), clazz);
        return null;
    }

    @Override
    public Object visit(Function node) {
        Fun fun = new Fun(this.env, node);
        this.env.define(node.getIdentifier().getText(), fun);
        return null;
    }

    @Override
    public Object visit(DefMethod node) {
        Fun method = new Fun(this.env, node);
        this.env.define(node.getIdentifier().getText(), method);
        return null;
    }

    @Override
    public Object visit(While node) {
        while((Boolean) node.getCondition().accept(this)){
            node.getBody().accept(this);
        }
        return null;
    }

    @Override
    public Object visit(ImportModule node) {
        try {
            MiniPythonLexer lexer = new MiniPythonLexer(CharStreams.fromFileName("tests/" + node.toString() + ".mipy"));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            MiniPythonParser parser = new MiniPythonParser(tokens);
    
            ParseTree tree = parser.start();
            AstTreeVisitor visitor = new AstTreeVisitor();
            AstTree ast = (AstTree) visitor.visit(tree);
    
            TreeViewer viewer = new TreeViewer(null, ast);
            viewer.open();
            
            InterpreterVisitor interpreterVisitor = new InterpreterVisitor();
            ast.accept(interpreterVisitor);
            this.env.addEnvironment(interpreterVisitor.getEnvironment());

        } catch (Exception e) {
            e.printStackTrace();;
        }
        return null;
    }

    @Override
    public Object visit(Return node) {
        return node.getExpression().accept(this);
    }

    @Override
    public Object visit(Statement node) {
        return node.accept(this);
    }

    @Override
    public Object visit(Expression node) {
        return node.accept(this);
    }

    @Override
    public Object visit(Int node) {
        return node.getValue();
    }

    @Override
    public Object visit(Text node) {
        return node.getValue();
    }

    @Override
    public Object visit(Bool node) {
        return node.getValue();
    }

    public Environment getEnvironment(){
        return this.env;
    }

    @Override
    public Object visit(code.ast.Class node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(Try node) {
        // TODO Auto-generated method stub
        return null;
    }

}
