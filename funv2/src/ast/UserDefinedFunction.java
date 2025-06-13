package ast;

import java.util.List;

public class UserDefinedFunction extends Function {
    private List<Decl> declarations;
    private List<Statement> statements;
    private Expr returnExpr;

    public UserDefinedFunction(String name, List<AnnotatedParameter> params,
            Type returnType, 
            List<Decl> declarations, List<Statement> statements, Expr returnExpr) {
        super(name, params, returnType);
        this.declarations = declarations;
        this.statements = statements;
        this.returnExpr = returnExpr;
    }

    public List<Decl> getDeclarations() {
        return declarations;
    }

    public List<Statement> getStatements() {
        return statements;
    }
    
    public Expr getReturnExpr() {
        return returnExpr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        // Header
        sb.append("func ");
        sb.append(getReturnType().toString());
        sb.append(" ");
        sb.append(getName());
        sb.append("(");
        // Parameters
        List<String> paramsList = getParameters().stream().map(p -> p.getName() + " " + p.getType()).toList();
        String paramsStr = String.join(", ", paramsList);
        sb.append(paramsStr);
        sb.append("):\n");
        // Declarations
        declarations.stream().forEach(d -> sb.append(d.toString().indent(2)));
        // Statements
        statements.stream().forEach(s -> sb.append(s.toString().indent(2)));
        // Return expression
        sb.append(("return " + returnExpr.toString()).indent(2));
        // End
        sb.append(".");
        return sb.toString();
    }

}
