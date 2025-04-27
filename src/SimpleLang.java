import main.ast.nodes_DIR.Program;
import main.ast.CPY_DIR.CPYtoC;
import main.grammar.SimpleLangLexer;
import main.grammar.SimpleLangParser;
import main.visitor.TestVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class SimpleLang {
    public static void main(String[] args) throws IOException {
//        convert cpy to c
        CPYtoC CPYtoC = new CPYtoC(args[0]);

//        lexer part
        CharStream reader = CharStreams.fromString(CPYtoC.finalC);
//        CharStream reader = CharStreams.fromFileName(args[0]);
        SimpleLangLexer simpleLangLexer = new SimpleLangLexer(reader);
        CommonTokenStream tokens = new CommonTokenStream(simpleLangLexer);

//        parser part
        SimpleLangParser flParser = new SimpleLangParser(tokens);
        Program program = flParser.program().programRet;
//
        System.out.println();

//        visitor part
        TestVisitor my_evaluator = new TestVisitor();

//        evaluation part
        my_evaluator.counter(program);


    }
}