import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import ast.*;
import antlr.*;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    /* TODO: Update boilerplate
    private static void parseAndRun(String code) {
        CharStream input = CharStreams.fromString(code);
        LRecLexer lexer = new LRecLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LRecParser parser = new LRecParser(tokens);

        ParseTree tree = parser.expr();
        System.out.println(tree.toString());
        Expr ast = new LRecASTGenerator().visit(tree);
        System.out.println(ast);
        Expr noLetFuns = new DesugarFunLets().desugar(ast);
        Expr noLets = new DesugarLets().desugar(noLetFuns);
        System.out.println("Desugared: " + noLets);
        Value result = (new LRecInterp()).interpExpr(noLets);
        System.out.println("Result: " + result);
    }

    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            String inputFile = args[0];
            String contents = Files.readString(Paths.get(inputFile));
            parseAndRun(contents);
        } else {
            Scanner scanner = new Scanner(System.in);
            for (;;) {
                System.out.print("Input expression > ");
                String code = scanner.nextLine();
                if (code.equalsIgnoreCase("quit")) {
                    scanner.close();
                    System.exit(0);
                } else {
                    parseAndRun(code);
                }

            }
        }
    }

    */

    public static void main(String[] args) {
        System.out.println("TODO");
    }

}
