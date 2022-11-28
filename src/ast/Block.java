package ast;

import java.util.List;
import visitor.AstVisitor;
import java.util.ArrayList;
import org.antlr.v4.runtime.tree.Tree;

public class Block extends Statement {

    private List<Statement> statements;

    public Block() {
        statements = new ArrayList<>();
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatement(Statement statement) {
        this.statements.add(statement);
    }

    @Override
    public Tree getChild(int i) {
        return statements.get(i);
    }

    @Override
    public int getChildCount() {
        return statements.size();
    }

    @Override
    public String toStringTree() {
        return "Block";
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
