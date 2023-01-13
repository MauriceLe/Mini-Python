package code.symbol;

public abstract class Symbol {
    private Scope scope;

    public void setScope(Scope s){
        this.scope = s;
    }

    public Scope getScope(){
        return this.scope;
    }
}
