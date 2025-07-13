package main.ast.literal_DIR;

import main.ast.baseNodes_DIR.Node;
import main.ast.declaration_DIR.DecList;
import main.ast.declaration_DIR.DeclarationSpecifiers;
import main.ast.declaration_DIR.Declarator;
import main.ast.statement_DIR.CompoundStatement;
import main.symbolTable.SymbolTable;
import main.visitor.IVisitor;

public class FunctionDefinition extends Node {

    private DeclarationSpecifiers declarationSpecifiers;
    private Declarator declarator;
    private DecList decList;
    private CompoundStatement compoundStatement;
    private SymbolTable symbolTable;
    private int numArgs;

    public FunctionDefinition() {
        declarationSpecifiers = null;
        decList = null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public DeclarationSpecifiers getDecSpecifiers() {
        return declarationSpecifiers;
    }

    public void setDecSpecifiers(DeclarationSpecifiers declarationSpecifiers) {
        this.declarationSpecifiers = declarationSpecifiers;
    }

    public Declarator getDeclarator() {
        return declarator;
    }

    public void setDeclarator(Declarator declarator) {
        this.declarator = declarator;
    }

    public DecList getDecList() {
        return decList;
    }

    public void setDecList(DecList decList) {
        this.decList = decList;
    }

    public CompoundStatement getCompoundStatement() {
        return compoundStatement;
    }

    public void setCompoundStatement(CompoundStatement compoundStatement) {
        this.compoundStatement = compoundStatement;
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    public void setSymbolTable(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    public int getNumArgs() {
        return numArgs;
    }

    public void setNumArgs(int numArgs) {
        this.numArgs = numArgs;
    }
}
