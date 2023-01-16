package code.symbol;

import code.ast.Class;

public class Class extends Symbol {

    private Class _class;

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
