package ast;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.Tree;

import visitor.AstVisitor;

public class Method extends Statement {
    
    private Identifier instance;
    private Identifier identifier;
    private List<Identifier> parameters;

    public Method() {
        parameters = new ArrayList<>();
    }

    public Identifier getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public void setInstance(Identifier identifier) {
        this.instance = identifier;
    }

    public Identifier getInstance(){
        return this.instance;
    }

    public void setParameter(Identifier parameter) {
        this.parameters.add(parameter);
    }

    public List<Identifier> getParameters(){
        return this.parameters;
    }
    
    @Override
    public int getChildCount() {
        return this.parameters.size();
    }

    @Override
    public Tree getChild(int i) {
        return this.parameters.get(i);
    }

    @Override
    public String toStringTree() {
        return "Method " + this.identifier.getIdentifier();
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
