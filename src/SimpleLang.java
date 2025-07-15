import main.ast.baseNodes_DIR.Program;
import main.ast.CPY_DIR.CPYtoC;
import main.grammar.SimpleLangLexer;
import main.grammar.SimpleLangParser;
import main.visitor.TypeChecker;
import main.vulnerability.VulnerabilityReporter;
import main.vulnerability.VulnerabilityDataCollector;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class SimpleLang {
    public static void main(String[] args) throws IOException {
        // --- Stage 0: Pre-processing ---
        // Converts the input .cpy file to a standard C-like format.
        CPYtoC cpyToCConverter = new CPYtoC(args[0]);

        // --- Stage 1: Parsing ---
        // Create a stream of characters from the converted code.
        CharStream reader = CharStreams.fromString(cpyToCConverter.converted);

        // Use ANTLR lexer and parser to build the Abstract Syntax Tree (AST).
        SimpleLangLexer simpleLangLexer = new SimpleLangLexer(reader);
        CommonTokenStream tokens = new CommonTokenStream(simpleLangLexer);
        SimpleLangParser flParser = new SimpleLangParser(tokens);
        Program program = flParser.program().programRet;

        System.out.println(); // Preserved from original code.

        // --- Stage 2: Name Analysis & Vulnerability Data Collection ---
        // First visitor pass: builds the symbol table and collects initial data for analysis.
        VulnerabilityDataCollector dataCollector = new VulnerabilityDataCollector();
        dataCollector.visit(program);

        // --- Stage 3: Vulnerability Reporting ---
        // Second visitor pass: uses the collected data to find and report vulnerabilities.
        VulnerabilityReporter vulnerabilityReporter = new VulnerabilityReporter(dataCollector.symbolTableMain);
        vulnerabilityReporter.visit(program);

        // --- Stage 4: Type Checking ---
        // Third visitor pass: performs type checking on the expressions and statements.
        TypeChecker typeChecker = new TypeChecker(dataCollector.symbolTableMain);
        typeChecker.visit(program);
    }
}