package typecheck;
import java.util.List;

import ast.*;
import util.*;

public class Typecheck {
    Program program;
    ImmutableEnvironment<Type> globals = new ImmutableEnvironment<>();

    public Typecheck(Program p) {
        this.program = p;
        // Populate list of globals.
        // Why is the interface for 'reduce' so weird?
        for (Decl d : p.getGlobals()) {
            checkType(d.getType(), typecheckExpr(globals, d.getBody()));
            globals = globals.extend(d.getVar(), d.getType());
        }
    }

    public void typecheckProcedure(UserDefinedProcedure p) {
        // Extend globals with parameters of procedure to start
        ImmutableEnvironment<Type> tyEnv = globals;
        for (AnnotatedParameter param : p.getParameters()) {
            tyEnv = tyEnv.extend(param.getName(), param.getType());
        }
        // Next, typecheck all procedure declarations and extend environment.
        for (Decl d : p.getDeclarations()) {
            checkType(d.getType(), typecheckExpr(tyEnv, d.getBody()));
            tyEnv = tyEnv.extend(d.getVar(), d.getType());
        }
        // Finally, typecheck all statements in body
        typecheckStatements(tyEnv, p.getStatements());
    }

    public void typecheckFunction(UserDefinedFunction f) {
        // As above, but also check that final expression matches given type
        ImmutableEnvironment<Type> tyEnv = globals;
        for (AnnotatedParameter param : f.getParameters()) {
            tyEnv = tyEnv.extend(param.getName(), param.getType());
        }
        // Next, typecheck all procedure declarations and extend environment.
        for (Decl d : f.getDeclarations()) {
            checkType(d.getType(), typecheckExpr(tyEnv, d.getBody()));
            tyEnv = tyEnv.extend(d.getVar(), d.getType());
        }
        // Typecheck all statements in body
        typecheckStatements(tyEnv, f.getStatements());
        checkType(f.getReturnType(), typecheckExpr(tyEnv, f.getReturnExpr()));
    }

    public void checkType(Type expected, Type actual) {
        if (expected != actual) {
            throw new TypeErrorException(String.format("Type mismatch. Expected %s but got %s",
                expected.toString(), actual.toString()));
        }
    }

    public void typecheckStatements(ImmutableEnvironment<Type> tyEnv, List<Statement> statements) {
        statements.stream().forEach(s -> typecheckStatement(tyEnv, s));
    }

    private void checkArguments(ImmutableEnvironment<Type> tyEnv,
            String name,
            List<AnnotatedParameter> params, List<Expr> args) {
        int paramCount = params.size();
        int argCount = args.size();
        if (argCount != paramCount) {
            throw new TypeErrorException(
                String.format("Arity mismatch in call to %s. Expected %d arguments but got %d",
                    name, paramCount, argCount));
        }

        for (int i = 0; i < paramCount; i++) {
            checkType(params.get(i).getType(), typecheckExpr(tyEnv, args.get(i)));
        }
    }

    public void typecheckStatement(ImmutableEnvironment<Type> tyEnv, Statement s) {
        // Fun's design ensures that assigned variables are always in the environment
        // already.
        if (s instanceof SAssign sa) {
            checkType(tyEnv.lookup(sa.getVar()), typecheckExpr(tyEnv, sa.getExpr()));
        } else if (s instanceof SCall sc) {
            Procedure p = program.lookupProcedure(sc.getName());
            checkArguments(tyEnv, p.getName(), p.getParameters(), sc.getArguments());
        } else if (s instanceof SCond sif) {
            checkType(typecheckExpr(tyEnv, sif.getTest()), Type.BOOL);
            typecheckStatements(tyEnv, sif.getThenBranch());
            sif.getElseBranch().ifPresent(elseBranch -> typecheckStatements(tyEnv, elseBranch));
        } else if (s instanceof SWhile sw) {
            checkType(typecheckExpr(tyEnv, sw.getTest()), Type.BOOL);
            typecheckStatements(tyEnv, sw.getBody());
        } else {
            throw new RuntimeException("Typechecking invalid statement " + s);
        }

    }


    public Type typecheckExpr(ImmutableEnvironment<Type> tyEnv, Expr e) {
        if (e instanceof EVar ev) {
            return tyEnv.lookup(ev.getVar());
        } else if (e instanceof EInt) {
            return Type.INT;
        } else if (e instanceof EBool) {
            return Type.BOOL;
        } else if (e instanceof ENot en) {
            checkType(typecheckExpr(tyEnv, en.getExpr()), Type.BOOL);
            return Type.BOOL;
        } else if (e instanceof EBinOp ebo) {
            Type t1 = typecheckExpr(tyEnv, ebo.getLeft());
            Type t2 = typecheckExpr(tyEnv, ebo.getRight());

            switch (ebo.getOp()) {
                case Op.EQ:
                    checkType(t1, t2);
                    return Type.BOOL;
                case Op.LT:
                case Op.GT:
                    checkType(t1, Type.INT);
                    checkType(t2, Type.INT);
                    return Type.BOOL;
                case ADD:
                case MUL:
                case SUB:
                case DIV:
                    checkType(t1, Type.INT);
                    checkType(t1, Type.INT);
                    return Type.INT;
                default:
                    throw new RuntimeException("Invalid operator: " + ebo.getOp().toString());
            }
        } else if (e instanceof ECall ec) {
            Function f = program.lookupFunction(ec.getName());
            checkArguments(tyEnv, ec.getName(), f.getParameters(), ec.getArguments());
            return f.getReturnType();
        } else {
            throw new RuntimeException("Typechecking invalid expression: " + e);
        }
    }

    public void typecheckProgram() {
        // Globals already checked by the constructor.
        // Check procedures and functions.
        program.getProcedures().forEach(p -> typecheckProcedure(p));
        program.getFunctions().forEach(p -> typecheckFunction(p));
    }

}
