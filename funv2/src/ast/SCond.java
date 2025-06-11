package ast;

import java.util.List;
import java.util.Optional;

public class SCond extends Statement {

    private Expr test;
    private List<Statement> thenBranch;
    private Optional<List<Statement>> elseBranch;
    public SCond(Expr test, List<Statement> thenBranch, List<Statement> elseBranch) {
        this.test = test;
        this.thenBranch = thenBranch;
        this.elseBranch = Optional.of(elseBranch);
    }

    public SCond(Expr test, List<Statement> thenBranch) {
        this.test = test;
        this.thenBranch = thenBranch;
        this.elseBranch = Optional.empty();
    }

    public Expr getTest() {
        return test;
    }

    public List<Statement> getThenBranch() {
        return thenBranch;
    }

    public Optional<List<Statement>> getElseBranch() {
        return elseBranch;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String thenStr = statementsToString(thenBranch).indent(2);
        sb.append(String.format("if %s:\n%s", test.toString(), thenStr));
        elseBranch.ifPresent(elseBranch -> sb.append(statementsToString(elseBranch).indent(2)));
        return sb.toString();
    }

}
