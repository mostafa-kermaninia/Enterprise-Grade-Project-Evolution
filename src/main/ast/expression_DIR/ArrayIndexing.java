package main.ast.expression_DIR;

import main.ast.mainNodes_DIR.Expr;
import main.visitor.IVisitor;

public class ArrayIndexing extends Expr {
    private Expr expr1;
    private Expr expr2;

    public ArrayIndexing(Expr expr1, Expr expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
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
}
