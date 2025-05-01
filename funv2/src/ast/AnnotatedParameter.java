package ast;

public class AnnotatedParameter {
    private final int name;
    private final Type type;
    public AnnotatedParameter(int name, Type type) {
        this.name = name;
        this.type = type;
    }
    public int getName() {
        return name;
    }
    public Type getType() {
        return type;
    }
}
