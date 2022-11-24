package symbol;

import java.util.LinkedHashMap;
import java.util.Map;

public class Scope {
    
    private final Scope parent;
    private Map<String, Symbol> symbols;

    public Scope(Scope parent){
        this.parent = parent;
        this.symbols = new LinkedHashMap<>();
    }

    public Scope(){
        this.parent = null;
        this.symbols = new LinkedHashMap<>();
    }

    public void bind(String id, Symbol s){
        this.symbols.put(id, s);
        s.setScope(this);
    }

    public Symbol resolve(String id){
        if(this.symbols.containsKey(id)){
            return this.symbols.get(id);
        }
        try{
            return this.parent.resolve(id);
        } catch(NullPointerException e){
            return null;
        }
    }

    

    @Override
    public String toString(){
        String out = "(";
        if(this.parent != null){
            out = out + "(" + this.parent.toString() + ")";
        }
        out = out + this.symbols.toString() + ")";
        return out;
    }

}
