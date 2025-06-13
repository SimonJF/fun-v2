package interp;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import ast.*;
import util.*;

public class Interp {

    private Program program;
    private MutableEnvironment<Value> globals = new MutableEnvironment<>();
    private Scanner scanner = new Scanner(System.in);

    public Interp(Program p) {
        this.program = p;
        // Initialise all global variables
        p.getGlobals().stream().forEach(d ->
            globals.set(d.getVar(), interpExpr(d.getBody()))
        );
    }

    public Value interpExpr(Expr e) {
        return interpExpr(new MutableEnvironment<>(), e);
    }

    private int unwrapInt(Value v) {
        if (v instanceof VInt vi) {
            return vi.getValue();
        } else {
            throw new RuntimeException("Tried to unwrap non-integer value " + v + " as an int.");
        }
    }

    private boolean unwrapBoolean(Value v) {
        if (v instanceof VBool vb) {
            return vb.getValue();
        } else {
            throw new RuntimeException("Tried to unwrap non-boolean value " + v + " as a bool.");
        }
    }

    // Returns a new locals environment based on evaluating all function arguments
    // and binding them to parameter names
    public MutableEnvironment<Value> evaluateArguments(MutableEnvironment<Value> locals,
            List<String> params, List<Expr> args) {
        MutableEnvironment<Value> newLocals = new MutableEnvironment<>();
        List<Value> vals = args.stream().map(x -> interpExpr(locals, x)).toList();
        if (params.size() != vals.size()) {
            // Shouldn't happen if type-correct
            throw new RuntimeException("Mismatch between parameters and given arguments");
        }
        for (int i = 0; i < params.size(); i++) {
            newLocals.set(params.get(i), vals.get(i));
        }
        return newLocals;
    }

    public void interpStatement(MutableEnvironment<Value> locals, Statement s) {
        if (s instanceof SAssign sa) {
            String var = sa.getVar();
            Value v = interpExpr(locals, sa.getExpr());
            if (locals.contains(sa.getVar())) {
                locals.set(var, v);
            } else if (globals.contains(var)) {
                globals.set(var, v);
            } else {
                throw new RuntimeException("Trying to assign unknown variable " + var);
            }
        } else if (s instanceof SCall sc) {
            callProcedure(locals, sc.getName(), sc.getArguments());
        } else if (s instanceof SCond scond) {
            Value test = interpExpr(locals, scond.getTest());
            if (unwrapBoolean(test)) {
                interpStatements(locals, scond.getThenBranch());
            } else {
                scond
                    .getElseBranch()
                    .ifPresent(elseBranch -> interpStatements(locals, elseBranch));
            }

        } else if (s instanceof SWhile sw) {
            while (unwrapBoolean(interpExpr(locals, sw.getTest()))) {
                interpStatements(locals, sw.getBody());
            }
        } else {
            throw new RuntimeException("Invalid statement: " + s.toString());
        }
    }

    public void interpStatements(MutableEnvironment<Value> locals, List<Statement> statements) {
        statements.forEach(s -> interpStatement(locals, s));
    }

    private void interpBuiltinProcedure(MutableEnvironment<Value> locals, BuiltinProcedure bip, List<Expr> arguments) {
        // Need to special-case 'write'
        if (bip.getName().equals("write")) {
            System.out.println(unwrapInt(interpExpr(locals, arguments.get(0))));
            return;
        }
        throw new RuntimeException("No implementation for builtin procedure: " + bip.getName());
    }

    private void callProcedure(MutableEnvironment<Value> locals, String name, List<Expr> arguments) {
        Procedure proc = program.lookupProcedure(name);
        if (proc instanceof BuiltinProcedure bip) {
            interpBuiltinProcedure(locals, bip, arguments);
            return;
        }

        UserDefinedProcedure callee = (UserDefinedProcedure) proc;
        List<String> params =
            callee
                .getParameters()
                .stream()
                .map(p -> p.getName())
                .toList();
        MutableEnvironment<Value> newLocals =
            evaluateArguments(locals, params, arguments);
        // Next, populate new environment with declarations.
        // Note that this needs to be in the context of the called function;
        // we want the parameters to be available, and we don't want any variables
        // to leak out of this scope.
        callee
            .getDeclarations()
            .stream()
            .forEach(d -> newLocals.set(d.getVar(), interpExpr(newLocals, d.getBody())));
        // Evaluate statements; environment will be updated mutably
        interpStatements(newLocals, callee.getStatements());
    }

    private Value interpBuiltinFunction(MutableEnvironment<Value> locals,
        BuiltinFunction bif, List<Expr> args) {
        
        if (bif.getName().equals("read")) {
            return new VInt(Integer.parseInt(scanner.nextLine()));
        }

        throw new RuntimeException("No implementation for builtin function " + bif.getName());

    }

    public Value interpExpr(MutableEnvironment<Value> locals, Expr e) {
        if (e instanceof EVar v) {
            // Check locals first
            try {
                return locals.lookup(v.getVar());
            } catch (NoSuchElementException nsee) {
                // Then check globals
                return globals.lookup(v.getVar());
            }
        } else if (e instanceof EBool b) {
            return new VBool(b.getValue());
        } else if (e instanceof EInt i) {
            return new VInt(i.getValue());
        } else if (e instanceof ECall c) {
            Function f = program.lookupFunction(c.getName());
            if (f instanceof BuiltinFunction bif) {
                return interpBuiltinFunction(locals, bif, c.getArguments());
            }

            UserDefinedFunction callee = (UserDefinedFunction) f;
            // Populate new locals environment
            List<String> params =
                callee
                    .getParameters()
                    .stream()
                    .map(p -> p.getName())
                    .toList();
           
            MutableEnvironment<Value> newLocals =
                evaluateArguments(locals, params, c.getArguments());

            // Next, populate new environment with declarations.
            // Note that this needs to be in the context of the called function;
            // we want the parameters to be available, and we don't want any variables
            // to leak out of this scope.
            callee
                .getDeclarations()
                .stream()
                .forEach(d -> newLocals.set(d.getVar(), interpExpr(newLocals, d.getBody())));

            // Evaluate statements; environment will be updated mutably
            interpStatements(newLocals, callee.getStatements());
            // TODO: Might want to have explicit environment-passing to retain
            // close correspondence with the operational semantics.
            return interpExpr(newLocals, callee.getReturnExpr());
        } else if (e instanceof EBinOp ebo) {
            Value v1 = interpExpr(locals, ebo.getLeft());
            Value v2 = interpExpr(locals, ebo.getRight());
            return switch (ebo.getOp()) {
                case ADD -> new VInt(unwrapInt(v1) + unwrapInt(v2));
                case MUL -> new VInt(unwrapInt(v1) * unwrapInt(v2));
                case SUB -> new VInt(unwrapInt(v1) - unwrapInt(v2));
                case DIV -> new VInt(unwrapInt(v1) / unwrapInt(v2));
                case LT -> new VBool(unwrapInt(v1) < unwrapInt(v2));
                case GT -> new VBool(unwrapInt(v1) > unwrapInt(v2));
                case EQ -> new VBool(v1.equals(v2));
            };
        } else if (e instanceof ENot en) {
            boolean vb = unwrapBoolean(interpExpr(locals, en.getExpr()));
            return new VBool(vb);

        } else {
            throw new RuntimeException("Attempting to interpret invalid expression: " + e.toString());
        }
    }

    public void interpProgram() {
        // Run main function
        callProcedure(new MutableEnvironment<>(), "main", new ArrayList<>());
    }

}
