import java.util.List;

import ast.Node;
import symbol.Callable;

public class Class extends Fun implements Callable{

    public Class(Environment env, Node node) {
        super(env, node);
    }

    public Fun findMethod(String name){
        return (Fun)this.getClosure().get(name);
    }

    @Override
    public Object call(List<Object> args) {
        return new Instance(this);
    }
    
}
