package code.ast;

import java.util.List;
import java.util.ArrayList;
import code.visitor.AstVisitor;
import org.antlr.v4.runtime.tree.Tree;

public class Callable extends Expression {

    private Identifier class_identifier;
    private Identifier identifier;
    private List<Expression> parameters;

    public Callable() {
        parameters = new ArrayList<>();
    }

    public Identifier getClassIdentifier() {
        return this.class_identifier;
    }

    public void setClassIdentifier(Identifier identifier) {
        this.class_identifier = identifier;
    }

    public Identifier getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public void setParameter(Expression parameter) {
        this.parameters.add(parameter);
    }
    
    public List<Expression> getParameters() {
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
        return "Function " + this.identifier.getText();
    }
    
    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
