package ast;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.tree.Tree;

public class AstTree extends Node {
    
    private List<Statement> statements;

    public AstTree() {
        statements = new ArrayList<>();
    }

    @Override
    public Tree getChild(int i) {
        return this.statements.get(i);
    }

    @Override
    public int getChildCount() {
        return this.statements.size();
    }

    @Override
    public String toStringTree() {
        return "Start";
    }

    public List<Statement> getStatements() {
        return this.statements;
    }

}
