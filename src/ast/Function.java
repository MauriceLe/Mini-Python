package ast;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.Tree;

public class Function extends Statement{

    private Identifier identifier;
    private List<Expression> parameters;

    public Function() {
        parameters = new ArrayList<>();
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
        return "Function " + this.identifier.getIdentifier();
    }
    
}
