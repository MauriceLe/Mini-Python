package ast.types;

import ast.Expression;
import visitor.AstVisitor;

public class Int extends Expression {
    
    private int value;

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toStringTree() {
        return "Int " +  this.value;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
