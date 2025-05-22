package main.ast.declaration_DIR;

import main.ast.baseNodes_DIR.Node;
import main.ast.literal_DIR.Pointer;
import main.visitor.IVisitor;

public class AbstractDec extends Node {
    private Pointer pointer;
    private DirectAbsDec directAbsDec;

    public AbstractDec() {
        directAbsDec = null;
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

    public DirectAbsDec getDirectAbsDec() {
        return directAbsDec;
    }

    public void setDirectAbsDec(DirectAbsDec directAbsDec) {
        this.directAbsDec = directAbsDec;
    }
}
