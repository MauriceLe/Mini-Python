package ast;

import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.Tree;

public class If extends Statement {

    private Expression if_condition;
    private List<Statement> if_statements;
    private List<Expression> elif_condition;
    private List<List<Statement>> elif_statements;
    private List<Statement> else_statements;

    public If() {
        if_statements = new ArrayList<>();
        elif_condition = new ArrayList<>();
        elif_statements = new ArrayList<>();
        else_statements = new ArrayList<>();
    }

    public void setIfCondition(Expression condition) {
        this.if_condition = condition;
    }

    public void setIfStatement(Statement statement) {
        this.if_statements.add(statement);
    }

    public void setElifCondition(Expression expression) {
        this.elif_condition.add(expression);
    }

    public void setElifStatement(Expression expression, Statement statements) {
        this.elif_statements.get(this.elif_condition.indexOf(expression)).add(statements);
    }

    public void setElseStatement(Statement statement) {
        this.else_statements.add(statement);
    }

    @Override
    public int getChildCount() {
        return 0;
    }

    @Override
    public Tree getChild(int i) {
        return null;
    }

    @Override
    public String toStringTree() {
        return "If" + this.if_condition.toString();
    }
    
}
