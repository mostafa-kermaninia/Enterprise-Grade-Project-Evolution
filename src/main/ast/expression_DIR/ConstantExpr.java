package main.ast.expression_DIR;

public class ConstantExpr extends Expr {
    private String name;

    public ConstantExpr(String name) {
        this.name = name;
    }

    public String getOperator() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
