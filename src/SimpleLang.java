import main.ast.baseNodes_DIR.Program;
import main.ast.CPY_DIR.CPYtoC;
import main.optimization.*;
import main.grammar.SimpleLangLexer;
import main.grammar.SimpleLangParser;
import main.visitor.NameAnalyzer;
import main.visitor.TestVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class SimpleLang {
    public static void main(String[] args) throws IOException {

//        PART 1 : convert to C
        CPYtoC CPYtoC = new CPYtoC(args[0]);
//        CPYtoC CPYtoC = new CPYtoC("C:\\Users\\mosta\\github-classroom\\PLC-UT\\phase-2-ce-mostafa-kermaninia\\tests\\NameAnalysis\\2-FunctionUndefined.cpy");

//        System.out.print(CPYtoC.finalC);

//        PART 2 : Lexical analysis
        CharStream reader = CharStreams.fromString(CPYtoC.finalC);
        SimpleLangLexer simpleLangLexer = new SimpleLangLexer(reader);
        CommonTokenStream tokens = new CommonTokenStream(simpleLangLexer);

//        PART 3 : parser
        SimpleLangParser flParser = new SimpleLangParser(tokens);
        Program program = flParser.program().programRet;

//        PART 4 : Phase 1 output
        System.out.println();

//        PART 5 : Name analysis and with visitors
        NameAnalyzer nameAnalyzer = new NameAnalyzer();
        nameAnalyzer.visit(program);

        boolean needChange = true;
        if (nameAnalyzer.SuccessfullyDone()) {
            while(needChange) {
                Optimizer OptimizedCode = new Optimizer(nameAnalyzer.getRootTable());
                OptimizedCode.visit(program);
                nameAnalyzer.visit(program);
                needChange = OptimizedCode.changed;
            }
            TestVisitor visitor = new TestVisitor();
            visitor.visit(program);
        }
    }
}