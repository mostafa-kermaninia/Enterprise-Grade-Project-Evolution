import main.ast.baseNodes_DIR.Program;
import main.ast.CPY_DIR.CPYtoC;
import main.grammar.SimpleLangLexer;
import main.grammar.SimpleLangParser;
import main.visitor.NameAnalyzer;
import main.optimization.OptMain;
import main.visitor.TestVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class SimpleLang {
    public static void main(String[] args) throws IOException {
        CPYtoC finalCode = new CPYtoC(args[0]);
//        System.out.print(convertor.converted);
        CharStream reader = CharStreams.fromString(finalCode.finalCcode);
        SimpleLangLexer simpleLangLexer = new SimpleLangLexer(reader);
        CommonTokenStream tokens = new CommonTokenStream(simpleLangLexer);
        SimpleLangParser flParser = new SimpleLangParser(tokens);
        Program program = flParser.program().programRet;
        System.out.println();


        NameAnalyzer my_name_analyzer = new NameAnalyzer();
        my_name_analyzer.visit(program);

        boolean needChange = true;
        if (my_name_analyzer.noError) {
            while(needChange) {
                OptMain my_opt_main = new OptMain(my_name_analyzer.symbolTableMain);
                my_opt_main.visit(program);
                my_name_analyzer.visit(program);
                needChange = my_opt_main.changed;
            }
            TestVisitor my_visitor = new TestVisitor();
            my_visitor.visit(program);
        }
    }
}