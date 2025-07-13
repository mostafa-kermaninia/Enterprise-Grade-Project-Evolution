package main.ast.literal_DIR;

import main.ast.baseNodes_DIR.Node;
import main.ast.expression_DIR.Expression;
import main.visitor.IVisitor;

public class Designator extends Node {
    private Expression expression;

    public Designator() {
        expression = null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
}
