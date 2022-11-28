import ast.*;
import ast.types.*;
import java.util.List;
import visitor.AstVisitor;
import java.util.stream.Collectors;

public class InterpreterVisitor implements AstVisitor<Object>{

    private Environment env;

    @Override
    public Object visit(AstTree node) {
        env = new Environment();
        node.getBlock().accept(this);
        return null;
    }

    @Override
    public Object visit(Arithmetic node) {

        List<Object> values = node.getOperands().stream().
        map(x -> x.accept(this)).collect(Collectors.toList());

        if (values.stream().allMatch(x -> x instanceof Integer)) {
            switch(node.getOperator()) {
                case MULTI: 
                    return values.stream().reduce((x,y) -> (int)x * (int)y).orElse(1);
                case DIVIS: 
                    return values.stream().reduce((x,y) -> (int)x / (int)y).orElse(1);
                case PLUS: 
                    return values.stream().reduce((x,y) -> (int)x + (int)y).orElse(0);
                case MINUS: 
                    return values.stream().reduce((x,y) -> (int)x - (int)y).orElse(0);
            }
        }

        if (values.stream().anyMatch(x -> x instanceof String) 
            && node.getOperator() == Arithmetic.Operator.PLUS) {
            return values.stream().reduce((x,y) -> x + y.toString()).orElse("");
        }
    
        return null;
    }

    @Override
    public Object visit(Compare node) {

        List<Object> values = node.getOperands().stream().
        map(x -> x.accept(this)).collect(Collectors.toList());

        if (values.stream().allMatch(x -> x instanceof Integer)) {
            switch (node.getOperator()) {
                case Equal:
                    return values.stream().reduce((x,y) -> (int)x == (int)y).orElse(true);
                case NotEqual:
                    return values.stream().reduce((x,y) -> (int)x != (int)y).orElse(true);
                case Greater:
                    return values.stream().reduce((x,y) -> (int)x > (int)y).orElse(true);
                case Greater_Then:
                    return values.stream().reduce((x,y) -> (int)x >= (int)y).orElse(true);
                case Less:
                    return values.stream().reduce((x,y) -> (int)x < (int)y).orElse(true);
                case Less_Then:
                    return values.stream().reduce((x,y) -> (int)x <= (int)y).orElse(true);
            }
        }

        if (values.stream().allMatch(x -> x instanceof String)) {
            switch (node.getOperator()) {
                case Equal:
                    return values.stream().reduce((x,y) -> ((String)x).compareTo((String)y) == 0).orElse(true);
                case NotEqual:
                    return values.stream().reduce((x,y) -> ((String)x).compareTo((String)y) != 0).orElse(true);
                case Greater:
                    return values.stream().reduce((x,y) -> ((String)x).compareTo((String)y) > 0).orElse(true);
                case Greater_Then:
                    return values.stream().reduce((x,y) -> ((String)x).compareTo((String)y) >= 0).orElse(true);
                case Less:
                    return values.stream().reduce((x,y) -> ((String)x).compareTo((String)y) < 0).orElse(true);
                case Less_Then:
                    return values.stream().reduce((x,y) -> ((String)x).compareTo((String)y) <= 0).orElse(true);
            }
        }

        if (values.stream().allMatch(x -> x instanceof Boolean)) {
            switch (node.getOperator()) {
                case Equal:
                    return values.stream().reduce((x,y) -> (boolean)x == (boolean)y).orElse(true);
                case NotEqual:
                    return values.stream().reduce((x,y) -> (boolean)x != (boolean)y).orElse(true);
                default: break;
            }
        }

        return null;
    }

    @Override
    public Object visit(Negation node) {
        Object value = node.getExpression().accept(this);

        if (value instanceof Boolean) {
            return !(boolean) value;
        }

        return null;
    }

    @Override
    public Object visit(Block node) {

        for (Statement statement: node.getStatements()) {
            statement.accept(this);
        }

        return null;
    }

    @Override
    public Object visit(If node) {

        if ((Boolean) node.getCondition().accept(this)) {
            return node.getIfBlock().accept(this);
        }
        else if (node.getElseBlock() != null) {
            return node.getElseBlock().accept(this);
        }

        return null;
    }

    @Override
    public Object visit(Method node) {
        return null;
    }

    @Override
    public Object visit(Function node) {
        return null;
    }

    @Override
    public Object visit(Identifier node) {
        return null;
    }
	
	@Override
    public Object visit(Assignment node) {
        return null;
    }

    @Override
    public Object visit(DefClass node) {
        return null;
    }

    @Override
    public Object visit(DefFunction node) {
        return null;
    }

    @Override
    public Object visit(DefMethod node) {
        return null;
    }

    @Override
    public Object visit(Return node) {
        return node.getExpression().accept(this);
    }

    @Override
    public Object visit(Statement node) {
        return node.accept(this);
    }

    @Override
    public Object visit(Expression node) {
        return node.accept(this);
    }

    @Override
    public Object visit(Int node) {
        return node.getValue();
    }

    @Override
    public Object visit(Text node) {
        return node.getValue();
    }

    @Override
    public Object visit(Bool node) {
        return node.getValue();
    }

}
