package main.ast.expression_DIR;

import main.ast.nodes_DIR.Node;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class IdentifierList extends Node {
    private List<Identifier> identifiers;  // A list of Identifier objects

    public IdentifierList(List<Identifier> identifiers) {
        this.identifiers = identifiers;
    }

    public List<Identifier> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(List<Identifier> identifiers) {
        this.identifiers = identifiers;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public List<Node> get_child() {
        List<Node> children = new ArrayList<>();
        for (Identifier identifier : identifiers) {
            children.add(identifier);
        }
        return children;
    }
}
