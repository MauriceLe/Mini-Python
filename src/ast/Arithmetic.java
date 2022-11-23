package ast;

public class Arithmetic extends Expression {
    
    private Expression left;
    private Expression right;
    private Operator operator;

    public enum Operator {
        MULTI,
        DIVIS,
        PLUS,
        MINUS
    }

    public Operator getOperator() {
        return this.operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Expression getLeft() {
        return this.left;
    }

    public Expression getRight() {
        return this.right;
    }

    public void setLeft(Expression left) {
        this.left = left;
    }

    public void setRight(Expression right) {
        this.right = right;
    }

}
