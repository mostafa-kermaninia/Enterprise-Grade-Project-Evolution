package main.ast.literal_DIR;

import main.ast.baseNodes_DIR.Node;
import main.ast.mainNodes_DIR.Expr;
import main.visitor.IVisitor;

public class Designator extends Node {
    private Expr expr;

    public Designator() {
        expr = null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expr getExpr() {
        return expr;
    }

    public void setExpr(Expr expr) {
        this.expr = expr;
    }
}
