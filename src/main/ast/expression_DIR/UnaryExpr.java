package main.ast.expression_DIR;

import main.ast.mainNodes_DIR.Expr;
import main.visitor.IVisitor;

public class UnaryExpr extends Expr {
    private Expr expr;
    private String Op;

    public UnaryExpr(Expr expr, String Op) {
        this.expr = expr;
        this.Op = Op;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expr getExpr() {
        return expr;
    }

    public String getOp() {
        return Op;
    }

}
