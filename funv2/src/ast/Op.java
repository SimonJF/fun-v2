package ast;

public enum Op {
    LT, GT, EQ, ADD, SUB, MUL, DIV;

    @Override
    public String toString() {
        return switch (this) {
            case LT -> "<";
            case GT -> ">";
            case EQ -> "==";
            case ADD -> "+";
            case SUB -> "-";
            case MUL -> "*";
            case DIV -> "/";
            default -> null;
        };
    }
}
