package ast;

import java.util.List;

public abstract class Procedure {
    private String name;
    private List<AnnotatedParameter> parameters;

    protected Procedure(String name, List<AnnotatedParameter> parameters) {
        this.name = name;
        this.parameters = parameters;
    }

    public String getName() {
        return name;
    }

    public List<AnnotatedParameter> getParameters() {
        return parameters;
    }
}
