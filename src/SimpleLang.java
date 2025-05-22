import main.ast.baseNodes_DIR.Program;
import main.ast.CPY_DIR.CPYtoC;
import main.grammar.SimpleLangLexer;
import main.grammar.SimpleLangParser;
import main.visitor.NameAnalyzer;
import main.optimization.Optimizer;
import main.visitor.TestVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class SimpleLang {
    public static void main(String[] args) throws IOException {
        CPYtoC finalCode = new CPYtoC(args[0]);
//        CPYtoC finalCode = new CPYtoC("C:\\Users\\mosta\\github-classroom\\PLC-UT\\phase-2-ce-mostafa-kermaninia\\tests\\Optimization\\1-Unused Variables and Function Parameters.cpy");

        CharStream reader = CharStreams.fromString(finalCode.finalCcode);
        SimpleLangLexer simpleLangLexer = new SimpleLangLexer(reader);
        CommonTokenStream tokens = new CommonTokenStream(simpleLangLexer);
        SimpleLangParser flParser = new SimpleLangParser(tokens);
        Program program = flParser.program().programRet;
        System.out.println();

        NameAnalyzer nameAnalyzer = new NameAnalyzer();
        nameAnalyzer.visit(program);

        if (nameAnalyzer.isSuccessfulDone()) {
            while (true) {
                Optimizer finalOptimizedCode = new Optimizer(nameAnalyzer.getRootST());
                finalOptimizedCode.visit(program);
                nameAnalyzer.visit(program);
                if (!finalOptimizedCode.changed) {
                    break;
                }
            }
            TestVisitor my_visitor = new TestVisitor();
            my_visitor.visit(program);
        }
    }
}