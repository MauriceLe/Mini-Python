package ast;

import org.antlr.v4.runtime.tree.Tree;

public class Negation extends Expression{

    private Expression expression;

    public Expression getExpression() {
        return this.expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public int getChildCount() {
        return 1;
    }

    @Override
    public Tree getChild(int i) {
        return this.expression;
    }

    @Override
    public String toStringTree() {
        return "Negation";
    }

}
