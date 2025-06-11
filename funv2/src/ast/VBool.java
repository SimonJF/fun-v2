package ast;

public class VBool extends Value {

    private boolean value;



    public VBool(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
    

}
