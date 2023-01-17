package code.visitor;

import code.ast.*;
import code.ast.Class;
import code.ast.types.*;
import code.ast.Exception;
import code.ast.exceptions.*;

import java.util.*;
import java.nio.file.Path;
import java.util.stream.Collectors;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import CBuilder.objects.*;
import CBuilder.Reference;
import CBuilder.literals.*;
import CBuilder.conditions.*;
import CBuilder.ProgramBuilder;
import CBuilder.keywords.bool.NotKeyword;
import CBuilder.objects.functions.Argument;
import CBuilder.variables.VariableDeclaration;
import antlr.core.MiniPythonLexer;
import antlr.core.MiniPythonParser;
import CBuilder.objects.functions.ReturnStatement;
import CBuilder.conditions.conditionalStatement.*;


@SuppressWarnings("unchecked")
public class BuilderVisitor implements AstVisitor<Object> {

    private List<Exception> exceptions = new ArrayList<>();
    private List<CBuilder.Statement> statements = new ArrayList<>();
    private List<CBuilder.objects.MPyClass> classes = new ArrayList<>();
    private List<CBuilder.objects.functions.Function> functions = new ArrayList<>();
    private List<CBuilder.variables.VariableDeclaration> variables = new ArrayList<>();

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
    public Object visit(Arithmetic node) {

        CBuilder.Expression right = (CBuilder.Expression) node.getRight().accept(this);

        if (right instanceof IntLiteral) {
            IntLiteral lit = (IntLiteral) right;
            if (node.getOperator() == "__div__" && lit.getValue() == 0) {
                exceptions.add(new ZeroDivisionError());
            }
        }

        return new Call(
            new AttributeReference(node.getOperator(), (CBuilder.Expression) node.getLeft().accept(this)),
            List.of(new CBuilder.Expression[] {(CBuilder.Expression) node.getRight().accept(this)})
        );
    }

    @Override
    public Object visit(Compare node) {
        return new Call(
            new AttributeReference(node.getOperator(), (CBuilder.Expression) node.getLeft().accept(this)),
            List.of(new CBuilder.Expression[] {(CBuilder.Expression) node.getRight().accept(this)})
        );
    }

    @Override
    public Object visit(Negation node) {
        return new NotKeyword((CBuilder.Expression) node.getExpression().accept(this));
    }

    @Override
    public Object visit(Assignment node) {
        CBuilder.Reference identifier = (CBuilder.Reference) node.getIdentifier().accept(this);
        CBuilder.Expression expression = (CBuilder.Expression) node.getExpression().accept(this);

        VariableDeclaration variable = new VariableDeclaration(node.getIdentifier().getText());
        CBuilder.variables.Assignment assign = new CBuilder.variables.Assignment(identifier, expression);

        if (expression instanceof Reference) {
            Reference reference = (Reference) expression;
            if (variables.stream().noneMatch(x -> x.getName().equals(reference.getName()))) {
                exceptions.add(new NameError());
            }
        }

        if (!variables.contains(variable)) {
            variables.add(variable);
        }

        statements.add(assign);

        return assign;
    }

    @Override
    public Object visit(Identifier node) {
        return new Reference(node.getText());
    }

    @Override
    public Object visit(Return node) {
        return new ReturnStatement((CBuilder.Expression) node.getExpression().accept(this));
    }

    @Override
    public Object visit(If node) {

        List<CBuilder.variables.VariableDeclaration> enclosing_variables = variables;
        List<CBuilder.Statement> enclosing_statements = statements;
        variables = new ArrayList<>();
        statements = new ArrayList<>();

        List<ElifStatement> elif_statements = new ArrayList<>();

        for (Map.Entry<Expression, Block> elif: node.getElifBlock().entrySet()) {
            elif_statements.add(
                new ElifStatement((CBuilder.Expression) elif.getKey().accept(this), 
                (List<CBuilder.Statement>) elif.getValue().accept(this))
            );
        }

        IfThenElseStatement _if = new IfThenElseStatement(
            new IfStatement(
                (CBuilder.Expression) node.getCondition().accept(this),
                (List<CBuilder.Statement>) node.getIfBlock().accept(this)
            ),
            Optional.of(elif_statements), 
            node.getElseBlock() == null 
                ? Optional.empty() 
                : Optional.of(new ElseStatement((List<CBuilder.Statement>) node.getElseBlock().accept(this)))
        );

        statements = enclosing_statements;
        variables = enclosing_variables;

        statements.add(_if);

        return _if;
    }

    @Override
    public Object visit(Try node) {
        List<Exception> enclosing_exceptions = exceptions;
        List<CBuilder.Statement> enclosing_statements = statements;
        List<CBuilder.objects.MPyClass> enclosing_classes = classes;
        List<CBuilder.objects.functions.Function> enclosing_functions = functions;
        List<CBuilder.variables.VariableDeclaration> enclosing_variables = variables;
        
        exceptions = new ArrayList<>();
        statements = new ArrayList<>();
        variables = new ArrayList<>();
        functions = new ArrayList<>();
        classes = new ArrayList<>();

        node.getTryBlock().accept(this);
         
        statements = enclosing_statements;
        variables = enclosing_variables;
        functions = enclosing_functions;
        classes = enclosing_classes;

        if (this.exceptions.size() == 0) {
            node.getTryBlock().accept(this);
        } 
        else if (this.exceptions.size() > 0) {
            node.getExceptBlock().accept(this);
        } 
        else {
            for (Exception exception: this.exceptions){
                if (node.getException() != null) {
                    if (node.getException().getClass() == exception.getClass()) {
                        node.getTryBlock().accept(this);
                    }
                }
            }
        }

        if (node.getFinallyBlock() != null){
            node.getFinallyBlock().accept(this);
        }

        this.exceptions = enclosing_exceptions;

        return null;
    }

    @Override
    public Object visit(While node) {

        List<CBuilder.variables.VariableDeclaration> enclosing_variables = variables;
        List<CBuilder.Statement> enclosing_statements = statements;

        variables = new ArrayList<>();
        statements = new ArrayList<>();

        WhileStatement _while = new WhileStatement(
            (CBuilder.Expression) node.getCondition().accept(this), 
            (List<CBuilder.Statement>) node.getBody().accept(this)
        );

        statements = enclosing_statements;
        variables = enclosing_variables;

        statements.add(_while);

        return _while;
    }

    @Override
    public Object visit(Callable node) {
        Call call;

        if (node.getClassIdentifier() != null) {
            call = new Call(
                new AttributeReference(
                    node.getIdentifier().getText(), 
                    (Reference) node.getClassIdentifier().accept(this)
                ), 
                node.getParameters().stream().map(x->(CBuilder.Expression) x.accept(this)).collect(Collectors.toList())
            );
        } 
        else {
            call = new Call(
                (CBuilder.Reference) node.getIdentifier().accept(this), 
                node.getParameters().stream().map(x->(CBuilder.Expression) x.accept(this)).collect(Collectors.toList())
            );
        }

        statements.add(call);

        if (functions.stream().noneMatch(x -> x.getName().equals(node.getIdentifier().getText()))){
            exceptions.add(new NameError());
        }

        return call;
    }

    @Override
    public Object visit(Function node) {

        List<CBuilder.variables.VariableDeclaration> enclosing_variables = variables;
        List<CBuilder.Statement> enclosing_statements = statements;

        variables = new ArrayList<>();
        statements = new ArrayList<>();

        List<Argument> arguments = new ArrayList<>();
        
        for (int i=0; i<node.getParameter().size(); i++) {
            arguments.add(new Argument(node.getParameter().get(i).getText(), i));
        }

        CBuilder.objects.functions.Function function = new CBuilder.objects.functions.Function(
            node.getIdentifier().getText(), 
            (List<CBuilder.Statement>) node.getBody().accept(this), 
            arguments, 
            variables
        );
        
        statements = enclosing_statements;
        variables = enclosing_variables;

        functions.add(function);

        return function;
    }

    @Override
    public Object visit(Class node) {

        List<CBuilder.objects.functions.Function> enclosing = functions;
        functions = new ArrayList<>();

        for (Function function: node.getFunctions()) {
            if (function.getIdentifier().getText().equals("__init__")) {
                functions.add(new CBuilder.objects.functions.Function(
                    "__init__",
                    List.of(new CBuilder.objects.SuperCall(List.of())),
                    List.of(new CBuilder.objects.functions.Argument("self", 0)),
                    List.of()
                ));
            } else { 
                function.accept(this);
            }
        }

        CBuilder.objects.MPyClass _class = new CBuilder.objects.MPyClass(
            node.getIdentifier().getText(),
            node.getSuperclass() != null 
                ? new CBuilder.Reference(node.getSuperclass().getText()) 
                : new CBuilder.Reference("__MPyType_Object"),
            functions,
            Map.of()
        );

        functions = enclosing;

        classes.add(_class);

        return _class;
    }

    @Override
    public Object visit(ImportModule node) {

        List<CBuilder.variables.VariableDeclaration> variables = new ArrayList<>();
        List<CBuilder.objects.functions.Function> functions = new ArrayList<>();
        List<CBuilder.objects.MPyClass> classes = new ArrayList<>();
        List<CBuilder.Statement> statements = new ArrayList<>();

        try {
            MiniPythonLexer lexer = new MiniPythonLexer(CharStreams.fromFileName("src/test/" + node.getModule().getText() + ".mipy"));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            MiniPythonParser parser = new MiniPythonParser(tokens);
            ParseTree tree = parser.start();
            AstTreeVisitor visitor = new AstTreeVisitor();
            AstTree ast = (AstTree) visitor.visit(tree);
            BuilderVisitor build = new BuilderVisitor();
            ast.accept(build);
            variables = build.getVariables();
            functions = build.getFunctions();
            classes = build.getClasses();
            statements = build.getStatements();
        } catch(java.lang.Exception e){
            this.exceptions.add(new ImportError());
        }

        if (node.getComponent() == null){
            for (CBuilder.variables.VariableDeclaration var : variables){
                this.variables.add(var);
            }
            for (CBuilder.objects.functions.Function fun : functions){
                this.functions.add(fun);
            }
            for (CBuilder.objects.MPyClass cla : classes){
                this.classes.add(cla);
            }
            for (CBuilder.Statement stmt : statements){
                this.statements.add(stmt);
            }
        } else {
            boolean found = false;
            for (CBuilder.variables.VariableDeclaration var : variables){
                if(var.getName().equals(node.getComponent().getText())){
                    this.variables.add(var);
                    found = true;
                }
            }
            for (CBuilder.objects.functions.Function fun : functions){
                if(fun.getName().equals(node.getComponent().getText()) ){
                    this.functions.add(fun);
                    found = true;
                }
            }
            for (CBuilder.objects.MPyClass cla : classes){
                if(cla.getName().equals(node.getComponent().getText())){
                    this.classes.add(cla);
                    found = true;
                }
            }
            if (!found){
                this.exceptions.add(new NameError());
            }
        }

        return null;
    }

    @Override
    public Object visit(Block node) {
        List<CBuilder.Statement> statements = new ArrayList<>();

        for(Statement statement : node.getStatements()){
            statements.add((CBuilder.Statement) statement.accept(this));
        }

        return statements;
    }

    @Override
    public Object visit(AstTree node) {
        
        ProgramBuilder program = new ProgramBuilder();

        node.getBlock().accept(this);

        for (CBuilder.objects.functions.Function function: functions) {
            program.addFunction(function);
        }
        for (CBuilder.Statement statement: statements) {
            program.addStatement(statement);
        }
        for (CBuilder.objects.MPyClass _class: classes) {
            program.addClass(_class);
        }
        for (CBuilder.variables.VariableDeclaration variable: variables) {
            program.addVariable(variable);
        }

        program.writeProgram(Path.of("out"));
        
        return null;
    }

    public List<CBuilder.variables.VariableDeclaration> getVariables() {
        return this.variables;
    }

    public List<CBuilder.objects.functions.Function> getFunctions() {
        return this.functions;
    }

    public List<CBuilder.objects.MPyClass> getClasses() {
        return this.classes;
    }

    public List<CBuilder.Statement> getStatements() {
        return this.statements;
    }

}
