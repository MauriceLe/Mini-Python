package code.ast;

import code.visitor.AstVisitor;
import org.antlr.v4.runtime.tree.Tree;

public class Try extends Statement{

    private Exception exception;
    private Block try_block;
    private Block except_block;
    private Block finally_block;

    public Exception getException() {
        return this.exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Block getTryBlock() {
        return this.try_block;
    }

    public void setTryBlock(Block block) {
        this.try_block = block;
    }

    public Block getExceptBlock() {
        return this.except_block;
    }

    public void setExceptBlock(Block block) {
        this.except_block = block;
    }

    public Block getFinallyBlock() {
        return this.finally_block;
    }

    public void setFinallyBlock(Block block) {
        this.finally_block = block;
    }

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
