package ast;

import java.util.List;

public class ECall extends Expr {
    private String name;
    private List<Expr> arguments;

    public ECall(String name, List<Expr> arguments) {
        this.name = name;
        this.arguments = arguments;
    }

    public String getName() {
        return name;
    }
    public List<Expr> getArguments() {
        return arguments;
    }

}
