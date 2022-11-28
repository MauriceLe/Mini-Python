package ast;

import org.antlr.v4.runtime.tree.Tree;

import visitor.AstVisitor;

public class While extends Statement{

    private Expression condition;
    private Block body;

    public void setCondition(Expression condition){
        this.condition = condition;
    }

    public Expression getCondition(){
        return this.condition;
    }

    public void setBody(Block body){
        this.body = body;
    }

    public Block getBody(){
        return this.body;
    }

    @Override
    public Tree getChild(int i) {
        return body;
    }

    @Override
    public int getChildCount() {
        return 1;
    }

    @Override
    public String toStringTree() {
        return "While";
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
}
