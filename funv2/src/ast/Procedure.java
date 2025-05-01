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



}
