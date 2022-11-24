package symbol;

import java.util.ArrayList;

import ast.Expression;

public class Function extends Symbol implements Callable{

    private ast.DefFunction function;

    public Function(){
        this.function = null;
    }

    public Function(ast.DefFunction f){
        this.function = f;
    }

    @Override
    public Object call(ArrayList<Expression> args) {
        return null;
    }

    public ast.DefFunction getFunction(){
        return this.function;
    }
    
}
