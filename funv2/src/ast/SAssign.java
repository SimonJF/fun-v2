package ast;

public class SAssign extends Statement {
    private final String var;
    private final Expr expr;

    public SAssign(String var, Expr expr) {
        this.var = var;
        this.expr = expr;
    }

    public String getVar() {
        return var;
    }

    public Expr getExpr() {
        return expr;
    }

}
