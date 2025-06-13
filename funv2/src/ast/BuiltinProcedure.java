package ast;

import java.util.List;

public class BuiltinProcedure extends Procedure {

    protected BuiltinProcedure(String name, List<AnnotatedParameter> parameters) {
        super(name, parameters);
    }

    @Override
    public String toString() {
        List<String> paramsStrs =
            getParameters()
                .stream()
                .map(p -> p.getType().toString() + " " + p.getName())
                .toList();
        return String.format("proc %s(%s);", 
            getName(), String.join(", ", paramsStrs));
    }

}
