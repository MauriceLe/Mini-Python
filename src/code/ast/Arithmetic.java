package code.ast;

import java.util.ArrayList;
import java.util.List;
import code.visitor.AstVisitor;

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

    public Operator getOperator(){
        return this.operator;
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

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
