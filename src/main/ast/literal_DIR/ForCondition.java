package main.ast.literal_DIR;

import main.ast.baseNodes_DIR.Node;
import main.ast.declaration_DIR.ForDec;
import main.ast.expression_DIR.ForExpr;
import main.ast.mainNodes_DIR.Expr;
import main.visitor.IVisitor;

public class ForCondition extends Node {
    private Expr expr;
    private ForExpr forExpr1;
    private ForExpr forExpr2;
    private ForDec forDec;

    public ForCondition() {
        expr = null;
        forExpr1 = null;
        forExpr2 = null;
        forDec = null;
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

    public ForExpr getForExpr1() {
        return forExpr1;
    }

    public void setForExpr1(ForExpr forExpr1) {
        this.forExpr1 = forExpr1;
    }

    public ForExpr getForExpr2() {
        return forExpr2;
    }

    public void setForExpr2(ForExpr forExpr2) {
        this.forExpr2 = forExpr2;
    }

    public ForDec getForDec() {
        return forDec;
    }

    public void setForDec(ForDec forDec) {
        this.forDec = forDec;
    }
}
