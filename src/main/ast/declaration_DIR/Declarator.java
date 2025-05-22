package main.ast.declaration_DIR;

import main.ast.baseNodes_DIR.Node;
import main.ast.literal_DIR.Pointer;
import main.visitor.IVisitor;

public class Declarator extends Node {
    private Pointer pointer;
    private DirectDec directDec;

    public Declarator() {
        pointer = null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Pointer getPointer() {
        return pointer;
    }

    public void setPointer(Pointer pointer) {
        this.pointer = pointer;
    }

    public DirectDec getDirectDec() {
        return directDec;
    }

    public void setDirectDec(DirectDec directDec) {
        this.directDec = directDec;
    }
}
