package interpreter;
import java.util.LinkedHashMap;
import java.util.Map;

public class Environment {
    
    private Environment enclosing;
    private Map<String, Object> values;

    public Environment(){
        enclosing = null;
        this.values = new LinkedHashMap<>();
    }
    
    public Environment(Environment enclosing){
        this.enclosing = enclosing;
        this.values = new LinkedHashMap<>();
    }

    public void assign(String s, Object c){
        if(this.values.containsKey(s)){
            this.values.put(s, c);
        }
        else if(this.enclosing != null) {
            this.enclosing.assign(s, c);
        }
    }


}
