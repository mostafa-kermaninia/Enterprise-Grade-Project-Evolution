import main.ast.Program;
import main.convertor.Convertor;
import main.grammar.SimpleLangLexer;
import main.grammar.SimpleLangParser;
import main.visitor.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class SimpleLang {
    public static void main(String[] args) throws IOException {
        Convertor convertor = new Convertor(args[0]);

        CharStream reader = CharStreams.fromString(convertor.converted);
        SimpleLangLexer simpleLangLexer = new SimpleLangLexer(reader);
        CommonTokenStream tokens = new CommonTokenStream(simpleLangLexer);
        SimpleLangParser flParser = new SimpleLangParser(tokens);
        Program program = flParser.program().programRet;
        System.out.println();
 

        VulnVisitor my_vulnVisitor = new VulnVisitor();
        my_vulnVisitor.visit(program);

        VulnChecker my_vulnChecker = new VulnChecker(my_vulnVisitor.symbolTableMain);
        my_vulnChecker.visit(program);

        TypeChecker my_typeChecker = new TypeChecker(my_vulnVisitor.symbolTableMain);
        my_typeChecker.visit(program);

    }
}