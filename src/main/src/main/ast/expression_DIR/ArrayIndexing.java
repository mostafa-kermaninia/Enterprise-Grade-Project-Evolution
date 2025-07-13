package main.ast.expression_DIR;

import main.visitor.IVisitor;

public class ArrayIndexing extends Expression {
    private Expression expression1;
    private Expression expression2;

    public ArrayIndexing(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expression getExpression1() {
        return expression1;
    }

    public Expression getExpression2() {
        return expression2;
    }
}
