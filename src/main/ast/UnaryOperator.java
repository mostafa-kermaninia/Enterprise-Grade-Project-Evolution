package main.ast;

import main.visitor.IVisitor;

public class UnaryOperator extends Node{
    private String OpType;

    public UnaryOperator(String OpType) {
        this.OpType = OpType;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String getOpType() { return OpType; }

}
