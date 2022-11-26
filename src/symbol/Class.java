package symbol;

public class Class extends Symbol {

    private ast.DefClass _class;

    public Class(){
        this._class = null;
    }

    public Class(ast.DefClass c){
        this._class = c;
    }

    @Override
    public String toString(){
        return "Class";
    }
}
