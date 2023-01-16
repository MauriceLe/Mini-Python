package code.core;
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
	 * Visit a parse tree produced by the {@code CallExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpression(MiniPythonParser.CallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ZeroDivisionError}
	 * labeled alternative in {@link MiniPythonParser#exception}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitZeroDivisionError(MiniPythonParser.ZeroDivisionErrorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueError}
	 * labeled alternative in {@link MiniPythonParser#exception}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueError(MiniPythonParser.ValueErrorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignError}
	 * labeled alternative in {@link MiniPythonParser#exception}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignError(MiniPythonParser.AssignErrorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MiniPythonParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(MiniPythonParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(MiniPythonParser.IdentifierContext ctx);
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
	 * Visit a parse tree produced by {@link MiniPythonParser#return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(MiniPythonParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#import_module}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_module(MiniPythonParser.Import_moduleContext ctx);
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
	 * Visit a parse tree produced by {@link MiniPythonParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(MiniPythonParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#elif_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElif_statement(MiniPythonParser.Elif_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#else_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_statement(MiniPythonParser.Else_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#try}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTry(MiniPythonParser.TryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#try_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTry_statement(MiniPythonParser.Try_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#exc_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExc_statement(MiniPythonParser.Exc_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#fin_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFin_statement(MiniPythonParser.Fin_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#expression_parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_parameter(MiniPythonParser.Expression_parameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#function_parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_parameter(MiniPythonParser.Function_parameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(MiniPythonParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(MiniPythonParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#class}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass(MiniPythonParser.ClassContext ctx);
}