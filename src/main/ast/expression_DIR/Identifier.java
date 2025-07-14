package main.ast.expression_DIR;

import main.ast.mainNodes_DIR.Expr;
import main.visitor.IVisitor;

public class Identifier extends Expr {
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
