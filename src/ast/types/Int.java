package ast.types;

import ast.Expression;

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

}
