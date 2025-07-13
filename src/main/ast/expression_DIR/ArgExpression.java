package main.ast.expression_DIR;

import main.ast.baseNodes_DIR.Node;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class ArgExpression extends Node {
    private ArrayList<Expression> expressions;

    public ArgExpression(Expression expression) {
        expressions = new ArrayList<Expression>();
        expressions.add(expression);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<Expression> getExpressions() {
        return expressions;
    }

    public void addExpression(Expression expression) {
        this.expressions.add(expression);
    }

    public void notFirstExpression() {
        for (Expression expression : expressions) {
            expression.notFirst();
        }
    }

    public void removeLastExpression() {
        expressions.remove(expressions.size() - 1);
    }
}
