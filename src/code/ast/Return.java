package code.ast;

import code.visitor.AstVisitor;
import org.antlr.v4.runtime.tree.Tree;

public class Return extends Statement{

    private Expression expression;

    public Expression getExpression() {
        return this.expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public Tree getChild(int i) {
        return expression;
    }

    @Override
    public int getChildCount() {
        return 1;
    }

    @Override
    public String toStringTree() {
        return "Return";
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
}
