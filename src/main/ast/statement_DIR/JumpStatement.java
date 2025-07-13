package main.ast.statement_DIR;

import main.ast.expression_DIR.Expression;
import main.visitor.IVisitor;

public class JumpStatement extends Statement {
    private Expression returnExpression;

    public JumpStatement() {
        returnExpression = null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expression getCondition() {
        return returnExpression;
    }

    public void setReturnExpression(Expression returnExpr) {
        this.returnExpression = returnExpr;
    }
}
