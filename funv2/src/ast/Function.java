package ast;

import java.util.List;

public abstract class Function {
    private String name;
    private List<AnnotatedParameter> parameters;
    private Type returnType;

    protected Function(String name, List<AnnotatedParameter> parameters, Type returnType) {
        this.name = name;
        this.parameters = parameters;
        this.returnType = returnType;
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
}
