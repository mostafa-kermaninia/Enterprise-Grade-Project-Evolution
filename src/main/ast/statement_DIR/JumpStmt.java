package main.ast.statement_DIR;

import main.ast.expression_DIR.Expr;
import main.visitor.IVisitor;

public class JumpStmt extends Stmt {
    private Expr returnExpr;

    public JumpStmt() { returnExpr = null; }

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
}
