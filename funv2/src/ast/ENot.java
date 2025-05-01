package ast;

public class ENot extends Expr {
    private final Expr expr;

    public ENot(Expr expr) {
        this.expr = expr;
    }

    public Expr getExpr() {
        return expr;
    }




}
