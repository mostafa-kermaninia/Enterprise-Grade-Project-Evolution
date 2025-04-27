package main.ast.nodes_DIR;

import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class ExternalDeclaration extends Node {
    private Node declaration;

    public ExternalDeclaration(Node declaration) {
        this.declaration = declaration;
    }

    public ExternalDeclaration() {
    }

    public Node getDeclaration() {
        return declaration;
    }

    public void setDeclaration(Node declaration) {
        this.declaration = declaration;
    }

    @Override
    public List<Node> get_child() {
        List<Node> children = new ArrayList<>();
        if (declaration != null) {
            children.add(declaration);
        }
        return children;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
