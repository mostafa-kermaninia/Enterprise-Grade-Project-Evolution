package main.ast.expression_DIR;

import main.ast.baseNodes_DIR.Node;

public abstract class Expression extends Node {
    private boolean isFirst = true;

    public void addExpression(Expression expression) {
    }

    public void setArgExpression(ArgExpression argExpression) {
    }

    public void notFirst() {
        isFirst = false;
    }

    public boolean getFirst() {
        return isFirst;
    }
}
