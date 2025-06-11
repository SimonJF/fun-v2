package ast;

public class EBinOp extends Expr {

    private Expr left;
    private Op op;
    private Expr right;

    public EBinOp(Expr left, Op op, Expr right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }

    public Expr getLeft() {
        return left;
    }

    public Op getOp() {
        return op;
    }

    public Expr getRight() {
        return right;
    }

    public String toString() {
        return String.format("%s %s %s", left.toString(), op.toString(), right.toString());
    }

}
