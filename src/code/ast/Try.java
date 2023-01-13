package code.ast;

import code.visitor.AstVisitor;
import org.antlr.v4.runtime.tree.Tree;

public class Try extends Statement{

    private Block try_block;
    private Block except_block;
    private Block finally_block;

    @Override
    public int getChildCount() {
        return 2 + (finally_block != null ? 1 : 0);
    }

    @Override
    public Tree getChild(int i) {
        switch (i) {
            case 0: return try_block;
            case 1: return except_block;
            case 2: return finally_block;
            default: return super.getChild(i);
        }
    }

    @Override
    public String toStringTree() {
        return "Try";
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
}
