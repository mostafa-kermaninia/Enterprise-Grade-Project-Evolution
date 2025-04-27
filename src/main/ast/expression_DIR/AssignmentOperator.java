package main.ast.expression_DIR;

import main.ast.nodes_DIR.Node;
import main.visitor.IVisitor;

public class AssignmentOperator extends Node {
    private String operatorType;

    public AssignmentOperator (String operatorType) {
        this.operatorType = operatorType;
    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "AssignmentOperator{" +
                "operatorType='" + operatorType + '\'' +
                '}';
    }
}
