package symbol;

import java.util.List;
import ast.Identifier;

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
