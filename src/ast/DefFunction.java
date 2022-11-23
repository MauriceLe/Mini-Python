package ast;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.Tree;

public class DefFunction extends Statement {
    
    private Identifier identifier;
    private List<Identifier> parameters;
    private List<Statement> statements;

    public DefFunction() {
        parameters = new ArrayList<>();
        statements = new ArrayList<>();
    }

    public Identifier getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public void setParameter(Identifier parameter) {
        this.parameters.add(parameter);
    }

    public void setStatement(Statement statement) {
        this.statements.add(statement);
    }
    
    @Override
    public int getChildCount() {
        return this.statements.size();
    }

    @Override
    public Tree getChild(int i) {
        return this.statements.get(i);
    }

    @Override
    public String toStringTree() {
        return "Def-Function: " + this.identifier.getIdentifier();
    }
    

}
