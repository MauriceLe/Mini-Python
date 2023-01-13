package code.ast.types;

import code.ast.Expression;
import code.visitor.AstVisitor;

public class Bool extends Expression {
    
    private boolean value;

    public boolean getValue() {
        return this.value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public String toStringTree() {
        return "Boolean " +  this.value;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
