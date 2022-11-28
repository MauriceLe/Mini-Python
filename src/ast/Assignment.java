package ast;

import org.antlr.v4.runtime.tree.Tree;

import visitor.AstVisitor;

public class Assignment extends Statement {
    
    private Identifier identifier;
    private Expression expression;

    public Identifier getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public Expression getExpression() {
        return this.expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
    
    @Override
    public Tree getChild(int i) {
        switch (i) {
            case 0: return this.identifier;
            case 1: return this.expression;
            default: return super.getChild(i);
        }
    }

    @Override
    public int getChildCount() {
        return 2;
    }

    @Override
    public String toStringTree() {
        return "Assignment";
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
