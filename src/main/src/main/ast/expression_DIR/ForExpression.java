package main.ast.expression_DIR;

import main.visitor.IVisitor;
import main.ast.baseNodes_DIR.Node;

import java.util.ArrayList;

public class ForExpression extends Node {
    private ArrayList<Expression> expressions;

    public ForExpression(Expression expression) {
        expressions = new ArrayList<Expression>();
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
}
