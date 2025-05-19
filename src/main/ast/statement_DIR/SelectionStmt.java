package main.ast.statement_DIR;

import main.ast.expression_DIR.Expr;
import main.visitor.IVisitor;
import main.symbolTable.SymbolTable;

public class SelectionStmt  extends Stmt {
    private final Stmt mainStmt;
    private Stmt elseStmt;
    private final Expr expr;
    private int elseLine;
    private SymbolTable symbolTable;

    public SelectionStmt(Expr expr, Stmt mainStmt) {
        this.expr = expr;
        this.mainStmt = mainStmt;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }


    public Expr getExpr() {
        return expr;
    }

    public Stmt getMainStmt() { return mainStmt; }

    public Stmt getElseStmt() { return elseStmt; }
    public void setElseStmt(Stmt stmt) { this.elseStmt = stmt; }

    public int getElseLine() { return elseLine; }
    public void setElseLine(int line) { this.elseLine = line; }

    public SymbolTable getSymbolTable() { return symbolTable; }
    public void setSymbolTable(SymbolTable symbolTable) { this.symbolTable = symbolTable; }
}
