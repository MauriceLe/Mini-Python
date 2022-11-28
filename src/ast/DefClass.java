package ast;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.tree.Tree;

import visitor.AstVisitor;

public class DefClass extends Statement {

    private Identifier identifier;
    private Identifier superclass;
    private List<Method> methods;

    public DefClass() {
        methods = new ArrayList<>();
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public Identifier getSuperclass() {
        return this.superclass;
    }

    public void setSuperclass(Identifier superclass) {
        this.superclass = superclass;
    }

    public void setMethod(Method method) {
        this.methods.add(method);
    }

    @Override
    public int getChildCount() {
        return this.methods.size();
    }

    @Override
    public Tree getChild(int i) {
        return this.methods.get(i);
    }

    @Override
    public String toStringTree() {
        return "Def-Class " + this.identifier.getIdentifier();
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
}
