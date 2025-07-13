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
        // Translate CPY file to C code
        CPYtoC cpyTranslator = new CPYtoC(args[0]);

        // Load translated C code into a CharStream
        CharStream charStream = CharStreams.fromString(cpyTranslator.finalCcode);

        // Create lexer with the translated code
        SimpleLangLexer lexer = new SimpleLangLexer(charStream);

        // Tokenize the input for the parser
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Parse tokens to build the AST
        SimpleLangParser parser = new SimpleLangParser(tokens);
        Program program = parser.program().programRet;
        System.out.println();

        // Create a NameAnalyzer to perform name analysis
        NameAnalyzer analyzer = new NameAnalyzer();
        analyzer.visit(program);

        // Proceed if no parsing errors
        if (analyzer.isSuccessfulDone()) {
            // Optimization loop until no changes remain
            while (true) {
                Optimizer optimizer = new Optimizer(analyzer.getRootST());
                optimizer.visit(program);

                // Re-check name analysis after optimization
                analyzer.visit(program);

                // Stop if no further optimization changes occur
                if (!optimizer.changed) {
                    break;
                }
            }

            // Final test visiting/printing of the resulting AST
            TestVisitor testVisitor = new TestVisitor();
            testVisitor.visit(program);
        }
    }
}