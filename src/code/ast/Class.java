package code.ast;

import java.util.List;
import java.util.ArrayList;
import code.visitor.AstVisitor;
import org.antlr.v4.runtime.tree.Tree;

public class Class extends Statement {

    private Identifier identifier;
    private Identifier superclass;
    private List<Function> functions;

    public Class() {
        functions = new ArrayList<>();
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public Identifier getIdentifier(){
        return this.identifier;
    }

    public Identifier getSuperclass() {
        return this.superclass;
    }

    public void setSuperclass(Identifier superclass) {
        this.superclass = superclass;
    }

    public void setMethod(Function functions) {
        this.functions.add(functions);
    }

    public List<Function> getFunctions(){
        return this.functions;
    }

    @Override
    public int getChildCount() {
        return this.functions.size();
    }

    @Override
    public Tree getChild(int i) {
        return this.functions.get(i);
    }

    @Override
    public String toStringTree() {
        return "Def-Class " + this.identifier.getText();
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
}
