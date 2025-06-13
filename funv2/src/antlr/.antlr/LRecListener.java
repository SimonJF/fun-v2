// Generated from /Users/simon.fowler/git-repos/fun-v2/funv2/src/antlr/LRec.g4 by ANTLR 4.13.1

package antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LRecParser}.
 */
public interface LRecListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Let}
	 * labeled alternative in {@link LRecParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLet(LRecParser.LetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Let}
	 * labeled alternative in {@link LRecParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLet(LRecParser.LetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LetFun}
	 * labeled alternative in {@link LRecParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLetFun(LRecParser.LetFunContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LetFun}
	 * labeled alternative in {@link LRecParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLetFun(LRecParser.LetFunContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LetRec}
	 * labeled alternative in {@link LRecParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLetRec(LRecParser.LetRecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LetRec}
	 * labeled alternative in {@link LRecParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLetRec(LRecParser.LetRecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BaseExpr}
	 * labeled alternative in {@link LRecParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBaseExpr(LRecParser.BaseExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BaseExpr}
	 * labeled alternative in {@link LRecParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBaseExpr(LRecParser.BaseExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code App}
	 * labeled alternative in {@link LRecParser#base_expr}.
	 * @param ctx the parse tree
	 */
	void enterApp(LRecParser.AppContext ctx);
	/**
	 * Exit a parse tree produced by the {@code App}
	 * labeled alternative in {@link LRecParser#base_expr}.
	 * @param ctx the parse tree
	 */
	void exitApp(LRecParser.AppContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Div}
	 * labeled alternative in {@link LRecParser#base_expr}.
	 * @param ctx the parse tree
	 */
	void enterDiv(LRecParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link LRecParser#base_expr}.
	 * @param ctx the parse tree
	 */
	void exitDiv(LRecParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Add}
	 * labeled alternative in {@link LRecParser#base_expr}.
	 * @param ctx the parse tree
	 */
	void enterAdd(LRecParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link LRecParser#base_expr}.
	 * @param ctx the parse tree
	 */
	void exitAdd(LRecParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Sub}
	 * labeled alternative in {@link LRecParser#base_expr}.
	 * @param ctx the parse tree
	 */
	void enterSub(LRecParser.SubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Sub}
	 * labeled alternative in {@link LRecParser#base_expr}.
	 * @param ctx the parse tree
	 */
	void exitSub(LRecParser.SubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Cond}
	 * labeled alternative in {@link LRecParser#base_expr}.
	 * @param ctx the parse tree
	 */
	void enterCond(LRecParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Cond}
	 * labeled alternative in {@link LRecParser#base_expr}.
	 * @param ctx the parse tree
	 */
	void exitCond(LRecParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Or}
	 * labeled alternative in {@link LRecParser#base_expr}.
	 * @param ctx the parse tree
	 */
	void enterOr(LRecParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link LRecParser#base_expr}.
	 * @param ctx the parse tree
	 */
	void exitOr(LRecParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Mul}
	 * labeled alternative in {@link LRecParser#base_expr}.
	 * @param ctx the parse tree
	 */
	void enterMul(LRecParser.MulContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mul}
	 * labeled alternative in {@link LRecParser#base_expr}.
	 * @param ctx the parse tree
	 */
	void exitMul(LRecParser.MulContext ctx);
	/**
	 * Enter a parse tree produced by the {@code And}
	 * labeled alternative in {@link LRecParser#base_expr}.
	 * @param ctx the parse tree
	 */
	void enterAnd(LRecParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code And}
	 * labeled alternative in {@link LRecParser#base_expr}.
	 * @param ctx the parse tree
	 */
	void exitAnd(LRecParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Lt}
	 * labeled alternative in {@link LRecParser#base_expr}.
	 * @param ctx the parse tree
	 */
	void enterLt(LRecParser.LtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Lt}
	 * labeled alternative in {@link LRecParser#base_expr}.
	 * @param ctx the parse tree
	 */
	void exitLt(LRecParser.LtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Eq}
	 * labeled alternative in {@link LRecParser#base_expr}.
	 * @param ctx the parse tree
	 */
	void enterEq(LRecParser.EqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Eq}
	 * labeled alternative in {@link LRecParser#base_expr}.
	 * @param ctx the parse tree
	 */
	void exitEq(LRecParser.EqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Fact}
	 * labeled alternative in {@link LRecParser#base_expr}.
	 * @param ctx the parse tree
	 */
	void enterFact(LRecParser.FactContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Fact}
	 * labeled alternative in {@link LRecParser#base_expr}.
	 * @param ctx the parse tree
	 */
	void exitFact(LRecParser.FactContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Gt}
	 * labeled alternative in {@link LRecParser#base_expr}.
	 * @param ctx the parse tree
	 */
	void enterGt(LRecParser.GtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Gt}
	 * labeled alternative in {@link LRecParser#base_expr}.
	 * @param ctx the parse tree
	 */
	void exitGt(LRecParser.GtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Lambda}
	 * labeled alternative in {@link LRecParser#prim}.
	 * @param ctx the parse tree
	 */
	void enterLambda(LRecParser.LambdaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Lambda}
	 * labeled alternative in {@link LRecParser#prim}.
	 * @param ctx the parse tree
	 */
	void exitLambda(LRecParser.LambdaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Rec}
	 * labeled alternative in {@link LRecParser#prim}.
	 * @param ctx the parse tree
	 */
	void enterRec(LRecParser.RecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Rec}
	 * labeled alternative in {@link LRecParser#prim}.
	 * @param ctx the parse tree
	 */
	void exitRec(LRecParser.RecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Var}
	 * labeled alternative in {@link LRecParser#prim}.
	 * @param ctx the parse tree
	 */
	void enterVar(LRecParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link LRecParser#prim}.
	 * @param ctx the parse tree
	 */
	void exitVar(LRecParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Int}
	 * labeled alternative in {@link LRecParser#prim}.
	 * @param ctx the parse tree
	 */
	void enterInt(LRecParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link LRecParser#prim}.
	 * @param ctx the parse tree
	 */
	void exitInt(LRecParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code True}
	 * labeled alternative in {@link LRecParser#prim}.
	 * @param ctx the parse tree
	 */
	void enterTrue(LRecParser.TrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code True}
	 * labeled alternative in {@link LRecParser#prim}.
	 * @param ctx the parse tree
	 */
	void exitTrue(LRecParser.TrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code False}
	 * labeled alternative in {@link LRecParser#prim}.
	 * @param ctx the parse tree
	 */
	void enterFalse(LRecParser.FalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code False}
	 * labeled alternative in {@link LRecParser#prim}.
	 * @param ctx the parse tree
	 */
	void exitFalse(LRecParser.FalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link LRecParser#prim}.
	 * @param ctx the parse tree
	 */
	void enterParens(LRecParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link LRecParser#prim}.
	 * @param ctx the parse tree
	 */
	void exitParens(LRecParser.ParensContext ctx);
}