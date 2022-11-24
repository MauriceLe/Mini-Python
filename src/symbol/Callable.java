package symbol;

import java.util.ArrayList;

import ast.Expression;

public interface Callable {
    
    public Object call(ArrayList<Expression> args);
    
}
