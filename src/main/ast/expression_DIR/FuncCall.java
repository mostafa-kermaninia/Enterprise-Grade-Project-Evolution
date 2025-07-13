package main.ast.expression_DIR;

import main.visitor.IVisitor;

public class FuncCall extends Expression {
    private Expression expression;
    private ArgExpression argExpression;

    public FuncCall(Expression expression) {
        this.expression = expression;
        argExpression = null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expression getExpression() {
        return expression;
    }

    public ArgExpression getArgExpression() {
        return argExpression;
    }

    @Override
    public void setArgExpression(ArgExpression argExpression) {
        this.argExpression = argExpression;
    }

    public int getNumArgs() {
        if (argExpression == null)
            return 0;
        else
            return argExpression.getExpressions().size();
    }

    public void removeArg() {
        argExpression.removeLastExpression();
    }
}
