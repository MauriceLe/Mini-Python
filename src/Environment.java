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

    public void define(String name, Object object) {
        this.values.put(name, object);
    }

    public Object get(String name) {

        if (this.values.containsKey(name)){
            this.values.get(name);
        } else if(this.enclosing != null) {
            this.enclosing.get(name);
        }

        return null;
    }

    public Object getObjects() {
        return this.values.values();
    }

}
