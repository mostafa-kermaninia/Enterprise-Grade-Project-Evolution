package main.ast.expression_DIR;

import main.ast.nodes_DIR.Node;

import java.util.ArrayList;
import java.util.List;

public class AssignmentExpr extends Expr {
    private Expr leftHandSide;
    private String operator;
    private Expr rightHandSide;

    public AssignmentExpr(Expr leftHandSide, String operator, Expr rightHandSide) {
        this.leftHandSide = leftHandSide;
        this.operator = operator;
        this.rightHandSide = rightHandSide;
    }

    public Expr getLeftHandSide() {
        return leftHandSide;
    }

    public void setLeftHandSide(Expr leftHandSide) {
        this.leftHandSide = leftHandSide;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Expr getRightHandSide() {
        return rightHandSide;
    }

    public void setRightHandSide(Expr rightHandSide) {
        this.rightHandSide = rightHandSide;
    }

    @Override
    public List<Node> get_child() {
        List<Node> children = new ArrayList<>();
        if (leftHandSide != null) {
            children.add(leftHandSide);
        }
        if (rightHandSide != null) {
            children.add(rightHandSide);
        }
        return children;
    }

}
