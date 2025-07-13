package main.ast;

import main.visitor.IVisitor;

public class AssignmentOp extends Node{
    private String OpType;

    public AssignmentOp(String OpType) {
        this.OpType = OpType;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String getOpType() { return OpType; }

}
