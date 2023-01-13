package code.environment;
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

    public void addEnvironment(Environment env){
        for (Map.Entry<String, Object> entry : env.getValues().entrySet()){
            this.define(entry.getKey(), entry.getValue());;
        }
    }

    public Object get(String name) {
        if (this.values.containsKey(name)){
            return this.values.get(name);
        } else if(this.enclosing != null) {
            return this.enclosing.get(name);
        }

        return null;
    }

    public Object getObjects() {
        return this.values.values();
    }

    public Map<String, Object> getValues(){
        return this.values;
    }

}
