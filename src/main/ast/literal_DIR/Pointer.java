package main.ast.literal_DIR;

import main.ast.nodes_DIR.Node;
import main.visitor.IVisitor;

public class Pointer extends Node {
    private int levelOfPointer;
    private boolean isConstant;
    private int lineNumber;

    public void setPointerLevel(int levelOfPointer) {
        this.levelOfPointer = levelOfPointer;
    }

    public void setConst(boolean isConstant) {
        this.isConstant = isConstant;
    }

    public void setLine(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int getPointerLevel() {
        return levelOfPointer;
    }

    public boolean isConst() {
        return isConstant;
    }

    public int getLine() {
        return lineNumber;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public void printPointerDetails() {
        System.out.println("Pointer Level: " + levelOfPointer);
        System.out.println("Is Constant: " + isConstant);
    }
}
