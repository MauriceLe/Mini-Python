package ast;

import org.antlr.v4.runtime.tree.Tree;
import visitor.AstVisitor;

public class AstTree extends Node {
    
    private Block block;

    public AstTree() {
        block = new Block();
    }

    public Block getBlock() {
        return this.block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    @Override
    public Tree getChild(int i) {
        return this.block;
    }

    @Override
    public int getChildCount() {
        return 1;
    }

    @Override
    public String toStringTree() {
        return "Start";
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
