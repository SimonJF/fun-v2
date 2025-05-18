import java.util.LinkedList;
import java.util.List;

import antlr.FunBaseVisitor;
import antlr.FunParser.BoolContext;
import antlr.FunParser.ExprContext;
import antlr.FunParser.FalseContext;
import antlr.FunParser.FunccallContext;
import antlr.FunParser.IdContext;
import antlr.FunParser.IntContext;
import antlr.FunParser.NotContext;
import antlr.FunParser.NumContext;
import antlr.FunParser.ParensContext;
import antlr.FunParser.Sec_exprContext;
import antlr.FunParser.TrueContext;
import antlr.FunParser.VarContext;
import ast.*;

public class FunASTGenerator {

    private class FunExprGenerator extends FunBaseVisitor<Expr> {

        @Override
        public Expr visitFalse(FalseContext ctx) {
            return new EBool(false);
        }

        @Override
        public Expr visitFunccall(FunccallContext ctx) {
            String fnName = ctx.ID().getText();
            List<Expr> args = new LinkedList<>();
            if (ctx.actual_seq() != null) {
                args = ctx.actual_seq().children.stream().map(x -> visit(x)).toList();
            }
            return new ECall(fnName, args);
            
        }

        @Override
        public Expr visitNot(NotContext ctx) {
            Expr e = visit(ctx.prim_expr());
            return new ENot(e);
        }

        @Override
        public Expr visitNum(NumContext ctx) {
            return new EInt(Integer.valueOf(ctx.NUM().getText()));
        }

        @Override
        public Expr visitTrue(TrueContext ctx) {
            return new EBool(true);
        }

        @Override
        public Expr visitId(IdContext ctx) {
            return new EVar(ctx.ID().getText());
        }

        @Override
        public Expr visitParens(ParensContext ctx) {
            return visit(ctx.expr());
        }

        @Override
        public Expr visitExpr(ExprContext ctx) {
            Expr e1 = visit(ctx.e1);
            if (ctx.op == null || ctx.e2 == null) {
                return e1;

            }

            Expr e2 = visit(ctx.e2);
            String opName = ctx.op.getText();
            Op op = switch (opName) {
                case "EQ" -> Op.EQ;
                case "LT" -> Op.LT;
                case "GT" -> Op.GT;
                default -> throw new RuntimeException("Invalid operator " + opName);
            };
            return new EBinOp(e1, op, e2);
        }

        @Override
        public Expr visitSec_expr(Sec_exprContext ctx) {
            Expr e1 = visit(ctx.e1);
            if (ctx.op == null || ctx.e2 == null) {
                return e1;

            }

            Expr e2 = visit(ctx.e2);
            String opName = ctx.op.getText();
            Op op = switch (opName) {
                case "PLUS" -> Op.ADD;
                case "MINUS" -> Op.SUB;
                case "TIMES" -> Op.MUL;
                case "DIV" -> Op.DIV;
                default -> throw new RuntimeException("Invalid operator " + opName);
            };
            return new EBinOp(e1, op, e2);
        }
    }

}
