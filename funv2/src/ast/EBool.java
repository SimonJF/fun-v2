package ast;

public class EBool extends Expr {

    private boolean value;

    public EBool(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }


}
