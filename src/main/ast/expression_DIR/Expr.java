package main.ast.expression_DIR;

import main.ast.nodes_DIR.Node;

public abstract class Expr extends Node {
    protected int line;

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }
    public <T> T accept(main.visitor.IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
