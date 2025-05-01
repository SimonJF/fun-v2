package ast;

public class EInt extends Expr {
    private final int value;

    public EInt(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    

}
