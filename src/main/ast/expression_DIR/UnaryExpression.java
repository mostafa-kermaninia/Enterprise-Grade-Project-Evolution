package main.ast.expression_DIR;

import main.visitor.IVisitor;

public class UnaryExpression extends Expression {
    private Expression expression;
    private String Op;

    public UnaryExpression(Expression expression, String Op) {
        this.expression = expression;
        this.Op = Op;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expression getExpression() {
        return expression;
    }

    public String getOp() {
        return Op;
    }

}
