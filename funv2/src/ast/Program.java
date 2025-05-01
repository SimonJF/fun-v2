package ast;

import java.util.List;

public class Program {
    private List<Decl> global;
    private List<Procedure> procedures;
    private List<Function> functions;
    private Procedure main;

    public List<Decl> getGlobal() {
        return global;
    }

    public List<Procedure> getProcedures() {
        return procedures;
    }

    public List<Function> getFunctions() {
        return functions;
    }

    public Procedure getMain() {
        return main;
    }

    public Program(List<Decl> global, List<Procedure> procedures, List<Function> functions, Procedure main) {
        this.global = global;
        this.procedures = procedures;
        this.functions = functions;
        this.main = main;
    }
    

}
