package ast.types;

import ast.Expression;

public class Text extends Expression {
    
    private String value;

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
