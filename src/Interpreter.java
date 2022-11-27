
import ast.*;
import interpreter.*;

public class Interpreter implements AstVisitor<Object>{

    private Environment env;
    private AstTree root;

    public Interpreter(AstTree t){
        this.root = t;
        this.env = new Environment();
    }

    @Override
    public Object visit(Arithmetic node) {
        
        switch (node.getOperator()) {
            case MINUS:
                break;
            case DIVIS:
                break;
            case PLUS:
                break;
            case MULTI:
                break;
            default:
                break;
        }

        return null;
    }

    @Override
    public Object visit(Method node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(Compare node) {
        
        switch (node.getOperator()) {
            case Equal:
                break;
            case NotEqual:
                break;
            case Greater:
                break;
            case Greater_Then:
                break;
            case Less:
                break;
            case Less_Then:
                break;
            default:
                break;
        }

        return null;
    }

    @Override
    public Object visit(Statement node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(Expression node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(Negation node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(Function node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(If node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(Identifier node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(Return node) {
        // TODO Auto-generated method stub
        return null;
    }
	
	@Override
    public Object visit(Assignment node) {
        // TODO Auto-generated method stub
        return null;
    }

}
