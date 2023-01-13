package code.environment;
public class Instance {
    
    private Class clazz;

    public Instance(Class clazz){
        this.clazz = clazz;
    }

    public Class getClazz(){
        return this.clazz;
    }

    public Fun get(String name){
        Fun method = this.clazz.findMethod(name);
        if(method != null){
            return method;
        }
        return null;
    }

}
