package code.symbol;

import code.ast.DefClass;

public class Class extends Symbol {

    private DefClass _class;

    public Class(){
        this._class = null;
    }

    public Class(code.ast.DefClass c){
        this._class = c;
    }

    @Override
    public String toString(){
        return "Class";
    }
}
