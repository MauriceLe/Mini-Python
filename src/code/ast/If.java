package code.ast;

import code.visitor.AstVisitor;
import java.util.LinkedHashMap;
import java.util.Map;
import org.antlr.v4.runtime.tree.Tree;

public class If extends Statement {

    private Expression condition;
    private Block if_block;
    private Map<Expression, Block> elif_block;
    private Block else_block;

    public If() {
        this.elif_block = new LinkedHashMap<>();
    }

    public Expression getCondition() {
        return this.condition;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }

    public Block getIfBlock() {
        return this.if_block;
    }

    public void setIfBlock(Block block) {
        this.if_block = block;
    }

    public Map<Expression, Block> getElifBlock() {
        return this.elif_block;
    }

    public void setElifBlock(Expression expression, Block block) {
        this.elif_block.put(expression, block);
    }

    public Block getElseBlock() {
        return this.else_block;
    }

    public void setElseBlock(Block block) {
        this.else_block = block;
    }
    
    @Override
    public int getChildCount() {
        return 1 + (if_block != null ? 1 : 0) + (else_block != null ? 1 : 0);
    }

    @Override
    public Tree getChild(int i) {
        switch (i) {
            case 0: return condition;
            case 1: return if_block;
            case 2: return else_block;
            default: return super.getChild(i);
        }
    }

    @Override
    public String toStringTree() {
        return "If";
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
}
