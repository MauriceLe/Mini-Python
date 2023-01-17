package code.visitor;

import code.ast.*;
import code.core.*;
import code.ast.Class;
import code.ast.types.*;
import code.ast.Exception;
import code.ast.exceptions.*;

public class AstTreeVisitor extends MiniPythonBaseVisitor<Node> {

    @Override 
    public Node visitStart(MiniPythonParser.StartContext ctx) { 
        AstTree tree = new AstTree();
        tree.setBlock((Block) visit(ctx.statements()));
        return tree;
    }

    @Override 
    public Node visitStatements(MiniPythonParser.StatementsContext ctx) { 
        Block block = new Block();

        for (MiniPythonParser.StatementContext statement: ctx.statement()) {
            block.setStatement((Statement) visit(statement));
        } 

        return block;
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
        arithmetic.setOperator(Arithmetic.Operator.Multiplication);
        arithmetic.setLeft((Expression) visit(ctx.expression(0)));
        arithmetic.setRight((Expression) visit(ctx.expression(1)));
        return arithmetic;
    }

    @Override 
    public Node visitDivisionExpression(MiniPythonParser.DivisionExpressionContext ctx) { 
        Arithmetic arithmetic = new Arithmetic();
        arithmetic.setOperator(Arithmetic.Operator.Division);
        arithmetic.setLeft((Expression) visit(ctx.expression(0)));
        arithmetic.setRight((Expression) visit(ctx.expression(1)));
        return arithmetic;
    }

    @Override
    public Node visitPlusExpression(MiniPythonParser.PlusExpressionContext ctx) { 
        Arithmetic arithmetic = new Arithmetic();
        arithmetic.setOperator(Arithmetic.Operator.Plus);
        arithmetic.setLeft((Expression) visit(ctx.expression(0)));
        arithmetic.setRight((Expression) visit(ctx.expression(1)));
        return arithmetic;
    }

    @Override 
    public Node visitMinusExpression(MiniPythonParser.MinusExpressionContext ctx) { 
        Arithmetic arithmetic = new Arithmetic();
        arithmetic.setOperator(Arithmetic.Operator.Minus);
        arithmetic.setLeft((Expression) visit(ctx.expression(0)));
        arithmetic.setRight((Expression) visit(ctx.expression(1)));
        return arithmetic;
    }
	
	@Override 
    public Node visitEqualExpression(MiniPythonParser.EqualExpressionContext ctx) { 
        Compare compare = new Compare();
        compare.setOperator(Compare.Operator.Equal);
        compare.setLeft((Expression) visit(ctx.expression(0)));
        compare.setRight((Expression) visit(ctx.expression(1)));
        return compare;
    }
	
	@Override 
    public Node visitGreaterThenExpression(MiniPythonParser.GreaterThenExpressionContext ctx) { 
        Compare compare = new Compare();
        compare.setOperator(Compare.Operator.Greater_Then);
        compare.setLeft((Expression) visit(ctx.expression(0)));
        compare.setRight((Expression) visit(ctx.expression(1)));
        return compare;
    }
	
	@Override 
    public Node visitNotEqualExpression(MiniPythonParser.NotEqualExpressionContext ctx) { 
        Compare compare = new Compare();
        compare.setOperator(Compare.Operator.NotEqual);
        compare.setLeft((Expression) visit(ctx.expression(0)));
        compare.setRight((Expression) visit(ctx.expression(1)));
        return compare;
    }
	
	@Override 
    public Node visitLessExpression(MiniPythonParser.LessExpressionContext ctx) { 
        Compare compare = new Compare();
        compare.setOperator(Compare.Operator.Less);
        compare.setLeft((Expression) visit(ctx.expression(0)));
        compare.setRight((Expression) visit(ctx.expression(1)));
        return compare;
    }

	@Override 
    public Node visitGreaterExpression(MiniPythonParser.GreaterExpressionContext ctx) { 
        Compare compare = new Compare();
        compare.setOperator(Compare.Operator.Greater);
        compare.setLeft((Expression) visit(ctx.expression(0)));
        compare.setRight((Expression) visit(ctx.expression(1)));
        return compare;
    }

	@Override 
    public Node visitLessThenExpression(MiniPythonParser.LessThenExpressionContext ctx) { 
        Compare compare = new Compare();
        compare.setOperator(Compare.Operator.Less_Then);
        compare.setLeft((Expression) visit(ctx.expression(0)));
        compare.setRight((Expression) visit(ctx.expression(1)));
        return compare;
    }

    @Override 
    public Node visitNotExpression(MiniPythonParser.NotExpressionContext ctx) { 
        Negation not = new Negation();
        not.setExpression((Expression) visit(ctx.expression()));
        return not;
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
        While _while = new While();
        _while.setCondition((Expression) visit(ctx.condition().expression()));
        _while.setBody((Block) visit(ctx.statements()));
        return _while; 
    }
	
	@Override 
    public Node visitIf(MiniPythonParser.IfContext ctx) { 
        If _if = new If();

        _if.setCondition((Expression) visit(ctx.if_statement().condition().expression()));
        _if.setIfBlock((Block) visit(ctx.if_statement().statements()));

        for (MiniPythonParser.Elif_statementContext _else: ctx.elif_statement()) {
            Expression condition = (Expression) visit(_else.condition().expression());
            Block block = (Block) visit(_else.statements());
            _if.setElifBlock(condition, block);
        }

        if (ctx.else_statement() != null) {
            _if.setElseBlock((Block) visit(ctx.else_statement().statements()));
        }

        return _if;
    }

    @Override 
    public Node visitZeroDivisionError(MiniPythonParser.ZeroDivisionErrorContext ctx) { 
        return new ZeroDivisionError(); 
    }

    @Override 
    public Node visitNameError(MiniPythonParser.NameErrorContext ctx) { 
        return new NameError();
    }

    @Override 
    public Node visitImportError(MiniPythonParser.ImportErrorContext ctx) { 
        return new ImportError(); 
    }

    @Override 
    public Node visitTry(MiniPythonParser.TryContext ctx) { 
        Try _try = new Try();

        if (ctx.exc_statement().exception() != null) {
            _try.setException((Exception) visit(ctx.exc_statement().exception()));
        }

        _try.setTryBlock((Block) visit(ctx.try_statement().statements()));
        _try.setExceptBlock((Block) visit(ctx.exc_statement().statements()));

        if (ctx.fin_statement() != null) {
            _try.setFinallyBlock((Block) visit(ctx.fin_statement().statements()));
        }

        return _try; 
    }
	
    @Override public Node visitCallExpression(MiniPythonParser.CallExpressionContext ctx) { 
        Callable callable = new Callable();

        if (ctx.call().identifier().size() == 1) {
            callable.setIdentifier((Identifier) visit(ctx.call().identifier(0)));
        } else {
            callable.setClassIdentifier((Identifier) visit(ctx.call().identifier(0)));
            callable.setIdentifier((Identifier) visit(ctx.call().identifier(1)));
        }

        for (MiniPythonParser.ExpressionContext expression: ctx.call().expression_parameter().expression()) {
            callable.setParameter((Expression) visit(expression));
        }

        return callable; 
    }

	@Override public Node visitCall(MiniPythonParser.CallContext ctx) { 
        Callable callable = new Callable();

        if (ctx.identifier().size() == 1) {
            callable.setIdentifier((Identifier) visit(ctx.identifier(0)));
        } else {
            callable.setClassIdentifier((Identifier) visit(ctx.identifier(0)));
            callable.setIdentifier((Identifier) visit(ctx.identifier(1)));
        }

        for (MiniPythonParser.ExpressionContext expression: ctx.expression_parameter().expression()) {
            callable.setParameter((Expression) visit(expression));
        }

        return callable; 
    }
	
	@Override 
    public Node visitFunction(MiniPythonParser.FunctionContext ctx) { 
        Function function = new Function();

        function.setIdentifier((Identifier) visit(ctx.identifier()));
        
        for (MiniPythonParser.IdentifierContext identifier: ctx.function_parameter().identifier()) {
            function.setParameter((Identifier) visit(identifier));
        }

        function.setBody((Block) visit(ctx.statements()));

        return function; 
    }
	
    @Override public Node visitClass(MiniPythonParser.ClassContext ctx) { 
        Class _class = new Class();

        _class.setIdentifier((Identifier) visit(ctx.identifier(0)));
        
        if (ctx.identifier(1) != null) {
            _class.setSuperclass((Identifier) visit(ctx.identifier(1)));
        }

        for (MiniPythonParser.FunctionContext method: ctx.function()) {
            _class.setMethod((Function) visit(method));
        }

        return _class; 
    }
	
    @Override 
    public Node visitReturn(MiniPythonParser.ReturnContext ctx) { 
        Return _return = new Return();
        _return.setExpression((Expression) visit(ctx.expression()));
        return _return;
    }
	
    @Override 
    public Node visitImport_module(MiniPythonParser.Import_moduleContext ctx) { 
        if(ctx.identifier().size() == 1){
            return new ImportModule((Identifier) visit(ctx.identifier().get(0)));
        }
        return new ImportModule((Identifier) visit(ctx.identifier(0)), (Identifier) visit(ctx.identifier(1)));
    }

}
