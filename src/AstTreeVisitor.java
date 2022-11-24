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
        Compare compare = new Compare();
        compare.setOperator(Compare.Operator.Equal);

        for (MiniPythonParser.ExpressionContext expression: ctx.expression()) {
            compare.setOperand((Expression) visit(expression));
        }

        return compare;
    }
	
	@Override 
    public Node visitNotExpression(MiniPythonParser.NotExpressionContext ctx) { 
        Negation not = new Negation();
        not.setExpression((Expression) visit(ctx.expression()));
        return not;
    }
	
	@Override 
    public Node visitGreaterThenExpression(MiniPythonParser.GreaterThenExpressionContext ctx) { 
        Compare compare = new Compare();
        compare.setOperator(Compare.Operator.Greater_Then);

        for (MiniPythonParser.ExpressionContext expression: ctx.expression()) {
            compare.setOperand((Expression) visit(expression));
        }

        return compare;
    }
	
	@Override 
    public Node visitNotEqualExpression(MiniPythonParser.NotEqualExpressionContext ctx) { 
        Compare compare = new Compare();
        compare.setOperator(Compare.Operator.NotEqual);

        for (MiniPythonParser.ExpressionContext expression: ctx.expression()) {
            compare.setOperand((Expression) visit(expression));
        }

        return compare;
    }
	
	@Override 
    public Node visitLessExpression(MiniPythonParser.LessExpressionContext ctx) { 
        Compare compare = new Compare();
        compare.setOperator(Compare.Operator.Less);

        for (MiniPythonParser.ExpressionContext expression: ctx.expression()) {
            compare.setOperand((Expression) visit(expression));
        }

        return compare;
    }

	@Override 
    public Node visitGreaterExpression(MiniPythonParser.GreaterExpressionContext ctx) { 
        Compare compare = new Compare();
        compare.setOperator(Compare.Operator.Greater);

        for (MiniPythonParser.ExpressionContext expression: ctx.expression()) {
            compare.setOperand((Expression) visit(expression));
        }

        return compare;
    }

	@Override 
    public Node visitLessThenExpression(MiniPythonParser.LessThenExpressionContext ctx) { 
        Compare compare = new Compare();
        compare.setOperator(Compare.Operator.Less_Then);

        for (MiniPythonParser.ExpressionContext expression: ctx.expression()) {
            compare.setOperand((Expression) visit(expression));
        }

        return compare;
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
        If if_statement = new If();
        if_statement.setIfCondition((Expression) visit(ctx.if_statement().condition().expression()));

        for (MiniPythonParser.StatementContext statement: ctx.if_statement().statement()) {
            if_statement.setIfStatement((Statement) visit(statement));
        }

        for (MiniPythonParser.StatementContext statement: ctx.if_statement().statement()) {
            if_statement.setIfStatement((Statement) visit(statement));
        }

        if(ctx.elif_statement() != null){
            for (MiniPythonParser.Elif_statementContext elif: ctx.elif_statement()) {
                for (MiniPythonParser.StatementContext statement: elif.statement()) {
                    if_statement.setElifCondition((Expression) visit(elif.condition().expression()));
                    if_statement.setElifStatement((Expression) visit(elif.condition().expression()), 
                    (Statement) visit(statement));
                }
        }
        }

        if(ctx.else_statement() != null){
            for (MiniPythonParser.StatementContext statement: ctx.else_statement().statement()) {
                if_statement.setElseStatement((Expression) visit(statement));
            }
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
        method.setIdentifier((Identifier) visit(ctx.identifier(0)));

        for (MiniPythonParser.IdentifierContext parameter: ctx.identifier()) {
            method.setParameter((Identifier) visit(parameter));
        }

        return method;
    }

    @Override 
    public Node visitFunctionExpression(MiniPythonParser.FunctionExpressionContext ctx) { 
        return visit(ctx.function()); 
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
        DefMethod method = new DefMethod();
        method.setIdentifier((Identifier) visit(ctx.identifier()));

        for (MiniPythonParser.IdentifierContext identifier: ctx.fun_parameter().identifier()) {
            method.setParameter((Identifier) visit(identifier));
        }

        for (MiniPythonParser.StatementContext statement: ctx.statement()) {
            method.setStatement((Statement) visit(statement));
        }

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
            new_class.setMethod((Method) visit(method));
        }

        return new_class;
    }

}
