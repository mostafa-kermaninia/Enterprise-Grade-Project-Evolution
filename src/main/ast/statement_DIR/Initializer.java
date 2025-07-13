package main.ast.statement_DIR;

import main.ast.baseNodes_DIR.Node;
import main.ast.expression_DIR.Expression;
import main.visitor.IVisitor;

public class Initializer extends Node {
    private Expression expression;
    private InitializerList initList;

    public Initializer() {
        expression = null;
        initList = null;
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

    public InitializerList getInitList() {
        return initList;
    }

    public void setInitializerList(InitializerList initList) {
        this.initList = initList;
    }
}
