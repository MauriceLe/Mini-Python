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
	 * Enter a parse tree produced by {@link MiniPythonParser#negation}.
	 * @param ctx the parse tree
	 */
	void enterNegation(MiniPythonParser.NegationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#negation}.
	 * @param ctx the parse tree
	 */
	void exitNegation(MiniPythonParser.NegationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#logic}.
	 * @param ctx the parse tree
	 */
	void enterLogic(MiniPythonParser.LogicContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#logic}.
	 * @param ctx the parse tree
	 */
	void exitLogic(MiniPythonParser.LogicContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#compare}.
	 * @param ctx the parse tree
	 */
	void enterCompare(MiniPythonParser.CompareContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#compare}.
	 * @param ctx the parse tree
	 */
	void exitCompare(MiniPythonParser.CompareContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#arithmetic}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic(MiniPythonParser.ArithmeticContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#arithmetic}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic(MiniPythonParser.ArithmeticContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MiniPythonParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MiniPythonParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MiniPythonParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MiniPythonParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(MiniPythonParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(MiniPythonParser.ParamContext ctx);
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
	 * Enter a parse tree produced by {@link MiniPythonParser#object}.
	 * @param ctx the parse tree
	 */
	void enterObject(MiniPythonParser.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#object}.
	 * @param ctx the parse tree
	 */
	void exitObject(MiniPythonParser.ObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(MiniPythonParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(MiniPythonParser.AssignContext ctx);
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