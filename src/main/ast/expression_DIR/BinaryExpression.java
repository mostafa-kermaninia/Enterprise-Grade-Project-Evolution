package main.ast.expression_DIR;

import main.ast.literal_DIR.AssignmentOp;
import main.visitor.IVisitor;

public class BinaryExpression extends Expression {
    private Expression expression1;
    private Expression expression2;
    private String operator;
    private AssignmentOp assignmentOp;

    public BinaryExpression(Expression expression1, Expression expression2, String operator) {
        this.expression1 = expression1;
        this.expression2 = expression2;
        this.operator = operator;
    }

    public BinaryExpression(Expression expression1, Expression expression2, AssignmentOp assignmentOp) {
        this.expression1 = expression1;
        this.expression2 = expression2;
        this.assignmentOp = assignmentOp;
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

    public String getOperator() {
        return operator;
    }

    public AssignmentOp getAssignmentOp() {
        return assignmentOp;
    }
}
