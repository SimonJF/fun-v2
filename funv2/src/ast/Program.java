package ast;

import java.util.ArrayList;
import java.util.List;

public class Program {
    private List<Decl> globals;
    private List<UserDefinedProcedure> procedures;
    private List<UserDefinedFunction> functions;
    private List<BuiltinFunction> builtinFunctions = new ArrayList<>();
    private List<BuiltinProcedure> builtinProcedures = new ArrayList<>();


    public Program(List<Decl> global, List<UserDefinedProcedure> procedures, List<UserDefinedFunction> functions) {
        this.globals = global;
        this.procedures = procedures;
        this.functions = functions;

        // Add builtins
        builtinFunctions.add(new BuiltinFunction("read", List.of(), Type.INT));
        builtinProcedures.add(new BuiltinProcedure("write", List.of(new AnnotatedParameter("x", Type.INT))));
    }


    public List<Decl> getGlobals() {
        return globals;
    }

    public List<UserDefinedProcedure> getProcedures() {
        return procedures;
    }

    public List<UserDefinedFunction> getFunctions() {
        return functions;
    }

    public Function lookupFunction(String name) {
        // First check user-defined functions
        for (Function f : functions) {
            if (f.getName().equalsIgnoreCase(name)) {
                return f;
            }
        }
        // Then check builtins
        for (Function f : builtinFunctions) {
            if (f.getName().equalsIgnoreCase(name)) {
                return f;
            }
        }
        throw new RuntimeException("Function " + name + " not found");
    }

    public Procedure lookupProcedure(String name) {
        for (Procedure p : procedures) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        for (Procedure p : builtinProcedures) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        throw new RuntimeException("Procedure " + name + " not found");

    }

    public UserDefinedProcedure getMain() {
        return (UserDefinedProcedure) lookupProcedure("main");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        globals.stream().forEach(g -> sb.append(g.toString() + "\n"));
        sb.append("\n");
        procedures.stream().forEach(p -> sb.append(p.toString() + "\n"));
        sb.append("\n");
        functions.stream().forEach(f -> sb.append(f.toString() + "\n"));
        return sb.toString();
    }
    

}
