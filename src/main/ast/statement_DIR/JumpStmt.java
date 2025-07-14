package main.ast.statement_DIR;

import main.ast.mainNodes_DIR.Expr;
import main.ast.mainNodes_DIR.Stmt;
import main.visitor.IVisitor;

public class JumpStmt extends Stmt {
    private Expr returnExpr;
    private boolean isReturn = false;

    public JumpStmt() {
        returnExpr = null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expr getCondition() {
        return returnExpr;
    }

    public void setReturnExpr(Expr returnExpr) {
        this.returnExpr = returnExpr;
    }

    public boolean isReturn() {
        return isReturn;
    }

    public void setReturn() {
        this.isReturn = true;
    }
}
