package ast;

import java.util.List;

public abstract class Statement {

    protected String statementsToString(List<Statement> stmts) {
        return String.join("\n", stmts.stream().map(s -> s.toString()).toList());
    }
}
