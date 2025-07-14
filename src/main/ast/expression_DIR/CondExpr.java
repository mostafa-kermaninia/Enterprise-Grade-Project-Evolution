package main.ast.expression_DIR;

import main.ast.mainNodes_DIR.Expr;
import main.visitor.IVisitor;

public class CondExpr extends Expr {
    private Expr expr1;
    private Expr expr2;
    private Expr expr3;

    public CondExpr(Expr expr1, Expr expr2, Expr expr3) {
        this.expr1 = expr1;
        this.expr2 = expr2;
        this.expr3 = expr3;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expr getExpr1() {
        return expr1;
    }

    public Expr getExpr2() {
        return expr2;
    }

    public Expr getExpr3() {
        return expr3;
    }
}
