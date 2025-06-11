package ast;

import java.util.List;

public class Procedure {
    private String name;
    private List<AnnotatedParameter> parameters;
    private List<Decl> declarations;
    private List<Statement> statements;
    
    public Procedure(String name, List<AnnotatedParameter> parameters, List<Decl> declarations,
            List<Statement> statements) {
        this.name = name;
        this.parameters = parameters;
        this.declarations = declarations;
        this.statements = statements;
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        // Header
        sb.append("proc ");
        sb.append(" ");
        sb.append(name);
        sb.append("(");
        // Parameters
        List<String> paramsList = parameters.stream().map(p -> p.getName() + " " + p.getType()).toList();
        String paramsStr = String.join(", ", paramsList);
        sb.append(paramsStr);
        sb.append("):\n");
        // Declarations
        declarations.stream().forEach(d -> sb.append(d.toString().indent(2) + "\n"));
        // Statements
        statements.stream().forEach(s -> sb.append(s.toString().indent(2) + "\n"));
        // End
        sb.append(".");
        return sb.toString();
    }

}
