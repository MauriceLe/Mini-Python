package ast.types;

import ast.Expression;

public class Bool extends Expression {
    
    private boolean value;

    public boolean getValue() {
        return this.value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

}
