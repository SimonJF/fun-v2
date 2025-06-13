package util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Map.Entry;

/*
 * An mutable map from strings to another type. Used for mutable
 * variable bindings and global variables in the interpreter.
 */
public class MutableEnvironment<T> {

    // Internal (mutable) map
    private Map<String, T> env;

    public MutableEnvironment() {
        this.env = new LinkedHashMap<>();
    }

    public T lookup(String var) throws NoSuchElementException {
        if (env.containsKey(var)) {
            return env.get(var);
        } else {
            throw new NoSuchElementException("Unbound variable " + var + ".");
        }
    }

    public void set(String var, T t) {
        env.put(var, t);
    }

    public void dump() {
        for (Entry<String, T> e : env.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }

    public boolean contains(String var) {
        return env.containsKey(var);
    }

}
