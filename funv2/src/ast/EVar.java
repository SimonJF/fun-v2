package ast;

public class EVar extends Expr {

    private final String var;

    public EVar(String var) {
        this.var = var;
    }

    public String getVar() {
        return var;
    }

}
