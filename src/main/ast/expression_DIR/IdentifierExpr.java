package main.ast.expression_DIR;

public class
IdentifierExpr extends Expr {
    private String name;

    public IdentifierExpr(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
