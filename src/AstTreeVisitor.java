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
    public Node visitMultiplyExpression(MiniPythonParser.MultiplyExpressionContext ctx) {
        Arithmetic arithmetic = new Arithmetic();
        arithmetic.setOperator(Arithmetic.Operator.MULTI);
        arithmetic.setLeft((Expression) visit(ctx.expression(0)));
        arithmetic.setRight((Expression) visit(ctx.expression(1)));
        return arithmetic;
    }

    @Override 
    public Node visitDivisionExpression(MiniPythonParser.DivisionExpressionContext ctx) { 
        Arithmetic arithmetic = new Arithmetic();
        arithmetic.setOperator(Arithmetic.Operator.DIVIS);
        arithmetic.setLeft((Expression) visit(ctx.expression(0)));
        arithmetic.setRight((Expression) visit(ctx.expression(1)));
        return arithmetic;
    }

    @Override
    public Node visitPlusExpression(MiniPythonParser.PlusExpressionContext ctx) { 
        Arithmetic arithmetic = new Arithmetic();
        arithmetic.setOperator(Arithmetic.Operator.PLUS);
        arithmetic.setLeft((Expression) visit(ctx.expression(0)));
        arithmetic.setRight((Expression) visit(ctx.expression(1)));
        return arithmetic;
    }

    @Override 
    public Node visitMinusExpression(MiniPythonParser.MinusExpressionContext ctx) { 
        Arithmetic arithmetic = new Arithmetic();
        arithmetic.setOperator(Arithmetic.Operator.MINUS);
        arithmetic.setLeft((Expression) visit(ctx.expression(0)));
        arithmetic.setRight((Expression) visit(ctx.expression(1)));
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
    public Node visitFunctionExpression(MiniPythonParser.FunctionExpressionContext ctx) { 
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
        return visitChildren(ctx); 
    }

	@Override 
    public Node visitCondition(MiniPythonParser.ConditionContext ctx) { 
        return visitChildren(ctx); 
    }
	
	@Override 
    public Node visitReturn(MiniPythonParser.ReturnContext ctx) { 
        return visitChildren(ctx); 
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
        return visitChildren(ctx); 
    }
	
	@Override 
    public Node visitDef_function(MiniPythonParser.Def_functionContext ctx) { 
        return visitChildren(ctx); 
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
