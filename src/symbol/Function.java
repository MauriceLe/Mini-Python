package symbol;

import java.util.List;

public class Function extends Symbol implements Callable{

    private ast.DefFunction function;
    private ast.Identifier id;

    public Function(){
        this.function = null;
    }

    public Function(ast.Identifier id){
        this.id = id;
    }

    public Function(ast.DefFunction f){
        this.function = f;
    }

    @Override
    public Object call(List<Object> args) {
        return null;
    }

    public ast.DefFunction getFunction(){
        return this.function;
    }

    @Override
    public String toString(){
        return "Function";
    }
    
}
