package code.ast;

import code.visitor.AstVisitor;
import org.antlr.v4.runtime.tree.Tree;

public class Compare extends Expression {

    private Expression left;
    private Expression right;
    private Operator operator;

    public enum Operator {
        Equal,
        NotEqual,
        Greater,
        Greater_Then,
        Less,
        Less_Then
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public void setLeft(Expression expression) {
        this.left = expression;
    }

    public void setRight(Expression expression) {
        this.right = expression;
    }

    public Expression getLeft() {
        return this.left;
    }

    public Expression getRight() {
        return this.right;
    }

    public String getOperator() {
        switch(this.operator) {
            case Equal: return "__eq__";
            case NotEqual: return "__ne__";
            case Greater: return "__gt__";
            case Greater_Then: return "__ge__";
            case Less: return "__lt__";
            case Less_Then: return "__le__";
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
        return "Compare " + this.operator;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
}
