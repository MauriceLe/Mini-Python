package code.ast;


import java.util.List;
import java.util.ArrayList;
import code.visitor.AstVisitor;
import org.antlr.v4.runtime.tree.Tree;


public class Arithmetic extends Expression {
    
    private List<Expression> operands;
    private Operator operator;

    public Arithmetic() {
        operands = new ArrayList<>();
    }

    public enum Operator {
        Multiplication,
        Division,
        Plus,
        Minus
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
