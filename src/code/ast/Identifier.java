package code.ast;

import code.visitor.AstVisitor;

public class Identifier extends Expression {
    
    private String identifier;

    public Identifier(){}

    public Identifier(String i){
        this.identifier = i;
    }

    public String getText() {
        return this.identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toStringTree() {
        return "Identifier " +  this.identifier;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
