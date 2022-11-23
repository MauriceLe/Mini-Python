package ast;

public class Identifier extends Expression {
    
    private String identifier;

    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toStringTree() {
        return "Identifier: " +  this.identifier;
    }

}
