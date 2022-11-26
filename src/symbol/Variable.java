package symbol;

import ast.Identifier;

public class Variable extends Symbol{
    
    private Object value;
    private Identifier identifier;

    public Variable(Identifier i){
        this.identifier = i;
    }

    public void setValue(Object val){
        this.value = val;
    }

    @Override
    public String toString(){
        return "Variable";
    }

}
