package main.ast.expression_DIR;

import main.visitor.IVisitor;

public class UnaryExpression extends Expression {
    private Expression expression;
    private String Operation;

    public UnaryExpression(Expression expression, String Operation) {
        this.expression = expression;
        this.Operation = Operation;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expression getExpression() {
        return expression;
    }

    public String getOperation() {
        return Operation;
    }

}
