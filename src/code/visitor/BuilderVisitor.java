package code.visitor;

import code.ast.*;
import code.ast.Class;

import java.util.*;
import java.util.stream.Collectors;
import code.ast.types.*;
import java.nio.file.Path;
import CBuilder.literals.*;
import CBuilder.objects.*;
import CBuilder.objects.functions.Argument;
import CBuilder.objects.functions.ReturnStatement;
import CBuilder.variables.VariableDeclaration;
import CBuilder.ProgramBuilder;
import CBuilder.Reference;
import CBuilder.conditions.*;
import CBuilder.conditions.conditionalStatement.*;
import CBuilder.keywords.bool.NotKeyword;


@SuppressWarnings("unchecked")
public class BuilderVisitor implements AstVisitor<Object> {

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
        CBuilder.variables.Assignment assignment = new CBuilder.variables.Assignment(identifier, expression);

        if (!variables.contains(variable)) {
            variables.add(variable);
        }

        statements.add(assignment);

        return assignment;
    }

    @Override
    public Object visit(If node) {

        List<CBuilder.Statement> enclosing_statements = statements;
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
        statements.add(_if);

        return _if;
    }

    @Override
    public Object visit(While node) {
        WhileStatement while_Statement = new WhileStatement(
            (CBuilder.Expression) node.getCondition().accept(this), 
            (List<CBuilder.Statement>) node.getBody().accept(this)
        );

        statements.add(while_Statement);

        return while_Statement;
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
    public Object visit(Callable node) {
        Call function = new Call(
            (CBuilder.Reference) node.getIdentifier().accept(this), 
            node.getParameters().stream().map(x->(CBuilder.Expression) x.accept(this)).collect(Collectors.toList())
        );

        statements.add(function);
      
        return function;
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

        if (node.getFunctions().stream().noneMatch(f -> f.getIdentifier().getText().equals("__init__"))) {
            functions.add(new CBuilder.objects.functions.Function(
                "__init__",
                List.of(new CBuilder.objects.SuperCall(List.of())),
                List.of(new CBuilder.objects.functions.Argument("self", 0)),
                List.of()
            ));
        }

        for (Function function: node.getFunctions()) {
            function.accept(this);
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

}
