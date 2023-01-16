package code.core;
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
	 * Enter a parse tree produced by the {@code CallExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCallExpression(MiniPythonParser.CallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallExpression}
	 * labeled alternative in {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCallExpression(MiniPythonParser.CallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ZeroDivisionError}
	 * labeled alternative in {@link MiniPythonParser#exception}.
	 * @param ctx the parse tree
	 */
	void enterZeroDivisionError(MiniPythonParser.ZeroDivisionErrorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ZeroDivisionError}
	 * labeled alternative in {@link MiniPythonParser#exception}.
	 * @param ctx the parse tree
	 */
	void exitZeroDivisionError(MiniPythonParser.ZeroDivisionErrorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueError}
	 * labeled alternative in {@link MiniPythonParser#exception}.
	 * @param ctx the parse tree
	 */
	void enterValueError(MiniPythonParser.ValueErrorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueError}
	 * labeled alternative in {@link MiniPythonParser#exception}.
	 * @param ctx the parse tree
	 */
	void exitValueError(MiniPythonParser.ValueErrorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignError}
	 * labeled alternative in {@link MiniPythonParser#exception}.
	 * @param ctx the parse tree
	 */
	void enterAssignError(MiniPythonParser.AssignErrorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignError}
	 * labeled alternative in {@link MiniPythonParser#exception}.
	 * @param ctx the parse tree
	 */
	void exitAssignError(MiniPythonParser.AssignErrorContext ctx);
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
	 * Enter a parse tree produced by {@link MiniPythonParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(MiniPythonParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(MiniPythonParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(MiniPythonParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(MiniPythonParser.IdentifierContext ctx);
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
	 * Enter a parse tree produced by {@link MiniPythonParser#import_module}.
	 * @param ctx the parse tree
	 */
	void enterImport_module(MiniPythonParser.Import_moduleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#import_module}.
	 * @param ctx the parse tree
	 */
	void exitImport_module(MiniPythonParser.Import_moduleContext ctx);
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
	 * Enter a parse tree produced by {@link MiniPythonParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(MiniPythonParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(MiniPythonParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#elif_statement}.
	 * @param ctx the parse tree
	 */
	void enterElif_statement(MiniPythonParser.Elif_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#elif_statement}.
	 * @param ctx the parse tree
	 */
	void exitElif_statement(MiniPythonParser.Elif_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void enterElse_statement(MiniPythonParser.Else_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void exitElse_statement(MiniPythonParser.Else_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#try}.
	 * @param ctx the parse tree
	 */
	void enterTry(MiniPythonParser.TryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#try}.
	 * @param ctx the parse tree
	 */
	void exitTry(MiniPythonParser.TryContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#try_statement}.
	 * @param ctx the parse tree
	 */
	void enterTry_statement(MiniPythonParser.Try_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#try_statement}.
	 * @param ctx the parse tree
	 */
	void exitTry_statement(MiniPythonParser.Try_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#exc_statement}.
	 * @param ctx the parse tree
	 */
	void enterExc_statement(MiniPythonParser.Exc_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#exc_statement}.
	 * @param ctx the parse tree
	 */
	void exitExc_statement(MiniPythonParser.Exc_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#fin_statement}.
	 * @param ctx the parse tree
	 */
	void enterFin_statement(MiniPythonParser.Fin_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#fin_statement}.
	 * @param ctx the parse tree
	 */
	void exitFin_statement(MiniPythonParser.Fin_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#expression_parameter}.
	 * @param ctx the parse tree
	 */
	void enterExpression_parameter(MiniPythonParser.Expression_parameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#expression_parameter}.
	 * @param ctx the parse tree
	 */
	void exitExpression_parameter(MiniPythonParser.Expression_parameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#function_parameter}.
	 * @param ctx the parse tree
	 */
	void enterFunction_parameter(MiniPythonParser.Function_parameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#function_parameter}.
	 * @param ctx the parse tree
	 */
	void exitFunction_parameter(MiniPythonParser.Function_parameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(MiniPythonParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(MiniPythonParser.CallContext ctx);
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
	 * Enter a parse tree produced by {@link MiniPythonParser#class}.
	 * @param ctx the parse tree
	 */
	void enterClass(MiniPythonParser.ClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#class}.
	 * @param ctx the parse tree
	 */
	void exitClass(MiniPythonParser.ClassContext ctx);
}