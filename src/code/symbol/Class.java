package code.symbol;

public class Class extends Symbol {

    private code.ast.Class _class;

    public Class(){
        this._class = null;
    }

    public Class(code.ast.Class c){
        this._class = c;
    }

    @Override
    public String toString(){
        return "Class";
    }
}
