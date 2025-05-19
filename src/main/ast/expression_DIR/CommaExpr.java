package main.ast.expression_DIR;

import main.visitor.IVisitor;

import java.util.ArrayList;

public class CommaExpr extends Expr{
    private ArrayList<Expr> exprs;

    public CommaExpr(Expr expr){
        exprs = new ArrayList<>();
        exprs.add(expr);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }


    public ArrayList<Expr> getExprs(){ return exprs; }
    @Override
    public void addExpr(Expr expr){ exprs.add(expr); }
}
