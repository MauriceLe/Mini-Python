package symbol;

import java.util.ArrayList;

import ast.Expression;
import ast.Identifier;

public class Method extends Symbol implements Callable{

    private ast.Identifier id;

    public Method(Identifier id){
        this.id = id;
    }

    @Override
    public Object call(ArrayList<Expression> args) {
        return null;
    }

    @Override
    public String toString(){
        return "Method";
    }
    
}
