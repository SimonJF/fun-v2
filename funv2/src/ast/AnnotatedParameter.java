package ast;

public class AnnotatedParameter {
    private final String name;
    private final Type type;
    public AnnotatedParameter(String name, Type type) {
        this.name = name;
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", name, type.toString());
    }
}
