package main.ast.expression_DIR;

import java.util.ArrayList;
import main.visitor.IVisitor;

public class CommaExpression extends Expression {
    private ArrayList<Expression> expressions;

    public CommaExpression(Expression expression) {
        expressions = new ArrayList<>();
        expressions.add(expression);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<Expression> getExpressions() {
        return expressions;
    }

    @Override
    public void addExpression(Expression expression) {
        expressions.add(expression);
    }
}
