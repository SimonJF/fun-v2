package ast;

import java.util.List;

public class Function {
    private Type returnType;
    private String name;
    private List<AnnotatedParameter> params;
    private List<Decl> declarations;
    private List<Statement> statements;

    public Function(Type returnType, String name, List<AnnotatedParameter> params,
            List<Decl> declarations, List<Statement> statements) {
        this.returnType = returnType;
        this.name = name;
        this.params = params;
        this.declarations = declarations;
        this.statements = statements;
    }

    public Type getReturnType() {
        return returnType;
    }

    public String getName() {
        return name;
    }

    public List<AnnotatedParameter> getParams() {
        return params;
    }

    public List<Decl> getDeclarations() {
        return declarations;
    }

    public List<Statement> getStatements() {
        return statements;
    }

}
