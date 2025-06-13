package ast;

import java.util.List;

public class BuiltinFunction extends Function {

    protected BuiltinFunction(String name, List<AnnotatedParameter> parameters, Type returnType) {
        super(name, parameters, returnType);
    }

    @Override
    public String toString() {
        List<String> paramsStrs =
            getParameters()
                .stream()
                .map(p -> p.getType().toString() + " " + p.getName())
                .toList();
        return String.format("func %s %s(%s);", getReturnType().toString(),
            getName(), String.join(", ", paramsStrs));
    }

}
