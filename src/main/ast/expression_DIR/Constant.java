package main.ast.expression_DIR;

import main.ast.mainNodes_DIR.Expr;
import main.visitor.IVisitor;

public class Constant extends Expr {
    private String constant;
    private boolean isString = false;

    public Constant(String constant, boolean isString) {
        this.constant = constant;
        this.isString = isString;
        // System.out.println(constant);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String getConstant() {
        return constant;
    }

    public boolean isString() {
        return isString;
    }

    public void setString() {
        this.isString = true;
    }
}
