package ast;

import java.util.List;

public class Arithmetic extends Expression {
    
    private List<Expression> operands;
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

    public List<Expression> getOperands() {
        return this.operands;
    }

    public void setOperand(Expression expression) {
        this.operands.add(expression);
    }

    @Override
    public String toStringTree() {
        return "Operator: " +  this.operator;
    }

}
