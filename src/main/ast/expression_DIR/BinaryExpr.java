package main.ast.expression_DIR;

import main.ast.literal_DIR.AssignmentOp;
import main.ast.mainNodes_DIR.Expr;
import main.visitor.IVisitor;

public class BinaryExpr extends Expr {
    private Expr expr1;
    private Expr expr2;
    private String operator;
    private AssignmentOp assignmentOp;

    public BinaryExpr(Expr expr1, Expr expr2, String operator) {
        this.expr1 = expr1;
        this.expr2 = expr2;
        this.operator = operator;
    }

    public BinaryExpr(Expr expr1, Expr expr2, AssignmentOp assignmentOp) {
        this.expr1 = expr1;
        this.expr2 = expr2;
        this.assignmentOp = assignmentOp;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expr getExpr1() {
        return expr1;
    }

    public Expr getExpr2() {
        return expr2;
    }

    public String getOperator() {
        return operator;
    }

    public AssignmentOp getAssignmentOp() {
        return assignmentOp;
    }
}
