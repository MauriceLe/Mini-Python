package code.visitor;

import code.ast.*;
import code.ast.types.*;
import java.nio.file.Path;
import CBuilder.literals.*;
import CBuilder.ProgramBuilder;
import CBuilder.Reference;
import CBuilder.keywords.bool.NotKeyword;

public class BuilderVisitor implements AstVisitor<Object> {

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

        String operator; 

        switch (node.getOperator()) {
            case MULTI: operator = "__mul__";
            case DIVIS: operator = "__div__";
            case PLUS: operator = "__add__";
            case MINUS: operator = "__sub__";
            default: operator = "";
        }

        return null;
    }

    @Override
    public Object visit(Compare node) {

        String operator; 

        switch (node.getOperator()) {
            case Equal: operator = "__eq__";
            case NotEqual: operator = "__ne__";
            case Greater: operator = "__ge__";
            case Greater_Then: operator = "__gt__";
            case Less: operator = "__le__";
            case Less_Then: operator = "__lt__";
            default: operator = "";
        }

        return null;
    }

    @Override
    public Object visit(Assignment node) {
        CBuilder.Expression identifier = (CBuilder.Expression) node.getIdentifier().accept(this);
        CBuilder.Expression expression = (CBuilder.Expression) node.getExpression().accept(this);

        return new CBuilder.variables.Assignment((Reference) identifier, expression);
    }

    @Override
    public Object visit(Method node) {
        return null;
    }

    @Override
    public Object visit(Statement node) {
        return null;
    }

    @Override
    public Object visit(Expression node) {
        return null;
    }

    @Override
    public Object visit(Function node) {
        return null;
    }

    @Override
    public Object visit(If node) {
        return null;
    }

    @Override
    public Object visit(Identifier node) {
        return new Reference(node.getIdentifier());
    }

    @Override
    public Object visit(Return node) {
        return null;
    }

    @Override
    public Object visit(DefClass node) {
        return null;
    }

    @Override
    public Object visit(DefFunction node) {
        return null;
    }

    @Override
    public Object visit(DefMethod node) {
        return null;
    }

    @Override
    public Object visit(Block node) {
        return null;
    }

    @Override
    public Object visit(While node) {
        return null;
    }

    @Override
    public Object visit(ImportModule node) {
        return null;
    }

    @Override
    public Object visit(AstTree node) {
        ProgramBuilder program = new ProgramBuilder();
        program.writeProgram(Path.of("out"));
        return null;
    }
    
}
