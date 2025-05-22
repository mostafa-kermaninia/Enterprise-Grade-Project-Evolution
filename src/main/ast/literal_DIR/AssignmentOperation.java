package main.ast.literal_DIR;

import main.ast.baseNodes_DIR.Node;
import main.visitor.IVisitor;

public class AssignmentOperation extends Node {
    private String OperationType;

    public AssignmentOperation(String OperationType) {
        this.OperationType = OperationType;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String getOperationType() {
        return OperationType;
    }

}
