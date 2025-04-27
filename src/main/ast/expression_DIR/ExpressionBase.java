package main.ast.expression_DIR;

import java.util.List;

public class ExpressionBase extends Expr {
    private String identifier;
    private Object constant;
    private List<String> stringLiterals;

    public ExpressionBase(String identifier) {
        this.identifier = identifier;
    }

    public ExpressionBase(Object constant) {
        this.constant = constant;
    }

    public ExpressionBase(List<String> stringLiterals) {
        this.stringLiterals = stringLiterals;
    }

    public String getIdentifier() {
        return identifier;
    }

    public Object getConstant() {
        return constant;
    }

    public List<String> getStringLiterals() {
        return stringLiterals;
    }
}
