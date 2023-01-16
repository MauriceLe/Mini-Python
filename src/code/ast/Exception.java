package code.ast;

import code.visitor.AstVisitor;

public class Exception extends Expression {

    @Override
    public String toStringTree() {
        return "Exception";
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
