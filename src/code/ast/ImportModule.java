package code.ast;

import code.visitor.AstVisitor;

public class ImportModule extends Statement {
    
    private Identifier module;
    private Identifier component;

    public ImportModule(Identifier i){
        this.module = i;
    }

    public ImportModule(Identifier i, Identifier c){
        this.module = i;
        this.component = c;
    }

    public Identifier getModule(){
        return this.module;
    }

    public Identifier getComponent(){
        return this.component;
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
