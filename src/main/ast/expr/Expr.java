package main.ast.expr;

import main.ast.ArgExpr;
import main.ast.Node;

public abstract class Expr extends Node {
    private boolean isFirst = true;
    public void addExpr(Expr expr) {}
    public void setArgExpr(ArgExpr argExpr) {}
    public void notFirst() { isFirst = false; }
    public boolean getFirst() { return isFirst; }
}
