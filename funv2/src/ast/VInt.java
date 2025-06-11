package ast;

public class VInt extends Value {

    private int value;



    public VInt(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
    

}
