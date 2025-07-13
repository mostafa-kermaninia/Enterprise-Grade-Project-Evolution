package main.ast.literal_DIR;

import main.ast.baseNodes_DIR.Node;
import main.ast.declaration_DIR.ForDec;
import main.ast.expression_DIR.Expression;
import main.ast.expression_DIR.ForExpression;
import main.visitor.IVisitor;

public class ForCondition extends Node {
    private Expression expression;
    private ForExpression forExpression1;
    private ForExpression forExpression2;
    private ForDec forDec;

    public ForCondition() {
        expression = null;
        forExpression1 = null;
        forExpression2 = null;
        forDec = null;
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

    public ForExpression getForExpression1() {
        return forExpression1;
    }

    public void setForExpression1(ForExpression forExpression1) {
        this.forExpression1 = forExpression1;
    }

    public ForExpression getForExpression2() {
        return forExpression2;
    }

    public void setForExpression2(ForExpression forExpression2) {
        this.forExpression2 = forExpression2;
    }

    public ForDec getForDec() {
        return forDec;
    }

    public void setForDec(ForDec forDec) {
        this.forDec = forDec;
    }
}
