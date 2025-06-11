package ast;

import java.util.List;

public class Function {
    private Type returnType;
    private String name;
    private List<AnnotatedParameter> parameters;
    private List<Decl> declarations;
    private List<Statement> statements;
    private Expr returnExpr;

    public Function(Type returnType, String name, List<AnnotatedParameter> params,
            List<Decl> declarations, List<Statement> statements, Expr returnExpr) {
        this.returnType = returnType;
        this.name = name;
        this.parameters = params;
        this.declarations = declarations;
        this.statements = statements;
        this.returnExpr = returnExpr;
    }

    public Type getReturnType() {
        return returnType;
    }

    public String getName() {
        return name;
    }

    public List<AnnotatedParameter> getParameters() {
        return parameters;
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
        sb.append(returnType.toString());
        sb.append(" ");
        sb.append(name);
        sb.append("(");
        // Parameters
        List<String> paramsList = parameters.stream().map(p -> p.getName() + " " + p.getType()).toList();
        String paramsStr = String.join(", ", paramsList);
        sb.append(paramsStr);
        sb.append("):\n");
        // Declarations
        declarations.stream().forEach(d -> sb.append(d.toString().indent(2)));
        // Statements
        statements.stream().forEach(s -> sb.append(s.toString().indent(2)));
        // Return expression
        sb.append(returnExpr.toString().indent(2));
        // End
        sb.append(".");
        return sb.toString();
    }

}
