package code.symbol;

import java.util.List;

public class Function extends Symbol implements Callable{

    private code.ast.Function function;
    private code.ast.Identifier id;

    public Function(){
        this.function = null;
    }

    public Function(code.ast.Identifier id){
        this.id = id;
    }

    public Function(code.ast.Function f){
        this.function = f;
    }

    @Override
    public Object call(List<Object> args) {
        return null;
    }

    public code.ast.Function getFunction(){
        return this.function;
    }

    @Override
    public String toString(){
        return "Function";
    }
    
}
