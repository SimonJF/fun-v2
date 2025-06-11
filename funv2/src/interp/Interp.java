package interp;
import java.util.NoSuchElementException;

import ast.*;
import util.*;

public class Interp {

    private Program program;
    private MutableEnvironment<Value> globals;

    public Interp(Program p) {
        this.program = p;
        // Initialise all global variables
        p.getGlobals().stream().forEach(d ->
            globals.set(d.getVar(), interpExpr(d.getBody()))
        );
    }

    public Value interpExpr(Expr e) {
        interpExpr(new MutableEnvironment<>(), e);
    }

    private int unwrapInt(Value v) {
        if (v instanceof VInt vi) {
            return vi.getValue();
        } else {
            throw new RuntimeException("Tried to unwrap non-integer value " + v + " as an int.")
        }
    }

    private boolean unwrapBoolean(Value v) {
        if (v instanceof VBool vb) {
            return vb.getValue();
        } else {
            throw new RuntimeException("Tried to unwrap non-boolean value " + v + " as a bool.")
        }
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
            throw new RuntimeException("TODO");
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
            boolean vb = unwrapBoolean(interpExpr(en.getExpr()));
            return new VBool(vb);

        } else {
            throw new RuntimeException("Attempting to interpret invalid expression: " + e.toString());
        }
    }

}
