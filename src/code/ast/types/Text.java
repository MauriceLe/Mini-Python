package code.ast.types;

import code.ast.Expression;
import code.visitor.AstVisitor;

public class Text extends Expression {
    
    private String value;

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toStringTree() {
        return "String " +  this.value;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
