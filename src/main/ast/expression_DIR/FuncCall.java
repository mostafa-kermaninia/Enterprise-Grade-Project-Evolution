package main.ast.expression_DIR;

import main.ast.mainNodes_DIR.Expr;
import main.visitor.IVisitor;

public class FuncCall extends Expr {
    private Expr expr;
    private ArgExpr argExpr;

    public FuncCall(Expr expr) {
        this.expr = expr;
        argExpr = null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expr getExpr() {
        return expr;
    }

    public ArgExpr getArgExpr() {
        return argExpr;
    }

    @Override
    public void setArgExpr(ArgExpr argExpr) {
        this.argExpr = argExpr;
    }

    public int getNumArgs() {
        if (argExpr == null)
            return 0;
        else
            return argExpr.getExprs().size();
    }

    public void removeArg() {
        argExpr.removeLastExpr();
    }
}
