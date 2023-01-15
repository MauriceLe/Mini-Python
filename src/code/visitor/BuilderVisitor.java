package code.visitor;

import code.ast.*;
import code.core.*;
import java.util.*;
import code.ast.types.*;
import code.environment.Environment;
import java.nio.file.Path;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import CBuilder.literals.*;
import CBuilder.objects.*;
import CBuilder.objects.Call;
import CBuilder.objects.MPyClass;
import CBuilder.objects.functions.ReturnStatement;
import CBuilder.variables.VariableDeclaration;
import CBuilder.ProgramBuilder;
import CBuilder.Reference;
import CBuilder.conditions.*;
import CBuilder.conditions.conditionalStatement.*;
import CBuilder.keywords.bool.NotKeyword;


@SuppressWarnings("unchecked")
public class BuilderVisitor implements AstVisitor<Object> {

    private Environment env = new Environment();
    private ProgramBuilder program = new ProgramBuilder();

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
        return new IntLiteral(node.getValue());
    }

    @Override
    public Object visit(Text node) {
        return new StringLiteral(node.getValue());
    }

    @Override
    public Object visit(Bool node) {
        return new BoolLiteral(node.getValue());
    }

    @Override
    public Object visit(Negation node) {
        return new NotKeyword((CBuilder.Expression) node.getExpression().accept(this));
    }

    @Override
    public Object visit(Arithmetic node) {
        return new Call(
            new AttributeReference(
                node.getOperator(), 
                (CBuilder.Expression) node.getOperands().get(0).accept(this)
            ), 
            List.of((CBuilder.Expression) node.getOperands().get(1).accept(this))
        );
    }

    @Override
    public Object visit(Compare node) {
        return new Call(
            new AttributeReference(
                node.getOperator(), 
                (CBuilder.Expression) node.getOperands().get(0).accept(this)
            ), 
            List.of((CBuilder.Expression) node.getOperands().get(1).accept(this))
        );
    }

    @Override
    public Object visit(Assignment node) {
        CBuilder.Expression identifier = (CBuilder.Expression) node.getIdentifier().accept(this);
        CBuilder.Expression expression = (CBuilder.Expression) node.getExpression().accept(this);

        return new CBuilder.variables.Assignment((Reference) identifier, expression);
    }

    @Override
    public Object visit(If node) {
        return new IfThenElseStatement(
            new IfStatement(
                (CBuilder.Expression) node.getCondition().accept(this),
                (List<CBuilder.Statement>) node.getIfBlock().accept(this)
            ), 
            Optional.empty(), 
            node.getElseBlock() == null 
                ? Optional.empty() 
                : Optional.of(new ElseStatement((List<CBuilder.Statement>) node.getElseBlock().accept(this)))
        );
    }

    @Override
    public Object visit(While node) {
        CBuilder.Expression condition = (CBuilder.Expression) node.getCondition().accept(this);
        List<CBuilder.Statement> statements = (List<CBuilder.Statement>) node.getBody().accept(this);

        return new WhileStatement(condition, statements);
    }

    @Override
    public Object visit(Identifier node) {
        return new Reference(node.getIdentifier());
    }

    @Override
    public Object visit(Return node) {
        return new ReturnStatement((CBuilder.Expression) node.getExpression().accept(this));
    }

    @Override
    public Object visit(Method node) {
        return null;
    }

    @Override
    public Object visit(Function node) {
        return null;
    }

    @Override
    public Object visit(DefClass node) {
        String className = node.getIdentifier().getIdentifier();
        Reference parent = null;
        List<CBuilder.objects.functions.Function> methods = new ArrayList<>();
        for(DefMethod method : node.getMethods()){
            CBuilder.objects.functions.Function fun = (CBuilder.objects.functions.Function) method.accept(this);
            methods.add(fun);
        }
        Map<Reference, CBuilder.Expression> attributes = null;
        MPyClass pyClass = new MPyClass(
            className,
            parent,
            methods,
            attributes
        );
        this.program.addClass(pyClass);
        this.env.define(className, pyClass);
        return pyClass;
    }

    @Override
    public Object visit(DefFunction node) {
        String functionName = node.getIdentifier().getIdentifier();
        List<CBuilder.Statement> statements = (List<CBuilder.Statement>) node.getBody().accept(this);
        List<CBuilder.objects.functions.Argument> positionalArguments = new ArrayList<>();
        List<CBuilder.variables.VariableDeclaration> localVariables = new ArrayList<>();
        for(int i = 0; i < node.getParameter().size(); i++){
            String paramName = node.getParameter().get(i).getIdentifier();
            positionalArguments.add(new CBuilder.objects.functions.Argument(paramName, i));
        }
        CBuilder.objects.functions.Function fun = new CBuilder.objects.functions.Function(
            functionName,
            statements,
            positionalArguments,
            localVariables
        );

        this.program.addFunction(fun);
        this.env.define(functionName, fun);

        return fun;
    }

    @Override
    public Object visit(DefMethod node) {
        List<CBuilder.objects.functions.Argument> positionalArguments = new ArrayList<>();
        List<CBuilder.variables.VariableDeclaration> localVariables = new ArrayList<>();
        for(int i = 0; i < node.getParameters().size(); i++){
            String paramName = node.getParameters().get(i).getIdentifier();
            positionalArguments.add(new CBuilder.objects.functions.Argument(paramName, i));
        }
        CBuilder.objects.functions.Function fun = new CBuilder.objects.functions.Function(
            node.getIdentifier().getIdentifier(),
            (List<CBuilder.Statement>) node.getBody().accept(this),
            positionalArguments,
            localVariables
        );
        return fun;
    }

    @Override
    public Object visit(Block node) {
        List<CBuilder.Statement> statements = new ArrayList<>();

        for(Statement statement : node.getStatements()){
            statements.add((CBuilder.Statement) statement.accept(this));
            this.program.addStatement((CBuilder.Statement) statement.accept(this));
        }

        return statements;
    }

    @Override
    public Object visit(ImportModule node) {
      
        try {
            MiniPythonLexer lexer = new MiniPythonLexer(CharStreams.fromFileName("src/test/" + node.toString() + ".mipy"));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            MiniPythonParser parser = new MiniPythonParser(tokens);
    
            ParseTree tree = parser.start();
            AstTreeVisitor visitor = new AstTreeVisitor();
            AstTree ast = (AstTree) visitor.visit(tree);
            BuilderVisitor build = new BuilderVisitor();
            ast.accept(build);

            for (Map.Entry<String, Object> entry : build.getEnvironment().getValues().entrySet()){
                if(entry.getValue() instanceof MPyClass){
                    this.program.addClass((MPyClass) entry.getValue());
                } else if (entry.getValue() instanceof CBuilder.objects.functions.Function){
                    this.program.addFunction((CBuilder.objects.functions.Function) entry.getValue());
                } else if (entry.getValue() instanceof VariableDeclaration) {
                    //this.program.addVariable((VariableDeclaration) entry.getValue());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object visit(AstTree node) {
        node.getBlock().accept(this);
        this.program.writeProgram(Path.of("out"));
        return program;
    }

    public Environment getEnvironment(){
        return this.env;
    }
    
}
