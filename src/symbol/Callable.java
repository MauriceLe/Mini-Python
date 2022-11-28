package symbol;

import ast.Expression;
import java.util.ArrayList;

public interface Callable {
    
    public Object call(ArrayList<Expression> args);
    
}
