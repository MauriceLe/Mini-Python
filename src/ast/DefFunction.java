package ast;

import java.util.List;
import visitor.AstVisitor;
import java.util.ArrayList;
import org.antlr.v4.runtime.tree.Tree;

public class DefFunction extends Statement {
    
    private Identifier identifier;
    private List<Identifier> parameters;
    private Block body;

    public DefFunction() {
        parameters = new ArrayList<>();
    }

    public Identifier getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public List<Identifier> getParameter() {
        return this.parameters;
    }

    public void setParameter(Identifier parameter) {
        this.parameters.add(parameter);
    }

    public void setBody(Block body) {
        this.body = body;
    }
    
    @Override
    public int getChildCount() {
        return 1;
    }

    @Override
    public Tree getChild(int i) {
        return this.body;
    }

    @Override
    public String toStringTree() {
        return "Def-Function " + this.identifier.getIdentifier();
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
}
