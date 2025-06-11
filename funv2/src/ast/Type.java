package ast;

public enum Type {
    INT, BOOL;

    @Override
    public String toString() {
        return switch(this) {
            case INT -> "int";
            case BOOL -> "bool";
            default -> null;
        };
    }
}
