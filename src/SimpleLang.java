import main.ast.nodes.Program;
import main.convertor.Convertor;
import main.grammar.SimpleLangLexer;
import main.grammar.SimpleLangParser;
import main.visitor.NameAnalyzer;
import main.visitor.TestVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import main.visitor.Visitor;
import java.io.IOException;

public class SimpleLang {
    public static void main(String[] args) throws IOException {
//        Convertor convertor = new Convertor(args[0]);
        Convertor convertor = new Convertor("E:\\university\\term 6\\Compiler\\Project phase 2\\phase-2-ce-AmirNaddaf2004\\samples\\sample1.sl");
//        System.out.print(convertor.converted);
        CharStream reader = CharStreams.fromString(convertor.converted);
        SimpleLangLexer simpleLangLexer = new SimpleLangLexer(reader);
        CommonTokenStream tokens = new CommonTokenStream(simpleLangLexer);
        SimpleLangParser flParser = new SimpleLangParser(tokens);
        Program program = flParser.program().programRet;
        System.out.println();

        
        NameAnalyzer my_name_analyzer = new NameAnalyzer();
        my_name_analyzer.visit(program);

        if (my_name_analyzer.noError) {
            TestVisitor my_visitor = new TestVisitor();
            my_visitor.visit(program);
        }
    }
}