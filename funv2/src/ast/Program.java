package ast;

import java.util.List;

public class Program {
    private List<Decl> global;
    private List<Procedure> procedures;
    private List<Function> functions;

    public List<Decl> getGlobal() {
        return global;
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
        this.global = global;
        this.procedures = procedures;
        this.functions = functions;
    }
    

}
