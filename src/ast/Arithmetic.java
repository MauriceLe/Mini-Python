package ast;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.tree.Tree;

public class Arithmetic extends Expression {
    
    private List<Expression> operands;
    private Operator operator;

    public Arithmetic() {
        operands = new ArrayList<>();
    }

    public enum Operator {
        MULTI,
        DIVIS,
        PLUS,
        MINUS
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
    public Tree getChild(int i) {
        return this.operands.get(i);
    }

    @Override
    public int getChildCount() {
        return this.operands.size();
    }

    @Override
    public String toStringTree() {
        return "Operator " +  this.operator;
    }

}
