import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;

import antlr.FunBaseVisitor;
import antlr.FunParser.AssnContext;
import antlr.FunParser.ExprContext;
import antlr.FunParser.FalseContext;
import antlr.FunParser.FormalContext;
import antlr.FunParser.FuncContext;
import antlr.FunParser.FunccallContext;
import antlr.FunParser.IdContext;
import antlr.FunParser.IfContext;
import antlr.FunParser.NotContext;
import antlr.FunParser.NumContext;
import antlr.FunParser.ParensContext;
import antlr.FunParser.ProcContext;
import antlr.FunParser.ProccallContext;
import antlr.FunParser.ProgContext;
import antlr.FunParser.Sec_exprContext;
import antlr.FunParser.TrueContext;
import antlr.FunParser.VarContext;
import antlr.FunParser.WhileContext;
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
            if (ctx.actual_seq() != null && ctx.actual_seq().children != null) {
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
                case "==" -> Op.EQ;
                case "<" -> Op.LT;
                case ">" -> Op.GT;
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
                case "+" -> Op.ADD;
                case "-" -> Op.SUB;
                case "*" -> Op.MUL;
                case "/" -> Op.DIV;
                default -> throw new RuntimeException("Invalid operator " + opName);
            };
            return new EBinOp(e1, op, e2);
        }
    }

    public class FunStatementGenerator extends FunBaseVisitor<Statement> {
        FunExprGenerator exprGen = new FunExprGenerator();

        @Override
        public Statement visitAssn(AssnContext ctx) {
            String id = ctx.ID().getText();
            Expr e = exprGen.visit(ctx.expr());
            return new SAssign(id, e);
        }

        @Override
        public Statement visitIf(IfContext ctx) {
            Expr test = exprGen.visit(ctx.expr());
            List<Statement> thenBranch =
                ctx.c1.children.stream().map(s -> visit(s)).toList();
            if (ctx.c2 == null) {
                return new SCond(test, thenBranch);
            }
            List<Statement> elseBranch =
                ctx.c2.children.stream().map(s -> visit(s)).toList();
            return new SCond(test, thenBranch, elseBranch);
        }

        @Override
        public Statement visitProccall(ProccallContext ctx) {
            String name = ctx.ID().getText();
            List<Expr> args = List.of();
            if (ctx.actual_seq() != null && ctx.actual_seq().children != null) {
                args = ctx.actual_seq()
                            .children
                            .stream()
                            .map(e -> exprGen.visit(e))
                            .toList();
            }
            return new SCall(name, args);
        }

        @Override
        public Statement visitWhile(WhileContext ctx) {
            Expr test = exprGen.visit(ctx.expr());
            List<Statement> body = ctx.seq_com().children.stream().map(s -> visit(s)).toList();
            return new SWhile(test, body);
        }
    }

    public class FunProgramGenerator extends FunBaseVisitor<Program> {

        private Type parseType(String tyStr) {
            if (tyStr.equals("int")) {
                return Type.INT;
            } else if (tyStr.equals("bool")) {
                return Type.BOOL;
            } else {
                throw new RuntimeException("Invalid type: " + tyStr);
            }
        } 


        private class FunDeclGenerator extends FunBaseVisitor<Decl> {
            @Override
            public Decl visitVar(VarContext ctx) {
                String id = ctx.ID().getText();
                Type ty = parseType(ctx.type().getText());
                Expr e = exprGen.visit(ctx.expr());
                return new Decl(id, ty, e);
            }
        }

        private class FunParamGenerator extends FunBaseVisitor<AnnotatedParameter> {

            @Override
            public AnnotatedParameter visitFormal(FormalContext ctx) {
                String id = ctx.ID().getText();
                Type ty = parseType(ctx.type().getText());
                return new AnnotatedParameter(id, ty);
            }

        }

        private FunExprGenerator exprGen = new FunExprGenerator();
        private FunStatementGenerator stmtGen = new FunStatementGenerator();
        private FunDeclGenerator declGen = new FunDeclGenerator();
        private FunParamGenerator paramGen = new FunParamGenerator();

        private class FunFunctionGenerator extends FunBaseVisitor<Function> {

            @Override
            public Function visitFunc(FuncContext ctx) {
                Type t = parseType(ctx.type().getText());
                String name = ctx.ID().getText();
                List<AnnotatedParameter> params = List.of();
                if (ctx.formal_decl_seq() != null) {
                    ctx.formal_decl_seq().children.stream().map(d -> paramGen.visit(d)).toList();
                }

                List<Decl> decls = List.of();
                if (ctx.var_decl() != null) {
                    ctx.var_decl().stream().map(d -> declGen.visit(d)).toList();
                }
                List<Statement> body = List.of();
                if (ctx.seq_com() != null && ctx.seq_com().children != null) {
                    ctx.seq_com().children.stream().map(d -> stmtGen.visit(d)).toList();
                }
                Expr returnExpr = exprGen.visit(ctx.expr());
                return new Function(t, name, params, decls, body, returnExpr);
            }

        }

        private class FunProcedureGenerator extends FunBaseVisitor<Procedure> {

            @Override
            public Procedure visitProc(ProcContext ctx) {
                String id = ctx.ID().getText();
                List<AnnotatedParameter> params = List.of();
                if (ctx.formal_decl_seq() != null && ctx.formal_decl_seq().children != null) {
                    params = ctx.formal_decl_seq().children.stream().map(d -> paramGen.visit(d)).toList();
                }
                List<Decl> decls = List.of();
                if (ctx.var_decl() != null) {
                    ctx.var_decl().stream().map(d -> declGen.visit(d)).toList();
                }
                List<Statement> body = List.of();
                if (ctx.seq_com() != null) {
                    ctx.seq_com().children.stream().map(d -> stmtGen.visit(d)).toList();
                }
                return new Procedure(id, params, decls, body);
            }
        }

        /*
         * proc_decl
	:	PROC ID
		  LPAR formal_decl_seq? RPAR COLON
		  var_decl* seq_com DOT   # proc

	|	FUNC type ID
		  LPAR formal_decl_seq? RPAR COLON
		  var_decl* seq_com
		  RETURN expr DOT         # func
	;

formal_decl_seq
	:	formal_decl (COMMA formal_decl)* # formalseq
	;

formal_decl
	:	type ID                # formal
	;

var_decl
	:	type ID ASSN expr         # var
	;

type
	:	BOOL                      # bool
	|	INT                       # int
	;
         */
        
        @Override
        public Program visitProg(ProgContext ctx) {
            // 	:	var_decl* proc_decl+ EOF  # prog
            FunFunctionGenerator funcGen = new FunFunctionGenerator();
            FunProcedureGenerator procGen = new FunProcedureGenerator();
            FunDeclGenerator declGen = new FunDeclGenerator();
            /* */
            List<Decl> globals = ctx.var_decl().stream().map(d -> declGen.visit(d)).toList();

            List<Function> functions = ctx.proc_decl().stream()
                                                .map(d -> funcGen.visit(d))
                                                .filter(x -> x != null)
                                                .toList();
            List<Procedure> procedures = ctx.proc_decl().stream()
                                                .map(d -> procGen.visit(d))
                                                .filter(x -> x != null)
                                                .toList();
            return new Program(globals, procedures, functions);
        }
    }

    public Program visitProgram(ParseTree tree) {
        return new FunProgramGenerator().visit(tree);
    }
}
