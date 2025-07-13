package main.ast.expression_DIR;

import main.visitor.IVisitor;

public class Identifier extends Expression {
    private String identifier;
    private boolean func = false;

    public Identifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String getIdentifier() {
        return identifier;
    }

    public boolean isFunc() {
        return func;
    }

    public void setFunc() {
        func = true;
    }
}
