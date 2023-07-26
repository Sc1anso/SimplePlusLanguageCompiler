// Generated from SimplePlus.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimplePlusParser}.
 */
public interface SimplePlusListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimplePlusParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SimplePlusParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplePlusParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SimplePlusParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplePlusParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SimplePlusParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplePlusParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SimplePlusParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplePlusParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(SimplePlusParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplePlusParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(SimplePlusParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplePlusParser#decFun}.
	 * @param ctx the parse tree
	 */
	void enterDecFun(SimplePlusParser.DecFunContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplePlusParser#decFun}.
	 * @param ctx the parse tree
	 */
	void exitDecFun(SimplePlusParser.DecFunContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplePlusParser#decVar}.
	 * @param ctx the parse tree
	 */
	void enterDecVar(SimplePlusParser.DecVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplePlusParser#decVar}.
	 * @param ctx the parse tree
	 */
	void exitDecVar(SimplePlusParser.DecVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplePlusParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(SimplePlusParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplePlusParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(SimplePlusParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplePlusParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(SimplePlusParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplePlusParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(SimplePlusParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplePlusParser#ref}.
	 * @param ctx the parse tree
	 */
	void enterRef(SimplePlusParser.RefContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplePlusParser#ref}.
	 * @param ctx the parse tree
	 */
	void exitRef(SimplePlusParser.RefContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplePlusParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(SimplePlusParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplePlusParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(SimplePlusParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplePlusParser#deletion}.
	 * @param ctx the parse tree
	 */
	void enterDeletion(SimplePlusParser.DeletionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplePlusParser#deletion}.
	 * @param ctx the parse tree
	 */
	void exitDeletion(SimplePlusParser.DeletionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplePlusParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(SimplePlusParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplePlusParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(SimplePlusParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplePlusParser#ret}.
	 * @param ctx the parse tree
	 */
	void enterRet(SimplePlusParser.RetContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplePlusParser#ret}.
	 * @param ctx the parse tree
	 */
	void exitRet(SimplePlusParser.RetContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplePlusParser#ite}.
	 * @param ctx the parse tree
	 */
	void enterIte(SimplePlusParser.IteContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplePlusParser#ite}.
	 * @param ctx the parse tree
	 */
	void exitIte(SimplePlusParser.IteContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplePlusParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(SimplePlusParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplePlusParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(SimplePlusParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code baseExp}
	 * labeled alternative in {@link SimplePlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBaseExp(SimplePlusParser.BaseExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code baseExp}
	 * labeled alternative in {@link SimplePlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBaseExp(SimplePlusParser.BaseExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varExp}
	 * labeled alternative in {@link SimplePlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterVarExp(SimplePlusParser.VarExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varExp}
	 * labeled alternative in {@link SimplePlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitVarExp(SimplePlusParser.VarExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binExp}
	 * labeled alternative in {@link SimplePlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBinExp(SimplePlusParser.BinExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binExp}
	 * labeled alternative in {@link SimplePlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBinExp(SimplePlusParser.BinExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valExp}
	 * labeled alternative in {@link SimplePlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterValExp(SimplePlusParser.ValExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valExp}
	 * labeled alternative in {@link SimplePlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitValExp(SimplePlusParser.ValExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negExp}
	 * labeled alternative in {@link SimplePlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterNegExp(SimplePlusParser.NegExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negExp}
	 * labeled alternative in {@link SimplePlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitNegExp(SimplePlusParser.NegExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExp}
	 * labeled alternative in {@link SimplePlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBoolExp(SimplePlusParser.BoolExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExp}
	 * labeled alternative in {@link SimplePlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBoolExp(SimplePlusParser.BoolExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code callExp}
	 * labeled alternative in {@link SimplePlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterCallExp(SimplePlusParser.CallExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code callExp}
	 * labeled alternative in {@link SimplePlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitCallExp(SimplePlusParser.CallExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExp}
	 * labeled alternative in {@link SimplePlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterNotExp(SimplePlusParser.NotExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExp}
	 * labeled alternative in {@link SimplePlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitNotExp(SimplePlusParser.NotExpContext ctx);
}