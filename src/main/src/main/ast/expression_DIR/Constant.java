package main.ast.expression_DIR;

import main.visitor.IVisitor;

public class Constant extends Expression {
    private String constant;

    public Constant(String constant) {
        this.constant = constant;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String getConstant() {
        return constant;
    }
}
