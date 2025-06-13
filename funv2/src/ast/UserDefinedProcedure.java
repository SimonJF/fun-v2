package ast;

import java.util.List;

public class UserDefinedProcedure extends Procedure {
    private List<Decl> declarations;
    private List<Statement> statements;
    
    public UserDefinedProcedure(String name, List<AnnotatedParameter> parameters, List<Decl> declarations,
            List<Statement> statements) {
        super(name, parameters);
        this.declarations = declarations;
        this.statements = statements;
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
        // End
        sb.append(".");
        return sb.toString();
    }

}
