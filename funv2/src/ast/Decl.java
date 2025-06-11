package ast;

public class Decl {
    private String var;
    private Type type;
    private Expr body;
    public Decl(String var, Type type, Expr body) {
        this.var = var;
        this.type = type;
        this.body = body;
    }
    public String getVar() {
        return var;
    }
    public Type getType() {
        return type;
    }
    public Expr getBody() {
        return body;
    }

    @Override
    public String toString() {
        return String.format("%s %s = %s", type.toString(), var, body.toString());
    }


}
