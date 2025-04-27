package main.ast.declaration_DIR;

import main.ast.nodes_DIR.Declaration;
import main.ast.nodes_DIR.Node;
import main.ast.literal_DIR.Pointer;

import java.util.ArrayList;
import java.util.List;

public class Declarator extends Declaration {
    private Pointer pointer;
    private DirectDeclarator directDeclarator;

    public Declarator(DirectDeclarator directDeclarator) {
        this.pointer = null;
        this.directDeclarator = directDeclarator;
    }

    public Declarator(Pointer pointer, DirectDeclarator directDeclarator) {
        this.pointer = pointer;
        this.directDeclarator = directDeclarator;
    }

    public Declarator() {
        this.pointer = null;
        this.directDeclarator = null;
    }

    public Declarator(Pointer pointer) {
        this.pointer = pointer;
    }

    public Pointer getPointer() {
        return pointer;
    }

    public void setPointer(Pointer pointer) {
        this.pointer = pointer;
    }

    public DirectDeclarator getDirectDeclarator() {
        return directDeclarator;
    }

    public void setDirectDeclarator(DirectDeclarator directDeclarator) {
        this.directDeclarator = directDeclarator;
    }

    @Override
    public List<Node> get_child() {
        List<Node> children = new ArrayList<>();
        if (pointer != null)
            children.add(pointer);
        if (directDeclarator != null)
            children.add(directDeclarator);
        return children;
    }
}
