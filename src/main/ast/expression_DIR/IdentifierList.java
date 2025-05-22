package main.ast.expression_DIR;

import java.util.ArrayList;
import main.ast.baseNodes_DIR.Node;
import main.visitor.IVisitor;

public class IdentifierList extends Node {
    private ArrayList<String> identifiers;

    public IdentifierList(String identifier) {
        identifiers = new ArrayList<>();
        identifiers.add(identifier);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<String> addIdentifier() {
        return identifiers;
    }

    public void addIdentifier(String identifier) {
        this.identifiers.add(identifier);
    }
}
