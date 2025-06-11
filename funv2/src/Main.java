import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import ast.*;
import antlr.*;


import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    private static void parseAndRun(String code) {
        CharStream input = CharStreams.fromString(code);
        FunLexer lexer = new FunLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FunParser parser = new FunParser(tokens);

        ParseTree tree = parser.program();
        System.out.println(tree.toString());
        Program prog = new FunASTGenerator().visitProgram(tree);
        System.out.println(prog);
        /* 
        Expr noLetFuns = new DesugarFunLets().desugar(ast);
        Expr noLets = new DesugarLets().desugar(noLetFuns);
        System.out.println("Desugared: " + noLets);
        Value result = (new FunInterp()).interpExpr(noLets);
        System.out.println("Result: " + result);
        */
    }

    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            String inputFile = args[0];
            String contents = Files.readString(Paths.get(inputFile));
            parseAndRun(contents);
        } else {
            System.out.println("USAGE: ./fun.sh <filename name>");
        }
    }

}
