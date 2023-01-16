package code.ast;

import code.visitor.AstVisitor;
import org.antlr.v4.runtime.tree.Tree;

public class Arithmetic extends Expression {
    
    private Expression left;
    private Expression right;
    private Operator operator;

    public enum Operator {
        Multiplication,
        Division,
        Plus,
        Minus
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Expression getLeft() {
        return this.left;
    }

    public Expression getRight() {
        return this.left;
    }

    public void setLeft(Expression expression) {
        this.left = expression;
    }

    public void setRight(Expression expression) {
        this.right = expression;
    }

    public String getOperator() {
        switch(this.operator) {
            case Multiplication: return "__mul__";
            case Division: return "__div__";
            case Plus: return "__add__";
            case Minus: return "__sub__";
            default: return "";
        }
    }

    @Override
    public Tree getChild(int i) {
        switch(i) {
            case 0: return this.left;
            case 1: return this.right;
            default: return super.getChild(i);
        }
    }

    @Override
    public int getChildCount() {
        return 2;
    }

    @Override
    public String toStringTree() {
        return "Operator " +  this.operator;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
