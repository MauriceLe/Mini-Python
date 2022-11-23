// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniPythonParser}.
 */
public interface MiniPythonListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(MiniPythonParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(MiniPythonParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PlusExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPlusExpression(MiniPythonParser.PlusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PlusExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPlusExpression(MiniPythonParser.PlusExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIntExpression(MiniPythonParser.IntExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIntExpression(MiniPythonParser.IntExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiplyExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyExpression(MiniPythonParser.MultiplyExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiplyExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyExpression(MiniPythonParser.MultiplyExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqualExpression(MiniPythonParser.EqualExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqualExpression(MiniPythonParser.EqualExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(MiniPythonParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(MiniPythonParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MethodExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMethodExpression(MiniPythonParser.MethodExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MethodExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMethodExpression(MiniPythonParser.MethodExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpression(MiniPythonParser.BoolExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpression(MiniPythonParser.BoolExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GreaterThenExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGreaterThenExpression(MiniPythonParser.GreaterThenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GreaterThenExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGreaterThenExpression(MiniPythonParser.GreaterThenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotEqualExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotEqualExpression(MiniPythonParser.NotEqualExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotEqualExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotEqualExpression(MiniPythonParser.NotEqualExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LessExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLessExpression(MiniPythonParser.LessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLessExpression(MiniPythonParser.LessExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpression(MiniPythonParser.FunctionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpression(MiniPythonParser.FunctionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MinusExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMinusExpression(MiniPythonParser.MinusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MinusExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMinusExpression(MiniPythonParser.MinusExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpression(MiniPythonParser.StringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpression(MiniPythonParser.StringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GreaterExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGreaterExpression(MiniPythonParser.GreaterExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GreaterExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGreaterExpression(MiniPythonParser.GreaterExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdExpression(MiniPythonParser.IdExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdExpression(MiniPythonParser.IdExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DivisionExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDivisionExpression(MiniPythonParser.DivisionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DivisionExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDivisionExpression(MiniPythonParser.DivisionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LessThenExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLessThenExpression(MiniPythonParser.LessThenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessThenExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLessThenExpression(MiniPythonParser.LessThenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MiniPythonParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MiniPythonParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(MiniPythonParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(MiniPythonParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(MiniPythonParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(MiniPythonParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#exp_parameter}.
	 * @param ctx the parse tree
	 */
	void enterExp_parameter(MiniPythonParser.Exp_parameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#exp_parameter}.
	 * @param ctx the parse tree
	 */
	void exitExp_parameter(MiniPythonParser.Exp_parameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#fun_parameter}.
	 * @param ctx the parse tree
	 */
	void enterFun_parameter(MiniPythonParser.Fun_parameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#fun_parameter}.
	 * @param ctx the parse tree
	 */
	void exitFun_parameter(MiniPythonParser.Fun_parameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#return}.
	 * @param ctx the parse tree
	 */
	void enterReturn(MiniPythonParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#return}.
	 * @param ctx the parse tree
	 */
	void exitReturn(MiniPythonParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#while}.
	 * @param ctx the parse tree
	 */
	void enterWhile(MiniPythonParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#while}.
	 * @param ctx the parse tree
	 */
	void exitWhile(MiniPythonParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#if}.
	 * @param ctx the parse tree
	 */
	void enterIf(MiniPythonParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#if}.
	 * @param ctx the parse tree
	 */
	void exitIf(MiniPythonParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(MiniPythonParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(MiniPythonParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(MiniPythonParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(MiniPythonParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#def_function}.
	 * @param ctx the parse tree
	 */
	void enterDef_function(MiniPythonParser.Def_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#def_function}.
	 * @param ctx the parse tree
	 */
	void exitDef_function(MiniPythonParser.Def_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#def_method}.
	 * @param ctx the parse tree
	 */
	void enterDef_method(MiniPythonParser.Def_methodContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#def_method}.
	 * @param ctx the parse tree
	 */
	void exitDef_method(MiniPythonParser.Def_methodContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#def_class}.
	 * @param ctx the parse tree
	 */
	void enterDef_class(MiniPythonParser.Def_classContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#def_class}.
	 * @param ctx the parse tree
	 */
	void exitDef_class(MiniPythonParser.Def_classContext ctx);
}