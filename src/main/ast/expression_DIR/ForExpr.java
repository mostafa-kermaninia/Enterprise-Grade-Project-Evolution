package main.ast.expression_DIR;

import main.ast.mainNodes_DIR.Expr;

import main.visitor.IVisitor;

import main.ast.baseNodes_DIR.Node;

import java.util.ArrayList;

public class ForExpr extends Node {
    private ArrayList<Expr> exprs;

    public ForExpr(Expr expr) {
        exprs = new ArrayList<Expr>();
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
}
