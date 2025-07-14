package main.ast.statement_DIR;

import main.ast.mainNodes_DIR.Expr;
import main.ast.mainNodes_DIR.Stmt;
import main.symbolTable.SymbolTable;
import main.visitor.IVisitor;

public class SelectionStmt extends Stmt {
    private final Stmt mainStmt;
    private Stmt elseStmt;
    private final Expr expr;
    private int elseLine;
    private SymbolTable symbolTable;

    public SelectionStmt(Expr expr, Stmt mainStmt) {
        this.expr = expr;
        this.mainStmt = mainStmt;
        this.elseStmt = null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expr getExpr() {
        return expr;
    }

    public Stmt getMainStmt() {
        return mainStmt;
    }

    public Stmt getElseStmt() {
        return elseStmt;
    }

    public void setElseStmt(Stmt stmt) {
        this.elseStmt = stmt;
    }

    public int getElseLine() {
        return elseLine;
    }

    public void setElseLine(int line) {
        this.elseLine = line;
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    public void setSymbolTable(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    public boolean allReturn() {
        boolean ans = true;
        if (elseStmt == null) {
            return false;
        } else if (elseStmt instanceof SelectionStmt) {
            SelectionStmt selStmt = (SelectionStmt) elseStmt;
            ans = ans && selStmt.allReturn();
        } else if (elseStmt instanceof CompoundStmt) {
            CompoundStmt compStmt = (CompoundStmt) elseStmt;
            ans = ans && compStmt.hasJumpStmt();
        }
        if (mainStmt instanceof CompoundStmt)
            ans = ans & ((CompoundStmt) mainStmt).hasJumpStmt();
        else if (mainStmt instanceof SelectionStmt)
            ans = ans && ((SelectionStmt) mainStmt).allReturn();

        return ans;
    }
}
