package code.visitor;

import code.ast.*;
import code.ast.types.*;
import code.core.MiniPythonBaseVisitor;
import code.core.MiniPythonParser;

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
        If if_statement = new If();

        if_statement.setCondition((Expression) visit(ctx.if_statement().condition().expression()));
        if_statement.setIfBlock((Block) visit(ctx.if_statement().statements()));

        for (MiniPythonParser.Elif_statementContext elseIF: ctx.elif_statement()) {
            Expression condition = (Expression) visit(elseIF.condition().expression());
            Block block = (Block) visit(elseIF.statements());
            if_statement.setElifBlock(condition, block);
        }

        if (ctx.else_statement() != null) {
            if_statement.setElseBlock((Block) visit(ctx.else_statement().statements()));
        }

        return if_statement;
    }
	
    @Override 
    public Node visitMethodExpression(MiniPythonParser.MethodExpressionContext ctx) { 
        return visit(ctx.method());
    }

	@Override 
    public Node visitMethod(MiniPythonParser.MethodContext ctx) { 
        Method method = new Method();

        method.setInstance((Identifier) visit(ctx.identifier().get(0)));
        method.setIdentifier((Identifier) visit(ctx.identifier().get(1)));

        for (MiniPythonParser.ExpressionContext parameter: ctx.exp_parameter().expression()) {
            method.setParameter((Expression) visit(parameter));
        }

        return method;
    }

    @Override 
    public Node visitFunctionExpression(MiniPythonParser.FunctionExpressionContext ctx) { 
        Function function = new Function();
        function.setIdentifier((Identifier) visit(ctx.function().identifier()));

        for (MiniPythonParser.ExpressionContext expression: ctx.function().exp_parameter().expression()) {
            function.setParameter((Expression) visit(expression));
        }

        return function; 
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

        function.setBody((Block) visit(ctx.statements()));

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
        DefMethod method = new DefMethod();
        method.setIdentifier((Identifier) visit(ctx.identifier()));

        if(ctx.fun_parameter() != null){
            for (MiniPythonParser.IdentifierContext identifier: ctx.fun_parameter().identifier()) {
                method.setParameter((Identifier) visit(identifier));
            }
        }

        method.setBody((Block) visit(ctx.statements()));

        return method;
    }
	
	@Override 
    public Node visitDef_class(MiniPythonParser.Def_classContext ctx) { 
        DefClass new_class = new DefClass();
        new_class.setIdentifier((Identifier) visit(ctx.identifier(0)));

        if (ctx.identifier(1) != null) {
            new_class.setSuperclass((Identifier) visit(ctx.identifier(1)));
        }
        
        for (MiniPythonParser.Def_methodContext method: ctx.def_method()) {
            new_class.setMethod((DefMethod) visit(method));
        }

        return new_class;
    }

    @Override 
    public Node visitImport_module(MiniPythonParser.Import_moduleContext ctx) { 
        return new ImportModule((Identifier) visit(ctx.identifier()));
    }

}
