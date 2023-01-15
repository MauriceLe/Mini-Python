package code.ast;


import java.util.List;
import java.util.ArrayList;
import code.visitor.AstVisitor;
import org.antlr.v4.runtime.tree.Tree;


public class Compare extends Expression {

    private List<Expression> operands;
    private Operator operator;

    public Compare() {
        operands = new ArrayList<>();
    }

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

    public void setOperand(Expression expression) {
        this.operands.add(expression);
    }

    public List<Expression> getOperands() {
        return this.operands;
    }

    public String getOperator() {
        switch(this.operator) {
            case Equal: return "__eq__";
            case NotEqual: return "__ne__";
            case Greater: return "__ge__";
            case Greater_Then: return "__gt__";
            case Less: return "__le__";
            case Less_Then: return "__lt__";
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
        return "Compare " + this.operator;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
}
