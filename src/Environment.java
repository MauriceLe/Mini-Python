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

    public void define(String name) {
        
    }

    public void assign(String name, Object value){
        if(this.values.containsKey(name)){
            this.values.put(name, value);
        }
        else if(this.enclosing != null) {
            this.enclosing.assign(name, value);
        }
    }

    public Object getObject(String name) {
        return values.get(name);
    }

    public Object getObjects() {
        return this.values.values();
    }

}
