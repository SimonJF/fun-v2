package ast;

import java.util.List;

public class Program {
    private List<Decl> globals;
    private List<Procedure> procedures;
    private List<Function> functions;

    public List<Decl> getGlobals() {
        return globals;
    }

    public List<Procedure> getProcedures() {
        return procedures;
    }

    public List<Function> getFunctions() {
        return functions;
    }

    public Function lookupFunction(String name) {
        for (Function f : functions) {
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
        throw new RuntimeException("Procedure " + name + " not found");

    }

    public Procedure getMain() {
        return lookupProcedure("main");
    }

    public Program(List<Decl> global, List<Procedure> procedures, List<Function> functions) {
        this.globals = global;
        this.procedures = procedures;
        this.functions = functions;
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
