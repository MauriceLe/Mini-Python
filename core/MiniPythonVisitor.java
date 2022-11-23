// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniPythonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiniPythonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(MiniPythonParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PlusExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusExpression(MiniPythonParser.PlusExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExpression(MiniPythonParser.IntExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultiplyExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplyExpression(MiniPythonParser.MultiplyExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualExpression(MiniPythonParser.EqualExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(MiniPythonParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MethodExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodExpression(MiniPythonParser.MethodExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpression(MiniPythonParser.BoolExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GreaterThenExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThenExpression(MiniPythonParser.GreaterThenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotEqualExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotEqualExpression(MiniPythonParser.NotEqualExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessExpression(MiniPythonParser.LessExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpression(MiniPythonParser.FunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MinusExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusExpression(MiniPythonParser.MinusExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpression(MiniPythonParser.StringExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GreaterExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterExpression(MiniPythonParser.GreaterExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpression(MiniPythonParser.IdExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DivisionExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivisionExpression(MiniPythonParser.DivisionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessThenExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThenExpression(MiniPythonParser.LessThenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MiniPythonParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(MiniPythonParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(MiniPythonParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#exp_parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_parameter(MiniPythonParser.Exp_parameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#fun_parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFun_parameter(MiniPythonParser.Fun_parameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(MiniPythonParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(MiniPythonParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(MiniPythonParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(MiniPythonParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(MiniPythonParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#def_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef_function(MiniPythonParser.Def_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#def_method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef_method(MiniPythonParser.Def_methodContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#def_class}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef_class(MiniPythonParser.Def_classContext ctx);
}