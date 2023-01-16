package code.ast;

import code.visitor.AstVisitor;

public class ImportModule extends Statement {
    
    private Identifier module;

    public ImportModule(Identifier i){
        this.module = i;
    }

    public Identifier getModule(){
        return this.module;
    }

    public void test(){
        System.out.println("a");
    }

    public String toString(){
        return module.getText();
    }

    @Override
    public String toStringTree() {
        return "Module: " + module.toString();
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
