package main.ast.expression_DIR;

import java.util.List;

public class StringLiteralExpr extends Expr {
    private List<String> stringValues;

    public StringLiteralExpr(List<String> stringValues) {
        this.stringValues = stringValues;
    }

    public List<String> getStringValues() {
        return stringValues;
    }

    public void setStringValues(List<String> stringValues) {
        this.stringValues = stringValues;
    }
}
