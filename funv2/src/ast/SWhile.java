package ast;

import java.util.List;

public class SWhile extends Statement {

    private Expr test;
    private List<Statement> body;

    public SWhile(Expr test, List<Statement> body) {
        this.test = test;
        this.body = body;
    }

    public Expr getTest() {
        return test;
    }

    public List<Statement> getBody() {
        return body;
    }

    @Override
    public String toString() {
        String bodyStr = statementsToString(body).indent(2);
        return String.format("while %s:\n%s.", test.toString(), bodyStr);
    }
}
