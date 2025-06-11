package util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Map.Entry;

/*
 * An immutable map from strings to another type. Used in the
 * interpreter and typechecker.
 */
public class ImmutableEnvironment<T> {

    // Internal (mutable) map
    private Map<String, T> env;

    public ImmutableEnvironment() {
        this.env = new LinkedHashMap<>();
    }

    private void setEnv(Map<String, T> env) {
        this.env = env;
    }

    public T lookup(String var) throws NoSuchElementException {
        if (env.containsKey(var)) {
            return env.get(var);
        } else {
            throw new NoSuchElementException("Unbound variable " + var + ".");
        }
    }

    public ImmutableEnvironment<T> extend(String var, T t) {
        Map<String, T> newEnv = new LinkedHashMap<>();
        for (Entry<String, T> entry : env.entrySet()) {
            newEnv.put(entry.getKey(), entry.getValue());
        }
        newEnv.put(var, t);
        ImmutableEnvironment<T> newEnvironment = new ImmutableEnvironment<>();
        newEnvironment.setEnv(newEnv);
        return newEnvironment;
    }

    public void dump() {
        for (Entry<String, T> e : env.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }

}
