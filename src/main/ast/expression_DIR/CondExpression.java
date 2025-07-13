package main.ast.expression_DIR;

import main.visitor.IVisitor;

public class CondExpression extends Expression {
    private Expression expression1;
    private Expression expression2;
    private Expression expression3;

    public CondExpression(Expression expression1, Expression expression2, Expression expression3) {
        this.expression1 = expression1;
        this.expression2 = expression2;
        this.expression3 = expression3;
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

    public Expression getExpression3() {
        return expression3;
    }
}
