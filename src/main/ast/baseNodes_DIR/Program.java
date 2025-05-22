package main.ast.baseNodes_DIR;

import main.symbolTable.SymbolTable;
import main.visitor.IVisitor;

public class Program extends Node {
    private TranslationUnit translationUnit;
    private SymbolTable symbolTable;

    public Program() {
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public TranslationUnit getTranslationUnit() {
        return translationUnit;
    }

    public void setTranslationUnit(TranslationUnit translationUnit) {
        this.translationUnit = translationUnit;
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    public void setSymbolTable(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }
}
