import ast.*;
import ast.types.*;
import java.util.List;
import visitor.AstVisitor;
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
                case MULTI: 
                    return values.stream().reduce((x,y) -> (int)x * (int)y).orElse(1);
                case DIVIS: 
                    return values.stream().reduce((x,y) -> (int)x / (int)y).orElse(1);
                case PLUS: 
                    return values.stream().reduce((x,y) -> (int)x + (int)y).orElse(0);
                case MINUS: 
                    return values.stream().reduce((x,y) -> (int)x - (int)y).orElse(0);
            }
        }

        if (values.stream().anyMatch(x -> x instanceof String) 
            && node.getOperator() == Arithmetic.Operator.PLUS) {
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
                case Equal:
                    return values.stream().reduce((x,y) -> (int)x == (int)y).orElse(true);
                case NotEqual:
                    return values.stream().reduce((x,y) -> (int)x != (int)y).orElse(true);
                case Greater:
                    return values.stream().reduce((x,y) -> (int)x > (int)y).orElse(true);
                case Greater_Then:
                    return values.stream().reduce((x,y) -> (int)x >= (int)y).orElse(true);
                case Less:
                    return values.stream().reduce((x,y) -> (int)x < (int)y).orElse(true);
                case Less_Then:
                    return values.stream().reduce((x,y) -> (int)x <= (int)y).orElse(true);
            }
        }

        if (values.stream().allMatch(x -> x instanceof String)) {
            switch (node.getOperator()) {
                case Equal:
                    return values.stream().reduce((x,y) -> ((String)x).compareTo((String)y) == 0).orElse(true);
                case NotEqual:
                    return values.stream().reduce((x,y) -> ((String)x).compareTo((String)y) != 0).orElse(true);
                case Greater:
                    return values.stream().reduce((x,y) -> ((String)x).compareTo((String)y) > 0).orElse(true);
                case Greater_Then:
                    return values.stream().reduce((x,y) -> ((String)x).compareTo((String)y) >= 0).orElse(true);
                case Less:
                    return values.stream().reduce((x,y) -> ((String)x).compareTo((String)y) < 0).orElse(true);
                case Less_Then:
                    return values.stream().reduce((x,y) -> ((String)x).compareTo((String)y) <= 0).orElse(true);
            }
        }

        if (values.stream().allMatch(x -> x instanceof Boolean)) {
            switch (node.getOperator()) {
                case Equal:
                    return values.stream().reduce((x,y) -> (boolean)x == (boolean)y).orElse(true);
                case NotEqual:
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

        Instance id = (Instance)this.env.get(node.getInstance().getIdentifier());
        Fun fun = (Fun)(id.get(node.getIdentifier().getIdentifier()));

        List<Object> args = node.getParameters().stream().
        map(x -> x.accept(this)).collect(Collectors.toList());

        Environment prev = this.env;

        this.env = new Environment(this.env);

        for (int i=0; i < args.size(); i++) {
            this.env.define(((DefMethod) fun.getNode()).getParameters().get(i).getIdentifier(), args.get(i));
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
    public Object visit(Function node) {

        Fun fun = (Fun) this.env.get(node.getIdentifier().getIdentifier());

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
            this.env.define(((DefFunction) fun.getNode()).getParameter().get(i).getIdentifier(), args.get(i));
        }

        for(Statement stmt: ((DefFunction)fun.getNode()).getBody().getStatements()){
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
        return env.get(node.getIdentifier());
    }
	
	@Override
    public Object visit(Assignment node) {
        this.env.define(node.getIdentifier().getIdentifier(), node.getExpression().accept(this));
        return null;
    }

    @Override
    public Object visit(DefClass node) {
        Environment prev = this.env;
        this.env = new Environment(this.env);

        for(DefMethod method: node.getMethods()){
            method.accept(this);
        }

        Class clazz = new Class(this.env, node);
        this.env = prev;
        this.env.define(node.getIdentifier().getIdentifier(), clazz);
        return null;
    }

    @Override
    public Object visit(DefFunction node) {
        Fun fun = new Fun(this.env, node);
        this.env.define(node.getIdentifier().getIdentifier(), fun);
        return null;
    }

    @Override
    public Object visit(DefMethod node) {
        Fun method = new Fun(this.env, node);
        this.env.define(node.getIdentifier().getIdentifier(), method);
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

}
