package main.ast.declaration_DIR;

import main.ast.nodes_DIR.Node;
import main.ast.literal_DIR.Pointer;

public class AbstractDeclarator extends Node {
    private Pointer pointer;
    private DirectAbstractDeclarator directAbstractDeclarator;

    public AbstractDeclarator() {
    }

    public Pointer getPointer() {
        return pointer;
    }

    public void setPointer(Pointer pointer) {
        this.pointer = pointer;
    }

    public DirectAbstractDeclarator getDirectAbstractDeclarator() {
        return directAbstractDeclarator;
    }

    public void setDirectAbstractDeclarator(DirectAbstractDeclarator directAbstractDeclarator) {
        this.directAbstractDeclarator = directAbstractDeclarator;
    }



    @Override
    public <T> T accept(main.visitor.IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
