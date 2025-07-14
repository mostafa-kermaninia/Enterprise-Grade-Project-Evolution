package main.ast.expression_DIR;

import main.ast.baseNodes_DIR.Node;
import main.ast.mainNodes_DIR.Expr;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class ArgExpr extends Node {
    private ArrayList<Expr> exprs;

    public ArgExpr(Expr expr) {
        exprs = new ArrayList<Expr>();
        exprs.add(expr);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<Expr> getExprs() {
        return exprs;
    }

    public void addExpr(Expr expr) {
        this.exprs.add(expr);
    }

    public void notFirstExpr() {
        for (Expr expr : exprs) {
            expr.notFirst();
        }
    }

    public void removeLastExpr() {
        exprs.remove(exprs.size() - 1);
    }
}
