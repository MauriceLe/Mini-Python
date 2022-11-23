import ast.*;
import ast.types.*;

public class AstTreeVisitor extends MiniPythonBaseVisitor<Node> {

    @Override 
    public Node visitStart(MiniPythonParser.StartContext ctx) { 
        AstTree tree = new AstTree();

        for (MiniPythonParser.StatementContext statement: ctx.statement()) {
            tree.getStatements().add((Statement) visit(statement));
        }

        return tree;
    }
	
	@Override 
    public Node visitIntExpression(MiniPythonParser.IntExpressionContext ctx) { 
        Int integer = new Int();
        integer.setValue(Integer.parseInt(ctx.INT().getText()));
        return integer;
    }

    @Override 
    public Node visitStringExpression(MiniPythonParser.StringExpressionContext ctx) { 
        Text string = new Text();
        string.setValue(ctx.STRING().getText());
        return string;
    }

    @Override 
    public Node visitBoolExpression(MiniPythonParser.BoolExpressionContext ctx) {
        Bool bool = new Bool();
        bool.setValue(Boolean.parseBoolean(ctx.BOOLEAN().getText()));
        return bool;
    }

    @Override 
    public Node visitIdExpression(MiniPythonParser.IdExpressionContext ctx) { 
        Identifier identifier =  new Identifier();
        identifier.setIdentifier(ctx.ID().getText());
        return identifier;
    }

    @Override 
    public Node visitIdentifier(MiniPythonParser.IdentifierContext ctx) { 
        Identifier identifier =  new Identifier();
        identifier.setIdentifier(ctx.ID().getText());
        return identifier;
    }

    @Override 
    public Node visitMultiplyExpression(MiniPythonParser.MultiplyExpressionContext ctx) {
        Arithmetic arithmetic = new Arithmetic();
        arithmetic.setOperator(Arithmetic.Operator.MULTI);
 
        for (MiniPythonParser.ExpressionContext expression: ctx.expression()) {
            arithmetic.setOperand((Expression) visit(expression));
        }

        return arithmetic;
    }

    @Override 
    public Node visitDivisionExpression(MiniPythonParser.DivisionExpressionContext ctx) { 
        Arithmetic arithmetic = new Arithmetic();
        arithmetic.setOperator(Arithmetic.Operator.DIVIS);
    
        for (MiniPythonParser.ExpressionContext expression: ctx.expression()) {
            arithmetic.setOperand((Expression) visit(expression));
        }

        return arithmetic;
    }

    @Override
    public Node visitPlusExpression(MiniPythonParser.PlusExpressionContext ctx) { 
        Arithmetic arithmetic = new Arithmetic();
        arithmetic.setOperator(Arithmetic.Operator.PLUS);
    
        for (MiniPythonParser.ExpressionContext expression: ctx.expression()) {
            arithmetic.setOperand((Expression) visit(expression));
        }

        return arithmetic;
    }

    @Override 
    public Node visitMinusExpression(MiniPythonParser.MinusExpressionContext ctx) { 
        Arithmetic arithmetic = new Arithmetic();
        arithmetic.setOperator(Arithmetic.Operator.MINUS);
    
        for (MiniPythonParser.ExpressionContext expression: ctx.expression()) {
            arithmetic.setOperand((Expression) visit(expression));
        }

        return arithmetic;
    }
	
	@Override 
    public Node visitEqualExpression(MiniPythonParser.EqualExpressionContext ctx) { 
        return visitChildren(ctx); 
    }
	
	@Override 
    public Node visitNotExpression(MiniPythonParser.NotExpressionContext ctx) { 
        return visitChildren(ctx); 
    }
	
	@Override 
    public Node visitMethodExpression(MiniPythonParser.MethodExpressionContext ctx) { 
        return visitChildren(ctx);
    }
	
	@Override 
    public Node visitGreaterThenExpression(MiniPythonParser.GreaterThenExpressionContext ctx) { 
        return visitChildren(ctx); 
    }
	
	@Override 
    public Node visitNotEqualExpression(MiniPythonParser.NotEqualExpressionContext ctx) { 
        return visitChildren(ctx); 
    }
	
	@Override 
    public Node visitLessExpression(MiniPythonParser.LessExpressionContext ctx) { 
        return visitChildren(ctx); 
    }

	@Override 
    public Node visitGreaterExpression(MiniPythonParser.GreaterExpressionContext ctx) { 
        return visitChildren(ctx); 
    }

	@Override 
    public Node visitLessThenExpression(MiniPythonParser.LessThenExpressionContext ctx) { 
        return visitChildren(ctx); 
    }

	@Override 
    public Node visitAssignment(MiniPythonParser.AssignmentContext ctx) { 
        Assignment assignment = new Assignment();
        assignment.setIdentifier((Identifier) visit(ctx.identifier()));
        assignment.setExpression((Expression) visit(ctx.expression()));
        return assignment;
    }
	
	@Override 
    public Node visitWhile(MiniPythonParser.WhileContext ctx) { 
        return visitChildren(ctx); 
    }
	
	@Override 
    public Node visitIf(MiniPythonParser.IfContext ctx) { 
        return visitChildren(ctx); 
    }
	
	@Override 
    public Node visitMethod(MiniPythonParser.MethodContext ctx) { 
        return visitChildren(ctx); 
    }
	
	@Override 
    public Node visitFunction(MiniPythonParser.FunctionContext ctx) { 
        Function function = new Function();
        function.setIdentifier((Identifier) visit(ctx.identifier()));

        for (MiniPythonParser.ExpressionContext expression: ctx.exp_parameter().expression()) {
            function.setParameter((Expression) visit(expression));
        }

        return function; 
    }
	
	@Override 
    public Node visitDef_function(MiniPythonParser.Def_functionContext ctx) { 
        DefFunction function = new DefFunction();
        function.setIdentifier((Identifier) visit(ctx.identifier()));

        for (MiniPythonParser.IdentifierContext identifier: ctx.fun_parameter().identifier()) {
            function.setParameter((Identifier) visit(identifier));
        }

        for (MiniPythonParser.StatementContext statement: ctx.statement()) {
            function.setStatement((Statement) visit(statement));
        }

        return function; 
    }

    @Override 
    public Node visitReturn(MiniPythonParser.ReturnContext ctx) { 
        Return ret = new Return();
        ret.setExpression((Expression) visit(ctx.expression()));
        return ret;
    }
	
	@Override 
    public Node visitDef_method(MiniPythonParser.Def_methodContext ctx) { 
        return visitChildren(ctx); 
    }
	
	@Override 
    public Node visitDef_class(MiniPythonParser.Def_classContext ctx) { 
        return visitChildren(ctx); 
    }

}
