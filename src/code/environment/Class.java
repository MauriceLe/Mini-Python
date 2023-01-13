package code.environment;
import code.ast.Node;
import code.symbol.Callable;
import java.util.List;

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
