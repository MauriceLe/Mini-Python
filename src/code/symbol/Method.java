package code.symbol;

import code.ast.Identifier;
import java.util.List;

public class Method extends Symbol implements Callable{

    private Identifier id;

    public Method(Identifier id){
        this.id = id;
    }

    @Override
    public Object call(List<Object> args) {
        return null;
    }

    @Override
    public String toString(){
        return "Method ";
    }
    
}
